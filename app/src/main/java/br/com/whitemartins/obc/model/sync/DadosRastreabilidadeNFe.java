package br.com.whitemartins.obc.model.sync;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "rastreabilidade")
public class DadosRastreabilidadeNFe {
  @Element(name = "cd_cilindro", required = false)
  private String codigoCilindro;

  @Element(name = "num_lote", required = false)
  private String numeroLote;

  public String getCodigoCilindro() {
    return codigoCilindro;
  }

  public void setCodigoCilindro(String codigoCilindro) {
    this.codigoCilindro = codigoCilindro;
  }

  public String getNumeroLote() {
    return numeroLote;
  }

  public void setNumeroLote(String numeroLote) {
    this.numeroLote = numeroLote;
  }

}
