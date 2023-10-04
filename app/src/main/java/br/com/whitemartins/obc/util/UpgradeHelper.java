package br.com.whitemartins.obc.util;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.List;

import br.com.whitemartins.obc.BuildConfig;
import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.interafce.MyCallbackInterface;
import br.com.whitemartins.obc.receiver.DevAdminReceiver;
import br.com.whitemartins.obc.service.UpgradeService;
import br.com.whitemartins.obc.xml.XmlAtualizacao;

/**
 * Created by Rodolfo on 12/12/2017.
 */
//getFile


public class UpgradeHelper {
  public static UpgradeHelper _self;

  private WeakReference<Activity> activity;
  private MyCallbackInterface.CallbackBooleanInterface postExecuteCallback;

  private MyCallbackInterface.CallbackBooleanInterface processUpdate = new MyCallbackInterface.CallbackBooleanInterface() {
    @Override
    public void execute(Boolean success) {

      if (success) {
        performCopy();
        performInstall();
      } else
        DialogHelper.showErrorMessage(activity.get(), R.string.erro_text,
          R.string.update_error_message, null);
    }
  };

  private MyCallbackInterface.CallbackBooleanInterface readUpdagradeFile = new MyCallbackInterface.CallbackBooleanInterface() {
    @Override
    public void execute(Boolean success) {
      if (success) {
        try {
          XmlAtualizacao xml = XmlAtualizacao.self(activity.get()).read();
          List<String> files = xml.getObjeto();
          boolean isPilotProject = ConstantsEnum.YES.getValue().equalsIgnoreCase(
            XmlAtualizacao.self(activity.get()).getPiloto());

          String _versaoUpgrade = "", path;
          String filial = GLOBAL.self().getStaticTable().getCdFilial();

          String veiculoFilial = filial.substring(3, 6) +
            UtilHelper.padLeft(GLOBAL.self().getStaticTable().getCdVeiculo(), '0', 4);

          if (isPilotProject && ((xml.getVeiculo().contains(veiculoFilial))
            || (xml.getFilial().contains(filial)))) {
            _versaoUpgrade = xml.getVersaoPiloto();
            path = xml.getPathVersaoPiloto();
          } else {
            _versaoUpgrade = xml.getVersaoProd();
            path = xml.getPathVersaoProd();
          }

          boolean _needUpgrade = (!_versaoUpgrade.equalsIgnoreCase(
            GLOBAL.self().getVersao().replace(".", "")));

          if (_needUpgrade) {
            DialogHelper.showInformationMessage(activity.get(), R.string.informar_text,
              R.string.update_message, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                  downloadFiles(path, files);
//                  performCopy();
//                  performInstall();
                }
              });


          } else
            postExecuteCallback.execute(true);

        } catch (Exception e) {
          DialogHelper.showInformationMessage(activity.get(), R.string.erro_text,
            R.string.update_error_message, null
          );
        }
      } else
        DialogHelper.showInformationMessage(activity.get(), R.string.erro_text,
          R.string.update_error_message, null
        );
    }
  };

  private UpgradeHelper(Activity a) {
    activity = new WeakReference<>(a);
  }

  public static UpgradeHelper self(Activity a) {
    //if (_self == null)
    _self = new UpgradeHelper(a);
    return _self;
  }

  public static void copy(InputStream in, OutputStream out) throws IOException {

    byte[] buffer = new byte[1024];
    while (true) {
      int bytesRead = in.read(buffer);
      if (bytesRead == -1)
        break;
      out.write(buffer, 0, bytesRead);
    }
  }

  public UpgradeHelper setPostExecuteCallback(MyCallbackInterface.CallbackBooleanInterface postExecuteCallback) {
    this.postExecuteCallback = postExecuteCallback;
    return _self;
  }

  public void performInstall() {

    File toInstall = new File(PathHelper.self().getFilePathDownload() +
      Constants.OBC_NET_FILE);

    try {

      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Uri apkUri = FileProvider.getUriForFile(activity.get(),
          BuildConfig.APPLICATION_ID + ".fileprovider", toInstall);

        Intent intent = new Intent(Intent.ACTION_INSTALL_PACKAGE);// ACTION_INSTALL_PACKAGE);
        intent.setData(apkUri);
        intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        activity.get().startActivity(intent);

      } else {
        Uri apkUri = Uri.fromFile(toInstall);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(apkUri, "application/vnd.android.package-archive");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.get().startActivity(intent);
      }
    } catch (Exception e) {
      e.printStackTrace();
      LogHelper.self().error("performInstall", e);
    }
  }

  private void performCopy() {
    String sourcePath = PathHelper.self().getFilePathDownload() + Constants.OBC_NET_CONFIG;
    File source = new File(sourcePath);

    String destinationPath = PathHelper.self().getFilePathConfig() + Constants.OBC_NET_CONFIG;
    File destination = new File(destinationPath);
    try {
      UtilHelper.copyFile(source, destination);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void downloadUpdagradeFile() {
    new UpgradeService()
      .setVersion("")
      .setPostExecuteCallback(readUpdagradeFile)
      .setActivity(activity.get())
      .execute();
  }

  private void downloadFiles(String versaoUpgrade, List<String> files) {
    new UpgradeService()
      .setFiles(files)
      .setVersion(versaoUpgrade)
      .setPostExecuteCallback(processUpdate)
      .setActivity(activity.get())
      .execute();
  }
}
