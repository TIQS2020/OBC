package br.com.whitemartins.obc.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

import br.com.whitemartins.obc.dao.CodeDao;
import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.interafce.FileInfo;
import br.com.whitemartins.obc.util.UtilHelper;
import br.com.whitemartins.obc.views.DatabaseApp;

@Entity
@FileInfo(lineLength = 24)
public class Code extends MockRecord implements Serializable {
  private static final long serialVersionUID = 1L;

  @PrimaryKey(autoGenerate = true)
  private Long id;
  private String tipoCodigo;
  private Integer codigo;
  private String descricao;
  private String indRastreabilidade;
  private Integer cfop3;
  private String sufixo;
  private Integer cfop4;
  private Integer situacaoTributariaPis;
  private String cstPis;
  private Integer situacaoTributariaCofins;
  private String cstCofins;
  private String cstIpiZero;
  private String cstIpiTributado;
  private String cstIpiIsento;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTipoCodigo() {
    return tipoCodigo;
  }

  public void setTipoCodigo(String tipoCodigo) {
    this.tipoCodigo = tipoCodigo;
  }

  public Integer getCodigo() {
    return codigo;
  }

  public void setCodigo(Integer codigo) {
    this.codigo = codigo;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getIndRastreabilidade() {
    return indRastreabilidade;
  }

  public void setIndRastreabilidade(String indRastreabilidade) {
    this.indRastreabilidade = indRastreabilidade;
  }

  public Integer getCfop3() {
    return cfop3;
  }

  public void setCfop3(Integer cfop3) {
    this.cfop3 = cfop3;
  }

  public String getSufixo() {
    return sufixo;
  }

  public void setSufixo(String sufixo) {
    this.sufixo = sufixo;
  }

  public Integer getCfop4() {
    return cfop4;
  }

  public void setCfop4(Integer cfop4) {
    this.cfop4 = cfop4;
  }

  public Integer getSituacaoTributariaPis() {
    return situacaoTributariaPis;
  }

  public void setSituacaoTributariaPis(Integer situacaoTributariaPis) {
    this.situacaoTributariaPis = situacaoTributariaPis;
  }

  public String getCstPis() {
    return cstPis;
  }

  public void setCstPis(String cstPis) {
    this.cstPis = cstPis;
  }

  public Integer getSituacaoTributariaCofins() {
    return situacaoTributariaCofins;
  }

  public void setSituacaoTributariaCofins(Integer situacaoTributariaCofins) {
    this.situacaoTributariaCofins = situacaoTributariaCofins;
  }

  public String getCstCofins() {
    return cstCofins;
  }

  public void setCstCofins(String cstCofins) {
    this.cstCofins = cstCofins;
  }

  public String getCstIpiZero() {
    return cstIpiZero;
  }

  public void setCstIpiZero(String cstIpiZero) {
    this.cstIpiZero = cstIpiZero;
  }

  public String getCstIpiTributado() {
    return cstIpiTributado;
  }

  public void setCstIpiTributado(String cstIpiTributado) {
    this.cstIpiTributado = cstIpiTributado;
  }

  public String getCstIpiIsento() {
    return cstIpiIsento;
  }

  public void setCstIpiIsento(String cstIpiIsento) {
    this.cstIpiIsento = cstIpiIsento;
  }

  @Override
  public void parseLine(String line) {
    String type = line.substring(0, 1).trim();
    String code = line.substring(1, 3).trim();
    String desc = line.substring(3, 23);
    String rast = line.substring(23, 24).trim();

    this.codigo = UtilHelper.convertToIntegerDef(code, 0);
    this.tipoCodigo = type;

    if (ConstantsEnum.YES.getValue().equalsIgnoreCase(type))
      desc = desc.trim();

    this.descricao = desc;
    this.indRastreabilidade = rast;

    if ("I".equalsIgnoreCase(type)) {
      this.cfop3 = UtilHelper.convertToIntegerDef(desc.substring(0, 3), 0);
      this.sufixo = desc.substring(3, 5);
      this.cfop4 = UtilHelper.convertToIntegerDef(desc.substring(5, 9), 0);
      this.situacaoTributariaPis = UtilHelper.convertToIntegerDef(desc.substring(9, 10), 0);
      this.cstPis = desc.substring(10, 12);
      this.situacaoTributariaCofins = UtilHelper.convertToIntegerDef(desc.substring(12, 13), 0);
      this.cstCofins = desc.substring(13, 15);
    }

    if ("P".equalsIgnoreCase(type)) {
      this.cfop3 = UtilHelper.convertToIntegerDef(desc.substring(0, 3), 0);
      this.sufixo = desc.substring(3, 5);
      this.cfop4 = UtilHelper.convertToIntegerDef(desc.substring(5, 9), 0);
      this.cstIpiZero = desc.substring(9, 11);
      this.cstIpiTributado = desc.substring(11, 13);
      this.cstIpiIsento = desc.substring(13, 15);
    }
  }

  public boolean isValid() {
    return true;
  }

  @Override
  public void save() {
    CodeDao dao = DatabaseApp.self().getDatabase().codeDao();
    dao.insert(this);
  }

  @Override
  public void deleteAll() {
    CodeDao dao = DatabaseApp.self().getDatabase().codeDao();
    dao.deleteAll(dao.getAll());
  }


}
