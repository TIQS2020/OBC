package br.com.whitemartins.obc.xml;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import br.com.whitemartins.obc.util.PathHelper;

@Root(name = "obcConsultaCecResponse")
public class XmlConsultaCecRetorno extends XmlBase {

  @Element(name = "codigoFilial", required = false)
  private String cdFilial;
  @Element(name = "dataViagem", required = false)
  private String dataViagem;
  @Element(name = "numeroViagem", required = false)
  private String numeroViagem;
  @Element(name = "numeroNota", required = false)
  private Long numeroNota;
  @Element(name = "serieNota", required = false)
  private Long serieNota;
  @Element(name = "statusRetorno", required = false)
  private String statusRetorno;
  @Element(name = "mensagemStatus", required = false)
  private String mensagemStatus;
  @Element(name = "tipo", required = false)
  private String tipoDocumento;


  public static XmlConsultaCecRetorno newInstance() {
    return new XmlConsultaCecRetorno();
  }

  public String getCdFilial() {
    return cdFilial;
  }

  public void setCdFilial(String cdFilial) {
    this.cdFilial = cdFilial;
  }

  public String getDataViagem() {
    return dataViagem;
  }

  public void setDataViagem(String dataViagem) {
    this.dataViagem = dataViagem;
  }

  public String getNumeroViagem() {
    return numeroViagem;
  }

  public void setNumeroViagem(String numeroViagem) {
    this.numeroViagem = numeroViagem;
  }

  public Long getNumeroNota() {
    return numeroNota;
  }

  public void setNumeroNota(Long numeroNota) {
    this.numeroNota = numeroNota;
  }

  public Long getSerieNota() {
    return serieNota;
  }

  public void setSerieNota(Long serieNota) {
    this.serieNota = serieNota;
  }

  public String getStatusRetorno() {
    return statusRetorno;
  }

  public void setStatusRetorno(String statusRetorno) {
    this.statusRetorno = statusRetorno;
  }

  public String getMensagemStatus() {
    return mensagemStatus;
  }

  public void setMensagemStatus(String mensagemStatus) {
    this.mensagemStatus = mensagemStatus;
  }

  public String getTipoDocumento() {
    return tipoDocumento;
  }

  public void setTipoDocumento(String tipoDocumento) {
    this.tipoDocumento = tipoDocumento;
  }

  @Override
  public void saveFile(String input) throws IOException {
    FileOutputStream outputStream = null;
    File outputFile;
    try {
      File dir = new File(PathHelper.self().getFilePathDownload());
      outputFile = new File(dir, getClass().getSimpleName() + "_" + numeroNota + "_" + serieNota + ".xml");
      outputStream = new FileOutputStream(outputFile);
      outputStream.write(input.getBytes());

    } finally {
      if (outputStream != null) {
        outputStream.flush();
        outputStream.close();
      }
    }

  }
}
