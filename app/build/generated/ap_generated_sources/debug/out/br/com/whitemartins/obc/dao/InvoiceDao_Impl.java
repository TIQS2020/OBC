package br.com.whitemartins.obc.dao;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.util.StringUtil;
import android.database.Cursor;
import br.com.whitemartins.obc.database.DateTypeConverter;
import br.com.whitemartins.obc.model.Invoice;
import java.lang.Double;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("unchecked")
public class InvoiceDao_Impl implements InvoiceDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfInvoice;

  private final EntityInsertionAdapter __insertionAdapterOfInvoice_1;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfInvoice;

  public InvoiceDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfInvoice = new EntityInsertionAdapter<Invoice>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Invoice`(`id`,`numero`,`serie`,`numeroNotaVOR`,`serieNotaVOR`,`cdPreOrdem`,`numeroFutEntrega`,`cdFiscal`,`cnpjCpfDestino`,`cnpjCpfTransp`,`tipoNota`,`classeContribuinte`,`dataViagemPrincial`,`numeroViagem`,`dataViagem`,`nomeOperacao`,`dataEmissao`,`dataMovimento`,`dataVencimento`,`valorTotal`,`valorLiquido`,`valorTotalProduto`,`valorFrete`,`valorDespAcessorias`,`valorDinheiro`,`valorTroco`,`valorFatura`,`valorDebito`,`valorCredito`,`valorCheque`,`numeroCheque`,`ufVeiculo`,`placaVeiculo`,`numeroVeiculo`,`modalidadeFrete`,`nomeEspecVolume`,`nomeMarca`,`qtdVolumes`,`volumeCapacidade`,`volumeCapacidadeReport`,`pesoBruto`,`pesoLiquido`,`tipoPedido`,`cdCustomer`,`ativaTipoPagto`,`stepEmissao`,`chave`,`protocolo`,`cdMovimento`,`condicaoPagamento`,`aliquotaIcms`,`valorDescontoIcms`,`valorIcms`,`baseCalculoIcms`,`situacaoTributariaIcms`,`valorIpi`,`baseCalculoIpi`,`situacaoTributariaIpi`,`flNovoFaturamento`,`cdOperadora`,`flPaciente`,`cdCustomerService`,`nomeAssinadorCec`,`rgAssinadorCec`,`tipoMovimentoIntegracao`,`semPagto`,`statusGravacaoJde`,`mensagemGravacaoJde`,`tipoTransacao`,`status`,`statusContingencia`,`mensagemContingencia`,`statusCec`,`nomeTransacao`,`statusImpressaoCec`,`nomeFormaImpressaoCec`,`nomeStatus`,`nomeStatusImpressaoCec`,`flPrecoAlterado`,`nomeTipoPagamento`,`cdMotivo`,`dsMotivo`,`statusNfeImp`,`statusReportFile`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Invoice value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getNumero() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getNumero());
        }
        if (value.getSerie() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getSerie());
        }
        if (value.getNumeroNotaVOR() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getNumeroNotaVOR());
        }
        if (value.getSerieNotaVOR() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getSerieNotaVOR());
        }
        if (value.getCdPreOrdem() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getCdPreOrdem());
        }
        if (value.getNumeroFutEntrega() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getNumeroFutEntrega());
        }
        if (value.getCdFiscal() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.getCdFiscal());
        }
        if (value.getCnpjCpfDestino() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getCnpjCpfDestino());
        }
        if (value.getCnpjCpfTransp() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getCnpjCpfTransp());
        }
        if (value.getTipoNota() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getTipoNota());
        }
        if (value.getClasseContribuinte() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindLong(12, value.getClasseContribuinte());
        }
        if (value.getDataViagemPrincial() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getDataViagemPrincial());
        }
        if (value.getNumeroViagem() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getNumeroViagem());
        }
        if (value.getDataViagem() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getDataViagem());
        }
        if (value.getNomeOperacao() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getNomeOperacao());
        }
        final Long _tmp;
        _tmp = DateTypeConverter.dateToTimestamp(value.getDataEmissao());
        if (_tmp == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindLong(17, _tmp);
        }
        final Long _tmp_1;
        _tmp_1 = DateTypeConverter.dateToTimestamp(value.getDataMovimento());
        if (_tmp_1 == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindLong(18, _tmp_1);
        }
        final Long _tmp_2;
        _tmp_2 = DateTypeConverter.dateToTimestamp(value.getDataVencimento());
        if (_tmp_2 == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindLong(19, _tmp_2);
        }
        if (value.getValorTotal() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindDouble(20, value.getValorTotal());
        }
        if (value.getValorLiquido() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindDouble(21, value.getValorLiquido());
        }
        if (value.getValorTotalProduto() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindDouble(22, value.getValorTotalProduto());
        }
        if (value.getValorFrete() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindDouble(23, value.getValorFrete());
        }
        if (value.getValorDespAcessorias() == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindDouble(24, value.getValorDespAcessorias());
        }
        if (value.getValorDinheiro() == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindDouble(25, value.getValorDinheiro());
        }
        if (value.getValorTroco() == null) {
          stmt.bindNull(26);
        } else {
          stmt.bindDouble(26, value.getValorTroco());
        }
        if (value.getValorFatura() == null) {
          stmt.bindNull(27);
        } else {
          stmt.bindDouble(27, value.getValorFatura());
        }
        if (value.getValorDebito() == null) {
          stmt.bindNull(28);
        } else {
          stmt.bindDouble(28, value.getValorDebito());
        }
        if (value.getValorCredito() == null) {
          stmt.bindNull(29);
        } else {
          stmt.bindDouble(29, value.getValorCredito());
        }
        if (value.getValorCheque() == null) {
          stmt.bindNull(30);
        } else {
          stmt.bindDouble(30, value.getValorCheque());
        }
        if (value.getNumeroCheque() == null) {
          stmt.bindNull(31);
        } else {
          stmt.bindString(31, value.getNumeroCheque());
        }
        if (value.getUfVeiculo() == null) {
          stmt.bindNull(32);
        } else {
          stmt.bindString(32, value.getUfVeiculo());
        }
        if (value.getPlacaVeiculo() == null) {
          stmt.bindNull(33);
        } else {
          stmt.bindString(33, value.getPlacaVeiculo());
        }
        if (value.getNumeroVeiculo() == null) {
          stmt.bindNull(34);
        } else {
          stmt.bindString(34, value.getNumeroVeiculo());
        }
        if (value.getModalidadeFrete() == null) {
          stmt.bindNull(35);
        } else {
          stmt.bindLong(35, value.getModalidadeFrete());
        }
        if (value.getNomeEspecVolume() == null) {
          stmt.bindNull(36);
        } else {
          stmt.bindString(36, value.getNomeEspecVolume());
        }
        if (value.getNomeMarca() == null) {
          stmt.bindNull(37);
        } else {
          stmt.bindString(37, value.getNomeMarca());
        }
        if (value.getQtdVolumes() == null) {
          stmt.bindNull(38);
        } else {
          stmt.bindLong(38, value.getQtdVolumes());
        }
        if (value.getVolumeCapacidade() == null) {
          stmt.bindNull(39);
        } else {
          stmt.bindDouble(39, value.getVolumeCapacidade());
        }
        if (value.getVolumeCapacidadeReport() == null) {
          stmt.bindNull(40);
        } else {
          stmt.bindDouble(40, value.getVolumeCapacidadeReport());
        }
        if (value.getPesoBruto() == null) {
          stmt.bindNull(41);
        } else {
          stmt.bindDouble(41, value.getPesoBruto());
        }
        if (value.getPesoLiquido() == null) {
          stmt.bindNull(42);
        } else {
          stmt.bindDouble(42, value.getPesoLiquido());
        }
        if (value.getTipoPedido() == null) {
          stmt.bindNull(43);
        } else {
          stmt.bindString(43, value.getTipoPedido());
        }
        if (value.getCdCustomer() == null) {
          stmt.bindNull(44);
        } else {
          stmt.bindLong(44, value.getCdCustomer());
        }
        if (value.getAtivaTipoPagto() == null) {
          stmt.bindNull(45);
        } else {
          stmt.bindString(45, value.getAtivaTipoPagto());
        }
        if (value.getStepEmissao() == null) {
          stmt.bindNull(46);
        } else {
          stmt.bindLong(46, value.getStepEmissao());
        }
        if (value.getChave() == null) {
          stmt.bindNull(47);
        } else {
          stmt.bindString(47, value.getChave());
        }
        if (value.getProtocolo() == null) {
          stmt.bindNull(48);
        } else {
          stmt.bindString(48, value.getProtocolo());
        }
        if (value.getCdMovimento() == null) {
          stmt.bindNull(49);
        } else {
          stmt.bindString(49, value.getCdMovimento());
        }
        if (value.getCondicaoPagamento() == null) {
          stmt.bindNull(50);
        } else {
          stmt.bindString(50, value.getCondicaoPagamento());
        }
        if (value.getAliquotaIcms() == null) {
          stmt.bindNull(51);
        } else {
          stmt.bindDouble(51, value.getAliquotaIcms());
        }
        if (value.getValorDescontoIcms() == null) {
          stmt.bindNull(52);
        } else {
          stmt.bindDouble(52, value.getValorDescontoIcms());
        }
        if (value.getValorIcms() == null) {
          stmt.bindNull(53);
        } else {
          stmt.bindDouble(53, value.getValorIcms());
        }
        if (value.getBaseCalculoIcms() == null) {
          stmt.bindNull(54);
        } else {
          stmt.bindDouble(54, value.getBaseCalculoIcms());
        }
        if (value.getSituacaoTributariaIcms() == null) {
          stmt.bindNull(55);
        } else {
          stmt.bindLong(55, value.getSituacaoTributariaIcms());
        }
        if (value.getValorIpi() == null) {
          stmt.bindNull(56);
        } else {
          stmt.bindDouble(56, value.getValorIpi());
        }
        if (value.getBaseCalculoIpi() == null) {
          stmt.bindNull(57);
        } else {
          stmt.bindDouble(57, value.getBaseCalculoIpi());
        }
        if (value.getSituacaoTributariaIpi() == null) {
          stmt.bindNull(58);
        } else {
          stmt.bindLong(58, value.getSituacaoTributariaIpi());
        }
        if (value.getFlNovoFaturamento() == null) {
          stmt.bindNull(59);
        } else {
          stmt.bindString(59, value.getFlNovoFaturamento());
        }
        if (value.getCdOperadora() == null) {
          stmt.bindNull(60);
        } else {
          stmt.bindLong(60, value.getCdOperadora());
        }
        if (value.getFlPaciente() == null) {
          stmt.bindNull(61);
        } else {
          stmt.bindString(61, value.getFlPaciente());
        }
        if (value.getCdCustomerService() == null) {
          stmt.bindNull(62);
        } else {
          stmt.bindLong(62, value.getCdCustomerService());
        }
        if (value.getNomeAssinadorCec() == null) {
          stmt.bindNull(63);
        } else {
          stmt.bindString(63, value.getNomeAssinadorCec());
        }
        if (value.getRgAssinadorCec() == null) {
          stmt.bindNull(64);
        } else {
          stmt.bindString(64, value.getRgAssinadorCec());
        }
        if (value.getTipoMovimentoIntegracao() == null) {
          stmt.bindNull(65);
        } else {
          stmt.bindLong(65, value.getTipoMovimentoIntegracao());
        }
        if (value.getSemPagto() == null) {
          stmt.bindNull(66);
        } else {
          stmt.bindString(66, value.getSemPagto());
        }
        if (value.getStatusGravacaoJde() == null) {
          stmt.bindNull(67);
        } else {
          stmt.bindLong(67, value.getStatusGravacaoJde());
        }
        if (value.getMensagemGravacaoJde() == null) {
          stmt.bindNull(68);
        } else {
          stmt.bindString(68, value.getMensagemGravacaoJde());
        }
        if (value.getTipoTransacao() == null) {
          stmt.bindNull(69);
        } else {
          stmt.bindLong(69, value.getTipoTransacao());
        }
        if (value.getStatus() == null) {
          stmt.bindNull(70);
        } else {
          stmt.bindLong(70, value.getStatus());
        }
        if (value.getStatusContingencia() == null) {
          stmt.bindNull(71);
        } else {
          stmt.bindString(71, value.getStatusContingencia());
        }
        if (value.getMensagemContingencia() == null) {
          stmt.bindNull(72);
        } else {
          stmt.bindString(72, value.getMensagemContingencia());
        }
        if (value.getStatusCec() == null) {
          stmt.bindNull(73);
        } else {
          stmt.bindLong(73, value.getStatusCec());
        }
        if (value.getNomeTransacao() == null) {
          stmt.bindNull(74);
        } else {
          stmt.bindString(74, value.getNomeTransacao());
        }
        if (value.getStatusImpressaoCec() == null) {
          stmt.bindNull(75);
        } else {
          stmt.bindLong(75, value.getStatusImpressaoCec());
        }
        if (value.getNomeFormaImpressaoCec() == null) {
          stmt.bindNull(76);
        } else {
          stmt.bindString(76, value.getNomeFormaImpressaoCec());
        }
        if (value.getNomeStatus() == null) {
          stmt.bindNull(77);
        } else {
          stmt.bindString(77, value.getNomeStatus());
        }
        if (value.getNomeStatusImpressaoCec() == null) {
          stmt.bindNull(78);
        } else {
          stmt.bindString(78, value.getNomeStatusImpressaoCec());
        }
        if (value.getFlPrecoAlterado() == null) {
          stmt.bindNull(79);
        } else {
          stmt.bindString(79, value.getFlPrecoAlterado());
        }
        if (value.getNomeTipoPagamento() == null) {
          stmt.bindNull(80);
        } else {
          stmt.bindString(80, value.getNomeTipoPagamento());
        }
        if (value.getCdMotivo() == null) {
          stmt.bindNull(81);
        } else {
          stmt.bindString(81, value.getCdMotivo());
        }
        if (value.getDsMotivo() == null) {
          stmt.bindNull(82);
        } else {
          stmt.bindString(82, value.getDsMotivo());
        }
        if (value.getStatusNfeImp() == null) {
          stmt.bindNull(83);
        } else {
          stmt.bindString(83, value.getStatusNfeImp());
        }
        if (value.getStatusReportFile() == null) {
          stmt.bindNull(84);
        } else {
          stmt.bindString(84, value.getStatusReportFile());
        }
      }
    };
    this.__insertionAdapterOfInvoice_1 = new EntityInsertionAdapter<Invoice>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Invoice`(`id`,`numero`,`serie`,`numeroNotaVOR`,`serieNotaVOR`,`cdPreOrdem`,`numeroFutEntrega`,`cdFiscal`,`cnpjCpfDestino`,`cnpjCpfTransp`,`tipoNota`,`classeContribuinte`,`dataViagemPrincial`,`numeroViagem`,`dataViagem`,`nomeOperacao`,`dataEmissao`,`dataMovimento`,`dataVencimento`,`valorTotal`,`valorLiquido`,`valorTotalProduto`,`valorFrete`,`valorDespAcessorias`,`valorDinheiro`,`valorTroco`,`valorFatura`,`valorDebito`,`valorCredito`,`valorCheque`,`numeroCheque`,`ufVeiculo`,`placaVeiculo`,`numeroVeiculo`,`modalidadeFrete`,`nomeEspecVolume`,`nomeMarca`,`qtdVolumes`,`volumeCapacidade`,`volumeCapacidadeReport`,`pesoBruto`,`pesoLiquido`,`tipoPedido`,`cdCustomer`,`ativaTipoPagto`,`stepEmissao`,`chave`,`protocolo`,`cdMovimento`,`condicaoPagamento`,`aliquotaIcms`,`valorDescontoIcms`,`valorIcms`,`baseCalculoIcms`,`situacaoTributariaIcms`,`valorIpi`,`baseCalculoIpi`,`situacaoTributariaIpi`,`flNovoFaturamento`,`cdOperadora`,`flPaciente`,`cdCustomerService`,`nomeAssinadorCec`,`rgAssinadorCec`,`tipoMovimentoIntegracao`,`semPagto`,`statusGravacaoJde`,`mensagemGravacaoJde`,`tipoTransacao`,`status`,`statusContingencia`,`mensagemContingencia`,`statusCec`,`nomeTransacao`,`statusImpressaoCec`,`nomeFormaImpressaoCec`,`nomeStatus`,`nomeStatusImpressaoCec`,`flPrecoAlterado`,`nomeTipoPagamento`,`cdMotivo`,`dsMotivo`,`statusNfeImp`,`statusReportFile`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Invoice value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getNumero() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getNumero());
        }
        if (value.getSerie() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getSerie());
        }
        if (value.getNumeroNotaVOR() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getNumeroNotaVOR());
        }
        if (value.getSerieNotaVOR() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getSerieNotaVOR());
        }
        if (value.getCdPreOrdem() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getCdPreOrdem());
        }
        if (value.getNumeroFutEntrega() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getNumeroFutEntrega());
        }
        if (value.getCdFiscal() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.getCdFiscal());
        }
        if (value.getCnpjCpfDestino() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getCnpjCpfDestino());
        }
        if (value.getCnpjCpfTransp() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getCnpjCpfTransp());
        }
        if (value.getTipoNota() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getTipoNota());
        }
        if (value.getClasseContribuinte() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindLong(12, value.getClasseContribuinte());
        }
        if (value.getDataViagemPrincial() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getDataViagemPrincial());
        }
        if (value.getNumeroViagem() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getNumeroViagem());
        }
        if (value.getDataViagem() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getDataViagem());
        }
        if (value.getNomeOperacao() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getNomeOperacao());
        }
        final Long _tmp;
        _tmp = DateTypeConverter.dateToTimestamp(value.getDataEmissao());
        if (_tmp == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindLong(17, _tmp);
        }
        final Long _tmp_1;
        _tmp_1 = DateTypeConverter.dateToTimestamp(value.getDataMovimento());
        if (_tmp_1 == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindLong(18, _tmp_1);
        }
        final Long _tmp_2;
        _tmp_2 = DateTypeConverter.dateToTimestamp(value.getDataVencimento());
        if (_tmp_2 == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindLong(19, _tmp_2);
        }
        if (value.getValorTotal() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindDouble(20, value.getValorTotal());
        }
        if (value.getValorLiquido() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindDouble(21, value.getValorLiquido());
        }
        if (value.getValorTotalProduto() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindDouble(22, value.getValorTotalProduto());
        }
        if (value.getValorFrete() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindDouble(23, value.getValorFrete());
        }
        if (value.getValorDespAcessorias() == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindDouble(24, value.getValorDespAcessorias());
        }
        if (value.getValorDinheiro() == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindDouble(25, value.getValorDinheiro());
        }
        if (value.getValorTroco() == null) {
          stmt.bindNull(26);
        } else {
          stmt.bindDouble(26, value.getValorTroco());
        }
        if (value.getValorFatura() == null) {
          stmt.bindNull(27);
        } else {
          stmt.bindDouble(27, value.getValorFatura());
        }
        if (value.getValorDebito() == null) {
          stmt.bindNull(28);
        } else {
          stmt.bindDouble(28, value.getValorDebito());
        }
        if (value.getValorCredito() == null) {
          stmt.bindNull(29);
        } else {
          stmt.bindDouble(29, value.getValorCredito());
        }
        if (value.getValorCheque() == null) {
          stmt.bindNull(30);
        } else {
          stmt.bindDouble(30, value.getValorCheque());
        }
        if (value.getNumeroCheque() == null) {
          stmt.bindNull(31);
        } else {
          stmt.bindString(31, value.getNumeroCheque());
        }
        if (value.getUfVeiculo() == null) {
          stmt.bindNull(32);
        } else {
          stmt.bindString(32, value.getUfVeiculo());
        }
        if (value.getPlacaVeiculo() == null) {
          stmt.bindNull(33);
        } else {
          stmt.bindString(33, value.getPlacaVeiculo());
        }
        if (value.getNumeroVeiculo() == null) {
          stmt.bindNull(34);
        } else {
          stmt.bindString(34, value.getNumeroVeiculo());
        }
        if (value.getModalidadeFrete() == null) {
          stmt.bindNull(35);
        } else {
          stmt.bindLong(35, value.getModalidadeFrete());
        }
        if (value.getNomeEspecVolume() == null) {
          stmt.bindNull(36);
        } else {
          stmt.bindString(36, value.getNomeEspecVolume());
        }
        if (value.getNomeMarca() == null) {
          stmt.bindNull(37);
        } else {
          stmt.bindString(37, value.getNomeMarca());
        }
        if (value.getQtdVolumes() == null) {
          stmt.bindNull(38);
        } else {
          stmt.bindLong(38, value.getQtdVolumes());
        }
        if (value.getVolumeCapacidade() == null) {
          stmt.bindNull(39);
        } else {
          stmt.bindDouble(39, value.getVolumeCapacidade());
        }
        if (value.getVolumeCapacidadeReport() == null) {
          stmt.bindNull(40);
        } else {
          stmt.bindDouble(40, value.getVolumeCapacidadeReport());
        }
        if (value.getPesoBruto() == null) {
          stmt.bindNull(41);
        } else {
          stmt.bindDouble(41, value.getPesoBruto());
        }
        if (value.getPesoLiquido() == null) {
          stmt.bindNull(42);
        } else {
          stmt.bindDouble(42, value.getPesoLiquido());
        }
        if (value.getTipoPedido() == null) {
          stmt.bindNull(43);
        } else {
          stmt.bindString(43, value.getTipoPedido());
        }
        if (value.getCdCustomer() == null) {
          stmt.bindNull(44);
        } else {
          stmt.bindLong(44, value.getCdCustomer());
        }
        if (value.getAtivaTipoPagto() == null) {
          stmt.bindNull(45);
        } else {
          stmt.bindString(45, value.getAtivaTipoPagto());
        }
        if (value.getStepEmissao() == null) {
          stmt.bindNull(46);
        } else {
          stmt.bindLong(46, value.getStepEmissao());
        }
        if (value.getChave() == null) {
          stmt.bindNull(47);
        } else {
          stmt.bindString(47, value.getChave());
        }
        if (value.getProtocolo() == null) {
          stmt.bindNull(48);
        } else {
          stmt.bindString(48, value.getProtocolo());
        }
        if (value.getCdMovimento() == null) {
          stmt.bindNull(49);
        } else {
          stmt.bindString(49, value.getCdMovimento());
        }
        if (value.getCondicaoPagamento() == null) {
          stmt.bindNull(50);
        } else {
          stmt.bindString(50, value.getCondicaoPagamento());
        }
        if (value.getAliquotaIcms() == null) {
          stmt.bindNull(51);
        } else {
          stmt.bindDouble(51, value.getAliquotaIcms());
        }
        if (value.getValorDescontoIcms() == null) {
          stmt.bindNull(52);
        } else {
          stmt.bindDouble(52, value.getValorDescontoIcms());
        }
        if (value.getValorIcms() == null) {
          stmt.bindNull(53);
        } else {
          stmt.bindDouble(53, value.getValorIcms());
        }
        if (value.getBaseCalculoIcms() == null) {
          stmt.bindNull(54);
        } else {
          stmt.bindDouble(54, value.getBaseCalculoIcms());
        }
        if (value.getSituacaoTributariaIcms() == null) {
          stmt.bindNull(55);
        } else {
          stmt.bindLong(55, value.getSituacaoTributariaIcms());
        }
        if (value.getValorIpi() == null) {
          stmt.bindNull(56);
        } else {
          stmt.bindDouble(56, value.getValorIpi());
        }
        if (value.getBaseCalculoIpi() == null) {
          stmt.bindNull(57);
        } else {
          stmt.bindDouble(57, value.getBaseCalculoIpi());
        }
        if (value.getSituacaoTributariaIpi() == null) {
          stmt.bindNull(58);
        } else {
          stmt.bindLong(58, value.getSituacaoTributariaIpi());
        }
        if (value.getFlNovoFaturamento() == null) {
          stmt.bindNull(59);
        } else {
          stmt.bindString(59, value.getFlNovoFaturamento());
        }
        if (value.getCdOperadora() == null) {
          stmt.bindNull(60);
        } else {
          stmt.bindLong(60, value.getCdOperadora());
        }
        if (value.getFlPaciente() == null) {
          stmt.bindNull(61);
        } else {
          stmt.bindString(61, value.getFlPaciente());
        }
        if (value.getCdCustomerService() == null) {
          stmt.bindNull(62);
        } else {
          stmt.bindLong(62, value.getCdCustomerService());
        }
        if (value.getNomeAssinadorCec() == null) {
          stmt.bindNull(63);
        } else {
          stmt.bindString(63, value.getNomeAssinadorCec());
        }
        if (value.getRgAssinadorCec() == null) {
          stmt.bindNull(64);
        } else {
          stmt.bindString(64, value.getRgAssinadorCec());
        }
        if (value.getTipoMovimentoIntegracao() == null) {
          stmt.bindNull(65);
        } else {
          stmt.bindLong(65, value.getTipoMovimentoIntegracao());
        }
        if (value.getSemPagto() == null) {
          stmt.bindNull(66);
        } else {
          stmt.bindString(66, value.getSemPagto());
        }
        if (value.getStatusGravacaoJde() == null) {
          stmt.bindNull(67);
        } else {
          stmt.bindLong(67, value.getStatusGravacaoJde());
        }
        if (value.getMensagemGravacaoJde() == null) {
          stmt.bindNull(68);
        } else {
          stmt.bindString(68, value.getMensagemGravacaoJde());
        }
        if (value.getTipoTransacao() == null) {
          stmt.bindNull(69);
        } else {
          stmt.bindLong(69, value.getTipoTransacao());
        }
        if (value.getStatus() == null) {
          stmt.bindNull(70);
        } else {
          stmt.bindLong(70, value.getStatus());
        }
        if (value.getStatusContingencia() == null) {
          stmt.bindNull(71);
        } else {
          stmt.bindString(71, value.getStatusContingencia());
        }
        if (value.getMensagemContingencia() == null) {
          stmt.bindNull(72);
        } else {
          stmt.bindString(72, value.getMensagemContingencia());
        }
        if (value.getStatusCec() == null) {
          stmt.bindNull(73);
        } else {
          stmt.bindLong(73, value.getStatusCec());
        }
        if (value.getNomeTransacao() == null) {
          stmt.bindNull(74);
        } else {
          stmt.bindString(74, value.getNomeTransacao());
        }
        if (value.getStatusImpressaoCec() == null) {
          stmt.bindNull(75);
        } else {
          stmt.bindLong(75, value.getStatusImpressaoCec());
        }
        if (value.getNomeFormaImpressaoCec() == null) {
          stmt.bindNull(76);
        } else {
          stmt.bindString(76, value.getNomeFormaImpressaoCec());
        }
        if (value.getNomeStatus() == null) {
          stmt.bindNull(77);
        } else {
          stmt.bindString(77, value.getNomeStatus());
        }
        if (value.getNomeStatusImpressaoCec() == null) {
          stmt.bindNull(78);
        } else {
          stmt.bindString(78, value.getNomeStatusImpressaoCec());
        }
        if (value.getFlPrecoAlterado() == null) {
          stmt.bindNull(79);
        } else {
          stmt.bindString(79, value.getFlPrecoAlterado());
        }
        if (value.getNomeTipoPagamento() == null) {
          stmt.bindNull(80);
        } else {
          stmt.bindString(80, value.getNomeTipoPagamento());
        }
        if (value.getCdMotivo() == null) {
          stmt.bindNull(81);
        } else {
          stmt.bindString(81, value.getCdMotivo());
        }
        if (value.getDsMotivo() == null) {
          stmt.bindNull(82);
        } else {
          stmt.bindString(82, value.getDsMotivo());
        }
        if (value.getStatusNfeImp() == null) {
          stmt.bindNull(83);
        } else {
          stmt.bindString(83, value.getStatusNfeImp());
        }
        if (value.getStatusReportFile() == null) {
          stmt.bindNull(84);
        } else {
          stmt.bindString(84, value.getStatusReportFile());
        }
      }
    };
    this.__deletionAdapterOfInvoice = new EntityDeletionOrUpdateAdapter<Invoice>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Invoice` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Invoice value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
  }

  @Override
  public Long[] insertAll(List<Invoice> invoices) {
    __db.beginTransaction();
    try {
      Long[] _result = __insertionAdapterOfInvoice.insertAndReturnIdsArrayBox(invoices);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Long insert(Invoice invoice) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfInvoice_1.insertAndReturnId(invoice);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(Invoice invoice) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfInvoice.handle(invoice);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll(List<Invoice> invoices) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfInvoice.handleMultiple(invoices);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Invoice> getAll() {
    final String _sql = "SELECT * FROM Invoice ORDER BY numero";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfNumero = _cursor.getColumnIndexOrThrow("numero");
      final int _cursorIndexOfSerie = _cursor.getColumnIndexOrThrow("serie");
      final int _cursorIndexOfNumeroNotaVOR = _cursor.getColumnIndexOrThrow("numeroNotaVOR");
      final int _cursorIndexOfSerieNotaVOR = _cursor.getColumnIndexOrThrow("serieNotaVOR");
      final int _cursorIndexOfCdPreOrdem = _cursor.getColumnIndexOrThrow("cdPreOrdem");
      final int _cursorIndexOfNumeroFutEntrega = _cursor.getColumnIndexOrThrow("numeroFutEntrega");
      final int _cursorIndexOfCdFiscal = _cursor.getColumnIndexOrThrow("cdFiscal");
      final int _cursorIndexOfCnpjCpfDestino = _cursor.getColumnIndexOrThrow("cnpjCpfDestino");
      final int _cursorIndexOfCnpjCpfTransp = _cursor.getColumnIndexOrThrow("cnpjCpfTransp");
      final int _cursorIndexOfTipoNota = _cursor.getColumnIndexOrThrow("tipoNota");
      final int _cursorIndexOfClasseContribuinte = _cursor.getColumnIndexOrThrow("classeContribuinte");
      final int _cursorIndexOfDataViagemPrincial = _cursor.getColumnIndexOrThrow("dataViagemPrincial");
      final int _cursorIndexOfNumeroViagem = _cursor.getColumnIndexOrThrow("numeroViagem");
      final int _cursorIndexOfDataViagem = _cursor.getColumnIndexOrThrow("dataViagem");
      final int _cursorIndexOfNomeOperacao = _cursor.getColumnIndexOrThrow("nomeOperacao");
      final int _cursorIndexOfDataEmissao = _cursor.getColumnIndexOrThrow("dataEmissao");
      final int _cursorIndexOfDataMovimento = _cursor.getColumnIndexOrThrow("dataMovimento");
      final int _cursorIndexOfDataVencimento = _cursor.getColumnIndexOrThrow("dataVencimento");
      final int _cursorIndexOfValorTotal = _cursor.getColumnIndexOrThrow("valorTotal");
      final int _cursorIndexOfValorLiquido = _cursor.getColumnIndexOrThrow("valorLiquido");
      final int _cursorIndexOfValorTotalProduto = _cursor.getColumnIndexOrThrow("valorTotalProduto");
      final int _cursorIndexOfValorFrete = _cursor.getColumnIndexOrThrow("valorFrete");
      final int _cursorIndexOfValorDespAcessorias = _cursor.getColumnIndexOrThrow("valorDespAcessorias");
      final int _cursorIndexOfValorDinheiro = _cursor.getColumnIndexOrThrow("valorDinheiro");
      final int _cursorIndexOfValorTroco = _cursor.getColumnIndexOrThrow("valorTroco");
      final int _cursorIndexOfValorFatura = _cursor.getColumnIndexOrThrow("valorFatura");
      final int _cursorIndexOfValorDebito = _cursor.getColumnIndexOrThrow("valorDebito");
      final int _cursorIndexOfValorCredito = _cursor.getColumnIndexOrThrow("valorCredito");
      final int _cursorIndexOfValorCheque = _cursor.getColumnIndexOrThrow("valorCheque");
      final int _cursorIndexOfNumeroCheque = _cursor.getColumnIndexOrThrow("numeroCheque");
      final int _cursorIndexOfUfVeiculo = _cursor.getColumnIndexOrThrow("ufVeiculo");
      final int _cursorIndexOfPlacaVeiculo = _cursor.getColumnIndexOrThrow("placaVeiculo");
      final int _cursorIndexOfNumeroVeiculo = _cursor.getColumnIndexOrThrow("numeroVeiculo");
      final int _cursorIndexOfModalidadeFrete = _cursor.getColumnIndexOrThrow("modalidadeFrete");
      final int _cursorIndexOfNomeEspecVolume = _cursor.getColumnIndexOrThrow("nomeEspecVolume");
      final int _cursorIndexOfNomeMarca = _cursor.getColumnIndexOrThrow("nomeMarca");
      final int _cursorIndexOfQtdVolumes = _cursor.getColumnIndexOrThrow("qtdVolumes");
      final int _cursorIndexOfVolumeCapacidade = _cursor.getColumnIndexOrThrow("volumeCapacidade");
      final int _cursorIndexOfVolumeCapacidadeReport = _cursor.getColumnIndexOrThrow("volumeCapacidadeReport");
      final int _cursorIndexOfPesoBruto = _cursor.getColumnIndexOrThrow("pesoBruto");
      final int _cursorIndexOfPesoLiquido = _cursor.getColumnIndexOrThrow("pesoLiquido");
      final int _cursorIndexOfTipoPedido = _cursor.getColumnIndexOrThrow("tipoPedido");
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfAtivaTipoPagto = _cursor.getColumnIndexOrThrow("ativaTipoPagto");
      final int _cursorIndexOfStepEmissao = _cursor.getColumnIndexOrThrow("stepEmissao");
      final int _cursorIndexOfChave = _cursor.getColumnIndexOrThrow("chave");
      final int _cursorIndexOfProtocolo = _cursor.getColumnIndexOrThrow("protocolo");
      final int _cursorIndexOfCdMovimento = _cursor.getColumnIndexOrThrow("cdMovimento");
      final int _cursorIndexOfCondicaoPagamento = _cursor.getColumnIndexOrThrow("condicaoPagamento");
      final int _cursorIndexOfAliquotaIcms = _cursor.getColumnIndexOrThrow("aliquotaIcms");
      final int _cursorIndexOfValorDescontoIcms = _cursor.getColumnIndexOrThrow("valorDescontoIcms");
      final int _cursorIndexOfValorIcms = _cursor.getColumnIndexOrThrow("valorIcms");
      final int _cursorIndexOfBaseCalculoIcms = _cursor.getColumnIndexOrThrow("baseCalculoIcms");
      final int _cursorIndexOfSituacaoTributariaIcms = _cursor.getColumnIndexOrThrow("situacaoTributariaIcms");
      final int _cursorIndexOfValorIpi = _cursor.getColumnIndexOrThrow("valorIpi");
      final int _cursorIndexOfBaseCalculoIpi = _cursor.getColumnIndexOrThrow("baseCalculoIpi");
      final int _cursorIndexOfSituacaoTributariaIpi = _cursor.getColumnIndexOrThrow("situacaoTributariaIpi");
      final int _cursorIndexOfFlNovoFaturamento = _cursor.getColumnIndexOrThrow("flNovoFaturamento");
      final int _cursorIndexOfCdOperadora = _cursor.getColumnIndexOrThrow("cdOperadora");
      final int _cursorIndexOfFlPaciente = _cursor.getColumnIndexOrThrow("flPaciente");
      final int _cursorIndexOfCdCustomerService = _cursor.getColumnIndexOrThrow("cdCustomerService");
      final int _cursorIndexOfNomeAssinadorCec = _cursor.getColumnIndexOrThrow("nomeAssinadorCec");
      final int _cursorIndexOfRgAssinadorCec = _cursor.getColumnIndexOrThrow("rgAssinadorCec");
      final int _cursorIndexOfTipoMovimentoIntegracao = _cursor.getColumnIndexOrThrow("tipoMovimentoIntegracao");
      final int _cursorIndexOfSemPagto = _cursor.getColumnIndexOrThrow("semPagto");
      final int _cursorIndexOfStatusGravacaoJde = _cursor.getColumnIndexOrThrow("statusGravacaoJde");
      final int _cursorIndexOfMensagemGravacaoJde = _cursor.getColumnIndexOrThrow("mensagemGravacaoJde");
      final int _cursorIndexOfTipoTransacao = _cursor.getColumnIndexOrThrow("tipoTransacao");
      final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("status");
      final int _cursorIndexOfStatusContingencia = _cursor.getColumnIndexOrThrow("statusContingencia");
      final int _cursorIndexOfMensagemContingencia = _cursor.getColumnIndexOrThrow("mensagemContingencia");
      final int _cursorIndexOfStatusCec = _cursor.getColumnIndexOrThrow("statusCec");
      final int _cursorIndexOfNomeTransacao = _cursor.getColumnIndexOrThrow("nomeTransacao");
      final int _cursorIndexOfStatusImpressaoCec = _cursor.getColumnIndexOrThrow("statusImpressaoCec");
      final int _cursorIndexOfNomeFormaImpressaoCec = _cursor.getColumnIndexOrThrow("nomeFormaImpressaoCec");
      final int _cursorIndexOfNomeStatus = _cursor.getColumnIndexOrThrow("nomeStatus");
      final int _cursorIndexOfNomeStatusImpressaoCec = _cursor.getColumnIndexOrThrow("nomeStatusImpressaoCec");
      final int _cursorIndexOfFlPrecoAlterado = _cursor.getColumnIndexOrThrow("flPrecoAlterado");
      final int _cursorIndexOfNomeTipoPagamento = _cursor.getColumnIndexOrThrow("nomeTipoPagamento");
      final int _cursorIndexOfCdMotivo = _cursor.getColumnIndexOrThrow("cdMotivo");
      final int _cursorIndexOfDsMotivo = _cursor.getColumnIndexOrThrow("dsMotivo");
      final int _cursorIndexOfStatusNfeImp = _cursor.getColumnIndexOrThrow("statusNfeImp");
      final int _cursorIndexOfStatusReportFile = _cursor.getColumnIndexOrThrow("statusReportFile");
      final List<Invoice> _result = new ArrayList<Invoice>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Invoice _item;
        _item = new Invoice();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final Long _tmpNumero;
        if (_cursor.isNull(_cursorIndexOfNumero)) {
          _tmpNumero = null;
        } else {
          _tmpNumero = _cursor.getLong(_cursorIndexOfNumero);
        }
        _item.setNumero(_tmpNumero);
        final Long _tmpSerie;
        if (_cursor.isNull(_cursorIndexOfSerie)) {
          _tmpSerie = null;
        } else {
          _tmpSerie = _cursor.getLong(_cursorIndexOfSerie);
        }
        _item.setSerie(_tmpSerie);
        final Long _tmpNumeroNotaVOR;
        if (_cursor.isNull(_cursorIndexOfNumeroNotaVOR)) {
          _tmpNumeroNotaVOR = null;
        } else {
          _tmpNumeroNotaVOR = _cursor.getLong(_cursorIndexOfNumeroNotaVOR);
        }
        _item.setNumeroNotaVOR(_tmpNumeroNotaVOR);
        final Long _tmpSerieNotaVOR;
        if (_cursor.isNull(_cursorIndexOfSerieNotaVOR)) {
          _tmpSerieNotaVOR = null;
        } else {
          _tmpSerieNotaVOR = _cursor.getLong(_cursorIndexOfSerieNotaVOR);
        }
        _item.setSerieNotaVOR(_tmpSerieNotaVOR);
        final String _tmpCdPreOrdem;
        _tmpCdPreOrdem = _cursor.getString(_cursorIndexOfCdPreOrdem);
        _item.setCdPreOrdem(_tmpCdPreOrdem);
        final String _tmpNumeroFutEntrega;
        _tmpNumeroFutEntrega = _cursor.getString(_cursorIndexOfNumeroFutEntrega);
        _item.setNumeroFutEntrega(_tmpNumeroFutEntrega);
        final Integer _tmpCdFiscal;
        if (_cursor.isNull(_cursorIndexOfCdFiscal)) {
          _tmpCdFiscal = null;
        } else {
          _tmpCdFiscal = _cursor.getInt(_cursorIndexOfCdFiscal);
        }
        _item.setCdFiscal(_tmpCdFiscal);
        final String _tmpCnpjCpfDestino;
        _tmpCnpjCpfDestino = _cursor.getString(_cursorIndexOfCnpjCpfDestino);
        _item.setCnpjCpfDestino(_tmpCnpjCpfDestino);
        final String _tmpCnpjCpfTransp;
        _tmpCnpjCpfTransp = _cursor.getString(_cursorIndexOfCnpjCpfTransp);
        _item.setCnpjCpfTransp(_tmpCnpjCpfTransp);
        final String _tmpTipoNota;
        _tmpTipoNota = _cursor.getString(_cursorIndexOfTipoNota);
        _item.setTipoNota(_tmpTipoNota);
        final Integer _tmpClasseContribuinte;
        if (_cursor.isNull(_cursorIndexOfClasseContribuinte)) {
          _tmpClasseContribuinte = null;
        } else {
          _tmpClasseContribuinte = _cursor.getInt(_cursorIndexOfClasseContribuinte);
        }
        _item.setClasseContribuinte(_tmpClasseContribuinte);
        final String _tmpDataViagemPrincial;
        _tmpDataViagemPrincial = _cursor.getString(_cursorIndexOfDataViagemPrincial);
        _item.setDataViagemPrincial(_tmpDataViagemPrincial);
        final String _tmpNumeroViagem;
        _tmpNumeroViagem = _cursor.getString(_cursorIndexOfNumeroViagem);
        _item.setNumeroViagem(_tmpNumeroViagem);
        final String _tmpDataViagem;
        _tmpDataViagem = _cursor.getString(_cursorIndexOfDataViagem);
        _item.setDataViagem(_tmpDataViagem);
        final String _tmpNomeOperacao;
        _tmpNomeOperacao = _cursor.getString(_cursorIndexOfNomeOperacao);
        _item.setNomeOperacao(_tmpNomeOperacao);
        final Date _tmpDataEmissao;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfDataEmissao)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfDataEmissao);
        }
        _tmpDataEmissao = DateTypeConverter.fromTimestamp(_tmp);
        _item.setDataEmissao(_tmpDataEmissao);
        final Date _tmpDataMovimento;
        final Long _tmp_1;
        if (_cursor.isNull(_cursorIndexOfDataMovimento)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getLong(_cursorIndexOfDataMovimento);
        }
        _tmpDataMovimento = DateTypeConverter.fromTimestamp(_tmp_1);
        _item.setDataMovimento(_tmpDataMovimento);
        final Date _tmpDataVencimento;
        final Long _tmp_2;
        if (_cursor.isNull(_cursorIndexOfDataVencimento)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getLong(_cursorIndexOfDataVencimento);
        }
        _tmpDataVencimento = DateTypeConverter.fromTimestamp(_tmp_2);
        _item.setDataVencimento(_tmpDataVencimento);
        final Double _tmpValorTotal;
        if (_cursor.isNull(_cursorIndexOfValorTotal)) {
          _tmpValorTotal = null;
        } else {
          _tmpValorTotal = _cursor.getDouble(_cursorIndexOfValorTotal);
        }
        _item.setValorTotal(_tmpValorTotal);
        final Double _tmpValorLiquido;
        if (_cursor.isNull(_cursorIndexOfValorLiquido)) {
          _tmpValorLiquido = null;
        } else {
          _tmpValorLiquido = _cursor.getDouble(_cursorIndexOfValorLiquido);
        }
        _item.setValorLiquido(_tmpValorLiquido);
        final Double _tmpValorTotalProduto;
        if (_cursor.isNull(_cursorIndexOfValorTotalProduto)) {
          _tmpValorTotalProduto = null;
        } else {
          _tmpValorTotalProduto = _cursor.getDouble(_cursorIndexOfValorTotalProduto);
        }
        _item.setValorTotalProduto(_tmpValorTotalProduto);
        final Double _tmpValorFrete;
        if (_cursor.isNull(_cursorIndexOfValorFrete)) {
          _tmpValorFrete = null;
        } else {
          _tmpValorFrete = _cursor.getDouble(_cursorIndexOfValorFrete);
        }
        _item.setValorFrete(_tmpValorFrete);
        final Double _tmpValorDespAcessorias;
        if (_cursor.isNull(_cursorIndexOfValorDespAcessorias)) {
          _tmpValorDespAcessorias = null;
        } else {
          _tmpValorDespAcessorias = _cursor.getDouble(_cursorIndexOfValorDespAcessorias);
        }
        _item.setValorDespAcessorias(_tmpValorDespAcessorias);
        final Double _tmpValorDinheiro;
        if (_cursor.isNull(_cursorIndexOfValorDinheiro)) {
          _tmpValorDinheiro = null;
        } else {
          _tmpValorDinheiro = _cursor.getDouble(_cursorIndexOfValorDinheiro);
        }
        _item.setValorDinheiro(_tmpValorDinheiro);
        final Double _tmpValorTroco;
        if (_cursor.isNull(_cursorIndexOfValorTroco)) {
          _tmpValorTroco = null;
        } else {
          _tmpValorTroco = _cursor.getDouble(_cursorIndexOfValorTroco);
        }
        _item.setValorTroco(_tmpValorTroco);
        final Double _tmpValorFatura;
        if (_cursor.isNull(_cursorIndexOfValorFatura)) {
          _tmpValorFatura = null;
        } else {
          _tmpValorFatura = _cursor.getDouble(_cursorIndexOfValorFatura);
        }
        _item.setValorFatura(_tmpValorFatura);
        final Double _tmpValorDebito;
        if (_cursor.isNull(_cursorIndexOfValorDebito)) {
          _tmpValorDebito = null;
        } else {
          _tmpValorDebito = _cursor.getDouble(_cursorIndexOfValorDebito);
        }
        _item.setValorDebito(_tmpValorDebito);
        final Double _tmpValorCredito;
        if (_cursor.isNull(_cursorIndexOfValorCredito)) {
          _tmpValorCredito = null;
        } else {
          _tmpValorCredito = _cursor.getDouble(_cursorIndexOfValorCredito);
        }
        _item.setValorCredito(_tmpValorCredito);
        final Double _tmpValorCheque;
        if (_cursor.isNull(_cursorIndexOfValorCheque)) {
          _tmpValorCheque = null;
        } else {
          _tmpValorCheque = _cursor.getDouble(_cursorIndexOfValorCheque);
        }
        _item.setValorCheque(_tmpValorCheque);
        final String _tmpNumeroCheque;
        _tmpNumeroCheque = _cursor.getString(_cursorIndexOfNumeroCheque);
        _item.setNumeroCheque(_tmpNumeroCheque);
        final String _tmpUfVeiculo;
        _tmpUfVeiculo = _cursor.getString(_cursorIndexOfUfVeiculo);
        _item.setUfVeiculo(_tmpUfVeiculo);
        final String _tmpPlacaVeiculo;
        _tmpPlacaVeiculo = _cursor.getString(_cursorIndexOfPlacaVeiculo);
        _item.setPlacaVeiculo(_tmpPlacaVeiculo);
        final String _tmpNumeroVeiculo;
        _tmpNumeroVeiculo = _cursor.getString(_cursorIndexOfNumeroVeiculo);
        _item.setNumeroVeiculo(_tmpNumeroVeiculo);
        final Integer _tmpModalidadeFrete;
        if (_cursor.isNull(_cursorIndexOfModalidadeFrete)) {
          _tmpModalidadeFrete = null;
        } else {
          _tmpModalidadeFrete = _cursor.getInt(_cursorIndexOfModalidadeFrete);
        }
        _item.setModalidadeFrete(_tmpModalidadeFrete);
        final String _tmpNomeEspecVolume;
        _tmpNomeEspecVolume = _cursor.getString(_cursorIndexOfNomeEspecVolume);
        _item.setNomeEspecVolume(_tmpNomeEspecVolume);
        final String _tmpNomeMarca;
        _tmpNomeMarca = _cursor.getString(_cursorIndexOfNomeMarca);
        _item.setNomeMarca(_tmpNomeMarca);
        final Integer _tmpQtdVolumes;
        if (_cursor.isNull(_cursorIndexOfQtdVolumes)) {
          _tmpQtdVolumes = null;
        } else {
          _tmpQtdVolumes = _cursor.getInt(_cursorIndexOfQtdVolumes);
        }
        _item.setQtdVolumes(_tmpQtdVolumes);
        final Double _tmpVolumeCapacidade;
        if (_cursor.isNull(_cursorIndexOfVolumeCapacidade)) {
          _tmpVolumeCapacidade = null;
        } else {
          _tmpVolumeCapacidade = _cursor.getDouble(_cursorIndexOfVolumeCapacidade);
        }
        _item.setVolumeCapacidade(_tmpVolumeCapacidade);
        final Double _tmpVolumeCapacidadeReport;
        if (_cursor.isNull(_cursorIndexOfVolumeCapacidadeReport)) {
          _tmpVolumeCapacidadeReport = null;
        } else {
          _tmpVolumeCapacidadeReport = _cursor.getDouble(_cursorIndexOfVolumeCapacidadeReport);
        }
        _item.setVolumeCapacidadeReport(_tmpVolumeCapacidadeReport);
        final Double _tmpPesoBruto;
        if (_cursor.isNull(_cursorIndexOfPesoBruto)) {
          _tmpPesoBruto = null;
        } else {
          _tmpPesoBruto = _cursor.getDouble(_cursorIndexOfPesoBruto);
        }
        _item.setPesoBruto(_tmpPesoBruto);
        final Double _tmpPesoLiquido;
        if (_cursor.isNull(_cursorIndexOfPesoLiquido)) {
          _tmpPesoLiquido = null;
        } else {
          _tmpPesoLiquido = _cursor.getDouble(_cursorIndexOfPesoLiquido);
        }
        _item.setPesoLiquido(_tmpPesoLiquido);
        final String _tmpTipoPedido;
        _tmpTipoPedido = _cursor.getString(_cursorIndexOfTipoPedido);
        _item.setTipoPedido(_tmpTipoPedido);
        final Long _tmpCdCustomer;
        if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
          _tmpCdCustomer = null;
        } else {
          _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
        }
        _item.setCdCustomer(_tmpCdCustomer);
        final String _tmpAtivaTipoPagto;
        _tmpAtivaTipoPagto = _cursor.getString(_cursorIndexOfAtivaTipoPagto);
        _item.setAtivaTipoPagto(_tmpAtivaTipoPagto);
        final Integer _tmpStepEmissao;
        if (_cursor.isNull(_cursorIndexOfStepEmissao)) {
          _tmpStepEmissao = null;
        } else {
          _tmpStepEmissao = _cursor.getInt(_cursorIndexOfStepEmissao);
        }
        _item.setStepEmissao(_tmpStepEmissao);
        final String _tmpChave;
        _tmpChave = _cursor.getString(_cursorIndexOfChave);
        _item.setChave(_tmpChave);
        final String _tmpProtocolo;
        _tmpProtocolo = _cursor.getString(_cursorIndexOfProtocolo);
        _item.setProtocolo(_tmpProtocolo);
        final String _tmpCdMovimento;
        _tmpCdMovimento = _cursor.getString(_cursorIndexOfCdMovimento);
        _item.setCdMovimento(_tmpCdMovimento);
        final String _tmpCondicaoPagamento;
        _tmpCondicaoPagamento = _cursor.getString(_cursorIndexOfCondicaoPagamento);
        _item.setCondicaoPagamento(_tmpCondicaoPagamento);
        final Double _tmpAliquotaIcms;
        if (_cursor.isNull(_cursorIndexOfAliquotaIcms)) {
          _tmpAliquotaIcms = null;
        } else {
          _tmpAliquotaIcms = _cursor.getDouble(_cursorIndexOfAliquotaIcms);
        }
        _item.setAliquotaIcms(_tmpAliquotaIcms);
        final Double _tmpValorDescontoIcms;
        if (_cursor.isNull(_cursorIndexOfValorDescontoIcms)) {
          _tmpValorDescontoIcms = null;
        } else {
          _tmpValorDescontoIcms = _cursor.getDouble(_cursorIndexOfValorDescontoIcms);
        }
        _item.setValorDescontoIcms(_tmpValorDescontoIcms);
        final Double _tmpValorIcms;
        if (_cursor.isNull(_cursorIndexOfValorIcms)) {
          _tmpValorIcms = null;
        } else {
          _tmpValorIcms = _cursor.getDouble(_cursorIndexOfValorIcms);
        }
        _item.setValorIcms(_tmpValorIcms);
        final Double _tmpBaseCalculoIcms;
        if (_cursor.isNull(_cursorIndexOfBaseCalculoIcms)) {
          _tmpBaseCalculoIcms = null;
        } else {
          _tmpBaseCalculoIcms = _cursor.getDouble(_cursorIndexOfBaseCalculoIcms);
        }
        _item.setBaseCalculoIcms(_tmpBaseCalculoIcms);
        final Integer _tmpSituacaoTributariaIcms;
        if (_cursor.isNull(_cursorIndexOfSituacaoTributariaIcms)) {
          _tmpSituacaoTributariaIcms = null;
        } else {
          _tmpSituacaoTributariaIcms = _cursor.getInt(_cursorIndexOfSituacaoTributariaIcms);
        }
        _item.setSituacaoTributariaIcms(_tmpSituacaoTributariaIcms);
        final Double _tmpValorIpi;
        if (_cursor.isNull(_cursorIndexOfValorIpi)) {
          _tmpValorIpi = null;
        } else {
          _tmpValorIpi = _cursor.getDouble(_cursorIndexOfValorIpi);
        }
        _item.setValorIpi(_tmpValorIpi);
        final Double _tmpBaseCalculoIpi;
        if (_cursor.isNull(_cursorIndexOfBaseCalculoIpi)) {
          _tmpBaseCalculoIpi = null;
        } else {
          _tmpBaseCalculoIpi = _cursor.getDouble(_cursorIndexOfBaseCalculoIpi);
        }
        _item.setBaseCalculoIpi(_tmpBaseCalculoIpi);
        final Integer _tmpSituacaoTributariaIpi;
        if (_cursor.isNull(_cursorIndexOfSituacaoTributariaIpi)) {
          _tmpSituacaoTributariaIpi = null;
        } else {
          _tmpSituacaoTributariaIpi = _cursor.getInt(_cursorIndexOfSituacaoTributariaIpi);
        }
        _item.setSituacaoTributariaIpi(_tmpSituacaoTributariaIpi);
        final String _tmpFlNovoFaturamento;
        _tmpFlNovoFaturamento = _cursor.getString(_cursorIndexOfFlNovoFaturamento);
        _item.setFlNovoFaturamento(_tmpFlNovoFaturamento);
        final Long _tmpCdOperadora;
        if (_cursor.isNull(_cursorIndexOfCdOperadora)) {
          _tmpCdOperadora = null;
        } else {
          _tmpCdOperadora = _cursor.getLong(_cursorIndexOfCdOperadora);
        }
        _item.setCdOperadora(_tmpCdOperadora);
        final String _tmpFlPaciente;
        _tmpFlPaciente = _cursor.getString(_cursorIndexOfFlPaciente);
        _item.setFlPaciente(_tmpFlPaciente);
        final Long _tmpCdCustomerService;
        if (_cursor.isNull(_cursorIndexOfCdCustomerService)) {
          _tmpCdCustomerService = null;
        } else {
          _tmpCdCustomerService = _cursor.getLong(_cursorIndexOfCdCustomerService);
        }
        _item.setCdCustomerService(_tmpCdCustomerService);
        final String _tmpNomeAssinadorCec;
        _tmpNomeAssinadorCec = _cursor.getString(_cursorIndexOfNomeAssinadorCec);
        _item.setNomeAssinadorCec(_tmpNomeAssinadorCec);
        final String _tmpRgAssinadorCec;
        _tmpRgAssinadorCec = _cursor.getString(_cursorIndexOfRgAssinadorCec);
        _item.setRgAssinadorCec(_tmpRgAssinadorCec);
        final Integer _tmpTipoMovimentoIntegracao;
        if (_cursor.isNull(_cursorIndexOfTipoMovimentoIntegracao)) {
          _tmpTipoMovimentoIntegracao = null;
        } else {
          _tmpTipoMovimentoIntegracao = _cursor.getInt(_cursorIndexOfTipoMovimentoIntegracao);
        }
        _item.setTipoMovimentoIntegracao(_tmpTipoMovimentoIntegracao);
        final String _tmpSemPagto;
        _tmpSemPagto = _cursor.getString(_cursorIndexOfSemPagto);
        _item.setSemPagto(_tmpSemPagto);
        final Integer _tmpStatusGravacaoJde;
        if (_cursor.isNull(_cursorIndexOfStatusGravacaoJde)) {
          _tmpStatusGravacaoJde = null;
        } else {
          _tmpStatusGravacaoJde = _cursor.getInt(_cursorIndexOfStatusGravacaoJde);
        }
        _item.setStatusGravacaoJde(_tmpStatusGravacaoJde);
        final String _tmpMensagemGravacaoJde;
        _tmpMensagemGravacaoJde = _cursor.getString(_cursorIndexOfMensagemGravacaoJde);
        _item.setMensagemGravacaoJde(_tmpMensagemGravacaoJde);
        final Integer _tmpTipoTransacao;
        if (_cursor.isNull(_cursorIndexOfTipoTransacao)) {
          _tmpTipoTransacao = null;
        } else {
          _tmpTipoTransacao = _cursor.getInt(_cursorIndexOfTipoTransacao);
        }
        _item.setTipoTransacao(_tmpTipoTransacao);
        final Integer _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
        }
        _item.setStatus(_tmpStatus);
        final String _tmpStatusContingencia;
        _tmpStatusContingencia = _cursor.getString(_cursorIndexOfStatusContingencia);
        _item.setStatusContingencia(_tmpStatusContingencia);
        final String _tmpMensagemContingencia;
        _tmpMensagemContingencia = _cursor.getString(_cursorIndexOfMensagemContingencia);
        _item.setMensagemContingencia(_tmpMensagemContingencia);
        final Integer _tmpStatusCec;
        if (_cursor.isNull(_cursorIndexOfStatusCec)) {
          _tmpStatusCec = null;
        } else {
          _tmpStatusCec = _cursor.getInt(_cursorIndexOfStatusCec);
        }
        _item.setStatusCec(_tmpStatusCec);
        final String _tmpNomeTransacao;
        _tmpNomeTransacao = _cursor.getString(_cursorIndexOfNomeTransacao);
        _item.setNomeTransacao(_tmpNomeTransacao);
        final Integer _tmpStatusImpressaoCec;
        if (_cursor.isNull(_cursorIndexOfStatusImpressaoCec)) {
          _tmpStatusImpressaoCec = null;
        } else {
          _tmpStatusImpressaoCec = _cursor.getInt(_cursorIndexOfStatusImpressaoCec);
        }
        _item.setStatusImpressaoCec(_tmpStatusImpressaoCec);
        final String _tmpNomeFormaImpressaoCec;
        _tmpNomeFormaImpressaoCec = _cursor.getString(_cursorIndexOfNomeFormaImpressaoCec);
        _item.setNomeFormaImpressaoCec(_tmpNomeFormaImpressaoCec);
        final String _tmpNomeStatus;
        _tmpNomeStatus = _cursor.getString(_cursorIndexOfNomeStatus);
        _item.setNomeStatus(_tmpNomeStatus);
        final String _tmpNomeStatusImpressaoCec;
        _tmpNomeStatusImpressaoCec = _cursor.getString(_cursorIndexOfNomeStatusImpressaoCec);
        _item.setNomeStatusImpressaoCec(_tmpNomeStatusImpressaoCec);
        final String _tmpFlPrecoAlterado;
        _tmpFlPrecoAlterado = _cursor.getString(_cursorIndexOfFlPrecoAlterado);
        _item.setFlPrecoAlterado(_tmpFlPrecoAlterado);
        final String _tmpNomeTipoPagamento;
        _tmpNomeTipoPagamento = _cursor.getString(_cursorIndexOfNomeTipoPagamento);
        _item.setNomeTipoPagamento(_tmpNomeTipoPagamento);
        final String _tmpCdMotivo;
        _tmpCdMotivo = _cursor.getString(_cursorIndexOfCdMotivo);
        _item.setCdMotivo(_tmpCdMotivo);
        final String _tmpDsMotivo;
        _tmpDsMotivo = _cursor.getString(_cursorIndexOfDsMotivo);
        _item.setDsMotivo(_tmpDsMotivo);
        final String _tmpStatusNfeImp;
        _tmpStatusNfeImp = _cursor.getString(_cursorIndexOfStatusNfeImp);
        _item.setStatusNfeImp(_tmpStatusNfeImp);
        final String _tmpStatusReportFile;
        _tmpStatusReportFile = _cursor.getString(_cursorIndexOfStatusReportFile);
        _item.setStatusReportFile(_tmpStatusReportFile);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Invoice> findInvoiceReport(String numeroViagem) {
    final String _sql = "SELECT * FROM Invoice WHERE numeroViagem = ? ORDER BY numero, cdCustomer";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (numeroViagem == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, numeroViagem);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfNumero = _cursor.getColumnIndexOrThrow("numero");
      final int _cursorIndexOfSerie = _cursor.getColumnIndexOrThrow("serie");
      final int _cursorIndexOfNumeroNotaVOR = _cursor.getColumnIndexOrThrow("numeroNotaVOR");
      final int _cursorIndexOfSerieNotaVOR = _cursor.getColumnIndexOrThrow("serieNotaVOR");
      final int _cursorIndexOfCdPreOrdem = _cursor.getColumnIndexOrThrow("cdPreOrdem");
      final int _cursorIndexOfNumeroFutEntrega = _cursor.getColumnIndexOrThrow("numeroFutEntrega");
      final int _cursorIndexOfCdFiscal = _cursor.getColumnIndexOrThrow("cdFiscal");
      final int _cursorIndexOfCnpjCpfDestino = _cursor.getColumnIndexOrThrow("cnpjCpfDestino");
      final int _cursorIndexOfCnpjCpfTransp = _cursor.getColumnIndexOrThrow("cnpjCpfTransp");
      final int _cursorIndexOfTipoNota = _cursor.getColumnIndexOrThrow("tipoNota");
      final int _cursorIndexOfClasseContribuinte = _cursor.getColumnIndexOrThrow("classeContribuinte");
      final int _cursorIndexOfDataViagemPrincial = _cursor.getColumnIndexOrThrow("dataViagemPrincial");
      final int _cursorIndexOfNumeroViagem = _cursor.getColumnIndexOrThrow("numeroViagem");
      final int _cursorIndexOfDataViagem = _cursor.getColumnIndexOrThrow("dataViagem");
      final int _cursorIndexOfNomeOperacao = _cursor.getColumnIndexOrThrow("nomeOperacao");
      final int _cursorIndexOfDataEmissao = _cursor.getColumnIndexOrThrow("dataEmissao");
      final int _cursorIndexOfDataMovimento = _cursor.getColumnIndexOrThrow("dataMovimento");
      final int _cursorIndexOfDataVencimento = _cursor.getColumnIndexOrThrow("dataVencimento");
      final int _cursorIndexOfValorTotal = _cursor.getColumnIndexOrThrow("valorTotal");
      final int _cursorIndexOfValorLiquido = _cursor.getColumnIndexOrThrow("valorLiquido");
      final int _cursorIndexOfValorTotalProduto = _cursor.getColumnIndexOrThrow("valorTotalProduto");
      final int _cursorIndexOfValorFrete = _cursor.getColumnIndexOrThrow("valorFrete");
      final int _cursorIndexOfValorDespAcessorias = _cursor.getColumnIndexOrThrow("valorDespAcessorias");
      final int _cursorIndexOfValorDinheiro = _cursor.getColumnIndexOrThrow("valorDinheiro");
      final int _cursorIndexOfValorTroco = _cursor.getColumnIndexOrThrow("valorTroco");
      final int _cursorIndexOfValorFatura = _cursor.getColumnIndexOrThrow("valorFatura");
      final int _cursorIndexOfValorDebito = _cursor.getColumnIndexOrThrow("valorDebito");
      final int _cursorIndexOfValorCredito = _cursor.getColumnIndexOrThrow("valorCredito");
      final int _cursorIndexOfValorCheque = _cursor.getColumnIndexOrThrow("valorCheque");
      final int _cursorIndexOfNumeroCheque = _cursor.getColumnIndexOrThrow("numeroCheque");
      final int _cursorIndexOfUfVeiculo = _cursor.getColumnIndexOrThrow("ufVeiculo");
      final int _cursorIndexOfPlacaVeiculo = _cursor.getColumnIndexOrThrow("placaVeiculo");
      final int _cursorIndexOfNumeroVeiculo = _cursor.getColumnIndexOrThrow("numeroVeiculo");
      final int _cursorIndexOfModalidadeFrete = _cursor.getColumnIndexOrThrow("modalidadeFrete");
      final int _cursorIndexOfNomeEspecVolume = _cursor.getColumnIndexOrThrow("nomeEspecVolume");
      final int _cursorIndexOfNomeMarca = _cursor.getColumnIndexOrThrow("nomeMarca");
      final int _cursorIndexOfQtdVolumes = _cursor.getColumnIndexOrThrow("qtdVolumes");
      final int _cursorIndexOfVolumeCapacidade = _cursor.getColumnIndexOrThrow("volumeCapacidade");
      final int _cursorIndexOfVolumeCapacidadeReport = _cursor.getColumnIndexOrThrow("volumeCapacidadeReport");
      final int _cursorIndexOfPesoBruto = _cursor.getColumnIndexOrThrow("pesoBruto");
      final int _cursorIndexOfPesoLiquido = _cursor.getColumnIndexOrThrow("pesoLiquido");
      final int _cursorIndexOfTipoPedido = _cursor.getColumnIndexOrThrow("tipoPedido");
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfAtivaTipoPagto = _cursor.getColumnIndexOrThrow("ativaTipoPagto");
      final int _cursorIndexOfStepEmissao = _cursor.getColumnIndexOrThrow("stepEmissao");
      final int _cursorIndexOfChave = _cursor.getColumnIndexOrThrow("chave");
      final int _cursorIndexOfProtocolo = _cursor.getColumnIndexOrThrow("protocolo");
      final int _cursorIndexOfCdMovimento = _cursor.getColumnIndexOrThrow("cdMovimento");
      final int _cursorIndexOfCondicaoPagamento = _cursor.getColumnIndexOrThrow("condicaoPagamento");
      final int _cursorIndexOfAliquotaIcms = _cursor.getColumnIndexOrThrow("aliquotaIcms");
      final int _cursorIndexOfValorDescontoIcms = _cursor.getColumnIndexOrThrow("valorDescontoIcms");
      final int _cursorIndexOfValorIcms = _cursor.getColumnIndexOrThrow("valorIcms");
      final int _cursorIndexOfBaseCalculoIcms = _cursor.getColumnIndexOrThrow("baseCalculoIcms");
      final int _cursorIndexOfSituacaoTributariaIcms = _cursor.getColumnIndexOrThrow("situacaoTributariaIcms");
      final int _cursorIndexOfValorIpi = _cursor.getColumnIndexOrThrow("valorIpi");
      final int _cursorIndexOfBaseCalculoIpi = _cursor.getColumnIndexOrThrow("baseCalculoIpi");
      final int _cursorIndexOfSituacaoTributariaIpi = _cursor.getColumnIndexOrThrow("situacaoTributariaIpi");
      final int _cursorIndexOfFlNovoFaturamento = _cursor.getColumnIndexOrThrow("flNovoFaturamento");
      final int _cursorIndexOfCdOperadora = _cursor.getColumnIndexOrThrow("cdOperadora");
      final int _cursorIndexOfFlPaciente = _cursor.getColumnIndexOrThrow("flPaciente");
      final int _cursorIndexOfCdCustomerService = _cursor.getColumnIndexOrThrow("cdCustomerService");
      final int _cursorIndexOfNomeAssinadorCec = _cursor.getColumnIndexOrThrow("nomeAssinadorCec");
      final int _cursorIndexOfRgAssinadorCec = _cursor.getColumnIndexOrThrow("rgAssinadorCec");
      final int _cursorIndexOfTipoMovimentoIntegracao = _cursor.getColumnIndexOrThrow("tipoMovimentoIntegracao");
      final int _cursorIndexOfSemPagto = _cursor.getColumnIndexOrThrow("semPagto");
      final int _cursorIndexOfStatusGravacaoJde = _cursor.getColumnIndexOrThrow("statusGravacaoJde");
      final int _cursorIndexOfMensagemGravacaoJde = _cursor.getColumnIndexOrThrow("mensagemGravacaoJde");
      final int _cursorIndexOfTipoTransacao = _cursor.getColumnIndexOrThrow("tipoTransacao");
      final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("status");
      final int _cursorIndexOfStatusContingencia = _cursor.getColumnIndexOrThrow("statusContingencia");
      final int _cursorIndexOfMensagemContingencia = _cursor.getColumnIndexOrThrow("mensagemContingencia");
      final int _cursorIndexOfStatusCec = _cursor.getColumnIndexOrThrow("statusCec");
      final int _cursorIndexOfNomeTransacao = _cursor.getColumnIndexOrThrow("nomeTransacao");
      final int _cursorIndexOfStatusImpressaoCec = _cursor.getColumnIndexOrThrow("statusImpressaoCec");
      final int _cursorIndexOfNomeFormaImpressaoCec = _cursor.getColumnIndexOrThrow("nomeFormaImpressaoCec");
      final int _cursorIndexOfNomeStatus = _cursor.getColumnIndexOrThrow("nomeStatus");
      final int _cursorIndexOfNomeStatusImpressaoCec = _cursor.getColumnIndexOrThrow("nomeStatusImpressaoCec");
      final int _cursorIndexOfFlPrecoAlterado = _cursor.getColumnIndexOrThrow("flPrecoAlterado");
      final int _cursorIndexOfNomeTipoPagamento = _cursor.getColumnIndexOrThrow("nomeTipoPagamento");
      final int _cursorIndexOfCdMotivo = _cursor.getColumnIndexOrThrow("cdMotivo");
      final int _cursorIndexOfDsMotivo = _cursor.getColumnIndexOrThrow("dsMotivo");
      final int _cursorIndexOfStatusNfeImp = _cursor.getColumnIndexOrThrow("statusNfeImp");
      final int _cursorIndexOfStatusReportFile = _cursor.getColumnIndexOrThrow("statusReportFile");
      final List<Invoice> _result = new ArrayList<Invoice>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Invoice _item;
        _item = new Invoice();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final Long _tmpNumero;
        if (_cursor.isNull(_cursorIndexOfNumero)) {
          _tmpNumero = null;
        } else {
          _tmpNumero = _cursor.getLong(_cursorIndexOfNumero);
        }
        _item.setNumero(_tmpNumero);
        final Long _tmpSerie;
        if (_cursor.isNull(_cursorIndexOfSerie)) {
          _tmpSerie = null;
        } else {
          _tmpSerie = _cursor.getLong(_cursorIndexOfSerie);
        }
        _item.setSerie(_tmpSerie);
        final Long _tmpNumeroNotaVOR;
        if (_cursor.isNull(_cursorIndexOfNumeroNotaVOR)) {
          _tmpNumeroNotaVOR = null;
        } else {
          _tmpNumeroNotaVOR = _cursor.getLong(_cursorIndexOfNumeroNotaVOR);
        }
        _item.setNumeroNotaVOR(_tmpNumeroNotaVOR);
        final Long _tmpSerieNotaVOR;
        if (_cursor.isNull(_cursorIndexOfSerieNotaVOR)) {
          _tmpSerieNotaVOR = null;
        } else {
          _tmpSerieNotaVOR = _cursor.getLong(_cursorIndexOfSerieNotaVOR);
        }
        _item.setSerieNotaVOR(_tmpSerieNotaVOR);
        final String _tmpCdPreOrdem;
        _tmpCdPreOrdem = _cursor.getString(_cursorIndexOfCdPreOrdem);
        _item.setCdPreOrdem(_tmpCdPreOrdem);
        final String _tmpNumeroFutEntrega;
        _tmpNumeroFutEntrega = _cursor.getString(_cursorIndexOfNumeroFutEntrega);
        _item.setNumeroFutEntrega(_tmpNumeroFutEntrega);
        final Integer _tmpCdFiscal;
        if (_cursor.isNull(_cursorIndexOfCdFiscal)) {
          _tmpCdFiscal = null;
        } else {
          _tmpCdFiscal = _cursor.getInt(_cursorIndexOfCdFiscal);
        }
        _item.setCdFiscal(_tmpCdFiscal);
        final String _tmpCnpjCpfDestino;
        _tmpCnpjCpfDestino = _cursor.getString(_cursorIndexOfCnpjCpfDestino);
        _item.setCnpjCpfDestino(_tmpCnpjCpfDestino);
        final String _tmpCnpjCpfTransp;
        _tmpCnpjCpfTransp = _cursor.getString(_cursorIndexOfCnpjCpfTransp);
        _item.setCnpjCpfTransp(_tmpCnpjCpfTransp);
        final String _tmpTipoNota;
        _tmpTipoNota = _cursor.getString(_cursorIndexOfTipoNota);
        _item.setTipoNota(_tmpTipoNota);
        final Integer _tmpClasseContribuinte;
        if (_cursor.isNull(_cursorIndexOfClasseContribuinte)) {
          _tmpClasseContribuinte = null;
        } else {
          _tmpClasseContribuinte = _cursor.getInt(_cursorIndexOfClasseContribuinte);
        }
        _item.setClasseContribuinte(_tmpClasseContribuinte);
        final String _tmpDataViagemPrincial;
        _tmpDataViagemPrincial = _cursor.getString(_cursorIndexOfDataViagemPrincial);
        _item.setDataViagemPrincial(_tmpDataViagemPrincial);
        final String _tmpNumeroViagem;
        _tmpNumeroViagem = _cursor.getString(_cursorIndexOfNumeroViagem);
        _item.setNumeroViagem(_tmpNumeroViagem);
        final String _tmpDataViagem;
        _tmpDataViagem = _cursor.getString(_cursorIndexOfDataViagem);
        _item.setDataViagem(_tmpDataViagem);
        final String _tmpNomeOperacao;
        _tmpNomeOperacao = _cursor.getString(_cursorIndexOfNomeOperacao);
        _item.setNomeOperacao(_tmpNomeOperacao);
        final Date _tmpDataEmissao;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfDataEmissao)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfDataEmissao);
        }
        _tmpDataEmissao = DateTypeConverter.fromTimestamp(_tmp);
        _item.setDataEmissao(_tmpDataEmissao);
        final Date _tmpDataMovimento;
        final Long _tmp_1;
        if (_cursor.isNull(_cursorIndexOfDataMovimento)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getLong(_cursorIndexOfDataMovimento);
        }
        _tmpDataMovimento = DateTypeConverter.fromTimestamp(_tmp_1);
        _item.setDataMovimento(_tmpDataMovimento);
        final Date _tmpDataVencimento;
        final Long _tmp_2;
        if (_cursor.isNull(_cursorIndexOfDataVencimento)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getLong(_cursorIndexOfDataVencimento);
        }
        _tmpDataVencimento = DateTypeConverter.fromTimestamp(_tmp_2);
        _item.setDataVencimento(_tmpDataVencimento);
        final Double _tmpValorTotal;
        if (_cursor.isNull(_cursorIndexOfValorTotal)) {
          _tmpValorTotal = null;
        } else {
          _tmpValorTotal = _cursor.getDouble(_cursorIndexOfValorTotal);
        }
        _item.setValorTotal(_tmpValorTotal);
        final Double _tmpValorLiquido;
        if (_cursor.isNull(_cursorIndexOfValorLiquido)) {
          _tmpValorLiquido = null;
        } else {
          _tmpValorLiquido = _cursor.getDouble(_cursorIndexOfValorLiquido);
        }
        _item.setValorLiquido(_tmpValorLiquido);
        final Double _tmpValorTotalProduto;
        if (_cursor.isNull(_cursorIndexOfValorTotalProduto)) {
          _tmpValorTotalProduto = null;
        } else {
          _tmpValorTotalProduto = _cursor.getDouble(_cursorIndexOfValorTotalProduto);
        }
        _item.setValorTotalProduto(_tmpValorTotalProduto);
        final Double _tmpValorFrete;
        if (_cursor.isNull(_cursorIndexOfValorFrete)) {
          _tmpValorFrete = null;
        } else {
          _tmpValorFrete = _cursor.getDouble(_cursorIndexOfValorFrete);
        }
        _item.setValorFrete(_tmpValorFrete);
        final Double _tmpValorDespAcessorias;
        if (_cursor.isNull(_cursorIndexOfValorDespAcessorias)) {
          _tmpValorDespAcessorias = null;
        } else {
          _tmpValorDespAcessorias = _cursor.getDouble(_cursorIndexOfValorDespAcessorias);
        }
        _item.setValorDespAcessorias(_tmpValorDespAcessorias);
        final Double _tmpValorDinheiro;
        if (_cursor.isNull(_cursorIndexOfValorDinheiro)) {
          _tmpValorDinheiro = null;
        } else {
          _tmpValorDinheiro = _cursor.getDouble(_cursorIndexOfValorDinheiro);
        }
        _item.setValorDinheiro(_tmpValorDinheiro);
        final Double _tmpValorTroco;
        if (_cursor.isNull(_cursorIndexOfValorTroco)) {
          _tmpValorTroco = null;
        } else {
          _tmpValorTroco = _cursor.getDouble(_cursorIndexOfValorTroco);
        }
        _item.setValorTroco(_tmpValorTroco);
        final Double _tmpValorFatura;
        if (_cursor.isNull(_cursorIndexOfValorFatura)) {
          _tmpValorFatura = null;
        } else {
          _tmpValorFatura = _cursor.getDouble(_cursorIndexOfValorFatura);
        }
        _item.setValorFatura(_tmpValorFatura);
        final Double _tmpValorDebito;
        if (_cursor.isNull(_cursorIndexOfValorDebito)) {
          _tmpValorDebito = null;
        } else {
          _tmpValorDebito = _cursor.getDouble(_cursorIndexOfValorDebito);
        }
        _item.setValorDebito(_tmpValorDebito);
        final Double _tmpValorCredito;
        if (_cursor.isNull(_cursorIndexOfValorCredito)) {
          _tmpValorCredito = null;
        } else {
          _tmpValorCredito = _cursor.getDouble(_cursorIndexOfValorCredito);
        }
        _item.setValorCredito(_tmpValorCredito);
        final Double _tmpValorCheque;
        if (_cursor.isNull(_cursorIndexOfValorCheque)) {
          _tmpValorCheque = null;
        } else {
          _tmpValorCheque = _cursor.getDouble(_cursorIndexOfValorCheque);
        }
        _item.setValorCheque(_tmpValorCheque);
        final String _tmpNumeroCheque;
        _tmpNumeroCheque = _cursor.getString(_cursorIndexOfNumeroCheque);
        _item.setNumeroCheque(_tmpNumeroCheque);
        final String _tmpUfVeiculo;
        _tmpUfVeiculo = _cursor.getString(_cursorIndexOfUfVeiculo);
        _item.setUfVeiculo(_tmpUfVeiculo);
        final String _tmpPlacaVeiculo;
        _tmpPlacaVeiculo = _cursor.getString(_cursorIndexOfPlacaVeiculo);
        _item.setPlacaVeiculo(_tmpPlacaVeiculo);
        final String _tmpNumeroVeiculo;
        _tmpNumeroVeiculo = _cursor.getString(_cursorIndexOfNumeroVeiculo);
        _item.setNumeroVeiculo(_tmpNumeroVeiculo);
        final Integer _tmpModalidadeFrete;
        if (_cursor.isNull(_cursorIndexOfModalidadeFrete)) {
          _tmpModalidadeFrete = null;
        } else {
          _tmpModalidadeFrete = _cursor.getInt(_cursorIndexOfModalidadeFrete);
        }
        _item.setModalidadeFrete(_tmpModalidadeFrete);
        final String _tmpNomeEspecVolume;
        _tmpNomeEspecVolume = _cursor.getString(_cursorIndexOfNomeEspecVolume);
        _item.setNomeEspecVolume(_tmpNomeEspecVolume);
        final String _tmpNomeMarca;
        _tmpNomeMarca = _cursor.getString(_cursorIndexOfNomeMarca);
        _item.setNomeMarca(_tmpNomeMarca);
        final Integer _tmpQtdVolumes;
        if (_cursor.isNull(_cursorIndexOfQtdVolumes)) {
          _tmpQtdVolumes = null;
        } else {
          _tmpQtdVolumes = _cursor.getInt(_cursorIndexOfQtdVolumes);
        }
        _item.setQtdVolumes(_tmpQtdVolumes);
        final Double _tmpVolumeCapacidade;
        if (_cursor.isNull(_cursorIndexOfVolumeCapacidade)) {
          _tmpVolumeCapacidade = null;
        } else {
          _tmpVolumeCapacidade = _cursor.getDouble(_cursorIndexOfVolumeCapacidade);
        }
        _item.setVolumeCapacidade(_tmpVolumeCapacidade);
        final Double _tmpVolumeCapacidadeReport;
        if (_cursor.isNull(_cursorIndexOfVolumeCapacidadeReport)) {
          _tmpVolumeCapacidadeReport = null;
        } else {
          _tmpVolumeCapacidadeReport = _cursor.getDouble(_cursorIndexOfVolumeCapacidadeReport);
        }
        _item.setVolumeCapacidadeReport(_tmpVolumeCapacidadeReport);
        final Double _tmpPesoBruto;
        if (_cursor.isNull(_cursorIndexOfPesoBruto)) {
          _tmpPesoBruto = null;
        } else {
          _tmpPesoBruto = _cursor.getDouble(_cursorIndexOfPesoBruto);
        }
        _item.setPesoBruto(_tmpPesoBruto);
        final Double _tmpPesoLiquido;
        if (_cursor.isNull(_cursorIndexOfPesoLiquido)) {
          _tmpPesoLiquido = null;
        } else {
          _tmpPesoLiquido = _cursor.getDouble(_cursorIndexOfPesoLiquido);
        }
        _item.setPesoLiquido(_tmpPesoLiquido);
        final String _tmpTipoPedido;
        _tmpTipoPedido = _cursor.getString(_cursorIndexOfTipoPedido);
        _item.setTipoPedido(_tmpTipoPedido);
        final Long _tmpCdCustomer;
        if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
          _tmpCdCustomer = null;
        } else {
          _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
        }
        _item.setCdCustomer(_tmpCdCustomer);
        final String _tmpAtivaTipoPagto;
        _tmpAtivaTipoPagto = _cursor.getString(_cursorIndexOfAtivaTipoPagto);
        _item.setAtivaTipoPagto(_tmpAtivaTipoPagto);
        final Integer _tmpStepEmissao;
        if (_cursor.isNull(_cursorIndexOfStepEmissao)) {
          _tmpStepEmissao = null;
        } else {
          _tmpStepEmissao = _cursor.getInt(_cursorIndexOfStepEmissao);
        }
        _item.setStepEmissao(_tmpStepEmissao);
        final String _tmpChave;
        _tmpChave = _cursor.getString(_cursorIndexOfChave);
        _item.setChave(_tmpChave);
        final String _tmpProtocolo;
        _tmpProtocolo = _cursor.getString(_cursorIndexOfProtocolo);
        _item.setProtocolo(_tmpProtocolo);
        final String _tmpCdMovimento;
        _tmpCdMovimento = _cursor.getString(_cursorIndexOfCdMovimento);
        _item.setCdMovimento(_tmpCdMovimento);
        final String _tmpCondicaoPagamento;
        _tmpCondicaoPagamento = _cursor.getString(_cursorIndexOfCondicaoPagamento);
        _item.setCondicaoPagamento(_tmpCondicaoPagamento);
        final Double _tmpAliquotaIcms;
        if (_cursor.isNull(_cursorIndexOfAliquotaIcms)) {
          _tmpAliquotaIcms = null;
        } else {
          _tmpAliquotaIcms = _cursor.getDouble(_cursorIndexOfAliquotaIcms);
        }
        _item.setAliquotaIcms(_tmpAliquotaIcms);
        final Double _tmpValorDescontoIcms;
        if (_cursor.isNull(_cursorIndexOfValorDescontoIcms)) {
          _tmpValorDescontoIcms = null;
        } else {
          _tmpValorDescontoIcms = _cursor.getDouble(_cursorIndexOfValorDescontoIcms);
        }
        _item.setValorDescontoIcms(_tmpValorDescontoIcms);
        final Double _tmpValorIcms;
        if (_cursor.isNull(_cursorIndexOfValorIcms)) {
          _tmpValorIcms = null;
        } else {
          _tmpValorIcms = _cursor.getDouble(_cursorIndexOfValorIcms);
        }
        _item.setValorIcms(_tmpValorIcms);
        final Double _tmpBaseCalculoIcms;
        if (_cursor.isNull(_cursorIndexOfBaseCalculoIcms)) {
          _tmpBaseCalculoIcms = null;
        } else {
          _tmpBaseCalculoIcms = _cursor.getDouble(_cursorIndexOfBaseCalculoIcms);
        }
        _item.setBaseCalculoIcms(_tmpBaseCalculoIcms);
        final Integer _tmpSituacaoTributariaIcms;
        if (_cursor.isNull(_cursorIndexOfSituacaoTributariaIcms)) {
          _tmpSituacaoTributariaIcms = null;
        } else {
          _tmpSituacaoTributariaIcms = _cursor.getInt(_cursorIndexOfSituacaoTributariaIcms);
        }
        _item.setSituacaoTributariaIcms(_tmpSituacaoTributariaIcms);
        final Double _tmpValorIpi;
        if (_cursor.isNull(_cursorIndexOfValorIpi)) {
          _tmpValorIpi = null;
        } else {
          _tmpValorIpi = _cursor.getDouble(_cursorIndexOfValorIpi);
        }
        _item.setValorIpi(_tmpValorIpi);
        final Double _tmpBaseCalculoIpi;
        if (_cursor.isNull(_cursorIndexOfBaseCalculoIpi)) {
          _tmpBaseCalculoIpi = null;
        } else {
          _tmpBaseCalculoIpi = _cursor.getDouble(_cursorIndexOfBaseCalculoIpi);
        }
        _item.setBaseCalculoIpi(_tmpBaseCalculoIpi);
        final Integer _tmpSituacaoTributariaIpi;
        if (_cursor.isNull(_cursorIndexOfSituacaoTributariaIpi)) {
          _tmpSituacaoTributariaIpi = null;
        } else {
          _tmpSituacaoTributariaIpi = _cursor.getInt(_cursorIndexOfSituacaoTributariaIpi);
        }
        _item.setSituacaoTributariaIpi(_tmpSituacaoTributariaIpi);
        final String _tmpFlNovoFaturamento;
        _tmpFlNovoFaturamento = _cursor.getString(_cursorIndexOfFlNovoFaturamento);
        _item.setFlNovoFaturamento(_tmpFlNovoFaturamento);
        final Long _tmpCdOperadora;
        if (_cursor.isNull(_cursorIndexOfCdOperadora)) {
          _tmpCdOperadora = null;
        } else {
          _tmpCdOperadora = _cursor.getLong(_cursorIndexOfCdOperadora);
        }
        _item.setCdOperadora(_tmpCdOperadora);
        final String _tmpFlPaciente;
        _tmpFlPaciente = _cursor.getString(_cursorIndexOfFlPaciente);
        _item.setFlPaciente(_tmpFlPaciente);
        final Long _tmpCdCustomerService;
        if (_cursor.isNull(_cursorIndexOfCdCustomerService)) {
          _tmpCdCustomerService = null;
        } else {
          _tmpCdCustomerService = _cursor.getLong(_cursorIndexOfCdCustomerService);
        }
        _item.setCdCustomerService(_tmpCdCustomerService);
        final String _tmpNomeAssinadorCec;
        _tmpNomeAssinadorCec = _cursor.getString(_cursorIndexOfNomeAssinadorCec);
        _item.setNomeAssinadorCec(_tmpNomeAssinadorCec);
        final String _tmpRgAssinadorCec;
        _tmpRgAssinadorCec = _cursor.getString(_cursorIndexOfRgAssinadorCec);
        _item.setRgAssinadorCec(_tmpRgAssinadorCec);
        final Integer _tmpTipoMovimentoIntegracao;
        if (_cursor.isNull(_cursorIndexOfTipoMovimentoIntegracao)) {
          _tmpTipoMovimentoIntegracao = null;
        } else {
          _tmpTipoMovimentoIntegracao = _cursor.getInt(_cursorIndexOfTipoMovimentoIntegracao);
        }
        _item.setTipoMovimentoIntegracao(_tmpTipoMovimentoIntegracao);
        final String _tmpSemPagto;
        _tmpSemPagto = _cursor.getString(_cursorIndexOfSemPagto);
        _item.setSemPagto(_tmpSemPagto);
        final Integer _tmpStatusGravacaoJde;
        if (_cursor.isNull(_cursorIndexOfStatusGravacaoJde)) {
          _tmpStatusGravacaoJde = null;
        } else {
          _tmpStatusGravacaoJde = _cursor.getInt(_cursorIndexOfStatusGravacaoJde);
        }
        _item.setStatusGravacaoJde(_tmpStatusGravacaoJde);
        final String _tmpMensagemGravacaoJde;
        _tmpMensagemGravacaoJde = _cursor.getString(_cursorIndexOfMensagemGravacaoJde);
        _item.setMensagemGravacaoJde(_tmpMensagemGravacaoJde);
        final Integer _tmpTipoTransacao;
        if (_cursor.isNull(_cursorIndexOfTipoTransacao)) {
          _tmpTipoTransacao = null;
        } else {
          _tmpTipoTransacao = _cursor.getInt(_cursorIndexOfTipoTransacao);
        }
        _item.setTipoTransacao(_tmpTipoTransacao);
        final Integer _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
        }
        _item.setStatus(_tmpStatus);
        final String _tmpStatusContingencia;
        _tmpStatusContingencia = _cursor.getString(_cursorIndexOfStatusContingencia);
        _item.setStatusContingencia(_tmpStatusContingencia);
        final String _tmpMensagemContingencia;
        _tmpMensagemContingencia = _cursor.getString(_cursorIndexOfMensagemContingencia);
        _item.setMensagemContingencia(_tmpMensagemContingencia);
        final Integer _tmpStatusCec;
        if (_cursor.isNull(_cursorIndexOfStatusCec)) {
          _tmpStatusCec = null;
        } else {
          _tmpStatusCec = _cursor.getInt(_cursorIndexOfStatusCec);
        }
        _item.setStatusCec(_tmpStatusCec);
        final String _tmpNomeTransacao;
        _tmpNomeTransacao = _cursor.getString(_cursorIndexOfNomeTransacao);
        _item.setNomeTransacao(_tmpNomeTransacao);
        final Integer _tmpStatusImpressaoCec;
        if (_cursor.isNull(_cursorIndexOfStatusImpressaoCec)) {
          _tmpStatusImpressaoCec = null;
        } else {
          _tmpStatusImpressaoCec = _cursor.getInt(_cursorIndexOfStatusImpressaoCec);
        }
        _item.setStatusImpressaoCec(_tmpStatusImpressaoCec);
        final String _tmpNomeFormaImpressaoCec;
        _tmpNomeFormaImpressaoCec = _cursor.getString(_cursorIndexOfNomeFormaImpressaoCec);
        _item.setNomeFormaImpressaoCec(_tmpNomeFormaImpressaoCec);
        final String _tmpNomeStatus;
        _tmpNomeStatus = _cursor.getString(_cursorIndexOfNomeStatus);
        _item.setNomeStatus(_tmpNomeStatus);
        final String _tmpNomeStatusImpressaoCec;
        _tmpNomeStatusImpressaoCec = _cursor.getString(_cursorIndexOfNomeStatusImpressaoCec);
        _item.setNomeStatusImpressaoCec(_tmpNomeStatusImpressaoCec);
        final String _tmpFlPrecoAlterado;
        _tmpFlPrecoAlterado = _cursor.getString(_cursorIndexOfFlPrecoAlterado);
        _item.setFlPrecoAlterado(_tmpFlPrecoAlterado);
        final String _tmpNomeTipoPagamento;
        _tmpNomeTipoPagamento = _cursor.getString(_cursorIndexOfNomeTipoPagamento);
        _item.setNomeTipoPagamento(_tmpNomeTipoPagamento);
        final String _tmpCdMotivo;
        _tmpCdMotivo = _cursor.getString(_cursorIndexOfCdMotivo);
        _item.setCdMotivo(_tmpCdMotivo);
        final String _tmpDsMotivo;
        _tmpDsMotivo = _cursor.getString(_cursorIndexOfDsMotivo);
        _item.setDsMotivo(_tmpDsMotivo);
        final String _tmpStatusNfeImp;
        _tmpStatusNfeImp = _cursor.getString(_cursorIndexOfStatusNfeImp);
        _item.setStatusNfeImp(_tmpStatusNfeImp);
        final String _tmpStatusReportFile;
        _tmpStatusReportFile = _cursor.getString(_cursorIndexOfStatusReportFile);
        _item.setStatusReportFile(_tmpStatusReportFile);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Invoice findById(Long id) {
    final String _sql = "SELECT * FROM Invoice WHERE id = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, id);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfNumero = _cursor.getColumnIndexOrThrow("numero");
      final int _cursorIndexOfSerie = _cursor.getColumnIndexOrThrow("serie");
      final int _cursorIndexOfNumeroNotaVOR = _cursor.getColumnIndexOrThrow("numeroNotaVOR");
      final int _cursorIndexOfSerieNotaVOR = _cursor.getColumnIndexOrThrow("serieNotaVOR");
      final int _cursorIndexOfCdPreOrdem = _cursor.getColumnIndexOrThrow("cdPreOrdem");
      final int _cursorIndexOfNumeroFutEntrega = _cursor.getColumnIndexOrThrow("numeroFutEntrega");
      final int _cursorIndexOfCdFiscal = _cursor.getColumnIndexOrThrow("cdFiscal");
      final int _cursorIndexOfCnpjCpfDestino = _cursor.getColumnIndexOrThrow("cnpjCpfDestino");
      final int _cursorIndexOfCnpjCpfTransp = _cursor.getColumnIndexOrThrow("cnpjCpfTransp");
      final int _cursorIndexOfTipoNota = _cursor.getColumnIndexOrThrow("tipoNota");
      final int _cursorIndexOfClasseContribuinte = _cursor.getColumnIndexOrThrow("classeContribuinte");
      final int _cursorIndexOfDataViagemPrincial = _cursor.getColumnIndexOrThrow("dataViagemPrincial");
      final int _cursorIndexOfNumeroViagem = _cursor.getColumnIndexOrThrow("numeroViagem");
      final int _cursorIndexOfDataViagem = _cursor.getColumnIndexOrThrow("dataViagem");
      final int _cursorIndexOfNomeOperacao = _cursor.getColumnIndexOrThrow("nomeOperacao");
      final int _cursorIndexOfDataEmissao = _cursor.getColumnIndexOrThrow("dataEmissao");
      final int _cursorIndexOfDataMovimento = _cursor.getColumnIndexOrThrow("dataMovimento");
      final int _cursorIndexOfDataVencimento = _cursor.getColumnIndexOrThrow("dataVencimento");
      final int _cursorIndexOfValorTotal = _cursor.getColumnIndexOrThrow("valorTotal");
      final int _cursorIndexOfValorLiquido = _cursor.getColumnIndexOrThrow("valorLiquido");
      final int _cursorIndexOfValorTotalProduto = _cursor.getColumnIndexOrThrow("valorTotalProduto");
      final int _cursorIndexOfValorFrete = _cursor.getColumnIndexOrThrow("valorFrete");
      final int _cursorIndexOfValorDespAcessorias = _cursor.getColumnIndexOrThrow("valorDespAcessorias");
      final int _cursorIndexOfValorDinheiro = _cursor.getColumnIndexOrThrow("valorDinheiro");
      final int _cursorIndexOfValorTroco = _cursor.getColumnIndexOrThrow("valorTroco");
      final int _cursorIndexOfValorFatura = _cursor.getColumnIndexOrThrow("valorFatura");
      final int _cursorIndexOfValorDebito = _cursor.getColumnIndexOrThrow("valorDebito");
      final int _cursorIndexOfValorCredito = _cursor.getColumnIndexOrThrow("valorCredito");
      final int _cursorIndexOfValorCheque = _cursor.getColumnIndexOrThrow("valorCheque");
      final int _cursorIndexOfNumeroCheque = _cursor.getColumnIndexOrThrow("numeroCheque");
      final int _cursorIndexOfUfVeiculo = _cursor.getColumnIndexOrThrow("ufVeiculo");
      final int _cursorIndexOfPlacaVeiculo = _cursor.getColumnIndexOrThrow("placaVeiculo");
      final int _cursorIndexOfNumeroVeiculo = _cursor.getColumnIndexOrThrow("numeroVeiculo");
      final int _cursorIndexOfModalidadeFrete = _cursor.getColumnIndexOrThrow("modalidadeFrete");
      final int _cursorIndexOfNomeEspecVolume = _cursor.getColumnIndexOrThrow("nomeEspecVolume");
      final int _cursorIndexOfNomeMarca = _cursor.getColumnIndexOrThrow("nomeMarca");
      final int _cursorIndexOfQtdVolumes = _cursor.getColumnIndexOrThrow("qtdVolumes");
      final int _cursorIndexOfVolumeCapacidade = _cursor.getColumnIndexOrThrow("volumeCapacidade");
      final int _cursorIndexOfVolumeCapacidadeReport = _cursor.getColumnIndexOrThrow("volumeCapacidadeReport");
      final int _cursorIndexOfPesoBruto = _cursor.getColumnIndexOrThrow("pesoBruto");
      final int _cursorIndexOfPesoLiquido = _cursor.getColumnIndexOrThrow("pesoLiquido");
      final int _cursorIndexOfTipoPedido = _cursor.getColumnIndexOrThrow("tipoPedido");
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfAtivaTipoPagto = _cursor.getColumnIndexOrThrow("ativaTipoPagto");
      final int _cursorIndexOfStepEmissao = _cursor.getColumnIndexOrThrow("stepEmissao");
      final int _cursorIndexOfChave = _cursor.getColumnIndexOrThrow("chave");
      final int _cursorIndexOfProtocolo = _cursor.getColumnIndexOrThrow("protocolo");
      final int _cursorIndexOfCdMovimento = _cursor.getColumnIndexOrThrow("cdMovimento");
      final int _cursorIndexOfCondicaoPagamento = _cursor.getColumnIndexOrThrow("condicaoPagamento");
      final int _cursorIndexOfAliquotaIcms = _cursor.getColumnIndexOrThrow("aliquotaIcms");
      final int _cursorIndexOfValorDescontoIcms = _cursor.getColumnIndexOrThrow("valorDescontoIcms");
      final int _cursorIndexOfValorIcms = _cursor.getColumnIndexOrThrow("valorIcms");
      final int _cursorIndexOfBaseCalculoIcms = _cursor.getColumnIndexOrThrow("baseCalculoIcms");
      final int _cursorIndexOfSituacaoTributariaIcms = _cursor.getColumnIndexOrThrow("situacaoTributariaIcms");
      final int _cursorIndexOfValorIpi = _cursor.getColumnIndexOrThrow("valorIpi");
      final int _cursorIndexOfBaseCalculoIpi = _cursor.getColumnIndexOrThrow("baseCalculoIpi");
      final int _cursorIndexOfSituacaoTributariaIpi = _cursor.getColumnIndexOrThrow("situacaoTributariaIpi");
      final int _cursorIndexOfFlNovoFaturamento = _cursor.getColumnIndexOrThrow("flNovoFaturamento");
      final int _cursorIndexOfCdOperadora = _cursor.getColumnIndexOrThrow("cdOperadora");
      final int _cursorIndexOfFlPaciente = _cursor.getColumnIndexOrThrow("flPaciente");
      final int _cursorIndexOfCdCustomerService = _cursor.getColumnIndexOrThrow("cdCustomerService");
      final int _cursorIndexOfNomeAssinadorCec = _cursor.getColumnIndexOrThrow("nomeAssinadorCec");
      final int _cursorIndexOfRgAssinadorCec = _cursor.getColumnIndexOrThrow("rgAssinadorCec");
      final int _cursorIndexOfTipoMovimentoIntegracao = _cursor.getColumnIndexOrThrow("tipoMovimentoIntegracao");
      final int _cursorIndexOfSemPagto = _cursor.getColumnIndexOrThrow("semPagto");
      final int _cursorIndexOfStatusGravacaoJde = _cursor.getColumnIndexOrThrow("statusGravacaoJde");
      final int _cursorIndexOfMensagemGravacaoJde = _cursor.getColumnIndexOrThrow("mensagemGravacaoJde");
      final int _cursorIndexOfTipoTransacao = _cursor.getColumnIndexOrThrow("tipoTransacao");
      final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("status");
      final int _cursorIndexOfStatusContingencia = _cursor.getColumnIndexOrThrow("statusContingencia");
      final int _cursorIndexOfMensagemContingencia = _cursor.getColumnIndexOrThrow("mensagemContingencia");
      final int _cursorIndexOfStatusCec = _cursor.getColumnIndexOrThrow("statusCec");
      final int _cursorIndexOfNomeTransacao = _cursor.getColumnIndexOrThrow("nomeTransacao");
      final int _cursorIndexOfStatusImpressaoCec = _cursor.getColumnIndexOrThrow("statusImpressaoCec");
      final int _cursorIndexOfNomeFormaImpressaoCec = _cursor.getColumnIndexOrThrow("nomeFormaImpressaoCec");
      final int _cursorIndexOfNomeStatus = _cursor.getColumnIndexOrThrow("nomeStatus");
      final int _cursorIndexOfNomeStatusImpressaoCec = _cursor.getColumnIndexOrThrow("nomeStatusImpressaoCec");
      final int _cursorIndexOfFlPrecoAlterado = _cursor.getColumnIndexOrThrow("flPrecoAlterado");
      final int _cursorIndexOfNomeTipoPagamento = _cursor.getColumnIndexOrThrow("nomeTipoPagamento");
      final int _cursorIndexOfCdMotivo = _cursor.getColumnIndexOrThrow("cdMotivo");
      final int _cursorIndexOfDsMotivo = _cursor.getColumnIndexOrThrow("dsMotivo");
      final int _cursorIndexOfStatusNfeImp = _cursor.getColumnIndexOrThrow("statusNfeImp");
      final int _cursorIndexOfStatusReportFile = _cursor.getColumnIndexOrThrow("statusReportFile");
      final Invoice _result;
      if(_cursor.moveToFirst()) {
        _result = new Invoice();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _result.setId(_tmpId);
        final Long _tmpNumero;
        if (_cursor.isNull(_cursorIndexOfNumero)) {
          _tmpNumero = null;
        } else {
          _tmpNumero = _cursor.getLong(_cursorIndexOfNumero);
        }
        _result.setNumero(_tmpNumero);
        final Long _tmpSerie;
        if (_cursor.isNull(_cursorIndexOfSerie)) {
          _tmpSerie = null;
        } else {
          _tmpSerie = _cursor.getLong(_cursorIndexOfSerie);
        }
        _result.setSerie(_tmpSerie);
        final Long _tmpNumeroNotaVOR;
        if (_cursor.isNull(_cursorIndexOfNumeroNotaVOR)) {
          _tmpNumeroNotaVOR = null;
        } else {
          _tmpNumeroNotaVOR = _cursor.getLong(_cursorIndexOfNumeroNotaVOR);
        }
        _result.setNumeroNotaVOR(_tmpNumeroNotaVOR);
        final Long _tmpSerieNotaVOR;
        if (_cursor.isNull(_cursorIndexOfSerieNotaVOR)) {
          _tmpSerieNotaVOR = null;
        } else {
          _tmpSerieNotaVOR = _cursor.getLong(_cursorIndexOfSerieNotaVOR);
        }
        _result.setSerieNotaVOR(_tmpSerieNotaVOR);
        final String _tmpCdPreOrdem;
        _tmpCdPreOrdem = _cursor.getString(_cursorIndexOfCdPreOrdem);
        _result.setCdPreOrdem(_tmpCdPreOrdem);
        final String _tmpNumeroFutEntrega;
        _tmpNumeroFutEntrega = _cursor.getString(_cursorIndexOfNumeroFutEntrega);
        _result.setNumeroFutEntrega(_tmpNumeroFutEntrega);
        final Integer _tmpCdFiscal;
        if (_cursor.isNull(_cursorIndexOfCdFiscal)) {
          _tmpCdFiscal = null;
        } else {
          _tmpCdFiscal = _cursor.getInt(_cursorIndexOfCdFiscal);
        }
        _result.setCdFiscal(_tmpCdFiscal);
        final String _tmpCnpjCpfDestino;
        _tmpCnpjCpfDestino = _cursor.getString(_cursorIndexOfCnpjCpfDestino);
        _result.setCnpjCpfDestino(_tmpCnpjCpfDestino);
        final String _tmpCnpjCpfTransp;
        _tmpCnpjCpfTransp = _cursor.getString(_cursorIndexOfCnpjCpfTransp);
        _result.setCnpjCpfTransp(_tmpCnpjCpfTransp);
        final String _tmpTipoNota;
        _tmpTipoNota = _cursor.getString(_cursorIndexOfTipoNota);
        _result.setTipoNota(_tmpTipoNota);
        final Integer _tmpClasseContribuinte;
        if (_cursor.isNull(_cursorIndexOfClasseContribuinte)) {
          _tmpClasseContribuinte = null;
        } else {
          _tmpClasseContribuinte = _cursor.getInt(_cursorIndexOfClasseContribuinte);
        }
        _result.setClasseContribuinte(_tmpClasseContribuinte);
        final String _tmpDataViagemPrincial;
        _tmpDataViagemPrincial = _cursor.getString(_cursorIndexOfDataViagemPrincial);
        _result.setDataViagemPrincial(_tmpDataViagemPrincial);
        final String _tmpNumeroViagem;
        _tmpNumeroViagem = _cursor.getString(_cursorIndexOfNumeroViagem);
        _result.setNumeroViagem(_tmpNumeroViagem);
        final String _tmpDataViagem;
        _tmpDataViagem = _cursor.getString(_cursorIndexOfDataViagem);
        _result.setDataViagem(_tmpDataViagem);
        final String _tmpNomeOperacao;
        _tmpNomeOperacao = _cursor.getString(_cursorIndexOfNomeOperacao);
        _result.setNomeOperacao(_tmpNomeOperacao);
        final Date _tmpDataEmissao;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfDataEmissao)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfDataEmissao);
        }
        _tmpDataEmissao = DateTypeConverter.fromTimestamp(_tmp);
        _result.setDataEmissao(_tmpDataEmissao);
        final Date _tmpDataMovimento;
        final Long _tmp_1;
        if (_cursor.isNull(_cursorIndexOfDataMovimento)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getLong(_cursorIndexOfDataMovimento);
        }
        _tmpDataMovimento = DateTypeConverter.fromTimestamp(_tmp_1);
        _result.setDataMovimento(_tmpDataMovimento);
        final Date _tmpDataVencimento;
        final Long _tmp_2;
        if (_cursor.isNull(_cursorIndexOfDataVencimento)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getLong(_cursorIndexOfDataVencimento);
        }
        _tmpDataVencimento = DateTypeConverter.fromTimestamp(_tmp_2);
        _result.setDataVencimento(_tmpDataVencimento);
        final Double _tmpValorTotal;
        if (_cursor.isNull(_cursorIndexOfValorTotal)) {
          _tmpValorTotal = null;
        } else {
          _tmpValorTotal = _cursor.getDouble(_cursorIndexOfValorTotal);
        }
        _result.setValorTotal(_tmpValorTotal);
        final Double _tmpValorLiquido;
        if (_cursor.isNull(_cursorIndexOfValorLiquido)) {
          _tmpValorLiquido = null;
        } else {
          _tmpValorLiquido = _cursor.getDouble(_cursorIndexOfValorLiquido);
        }
        _result.setValorLiquido(_tmpValorLiquido);
        final Double _tmpValorTotalProduto;
        if (_cursor.isNull(_cursorIndexOfValorTotalProduto)) {
          _tmpValorTotalProduto = null;
        } else {
          _tmpValorTotalProduto = _cursor.getDouble(_cursorIndexOfValorTotalProduto);
        }
        _result.setValorTotalProduto(_tmpValorTotalProduto);
        final Double _tmpValorFrete;
        if (_cursor.isNull(_cursorIndexOfValorFrete)) {
          _tmpValorFrete = null;
        } else {
          _tmpValorFrete = _cursor.getDouble(_cursorIndexOfValorFrete);
        }
        _result.setValorFrete(_tmpValorFrete);
        final Double _tmpValorDespAcessorias;
        if (_cursor.isNull(_cursorIndexOfValorDespAcessorias)) {
          _tmpValorDespAcessorias = null;
        } else {
          _tmpValorDespAcessorias = _cursor.getDouble(_cursorIndexOfValorDespAcessorias);
        }
        _result.setValorDespAcessorias(_tmpValorDespAcessorias);
        final Double _tmpValorDinheiro;
        if (_cursor.isNull(_cursorIndexOfValorDinheiro)) {
          _tmpValorDinheiro = null;
        } else {
          _tmpValorDinheiro = _cursor.getDouble(_cursorIndexOfValorDinheiro);
        }
        _result.setValorDinheiro(_tmpValorDinheiro);
        final Double _tmpValorTroco;
        if (_cursor.isNull(_cursorIndexOfValorTroco)) {
          _tmpValorTroco = null;
        } else {
          _tmpValorTroco = _cursor.getDouble(_cursorIndexOfValorTroco);
        }
        _result.setValorTroco(_tmpValorTroco);
        final Double _tmpValorFatura;
        if (_cursor.isNull(_cursorIndexOfValorFatura)) {
          _tmpValorFatura = null;
        } else {
          _tmpValorFatura = _cursor.getDouble(_cursorIndexOfValorFatura);
        }
        _result.setValorFatura(_tmpValorFatura);
        final Double _tmpValorDebito;
        if (_cursor.isNull(_cursorIndexOfValorDebito)) {
          _tmpValorDebito = null;
        } else {
          _tmpValorDebito = _cursor.getDouble(_cursorIndexOfValorDebito);
        }
        _result.setValorDebito(_tmpValorDebito);
        final Double _tmpValorCredito;
        if (_cursor.isNull(_cursorIndexOfValorCredito)) {
          _tmpValorCredito = null;
        } else {
          _tmpValorCredito = _cursor.getDouble(_cursorIndexOfValorCredito);
        }
        _result.setValorCredito(_tmpValorCredito);
        final Double _tmpValorCheque;
        if (_cursor.isNull(_cursorIndexOfValorCheque)) {
          _tmpValorCheque = null;
        } else {
          _tmpValorCheque = _cursor.getDouble(_cursorIndexOfValorCheque);
        }
        _result.setValorCheque(_tmpValorCheque);
        final String _tmpNumeroCheque;
        _tmpNumeroCheque = _cursor.getString(_cursorIndexOfNumeroCheque);
        _result.setNumeroCheque(_tmpNumeroCheque);
        final String _tmpUfVeiculo;
        _tmpUfVeiculo = _cursor.getString(_cursorIndexOfUfVeiculo);
        _result.setUfVeiculo(_tmpUfVeiculo);
        final String _tmpPlacaVeiculo;
        _tmpPlacaVeiculo = _cursor.getString(_cursorIndexOfPlacaVeiculo);
        _result.setPlacaVeiculo(_tmpPlacaVeiculo);
        final String _tmpNumeroVeiculo;
        _tmpNumeroVeiculo = _cursor.getString(_cursorIndexOfNumeroVeiculo);
        _result.setNumeroVeiculo(_tmpNumeroVeiculo);
        final Integer _tmpModalidadeFrete;
        if (_cursor.isNull(_cursorIndexOfModalidadeFrete)) {
          _tmpModalidadeFrete = null;
        } else {
          _tmpModalidadeFrete = _cursor.getInt(_cursorIndexOfModalidadeFrete);
        }
        _result.setModalidadeFrete(_tmpModalidadeFrete);
        final String _tmpNomeEspecVolume;
        _tmpNomeEspecVolume = _cursor.getString(_cursorIndexOfNomeEspecVolume);
        _result.setNomeEspecVolume(_tmpNomeEspecVolume);
        final String _tmpNomeMarca;
        _tmpNomeMarca = _cursor.getString(_cursorIndexOfNomeMarca);
        _result.setNomeMarca(_tmpNomeMarca);
        final Integer _tmpQtdVolumes;
        if (_cursor.isNull(_cursorIndexOfQtdVolumes)) {
          _tmpQtdVolumes = null;
        } else {
          _tmpQtdVolumes = _cursor.getInt(_cursorIndexOfQtdVolumes);
        }
        _result.setQtdVolumes(_tmpQtdVolumes);
        final Double _tmpVolumeCapacidade;
        if (_cursor.isNull(_cursorIndexOfVolumeCapacidade)) {
          _tmpVolumeCapacidade = null;
        } else {
          _tmpVolumeCapacidade = _cursor.getDouble(_cursorIndexOfVolumeCapacidade);
        }
        _result.setVolumeCapacidade(_tmpVolumeCapacidade);
        final Double _tmpVolumeCapacidadeReport;
        if (_cursor.isNull(_cursorIndexOfVolumeCapacidadeReport)) {
          _tmpVolumeCapacidadeReport = null;
        } else {
          _tmpVolumeCapacidadeReport = _cursor.getDouble(_cursorIndexOfVolumeCapacidadeReport);
        }
        _result.setVolumeCapacidadeReport(_tmpVolumeCapacidadeReport);
        final Double _tmpPesoBruto;
        if (_cursor.isNull(_cursorIndexOfPesoBruto)) {
          _tmpPesoBruto = null;
        } else {
          _tmpPesoBruto = _cursor.getDouble(_cursorIndexOfPesoBruto);
        }
        _result.setPesoBruto(_tmpPesoBruto);
        final Double _tmpPesoLiquido;
        if (_cursor.isNull(_cursorIndexOfPesoLiquido)) {
          _tmpPesoLiquido = null;
        } else {
          _tmpPesoLiquido = _cursor.getDouble(_cursorIndexOfPesoLiquido);
        }
        _result.setPesoLiquido(_tmpPesoLiquido);
        final String _tmpTipoPedido;
        _tmpTipoPedido = _cursor.getString(_cursorIndexOfTipoPedido);
        _result.setTipoPedido(_tmpTipoPedido);
        final Long _tmpCdCustomer;
        if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
          _tmpCdCustomer = null;
        } else {
          _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
        }
        _result.setCdCustomer(_tmpCdCustomer);
        final String _tmpAtivaTipoPagto;
        _tmpAtivaTipoPagto = _cursor.getString(_cursorIndexOfAtivaTipoPagto);
        _result.setAtivaTipoPagto(_tmpAtivaTipoPagto);
        final Integer _tmpStepEmissao;
        if (_cursor.isNull(_cursorIndexOfStepEmissao)) {
          _tmpStepEmissao = null;
        } else {
          _tmpStepEmissao = _cursor.getInt(_cursorIndexOfStepEmissao);
        }
        _result.setStepEmissao(_tmpStepEmissao);
        final String _tmpChave;
        _tmpChave = _cursor.getString(_cursorIndexOfChave);
        _result.setChave(_tmpChave);
        final String _tmpProtocolo;
        _tmpProtocolo = _cursor.getString(_cursorIndexOfProtocolo);
        _result.setProtocolo(_tmpProtocolo);
        final String _tmpCdMovimento;
        _tmpCdMovimento = _cursor.getString(_cursorIndexOfCdMovimento);
        _result.setCdMovimento(_tmpCdMovimento);
        final String _tmpCondicaoPagamento;
        _tmpCondicaoPagamento = _cursor.getString(_cursorIndexOfCondicaoPagamento);
        _result.setCondicaoPagamento(_tmpCondicaoPagamento);
        final Double _tmpAliquotaIcms;
        if (_cursor.isNull(_cursorIndexOfAliquotaIcms)) {
          _tmpAliquotaIcms = null;
        } else {
          _tmpAliquotaIcms = _cursor.getDouble(_cursorIndexOfAliquotaIcms);
        }
        _result.setAliquotaIcms(_tmpAliquotaIcms);
        final Double _tmpValorDescontoIcms;
        if (_cursor.isNull(_cursorIndexOfValorDescontoIcms)) {
          _tmpValorDescontoIcms = null;
        } else {
          _tmpValorDescontoIcms = _cursor.getDouble(_cursorIndexOfValorDescontoIcms);
        }
        _result.setValorDescontoIcms(_tmpValorDescontoIcms);
        final Double _tmpValorIcms;
        if (_cursor.isNull(_cursorIndexOfValorIcms)) {
          _tmpValorIcms = null;
        } else {
          _tmpValorIcms = _cursor.getDouble(_cursorIndexOfValorIcms);
        }
        _result.setValorIcms(_tmpValorIcms);
        final Double _tmpBaseCalculoIcms;
        if (_cursor.isNull(_cursorIndexOfBaseCalculoIcms)) {
          _tmpBaseCalculoIcms = null;
        } else {
          _tmpBaseCalculoIcms = _cursor.getDouble(_cursorIndexOfBaseCalculoIcms);
        }
        _result.setBaseCalculoIcms(_tmpBaseCalculoIcms);
        final Integer _tmpSituacaoTributariaIcms;
        if (_cursor.isNull(_cursorIndexOfSituacaoTributariaIcms)) {
          _tmpSituacaoTributariaIcms = null;
        } else {
          _tmpSituacaoTributariaIcms = _cursor.getInt(_cursorIndexOfSituacaoTributariaIcms);
        }
        _result.setSituacaoTributariaIcms(_tmpSituacaoTributariaIcms);
        final Double _tmpValorIpi;
        if (_cursor.isNull(_cursorIndexOfValorIpi)) {
          _tmpValorIpi = null;
        } else {
          _tmpValorIpi = _cursor.getDouble(_cursorIndexOfValorIpi);
        }
        _result.setValorIpi(_tmpValorIpi);
        final Double _tmpBaseCalculoIpi;
        if (_cursor.isNull(_cursorIndexOfBaseCalculoIpi)) {
          _tmpBaseCalculoIpi = null;
        } else {
          _tmpBaseCalculoIpi = _cursor.getDouble(_cursorIndexOfBaseCalculoIpi);
        }
        _result.setBaseCalculoIpi(_tmpBaseCalculoIpi);
        final Integer _tmpSituacaoTributariaIpi;
        if (_cursor.isNull(_cursorIndexOfSituacaoTributariaIpi)) {
          _tmpSituacaoTributariaIpi = null;
        } else {
          _tmpSituacaoTributariaIpi = _cursor.getInt(_cursorIndexOfSituacaoTributariaIpi);
        }
        _result.setSituacaoTributariaIpi(_tmpSituacaoTributariaIpi);
        final String _tmpFlNovoFaturamento;
        _tmpFlNovoFaturamento = _cursor.getString(_cursorIndexOfFlNovoFaturamento);
        _result.setFlNovoFaturamento(_tmpFlNovoFaturamento);
        final Long _tmpCdOperadora;
        if (_cursor.isNull(_cursorIndexOfCdOperadora)) {
          _tmpCdOperadora = null;
        } else {
          _tmpCdOperadora = _cursor.getLong(_cursorIndexOfCdOperadora);
        }
        _result.setCdOperadora(_tmpCdOperadora);
        final String _tmpFlPaciente;
        _tmpFlPaciente = _cursor.getString(_cursorIndexOfFlPaciente);
        _result.setFlPaciente(_tmpFlPaciente);
        final Long _tmpCdCustomerService;
        if (_cursor.isNull(_cursorIndexOfCdCustomerService)) {
          _tmpCdCustomerService = null;
        } else {
          _tmpCdCustomerService = _cursor.getLong(_cursorIndexOfCdCustomerService);
        }
        _result.setCdCustomerService(_tmpCdCustomerService);
        final String _tmpNomeAssinadorCec;
        _tmpNomeAssinadorCec = _cursor.getString(_cursorIndexOfNomeAssinadorCec);
        _result.setNomeAssinadorCec(_tmpNomeAssinadorCec);
        final String _tmpRgAssinadorCec;
        _tmpRgAssinadorCec = _cursor.getString(_cursorIndexOfRgAssinadorCec);
        _result.setRgAssinadorCec(_tmpRgAssinadorCec);
        final Integer _tmpTipoMovimentoIntegracao;
        if (_cursor.isNull(_cursorIndexOfTipoMovimentoIntegracao)) {
          _tmpTipoMovimentoIntegracao = null;
        } else {
          _tmpTipoMovimentoIntegracao = _cursor.getInt(_cursorIndexOfTipoMovimentoIntegracao);
        }
        _result.setTipoMovimentoIntegracao(_tmpTipoMovimentoIntegracao);
        final String _tmpSemPagto;
        _tmpSemPagto = _cursor.getString(_cursorIndexOfSemPagto);
        _result.setSemPagto(_tmpSemPagto);
        final Integer _tmpStatusGravacaoJde;
        if (_cursor.isNull(_cursorIndexOfStatusGravacaoJde)) {
          _tmpStatusGravacaoJde = null;
        } else {
          _tmpStatusGravacaoJde = _cursor.getInt(_cursorIndexOfStatusGravacaoJde);
        }
        _result.setStatusGravacaoJde(_tmpStatusGravacaoJde);
        final String _tmpMensagemGravacaoJde;
        _tmpMensagemGravacaoJde = _cursor.getString(_cursorIndexOfMensagemGravacaoJde);
        _result.setMensagemGravacaoJde(_tmpMensagemGravacaoJde);
        final Integer _tmpTipoTransacao;
        if (_cursor.isNull(_cursorIndexOfTipoTransacao)) {
          _tmpTipoTransacao = null;
        } else {
          _tmpTipoTransacao = _cursor.getInt(_cursorIndexOfTipoTransacao);
        }
        _result.setTipoTransacao(_tmpTipoTransacao);
        final Integer _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
        }
        _result.setStatus(_tmpStatus);
        final String _tmpStatusContingencia;
        _tmpStatusContingencia = _cursor.getString(_cursorIndexOfStatusContingencia);
        _result.setStatusContingencia(_tmpStatusContingencia);
        final String _tmpMensagemContingencia;
        _tmpMensagemContingencia = _cursor.getString(_cursorIndexOfMensagemContingencia);
        _result.setMensagemContingencia(_tmpMensagemContingencia);
        final Integer _tmpStatusCec;
        if (_cursor.isNull(_cursorIndexOfStatusCec)) {
          _tmpStatusCec = null;
        } else {
          _tmpStatusCec = _cursor.getInt(_cursorIndexOfStatusCec);
        }
        _result.setStatusCec(_tmpStatusCec);
        final String _tmpNomeTransacao;
        _tmpNomeTransacao = _cursor.getString(_cursorIndexOfNomeTransacao);
        _result.setNomeTransacao(_tmpNomeTransacao);
        final Integer _tmpStatusImpressaoCec;
        if (_cursor.isNull(_cursorIndexOfStatusImpressaoCec)) {
          _tmpStatusImpressaoCec = null;
        } else {
          _tmpStatusImpressaoCec = _cursor.getInt(_cursorIndexOfStatusImpressaoCec);
        }
        _result.setStatusImpressaoCec(_tmpStatusImpressaoCec);
        final String _tmpNomeFormaImpressaoCec;
        _tmpNomeFormaImpressaoCec = _cursor.getString(_cursorIndexOfNomeFormaImpressaoCec);
        _result.setNomeFormaImpressaoCec(_tmpNomeFormaImpressaoCec);
        final String _tmpNomeStatus;
        _tmpNomeStatus = _cursor.getString(_cursorIndexOfNomeStatus);
        _result.setNomeStatus(_tmpNomeStatus);
        final String _tmpNomeStatusImpressaoCec;
        _tmpNomeStatusImpressaoCec = _cursor.getString(_cursorIndexOfNomeStatusImpressaoCec);
        _result.setNomeStatusImpressaoCec(_tmpNomeStatusImpressaoCec);
        final String _tmpFlPrecoAlterado;
        _tmpFlPrecoAlterado = _cursor.getString(_cursorIndexOfFlPrecoAlterado);
        _result.setFlPrecoAlterado(_tmpFlPrecoAlterado);
        final String _tmpNomeTipoPagamento;
        _tmpNomeTipoPagamento = _cursor.getString(_cursorIndexOfNomeTipoPagamento);
        _result.setNomeTipoPagamento(_tmpNomeTipoPagamento);
        final String _tmpCdMotivo;
        _tmpCdMotivo = _cursor.getString(_cursorIndexOfCdMotivo);
        _result.setCdMotivo(_tmpCdMotivo);
        final String _tmpDsMotivo;
        _tmpDsMotivo = _cursor.getString(_cursorIndexOfDsMotivo);
        _result.setDsMotivo(_tmpDsMotivo);
        final String _tmpStatusNfeImp;
        _tmpStatusNfeImp = _cursor.getString(_cursorIndexOfStatusNfeImp);
        _result.setStatusNfeImp(_tmpStatusNfeImp);
        final String _tmpStatusReportFile;
        _tmpStatusReportFile = _cursor.getString(_cursorIndexOfStatusReportFile);
        _result.setStatusReportFile(_tmpStatusReportFile);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Invoice> find(Long cdCustomer, String numeroViagem) {
    final String _sql = "SELECT * FROM Invoice WHERE cdCustomer = ifnull(?, cdCustomer) AND numeroViagem = ? ORDER BY numero";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (cdCustomer == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cdCustomer);
    }
    _argIndex = 2;
    if (numeroViagem == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, numeroViagem);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfNumero = _cursor.getColumnIndexOrThrow("numero");
      final int _cursorIndexOfSerie = _cursor.getColumnIndexOrThrow("serie");
      final int _cursorIndexOfNumeroNotaVOR = _cursor.getColumnIndexOrThrow("numeroNotaVOR");
      final int _cursorIndexOfSerieNotaVOR = _cursor.getColumnIndexOrThrow("serieNotaVOR");
      final int _cursorIndexOfCdPreOrdem = _cursor.getColumnIndexOrThrow("cdPreOrdem");
      final int _cursorIndexOfNumeroFutEntrega = _cursor.getColumnIndexOrThrow("numeroFutEntrega");
      final int _cursorIndexOfCdFiscal = _cursor.getColumnIndexOrThrow("cdFiscal");
      final int _cursorIndexOfCnpjCpfDestino = _cursor.getColumnIndexOrThrow("cnpjCpfDestino");
      final int _cursorIndexOfCnpjCpfTransp = _cursor.getColumnIndexOrThrow("cnpjCpfTransp");
      final int _cursorIndexOfTipoNota = _cursor.getColumnIndexOrThrow("tipoNota");
      final int _cursorIndexOfClasseContribuinte = _cursor.getColumnIndexOrThrow("classeContribuinte");
      final int _cursorIndexOfDataViagemPrincial = _cursor.getColumnIndexOrThrow("dataViagemPrincial");
      final int _cursorIndexOfNumeroViagem = _cursor.getColumnIndexOrThrow("numeroViagem");
      final int _cursorIndexOfDataViagem = _cursor.getColumnIndexOrThrow("dataViagem");
      final int _cursorIndexOfNomeOperacao = _cursor.getColumnIndexOrThrow("nomeOperacao");
      final int _cursorIndexOfDataEmissao = _cursor.getColumnIndexOrThrow("dataEmissao");
      final int _cursorIndexOfDataMovimento = _cursor.getColumnIndexOrThrow("dataMovimento");
      final int _cursorIndexOfDataVencimento = _cursor.getColumnIndexOrThrow("dataVencimento");
      final int _cursorIndexOfValorTotal = _cursor.getColumnIndexOrThrow("valorTotal");
      final int _cursorIndexOfValorLiquido = _cursor.getColumnIndexOrThrow("valorLiquido");
      final int _cursorIndexOfValorTotalProduto = _cursor.getColumnIndexOrThrow("valorTotalProduto");
      final int _cursorIndexOfValorFrete = _cursor.getColumnIndexOrThrow("valorFrete");
      final int _cursorIndexOfValorDespAcessorias = _cursor.getColumnIndexOrThrow("valorDespAcessorias");
      final int _cursorIndexOfValorDinheiro = _cursor.getColumnIndexOrThrow("valorDinheiro");
      final int _cursorIndexOfValorTroco = _cursor.getColumnIndexOrThrow("valorTroco");
      final int _cursorIndexOfValorFatura = _cursor.getColumnIndexOrThrow("valorFatura");
      final int _cursorIndexOfValorDebito = _cursor.getColumnIndexOrThrow("valorDebito");
      final int _cursorIndexOfValorCredito = _cursor.getColumnIndexOrThrow("valorCredito");
      final int _cursorIndexOfValorCheque = _cursor.getColumnIndexOrThrow("valorCheque");
      final int _cursorIndexOfNumeroCheque = _cursor.getColumnIndexOrThrow("numeroCheque");
      final int _cursorIndexOfUfVeiculo = _cursor.getColumnIndexOrThrow("ufVeiculo");
      final int _cursorIndexOfPlacaVeiculo = _cursor.getColumnIndexOrThrow("placaVeiculo");
      final int _cursorIndexOfNumeroVeiculo = _cursor.getColumnIndexOrThrow("numeroVeiculo");
      final int _cursorIndexOfModalidadeFrete = _cursor.getColumnIndexOrThrow("modalidadeFrete");
      final int _cursorIndexOfNomeEspecVolume = _cursor.getColumnIndexOrThrow("nomeEspecVolume");
      final int _cursorIndexOfNomeMarca = _cursor.getColumnIndexOrThrow("nomeMarca");
      final int _cursorIndexOfQtdVolumes = _cursor.getColumnIndexOrThrow("qtdVolumes");
      final int _cursorIndexOfVolumeCapacidade = _cursor.getColumnIndexOrThrow("volumeCapacidade");
      final int _cursorIndexOfVolumeCapacidadeReport = _cursor.getColumnIndexOrThrow("volumeCapacidadeReport");
      final int _cursorIndexOfPesoBruto = _cursor.getColumnIndexOrThrow("pesoBruto");
      final int _cursorIndexOfPesoLiquido = _cursor.getColumnIndexOrThrow("pesoLiquido");
      final int _cursorIndexOfTipoPedido = _cursor.getColumnIndexOrThrow("tipoPedido");
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfAtivaTipoPagto = _cursor.getColumnIndexOrThrow("ativaTipoPagto");
      final int _cursorIndexOfStepEmissao = _cursor.getColumnIndexOrThrow("stepEmissao");
      final int _cursorIndexOfChave = _cursor.getColumnIndexOrThrow("chave");
      final int _cursorIndexOfProtocolo = _cursor.getColumnIndexOrThrow("protocolo");
      final int _cursorIndexOfCdMovimento = _cursor.getColumnIndexOrThrow("cdMovimento");
      final int _cursorIndexOfCondicaoPagamento = _cursor.getColumnIndexOrThrow("condicaoPagamento");
      final int _cursorIndexOfAliquotaIcms = _cursor.getColumnIndexOrThrow("aliquotaIcms");
      final int _cursorIndexOfValorDescontoIcms = _cursor.getColumnIndexOrThrow("valorDescontoIcms");
      final int _cursorIndexOfValorIcms = _cursor.getColumnIndexOrThrow("valorIcms");
      final int _cursorIndexOfBaseCalculoIcms = _cursor.getColumnIndexOrThrow("baseCalculoIcms");
      final int _cursorIndexOfSituacaoTributariaIcms = _cursor.getColumnIndexOrThrow("situacaoTributariaIcms");
      final int _cursorIndexOfValorIpi = _cursor.getColumnIndexOrThrow("valorIpi");
      final int _cursorIndexOfBaseCalculoIpi = _cursor.getColumnIndexOrThrow("baseCalculoIpi");
      final int _cursorIndexOfSituacaoTributariaIpi = _cursor.getColumnIndexOrThrow("situacaoTributariaIpi");
      final int _cursorIndexOfFlNovoFaturamento = _cursor.getColumnIndexOrThrow("flNovoFaturamento");
      final int _cursorIndexOfCdOperadora = _cursor.getColumnIndexOrThrow("cdOperadora");
      final int _cursorIndexOfFlPaciente = _cursor.getColumnIndexOrThrow("flPaciente");
      final int _cursorIndexOfCdCustomerService = _cursor.getColumnIndexOrThrow("cdCustomerService");
      final int _cursorIndexOfNomeAssinadorCec = _cursor.getColumnIndexOrThrow("nomeAssinadorCec");
      final int _cursorIndexOfRgAssinadorCec = _cursor.getColumnIndexOrThrow("rgAssinadorCec");
      final int _cursorIndexOfTipoMovimentoIntegracao = _cursor.getColumnIndexOrThrow("tipoMovimentoIntegracao");
      final int _cursorIndexOfSemPagto = _cursor.getColumnIndexOrThrow("semPagto");
      final int _cursorIndexOfStatusGravacaoJde = _cursor.getColumnIndexOrThrow("statusGravacaoJde");
      final int _cursorIndexOfMensagemGravacaoJde = _cursor.getColumnIndexOrThrow("mensagemGravacaoJde");
      final int _cursorIndexOfTipoTransacao = _cursor.getColumnIndexOrThrow("tipoTransacao");
      final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("status");
      final int _cursorIndexOfStatusContingencia = _cursor.getColumnIndexOrThrow("statusContingencia");
      final int _cursorIndexOfMensagemContingencia = _cursor.getColumnIndexOrThrow("mensagemContingencia");
      final int _cursorIndexOfStatusCec = _cursor.getColumnIndexOrThrow("statusCec");
      final int _cursorIndexOfNomeTransacao = _cursor.getColumnIndexOrThrow("nomeTransacao");
      final int _cursorIndexOfStatusImpressaoCec = _cursor.getColumnIndexOrThrow("statusImpressaoCec");
      final int _cursorIndexOfNomeFormaImpressaoCec = _cursor.getColumnIndexOrThrow("nomeFormaImpressaoCec");
      final int _cursorIndexOfNomeStatus = _cursor.getColumnIndexOrThrow("nomeStatus");
      final int _cursorIndexOfNomeStatusImpressaoCec = _cursor.getColumnIndexOrThrow("nomeStatusImpressaoCec");
      final int _cursorIndexOfFlPrecoAlterado = _cursor.getColumnIndexOrThrow("flPrecoAlterado");
      final int _cursorIndexOfNomeTipoPagamento = _cursor.getColumnIndexOrThrow("nomeTipoPagamento");
      final int _cursorIndexOfCdMotivo = _cursor.getColumnIndexOrThrow("cdMotivo");
      final int _cursorIndexOfDsMotivo = _cursor.getColumnIndexOrThrow("dsMotivo");
      final int _cursorIndexOfStatusNfeImp = _cursor.getColumnIndexOrThrow("statusNfeImp");
      final int _cursorIndexOfStatusReportFile = _cursor.getColumnIndexOrThrow("statusReportFile");
      final List<Invoice> _result = new ArrayList<Invoice>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Invoice _item;
        _item = new Invoice();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final Long _tmpNumero;
        if (_cursor.isNull(_cursorIndexOfNumero)) {
          _tmpNumero = null;
        } else {
          _tmpNumero = _cursor.getLong(_cursorIndexOfNumero);
        }
        _item.setNumero(_tmpNumero);
        final Long _tmpSerie;
        if (_cursor.isNull(_cursorIndexOfSerie)) {
          _tmpSerie = null;
        } else {
          _tmpSerie = _cursor.getLong(_cursorIndexOfSerie);
        }
        _item.setSerie(_tmpSerie);
        final Long _tmpNumeroNotaVOR;
        if (_cursor.isNull(_cursorIndexOfNumeroNotaVOR)) {
          _tmpNumeroNotaVOR = null;
        } else {
          _tmpNumeroNotaVOR = _cursor.getLong(_cursorIndexOfNumeroNotaVOR);
        }
        _item.setNumeroNotaVOR(_tmpNumeroNotaVOR);
        final Long _tmpSerieNotaVOR;
        if (_cursor.isNull(_cursorIndexOfSerieNotaVOR)) {
          _tmpSerieNotaVOR = null;
        } else {
          _tmpSerieNotaVOR = _cursor.getLong(_cursorIndexOfSerieNotaVOR);
        }
        _item.setSerieNotaVOR(_tmpSerieNotaVOR);
        final String _tmpCdPreOrdem;
        _tmpCdPreOrdem = _cursor.getString(_cursorIndexOfCdPreOrdem);
        _item.setCdPreOrdem(_tmpCdPreOrdem);
        final String _tmpNumeroFutEntrega;
        _tmpNumeroFutEntrega = _cursor.getString(_cursorIndexOfNumeroFutEntrega);
        _item.setNumeroFutEntrega(_tmpNumeroFutEntrega);
        final Integer _tmpCdFiscal;
        if (_cursor.isNull(_cursorIndexOfCdFiscal)) {
          _tmpCdFiscal = null;
        } else {
          _tmpCdFiscal = _cursor.getInt(_cursorIndexOfCdFiscal);
        }
        _item.setCdFiscal(_tmpCdFiscal);
        final String _tmpCnpjCpfDestino;
        _tmpCnpjCpfDestino = _cursor.getString(_cursorIndexOfCnpjCpfDestino);
        _item.setCnpjCpfDestino(_tmpCnpjCpfDestino);
        final String _tmpCnpjCpfTransp;
        _tmpCnpjCpfTransp = _cursor.getString(_cursorIndexOfCnpjCpfTransp);
        _item.setCnpjCpfTransp(_tmpCnpjCpfTransp);
        final String _tmpTipoNota;
        _tmpTipoNota = _cursor.getString(_cursorIndexOfTipoNota);
        _item.setTipoNota(_tmpTipoNota);
        final Integer _tmpClasseContribuinte;
        if (_cursor.isNull(_cursorIndexOfClasseContribuinte)) {
          _tmpClasseContribuinte = null;
        } else {
          _tmpClasseContribuinte = _cursor.getInt(_cursorIndexOfClasseContribuinte);
        }
        _item.setClasseContribuinte(_tmpClasseContribuinte);
        final String _tmpDataViagemPrincial;
        _tmpDataViagemPrincial = _cursor.getString(_cursorIndexOfDataViagemPrincial);
        _item.setDataViagemPrincial(_tmpDataViagemPrincial);
        final String _tmpNumeroViagem;
        _tmpNumeroViagem = _cursor.getString(_cursorIndexOfNumeroViagem);
        _item.setNumeroViagem(_tmpNumeroViagem);
        final String _tmpDataViagem;
        _tmpDataViagem = _cursor.getString(_cursorIndexOfDataViagem);
        _item.setDataViagem(_tmpDataViagem);
        final String _tmpNomeOperacao;
        _tmpNomeOperacao = _cursor.getString(_cursorIndexOfNomeOperacao);
        _item.setNomeOperacao(_tmpNomeOperacao);
        final Date _tmpDataEmissao;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfDataEmissao)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfDataEmissao);
        }
        _tmpDataEmissao = DateTypeConverter.fromTimestamp(_tmp);
        _item.setDataEmissao(_tmpDataEmissao);
        final Date _tmpDataMovimento;
        final Long _tmp_1;
        if (_cursor.isNull(_cursorIndexOfDataMovimento)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getLong(_cursorIndexOfDataMovimento);
        }
        _tmpDataMovimento = DateTypeConverter.fromTimestamp(_tmp_1);
        _item.setDataMovimento(_tmpDataMovimento);
        final Date _tmpDataVencimento;
        final Long _tmp_2;
        if (_cursor.isNull(_cursorIndexOfDataVencimento)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getLong(_cursorIndexOfDataVencimento);
        }
        _tmpDataVencimento = DateTypeConverter.fromTimestamp(_tmp_2);
        _item.setDataVencimento(_tmpDataVencimento);
        final Double _tmpValorTotal;
        if (_cursor.isNull(_cursorIndexOfValorTotal)) {
          _tmpValorTotal = null;
        } else {
          _tmpValorTotal = _cursor.getDouble(_cursorIndexOfValorTotal);
        }
        _item.setValorTotal(_tmpValorTotal);
        final Double _tmpValorLiquido;
        if (_cursor.isNull(_cursorIndexOfValorLiquido)) {
          _tmpValorLiquido = null;
        } else {
          _tmpValorLiquido = _cursor.getDouble(_cursorIndexOfValorLiquido);
        }
        _item.setValorLiquido(_tmpValorLiquido);
        final Double _tmpValorTotalProduto;
        if (_cursor.isNull(_cursorIndexOfValorTotalProduto)) {
          _tmpValorTotalProduto = null;
        } else {
          _tmpValorTotalProduto = _cursor.getDouble(_cursorIndexOfValorTotalProduto);
        }
        _item.setValorTotalProduto(_tmpValorTotalProduto);
        final Double _tmpValorFrete;
        if (_cursor.isNull(_cursorIndexOfValorFrete)) {
          _tmpValorFrete = null;
        } else {
          _tmpValorFrete = _cursor.getDouble(_cursorIndexOfValorFrete);
        }
        _item.setValorFrete(_tmpValorFrete);
        final Double _tmpValorDespAcessorias;
        if (_cursor.isNull(_cursorIndexOfValorDespAcessorias)) {
          _tmpValorDespAcessorias = null;
        } else {
          _tmpValorDespAcessorias = _cursor.getDouble(_cursorIndexOfValorDespAcessorias);
        }
        _item.setValorDespAcessorias(_tmpValorDespAcessorias);
        final Double _tmpValorDinheiro;
        if (_cursor.isNull(_cursorIndexOfValorDinheiro)) {
          _tmpValorDinheiro = null;
        } else {
          _tmpValorDinheiro = _cursor.getDouble(_cursorIndexOfValorDinheiro);
        }
        _item.setValorDinheiro(_tmpValorDinheiro);
        final Double _tmpValorTroco;
        if (_cursor.isNull(_cursorIndexOfValorTroco)) {
          _tmpValorTroco = null;
        } else {
          _tmpValorTroco = _cursor.getDouble(_cursorIndexOfValorTroco);
        }
        _item.setValorTroco(_tmpValorTroco);
        final Double _tmpValorFatura;
        if (_cursor.isNull(_cursorIndexOfValorFatura)) {
          _tmpValorFatura = null;
        } else {
          _tmpValorFatura = _cursor.getDouble(_cursorIndexOfValorFatura);
        }
        _item.setValorFatura(_tmpValorFatura);
        final Double _tmpValorDebito;
        if (_cursor.isNull(_cursorIndexOfValorDebito)) {
          _tmpValorDebito = null;
        } else {
          _tmpValorDebito = _cursor.getDouble(_cursorIndexOfValorDebito);
        }
        _item.setValorDebito(_tmpValorDebito);
        final Double _tmpValorCredito;
        if (_cursor.isNull(_cursorIndexOfValorCredito)) {
          _tmpValorCredito = null;
        } else {
          _tmpValorCredito = _cursor.getDouble(_cursorIndexOfValorCredito);
        }
        _item.setValorCredito(_tmpValorCredito);
        final Double _tmpValorCheque;
        if (_cursor.isNull(_cursorIndexOfValorCheque)) {
          _tmpValorCheque = null;
        } else {
          _tmpValorCheque = _cursor.getDouble(_cursorIndexOfValorCheque);
        }
        _item.setValorCheque(_tmpValorCheque);
        final String _tmpNumeroCheque;
        _tmpNumeroCheque = _cursor.getString(_cursorIndexOfNumeroCheque);
        _item.setNumeroCheque(_tmpNumeroCheque);
        final String _tmpUfVeiculo;
        _tmpUfVeiculo = _cursor.getString(_cursorIndexOfUfVeiculo);
        _item.setUfVeiculo(_tmpUfVeiculo);
        final String _tmpPlacaVeiculo;
        _tmpPlacaVeiculo = _cursor.getString(_cursorIndexOfPlacaVeiculo);
        _item.setPlacaVeiculo(_tmpPlacaVeiculo);
        final String _tmpNumeroVeiculo;
        _tmpNumeroVeiculo = _cursor.getString(_cursorIndexOfNumeroVeiculo);
        _item.setNumeroVeiculo(_tmpNumeroVeiculo);
        final Integer _tmpModalidadeFrete;
        if (_cursor.isNull(_cursorIndexOfModalidadeFrete)) {
          _tmpModalidadeFrete = null;
        } else {
          _tmpModalidadeFrete = _cursor.getInt(_cursorIndexOfModalidadeFrete);
        }
        _item.setModalidadeFrete(_tmpModalidadeFrete);
        final String _tmpNomeEspecVolume;
        _tmpNomeEspecVolume = _cursor.getString(_cursorIndexOfNomeEspecVolume);
        _item.setNomeEspecVolume(_tmpNomeEspecVolume);
        final String _tmpNomeMarca;
        _tmpNomeMarca = _cursor.getString(_cursorIndexOfNomeMarca);
        _item.setNomeMarca(_tmpNomeMarca);
        final Integer _tmpQtdVolumes;
        if (_cursor.isNull(_cursorIndexOfQtdVolumes)) {
          _tmpQtdVolumes = null;
        } else {
          _tmpQtdVolumes = _cursor.getInt(_cursorIndexOfQtdVolumes);
        }
        _item.setQtdVolumes(_tmpQtdVolumes);
        final Double _tmpVolumeCapacidade;
        if (_cursor.isNull(_cursorIndexOfVolumeCapacidade)) {
          _tmpVolumeCapacidade = null;
        } else {
          _tmpVolumeCapacidade = _cursor.getDouble(_cursorIndexOfVolumeCapacidade);
        }
        _item.setVolumeCapacidade(_tmpVolumeCapacidade);
        final Double _tmpVolumeCapacidadeReport;
        if (_cursor.isNull(_cursorIndexOfVolumeCapacidadeReport)) {
          _tmpVolumeCapacidadeReport = null;
        } else {
          _tmpVolumeCapacidadeReport = _cursor.getDouble(_cursorIndexOfVolumeCapacidadeReport);
        }
        _item.setVolumeCapacidadeReport(_tmpVolumeCapacidadeReport);
        final Double _tmpPesoBruto;
        if (_cursor.isNull(_cursorIndexOfPesoBruto)) {
          _tmpPesoBruto = null;
        } else {
          _tmpPesoBruto = _cursor.getDouble(_cursorIndexOfPesoBruto);
        }
        _item.setPesoBruto(_tmpPesoBruto);
        final Double _tmpPesoLiquido;
        if (_cursor.isNull(_cursorIndexOfPesoLiquido)) {
          _tmpPesoLiquido = null;
        } else {
          _tmpPesoLiquido = _cursor.getDouble(_cursorIndexOfPesoLiquido);
        }
        _item.setPesoLiquido(_tmpPesoLiquido);
        final String _tmpTipoPedido;
        _tmpTipoPedido = _cursor.getString(_cursorIndexOfTipoPedido);
        _item.setTipoPedido(_tmpTipoPedido);
        final Long _tmpCdCustomer;
        if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
          _tmpCdCustomer = null;
        } else {
          _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
        }
        _item.setCdCustomer(_tmpCdCustomer);
        final String _tmpAtivaTipoPagto;
        _tmpAtivaTipoPagto = _cursor.getString(_cursorIndexOfAtivaTipoPagto);
        _item.setAtivaTipoPagto(_tmpAtivaTipoPagto);
        final Integer _tmpStepEmissao;
        if (_cursor.isNull(_cursorIndexOfStepEmissao)) {
          _tmpStepEmissao = null;
        } else {
          _tmpStepEmissao = _cursor.getInt(_cursorIndexOfStepEmissao);
        }
        _item.setStepEmissao(_tmpStepEmissao);
        final String _tmpChave;
        _tmpChave = _cursor.getString(_cursorIndexOfChave);
        _item.setChave(_tmpChave);
        final String _tmpProtocolo;
        _tmpProtocolo = _cursor.getString(_cursorIndexOfProtocolo);
        _item.setProtocolo(_tmpProtocolo);
        final String _tmpCdMovimento;
        _tmpCdMovimento = _cursor.getString(_cursorIndexOfCdMovimento);
        _item.setCdMovimento(_tmpCdMovimento);
        final String _tmpCondicaoPagamento;
        _tmpCondicaoPagamento = _cursor.getString(_cursorIndexOfCondicaoPagamento);
        _item.setCondicaoPagamento(_tmpCondicaoPagamento);
        final Double _tmpAliquotaIcms;
        if (_cursor.isNull(_cursorIndexOfAliquotaIcms)) {
          _tmpAliquotaIcms = null;
        } else {
          _tmpAliquotaIcms = _cursor.getDouble(_cursorIndexOfAliquotaIcms);
        }
        _item.setAliquotaIcms(_tmpAliquotaIcms);
        final Double _tmpValorDescontoIcms;
        if (_cursor.isNull(_cursorIndexOfValorDescontoIcms)) {
          _tmpValorDescontoIcms = null;
        } else {
          _tmpValorDescontoIcms = _cursor.getDouble(_cursorIndexOfValorDescontoIcms);
        }
        _item.setValorDescontoIcms(_tmpValorDescontoIcms);
        final Double _tmpValorIcms;
        if (_cursor.isNull(_cursorIndexOfValorIcms)) {
          _tmpValorIcms = null;
        } else {
          _tmpValorIcms = _cursor.getDouble(_cursorIndexOfValorIcms);
        }
        _item.setValorIcms(_tmpValorIcms);
        final Double _tmpBaseCalculoIcms;
        if (_cursor.isNull(_cursorIndexOfBaseCalculoIcms)) {
          _tmpBaseCalculoIcms = null;
        } else {
          _tmpBaseCalculoIcms = _cursor.getDouble(_cursorIndexOfBaseCalculoIcms);
        }
        _item.setBaseCalculoIcms(_tmpBaseCalculoIcms);
        final Integer _tmpSituacaoTributariaIcms;
        if (_cursor.isNull(_cursorIndexOfSituacaoTributariaIcms)) {
          _tmpSituacaoTributariaIcms = null;
        } else {
          _tmpSituacaoTributariaIcms = _cursor.getInt(_cursorIndexOfSituacaoTributariaIcms);
        }
        _item.setSituacaoTributariaIcms(_tmpSituacaoTributariaIcms);
        final Double _tmpValorIpi;
        if (_cursor.isNull(_cursorIndexOfValorIpi)) {
          _tmpValorIpi = null;
        } else {
          _tmpValorIpi = _cursor.getDouble(_cursorIndexOfValorIpi);
        }
        _item.setValorIpi(_tmpValorIpi);
        final Double _tmpBaseCalculoIpi;
        if (_cursor.isNull(_cursorIndexOfBaseCalculoIpi)) {
          _tmpBaseCalculoIpi = null;
        } else {
          _tmpBaseCalculoIpi = _cursor.getDouble(_cursorIndexOfBaseCalculoIpi);
        }
        _item.setBaseCalculoIpi(_tmpBaseCalculoIpi);
        final Integer _tmpSituacaoTributariaIpi;
        if (_cursor.isNull(_cursorIndexOfSituacaoTributariaIpi)) {
          _tmpSituacaoTributariaIpi = null;
        } else {
          _tmpSituacaoTributariaIpi = _cursor.getInt(_cursorIndexOfSituacaoTributariaIpi);
        }
        _item.setSituacaoTributariaIpi(_tmpSituacaoTributariaIpi);
        final String _tmpFlNovoFaturamento;
        _tmpFlNovoFaturamento = _cursor.getString(_cursorIndexOfFlNovoFaturamento);
        _item.setFlNovoFaturamento(_tmpFlNovoFaturamento);
        final Long _tmpCdOperadora;
        if (_cursor.isNull(_cursorIndexOfCdOperadora)) {
          _tmpCdOperadora = null;
        } else {
          _tmpCdOperadora = _cursor.getLong(_cursorIndexOfCdOperadora);
        }
        _item.setCdOperadora(_tmpCdOperadora);
        final String _tmpFlPaciente;
        _tmpFlPaciente = _cursor.getString(_cursorIndexOfFlPaciente);
        _item.setFlPaciente(_tmpFlPaciente);
        final Long _tmpCdCustomerService;
        if (_cursor.isNull(_cursorIndexOfCdCustomerService)) {
          _tmpCdCustomerService = null;
        } else {
          _tmpCdCustomerService = _cursor.getLong(_cursorIndexOfCdCustomerService);
        }
        _item.setCdCustomerService(_tmpCdCustomerService);
        final String _tmpNomeAssinadorCec;
        _tmpNomeAssinadorCec = _cursor.getString(_cursorIndexOfNomeAssinadorCec);
        _item.setNomeAssinadorCec(_tmpNomeAssinadorCec);
        final String _tmpRgAssinadorCec;
        _tmpRgAssinadorCec = _cursor.getString(_cursorIndexOfRgAssinadorCec);
        _item.setRgAssinadorCec(_tmpRgAssinadorCec);
        final Integer _tmpTipoMovimentoIntegracao;
        if (_cursor.isNull(_cursorIndexOfTipoMovimentoIntegracao)) {
          _tmpTipoMovimentoIntegracao = null;
        } else {
          _tmpTipoMovimentoIntegracao = _cursor.getInt(_cursorIndexOfTipoMovimentoIntegracao);
        }
        _item.setTipoMovimentoIntegracao(_tmpTipoMovimentoIntegracao);
        final String _tmpSemPagto;
        _tmpSemPagto = _cursor.getString(_cursorIndexOfSemPagto);
        _item.setSemPagto(_tmpSemPagto);
        final Integer _tmpStatusGravacaoJde;
        if (_cursor.isNull(_cursorIndexOfStatusGravacaoJde)) {
          _tmpStatusGravacaoJde = null;
        } else {
          _tmpStatusGravacaoJde = _cursor.getInt(_cursorIndexOfStatusGravacaoJde);
        }
        _item.setStatusGravacaoJde(_tmpStatusGravacaoJde);
        final String _tmpMensagemGravacaoJde;
        _tmpMensagemGravacaoJde = _cursor.getString(_cursorIndexOfMensagemGravacaoJde);
        _item.setMensagemGravacaoJde(_tmpMensagemGravacaoJde);
        final Integer _tmpTipoTransacao;
        if (_cursor.isNull(_cursorIndexOfTipoTransacao)) {
          _tmpTipoTransacao = null;
        } else {
          _tmpTipoTransacao = _cursor.getInt(_cursorIndexOfTipoTransacao);
        }
        _item.setTipoTransacao(_tmpTipoTransacao);
        final Integer _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
        }
        _item.setStatus(_tmpStatus);
        final String _tmpStatusContingencia;
        _tmpStatusContingencia = _cursor.getString(_cursorIndexOfStatusContingencia);
        _item.setStatusContingencia(_tmpStatusContingencia);
        final String _tmpMensagemContingencia;
        _tmpMensagemContingencia = _cursor.getString(_cursorIndexOfMensagemContingencia);
        _item.setMensagemContingencia(_tmpMensagemContingencia);
        final Integer _tmpStatusCec;
        if (_cursor.isNull(_cursorIndexOfStatusCec)) {
          _tmpStatusCec = null;
        } else {
          _tmpStatusCec = _cursor.getInt(_cursorIndexOfStatusCec);
        }
        _item.setStatusCec(_tmpStatusCec);
        final String _tmpNomeTransacao;
        _tmpNomeTransacao = _cursor.getString(_cursorIndexOfNomeTransacao);
        _item.setNomeTransacao(_tmpNomeTransacao);
        final Integer _tmpStatusImpressaoCec;
        if (_cursor.isNull(_cursorIndexOfStatusImpressaoCec)) {
          _tmpStatusImpressaoCec = null;
        } else {
          _tmpStatusImpressaoCec = _cursor.getInt(_cursorIndexOfStatusImpressaoCec);
        }
        _item.setStatusImpressaoCec(_tmpStatusImpressaoCec);
        final String _tmpNomeFormaImpressaoCec;
        _tmpNomeFormaImpressaoCec = _cursor.getString(_cursorIndexOfNomeFormaImpressaoCec);
        _item.setNomeFormaImpressaoCec(_tmpNomeFormaImpressaoCec);
        final String _tmpNomeStatus;
        _tmpNomeStatus = _cursor.getString(_cursorIndexOfNomeStatus);
        _item.setNomeStatus(_tmpNomeStatus);
        final String _tmpNomeStatusImpressaoCec;
        _tmpNomeStatusImpressaoCec = _cursor.getString(_cursorIndexOfNomeStatusImpressaoCec);
        _item.setNomeStatusImpressaoCec(_tmpNomeStatusImpressaoCec);
        final String _tmpFlPrecoAlterado;
        _tmpFlPrecoAlterado = _cursor.getString(_cursorIndexOfFlPrecoAlterado);
        _item.setFlPrecoAlterado(_tmpFlPrecoAlterado);
        final String _tmpNomeTipoPagamento;
        _tmpNomeTipoPagamento = _cursor.getString(_cursorIndexOfNomeTipoPagamento);
        _item.setNomeTipoPagamento(_tmpNomeTipoPagamento);
        final String _tmpCdMotivo;
        _tmpCdMotivo = _cursor.getString(_cursorIndexOfCdMotivo);
        _item.setCdMotivo(_tmpCdMotivo);
        final String _tmpDsMotivo;
        _tmpDsMotivo = _cursor.getString(_cursorIndexOfDsMotivo);
        _item.setDsMotivo(_tmpDsMotivo);
        final String _tmpStatusNfeImp;
        _tmpStatusNfeImp = _cursor.getString(_cursorIndexOfStatusNfeImp);
        _item.setStatusNfeImp(_tmpStatusNfeImp);
        final String _tmpStatusReportFile;
        _tmpStatusReportFile = _cursor.getString(_cursorIndexOfStatusReportFile);
        _item.setStatusReportFile(_tmpStatusReportFile);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Invoice> find(String numeroFutEntrega) {
    final String _sql = "SELECT * FROM Invoice WHERE numeroFutEntrega = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (numeroFutEntrega == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, numeroFutEntrega);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfNumero = _cursor.getColumnIndexOrThrow("numero");
      final int _cursorIndexOfSerie = _cursor.getColumnIndexOrThrow("serie");
      final int _cursorIndexOfNumeroNotaVOR = _cursor.getColumnIndexOrThrow("numeroNotaVOR");
      final int _cursorIndexOfSerieNotaVOR = _cursor.getColumnIndexOrThrow("serieNotaVOR");
      final int _cursorIndexOfCdPreOrdem = _cursor.getColumnIndexOrThrow("cdPreOrdem");
      final int _cursorIndexOfNumeroFutEntrega = _cursor.getColumnIndexOrThrow("numeroFutEntrega");
      final int _cursorIndexOfCdFiscal = _cursor.getColumnIndexOrThrow("cdFiscal");
      final int _cursorIndexOfCnpjCpfDestino = _cursor.getColumnIndexOrThrow("cnpjCpfDestino");
      final int _cursorIndexOfCnpjCpfTransp = _cursor.getColumnIndexOrThrow("cnpjCpfTransp");
      final int _cursorIndexOfTipoNota = _cursor.getColumnIndexOrThrow("tipoNota");
      final int _cursorIndexOfClasseContribuinte = _cursor.getColumnIndexOrThrow("classeContribuinte");
      final int _cursorIndexOfDataViagemPrincial = _cursor.getColumnIndexOrThrow("dataViagemPrincial");
      final int _cursorIndexOfNumeroViagem = _cursor.getColumnIndexOrThrow("numeroViagem");
      final int _cursorIndexOfDataViagem = _cursor.getColumnIndexOrThrow("dataViagem");
      final int _cursorIndexOfNomeOperacao = _cursor.getColumnIndexOrThrow("nomeOperacao");
      final int _cursorIndexOfDataEmissao = _cursor.getColumnIndexOrThrow("dataEmissao");
      final int _cursorIndexOfDataMovimento = _cursor.getColumnIndexOrThrow("dataMovimento");
      final int _cursorIndexOfDataVencimento = _cursor.getColumnIndexOrThrow("dataVencimento");
      final int _cursorIndexOfValorTotal = _cursor.getColumnIndexOrThrow("valorTotal");
      final int _cursorIndexOfValorLiquido = _cursor.getColumnIndexOrThrow("valorLiquido");
      final int _cursorIndexOfValorTotalProduto = _cursor.getColumnIndexOrThrow("valorTotalProduto");
      final int _cursorIndexOfValorFrete = _cursor.getColumnIndexOrThrow("valorFrete");
      final int _cursorIndexOfValorDespAcessorias = _cursor.getColumnIndexOrThrow("valorDespAcessorias");
      final int _cursorIndexOfValorDinheiro = _cursor.getColumnIndexOrThrow("valorDinheiro");
      final int _cursorIndexOfValorTroco = _cursor.getColumnIndexOrThrow("valorTroco");
      final int _cursorIndexOfValorFatura = _cursor.getColumnIndexOrThrow("valorFatura");
      final int _cursorIndexOfValorDebito = _cursor.getColumnIndexOrThrow("valorDebito");
      final int _cursorIndexOfValorCredito = _cursor.getColumnIndexOrThrow("valorCredito");
      final int _cursorIndexOfValorCheque = _cursor.getColumnIndexOrThrow("valorCheque");
      final int _cursorIndexOfNumeroCheque = _cursor.getColumnIndexOrThrow("numeroCheque");
      final int _cursorIndexOfUfVeiculo = _cursor.getColumnIndexOrThrow("ufVeiculo");
      final int _cursorIndexOfPlacaVeiculo = _cursor.getColumnIndexOrThrow("placaVeiculo");
      final int _cursorIndexOfNumeroVeiculo = _cursor.getColumnIndexOrThrow("numeroVeiculo");
      final int _cursorIndexOfModalidadeFrete = _cursor.getColumnIndexOrThrow("modalidadeFrete");
      final int _cursorIndexOfNomeEspecVolume = _cursor.getColumnIndexOrThrow("nomeEspecVolume");
      final int _cursorIndexOfNomeMarca = _cursor.getColumnIndexOrThrow("nomeMarca");
      final int _cursorIndexOfQtdVolumes = _cursor.getColumnIndexOrThrow("qtdVolumes");
      final int _cursorIndexOfVolumeCapacidade = _cursor.getColumnIndexOrThrow("volumeCapacidade");
      final int _cursorIndexOfVolumeCapacidadeReport = _cursor.getColumnIndexOrThrow("volumeCapacidadeReport");
      final int _cursorIndexOfPesoBruto = _cursor.getColumnIndexOrThrow("pesoBruto");
      final int _cursorIndexOfPesoLiquido = _cursor.getColumnIndexOrThrow("pesoLiquido");
      final int _cursorIndexOfTipoPedido = _cursor.getColumnIndexOrThrow("tipoPedido");
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfAtivaTipoPagto = _cursor.getColumnIndexOrThrow("ativaTipoPagto");
      final int _cursorIndexOfStepEmissao = _cursor.getColumnIndexOrThrow("stepEmissao");
      final int _cursorIndexOfChave = _cursor.getColumnIndexOrThrow("chave");
      final int _cursorIndexOfProtocolo = _cursor.getColumnIndexOrThrow("protocolo");
      final int _cursorIndexOfCdMovimento = _cursor.getColumnIndexOrThrow("cdMovimento");
      final int _cursorIndexOfCondicaoPagamento = _cursor.getColumnIndexOrThrow("condicaoPagamento");
      final int _cursorIndexOfAliquotaIcms = _cursor.getColumnIndexOrThrow("aliquotaIcms");
      final int _cursorIndexOfValorDescontoIcms = _cursor.getColumnIndexOrThrow("valorDescontoIcms");
      final int _cursorIndexOfValorIcms = _cursor.getColumnIndexOrThrow("valorIcms");
      final int _cursorIndexOfBaseCalculoIcms = _cursor.getColumnIndexOrThrow("baseCalculoIcms");
      final int _cursorIndexOfSituacaoTributariaIcms = _cursor.getColumnIndexOrThrow("situacaoTributariaIcms");
      final int _cursorIndexOfValorIpi = _cursor.getColumnIndexOrThrow("valorIpi");
      final int _cursorIndexOfBaseCalculoIpi = _cursor.getColumnIndexOrThrow("baseCalculoIpi");
      final int _cursorIndexOfSituacaoTributariaIpi = _cursor.getColumnIndexOrThrow("situacaoTributariaIpi");
      final int _cursorIndexOfFlNovoFaturamento = _cursor.getColumnIndexOrThrow("flNovoFaturamento");
      final int _cursorIndexOfCdOperadora = _cursor.getColumnIndexOrThrow("cdOperadora");
      final int _cursorIndexOfFlPaciente = _cursor.getColumnIndexOrThrow("flPaciente");
      final int _cursorIndexOfCdCustomerService = _cursor.getColumnIndexOrThrow("cdCustomerService");
      final int _cursorIndexOfNomeAssinadorCec = _cursor.getColumnIndexOrThrow("nomeAssinadorCec");
      final int _cursorIndexOfRgAssinadorCec = _cursor.getColumnIndexOrThrow("rgAssinadorCec");
      final int _cursorIndexOfTipoMovimentoIntegracao = _cursor.getColumnIndexOrThrow("tipoMovimentoIntegracao");
      final int _cursorIndexOfSemPagto = _cursor.getColumnIndexOrThrow("semPagto");
      final int _cursorIndexOfStatusGravacaoJde = _cursor.getColumnIndexOrThrow("statusGravacaoJde");
      final int _cursorIndexOfMensagemGravacaoJde = _cursor.getColumnIndexOrThrow("mensagemGravacaoJde");
      final int _cursorIndexOfTipoTransacao = _cursor.getColumnIndexOrThrow("tipoTransacao");
      final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("status");
      final int _cursorIndexOfStatusContingencia = _cursor.getColumnIndexOrThrow("statusContingencia");
      final int _cursorIndexOfMensagemContingencia = _cursor.getColumnIndexOrThrow("mensagemContingencia");
      final int _cursorIndexOfStatusCec = _cursor.getColumnIndexOrThrow("statusCec");
      final int _cursorIndexOfNomeTransacao = _cursor.getColumnIndexOrThrow("nomeTransacao");
      final int _cursorIndexOfStatusImpressaoCec = _cursor.getColumnIndexOrThrow("statusImpressaoCec");
      final int _cursorIndexOfNomeFormaImpressaoCec = _cursor.getColumnIndexOrThrow("nomeFormaImpressaoCec");
      final int _cursorIndexOfNomeStatus = _cursor.getColumnIndexOrThrow("nomeStatus");
      final int _cursorIndexOfNomeStatusImpressaoCec = _cursor.getColumnIndexOrThrow("nomeStatusImpressaoCec");
      final int _cursorIndexOfFlPrecoAlterado = _cursor.getColumnIndexOrThrow("flPrecoAlterado");
      final int _cursorIndexOfNomeTipoPagamento = _cursor.getColumnIndexOrThrow("nomeTipoPagamento");
      final int _cursorIndexOfCdMotivo = _cursor.getColumnIndexOrThrow("cdMotivo");
      final int _cursorIndexOfDsMotivo = _cursor.getColumnIndexOrThrow("dsMotivo");
      final int _cursorIndexOfStatusNfeImp = _cursor.getColumnIndexOrThrow("statusNfeImp");
      final int _cursorIndexOfStatusReportFile = _cursor.getColumnIndexOrThrow("statusReportFile");
      final List<Invoice> _result = new ArrayList<Invoice>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Invoice _item;
        _item = new Invoice();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final Long _tmpNumero;
        if (_cursor.isNull(_cursorIndexOfNumero)) {
          _tmpNumero = null;
        } else {
          _tmpNumero = _cursor.getLong(_cursorIndexOfNumero);
        }
        _item.setNumero(_tmpNumero);
        final Long _tmpSerie;
        if (_cursor.isNull(_cursorIndexOfSerie)) {
          _tmpSerie = null;
        } else {
          _tmpSerie = _cursor.getLong(_cursorIndexOfSerie);
        }
        _item.setSerie(_tmpSerie);
        final Long _tmpNumeroNotaVOR;
        if (_cursor.isNull(_cursorIndexOfNumeroNotaVOR)) {
          _tmpNumeroNotaVOR = null;
        } else {
          _tmpNumeroNotaVOR = _cursor.getLong(_cursorIndexOfNumeroNotaVOR);
        }
        _item.setNumeroNotaVOR(_tmpNumeroNotaVOR);
        final Long _tmpSerieNotaVOR;
        if (_cursor.isNull(_cursorIndexOfSerieNotaVOR)) {
          _tmpSerieNotaVOR = null;
        } else {
          _tmpSerieNotaVOR = _cursor.getLong(_cursorIndexOfSerieNotaVOR);
        }
        _item.setSerieNotaVOR(_tmpSerieNotaVOR);
        final String _tmpCdPreOrdem;
        _tmpCdPreOrdem = _cursor.getString(_cursorIndexOfCdPreOrdem);
        _item.setCdPreOrdem(_tmpCdPreOrdem);
        final String _tmpNumeroFutEntrega;
        _tmpNumeroFutEntrega = _cursor.getString(_cursorIndexOfNumeroFutEntrega);
        _item.setNumeroFutEntrega(_tmpNumeroFutEntrega);
        final Integer _tmpCdFiscal;
        if (_cursor.isNull(_cursorIndexOfCdFiscal)) {
          _tmpCdFiscal = null;
        } else {
          _tmpCdFiscal = _cursor.getInt(_cursorIndexOfCdFiscal);
        }
        _item.setCdFiscal(_tmpCdFiscal);
        final String _tmpCnpjCpfDestino;
        _tmpCnpjCpfDestino = _cursor.getString(_cursorIndexOfCnpjCpfDestino);
        _item.setCnpjCpfDestino(_tmpCnpjCpfDestino);
        final String _tmpCnpjCpfTransp;
        _tmpCnpjCpfTransp = _cursor.getString(_cursorIndexOfCnpjCpfTransp);
        _item.setCnpjCpfTransp(_tmpCnpjCpfTransp);
        final String _tmpTipoNota;
        _tmpTipoNota = _cursor.getString(_cursorIndexOfTipoNota);
        _item.setTipoNota(_tmpTipoNota);
        final Integer _tmpClasseContribuinte;
        if (_cursor.isNull(_cursorIndexOfClasseContribuinte)) {
          _tmpClasseContribuinte = null;
        } else {
          _tmpClasseContribuinte = _cursor.getInt(_cursorIndexOfClasseContribuinte);
        }
        _item.setClasseContribuinte(_tmpClasseContribuinte);
        final String _tmpDataViagemPrincial;
        _tmpDataViagemPrincial = _cursor.getString(_cursorIndexOfDataViagemPrincial);
        _item.setDataViagemPrincial(_tmpDataViagemPrincial);
        final String _tmpNumeroViagem;
        _tmpNumeroViagem = _cursor.getString(_cursorIndexOfNumeroViagem);
        _item.setNumeroViagem(_tmpNumeroViagem);
        final String _tmpDataViagem;
        _tmpDataViagem = _cursor.getString(_cursorIndexOfDataViagem);
        _item.setDataViagem(_tmpDataViagem);
        final String _tmpNomeOperacao;
        _tmpNomeOperacao = _cursor.getString(_cursorIndexOfNomeOperacao);
        _item.setNomeOperacao(_tmpNomeOperacao);
        final Date _tmpDataEmissao;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfDataEmissao)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfDataEmissao);
        }
        _tmpDataEmissao = DateTypeConverter.fromTimestamp(_tmp);
        _item.setDataEmissao(_tmpDataEmissao);
        final Date _tmpDataMovimento;
        final Long _tmp_1;
        if (_cursor.isNull(_cursorIndexOfDataMovimento)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getLong(_cursorIndexOfDataMovimento);
        }
        _tmpDataMovimento = DateTypeConverter.fromTimestamp(_tmp_1);
        _item.setDataMovimento(_tmpDataMovimento);
        final Date _tmpDataVencimento;
        final Long _tmp_2;
        if (_cursor.isNull(_cursorIndexOfDataVencimento)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getLong(_cursorIndexOfDataVencimento);
        }
        _tmpDataVencimento = DateTypeConverter.fromTimestamp(_tmp_2);
        _item.setDataVencimento(_tmpDataVencimento);
        final Double _tmpValorTotal;
        if (_cursor.isNull(_cursorIndexOfValorTotal)) {
          _tmpValorTotal = null;
        } else {
          _tmpValorTotal = _cursor.getDouble(_cursorIndexOfValorTotal);
        }
        _item.setValorTotal(_tmpValorTotal);
        final Double _tmpValorLiquido;
        if (_cursor.isNull(_cursorIndexOfValorLiquido)) {
          _tmpValorLiquido = null;
        } else {
          _tmpValorLiquido = _cursor.getDouble(_cursorIndexOfValorLiquido);
        }
        _item.setValorLiquido(_tmpValorLiquido);
        final Double _tmpValorTotalProduto;
        if (_cursor.isNull(_cursorIndexOfValorTotalProduto)) {
          _tmpValorTotalProduto = null;
        } else {
          _tmpValorTotalProduto = _cursor.getDouble(_cursorIndexOfValorTotalProduto);
        }
        _item.setValorTotalProduto(_tmpValorTotalProduto);
        final Double _tmpValorFrete;
        if (_cursor.isNull(_cursorIndexOfValorFrete)) {
          _tmpValorFrete = null;
        } else {
          _tmpValorFrete = _cursor.getDouble(_cursorIndexOfValorFrete);
        }
        _item.setValorFrete(_tmpValorFrete);
        final Double _tmpValorDespAcessorias;
        if (_cursor.isNull(_cursorIndexOfValorDespAcessorias)) {
          _tmpValorDespAcessorias = null;
        } else {
          _tmpValorDespAcessorias = _cursor.getDouble(_cursorIndexOfValorDespAcessorias);
        }
        _item.setValorDespAcessorias(_tmpValorDespAcessorias);
        final Double _tmpValorDinheiro;
        if (_cursor.isNull(_cursorIndexOfValorDinheiro)) {
          _tmpValorDinheiro = null;
        } else {
          _tmpValorDinheiro = _cursor.getDouble(_cursorIndexOfValorDinheiro);
        }
        _item.setValorDinheiro(_tmpValorDinheiro);
        final Double _tmpValorTroco;
        if (_cursor.isNull(_cursorIndexOfValorTroco)) {
          _tmpValorTroco = null;
        } else {
          _tmpValorTroco = _cursor.getDouble(_cursorIndexOfValorTroco);
        }
        _item.setValorTroco(_tmpValorTroco);
        final Double _tmpValorFatura;
        if (_cursor.isNull(_cursorIndexOfValorFatura)) {
          _tmpValorFatura = null;
        } else {
          _tmpValorFatura = _cursor.getDouble(_cursorIndexOfValorFatura);
        }
        _item.setValorFatura(_tmpValorFatura);
        final Double _tmpValorDebito;
        if (_cursor.isNull(_cursorIndexOfValorDebito)) {
          _tmpValorDebito = null;
        } else {
          _tmpValorDebito = _cursor.getDouble(_cursorIndexOfValorDebito);
        }
        _item.setValorDebito(_tmpValorDebito);
        final Double _tmpValorCredito;
        if (_cursor.isNull(_cursorIndexOfValorCredito)) {
          _tmpValorCredito = null;
        } else {
          _tmpValorCredito = _cursor.getDouble(_cursorIndexOfValorCredito);
        }
        _item.setValorCredito(_tmpValorCredito);
        final Double _tmpValorCheque;
        if (_cursor.isNull(_cursorIndexOfValorCheque)) {
          _tmpValorCheque = null;
        } else {
          _tmpValorCheque = _cursor.getDouble(_cursorIndexOfValorCheque);
        }
        _item.setValorCheque(_tmpValorCheque);
        final String _tmpNumeroCheque;
        _tmpNumeroCheque = _cursor.getString(_cursorIndexOfNumeroCheque);
        _item.setNumeroCheque(_tmpNumeroCheque);
        final String _tmpUfVeiculo;
        _tmpUfVeiculo = _cursor.getString(_cursorIndexOfUfVeiculo);
        _item.setUfVeiculo(_tmpUfVeiculo);
        final String _tmpPlacaVeiculo;
        _tmpPlacaVeiculo = _cursor.getString(_cursorIndexOfPlacaVeiculo);
        _item.setPlacaVeiculo(_tmpPlacaVeiculo);
        final String _tmpNumeroVeiculo;
        _tmpNumeroVeiculo = _cursor.getString(_cursorIndexOfNumeroVeiculo);
        _item.setNumeroVeiculo(_tmpNumeroVeiculo);
        final Integer _tmpModalidadeFrete;
        if (_cursor.isNull(_cursorIndexOfModalidadeFrete)) {
          _tmpModalidadeFrete = null;
        } else {
          _tmpModalidadeFrete = _cursor.getInt(_cursorIndexOfModalidadeFrete);
        }
        _item.setModalidadeFrete(_tmpModalidadeFrete);
        final String _tmpNomeEspecVolume;
        _tmpNomeEspecVolume = _cursor.getString(_cursorIndexOfNomeEspecVolume);
        _item.setNomeEspecVolume(_tmpNomeEspecVolume);
        final String _tmpNomeMarca;
        _tmpNomeMarca = _cursor.getString(_cursorIndexOfNomeMarca);
        _item.setNomeMarca(_tmpNomeMarca);
        final Integer _tmpQtdVolumes;
        if (_cursor.isNull(_cursorIndexOfQtdVolumes)) {
          _tmpQtdVolumes = null;
        } else {
          _tmpQtdVolumes = _cursor.getInt(_cursorIndexOfQtdVolumes);
        }
        _item.setQtdVolumes(_tmpQtdVolumes);
        final Double _tmpVolumeCapacidade;
        if (_cursor.isNull(_cursorIndexOfVolumeCapacidade)) {
          _tmpVolumeCapacidade = null;
        } else {
          _tmpVolumeCapacidade = _cursor.getDouble(_cursorIndexOfVolumeCapacidade);
        }
        _item.setVolumeCapacidade(_tmpVolumeCapacidade);
        final Double _tmpVolumeCapacidadeReport;
        if (_cursor.isNull(_cursorIndexOfVolumeCapacidadeReport)) {
          _tmpVolumeCapacidadeReport = null;
        } else {
          _tmpVolumeCapacidadeReport = _cursor.getDouble(_cursorIndexOfVolumeCapacidadeReport);
        }
        _item.setVolumeCapacidadeReport(_tmpVolumeCapacidadeReport);
        final Double _tmpPesoBruto;
        if (_cursor.isNull(_cursorIndexOfPesoBruto)) {
          _tmpPesoBruto = null;
        } else {
          _tmpPesoBruto = _cursor.getDouble(_cursorIndexOfPesoBruto);
        }
        _item.setPesoBruto(_tmpPesoBruto);
        final Double _tmpPesoLiquido;
        if (_cursor.isNull(_cursorIndexOfPesoLiquido)) {
          _tmpPesoLiquido = null;
        } else {
          _tmpPesoLiquido = _cursor.getDouble(_cursorIndexOfPesoLiquido);
        }
        _item.setPesoLiquido(_tmpPesoLiquido);
        final String _tmpTipoPedido;
        _tmpTipoPedido = _cursor.getString(_cursorIndexOfTipoPedido);
        _item.setTipoPedido(_tmpTipoPedido);
        final Long _tmpCdCustomer;
        if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
          _tmpCdCustomer = null;
        } else {
          _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
        }
        _item.setCdCustomer(_tmpCdCustomer);
        final String _tmpAtivaTipoPagto;
        _tmpAtivaTipoPagto = _cursor.getString(_cursorIndexOfAtivaTipoPagto);
        _item.setAtivaTipoPagto(_tmpAtivaTipoPagto);
        final Integer _tmpStepEmissao;
        if (_cursor.isNull(_cursorIndexOfStepEmissao)) {
          _tmpStepEmissao = null;
        } else {
          _tmpStepEmissao = _cursor.getInt(_cursorIndexOfStepEmissao);
        }
        _item.setStepEmissao(_tmpStepEmissao);
        final String _tmpChave;
        _tmpChave = _cursor.getString(_cursorIndexOfChave);
        _item.setChave(_tmpChave);
        final String _tmpProtocolo;
        _tmpProtocolo = _cursor.getString(_cursorIndexOfProtocolo);
        _item.setProtocolo(_tmpProtocolo);
        final String _tmpCdMovimento;
        _tmpCdMovimento = _cursor.getString(_cursorIndexOfCdMovimento);
        _item.setCdMovimento(_tmpCdMovimento);
        final String _tmpCondicaoPagamento;
        _tmpCondicaoPagamento = _cursor.getString(_cursorIndexOfCondicaoPagamento);
        _item.setCondicaoPagamento(_tmpCondicaoPagamento);
        final Double _tmpAliquotaIcms;
        if (_cursor.isNull(_cursorIndexOfAliquotaIcms)) {
          _tmpAliquotaIcms = null;
        } else {
          _tmpAliquotaIcms = _cursor.getDouble(_cursorIndexOfAliquotaIcms);
        }
        _item.setAliquotaIcms(_tmpAliquotaIcms);
        final Double _tmpValorDescontoIcms;
        if (_cursor.isNull(_cursorIndexOfValorDescontoIcms)) {
          _tmpValorDescontoIcms = null;
        } else {
          _tmpValorDescontoIcms = _cursor.getDouble(_cursorIndexOfValorDescontoIcms);
        }
        _item.setValorDescontoIcms(_tmpValorDescontoIcms);
        final Double _tmpValorIcms;
        if (_cursor.isNull(_cursorIndexOfValorIcms)) {
          _tmpValorIcms = null;
        } else {
          _tmpValorIcms = _cursor.getDouble(_cursorIndexOfValorIcms);
        }
        _item.setValorIcms(_tmpValorIcms);
        final Double _tmpBaseCalculoIcms;
        if (_cursor.isNull(_cursorIndexOfBaseCalculoIcms)) {
          _tmpBaseCalculoIcms = null;
        } else {
          _tmpBaseCalculoIcms = _cursor.getDouble(_cursorIndexOfBaseCalculoIcms);
        }
        _item.setBaseCalculoIcms(_tmpBaseCalculoIcms);
        final Integer _tmpSituacaoTributariaIcms;
        if (_cursor.isNull(_cursorIndexOfSituacaoTributariaIcms)) {
          _tmpSituacaoTributariaIcms = null;
        } else {
          _tmpSituacaoTributariaIcms = _cursor.getInt(_cursorIndexOfSituacaoTributariaIcms);
        }
        _item.setSituacaoTributariaIcms(_tmpSituacaoTributariaIcms);
        final Double _tmpValorIpi;
        if (_cursor.isNull(_cursorIndexOfValorIpi)) {
          _tmpValorIpi = null;
        } else {
          _tmpValorIpi = _cursor.getDouble(_cursorIndexOfValorIpi);
        }
        _item.setValorIpi(_tmpValorIpi);
        final Double _tmpBaseCalculoIpi;
        if (_cursor.isNull(_cursorIndexOfBaseCalculoIpi)) {
          _tmpBaseCalculoIpi = null;
        } else {
          _tmpBaseCalculoIpi = _cursor.getDouble(_cursorIndexOfBaseCalculoIpi);
        }
        _item.setBaseCalculoIpi(_tmpBaseCalculoIpi);
        final Integer _tmpSituacaoTributariaIpi;
        if (_cursor.isNull(_cursorIndexOfSituacaoTributariaIpi)) {
          _tmpSituacaoTributariaIpi = null;
        } else {
          _tmpSituacaoTributariaIpi = _cursor.getInt(_cursorIndexOfSituacaoTributariaIpi);
        }
        _item.setSituacaoTributariaIpi(_tmpSituacaoTributariaIpi);
        final String _tmpFlNovoFaturamento;
        _tmpFlNovoFaturamento = _cursor.getString(_cursorIndexOfFlNovoFaturamento);
        _item.setFlNovoFaturamento(_tmpFlNovoFaturamento);
        final Long _tmpCdOperadora;
        if (_cursor.isNull(_cursorIndexOfCdOperadora)) {
          _tmpCdOperadora = null;
        } else {
          _tmpCdOperadora = _cursor.getLong(_cursorIndexOfCdOperadora);
        }
        _item.setCdOperadora(_tmpCdOperadora);
        final String _tmpFlPaciente;
        _tmpFlPaciente = _cursor.getString(_cursorIndexOfFlPaciente);
        _item.setFlPaciente(_tmpFlPaciente);
        final Long _tmpCdCustomerService;
        if (_cursor.isNull(_cursorIndexOfCdCustomerService)) {
          _tmpCdCustomerService = null;
        } else {
          _tmpCdCustomerService = _cursor.getLong(_cursorIndexOfCdCustomerService);
        }
        _item.setCdCustomerService(_tmpCdCustomerService);
        final String _tmpNomeAssinadorCec;
        _tmpNomeAssinadorCec = _cursor.getString(_cursorIndexOfNomeAssinadorCec);
        _item.setNomeAssinadorCec(_tmpNomeAssinadorCec);
        final String _tmpRgAssinadorCec;
        _tmpRgAssinadorCec = _cursor.getString(_cursorIndexOfRgAssinadorCec);
        _item.setRgAssinadorCec(_tmpRgAssinadorCec);
        final Integer _tmpTipoMovimentoIntegracao;
        if (_cursor.isNull(_cursorIndexOfTipoMovimentoIntegracao)) {
          _tmpTipoMovimentoIntegracao = null;
        } else {
          _tmpTipoMovimentoIntegracao = _cursor.getInt(_cursorIndexOfTipoMovimentoIntegracao);
        }
        _item.setTipoMovimentoIntegracao(_tmpTipoMovimentoIntegracao);
        final String _tmpSemPagto;
        _tmpSemPagto = _cursor.getString(_cursorIndexOfSemPagto);
        _item.setSemPagto(_tmpSemPagto);
        final Integer _tmpStatusGravacaoJde;
        if (_cursor.isNull(_cursorIndexOfStatusGravacaoJde)) {
          _tmpStatusGravacaoJde = null;
        } else {
          _tmpStatusGravacaoJde = _cursor.getInt(_cursorIndexOfStatusGravacaoJde);
        }
        _item.setStatusGravacaoJde(_tmpStatusGravacaoJde);
        final String _tmpMensagemGravacaoJde;
        _tmpMensagemGravacaoJde = _cursor.getString(_cursorIndexOfMensagemGravacaoJde);
        _item.setMensagemGravacaoJde(_tmpMensagemGravacaoJde);
        final Integer _tmpTipoTransacao;
        if (_cursor.isNull(_cursorIndexOfTipoTransacao)) {
          _tmpTipoTransacao = null;
        } else {
          _tmpTipoTransacao = _cursor.getInt(_cursorIndexOfTipoTransacao);
        }
        _item.setTipoTransacao(_tmpTipoTransacao);
        final Integer _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
        }
        _item.setStatus(_tmpStatus);
        final String _tmpStatusContingencia;
        _tmpStatusContingencia = _cursor.getString(_cursorIndexOfStatusContingencia);
        _item.setStatusContingencia(_tmpStatusContingencia);
        final String _tmpMensagemContingencia;
        _tmpMensagemContingencia = _cursor.getString(_cursorIndexOfMensagemContingencia);
        _item.setMensagemContingencia(_tmpMensagemContingencia);
        final Integer _tmpStatusCec;
        if (_cursor.isNull(_cursorIndexOfStatusCec)) {
          _tmpStatusCec = null;
        } else {
          _tmpStatusCec = _cursor.getInt(_cursorIndexOfStatusCec);
        }
        _item.setStatusCec(_tmpStatusCec);
        final String _tmpNomeTransacao;
        _tmpNomeTransacao = _cursor.getString(_cursorIndexOfNomeTransacao);
        _item.setNomeTransacao(_tmpNomeTransacao);
        final Integer _tmpStatusImpressaoCec;
        if (_cursor.isNull(_cursorIndexOfStatusImpressaoCec)) {
          _tmpStatusImpressaoCec = null;
        } else {
          _tmpStatusImpressaoCec = _cursor.getInt(_cursorIndexOfStatusImpressaoCec);
        }
        _item.setStatusImpressaoCec(_tmpStatusImpressaoCec);
        final String _tmpNomeFormaImpressaoCec;
        _tmpNomeFormaImpressaoCec = _cursor.getString(_cursorIndexOfNomeFormaImpressaoCec);
        _item.setNomeFormaImpressaoCec(_tmpNomeFormaImpressaoCec);
        final String _tmpNomeStatus;
        _tmpNomeStatus = _cursor.getString(_cursorIndexOfNomeStatus);
        _item.setNomeStatus(_tmpNomeStatus);
        final String _tmpNomeStatusImpressaoCec;
        _tmpNomeStatusImpressaoCec = _cursor.getString(_cursorIndexOfNomeStatusImpressaoCec);
        _item.setNomeStatusImpressaoCec(_tmpNomeStatusImpressaoCec);
        final String _tmpFlPrecoAlterado;
        _tmpFlPrecoAlterado = _cursor.getString(_cursorIndexOfFlPrecoAlterado);
        _item.setFlPrecoAlterado(_tmpFlPrecoAlterado);
        final String _tmpNomeTipoPagamento;
        _tmpNomeTipoPagamento = _cursor.getString(_cursorIndexOfNomeTipoPagamento);
        _item.setNomeTipoPagamento(_tmpNomeTipoPagamento);
        final String _tmpCdMotivo;
        _tmpCdMotivo = _cursor.getString(_cursorIndexOfCdMotivo);
        _item.setCdMotivo(_tmpCdMotivo);
        final String _tmpDsMotivo;
        _tmpDsMotivo = _cursor.getString(_cursorIndexOfDsMotivo);
        _item.setDsMotivo(_tmpDsMotivo);
        final String _tmpStatusNfeImp;
        _tmpStatusNfeImp = _cursor.getString(_cursorIndexOfStatusNfeImp);
        _item.setStatusNfeImp(_tmpStatusNfeImp);
        final String _tmpStatusReportFile;
        _tmpStatusReportFile = _cursor.getString(_cursorIndexOfStatusReportFile);
        _item.setStatusReportFile(_tmpStatusReportFile);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Invoice> find(List<Integer> statusNFe) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT * FROM Invoice WHERE status IN (");
    final int _inputSize = statusNFe.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ORDER BY numero");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (Integer _item : statusNFe) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item);
      }
      _argIndex ++;
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfNumero = _cursor.getColumnIndexOrThrow("numero");
      final int _cursorIndexOfSerie = _cursor.getColumnIndexOrThrow("serie");
      final int _cursorIndexOfNumeroNotaVOR = _cursor.getColumnIndexOrThrow("numeroNotaVOR");
      final int _cursorIndexOfSerieNotaVOR = _cursor.getColumnIndexOrThrow("serieNotaVOR");
      final int _cursorIndexOfCdPreOrdem = _cursor.getColumnIndexOrThrow("cdPreOrdem");
      final int _cursorIndexOfNumeroFutEntrega = _cursor.getColumnIndexOrThrow("numeroFutEntrega");
      final int _cursorIndexOfCdFiscal = _cursor.getColumnIndexOrThrow("cdFiscal");
      final int _cursorIndexOfCnpjCpfDestino = _cursor.getColumnIndexOrThrow("cnpjCpfDestino");
      final int _cursorIndexOfCnpjCpfTransp = _cursor.getColumnIndexOrThrow("cnpjCpfTransp");
      final int _cursorIndexOfTipoNota = _cursor.getColumnIndexOrThrow("tipoNota");
      final int _cursorIndexOfClasseContribuinte = _cursor.getColumnIndexOrThrow("classeContribuinte");
      final int _cursorIndexOfDataViagemPrincial = _cursor.getColumnIndexOrThrow("dataViagemPrincial");
      final int _cursorIndexOfNumeroViagem = _cursor.getColumnIndexOrThrow("numeroViagem");
      final int _cursorIndexOfDataViagem = _cursor.getColumnIndexOrThrow("dataViagem");
      final int _cursorIndexOfNomeOperacao = _cursor.getColumnIndexOrThrow("nomeOperacao");
      final int _cursorIndexOfDataEmissao = _cursor.getColumnIndexOrThrow("dataEmissao");
      final int _cursorIndexOfDataMovimento = _cursor.getColumnIndexOrThrow("dataMovimento");
      final int _cursorIndexOfDataVencimento = _cursor.getColumnIndexOrThrow("dataVencimento");
      final int _cursorIndexOfValorTotal = _cursor.getColumnIndexOrThrow("valorTotal");
      final int _cursorIndexOfValorLiquido = _cursor.getColumnIndexOrThrow("valorLiquido");
      final int _cursorIndexOfValorTotalProduto = _cursor.getColumnIndexOrThrow("valorTotalProduto");
      final int _cursorIndexOfValorFrete = _cursor.getColumnIndexOrThrow("valorFrete");
      final int _cursorIndexOfValorDespAcessorias = _cursor.getColumnIndexOrThrow("valorDespAcessorias");
      final int _cursorIndexOfValorDinheiro = _cursor.getColumnIndexOrThrow("valorDinheiro");
      final int _cursorIndexOfValorTroco = _cursor.getColumnIndexOrThrow("valorTroco");
      final int _cursorIndexOfValorFatura = _cursor.getColumnIndexOrThrow("valorFatura");
      final int _cursorIndexOfValorDebito = _cursor.getColumnIndexOrThrow("valorDebito");
      final int _cursorIndexOfValorCredito = _cursor.getColumnIndexOrThrow("valorCredito");
      final int _cursorIndexOfValorCheque = _cursor.getColumnIndexOrThrow("valorCheque");
      final int _cursorIndexOfNumeroCheque = _cursor.getColumnIndexOrThrow("numeroCheque");
      final int _cursorIndexOfUfVeiculo = _cursor.getColumnIndexOrThrow("ufVeiculo");
      final int _cursorIndexOfPlacaVeiculo = _cursor.getColumnIndexOrThrow("placaVeiculo");
      final int _cursorIndexOfNumeroVeiculo = _cursor.getColumnIndexOrThrow("numeroVeiculo");
      final int _cursorIndexOfModalidadeFrete = _cursor.getColumnIndexOrThrow("modalidadeFrete");
      final int _cursorIndexOfNomeEspecVolume = _cursor.getColumnIndexOrThrow("nomeEspecVolume");
      final int _cursorIndexOfNomeMarca = _cursor.getColumnIndexOrThrow("nomeMarca");
      final int _cursorIndexOfQtdVolumes = _cursor.getColumnIndexOrThrow("qtdVolumes");
      final int _cursorIndexOfVolumeCapacidade = _cursor.getColumnIndexOrThrow("volumeCapacidade");
      final int _cursorIndexOfVolumeCapacidadeReport = _cursor.getColumnIndexOrThrow("volumeCapacidadeReport");
      final int _cursorIndexOfPesoBruto = _cursor.getColumnIndexOrThrow("pesoBruto");
      final int _cursorIndexOfPesoLiquido = _cursor.getColumnIndexOrThrow("pesoLiquido");
      final int _cursorIndexOfTipoPedido = _cursor.getColumnIndexOrThrow("tipoPedido");
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfAtivaTipoPagto = _cursor.getColumnIndexOrThrow("ativaTipoPagto");
      final int _cursorIndexOfStepEmissao = _cursor.getColumnIndexOrThrow("stepEmissao");
      final int _cursorIndexOfChave = _cursor.getColumnIndexOrThrow("chave");
      final int _cursorIndexOfProtocolo = _cursor.getColumnIndexOrThrow("protocolo");
      final int _cursorIndexOfCdMovimento = _cursor.getColumnIndexOrThrow("cdMovimento");
      final int _cursorIndexOfCondicaoPagamento = _cursor.getColumnIndexOrThrow("condicaoPagamento");
      final int _cursorIndexOfAliquotaIcms = _cursor.getColumnIndexOrThrow("aliquotaIcms");
      final int _cursorIndexOfValorDescontoIcms = _cursor.getColumnIndexOrThrow("valorDescontoIcms");
      final int _cursorIndexOfValorIcms = _cursor.getColumnIndexOrThrow("valorIcms");
      final int _cursorIndexOfBaseCalculoIcms = _cursor.getColumnIndexOrThrow("baseCalculoIcms");
      final int _cursorIndexOfSituacaoTributariaIcms = _cursor.getColumnIndexOrThrow("situacaoTributariaIcms");
      final int _cursorIndexOfValorIpi = _cursor.getColumnIndexOrThrow("valorIpi");
      final int _cursorIndexOfBaseCalculoIpi = _cursor.getColumnIndexOrThrow("baseCalculoIpi");
      final int _cursorIndexOfSituacaoTributariaIpi = _cursor.getColumnIndexOrThrow("situacaoTributariaIpi");
      final int _cursorIndexOfFlNovoFaturamento = _cursor.getColumnIndexOrThrow("flNovoFaturamento");
      final int _cursorIndexOfCdOperadora = _cursor.getColumnIndexOrThrow("cdOperadora");
      final int _cursorIndexOfFlPaciente = _cursor.getColumnIndexOrThrow("flPaciente");
      final int _cursorIndexOfCdCustomerService = _cursor.getColumnIndexOrThrow("cdCustomerService");
      final int _cursorIndexOfNomeAssinadorCec = _cursor.getColumnIndexOrThrow("nomeAssinadorCec");
      final int _cursorIndexOfRgAssinadorCec = _cursor.getColumnIndexOrThrow("rgAssinadorCec");
      final int _cursorIndexOfTipoMovimentoIntegracao = _cursor.getColumnIndexOrThrow("tipoMovimentoIntegracao");
      final int _cursorIndexOfSemPagto = _cursor.getColumnIndexOrThrow("semPagto");
      final int _cursorIndexOfStatusGravacaoJde = _cursor.getColumnIndexOrThrow("statusGravacaoJde");
      final int _cursorIndexOfMensagemGravacaoJde = _cursor.getColumnIndexOrThrow("mensagemGravacaoJde");
      final int _cursorIndexOfTipoTransacao = _cursor.getColumnIndexOrThrow("tipoTransacao");
      final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("status");
      final int _cursorIndexOfStatusContingencia = _cursor.getColumnIndexOrThrow("statusContingencia");
      final int _cursorIndexOfMensagemContingencia = _cursor.getColumnIndexOrThrow("mensagemContingencia");
      final int _cursorIndexOfStatusCec = _cursor.getColumnIndexOrThrow("statusCec");
      final int _cursorIndexOfNomeTransacao = _cursor.getColumnIndexOrThrow("nomeTransacao");
      final int _cursorIndexOfStatusImpressaoCec = _cursor.getColumnIndexOrThrow("statusImpressaoCec");
      final int _cursorIndexOfNomeFormaImpressaoCec = _cursor.getColumnIndexOrThrow("nomeFormaImpressaoCec");
      final int _cursorIndexOfNomeStatus = _cursor.getColumnIndexOrThrow("nomeStatus");
      final int _cursorIndexOfNomeStatusImpressaoCec = _cursor.getColumnIndexOrThrow("nomeStatusImpressaoCec");
      final int _cursorIndexOfFlPrecoAlterado = _cursor.getColumnIndexOrThrow("flPrecoAlterado");
      final int _cursorIndexOfNomeTipoPagamento = _cursor.getColumnIndexOrThrow("nomeTipoPagamento");
      final int _cursorIndexOfCdMotivo = _cursor.getColumnIndexOrThrow("cdMotivo");
      final int _cursorIndexOfDsMotivo = _cursor.getColumnIndexOrThrow("dsMotivo");
      final int _cursorIndexOfStatusNfeImp = _cursor.getColumnIndexOrThrow("statusNfeImp");
      final int _cursorIndexOfStatusReportFile = _cursor.getColumnIndexOrThrow("statusReportFile");
      final List<Invoice> _result = new ArrayList<Invoice>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Invoice _item_1;
        _item_1 = new Invoice();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _item_1.setId(_tmpId);
        final Long _tmpNumero;
        if (_cursor.isNull(_cursorIndexOfNumero)) {
          _tmpNumero = null;
        } else {
          _tmpNumero = _cursor.getLong(_cursorIndexOfNumero);
        }
        _item_1.setNumero(_tmpNumero);
        final Long _tmpSerie;
        if (_cursor.isNull(_cursorIndexOfSerie)) {
          _tmpSerie = null;
        } else {
          _tmpSerie = _cursor.getLong(_cursorIndexOfSerie);
        }
        _item_1.setSerie(_tmpSerie);
        final Long _tmpNumeroNotaVOR;
        if (_cursor.isNull(_cursorIndexOfNumeroNotaVOR)) {
          _tmpNumeroNotaVOR = null;
        } else {
          _tmpNumeroNotaVOR = _cursor.getLong(_cursorIndexOfNumeroNotaVOR);
        }
        _item_1.setNumeroNotaVOR(_tmpNumeroNotaVOR);
        final Long _tmpSerieNotaVOR;
        if (_cursor.isNull(_cursorIndexOfSerieNotaVOR)) {
          _tmpSerieNotaVOR = null;
        } else {
          _tmpSerieNotaVOR = _cursor.getLong(_cursorIndexOfSerieNotaVOR);
        }
        _item_1.setSerieNotaVOR(_tmpSerieNotaVOR);
        final String _tmpCdPreOrdem;
        _tmpCdPreOrdem = _cursor.getString(_cursorIndexOfCdPreOrdem);
        _item_1.setCdPreOrdem(_tmpCdPreOrdem);
        final String _tmpNumeroFutEntrega;
        _tmpNumeroFutEntrega = _cursor.getString(_cursorIndexOfNumeroFutEntrega);
        _item_1.setNumeroFutEntrega(_tmpNumeroFutEntrega);
        final Integer _tmpCdFiscal;
        if (_cursor.isNull(_cursorIndexOfCdFiscal)) {
          _tmpCdFiscal = null;
        } else {
          _tmpCdFiscal = _cursor.getInt(_cursorIndexOfCdFiscal);
        }
        _item_1.setCdFiscal(_tmpCdFiscal);
        final String _tmpCnpjCpfDestino;
        _tmpCnpjCpfDestino = _cursor.getString(_cursorIndexOfCnpjCpfDestino);
        _item_1.setCnpjCpfDestino(_tmpCnpjCpfDestino);
        final String _tmpCnpjCpfTransp;
        _tmpCnpjCpfTransp = _cursor.getString(_cursorIndexOfCnpjCpfTransp);
        _item_1.setCnpjCpfTransp(_tmpCnpjCpfTransp);
        final String _tmpTipoNota;
        _tmpTipoNota = _cursor.getString(_cursorIndexOfTipoNota);
        _item_1.setTipoNota(_tmpTipoNota);
        final Integer _tmpClasseContribuinte;
        if (_cursor.isNull(_cursorIndexOfClasseContribuinte)) {
          _tmpClasseContribuinte = null;
        } else {
          _tmpClasseContribuinte = _cursor.getInt(_cursorIndexOfClasseContribuinte);
        }
        _item_1.setClasseContribuinte(_tmpClasseContribuinte);
        final String _tmpDataViagemPrincial;
        _tmpDataViagemPrincial = _cursor.getString(_cursorIndexOfDataViagemPrincial);
        _item_1.setDataViagemPrincial(_tmpDataViagemPrincial);
        final String _tmpNumeroViagem;
        _tmpNumeroViagem = _cursor.getString(_cursorIndexOfNumeroViagem);
        _item_1.setNumeroViagem(_tmpNumeroViagem);
        final String _tmpDataViagem;
        _tmpDataViagem = _cursor.getString(_cursorIndexOfDataViagem);
        _item_1.setDataViagem(_tmpDataViagem);
        final String _tmpNomeOperacao;
        _tmpNomeOperacao = _cursor.getString(_cursorIndexOfNomeOperacao);
        _item_1.setNomeOperacao(_tmpNomeOperacao);
        final Date _tmpDataEmissao;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfDataEmissao)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfDataEmissao);
        }
        _tmpDataEmissao = DateTypeConverter.fromTimestamp(_tmp);
        _item_1.setDataEmissao(_tmpDataEmissao);
        final Date _tmpDataMovimento;
        final Long _tmp_1;
        if (_cursor.isNull(_cursorIndexOfDataMovimento)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getLong(_cursorIndexOfDataMovimento);
        }
        _tmpDataMovimento = DateTypeConverter.fromTimestamp(_tmp_1);
        _item_1.setDataMovimento(_tmpDataMovimento);
        final Date _tmpDataVencimento;
        final Long _tmp_2;
        if (_cursor.isNull(_cursorIndexOfDataVencimento)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getLong(_cursorIndexOfDataVencimento);
        }
        _tmpDataVencimento = DateTypeConverter.fromTimestamp(_tmp_2);
        _item_1.setDataVencimento(_tmpDataVencimento);
        final Double _tmpValorTotal;
        if (_cursor.isNull(_cursorIndexOfValorTotal)) {
          _tmpValorTotal = null;
        } else {
          _tmpValorTotal = _cursor.getDouble(_cursorIndexOfValorTotal);
        }
        _item_1.setValorTotal(_tmpValorTotal);
        final Double _tmpValorLiquido;
        if (_cursor.isNull(_cursorIndexOfValorLiquido)) {
          _tmpValorLiquido = null;
        } else {
          _tmpValorLiquido = _cursor.getDouble(_cursorIndexOfValorLiquido);
        }
        _item_1.setValorLiquido(_tmpValorLiquido);
        final Double _tmpValorTotalProduto;
        if (_cursor.isNull(_cursorIndexOfValorTotalProduto)) {
          _tmpValorTotalProduto = null;
        } else {
          _tmpValorTotalProduto = _cursor.getDouble(_cursorIndexOfValorTotalProduto);
        }
        _item_1.setValorTotalProduto(_tmpValorTotalProduto);
        final Double _tmpValorFrete;
        if (_cursor.isNull(_cursorIndexOfValorFrete)) {
          _tmpValorFrete = null;
        } else {
          _tmpValorFrete = _cursor.getDouble(_cursorIndexOfValorFrete);
        }
        _item_1.setValorFrete(_tmpValorFrete);
        final Double _tmpValorDespAcessorias;
        if (_cursor.isNull(_cursorIndexOfValorDespAcessorias)) {
          _tmpValorDespAcessorias = null;
        } else {
          _tmpValorDespAcessorias = _cursor.getDouble(_cursorIndexOfValorDespAcessorias);
        }
        _item_1.setValorDespAcessorias(_tmpValorDespAcessorias);
        final Double _tmpValorDinheiro;
        if (_cursor.isNull(_cursorIndexOfValorDinheiro)) {
          _tmpValorDinheiro = null;
        } else {
          _tmpValorDinheiro = _cursor.getDouble(_cursorIndexOfValorDinheiro);
        }
        _item_1.setValorDinheiro(_tmpValorDinheiro);
        final Double _tmpValorTroco;
        if (_cursor.isNull(_cursorIndexOfValorTroco)) {
          _tmpValorTroco = null;
        } else {
          _tmpValorTroco = _cursor.getDouble(_cursorIndexOfValorTroco);
        }
        _item_1.setValorTroco(_tmpValorTroco);
        final Double _tmpValorFatura;
        if (_cursor.isNull(_cursorIndexOfValorFatura)) {
          _tmpValorFatura = null;
        } else {
          _tmpValorFatura = _cursor.getDouble(_cursorIndexOfValorFatura);
        }
        _item_1.setValorFatura(_tmpValorFatura);
        final Double _tmpValorDebito;
        if (_cursor.isNull(_cursorIndexOfValorDebito)) {
          _tmpValorDebito = null;
        } else {
          _tmpValorDebito = _cursor.getDouble(_cursorIndexOfValorDebito);
        }
        _item_1.setValorDebito(_tmpValorDebito);
        final Double _tmpValorCredito;
        if (_cursor.isNull(_cursorIndexOfValorCredito)) {
          _tmpValorCredito = null;
        } else {
          _tmpValorCredito = _cursor.getDouble(_cursorIndexOfValorCredito);
        }
        _item_1.setValorCredito(_tmpValorCredito);
        final Double _tmpValorCheque;
        if (_cursor.isNull(_cursorIndexOfValorCheque)) {
          _tmpValorCheque = null;
        } else {
          _tmpValorCheque = _cursor.getDouble(_cursorIndexOfValorCheque);
        }
        _item_1.setValorCheque(_tmpValorCheque);
        final String _tmpNumeroCheque;
        _tmpNumeroCheque = _cursor.getString(_cursorIndexOfNumeroCheque);
        _item_1.setNumeroCheque(_tmpNumeroCheque);
        final String _tmpUfVeiculo;
        _tmpUfVeiculo = _cursor.getString(_cursorIndexOfUfVeiculo);
        _item_1.setUfVeiculo(_tmpUfVeiculo);
        final String _tmpPlacaVeiculo;
        _tmpPlacaVeiculo = _cursor.getString(_cursorIndexOfPlacaVeiculo);
        _item_1.setPlacaVeiculo(_tmpPlacaVeiculo);
        final String _tmpNumeroVeiculo;
        _tmpNumeroVeiculo = _cursor.getString(_cursorIndexOfNumeroVeiculo);
        _item_1.setNumeroVeiculo(_tmpNumeroVeiculo);
        final Integer _tmpModalidadeFrete;
        if (_cursor.isNull(_cursorIndexOfModalidadeFrete)) {
          _tmpModalidadeFrete = null;
        } else {
          _tmpModalidadeFrete = _cursor.getInt(_cursorIndexOfModalidadeFrete);
        }
        _item_1.setModalidadeFrete(_tmpModalidadeFrete);
        final String _tmpNomeEspecVolume;
        _tmpNomeEspecVolume = _cursor.getString(_cursorIndexOfNomeEspecVolume);
        _item_1.setNomeEspecVolume(_tmpNomeEspecVolume);
        final String _tmpNomeMarca;
        _tmpNomeMarca = _cursor.getString(_cursorIndexOfNomeMarca);
        _item_1.setNomeMarca(_tmpNomeMarca);
        final Integer _tmpQtdVolumes;
        if (_cursor.isNull(_cursorIndexOfQtdVolumes)) {
          _tmpQtdVolumes = null;
        } else {
          _tmpQtdVolumes = _cursor.getInt(_cursorIndexOfQtdVolumes);
        }
        _item_1.setQtdVolumes(_tmpQtdVolumes);
        final Double _tmpVolumeCapacidade;
        if (_cursor.isNull(_cursorIndexOfVolumeCapacidade)) {
          _tmpVolumeCapacidade = null;
        } else {
          _tmpVolumeCapacidade = _cursor.getDouble(_cursorIndexOfVolumeCapacidade);
        }
        _item_1.setVolumeCapacidade(_tmpVolumeCapacidade);
        final Double _tmpVolumeCapacidadeReport;
        if (_cursor.isNull(_cursorIndexOfVolumeCapacidadeReport)) {
          _tmpVolumeCapacidadeReport = null;
        } else {
          _tmpVolumeCapacidadeReport = _cursor.getDouble(_cursorIndexOfVolumeCapacidadeReport);
        }
        _item_1.setVolumeCapacidadeReport(_tmpVolumeCapacidadeReport);
        final Double _tmpPesoBruto;
        if (_cursor.isNull(_cursorIndexOfPesoBruto)) {
          _tmpPesoBruto = null;
        } else {
          _tmpPesoBruto = _cursor.getDouble(_cursorIndexOfPesoBruto);
        }
        _item_1.setPesoBruto(_tmpPesoBruto);
        final Double _tmpPesoLiquido;
        if (_cursor.isNull(_cursorIndexOfPesoLiquido)) {
          _tmpPesoLiquido = null;
        } else {
          _tmpPesoLiquido = _cursor.getDouble(_cursorIndexOfPesoLiquido);
        }
        _item_1.setPesoLiquido(_tmpPesoLiquido);
        final String _tmpTipoPedido;
        _tmpTipoPedido = _cursor.getString(_cursorIndexOfTipoPedido);
        _item_1.setTipoPedido(_tmpTipoPedido);
        final Long _tmpCdCustomer;
        if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
          _tmpCdCustomer = null;
        } else {
          _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
        }
        _item_1.setCdCustomer(_tmpCdCustomer);
        final String _tmpAtivaTipoPagto;
        _tmpAtivaTipoPagto = _cursor.getString(_cursorIndexOfAtivaTipoPagto);
        _item_1.setAtivaTipoPagto(_tmpAtivaTipoPagto);
        final Integer _tmpStepEmissao;
        if (_cursor.isNull(_cursorIndexOfStepEmissao)) {
          _tmpStepEmissao = null;
        } else {
          _tmpStepEmissao = _cursor.getInt(_cursorIndexOfStepEmissao);
        }
        _item_1.setStepEmissao(_tmpStepEmissao);
        final String _tmpChave;
        _tmpChave = _cursor.getString(_cursorIndexOfChave);
        _item_1.setChave(_tmpChave);
        final String _tmpProtocolo;
        _tmpProtocolo = _cursor.getString(_cursorIndexOfProtocolo);
        _item_1.setProtocolo(_tmpProtocolo);
        final String _tmpCdMovimento;
        _tmpCdMovimento = _cursor.getString(_cursorIndexOfCdMovimento);
        _item_1.setCdMovimento(_tmpCdMovimento);
        final String _tmpCondicaoPagamento;
        _tmpCondicaoPagamento = _cursor.getString(_cursorIndexOfCondicaoPagamento);
        _item_1.setCondicaoPagamento(_tmpCondicaoPagamento);
        final Double _tmpAliquotaIcms;
        if (_cursor.isNull(_cursorIndexOfAliquotaIcms)) {
          _tmpAliquotaIcms = null;
        } else {
          _tmpAliquotaIcms = _cursor.getDouble(_cursorIndexOfAliquotaIcms);
        }
        _item_1.setAliquotaIcms(_tmpAliquotaIcms);
        final Double _tmpValorDescontoIcms;
        if (_cursor.isNull(_cursorIndexOfValorDescontoIcms)) {
          _tmpValorDescontoIcms = null;
        } else {
          _tmpValorDescontoIcms = _cursor.getDouble(_cursorIndexOfValorDescontoIcms);
        }
        _item_1.setValorDescontoIcms(_tmpValorDescontoIcms);
        final Double _tmpValorIcms;
        if (_cursor.isNull(_cursorIndexOfValorIcms)) {
          _tmpValorIcms = null;
        } else {
          _tmpValorIcms = _cursor.getDouble(_cursorIndexOfValorIcms);
        }
        _item_1.setValorIcms(_tmpValorIcms);
        final Double _tmpBaseCalculoIcms;
        if (_cursor.isNull(_cursorIndexOfBaseCalculoIcms)) {
          _tmpBaseCalculoIcms = null;
        } else {
          _tmpBaseCalculoIcms = _cursor.getDouble(_cursorIndexOfBaseCalculoIcms);
        }
        _item_1.setBaseCalculoIcms(_tmpBaseCalculoIcms);
        final Integer _tmpSituacaoTributariaIcms;
        if (_cursor.isNull(_cursorIndexOfSituacaoTributariaIcms)) {
          _tmpSituacaoTributariaIcms = null;
        } else {
          _tmpSituacaoTributariaIcms = _cursor.getInt(_cursorIndexOfSituacaoTributariaIcms);
        }
        _item_1.setSituacaoTributariaIcms(_tmpSituacaoTributariaIcms);
        final Double _tmpValorIpi;
        if (_cursor.isNull(_cursorIndexOfValorIpi)) {
          _tmpValorIpi = null;
        } else {
          _tmpValorIpi = _cursor.getDouble(_cursorIndexOfValorIpi);
        }
        _item_1.setValorIpi(_tmpValorIpi);
        final Double _tmpBaseCalculoIpi;
        if (_cursor.isNull(_cursorIndexOfBaseCalculoIpi)) {
          _tmpBaseCalculoIpi = null;
        } else {
          _tmpBaseCalculoIpi = _cursor.getDouble(_cursorIndexOfBaseCalculoIpi);
        }
        _item_1.setBaseCalculoIpi(_tmpBaseCalculoIpi);
        final Integer _tmpSituacaoTributariaIpi;
        if (_cursor.isNull(_cursorIndexOfSituacaoTributariaIpi)) {
          _tmpSituacaoTributariaIpi = null;
        } else {
          _tmpSituacaoTributariaIpi = _cursor.getInt(_cursorIndexOfSituacaoTributariaIpi);
        }
        _item_1.setSituacaoTributariaIpi(_tmpSituacaoTributariaIpi);
        final String _tmpFlNovoFaturamento;
        _tmpFlNovoFaturamento = _cursor.getString(_cursorIndexOfFlNovoFaturamento);
        _item_1.setFlNovoFaturamento(_tmpFlNovoFaturamento);
        final Long _tmpCdOperadora;
        if (_cursor.isNull(_cursorIndexOfCdOperadora)) {
          _tmpCdOperadora = null;
        } else {
          _tmpCdOperadora = _cursor.getLong(_cursorIndexOfCdOperadora);
        }
        _item_1.setCdOperadora(_tmpCdOperadora);
        final String _tmpFlPaciente;
        _tmpFlPaciente = _cursor.getString(_cursorIndexOfFlPaciente);
        _item_1.setFlPaciente(_tmpFlPaciente);
        final Long _tmpCdCustomerService;
        if (_cursor.isNull(_cursorIndexOfCdCustomerService)) {
          _tmpCdCustomerService = null;
        } else {
          _tmpCdCustomerService = _cursor.getLong(_cursorIndexOfCdCustomerService);
        }
        _item_1.setCdCustomerService(_tmpCdCustomerService);
        final String _tmpNomeAssinadorCec;
        _tmpNomeAssinadorCec = _cursor.getString(_cursorIndexOfNomeAssinadorCec);
        _item_1.setNomeAssinadorCec(_tmpNomeAssinadorCec);
        final String _tmpRgAssinadorCec;
        _tmpRgAssinadorCec = _cursor.getString(_cursorIndexOfRgAssinadorCec);
        _item_1.setRgAssinadorCec(_tmpRgAssinadorCec);
        final Integer _tmpTipoMovimentoIntegracao;
        if (_cursor.isNull(_cursorIndexOfTipoMovimentoIntegracao)) {
          _tmpTipoMovimentoIntegracao = null;
        } else {
          _tmpTipoMovimentoIntegracao = _cursor.getInt(_cursorIndexOfTipoMovimentoIntegracao);
        }
        _item_1.setTipoMovimentoIntegracao(_tmpTipoMovimentoIntegracao);
        final String _tmpSemPagto;
        _tmpSemPagto = _cursor.getString(_cursorIndexOfSemPagto);
        _item_1.setSemPagto(_tmpSemPagto);
        final Integer _tmpStatusGravacaoJde;
        if (_cursor.isNull(_cursorIndexOfStatusGravacaoJde)) {
          _tmpStatusGravacaoJde = null;
        } else {
          _tmpStatusGravacaoJde = _cursor.getInt(_cursorIndexOfStatusGravacaoJde);
        }
        _item_1.setStatusGravacaoJde(_tmpStatusGravacaoJde);
        final String _tmpMensagemGravacaoJde;
        _tmpMensagemGravacaoJde = _cursor.getString(_cursorIndexOfMensagemGravacaoJde);
        _item_1.setMensagemGravacaoJde(_tmpMensagemGravacaoJde);
        final Integer _tmpTipoTransacao;
        if (_cursor.isNull(_cursorIndexOfTipoTransacao)) {
          _tmpTipoTransacao = null;
        } else {
          _tmpTipoTransacao = _cursor.getInt(_cursorIndexOfTipoTransacao);
        }
        _item_1.setTipoTransacao(_tmpTipoTransacao);
        final Integer _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
        }
        _item_1.setStatus(_tmpStatus);
        final String _tmpStatusContingencia;
        _tmpStatusContingencia = _cursor.getString(_cursorIndexOfStatusContingencia);
        _item_1.setStatusContingencia(_tmpStatusContingencia);
        final String _tmpMensagemContingencia;
        _tmpMensagemContingencia = _cursor.getString(_cursorIndexOfMensagemContingencia);
        _item_1.setMensagemContingencia(_tmpMensagemContingencia);
        final Integer _tmpStatusCec;
        if (_cursor.isNull(_cursorIndexOfStatusCec)) {
          _tmpStatusCec = null;
        } else {
          _tmpStatusCec = _cursor.getInt(_cursorIndexOfStatusCec);
        }
        _item_1.setStatusCec(_tmpStatusCec);
        final String _tmpNomeTransacao;
        _tmpNomeTransacao = _cursor.getString(_cursorIndexOfNomeTransacao);
        _item_1.setNomeTransacao(_tmpNomeTransacao);
        final Integer _tmpStatusImpressaoCec;
        if (_cursor.isNull(_cursorIndexOfStatusImpressaoCec)) {
          _tmpStatusImpressaoCec = null;
        } else {
          _tmpStatusImpressaoCec = _cursor.getInt(_cursorIndexOfStatusImpressaoCec);
        }
        _item_1.setStatusImpressaoCec(_tmpStatusImpressaoCec);
        final String _tmpNomeFormaImpressaoCec;
        _tmpNomeFormaImpressaoCec = _cursor.getString(_cursorIndexOfNomeFormaImpressaoCec);
        _item_1.setNomeFormaImpressaoCec(_tmpNomeFormaImpressaoCec);
        final String _tmpNomeStatus;
        _tmpNomeStatus = _cursor.getString(_cursorIndexOfNomeStatus);
        _item_1.setNomeStatus(_tmpNomeStatus);
        final String _tmpNomeStatusImpressaoCec;
        _tmpNomeStatusImpressaoCec = _cursor.getString(_cursorIndexOfNomeStatusImpressaoCec);
        _item_1.setNomeStatusImpressaoCec(_tmpNomeStatusImpressaoCec);
        final String _tmpFlPrecoAlterado;
        _tmpFlPrecoAlterado = _cursor.getString(_cursorIndexOfFlPrecoAlterado);
        _item_1.setFlPrecoAlterado(_tmpFlPrecoAlterado);
        final String _tmpNomeTipoPagamento;
        _tmpNomeTipoPagamento = _cursor.getString(_cursorIndexOfNomeTipoPagamento);
        _item_1.setNomeTipoPagamento(_tmpNomeTipoPagamento);
        final String _tmpCdMotivo;
        _tmpCdMotivo = _cursor.getString(_cursorIndexOfCdMotivo);
        _item_1.setCdMotivo(_tmpCdMotivo);
        final String _tmpDsMotivo;
        _tmpDsMotivo = _cursor.getString(_cursorIndexOfDsMotivo);
        _item_1.setDsMotivo(_tmpDsMotivo);
        final String _tmpStatusNfeImp;
        _tmpStatusNfeImp = _cursor.getString(_cursorIndexOfStatusNfeImp);
        _item_1.setStatusNfeImp(_tmpStatusNfeImp);
        final String _tmpStatusReportFile;
        _tmpStatusReportFile = _cursor.getString(_cursorIndexOfStatusReportFile);
        _item_1.setStatusReportFile(_tmpStatusReportFile);
        _result.add(_item_1);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Invoice> find(Integer stepEmissao) {
    final String _sql = "SELECT * FROM Invoice WHERE stepEmissao NOT IN (?) ORDER BY numero";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (stepEmissao == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, stepEmissao);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfNumero = _cursor.getColumnIndexOrThrow("numero");
      final int _cursorIndexOfSerie = _cursor.getColumnIndexOrThrow("serie");
      final int _cursorIndexOfNumeroNotaVOR = _cursor.getColumnIndexOrThrow("numeroNotaVOR");
      final int _cursorIndexOfSerieNotaVOR = _cursor.getColumnIndexOrThrow("serieNotaVOR");
      final int _cursorIndexOfCdPreOrdem = _cursor.getColumnIndexOrThrow("cdPreOrdem");
      final int _cursorIndexOfNumeroFutEntrega = _cursor.getColumnIndexOrThrow("numeroFutEntrega");
      final int _cursorIndexOfCdFiscal = _cursor.getColumnIndexOrThrow("cdFiscal");
      final int _cursorIndexOfCnpjCpfDestino = _cursor.getColumnIndexOrThrow("cnpjCpfDestino");
      final int _cursorIndexOfCnpjCpfTransp = _cursor.getColumnIndexOrThrow("cnpjCpfTransp");
      final int _cursorIndexOfTipoNota = _cursor.getColumnIndexOrThrow("tipoNota");
      final int _cursorIndexOfClasseContribuinte = _cursor.getColumnIndexOrThrow("classeContribuinte");
      final int _cursorIndexOfDataViagemPrincial = _cursor.getColumnIndexOrThrow("dataViagemPrincial");
      final int _cursorIndexOfNumeroViagem = _cursor.getColumnIndexOrThrow("numeroViagem");
      final int _cursorIndexOfDataViagem = _cursor.getColumnIndexOrThrow("dataViagem");
      final int _cursorIndexOfNomeOperacao = _cursor.getColumnIndexOrThrow("nomeOperacao");
      final int _cursorIndexOfDataEmissao = _cursor.getColumnIndexOrThrow("dataEmissao");
      final int _cursorIndexOfDataMovimento = _cursor.getColumnIndexOrThrow("dataMovimento");
      final int _cursorIndexOfDataVencimento = _cursor.getColumnIndexOrThrow("dataVencimento");
      final int _cursorIndexOfValorTotal = _cursor.getColumnIndexOrThrow("valorTotal");
      final int _cursorIndexOfValorLiquido = _cursor.getColumnIndexOrThrow("valorLiquido");
      final int _cursorIndexOfValorTotalProduto = _cursor.getColumnIndexOrThrow("valorTotalProduto");
      final int _cursorIndexOfValorFrete = _cursor.getColumnIndexOrThrow("valorFrete");
      final int _cursorIndexOfValorDespAcessorias = _cursor.getColumnIndexOrThrow("valorDespAcessorias");
      final int _cursorIndexOfValorDinheiro = _cursor.getColumnIndexOrThrow("valorDinheiro");
      final int _cursorIndexOfValorTroco = _cursor.getColumnIndexOrThrow("valorTroco");
      final int _cursorIndexOfValorFatura = _cursor.getColumnIndexOrThrow("valorFatura");
      final int _cursorIndexOfValorDebito = _cursor.getColumnIndexOrThrow("valorDebito");
      final int _cursorIndexOfValorCredito = _cursor.getColumnIndexOrThrow("valorCredito");
      final int _cursorIndexOfValorCheque = _cursor.getColumnIndexOrThrow("valorCheque");
      final int _cursorIndexOfNumeroCheque = _cursor.getColumnIndexOrThrow("numeroCheque");
      final int _cursorIndexOfUfVeiculo = _cursor.getColumnIndexOrThrow("ufVeiculo");
      final int _cursorIndexOfPlacaVeiculo = _cursor.getColumnIndexOrThrow("placaVeiculo");
      final int _cursorIndexOfNumeroVeiculo = _cursor.getColumnIndexOrThrow("numeroVeiculo");
      final int _cursorIndexOfModalidadeFrete = _cursor.getColumnIndexOrThrow("modalidadeFrete");
      final int _cursorIndexOfNomeEspecVolume = _cursor.getColumnIndexOrThrow("nomeEspecVolume");
      final int _cursorIndexOfNomeMarca = _cursor.getColumnIndexOrThrow("nomeMarca");
      final int _cursorIndexOfQtdVolumes = _cursor.getColumnIndexOrThrow("qtdVolumes");
      final int _cursorIndexOfVolumeCapacidade = _cursor.getColumnIndexOrThrow("volumeCapacidade");
      final int _cursorIndexOfVolumeCapacidadeReport = _cursor.getColumnIndexOrThrow("volumeCapacidadeReport");
      final int _cursorIndexOfPesoBruto = _cursor.getColumnIndexOrThrow("pesoBruto");
      final int _cursorIndexOfPesoLiquido = _cursor.getColumnIndexOrThrow("pesoLiquido");
      final int _cursorIndexOfTipoPedido = _cursor.getColumnIndexOrThrow("tipoPedido");
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfAtivaTipoPagto = _cursor.getColumnIndexOrThrow("ativaTipoPagto");
      final int _cursorIndexOfStepEmissao = _cursor.getColumnIndexOrThrow("stepEmissao");
      final int _cursorIndexOfChave = _cursor.getColumnIndexOrThrow("chave");
      final int _cursorIndexOfProtocolo = _cursor.getColumnIndexOrThrow("protocolo");
      final int _cursorIndexOfCdMovimento = _cursor.getColumnIndexOrThrow("cdMovimento");
      final int _cursorIndexOfCondicaoPagamento = _cursor.getColumnIndexOrThrow("condicaoPagamento");
      final int _cursorIndexOfAliquotaIcms = _cursor.getColumnIndexOrThrow("aliquotaIcms");
      final int _cursorIndexOfValorDescontoIcms = _cursor.getColumnIndexOrThrow("valorDescontoIcms");
      final int _cursorIndexOfValorIcms = _cursor.getColumnIndexOrThrow("valorIcms");
      final int _cursorIndexOfBaseCalculoIcms = _cursor.getColumnIndexOrThrow("baseCalculoIcms");
      final int _cursorIndexOfSituacaoTributariaIcms = _cursor.getColumnIndexOrThrow("situacaoTributariaIcms");
      final int _cursorIndexOfValorIpi = _cursor.getColumnIndexOrThrow("valorIpi");
      final int _cursorIndexOfBaseCalculoIpi = _cursor.getColumnIndexOrThrow("baseCalculoIpi");
      final int _cursorIndexOfSituacaoTributariaIpi = _cursor.getColumnIndexOrThrow("situacaoTributariaIpi");
      final int _cursorIndexOfFlNovoFaturamento = _cursor.getColumnIndexOrThrow("flNovoFaturamento");
      final int _cursorIndexOfCdOperadora = _cursor.getColumnIndexOrThrow("cdOperadora");
      final int _cursorIndexOfFlPaciente = _cursor.getColumnIndexOrThrow("flPaciente");
      final int _cursorIndexOfCdCustomerService = _cursor.getColumnIndexOrThrow("cdCustomerService");
      final int _cursorIndexOfNomeAssinadorCec = _cursor.getColumnIndexOrThrow("nomeAssinadorCec");
      final int _cursorIndexOfRgAssinadorCec = _cursor.getColumnIndexOrThrow("rgAssinadorCec");
      final int _cursorIndexOfTipoMovimentoIntegracao = _cursor.getColumnIndexOrThrow("tipoMovimentoIntegracao");
      final int _cursorIndexOfSemPagto = _cursor.getColumnIndexOrThrow("semPagto");
      final int _cursorIndexOfStatusGravacaoJde = _cursor.getColumnIndexOrThrow("statusGravacaoJde");
      final int _cursorIndexOfMensagemGravacaoJde = _cursor.getColumnIndexOrThrow("mensagemGravacaoJde");
      final int _cursorIndexOfTipoTransacao = _cursor.getColumnIndexOrThrow("tipoTransacao");
      final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("status");
      final int _cursorIndexOfStatusContingencia = _cursor.getColumnIndexOrThrow("statusContingencia");
      final int _cursorIndexOfMensagemContingencia = _cursor.getColumnIndexOrThrow("mensagemContingencia");
      final int _cursorIndexOfStatusCec = _cursor.getColumnIndexOrThrow("statusCec");
      final int _cursorIndexOfNomeTransacao = _cursor.getColumnIndexOrThrow("nomeTransacao");
      final int _cursorIndexOfStatusImpressaoCec = _cursor.getColumnIndexOrThrow("statusImpressaoCec");
      final int _cursorIndexOfNomeFormaImpressaoCec = _cursor.getColumnIndexOrThrow("nomeFormaImpressaoCec");
      final int _cursorIndexOfNomeStatus = _cursor.getColumnIndexOrThrow("nomeStatus");
      final int _cursorIndexOfNomeStatusImpressaoCec = _cursor.getColumnIndexOrThrow("nomeStatusImpressaoCec");
      final int _cursorIndexOfFlPrecoAlterado = _cursor.getColumnIndexOrThrow("flPrecoAlterado");
      final int _cursorIndexOfNomeTipoPagamento = _cursor.getColumnIndexOrThrow("nomeTipoPagamento");
      final int _cursorIndexOfCdMotivo = _cursor.getColumnIndexOrThrow("cdMotivo");
      final int _cursorIndexOfDsMotivo = _cursor.getColumnIndexOrThrow("dsMotivo");
      final int _cursorIndexOfStatusNfeImp = _cursor.getColumnIndexOrThrow("statusNfeImp");
      final int _cursorIndexOfStatusReportFile = _cursor.getColumnIndexOrThrow("statusReportFile");
      final List<Invoice> _result = new ArrayList<Invoice>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Invoice _item;
        _item = new Invoice();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final Long _tmpNumero;
        if (_cursor.isNull(_cursorIndexOfNumero)) {
          _tmpNumero = null;
        } else {
          _tmpNumero = _cursor.getLong(_cursorIndexOfNumero);
        }
        _item.setNumero(_tmpNumero);
        final Long _tmpSerie;
        if (_cursor.isNull(_cursorIndexOfSerie)) {
          _tmpSerie = null;
        } else {
          _tmpSerie = _cursor.getLong(_cursorIndexOfSerie);
        }
        _item.setSerie(_tmpSerie);
        final Long _tmpNumeroNotaVOR;
        if (_cursor.isNull(_cursorIndexOfNumeroNotaVOR)) {
          _tmpNumeroNotaVOR = null;
        } else {
          _tmpNumeroNotaVOR = _cursor.getLong(_cursorIndexOfNumeroNotaVOR);
        }
        _item.setNumeroNotaVOR(_tmpNumeroNotaVOR);
        final Long _tmpSerieNotaVOR;
        if (_cursor.isNull(_cursorIndexOfSerieNotaVOR)) {
          _tmpSerieNotaVOR = null;
        } else {
          _tmpSerieNotaVOR = _cursor.getLong(_cursorIndexOfSerieNotaVOR);
        }
        _item.setSerieNotaVOR(_tmpSerieNotaVOR);
        final String _tmpCdPreOrdem;
        _tmpCdPreOrdem = _cursor.getString(_cursorIndexOfCdPreOrdem);
        _item.setCdPreOrdem(_tmpCdPreOrdem);
        final String _tmpNumeroFutEntrega;
        _tmpNumeroFutEntrega = _cursor.getString(_cursorIndexOfNumeroFutEntrega);
        _item.setNumeroFutEntrega(_tmpNumeroFutEntrega);
        final Integer _tmpCdFiscal;
        if (_cursor.isNull(_cursorIndexOfCdFiscal)) {
          _tmpCdFiscal = null;
        } else {
          _tmpCdFiscal = _cursor.getInt(_cursorIndexOfCdFiscal);
        }
        _item.setCdFiscal(_tmpCdFiscal);
        final String _tmpCnpjCpfDestino;
        _tmpCnpjCpfDestino = _cursor.getString(_cursorIndexOfCnpjCpfDestino);
        _item.setCnpjCpfDestino(_tmpCnpjCpfDestino);
        final String _tmpCnpjCpfTransp;
        _tmpCnpjCpfTransp = _cursor.getString(_cursorIndexOfCnpjCpfTransp);
        _item.setCnpjCpfTransp(_tmpCnpjCpfTransp);
        final String _tmpTipoNota;
        _tmpTipoNota = _cursor.getString(_cursorIndexOfTipoNota);
        _item.setTipoNota(_tmpTipoNota);
        final Integer _tmpClasseContribuinte;
        if (_cursor.isNull(_cursorIndexOfClasseContribuinte)) {
          _tmpClasseContribuinte = null;
        } else {
          _tmpClasseContribuinte = _cursor.getInt(_cursorIndexOfClasseContribuinte);
        }
        _item.setClasseContribuinte(_tmpClasseContribuinte);
        final String _tmpDataViagemPrincial;
        _tmpDataViagemPrincial = _cursor.getString(_cursorIndexOfDataViagemPrincial);
        _item.setDataViagemPrincial(_tmpDataViagemPrincial);
        final String _tmpNumeroViagem;
        _tmpNumeroViagem = _cursor.getString(_cursorIndexOfNumeroViagem);
        _item.setNumeroViagem(_tmpNumeroViagem);
        final String _tmpDataViagem;
        _tmpDataViagem = _cursor.getString(_cursorIndexOfDataViagem);
        _item.setDataViagem(_tmpDataViagem);
        final String _tmpNomeOperacao;
        _tmpNomeOperacao = _cursor.getString(_cursorIndexOfNomeOperacao);
        _item.setNomeOperacao(_tmpNomeOperacao);
        final Date _tmpDataEmissao;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfDataEmissao)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfDataEmissao);
        }
        _tmpDataEmissao = DateTypeConverter.fromTimestamp(_tmp);
        _item.setDataEmissao(_tmpDataEmissao);
        final Date _tmpDataMovimento;
        final Long _tmp_1;
        if (_cursor.isNull(_cursorIndexOfDataMovimento)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getLong(_cursorIndexOfDataMovimento);
        }
        _tmpDataMovimento = DateTypeConverter.fromTimestamp(_tmp_1);
        _item.setDataMovimento(_tmpDataMovimento);
        final Date _tmpDataVencimento;
        final Long _tmp_2;
        if (_cursor.isNull(_cursorIndexOfDataVencimento)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getLong(_cursorIndexOfDataVencimento);
        }
        _tmpDataVencimento = DateTypeConverter.fromTimestamp(_tmp_2);
        _item.setDataVencimento(_tmpDataVencimento);
        final Double _tmpValorTotal;
        if (_cursor.isNull(_cursorIndexOfValorTotal)) {
          _tmpValorTotal = null;
        } else {
          _tmpValorTotal = _cursor.getDouble(_cursorIndexOfValorTotal);
        }
        _item.setValorTotal(_tmpValorTotal);
        final Double _tmpValorLiquido;
        if (_cursor.isNull(_cursorIndexOfValorLiquido)) {
          _tmpValorLiquido = null;
        } else {
          _tmpValorLiquido = _cursor.getDouble(_cursorIndexOfValorLiquido);
        }
        _item.setValorLiquido(_tmpValorLiquido);
        final Double _tmpValorTotalProduto;
        if (_cursor.isNull(_cursorIndexOfValorTotalProduto)) {
          _tmpValorTotalProduto = null;
        } else {
          _tmpValorTotalProduto = _cursor.getDouble(_cursorIndexOfValorTotalProduto);
        }
        _item.setValorTotalProduto(_tmpValorTotalProduto);
        final Double _tmpValorFrete;
        if (_cursor.isNull(_cursorIndexOfValorFrete)) {
          _tmpValorFrete = null;
        } else {
          _tmpValorFrete = _cursor.getDouble(_cursorIndexOfValorFrete);
        }
        _item.setValorFrete(_tmpValorFrete);
        final Double _tmpValorDespAcessorias;
        if (_cursor.isNull(_cursorIndexOfValorDespAcessorias)) {
          _tmpValorDespAcessorias = null;
        } else {
          _tmpValorDespAcessorias = _cursor.getDouble(_cursorIndexOfValorDespAcessorias);
        }
        _item.setValorDespAcessorias(_tmpValorDespAcessorias);
        final Double _tmpValorDinheiro;
        if (_cursor.isNull(_cursorIndexOfValorDinheiro)) {
          _tmpValorDinheiro = null;
        } else {
          _tmpValorDinheiro = _cursor.getDouble(_cursorIndexOfValorDinheiro);
        }
        _item.setValorDinheiro(_tmpValorDinheiro);
        final Double _tmpValorTroco;
        if (_cursor.isNull(_cursorIndexOfValorTroco)) {
          _tmpValorTroco = null;
        } else {
          _tmpValorTroco = _cursor.getDouble(_cursorIndexOfValorTroco);
        }
        _item.setValorTroco(_tmpValorTroco);
        final Double _tmpValorFatura;
        if (_cursor.isNull(_cursorIndexOfValorFatura)) {
          _tmpValorFatura = null;
        } else {
          _tmpValorFatura = _cursor.getDouble(_cursorIndexOfValorFatura);
        }
        _item.setValorFatura(_tmpValorFatura);
        final Double _tmpValorDebito;
        if (_cursor.isNull(_cursorIndexOfValorDebito)) {
          _tmpValorDebito = null;
        } else {
          _tmpValorDebito = _cursor.getDouble(_cursorIndexOfValorDebito);
        }
        _item.setValorDebito(_tmpValorDebito);
        final Double _tmpValorCredito;
        if (_cursor.isNull(_cursorIndexOfValorCredito)) {
          _tmpValorCredito = null;
        } else {
          _tmpValorCredito = _cursor.getDouble(_cursorIndexOfValorCredito);
        }
        _item.setValorCredito(_tmpValorCredito);
        final Double _tmpValorCheque;
        if (_cursor.isNull(_cursorIndexOfValorCheque)) {
          _tmpValorCheque = null;
        } else {
          _tmpValorCheque = _cursor.getDouble(_cursorIndexOfValorCheque);
        }
        _item.setValorCheque(_tmpValorCheque);
        final String _tmpNumeroCheque;
        _tmpNumeroCheque = _cursor.getString(_cursorIndexOfNumeroCheque);
        _item.setNumeroCheque(_tmpNumeroCheque);
        final String _tmpUfVeiculo;
        _tmpUfVeiculo = _cursor.getString(_cursorIndexOfUfVeiculo);
        _item.setUfVeiculo(_tmpUfVeiculo);
        final String _tmpPlacaVeiculo;
        _tmpPlacaVeiculo = _cursor.getString(_cursorIndexOfPlacaVeiculo);
        _item.setPlacaVeiculo(_tmpPlacaVeiculo);
        final String _tmpNumeroVeiculo;
        _tmpNumeroVeiculo = _cursor.getString(_cursorIndexOfNumeroVeiculo);
        _item.setNumeroVeiculo(_tmpNumeroVeiculo);
        final Integer _tmpModalidadeFrete;
        if (_cursor.isNull(_cursorIndexOfModalidadeFrete)) {
          _tmpModalidadeFrete = null;
        } else {
          _tmpModalidadeFrete = _cursor.getInt(_cursorIndexOfModalidadeFrete);
        }
        _item.setModalidadeFrete(_tmpModalidadeFrete);
        final String _tmpNomeEspecVolume;
        _tmpNomeEspecVolume = _cursor.getString(_cursorIndexOfNomeEspecVolume);
        _item.setNomeEspecVolume(_tmpNomeEspecVolume);
        final String _tmpNomeMarca;
        _tmpNomeMarca = _cursor.getString(_cursorIndexOfNomeMarca);
        _item.setNomeMarca(_tmpNomeMarca);
        final Integer _tmpQtdVolumes;
        if (_cursor.isNull(_cursorIndexOfQtdVolumes)) {
          _tmpQtdVolumes = null;
        } else {
          _tmpQtdVolumes = _cursor.getInt(_cursorIndexOfQtdVolumes);
        }
        _item.setQtdVolumes(_tmpQtdVolumes);
        final Double _tmpVolumeCapacidade;
        if (_cursor.isNull(_cursorIndexOfVolumeCapacidade)) {
          _tmpVolumeCapacidade = null;
        } else {
          _tmpVolumeCapacidade = _cursor.getDouble(_cursorIndexOfVolumeCapacidade);
        }
        _item.setVolumeCapacidade(_tmpVolumeCapacidade);
        final Double _tmpVolumeCapacidadeReport;
        if (_cursor.isNull(_cursorIndexOfVolumeCapacidadeReport)) {
          _tmpVolumeCapacidadeReport = null;
        } else {
          _tmpVolumeCapacidadeReport = _cursor.getDouble(_cursorIndexOfVolumeCapacidadeReport);
        }
        _item.setVolumeCapacidadeReport(_tmpVolumeCapacidadeReport);
        final Double _tmpPesoBruto;
        if (_cursor.isNull(_cursorIndexOfPesoBruto)) {
          _tmpPesoBruto = null;
        } else {
          _tmpPesoBruto = _cursor.getDouble(_cursorIndexOfPesoBruto);
        }
        _item.setPesoBruto(_tmpPesoBruto);
        final Double _tmpPesoLiquido;
        if (_cursor.isNull(_cursorIndexOfPesoLiquido)) {
          _tmpPesoLiquido = null;
        } else {
          _tmpPesoLiquido = _cursor.getDouble(_cursorIndexOfPesoLiquido);
        }
        _item.setPesoLiquido(_tmpPesoLiquido);
        final String _tmpTipoPedido;
        _tmpTipoPedido = _cursor.getString(_cursorIndexOfTipoPedido);
        _item.setTipoPedido(_tmpTipoPedido);
        final Long _tmpCdCustomer;
        if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
          _tmpCdCustomer = null;
        } else {
          _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
        }
        _item.setCdCustomer(_tmpCdCustomer);
        final String _tmpAtivaTipoPagto;
        _tmpAtivaTipoPagto = _cursor.getString(_cursorIndexOfAtivaTipoPagto);
        _item.setAtivaTipoPagto(_tmpAtivaTipoPagto);
        final Integer _tmpStepEmissao;
        if (_cursor.isNull(_cursorIndexOfStepEmissao)) {
          _tmpStepEmissao = null;
        } else {
          _tmpStepEmissao = _cursor.getInt(_cursorIndexOfStepEmissao);
        }
        _item.setStepEmissao(_tmpStepEmissao);
        final String _tmpChave;
        _tmpChave = _cursor.getString(_cursorIndexOfChave);
        _item.setChave(_tmpChave);
        final String _tmpProtocolo;
        _tmpProtocolo = _cursor.getString(_cursorIndexOfProtocolo);
        _item.setProtocolo(_tmpProtocolo);
        final String _tmpCdMovimento;
        _tmpCdMovimento = _cursor.getString(_cursorIndexOfCdMovimento);
        _item.setCdMovimento(_tmpCdMovimento);
        final String _tmpCondicaoPagamento;
        _tmpCondicaoPagamento = _cursor.getString(_cursorIndexOfCondicaoPagamento);
        _item.setCondicaoPagamento(_tmpCondicaoPagamento);
        final Double _tmpAliquotaIcms;
        if (_cursor.isNull(_cursorIndexOfAliquotaIcms)) {
          _tmpAliquotaIcms = null;
        } else {
          _tmpAliquotaIcms = _cursor.getDouble(_cursorIndexOfAliquotaIcms);
        }
        _item.setAliquotaIcms(_tmpAliquotaIcms);
        final Double _tmpValorDescontoIcms;
        if (_cursor.isNull(_cursorIndexOfValorDescontoIcms)) {
          _tmpValorDescontoIcms = null;
        } else {
          _tmpValorDescontoIcms = _cursor.getDouble(_cursorIndexOfValorDescontoIcms);
        }
        _item.setValorDescontoIcms(_tmpValorDescontoIcms);
        final Double _tmpValorIcms;
        if (_cursor.isNull(_cursorIndexOfValorIcms)) {
          _tmpValorIcms = null;
        } else {
          _tmpValorIcms = _cursor.getDouble(_cursorIndexOfValorIcms);
        }
        _item.setValorIcms(_tmpValorIcms);
        final Double _tmpBaseCalculoIcms;
        if (_cursor.isNull(_cursorIndexOfBaseCalculoIcms)) {
          _tmpBaseCalculoIcms = null;
        } else {
          _tmpBaseCalculoIcms = _cursor.getDouble(_cursorIndexOfBaseCalculoIcms);
        }
        _item.setBaseCalculoIcms(_tmpBaseCalculoIcms);
        final Integer _tmpSituacaoTributariaIcms;
        if (_cursor.isNull(_cursorIndexOfSituacaoTributariaIcms)) {
          _tmpSituacaoTributariaIcms = null;
        } else {
          _tmpSituacaoTributariaIcms = _cursor.getInt(_cursorIndexOfSituacaoTributariaIcms);
        }
        _item.setSituacaoTributariaIcms(_tmpSituacaoTributariaIcms);
        final Double _tmpValorIpi;
        if (_cursor.isNull(_cursorIndexOfValorIpi)) {
          _tmpValorIpi = null;
        } else {
          _tmpValorIpi = _cursor.getDouble(_cursorIndexOfValorIpi);
        }
        _item.setValorIpi(_tmpValorIpi);
        final Double _tmpBaseCalculoIpi;
        if (_cursor.isNull(_cursorIndexOfBaseCalculoIpi)) {
          _tmpBaseCalculoIpi = null;
        } else {
          _tmpBaseCalculoIpi = _cursor.getDouble(_cursorIndexOfBaseCalculoIpi);
        }
        _item.setBaseCalculoIpi(_tmpBaseCalculoIpi);
        final Integer _tmpSituacaoTributariaIpi;
        if (_cursor.isNull(_cursorIndexOfSituacaoTributariaIpi)) {
          _tmpSituacaoTributariaIpi = null;
        } else {
          _tmpSituacaoTributariaIpi = _cursor.getInt(_cursorIndexOfSituacaoTributariaIpi);
        }
        _item.setSituacaoTributariaIpi(_tmpSituacaoTributariaIpi);
        final String _tmpFlNovoFaturamento;
        _tmpFlNovoFaturamento = _cursor.getString(_cursorIndexOfFlNovoFaturamento);
        _item.setFlNovoFaturamento(_tmpFlNovoFaturamento);
        final Long _tmpCdOperadora;
        if (_cursor.isNull(_cursorIndexOfCdOperadora)) {
          _tmpCdOperadora = null;
        } else {
          _tmpCdOperadora = _cursor.getLong(_cursorIndexOfCdOperadora);
        }
        _item.setCdOperadora(_tmpCdOperadora);
        final String _tmpFlPaciente;
        _tmpFlPaciente = _cursor.getString(_cursorIndexOfFlPaciente);
        _item.setFlPaciente(_tmpFlPaciente);
        final Long _tmpCdCustomerService;
        if (_cursor.isNull(_cursorIndexOfCdCustomerService)) {
          _tmpCdCustomerService = null;
        } else {
          _tmpCdCustomerService = _cursor.getLong(_cursorIndexOfCdCustomerService);
        }
        _item.setCdCustomerService(_tmpCdCustomerService);
        final String _tmpNomeAssinadorCec;
        _tmpNomeAssinadorCec = _cursor.getString(_cursorIndexOfNomeAssinadorCec);
        _item.setNomeAssinadorCec(_tmpNomeAssinadorCec);
        final String _tmpRgAssinadorCec;
        _tmpRgAssinadorCec = _cursor.getString(_cursorIndexOfRgAssinadorCec);
        _item.setRgAssinadorCec(_tmpRgAssinadorCec);
        final Integer _tmpTipoMovimentoIntegracao;
        if (_cursor.isNull(_cursorIndexOfTipoMovimentoIntegracao)) {
          _tmpTipoMovimentoIntegracao = null;
        } else {
          _tmpTipoMovimentoIntegracao = _cursor.getInt(_cursorIndexOfTipoMovimentoIntegracao);
        }
        _item.setTipoMovimentoIntegracao(_tmpTipoMovimentoIntegracao);
        final String _tmpSemPagto;
        _tmpSemPagto = _cursor.getString(_cursorIndexOfSemPagto);
        _item.setSemPagto(_tmpSemPagto);
        final Integer _tmpStatusGravacaoJde;
        if (_cursor.isNull(_cursorIndexOfStatusGravacaoJde)) {
          _tmpStatusGravacaoJde = null;
        } else {
          _tmpStatusGravacaoJde = _cursor.getInt(_cursorIndexOfStatusGravacaoJde);
        }
        _item.setStatusGravacaoJde(_tmpStatusGravacaoJde);
        final String _tmpMensagemGravacaoJde;
        _tmpMensagemGravacaoJde = _cursor.getString(_cursorIndexOfMensagemGravacaoJde);
        _item.setMensagemGravacaoJde(_tmpMensagemGravacaoJde);
        final Integer _tmpTipoTransacao;
        if (_cursor.isNull(_cursorIndexOfTipoTransacao)) {
          _tmpTipoTransacao = null;
        } else {
          _tmpTipoTransacao = _cursor.getInt(_cursorIndexOfTipoTransacao);
        }
        _item.setTipoTransacao(_tmpTipoTransacao);
        final Integer _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
        }
        _item.setStatus(_tmpStatus);
        final String _tmpStatusContingencia;
        _tmpStatusContingencia = _cursor.getString(_cursorIndexOfStatusContingencia);
        _item.setStatusContingencia(_tmpStatusContingencia);
        final String _tmpMensagemContingencia;
        _tmpMensagemContingencia = _cursor.getString(_cursorIndexOfMensagemContingencia);
        _item.setMensagemContingencia(_tmpMensagemContingencia);
        final Integer _tmpStatusCec;
        if (_cursor.isNull(_cursorIndexOfStatusCec)) {
          _tmpStatusCec = null;
        } else {
          _tmpStatusCec = _cursor.getInt(_cursorIndexOfStatusCec);
        }
        _item.setStatusCec(_tmpStatusCec);
        final String _tmpNomeTransacao;
        _tmpNomeTransacao = _cursor.getString(_cursorIndexOfNomeTransacao);
        _item.setNomeTransacao(_tmpNomeTransacao);
        final Integer _tmpStatusImpressaoCec;
        if (_cursor.isNull(_cursorIndexOfStatusImpressaoCec)) {
          _tmpStatusImpressaoCec = null;
        } else {
          _tmpStatusImpressaoCec = _cursor.getInt(_cursorIndexOfStatusImpressaoCec);
        }
        _item.setStatusImpressaoCec(_tmpStatusImpressaoCec);
        final String _tmpNomeFormaImpressaoCec;
        _tmpNomeFormaImpressaoCec = _cursor.getString(_cursorIndexOfNomeFormaImpressaoCec);
        _item.setNomeFormaImpressaoCec(_tmpNomeFormaImpressaoCec);
        final String _tmpNomeStatus;
        _tmpNomeStatus = _cursor.getString(_cursorIndexOfNomeStatus);
        _item.setNomeStatus(_tmpNomeStatus);
        final String _tmpNomeStatusImpressaoCec;
        _tmpNomeStatusImpressaoCec = _cursor.getString(_cursorIndexOfNomeStatusImpressaoCec);
        _item.setNomeStatusImpressaoCec(_tmpNomeStatusImpressaoCec);
        final String _tmpFlPrecoAlterado;
        _tmpFlPrecoAlterado = _cursor.getString(_cursorIndexOfFlPrecoAlterado);
        _item.setFlPrecoAlterado(_tmpFlPrecoAlterado);
        final String _tmpNomeTipoPagamento;
        _tmpNomeTipoPagamento = _cursor.getString(_cursorIndexOfNomeTipoPagamento);
        _item.setNomeTipoPagamento(_tmpNomeTipoPagamento);
        final String _tmpCdMotivo;
        _tmpCdMotivo = _cursor.getString(_cursorIndexOfCdMotivo);
        _item.setCdMotivo(_tmpCdMotivo);
        final String _tmpDsMotivo;
        _tmpDsMotivo = _cursor.getString(_cursorIndexOfDsMotivo);
        _item.setDsMotivo(_tmpDsMotivo);
        final String _tmpStatusNfeImp;
        _tmpStatusNfeImp = _cursor.getString(_cursorIndexOfStatusNfeImp);
        _item.setStatusNfeImp(_tmpStatusNfeImp);
        final String _tmpStatusReportFile;
        _tmpStatusReportFile = _cursor.getString(_cursorIndexOfStatusReportFile);
        _item.setStatusReportFile(_tmpStatusReportFile);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Invoice> find(List<Integer> statusNFe, Integer stepEmissao) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT * FROM Invoice WHERE status IN (");
    final int _inputSize = statusNFe.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") AND stepEmissao = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" ORDER BY numero");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 1 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (Integer _item : statusNFe) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item);
      }
      _argIndex ++;
    }
    _argIndex = 1 + _inputSize;
    if (stepEmissao == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, stepEmissao);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfNumero = _cursor.getColumnIndexOrThrow("numero");
      final int _cursorIndexOfSerie = _cursor.getColumnIndexOrThrow("serie");
      final int _cursorIndexOfNumeroNotaVOR = _cursor.getColumnIndexOrThrow("numeroNotaVOR");
      final int _cursorIndexOfSerieNotaVOR = _cursor.getColumnIndexOrThrow("serieNotaVOR");
      final int _cursorIndexOfCdPreOrdem = _cursor.getColumnIndexOrThrow("cdPreOrdem");
      final int _cursorIndexOfNumeroFutEntrega = _cursor.getColumnIndexOrThrow("numeroFutEntrega");
      final int _cursorIndexOfCdFiscal = _cursor.getColumnIndexOrThrow("cdFiscal");
      final int _cursorIndexOfCnpjCpfDestino = _cursor.getColumnIndexOrThrow("cnpjCpfDestino");
      final int _cursorIndexOfCnpjCpfTransp = _cursor.getColumnIndexOrThrow("cnpjCpfTransp");
      final int _cursorIndexOfTipoNota = _cursor.getColumnIndexOrThrow("tipoNota");
      final int _cursorIndexOfClasseContribuinte = _cursor.getColumnIndexOrThrow("classeContribuinte");
      final int _cursorIndexOfDataViagemPrincial = _cursor.getColumnIndexOrThrow("dataViagemPrincial");
      final int _cursorIndexOfNumeroViagem = _cursor.getColumnIndexOrThrow("numeroViagem");
      final int _cursorIndexOfDataViagem = _cursor.getColumnIndexOrThrow("dataViagem");
      final int _cursorIndexOfNomeOperacao = _cursor.getColumnIndexOrThrow("nomeOperacao");
      final int _cursorIndexOfDataEmissao = _cursor.getColumnIndexOrThrow("dataEmissao");
      final int _cursorIndexOfDataMovimento = _cursor.getColumnIndexOrThrow("dataMovimento");
      final int _cursorIndexOfDataVencimento = _cursor.getColumnIndexOrThrow("dataVencimento");
      final int _cursorIndexOfValorTotal = _cursor.getColumnIndexOrThrow("valorTotal");
      final int _cursorIndexOfValorLiquido = _cursor.getColumnIndexOrThrow("valorLiquido");
      final int _cursorIndexOfValorTotalProduto = _cursor.getColumnIndexOrThrow("valorTotalProduto");
      final int _cursorIndexOfValorFrete = _cursor.getColumnIndexOrThrow("valorFrete");
      final int _cursorIndexOfValorDespAcessorias = _cursor.getColumnIndexOrThrow("valorDespAcessorias");
      final int _cursorIndexOfValorDinheiro = _cursor.getColumnIndexOrThrow("valorDinheiro");
      final int _cursorIndexOfValorTroco = _cursor.getColumnIndexOrThrow("valorTroco");
      final int _cursorIndexOfValorFatura = _cursor.getColumnIndexOrThrow("valorFatura");
      final int _cursorIndexOfValorDebito = _cursor.getColumnIndexOrThrow("valorDebito");
      final int _cursorIndexOfValorCredito = _cursor.getColumnIndexOrThrow("valorCredito");
      final int _cursorIndexOfValorCheque = _cursor.getColumnIndexOrThrow("valorCheque");
      final int _cursorIndexOfNumeroCheque = _cursor.getColumnIndexOrThrow("numeroCheque");
      final int _cursorIndexOfUfVeiculo = _cursor.getColumnIndexOrThrow("ufVeiculo");
      final int _cursorIndexOfPlacaVeiculo = _cursor.getColumnIndexOrThrow("placaVeiculo");
      final int _cursorIndexOfNumeroVeiculo = _cursor.getColumnIndexOrThrow("numeroVeiculo");
      final int _cursorIndexOfModalidadeFrete = _cursor.getColumnIndexOrThrow("modalidadeFrete");
      final int _cursorIndexOfNomeEspecVolume = _cursor.getColumnIndexOrThrow("nomeEspecVolume");
      final int _cursorIndexOfNomeMarca = _cursor.getColumnIndexOrThrow("nomeMarca");
      final int _cursorIndexOfQtdVolumes = _cursor.getColumnIndexOrThrow("qtdVolumes");
      final int _cursorIndexOfVolumeCapacidade = _cursor.getColumnIndexOrThrow("volumeCapacidade");
      final int _cursorIndexOfVolumeCapacidadeReport = _cursor.getColumnIndexOrThrow("volumeCapacidadeReport");
      final int _cursorIndexOfPesoBruto = _cursor.getColumnIndexOrThrow("pesoBruto");
      final int _cursorIndexOfPesoLiquido = _cursor.getColumnIndexOrThrow("pesoLiquido");
      final int _cursorIndexOfTipoPedido = _cursor.getColumnIndexOrThrow("tipoPedido");
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfAtivaTipoPagto = _cursor.getColumnIndexOrThrow("ativaTipoPagto");
      final int _cursorIndexOfStepEmissao = _cursor.getColumnIndexOrThrow("stepEmissao");
      final int _cursorIndexOfChave = _cursor.getColumnIndexOrThrow("chave");
      final int _cursorIndexOfProtocolo = _cursor.getColumnIndexOrThrow("protocolo");
      final int _cursorIndexOfCdMovimento = _cursor.getColumnIndexOrThrow("cdMovimento");
      final int _cursorIndexOfCondicaoPagamento = _cursor.getColumnIndexOrThrow("condicaoPagamento");
      final int _cursorIndexOfAliquotaIcms = _cursor.getColumnIndexOrThrow("aliquotaIcms");
      final int _cursorIndexOfValorDescontoIcms = _cursor.getColumnIndexOrThrow("valorDescontoIcms");
      final int _cursorIndexOfValorIcms = _cursor.getColumnIndexOrThrow("valorIcms");
      final int _cursorIndexOfBaseCalculoIcms = _cursor.getColumnIndexOrThrow("baseCalculoIcms");
      final int _cursorIndexOfSituacaoTributariaIcms = _cursor.getColumnIndexOrThrow("situacaoTributariaIcms");
      final int _cursorIndexOfValorIpi = _cursor.getColumnIndexOrThrow("valorIpi");
      final int _cursorIndexOfBaseCalculoIpi = _cursor.getColumnIndexOrThrow("baseCalculoIpi");
      final int _cursorIndexOfSituacaoTributariaIpi = _cursor.getColumnIndexOrThrow("situacaoTributariaIpi");
      final int _cursorIndexOfFlNovoFaturamento = _cursor.getColumnIndexOrThrow("flNovoFaturamento");
      final int _cursorIndexOfCdOperadora = _cursor.getColumnIndexOrThrow("cdOperadora");
      final int _cursorIndexOfFlPaciente = _cursor.getColumnIndexOrThrow("flPaciente");
      final int _cursorIndexOfCdCustomerService = _cursor.getColumnIndexOrThrow("cdCustomerService");
      final int _cursorIndexOfNomeAssinadorCec = _cursor.getColumnIndexOrThrow("nomeAssinadorCec");
      final int _cursorIndexOfRgAssinadorCec = _cursor.getColumnIndexOrThrow("rgAssinadorCec");
      final int _cursorIndexOfTipoMovimentoIntegracao = _cursor.getColumnIndexOrThrow("tipoMovimentoIntegracao");
      final int _cursorIndexOfSemPagto = _cursor.getColumnIndexOrThrow("semPagto");
      final int _cursorIndexOfStatusGravacaoJde = _cursor.getColumnIndexOrThrow("statusGravacaoJde");
      final int _cursorIndexOfMensagemGravacaoJde = _cursor.getColumnIndexOrThrow("mensagemGravacaoJde");
      final int _cursorIndexOfTipoTransacao = _cursor.getColumnIndexOrThrow("tipoTransacao");
      final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("status");
      final int _cursorIndexOfStatusContingencia = _cursor.getColumnIndexOrThrow("statusContingencia");
      final int _cursorIndexOfMensagemContingencia = _cursor.getColumnIndexOrThrow("mensagemContingencia");
      final int _cursorIndexOfStatusCec = _cursor.getColumnIndexOrThrow("statusCec");
      final int _cursorIndexOfNomeTransacao = _cursor.getColumnIndexOrThrow("nomeTransacao");
      final int _cursorIndexOfStatusImpressaoCec = _cursor.getColumnIndexOrThrow("statusImpressaoCec");
      final int _cursorIndexOfNomeFormaImpressaoCec = _cursor.getColumnIndexOrThrow("nomeFormaImpressaoCec");
      final int _cursorIndexOfNomeStatus = _cursor.getColumnIndexOrThrow("nomeStatus");
      final int _cursorIndexOfNomeStatusImpressaoCec = _cursor.getColumnIndexOrThrow("nomeStatusImpressaoCec");
      final int _cursorIndexOfFlPrecoAlterado = _cursor.getColumnIndexOrThrow("flPrecoAlterado");
      final int _cursorIndexOfNomeTipoPagamento = _cursor.getColumnIndexOrThrow("nomeTipoPagamento");
      final int _cursorIndexOfCdMotivo = _cursor.getColumnIndexOrThrow("cdMotivo");
      final int _cursorIndexOfDsMotivo = _cursor.getColumnIndexOrThrow("dsMotivo");
      final int _cursorIndexOfStatusNfeImp = _cursor.getColumnIndexOrThrow("statusNfeImp");
      final int _cursorIndexOfStatusReportFile = _cursor.getColumnIndexOrThrow("statusReportFile");
      final List<Invoice> _result = new ArrayList<Invoice>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Invoice _item_1;
        _item_1 = new Invoice();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _item_1.setId(_tmpId);
        final Long _tmpNumero;
        if (_cursor.isNull(_cursorIndexOfNumero)) {
          _tmpNumero = null;
        } else {
          _tmpNumero = _cursor.getLong(_cursorIndexOfNumero);
        }
        _item_1.setNumero(_tmpNumero);
        final Long _tmpSerie;
        if (_cursor.isNull(_cursorIndexOfSerie)) {
          _tmpSerie = null;
        } else {
          _tmpSerie = _cursor.getLong(_cursorIndexOfSerie);
        }
        _item_1.setSerie(_tmpSerie);
        final Long _tmpNumeroNotaVOR;
        if (_cursor.isNull(_cursorIndexOfNumeroNotaVOR)) {
          _tmpNumeroNotaVOR = null;
        } else {
          _tmpNumeroNotaVOR = _cursor.getLong(_cursorIndexOfNumeroNotaVOR);
        }
        _item_1.setNumeroNotaVOR(_tmpNumeroNotaVOR);
        final Long _tmpSerieNotaVOR;
        if (_cursor.isNull(_cursorIndexOfSerieNotaVOR)) {
          _tmpSerieNotaVOR = null;
        } else {
          _tmpSerieNotaVOR = _cursor.getLong(_cursorIndexOfSerieNotaVOR);
        }
        _item_1.setSerieNotaVOR(_tmpSerieNotaVOR);
        final String _tmpCdPreOrdem;
        _tmpCdPreOrdem = _cursor.getString(_cursorIndexOfCdPreOrdem);
        _item_1.setCdPreOrdem(_tmpCdPreOrdem);
        final String _tmpNumeroFutEntrega;
        _tmpNumeroFutEntrega = _cursor.getString(_cursorIndexOfNumeroFutEntrega);
        _item_1.setNumeroFutEntrega(_tmpNumeroFutEntrega);
        final Integer _tmpCdFiscal;
        if (_cursor.isNull(_cursorIndexOfCdFiscal)) {
          _tmpCdFiscal = null;
        } else {
          _tmpCdFiscal = _cursor.getInt(_cursorIndexOfCdFiscal);
        }
        _item_1.setCdFiscal(_tmpCdFiscal);
        final String _tmpCnpjCpfDestino;
        _tmpCnpjCpfDestino = _cursor.getString(_cursorIndexOfCnpjCpfDestino);
        _item_1.setCnpjCpfDestino(_tmpCnpjCpfDestino);
        final String _tmpCnpjCpfTransp;
        _tmpCnpjCpfTransp = _cursor.getString(_cursorIndexOfCnpjCpfTransp);
        _item_1.setCnpjCpfTransp(_tmpCnpjCpfTransp);
        final String _tmpTipoNota;
        _tmpTipoNota = _cursor.getString(_cursorIndexOfTipoNota);
        _item_1.setTipoNota(_tmpTipoNota);
        final Integer _tmpClasseContribuinte;
        if (_cursor.isNull(_cursorIndexOfClasseContribuinte)) {
          _tmpClasseContribuinte = null;
        } else {
          _tmpClasseContribuinte = _cursor.getInt(_cursorIndexOfClasseContribuinte);
        }
        _item_1.setClasseContribuinte(_tmpClasseContribuinte);
        final String _tmpDataViagemPrincial;
        _tmpDataViagemPrincial = _cursor.getString(_cursorIndexOfDataViagemPrincial);
        _item_1.setDataViagemPrincial(_tmpDataViagemPrincial);
        final String _tmpNumeroViagem;
        _tmpNumeroViagem = _cursor.getString(_cursorIndexOfNumeroViagem);
        _item_1.setNumeroViagem(_tmpNumeroViagem);
        final String _tmpDataViagem;
        _tmpDataViagem = _cursor.getString(_cursorIndexOfDataViagem);
        _item_1.setDataViagem(_tmpDataViagem);
        final String _tmpNomeOperacao;
        _tmpNomeOperacao = _cursor.getString(_cursorIndexOfNomeOperacao);
        _item_1.setNomeOperacao(_tmpNomeOperacao);
        final Date _tmpDataEmissao;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfDataEmissao)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfDataEmissao);
        }
        _tmpDataEmissao = DateTypeConverter.fromTimestamp(_tmp);
        _item_1.setDataEmissao(_tmpDataEmissao);
        final Date _tmpDataMovimento;
        final Long _tmp_1;
        if (_cursor.isNull(_cursorIndexOfDataMovimento)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getLong(_cursorIndexOfDataMovimento);
        }
        _tmpDataMovimento = DateTypeConverter.fromTimestamp(_tmp_1);
        _item_1.setDataMovimento(_tmpDataMovimento);
        final Date _tmpDataVencimento;
        final Long _tmp_2;
        if (_cursor.isNull(_cursorIndexOfDataVencimento)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getLong(_cursorIndexOfDataVencimento);
        }
        _tmpDataVencimento = DateTypeConverter.fromTimestamp(_tmp_2);
        _item_1.setDataVencimento(_tmpDataVencimento);
        final Double _tmpValorTotal;
        if (_cursor.isNull(_cursorIndexOfValorTotal)) {
          _tmpValorTotal = null;
        } else {
          _tmpValorTotal = _cursor.getDouble(_cursorIndexOfValorTotal);
        }
        _item_1.setValorTotal(_tmpValorTotal);
        final Double _tmpValorLiquido;
        if (_cursor.isNull(_cursorIndexOfValorLiquido)) {
          _tmpValorLiquido = null;
        } else {
          _tmpValorLiquido = _cursor.getDouble(_cursorIndexOfValorLiquido);
        }
        _item_1.setValorLiquido(_tmpValorLiquido);
        final Double _tmpValorTotalProduto;
        if (_cursor.isNull(_cursorIndexOfValorTotalProduto)) {
          _tmpValorTotalProduto = null;
        } else {
          _tmpValorTotalProduto = _cursor.getDouble(_cursorIndexOfValorTotalProduto);
        }
        _item_1.setValorTotalProduto(_tmpValorTotalProduto);
        final Double _tmpValorFrete;
        if (_cursor.isNull(_cursorIndexOfValorFrete)) {
          _tmpValorFrete = null;
        } else {
          _tmpValorFrete = _cursor.getDouble(_cursorIndexOfValorFrete);
        }
        _item_1.setValorFrete(_tmpValorFrete);
        final Double _tmpValorDespAcessorias;
        if (_cursor.isNull(_cursorIndexOfValorDespAcessorias)) {
          _tmpValorDespAcessorias = null;
        } else {
          _tmpValorDespAcessorias = _cursor.getDouble(_cursorIndexOfValorDespAcessorias);
        }
        _item_1.setValorDespAcessorias(_tmpValorDespAcessorias);
        final Double _tmpValorDinheiro;
        if (_cursor.isNull(_cursorIndexOfValorDinheiro)) {
          _tmpValorDinheiro = null;
        } else {
          _tmpValorDinheiro = _cursor.getDouble(_cursorIndexOfValorDinheiro);
        }
        _item_1.setValorDinheiro(_tmpValorDinheiro);
        final Double _tmpValorTroco;
        if (_cursor.isNull(_cursorIndexOfValorTroco)) {
          _tmpValorTroco = null;
        } else {
          _tmpValorTroco = _cursor.getDouble(_cursorIndexOfValorTroco);
        }
        _item_1.setValorTroco(_tmpValorTroco);
        final Double _tmpValorFatura;
        if (_cursor.isNull(_cursorIndexOfValorFatura)) {
          _tmpValorFatura = null;
        } else {
          _tmpValorFatura = _cursor.getDouble(_cursorIndexOfValorFatura);
        }
        _item_1.setValorFatura(_tmpValorFatura);
        final Double _tmpValorDebito;
        if (_cursor.isNull(_cursorIndexOfValorDebito)) {
          _tmpValorDebito = null;
        } else {
          _tmpValorDebito = _cursor.getDouble(_cursorIndexOfValorDebito);
        }
        _item_1.setValorDebito(_tmpValorDebito);
        final Double _tmpValorCredito;
        if (_cursor.isNull(_cursorIndexOfValorCredito)) {
          _tmpValorCredito = null;
        } else {
          _tmpValorCredito = _cursor.getDouble(_cursorIndexOfValorCredito);
        }
        _item_1.setValorCredito(_tmpValorCredito);
        final Double _tmpValorCheque;
        if (_cursor.isNull(_cursorIndexOfValorCheque)) {
          _tmpValorCheque = null;
        } else {
          _tmpValorCheque = _cursor.getDouble(_cursorIndexOfValorCheque);
        }
        _item_1.setValorCheque(_tmpValorCheque);
        final String _tmpNumeroCheque;
        _tmpNumeroCheque = _cursor.getString(_cursorIndexOfNumeroCheque);
        _item_1.setNumeroCheque(_tmpNumeroCheque);
        final String _tmpUfVeiculo;
        _tmpUfVeiculo = _cursor.getString(_cursorIndexOfUfVeiculo);
        _item_1.setUfVeiculo(_tmpUfVeiculo);
        final String _tmpPlacaVeiculo;
        _tmpPlacaVeiculo = _cursor.getString(_cursorIndexOfPlacaVeiculo);
        _item_1.setPlacaVeiculo(_tmpPlacaVeiculo);
        final String _tmpNumeroVeiculo;
        _tmpNumeroVeiculo = _cursor.getString(_cursorIndexOfNumeroVeiculo);
        _item_1.setNumeroVeiculo(_tmpNumeroVeiculo);
        final Integer _tmpModalidadeFrete;
        if (_cursor.isNull(_cursorIndexOfModalidadeFrete)) {
          _tmpModalidadeFrete = null;
        } else {
          _tmpModalidadeFrete = _cursor.getInt(_cursorIndexOfModalidadeFrete);
        }
        _item_1.setModalidadeFrete(_tmpModalidadeFrete);
        final String _tmpNomeEspecVolume;
        _tmpNomeEspecVolume = _cursor.getString(_cursorIndexOfNomeEspecVolume);
        _item_1.setNomeEspecVolume(_tmpNomeEspecVolume);
        final String _tmpNomeMarca;
        _tmpNomeMarca = _cursor.getString(_cursorIndexOfNomeMarca);
        _item_1.setNomeMarca(_tmpNomeMarca);
        final Integer _tmpQtdVolumes;
        if (_cursor.isNull(_cursorIndexOfQtdVolumes)) {
          _tmpQtdVolumes = null;
        } else {
          _tmpQtdVolumes = _cursor.getInt(_cursorIndexOfQtdVolumes);
        }
        _item_1.setQtdVolumes(_tmpQtdVolumes);
        final Double _tmpVolumeCapacidade;
        if (_cursor.isNull(_cursorIndexOfVolumeCapacidade)) {
          _tmpVolumeCapacidade = null;
        } else {
          _tmpVolumeCapacidade = _cursor.getDouble(_cursorIndexOfVolumeCapacidade);
        }
        _item_1.setVolumeCapacidade(_tmpVolumeCapacidade);
        final Double _tmpVolumeCapacidadeReport;
        if (_cursor.isNull(_cursorIndexOfVolumeCapacidadeReport)) {
          _tmpVolumeCapacidadeReport = null;
        } else {
          _tmpVolumeCapacidadeReport = _cursor.getDouble(_cursorIndexOfVolumeCapacidadeReport);
        }
        _item_1.setVolumeCapacidadeReport(_tmpVolumeCapacidadeReport);
        final Double _tmpPesoBruto;
        if (_cursor.isNull(_cursorIndexOfPesoBruto)) {
          _tmpPesoBruto = null;
        } else {
          _tmpPesoBruto = _cursor.getDouble(_cursorIndexOfPesoBruto);
        }
        _item_1.setPesoBruto(_tmpPesoBruto);
        final Double _tmpPesoLiquido;
        if (_cursor.isNull(_cursorIndexOfPesoLiquido)) {
          _tmpPesoLiquido = null;
        } else {
          _tmpPesoLiquido = _cursor.getDouble(_cursorIndexOfPesoLiquido);
        }
        _item_1.setPesoLiquido(_tmpPesoLiquido);
        final String _tmpTipoPedido;
        _tmpTipoPedido = _cursor.getString(_cursorIndexOfTipoPedido);
        _item_1.setTipoPedido(_tmpTipoPedido);
        final Long _tmpCdCustomer;
        if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
          _tmpCdCustomer = null;
        } else {
          _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
        }
        _item_1.setCdCustomer(_tmpCdCustomer);
        final String _tmpAtivaTipoPagto;
        _tmpAtivaTipoPagto = _cursor.getString(_cursorIndexOfAtivaTipoPagto);
        _item_1.setAtivaTipoPagto(_tmpAtivaTipoPagto);
        final Integer _tmpStepEmissao;
        if (_cursor.isNull(_cursorIndexOfStepEmissao)) {
          _tmpStepEmissao = null;
        } else {
          _tmpStepEmissao = _cursor.getInt(_cursorIndexOfStepEmissao);
        }
        _item_1.setStepEmissao(_tmpStepEmissao);
        final String _tmpChave;
        _tmpChave = _cursor.getString(_cursorIndexOfChave);
        _item_1.setChave(_tmpChave);
        final String _tmpProtocolo;
        _tmpProtocolo = _cursor.getString(_cursorIndexOfProtocolo);
        _item_1.setProtocolo(_tmpProtocolo);
        final String _tmpCdMovimento;
        _tmpCdMovimento = _cursor.getString(_cursorIndexOfCdMovimento);
        _item_1.setCdMovimento(_tmpCdMovimento);
        final String _tmpCondicaoPagamento;
        _tmpCondicaoPagamento = _cursor.getString(_cursorIndexOfCondicaoPagamento);
        _item_1.setCondicaoPagamento(_tmpCondicaoPagamento);
        final Double _tmpAliquotaIcms;
        if (_cursor.isNull(_cursorIndexOfAliquotaIcms)) {
          _tmpAliquotaIcms = null;
        } else {
          _tmpAliquotaIcms = _cursor.getDouble(_cursorIndexOfAliquotaIcms);
        }
        _item_1.setAliquotaIcms(_tmpAliquotaIcms);
        final Double _tmpValorDescontoIcms;
        if (_cursor.isNull(_cursorIndexOfValorDescontoIcms)) {
          _tmpValorDescontoIcms = null;
        } else {
          _tmpValorDescontoIcms = _cursor.getDouble(_cursorIndexOfValorDescontoIcms);
        }
        _item_1.setValorDescontoIcms(_tmpValorDescontoIcms);
        final Double _tmpValorIcms;
        if (_cursor.isNull(_cursorIndexOfValorIcms)) {
          _tmpValorIcms = null;
        } else {
          _tmpValorIcms = _cursor.getDouble(_cursorIndexOfValorIcms);
        }
        _item_1.setValorIcms(_tmpValorIcms);
        final Double _tmpBaseCalculoIcms;
        if (_cursor.isNull(_cursorIndexOfBaseCalculoIcms)) {
          _tmpBaseCalculoIcms = null;
        } else {
          _tmpBaseCalculoIcms = _cursor.getDouble(_cursorIndexOfBaseCalculoIcms);
        }
        _item_1.setBaseCalculoIcms(_tmpBaseCalculoIcms);
        final Integer _tmpSituacaoTributariaIcms;
        if (_cursor.isNull(_cursorIndexOfSituacaoTributariaIcms)) {
          _tmpSituacaoTributariaIcms = null;
        } else {
          _tmpSituacaoTributariaIcms = _cursor.getInt(_cursorIndexOfSituacaoTributariaIcms);
        }
        _item_1.setSituacaoTributariaIcms(_tmpSituacaoTributariaIcms);
        final Double _tmpValorIpi;
        if (_cursor.isNull(_cursorIndexOfValorIpi)) {
          _tmpValorIpi = null;
        } else {
          _tmpValorIpi = _cursor.getDouble(_cursorIndexOfValorIpi);
        }
        _item_1.setValorIpi(_tmpValorIpi);
        final Double _tmpBaseCalculoIpi;
        if (_cursor.isNull(_cursorIndexOfBaseCalculoIpi)) {
          _tmpBaseCalculoIpi = null;
        } else {
          _tmpBaseCalculoIpi = _cursor.getDouble(_cursorIndexOfBaseCalculoIpi);
        }
        _item_1.setBaseCalculoIpi(_tmpBaseCalculoIpi);
        final Integer _tmpSituacaoTributariaIpi;
        if (_cursor.isNull(_cursorIndexOfSituacaoTributariaIpi)) {
          _tmpSituacaoTributariaIpi = null;
        } else {
          _tmpSituacaoTributariaIpi = _cursor.getInt(_cursorIndexOfSituacaoTributariaIpi);
        }
        _item_1.setSituacaoTributariaIpi(_tmpSituacaoTributariaIpi);
        final String _tmpFlNovoFaturamento;
        _tmpFlNovoFaturamento = _cursor.getString(_cursorIndexOfFlNovoFaturamento);
        _item_1.setFlNovoFaturamento(_tmpFlNovoFaturamento);
        final Long _tmpCdOperadora;
        if (_cursor.isNull(_cursorIndexOfCdOperadora)) {
          _tmpCdOperadora = null;
        } else {
          _tmpCdOperadora = _cursor.getLong(_cursorIndexOfCdOperadora);
        }
        _item_1.setCdOperadora(_tmpCdOperadora);
        final String _tmpFlPaciente;
        _tmpFlPaciente = _cursor.getString(_cursorIndexOfFlPaciente);
        _item_1.setFlPaciente(_tmpFlPaciente);
        final Long _tmpCdCustomerService;
        if (_cursor.isNull(_cursorIndexOfCdCustomerService)) {
          _tmpCdCustomerService = null;
        } else {
          _tmpCdCustomerService = _cursor.getLong(_cursorIndexOfCdCustomerService);
        }
        _item_1.setCdCustomerService(_tmpCdCustomerService);
        final String _tmpNomeAssinadorCec;
        _tmpNomeAssinadorCec = _cursor.getString(_cursorIndexOfNomeAssinadorCec);
        _item_1.setNomeAssinadorCec(_tmpNomeAssinadorCec);
        final String _tmpRgAssinadorCec;
        _tmpRgAssinadorCec = _cursor.getString(_cursorIndexOfRgAssinadorCec);
        _item_1.setRgAssinadorCec(_tmpRgAssinadorCec);
        final Integer _tmpTipoMovimentoIntegracao;
        if (_cursor.isNull(_cursorIndexOfTipoMovimentoIntegracao)) {
          _tmpTipoMovimentoIntegracao = null;
        } else {
          _tmpTipoMovimentoIntegracao = _cursor.getInt(_cursorIndexOfTipoMovimentoIntegracao);
        }
        _item_1.setTipoMovimentoIntegracao(_tmpTipoMovimentoIntegracao);
        final String _tmpSemPagto;
        _tmpSemPagto = _cursor.getString(_cursorIndexOfSemPagto);
        _item_1.setSemPagto(_tmpSemPagto);
        final Integer _tmpStatusGravacaoJde;
        if (_cursor.isNull(_cursorIndexOfStatusGravacaoJde)) {
          _tmpStatusGravacaoJde = null;
        } else {
          _tmpStatusGravacaoJde = _cursor.getInt(_cursorIndexOfStatusGravacaoJde);
        }
        _item_1.setStatusGravacaoJde(_tmpStatusGravacaoJde);
        final String _tmpMensagemGravacaoJde;
        _tmpMensagemGravacaoJde = _cursor.getString(_cursorIndexOfMensagemGravacaoJde);
        _item_1.setMensagemGravacaoJde(_tmpMensagemGravacaoJde);
        final Integer _tmpTipoTransacao;
        if (_cursor.isNull(_cursorIndexOfTipoTransacao)) {
          _tmpTipoTransacao = null;
        } else {
          _tmpTipoTransacao = _cursor.getInt(_cursorIndexOfTipoTransacao);
        }
        _item_1.setTipoTransacao(_tmpTipoTransacao);
        final Integer _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
        }
        _item_1.setStatus(_tmpStatus);
        final String _tmpStatusContingencia;
        _tmpStatusContingencia = _cursor.getString(_cursorIndexOfStatusContingencia);
        _item_1.setStatusContingencia(_tmpStatusContingencia);
        final String _tmpMensagemContingencia;
        _tmpMensagemContingencia = _cursor.getString(_cursorIndexOfMensagemContingencia);
        _item_1.setMensagemContingencia(_tmpMensagemContingencia);
        final Integer _tmpStatusCec;
        if (_cursor.isNull(_cursorIndexOfStatusCec)) {
          _tmpStatusCec = null;
        } else {
          _tmpStatusCec = _cursor.getInt(_cursorIndexOfStatusCec);
        }
        _item_1.setStatusCec(_tmpStatusCec);
        final String _tmpNomeTransacao;
        _tmpNomeTransacao = _cursor.getString(_cursorIndexOfNomeTransacao);
        _item_1.setNomeTransacao(_tmpNomeTransacao);
        final Integer _tmpStatusImpressaoCec;
        if (_cursor.isNull(_cursorIndexOfStatusImpressaoCec)) {
          _tmpStatusImpressaoCec = null;
        } else {
          _tmpStatusImpressaoCec = _cursor.getInt(_cursorIndexOfStatusImpressaoCec);
        }
        _item_1.setStatusImpressaoCec(_tmpStatusImpressaoCec);
        final String _tmpNomeFormaImpressaoCec;
        _tmpNomeFormaImpressaoCec = _cursor.getString(_cursorIndexOfNomeFormaImpressaoCec);
        _item_1.setNomeFormaImpressaoCec(_tmpNomeFormaImpressaoCec);
        final String _tmpNomeStatus;
        _tmpNomeStatus = _cursor.getString(_cursorIndexOfNomeStatus);
        _item_1.setNomeStatus(_tmpNomeStatus);
        final String _tmpNomeStatusImpressaoCec;
        _tmpNomeStatusImpressaoCec = _cursor.getString(_cursorIndexOfNomeStatusImpressaoCec);
        _item_1.setNomeStatusImpressaoCec(_tmpNomeStatusImpressaoCec);
        final String _tmpFlPrecoAlterado;
        _tmpFlPrecoAlterado = _cursor.getString(_cursorIndexOfFlPrecoAlterado);
        _item_1.setFlPrecoAlterado(_tmpFlPrecoAlterado);
        final String _tmpNomeTipoPagamento;
        _tmpNomeTipoPagamento = _cursor.getString(_cursorIndexOfNomeTipoPagamento);
        _item_1.setNomeTipoPagamento(_tmpNomeTipoPagamento);
        final String _tmpCdMotivo;
        _tmpCdMotivo = _cursor.getString(_cursorIndexOfCdMotivo);
        _item_1.setCdMotivo(_tmpCdMotivo);
        final String _tmpDsMotivo;
        _tmpDsMotivo = _cursor.getString(_cursorIndexOfDsMotivo);
        _item_1.setDsMotivo(_tmpDsMotivo);
        final String _tmpStatusNfeImp;
        _tmpStatusNfeImp = _cursor.getString(_cursorIndexOfStatusNfeImp);
        _item_1.setStatusNfeImp(_tmpStatusNfeImp);
        final String _tmpStatusReportFile;
        _tmpStatusReportFile = _cursor.getString(_cursorIndexOfStatusReportFile);
        _item_1.setStatusReportFile(_tmpStatusReportFile);
        _result.add(_item_1);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Invoice findByTipoNota(String tipoNota) {
    final String _sql = "SELECT * FROM Invoice WHERE tipoNota = ? ORDER BY numero DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (tipoNota == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, tipoNota);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfNumero = _cursor.getColumnIndexOrThrow("numero");
      final int _cursorIndexOfSerie = _cursor.getColumnIndexOrThrow("serie");
      final int _cursorIndexOfNumeroNotaVOR = _cursor.getColumnIndexOrThrow("numeroNotaVOR");
      final int _cursorIndexOfSerieNotaVOR = _cursor.getColumnIndexOrThrow("serieNotaVOR");
      final int _cursorIndexOfCdPreOrdem = _cursor.getColumnIndexOrThrow("cdPreOrdem");
      final int _cursorIndexOfNumeroFutEntrega = _cursor.getColumnIndexOrThrow("numeroFutEntrega");
      final int _cursorIndexOfCdFiscal = _cursor.getColumnIndexOrThrow("cdFiscal");
      final int _cursorIndexOfCnpjCpfDestino = _cursor.getColumnIndexOrThrow("cnpjCpfDestino");
      final int _cursorIndexOfCnpjCpfTransp = _cursor.getColumnIndexOrThrow("cnpjCpfTransp");
      final int _cursorIndexOfTipoNota = _cursor.getColumnIndexOrThrow("tipoNota");
      final int _cursorIndexOfClasseContribuinte = _cursor.getColumnIndexOrThrow("classeContribuinte");
      final int _cursorIndexOfDataViagemPrincial = _cursor.getColumnIndexOrThrow("dataViagemPrincial");
      final int _cursorIndexOfNumeroViagem = _cursor.getColumnIndexOrThrow("numeroViagem");
      final int _cursorIndexOfDataViagem = _cursor.getColumnIndexOrThrow("dataViagem");
      final int _cursorIndexOfNomeOperacao = _cursor.getColumnIndexOrThrow("nomeOperacao");
      final int _cursorIndexOfDataEmissao = _cursor.getColumnIndexOrThrow("dataEmissao");
      final int _cursorIndexOfDataMovimento = _cursor.getColumnIndexOrThrow("dataMovimento");
      final int _cursorIndexOfDataVencimento = _cursor.getColumnIndexOrThrow("dataVencimento");
      final int _cursorIndexOfValorTotal = _cursor.getColumnIndexOrThrow("valorTotal");
      final int _cursorIndexOfValorLiquido = _cursor.getColumnIndexOrThrow("valorLiquido");
      final int _cursorIndexOfValorTotalProduto = _cursor.getColumnIndexOrThrow("valorTotalProduto");
      final int _cursorIndexOfValorFrete = _cursor.getColumnIndexOrThrow("valorFrete");
      final int _cursorIndexOfValorDespAcessorias = _cursor.getColumnIndexOrThrow("valorDespAcessorias");
      final int _cursorIndexOfValorDinheiro = _cursor.getColumnIndexOrThrow("valorDinheiro");
      final int _cursorIndexOfValorTroco = _cursor.getColumnIndexOrThrow("valorTroco");
      final int _cursorIndexOfValorFatura = _cursor.getColumnIndexOrThrow("valorFatura");
      final int _cursorIndexOfValorDebito = _cursor.getColumnIndexOrThrow("valorDebito");
      final int _cursorIndexOfValorCredito = _cursor.getColumnIndexOrThrow("valorCredito");
      final int _cursorIndexOfValorCheque = _cursor.getColumnIndexOrThrow("valorCheque");
      final int _cursorIndexOfNumeroCheque = _cursor.getColumnIndexOrThrow("numeroCheque");
      final int _cursorIndexOfUfVeiculo = _cursor.getColumnIndexOrThrow("ufVeiculo");
      final int _cursorIndexOfPlacaVeiculo = _cursor.getColumnIndexOrThrow("placaVeiculo");
      final int _cursorIndexOfNumeroVeiculo = _cursor.getColumnIndexOrThrow("numeroVeiculo");
      final int _cursorIndexOfModalidadeFrete = _cursor.getColumnIndexOrThrow("modalidadeFrete");
      final int _cursorIndexOfNomeEspecVolume = _cursor.getColumnIndexOrThrow("nomeEspecVolume");
      final int _cursorIndexOfNomeMarca = _cursor.getColumnIndexOrThrow("nomeMarca");
      final int _cursorIndexOfQtdVolumes = _cursor.getColumnIndexOrThrow("qtdVolumes");
      final int _cursorIndexOfVolumeCapacidade = _cursor.getColumnIndexOrThrow("volumeCapacidade");
      final int _cursorIndexOfVolumeCapacidadeReport = _cursor.getColumnIndexOrThrow("volumeCapacidadeReport");
      final int _cursorIndexOfPesoBruto = _cursor.getColumnIndexOrThrow("pesoBruto");
      final int _cursorIndexOfPesoLiquido = _cursor.getColumnIndexOrThrow("pesoLiquido");
      final int _cursorIndexOfTipoPedido = _cursor.getColumnIndexOrThrow("tipoPedido");
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfAtivaTipoPagto = _cursor.getColumnIndexOrThrow("ativaTipoPagto");
      final int _cursorIndexOfStepEmissao = _cursor.getColumnIndexOrThrow("stepEmissao");
      final int _cursorIndexOfChave = _cursor.getColumnIndexOrThrow("chave");
      final int _cursorIndexOfProtocolo = _cursor.getColumnIndexOrThrow("protocolo");
      final int _cursorIndexOfCdMovimento = _cursor.getColumnIndexOrThrow("cdMovimento");
      final int _cursorIndexOfCondicaoPagamento = _cursor.getColumnIndexOrThrow("condicaoPagamento");
      final int _cursorIndexOfAliquotaIcms = _cursor.getColumnIndexOrThrow("aliquotaIcms");
      final int _cursorIndexOfValorDescontoIcms = _cursor.getColumnIndexOrThrow("valorDescontoIcms");
      final int _cursorIndexOfValorIcms = _cursor.getColumnIndexOrThrow("valorIcms");
      final int _cursorIndexOfBaseCalculoIcms = _cursor.getColumnIndexOrThrow("baseCalculoIcms");
      final int _cursorIndexOfSituacaoTributariaIcms = _cursor.getColumnIndexOrThrow("situacaoTributariaIcms");
      final int _cursorIndexOfValorIpi = _cursor.getColumnIndexOrThrow("valorIpi");
      final int _cursorIndexOfBaseCalculoIpi = _cursor.getColumnIndexOrThrow("baseCalculoIpi");
      final int _cursorIndexOfSituacaoTributariaIpi = _cursor.getColumnIndexOrThrow("situacaoTributariaIpi");
      final int _cursorIndexOfFlNovoFaturamento = _cursor.getColumnIndexOrThrow("flNovoFaturamento");
      final int _cursorIndexOfCdOperadora = _cursor.getColumnIndexOrThrow("cdOperadora");
      final int _cursorIndexOfFlPaciente = _cursor.getColumnIndexOrThrow("flPaciente");
      final int _cursorIndexOfCdCustomerService = _cursor.getColumnIndexOrThrow("cdCustomerService");
      final int _cursorIndexOfNomeAssinadorCec = _cursor.getColumnIndexOrThrow("nomeAssinadorCec");
      final int _cursorIndexOfRgAssinadorCec = _cursor.getColumnIndexOrThrow("rgAssinadorCec");
      final int _cursorIndexOfTipoMovimentoIntegracao = _cursor.getColumnIndexOrThrow("tipoMovimentoIntegracao");
      final int _cursorIndexOfSemPagto = _cursor.getColumnIndexOrThrow("semPagto");
      final int _cursorIndexOfStatusGravacaoJde = _cursor.getColumnIndexOrThrow("statusGravacaoJde");
      final int _cursorIndexOfMensagemGravacaoJde = _cursor.getColumnIndexOrThrow("mensagemGravacaoJde");
      final int _cursorIndexOfTipoTransacao = _cursor.getColumnIndexOrThrow("tipoTransacao");
      final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("status");
      final int _cursorIndexOfStatusContingencia = _cursor.getColumnIndexOrThrow("statusContingencia");
      final int _cursorIndexOfMensagemContingencia = _cursor.getColumnIndexOrThrow("mensagemContingencia");
      final int _cursorIndexOfStatusCec = _cursor.getColumnIndexOrThrow("statusCec");
      final int _cursorIndexOfNomeTransacao = _cursor.getColumnIndexOrThrow("nomeTransacao");
      final int _cursorIndexOfStatusImpressaoCec = _cursor.getColumnIndexOrThrow("statusImpressaoCec");
      final int _cursorIndexOfNomeFormaImpressaoCec = _cursor.getColumnIndexOrThrow("nomeFormaImpressaoCec");
      final int _cursorIndexOfNomeStatus = _cursor.getColumnIndexOrThrow("nomeStatus");
      final int _cursorIndexOfNomeStatusImpressaoCec = _cursor.getColumnIndexOrThrow("nomeStatusImpressaoCec");
      final int _cursorIndexOfFlPrecoAlterado = _cursor.getColumnIndexOrThrow("flPrecoAlterado");
      final int _cursorIndexOfNomeTipoPagamento = _cursor.getColumnIndexOrThrow("nomeTipoPagamento");
      final int _cursorIndexOfCdMotivo = _cursor.getColumnIndexOrThrow("cdMotivo");
      final int _cursorIndexOfDsMotivo = _cursor.getColumnIndexOrThrow("dsMotivo");
      final int _cursorIndexOfStatusNfeImp = _cursor.getColumnIndexOrThrow("statusNfeImp");
      final int _cursorIndexOfStatusReportFile = _cursor.getColumnIndexOrThrow("statusReportFile");
      final Invoice _result;
      if(_cursor.moveToFirst()) {
        _result = new Invoice();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _result.setId(_tmpId);
        final Long _tmpNumero;
        if (_cursor.isNull(_cursorIndexOfNumero)) {
          _tmpNumero = null;
        } else {
          _tmpNumero = _cursor.getLong(_cursorIndexOfNumero);
        }
        _result.setNumero(_tmpNumero);
        final Long _tmpSerie;
        if (_cursor.isNull(_cursorIndexOfSerie)) {
          _tmpSerie = null;
        } else {
          _tmpSerie = _cursor.getLong(_cursorIndexOfSerie);
        }
        _result.setSerie(_tmpSerie);
        final Long _tmpNumeroNotaVOR;
        if (_cursor.isNull(_cursorIndexOfNumeroNotaVOR)) {
          _tmpNumeroNotaVOR = null;
        } else {
          _tmpNumeroNotaVOR = _cursor.getLong(_cursorIndexOfNumeroNotaVOR);
        }
        _result.setNumeroNotaVOR(_tmpNumeroNotaVOR);
        final Long _tmpSerieNotaVOR;
        if (_cursor.isNull(_cursorIndexOfSerieNotaVOR)) {
          _tmpSerieNotaVOR = null;
        } else {
          _tmpSerieNotaVOR = _cursor.getLong(_cursorIndexOfSerieNotaVOR);
        }
        _result.setSerieNotaVOR(_tmpSerieNotaVOR);
        final String _tmpCdPreOrdem;
        _tmpCdPreOrdem = _cursor.getString(_cursorIndexOfCdPreOrdem);
        _result.setCdPreOrdem(_tmpCdPreOrdem);
        final String _tmpNumeroFutEntrega;
        _tmpNumeroFutEntrega = _cursor.getString(_cursorIndexOfNumeroFutEntrega);
        _result.setNumeroFutEntrega(_tmpNumeroFutEntrega);
        final Integer _tmpCdFiscal;
        if (_cursor.isNull(_cursorIndexOfCdFiscal)) {
          _tmpCdFiscal = null;
        } else {
          _tmpCdFiscal = _cursor.getInt(_cursorIndexOfCdFiscal);
        }
        _result.setCdFiscal(_tmpCdFiscal);
        final String _tmpCnpjCpfDestino;
        _tmpCnpjCpfDestino = _cursor.getString(_cursorIndexOfCnpjCpfDestino);
        _result.setCnpjCpfDestino(_tmpCnpjCpfDestino);
        final String _tmpCnpjCpfTransp;
        _tmpCnpjCpfTransp = _cursor.getString(_cursorIndexOfCnpjCpfTransp);
        _result.setCnpjCpfTransp(_tmpCnpjCpfTransp);
        final String _tmpTipoNota;
        _tmpTipoNota = _cursor.getString(_cursorIndexOfTipoNota);
        _result.setTipoNota(_tmpTipoNota);
        final Integer _tmpClasseContribuinte;
        if (_cursor.isNull(_cursorIndexOfClasseContribuinte)) {
          _tmpClasseContribuinte = null;
        } else {
          _tmpClasseContribuinte = _cursor.getInt(_cursorIndexOfClasseContribuinte);
        }
        _result.setClasseContribuinte(_tmpClasseContribuinte);
        final String _tmpDataViagemPrincial;
        _tmpDataViagemPrincial = _cursor.getString(_cursorIndexOfDataViagemPrincial);
        _result.setDataViagemPrincial(_tmpDataViagemPrincial);
        final String _tmpNumeroViagem;
        _tmpNumeroViagem = _cursor.getString(_cursorIndexOfNumeroViagem);
        _result.setNumeroViagem(_tmpNumeroViagem);
        final String _tmpDataViagem;
        _tmpDataViagem = _cursor.getString(_cursorIndexOfDataViagem);
        _result.setDataViagem(_tmpDataViagem);
        final String _tmpNomeOperacao;
        _tmpNomeOperacao = _cursor.getString(_cursorIndexOfNomeOperacao);
        _result.setNomeOperacao(_tmpNomeOperacao);
        final Date _tmpDataEmissao;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfDataEmissao)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfDataEmissao);
        }
        _tmpDataEmissao = DateTypeConverter.fromTimestamp(_tmp);
        _result.setDataEmissao(_tmpDataEmissao);
        final Date _tmpDataMovimento;
        final Long _tmp_1;
        if (_cursor.isNull(_cursorIndexOfDataMovimento)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getLong(_cursorIndexOfDataMovimento);
        }
        _tmpDataMovimento = DateTypeConverter.fromTimestamp(_tmp_1);
        _result.setDataMovimento(_tmpDataMovimento);
        final Date _tmpDataVencimento;
        final Long _tmp_2;
        if (_cursor.isNull(_cursorIndexOfDataVencimento)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getLong(_cursorIndexOfDataVencimento);
        }
        _tmpDataVencimento = DateTypeConverter.fromTimestamp(_tmp_2);
        _result.setDataVencimento(_tmpDataVencimento);
        final Double _tmpValorTotal;
        if (_cursor.isNull(_cursorIndexOfValorTotal)) {
          _tmpValorTotal = null;
        } else {
          _tmpValorTotal = _cursor.getDouble(_cursorIndexOfValorTotal);
        }
        _result.setValorTotal(_tmpValorTotal);
        final Double _tmpValorLiquido;
        if (_cursor.isNull(_cursorIndexOfValorLiquido)) {
          _tmpValorLiquido = null;
        } else {
          _tmpValorLiquido = _cursor.getDouble(_cursorIndexOfValorLiquido);
        }
        _result.setValorLiquido(_tmpValorLiquido);
        final Double _tmpValorTotalProduto;
        if (_cursor.isNull(_cursorIndexOfValorTotalProduto)) {
          _tmpValorTotalProduto = null;
        } else {
          _tmpValorTotalProduto = _cursor.getDouble(_cursorIndexOfValorTotalProduto);
        }
        _result.setValorTotalProduto(_tmpValorTotalProduto);
        final Double _tmpValorFrete;
        if (_cursor.isNull(_cursorIndexOfValorFrete)) {
          _tmpValorFrete = null;
        } else {
          _tmpValorFrete = _cursor.getDouble(_cursorIndexOfValorFrete);
        }
        _result.setValorFrete(_tmpValorFrete);
        final Double _tmpValorDespAcessorias;
        if (_cursor.isNull(_cursorIndexOfValorDespAcessorias)) {
          _tmpValorDespAcessorias = null;
        } else {
          _tmpValorDespAcessorias = _cursor.getDouble(_cursorIndexOfValorDespAcessorias);
        }
        _result.setValorDespAcessorias(_tmpValorDespAcessorias);
        final Double _tmpValorDinheiro;
        if (_cursor.isNull(_cursorIndexOfValorDinheiro)) {
          _tmpValorDinheiro = null;
        } else {
          _tmpValorDinheiro = _cursor.getDouble(_cursorIndexOfValorDinheiro);
        }
        _result.setValorDinheiro(_tmpValorDinheiro);
        final Double _tmpValorTroco;
        if (_cursor.isNull(_cursorIndexOfValorTroco)) {
          _tmpValorTroco = null;
        } else {
          _tmpValorTroco = _cursor.getDouble(_cursorIndexOfValorTroco);
        }
        _result.setValorTroco(_tmpValorTroco);
        final Double _tmpValorFatura;
        if (_cursor.isNull(_cursorIndexOfValorFatura)) {
          _tmpValorFatura = null;
        } else {
          _tmpValorFatura = _cursor.getDouble(_cursorIndexOfValorFatura);
        }
        _result.setValorFatura(_tmpValorFatura);
        final Double _tmpValorDebito;
        if (_cursor.isNull(_cursorIndexOfValorDebito)) {
          _tmpValorDebito = null;
        } else {
          _tmpValorDebito = _cursor.getDouble(_cursorIndexOfValorDebito);
        }
        _result.setValorDebito(_tmpValorDebito);
        final Double _tmpValorCredito;
        if (_cursor.isNull(_cursorIndexOfValorCredito)) {
          _tmpValorCredito = null;
        } else {
          _tmpValorCredito = _cursor.getDouble(_cursorIndexOfValorCredito);
        }
        _result.setValorCredito(_tmpValorCredito);
        final Double _tmpValorCheque;
        if (_cursor.isNull(_cursorIndexOfValorCheque)) {
          _tmpValorCheque = null;
        } else {
          _tmpValorCheque = _cursor.getDouble(_cursorIndexOfValorCheque);
        }
        _result.setValorCheque(_tmpValorCheque);
        final String _tmpNumeroCheque;
        _tmpNumeroCheque = _cursor.getString(_cursorIndexOfNumeroCheque);
        _result.setNumeroCheque(_tmpNumeroCheque);
        final String _tmpUfVeiculo;
        _tmpUfVeiculo = _cursor.getString(_cursorIndexOfUfVeiculo);
        _result.setUfVeiculo(_tmpUfVeiculo);
        final String _tmpPlacaVeiculo;
        _tmpPlacaVeiculo = _cursor.getString(_cursorIndexOfPlacaVeiculo);
        _result.setPlacaVeiculo(_tmpPlacaVeiculo);
        final String _tmpNumeroVeiculo;
        _tmpNumeroVeiculo = _cursor.getString(_cursorIndexOfNumeroVeiculo);
        _result.setNumeroVeiculo(_tmpNumeroVeiculo);
        final Integer _tmpModalidadeFrete;
        if (_cursor.isNull(_cursorIndexOfModalidadeFrete)) {
          _tmpModalidadeFrete = null;
        } else {
          _tmpModalidadeFrete = _cursor.getInt(_cursorIndexOfModalidadeFrete);
        }
        _result.setModalidadeFrete(_tmpModalidadeFrete);
        final String _tmpNomeEspecVolume;
        _tmpNomeEspecVolume = _cursor.getString(_cursorIndexOfNomeEspecVolume);
        _result.setNomeEspecVolume(_tmpNomeEspecVolume);
        final String _tmpNomeMarca;
        _tmpNomeMarca = _cursor.getString(_cursorIndexOfNomeMarca);
        _result.setNomeMarca(_tmpNomeMarca);
        final Integer _tmpQtdVolumes;
        if (_cursor.isNull(_cursorIndexOfQtdVolumes)) {
          _tmpQtdVolumes = null;
        } else {
          _tmpQtdVolumes = _cursor.getInt(_cursorIndexOfQtdVolumes);
        }
        _result.setQtdVolumes(_tmpQtdVolumes);
        final Double _tmpVolumeCapacidade;
        if (_cursor.isNull(_cursorIndexOfVolumeCapacidade)) {
          _tmpVolumeCapacidade = null;
        } else {
          _tmpVolumeCapacidade = _cursor.getDouble(_cursorIndexOfVolumeCapacidade);
        }
        _result.setVolumeCapacidade(_tmpVolumeCapacidade);
        final Double _tmpVolumeCapacidadeReport;
        if (_cursor.isNull(_cursorIndexOfVolumeCapacidadeReport)) {
          _tmpVolumeCapacidadeReport = null;
        } else {
          _tmpVolumeCapacidadeReport = _cursor.getDouble(_cursorIndexOfVolumeCapacidadeReport);
        }
        _result.setVolumeCapacidadeReport(_tmpVolumeCapacidadeReport);
        final Double _tmpPesoBruto;
        if (_cursor.isNull(_cursorIndexOfPesoBruto)) {
          _tmpPesoBruto = null;
        } else {
          _tmpPesoBruto = _cursor.getDouble(_cursorIndexOfPesoBruto);
        }
        _result.setPesoBruto(_tmpPesoBruto);
        final Double _tmpPesoLiquido;
        if (_cursor.isNull(_cursorIndexOfPesoLiquido)) {
          _tmpPesoLiquido = null;
        } else {
          _tmpPesoLiquido = _cursor.getDouble(_cursorIndexOfPesoLiquido);
        }
        _result.setPesoLiquido(_tmpPesoLiquido);
        final String _tmpTipoPedido;
        _tmpTipoPedido = _cursor.getString(_cursorIndexOfTipoPedido);
        _result.setTipoPedido(_tmpTipoPedido);
        final Long _tmpCdCustomer;
        if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
          _tmpCdCustomer = null;
        } else {
          _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
        }
        _result.setCdCustomer(_tmpCdCustomer);
        final String _tmpAtivaTipoPagto;
        _tmpAtivaTipoPagto = _cursor.getString(_cursorIndexOfAtivaTipoPagto);
        _result.setAtivaTipoPagto(_tmpAtivaTipoPagto);
        final Integer _tmpStepEmissao;
        if (_cursor.isNull(_cursorIndexOfStepEmissao)) {
          _tmpStepEmissao = null;
        } else {
          _tmpStepEmissao = _cursor.getInt(_cursorIndexOfStepEmissao);
        }
        _result.setStepEmissao(_tmpStepEmissao);
        final String _tmpChave;
        _tmpChave = _cursor.getString(_cursorIndexOfChave);
        _result.setChave(_tmpChave);
        final String _tmpProtocolo;
        _tmpProtocolo = _cursor.getString(_cursorIndexOfProtocolo);
        _result.setProtocolo(_tmpProtocolo);
        final String _tmpCdMovimento;
        _tmpCdMovimento = _cursor.getString(_cursorIndexOfCdMovimento);
        _result.setCdMovimento(_tmpCdMovimento);
        final String _tmpCondicaoPagamento;
        _tmpCondicaoPagamento = _cursor.getString(_cursorIndexOfCondicaoPagamento);
        _result.setCondicaoPagamento(_tmpCondicaoPagamento);
        final Double _tmpAliquotaIcms;
        if (_cursor.isNull(_cursorIndexOfAliquotaIcms)) {
          _tmpAliquotaIcms = null;
        } else {
          _tmpAliquotaIcms = _cursor.getDouble(_cursorIndexOfAliquotaIcms);
        }
        _result.setAliquotaIcms(_tmpAliquotaIcms);
        final Double _tmpValorDescontoIcms;
        if (_cursor.isNull(_cursorIndexOfValorDescontoIcms)) {
          _tmpValorDescontoIcms = null;
        } else {
          _tmpValorDescontoIcms = _cursor.getDouble(_cursorIndexOfValorDescontoIcms);
        }
        _result.setValorDescontoIcms(_tmpValorDescontoIcms);
        final Double _tmpValorIcms;
        if (_cursor.isNull(_cursorIndexOfValorIcms)) {
          _tmpValorIcms = null;
        } else {
          _tmpValorIcms = _cursor.getDouble(_cursorIndexOfValorIcms);
        }
        _result.setValorIcms(_tmpValorIcms);
        final Double _tmpBaseCalculoIcms;
        if (_cursor.isNull(_cursorIndexOfBaseCalculoIcms)) {
          _tmpBaseCalculoIcms = null;
        } else {
          _tmpBaseCalculoIcms = _cursor.getDouble(_cursorIndexOfBaseCalculoIcms);
        }
        _result.setBaseCalculoIcms(_tmpBaseCalculoIcms);
        final Integer _tmpSituacaoTributariaIcms;
        if (_cursor.isNull(_cursorIndexOfSituacaoTributariaIcms)) {
          _tmpSituacaoTributariaIcms = null;
        } else {
          _tmpSituacaoTributariaIcms = _cursor.getInt(_cursorIndexOfSituacaoTributariaIcms);
        }
        _result.setSituacaoTributariaIcms(_tmpSituacaoTributariaIcms);
        final Double _tmpValorIpi;
        if (_cursor.isNull(_cursorIndexOfValorIpi)) {
          _tmpValorIpi = null;
        } else {
          _tmpValorIpi = _cursor.getDouble(_cursorIndexOfValorIpi);
        }
        _result.setValorIpi(_tmpValorIpi);
        final Double _tmpBaseCalculoIpi;
        if (_cursor.isNull(_cursorIndexOfBaseCalculoIpi)) {
          _tmpBaseCalculoIpi = null;
        } else {
          _tmpBaseCalculoIpi = _cursor.getDouble(_cursorIndexOfBaseCalculoIpi);
        }
        _result.setBaseCalculoIpi(_tmpBaseCalculoIpi);
        final Integer _tmpSituacaoTributariaIpi;
        if (_cursor.isNull(_cursorIndexOfSituacaoTributariaIpi)) {
          _tmpSituacaoTributariaIpi = null;
        } else {
          _tmpSituacaoTributariaIpi = _cursor.getInt(_cursorIndexOfSituacaoTributariaIpi);
        }
        _result.setSituacaoTributariaIpi(_tmpSituacaoTributariaIpi);
        final String _tmpFlNovoFaturamento;
        _tmpFlNovoFaturamento = _cursor.getString(_cursorIndexOfFlNovoFaturamento);
        _result.setFlNovoFaturamento(_tmpFlNovoFaturamento);
        final Long _tmpCdOperadora;
        if (_cursor.isNull(_cursorIndexOfCdOperadora)) {
          _tmpCdOperadora = null;
        } else {
          _tmpCdOperadora = _cursor.getLong(_cursorIndexOfCdOperadora);
        }
        _result.setCdOperadora(_tmpCdOperadora);
        final String _tmpFlPaciente;
        _tmpFlPaciente = _cursor.getString(_cursorIndexOfFlPaciente);
        _result.setFlPaciente(_tmpFlPaciente);
        final Long _tmpCdCustomerService;
        if (_cursor.isNull(_cursorIndexOfCdCustomerService)) {
          _tmpCdCustomerService = null;
        } else {
          _tmpCdCustomerService = _cursor.getLong(_cursorIndexOfCdCustomerService);
        }
        _result.setCdCustomerService(_tmpCdCustomerService);
        final String _tmpNomeAssinadorCec;
        _tmpNomeAssinadorCec = _cursor.getString(_cursorIndexOfNomeAssinadorCec);
        _result.setNomeAssinadorCec(_tmpNomeAssinadorCec);
        final String _tmpRgAssinadorCec;
        _tmpRgAssinadorCec = _cursor.getString(_cursorIndexOfRgAssinadorCec);
        _result.setRgAssinadorCec(_tmpRgAssinadorCec);
        final Integer _tmpTipoMovimentoIntegracao;
        if (_cursor.isNull(_cursorIndexOfTipoMovimentoIntegracao)) {
          _tmpTipoMovimentoIntegracao = null;
        } else {
          _tmpTipoMovimentoIntegracao = _cursor.getInt(_cursorIndexOfTipoMovimentoIntegracao);
        }
        _result.setTipoMovimentoIntegracao(_tmpTipoMovimentoIntegracao);
        final String _tmpSemPagto;
        _tmpSemPagto = _cursor.getString(_cursorIndexOfSemPagto);
        _result.setSemPagto(_tmpSemPagto);
        final Integer _tmpStatusGravacaoJde;
        if (_cursor.isNull(_cursorIndexOfStatusGravacaoJde)) {
          _tmpStatusGravacaoJde = null;
        } else {
          _tmpStatusGravacaoJde = _cursor.getInt(_cursorIndexOfStatusGravacaoJde);
        }
        _result.setStatusGravacaoJde(_tmpStatusGravacaoJde);
        final String _tmpMensagemGravacaoJde;
        _tmpMensagemGravacaoJde = _cursor.getString(_cursorIndexOfMensagemGravacaoJde);
        _result.setMensagemGravacaoJde(_tmpMensagemGravacaoJde);
        final Integer _tmpTipoTransacao;
        if (_cursor.isNull(_cursorIndexOfTipoTransacao)) {
          _tmpTipoTransacao = null;
        } else {
          _tmpTipoTransacao = _cursor.getInt(_cursorIndexOfTipoTransacao);
        }
        _result.setTipoTransacao(_tmpTipoTransacao);
        final Integer _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
        }
        _result.setStatus(_tmpStatus);
        final String _tmpStatusContingencia;
        _tmpStatusContingencia = _cursor.getString(_cursorIndexOfStatusContingencia);
        _result.setStatusContingencia(_tmpStatusContingencia);
        final String _tmpMensagemContingencia;
        _tmpMensagemContingencia = _cursor.getString(_cursorIndexOfMensagemContingencia);
        _result.setMensagemContingencia(_tmpMensagemContingencia);
        final Integer _tmpStatusCec;
        if (_cursor.isNull(_cursorIndexOfStatusCec)) {
          _tmpStatusCec = null;
        } else {
          _tmpStatusCec = _cursor.getInt(_cursorIndexOfStatusCec);
        }
        _result.setStatusCec(_tmpStatusCec);
        final String _tmpNomeTransacao;
        _tmpNomeTransacao = _cursor.getString(_cursorIndexOfNomeTransacao);
        _result.setNomeTransacao(_tmpNomeTransacao);
        final Integer _tmpStatusImpressaoCec;
        if (_cursor.isNull(_cursorIndexOfStatusImpressaoCec)) {
          _tmpStatusImpressaoCec = null;
        } else {
          _tmpStatusImpressaoCec = _cursor.getInt(_cursorIndexOfStatusImpressaoCec);
        }
        _result.setStatusImpressaoCec(_tmpStatusImpressaoCec);
        final String _tmpNomeFormaImpressaoCec;
        _tmpNomeFormaImpressaoCec = _cursor.getString(_cursorIndexOfNomeFormaImpressaoCec);
        _result.setNomeFormaImpressaoCec(_tmpNomeFormaImpressaoCec);
        final String _tmpNomeStatus;
        _tmpNomeStatus = _cursor.getString(_cursorIndexOfNomeStatus);
        _result.setNomeStatus(_tmpNomeStatus);
        final String _tmpNomeStatusImpressaoCec;
        _tmpNomeStatusImpressaoCec = _cursor.getString(_cursorIndexOfNomeStatusImpressaoCec);
        _result.setNomeStatusImpressaoCec(_tmpNomeStatusImpressaoCec);
        final String _tmpFlPrecoAlterado;
        _tmpFlPrecoAlterado = _cursor.getString(_cursorIndexOfFlPrecoAlterado);
        _result.setFlPrecoAlterado(_tmpFlPrecoAlterado);
        final String _tmpNomeTipoPagamento;
        _tmpNomeTipoPagamento = _cursor.getString(_cursorIndexOfNomeTipoPagamento);
        _result.setNomeTipoPagamento(_tmpNomeTipoPagamento);
        final String _tmpCdMotivo;
        _tmpCdMotivo = _cursor.getString(_cursorIndexOfCdMotivo);
        _result.setCdMotivo(_tmpCdMotivo);
        final String _tmpDsMotivo;
        _tmpDsMotivo = _cursor.getString(_cursorIndexOfDsMotivo);
        _result.setDsMotivo(_tmpDsMotivo);
        final String _tmpStatusNfeImp;
        _tmpStatusNfeImp = _cursor.getString(_cursorIndexOfStatusNfeImp);
        _result.setStatusNfeImp(_tmpStatusNfeImp);
        final String _tmpStatusReportFile;
        _tmpStatusReportFile = _cursor.getString(_cursorIndexOfStatusReportFile);
        _result.setStatusReportFile(_tmpStatusReportFile);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Invoice> findAllByTipoNota(String tipoNota) {
    final String _sql = "SELECT * FROM Invoice WHERE tipoNota = ? ORDER BY numero";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (tipoNota == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, tipoNota);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfNumero = _cursor.getColumnIndexOrThrow("numero");
      final int _cursorIndexOfSerie = _cursor.getColumnIndexOrThrow("serie");
      final int _cursorIndexOfNumeroNotaVOR = _cursor.getColumnIndexOrThrow("numeroNotaVOR");
      final int _cursorIndexOfSerieNotaVOR = _cursor.getColumnIndexOrThrow("serieNotaVOR");
      final int _cursorIndexOfCdPreOrdem = _cursor.getColumnIndexOrThrow("cdPreOrdem");
      final int _cursorIndexOfNumeroFutEntrega = _cursor.getColumnIndexOrThrow("numeroFutEntrega");
      final int _cursorIndexOfCdFiscal = _cursor.getColumnIndexOrThrow("cdFiscal");
      final int _cursorIndexOfCnpjCpfDestino = _cursor.getColumnIndexOrThrow("cnpjCpfDestino");
      final int _cursorIndexOfCnpjCpfTransp = _cursor.getColumnIndexOrThrow("cnpjCpfTransp");
      final int _cursorIndexOfTipoNota = _cursor.getColumnIndexOrThrow("tipoNota");
      final int _cursorIndexOfClasseContribuinte = _cursor.getColumnIndexOrThrow("classeContribuinte");
      final int _cursorIndexOfDataViagemPrincial = _cursor.getColumnIndexOrThrow("dataViagemPrincial");
      final int _cursorIndexOfNumeroViagem = _cursor.getColumnIndexOrThrow("numeroViagem");
      final int _cursorIndexOfDataViagem = _cursor.getColumnIndexOrThrow("dataViagem");
      final int _cursorIndexOfNomeOperacao = _cursor.getColumnIndexOrThrow("nomeOperacao");
      final int _cursorIndexOfDataEmissao = _cursor.getColumnIndexOrThrow("dataEmissao");
      final int _cursorIndexOfDataMovimento = _cursor.getColumnIndexOrThrow("dataMovimento");
      final int _cursorIndexOfDataVencimento = _cursor.getColumnIndexOrThrow("dataVencimento");
      final int _cursorIndexOfValorTotal = _cursor.getColumnIndexOrThrow("valorTotal");
      final int _cursorIndexOfValorLiquido = _cursor.getColumnIndexOrThrow("valorLiquido");
      final int _cursorIndexOfValorTotalProduto = _cursor.getColumnIndexOrThrow("valorTotalProduto");
      final int _cursorIndexOfValorFrete = _cursor.getColumnIndexOrThrow("valorFrete");
      final int _cursorIndexOfValorDespAcessorias = _cursor.getColumnIndexOrThrow("valorDespAcessorias");
      final int _cursorIndexOfValorDinheiro = _cursor.getColumnIndexOrThrow("valorDinheiro");
      final int _cursorIndexOfValorTroco = _cursor.getColumnIndexOrThrow("valorTroco");
      final int _cursorIndexOfValorFatura = _cursor.getColumnIndexOrThrow("valorFatura");
      final int _cursorIndexOfValorDebito = _cursor.getColumnIndexOrThrow("valorDebito");
      final int _cursorIndexOfValorCredito = _cursor.getColumnIndexOrThrow("valorCredito");
      final int _cursorIndexOfValorCheque = _cursor.getColumnIndexOrThrow("valorCheque");
      final int _cursorIndexOfNumeroCheque = _cursor.getColumnIndexOrThrow("numeroCheque");
      final int _cursorIndexOfUfVeiculo = _cursor.getColumnIndexOrThrow("ufVeiculo");
      final int _cursorIndexOfPlacaVeiculo = _cursor.getColumnIndexOrThrow("placaVeiculo");
      final int _cursorIndexOfNumeroVeiculo = _cursor.getColumnIndexOrThrow("numeroVeiculo");
      final int _cursorIndexOfModalidadeFrete = _cursor.getColumnIndexOrThrow("modalidadeFrete");
      final int _cursorIndexOfNomeEspecVolume = _cursor.getColumnIndexOrThrow("nomeEspecVolume");
      final int _cursorIndexOfNomeMarca = _cursor.getColumnIndexOrThrow("nomeMarca");
      final int _cursorIndexOfQtdVolumes = _cursor.getColumnIndexOrThrow("qtdVolumes");
      final int _cursorIndexOfVolumeCapacidade = _cursor.getColumnIndexOrThrow("volumeCapacidade");
      final int _cursorIndexOfVolumeCapacidadeReport = _cursor.getColumnIndexOrThrow("volumeCapacidadeReport");
      final int _cursorIndexOfPesoBruto = _cursor.getColumnIndexOrThrow("pesoBruto");
      final int _cursorIndexOfPesoLiquido = _cursor.getColumnIndexOrThrow("pesoLiquido");
      final int _cursorIndexOfTipoPedido = _cursor.getColumnIndexOrThrow("tipoPedido");
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfAtivaTipoPagto = _cursor.getColumnIndexOrThrow("ativaTipoPagto");
      final int _cursorIndexOfStepEmissao = _cursor.getColumnIndexOrThrow("stepEmissao");
      final int _cursorIndexOfChave = _cursor.getColumnIndexOrThrow("chave");
      final int _cursorIndexOfProtocolo = _cursor.getColumnIndexOrThrow("protocolo");
      final int _cursorIndexOfCdMovimento = _cursor.getColumnIndexOrThrow("cdMovimento");
      final int _cursorIndexOfCondicaoPagamento = _cursor.getColumnIndexOrThrow("condicaoPagamento");
      final int _cursorIndexOfAliquotaIcms = _cursor.getColumnIndexOrThrow("aliquotaIcms");
      final int _cursorIndexOfValorDescontoIcms = _cursor.getColumnIndexOrThrow("valorDescontoIcms");
      final int _cursorIndexOfValorIcms = _cursor.getColumnIndexOrThrow("valorIcms");
      final int _cursorIndexOfBaseCalculoIcms = _cursor.getColumnIndexOrThrow("baseCalculoIcms");
      final int _cursorIndexOfSituacaoTributariaIcms = _cursor.getColumnIndexOrThrow("situacaoTributariaIcms");
      final int _cursorIndexOfValorIpi = _cursor.getColumnIndexOrThrow("valorIpi");
      final int _cursorIndexOfBaseCalculoIpi = _cursor.getColumnIndexOrThrow("baseCalculoIpi");
      final int _cursorIndexOfSituacaoTributariaIpi = _cursor.getColumnIndexOrThrow("situacaoTributariaIpi");
      final int _cursorIndexOfFlNovoFaturamento = _cursor.getColumnIndexOrThrow("flNovoFaturamento");
      final int _cursorIndexOfCdOperadora = _cursor.getColumnIndexOrThrow("cdOperadora");
      final int _cursorIndexOfFlPaciente = _cursor.getColumnIndexOrThrow("flPaciente");
      final int _cursorIndexOfCdCustomerService = _cursor.getColumnIndexOrThrow("cdCustomerService");
      final int _cursorIndexOfNomeAssinadorCec = _cursor.getColumnIndexOrThrow("nomeAssinadorCec");
      final int _cursorIndexOfRgAssinadorCec = _cursor.getColumnIndexOrThrow("rgAssinadorCec");
      final int _cursorIndexOfTipoMovimentoIntegracao = _cursor.getColumnIndexOrThrow("tipoMovimentoIntegracao");
      final int _cursorIndexOfSemPagto = _cursor.getColumnIndexOrThrow("semPagto");
      final int _cursorIndexOfStatusGravacaoJde = _cursor.getColumnIndexOrThrow("statusGravacaoJde");
      final int _cursorIndexOfMensagemGravacaoJde = _cursor.getColumnIndexOrThrow("mensagemGravacaoJde");
      final int _cursorIndexOfTipoTransacao = _cursor.getColumnIndexOrThrow("tipoTransacao");
      final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("status");
      final int _cursorIndexOfStatusContingencia = _cursor.getColumnIndexOrThrow("statusContingencia");
      final int _cursorIndexOfMensagemContingencia = _cursor.getColumnIndexOrThrow("mensagemContingencia");
      final int _cursorIndexOfStatusCec = _cursor.getColumnIndexOrThrow("statusCec");
      final int _cursorIndexOfNomeTransacao = _cursor.getColumnIndexOrThrow("nomeTransacao");
      final int _cursorIndexOfStatusImpressaoCec = _cursor.getColumnIndexOrThrow("statusImpressaoCec");
      final int _cursorIndexOfNomeFormaImpressaoCec = _cursor.getColumnIndexOrThrow("nomeFormaImpressaoCec");
      final int _cursorIndexOfNomeStatus = _cursor.getColumnIndexOrThrow("nomeStatus");
      final int _cursorIndexOfNomeStatusImpressaoCec = _cursor.getColumnIndexOrThrow("nomeStatusImpressaoCec");
      final int _cursorIndexOfFlPrecoAlterado = _cursor.getColumnIndexOrThrow("flPrecoAlterado");
      final int _cursorIndexOfNomeTipoPagamento = _cursor.getColumnIndexOrThrow("nomeTipoPagamento");
      final int _cursorIndexOfCdMotivo = _cursor.getColumnIndexOrThrow("cdMotivo");
      final int _cursorIndexOfDsMotivo = _cursor.getColumnIndexOrThrow("dsMotivo");
      final int _cursorIndexOfStatusNfeImp = _cursor.getColumnIndexOrThrow("statusNfeImp");
      final int _cursorIndexOfStatusReportFile = _cursor.getColumnIndexOrThrow("statusReportFile");
      final List<Invoice> _result = new ArrayList<Invoice>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Invoice _item;
        _item = new Invoice();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final Long _tmpNumero;
        if (_cursor.isNull(_cursorIndexOfNumero)) {
          _tmpNumero = null;
        } else {
          _tmpNumero = _cursor.getLong(_cursorIndexOfNumero);
        }
        _item.setNumero(_tmpNumero);
        final Long _tmpSerie;
        if (_cursor.isNull(_cursorIndexOfSerie)) {
          _tmpSerie = null;
        } else {
          _tmpSerie = _cursor.getLong(_cursorIndexOfSerie);
        }
        _item.setSerie(_tmpSerie);
        final Long _tmpNumeroNotaVOR;
        if (_cursor.isNull(_cursorIndexOfNumeroNotaVOR)) {
          _tmpNumeroNotaVOR = null;
        } else {
          _tmpNumeroNotaVOR = _cursor.getLong(_cursorIndexOfNumeroNotaVOR);
        }
        _item.setNumeroNotaVOR(_tmpNumeroNotaVOR);
        final Long _tmpSerieNotaVOR;
        if (_cursor.isNull(_cursorIndexOfSerieNotaVOR)) {
          _tmpSerieNotaVOR = null;
        } else {
          _tmpSerieNotaVOR = _cursor.getLong(_cursorIndexOfSerieNotaVOR);
        }
        _item.setSerieNotaVOR(_tmpSerieNotaVOR);
        final String _tmpCdPreOrdem;
        _tmpCdPreOrdem = _cursor.getString(_cursorIndexOfCdPreOrdem);
        _item.setCdPreOrdem(_tmpCdPreOrdem);
        final String _tmpNumeroFutEntrega;
        _tmpNumeroFutEntrega = _cursor.getString(_cursorIndexOfNumeroFutEntrega);
        _item.setNumeroFutEntrega(_tmpNumeroFutEntrega);
        final Integer _tmpCdFiscal;
        if (_cursor.isNull(_cursorIndexOfCdFiscal)) {
          _tmpCdFiscal = null;
        } else {
          _tmpCdFiscal = _cursor.getInt(_cursorIndexOfCdFiscal);
        }
        _item.setCdFiscal(_tmpCdFiscal);
        final String _tmpCnpjCpfDestino;
        _tmpCnpjCpfDestino = _cursor.getString(_cursorIndexOfCnpjCpfDestino);
        _item.setCnpjCpfDestino(_tmpCnpjCpfDestino);
        final String _tmpCnpjCpfTransp;
        _tmpCnpjCpfTransp = _cursor.getString(_cursorIndexOfCnpjCpfTransp);
        _item.setCnpjCpfTransp(_tmpCnpjCpfTransp);
        final String _tmpTipoNota;
        _tmpTipoNota = _cursor.getString(_cursorIndexOfTipoNota);
        _item.setTipoNota(_tmpTipoNota);
        final Integer _tmpClasseContribuinte;
        if (_cursor.isNull(_cursorIndexOfClasseContribuinte)) {
          _tmpClasseContribuinte = null;
        } else {
          _tmpClasseContribuinte = _cursor.getInt(_cursorIndexOfClasseContribuinte);
        }
        _item.setClasseContribuinte(_tmpClasseContribuinte);
        final String _tmpDataViagemPrincial;
        _tmpDataViagemPrincial = _cursor.getString(_cursorIndexOfDataViagemPrincial);
        _item.setDataViagemPrincial(_tmpDataViagemPrincial);
        final String _tmpNumeroViagem;
        _tmpNumeroViagem = _cursor.getString(_cursorIndexOfNumeroViagem);
        _item.setNumeroViagem(_tmpNumeroViagem);
        final String _tmpDataViagem;
        _tmpDataViagem = _cursor.getString(_cursorIndexOfDataViagem);
        _item.setDataViagem(_tmpDataViagem);
        final String _tmpNomeOperacao;
        _tmpNomeOperacao = _cursor.getString(_cursorIndexOfNomeOperacao);
        _item.setNomeOperacao(_tmpNomeOperacao);
        final Date _tmpDataEmissao;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfDataEmissao)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfDataEmissao);
        }
        _tmpDataEmissao = DateTypeConverter.fromTimestamp(_tmp);
        _item.setDataEmissao(_tmpDataEmissao);
        final Date _tmpDataMovimento;
        final Long _tmp_1;
        if (_cursor.isNull(_cursorIndexOfDataMovimento)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getLong(_cursorIndexOfDataMovimento);
        }
        _tmpDataMovimento = DateTypeConverter.fromTimestamp(_tmp_1);
        _item.setDataMovimento(_tmpDataMovimento);
        final Date _tmpDataVencimento;
        final Long _tmp_2;
        if (_cursor.isNull(_cursorIndexOfDataVencimento)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getLong(_cursorIndexOfDataVencimento);
        }
        _tmpDataVencimento = DateTypeConverter.fromTimestamp(_tmp_2);
        _item.setDataVencimento(_tmpDataVencimento);
        final Double _tmpValorTotal;
        if (_cursor.isNull(_cursorIndexOfValorTotal)) {
          _tmpValorTotal = null;
        } else {
          _tmpValorTotal = _cursor.getDouble(_cursorIndexOfValorTotal);
        }
        _item.setValorTotal(_tmpValorTotal);
        final Double _tmpValorLiquido;
        if (_cursor.isNull(_cursorIndexOfValorLiquido)) {
          _tmpValorLiquido = null;
        } else {
          _tmpValorLiquido = _cursor.getDouble(_cursorIndexOfValorLiquido);
        }
        _item.setValorLiquido(_tmpValorLiquido);
        final Double _tmpValorTotalProduto;
        if (_cursor.isNull(_cursorIndexOfValorTotalProduto)) {
          _tmpValorTotalProduto = null;
        } else {
          _tmpValorTotalProduto = _cursor.getDouble(_cursorIndexOfValorTotalProduto);
        }
        _item.setValorTotalProduto(_tmpValorTotalProduto);
        final Double _tmpValorFrete;
        if (_cursor.isNull(_cursorIndexOfValorFrete)) {
          _tmpValorFrete = null;
        } else {
          _tmpValorFrete = _cursor.getDouble(_cursorIndexOfValorFrete);
        }
        _item.setValorFrete(_tmpValorFrete);
        final Double _tmpValorDespAcessorias;
        if (_cursor.isNull(_cursorIndexOfValorDespAcessorias)) {
          _tmpValorDespAcessorias = null;
        } else {
          _tmpValorDespAcessorias = _cursor.getDouble(_cursorIndexOfValorDespAcessorias);
        }
        _item.setValorDespAcessorias(_tmpValorDespAcessorias);
        final Double _tmpValorDinheiro;
        if (_cursor.isNull(_cursorIndexOfValorDinheiro)) {
          _tmpValorDinheiro = null;
        } else {
          _tmpValorDinheiro = _cursor.getDouble(_cursorIndexOfValorDinheiro);
        }
        _item.setValorDinheiro(_tmpValorDinheiro);
        final Double _tmpValorTroco;
        if (_cursor.isNull(_cursorIndexOfValorTroco)) {
          _tmpValorTroco = null;
        } else {
          _tmpValorTroco = _cursor.getDouble(_cursorIndexOfValorTroco);
        }
        _item.setValorTroco(_tmpValorTroco);
        final Double _tmpValorFatura;
        if (_cursor.isNull(_cursorIndexOfValorFatura)) {
          _tmpValorFatura = null;
        } else {
          _tmpValorFatura = _cursor.getDouble(_cursorIndexOfValorFatura);
        }
        _item.setValorFatura(_tmpValorFatura);
        final Double _tmpValorDebito;
        if (_cursor.isNull(_cursorIndexOfValorDebito)) {
          _tmpValorDebito = null;
        } else {
          _tmpValorDebito = _cursor.getDouble(_cursorIndexOfValorDebito);
        }
        _item.setValorDebito(_tmpValorDebito);
        final Double _tmpValorCredito;
        if (_cursor.isNull(_cursorIndexOfValorCredito)) {
          _tmpValorCredito = null;
        } else {
          _tmpValorCredito = _cursor.getDouble(_cursorIndexOfValorCredito);
        }
        _item.setValorCredito(_tmpValorCredito);
        final Double _tmpValorCheque;
        if (_cursor.isNull(_cursorIndexOfValorCheque)) {
          _tmpValorCheque = null;
        } else {
          _tmpValorCheque = _cursor.getDouble(_cursorIndexOfValorCheque);
        }
        _item.setValorCheque(_tmpValorCheque);
        final String _tmpNumeroCheque;
        _tmpNumeroCheque = _cursor.getString(_cursorIndexOfNumeroCheque);
        _item.setNumeroCheque(_tmpNumeroCheque);
        final String _tmpUfVeiculo;
        _tmpUfVeiculo = _cursor.getString(_cursorIndexOfUfVeiculo);
        _item.setUfVeiculo(_tmpUfVeiculo);
        final String _tmpPlacaVeiculo;
        _tmpPlacaVeiculo = _cursor.getString(_cursorIndexOfPlacaVeiculo);
        _item.setPlacaVeiculo(_tmpPlacaVeiculo);
        final String _tmpNumeroVeiculo;
        _tmpNumeroVeiculo = _cursor.getString(_cursorIndexOfNumeroVeiculo);
        _item.setNumeroVeiculo(_tmpNumeroVeiculo);
        final Integer _tmpModalidadeFrete;
        if (_cursor.isNull(_cursorIndexOfModalidadeFrete)) {
          _tmpModalidadeFrete = null;
        } else {
          _tmpModalidadeFrete = _cursor.getInt(_cursorIndexOfModalidadeFrete);
        }
        _item.setModalidadeFrete(_tmpModalidadeFrete);
        final String _tmpNomeEspecVolume;
        _tmpNomeEspecVolume = _cursor.getString(_cursorIndexOfNomeEspecVolume);
        _item.setNomeEspecVolume(_tmpNomeEspecVolume);
        final String _tmpNomeMarca;
        _tmpNomeMarca = _cursor.getString(_cursorIndexOfNomeMarca);
        _item.setNomeMarca(_tmpNomeMarca);
        final Integer _tmpQtdVolumes;
        if (_cursor.isNull(_cursorIndexOfQtdVolumes)) {
          _tmpQtdVolumes = null;
        } else {
          _tmpQtdVolumes = _cursor.getInt(_cursorIndexOfQtdVolumes);
        }
        _item.setQtdVolumes(_tmpQtdVolumes);
        final Double _tmpVolumeCapacidade;
        if (_cursor.isNull(_cursorIndexOfVolumeCapacidade)) {
          _tmpVolumeCapacidade = null;
        } else {
          _tmpVolumeCapacidade = _cursor.getDouble(_cursorIndexOfVolumeCapacidade);
        }
        _item.setVolumeCapacidade(_tmpVolumeCapacidade);
        final Double _tmpVolumeCapacidadeReport;
        if (_cursor.isNull(_cursorIndexOfVolumeCapacidadeReport)) {
          _tmpVolumeCapacidadeReport = null;
        } else {
          _tmpVolumeCapacidadeReport = _cursor.getDouble(_cursorIndexOfVolumeCapacidadeReport);
        }
        _item.setVolumeCapacidadeReport(_tmpVolumeCapacidadeReport);
        final Double _tmpPesoBruto;
        if (_cursor.isNull(_cursorIndexOfPesoBruto)) {
          _tmpPesoBruto = null;
        } else {
          _tmpPesoBruto = _cursor.getDouble(_cursorIndexOfPesoBruto);
        }
        _item.setPesoBruto(_tmpPesoBruto);
        final Double _tmpPesoLiquido;
        if (_cursor.isNull(_cursorIndexOfPesoLiquido)) {
          _tmpPesoLiquido = null;
        } else {
          _tmpPesoLiquido = _cursor.getDouble(_cursorIndexOfPesoLiquido);
        }
        _item.setPesoLiquido(_tmpPesoLiquido);
        final String _tmpTipoPedido;
        _tmpTipoPedido = _cursor.getString(_cursorIndexOfTipoPedido);
        _item.setTipoPedido(_tmpTipoPedido);
        final Long _tmpCdCustomer;
        if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
          _tmpCdCustomer = null;
        } else {
          _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
        }
        _item.setCdCustomer(_tmpCdCustomer);
        final String _tmpAtivaTipoPagto;
        _tmpAtivaTipoPagto = _cursor.getString(_cursorIndexOfAtivaTipoPagto);
        _item.setAtivaTipoPagto(_tmpAtivaTipoPagto);
        final Integer _tmpStepEmissao;
        if (_cursor.isNull(_cursorIndexOfStepEmissao)) {
          _tmpStepEmissao = null;
        } else {
          _tmpStepEmissao = _cursor.getInt(_cursorIndexOfStepEmissao);
        }
        _item.setStepEmissao(_tmpStepEmissao);
        final String _tmpChave;
        _tmpChave = _cursor.getString(_cursorIndexOfChave);
        _item.setChave(_tmpChave);
        final String _tmpProtocolo;
        _tmpProtocolo = _cursor.getString(_cursorIndexOfProtocolo);
        _item.setProtocolo(_tmpProtocolo);
        final String _tmpCdMovimento;
        _tmpCdMovimento = _cursor.getString(_cursorIndexOfCdMovimento);
        _item.setCdMovimento(_tmpCdMovimento);
        final String _tmpCondicaoPagamento;
        _tmpCondicaoPagamento = _cursor.getString(_cursorIndexOfCondicaoPagamento);
        _item.setCondicaoPagamento(_tmpCondicaoPagamento);
        final Double _tmpAliquotaIcms;
        if (_cursor.isNull(_cursorIndexOfAliquotaIcms)) {
          _tmpAliquotaIcms = null;
        } else {
          _tmpAliquotaIcms = _cursor.getDouble(_cursorIndexOfAliquotaIcms);
        }
        _item.setAliquotaIcms(_tmpAliquotaIcms);
        final Double _tmpValorDescontoIcms;
        if (_cursor.isNull(_cursorIndexOfValorDescontoIcms)) {
          _tmpValorDescontoIcms = null;
        } else {
          _tmpValorDescontoIcms = _cursor.getDouble(_cursorIndexOfValorDescontoIcms);
        }
        _item.setValorDescontoIcms(_tmpValorDescontoIcms);
        final Double _tmpValorIcms;
        if (_cursor.isNull(_cursorIndexOfValorIcms)) {
          _tmpValorIcms = null;
        } else {
          _tmpValorIcms = _cursor.getDouble(_cursorIndexOfValorIcms);
        }
        _item.setValorIcms(_tmpValorIcms);
        final Double _tmpBaseCalculoIcms;
        if (_cursor.isNull(_cursorIndexOfBaseCalculoIcms)) {
          _tmpBaseCalculoIcms = null;
        } else {
          _tmpBaseCalculoIcms = _cursor.getDouble(_cursorIndexOfBaseCalculoIcms);
        }
        _item.setBaseCalculoIcms(_tmpBaseCalculoIcms);
        final Integer _tmpSituacaoTributariaIcms;
        if (_cursor.isNull(_cursorIndexOfSituacaoTributariaIcms)) {
          _tmpSituacaoTributariaIcms = null;
        } else {
          _tmpSituacaoTributariaIcms = _cursor.getInt(_cursorIndexOfSituacaoTributariaIcms);
        }
        _item.setSituacaoTributariaIcms(_tmpSituacaoTributariaIcms);
        final Double _tmpValorIpi;
        if (_cursor.isNull(_cursorIndexOfValorIpi)) {
          _tmpValorIpi = null;
        } else {
          _tmpValorIpi = _cursor.getDouble(_cursorIndexOfValorIpi);
        }
        _item.setValorIpi(_tmpValorIpi);
        final Double _tmpBaseCalculoIpi;
        if (_cursor.isNull(_cursorIndexOfBaseCalculoIpi)) {
          _tmpBaseCalculoIpi = null;
        } else {
          _tmpBaseCalculoIpi = _cursor.getDouble(_cursorIndexOfBaseCalculoIpi);
        }
        _item.setBaseCalculoIpi(_tmpBaseCalculoIpi);
        final Integer _tmpSituacaoTributariaIpi;
        if (_cursor.isNull(_cursorIndexOfSituacaoTributariaIpi)) {
          _tmpSituacaoTributariaIpi = null;
        } else {
          _tmpSituacaoTributariaIpi = _cursor.getInt(_cursorIndexOfSituacaoTributariaIpi);
        }
        _item.setSituacaoTributariaIpi(_tmpSituacaoTributariaIpi);
        final String _tmpFlNovoFaturamento;
        _tmpFlNovoFaturamento = _cursor.getString(_cursorIndexOfFlNovoFaturamento);
        _item.setFlNovoFaturamento(_tmpFlNovoFaturamento);
        final Long _tmpCdOperadora;
        if (_cursor.isNull(_cursorIndexOfCdOperadora)) {
          _tmpCdOperadora = null;
        } else {
          _tmpCdOperadora = _cursor.getLong(_cursorIndexOfCdOperadora);
        }
        _item.setCdOperadora(_tmpCdOperadora);
        final String _tmpFlPaciente;
        _tmpFlPaciente = _cursor.getString(_cursorIndexOfFlPaciente);
        _item.setFlPaciente(_tmpFlPaciente);
        final Long _tmpCdCustomerService;
        if (_cursor.isNull(_cursorIndexOfCdCustomerService)) {
          _tmpCdCustomerService = null;
        } else {
          _tmpCdCustomerService = _cursor.getLong(_cursorIndexOfCdCustomerService);
        }
        _item.setCdCustomerService(_tmpCdCustomerService);
        final String _tmpNomeAssinadorCec;
        _tmpNomeAssinadorCec = _cursor.getString(_cursorIndexOfNomeAssinadorCec);
        _item.setNomeAssinadorCec(_tmpNomeAssinadorCec);
        final String _tmpRgAssinadorCec;
        _tmpRgAssinadorCec = _cursor.getString(_cursorIndexOfRgAssinadorCec);
        _item.setRgAssinadorCec(_tmpRgAssinadorCec);
        final Integer _tmpTipoMovimentoIntegracao;
        if (_cursor.isNull(_cursorIndexOfTipoMovimentoIntegracao)) {
          _tmpTipoMovimentoIntegracao = null;
        } else {
          _tmpTipoMovimentoIntegracao = _cursor.getInt(_cursorIndexOfTipoMovimentoIntegracao);
        }
        _item.setTipoMovimentoIntegracao(_tmpTipoMovimentoIntegracao);
        final String _tmpSemPagto;
        _tmpSemPagto = _cursor.getString(_cursorIndexOfSemPagto);
        _item.setSemPagto(_tmpSemPagto);
        final Integer _tmpStatusGravacaoJde;
        if (_cursor.isNull(_cursorIndexOfStatusGravacaoJde)) {
          _tmpStatusGravacaoJde = null;
        } else {
          _tmpStatusGravacaoJde = _cursor.getInt(_cursorIndexOfStatusGravacaoJde);
        }
        _item.setStatusGravacaoJde(_tmpStatusGravacaoJde);
        final String _tmpMensagemGravacaoJde;
        _tmpMensagemGravacaoJde = _cursor.getString(_cursorIndexOfMensagemGravacaoJde);
        _item.setMensagemGravacaoJde(_tmpMensagemGravacaoJde);
        final Integer _tmpTipoTransacao;
        if (_cursor.isNull(_cursorIndexOfTipoTransacao)) {
          _tmpTipoTransacao = null;
        } else {
          _tmpTipoTransacao = _cursor.getInt(_cursorIndexOfTipoTransacao);
        }
        _item.setTipoTransacao(_tmpTipoTransacao);
        final Integer _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
        }
        _item.setStatus(_tmpStatus);
        final String _tmpStatusContingencia;
        _tmpStatusContingencia = _cursor.getString(_cursorIndexOfStatusContingencia);
        _item.setStatusContingencia(_tmpStatusContingencia);
        final String _tmpMensagemContingencia;
        _tmpMensagemContingencia = _cursor.getString(_cursorIndexOfMensagemContingencia);
        _item.setMensagemContingencia(_tmpMensagemContingencia);
        final Integer _tmpStatusCec;
        if (_cursor.isNull(_cursorIndexOfStatusCec)) {
          _tmpStatusCec = null;
        } else {
          _tmpStatusCec = _cursor.getInt(_cursorIndexOfStatusCec);
        }
        _item.setStatusCec(_tmpStatusCec);
        final String _tmpNomeTransacao;
        _tmpNomeTransacao = _cursor.getString(_cursorIndexOfNomeTransacao);
        _item.setNomeTransacao(_tmpNomeTransacao);
        final Integer _tmpStatusImpressaoCec;
        if (_cursor.isNull(_cursorIndexOfStatusImpressaoCec)) {
          _tmpStatusImpressaoCec = null;
        } else {
          _tmpStatusImpressaoCec = _cursor.getInt(_cursorIndexOfStatusImpressaoCec);
        }
        _item.setStatusImpressaoCec(_tmpStatusImpressaoCec);
        final String _tmpNomeFormaImpressaoCec;
        _tmpNomeFormaImpressaoCec = _cursor.getString(_cursorIndexOfNomeFormaImpressaoCec);
        _item.setNomeFormaImpressaoCec(_tmpNomeFormaImpressaoCec);
        final String _tmpNomeStatus;
        _tmpNomeStatus = _cursor.getString(_cursorIndexOfNomeStatus);
        _item.setNomeStatus(_tmpNomeStatus);
        final String _tmpNomeStatusImpressaoCec;
        _tmpNomeStatusImpressaoCec = _cursor.getString(_cursorIndexOfNomeStatusImpressaoCec);
        _item.setNomeStatusImpressaoCec(_tmpNomeStatusImpressaoCec);
        final String _tmpFlPrecoAlterado;
        _tmpFlPrecoAlterado = _cursor.getString(_cursorIndexOfFlPrecoAlterado);
        _item.setFlPrecoAlterado(_tmpFlPrecoAlterado);
        final String _tmpNomeTipoPagamento;
        _tmpNomeTipoPagamento = _cursor.getString(_cursorIndexOfNomeTipoPagamento);
        _item.setNomeTipoPagamento(_tmpNomeTipoPagamento);
        final String _tmpCdMotivo;
        _tmpCdMotivo = _cursor.getString(_cursorIndexOfCdMotivo);
        _item.setCdMotivo(_tmpCdMotivo);
        final String _tmpDsMotivo;
        _tmpDsMotivo = _cursor.getString(_cursorIndexOfDsMotivo);
        _item.setDsMotivo(_tmpDsMotivo);
        final String _tmpStatusNfeImp;
        _tmpStatusNfeImp = _cursor.getString(_cursorIndexOfStatusNfeImp);
        _item.setStatusNfeImp(_tmpStatusNfeImp);
        final String _tmpStatusReportFile;
        _tmpStatusReportFile = _cursor.getString(_cursorIndexOfStatusReportFile);
        _item.setStatusReportFile(_tmpStatusReportFile);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Invoice findPriorInvoice(Long numero, String tipoNota) {
    final String _sql = "SELECT * FROM Invoice WHERE numero < ? AND tiponota = ? ORDER BY Invoice.dataMovimento DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (numero == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, numero);
    }
    _argIndex = 2;
    if (tipoNota == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, tipoNota);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfNumero = _cursor.getColumnIndexOrThrow("numero");
      final int _cursorIndexOfSerie = _cursor.getColumnIndexOrThrow("serie");
      final int _cursorIndexOfNumeroNotaVOR = _cursor.getColumnIndexOrThrow("numeroNotaVOR");
      final int _cursorIndexOfSerieNotaVOR = _cursor.getColumnIndexOrThrow("serieNotaVOR");
      final int _cursorIndexOfCdPreOrdem = _cursor.getColumnIndexOrThrow("cdPreOrdem");
      final int _cursorIndexOfNumeroFutEntrega = _cursor.getColumnIndexOrThrow("numeroFutEntrega");
      final int _cursorIndexOfCdFiscal = _cursor.getColumnIndexOrThrow("cdFiscal");
      final int _cursorIndexOfCnpjCpfDestino = _cursor.getColumnIndexOrThrow("cnpjCpfDestino");
      final int _cursorIndexOfCnpjCpfTransp = _cursor.getColumnIndexOrThrow("cnpjCpfTransp");
      final int _cursorIndexOfTipoNota = _cursor.getColumnIndexOrThrow("tipoNota");
      final int _cursorIndexOfClasseContribuinte = _cursor.getColumnIndexOrThrow("classeContribuinte");
      final int _cursorIndexOfDataViagemPrincial = _cursor.getColumnIndexOrThrow("dataViagemPrincial");
      final int _cursorIndexOfNumeroViagem = _cursor.getColumnIndexOrThrow("numeroViagem");
      final int _cursorIndexOfDataViagem = _cursor.getColumnIndexOrThrow("dataViagem");
      final int _cursorIndexOfNomeOperacao = _cursor.getColumnIndexOrThrow("nomeOperacao");
      final int _cursorIndexOfDataEmissao = _cursor.getColumnIndexOrThrow("dataEmissao");
      final int _cursorIndexOfDataMovimento = _cursor.getColumnIndexOrThrow("dataMovimento");
      final int _cursorIndexOfDataVencimento = _cursor.getColumnIndexOrThrow("dataVencimento");
      final int _cursorIndexOfValorTotal = _cursor.getColumnIndexOrThrow("valorTotal");
      final int _cursorIndexOfValorLiquido = _cursor.getColumnIndexOrThrow("valorLiquido");
      final int _cursorIndexOfValorTotalProduto = _cursor.getColumnIndexOrThrow("valorTotalProduto");
      final int _cursorIndexOfValorFrete = _cursor.getColumnIndexOrThrow("valorFrete");
      final int _cursorIndexOfValorDespAcessorias = _cursor.getColumnIndexOrThrow("valorDespAcessorias");
      final int _cursorIndexOfValorDinheiro = _cursor.getColumnIndexOrThrow("valorDinheiro");
      final int _cursorIndexOfValorTroco = _cursor.getColumnIndexOrThrow("valorTroco");
      final int _cursorIndexOfValorFatura = _cursor.getColumnIndexOrThrow("valorFatura");
      final int _cursorIndexOfValorDebito = _cursor.getColumnIndexOrThrow("valorDebito");
      final int _cursorIndexOfValorCredito = _cursor.getColumnIndexOrThrow("valorCredito");
      final int _cursorIndexOfValorCheque = _cursor.getColumnIndexOrThrow("valorCheque");
      final int _cursorIndexOfNumeroCheque = _cursor.getColumnIndexOrThrow("numeroCheque");
      final int _cursorIndexOfUfVeiculo = _cursor.getColumnIndexOrThrow("ufVeiculo");
      final int _cursorIndexOfPlacaVeiculo = _cursor.getColumnIndexOrThrow("placaVeiculo");
      final int _cursorIndexOfNumeroVeiculo = _cursor.getColumnIndexOrThrow("numeroVeiculo");
      final int _cursorIndexOfModalidadeFrete = _cursor.getColumnIndexOrThrow("modalidadeFrete");
      final int _cursorIndexOfNomeEspecVolume = _cursor.getColumnIndexOrThrow("nomeEspecVolume");
      final int _cursorIndexOfNomeMarca = _cursor.getColumnIndexOrThrow("nomeMarca");
      final int _cursorIndexOfQtdVolumes = _cursor.getColumnIndexOrThrow("qtdVolumes");
      final int _cursorIndexOfVolumeCapacidade = _cursor.getColumnIndexOrThrow("volumeCapacidade");
      final int _cursorIndexOfVolumeCapacidadeReport = _cursor.getColumnIndexOrThrow("volumeCapacidadeReport");
      final int _cursorIndexOfPesoBruto = _cursor.getColumnIndexOrThrow("pesoBruto");
      final int _cursorIndexOfPesoLiquido = _cursor.getColumnIndexOrThrow("pesoLiquido");
      final int _cursorIndexOfTipoPedido = _cursor.getColumnIndexOrThrow("tipoPedido");
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfAtivaTipoPagto = _cursor.getColumnIndexOrThrow("ativaTipoPagto");
      final int _cursorIndexOfStepEmissao = _cursor.getColumnIndexOrThrow("stepEmissao");
      final int _cursorIndexOfChave = _cursor.getColumnIndexOrThrow("chave");
      final int _cursorIndexOfProtocolo = _cursor.getColumnIndexOrThrow("protocolo");
      final int _cursorIndexOfCdMovimento = _cursor.getColumnIndexOrThrow("cdMovimento");
      final int _cursorIndexOfCondicaoPagamento = _cursor.getColumnIndexOrThrow("condicaoPagamento");
      final int _cursorIndexOfAliquotaIcms = _cursor.getColumnIndexOrThrow("aliquotaIcms");
      final int _cursorIndexOfValorDescontoIcms = _cursor.getColumnIndexOrThrow("valorDescontoIcms");
      final int _cursorIndexOfValorIcms = _cursor.getColumnIndexOrThrow("valorIcms");
      final int _cursorIndexOfBaseCalculoIcms = _cursor.getColumnIndexOrThrow("baseCalculoIcms");
      final int _cursorIndexOfSituacaoTributariaIcms = _cursor.getColumnIndexOrThrow("situacaoTributariaIcms");
      final int _cursorIndexOfValorIpi = _cursor.getColumnIndexOrThrow("valorIpi");
      final int _cursorIndexOfBaseCalculoIpi = _cursor.getColumnIndexOrThrow("baseCalculoIpi");
      final int _cursorIndexOfSituacaoTributariaIpi = _cursor.getColumnIndexOrThrow("situacaoTributariaIpi");
      final int _cursorIndexOfFlNovoFaturamento = _cursor.getColumnIndexOrThrow("flNovoFaturamento");
      final int _cursorIndexOfCdOperadora = _cursor.getColumnIndexOrThrow("cdOperadora");
      final int _cursorIndexOfFlPaciente = _cursor.getColumnIndexOrThrow("flPaciente");
      final int _cursorIndexOfCdCustomerService = _cursor.getColumnIndexOrThrow("cdCustomerService");
      final int _cursorIndexOfNomeAssinadorCec = _cursor.getColumnIndexOrThrow("nomeAssinadorCec");
      final int _cursorIndexOfRgAssinadorCec = _cursor.getColumnIndexOrThrow("rgAssinadorCec");
      final int _cursorIndexOfTipoMovimentoIntegracao = _cursor.getColumnIndexOrThrow("tipoMovimentoIntegracao");
      final int _cursorIndexOfSemPagto = _cursor.getColumnIndexOrThrow("semPagto");
      final int _cursorIndexOfStatusGravacaoJde = _cursor.getColumnIndexOrThrow("statusGravacaoJde");
      final int _cursorIndexOfMensagemGravacaoJde = _cursor.getColumnIndexOrThrow("mensagemGravacaoJde");
      final int _cursorIndexOfTipoTransacao = _cursor.getColumnIndexOrThrow("tipoTransacao");
      final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("status");
      final int _cursorIndexOfStatusContingencia = _cursor.getColumnIndexOrThrow("statusContingencia");
      final int _cursorIndexOfMensagemContingencia = _cursor.getColumnIndexOrThrow("mensagemContingencia");
      final int _cursorIndexOfStatusCec = _cursor.getColumnIndexOrThrow("statusCec");
      final int _cursorIndexOfNomeTransacao = _cursor.getColumnIndexOrThrow("nomeTransacao");
      final int _cursorIndexOfStatusImpressaoCec = _cursor.getColumnIndexOrThrow("statusImpressaoCec");
      final int _cursorIndexOfNomeFormaImpressaoCec = _cursor.getColumnIndexOrThrow("nomeFormaImpressaoCec");
      final int _cursorIndexOfNomeStatus = _cursor.getColumnIndexOrThrow("nomeStatus");
      final int _cursorIndexOfNomeStatusImpressaoCec = _cursor.getColumnIndexOrThrow("nomeStatusImpressaoCec");
      final int _cursorIndexOfFlPrecoAlterado = _cursor.getColumnIndexOrThrow("flPrecoAlterado");
      final int _cursorIndexOfNomeTipoPagamento = _cursor.getColumnIndexOrThrow("nomeTipoPagamento");
      final int _cursorIndexOfCdMotivo = _cursor.getColumnIndexOrThrow("cdMotivo");
      final int _cursorIndexOfDsMotivo = _cursor.getColumnIndexOrThrow("dsMotivo");
      final int _cursorIndexOfStatusNfeImp = _cursor.getColumnIndexOrThrow("statusNfeImp");
      final int _cursorIndexOfStatusReportFile = _cursor.getColumnIndexOrThrow("statusReportFile");
      final Invoice _result;
      if(_cursor.moveToFirst()) {
        _result = new Invoice();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _result.setId(_tmpId);
        final Long _tmpNumero;
        if (_cursor.isNull(_cursorIndexOfNumero)) {
          _tmpNumero = null;
        } else {
          _tmpNumero = _cursor.getLong(_cursorIndexOfNumero);
        }
        _result.setNumero(_tmpNumero);
        final Long _tmpSerie;
        if (_cursor.isNull(_cursorIndexOfSerie)) {
          _tmpSerie = null;
        } else {
          _tmpSerie = _cursor.getLong(_cursorIndexOfSerie);
        }
        _result.setSerie(_tmpSerie);
        final Long _tmpNumeroNotaVOR;
        if (_cursor.isNull(_cursorIndexOfNumeroNotaVOR)) {
          _tmpNumeroNotaVOR = null;
        } else {
          _tmpNumeroNotaVOR = _cursor.getLong(_cursorIndexOfNumeroNotaVOR);
        }
        _result.setNumeroNotaVOR(_tmpNumeroNotaVOR);
        final Long _tmpSerieNotaVOR;
        if (_cursor.isNull(_cursorIndexOfSerieNotaVOR)) {
          _tmpSerieNotaVOR = null;
        } else {
          _tmpSerieNotaVOR = _cursor.getLong(_cursorIndexOfSerieNotaVOR);
        }
        _result.setSerieNotaVOR(_tmpSerieNotaVOR);
        final String _tmpCdPreOrdem;
        _tmpCdPreOrdem = _cursor.getString(_cursorIndexOfCdPreOrdem);
        _result.setCdPreOrdem(_tmpCdPreOrdem);
        final String _tmpNumeroFutEntrega;
        _tmpNumeroFutEntrega = _cursor.getString(_cursorIndexOfNumeroFutEntrega);
        _result.setNumeroFutEntrega(_tmpNumeroFutEntrega);
        final Integer _tmpCdFiscal;
        if (_cursor.isNull(_cursorIndexOfCdFiscal)) {
          _tmpCdFiscal = null;
        } else {
          _tmpCdFiscal = _cursor.getInt(_cursorIndexOfCdFiscal);
        }
        _result.setCdFiscal(_tmpCdFiscal);
        final String _tmpCnpjCpfDestino;
        _tmpCnpjCpfDestino = _cursor.getString(_cursorIndexOfCnpjCpfDestino);
        _result.setCnpjCpfDestino(_tmpCnpjCpfDestino);
        final String _tmpCnpjCpfTransp;
        _tmpCnpjCpfTransp = _cursor.getString(_cursorIndexOfCnpjCpfTransp);
        _result.setCnpjCpfTransp(_tmpCnpjCpfTransp);
        final String _tmpTipoNota;
        _tmpTipoNota = _cursor.getString(_cursorIndexOfTipoNota);
        _result.setTipoNota(_tmpTipoNota);
        final Integer _tmpClasseContribuinte;
        if (_cursor.isNull(_cursorIndexOfClasseContribuinte)) {
          _tmpClasseContribuinte = null;
        } else {
          _tmpClasseContribuinte = _cursor.getInt(_cursorIndexOfClasseContribuinte);
        }
        _result.setClasseContribuinte(_tmpClasseContribuinte);
        final String _tmpDataViagemPrincial;
        _tmpDataViagemPrincial = _cursor.getString(_cursorIndexOfDataViagemPrincial);
        _result.setDataViagemPrincial(_tmpDataViagemPrincial);
        final String _tmpNumeroViagem;
        _tmpNumeroViagem = _cursor.getString(_cursorIndexOfNumeroViagem);
        _result.setNumeroViagem(_tmpNumeroViagem);
        final String _tmpDataViagem;
        _tmpDataViagem = _cursor.getString(_cursorIndexOfDataViagem);
        _result.setDataViagem(_tmpDataViagem);
        final String _tmpNomeOperacao;
        _tmpNomeOperacao = _cursor.getString(_cursorIndexOfNomeOperacao);
        _result.setNomeOperacao(_tmpNomeOperacao);
        final Date _tmpDataEmissao;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfDataEmissao)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfDataEmissao);
        }
        _tmpDataEmissao = DateTypeConverter.fromTimestamp(_tmp);
        _result.setDataEmissao(_tmpDataEmissao);
        final Date _tmpDataMovimento;
        final Long _tmp_1;
        if (_cursor.isNull(_cursorIndexOfDataMovimento)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getLong(_cursorIndexOfDataMovimento);
        }
        _tmpDataMovimento = DateTypeConverter.fromTimestamp(_tmp_1);
        _result.setDataMovimento(_tmpDataMovimento);
        final Date _tmpDataVencimento;
        final Long _tmp_2;
        if (_cursor.isNull(_cursorIndexOfDataVencimento)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getLong(_cursorIndexOfDataVencimento);
        }
        _tmpDataVencimento = DateTypeConverter.fromTimestamp(_tmp_2);
        _result.setDataVencimento(_tmpDataVencimento);
        final Double _tmpValorTotal;
        if (_cursor.isNull(_cursorIndexOfValorTotal)) {
          _tmpValorTotal = null;
        } else {
          _tmpValorTotal = _cursor.getDouble(_cursorIndexOfValorTotal);
        }
        _result.setValorTotal(_tmpValorTotal);
        final Double _tmpValorLiquido;
        if (_cursor.isNull(_cursorIndexOfValorLiquido)) {
          _tmpValorLiquido = null;
        } else {
          _tmpValorLiquido = _cursor.getDouble(_cursorIndexOfValorLiquido);
        }
        _result.setValorLiquido(_tmpValorLiquido);
        final Double _tmpValorTotalProduto;
        if (_cursor.isNull(_cursorIndexOfValorTotalProduto)) {
          _tmpValorTotalProduto = null;
        } else {
          _tmpValorTotalProduto = _cursor.getDouble(_cursorIndexOfValorTotalProduto);
        }
        _result.setValorTotalProduto(_tmpValorTotalProduto);
        final Double _tmpValorFrete;
        if (_cursor.isNull(_cursorIndexOfValorFrete)) {
          _tmpValorFrete = null;
        } else {
          _tmpValorFrete = _cursor.getDouble(_cursorIndexOfValorFrete);
        }
        _result.setValorFrete(_tmpValorFrete);
        final Double _tmpValorDespAcessorias;
        if (_cursor.isNull(_cursorIndexOfValorDespAcessorias)) {
          _tmpValorDespAcessorias = null;
        } else {
          _tmpValorDespAcessorias = _cursor.getDouble(_cursorIndexOfValorDespAcessorias);
        }
        _result.setValorDespAcessorias(_tmpValorDespAcessorias);
        final Double _tmpValorDinheiro;
        if (_cursor.isNull(_cursorIndexOfValorDinheiro)) {
          _tmpValorDinheiro = null;
        } else {
          _tmpValorDinheiro = _cursor.getDouble(_cursorIndexOfValorDinheiro);
        }
        _result.setValorDinheiro(_tmpValorDinheiro);
        final Double _tmpValorTroco;
        if (_cursor.isNull(_cursorIndexOfValorTroco)) {
          _tmpValorTroco = null;
        } else {
          _tmpValorTroco = _cursor.getDouble(_cursorIndexOfValorTroco);
        }
        _result.setValorTroco(_tmpValorTroco);
        final Double _tmpValorFatura;
        if (_cursor.isNull(_cursorIndexOfValorFatura)) {
          _tmpValorFatura = null;
        } else {
          _tmpValorFatura = _cursor.getDouble(_cursorIndexOfValorFatura);
        }
        _result.setValorFatura(_tmpValorFatura);
        final Double _tmpValorDebito;
        if (_cursor.isNull(_cursorIndexOfValorDebito)) {
          _tmpValorDebito = null;
        } else {
          _tmpValorDebito = _cursor.getDouble(_cursorIndexOfValorDebito);
        }
        _result.setValorDebito(_tmpValorDebito);
        final Double _tmpValorCredito;
        if (_cursor.isNull(_cursorIndexOfValorCredito)) {
          _tmpValorCredito = null;
        } else {
          _tmpValorCredito = _cursor.getDouble(_cursorIndexOfValorCredito);
        }
        _result.setValorCredito(_tmpValorCredito);
        final Double _tmpValorCheque;
        if (_cursor.isNull(_cursorIndexOfValorCheque)) {
          _tmpValorCheque = null;
        } else {
          _tmpValorCheque = _cursor.getDouble(_cursorIndexOfValorCheque);
        }
        _result.setValorCheque(_tmpValorCheque);
        final String _tmpNumeroCheque;
        _tmpNumeroCheque = _cursor.getString(_cursorIndexOfNumeroCheque);
        _result.setNumeroCheque(_tmpNumeroCheque);
        final String _tmpUfVeiculo;
        _tmpUfVeiculo = _cursor.getString(_cursorIndexOfUfVeiculo);
        _result.setUfVeiculo(_tmpUfVeiculo);
        final String _tmpPlacaVeiculo;
        _tmpPlacaVeiculo = _cursor.getString(_cursorIndexOfPlacaVeiculo);
        _result.setPlacaVeiculo(_tmpPlacaVeiculo);
        final String _tmpNumeroVeiculo;
        _tmpNumeroVeiculo = _cursor.getString(_cursorIndexOfNumeroVeiculo);
        _result.setNumeroVeiculo(_tmpNumeroVeiculo);
        final Integer _tmpModalidadeFrete;
        if (_cursor.isNull(_cursorIndexOfModalidadeFrete)) {
          _tmpModalidadeFrete = null;
        } else {
          _tmpModalidadeFrete = _cursor.getInt(_cursorIndexOfModalidadeFrete);
        }
        _result.setModalidadeFrete(_tmpModalidadeFrete);
        final String _tmpNomeEspecVolume;
        _tmpNomeEspecVolume = _cursor.getString(_cursorIndexOfNomeEspecVolume);
        _result.setNomeEspecVolume(_tmpNomeEspecVolume);
        final String _tmpNomeMarca;
        _tmpNomeMarca = _cursor.getString(_cursorIndexOfNomeMarca);
        _result.setNomeMarca(_tmpNomeMarca);
        final Integer _tmpQtdVolumes;
        if (_cursor.isNull(_cursorIndexOfQtdVolumes)) {
          _tmpQtdVolumes = null;
        } else {
          _tmpQtdVolumes = _cursor.getInt(_cursorIndexOfQtdVolumes);
        }
        _result.setQtdVolumes(_tmpQtdVolumes);
        final Double _tmpVolumeCapacidade;
        if (_cursor.isNull(_cursorIndexOfVolumeCapacidade)) {
          _tmpVolumeCapacidade = null;
        } else {
          _tmpVolumeCapacidade = _cursor.getDouble(_cursorIndexOfVolumeCapacidade);
        }
        _result.setVolumeCapacidade(_tmpVolumeCapacidade);
        final Double _tmpVolumeCapacidadeReport;
        if (_cursor.isNull(_cursorIndexOfVolumeCapacidadeReport)) {
          _tmpVolumeCapacidadeReport = null;
        } else {
          _tmpVolumeCapacidadeReport = _cursor.getDouble(_cursorIndexOfVolumeCapacidadeReport);
        }
        _result.setVolumeCapacidadeReport(_tmpVolumeCapacidadeReport);
        final Double _tmpPesoBruto;
        if (_cursor.isNull(_cursorIndexOfPesoBruto)) {
          _tmpPesoBruto = null;
        } else {
          _tmpPesoBruto = _cursor.getDouble(_cursorIndexOfPesoBruto);
        }
        _result.setPesoBruto(_tmpPesoBruto);
        final Double _tmpPesoLiquido;
        if (_cursor.isNull(_cursorIndexOfPesoLiquido)) {
          _tmpPesoLiquido = null;
        } else {
          _tmpPesoLiquido = _cursor.getDouble(_cursorIndexOfPesoLiquido);
        }
        _result.setPesoLiquido(_tmpPesoLiquido);
        final String _tmpTipoPedido;
        _tmpTipoPedido = _cursor.getString(_cursorIndexOfTipoPedido);
        _result.setTipoPedido(_tmpTipoPedido);
        final Long _tmpCdCustomer;
        if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
          _tmpCdCustomer = null;
        } else {
          _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
        }
        _result.setCdCustomer(_tmpCdCustomer);
        final String _tmpAtivaTipoPagto;
        _tmpAtivaTipoPagto = _cursor.getString(_cursorIndexOfAtivaTipoPagto);
        _result.setAtivaTipoPagto(_tmpAtivaTipoPagto);
        final Integer _tmpStepEmissao;
        if (_cursor.isNull(_cursorIndexOfStepEmissao)) {
          _tmpStepEmissao = null;
        } else {
          _tmpStepEmissao = _cursor.getInt(_cursorIndexOfStepEmissao);
        }
        _result.setStepEmissao(_tmpStepEmissao);
        final String _tmpChave;
        _tmpChave = _cursor.getString(_cursorIndexOfChave);
        _result.setChave(_tmpChave);
        final String _tmpProtocolo;
        _tmpProtocolo = _cursor.getString(_cursorIndexOfProtocolo);
        _result.setProtocolo(_tmpProtocolo);
        final String _tmpCdMovimento;
        _tmpCdMovimento = _cursor.getString(_cursorIndexOfCdMovimento);
        _result.setCdMovimento(_tmpCdMovimento);
        final String _tmpCondicaoPagamento;
        _tmpCondicaoPagamento = _cursor.getString(_cursorIndexOfCondicaoPagamento);
        _result.setCondicaoPagamento(_tmpCondicaoPagamento);
        final Double _tmpAliquotaIcms;
        if (_cursor.isNull(_cursorIndexOfAliquotaIcms)) {
          _tmpAliquotaIcms = null;
        } else {
          _tmpAliquotaIcms = _cursor.getDouble(_cursorIndexOfAliquotaIcms);
        }
        _result.setAliquotaIcms(_tmpAliquotaIcms);
        final Double _tmpValorDescontoIcms;
        if (_cursor.isNull(_cursorIndexOfValorDescontoIcms)) {
          _tmpValorDescontoIcms = null;
        } else {
          _tmpValorDescontoIcms = _cursor.getDouble(_cursorIndexOfValorDescontoIcms);
        }
        _result.setValorDescontoIcms(_tmpValorDescontoIcms);
        final Double _tmpValorIcms;
        if (_cursor.isNull(_cursorIndexOfValorIcms)) {
          _tmpValorIcms = null;
        } else {
          _tmpValorIcms = _cursor.getDouble(_cursorIndexOfValorIcms);
        }
        _result.setValorIcms(_tmpValorIcms);
        final Double _tmpBaseCalculoIcms;
        if (_cursor.isNull(_cursorIndexOfBaseCalculoIcms)) {
          _tmpBaseCalculoIcms = null;
        } else {
          _tmpBaseCalculoIcms = _cursor.getDouble(_cursorIndexOfBaseCalculoIcms);
        }
        _result.setBaseCalculoIcms(_tmpBaseCalculoIcms);
        final Integer _tmpSituacaoTributariaIcms;
        if (_cursor.isNull(_cursorIndexOfSituacaoTributariaIcms)) {
          _tmpSituacaoTributariaIcms = null;
        } else {
          _tmpSituacaoTributariaIcms = _cursor.getInt(_cursorIndexOfSituacaoTributariaIcms);
        }
        _result.setSituacaoTributariaIcms(_tmpSituacaoTributariaIcms);
        final Double _tmpValorIpi;
        if (_cursor.isNull(_cursorIndexOfValorIpi)) {
          _tmpValorIpi = null;
        } else {
          _tmpValorIpi = _cursor.getDouble(_cursorIndexOfValorIpi);
        }
        _result.setValorIpi(_tmpValorIpi);
        final Double _tmpBaseCalculoIpi;
        if (_cursor.isNull(_cursorIndexOfBaseCalculoIpi)) {
          _tmpBaseCalculoIpi = null;
        } else {
          _tmpBaseCalculoIpi = _cursor.getDouble(_cursorIndexOfBaseCalculoIpi);
        }
        _result.setBaseCalculoIpi(_tmpBaseCalculoIpi);
        final Integer _tmpSituacaoTributariaIpi;
        if (_cursor.isNull(_cursorIndexOfSituacaoTributariaIpi)) {
          _tmpSituacaoTributariaIpi = null;
        } else {
          _tmpSituacaoTributariaIpi = _cursor.getInt(_cursorIndexOfSituacaoTributariaIpi);
        }
        _result.setSituacaoTributariaIpi(_tmpSituacaoTributariaIpi);
        final String _tmpFlNovoFaturamento;
        _tmpFlNovoFaturamento = _cursor.getString(_cursorIndexOfFlNovoFaturamento);
        _result.setFlNovoFaturamento(_tmpFlNovoFaturamento);
        final Long _tmpCdOperadora;
        if (_cursor.isNull(_cursorIndexOfCdOperadora)) {
          _tmpCdOperadora = null;
        } else {
          _tmpCdOperadora = _cursor.getLong(_cursorIndexOfCdOperadora);
        }
        _result.setCdOperadora(_tmpCdOperadora);
        final String _tmpFlPaciente;
        _tmpFlPaciente = _cursor.getString(_cursorIndexOfFlPaciente);
        _result.setFlPaciente(_tmpFlPaciente);
        final Long _tmpCdCustomerService;
        if (_cursor.isNull(_cursorIndexOfCdCustomerService)) {
          _tmpCdCustomerService = null;
        } else {
          _tmpCdCustomerService = _cursor.getLong(_cursorIndexOfCdCustomerService);
        }
        _result.setCdCustomerService(_tmpCdCustomerService);
        final String _tmpNomeAssinadorCec;
        _tmpNomeAssinadorCec = _cursor.getString(_cursorIndexOfNomeAssinadorCec);
        _result.setNomeAssinadorCec(_tmpNomeAssinadorCec);
        final String _tmpRgAssinadorCec;
        _tmpRgAssinadorCec = _cursor.getString(_cursorIndexOfRgAssinadorCec);
        _result.setRgAssinadorCec(_tmpRgAssinadorCec);
        final Integer _tmpTipoMovimentoIntegracao;
        if (_cursor.isNull(_cursorIndexOfTipoMovimentoIntegracao)) {
          _tmpTipoMovimentoIntegracao = null;
        } else {
          _tmpTipoMovimentoIntegracao = _cursor.getInt(_cursorIndexOfTipoMovimentoIntegracao);
        }
        _result.setTipoMovimentoIntegracao(_tmpTipoMovimentoIntegracao);
        final String _tmpSemPagto;
        _tmpSemPagto = _cursor.getString(_cursorIndexOfSemPagto);
        _result.setSemPagto(_tmpSemPagto);
        final Integer _tmpStatusGravacaoJde;
        if (_cursor.isNull(_cursorIndexOfStatusGravacaoJde)) {
          _tmpStatusGravacaoJde = null;
        } else {
          _tmpStatusGravacaoJde = _cursor.getInt(_cursorIndexOfStatusGravacaoJde);
        }
        _result.setStatusGravacaoJde(_tmpStatusGravacaoJde);
        final String _tmpMensagemGravacaoJde;
        _tmpMensagemGravacaoJde = _cursor.getString(_cursorIndexOfMensagemGravacaoJde);
        _result.setMensagemGravacaoJde(_tmpMensagemGravacaoJde);
        final Integer _tmpTipoTransacao;
        if (_cursor.isNull(_cursorIndexOfTipoTransacao)) {
          _tmpTipoTransacao = null;
        } else {
          _tmpTipoTransacao = _cursor.getInt(_cursorIndexOfTipoTransacao);
        }
        _result.setTipoTransacao(_tmpTipoTransacao);
        final Integer _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
        }
        _result.setStatus(_tmpStatus);
        final String _tmpStatusContingencia;
        _tmpStatusContingencia = _cursor.getString(_cursorIndexOfStatusContingencia);
        _result.setStatusContingencia(_tmpStatusContingencia);
        final String _tmpMensagemContingencia;
        _tmpMensagemContingencia = _cursor.getString(_cursorIndexOfMensagemContingencia);
        _result.setMensagemContingencia(_tmpMensagemContingencia);
        final Integer _tmpStatusCec;
        if (_cursor.isNull(_cursorIndexOfStatusCec)) {
          _tmpStatusCec = null;
        } else {
          _tmpStatusCec = _cursor.getInt(_cursorIndexOfStatusCec);
        }
        _result.setStatusCec(_tmpStatusCec);
        final String _tmpNomeTransacao;
        _tmpNomeTransacao = _cursor.getString(_cursorIndexOfNomeTransacao);
        _result.setNomeTransacao(_tmpNomeTransacao);
        final Integer _tmpStatusImpressaoCec;
        if (_cursor.isNull(_cursorIndexOfStatusImpressaoCec)) {
          _tmpStatusImpressaoCec = null;
        } else {
          _tmpStatusImpressaoCec = _cursor.getInt(_cursorIndexOfStatusImpressaoCec);
        }
        _result.setStatusImpressaoCec(_tmpStatusImpressaoCec);
        final String _tmpNomeFormaImpressaoCec;
        _tmpNomeFormaImpressaoCec = _cursor.getString(_cursorIndexOfNomeFormaImpressaoCec);
        _result.setNomeFormaImpressaoCec(_tmpNomeFormaImpressaoCec);
        final String _tmpNomeStatus;
        _tmpNomeStatus = _cursor.getString(_cursorIndexOfNomeStatus);
        _result.setNomeStatus(_tmpNomeStatus);
        final String _tmpNomeStatusImpressaoCec;
        _tmpNomeStatusImpressaoCec = _cursor.getString(_cursorIndexOfNomeStatusImpressaoCec);
        _result.setNomeStatusImpressaoCec(_tmpNomeStatusImpressaoCec);
        final String _tmpFlPrecoAlterado;
        _tmpFlPrecoAlterado = _cursor.getString(_cursorIndexOfFlPrecoAlterado);
        _result.setFlPrecoAlterado(_tmpFlPrecoAlterado);
        final String _tmpNomeTipoPagamento;
        _tmpNomeTipoPagamento = _cursor.getString(_cursorIndexOfNomeTipoPagamento);
        _result.setNomeTipoPagamento(_tmpNomeTipoPagamento);
        final String _tmpCdMotivo;
        _tmpCdMotivo = _cursor.getString(_cursorIndexOfCdMotivo);
        _result.setCdMotivo(_tmpCdMotivo);
        final String _tmpDsMotivo;
        _tmpDsMotivo = _cursor.getString(_cursorIndexOfDsMotivo);
        _result.setDsMotivo(_tmpDsMotivo);
        final String _tmpStatusNfeImp;
        _tmpStatusNfeImp = _cursor.getString(_cursorIndexOfStatusNfeImp);
        _result.setStatusNfeImp(_tmpStatusNfeImp);
        final String _tmpStatusReportFile;
        _tmpStatusReportFile = _cursor.getString(_cursorIndexOfStatusReportFile);
        _result.setStatusReportFile(_tmpStatusReportFile);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Invoice findNextInvoice(Long numero, String tipoNota) {
    final String _sql = "SELECT * FROM Invoice WHERE numero > ? AND tiponota = ? ORDER BY Invoice.dataMovimento ASC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (numero == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, numero);
    }
    _argIndex = 2;
    if (tipoNota == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, tipoNota);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfNumero = _cursor.getColumnIndexOrThrow("numero");
      final int _cursorIndexOfSerie = _cursor.getColumnIndexOrThrow("serie");
      final int _cursorIndexOfNumeroNotaVOR = _cursor.getColumnIndexOrThrow("numeroNotaVOR");
      final int _cursorIndexOfSerieNotaVOR = _cursor.getColumnIndexOrThrow("serieNotaVOR");
      final int _cursorIndexOfCdPreOrdem = _cursor.getColumnIndexOrThrow("cdPreOrdem");
      final int _cursorIndexOfNumeroFutEntrega = _cursor.getColumnIndexOrThrow("numeroFutEntrega");
      final int _cursorIndexOfCdFiscal = _cursor.getColumnIndexOrThrow("cdFiscal");
      final int _cursorIndexOfCnpjCpfDestino = _cursor.getColumnIndexOrThrow("cnpjCpfDestino");
      final int _cursorIndexOfCnpjCpfTransp = _cursor.getColumnIndexOrThrow("cnpjCpfTransp");
      final int _cursorIndexOfTipoNota = _cursor.getColumnIndexOrThrow("tipoNota");
      final int _cursorIndexOfClasseContribuinte = _cursor.getColumnIndexOrThrow("classeContribuinte");
      final int _cursorIndexOfDataViagemPrincial = _cursor.getColumnIndexOrThrow("dataViagemPrincial");
      final int _cursorIndexOfNumeroViagem = _cursor.getColumnIndexOrThrow("numeroViagem");
      final int _cursorIndexOfDataViagem = _cursor.getColumnIndexOrThrow("dataViagem");
      final int _cursorIndexOfNomeOperacao = _cursor.getColumnIndexOrThrow("nomeOperacao");
      final int _cursorIndexOfDataEmissao = _cursor.getColumnIndexOrThrow("dataEmissao");
      final int _cursorIndexOfDataMovimento = _cursor.getColumnIndexOrThrow("dataMovimento");
      final int _cursorIndexOfDataVencimento = _cursor.getColumnIndexOrThrow("dataVencimento");
      final int _cursorIndexOfValorTotal = _cursor.getColumnIndexOrThrow("valorTotal");
      final int _cursorIndexOfValorLiquido = _cursor.getColumnIndexOrThrow("valorLiquido");
      final int _cursorIndexOfValorTotalProduto = _cursor.getColumnIndexOrThrow("valorTotalProduto");
      final int _cursorIndexOfValorFrete = _cursor.getColumnIndexOrThrow("valorFrete");
      final int _cursorIndexOfValorDespAcessorias = _cursor.getColumnIndexOrThrow("valorDespAcessorias");
      final int _cursorIndexOfValorDinheiro = _cursor.getColumnIndexOrThrow("valorDinheiro");
      final int _cursorIndexOfValorTroco = _cursor.getColumnIndexOrThrow("valorTroco");
      final int _cursorIndexOfValorFatura = _cursor.getColumnIndexOrThrow("valorFatura");
      final int _cursorIndexOfValorDebito = _cursor.getColumnIndexOrThrow("valorDebito");
      final int _cursorIndexOfValorCredito = _cursor.getColumnIndexOrThrow("valorCredito");
      final int _cursorIndexOfValorCheque = _cursor.getColumnIndexOrThrow("valorCheque");
      final int _cursorIndexOfNumeroCheque = _cursor.getColumnIndexOrThrow("numeroCheque");
      final int _cursorIndexOfUfVeiculo = _cursor.getColumnIndexOrThrow("ufVeiculo");
      final int _cursorIndexOfPlacaVeiculo = _cursor.getColumnIndexOrThrow("placaVeiculo");
      final int _cursorIndexOfNumeroVeiculo = _cursor.getColumnIndexOrThrow("numeroVeiculo");
      final int _cursorIndexOfModalidadeFrete = _cursor.getColumnIndexOrThrow("modalidadeFrete");
      final int _cursorIndexOfNomeEspecVolume = _cursor.getColumnIndexOrThrow("nomeEspecVolume");
      final int _cursorIndexOfNomeMarca = _cursor.getColumnIndexOrThrow("nomeMarca");
      final int _cursorIndexOfQtdVolumes = _cursor.getColumnIndexOrThrow("qtdVolumes");
      final int _cursorIndexOfVolumeCapacidade = _cursor.getColumnIndexOrThrow("volumeCapacidade");
      final int _cursorIndexOfVolumeCapacidadeReport = _cursor.getColumnIndexOrThrow("volumeCapacidadeReport");
      final int _cursorIndexOfPesoBruto = _cursor.getColumnIndexOrThrow("pesoBruto");
      final int _cursorIndexOfPesoLiquido = _cursor.getColumnIndexOrThrow("pesoLiquido");
      final int _cursorIndexOfTipoPedido = _cursor.getColumnIndexOrThrow("tipoPedido");
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfAtivaTipoPagto = _cursor.getColumnIndexOrThrow("ativaTipoPagto");
      final int _cursorIndexOfStepEmissao = _cursor.getColumnIndexOrThrow("stepEmissao");
      final int _cursorIndexOfChave = _cursor.getColumnIndexOrThrow("chave");
      final int _cursorIndexOfProtocolo = _cursor.getColumnIndexOrThrow("protocolo");
      final int _cursorIndexOfCdMovimento = _cursor.getColumnIndexOrThrow("cdMovimento");
      final int _cursorIndexOfCondicaoPagamento = _cursor.getColumnIndexOrThrow("condicaoPagamento");
      final int _cursorIndexOfAliquotaIcms = _cursor.getColumnIndexOrThrow("aliquotaIcms");
      final int _cursorIndexOfValorDescontoIcms = _cursor.getColumnIndexOrThrow("valorDescontoIcms");
      final int _cursorIndexOfValorIcms = _cursor.getColumnIndexOrThrow("valorIcms");
      final int _cursorIndexOfBaseCalculoIcms = _cursor.getColumnIndexOrThrow("baseCalculoIcms");
      final int _cursorIndexOfSituacaoTributariaIcms = _cursor.getColumnIndexOrThrow("situacaoTributariaIcms");
      final int _cursorIndexOfValorIpi = _cursor.getColumnIndexOrThrow("valorIpi");
      final int _cursorIndexOfBaseCalculoIpi = _cursor.getColumnIndexOrThrow("baseCalculoIpi");
      final int _cursorIndexOfSituacaoTributariaIpi = _cursor.getColumnIndexOrThrow("situacaoTributariaIpi");
      final int _cursorIndexOfFlNovoFaturamento = _cursor.getColumnIndexOrThrow("flNovoFaturamento");
      final int _cursorIndexOfCdOperadora = _cursor.getColumnIndexOrThrow("cdOperadora");
      final int _cursorIndexOfFlPaciente = _cursor.getColumnIndexOrThrow("flPaciente");
      final int _cursorIndexOfCdCustomerService = _cursor.getColumnIndexOrThrow("cdCustomerService");
      final int _cursorIndexOfNomeAssinadorCec = _cursor.getColumnIndexOrThrow("nomeAssinadorCec");
      final int _cursorIndexOfRgAssinadorCec = _cursor.getColumnIndexOrThrow("rgAssinadorCec");
      final int _cursorIndexOfTipoMovimentoIntegracao = _cursor.getColumnIndexOrThrow("tipoMovimentoIntegracao");
      final int _cursorIndexOfSemPagto = _cursor.getColumnIndexOrThrow("semPagto");
      final int _cursorIndexOfStatusGravacaoJde = _cursor.getColumnIndexOrThrow("statusGravacaoJde");
      final int _cursorIndexOfMensagemGravacaoJde = _cursor.getColumnIndexOrThrow("mensagemGravacaoJde");
      final int _cursorIndexOfTipoTransacao = _cursor.getColumnIndexOrThrow("tipoTransacao");
      final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("status");
      final int _cursorIndexOfStatusContingencia = _cursor.getColumnIndexOrThrow("statusContingencia");
      final int _cursorIndexOfMensagemContingencia = _cursor.getColumnIndexOrThrow("mensagemContingencia");
      final int _cursorIndexOfStatusCec = _cursor.getColumnIndexOrThrow("statusCec");
      final int _cursorIndexOfNomeTransacao = _cursor.getColumnIndexOrThrow("nomeTransacao");
      final int _cursorIndexOfStatusImpressaoCec = _cursor.getColumnIndexOrThrow("statusImpressaoCec");
      final int _cursorIndexOfNomeFormaImpressaoCec = _cursor.getColumnIndexOrThrow("nomeFormaImpressaoCec");
      final int _cursorIndexOfNomeStatus = _cursor.getColumnIndexOrThrow("nomeStatus");
      final int _cursorIndexOfNomeStatusImpressaoCec = _cursor.getColumnIndexOrThrow("nomeStatusImpressaoCec");
      final int _cursorIndexOfFlPrecoAlterado = _cursor.getColumnIndexOrThrow("flPrecoAlterado");
      final int _cursorIndexOfNomeTipoPagamento = _cursor.getColumnIndexOrThrow("nomeTipoPagamento");
      final int _cursorIndexOfCdMotivo = _cursor.getColumnIndexOrThrow("cdMotivo");
      final int _cursorIndexOfDsMotivo = _cursor.getColumnIndexOrThrow("dsMotivo");
      final int _cursorIndexOfStatusNfeImp = _cursor.getColumnIndexOrThrow("statusNfeImp");
      final int _cursorIndexOfStatusReportFile = _cursor.getColumnIndexOrThrow("statusReportFile");
      final Invoice _result;
      if(_cursor.moveToFirst()) {
        _result = new Invoice();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _result.setId(_tmpId);
        final Long _tmpNumero;
        if (_cursor.isNull(_cursorIndexOfNumero)) {
          _tmpNumero = null;
        } else {
          _tmpNumero = _cursor.getLong(_cursorIndexOfNumero);
        }
        _result.setNumero(_tmpNumero);
        final Long _tmpSerie;
        if (_cursor.isNull(_cursorIndexOfSerie)) {
          _tmpSerie = null;
        } else {
          _tmpSerie = _cursor.getLong(_cursorIndexOfSerie);
        }
        _result.setSerie(_tmpSerie);
        final Long _tmpNumeroNotaVOR;
        if (_cursor.isNull(_cursorIndexOfNumeroNotaVOR)) {
          _tmpNumeroNotaVOR = null;
        } else {
          _tmpNumeroNotaVOR = _cursor.getLong(_cursorIndexOfNumeroNotaVOR);
        }
        _result.setNumeroNotaVOR(_tmpNumeroNotaVOR);
        final Long _tmpSerieNotaVOR;
        if (_cursor.isNull(_cursorIndexOfSerieNotaVOR)) {
          _tmpSerieNotaVOR = null;
        } else {
          _tmpSerieNotaVOR = _cursor.getLong(_cursorIndexOfSerieNotaVOR);
        }
        _result.setSerieNotaVOR(_tmpSerieNotaVOR);
        final String _tmpCdPreOrdem;
        _tmpCdPreOrdem = _cursor.getString(_cursorIndexOfCdPreOrdem);
        _result.setCdPreOrdem(_tmpCdPreOrdem);
        final String _tmpNumeroFutEntrega;
        _tmpNumeroFutEntrega = _cursor.getString(_cursorIndexOfNumeroFutEntrega);
        _result.setNumeroFutEntrega(_tmpNumeroFutEntrega);
        final Integer _tmpCdFiscal;
        if (_cursor.isNull(_cursorIndexOfCdFiscal)) {
          _tmpCdFiscal = null;
        } else {
          _tmpCdFiscal = _cursor.getInt(_cursorIndexOfCdFiscal);
        }
        _result.setCdFiscal(_tmpCdFiscal);
        final String _tmpCnpjCpfDestino;
        _tmpCnpjCpfDestino = _cursor.getString(_cursorIndexOfCnpjCpfDestino);
        _result.setCnpjCpfDestino(_tmpCnpjCpfDestino);
        final String _tmpCnpjCpfTransp;
        _tmpCnpjCpfTransp = _cursor.getString(_cursorIndexOfCnpjCpfTransp);
        _result.setCnpjCpfTransp(_tmpCnpjCpfTransp);
        final String _tmpTipoNota;
        _tmpTipoNota = _cursor.getString(_cursorIndexOfTipoNota);
        _result.setTipoNota(_tmpTipoNota);
        final Integer _tmpClasseContribuinte;
        if (_cursor.isNull(_cursorIndexOfClasseContribuinte)) {
          _tmpClasseContribuinte = null;
        } else {
          _tmpClasseContribuinte = _cursor.getInt(_cursorIndexOfClasseContribuinte);
        }
        _result.setClasseContribuinte(_tmpClasseContribuinte);
        final String _tmpDataViagemPrincial;
        _tmpDataViagemPrincial = _cursor.getString(_cursorIndexOfDataViagemPrincial);
        _result.setDataViagemPrincial(_tmpDataViagemPrincial);
        final String _tmpNumeroViagem;
        _tmpNumeroViagem = _cursor.getString(_cursorIndexOfNumeroViagem);
        _result.setNumeroViagem(_tmpNumeroViagem);
        final String _tmpDataViagem;
        _tmpDataViagem = _cursor.getString(_cursorIndexOfDataViagem);
        _result.setDataViagem(_tmpDataViagem);
        final String _tmpNomeOperacao;
        _tmpNomeOperacao = _cursor.getString(_cursorIndexOfNomeOperacao);
        _result.setNomeOperacao(_tmpNomeOperacao);
        final Date _tmpDataEmissao;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfDataEmissao)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfDataEmissao);
        }
        _tmpDataEmissao = DateTypeConverter.fromTimestamp(_tmp);
        _result.setDataEmissao(_tmpDataEmissao);
        final Date _tmpDataMovimento;
        final Long _tmp_1;
        if (_cursor.isNull(_cursorIndexOfDataMovimento)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getLong(_cursorIndexOfDataMovimento);
        }
        _tmpDataMovimento = DateTypeConverter.fromTimestamp(_tmp_1);
        _result.setDataMovimento(_tmpDataMovimento);
        final Date _tmpDataVencimento;
        final Long _tmp_2;
        if (_cursor.isNull(_cursorIndexOfDataVencimento)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getLong(_cursorIndexOfDataVencimento);
        }
        _tmpDataVencimento = DateTypeConverter.fromTimestamp(_tmp_2);
        _result.setDataVencimento(_tmpDataVencimento);
        final Double _tmpValorTotal;
        if (_cursor.isNull(_cursorIndexOfValorTotal)) {
          _tmpValorTotal = null;
        } else {
          _tmpValorTotal = _cursor.getDouble(_cursorIndexOfValorTotal);
        }
        _result.setValorTotal(_tmpValorTotal);
        final Double _tmpValorLiquido;
        if (_cursor.isNull(_cursorIndexOfValorLiquido)) {
          _tmpValorLiquido = null;
        } else {
          _tmpValorLiquido = _cursor.getDouble(_cursorIndexOfValorLiquido);
        }
        _result.setValorLiquido(_tmpValorLiquido);
        final Double _tmpValorTotalProduto;
        if (_cursor.isNull(_cursorIndexOfValorTotalProduto)) {
          _tmpValorTotalProduto = null;
        } else {
          _tmpValorTotalProduto = _cursor.getDouble(_cursorIndexOfValorTotalProduto);
        }
        _result.setValorTotalProduto(_tmpValorTotalProduto);
        final Double _tmpValorFrete;
        if (_cursor.isNull(_cursorIndexOfValorFrete)) {
          _tmpValorFrete = null;
        } else {
          _tmpValorFrete = _cursor.getDouble(_cursorIndexOfValorFrete);
        }
        _result.setValorFrete(_tmpValorFrete);
        final Double _tmpValorDespAcessorias;
        if (_cursor.isNull(_cursorIndexOfValorDespAcessorias)) {
          _tmpValorDespAcessorias = null;
        } else {
          _tmpValorDespAcessorias = _cursor.getDouble(_cursorIndexOfValorDespAcessorias);
        }
        _result.setValorDespAcessorias(_tmpValorDespAcessorias);
        final Double _tmpValorDinheiro;
        if (_cursor.isNull(_cursorIndexOfValorDinheiro)) {
          _tmpValorDinheiro = null;
        } else {
          _tmpValorDinheiro = _cursor.getDouble(_cursorIndexOfValorDinheiro);
        }
        _result.setValorDinheiro(_tmpValorDinheiro);
        final Double _tmpValorTroco;
        if (_cursor.isNull(_cursorIndexOfValorTroco)) {
          _tmpValorTroco = null;
        } else {
          _tmpValorTroco = _cursor.getDouble(_cursorIndexOfValorTroco);
        }
        _result.setValorTroco(_tmpValorTroco);
        final Double _tmpValorFatura;
        if (_cursor.isNull(_cursorIndexOfValorFatura)) {
          _tmpValorFatura = null;
        } else {
          _tmpValorFatura = _cursor.getDouble(_cursorIndexOfValorFatura);
        }
        _result.setValorFatura(_tmpValorFatura);
        final Double _tmpValorDebito;
        if (_cursor.isNull(_cursorIndexOfValorDebito)) {
          _tmpValorDebito = null;
        } else {
          _tmpValorDebito = _cursor.getDouble(_cursorIndexOfValorDebito);
        }
        _result.setValorDebito(_tmpValorDebito);
        final Double _tmpValorCredito;
        if (_cursor.isNull(_cursorIndexOfValorCredito)) {
          _tmpValorCredito = null;
        } else {
          _tmpValorCredito = _cursor.getDouble(_cursorIndexOfValorCredito);
        }
        _result.setValorCredito(_tmpValorCredito);
        final Double _tmpValorCheque;
        if (_cursor.isNull(_cursorIndexOfValorCheque)) {
          _tmpValorCheque = null;
        } else {
          _tmpValorCheque = _cursor.getDouble(_cursorIndexOfValorCheque);
        }
        _result.setValorCheque(_tmpValorCheque);
        final String _tmpNumeroCheque;
        _tmpNumeroCheque = _cursor.getString(_cursorIndexOfNumeroCheque);
        _result.setNumeroCheque(_tmpNumeroCheque);
        final String _tmpUfVeiculo;
        _tmpUfVeiculo = _cursor.getString(_cursorIndexOfUfVeiculo);
        _result.setUfVeiculo(_tmpUfVeiculo);
        final String _tmpPlacaVeiculo;
        _tmpPlacaVeiculo = _cursor.getString(_cursorIndexOfPlacaVeiculo);
        _result.setPlacaVeiculo(_tmpPlacaVeiculo);
        final String _tmpNumeroVeiculo;
        _tmpNumeroVeiculo = _cursor.getString(_cursorIndexOfNumeroVeiculo);
        _result.setNumeroVeiculo(_tmpNumeroVeiculo);
        final Integer _tmpModalidadeFrete;
        if (_cursor.isNull(_cursorIndexOfModalidadeFrete)) {
          _tmpModalidadeFrete = null;
        } else {
          _tmpModalidadeFrete = _cursor.getInt(_cursorIndexOfModalidadeFrete);
        }
        _result.setModalidadeFrete(_tmpModalidadeFrete);
        final String _tmpNomeEspecVolume;
        _tmpNomeEspecVolume = _cursor.getString(_cursorIndexOfNomeEspecVolume);
        _result.setNomeEspecVolume(_tmpNomeEspecVolume);
        final String _tmpNomeMarca;
        _tmpNomeMarca = _cursor.getString(_cursorIndexOfNomeMarca);
        _result.setNomeMarca(_tmpNomeMarca);
        final Integer _tmpQtdVolumes;
        if (_cursor.isNull(_cursorIndexOfQtdVolumes)) {
          _tmpQtdVolumes = null;
        } else {
          _tmpQtdVolumes = _cursor.getInt(_cursorIndexOfQtdVolumes);
        }
        _result.setQtdVolumes(_tmpQtdVolumes);
        final Double _tmpVolumeCapacidade;
        if (_cursor.isNull(_cursorIndexOfVolumeCapacidade)) {
          _tmpVolumeCapacidade = null;
        } else {
          _tmpVolumeCapacidade = _cursor.getDouble(_cursorIndexOfVolumeCapacidade);
        }
        _result.setVolumeCapacidade(_tmpVolumeCapacidade);
        final Double _tmpVolumeCapacidadeReport;
        if (_cursor.isNull(_cursorIndexOfVolumeCapacidadeReport)) {
          _tmpVolumeCapacidadeReport = null;
        } else {
          _tmpVolumeCapacidadeReport = _cursor.getDouble(_cursorIndexOfVolumeCapacidadeReport);
        }
        _result.setVolumeCapacidadeReport(_tmpVolumeCapacidadeReport);
        final Double _tmpPesoBruto;
        if (_cursor.isNull(_cursorIndexOfPesoBruto)) {
          _tmpPesoBruto = null;
        } else {
          _tmpPesoBruto = _cursor.getDouble(_cursorIndexOfPesoBruto);
        }
        _result.setPesoBruto(_tmpPesoBruto);
        final Double _tmpPesoLiquido;
        if (_cursor.isNull(_cursorIndexOfPesoLiquido)) {
          _tmpPesoLiquido = null;
        } else {
          _tmpPesoLiquido = _cursor.getDouble(_cursorIndexOfPesoLiquido);
        }
        _result.setPesoLiquido(_tmpPesoLiquido);
        final String _tmpTipoPedido;
        _tmpTipoPedido = _cursor.getString(_cursorIndexOfTipoPedido);
        _result.setTipoPedido(_tmpTipoPedido);
        final Long _tmpCdCustomer;
        if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
          _tmpCdCustomer = null;
        } else {
          _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
        }
        _result.setCdCustomer(_tmpCdCustomer);
        final String _tmpAtivaTipoPagto;
        _tmpAtivaTipoPagto = _cursor.getString(_cursorIndexOfAtivaTipoPagto);
        _result.setAtivaTipoPagto(_tmpAtivaTipoPagto);
        final Integer _tmpStepEmissao;
        if (_cursor.isNull(_cursorIndexOfStepEmissao)) {
          _tmpStepEmissao = null;
        } else {
          _tmpStepEmissao = _cursor.getInt(_cursorIndexOfStepEmissao);
        }
        _result.setStepEmissao(_tmpStepEmissao);
        final String _tmpChave;
        _tmpChave = _cursor.getString(_cursorIndexOfChave);
        _result.setChave(_tmpChave);
        final String _tmpProtocolo;
        _tmpProtocolo = _cursor.getString(_cursorIndexOfProtocolo);
        _result.setProtocolo(_tmpProtocolo);
        final String _tmpCdMovimento;
        _tmpCdMovimento = _cursor.getString(_cursorIndexOfCdMovimento);
        _result.setCdMovimento(_tmpCdMovimento);
        final String _tmpCondicaoPagamento;
        _tmpCondicaoPagamento = _cursor.getString(_cursorIndexOfCondicaoPagamento);
        _result.setCondicaoPagamento(_tmpCondicaoPagamento);
        final Double _tmpAliquotaIcms;
        if (_cursor.isNull(_cursorIndexOfAliquotaIcms)) {
          _tmpAliquotaIcms = null;
        } else {
          _tmpAliquotaIcms = _cursor.getDouble(_cursorIndexOfAliquotaIcms);
        }
        _result.setAliquotaIcms(_tmpAliquotaIcms);
        final Double _tmpValorDescontoIcms;
        if (_cursor.isNull(_cursorIndexOfValorDescontoIcms)) {
          _tmpValorDescontoIcms = null;
        } else {
          _tmpValorDescontoIcms = _cursor.getDouble(_cursorIndexOfValorDescontoIcms);
        }
        _result.setValorDescontoIcms(_tmpValorDescontoIcms);
        final Double _tmpValorIcms;
        if (_cursor.isNull(_cursorIndexOfValorIcms)) {
          _tmpValorIcms = null;
        } else {
          _tmpValorIcms = _cursor.getDouble(_cursorIndexOfValorIcms);
        }
        _result.setValorIcms(_tmpValorIcms);
        final Double _tmpBaseCalculoIcms;
        if (_cursor.isNull(_cursorIndexOfBaseCalculoIcms)) {
          _tmpBaseCalculoIcms = null;
        } else {
          _tmpBaseCalculoIcms = _cursor.getDouble(_cursorIndexOfBaseCalculoIcms);
        }
        _result.setBaseCalculoIcms(_tmpBaseCalculoIcms);
        final Integer _tmpSituacaoTributariaIcms;
        if (_cursor.isNull(_cursorIndexOfSituacaoTributariaIcms)) {
          _tmpSituacaoTributariaIcms = null;
        } else {
          _tmpSituacaoTributariaIcms = _cursor.getInt(_cursorIndexOfSituacaoTributariaIcms);
        }
        _result.setSituacaoTributariaIcms(_tmpSituacaoTributariaIcms);
        final Double _tmpValorIpi;
        if (_cursor.isNull(_cursorIndexOfValorIpi)) {
          _tmpValorIpi = null;
        } else {
          _tmpValorIpi = _cursor.getDouble(_cursorIndexOfValorIpi);
        }
        _result.setValorIpi(_tmpValorIpi);
        final Double _tmpBaseCalculoIpi;
        if (_cursor.isNull(_cursorIndexOfBaseCalculoIpi)) {
          _tmpBaseCalculoIpi = null;
        } else {
          _tmpBaseCalculoIpi = _cursor.getDouble(_cursorIndexOfBaseCalculoIpi);
        }
        _result.setBaseCalculoIpi(_tmpBaseCalculoIpi);
        final Integer _tmpSituacaoTributariaIpi;
        if (_cursor.isNull(_cursorIndexOfSituacaoTributariaIpi)) {
          _tmpSituacaoTributariaIpi = null;
        } else {
          _tmpSituacaoTributariaIpi = _cursor.getInt(_cursorIndexOfSituacaoTributariaIpi);
        }
        _result.setSituacaoTributariaIpi(_tmpSituacaoTributariaIpi);
        final String _tmpFlNovoFaturamento;
        _tmpFlNovoFaturamento = _cursor.getString(_cursorIndexOfFlNovoFaturamento);
        _result.setFlNovoFaturamento(_tmpFlNovoFaturamento);
        final Long _tmpCdOperadora;
        if (_cursor.isNull(_cursorIndexOfCdOperadora)) {
          _tmpCdOperadora = null;
        } else {
          _tmpCdOperadora = _cursor.getLong(_cursorIndexOfCdOperadora);
        }
        _result.setCdOperadora(_tmpCdOperadora);
        final String _tmpFlPaciente;
        _tmpFlPaciente = _cursor.getString(_cursorIndexOfFlPaciente);
        _result.setFlPaciente(_tmpFlPaciente);
        final Long _tmpCdCustomerService;
        if (_cursor.isNull(_cursorIndexOfCdCustomerService)) {
          _tmpCdCustomerService = null;
        } else {
          _tmpCdCustomerService = _cursor.getLong(_cursorIndexOfCdCustomerService);
        }
        _result.setCdCustomerService(_tmpCdCustomerService);
        final String _tmpNomeAssinadorCec;
        _tmpNomeAssinadorCec = _cursor.getString(_cursorIndexOfNomeAssinadorCec);
        _result.setNomeAssinadorCec(_tmpNomeAssinadorCec);
        final String _tmpRgAssinadorCec;
        _tmpRgAssinadorCec = _cursor.getString(_cursorIndexOfRgAssinadorCec);
        _result.setRgAssinadorCec(_tmpRgAssinadorCec);
        final Integer _tmpTipoMovimentoIntegracao;
        if (_cursor.isNull(_cursorIndexOfTipoMovimentoIntegracao)) {
          _tmpTipoMovimentoIntegracao = null;
        } else {
          _tmpTipoMovimentoIntegracao = _cursor.getInt(_cursorIndexOfTipoMovimentoIntegracao);
        }
        _result.setTipoMovimentoIntegracao(_tmpTipoMovimentoIntegracao);
        final String _tmpSemPagto;
        _tmpSemPagto = _cursor.getString(_cursorIndexOfSemPagto);
        _result.setSemPagto(_tmpSemPagto);
        final Integer _tmpStatusGravacaoJde;
        if (_cursor.isNull(_cursorIndexOfStatusGravacaoJde)) {
          _tmpStatusGravacaoJde = null;
        } else {
          _tmpStatusGravacaoJde = _cursor.getInt(_cursorIndexOfStatusGravacaoJde);
        }
        _result.setStatusGravacaoJde(_tmpStatusGravacaoJde);
        final String _tmpMensagemGravacaoJde;
        _tmpMensagemGravacaoJde = _cursor.getString(_cursorIndexOfMensagemGravacaoJde);
        _result.setMensagemGravacaoJde(_tmpMensagemGravacaoJde);
        final Integer _tmpTipoTransacao;
        if (_cursor.isNull(_cursorIndexOfTipoTransacao)) {
          _tmpTipoTransacao = null;
        } else {
          _tmpTipoTransacao = _cursor.getInt(_cursorIndexOfTipoTransacao);
        }
        _result.setTipoTransacao(_tmpTipoTransacao);
        final Integer _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
        }
        _result.setStatus(_tmpStatus);
        final String _tmpStatusContingencia;
        _tmpStatusContingencia = _cursor.getString(_cursorIndexOfStatusContingencia);
        _result.setStatusContingencia(_tmpStatusContingencia);
        final String _tmpMensagemContingencia;
        _tmpMensagemContingencia = _cursor.getString(_cursorIndexOfMensagemContingencia);
        _result.setMensagemContingencia(_tmpMensagemContingencia);
        final Integer _tmpStatusCec;
        if (_cursor.isNull(_cursorIndexOfStatusCec)) {
          _tmpStatusCec = null;
        } else {
          _tmpStatusCec = _cursor.getInt(_cursorIndexOfStatusCec);
        }
        _result.setStatusCec(_tmpStatusCec);
        final String _tmpNomeTransacao;
        _tmpNomeTransacao = _cursor.getString(_cursorIndexOfNomeTransacao);
        _result.setNomeTransacao(_tmpNomeTransacao);
        final Integer _tmpStatusImpressaoCec;
        if (_cursor.isNull(_cursorIndexOfStatusImpressaoCec)) {
          _tmpStatusImpressaoCec = null;
        } else {
          _tmpStatusImpressaoCec = _cursor.getInt(_cursorIndexOfStatusImpressaoCec);
        }
        _result.setStatusImpressaoCec(_tmpStatusImpressaoCec);
        final String _tmpNomeFormaImpressaoCec;
        _tmpNomeFormaImpressaoCec = _cursor.getString(_cursorIndexOfNomeFormaImpressaoCec);
        _result.setNomeFormaImpressaoCec(_tmpNomeFormaImpressaoCec);
        final String _tmpNomeStatus;
        _tmpNomeStatus = _cursor.getString(_cursorIndexOfNomeStatus);
        _result.setNomeStatus(_tmpNomeStatus);
        final String _tmpNomeStatusImpressaoCec;
        _tmpNomeStatusImpressaoCec = _cursor.getString(_cursorIndexOfNomeStatusImpressaoCec);
        _result.setNomeStatusImpressaoCec(_tmpNomeStatusImpressaoCec);
        final String _tmpFlPrecoAlterado;
        _tmpFlPrecoAlterado = _cursor.getString(_cursorIndexOfFlPrecoAlterado);
        _result.setFlPrecoAlterado(_tmpFlPrecoAlterado);
        final String _tmpNomeTipoPagamento;
        _tmpNomeTipoPagamento = _cursor.getString(_cursorIndexOfNomeTipoPagamento);
        _result.setNomeTipoPagamento(_tmpNomeTipoPagamento);
        final String _tmpCdMotivo;
        _tmpCdMotivo = _cursor.getString(_cursorIndexOfCdMotivo);
        _result.setCdMotivo(_tmpCdMotivo);
        final String _tmpDsMotivo;
        _tmpDsMotivo = _cursor.getString(_cursorIndexOfDsMotivo);
        _result.setDsMotivo(_tmpDsMotivo);
        final String _tmpStatusNfeImp;
        _tmpStatusNfeImp = _cursor.getString(_cursorIndexOfStatusNfeImp);
        _result.setStatusNfeImp(_tmpStatusNfeImp);
        final String _tmpStatusReportFile;
        _tmpStatusReportFile = _cursor.getString(_cursorIndexOfStatusReportFile);
        _result.setStatusReportFile(_tmpStatusReportFile);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
