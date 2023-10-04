package br.com.whitemartins.obc.model.sync;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

@Root(name = "pagamento_cartao")
public class PagamentoCartao {

  @ElementList(name = "cartao", required = false, inline = true)
  private List<Cartao> dadosCartao;

  public PagamentoCartao() {
    dadosCartao = new ArrayList<>();
  }

  public List<Cartao> getDadosCartao() {
    return dadosCartao;
  }

  public void setDadosCartao(List<Cartao> dadosCartao) {
    this.dadosCartao = dadosCartao;
  }
}
