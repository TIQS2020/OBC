package br.com.whitemartins.obc.dao;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.util.StringUtil;
import android.database.Cursor;
import br.com.whitemartins.obc.model.Item;
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
public class ItemDao_Impl implements ItemDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfItem;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfItem;

  public ItemDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfItem = new EntityInsertionAdapter<Item>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Item`(`cdItem`,`capacidadeProduto`,`cdCilindro`,`capacidadeCilindro`,`indCapacVariavel`,`indRecursivoLastro`,`descricaoCilindro`,`descricaoProduto`,`qtdCilindroCheios`,`qtdCilindroVazios`,`fatorConversao`,`estruturaProducao`,`percode`,`custoTransferencia`,`tax1`,`tax2`,`tax3`,`indRastreavel`,`indLiquido`,`valorIndenizacao`,`cstGas`,`cstCilindro`,`unidadeMedida`,`indLiqGas`,`indRequerFator`,`fatorPcs`,`pcsRegistrado`,`classeNcmCilindro`,`pesoCilindro`,`pesoLiqUnitario`,`classeNcmGas`,`tipoPropriedade`,`recursivFrete`,`tipoPressao`,`indRastreabilidade`,`tipoItem`,`indFatorConvPolegadas`,`indProducao`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Item value) {
        if (value.getCdItem() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getCdItem());
        }
        if (value.getCapacidadeProduto() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindDouble(2, value.getCapacidadeProduto());
        }
        if (value.getCdCilindro() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getCdCilindro());
        }
        if (value.getCapacidadeCilindro() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindDouble(4, value.getCapacidadeCilindro());
        }
        if (value.getIndCapacVariavel() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getIndCapacVariavel());
        }
        if (value.getIndRecursivoLastro() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getIndRecursivoLastro());
        }
        if (value.getDescricaoCilindro() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getDescricaoCilindro());
        }
        if (value.getDescricaoProduto() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getDescricaoProduto());
        }
        if (value.getQtdCilindroCheios() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindDouble(9, value.getQtdCilindroCheios());
        }
        if (value.getQtdCilindroVazios() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindDouble(10, value.getQtdCilindroVazios());
        }
        if (value.getFatorConversao() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindDouble(11, value.getFatorConversao());
        }
        if (value.getEstruturaProducao() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getEstruturaProducao());
        }
        if (value.getPercode() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindLong(13, value.getPercode());
        }
        if (value.getCustoTransferencia() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindDouble(14, value.getCustoTransferencia());
        }
        if (value.getTax1() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getTax1());
        }
        if (value.getTax2() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getTax2());
        }
        if (value.getTax3() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getTax3());
        }
        if (value.getIndRastreavel() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getIndRastreavel());
        }
        if (value.getIndLiquido() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getIndLiquido());
        }
        if (value.getValorIndenizacao() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindDouble(20, value.getValorIndenizacao());
        }
        if (value.getCstGas() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getCstGas());
        }
        if (value.getCstCilindro() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.getCstCilindro());
        }
        if (value.getUnidadeMedida() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindString(23, value.getUnidadeMedida());
        }
        if (value.getIndLiqGas() == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindString(24, value.getIndLiqGas());
        }
        if (value.getIndRequerFator() == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindLong(25, value.getIndRequerFator());
        }
        if (value.getFatorPcs() == null) {
          stmt.bindNull(26);
        } else {
          stmt.bindDouble(26, value.getFatorPcs());
        }
        if (value.getPcsRegistrado() == null) {
          stmt.bindNull(27);
        } else {
          stmt.bindString(27, value.getPcsRegistrado());
        }
        if (value.getClasseNcmCilindro() == null) {
          stmt.bindNull(28);
        } else {
          stmt.bindLong(28, value.getClasseNcmCilindro());
        }
        if (value.getPesoCilindro() == null) {
          stmt.bindNull(29);
        } else {
          stmt.bindDouble(29, value.getPesoCilindro());
        }
        if (value.getPesoLiqUnitario() == null) {
          stmt.bindNull(30);
        } else {
          stmt.bindDouble(30, value.getPesoLiqUnitario());
        }
        if (value.getClasseNcmGas() == null) {
          stmt.bindNull(31);
        } else {
          stmt.bindLong(31, value.getClasseNcmGas());
        }
        if (value.getTipoPropriedade() == null) {
          stmt.bindNull(32);
        } else {
          stmt.bindString(32, value.getTipoPropriedade());
        }
        if (value.getRecursivFrete() == null) {
          stmt.bindNull(33);
        } else {
          stmt.bindString(33, value.getRecursivFrete());
        }
        if (value.getTipoPressao() == null) {
          stmt.bindNull(34);
        } else {
          stmt.bindLong(34, value.getTipoPressao());
        }
        if (value.getIndRastreabilidade() == null) {
          stmt.bindNull(35);
        } else {
          stmt.bindString(35, value.getIndRastreabilidade());
        }
        if (value.getTipoItem() == null) {
          stmt.bindNull(36);
        } else {
          stmt.bindLong(36, value.getTipoItem());
        }
        if (value.getIndFatorConvPolegadas() == null) {
          stmt.bindNull(37);
        } else {
          stmt.bindString(37, value.getIndFatorConvPolegadas());
        }
        if (value.getIndProducao() == null) {
          stmt.bindNull(38);
        } else {
          stmt.bindString(38, value.getIndProducao());
        }
      }
    };
    this.__deletionAdapterOfItem = new EntityDeletionOrUpdateAdapter<Item>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Item` WHERE `cdItem` = ? AND `capacidadeProduto` = ? AND `cdCilindro` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Item value) {
        if (value.getCdItem() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getCdItem());
        }
        if (value.getCapacidadeProduto() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindDouble(2, value.getCapacidadeProduto());
        }
        if (value.getCdCilindro() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getCdCilindro());
        }
      }
    };
  }

  @Override
  public void insertAll(Item... items) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfItem.insert(items);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insert(Item item) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfItem.insert(item);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(Item item) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfItem.handle(item);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll(List<Item> items) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfItem.handleMultiple(items);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Item> getAll() {
    final String _sql = "SELECT * FROM Item";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCdItem = _cursor.getColumnIndexOrThrow("cdItem");
      final int _cursorIndexOfCapacidadeProduto = _cursor.getColumnIndexOrThrow("capacidadeProduto");
      final int _cursorIndexOfCdCilindro = _cursor.getColumnIndexOrThrow("cdCilindro");
      final int _cursorIndexOfCapacidadeCilindro = _cursor.getColumnIndexOrThrow("capacidadeCilindro");
      final int _cursorIndexOfIndCapacVariavel = _cursor.getColumnIndexOrThrow("indCapacVariavel");
      final int _cursorIndexOfIndRecursivoLastro = _cursor.getColumnIndexOrThrow("indRecursivoLastro");
      final int _cursorIndexOfDescricaoCilindro = _cursor.getColumnIndexOrThrow("descricaoCilindro");
      final int _cursorIndexOfDescricaoProduto = _cursor.getColumnIndexOrThrow("descricaoProduto");
      final int _cursorIndexOfQtdCilindroCheios = _cursor.getColumnIndexOrThrow("qtdCilindroCheios");
      final int _cursorIndexOfQtdCilindroVazios = _cursor.getColumnIndexOrThrow("qtdCilindroVazios");
      final int _cursorIndexOfFatorConversao = _cursor.getColumnIndexOrThrow("fatorConversao");
      final int _cursorIndexOfEstruturaProducao = _cursor.getColumnIndexOrThrow("estruturaProducao");
      final int _cursorIndexOfPercode = _cursor.getColumnIndexOrThrow("percode");
      final int _cursorIndexOfCustoTransferencia = _cursor.getColumnIndexOrThrow("custoTransferencia");
      final int _cursorIndexOfTax1 = _cursor.getColumnIndexOrThrow("tax1");
      final int _cursorIndexOfTax2 = _cursor.getColumnIndexOrThrow("tax2");
      final int _cursorIndexOfTax3 = _cursor.getColumnIndexOrThrow("tax3");
      final int _cursorIndexOfIndRastreavel = _cursor.getColumnIndexOrThrow("indRastreavel");
      final int _cursorIndexOfIndLiquido = _cursor.getColumnIndexOrThrow("indLiquido");
      final int _cursorIndexOfValorIndenizacao = _cursor.getColumnIndexOrThrow("valorIndenizacao");
      final int _cursorIndexOfCstGas = _cursor.getColumnIndexOrThrow("cstGas");
      final int _cursorIndexOfCstCilindro = _cursor.getColumnIndexOrThrow("cstCilindro");
      final int _cursorIndexOfUnidadeMedida = _cursor.getColumnIndexOrThrow("unidadeMedida");
      final int _cursorIndexOfIndLiqGas = _cursor.getColumnIndexOrThrow("indLiqGas");
      final int _cursorIndexOfIndRequerFator = _cursor.getColumnIndexOrThrow("indRequerFator");
      final int _cursorIndexOfFatorPcs = _cursor.getColumnIndexOrThrow("fatorPcs");
      final int _cursorIndexOfPcsRegistrado = _cursor.getColumnIndexOrThrow("pcsRegistrado");
      final int _cursorIndexOfClasseNcmCilindro = _cursor.getColumnIndexOrThrow("classeNcmCilindro");
      final int _cursorIndexOfPesoCilindro = _cursor.getColumnIndexOrThrow("pesoCilindro");
      final int _cursorIndexOfPesoLiqUnitario = _cursor.getColumnIndexOrThrow("pesoLiqUnitario");
      final int _cursorIndexOfClasseNcmGas = _cursor.getColumnIndexOrThrow("classeNcmGas");
      final int _cursorIndexOfTipoPropriedade = _cursor.getColumnIndexOrThrow("tipoPropriedade");
      final int _cursorIndexOfRecursivFrete = _cursor.getColumnIndexOrThrow("recursivFrete");
      final int _cursorIndexOfTipoPressao = _cursor.getColumnIndexOrThrow("tipoPressao");
      final int _cursorIndexOfIndRastreabilidade = _cursor.getColumnIndexOrThrow("indRastreabilidade");
      final int _cursorIndexOfTipoItem = _cursor.getColumnIndexOrThrow("tipoItem");
      final int _cursorIndexOfIndFatorConvPolegadas = _cursor.getColumnIndexOrThrow("indFatorConvPolegadas");
      final int _cursorIndexOfIndProducao = _cursor.getColumnIndexOrThrow("indProducao");
      final List<Item> _result = new ArrayList<Item>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Item _item;
        _item = new Item();
        final Long _tmpCdItem;
        if (_cursor.isNull(_cursorIndexOfCdItem)) {
          _tmpCdItem = null;
        } else {
          _tmpCdItem = _cursor.getLong(_cursorIndexOfCdItem);
        }
        _item.setCdItem(_tmpCdItem);
        final Double _tmpCapacidadeProduto;
        if (_cursor.isNull(_cursorIndexOfCapacidadeProduto)) {
          _tmpCapacidadeProduto = null;
        } else {
          _tmpCapacidadeProduto = _cursor.getDouble(_cursorIndexOfCapacidadeProduto);
        }
        _item.setCapacidadeProduto(_tmpCapacidadeProduto);
        final Long _tmpCdCilindro;
        if (_cursor.isNull(_cursorIndexOfCdCilindro)) {
          _tmpCdCilindro = null;
        } else {
          _tmpCdCilindro = _cursor.getLong(_cursorIndexOfCdCilindro);
        }
        _item.setCdCilindro(_tmpCdCilindro);
        final Double _tmpCapacidadeCilindro;
        if (_cursor.isNull(_cursorIndexOfCapacidadeCilindro)) {
          _tmpCapacidadeCilindro = null;
        } else {
          _tmpCapacidadeCilindro = _cursor.getDouble(_cursorIndexOfCapacidadeCilindro);
        }
        _item.setCapacidadeCilindro(_tmpCapacidadeCilindro);
        final String _tmpIndCapacVariavel;
        _tmpIndCapacVariavel = _cursor.getString(_cursorIndexOfIndCapacVariavel);
        _item.setIndCapacVariavel(_tmpIndCapacVariavel);
        final String _tmpIndRecursivoLastro;
        _tmpIndRecursivoLastro = _cursor.getString(_cursorIndexOfIndRecursivoLastro);
        _item.setIndRecursivoLastro(_tmpIndRecursivoLastro);
        final String _tmpDescricaoCilindro;
        _tmpDescricaoCilindro = _cursor.getString(_cursorIndexOfDescricaoCilindro);
        _item.setDescricaoCilindro(_tmpDescricaoCilindro);
        final String _tmpDescricaoProduto;
        _tmpDescricaoProduto = _cursor.getString(_cursorIndexOfDescricaoProduto);
        _item.setDescricaoProduto(_tmpDescricaoProduto);
        final Double _tmpQtdCilindroCheios;
        if (_cursor.isNull(_cursorIndexOfQtdCilindroCheios)) {
          _tmpQtdCilindroCheios = null;
        } else {
          _tmpQtdCilindroCheios = _cursor.getDouble(_cursorIndexOfQtdCilindroCheios);
        }
        _item.setQtdCilindroCheios(_tmpQtdCilindroCheios);
        final Double _tmpQtdCilindroVazios;
        if (_cursor.isNull(_cursorIndexOfQtdCilindroVazios)) {
          _tmpQtdCilindroVazios = null;
        } else {
          _tmpQtdCilindroVazios = _cursor.getDouble(_cursorIndexOfQtdCilindroVazios);
        }
        _item.setQtdCilindroVazios(_tmpQtdCilindroVazios);
        final Double _tmpFatorConversao;
        if (_cursor.isNull(_cursorIndexOfFatorConversao)) {
          _tmpFatorConversao = null;
        } else {
          _tmpFatorConversao = _cursor.getDouble(_cursorIndexOfFatorConversao);
        }
        _item.setFatorConversao(_tmpFatorConversao);
        final String _tmpEstruturaProducao;
        _tmpEstruturaProducao = _cursor.getString(_cursorIndexOfEstruturaProducao);
        _item.setEstruturaProducao(_tmpEstruturaProducao);
        final Long _tmpPercode;
        if (_cursor.isNull(_cursorIndexOfPercode)) {
          _tmpPercode = null;
        } else {
          _tmpPercode = _cursor.getLong(_cursorIndexOfPercode);
        }
        _item.setPercode(_tmpPercode);
        final Double _tmpCustoTransferencia;
        if (_cursor.isNull(_cursorIndexOfCustoTransferencia)) {
          _tmpCustoTransferencia = null;
        } else {
          _tmpCustoTransferencia = _cursor.getDouble(_cursorIndexOfCustoTransferencia);
        }
        _item.setCustoTransferencia(_tmpCustoTransferencia);
        final String _tmpTax1;
        _tmpTax1 = _cursor.getString(_cursorIndexOfTax1);
        _item.setTax1(_tmpTax1);
        final String _tmpTax2;
        _tmpTax2 = _cursor.getString(_cursorIndexOfTax2);
        _item.setTax2(_tmpTax2);
        final String _tmpTax3;
        _tmpTax3 = _cursor.getString(_cursorIndexOfTax3);
        _item.setTax3(_tmpTax3);
        final String _tmpIndRastreavel;
        _tmpIndRastreavel = _cursor.getString(_cursorIndexOfIndRastreavel);
        _item.setIndRastreavel(_tmpIndRastreavel);
        final String _tmpIndLiquido;
        _tmpIndLiquido = _cursor.getString(_cursorIndexOfIndLiquido);
        _item.setIndLiquido(_tmpIndLiquido);
        final Double _tmpValorIndenizacao;
        if (_cursor.isNull(_cursorIndexOfValorIndenizacao)) {
          _tmpValorIndenizacao = null;
        } else {
          _tmpValorIndenizacao = _cursor.getDouble(_cursorIndexOfValorIndenizacao);
        }
        _item.setValorIndenizacao(_tmpValorIndenizacao);
        final String _tmpCstGas;
        _tmpCstGas = _cursor.getString(_cursorIndexOfCstGas);
        _item.setCstGas(_tmpCstGas);
        final String _tmpCstCilindro;
        _tmpCstCilindro = _cursor.getString(_cursorIndexOfCstCilindro);
        _item.setCstCilindro(_tmpCstCilindro);
        final String _tmpUnidadeMedida;
        _tmpUnidadeMedida = _cursor.getString(_cursorIndexOfUnidadeMedida);
        _item.setUnidadeMedida(_tmpUnidadeMedida);
        final String _tmpIndLiqGas;
        _tmpIndLiqGas = _cursor.getString(_cursorIndexOfIndLiqGas);
        _item.setIndLiqGas(_tmpIndLiqGas);
        final Integer _tmpIndRequerFator;
        if (_cursor.isNull(_cursorIndexOfIndRequerFator)) {
          _tmpIndRequerFator = null;
        } else {
          _tmpIndRequerFator = _cursor.getInt(_cursorIndexOfIndRequerFator);
        }
        _item.setIndRequerFator(_tmpIndRequerFator);
        final Double _tmpFatorPcs;
        if (_cursor.isNull(_cursorIndexOfFatorPcs)) {
          _tmpFatorPcs = null;
        } else {
          _tmpFatorPcs = _cursor.getDouble(_cursorIndexOfFatorPcs);
        }
        _item.setFatorPcs(_tmpFatorPcs);
        final String _tmpPcsRegistrado;
        _tmpPcsRegistrado = _cursor.getString(_cursorIndexOfPcsRegistrado);
        _item.setPcsRegistrado(_tmpPcsRegistrado);
        final Long _tmpClasseNcmCilindro;
        if (_cursor.isNull(_cursorIndexOfClasseNcmCilindro)) {
          _tmpClasseNcmCilindro = null;
        } else {
          _tmpClasseNcmCilindro = _cursor.getLong(_cursorIndexOfClasseNcmCilindro);
        }
        _item.setClasseNcmCilindro(_tmpClasseNcmCilindro);
        final Double _tmpPesoCilindro;
        if (_cursor.isNull(_cursorIndexOfPesoCilindro)) {
          _tmpPesoCilindro = null;
        } else {
          _tmpPesoCilindro = _cursor.getDouble(_cursorIndexOfPesoCilindro);
        }
        _item.setPesoCilindro(_tmpPesoCilindro);
        final Double _tmpPesoLiqUnitario;
        if (_cursor.isNull(_cursorIndexOfPesoLiqUnitario)) {
          _tmpPesoLiqUnitario = null;
        } else {
          _tmpPesoLiqUnitario = _cursor.getDouble(_cursorIndexOfPesoLiqUnitario);
        }
        _item.setPesoLiqUnitario(_tmpPesoLiqUnitario);
        final Long _tmpClasseNcmGas;
        if (_cursor.isNull(_cursorIndexOfClasseNcmGas)) {
          _tmpClasseNcmGas = null;
        } else {
          _tmpClasseNcmGas = _cursor.getLong(_cursorIndexOfClasseNcmGas);
        }
        _item.setClasseNcmGas(_tmpClasseNcmGas);
        final String _tmpTipoPropriedade;
        _tmpTipoPropriedade = _cursor.getString(_cursorIndexOfTipoPropriedade);
        _item.setTipoPropriedade(_tmpTipoPropriedade);
        final String _tmpRecursivFrete;
        _tmpRecursivFrete = _cursor.getString(_cursorIndexOfRecursivFrete);
        _item.setRecursivFrete(_tmpRecursivFrete);
        final Integer _tmpTipoPressao;
        if (_cursor.isNull(_cursorIndexOfTipoPressao)) {
          _tmpTipoPressao = null;
        } else {
          _tmpTipoPressao = _cursor.getInt(_cursorIndexOfTipoPressao);
        }
        _item.setTipoPressao(_tmpTipoPressao);
        final String _tmpIndRastreabilidade;
        _tmpIndRastreabilidade = _cursor.getString(_cursorIndexOfIndRastreabilidade);
        _item.setIndRastreabilidade(_tmpIndRastreabilidade);
        final Integer _tmpTipoItem;
        if (_cursor.isNull(_cursorIndexOfTipoItem)) {
          _tmpTipoItem = null;
        } else {
          _tmpTipoItem = _cursor.getInt(_cursorIndexOfTipoItem);
        }
        _item.setTipoItem(_tmpTipoItem);
        final String _tmpIndFatorConvPolegadas;
        _tmpIndFatorConvPolegadas = _cursor.getString(_cursorIndexOfIndFatorConvPolegadas);
        _item.setIndFatorConvPolegadas(_tmpIndFatorConvPolegadas);
        final String _tmpIndProducao;
        _tmpIndProducao = _cursor.getString(_cursorIndexOfIndProducao);
        _item.setIndProducao(_tmpIndProducao);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Item find(Long cdItem, Double capacidadeProduto) {
    final String _sql = "SELECT * FROM Item WHERE (cdItem = ? OR cdCilindro = ?) AND capacidadeProduto = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (cdItem == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cdItem);
    }
    _argIndex = 2;
    if (cdItem == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cdItem);
    }
    _argIndex = 3;
    if (capacidadeProduto == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindDouble(_argIndex, capacidadeProduto);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCdItem = _cursor.getColumnIndexOrThrow("cdItem");
      final int _cursorIndexOfCapacidadeProduto = _cursor.getColumnIndexOrThrow("capacidadeProduto");
      final int _cursorIndexOfCdCilindro = _cursor.getColumnIndexOrThrow("cdCilindro");
      final int _cursorIndexOfCapacidadeCilindro = _cursor.getColumnIndexOrThrow("capacidadeCilindro");
      final int _cursorIndexOfIndCapacVariavel = _cursor.getColumnIndexOrThrow("indCapacVariavel");
      final int _cursorIndexOfIndRecursivoLastro = _cursor.getColumnIndexOrThrow("indRecursivoLastro");
      final int _cursorIndexOfDescricaoCilindro = _cursor.getColumnIndexOrThrow("descricaoCilindro");
      final int _cursorIndexOfDescricaoProduto = _cursor.getColumnIndexOrThrow("descricaoProduto");
      final int _cursorIndexOfQtdCilindroCheios = _cursor.getColumnIndexOrThrow("qtdCilindroCheios");
      final int _cursorIndexOfQtdCilindroVazios = _cursor.getColumnIndexOrThrow("qtdCilindroVazios");
      final int _cursorIndexOfFatorConversao = _cursor.getColumnIndexOrThrow("fatorConversao");
      final int _cursorIndexOfEstruturaProducao = _cursor.getColumnIndexOrThrow("estruturaProducao");
      final int _cursorIndexOfPercode = _cursor.getColumnIndexOrThrow("percode");
      final int _cursorIndexOfCustoTransferencia = _cursor.getColumnIndexOrThrow("custoTransferencia");
      final int _cursorIndexOfTax1 = _cursor.getColumnIndexOrThrow("tax1");
      final int _cursorIndexOfTax2 = _cursor.getColumnIndexOrThrow("tax2");
      final int _cursorIndexOfTax3 = _cursor.getColumnIndexOrThrow("tax3");
      final int _cursorIndexOfIndRastreavel = _cursor.getColumnIndexOrThrow("indRastreavel");
      final int _cursorIndexOfIndLiquido = _cursor.getColumnIndexOrThrow("indLiquido");
      final int _cursorIndexOfValorIndenizacao = _cursor.getColumnIndexOrThrow("valorIndenizacao");
      final int _cursorIndexOfCstGas = _cursor.getColumnIndexOrThrow("cstGas");
      final int _cursorIndexOfCstCilindro = _cursor.getColumnIndexOrThrow("cstCilindro");
      final int _cursorIndexOfUnidadeMedida = _cursor.getColumnIndexOrThrow("unidadeMedida");
      final int _cursorIndexOfIndLiqGas = _cursor.getColumnIndexOrThrow("indLiqGas");
      final int _cursorIndexOfIndRequerFator = _cursor.getColumnIndexOrThrow("indRequerFator");
      final int _cursorIndexOfFatorPcs = _cursor.getColumnIndexOrThrow("fatorPcs");
      final int _cursorIndexOfPcsRegistrado = _cursor.getColumnIndexOrThrow("pcsRegistrado");
      final int _cursorIndexOfClasseNcmCilindro = _cursor.getColumnIndexOrThrow("classeNcmCilindro");
      final int _cursorIndexOfPesoCilindro = _cursor.getColumnIndexOrThrow("pesoCilindro");
      final int _cursorIndexOfPesoLiqUnitario = _cursor.getColumnIndexOrThrow("pesoLiqUnitario");
      final int _cursorIndexOfClasseNcmGas = _cursor.getColumnIndexOrThrow("classeNcmGas");
      final int _cursorIndexOfTipoPropriedade = _cursor.getColumnIndexOrThrow("tipoPropriedade");
      final int _cursorIndexOfRecursivFrete = _cursor.getColumnIndexOrThrow("recursivFrete");
      final int _cursorIndexOfTipoPressao = _cursor.getColumnIndexOrThrow("tipoPressao");
      final int _cursorIndexOfIndRastreabilidade = _cursor.getColumnIndexOrThrow("indRastreabilidade");
      final int _cursorIndexOfTipoItem = _cursor.getColumnIndexOrThrow("tipoItem");
      final int _cursorIndexOfIndFatorConvPolegadas = _cursor.getColumnIndexOrThrow("indFatorConvPolegadas");
      final int _cursorIndexOfIndProducao = _cursor.getColumnIndexOrThrow("indProducao");
      final Item _result;
      if(_cursor.moveToFirst()) {
        _result = new Item();
        final Long _tmpCdItem;
        if (_cursor.isNull(_cursorIndexOfCdItem)) {
          _tmpCdItem = null;
        } else {
          _tmpCdItem = _cursor.getLong(_cursorIndexOfCdItem);
        }
        _result.setCdItem(_tmpCdItem);
        final Double _tmpCapacidadeProduto;
        if (_cursor.isNull(_cursorIndexOfCapacidadeProduto)) {
          _tmpCapacidadeProduto = null;
        } else {
          _tmpCapacidadeProduto = _cursor.getDouble(_cursorIndexOfCapacidadeProduto);
        }
        _result.setCapacidadeProduto(_tmpCapacidadeProduto);
        final Long _tmpCdCilindro;
        if (_cursor.isNull(_cursorIndexOfCdCilindro)) {
          _tmpCdCilindro = null;
        } else {
          _tmpCdCilindro = _cursor.getLong(_cursorIndexOfCdCilindro);
        }
        _result.setCdCilindro(_tmpCdCilindro);
        final Double _tmpCapacidadeCilindro;
        if (_cursor.isNull(_cursorIndexOfCapacidadeCilindro)) {
          _tmpCapacidadeCilindro = null;
        } else {
          _tmpCapacidadeCilindro = _cursor.getDouble(_cursorIndexOfCapacidadeCilindro);
        }
        _result.setCapacidadeCilindro(_tmpCapacidadeCilindro);
        final String _tmpIndCapacVariavel;
        _tmpIndCapacVariavel = _cursor.getString(_cursorIndexOfIndCapacVariavel);
        _result.setIndCapacVariavel(_tmpIndCapacVariavel);
        final String _tmpIndRecursivoLastro;
        _tmpIndRecursivoLastro = _cursor.getString(_cursorIndexOfIndRecursivoLastro);
        _result.setIndRecursivoLastro(_tmpIndRecursivoLastro);
        final String _tmpDescricaoCilindro;
        _tmpDescricaoCilindro = _cursor.getString(_cursorIndexOfDescricaoCilindro);
        _result.setDescricaoCilindro(_tmpDescricaoCilindro);
        final String _tmpDescricaoProduto;
        _tmpDescricaoProduto = _cursor.getString(_cursorIndexOfDescricaoProduto);
        _result.setDescricaoProduto(_tmpDescricaoProduto);
        final Double _tmpQtdCilindroCheios;
        if (_cursor.isNull(_cursorIndexOfQtdCilindroCheios)) {
          _tmpQtdCilindroCheios = null;
        } else {
          _tmpQtdCilindroCheios = _cursor.getDouble(_cursorIndexOfQtdCilindroCheios);
        }
        _result.setQtdCilindroCheios(_tmpQtdCilindroCheios);
        final Double _tmpQtdCilindroVazios;
        if (_cursor.isNull(_cursorIndexOfQtdCilindroVazios)) {
          _tmpQtdCilindroVazios = null;
        } else {
          _tmpQtdCilindroVazios = _cursor.getDouble(_cursorIndexOfQtdCilindroVazios);
        }
        _result.setQtdCilindroVazios(_tmpQtdCilindroVazios);
        final Double _tmpFatorConversao;
        if (_cursor.isNull(_cursorIndexOfFatorConversao)) {
          _tmpFatorConversao = null;
        } else {
          _tmpFatorConversao = _cursor.getDouble(_cursorIndexOfFatorConversao);
        }
        _result.setFatorConversao(_tmpFatorConversao);
        final String _tmpEstruturaProducao;
        _tmpEstruturaProducao = _cursor.getString(_cursorIndexOfEstruturaProducao);
        _result.setEstruturaProducao(_tmpEstruturaProducao);
        final Long _tmpPercode;
        if (_cursor.isNull(_cursorIndexOfPercode)) {
          _tmpPercode = null;
        } else {
          _tmpPercode = _cursor.getLong(_cursorIndexOfPercode);
        }
        _result.setPercode(_tmpPercode);
        final Double _tmpCustoTransferencia;
        if (_cursor.isNull(_cursorIndexOfCustoTransferencia)) {
          _tmpCustoTransferencia = null;
        } else {
          _tmpCustoTransferencia = _cursor.getDouble(_cursorIndexOfCustoTransferencia);
        }
        _result.setCustoTransferencia(_tmpCustoTransferencia);
        final String _tmpTax1;
        _tmpTax1 = _cursor.getString(_cursorIndexOfTax1);
        _result.setTax1(_tmpTax1);
        final String _tmpTax2;
        _tmpTax2 = _cursor.getString(_cursorIndexOfTax2);
        _result.setTax2(_tmpTax2);
        final String _tmpTax3;
        _tmpTax3 = _cursor.getString(_cursorIndexOfTax3);
        _result.setTax3(_tmpTax3);
        final String _tmpIndRastreavel;
        _tmpIndRastreavel = _cursor.getString(_cursorIndexOfIndRastreavel);
        _result.setIndRastreavel(_tmpIndRastreavel);
        final String _tmpIndLiquido;
        _tmpIndLiquido = _cursor.getString(_cursorIndexOfIndLiquido);
        _result.setIndLiquido(_tmpIndLiquido);
        final Double _tmpValorIndenizacao;
        if (_cursor.isNull(_cursorIndexOfValorIndenizacao)) {
          _tmpValorIndenizacao = null;
        } else {
          _tmpValorIndenizacao = _cursor.getDouble(_cursorIndexOfValorIndenizacao);
        }
        _result.setValorIndenizacao(_tmpValorIndenizacao);
        final String _tmpCstGas;
        _tmpCstGas = _cursor.getString(_cursorIndexOfCstGas);
        _result.setCstGas(_tmpCstGas);
        final String _tmpCstCilindro;
        _tmpCstCilindro = _cursor.getString(_cursorIndexOfCstCilindro);
        _result.setCstCilindro(_tmpCstCilindro);
        final String _tmpUnidadeMedida;
        _tmpUnidadeMedida = _cursor.getString(_cursorIndexOfUnidadeMedida);
        _result.setUnidadeMedida(_tmpUnidadeMedida);
        final String _tmpIndLiqGas;
        _tmpIndLiqGas = _cursor.getString(_cursorIndexOfIndLiqGas);
        _result.setIndLiqGas(_tmpIndLiqGas);
        final Integer _tmpIndRequerFator;
        if (_cursor.isNull(_cursorIndexOfIndRequerFator)) {
          _tmpIndRequerFator = null;
        } else {
          _tmpIndRequerFator = _cursor.getInt(_cursorIndexOfIndRequerFator);
        }
        _result.setIndRequerFator(_tmpIndRequerFator);
        final Double _tmpFatorPcs;
        if (_cursor.isNull(_cursorIndexOfFatorPcs)) {
          _tmpFatorPcs = null;
        } else {
          _tmpFatorPcs = _cursor.getDouble(_cursorIndexOfFatorPcs);
        }
        _result.setFatorPcs(_tmpFatorPcs);
        final String _tmpPcsRegistrado;
        _tmpPcsRegistrado = _cursor.getString(_cursorIndexOfPcsRegistrado);
        _result.setPcsRegistrado(_tmpPcsRegistrado);
        final Long _tmpClasseNcmCilindro;
        if (_cursor.isNull(_cursorIndexOfClasseNcmCilindro)) {
          _tmpClasseNcmCilindro = null;
        } else {
          _tmpClasseNcmCilindro = _cursor.getLong(_cursorIndexOfClasseNcmCilindro);
        }
        _result.setClasseNcmCilindro(_tmpClasseNcmCilindro);
        final Double _tmpPesoCilindro;
        if (_cursor.isNull(_cursorIndexOfPesoCilindro)) {
          _tmpPesoCilindro = null;
        } else {
          _tmpPesoCilindro = _cursor.getDouble(_cursorIndexOfPesoCilindro);
        }
        _result.setPesoCilindro(_tmpPesoCilindro);
        final Double _tmpPesoLiqUnitario;
        if (_cursor.isNull(_cursorIndexOfPesoLiqUnitario)) {
          _tmpPesoLiqUnitario = null;
        } else {
          _tmpPesoLiqUnitario = _cursor.getDouble(_cursorIndexOfPesoLiqUnitario);
        }
        _result.setPesoLiqUnitario(_tmpPesoLiqUnitario);
        final Long _tmpClasseNcmGas;
        if (_cursor.isNull(_cursorIndexOfClasseNcmGas)) {
          _tmpClasseNcmGas = null;
        } else {
          _tmpClasseNcmGas = _cursor.getLong(_cursorIndexOfClasseNcmGas);
        }
        _result.setClasseNcmGas(_tmpClasseNcmGas);
        final String _tmpTipoPropriedade;
        _tmpTipoPropriedade = _cursor.getString(_cursorIndexOfTipoPropriedade);
        _result.setTipoPropriedade(_tmpTipoPropriedade);
        final String _tmpRecursivFrete;
        _tmpRecursivFrete = _cursor.getString(_cursorIndexOfRecursivFrete);
        _result.setRecursivFrete(_tmpRecursivFrete);
        final Integer _tmpTipoPressao;
        if (_cursor.isNull(_cursorIndexOfTipoPressao)) {
          _tmpTipoPressao = null;
        } else {
          _tmpTipoPressao = _cursor.getInt(_cursorIndexOfTipoPressao);
        }
        _result.setTipoPressao(_tmpTipoPressao);
        final String _tmpIndRastreabilidade;
        _tmpIndRastreabilidade = _cursor.getString(_cursorIndexOfIndRastreabilidade);
        _result.setIndRastreabilidade(_tmpIndRastreabilidade);
        final Integer _tmpTipoItem;
        if (_cursor.isNull(_cursorIndexOfTipoItem)) {
          _tmpTipoItem = null;
        } else {
          _tmpTipoItem = _cursor.getInt(_cursorIndexOfTipoItem);
        }
        _result.setTipoItem(_tmpTipoItem);
        final String _tmpIndFatorConvPolegadas;
        _tmpIndFatorConvPolegadas = _cursor.getString(_cursorIndexOfIndFatorConvPolegadas);
        _result.setIndFatorConvPolegadas(_tmpIndFatorConvPolegadas);
        final String _tmpIndProducao;
        _tmpIndProducao = _cursor.getString(_cursorIndexOfIndProducao);
        _result.setIndProducao(_tmpIndProducao);
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
  public Item find(Long cdItem) {
    final String _sql = "SELECT * FROM Item WHERE cdItem = ? OR cdCilindro = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (cdItem == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cdItem);
    }
    _argIndex = 2;
    if (cdItem == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cdItem);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCdItem = _cursor.getColumnIndexOrThrow("cdItem");
      final int _cursorIndexOfCapacidadeProduto = _cursor.getColumnIndexOrThrow("capacidadeProduto");
      final int _cursorIndexOfCdCilindro = _cursor.getColumnIndexOrThrow("cdCilindro");
      final int _cursorIndexOfCapacidadeCilindro = _cursor.getColumnIndexOrThrow("capacidadeCilindro");
      final int _cursorIndexOfIndCapacVariavel = _cursor.getColumnIndexOrThrow("indCapacVariavel");
      final int _cursorIndexOfIndRecursivoLastro = _cursor.getColumnIndexOrThrow("indRecursivoLastro");
      final int _cursorIndexOfDescricaoCilindro = _cursor.getColumnIndexOrThrow("descricaoCilindro");
      final int _cursorIndexOfDescricaoProduto = _cursor.getColumnIndexOrThrow("descricaoProduto");
      final int _cursorIndexOfQtdCilindroCheios = _cursor.getColumnIndexOrThrow("qtdCilindroCheios");
      final int _cursorIndexOfQtdCilindroVazios = _cursor.getColumnIndexOrThrow("qtdCilindroVazios");
      final int _cursorIndexOfFatorConversao = _cursor.getColumnIndexOrThrow("fatorConversao");
      final int _cursorIndexOfEstruturaProducao = _cursor.getColumnIndexOrThrow("estruturaProducao");
      final int _cursorIndexOfPercode = _cursor.getColumnIndexOrThrow("percode");
      final int _cursorIndexOfCustoTransferencia = _cursor.getColumnIndexOrThrow("custoTransferencia");
      final int _cursorIndexOfTax1 = _cursor.getColumnIndexOrThrow("tax1");
      final int _cursorIndexOfTax2 = _cursor.getColumnIndexOrThrow("tax2");
      final int _cursorIndexOfTax3 = _cursor.getColumnIndexOrThrow("tax3");
      final int _cursorIndexOfIndRastreavel = _cursor.getColumnIndexOrThrow("indRastreavel");
      final int _cursorIndexOfIndLiquido = _cursor.getColumnIndexOrThrow("indLiquido");
      final int _cursorIndexOfValorIndenizacao = _cursor.getColumnIndexOrThrow("valorIndenizacao");
      final int _cursorIndexOfCstGas = _cursor.getColumnIndexOrThrow("cstGas");
      final int _cursorIndexOfCstCilindro = _cursor.getColumnIndexOrThrow("cstCilindro");
      final int _cursorIndexOfUnidadeMedida = _cursor.getColumnIndexOrThrow("unidadeMedida");
      final int _cursorIndexOfIndLiqGas = _cursor.getColumnIndexOrThrow("indLiqGas");
      final int _cursorIndexOfIndRequerFator = _cursor.getColumnIndexOrThrow("indRequerFator");
      final int _cursorIndexOfFatorPcs = _cursor.getColumnIndexOrThrow("fatorPcs");
      final int _cursorIndexOfPcsRegistrado = _cursor.getColumnIndexOrThrow("pcsRegistrado");
      final int _cursorIndexOfClasseNcmCilindro = _cursor.getColumnIndexOrThrow("classeNcmCilindro");
      final int _cursorIndexOfPesoCilindro = _cursor.getColumnIndexOrThrow("pesoCilindro");
      final int _cursorIndexOfPesoLiqUnitario = _cursor.getColumnIndexOrThrow("pesoLiqUnitario");
      final int _cursorIndexOfClasseNcmGas = _cursor.getColumnIndexOrThrow("classeNcmGas");
      final int _cursorIndexOfTipoPropriedade = _cursor.getColumnIndexOrThrow("tipoPropriedade");
      final int _cursorIndexOfRecursivFrete = _cursor.getColumnIndexOrThrow("recursivFrete");
      final int _cursorIndexOfTipoPressao = _cursor.getColumnIndexOrThrow("tipoPressao");
      final int _cursorIndexOfIndRastreabilidade = _cursor.getColumnIndexOrThrow("indRastreabilidade");
      final int _cursorIndexOfTipoItem = _cursor.getColumnIndexOrThrow("tipoItem");
      final int _cursorIndexOfIndFatorConvPolegadas = _cursor.getColumnIndexOrThrow("indFatorConvPolegadas");
      final int _cursorIndexOfIndProducao = _cursor.getColumnIndexOrThrow("indProducao");
      final Item _result;
      if(_cursor.moveToFirst()) {
        _result = new Item();
        final Long _tmpCdItem;
        if (_cursor.isNull(_cursorIndexOfCdItem)) {
          _tmpCdItem = null;
        } else {
          _tmpCdItem = _cursor.getLong(_cursorIndexOfCdItem);
        }
        _result.setCdItem(_tmpCdItem);
        final Double _tmpCapacidadeProduto;
        if (_cursor.isNull(_cursorIndexOfCapacidadeProduto)) {
          _tmpCapacidadeProduto = null;
        } else {
          _tmpCapacidadeProduto = _cursor.getDouble(_cursorIndexOfCapacidadeProduto);
        }
        _result.setCapacidadeProduto(_tmpCapacidadeProduto);
        final Long _tmpCdCilindro;
        if (_cursor.isNull(_cursorIndexOfCdCilindro)) {
          _tmpCdCilindro = null;
        } else {
          _tmpCdCilindro = _cursor.getLong(_cursorIndexOfCdCilindro);
        }
        _result.setCdCilindro(_tmpCdCilindro);
        final Double _tmpCapacidadeCilindro;
        if (_cursor.isNull(_cursorIndexOfCapacidadeCilindro)) {
          _tmpCapacidadeCilindro = null;
        } else {
          _tmpCapacidadeCilindro = _cursor.getDouble(_cursorIndexOfCapacidadeCilindro);
        }
        _result.setCapacidadeCilindro(_tmpCapacidadeCilindro);
        final String _tmpIndCapacVariavel;
        _tmpIndCapacVariavel = _cursor.getString(_cursorIndexOfIndCapacVariavel);
        _result.setIndCapacVariavel(_tmpIndCapacVariavel);
        final String _tmpIndRecursivoLastro;
        _tmpIndRecursivoLastro = _cursor.getString(_cursorIndexOfIndRecursivoLastro);
        _result.setIndRecursivoLastro(_tmpIndRecursivoLastro);
        final String _tmpDescricaoCilindro;
        _tmpDescricaoCilindro = _cursor.getString(_cursorIndexOfDescricaoCilindro);
        _result.setDescricaoCilindro(_tmpDescricaoCilindro);
        final String _tmpDescricaoProduto;
        _tmpDescricaoProduto = _cursor.getString(_cursorIndexOfDescricaoProduto);
        _result.setDescricaoProduto(_tmpDescricaoProduto);
        final Double _tmpQtdCilindroCheios;
        if (_cursor.isNull(_cursorIndexOfQtdCilindroCheios)) {
          _tmpQtdCilindroCheios = null;
        } else {
          _tmpQtdCilindroCheios = _cursor.getDouble(_cursorIndexOfQtdCilindroCheios);
        }
        _result.setQtdCilindroCheios(_tmpQtdCilindroCheios);
        final Double _tmpQtdCilindroVazios;
        if (_cursor.isNull(_cursorIndexOfQtdCilindroVazios)) {
          _tmpQtdCilindroVazios = null;
        } else {
          _tmpQtdCilindroVazios = _cursor.getDouble(_cursorIndexOfQtdCilindroVazios);
        }
        _result.setQtdCilindroVazios(_tmpQtdCilindroVazios);
        final Double _tmpFatorConversao;
        if (_cursor.isNull(_cursorIndexOfFatorConversao)) {
          _tmpFatorConversao = null;
        } else {
          _tmpFatorConversao = _cursor.getDouble(_cursorIndexOfFatorConversao);
        }
        _result.setFatorConversao(_tmpFatorConversao);
        final String _tmpEstruturaProducao;
        _tmpEstruturaProducao = _cursor.getString(_cursorIndexOfEstruturaProducao);
        _result.setEstruturaProducao(_tmpEstruturaProducao);
        final Long _tmpPercode;
        if (_cursor.isNull(_cursorIndexOfPercode)) {
          _tmpPercode = null;
        } else {
          _tmpPercode = _cursor.getLong(_cursorIndexOfPercode);
        }
        _result.setPercode(_tmpPercode);
        final Double _tmpCustoTransferencia;
        if (_cursor.isNull(_cursorIndexOfCustoTransferencia)) {
          _tmpCustoTransferencia = null;
        } else {
          _tmpCustoTransferencia = _cursor.getDouble(_cursorIndexOfCustoTransferencia);
        }
        _result.setCustoTransferencia(_tmpCustoTransferencia);
        final String _tmpTax1;
        _tmpTax1 = _cursor.getString(_cursorIndexOfTax1);
        _result.setTax1(_tmpTax1);
        final String _tmpTax2;
        _tmpTax2 = _cursor.getString(_cursorIndexOfTax2);
        _result.setTax2(_tmpTax2);
        final String _tmpTax3;
        _tmpTax3 = _cursor.getString(_cursorIndexOfTax3);
        _result.setTax3(_tmpTax3);
        final String _tmpIndRastreavel;
        _tmpIndRastreavel = _cursor.getString(_cursorIndexOfIndRastreavel);
        _result.setIndRastreavel(_tmpIndRastreavel);
        final String _tmpIndLiquido;
        _tmpIndLiquido = _cursor.getString(_cursorIndexOfIndLiquido);
        _result.setIndLiquido(_tmpIndLiquido);
        final Double _tmpValorIndenizacao;
        if (_cursor.isNull(_cursorIndexOfValorIndenizacao)) {
          _tmpValorIndenizacao = null;
        } else {
          _tmpValorIndenizacao = _cursor.getDouble(_cursorIndexOfValorIndenizacao);
        }
        _result.setValorIndenizacao(_tmpValorIndenizacao);
        final String _tmpCstGas;
        _tmpCstGas = _cursor.getString(_cursorIndexOfCstGas);
        _result.setCstGas(_tmpCstGas);
        final String _tmpCstCilindro;
        _tmpCstCilindro = _cursor.getString(_cursorIndexOfCstCilindro);
        _result.setCstCilindro(_tmpCstCilindro);
        final String _tmpUnidadeMedida;
        _tmpUnidadeMedida = _cursor.getString(_cursorIndexOfUnidadeMedida);
        _result.setUnidadeMedida(_tmpUnidadeMedida);
        final String _tmpIndLiqGas;
        _tmpIndLiqGas = _cursor.getString(_cursorIndexOfIndLiqGas);
        _result.setIndLiqGas(_tmpIndLiqGas);
        final Integer _tmpIndRequerFator;
        if (_cursor.isNull(_cursorIndexOfIndRequerFator)) {
          _tmpIndRequerFator = null;
        } else {
          _tmpIndRequerFator = _cursor.getInt(_cursorIndexOfIndRequerFator);
        }
        _result.setIndRequerFator(_tmpIndRequerFator);
        final Double _tmpFatorPcs;
        if (_cursor.isNull(_cursorIndexOfFatorPcs)) {
          _tmpFatorPcs = null;
        } else {
          _tmpFatorPcs = _cursor.getDouble(_cursorIndexOfFatorPcs);
        }
        _result.setFatorPcs(_tmpFatorPcs);
        final String _tmpPcsRegistrado;
        _tmpPcsRegistrado = _cursor.getString(_cursorIndexOfPcsRegistrado);
        _result.setPcsRegistrado(_tmpPcsRegistrado);
        final Long _tmpClasseNcmCilindro;
        if (_cursor.isNull(_cursorIndexOfClasseNcmCilindro)) {
          _tmpClasseNcmCilindro = null;
        } else {
          _tmpClasseNcmCilindro = _cursor.getLong(_cursorIndexOfClasseNcmCilindro);
        }
        _result.setClasseNcmCilindro(_tmpClasseNcmCilindro);
        final Double _tmpPesoCilindro;
        if (_cursor.isNull(_cursorIndexOfPesoCilindro)) {
          _tmpPesoCilindro = null;
        } else {
          _tmpPesoCilindro = _cursor.getDouble(_cursorIndexOfPesoCilindro);
        }
        _result.setPesoCilindro(_tmpPesoCilindro);
        final Double _tmpPesoLiqUnitario;
        if (_cursor.isNull(_cursorIndexOfPesoLiqUnitario)) {
          _tmpPesoLiqUnitario = null;
        } else {
          _tmpPesoLiqUnitario = _cursor.getDouble(_cursorIndexOfPesoLiqUnitario);
        }
        _result.setPesoLiqUnitario(_tmpPesoLiqUnitario);
        final Long _tmpClasseNcmGas;
        if (_cursor.isNull(_cursorIndexOfClasseNcmGas)) {
          _tmpClasseNcmGas = null;
        } else {
          _tmpClasseNcmGas = _cursor.getLong(_cursorIndexOfClasseNcmGas);
        }
        _result.setClasseNcmGas(_tmpClasseNcmGas);
        final String _tmpTipoPropriedade;
        _tmpTipoPropriedade = _cursor.getString(_cursorIndexOfTipoPropriedade);
        _result.setTipoPropriedade(_tmpTipoPropriedade);
        final String _tmpRecursivFrete;
        _tmpRecursivFrete = _cursor.getString(_cursorIndexOfRecursivFrete);
        _result.setRecursivFrete(_tmpRecursivFrete);
        final Integer _tmpTipoPressao;
        if (_cursor.isNull(_cursorIndexOfTipoPressao)) {
          _tmpTipoPressao = null;
        } else {
          _tmpTipoPressao = _cursor.getInt(_cursorIndexOfTipoPressao);
        }
        _result.setTipoPressao(_tmpTipoPressao);
        final String _tmpIndRastreabilidade;
        _tmpIndRastreabilidade = _cursor.getString(_cursorIndexOfIndRastreabilidade);
        _result.setIndRastreabilidade(_tmpIndRastreabilidade);
        final Integer _tmpTipoItem;
        if (_cursor.isNull(_cursorIndexOfTipoItem)) {
          _tmpTipoItem = null;
        } else {
          _tmpTipoItem = _cursor.getInt(_cursorIndexOfTipoItem);
        }
        _result.setTipoItem(_tmpTipoItem);
        final String _tmpIndFatorConvPolegadas;
        _tmpIndFatorConvPolegadas = _cursor.getString(_cursorIndexOfIndFatorConvPolegadas);
        _result.setIndFatorConvPolegadas(_tmpIndFatorConvPolegadas);
        final String _tmpIndProducao;
        _tmpIndProducao = _cursor.getString(_cursorIndexOfIndProducao);
        _result.setIndProducao(_tmpIndProducao);
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
  public List<Item> find(List<Integer> tipoItem) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT * FROM Item WHERE (qtdCilindroCheios > 0 OR qtdCilindroVazios > 0) AND tipoItem IN (");
    final int _inputSize = tipoItem.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
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
      final int _cursorIndexOfCdItem = _cursor.getColumnIndexOrThrow("cdItem");
      final int _cursorIndexOfCapacidadeProduto = _cursor.getColumnIndexOrThrow("capacidadeProduto");
      final int _cursorIndexOfCdCilindro = _cursor.getColumnIndexOrThrow("cdCilindro");
      final int _cursorIndexOfCapacidadeCilindro = _cursor.getColumnIndexOrThrow("capacidadeCilindro");
      final int _cursorIndexOfIndCapacVariavel = _cursor.getColumnIndexOrThrow("indCapacVariavel");
      final int _cursorIndexOfIndRecursivoLastro = _cursor.getColumnIndexOrThrow("indRecursivoLastro");
      final int _cursorIndexOfDescricaoCilindro = _cursor.getColumnIndexOrThrow("descricaoCilindro");
      final int _cursorIndexOfDescricaoProduto = _cursor.getColumnIndexOrThrow("descricaoProduto");
      final int _cursorIndexOfQtdCilindroCheios = _cursor.getColumnIndexOrThrow("qtdCilindroCheios");
      final int _cursorIndexOfQtdCilindroVazios = _cursor.getColumnIndexOrThrow("qtdCilindroVazios");
      final int _cursorIndexOfFatorConversao = _cursor.getColumnIndexOrThrow("fatorConversao");
      final int _cursorIndexOfEstruturaProducao = _cursor.getColumnIndexOrThrow("estruturaProducao");
      final int _cursorIndexOfPercode = _cursor.getColumnIndexOrThrow("percode");
      final int _cursorIndexOfCustoTransferencia = _cursor.getColumnIndexOrThrow("custoTransferencia");
      final int _cursorIndexOfTax1 = _cursor.getColumnIndexOrThrow("tax1");
      final int _cursorIndexOfTax2 = _cursor.getColumnIndexOrThrow("tax2");
      final int _cursorIndexOfTax3 = _cursor.getColumnIndexOrThrow("tax3");
      final int _cursorIndexOfIndRastreavel = _cursor.getColumnIndexOrThrow("indRastreavel");
      final int _cursorIndexOfIndLiquido = _cursor.getColumnIndexOrThrow("indLiquido");
      final int _cursorIndexOfValorIndenizacao = _cursor.getColumnIndexOrThrow("valorIndenizacao");
      final int _cursorIndexOfCstGas = _cursor.getColumnIndexOrThrow("cstGas");
      final int _cursorIndexOfCstCilindro = _cursor.getColumnIndexOrThrow("cstCilindro");
      final int _cursorIndexOfUnidadeMedida = _cursor.getColumnIndexOrThrow("unidadeMedida");
      final int _cursorIndexOfIndLiqGas = _cursor.getColumnIndexOrThrow("indLiqGas");
      final int _cursorIndexOfIndRequerFator = _cursor.getColumnIndexOrThrow("indRequerFator");
      final int _cursorIndexOfFatorPcs = _cursor.getColumnIndexOrThrow("fatorPcs");
      final int _cursorIndexOfPcsRegistrado = _cursor.getColumnIndexOrThrow("pcsRegistrado");
      final int _cursorIndexOfClasseNcmCilindro = _cursor.getColumnIndexOrThrow("classeNcmCilindro");
      final int _cursorIndexOfPesoCilindro = _cursor.getColumnIndexOrThrow("pesoCilindro");
      final int _cursorIndexOfPesoLiqUnitario = _cursor.getColumnIndexOrThrow("pesoLiqUnitario");
      final int _cursorIndexOfClasseNcmGas = _cursor.getColumnIndexOrThrow("classeNcmGas");
      final int _cursorIndexOfTipoPropriedade = _cursor.getColumnIndexOrThrow("tipoPropriedade");
      final int _cursorIndexOfRecursivFrete = _cursor.getColumnIndexOrThrow("recursivFrete");
      final int _cursorIndexOfTipoPressao = _cursor.getColumnIndexOrThrow("tipoPressao");
      final int _cursorIndexOfIndRastreabilidade = _cursor.getColumnIndexOrThrow("indRastreabilidade");
      final int _cursorIndexOfTipoItem = _cursor.getColumnIndexOrThrow("tipoItem");
      final int _cursorIndexOfIndFatorConvPolegadas = _cursor.getColumnIndexOrThrow("indFatorConvPolegadas");
      final int _cursorIndexOfIndProducao = _cursor.getColumnIndexOrThrow("indProducao");
      final List<Item> _result = new ArrayList<Item>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Item _item_1;
        _item_1 = new Item();
        final Long _tmpCdItem;
        if (_cursor.isNull(_cursorIndexOfCdItem)) {
          _tmpCdItem = null;
        } else {
          _tmpCdItem = _cursor.getLong(_cursorIndexOfCdItem);
        }
        _item_1.setCdItem(_tmpCdItem);
        final Double _tmpCapacidadeProduto;
        if (_cursor.isNull(_cursorIndexOfCapacidadeProduto)) {
          _tmpCapacidadeProduto = null;
        } else {
          _tmpCapacidadeProduto = _cursor.getDouble(_cursorIndexOfCapacidadeProduto);
        }
        _item_1.setCapacidadeProduto(_tmpCapacidadeProduto);
        final Long _tmpCdCilindro;
        if (_cursor.isNull(_cursorIndexOfCdCilindro)) {
          _tmpCdCilindro = null;
        } else {
          _tmpCdCilindro = _cursor.getLong(_cursorIndexOfCdCilindro);
        }
        _item_1.setCdCilindro(_tmpCdCilindro);
        final Double _tmpCapacidadeCilindro;
        if (_cursor.isNull(_cursorIndexOfCapacidadeCilindro)) {
          _tmpCapacidadeCilindro = null;
        } else {
          _tmpCapacidadeCilindro = _cursor.getDouble(_cursorIndexOfCapacidadeCilindro);
        }
        _item_1.setCapacidadeCilindro(_tmpCapacidadeCilindro);
        final String _tmpIndCapacVariavel;
        _tmpIndCapacVariavel = _cursor.getString(_cursorIndexOfIndCapacVariavel);
        _item_1.setIndCapacVariavel(_tmpIndCapacVariavel);
        final String _tmpIndRecursivoLastro;
        _tmpIndRecursivoLastro = _cursor.getString(_cursorIndexOfIndRecursivoLastro);
        _item_1.setIndRecursivoLastro(_tmpIndRecursivoLastro);
        final String _tmpDescricaoCilindro;
        _tmpDescricaoCilindro = _cursor.getString(_cursorIndexOfDescricaoCilindro);
        _item_1.setDescricaoCilindro(_tmpDescricaoCilindro);
        final String _tmpDescricaoProduto;
        _tmpDescricaoProduto = _cursor.getString(_cursorIndexOfDescricaoProduto);
        _item_1.setDescricaoProduto(_tmpDescricaoProduto);
        final Double _tmpQtdCilindroCheios;
        if (_cursor.isNull(_cursorIndexOfQtdCilindroCheios)) {
          _tmpQtdCilindroCheios = null;
        } else {
          _tmpQtdCilindroCheios = _cursor.getDouble(_cursorIndexOfQtdCilindroCheios);
        }
        _item_1.setQtdCilindroCheios(_tmpQtdCilindroCheios);
        final Double _tmpQtdCilindroVazios;
        if (_cursor.isNull(_cursorIndexOfQtdCilindroVazios)) {
          _tmpQtdCilindroVazios = null;
        } else {
          _tmpQtdCilindroVazios = _cursor.getDouble(_cursorIndexOfQtdCilindroVazios);
        }
        _item_1.setQtdCilindroVazios(_tmpQtdCilindroVazios);
        final Double _tmpFatorConversao;
        if (_cursor.isNull(_cursorIndexOfFatorConversao)) {
          _tmpFatorConversao = null;
        } else {
          _tmpFatorConversao = _cursor.getDouble(_cursorIndexOfFatorConversao);
        }
        _item_1.setFatorConversao(_tmpFatorConversao);
        final String _tmpEstruturaProducao;
        _tmpEstruturaProducao = _cursor.getString(_cursorIndexOfEstruturaProducao);
        _item_1.setEstruturaProducao(_tmpEstruturaProducao);
        final Long _tmpPercode;
        if (_cursor.isNull(_cursorIndexOfPercode)) {
          _tmpPercode = null;
        } else {
          _tmpPercode = _cursor.getLong(_cursorIndexOfPercode);
        }
        _item_1.setPercode(_tmpPercode);
        final Double _tmpCustoTransferencia;
        if (_cursor.isNull(_cursorIndexOfCustoTransferencia)) {
          _tmpCustoTransferencia = null;
        } else {
          _tmpCustoTransferencia = _cursor.getDouble(_cursorIndexOfCustoTransferencia);
        }
        _item_1.setCustoTransferencia(_tmpCustoTransferencia);
        final String _tmpTax1;
        _tmpTax1 = _cursor.getString(_cursorIndexOfTax1);
        _item_1.setTax1(_tmpTax1);
        final String _tmpTax2;
        _tmpTax2 = _cursor.getString(_cursorIndexOfTax2);
        _item_1.setTax2(_tmpTax2);
        final String _tmpTax3;
        _tmpTax3 = _cursor.getString(_cursorIndexOfTax3);
        _item_1.setTax3(_tmpTax3);
        final String _tmpIndRastreavel;
        _tmpIndRastreavel = _cursor.getString(_cursorIndexOfIndRastreavel);
        _item_1.setIndRastreavel(_tmpIndRastreavel);
        final String _tmpIndLiquido;
        _tmpIndLiquido = _cursor.getString(_cursorIndexOfIndLiquido);
        _item_1.setIndLiquido(_tmpIndLiquido);
        final Double _tmpValorIndenizacao;
        if (_cursor.isNull(_cursorIndexOfValorIndenizacao)) {
          _tmpValorIndenizacao = null;
        } else {
          _tmpValorIndenizacao = _cursor.getDouble(_cursorIndexOfValorIndenizacao);
        }
        _item_1.setValorIndenizacao(_tmpValorIndenizacao);
        final String _tmpCstGas;
        _tmpCstGas = _cursor.getString(_cursorIndexOfCstGas);
        _item_1.setCstGas(_tmpCstGas);
        final String _tmpCstCilindro;
        _tmpCstCilindro = _cursor.getString(_cursorIndexOfCstCilindro);
        _item_1.setCstCilindro(_tmpCstCilindro);
        final String _tmpUnidadeMedida;
        _tmpUnidadeMedida = _cursor.getString(_cursorIndexOfUnidadeMedida);
        _item_1.setUnidadeMedida(_tmpUnidadeMedida);
        final String _tmpIndLiqGas;
        _tmpIndLiqGas = _cursor.getString(_cursorIndexOfIndLiqGas);
        _item_1.setIndLiqGas(_tmpIndLiqGas);
        final Integer _tmpIndRequerFator;
        if (_cursor.isNull(_cursorIndexOfIndRequerFator)) {
          _tmpIndRequerFator = null;
        } else {
          _tmpIndRequerFator = _cursor.getInt(_cursorIndexOfIndRequerFator);
        }
        _item_1.setIndRequerFator(_tmpIndRequerFator);
        final Double _tmpFatorPcs;
        if (_cursor.isNull(_cursorIndexOfFatorPcs)) {
          _tmpFatorPcs = null;
        } else {
          _tmpFatorPcs = _cursor.getDouble(_cursorIndexOfFatorPcs);
        }
        _item_1.setFatorPcs(_tmpFatorPcs);
        final String _tmpPcsRegistrado;
        _tmpPcsRegistrado = _cursor.getString(_cursorIndexOfPcsRegistrado);
        _item_1.setPcsRegistrado(_tmpPcsRegistrado);
        final Long _tmpClasseNcmCilindro;
        if (_cursor.isNull(_cursorIndexOfClasseNcmCilindro)) {
          _tmpClasseNcmCilindro = null;
        } else {
          _tmpClasseNcmCilindro = _cursor.getLong(_cursorIndexOfClasseNcmCilindro);
        }
        _item_1.setClasseNcmCilindro(_tmpClasseNcmCilindro);
        final Double _tmpPesoCilindro;
        if (_cursor.isNull(_cursorIndexOfPesoCilindro)) {
          _tmpPesoCilindro = null;
        } else {
          _tmpPesoCilindro = _cursor.getDouble(_cursorIndexOfPesoCilindro);
        }
        _item_1.setPesoCilindro(_tmpPesoCilindro);
        final Double _tmpPesoLiqUnitario;
        if (_cursor.isNull(_cursorIndexOfPesoLiqUnitario)) {
          _tmpPesoLiqUnitario = null;
        } else {
          _tmpPesoLiqUnitario = _cursor.getDouble(_cursorIndexOfPesoLiqUnitario);
        }
        _item_1.setPesoLiqUnitario(_tmpPesoLiqUnitario);
        final Long _tmpClasseNcmGas;
        if (_cursor.isNull(_cursorIndexOfClasseNcmGas)) {
          _tmpClasseNcmGas = null;
        } else {
          _tmpClasseNcmGas = _cursor.getLong(_cursorIndexOfClasseNcmGas);
        }
        _item_1.setClasseNcmGas(_tmpClasseNcmGas);
        final String _tmpTipoPropriedade;
        _tmpTipoPropriedade = _cursor.getString(_cursorIndexOfTipoPropriedade);
        _item_1.setTipoPropriedade(_tmpTipoPropriedade);
        final String _tmpRecursivFrete;
        _tmpRecursivFrete = _cursor.getString(_cursorIndexOfRecursivFrete);
        _item_1.setRecursivFrete(_tmpRecursivFrete);
        final Integer _tmpTipoPressao;
        if (_cursor.isNull(_cursorIndexOfTipoPressao)) {
          _tmpTipoPressao = null;
        } else {
          _tmpTipoPressao = _cursor.getInt(_cursorIndexOfTipoPressao);
        }
        _item_1.setTipoPressao(_tmpTipoPressao);
        final String _tmpIndRastreabilidade;
        _tmpIndRastreabilidade = _cursor.getString(_cursorIndexOfIndRastreabilidade);
        _item_1.setIndRastreabilidade(_tmpIndRastreabilidade);
        final Integer _tmpTipoItem;
        if (_cursor.isNull(_cursorIndexOfTipoItem)) {
          _tmpTipoItem = null;
        } else {
          _tmpTipoItem = _cursor.getInt(_cursorIndexOfTipoItem);
        }
        _item_1.setTipoItem(_tmpTipoItem);
        final String _tmpIndFatorConvPolegadas;
        _tmpIndFatorConvPolegadas = _cursor.getString(_cursorIndexOfIndFatorConvPolegadas);
        _item_1.setIndFatorConvPolegadas(_tmpIndFatorConvPolegadas);
        final String _tmpIndProducao;
        _tmpIndProducao = _cursor.getString(_cursorIndexOfIndProducao);
        _item_1.setIndProducao(_tmpIndProducao);
        _result.add(_item_1);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
