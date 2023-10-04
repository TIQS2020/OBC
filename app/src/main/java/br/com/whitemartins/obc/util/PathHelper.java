package br.com.whitemartins.obc.util;

import android.os.Environment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PathHelper {
  private static PathHelper _self;
  List<String> paths = new ArrayList<>();
  private String filePathDownload;
  private String filePathConfig;
  private String filePathLog;
  private String filePathInvoice;
  private String filePathFiles;


  private PathHelper() {
    filePathDownload = Environment.getExternalStorageDirectory().getAbsoluteFile() + "/OBC/download";
    filePathConfig = Environment.getExternalStorageDirectory().getAbsoluteFile() + "/OBC/xml";
    filePathLog = Environment.getExternalStorageDirectory().getAbsoluteFile() + "/OBC/log";
    filePathInvoice = Environment.getExternalStorageDirectory().getAbsoluteFile() + "/OBC/invoice";
    filePathFiles = Environment.getExternalStorageDirectory().getAbsolutePath() + "/OBC/files";

    paths.add(filePathDownload);
    paths.add(filePathLog);
    paths.add(filePathInvoice);
    paths.add(filePathFiles);
  }

  public static PathHelper self() {
    if (_self == null)
      _self = new PathHelper();

    _self.createPaths();
    return _self;
  }

  public void clearPaths() {

    for (String path : paths) {
      File dir = new File(path);
      File[] files = dir.listFiles();
      if (files != null)
        for (File file : files)
          file.delete();
    }
  }

  public void clearPath(String path) {

    File dir = new File(path);
    File[] files = dir.listFiles();
    if (files != null)
      for (File file : files)
        file.delete();
  }

  private void createPaths() {

    for (String path : paths) {
      File file = new File(path);
      if (!file.exists())
        file.mkdirs();
    }

    File file = new File(filePathConfig);
    if (!file.exists())
      file.mkdirs();
  }

  public String getFilePathConfig() {

    return filePathConfig + File.separator;
  }

  public String getFilePathLog() {
    return filePathLog + File.separator;
  }

  public String getFilePathDownload() {
    return filePathDownload + File.separator;
  }

  public String getFilePathInvoice() {
    return filePathInvoice + File.separator;
  }

  public String getFilePathFiles() {
    return filePathFiles + File.separator;
  }

  public void saveFile(String text, String fileName) {
    try {
      File dir = new File(PathHelper.self().getFilePathDownload());
      File file = new File(dir, fileName);

      BufferedWriter buf = new BufferedWriter(new FileWriter(file, false));
      buf.append(text);
      buf.newLine();
      buf.close();
    } catch (IOException e) {
      LogHelper.self().error("PathHelper", e);
      e.printStackTrace();
    }
  }


}
