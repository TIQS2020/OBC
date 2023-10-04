package br.com.whitemartins.obc.xml;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import br.com.whitemartins.obc.util.PathHelper;

@Root(name = "obcGravaCec")
public class XmlEnviaCec extends XmlBase {

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
  @Element(name = "dataEmissao", required = false)
  private String dataEmissao;
  @Element(name = "status", required = false)
  private Integer status;
  @Element(name = "tipo_documento", required = false)
  private String tipoDocumento;
  @Element(name = "nome", required = false)
  private String nome;
  @Element(name = "documento", required = false)
  private String documento;
  @Element(name = "cec", required = false)
  private String cec;
  @Element(name = "assinatura", required = false)
  private String assinatura;

  public static XmlEnviaCec newInstance() {
    return new XmlEnviaCec();
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

  public String getDataEmissao() {
    return dataEmissao;
  }

  public void setDataEmissao(String dataEmissao) {
    this.dataEmissao = dataEmissao;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getTipoDocumento() {
    return tipoDocumento;
  }

  public void setTipoDocumento(String tipoDocumento) {
    this.tipoDocumento = tipoDocumento;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDocumento() {
    return documento;
  }

  public void setDocumento(String documento) {
    this.documento = documento;
  }

  public String getCec() {
    return cec;
  }

  public void setCec(String cec) {
    this.cec = cec;
  }

  public String getAssinatura() {
    return assinatura;
  }

  public void setAssinatura(String assinatura) {
    this.assinatura = assinatura;
  }


  public String getName() {
    return getClass().getSimpleName() + "_" + numeroNota + "_" + serieNota;
  }

  @Override
  public void saveFile() throws IOException {
    FileOutputStream outputStream = null;
    File outputFile;
    try {
      File dir = new File(PathHelper.self().getFilePathDownload());
      outputFile = new File(dir, getClass().getSimpleName() + "_" + numeroNota + "_" + serieNota + ".xml");
      outputStream = new FileOutputStream(outputFile);
      outputStream.write(serialize().getBytes());

    } finally {
      if (outputStream != null) {
        outputStream.flush();
        outputStream.close();
      }
    }
  }
}
