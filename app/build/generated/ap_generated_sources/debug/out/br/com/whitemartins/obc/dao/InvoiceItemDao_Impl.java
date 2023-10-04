package br.com.whitemartins.obc.dao;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.util.StringUtil;
import android.database.Cursor;
import br.com.whitemartins.obc.model.InvoiceItem;
import java.lang.Double;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class InvoiceItemDao_Impl implements InvoiceItemDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfInvoiceItem;

  private final EntityInsertionAdapter __insertionAdapterOfInvoiceItem_1;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfInvoiceItem;

  public InvoiceItemDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfInvoiceItem = new EntityInsertionAdapter<InvoiceItem>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `InvoiceItem`(`idNota`,`numeroNota`,`serieNota`,`cfop`,`seqItem`,`cdItem`,`capacidade`,`nomeItem`,`qtdItem`,`volume`,`unidadeMedida`,`naturezaOperacao`,`nomeNaturezaOperacao`,`classifFiscal`,`cstAIcms`,`cstBIcms`,`cstIpi`,`cstPis`,`cstCofins`,`valorTotal`,`valorBaseIcms`,`valorBaseReduzidaIcms`,`valorIcms`,`valorDebitoIcms`,`valorCreditoIcms`,`valorBaseIcmsSt`,`valorIcmsSt`,`valorBaseIpi`,`valorIpi`,`valorDebitoIpi`,`valorCreditoIpi`,`valorBasePis`,`valorDebitoPis`,`valorBaseCreditoPis`,`valorCreditoPis`,`valorBaseCofins`,`valorDebitoCofins`,`valorBaseCreditoCofins`,`valorCreditoCofins`,`aliquotaIcms`,`aliquotaIpi`,`aliquotaPis`,`aliquotaCofins`,`tipoIcms`,`tipoIpi`,`tipoPis`,`tipoCofins`,`valorTotalFrete`,`valorTotalSeguro`,`valorDescontoIcms`,`valorUnitario`,`valorDespesasAcessorias`,`flPrecoAlterado`,`valorPrecoUnitarioOriginal`,`infCilPP`,`condicaoPagamento`,`cdMovimento`,`returnType`,`returnCode`,`quantidadeCilindroVendida`,`quantidadeCilindroPedida`,`pedidoCustomer`,`itemPedidoCustomer`,`tipoFaturamento`,`flAssistenciaTecnica`,`tipoItem`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, InvoiceItem value) {
        if (value.getIdNota() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getIdNota());
        }
        if (value.getNumeroNota() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getNumeroNota());
        }
        if (value.getSerieNota() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getSerieNota());
        }
        if (value.getCfop() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getCfop());
        }
        if (value.getSeqItem() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getSeqItem());
        }
        if (value.getCdItem() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getCdItem());
        }
        if (value.getCapacidade() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindDouble(7, value.getCapacidade());
        }
        if (value.getNomeItem() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getNomeItem());
        }
        if (value.getQtdItem() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindDouble(9, value.getQtdItem());
        }
        if (value.getVolume() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindDouble(10, value.getVolume());
        }
        if (value.getUnidadeMedida() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getUnidadeMedida());
        }
        if (value.getNaturezaOperacao() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getNaturezaOperacao());
        }
        if (value.getNomeNaturezaOperacao() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getNomeNaturezaOperacao());
        }
        if (value.getClassifFiscal() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindLong(14, value.getClassifFiscal());
        }
        if (value.getCstAIcms() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getCstAIcms());
        }
        if (value.getCstBIcms() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getCstBIcms());
        }
        if (value.getCstIpi() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getCstIpi());
        }
        if (value.getCstPis() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getCstPis());
        }
        if (value.getCstCofins() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getCstCofins());
        }
        if (value.getValorTotal() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindDouble(20, value.getValorTotal());
        }
        if (value.getValorBaseIcms() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindDouble(21, value.getValorBaseIcms());
        }
        if (value.getValorBaseReduzidaIcms() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindDouble(22, value.getValorBaseReduzidaIcms());
        }
        if (value.getValorIcms() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindDouble(23, value.getValorIcms());
        }
        if (value.getValorDebitoIcms() == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindDouble(24, value.getValorDebitoIcms());
        }
        if (value.getValorCreditoIcms() == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindDouble(25, value.getValorCreditoIcms());
        }
        if (value.getValorBaseIcmsSt() == null) {
          stmt.bindNull(26);
        } else {
          stmt.bindDouble(26, value.getValorBaseIcmsSt());
        }
        if (value.getValorIcmsSt() == null) {
          stmt.bindNull(27);
        } else {
          stmt.bindDouble(27, value.getValorIcmsSt());
        }
        if (value.getValorBaseIpi() == null) {
          stmt.bindNull(28);
        } else {
          stmt.bindDouble(28, value.getValorBaseIpi());
        }
        if (value.getValorIpi() == null) {
          stmt.bindNull(29);
        } else {
          stmt.bindDouble(29, value.getValorIpi());
        }
        if (value.getValorDebitoIpi() == null) {
          stmt.bindNull(30);
        } else {
          stmt.bindDouble(30, value.getValorDebitoIpi());
        }
        if (value.getValorCreditoIpi() == null) {
          stmt.bindNull(31);
        } else {
          stmt.bindDouble(31, value.getValorCreditoIpi());
        }
        if (value.getValorBasePis() == null) {
          stmt.bindNull(32);
        } else {
          stmt.bindDouble(32, value.getValorBasePis());
        }
        if (value.getValorDebitoPis() == null) {
          stmt.bindNull(33);
        } else {
          stmt.bindDouble(33, value.getValorDebitoPis());
        }
        if (value.getValorBaseCreditoPis() == null) {
          stmt.bindNull(34);
        } else {
          stmt.bindDouble(34, value.getValorBaseCreditoPis());
        }
        if (value.getValorCreditoPis() == null) {
          stmt.bindNull(35);
        } else {
          stmt.bindDouble(35, value.getValorCreditoPis());
        }
        if (value.getValorBaseCofins() == null) {
          stmt.bindNull(36);
        } else {
          stmt.bindDouble(36, value.getValorBaseCofins());
        }
        if (value.getValorDebitoCofins() == null) {
          stmt.bindNull(37);
        } else {
          stmt.bindDouble(37, value.getValorDebitoCofins());
        }
        if (value.getValorBaseCreditoCofins() == null) {
          stmt.bindNull(38);
        } else {
          stmt.bindDouble(38, value.getValorBaseCreditoCofins());
        }
        if (value.getValorCreditoCofins() == null) {
          stmt.bindNull(39);
        } else {
          stmt.bindDouble(39, value.getValorCreditoCofins());
        }
        if (value.getAliquotaIcms() == null) {
          stmt.bindNull(40);
        } else {
          stmt.bindDouble(40, value.getAliquotaIcms());
        }
        if (value.getAliquotaIpi() == null) {
          stmt.bindNull(41);
        } else {
          stmt.bindDouble(41, value.getAliquotaIpi());
        }
        if (value.getAliquotaPis() == null) {
          stmt.bindNull(42);
        } else {
          stmt.bindDouble(42, value.getAliquotaPis());
        }
        if (value.getAliquotaCofins() == null) {
          stmt.bindNull(43);
        } else {
          stmt.bindDouble(43, value.getAliquotaCofins());
        }
        if (value.getTipoIcms() == null) {
          stmt.bindNull(44);
        } else {
          stmt.bindLong(44, value.getTipoIcms());
        }
        if (value.getTipoIpi() == null) {
          stmt.bindNull(45);
        } else {
          stmt.bindLong(45, value.getTipoIpi());
        }
        if (value.getTipoPis() == null) {
          stmt.bindNull(46);
        } else {
          stmt.bindLong(46, value.getTipoPis());
        }
        if (value.getTipoCofins() == null) {
          stmt.bindNull(47);
        } else {
          stmt.bindLong(47, value.getTipoCofins());
        }
        if (value.getValorTotalFrete() == null) {
          stmt.bindNull(48);
        } else {
          stmt.bindDouble(48, value.getValorTotalFrete());
        }
        if (value.getValorTotalSeguro() == null) {
          stmt.bindNull(49);
        } else {
          stmt.bindDouble(49, value.getValorTotalSeguro());
        }
        if (value.getValorDescontoIcms() == null) {
          stmt.bindNull(50);
        } else {
          stmt.bindDouble(50, value.getValorDescontoIcms());
        }
        if (value.getValorUnitario() == null) {
          stmt.bindNull(51);
        } else {
          stmt.bindDouble(51, value.getValorUnitario());
        }
        if (value.getValorDespesasAcessorias() == null) {
          stmt.bindNull(52);
        } else {
          stmt.bindDouble(52, value.getValorDespesasAcessorias());
        }
        if (value.getFlPrecoAlterado() == null) {
          stmt.bindNull(53);
        } else {
          stmt.bindString(53, value.getFlPrecoAlterado());
        }
        if (value.getValorPrecoUnitarioOriginal() == null) {
          stmt.bindNull(54);
        } else {
          stmt.bindDouble(54, value.getValorPrecoUnitarioOriginal());
        }
        if (value.getInfCilPP() == null) {
          stmt.bindNull(55);
        } else {
          stmt.bindString(55, value.getInfCilPP());
        }
        if (value.getCondicaoPagamento() == null) {
          stmt.bindNull(56);
        } else {
          stmt.bindString(56, value.getCondicaoPagamento());
        }
        if (value.getCdMovimento() == null) {
          stmt.bindNull(57);
        } else {
          stmt.bindString(57, value.getCdMovimento());
        }
        if (value.getReturnType() == null) {
          stmt.bindNull(58);
        } else {
          stmt.bindLong(58, value.getReturnType());
        }
        if (value.getReturnCode() == null) {
          stmt.bindNull(59);
        } else {
          stmt.bindString(59, value.getReturnCode());
        }
        if (value.getQuantidadeCilindroVendida() == null) {
          stmt.bindNull(60);
        } else {
          stmt.bindDouble(60, value.getQuantidadeCilindroVendida());
        }
        if (value.getQuantidadeCilindroPedida() == null) {
          stmt.bindNull(61);
        } else {
          stmt.bindDouble(61, value.getQuantidadeCilindroPedida());
        }
        if (value.getPedidoCustomer() == null) {
          stmt.bindNull(62);
        } else {
          stmt.bindString(62, value.getPedidoCustomer());
        }
        if (value.getItemPedidoCustomer() == null) {
          stmt.bindNull(63);
        } else {
          stmt.bindString(63, value.getItemPedidoCustomer());
        }
        if (value.getTipoFaturamento() == null) {
          stmt.bindNull(64);
        } else {
          stmt.bindString(64, value.getTipoFaturamento());
        }
        if (value.getFlAssistenciaTecnica() == null) {
          stmt.bindNull(65);
        } else {
          stmt.bindString(65, value.getFlAssistenciaTecnica());
        }
        if (value.getTipoItem() == null) {
          stmt.bindNull(66);
        } else {
          stmt.bindLong(66, value.getTipoItem());
        }
      }
    };
    this.__insertionAdapterOfInvoiceItem_1 = new EntityInsertionAdapter<InvoiceItem>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `InvoiceItem`(`idNota`,`numeroNota`,`serieNota`,`cfop`,`seqItem`,`cdItem`,`capacidade`,`nomeItem`,`qtdItem`,`volume`,`unidadeMedida`,`naturezaOperacao`,`nomeNaturezaOperacao`,`classifFiscal`,`cstAIcms`,`cstBIcms`,`cstIpi`,`cstPis`,`cstCofins`,`valorTotal`,`valorBaseIcms`,`valorBaseReduzidaIcms`,`valorIcms`,`valorDebitoIcms`,`valorCreditoIcms`,`valorBaseIcmsSt`,`valorIcmsSt`,`valorBaseIpi`,`valorIpi`,`valorDebitoIpi`,`valorCreditoIpi`,`valorBasePis`,`valorDebitoPis`,`valorBaseCreditoPis`,`valorCreditoPis`,`valorBaseCofins`,`valorDebitoCofins`,`valorBaseCreditoCofins`,`valorCreditoCofins`,`aliquotaIcms`,`aliquotaIpi`,`aliquotaPis`,`aliquotaCofins`,`tipoIcms`,`tipoIpi`,`tipoPis`,`tipoCofins`,`valorTotalFrete`,`valorTotalSeguro`,`valorDescontoIcms`,`valorUnitario`,`valorDespesasAcessorias`,`flPrecoAlterado`,`valorPrecoUnitarioOriginal`,`infCilPP`,`condicaoPagamento`,`cdMovimento`,`returnType`,`returnCode`,`quantidadeCilindroVendida`,`quantidadeCilindroPedida`,`pedidoCustomer`,`itemPedidoCustomer`,`tipoFaturamento`,`flAssistenciaTecnica`,`tipoItem`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, InvoiceItem value) {
        if (value.getIdNota() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getIdNota());
        }
        if (value.getNumeroNota() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getNumeroNota());
        }
        if (value.getSerieNota() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getSerieNota());
        }
        if (value.getCfop() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getCfop());
        }
        if (value.getSeqItem() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getSeqItem());
        }
        if (value.getCdItem() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getCdItem());
        }
        if (value.getCapacidade() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindDouble(7, value.getCapacidade());
        }
        if (value.getNomeItem() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getNomeItem());
        }
        if (value.getQtdItem() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindDouble(9, value.getQtdItem());
        }
        if (value.getVolume() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindDouble(10, value.getVolume());
        }
        if (value.getUnidadeMedida() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getUnidadeMedida());
        }
        if (value.getNaturezaOperacao() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getNaturezaOperacao());
        }
        if (value.getNomeNaturezaOperacao() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getNomeNaturezaOperacao());
        }
        if (value.getClassifFiscal() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindLong(14, value.getClassifFiscal());
        }
        if (value.getCstAIcms() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getCstAIcms());
        }
        if (value.getCstBIcms() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getCstBIcms());
        }
        if (value.getCstIpi() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getCstIpi());
        }
        if (value.getCstPis() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getCstPis());
        }
        if (value.getCstCofins() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getCstCofins());
        }
        if (value.getValorTotal() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindDouble(20, value.getValorTotal());
        }
        if (value.getValorBaseIcms() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindDouble(21, value.getValorBaseIcms());
        }
        if (value.getValorBaseReduzidaIcms() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindDouble(22, value.getValorBaseReduzidaIcms());
        }
        if (value.getValorIcms() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindDouble(23, value.getValorIcms());
        }
        if (value.getValorDebitoIcms() == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindDouble(24, value.getValorDebitoIcms());
        }
        if (value.getValorCreditoIcms() == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindDouble(25, value.getValorCreditoIcms());
        }
        if (value.getValorBaseIcmsSt() == null) {
          stmt.bindNull(26);
        } else {
          stmt.bindDouble(26, value.getValorBaseIcmsSt());
        }
        if (value.getValorIcmsSt() == null) {
          stmt.bindNull(27);
        } else {
          stmt.bindDouble(27, value.getValorIcmsSt());
        }
        if (value.getValorBaseIpi() == null) {
          stmt.bindNull(28);
        } else {
          stmt.bindDouble(28, value.getValorBaseIpi());
        }
        if (value.getValorIpi() == null) {
          stmt.bindNull(29);
        } else {
          stmt.bindDouble(29, value.getValorIpi());
        }
        if (value.getValorDebitoIpi() == null) {
          stmt.bindNull(30);
        } else {
          stmt.bindDouble(30, value.getValorDebitoIpi());
        }
        if (value.getValorCreditoIpi() == null) {
          stmt.bindNull(31);
        } else {
          stmt.bindDouble(31, value.getValorCreditoIpi());
        }
        if (value.getValorBasePis() == null) {
          stmt.bindNull(32);
        } else {
          stmt.bindDouble(32, value.getValorBasePis());
        }
        if (value.getValorDebitoPis() == null) {
          stmt.bindNull(33);
        } else {
          stmt.bindDouble(33, value.getValorDebitoPis());
        }
        if (value.getValorBaseCreditoPis() == null) {
          stmt.bindNull(34);
        } else {
          stmt.bindDouble(34, value.getValorBaseCreditoPis());
        }
        if (value.getValorCreditoPis() == null) {
          stmt.bindNull(35);
        } else {
          stmt.bindDouble(35, value.getValorCreditoPis());
        }
        if (value.getValorBaseCofins() == null) {
          stmt.bindNull(36);
        } else {
          stmt.bindDouble(36, value.getValorBaseCofins());
        }
        if (value.getValorDebitoCofins() == null) {
          stmt.bindNull(37);
        } else {
          stmt.bindDouble(37, value.getValorDebitoCofins());
        }
        if (value.getValorBaseCreditoCofins() == null) {
          stmt.bindNull(38);
        } else {
          stmt.bindDouble(38, value.getValorBaseCreditoCofins());
        }
        if (value.getValorCreditoCofins() == null) {
          stmt.bindNull(39);
        } else {
          stmt.bindDouble(39, value.getValorCreditoCofins());
        }
        if (value.getAliquotaIcms() == null) {
          stmt.bindNull(40);
        } else {
          stmt.bindDouble(40, value.getAliquotaIcms());
        }
        if (value.getAliquotaIpi() == null) {
          stmt.bindNull(41);
        } else {
          stmt.bindDouble(41, value.getAliquotaIpi());
        }
        if (value.getAliquotaPis() == null) {
          stmt.bindNull(42);
        } else {
          stmt.bindDouble(42, value.getAliquotaPis());
        }
        if (value.getAliquotaCofins() == null) {
          stmt.bindNull(43);
        } else {
          stmt.bindDouble(43, value.getAliquotaCofins());
        }
        if (value.getTipoIcms() == null) {
          stmt.bindNull(44);
        } else {
          stmt.bindLong(44, value.getTipoIcms());
        }
        if (value.getTipoIpi() == null) {
          stmt.bindNull(45);
        } else {
          stmt.bindLong(45, value.getTipoIpi());
        }
        if (value.getTipoPis() == null) {
          stmt.bindNull(46);
        } else {
          stmt.bindLong(46, value.getTipoPis());
        }
        if (value.getTipoCofins() == null) {
          stmt.bindNull(47);
        } else {
          stmt.bindLong(47, value.getTipoCofins());
        }
        if (value.getValorTotalFrete() == null) {
          stmt.bindNull(48);
        } else {
          stmt.bindDouble(48, value.getValorTotalFrete());
        }
        if (value.getValorTotalSeguro() == null) {
          stmt.bindNull(49);
        } else {
          stmt.bindDouble(49, value.getValorTotalSeguro());
        }
        if (value.getValorDescontoIcms() == null) {
          stmt.bindNull(50);
        } else {
          stmt.bindDouble(50, value.getValorDescontoIcms());
        }
        if (value.getValorUnitario() == null) {
          stmt.bindNull(51);
        } else {
          stmt.bindDouble(51, value.getValorUnitario());
        }
        if (value.getValorDespesasAcessorias() == null) {
          stmt.bindNull(52);
        } else {
          stmt.bindDouble(52, value.getValorDespesasAcessorias());
        }
        if (value.getFlPrecoAlterado() == null) {
          stmt.bindNull(53);
        } else {
          stmt.bindString(53, value.getFlPrecoAlterado());
        }
        if (value.getValorPrecoUnitarioOriginal() == null) {
          stmt.bindNull(54);
        } else {
          stmt.bindDouble(54, value.getValorPrecoUnitarioOriginal());
        }
        if (value.getInfCilPP() == null) {
          stmt.bindNull(55);
        } else {
          stmt.bindString(55, value.getInfCilPP());
        }
        if (value.getCondicaoPagamento() == null) {
          stmt.bindNull(56);
        } else {
          stmt.bindString(56, value.getCondicaoPagamento());
        }
        if (value.getCdMovimento() == null) {
          stmt.bindNull(57);
        } else {
          stmt.bindString(57, value.getCdMovimento());
        }
        if (value.getReturnType() == null) {
          stmt.bindNull(58);
        } else {
          stmt.bindLong(58, value.getReturnType());
        }
        if (value.getReturnCode() == null) {
          stmt.bindNull(59);
        } else {
          stmt.bindString(59, value.getReturnCode());
        }
        if (value.getQuantidadeCilindroVendida() == null) {
          stmt.bindNull(60);
        } else {
          stmt.bindDouble(60, value.getQuantidadeCilindroVendida());
        }
        if (value.getQuantidadeCilindroPedida() == null) {
          stmt.bindNull(61);
        } else {
          stmt.bindDouble(61, value.getQuantidadeCilindroPedida());
        }
        if (value.getPedidoCustomer() == null) {
          stmt.bindNull(62);
        } else {
          stmt.bindString(62, value.getPedidoCustomer());
        }
        if (value.getItemPedidoCustomer() == null) {
          stmt.bindNull(63);
        } else {
          stmt.bindString(63, value.getItemPedidoCustomer());
        }
        if (value.getTipoFaturamento() == null) {
          stmt.bindNull(64);
        } else {
          stmt.bindString(64, value.getTipoFaturamento());
        }
        if (value.getFlAssistenciaTecnica() == null) {
          stmt.bindNull(65);
        } else {
          stmt.bindString(65, value.getFlAssistenciaTecnica());
        }
        if (value.getTipoItem() == null) {
          stmt.bindNull(66);
        } else {
          stmt.bindLong(66, value.getTipoItem());
        }
      }
    };
    this.__deletionAdapterOfInvoiceItem = new EntityDeletionOrUpdateAdapter<InvoiceItem>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `InvoiceItem` WHERE `idNota` = ? AND `cdItem` = ? AND `capacidade` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, InvoiceItem value) {
        if (value.getIdNota() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getIdNota());
        }
        if (value.getCdItem() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getCdItem());
        }
        if (value.getCapacidade() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindDouble(3, value.getCapacidade());
        }
      }
    };
  }

  @Override
  public void insertAll(List<InvoiceItem> invoiceItems) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfInvoiceItem.insert(invoiceItems);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insert(InvoiceItem invoiceItem) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfInvoiceItem_1.insert(invoiceItem);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(InvoiceItem invoiceItem) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfInvoiceItem.handle(invoiceItem);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll(List<InvoiceItem> invoiceItems) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfInvoiceItem.handleMultiple(invoiceItems);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<InvoiceItem> getAll() {
    final String _sql = "SELECT * FROM InvoiceItem";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfIdNota = _cursor.getColumnIndexOrThrow("idNota");
      final int _cursorIndexOfNumeroNota = _cursor.getColumnIndexOrThrow("numeroNota");
      final int _cursorIndexOfSerieNota = _cursor.getColumnIndexOrThrow("serieNota");
      final int _cursorIndexOfCfop = _cursor.getColumnIndexOrThrow("cfop");
      final int _cursorIndexOfSeqItem = _cursor.getColumnIndexOrThrow("seqItem");
      final int _cursorIndexOfCdItem = _cursor.getColumnIndexOrThrow("cdItem");
      final int _cursorIndexOfCapacidade = _cursor.getColumnIndexOrThrow("capacidade");
      final int _cursorIndexOfNomeItem = _cursor.getColumnIndexOrThrow("nomeItem");
      final int _cursorIndexOfQtdItem = _cursor.getColumnIndexOrThrow("qtdItem");
      final int _cursorIndexOfVolume = _cursor.getColumnIndexOrThrow("volume");
      final int _cursorIndexOfUnidadeMedida = _cursor.getColumnIndexOrThrow("unidadeMedida");
      final int _cursorIndexOfNaturezaOperacao = _cursor.getColumnIndexOrThrow("naturezaOperacao");
      final int _cursorIndexOfNomeNaturezaOperacao = _cursor.getColumnIndexOrThrow("nomeNaturezaOperacao");
      final int _cursorIndexOfClassifFiscal = _cursor.getColumnIndexOrThrow("classifFiscal");
      final int _cursorIndexOfCstAIcms = _cursor.getColumnIndexOrThrow("cstAIcms");
      final int _cursorIndexOfCstBIcms = _cursor.getColumnIndexOrThrow("cstBIcms");
      final int _cursorIndexOfCstIpi = _cursor.getColumnIndexOrThrow("cstIpi");
      final int _cursorIndexOfCstPis = _cursor.getColumnIndexOrThrow("cstPis");
      final int _cursorIndexOfCstCofins = _cursor.getColumnIndexOrThrow("cstCofins");
      final int _cursorIndexOfValorTotal = _cursor.getColumnIndexOrThrow("valorTotal");
      final int _cursorIndexOfValorBaseIcms = _cursor.getColumnIndexOrThrow("valorBaseIcms");
      final int _cursorIndexOfValorBaseReduzidaIcms = _cursor.getColumnIndexOrThrow("valorBaseReduzidaIcms");
      final int _cursorIndexOfValorIcms = _cursor.getColumnIndexOrThrow("valorIcms");
      final int _cursorIndexOfValorDebitoIcms = _cursor.getColumnIndexOrThrow("valorDebitoIcms");
      final int _cursorIndexOfValorCreditoIcms = _cursor.getColumnIndexOrThrow("valorCreditoIcms");
      final int _cursorIndexOfValorBaseIcmsSt = _cursor.getColumnIndexOrThrow("valorBaseIcmsSt");
      final int _cursorIndexOfValorIcmsSt = _cursor.getColumnIndexOrThrow("valorIcmsSt");
      final int _cursorIndexOfValorBaseIpi = _cursor.getColumnIndexOrThrow("valorBaseIpi");
      final int _cursorIndexOfValorIpi = _cursor.getColumnIndexOrThrow("valorIpi");
      final int _cursorIndexOfValorDebitoIpi = _cursor.getColumnIndexOrThrow("valorDebitoIpi");
      final int _cursorIndexOfValorCreditoIpi = _cursor.getColumnIndexOrThrow("valorCreditoIpi");
      final int _cursorIndexOfValorBasePis = _cursor.getColumnIndexOrThrow("valorBasePis");
      final int _cursorIndexOfValorDebitoPis = _cursor.getColumnIndexOrThrow("valorDebitoPis");
      final int _cursorIndexOfValorBaseCreditoPis = _cursor.getColumnIndexOrThrow("valorBaseCreditoPis");
      final int _cursorIndexOfValorCreditoPis = _cursor.getColumnIndexOrThrow("valorCreditoPis");
      final int _cursorIndexOfValorBaseCofins = _cursor.getColumnIndexOrThrow("valorBaseCofins");
      final int _cursorIndexOfValorDebitoCofins = _cursor.getColumnIndexOrThrow("valorDebitoCofins");
      final int _cursorIndexOfValorBaseCreditoCofins = _cursor.getColumnIndexOrThrow("valorBaseCreditoCofins");
      final int _cursorIndexOfValorCreditoCofins = _cursor.getColumnIndexOrThrow("valorCreditoCofins");
      final int _cursorIndexOfAliquotaIcms = _cursor.getColumnIndexOrThrow("aliquotaIcms");
      final int _cursorIndexOfAliquotaIpi = _cursor.getColumnIndexOrThrow("aliquotaIpi");
      final int _cursorIndexOfAliquotaPis = _cursor.getColumnIndexOrThrow("aliquotaPis");
      final int _cursorIndexOfAliquotaCofins = _cursor.getColumnIndexOrThrow("aliquotaCofins");
      final int _cursorIndexOfTipoIcms = _cursor.getColumnIndexOrThrow("tipoIcms");
      final int _cursorIndexOfTipoIpi = _cursor.getColumnIndexOrThrow("tipoIpi");
      final int _cursorIndexOfTipoPis = _cursor.getColumnIndexOrThrow("tipoPis");
      final int _cursorIndexOfTipoCofins = _cursor.getColumnIndexOrThrow("tipoCofins");
      final int _cursorIndexOfValorTotalFrete = _cursor.getColumnIndexOrThrow("valorTotalFrete");
      final int _cursorIndexOfValorTotalSeguro = _cursor.getColumnIndexOrThrow("valorTotalSeguro");
      final int _cursorIndexOfValorDescontoIcms = _cursor.getColumnIndexOrThrow("valorDescontoIcms");
      final int _cursorIndexOfValorUnitario = _cursor.getColumnIndexOrThrow("valorUnitario");
      final int _cursorIndexOfValorDespesasAcessorias = _cursor.getColumnIndexOrThrow("valorDespesasAcessorias");
      final int _cursorIndexOfFlPrecoAlterado = _cursor.getColumnIndexOrThrow("flPrecoAlterado");
      final int _cursorIndexOfValorPrecoUnitarioOriginal = _cursor.getColumnIndexOrThrow("valorPrecoUnitarioOriginal");
      final int _cursorIndexOfInfCilPP = _cursor.getColumnIndexOrThrow("infCilPP");
      final int _cursorIndexOfCondicaoPagamento = _cursor.getColumnIndexOrThrow("condicaoPagamento");
      final int _cursorIndexOfCdMovimento = _cursor.getColumnIndexOrThrow("cdMovimento");
      final int _cursorIndexOfReturnType = _cursor.getColumnIndexOrThrow("returnType");
      final int _cursorIndexOfReturnCode = _cursor.getColumnIndexOrThrow("returnCode");
      final int _cursorIndexOfQuantidadeCilindroVendida = _cursor.getColumnIndexOrThrow("quantidadeCilindroVendida");
      final int _cursorIndexOfQuantidadeCilindroPedida = _cursor.getColumnIndexOrThrow("quantidadeCilindroPedida");
      final int _cursorIndexOfPedidoCustomer = _cursor.getColumnIndexOrThrow("pedidoCustomer");
      final int _cursorIndexOfItemPedidoCustomer = _cursor.getColumnIndexOrThrow("itemPedidoCustomer");
      final int _cursorIndexOfTipoFaturamento = _cursor.getColumnIndexOrThrow("tipoFaturamento");
      final int _cursorIndexOfFlAssistenciaTecnica = _cursor.getColumnIndexOrThrow("flAssistenciaTecnica");
      final int _cursorIndexOfTipoItem = _cursor.getColumnIndexOrThrow("tipoItem");
      final List<InvoiceItem> _result = new ArrayList<InvoiceItem>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final InvoiceItem _item;
        _item = new InvoiceItem();
        final Long _tmpIdNota;
        if (_cursor.isNull(_cursorIndexOfIdNota)) {
          _tmpIdNota = null;
        } else {
          _tmpIdNota = _cursor.getLong(_cursorIndexOfIdNota);
        }
        _item.setIdNota(_tmpIdNota);
        final Long _tmpNumeroNota;
        if (_cursor.isNull(_cursorIndexOfNumeroNota)) {
          _tmpNumeroNota = null;
        } else {
          _tmpNumeroNota = _cursor.getLong(_cursorIndexOfNumeroNota);
        }
        _item.setNumeroNota(_tmpNumeroNota);
        final Long _tmpSerieNota;
        if (_cursor.isNull(_cursorIndexOfSerieNota)) {
          _tmpSerieNota = null;
        } else {
          _tmpSerieNota = _cursor.getLong(_cursorIndexOfSerieNota);
        }
        _item.setSerieNota(_tmpSerieNota);
        final Integer _tmpCfop;
        if (_cursor.isNull(_cursorIndexOfCfop)) {
          _tmpCfop = null;
        } else {
          _tmpCfop = _cursor.getInt(_cursorIndexOfCfop);
        }
        _item.setCfop(_tmpCfop);
        final Long _tmpSeqItem;
        if (_cursor.isNull(_cursorIndexOfSeqItem)) {
          _tmpSeqItem = null;
        } else {
          _tmpSeqItem = _cursor.getLong(_cursorIndexOfSeqItem);
        }
        _item.setSeqItem(_tmpSeqItem);
        final Long _tmpCdItem;
        if (_cursor.isNull(_cursorIndexOfCdItem)) {
          _tmpCdItem = null;
        } else {
          _tmpCdItem = _cursor.getLong(_cursorIndexOfCdItem);
        }
        _item.setCdItem(_tmpCdItem);
        final Double _tmpCapacidade;
        if (_cursor.isNull(_cursorIndexOfCapacidade)) {
          _tmpCapacidade = null;
        } else {
          _tmpCapacidade = _cursor.getDouble(_cursorIndexOfCapacidade);
        }
        _item.setCapacidade(_tmpCapacidade);
        final String _tmpNomeItem;
        _tmpNomeItem = _cursor.getString(_cursorIndexOfNomeItem);
        _item.setNomeItem(_tmpNomeItem);
        final Double _tmpQtdItem;
        if (_cursor.isNull(_cursorIndexOfQtdItem)) {
          _tmpQtdItem = null;
        } else {
          _tmpQtdItem = _cursor.getDouble(_cursorIndexOfQtdItem);
        }
        _item.setQtdItem(_tmpQtdItem);
        final Double _tmpVolume;
        if (_cursor.isNull(_cursorIndexOfVolume)) {
          _tmpVolume = null;
        } else {
          _tmpVolume = _cursor.getDouble(_cursorIndexOfVolume);
        }
        _item.setVolume(_tmpVolume);
        final String _tmpUnidadeMedida;
        _tmpUnidadeMedida = _cursor.getString(_cursorIndexOfUnidadeMedida);
        _item.setUnidadeMedida(_tmpUnidadeMedida);
        final String _tmpNaturezaOperacao;
        _tmpNaturezaOperacao = _cursor.getString(_cursorIndexOfNaturezaOperacao);
        _item.setNaturezaOperacao(_tmpNaturezaOperacao);
        final String _tmpNomeNaturezaOperacao;
        _tmpNomeNaturezaOperacao = _cursor.getString(_cursorIndexOfNomeNaturezaOperacao);
        _item.setNomeNaturezaOperacao(_tmpNomeNaturezaOperacao);
        final Long _tmpClassifFiscal;
        if (_cursor.isNull(_cursorIndexOfClassifFiscal)) {
          _tmpClassifFiscal = null;
        } else {
          _tmpClassifFiscal = _cursor.getLong(_cursorIndexOfClassifFiscal);
        }
        _item.setClassifFiscal(_tmpClassifFiscal);
        final String _tmpCstAIcms;
        _tmpCstAIcms = _cursor.getString(_cursorIndexOfCstAIcms);
        _item.setCstAIcms(_tmpCstAIcms);
        final String _tmpCstBIcms;
        _tmpCstBIcms = _cursor.getString(_cursorIndexOfCstBIcms);
        _item.setCstBIcms(_tmpCstBIcms);
        final String _tmpCstIpi;
        _tmpCstIpi = _cursor.getString(_cursorIndexOfCstIpi);
        _item.setCstIpi(_tmpCstIpi);
        final String _tmpCstPis;
        _tmpCstPis = _cursor.getString(_cursorIndexOfCstPis);
        _item.setCstPis(_tmpCstPis);
        final String _tmpCstCofins;
        _tmpCstCofins = _cursor.getString(_cursorIndexOfCstCofins);
        _item.setCstCofins(_tmpCstCofins);
        final Double _tmpValorTotal;
        if (_cursor.isNull(_cursorIndexOfValorTotal)) {
          _tmpValorTotal = null;
        } else {
          _tmpValorTotal = _cursor.getDouble(_cursorIndexOfValorTotal);
        }
        _item.setValorTotal(_tmpValorTotal);
        final Double _tmpValorBaseIcms;
        if (_cursor.isNull(_cursorIndexOfValorBaseIcms)) {
          _tmpValorBaseIcms = null;
        } else {
          _tmpValorBaseIcms = _cursor.getDouble(_cursorIndexOfValorBaseIcms);
        }
        _item.setValorBaseIcms(_tmpValorBaseIcms);
        final Double _tmpValorBaseReduzidaIcms;
        if (_cursor.isNull(_cursorIndexOfValorBaseReduzidaIcms)) {
          _tmpValorBaseReduzidaIcms = null;
        } else {
          _tmpValorBaseReduzidaIcms = _cursor.getDouble(_cursorIndexOfValorBaseReduzidaIcms);
        }
        _item.setValorBaseReduzidaIcms(_tmpValorBaseReduzidaIcms);
        final Double _tmpValorIcms;
        if (_cursor.isNull(_cursorIndexOfValorIcms)) {
          _tmpValorIcms = null;
        } else {
          _tmpValorIcms = _cursor.getDouble(_cursorIndexOfValorIcms);
        }
        _item.setValorIcms(_tmpValorIcms);
        final Double _tmpValorDebitoIcms;
        if (_cursor.isNull(_cursorIndexOfValorDebitoIcms)) {
          _tmpValorDebitoIcms = null;
        } else {
          _tmpValorDebitoIcms = _cursor.getDouble(_cursorIndexOfValorDebitoIcms);
        }
        _item.setValorDebitoIcms(_tmpValorDebitoIcms);
        final Double _tmpValorCreditoIcms;
        if (_cursor.isNull(_cursorIndexOfValorCreditoIcms)) {
          _tmpValorCreditoIcms = null;
        } else {
          _tmpValorCreditoIcms = _cursor.getDouble(_cursorIndexOfValorCreditoIcms);
        }
        _item.setValorCreditoIcms(_tmpValorCreditoIcms);
        final Double _tmpValorBaseIcmsSt;
        if (_cursor.isNull(_cursorIndexOfValorBaseIcmsSt)) {
          _tmpValorBaseIcmsSt = null;
        } else {
          _tmpValorBaseIcmsSt = _cursor.getDouble(_cursorIndexOfValorBaseIcmsSt);
        }
        _item.setValorBaseIcmsSt(_tmpValorBaseIcmsSt);
        final Double _tmpValorIcmsSt;
        if (_cursor.isNull(_cursorIndexOfValorIcmsSt)) {
          _tmpValorIcmsSt = null;
        } else {
          _tmpValorIcmsSt = _cursor.getDouble(_cursorIndexOfValorIcmsSt);
        }
        _item.setValorIcmsSt(_tmpValorIcmsSt);
        final Double _tmpValorBaseIpi;
        if (_cursor.isNull(_cursorIndexOfValorBaseIpi)) {
          _tmpValorBaseIpi = null;
        } else {
          _tmpValorBaseIpi = _cursor.getDouble(_cursorIndexOfValorBaseIpi);
        }
        _item.setValorBaseIpi(_tmpValorBaseIpi);
        final Double _tmpValorIpi;
        if (_cursor.isNull(_cursorIndexOfValorIpi)) {
          _tmpValorIpi = null;
        } else {
          _tmpValorIpi = _cursor.getDouble(_cursorIndexOfValorIpi);
        }
        _item.setValorIpi(_tmpValorIpi);
        final Double _tmpValorDebitoIpi;
        if (_cursor.isNull(_cursorIndexOfValorDebitoIpi)) {
          _tmpValorDebitoIpi = null;
        } else {
          _tmpValorDebitoIpi = _cursor.getDouble(_cursorIndexOfValorDebitoIpi);
        }
        _item.setValorDebitoIpi(_tmpValorDebitoIpi);
        final Double _tmpValorCreditoIpi;
        if (_cursor.isNull(_cursorIndexOfValorCreditoIpi)) {
          _tmpValorCreditoIpi = null;
        } else {
          _tmpValorCreditoIpi = _cursor.getDouble(_cursorIndexOfValorCreditoIpi);
        }
        _item.setValorCreditoIpi(_tmpValorCreditoIpi);
        final Double _tmpValorBasePis;
        if (_cursor.isNull(_cursorIndexOfValorBasePis)) {
          _tmpValorBasePis = null;
        } else {
          _tmpValorBasePis = _cursor.getDouble(_cursorIndexOfValorBasePis);
        }
        _item.setValorBasePis(_tmpValorBasePis);
        final Double _tmpValorDebitoPis;
        if (_cursor.isNull(_cursorIndexOfValorDebitoPis)) {
          _tmpValorDebitoPis = null;
        } else {
          _tmpValorDebitoPis = _cursor.getDouble(_cursorIndexOfValorDebitoPis);
        }
        _item.setValorDebitoPis(_tmpValorDebitoPis);
        final Double _tmpValorBaseCreditoPis;
        if (_cursor.isNull(_cursorIndexOfValorBaseCreditoPis)) {
          _tmpValorBaseCreditoPis = null;
        } else {
          _tmpValorBaseCreditoPis = _cursor.getDouble(_cursorIndexOfValorBaseCreditoPis);
        }
        _item.setValorBaseCreditoPis(_tmpValorBaseCreditoPis);
        final Double _tmpValorCreditoPis;
        if (_cursor.isNull(_cursorIndexOfValorCreditoPis)) {
          _tmpValorCreditoPis = null;
        } else {
          _tmpValorCreditoPis = _cursor.getDouble(_cursorIndexOfValorCreditoPis);
        }
        _item.setValorCreditoPis(_tmpValorCreditoPis);
        final Double _tmpValorBaseCofins;
        if (_cursor.isNull(_cursorIndexOfValorBaseCofins)) {
          _tmpValorBaseCofins = null;
        } else {
          _tmpValorBaseCofins = _cursor.getDouble(_cursorIndexOfValorBaseCofins);
        }
        _item.setValorBaseCofins(_tmpValorBaseCofins);
        final Double _tmpValorDebitoCofins;
        if (_cursor.isNull(_cursorIndexOfValorDebitoCofins)) {
          _tmpValorDebitoCofins = null;
        } else {
          _tmpValorDebitoCofins = _cursor.getDouble(_cursorIndexOfValorDebitoCofins);
        }
        _item.setValorDebitoCofins(_tmpValorDebitoCofins);
        final Double _tmpValorBaseCreditoCofins;
        if (_cursor.isNull(_cursorIndexOfValorBaseCreditoCofins)) {
          _tmpValorBaseCreditoCofins = null;
        } else {
          _tmpValorBaseCreditoCofins = _cursor.getDouble(_cursorIndexOfValorBaseCreditoCofins);
        }
        _item.setValorBaseCreditoCofins(_tmpValorBaseCreditoCofins);
        final Double _tmpValorCreditoCofins;
        if (_cursor.isNull(_cursorIndexOfValorCreditoCofins)) {
          _tmpValorCreditoCofins = null;
        } else {
          _tmpValorCreditoCofins = _cursor.getDouble(_cursorIndexOfValorCreditoCofins);
        }
        _item.setValorCreditoCofins(_tmpValorCreditoCofins);
        final Double _tmpAliquotaIcms;
        if (_cursor.isNull(_cursorIndexOfAliquotaIcms)) {
          _tmpAliquotaIcms = null;
        } else {
          _tmpAliquotaIcms = _cursor.getDouble(_cursorIndexOfAliquotaIcms);
        }
        _item.setAliquotaIcms(_tmpAliquotaIcms);
        final Double _tmpAliquotaIpi;
        if (_cursor.isNull(_cursorIndexOfAliquotaIpi)) {
          _tmpAliquotaIpi = null;
        } else {
          _tmpAliquotaIpi = _cursor.getDouble(_cursorIndexOfAliquotaIpi);
        }
        _item.setAliquotaIpi(_tmpAliquotaIpi);
        final Double _tmpAliquotaPis;
        if (_cursor.isNull(_cursorIndexOfAliquotaPis)) {
          _tmpAliquotaPis = null;
        } else {
          _tmpAliquotaPis = _cursor.getDouble(_cursorIndexOfAliquotaPis);
        }
        _item.setAliquotaPis(_tmpAliquotaPis);
        final Double _tmpAliquotaCofins;
        if (_cursor.isNull(_cursorIndexOfAliquotaCofins)) {
          _tmpAliquotaCofins = null;
        } else {
          _tmpAliquotaCofins = _cursor.getDouble(_cursorIndexOfAliquotaCofins);
        }
        _item.setAliquotaCofins(_tmpAliquotaCofins);
        final Integer _tmpTipoIcms;
        if (_cursor.isNull(_cursorIndexOfTipoIcms)) {
          _tmpTipoIcms = null;
        } else {
          _tmpTipoIcms = _cursor.getInt(_cursorIndexOfTipoIcms);
        }
        _item.setTipoIcms(_tmpTipoIcms);
        final Integer _tmpTipoIpi;
        if (_cursor.isNull(_cursorIndexOfTipoIpi)) {
          _tmpTipoIpi = null;
        } else {
          _tmpTipoIpi = _cursor.getInt(_cursorIndexOfTipoIpi);
        }
        _item.setTipoIpi(_tmpTipoIpi);
        final Integer _tmpTipoPis;
        if (_cursor.isNull(_cursorIndexOfTipoPis)) {
          _tmpTipoPis = null;
        } else {
          _tmpTipoPis = _cursor.getInt(_cursorIndexOfTipoPis);
        }
        _item.setTipoPis(_tmpTipoPis);
        final Integer _tmpTipoCofins;
        if (_cursor.isNull(_cursorIndexOfTipoCofins)) {
          _tmpTipoCofins = null;
        } else {
          _tmpTipoCofins = _cursor.getInt(_cursorIndexOfTipoCofins);
        }
        _item.setTipoCofins(_tmpTipoCofins);
        final Double _tmpValorTotalFrete;
        if (_cursor.isNull(_cursorIndexOfValorTotalFrete)) {
          _tmpValorTotalFrete = null;
        } else {
          _tmpValorTotalFrete = _cursor.getDouble(_cursorIndexOfValorTotalFrete);
        }
        _item.setValorTotalFrete(_tmpValorTotalFrete);
        final Double _tmpValorTotalSeguro;
        if (_cursor.isNull(_cursorIndexOfValorTotalSeguro)) {
          _tmpValorTotalSeguro = null;
        } else {
          _tmpValorTotalSeguro = _cursor.getDouble(_cursorIndexOfValorTotalSeguro);
        }
        _item.setValorTotalSeguro(_tmpValorTotalSeguro);
        final Double _tmpValorDescontoIcms;
        if (_cursor.isNull(_cursorIndexOfValorDescontoIcms)) {
          _tmpValorDescontoIcms = null;
        } else {
          _tmpValorDescontoIcms = _cursor.getDouble(_cursorIndexOfValorDescontoIcms);
        }
        _item.setValorDescontoIcms(_tmpValorDescontoIcms);
        final Double _tmpValorUnitario;
        if (_cursor.isNull(_cursorIndexOfValorUnitario)) {
          _tmpValorUnitario = null;
        } else {
          _tmpValorUnitario = _cursor.getDouble(_cursorIndexOfValorUnitario);
        }
        _item.setValorUnitario(_tmpValorUnitario);
        final Double _tmpValorDespesasAcessorias;
        if (_cursor.isNull(_cursorIndexOfValorDespesasAcessorias)) {
          _tmpValorDespesasAcessorias = null;
        } else {
          _tmpValorDespesasAcessorias = _cursor.getDouble(_cursorIndexOfValorDespesasAcessorias);
        }
        _item.setValorDespesasAcessorias(_tmpValorDespesasAcessorias);
        final String _tmpFlPrecoAlterado;
        _tmpFlPrecoAlterado = _cursor.getString(_cursorIndexOfFlPrecoAlterado);
        _item.setFlPrecoAlterado(_tmpFlPrecoAlterado);
        final Double _tmpValorPrecoUnitarioOriginal;
        if (_cursor.isNull(_cursorIndexOfValorPrecoUnitarioOriginal)) {
          _tmpValorPrecoUnitarioOriginal = null;
        } else {
          _tmpValorPrecoUnitarioOriginal = _cursor.getDouble(_cursorIndexOfValorPrecoUnitarioOriginal);
        }
        _item.setValorPrecoUnitarioOriginal(_tmpValorPrecoUnitarioOriginal);
        final String _tmpInfCilPP;
        _tmpInfCilPP = _cursor.getString(_cursorIndexOfInfCilPP);
        _item.setInfCilPP(_tmpInfCilPP);
        final String _tmpCondicaoPagamento;
        _tmpCondicaoPagamento = _cursor.getString(_cursorIndexOfCondicaoPagamento);
        _item.setCondicaoPagamento(_tmpCondicaoPagamento);
        final String _tmpCdMovimento;
        _tmpCdMovimento = _cursor.getString(_cursorIndexOfCdMovimento);
        _item.setCdMovimento(_tmpCdMovimento);
        final Integer _tmpReturnType;
        if (_cursor.isNull(_cursorIndexOfReturnType)) {
          _tmpReturnType = null;
        } else {
          _tmpReturnType = _cursor.getInt(_cursorIndexOfReturnType);
        }
        _item.setReturnType(_tmpReturnType);
        final String _tmpReturnCode;
        _tmpReturnCode = _cursor.getString(_cursorIndexOfReturnCode);
        _item.setReturnCode(_tmpReturnCode);
        final Double _tmpQuantidadeCilindroVendida;
        if (_cursor.isNull(_cursorIndexOfQuantidadeCilindroVendida)) {
          _tmpQuantidadeCilindroVendida = null;
        } else {
          _tmpQuantidadeCilindroVendida = _cursor.getDouble(_cursorIndexOfQuantidadeCilindroVendida);
        }
        _item.setQuantidadeCilindroVendida(_tmpQuantidadeCilindroVendida);
        final Double _tmpQuantidadeCilindroPedida;
        if (_cursor.isNull(_cursorIndexOfQuantidadeCilindroPedida)) {
          _tmpQuantidadeCilindroPedida = null;
        } else {
          _tmpQuantidadeCilindroPedida = _cursor.getDouble(_cursorIndexOfQuantidadeCilindroPedida);
        }
        _item.setQuantidadeCilindroPedida(_tmpQuantidadeCilindroPedida);
        final String _tmpPedidoCustomer;
        _tmpPedidoCustomer = _cursor.getString(_cursorIndexOfPedidoCustomer);
        _item.setPedidoCustomer(_tmpPedidoCustomer);
        final String _tmpItemPedidoCustomer;
        _tmpItemPedidoCustomer = _cursor.getString(_cursorIndexOfItemPedidoCustomer);
        _item.setItemPedidoCustomer(_tmpItemPedidoCustomer);
        final String _tmpTipoFaturamento;
        _tmpTipoFaturamento = _cursor.getString(_cursorIndexOfTipoFaturamento);
        _item.setTipoFaturamento(_tmpTipoFaturamento);
        final String _tmpFlAssistenciaTecnica;
        _tmpFlAssistenciaTecnica = _cursor.getString(_cursorIndexOfFlAssistenciaTecnica);
        _item.setFlAssistenciaTecnica(_tmpFlAssistenciaTecnica);
        final Integer _tmpTipoItem;
        if (_cursor.isNull(_cursorIndexOfTipoItem)) {
          _tmpTipoItem = null;
        } else {
          _tmpTipoItem = _cursor.getInt(_cursorIndexOfTipoItem);
        }
        _item.setTipoItem(_tmpTipoItem);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<InvoiceItem> find() {
    final String _sql = "SELECT * FROM InvoiceItem ORDER BY cdItem";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfIdNota = _cursor.getColumnIndexOrThrow("idNota");
      final int _cursorIndexOfNumeroNota = _cursor.getColumnIndexOrThrow("numeroNota");
      final int _cursorIndexOfSerieNota = _cursor.getColumnIndexOrThrow("serieNota");
      final int _cursorIndexOfCfop = _cursor.getColumnIndexOrThrow("cfop");
      final int _cursorIndexOfSeqItem = _cursor.getColumnIndexOrThrow("seqItem");
      final int _cursorIndexOfCdItem = _cursor.getColumnIndexOrThrow("cdItem");
      final int _cursorIndexOfCapacidade = _cursor.getColumnIndexOrThrow("capacidade");
      final int _cursorIndexOfNomeItem = _cursor.getColumnIndexOrThrow("nomeItem");
      final int _cursorIndexOfQtdItem = _cursor.getColumnIndexOrThrow("qtdItem");
      final int _cursorIndexOfVolume = _cursor.getColumnIndexOrThrow("volume");
      final int _cursorIndexOfUnidadeMedida = _cursor.getColumnIndexOrThrow("unidadeMedida");
      final int _cursorIndexOfNaturezaOperacao = _cursor.getColumnIndexOrThrow("naturezaOperacao");
      final int _cursorIndexOfNomeNaturezaOperacao = _cursor.getColumnIndexOrThrow("nomeNaturezaOperacao");
      final int _cursorIndexOfClassifFiscal = _cursor.getColumnIndexOrThrow("classifFiscal");
      final int _cursorIndexOfCstAIcms = _cursor.getColumnIndexOrThrow("cstAIcms");
      final int _cursorIndexOfCstBIcms = _cursor.getColumnIndexOrThrow("cstBIcms");
      final int _cursorIndexOfCstIpi = _cursor.getColumnIndexOrThrow("cstIpi");
      final int _cursorIndexOfCstPis = _cursor.getColumnIndexOrThrow("cstPis");
      final int _cursorIndexOfCstCofins = _cursor.getColumnIndexOrThrow("cstCofins");
      final int _cursorIndexOfValorTotal = _cursor.getColumnIndexOrThrow("valorTotal");
      final int _cursorIndexOfValorBaseIcms = _cursor.getColumnIndexOrThrow("valorBaseIcms");
      final int _cursorIndexOfValorBaseReduzidaIcms = _cursor.getColumnIndexOrThrow("valorBaseReduzidaIcms");
      final int _cursorIndexOfValorIcms = _cursor.getColumnIndexOrThrow("valorIcms");
      final int _cursorIndexOfValorDebitoIcms = _cursor.getColumnIndexOrThrow("valorDebitoIcms");
      final int _cursorIndexOfValorCreditoIcms = _cursor.getColumnIndexOrThrow("valorCreditoIcms");
      final int _cursorIndexOfValorBaseIcmsSt = _cursor.getColumnIndexOrThrow("valorBaseIcmsSt");
      final int _cursorIndexOfValorIcmsSt = _cursor.getColumnIndexOrThrow("valorIcmsSt");
      final int _cursorIndexOfValorBaseIpi = _cursor.getColumnIndexOrThrow("valorBaseIpi");
      final int _cursorIndexOfValorIpi = _cursor.getColumnIndexOrThrow("valorIpi");
      final int _cursorIndexOfValorDebitoIpi = _cursor.getColumnIndexOrThrow("valorDebitoIpi");
      final int _cursorIndexOfValorCreditoIpi = _cursor.getColumnIndexOrThrow("valorCreditoIpi");
      final int _cursorIndexOfValorBasePis = _cursor.getColumnIndexOrThrow("valorBasePis");
      final int _cursorIndexOfValorDebitoPis = _cursor.getColumnIndexOrThrow("valorDebitoPis");
      final int _cursorIndexOfValorBaseCreditoPis = _cursor.getColumnIndexOrThrow("valorBaseCreditoPis");
      final int _cursorIndexOfValorCreditoPis = _cursor.getColumnIndexOrThrow("valorCreditoPis");
      final int _cursorIndexOfValorBaseCofins = _cursor.getColumnIndexOrThrow("valorBaseCofins");
      final int _cursorIndexOfValorDebitoCofins = _cursor.getColumnIndexOrThrow("valorDebitoCofins");
      final int _cursorIndexOfValorBaseCreditoCofins = _cursor.getColumnIndexOrThrow("valorBaseCreditoCofins");
      final int _cursorIndexOfValorCreditoCofins = _cursor.getColumnIndexOrThrow("valorCreditoCofins");
      final int _cursorIndexOfAliquotaIcms = _cursor.getColumnIndexOrThrow("aliquotaIcms");
      final int _cursorIndexOfAliquotaIpi = _cursor.getColumnIndexOrThrow("aliquotaIpi");
      final int _cursorIndexOfAliquotaPis = _cursor.getColumnIndexOrThrow("aliquotaPis");
      final int _cursorIndexOfAliquotaCofins = _cursor.getColumnIndexOrThrow("aliquotaCofins");
      final int _cursorIndexOfTipoIcms = _cursor.getColumnIndexOrThrow("tipoIcms");
      final int _cursorIndexOfTipoIpi = _cursor.getColumnIndexOrThrow("tipoIpi");
      final int _cursorIndexOfTipoPis = _cursor.getColumnIndexOrThrow("tipoPis");
      final int _cursorIndexOfTipoCofins = _cursor.getColumnIndexOrThrow("tipoCofins");
      final int _cursorIndexOfValorTotalFrete = _cursor.getColumnIndexOrThrow("valorTotalFrete");
      final int _cursorIndexOfValorTotalSeguro = _cursor.getColumnIndexOrThrow("valorTotalSeguro");
      final int _cursorIndexOfValorDescontoIcms = _cursor.getColumnIndexOrThrow("valorDescontoIcms");
      final int _cursorIndexOfValorUnitario = _cursor.getColumnIndexOrThrow("valorUnitario");
      final int _cursorIndexOfValorDespesasAcessorias = _cursor.getColumnIndexOrThrow("valorDespesasAcessorias");
      final int _cursorIndexOfFlPrecoAlterado = _cursor.getColumnIndexOrThrow("flPrecoAlterado");
      final int _cursorIndexOfValorPrecoUnitarioOriginal = _cursor.getColumnIndexOrThrow("valorPrecoUnitarioOriginal");
      final int _cursorIndexOfInfCilPP = _cursor.getColumnIndexOrThrow("infCilPP");
      final int _cursorIndexOfCondicaoPagamento = _cursor.getColumnIndexOrThrow("condicaoPagamento");
      final int _cursorIndexOfCdMovimento = _cursor.getColumnIndexOrThrow("cdMovimento");
      final int _cursorIndexOfReturnType = _cursor.getColumnIndexOrThrow("returnType");
      final int _cursorIndexOfReturnCode = _cursor.getColumnIndexOrThrow("returnCode");
      final int _cursorIndexOfQuantidadeCilindroVendida = _cursor.getColumnIndexOrThrow("quantidadeCilindroVendida");
      final int _cursorIndexOfQuantidadeCilindroPedida = _cursor.getColumnIndexOrThrow("quantidadeCilindroPedida");
      final int _cursorIndexOfPedidoCustomer = _cursor.getColumnIndexOrThrow("pedidoCustomer");
      final int _cursorIndexOfItemPedidoCustomer = _cursor.getColumnIndexOrThrow("itemPedidoCustomer");
      final int _cursorIndexOfTipoFaturamento = _cursor.getColumnIndexOrThrow("tipoFaturamento");
      final int _cursorIndexOfFlAssistenciaTecnica = _cursor.getColumnIndexOrThrow("flAssistenciaTecnica");
      final int _cursorIndexOfTipoItem = _cursor.getColumnIndexOrThrow("tipoItem");
      final List<InvoiceItem> _result = new ArrayList<InvoiceItem>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final InvoiceItem _item;
        _item = new InvoiceItem();
        final Long _tmpIdNota;
        if (_cursor.isNull(_cursorIndexOfIdNota)) {
          _tmpIdNota = null;
        } else {
          _tmpIdNota = _cursor.getLong(_cursorIndexOfIdNota);
        }
        _item.setIdNota(_tmpIdNota);
        final Long _tmpNumeroNota;
        if (_cursor.isNull(_cursorIndexOfNumeroNota)) {
          _tmpNumeroNota = null;
        } else {
          _tmpNumeroNota = _cursor.getLong(_cursorIndexOfNumeroNota);
        }
        _item.setNumeroNota(_tmpNumeroNota);
        final Long _tmpSerieNota;
        if (_cursor.isNull(_cursorIndexOfSerieNota)) {
          _tmpSerieNota = null;
        } else {
          _tmpSerieNota = _cursor.getLong(_cursorIndexOfSerieNota);
        }
        _item.setSerieNota(_tmpSerieNota);
        final Integer _tmpCfop;
        if (_cursor.isNull(_cursorIndexOfCfop)) {
          _tmpCfop = null;
        } else {
          _tmpCfop = _cursor.getInt(_cursorIndexOfCfop);
        }
        _item.setCfop(_tmpCfop);
        final Long _tmpSeqItem;
        if (_cursor.isNull(_cursorIndexOfSeqItem)) {
          _tmpSeqItem = null;
        } else {
          _tmpSeqItem = _cursor.getLong(_cursorIndexOfSeqItem);
        }
        _item.setSeqItem(_tmpSeqItem);
        final Long _tmpCdItem;
        if (_cursor.isNull(_cursorIndexOfCdItem)) {
          _tmpCdItem = null;
        } else {
          _tmpCdItem = _cursor.getLong(_cursorIndexOfCdItem);
        }
        _item.setCdItem(_tmpCdItem);
        final Double _tmpCapacidade;
        if (_cursor.isNull(_cursorIndexOfCapacidade)) {
          _tmpCapacidade = null;
        } else {
          _tmpCapacidade = _cursor.getDouble(_cursorIndexOfCapacidade);
        }
        _item.setCapacidade(_tmpCapacidade);
        final String _tmpNomeItem;
        _tmpNomeItem = _cursor.getString(_cursorIndexOfNomeItem);
        _item.setNomeItem(_tmpNomeItem);
        final Double _tmpQtdItem;
        if (_cursor.isNull(_cursorIndexOfQtdItem)) {
          _tmpQtdItem = null;
        } else {
          _tmpQtdItem = _cursor.getDouble(_cursorIndexOfQtdItem);
        }
        _item.setQtdItem(_tmpQtdItem);
        final Double _tmpVolume;
        if (_cursor.isNull(_cursorIndexOfVolume)) {
          _tmpVolume = null;
        } else {
          _tmpVolume = _cursor.getDouble(_cursorIndexOfVolume);
        }
        _item.setVolume(_tmpVolume);
        final String _tmpUnidadeMedida;
        _tmpUnidadeMedida = _cursor.getString(_cursorIndexOfUnidadeMedida);
        _item.setUnidadeMedida(_tmpUnidadeMedida);
        final String _tmpNaturezaOperacao;
        _tmpNaturezaOperacao = _cursor.getString(_cursorIndexOfNaturezaOperacao);
        _item.setNaturezaOperacao(_tmpNaturezaOperacao);
        final String _tmpNomeNaturezaOperacao;
        _tmpNomeNaturezaOperacao = _cursor.getString(_cursorIndexOfNomeNaturezaOperacao);
        _item.setNomeNaturezaOperacao(_tmpNomeNaturezaOperacao);
        final Long _tmpClassifFiscal;
        if (_cursor.isNull(_cursorIndexOfClassifFiscal)) {
          _tmpClassifFiscal = null;
        } else {
          _tmpClassifFiscal = _cursor.getLong(_cursorIndexOfClassifFiscal);
        }
        _item.setClassifFiscal(_tmpClassifFiscal);
        final String _tmpCstAIcms;
        _tmpCstAIcms = _cursor.getString(_cursorIndexOfCstAIcms);
        _item.setCstAIcms(_tmpCstAIcms);
        final String _tmpCstBIcms;
        _tmpCstBIcms = _cursor.getString(_cursorIndexOfCstBIcms);
        _item.setCstBIcms(_tmpCstBIcms);
        final String _tmpCstIpi;
        _tmpCstIpi = _cursor.getString(_cursorIndexOfCstIpi);
        _item.setCstIpi(_tmpCstIpi);
        final String _tmpCstPis;
        _tmpCstPis = _cursor.getString(_cursorIndexOfCstPis);
        _item.setCstPis(_tmpCstPis);
        final String _tmpCstCofins;
        _tmpCstCofins = _cursor.getString(_cursorIndexOfCstCofins);
        _item.setCstCofins(_tmpCstCofins);
        final Double _tmpValorTotal;
        if (_cursor.isNull(_cursorIndexOfValorTotal)) {
          _tmpValorTotal = null;
        } else {
          _tmpValorTotal = _cursor.getDouble(_cursorIndexOfValorTotal);
        }
        _item.setValorTotal(_tmpValorTotal);
        final Double _tmpValorBaseIcms;
        if (_cursor.isNull(_cursorIndexOfValorBaseIcms)) {
          _tmpValorBaseIcms = null;
        } else {
          _tmpValorBaseIcms = _cursor.getDouble(_cursorIndexOfValorBaseIcms);
        }
        _item.setValorBaseIcms(_tmpValorBaseIcms);
        final Double _tmpValorBaseReduzidaIcms;
        if (_cursor.isNull(_cursorIndexOfValorBaseReduzidaIcms)) {
          _tmpValorBaseReduzidaIcms = null;
        } else {
          _tmpValorBaseReduzidaIcms = _cursor.getDouble(_cursorIndexOfValorBaseReduzidaIcms);
        }
        _item.setValorBaseReduzidaIcms(_tmpValorBaseReduzidaIcms);
        final Double _tmpValorIcms;
        if (_cursor.isNull(_cursorIndexOfValorIcms)) {
          _tmpValorIcms = null;
        } else {
          _tmpValorIcms = _cursor.getDouble(_cursorIndexOfValorIcms);
        }
        _item.setValorIcms(_tmpValorIcms);
        final Double _tmpValorDebitoIcms;
        if (_cursor.isNull(_cursorIndexOfValorDebitoIcms)) {
          _tmpValorDebitoIcms = null;
        } else {
          _tmpValorDebitoIcms = _cursor.getDouble(_cursorIndexOfValorDebitoIcms);
        }
        _item.setValorDebitoIcms(_tmpValorDebitoIcms);
        final Double _tmpValorCreditoIcms;
        if (_cursor.isNull(_cursorIndexOfValorCreditoIcms)) {
          _tmpValorCreditoIcms = null;
        } else {
          _tmpValorCreditoIcms = _cursor.getDouble(_cursorIndexOfValorCreditoIcms);
        }
        _item.setValorCreditoIcms(_tmpValorCreditoIcms);
        final Double _tmpValorBaseIcmsSt;
        if (_cursor.isNull(_cursorIndexOfValorBaseIcmsSt)) {
          _tmpValorBaseIcmsSt = null;
        } else {
          _tmpValorBaseIcmsSt = _cursor.getDouble(_cursorIndexOfValorBaseIcmsSt);
        }
        _item.setValorBaseIcmsSt(_tmpValorBaseIcmsSt);
        final Double _tmpValorIcmsSt;
        if (_cursor.isNull(_cursorIndexOfValorIcmsSt)) {
          _tmpValorIcmsSt = null;
        } else {
          _tmpValorIcmsSt = _cursor.getDouble(_cursorIndexOfValorIcmsSt);
        }
        _item.setValorIcmsSt(_tmpValorIcmsSt);
        final Double _tmpValorBaseIpi;
        if (_cursor.isNull(_cursorIndexOfValorBaseIpi)) {
          _tmpValorBaseIpi = null;
        } else {
          _tmpValorBaseIpi = _cursor.getDouble(_cursorIndexOfValorBaseIpi);
        }
        _item.setValorBaseIpi(_tmpValorBaseIpi);
        final Double _tmpValorIpi;
        if (_cursor.isNull(_cursorIndexOfValorIpi)) {
          _tmpValorIpi = null;
        } else {
          _tmpValorIpi = _cursor.getDouble(_cursorIndexOfValorIpi);
        }
        _item.setValorIpi(_tmpValorIpi);
        final Double _tmpValorDebitoIpi;
        if (_cursor.isNull(_cursorIndexOfValorDebitoIpi)) {
          _tmpValorDebitoIpi = null;
        } else {
          _tmpValorDebitoIpi = _cursor.getDouble(_cursorIndexOfValorDebitoIpi);
        }
        _item.setValorDebitoIpi(_tmpValorDebitoIpi);
        final Double _tmpValorCreditoIpi;
        if (_cursor.isNull(_cursorIndexOfValorCreditoIpi)) {
          _tmpValorCreditoIpi = null;
        } else {
          _tmpValorCreditoIpi = _cursor.getDouble(_cursorIndexOfValorCreditoIpi);
        }
        _item.setValorCreditoIpi(_tmpValorCreditoIpi);
        final Double _tmpValorBasePis;
        if (_cursor.isNull(_cursorIndexOfValorBasePis)) {
          _tmpValorBasePis = null;
        } else {
          _tmpValorBasePis = _cursor.getDouble(_cursorIndexOfValorBasePis);
        }
        _item.setValorBasePis(_tmpValorBasePis);
        final Double _tmpValorDebitoPis;
        if (_cursor.isNull(_cursorIndexOfValorDebitoPis)) {
          _tmpValorDebitoPis = null;
        } else {
          _tmpValorDebitoPis = _cursor.getDouble(_cursorIndexOfValorDebitoPis);
        }
        _item.setValorDebitoPis(_tmpValorDebitoPis);
        final Double _tmpValorBaseCreditoPis;
        if (_cursor.isNull(_cursorIndexOfValorBaseCreditoPis)) {
          _tmpValorBaseCreditoPis = null;
        } else {
          _tmpValorBaseCreditoPis = _cursor.getDouble(_cursorIndexOfValorBaseCreditoPis);
        }
        _item.setValorBaseCreditoPis(_tmpValorBaseCreditoPis);
        final Double _tmpValorCreditoPis;
        if (_cursor.isNull(_cursorIndexOfValorCreditoPis)) {
          _tmpValorCreditoPis = null;
        } else {
          _tmpValorCreditoPis = _cursor.getDouble(_cursorIndexOfValorCreditoPis);
        }
        _item.setValorCreditoPis(_tmpValorCreditoPis);
        final Double _tmpValorBaseCofins;
        if (_cursor.isNull(_cursorIndexOfValorBaseCofins)) {
          _tmpValorBaseCofins = null;
        } else {
          _tmpValorBaseCofins = _cursor.getDouble(_cursorIndexOfValorBaseCofins);
        }
        _item.setValorBaseCofins(_tmpValorBaseCofins);
        final Double _tmpValorDebitoCofins;
        if (_cursor.isNull(_cursorIndexOfValorDebitoCofins)) {
          _tmpValorDebitoCofins = null;
        } else {
          _tmpValorDebitoCofins = _cursor.getDouble(_cursorIndexOfValorDebitoCofins);
        }
        _item.setValorDebitoCofins(_tmpValorDebitoCofins);
        final Double _tmpValorBaseCreditoCofins;
        if (_cursor.isNull(_cursorIndexOfValorBaseCreditoCofins)) {
          _tmpValorBaseCreditoCofins = null;
        } else {
          _tmpValorBaseCreditoCofins = _cursor.getDouble(_cursorIndexOfValorBaseCreditoCofins);
        }
        _item.setValorBaseCreditoCofins(_tmpValorBaseCreditoCofins);
        final Double _tmpValorCreditoCofins;
        if (_cursor.isNull(_cursorIndexOfValorCreditoCofins)) {
          _tmpValorCreditoCofins = null;
        } else {
          _tmpValorCreditoCofins = _cursor.getDouble(_cursorIndexOfValorCreditoCofins);
        }
        _item.setValorCreditoCofins(_tmpValorCreditoCofins);
        final Double _tmpAliquotaIcms;
        if (_cursor.isNull(_cursorIndexOfAliquotaIcms)) {
          _tmpAliquotaIcms = null;
        } else {
          _tmpAliquotaIcms = _cursor.getDouble(_cursorIndexOfAliquotaIcms);
        }
        _item.setAliquotaIcms(_tmpAliquotaIcms);
        final Double _tmpAliquotaIpi;
        if (_cursor.isNull(_cursorIndexOfAliquotaIpi)) {
          _tmpAliquotaIpi = null;
        } else {
          _tmpAliquotaIpi = _cursor.getDouble(_cursorIndexOfAliquotaIpi);
        }
        _item.setAliquotaIpi(_tmpAliquotaIpi);
        final Double _tmpAliquotaPis;
        if (_cursor.isNull(_cursorIndexOfAliquotaPis)) {
          _tmpAliquotaPis = null;
        } else {
          _tmpAliquotaPis = _cursor.getDouble(_cursorIndexOfAliquotaPis);
        }
        _item.setAliquotaPis(_tmpAliquotaPis);
        final Double _tmpAliquotaCofins;
        if (_cursor.isNull(_cursorIndexOfAliquotaCofins)) {
          _tmpAliquotaCofins = null;
        } else {
          _tmpAliquotaCofins = _cursor.getDouble(_cursorIndexOfAliquotaCofins);
        }
        _item.setAliquotaCofins(_tmpAliquotaCofins);
        final Integer _tmpTipoIcms;
        if (_cursor.isNull(_cursorIndexOfTipoIcms)) {
          _tmpTipoIcms = null;
        } else {
          _tmpTipoIcms = _cursor.getInt(_cursorIndexOfTipoIcms);
        }
        _item.setTipoIcms(_tmpTipoIcms);
        final Integer _tmpTipoIpi;
        if (_cursor.isNull(_cursorIndexOfTipoIpi)) {
          _tmpTipoIpi = null;
        } else {
          _tmpTipoIpi = _cursor.getInt(_cursorIndexOfTipoIpi);
        }
        _item.setTipoIpi(_tmpTipoIpi);
        final Integer _tmpTipoPis;
        if (_cursor.isNull(_cursorIndexOfTipoPis)) {
          _tmpTipoPis = null;
        } else {
          _tmpTipoPis = _cursor.getInt(_cursorIndexOfTipoPis);
        }
        _item.setTipoPis(_tmpTipoPis);
        final Integer _tmpTipoCofins;
        if (_cursor.isNull(_cursorIndexOfTipoCofins)) {
          _tmpTipoCofins = null;
        } else {
          _tmpTipoCofins = _cursor.getInt(_cursorIndexOfTipoCofins);
        }
        _item.setTipoCofins(_tmpTipoCofins);
        final Double _tmpValorTotalFrete;
        if (_cursor.isNull(_cursorIndexOfValorTotalFrete)) {
          _tmpValorTotalFrete = null;
        } else {
          _tmpValorTotalFrete = _cursor.getDouble(_cursorIndexOfValorTotalFrete);
        }
        _item.setValorTotalFrete(_tmpValorTotalFrete);
        final Double _tmpValorTotalSeguro;
        if (_cursor.isNull(_cursorIndexOfValorTotalSeguro)) {
          _tmpValorTotalSeguro = null;
        } else {
          _tmpValorTotalSeguro = _cursor.getDouble(_cursorIndexOfValorTotalSeguro);
        }
        _item.setValorTotalSeguro(_tmpValorTotalSeguro);
        final Double _tmpValorDescontoIcms;
        if (_cursor.isNull(_cursorIndexOfValorDescontoIcms)) {
          _tmpValorDescontoIcms = null;
        } else {
          _tmpValorDescontoIcms = _cursor.getDouble(_cursorIndexOfValorDescontoIcms);
        }
        _item.setValorDescontoIcms(_tmpValorDescontoIcms);
        final Double _tmpValorUnitario;
        if (_cursor.isNull(_cursorIndexOfValorUnitario)) {
          _tmpValorUnitario = null;
        } else {
          _tmpValorUnitario = _cursor.getDouble(_cursorIndexOfValorUnitario);
        }
        _item.setValorUnitario(_tmpValorUnitario);
        final Double _tmpValorDespesasAcessorias;
        if (_cursor.isNull(_cursorIndexOfValorDespesasAcessorias)) {
          _tmpValorDespesasAcessorias = null;
        } else {
          _tmpValorDespesasAcessorias = _cursor.getDouble(_cursorIndexOfValorDespesasAcessorias);
        }
        _item.setValorDespesasAcessorias(_tmpValorDespesasAcessorias);
        final String _tmpFlPrecoAlterado;
        _tmpFlPrecoAlterado = _cursor.getString(_cursorIndexOfFlPrecoAlterado);
        _item.setFlPrecoAlterado(_tmpFlPrecoAlterado);
        final Double _tmpValorPrecoUnitarioOriginal;
        if (_cursor.isNull(_cursorIndexOfValorPrecoUnitarioOriginal)) {
          _tmpValorPrecoUnitarioOriginal = null;
        } else {
          _tmpValorPrecoUnitarioOriginal = _cursor.getDouble(_cursorIndexOfValorPrecoUnitarioOriginal);
        }
        _item.setValorPrecoUnitarioOriginal(_tmpValorPrecoUnitarioOriginal);
        final String _tmpInfCilPP;
        _tmpInfCilPP = _cursor.getString(_cursorIndexOfInfCilPP);
        _item.setInfCilPP(_tmpInfCilPP);
        final String _tmpCondicaoPagamento;
        _tmpCondicaoPagamento = _cursor.getString(_cursorIndexOfCondicaoPagamento);
        _item.setCondicaoPagamento(_tmpCondicaoPagamento);
        final String _tmpCdMovimento;
        _tmpCdMovimento = _cursor.getString(_cursorIndexOfCdMovimento);
        _item.setCdMovimento(_tmpCdMovimento);
        final Integer _tmpReturnType;
        if (_cursor.isNull(_cursorIndexOfReturnType)) {
          _tmpReturnType = null;
        } else {
          _tmpReturnType = _cursor.getInt(_cursorIndexOfReturnType);
        }
        _item.setReturnType(_tmpReturnType);
        final String _tmpReturnCode;
        _tmpReturnCode = _cursor.getString(_cursorIndexOfReturnCode);
        _item.setReturnCode(_tmpReturnCode);
        final Double _tmpQuantidadeCilindroVendida;
        if (_cursor.isNull(_cursorIndexOfQuantidadeCilindroVendida)) {
          _tmpQuantidadeCilindroVendida = null;
        } else {
          _tmpQuantidadeCilindroVendida = _cursor.getDouble(_cursorIndexOfQuantidadeCilindroVendida);
        }
        _item.setQuantidadeCilindroVendida(_tmpQuantidadeCilindroVendida);
        final Double _tmpQuantidadeCilindroPedida;
        if (_cursor.isNull(_cursorIndexOfQuantidadeCilindroPedida)) {
          _tmpQuantidadeCilindroPedida = null;
        } else {
          _tmpQuantidadeCilindroPedida = _cursor.getDouble(_cursorIndexOfQuantidadeCilindroPedida);
        }
        _item.setQuantidadeCilindroPedida(_tmpQuantidadeCilindroPedida);
        final String _tmpPedidoCustomer;
        _tmpPedidoCustomer = _cursor.getString(_cursorIndexOfPedidoCustomer);
        _item.setPedidoCustomer(_tmpPedidoCustomer);
        final String _tmpItemPedidoCustomer;
        _tmpItemPedidoCustomer = _cursor.getString(_cursorIndexOfItemPedidoCustomer);
        _item.setItemPedidoCustomer(_tmpItemPedidoCustomer);
        final String _tmpTipoFaturamento;
        _tmpTipoFaturamento = _cursor.getString(_cursorIndexOfTipoFaturamento);
        _item.setTipoFaturamento(_tmpTipoFaturamento);
        final String _tmpFlAssistenciaTecnica;
        _tmpFlAssistenciaTecnica = _cursor.getString(_cursorIndexOfFlAssistenciaTecnica);
        _item.setFlAssistenciaTecnica(_tmpFlAssistenciaTecnica);
        final Integer _tmpTipoItem;
        if (_cursor.isNull(_cursorIndexOfTipoItem)) {
          _tmpTipoItem = null;
        } else {
          _tmpTipoItem = _cursor.getInt(_cursorIndexOfTipoItem);
        }
        _item.setTipoItem(_tmpTipoItem);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<InvoiceItem> findByIdNota(Long idNota) {
    final String _sql = "SELECT * FROM InvoiceItem WHERE idNota = ? ORDER BY seqItem";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (idNota == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, idNota);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfIdNota = _cursor.getColumnIndexOrThrow("idNota");
      final int _cursorIndexOfNumeroNota = _cursor.getColumnIndexOrThrow("numeroNota");
      final int _cursorIndexOfSerieNota = _cursor.getColumnIndexOrThrow("serieNota");
      final int _cursorIndexOfCfop = _cursor.getColumnIndexOrThrow("cfop");
      final int _cursorIndexOfSeqItem = _cursor.getColumnIndexOrThrow("seqItem");
      final int _cursorIndexOfCdItem = _cursor.getColumnIndexOrThrow("cdItem");
      final int _cursorIndexOfCapacidade = _cursor.getColumnIndexOrThrow("capacidade");
      final int _cursorIndexOfNomeItem = _cursor.getColumnIndexOrThrow("nomeItem");
      final int _cursorIndexOfQtdItem = _cursor.getColumnIndexOrThrow("qtdItem");
      final int _cursorIndexOfVolume = _cursor.getColumnIndexOrThrow("volume");
      final int _cursorIndexOfUnidadeMedida = _cursor.getColumnIndexOrThrow("unidadeMedida");
      final int _cursorIndexOfNaturezaOperacao = _cursor.getColumnIndexOrThrow("naturezaOperacao");
      final int _cursorIndexOfNomeNaturezaOperacao = _cursor.getColumnIndexOrThrow("nomeNaturezaOperacao");
      final int _cursorIndexOfClassifFiscal = _cursor.getColumnIndexOrThrow("classifFiscal");
      final int _cursorIndexOfCstAIcms = _cursor.getColumnIndexOrThrow("cstAIcms");
      final int _cursorIndexOfCstBIcms = _cursor.getColumnIndexOrThrow("cstBIcms");
      final int _cursorIndexOfCstIpi = _cursor.getColumnIndexOrThrow("cstIpi");
      final int _cursorIndexOfCstPis = _cursor.getColumnIndexOrThrow("cstPis");
      final int _cursorIndexOfCstCofins = _cursor.getColumnIndexOrThrow("cstCofins");
      final int _cursorIndexOfValorTotal = _cursor.getColumnIndexOrThrow("valorTotal");
      final int _cursorIndexOfValorBaseIcms = _cursor.getColumnIndexOrThrow("valorBaseIcms");
      final int _cursorIndexOfValorBaseReduzidaIcms = _cursor.getColumnIndexOrThrow("valorBaseReduzidaIcms");
      final int _cursorIndexOfValorIcms = _cursor.getColumnIndexOrThrow("valorIcms");
      final int _cursorIndexOfValorDebitoIcms = _cursor.getColumnIndexOrThrow("valorDebitoIcms");
      final int _cursorIndexOfValorCreditoIcms = _cursor.getColumnIndexOrThrow("valorCreditoIcms");
      final int _cursorIndexOfValorBaseIcmsSt = _cursor.getColumnIndexOrThrow("valorBaseIcmsSt");
      final int _cursorIndexOfValorIcmsSt = _cursor.getColumnIndexOrThrow("valorIcmsSt");
      final int _cursorIndexOfValorBaseIpi = _cursor.getColumnIndexOrThrow("valorBaseIpi");
      final int _cursorIndexOfValorIpi = _cursor.getColumnIndexOrThrow("valorIpi");
      final int _cursorIndexOfValorDebitoIpi = _cursor.getColumnIndexOrThrow("valorDebitoIpi");
      final int _cursorIndexOfValorCreditoIpi = _cursor.getColumnIndexOrThrow("valorCreditoIpi");
      final int _cursorIndexOfValorBasePis = _cursor.getColumnIndexOrThrow("valorBasePis");
      final int _cursorIndexOfValorDebitoPis = _cursor.getColumnIndexOrThrow("valorDebitoPis");
      final int _cursorIndexOfValorBaseCreditoPis = _cursor.getColumnIndexOrThrow("valorBaseCreditoPis");
      final int _cursorIndexOfValorCreditoPis = _cursor.getColumnIndexOrThrow("valorCreditoPis");
      final int _cursorIndexOfValorBaseCofins = _cursor.getColumnIndexOrThrow("valorBaseCofins");
      final int _cursorIndexOfValorDebitoCofins = _cursor.getColumnIndexOrThrow("valorDebitoCofins");
      final int _cursorIndexOfValorBaseCreditoCofins = _cursor.getColumnIndexOrThrow("valorBaseCreditoCofins");
      final int _cursorIndexOfValorCreditoCofins = _cursor.getColumnIndexOrThrow("valorCreditoCofins");
      final int _cursorIndexOfAliquotaIcms = _cursor.getColumnIndexOrThrow("aliquotaIcms");
      final int _cursorIndexOfAliquotaIpi = _cursor.getColumnIndexOrThrow("aliquotaIpi");
      final int _cursorIndexOfAliquotaPis = _cursor.getColumnIndexOrThrow("aliquotaPis");
      final int _cursorIndexOfAliquotaCofins = _cursor.getColumnIndexOrThrow("aliquotaCofins");
      final int _cursorIndexOfTipoIcms = _cursor.getColumnIndexOrThrow("tipoIcms");
      final int _cursorIndexOfTipoIpi = _cursor.getColumnIndexOrThrow("tipoIpi");
      final int _cursorIndexOfTipoPis = _cursor.getColumnIndexOrThrow("tipoPis");
      final int _cursorIndexOfTipoCofins = _cursor.getColumnIndexOrThrow("tipoCofins");
      final int _cursorIndexOfValorTotalFrete = _cursor.getColumnIndexOrThrow("valorTotalFrete");
      final int _cursorIndexOfValorTotalSeguro = _cursor.getColumnIndexOrThrow("valorTotalSeguro");
      final int _cursorIndexOfValorDescontoIcms = _cursor.getColumnIndexOrThrow("valorDescontoIcms");
      final int _cursorIndexOfValorUnitario = _cursor.getColumnIndexOrThrow("valorUnitario");
      final int _cursorIndexOfValorDespesasAcessorias = _cursor.getColumnIndexOrThrow("valorDespesasAcessorias");
      final int _cursorIndexOfFlPrecoAlterado = _cursor.getColumnIndexOrThrow("flPrecoAlterado");
      final int _cursorIndexOfValorPrecoUnitarioOriginal = _cursor.getColumnIndexOrThrow("valorPrecoUnitarioOriginal");
      final int _cursorIndexOfInfCilPP = _cursor.getColumnIndexOrThrow("infCilPP");
      final int _cursorIndexOfCondicaoPagamento = _cursor.getColumnIndexOrThrow("condicaoPagamento");
      final int _cursorIndexOfCdMovimento = _cursor.getColumnIndexOrThrow("cdMovimento");
      final int _cursorIndexOfReturnType = _cursor.getColumnIndexOrThrow("returnType");
      final int _cursorIndexOfReturnCode = _cursor.getColumnIndexOrThrow("returnCode");
      final int _cursorIndexOfQuantidadeCilindroVendida = _cursor.getColumnIndexOrThrow("quantidadeCilindroVendida");
      final int _cursorIndexOfQuantidadeCilindroPedida = _cursor.getColumnIndexOrThrow("quantidadeCilindroPedida");
      final int _cursorIndexOfPedidoCustomer = _cursor.getColumnIndexOrThrow("pedidoCustomer");
      final int _cursorIndexOfItemPedidoCustomer = _cursor.getColumnIndexOrThrow("itemPedidoCustomer");
      final int _cursorIndexOfTipoFaturamento = _cursor.getColumnIndexOrThrow("tipoFaturamento");
      final int _cursorIndexOfFlAssistenciaTecnica = _cursor.getColumnIndexOrThrow("flAssistenciaTecnica");
      final int _cursorIndexOfTipoItem = _cursor.getColumnIndexOrThrow("tipoItem");
      final List<InvoiceItem> _result = new ArrayList<InvoiceItem>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final InvoiceItem _item;
        _item = new InvoiceItem();
        final Long _tmpIdNota;
        if (_cursor.isNull(_cursorIndexOfIdNota)) {
          _tmpIdNota = null;
        } else {
          _tmpIdNota = _cursor.getLong(_cursorIndexOfIdNota);
        }
        _item.setIdNota(_tmpIdNota);
        final Long _tmpNumeroNota;
        if (_cursor.isNull(_cursorIndexOfNumeroNota)) {
          _tmpNumeroNota = null;
        } else {
          _tmpNumeroNota = _cursor.getLong(_cursorIndexOfNumeroNota);
        }
        _item.setNumeroNota(_tmpNumeroNota);
        final Long _tmpSerieNota;
        if (_cursor.isNull(_cursorIndexOfSerieNota)) {
          _tmpSerieNota = null;
        } else {
          _tmpSerieNota = _cursor.getLong(_cursorIndexOfSerieNota);
        }
        _item.setSerieNota(_tmpSerieNota);
        final Integer _tmpCfop;
        if (_cursor.isNull(_cursorIndexOfCfop)) {
          _tmpCfop = null;
        } else {
          _tmpCfop = _cursor.getInt(_cursorIndexOfCfop);
        }
        _item.setCfop(_tmpCfop);
        final Long _tmpSeqItem;
        if (_cursor.isNull(_cursorIndexOfSeqItem)) {
          _tmpSeqItem = null;
        } else {
          _tmpSeqItem = _cursor.getLong(_cursorIndexOfSeqItem);
        }
        _item.setSeqItem(_tmpSeqItem);
        final Long _tmpCdItem;
        if (_cursor.isNull(_cursorIndexOfCdItem)) {
          _tmpCdItem = null;
        } else {
          _tmpCdItem = _cursor.getLong(_cursorIndexOfCdItem);
        }
        _item.setCdItem(_tmpCdItem);
        final Double _tmpCapacidade;
        if (_cursor.isNull(_cursorIndexOfCapacidade)) {
          _tmpCapacidade = null;
        } else {
          _tmpCapacidade = _cursor.getDouble(_cursorIndexOfCapacidade);
        }
        _item.setCapacidade(_tmpCapacidade);
        final String _tmpNomeItem;
        _tmpNomeItem = _cursor.getString(_cursorIndexOfNomeItem);
        _item.setNomeItem(_tmpNomeItem);
        final Double _tmpQtdItem;
        if (_cursor.isNull(_cursorIndexOfQtdItem)) {
          _tmpQtdItem = null;
        } else {
          _tmpQtdItem = _cursor.getDouble(_cursorIndexOfQtdItem);
        }
        _item.setQtdItem(_tmpQtdItem);
        final Double _tmpVolume;
        if (_cursor.isNull(_cursorIndexOfVolume)) {
          _tmpVolume = null;
        } else {
          _tmpVolume = _cursor.getDouble(_cursorIndexOfVolume);
        }
        _item.setVolume(_tmpVolume);
        final String _tmpUnidadeMedida;
        _tmpUnidadeMedida = _cursor.getString(_cursorIndexOfUnidadeMedida);
        _item.setUnidadeMedida(_tmpUnidadeMedida);
        final String _tmpNaturezaOperacao;
        _tmpNaturezaOperacao = _cursor.getString(_cursorIndexOfNaturezaOperacao);
        _item.setNaturezaOperacao(_tmpNaturezaOperacao);
        final String _tmpNomeNaturezaOperacao;
        _tmpNomeNaturezaOperacao = _cursor.getString(_cursorIndexOfNomeNaturezaOperacao);
        _item.setNomeNaturezaOperacao(_tmpNomeNaturezaOperacao);
        final Long _tmpClassifFiscal;
        if (_cursor.isNull(_cursorIndexOfClassifFiscal)) {
          _tmpClassifFiscal = null;
        } else {
          _tmpClassifFiscal = _cursor.getLong(_cursorIndexOfClassifFiscal);
        }
        _item.setClassifFiscal(_tmpClassifFiscal);
        final String _tmpCstAIcms;
        _tmpCstAIcms = _cursor.getString(_cursorIndexOfCstAIcms);
        _item.setCstAIcms(_tmpCstAIcms);
        final String _tmpCstBIcms;
        _tmpCstBIcms = _cursor.getString(_cursorIndexOfCstBIcms);
        _item.setCstBIcms(_tmpCstBIcms);
        final String _tmpCstIpi;
        _tmpCstIpi = _cursor.getString(_cursorIndexOfCstIpi);
        _item.setCstIpi(_tmpCstIpi);
        final String _tmpCstPis;
        _tmpCstPis = _cursor.getString(_cursorIndexOfCstPis);
        _item.setCstPis(_tmpCstPis);
        final String _tmpCstCofins;
        _tmpCstCofins = _cursor.getString(_cursorIndexOfCstCofins);
        _item.setCstCofins(_tmpCstCofins);
        final Double _tmpValorTotal;
        if (_cursor.isNull(_cursorIndexOfValorTotal)) {
          _tmpValorTotal = null;
        } else {
          _tmpValorTotal = _cursor.getDouble(_cursorIndexOfValorTotal);
        }
        _item.setValorTotal(_tmpValorTotal);
        final Double _tmpValorBaseIcms;
        if (_cursor.isNull(_cursorIndexOfValorBaseIcms)) {
          _tmpValorBaseIcms = null;
        } else {
          _tmpValorBaseIcms = _cursor.getDouble(_cursorIndexOfValorBaseIcms);
        }
        _item.setValorBaseIcms(_tmpValorBaseIcms);
        final Double _tmpValorBaseReduzidaIcms;
        if (_cursor.isNull(_cursorIndexOfValorBaseReduzidaIcms)) {
          _tmpValorBaseReduzidaIcms = null;
        } else {
          _tmpValorBaseReduzidaIcms = _cursor.getDouble(_cursorIndexOfValorBaseReduzidaIcms);
        }
        _item.setValorBaseReduzidaIcms(_tmpValorBaseReduzidaIcms);
        final Double _tmpValorIcms;
        if (_cursor.isNull(_cursorIndexOfValorIcms)) {
          _tmpValorIcms = null;
        } else {
          _tmpValorIcms = _cursor.getDouble(_cursorIndexOfValorIcms);
        }
        _item.setValorIcms(_tmpValorIcms);
        final Double _tmpValorDebitoIcms;
        if (_cursor.isNull(_cursorIndexOfValorDebitoIcms)) {
          _tmpValorDebitoIcms = null;
        } else {
          _tmpValorDebitoIcms = _cursor.getDouble(_cursorIndexOfValorDebitoIcms);
        }
        _item.setValorDebitoIcms(_tmpValorDebitoIcms);
        final Double _tmpValorCreditoIcms;
        if (_cursor.isNull(_cursorIndexOfValorCreditoIcms)) {
          _tmpValorCreditoIcms = null;
        } else {
          _tmpValorCreditoIcms = _cursor.getDouble(_cursorIndexOfValorCreditoIcms);
        }
        _item.setValorCreditoIcms(_tmpValorCreditoIcms);
        final Double _tmpValorBaseIcmsSt;
        if (_cursor.isNull(_cursorIndexOfValorBaseIcmsSt)) {
          _tmpValorBaseIcmsSt = null;
        } else {
          _tmpValorBaseIcmsSt = _cursor.getDouble(_cursorIndexOfValorBaseIcmsSt);
        }
        _item.setValorBaseIcmsSt(_tmpValorBaseIcmsSt);
        final Double _tmpValorIcmsSt;
        if (_cursor.isNull(_cursorIndexOfValorIcmsSt)) {
          _tmpValorIcmsSt = null;
        } else {
          _tmpValorIcmsSt = _cursor.getDouble(_cursorIndexOfValorIcmsSt);
        }
        _item.setValorIcmsSt(_tmpValorIcmsSt);
        final Double _tmpValorBaseIpi;
        if (_cursor.isNull(_cursorIndexOfValorBaseIpi)) {
          _tmpValorBaseIpi = null;
        } else {
          _tmpValorBaseIpi = _cursor.getDouble(_cursorIndexOfValorBaseIpi);
        }
        _item.setValorBaseIpi(_tmpValorBaseIpi);
        final Double _tmpValorIpi;
        if (_cursor.isNull(_cursorIndexOfValorIpi)) {
          _tmpValorIpi = null;
        } else {
          _tmpValorIpi = _cursor.getDouble(_cursorIndexOfValorIpi);
        }
        _item.setValorIpi(_tmpValorIpi);
        final Double _tmpValorDebitoIpi;
        if (_cursor.isNull(_cursorIndexOfValorDebitoIpi)) {
          _tmpValorDebitoIpi = null;
        } else {
          _tmpValorDebitoIpi = _cursor.getDouble(_cursorIndexOfValorDebitoIpi);
        }
        _item.setValorDebitoIpi(_tmpValorDebitoIpi);
        final Double _tmpValorCreditoIpi;
        if (_cursor.isNull(_cursorIndexOfValorCreditoIpi)) {
          _tmpValorCreditoIpi = null;
        } else {
          _tmpValorCreditoIpi = _cursor.getDouble(_cursorIndexOfValorCreditoIpi);
        }
        _item.setValorCreditoIpi(_tmpValorCreditoIpi);
        final Double _tmpValorBasePis;
        if (_cursor.isNull(_cursorIndexOfValorBasePis)) {
          _tmpValorBasePis = null;
        } else {
          _tmpValorBasePis = _cursor.getDouble(_cursorIndexOfValorBasePis);
        }
        _item.setValorBasePis(_tmpValorBasePis);
        final Double _tmpValorDebitoPis;
        if (_cursor.isNull(_cursorIndexOfValorDebitoPis)) {
          _tmpValorDebitoPis = null;
        } else {
          _tmpValorDebitoPis = _cursor.getDouble(_cursorIndexOfValorDebitoPis);
        }
        _item.setValorDebitoPis(_tmpValorDebitoPis);
        final Double _tmpValorBaseCreditoPis;
        if (_cursor.isNull(_cursorIndexOfValorBaseCreditoPis)) {
          _tmpValorBaseCreditoPis = null;
        } else {
          _tmpValorBaseCreditoPis = _cursor.getDouble(_cursorIndexOfValorBaseCreditoPis);
        }
        _item.setValorBaseCreditoPis(_tmpValorBaseCreditoPis);
        final Double _tmpValorCreditoPis;
        if (_cursor.isNull(_cursorIndexOfValorCreditoPis)) {
          _tmpValorCreditoPis = null;
        } else {
          _tmpValorCreditoPis = _cursor.getDouble(_cursorIndexOfValorCreditoPis);
        }
        _item.setValorCreditoPis(_tmpValorCreditoPis);
        final Double _tmpValorBaseCofins;
        if (_cursor.isNull(_cursorIndexOfValorBaseCofins)) {
          _tmpValorBaseCofins = null;
        } else {
          _tmpValorBaseCofins = _cursor.getDouble(_cursorIndexOfValorBaseCofins);
        }
        _item.setValorBaseCofins(_tmpValorBaseCofins);
        final Double _tmpValorDebitoCofins;
        if (_cursor.isNull(_cursorIndexOfValorDebitoCofins)) {
          _tmpValorDebitoCofins = null;
        } else {
          _tmpValorDebitoCofins = _cursor.getDouble(_cursorIndexOfValorDebitoCofins);
        }
        _item.setValorDebitoCofins(_tmpValorDebitoCofins);
        final Double _tmpValorBaseCreditoCofins;
        if (_cursor.isNull(_cursorIndexOfValorBaseCreditoCofins)) {
          _tmpValorBaseCreditoCofins = null;
        } else {
          _tmpValorBaseCreditoCofins = _cursor.getDouble(_cursorIndexOfValorBaseCreditoCofins);
        }
        _item.setValorBaseCreditoCofins(_tmpValorBaseCreditoCofins);
        final Double _tmpValorCreditoCofins;
        if (_cursor.isNull(_cursorIndexOfValorCreditoCofins)) {
          _tmpValorCreditoCofins = null;
        } else {
          _tmpValorCreditoCofins = _cursor.getDouble(_cursorIndexOfValorCreditoCofins);
        }
        _item.setValorCreditoCofins(_tmpValorCreditoCofins);
        final Double _tmpAliquotaIcms;
        if (_cursor.isNull(_cursorIndexOfAliquotaIcms)) {
          _tmpAliquotaIcms = null;
        } else {
          _tmpAliquotaIcms = _cursor.getDouble(_cursorIndexOfAliquotaIcms);
        }
        _item.setAliquotaIcms(_tmpAliquotaIcms);
        final Double _tmpAliquotaIpi;
        if (_cursor.isNull(_cursorIndexOfAliquotaIpi)) {
          _tmpAliquotaIpi = null;
        } else {
          _tmpAliquotaIpi = _cursor.getDouble(_cursorIndexOfAliquotaIpi);
        }
        _item.setAliquotaIpi(_tmpAliquotaIpi);
        final Double _tmpAliquotaPis;
        if (_cursor.isNull(_cursorIndexOfAliquotaPis)) {
          _tmpAliquotaPis = null;
        } else {
          _tmpAliquotaPis = _cursor.getDouble(_cursorIndexOfAliquotaPis);
        }
        _item.setAliquotaPis(_tmpAliquotaPis);
        final Double _tmpAliquotaCofins;
        if (_cursor.isNull(_cursorIndexOfAliquotaCofins)) {
          _tmpAliquotaCofins = null;
        } else {
          _tmpAliquotaCofins = _cursor.getDouble(_cursorIndexOfAliquotaCofins);
        }
        _item.setAliquotaCofins(_tmpAliquotaCofins);
        final Integer _tmpTipoIcms;
        if (_cursor.isNull(_cursorIndexOfTipoIcms)) {
          _tmpTipoIcms = null;
        } else {
          _tmpTipoIcms = _cursor.getInt(_cursorIndexOfTipoIcms);
        }
        _item.setTipoIcms(_tmpTipoIcms);
        final Integer _tmpTipoIpi;
        if (_cursor.isNull(_cursorIndexOfTipoIpi)) {
          _tmpTipoIpi = null;
        } else {
          _tmpTipoIpi = _cursor.getInt(_cursorIndexOfTipoIpi);
        }
        _item.setTipoIpi(_tmpTipoIpi);
        final Integer _tmpTipoPis;
        if (_cursor.isNull(_cursorIndexOfTipoPis)) {
          _tmpTipoPis = null;
        } else {
          _tmpTipoPis = _cursor.getInt(_cursorIndexOfTipoPis);
        }
        _item.setTipoPis(_tmpTipoPis);
        final Integer _tmpTipoCofins;
        if (_cursor.isNull(_cursorIndexOfTipoCofins)) {
          _tmpTipoCofins = null;
        } else {
          _tmpTipoCofins = _cursor.getInt(_cursorIndexOfTipoCofins);
        }
        _item.setTipoCofins(_tmpTipoCofins);
        final Double _tmpValorTotalFrete;
        if (_cursor.isNull(_cursorIndexOfValorTotalFrete)) {
          _tmpValorTotalFrete = null;
        } else {
          _tmpValorTotalFrete = _cursor.getDouble(_cursorIndexOfValorTotalFrete);
        }
        _item.setValorTotalFrete(_tmpValorTotalFrete);
        final Double _tmpValorTotalSeguro;
        if (_cursor.isNull(_cursorIndexOfValorTotalSeguro)) {
          _tmpValorTotalSeguro = null;
        } else {
          _tmpValorTotalSeguro = _cursor.getDouble(_cursorIndexOfValorTotalSeguro);
        }
        _item.setValorTotalSeguro(_tmpValorTotalSeguro);
        final Double _tmpValorDescontoIcms;
        if (_cursor.isNull(_cursorIndexOfValorDescontoIcms)) {
          _tmpValorDescontoIcms = null;
        } else {
          _tmpValorDescontoIcms = _cursor.getDouble(_cursorIndexOfValorDescontoIcms);
        }
        _item.setValorDescontoIcms(_tmpValorDescontoIcms);
        final Double _tmpValorUnitario;
        if (_cursor.isNull(_cursorIndexOfValorUnitario)) {
          _tmpValorUnitario = null;
        } else {
          _tmpValorUnitario = _cursor.getDouble(_cursorIndexOfValorUnitario);
        }
        _item.setValorUnitario(_tmpValorUnitario);
        final Double _tmpValorDespesasAcessorias;
        if (_cursor.isNull(_cursorIndexOfValorDespesasAcessorias)) {
          _tmpValorDespesasAcessorias = null;
        } else {
          _tmpValorDespesasAcessorias = _cursor.getDouble(_cursorIndexOfValorDespesasAcessorias);
        }
        _item.setValorDespesasAcessorias(_tmpValorDespesasAcessorias);
        final String _tmpFlPrecoAlterado;
        _tmpFlPrecoAlterado = _cursor.getString(_cursorIndexOfFlPrecoAlterado);
        _item.setFlPrecoAlterado(_tmpFlPrecoAlterado);
        final Double _tmpValorPrecoUnitarioOriginal;
        if (_cursor.isNull(_cursorIndexOfValorPrecoUnitarioOriginal)) {
          _tmpValorPrecoUnitarioOriginal = null;
        } else {
          _tmpValorPrecoUnitarioOriginal = _cursor.getDouble(_cursorIndexOfValorPrecoUnitarioOriginal);
        }
        _item.setValorPrecoUnitarioOriginal(_tmpValorPrecoUnitarioOriginal);
        final String _tmpInfCilPP;
        _tmpInfCilPP = _cursor.getString(_cursorIndexOfInfCilPP);
        _item.setInfCilPP(_tmpInfCilPP);
        final String _tmpCondicaoPagamento;
        _tmpCondicaoPagamento = _cursor.getString(_cursorIndexOfCondicaoPagamento);
        _item.setCondicaoPagamento(_tmpCondicaoPagamento);
        final String _tmpCdMovimento;
        _tmpCdMovimento = _cursor.getString(_cursorIndexOfCdMovimento);
        _item.setCdMovimento(_tmpCdMovimento);
        final Integer _tmpReturnType;
        if (_cursor.isNull(_cursorIndexOfReturnType)) {
          _tmpReturnType = null;
        } else {
          _tmpReturnType = _cursor.getInt(_cursorIndexOfReturnType);
        }
        _item.setReturnType(_tmpReturnType);
        final String _tmpReturnCode;
        _tmpReturnCode = _cursor.getString(_cursorIndexOfReturnCode);
        _item.setReturnCode(_tmpReturnCode);
        final Double _tmpQuantidadeCilindroVendida;
        if (_cursor.isNull(_cursorIndexOfQuantidadeCilindroVendida)) {
          _tmpQuantidadeCilindroVendida = null;
        } else {
          _tmpQuantidadeCilindroVendida = _cursor.getDouble(_cursorIndexOfQuantidadeCilindroVendida);
        }
        _item.setQuantidadeCilindroVendida(_tmpQuantidadeCilindroVendida);
        final Double _tmpQuantidadeCilindroPedida;
        if (_cursor.isNull(_cursorIndexOfQuantidadeCilindroPedida)) {
          _tmpQuantidadeCilindroPedida = null;
        } else {
          _tmpQuantidadeCilindroPedida = _cursor.getDouble(_cursorIndexOfQuantidadeCilindroPedida);
        }
        _item.setQuantidadeCilindroPedida(_tmpQuantidadeCilindroPedida);
        final String _tmpPedidoCustomer;
        _tmpPedidoCustomer = _cursor.getString(_cursorIndexOfPedidoCustomer);
        _item.setPedidoCustomer(_tmpPedidoCustomer);
        final String _tmpItemPedidoCustomer;
        _tmpItemPedidoCustomer = _cursor.getString(_cursorIndexOfItemPedidoCustomer);
        _item.setItemPedidoCustomer(_tmpItemPedidoCustomer);
        final String _tmpTipoFaturamento;
        _tmpTipoFaturamento = _cursor.getString(_cursorIndexOfTipoFaturamento);
        _item.setTipoFaturamento(_tmpTipoFaturamento);
        final String _tmpFlAssistenciaTecnica;
        _tmpFlAssistenciaTecnica = _cursor.getString(_cursorIndexOfFlAssistenciaTecnica);
        _item.setFlAssistenciaTecnica(_tmpFlAssistenciaTecnica);
        final Integer _tmpTipoItem;
        if (_cursor.isNull(_cursorIndexOfTipoItem)) {
          _tmpTipoItem = null;
        } else {
          _tmpTipoItem = _cursor.getInt(_cursorIndexOfTipoItem);
        }
        _item.setTipoItem(_tmpTipoItem);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<InvoiceItem> find(List<Integer> tipoItem) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT * FROM InvoiceItem WHERE InvoiceItem.tipoItem IN (");
    final int _inputSize = tipoItem.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ORDER BY cdItem");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (Integer _item : tipoItem) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item);
      }
      _argIndex ++;
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfIdNota = _cursor.getColumnIndexOrThrow("idNota");
      final int _cursorIndexOfNumeroNota = _cursor.getColumnIndexOrThrow("numeroNota");
      final int _cursorIndexOfSerieNota = _cursor.getColumnIndexOrThrow("serieNota");
      final int _cursorIndexOfCfop = _cursor.getColumnIndexOrThrow("cfop");
      final int _cursorIndexOfSeqItem = _cursor.getColumnIndexOrThrow("seqItem");
      final int _cursorIndexOfCdItem = _cursor.getColumnIndexOrThrow("cdItem");
      final int _cursorIndexOfCapacidade = _cursor.getColumnIndexOrThrow("capacidade");
      final int _cursorIndexOfNomeItem = _cursor.getColumnIndexOrThrow("nomeItem");
      final int _cursorIndexOfQtdItem = _cursor.getColumnIndexOrThrow("qtdItem");
      final int _cursorIndexOfVolume = _cursor.getColumnIndexOrThrow("volume");
      final int _cursorIndexOfUnidadeMedida = _cursor.getColumnIndexOrThrow("unidadeMedida");
      final int _cursorIndexOfNaturezaOperacao = _cursor.getColumnIndexOrThrow("naturezaOperacao");
      final int _cursorIndexOfNomeNaturezaOperacao = _cursor.getColumnIndexOrThrow("nomeNaturezaOperacao");
      final int _cursorIndexOfClassifFiscal = _cursor.getColumnIndexOrThrow("classifFiscal");
      final int _cursorIndexOfCstAIcms = _cursor.getColumnIndexOrThrow("cstAIcms");
      final int _cursorIndexOfCstBIcms = _cursor.getColumnIndexOrThrow("cstBIcms");
      final int _cursorIndexOfCstIpi = _cursor.getColumnIndexOrThrow("cstIpi");
      final int _cursorIndexOfCstPis = _cursor.getColumnIndexOrThrow("cstPis");
      final int _cursorIndexOfCstCofins = _cursor.getColumnIndexOrThrow("cstCofins");
      final int _cursorIndexOfValorTotal = _cursor.getColumnIndexOrThrow("valorTotal");
      final int _cursorIndexOfValorBaseIcms = _cursor.getColumnIndexOrThrow("valorBaseIcms");
      final int _cursorIndexOfValorBaseReduzidaIcms = _cursor.getColumnIndexOrThrow("valorBaseReduzidaIcms");
      final int _cursorIndexOfValorIcms = _cursor.getColumnIndexOrThrow("valorIcms");
      final int _cursorIndexOfValorDebitoIcms = _cursor.getColumnIndexOrThrow("valorDebitoIcms");
      final int _cursorIndexOfValorCreditoIcms = _cursor.getColumnIndexOrThrow("valorCreditoIcms");
      final int _cursorIndexOfValorBaseIcmsSt = _cursor.getColumnIndexOrThrow("valorBaseIcmsSt");
      final int _cursorIndexOfValorIcmsSt = _cursor.getColumnIndexOrThrow("valorIcmsSt");
      final int _cursorIndexOfValorBaseIpi = _cursor.getColumnIndexOrThrow("valorBaseIpi");
      final int _cursorIndexOfValorIpi = _cursor.getColumnIndexOrThrow("valorIpi");
      final int _cursorIndexOfValorDebitoIpi = _cursor.getColumnIndexOrThrow("valorDebitoIpi");
      final int _cursorIndexOfValorCreditoIpi = _cursor.getColumnIndexOrThrow("valorCreditoIpi");
      final int _cursorIndexOfValorBasePis = _cursor.getColumnIndexOrThrow("valorBasePis");
      final int _cursorIndexOfValorDebitoPis = _cursor.getColumnIndexOrThrow("valorDebitoPis");
      final int _cursorIndexOfValorBaseCreditoPis = _cursor.getColumnIndexOrThrow("valorBaseCreditoPis");
      final int _cursorIndexOfValorCreditoPis = _cursor.getColumnIndexOrThrow("valorCreditoPis");
      final int _cursorIndexOfValorBaseCofins = _cursor.getColumnIndexOrThrow("valorBaseCofins");
      final int _cursorIndexOfValorDebitoCofins = _cursor.getColumnIndexOrThrow("valorDebitoCofins");
      final int _cursorIndexOfValorBaseCreditoCofins = _cursor.getColumnIndexOrThrow("valorBaseCreditoCofins");
      final int _cursorIndexOfValorCreditoCofins = _cursor.getColumnIndexOrThrow("valorCreditoCofins");
      final int _cursorIndexOfAliquotaIcms = _cursor.getColumnIndexOrThrow("aliquotaIcms");
      final int _cursorIndexOfAliquotaIpi = _cursor.getColumnIndexOrThrow("aliquotaIpi");
      final int _cursorIndexOfAliquotaPis = _cursor.getColumnIndexOrThrow("aliquotaPis");
      final int _cursorIndexOfAliquotaCofins = _cursor.getColumnIndexOrThrow("aliquotaCofins");
      final int _cursorIndexOfTipoIcms = _cursor.getColumnIndexOrThrow("tipoIcms");
      final int _cursorIndexOfTipoIpi = _cursor.getColumnIndexOrThrow("tipoIpi");
      final int _cursorIndexOfTipoPis = _cursor.getColumnIndexOrThrow("tipoPis");
      final int _cursorIndexOfTipoCofins = _cursor.getColumnIndexOrThrow("tipoCofins");
      final int _cursorIndexOfValorTotalFrete = _cursor.getColumnIndexOrThrow("valorTotalFrete");
      final int _cursorIndexOfValorTotalSeguro = _cursor.getColumnIndexOrThrow("valorTotalSeguro");
      final int _cursorIndexOfValorDescontoIcms = _cursor.getColumnIndexOrThrow("valorDescontoIcms");
      final int _cursorIndexOfValorUnitario = _cursor.getColumnIndexOrThrow("valorUnitario");
      final int _cursorIndexOfValorDespesasAcessorias = _cursor.getColumnIndexOrThrow("valorDespesasAcessorias");
      final int _cursorIndexOfFlPrecoAlterado = _cursor.getColumnIndexOrThrow("flPrecoAlterado");
      final int _cursorIndexOfValorPrecoUnitarioOriginal = _cursor.getColumnIndexOrThrow("valorPrecoUnitarioOriginal");
      final int _cursorIndexOfInfCilPP = _cursor.getColumnIndexOrThrow("infCilPP");
      final int _cursorIndexOfCondicaoPagamento = _cursor.getColumnIndexOrThrow("condicaoPagamento");
      final int _cursorIndexOfCdMovimento = _cursor.getColumnIndexOrThrow("cdMovimento");
      final int _cursorIndexOfReturnType = _cursor.getColumnIndexOrThrow("returnType");
      final int _cursorIndexOfReturnCode = _cursor.getColumnIndexOrThrow("returnCode");
      final int _cursorIndexOfQuantidadeCilindroVendida = _cursor.getColumnIndexOrThrow("quantidadeCilindroVendida");
      final int _cursorIndexOfQuantidadeCilindroPedida = _cursor.getColumnIndexOrThrow("quantidadeCilindroPedida");
      final int _cursorIndexOfPedidoCustomer = _cursor.getColumnIndexOrThrow("pedidoCustomer");
      final int _cursorIndexOfItemPedidoCustomer = _cursor.getColumnIndexOrThrow("itemPedidoCustomer");
      final int _cursorIndexOfTipoFaturamento = _cursor.getColumnIndexOrThrow("tipoFaturamento");
      final int _cursorIndexOfFlAssistenciaTecnica = _cursor.getColumnIndexOrThrow("flAssistenciaTecnica");
      final int _cursorIndexOfTipoItem = _cursor.getColumnIndexOrThrow("tipoItem");
      final List<InvoiceItem> _result = new ArrayList<InvoiceItem>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final InvoiceItem _item_1;
        _item_1 = new InvoiceItem();
        final Long _tmpIdNota;
        if (_cursor.isNull(_cursorIndexOfIdNota)) {
          _tmpIdNota = null;
        } else {
          _tmpIdNota = _cursor.getLong(_cursorIndexOfIdNota);
        }
        _item_1.setIdNota(_tmpIdNota);
        final Long _tmpNumeroNota;
        if (_cursor.isNull(_cursorIndexOfNumeroNota)) {
          _tmpNumeroNota = null;
        } else {
          _tmpNumeroNota = _cursor.getLong(_cursorIndexOfNumeroNota);
        }
        _item_1.setNumeroNota(_tmpNumeroNota);
        final Long _tmpSerieNota;
        if (_cursor.isNull(_cursorIndexOfSerieNota)) {
          _tmpSerieNota = null;
        } else {
          _tmpSerieNota = _cursor.getLong(_cursorIndexOfSerieNota);
        }
        _item_1.setSerieNota(_tmpSerieNota);
        final Integer _tmpCfop;
        if (_cursor.isNull(_cursorIndexOfCfop)) {
          _tmpCfop = null;
        } else {
          _tmpCfop = _cursor.getInt(_cursorIndexOfCfop);
        }
        _item_1.setCfop(_tmpCfop);
        final Long _tmpSeqItem;
        if (_cursor.isNull(_cursorIndexOfSeqItem)) {
          _tmpSeqItem = null;
        } else {
          _tmpSeqItem = _cursor.getLong(_cursorIndexOfSeqItem);
        }
        _item_1.setSeqItem(_tmpSeqItem);
        final Long _tmpCdItem;
        if (_cursor.isNull(_cursorIndexOfCdItem)) {
          _tmpCdItem = null;
        } else {
          _tmpCdItem = _cursor.getLong(_cursorIndexOfCdItem);
        }
        _item_1.setCdItem(_tmpCdItem);
        final Double _tmpCapacidade;
        if (_cursor.isNull(_cursorIndexOfCapacidade)) {
          _tmpCapacidade = null;
        } else {
          _tmpCapacidade = _cursor.getDouble(_cursorIndexOfCapacidade);
        }
        _item_1.setCapacidade(_tmpCapacidade);
        final String _tmpNomeItem;
        _tmpNomeItem = _cursor.getString(_cursorIndexOfNomeItem);
        _item_1.setNomeItem(_tmpNomeItem);
        final Double _tmpQtdItem;
        if (_cursor.isNull(_cursorIndexOfQtdItem)) {
          _tmpQtdItem = null;
        } else {
          _tmpQtdItem = _cursor.getDouble(_cursorIndexOfQtdItem);
        }
        _item_1.setQtdItem(_tmpQtdItem);
        final Double _tmpVolume;
        if (_cursor.isNull(_cursorIndexOfVolume)) {
          _tmpVolume = null;
        } else {
          _tmpVolume = _cursor.getDouble(_cursorIndexOfVolume);
        }
        _item_1.setVolume(_tmpVolume);
        final String _tmpUnidadeMedida;
        _tmpUnidadeMedida = _cursor.getString(_cursorIndexOfUnidadeMedida);
        _item_1.setUnidadeMedida(_tmpUnidadeMedida);
        final String _tmpNaturezaOperacao;
        _tmpNaturezaOperacao = _cursor.getString(_cursorIndexOfNaturezaOperacao);
        _item_1.setNaturezaOperacao(_tmpNaturezaOperacao);
        final String _tmpNomeNaturezaOperacao;
        _tmpNomeNaturezaOperacao = _cursor.getString(_cursorIndexOfNomeNaturezaOperacao);
        _item_1.setNomeNaturezaOperacao(_tmpNomeNaturezaOperacao);
        final Long _tmpClassifFiscal;
        if (_cursor.isNull(_cursorIndexOfClassifFiscal)) {
          _tmpClassifFiscal = null;
        } else {
          _tmpClassifFiscal = _cursor.getLong(_cursorIndexOfClassifFiscal);
        }
        _item_1.setClassifFiscal(_tmpClassifFiscal);
        final String _tmpCstAIcms;
        _tmpCstAIcms = _cursor.getString(_cursorIndexOfCstAIcms);
        _item_1.setCstAIcms(_tmpCstAIcms);
        final String _tmpCstBIcms;
        _tmpCstBIcms = _cursor.getString(_cursorIndexOfCstBIcms);
        _item_1.setCstBIcms(_tmpCstBIcms);
        final String _tmpCstIpi;
        _tmpCstIpi = _cursor.getString(_cursorIndexOfCstIpi);
        _item_1.setCstIpi(_tmpCstIpi);
        final String _tmpCstPis;
        _tmpCstPis = _cursor.getString(_cursorIndexOfCstPis);
        _item_1.setCstPis(_tmpCstPis);
        final String _tmpCstCofins;
        _tmpCstCofins = _cursor.getString(_cursorIndexOfCstCofins);
        _item_1.setCstCofins(_tmpCstCofins);
        final Double _tmpValorTotal;
        if (_cursor.isNull(_cursorIndexOfValorTotal)) {
          _tmpValorTotal = null;
        } else {
          _tmpValorTotal = _cursor.getDouble(_cursorIndexOfValorTotal);
        }
        _item_1.setValorTotal(_tmpValorTotal);
        final Double _tmpValorBaseIcms;
        if (_cursor.isNull(_cursorIndexOfValorBaseIcms)) {
          _tmpValorBaseIcms = null;
        } else {
          _tmpValorBaseIcms = _cursor.getDouble(_cursorIndexOfValorBaseIcms);
        }
        _item_1.setValorBaseIcms(_tmpValorBaseIcms);
        final Double _tmpValorBaseReduzidaIcms;
        if (_cursor.isNull(_cursorIndexOfValorBaseReduzidaIcms)) {
          _tmpValorBaseReduzidaIcms = null;
        } else {
          _tmpValorBaseReduzidaIcms = _cursor.getDouble(_cursorIndexOfValorBaseReduzidaIcms);
        }
        _item_1.setValorBaseReduzidaIcms(_tmpValorBaseReduzidaIcms);
        final Double _tmpValorIcms;
        if (_cursor.isNull(_cursorIndexOfValorIcms)) {
          _tmpValorIcms = null;
        } else {
          _tmpValorIcms = _cursor.getDouble(_cursorIndexOfValorIcms);
        }
        _item_1.setValorIcms(_tmpValorIcms);
        final Double _tmpValorDebitoIcms;
        if (_cursor.isNull(_cursorIndexOfValorDebitoIcms)) {
          _tmpValorDebitoIcms = null;
        } else {
          _tmpValorDebitoIcms = _cursor.getDouble(_cursorIndexOfValorDebitoIcms);
        }
        _item_1.setValorDebitoIcms(_tmpValorDebitoIcms);
        final Double _tmpValorCreditoIcms;
        if (_cursor.isNull(_cursorIndexOfValorCreditoIcms)) {
          _tmpValorCreditoIcms = null;
        } else {
          _tmpValorCreditoIcms = _cursor.getDouble(_cursorIndexOfValorCreditoIcms);
        }
        _item_1.setValorCreditoIcms(_tmpValorCreditoIcms);
        final Double _tmpValorBaseIcmsSt;
        if (_cursor.isNull(_cursorIndexOfValorBaseIcmsSt)) {
          _tmpValorBaseIcmsSt = null;
        } else {
          _tmpValorBaseIcmsSt = _cursor.getDouble(_cursorIndexOfValorBaseIcmsSt);
        }
        _item_1.setValorBaseIcmsSt(_tmpValorBaseIcmsSt);
        final Double _tmpValorIcmsSt;
        if (_cursor.isNull(_cursorIndexOfValorIcmsSt)) {
          _tmpValorIcmsSt = null;
        } else {
          _tmpValorIcmsSt = _cursor.getDouble(_cursorIndexOfValorIcmsSt);
        }
        _item_1.setValorIcmsSt(_tmpValorIcmsSt);
        final Double _tmpValorBaseIpi;
        if (_cursor.isNull(_cursorIndexOfValorBaseIpi)) {
          _tmpValorBaseIpi = null;
        } else {
          _tmpValorBaseIpi = _cursor.getDouble(_cursorIndexOfValorBaseIpi);
        }
        _item_1.setValorBaseIpi(_tmpValorBaseIpi);
        final Double _tmpValorIpi;
        if (_cursor.isNull(_cursorIndexOfValorIpi)) {
          _tmpValorIpi = null;
        } else {
          _tmpValorIpi = _cursor.getDouble(_cursorIndexOfValorIpi);
        }
        _item_1.setValorIpi(_tmpValorIpi);
        final Double _tmpValorDebitoIpi;
        if (_cursor.isNull(_cursorIndexOfValorDebitoIpi)) {
          _tmpValorDebitoIpi = null;
        } else {
          _tmpValorDebitoIpi = _cursor.getDouble(_cursorIndexOfValorDebitoIpi);
        }
        _item_1.setValorDebitoIpi(_tmpValorDebitoIpi);
        final Double _tmpValorCreditoIpi;
        if (_cursor.isNull(_cursorIndexOfValorCreditoIpi)) {
          _tmpValorCreditoIpi = null;
        } else {
          _tmpValorCreditoIpi = _cursor.getDouble(_cursorIndexOfValorCreditoIpi);
        }
        _item_1.setValorCreditoIpi(_tmpValorCreditoIpi);
        final Double _tmpValorBasePis;
        if (_cursor.isNull(_cursorIndexOfValorBasePis)) {
          _tmpValorBasePis = null;
        } else {
          _tmpValorBasePis = _cursor.getDouble(_cursorIndexOfValorBasePis);
        }
        _item_1.setValorBasePis(_tmpValorBasePis);
        final Double _tmpValorDebitoPis;
        if (_cursor.isNull(_cursorIndexOfValorDebitoPis)) {
          _tmpValorDebitoPis = null;
        } else {
          _tmpValorDebitoPis = _cursor.getDouble(_cursorIndexOfValorDebitoPis);
        }
        _item_1.setValorDebitoPis(_tmpValorDebitoPis);
        final Double _tmpValorBaseCreditoPis;
        if (_cursor.isNull(_cursorIndexOfValorBaseCreditoPis)) {
          _tmpValorBaseCreditoPis = null;
        } else {
          _tmpValorBaseCreditoPis = _cursor.getDouble(_cursorIndexOfValorBaseCreditoPis);
        }
        _item_1.setValorBaseCreditoPis(_tmpValorBaseCreditoPis);
        final Double _tmpValorCreditoPis;
        if (_cursor.isNull(_cursorIndexOfValorCreditoPis)) {
          _tmpValorCreditoPis = null;
        } else {
          _tmpValorCreditoPis = _cursor.getDouble(_cursorIndexOfValorCreditoPis);
        }
        _item_1.setValorCreditoPis(_tmpValorCreditoPis);
        final Double _tmpValorBaseCofins;
        if (_cursor.isNull(_cursorIndexOfValorBaseCofins)) {
          _tmpValorBaseCofins = null;
        } else {
          _tmpValorBaseCofins = _cursor.getDouble(_cursorIndexOfValorBaseCofins);
        }
        _item_1.setValorBaseCofins(_tmpValorBaseCofins);
        final Double _tmpValorDebitoCofins;
        if (_cursor.isNull(_cursorIndexOfValorDebitoCofins)) {
          _tmpValorDebitoCofins = null;
        } else {
          _tmpValorDebitoCofins = _cursor.getDouble(_cursorIndexOfValorDebitoCofins);
        }
        _item_1.setValorDebitoCofins(_tmpValorDebitoCofins);
        final Double _tmpValorBaseCreditoCofins;
        if (_cursor.isNull(_cursorIndexOfValorBaseCreditoCofins)) {
          _tmpValorBaseCreditoCofins = null;
        } else {
          _tmpValorBaseCreditoCofins = _cursor.getDouble(_cursorIndexOfValorBaseCreditoCofins);
        }
        _item_1.setValorBaseCreditoCofins(_tmpValorBaseCreditoCofins);
        final Double _tmpValorCreditoCofins;
        if (_cursor.isNull(_cursorIndexOfValorCreditoCofins)) {
          _tmpValorCreditoCofins = null;
        } else {
          _tmpValorCreditoCofins = _cursor.getDouble(_cursorIndexOfValorCreditoCofins);
        }
        _item_1.setValorCreditoCofins(_tmpValorCreditoCofins);
        final Double _tmpAliquotaIcms;
        if (_cursor.isNull(_cursorIndexOfAliquotaIcms)) {
          _tmpAliquotaIcms = null;
        } else {
          _tmpAliquotaIcms = _cursor.getDouble(_cursorIndexOfAliquotaIcms);
        }
        _item_1.setAliquotaIcms(_tmpAliquotaIcms);
        final Double _tmpAliquotaIpi;
        if (_cursor.isNull(_cursorIndexOfAliquotaIpi)) {
          _tmpAliquotaIpi = null;
        } else {
          _tmpAliquotaIpi = _cursor.getDouble(_cursorIndexOfAliquotaIpi);
        }
        _item_1.setAliquotaIpi(_tmpAliquotaIpi);
        final Double _tmpAliquotaPis;
        if (_cursor.isNull(_cursorIndexOfAliquotaPis)) {
          _tmpAliquotaPis = null;
        } else {
          _tmpAliquotaPis = _cursor.getDouble(_cursorIndexOfAliquotaPis);
        }
        _item_1.setAliquotaPis(_tmpAliquotaPis);
        final Double _tmpAliquotaCofins;
        if (_cursor.isNull(_cursorIndexOfAliquotaCofins)) {
          _tmpAliquotaCofins = null;
        } else {
          _tmpAliquotaCofins = _cursor.getDouble(_cursorIndexOfAliquotaCofins);
        }
        _item_1.setAliquotaCofins(_tmpAliquotaCofins);
        final Integer _tmpTipoIcms;
        if (_cursor.isNull(_cursorIndexOfTipoIcms)) {
          _tmpTipoIcms = null;
        } else {
          _tmpTipoIcms = _cursor.getInt(_cursorIndexOfTipoIcms);
        }
        _item_1.setTipoIcms(_tmpTipoIcms);
        final Integer _tmpTipoIpi;
        if (_cursor.isNull(_cursorIndexOfTipoIpi)) {
          _tmpTipoIpi = null;
        } else {
          _tmpTipoIpi = _cursor.getInt(_cursorIndexOfTipoIpi);
        }
        _item_1.setTipoIpi(_tmpTipoIpi);
        final Integer _tmpTipoPis;
        if (_cursor.isNull(_cursorIndexOfTipoPis)) {
          _tmpTipoPis = null;
        } else {
          _tmpTipoPis = _cursor.getInt(_cursorIndexOfTipoPis);
        }
        _item_1.setTipoPis(_tmpTipoPis);
        final Integer _tmpTipoCofins;
        if (_cursor.isNull(_cursorIndexOfTipoCofins)) {
          _tmpTipoCofins = null;
        } else {
          _tmpTipoCofins = _cursor.getInt(_cursorIndexOfTipoCofins);
        }
        _item_1.setTipoCofins(_tmpTipoCofins);
        final Double _tmpValorTotalFrete;
        if (_cursor.isNull(_cursorIndexOfValorTotalFrete)) {
          _tmpValorTotalFrete = null;
        } else {
          _tmpValorTotalFrete = _cursor.getDouble(_cursorIndexOfValorTotalFrete);
        }
        _item_1.setValorTotalFrete(_tmpValorTotalFrete);
        final Double _tmpValorTotalSeguro;
        if (_cursor.isNull(_cursorIndexOfValorTotalSeguro)) {
          _tmpValorTotalSeguro = null;
        } else {
          _tmpValorTotalSeguro = _cursor.getDouble(_cursorIndexOfValorTotalSeguro);
        }
        _item_1.setValorTotalSeguro(_tmpValorTotalSeguro);
        final Double _tmpValorDescontoIcms;
        if (_cursor.isNull(_cursorIndexOfValorDescontoIcms)) {
          _tmpValorDescontoIcms = null;
        } else {
          _tmpValorDescontoIcms = _cursor.getDouble(_cursorIndexOfValorDescontoIcms);
        }
        _item_1.setValorDescontoIcms(_tmpValorDescontoIcms);
        final Double _tmpValorUnitario;
        if (_cursor.isNull(_cursorIndexOfValorUnitario)) {
          _tmpValorUnitario = null;
        } else {
          _tmpValorUnitario = _cursor.getDouble(_cursorIndexOfValorUnitario);
        }
        _item_1.setValorUnitario(_tmpValorUnitario);
        final Double _tmpValorDespesasAcessorias;
        if (_cursor.isNull(_cursorIndexOfValorDespesasAcessorias)) {
          _tmpValorDespesasAcessorias = null;
        } else {
          _tmpValorDespesasAcessorias = _cursor.getDouble(_cursorIndexOfValorDespesasAcessorias);
        }
        _item_1.setValorDespesasAcessorias(_tmpValorDespesasAcessorias);
        final String _tmpFlPrecoAlterado;
        _tmpFlPrecoAlterado = _cursor.getString(_cursorIndexOfFlPrecoAlterado);
        _item_1.setFlPrecoAlterado(_tmpFlPrecoAlterado);
        final Double _tmpValorPrecoUnitarioOriginal;
        if (_cursor.isNull(_cursorIndexOfValorPrecoUnitarioOriginal)) {
          _tmpValorPrecoUnitarioOriginal = null;
        } else {
          _tmpValorPrecoUnitarioOriginal = _cursor.getDouble(_cursorIndexOfValorPrecoUnitarioOriginal);
        }
        _item_1.setValorPrecoUnitarioOriginal(_tmpValorPrecoUnitarioOriginal);
        final String _tmpInfCilPP;
        _tmpInfCilPP = _cursor.getString(_cursorIndexOfInfCilPP);
        _item_1.setInfCilPP(_tmpInfCilPP);
        final String _tmpCondicaoPagamento;
        _tmpCondicaoPagamento = _cursor.getString(_cursorIndexOfCondicaoPagamento);
        _item_1.setCondicaoPagamento(_tmpCondicaoPagamento);
        final String _tmpCdMovimento;
        _tmpCdMovimento = _cursor.getString(_cursorIndexOfCdMovimento);
        _item_1.setCdMovimento(_tmpCdMovimento);
        final Integer _tmpReturnType;
        if (_cursor.isNull(_cursorIndexOfReturnType)) {
          _tmpReturnType = null;
        } else {
          _tmpReturnType = _cursor.getInt(_cursorIndexOfReturnType);
        }
        _item_1.setReturnType(_tmpReturnType);
        final String _tmpReturnCode;
        _tmpReturnCode = _cursor.getString(_cursorIndexOfReturnCode);
        _item_1.setReturnCode(_tmpReturnCode);
        final Double _tmpQuantidadeCilindroVendida;
        if (_cursor.isNull(_cursorIndexOfQuantidadeCilindroVendida)) {
          _tmpQuantidadeCilindroVendida = null;
        } else {
          _tmpQuantidadeCilindroVendida = _cursor.getDouble(_cursorIndexOfQuantidadeCilindroVendida);
        }
        _item_1.setQuantidadeCilindroVendida(_tmpQuantidadeCilindroVendida);
        final Double _tmpQuantidadeCilindroPedida;
        if (_cursor.isNull(_cursorIndexOfQuantidadeCilindroPedida)) {
          _tmpQuantidadeCilindroPedida = null;
        } else {
          _tmpQuantidadeCilindroPedida = _cursor.getDouble(_cursorIndexOfQuantidadeCilindroPedida);
        }
        _item_1.setQuantidadeCilindroPedida(_tmpQuantidadeCilindroPedida);
        final String _tmpPedidoCustomer;
        _tmpPedidoCustomer = _cursor.getString(_cursorIndexOfPedidoCustomer);
        _item_1.setPedidoCustomer(_tmpPedidoCustomer);
        final String _tmpItemPedidoCustomer;
        _tmpItemPedidoCustomer = _cursor.getString(_cursorIndexOfItemPedidoCustomer);
        _item_1.setItemPedidoCustomer(_tmpItemPedidoCustomer);
        final String _tmpTipoFaturamento;
        _tmpTipoFaturamento = _cursor.getString(_cursorIndexOfTipoFaturamento);
        _item_1.setTipoFaturamento(_tmpTipoFaturamento);
        final String _tmpFlAssistenciaTecnica;
        _tmpFlAssistenciaTecnica = _cursor.getString(_cursorIndexOfFlAssistenciaTecnica);
        _item_1.setFlAssistenciaTecnica(_tmpFlAssistenciaTecnica);
        final Integer _tmpTipoItem;
        if (_cursor.isNull(_cursorIndexOfTipoItem)) {
          _tmpTipoItem = null;
        } else {
          _tmpTipoItem = _cursor.getInt(_cursorIndexOfTipoItem);
        }
        _item_1.setTipoItem(_tmpTipoItem);
        _result.add(_item_1);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public InvoiceItem find(Long cdItem) {
    final String _sql = "SELECT * FROM InvoiceItem WHERE InvoiceItem.cdItem IN (?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (cdItem == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cdItem);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfIdNota = _cursor.getColumnIndexOrThrow("idNota");
      final int _cursorIndexOfNumeroNota = _cursor.getColumnIndexOrThrow("numeroNota");
      final int _cursorIndexOfSerieNota = _cursor.getColumnIndexOrThrow("serieNota");
      final int _cursorIndexOfCfop = _cursor.getColumnIndexOrThrow("cfop");
      final int _cursorIndexOfSeqItem = _cursor.getColumnIndexOrThrow("seqItem");
      final int _cursorIndexOfCdItem = _cursor.getColumnIndexOrThrow("cdItem");
      final int _cursorIndexOfCapacidade = _cursor.getColumnIndexOrThrow("capacidade");
      final int _cursorIndexOfNomeItem = _cursor.getColumnIndexOrThrow("nomeItem");
      final int _cursorIndexOfQtdItem = _cursor.getColumnIndexOrThrow("qtdItem");
      final int _cursorIndexOfVolume = _cursor.getColumnIndexOrThrow("volume");
      final int _cursorIndexOfUnidadeMedida = _cursor.getColumnIndexOrThrow("unidadeMedida");
      final int _cursorIndexOfNaturezaOperacao = _cursor.getColumnIndexOrThrow("naturezaOperacao");
      final int _cursorIndexOfNomeNaturezaOperacao = _cursor.getColumnIndexOrThrow("nomeNaturezaOperacao");
      final int _cursorIndexOfClassifFiscal = _cursor.getColumnIndexOrThrow("classifFiscal");
      final int _cursorIndexOfCstAIcms = _cursor.getColumnIndexOrThrow("cstAIcms");
      final int _cursorIndexOfCstBIcms = _cursor.getColumnIndexOrThrow("cstBIcms");
      final int _cursorIndexOfCstIpi = _cursor.getColumnIndexOrThrow("cstIpi");
      final int _cursorIndexOfCstPis = _cursor.getColumnIndexOrThrow("cstPis");
      final int _cursorIndexOfCstCofins = _cursor.getColumnIndexOrThrow("cstCofins");
      final int _cursorIndexOfValorTotal = _cursor.getColumnIndexOrThrow("valorTotal");
      final int _cursorIndexOfValorBaseIcms = _cursor.getColumnIndexOrThrow("valorBaseIcms");
      final int _cursorIndexOfValorBaseReduzidaIcms = _cursor.getColumnIndexOrThrow("valorBaseReduzidaIcms");
      final int _cursorIndexOfValorIcms = _cursor.getColumnIndexOrThrow("valorIcms");
      final int _cursorIndexOfValorDebitoIcms = _cursor.getColumnIndexOrThrow("valorDebitoIcms");
      final int _cursorIndexOfValorCreditoIcms = _cursor.getColumnIndexOrThrow("valorCreditoIcms");
      final int _cursorIndexOfValorBaseIcmsSt = _cursor.getColumnIndexOrThrow("valorBaseIcmsSt");
      final int _cursorIndexOfValorIcmsSt = _cursor.getColumnIndexOrThrow("valorIcmsSt");
      final int _cursorIndexOfValorBaseIpi = _cursor.getColumnIndexOrThrow("valorBaseIpi");
      final int _cursorIndexOfValorIpi = _cursor.getColumnIndexOrThrow("valorIpi");
      final int _cursorIndexOfValorDebitoIpi = _cursor.getColumnIndexOrThrow("valorDebitoIpi");
      final int _cursorIndexOfValorCreditoIpi = _cursor.getColumnIndexOrThrow("valorCreditoIpi");
      final int _cursorIndexOfValorBasePis = _cursor.getColumnIndexOrThrow("valorBasePis");
      final int _cursorIndexOfValorDebitoPis = _cursor.getColumnIndexOrThrow("valorDebitoPis");
      final int _cursorIndexOfValorBaseCreditoPis = _cursor.getColumnIndexOrThrow("valorBaseCreditoPis");
      final int _cursorIndexOfValorCreditoPis = _cursor.getColumnIndexOrThrow("valorCreditoPis");
      final int _cursorIndexOfValorBaseCofins = _cursor.getColumnIndexOrThrow("valorBaseCofins");
      final int _cursorIndexOfValorDebitoCofins = _cursor.getColumnIndexOrThrow("valorDebitoCofins");
      final int _cursorIndexOfValorBaseCreditoCofins = _cursor.getColumnIndexOrThrow("valorBaseCreditoCofins");
      final int _cursorIndexOfValorCreditoCofins = _cursor.getColumnIndexOrThrow("valorCreditoCofins");
      final int _cursorIndexOfAliquotaIcms = _cursor.getColumnIndexOrThrow("aliquotaIcms");
      final int _cursorIndexOfAliquotaIpi = _cursor.getColumnIndexOrThrow("aliquotaIpi");
      final int _cursorIndexOfAliquotaPis = _cursor.getColumnIndexOrThrow("aliquotaPis");
      final int _cursorIndexOfAliquotaCofins = _cursor.getColumnIndexOrThrow("aliquotaCofins");
      final int _cursorIndexOfTipoIcms = _cursor.getColumnIndexOrThrow("tipoIcms");
      final int _cursorIndexOfTipoIpi = _cursor.getColumnIndexOrThrow("tipoIpi");
      final int _cursorIndexOfTipoPis = _cursor.getColumnIndexOrThrow("tipoPis");
      final int _cursorIndexOfTipoCofins = _cursor.getColumnIndexOrThrow("tipoCofins");
      final int _cursorIndexOfValorTotalFrete = _cursor.getColumnIndexOrThrow("valorTotalFrete");
      final int _cursorIndexOfValorTotalSeguro = _cursor.getColumnIndexOrThrow("valorTotalSeguro");
      final int _cursorIndexOfValorDescontoIcms = _cursor.getColumnIndexOrThrow("valorDescontoIcms");
      final int _cursorIndexOfValorUnitario = _cursor.getColumnIndexOrThrow("valorUnitario");
      final int _cursorIndexOfValorDespesasAcessorias = _cursor.getColumnIndexOrThrow("valorDespesasAcessorias");
      final int _cursorIndexOfFlPrecoAlterado = _cursor.getColumnIndexOrThrow("flPrecoAlterado");
      final int _cursorIndexOfValorPrecoUnitarioOriginal = _cursor.getColumnIndexOrThrow("valorPrecoUnitarioOriginal");
      final int _cursorIndexOfInfCilPP = _cursor.getColumnIndexOrThrow("infCilPP");
      final int _cursorIndexOfCondicaoPagamento = _cursor.getColumnIndexOrThrow("condicaoPagamento");
      final int _cursorIndexOfCdMovimento = _cursor.getColumnIndexOrThrow("cdMovimento");
      final int _cursorIndexOfReturnType = _cursor.getColumnIndexOrThrow("returnType");
      final int _cursorIndexOfReturnCode = _cursor.getColumnIndexOrThrow("returnCode");
      final int _cursorIndexOfQuantidadeCilindroVendida = _cursor.getColumnIndexOrThrow("quantidadeCilindroVendida");
      final int _cursorIndexOfQuantidadeCilindroPedida = _cursor.getColumnIndexOrThrow("quantidadeCilindroPedida");
      final int _cursorIndexOfPedidoCustomer = _cursor.getColumnIndexOrThrow("pedidoCustomer");
      final int _cursorIndexOfItemPedidoCustomer = _cursor.getColumnIndexOrThrow("itemPedidoCustomer");
      final int _cursorIndexOfTipoFaturamento = _cursor.getColumnIndexOrThrow("tipoFaturamento");
      final int _cursorIndexOfFlAssistenciaTecnica = _cursor.getColumnIndexOrThrow("flAssistenciaTecnica");
      final int _cursorIndexOfTipoItem = _cursor.getColumnIndexOrThrow("tipoItem");
      final InvoiceItem _result;
      if(_cursor.moveToFirst()) {
        _result = new InvoiceItem();
        final Long _tmpIdNota;
        if (_cursor.isNull(_cursorIndexOfIdNota)) {
          _tmpIdNota = null;
        } else {
          _tmpIdNota = _cursor.getLong(_cursorIndexOfIdNota);
        }
        _result.setIdNota(_tmpIdNota);
        final Long _tmpNumeroNota;
        if (_cursor.isNull(_cursorIndexOfNumeroNota)) {
          _tmpNumeroNota = null;
        } else {
          _tmpNumeroNota = _cursor.getLong(_cursorIndexOfNumeroNota);
        }
        _result.setNumeroNota(_tmpNumeroNota);
        final Long _tmpSerieNota;
        if (_cursor.isNull(_cursorIndexOfSerieNota)) {
          _tmpSerieNota = null;
        } else {
          _tmpSerieNota = _cursor.getLong(_cursorIndexOfSerieNota);
        }
        _result.setSerieNota(_tmpSerieNota);
        final Integer _tmpCfop;
        if (_cursor.isNull(_cursorIndexOfCfop)) {
          _tmpCfop = null;
        } else {
          _tmpCfop = _cursor.getInt(_cursorIndexOfCfop);
        }
        _result.setCfop(_tmpCfop);
        final Long _tmpSeqItem;
        if (_cursor.isNull(_cursorIndexOfSeqItem)) {
          _tmpSeqItem = null;
        } else {
          _tmpSeqItem = _cursor.getLong(_cursorIndexOfSeqItem);
        }
        _result.setSeqItem(_tmpSeqItem);
        final Long _tmpCdItem;
        if (_cursor.isNull(_cursorIndexOfCdItem)) {
          _tmpCdItem = null;
        } else {
          _tmpCdItem = _cursor.getLong(_cursorIndexOfCdItem);
        }
        _result.setCdItem(_tmpCdItem);
        final Double _tmpCapacidade;
        if (_cursor.isNull(_cursorIndexOfCapacidade)) {
          _tmpCapacidade = null;
        } else {
          _tmpCapacidade = _cursor.getDouble(_cursorIndexOfCapacidade);
        }
        _result.setCapacidade(_tmpCapacidade);
        final String _tmpNomeItem;
        _tmpNomeItem = _cursor.getString(_cursorIndexOfNomeItem);
        _result.setNomeItem(_tmpNomeItem);
        final Double _tmpQtdItem;
        if (_cursor.isNull(_cursorIndexOfQtdItem)) {
          _tmpQtdItem = null;
        } else {
          _tmpQtdItem = _cursor.getDouble(_cursorIndexOfQtdItem);
        }
        _result.setQtdItem(_tmpQtdItem);
        final Double _tmpVolume;
        if (_cursor.isNull(_cursorIndexOfVolume)) {
          _tmpVolume = null;
        } else {
          _tmpVolume = _cursor.getDouble(_cursorIndexOfVolume);
        }
        _result.setVolume(_tmpVolume);
        final String _tmpUnidadeMedida;
        _tmpUnidadeMedida = _cursor.getString(_cursorIndexOfUnidadeMedida);
        _result.setUnidadeMedida(_tmpUnidadeMedida);
        final String _tmpNaturezaOperacao;
        _tmpNaturezaOperacao = _cursor.getString(_cursorIndexOfNaturezaOperacao);
        _result.setNaturezaOperacao(_tmpNaturezaOperacao);
        final String _tmpNomeNaturezaOperacao;
        _tmpNomeNaturezaOperacao = _cursor.getString(_cursorIndexOfNomeNaturezaOperacao);
        _result.setNomeNaturezaOperacao(_tmpNomeNaturezaOperacao);
        final Long _tmpClassifFiscal;
        if (_cursor.isNull(_cursorIndexOfClassifFiscal)) {
          _tmpClassifFiscal = null;
        } else {
          _tmpClassifFiscal = _cursor.getLong(_cursorIndexOfClassifFiscal);
        }
        _result.setClassifFiscal(_tmpClassifFiscal);
        final String _tmpCstAIcms;
        _tmpCstAIcms = _cursor.getString(_cursorIndexOfCstAIcms);
        _result.setCstAIcms(_tmpCstAIcms);
        final String _tmpCstBIcms;
        _tmpCstBIcms = _cursor.getString(_cursorIndexOfCstBIcms);
        _result.setCstBIcms(_tmpCstBIcms);
        final String _tmpCstIpi;
        _tmpCstIpi = _cursor.getString(_cursorIndexOfCstIpi);
        _result.setCstIpi(_tmpCstIpi);
        final String _tmpCstPis;
        _tmpCstPis = _cursor.getString(_cursorIndexOfCstPis);
        _result.setCstPis(_tmpCstPis);
        final String _tmpCstCofins;
        _tmpCstCofins = _cursor.getString(_cursorIndexOfCstCofins);
        _result.setCstCofins(_tmpCstCofins);
        final Double _tmpValorTotal;
        if (_cursor.isNull(_cursorIndexOfValorTotal)) {
          _tmpValorTotal = null;
        } else {
          _tmpValorTotal = _cursor.getDouble(_cursorIndexOfValorTotal);
        }
        _result.setValorTotal(_tmpValorTotal);
        final Double _tmpValorBaseIcms;
        if (_cursor.isNull(_cursorIndexOfValorBaseIcms)) {
          _tmpValorBaseIcms = null;
        } else {
          _tmpValorBaseIcms = _cursor.getDouble(_cursorIndexOfValorBaseIcms);
        }
        _result.setValorBaseIcms(_tmpValorBaseIcms);
        final Double _tmpValorBaseReduzidaIcms;
        if (_cursor.isNull(_cursorIndexOfValorBaseReduzidaIcms)) {
          _tmpValorBaseReduzidaIcms = null;
        } else {
          _tmpValorBaseReduzidaIcms = _cursor.getDouble(_cursorIndexOfValorBaseReduzidaIcms);
        }
        _result.setValorBaseReduzidaIcms(_tmpValorBaseReduzidaIcms);
        final Double _tmpValorIcms;
        if (_cursor.isNull(_cursorIndexOfValorIcms)) {
          _tmpValorIcms = null;
        } else {
          _tmpValorIcms = _cursor.getDouble(_cursorIndexOfValorIcms);
        }
        _result.setValorIcms(_tmpValorIcms);
        final Double _tmpValorDebitoIcms;
        if (_cursor.isNull(_cursorIndexOfValorDebitoIcms)) {
          _tmpValorDebitoIcms = null;
        } else {
          _tmpValorDebitoIcms = _cursor.getDouble(_cursorIndexOfValorDebitoIcms);
        }
        _result.setValorDebitoIcms(_tmpValorDebitoIcms);
        final Double _tmpValorCreditoIcms;
        if (_cursor.isNull(_cursorIndexOfValorCreditoIcms)) {
          _tmpValorCreditoIcms = null;
        } else {
          _tmpValorCreditoIcms = _cursor.getDouble(_cursorIndexOfValorCreditoIcms);
        }
        _result.setValorCreditoIcms(_tmpValorCreditoIcms);
        final Double _tmpValorBaseIcmsSt;
        if (_cursor.isNull(_cursorIndexOfValorBaseIcmsSt)) {
          _tmpValorBaseIcmsSt = null;
        } else {
          _tmpValorBaseIcmsSt = _cursor.getDouble(_cursorIndexOfValorBaseIcmsSt);
        }
        _result.setValorBaseIcmsSt(_tmpValorBaseIcmsSt);
        final Double _tmpValorIcmsSt;
        if (_cursor.isNull(_cursorIndexOfValorIcmsSt)) {
          _tmpValorIcmsSt = null;
        } else {
          _tmpValorIcmsSt = _cursor.getDouble(_cursorIndexOfValorIcmsSt);
        }
        _result.setValorIcmsSt(_tmpValorIcmsSt);
        final Double _tmpValorBaseIpi;
        if (_cursor.isNull(_cursorIndexOfValorBaseIpi)) {
          _tmpValorBaseIpi = null;
        } else {
          _tmpValorBaseIpi = _cursor.getDouble(_cursorIndexOfValorBaseIpi);
        }
        _result.setValorBaseIpi(_tmpValorBaseIpi);
        final Double _tmpValorIpi;
        if (_cursor.isNull(_cursorIndexOfValorIpi)) {
          _tmpValorIpi = null;
        } else {
          _tmpValorIpi = _cursor.getDouble(_cursorIndexOfValorIpi);
        }
        _result.setValorIpi(_tmpValorIpi);
        final Double _tmpValorDebitoIpi;
        if (_cursor.isNull(_cursorIndexOfValorDebitoIpi)) {
          _tmpValorDebitoIpi = null;
        } else {
          _tmpValorDebitoIpi = _cursor.getDouble(_cursorIndexOfValorDebitoIpi);
        }
        _result.setValorDebitoIpi(_tmpValorDebitoIpi);
        final Double _tmpValorCreditoIpi;
        if (_cursor.isNull(_cursorIndexOfValorCreditoIpi)) {
          _tmpValorCreditoIpi = null;
        } else {
          _tmpValorCreditoIpi = _cursor.getDouble(_cursorIndexOfValorCreditoIpi);
        }
        _result.setValorCreditoIpi(_tmpValorCreditoIpi);
        final Double _tmpValorBasePis;
        if (_cursor.isNull(_cursorIndexOfValorBasePis)) {
          _tmpValorBasePis = null;
        } else {
          _tmpValorBasePis = _cursor.getDouble(_cursorIndexOfValorBasePis);
        }
        _result.setValorBasePis(_tmpValorBasePis);
        final Double _tmpValorDebitoPis;
        if (_cursor.isNull(_cursorIndexOfValorDebitoPis)) {
          _tmpValorDebitoPis = null;
        } else {
          _tmpValorDebitoPis = _cursor.getDouble(_cursorIndexOfValorDebitoPis);
        }
        _result.setValorDebitoPis(_tmpValorDebitoPis);
        final Double _tmpValorBaseCreditoPis;
        if (_cursor.isNull(_cursorIndexOfValorBaseCreditoPis)) {
          _tmpValorBaseCreditoPis = null;
        } else {
          _tmpValorBaseCreditoPis = _cursor.getDouble(_cursorIndexOfValorBaseCreditoPis);
        }
        _result.setValorBaseCreditoPis(_tmpValorBaseCreditoPis);
        final Double _tmpValorCreditoPis;
        if (_cursor.isNull(_cursorIndexOfValorCreditoPis)) {
          _tmpValorCreditoPis = null;
        } else {
          _tmpValorCreditoPis = _cursor.getDouble(_cursorIndexOfValorCreditoPis);
        }
        _result.setValorCreditoPis(_tmpValorCreditoPis);
        final Double _tmpValorBaseCofins;
        if (_cursor.isNull(_cursorIndexOfValorBaseCofins)) {
          _tmpValorBaseCofins = null;
        } else {
          _tmpValorBaseCofins = _cursor.getDouble(_cursorIndexOfValorBaseCofins);
        }
        _result.setValorBaseCofins(_tmpValorBaseCofins);
        final Double _tmpValorDebitoCofins;
        if (_cursor.isNull(_cursorIndexOfValorDebitoCofins)) {
          _tmpValorDebitoCofins = null;
        } else {
          _tmpValorDebitoCofins = _cursor.getDouble(_cursorIndexOfValorDebitoCofins);
        }
        _result.setValorDebitoCofins(_tmpValorDebitoCofins);
        final Double _tmpValorBaseCreditoCofins;
        if (_cursor.isNull(_cursorIndexOfValorBaseCreditoCofins)) {
          _tmpValorBaseCreditoCofins = null;
        } else {
          _tmpValorBaseCreditoCofins = _cursor.getDouble(_cursorIndexOfValorBaseCreditoCofins);
        }
        _result.setValorBaseCreditoCofins(_tmpValorBaseCreditoCofins);
        final Double _tmpValorCreditoCofins;
        if (_cursor.isNull(_cursorIndexOfValorCreditoCofins)) {
          _tmpValorCreditoCofins = null;
        } else {
          _tmpValorCreditoCofins = _cursor.getDouble(_cursorIndexOfValorCreditoCofins);
        }
        _result.setValorCreditoCofins(_tmpValorCreditoCofins);
        final Double _tmpAliquotaIcms;
        if (_cursor.isNull(_cursorIndexOfAliquotaIcms)) {
          _tmpAliquotaIcms = null;
        } else {
          _tmpAliquotaIcms = _cursor.getDouble(_cursorIndexOfAliquotaIcms);
        }
        _result.setAliquotaIcms(_tmpAliquotaIcms);
        final Double _tmpAliquotaIpi;
        if (_cursor.isNull(_cursorIndexOfAliquotaIpi)) {
          _tmpAliquotaIpi = null;
        } else {
          _tmpAliquotaIpi = _cursor.getDouble(_cursorIndexOfAliquotaIpi);
        }
        _result.setAliquotaIpi(_tmpAliquotaIpi);
        final Double _tmpAliquotaPis;
        if (_cursor.isNull(_cursorIndexOfAliquotaPis)) {
          _tmpAliquotaPis = null;
        } else {
          _tmpAliquotaPis = _cursor.getDouble(_cursorIndexOfAliquotaPis);
        }
        _result.setAliquotaPis(_tmpAliquotaPis);
        final Double _tmpAliquotaCofins;
        if (_cursor.isNull(_cursorIndexOfAliquotaCofins)) {
          _tmpAliquotaCofins = null;
        } else {
          _tmpAliquotaCofins = _cursor.getDouble(_cursorIndexOfAliquotaCofins);
        }
        _result.setAliquotaCofins(_tmpAliquotaCofins);
        final Integer _tmpTipoIcms;
        if (_cursor.isNull(_cursorIndexOfTipoIcms)) {
          _tmpTipoIcms = null;
        } else {
          _tmpTipoIcms = _cursor.getInt(_cursorIndexOfTipoIcms);
        }
        _result.setTipoIcms(_tmpTipoIcms);
        final Integer _tmpTipoIpi;
        if (_cursor.isNull(_cursorIndexOfTipoIpi)) {
          _tmpTipoIpi = null;
        } else {
          _tmpTipoIpi = _cursor.getInt(_cursorIndexOfTipoIpi);
        }
        _result.setTipoIpi(_tmpTipoIpi);
        final Integer _tmpTipoPis;
        if (_cursor.isNull(_cursorIndexOfTipoPis)) {
          _tmpTipoPis = null;
        } else {
          _tmpTipoPis = _cursor.getInt(_cursorIndexOfTipoPis);
        }
        _result.setTipoPis(_tmpTipoPis);
        final Integer _tmpTipoCofins;
        if (_cursor.isNull(_cursorIndexOfTipoCofins)) {
          _tmpTipoCofins = null;
        } else {
          _tmpTipoCofins = _cursor.getInt(_cursorIndexOfTipoCofins);
        }
        _result.setTipoCofins(_tmpTipoCofins);
        final Double _tmpValorTotalFrete;
        if (_cursor.isNull(_cursorIndexOfValorTotalFrete)) {
          _tmpValorTotalFrete = null;
        } else {
          _tmpValorTotalFrete = _cursor.getDouble(_cursorIndexOfValorTotalFrete);
        }
        _result.setValorTotalFrete(_tmpValorTotalFrete);
        final Double _tmpValorTotalSeguro;
        if (_cursor.isNull(_cursorIndexOfValorTotalSeguro)) {
          _tmpValorTotalSeguro = null;
        } else {
          _tmpValorTotalSeguro = _cursor.getDouble(_cursorIndexOfValorTotalSeguro);
        }
        _result.setValorTotalSeguro(_tmpValorTotalSeguro);
        final Double _tmpValorDescontoIcms;
        if (_cursor.isNull(_cursorIndexOfValorDescontoIcms)) {
          _tmpValorDescontoIcms = null;
        } else {
          _tmpValorDescontoIcms = _cursor.getDouble(_cursorIndexOfValorDescontoIcms);
        }
        _result.setValorDescontoIcms(_tmpValorDescontoIcms);
        final Double _tmpValorUnitario;
        if (_cursor.isNull(_cursorIndexOfValorUnitario)) {
          _tmpValorUnitario = null;
        } else {
          _tmpValorUnitario = _cursor.getDouble(_cursorIndexOfValorUnitario);
        }
        _result.setValorUnitario(_tmpValorUnitario);
        final Double _tmpValorDespesasAcessorias;
        if (_cursor.isNull(_cursorIndexOfValorDespesasAcessorias)) {
          _tmpValorDespesasAcessorias = null;
        } else {
          _tmpValorDespesasAcessorias = _cursor.getDouble(_cursorIndexOfValorDespesasAcessorias);
        }
        _result.setValorDespesasAcessorias(_tmpValorDespesasAcessorias);
        final String _tmpFlPrecoAlterado;
        _tmpFlPrecoAlterado = _cursor.getString(_cursorIndexOfFlPrecoAlterado);
        _result.setFlPrecoAlterado(_tmpFlPrecoAlterado);
        final Double _tmpValorPrecoUnitarioOriginal;
        if (_cursor.isNull(_cursorIndexOfValorPrecoUnitarioOriginal)) {
          _tmpValorPrecoUnitarioOriginal = null;
        } else {
          _tmpValorPrecoUnitarioOriginal = _cursor.getDouble(_cursorIndexOfValorPrecoUnitarioOriginal);
        }
        _result.setValorPrecoUnitarioOriginal(_tmpValorPrecoUnitarioOriginal);
        final String _tmpInfCilPP;
        _tmpInfCilPP = _cursor.getString(_cursorIndexOfInfCilPP);
        _result.setInfCilPP(_tmpInfCilPP);
        final String _tmpCondicaoPagamento;
        _tmpCondicaoPagamento = _cursor.getString(_cursorIndexOfCondicaoPagamento);
        _result.setCondicaoPagamento(_tmpCondicaoPagamento);
        final String _tmpCdMovimento;
        _tmpCdMovimento = _cursor.getString(_cursorIndexOfCdMovimento);
        _result.setCdMovimento(_tmpCdMovimento);
        final Integer _tmpReturnType;
        if (_cursor.isNull(_cursorIndexOfReturnType)) {
          _tmpReturnType = null;
        } else {
          _tmpReturnType = _cursor.getInt(_cursorIndexOfReturnType);
        }
        _result.setReturnType(_tmpReturnType);
        final String _tmpReturnCode;
        _tmpReturnCode = _cursor.getString(_cursorIndexOfReturnCode);
        _result.setReturnCode(_tmpReturnCode);
        final Double _tmpQuantidadeCilindroVendida;
        if (_cursor.isNull(_cursorIndexOfQuantidadeCilindroVendida)) {
          _tmpQuantidadeCilindroVendida = null;
        } else {
          _tmpQuantidadeCilindroVendida = _cursor.getDouble(_cursorIndexOfQuantidadeCilindroVendida);
        }
        _result.setQuantidadeCilindroVendida(_tmpQuantidadeCilindroVendida);
        final Double _tmpQuantidadeCilindroPedida;
        if (_cursor.isNull(_cursorIndexOfQuantidadeCilindroPedida)) {
          _tmpQuantidadeCilindroPedida = null;
        } else {
          _tmpQuantidadeCilindroPedida = _cursor.getDouble(_cursorIndexOfQuantidadeCilindroPedida);
        }
        _result.setQuantidadeCilindroPedida(_tmpQuantidadeCilindroPedida);
        final String _tmpPedidoCustomer;
        _tmpPedidoCustomer = _cursor.getString(_cursorIndexOfPedidoCustomer);
        _result.setPedidoCustomer(_tmpPedidoCustomer);
        final String _tmpItemPedidoCustomer;
        _tmpItemPedidoCustomer = _cursor.getString(_cursorIndexOfItemPedidoCustomer);
        _result.setItemPedidoCustomer(_tmpItemPedidoCustomer);
        final String _tmpTipoFaturamento;
        _tmpTipoFaturamento = _cursor.getString(_cursorIndexOfTipoFaturamento);
        _result.setTipoFaturamento(_tmpTipoFaturamento);
        final String _tmpFlAssistenciaTecnica;
        _tmpFlAssistenciaTecnica = _cursor.getString(_cursorIndexOfFlAssistenciaTecnica);
        _result.setFlAssistenciaTecnica(_tmpFlAssistenciaTecnica);
        final Integer _tmpTipoItem;
        if (_cursor.isNull(_cursorIndexOfTipoItem)) {
          _tmpTipoItem = null;
        } else {
          _tmpTipoItem = _cursor.getInt(_cursorIndexOfTipoItem);
        }
        _result.setTipoItem(_tmpTipoItem);
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
