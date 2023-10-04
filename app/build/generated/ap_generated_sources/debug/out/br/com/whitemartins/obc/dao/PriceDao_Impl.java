package br.com.whitemartins.obc.dao;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.util.StringUtil;
import android.database.Cursor;
import br.com.whitemartins.obc.model.Item;
import br.com.whitemartins.obc.model.ItemPrice;
import br.com.whitemartins.obc.model.Price;
import br.com.whitemartins.obc.model.Route;
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
public class PriceDao_Impl implements PriceDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfPrice;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfPrice;

  public PriceDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPrice = new EntityInsertionAdapter<Price>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Price`(`cdCustomer`,`cdItem`,`flNovoFaturamento`,`percentualIpi`,`percentualIcms`,`percReducaoIcms`,`precoUnitario`,`valorFrete`,`valorDespesas`,`percentualPis`,`percentualCofins`,`cstPis`,`cstCofins`,`situacaoTributaria`,`condicaoFaturamento`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Price value) {
        if (value.getCdCustomer() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getCdCustomer());
        }
        if (value.getCdItem() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getCdItem());
        }
        if (value.getFlNovoFaturamento() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getFlNovoFaturamento());
        }
        if (value.getPercentualIpi() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindDouble(4, value.getPercentualIpi());
        }
        if (value.getPercentualIcms() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindDouble(5, value.getPercentualIcms());
        }
        if (value.getPercReducaoIcms() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindDouble(6, value.getPercReducaoIcms());
        }
        if (value.getPrecoUnitario() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindDouble(7, value.getPrecoUnitario());
        }
        if (value.getValorFrete() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindDouble(8, value.getValorFrete());
        }
        if (value.getValorDespesas() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindDouble(9, value.getValorDespesas());
        }
        if (value.getPercentualPis() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindDouble(10, value.getPercentualPis());
        }
        if (value.getPercentualCofins() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindDouble(11, value.getPercentualCofins());
        }
        if (value.getCstPis() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getCstPis());
        }
        if (value.getCstCofins() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getCstCofins());
        }
        if (value.getSituacaoTributaria() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getSituacaoTributaria());
        }
        if (value.getCondicaoFaturamento() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getCondicaoFaturamento());
        }
      }
    };
    this.__deletionAdapterOfPrice = new EntityDeletionOrUpdateAdapter<Price>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Price` WHERE `cdCustomer` = ? AND `cdItem` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Price value) {
        if (value.getCdCustomer() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getCdCustomer());
        }
        if (value.getCdItem() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getCdItem());
        }
      }
    };
  }

  @Override
  public void insertAll(List<Price> prices) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfPrice.insert(prices);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insert(Price price) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfPrice.insert(price);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(Price price) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfPrice.handle(price);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll(List<Price> prices) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfPrice.handleMultiple(prices);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Price> getAll() {
    final String _sql = "SELECT * FROM Price";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfCdItem = _cursor.getColumnIndexOrThrow("cdItem");
      final int _cursorIndexOfFlNovoFaturamento = _cursor.getColumnIndexOrThrow("flNovoFaturamento");
      final int _cursorIndexOfPercentualIpi = _cursor.getColumnIndexOrThrow("percentualIpi");
      final int _cursorIndexOfPercentualIcms = _cursor.getColumnIndexOrThrow("percentualIcms");
      final int _cursorIndexOfPercReducaoIcms = _cursor.getColumnIndexOrThrow("percReducaoIcms");
      final int _cursorIndexOfPrecoUnitario = _cursor.getColumnIndexOrThrow("precoUnitario");
      final int _cursorIndexOfValorFrete = _cursor.getColumnIndexOrThrow("valorFrete");
      final int _cursorIndexOfValorDespesas = _cursor.getColumnIndexOrThrow("valorDespesas");
      final int _cursorIndexOfPercentualPis = _cursor.getColumnIndexOrThrow("percentualPis");
      final int _cursorIndexOfPercentualCofins = _cursor.getColumnIndexOrThrow("percentualCofins");
      final int _cursorIndexOfCstPis = _cursor.getColumnIndexOrThrow("cstPis");
      final int _cursorIndexOfCstCofins = _cursor.getColumnIndexOrThrow("cstCofins");
      final int _cursorIndexOfSituacaoTributaria = _cursor.getColumnIndexOrThrow("situacaoTributaria");
      final int _cursorIndexOfCondicaoFaturamento = _cursor.getColumnIndexOrThrow("condicaoFaturamento");
      final List<Price> _result = new ArrayList<Price>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Price _item;
        _item = new Price();
        final Long _tmpCdCustomer;
        if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
          _tmpCdCustomer = null;
        } else {
          _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
        }
        _item.setCdCustomer(_tmpCdCustomer);
        final Long _tmpCdItem;
        if (_cursor.isNull(_cursorIndexOfCdItem)) {
          _tmpCdItem = null;
        } else {
          _tmpCdItem = _cursor.getLong(_cursorIndexOfCdItem);
        }
        _item.setCdItem(_tmpCdItem);
        final String _tmpFlNovoFaturamento;
        _tmpFlNovoFaturamento = _cursor.getString(_cursorIndexOfFlNovoFaturamento);
        _item.setFlNovoFaturamento(_tmpFlNovoFaturamento);
        final Double _tmpPercentualIpi;
        if (_cursor.isNull(_cursorIndexOfPercentualIpi)) {
          _tmpPercentualIpi = null;
        } else {
          _tmpPercentualIpi = _cursor.getDouble(_cursorIndexOfPercentualIpi);
        }
        _item.setPercentualIpi(_tmpPercentualIpi);
        final Double _tmpPercentualIcms;
        if (_cursor.isNull(_cursorIndexOfPercentualIcms)) {
          _tmpPercentualIcms = null;
        } else {
          _tmpPercentualIcms = _cursor.getDouble(_cursorIndexOfPercentualIcms);
        }
        _item.setPercentualIcms(_tmpPercentualIcms);
        final Double _tmpPercReducaoIcms;
        if (_cursor.isNull(_cursorIndexOfPercReducaoIcms)) {
          _tmpPercReducaoIcms = null;
        } else {
          _tmpPercReducaoIcms = _cursor.getDouble(_cursorIndexOfPercReducaoIcms);
        }
        _item.setPercReducaoIcms(_tmpPercReducaoIcms);
        final Double _tmpPrecoUnitario;
        if (_cursor.isNull(_cursorIndexOfPrecoUnitario)) {
          _tmpPrecoUnitario = null;
        } else {
          _tmpPrecoUnitario = _cursor.getDouble(_cursorIndexOfPrecoUnitario);
        }
        _item.setPrecoUnitario(_tmpPrecoUnitario);
        final Double _tmpValorFrete;
        if (_cursor.isNull(_cursorIndexOfValorFrete)) {
          _tmpValorFrete = null;
        } else {
          _tmpValorFrete = _cursor.getDouble(_cursorIndexOfValorFrete);
        }
        _item.setValorFrete(_tmpValorFrete);
        final Double _tmpValorDespesas;
        if (_cursor.isNull(_cursorIndexOfValorDespesas)) {
          _tmpValorDespesas = null;
        } else {
          _tmpValorDespesas = _cursor.getDouble(_cursorIndexOfValorDespesas);
        }
        _item.setValorDespesas(_tmpValorDespesas);
        final Double _tmpPercentualPis;
        if (_cursor.isNull(_cursorIndexOfPercentualPis)) {
          _tmpPercentualPis = null;
        } else {
          _tmpPercentualPis = _cursor.getDouble(_cursorIndexOfPercentualPis);
        }
        _item.setPercentualPis(_tmpPercentualPis);
        final Double _tmpPercentualCofins;
        if (_cursor.isNull(_cursorIndexOfPercentualCofins)) {
          _tmpPercentualCofins = null;
        } else {
          _tmpPercentualCofins = _cursor.getDouble(_cursorIndexOfPercentualCofins);
        }
        _item.setPercentualCofins(_tmpPercentualCofins);
        final String _tmpCstPis;
        _tmpCstPis = _cursor.getString(_cursorIndexOfCstPis);
        _item.setCstPis(_tmpCstPis);
        final String _tmpCstCofins;
        _tmpCstCofins = _cursor.getString(_cursorIndexOfCstCofins);
        _item.setCstCofins(_tmpCstCofins);
        final String _tmpSituacaoTributaria;
        _tmpSituacaoTributaria = _cursor.getString(_cursorIndexOfSituacaoTributaria);
        _item.setSituacaoTributaria(_tmpSituacaoTributaria);
        final String _tmpCondicaoFaturamento;
        _tmpCondicaoFaturamento = _cursor.getString(_cursorIndexOfCondicaoFaturamento);
        _item.setCondicaoFaturamento(_tmpCondicaoFaturamento);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<ItemPrice> findPricesVnd(Long cdCustomer, Long cdItem, List<Integer> tipoItem) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT  Price.*, Item.cdItem as it_cdItem, Item.descricaoProduto as it_descricaoProduto,  Item.descricaoCilindro as it_descricaoCilindro,  Item.capacidadeProduto as it_capacidadeProduto, Item.unidadeMedida as it_unidadeMedida, Item.tax3 as it_tax3, Item.indProducao as it_indProducao, Item.tipoPressao as it_tipoPressao, Item.indRequerFator as it_indRequerFator, Item.fatorPcs as it_fatorPcs,  Item.pesoCilindro as it_pesoCilindro, Item.pesoLiqUnitario as it_pesoLiqUnitario,  Item.capacidadeCilindro as it_capacidadeCilindro,  Item.cstCilindro as it_cstCilindro, Item.cstGas as it_cstGas,  Item.classeNcmGas as it_classeNcmGas, Item.classeNcmCilindro as it_classeNcmCilindro,  Item.tipoItem as it_tipoItem, Item.tipoPropriedade as it_tipoPropriedade,  Item.fatorConversao as it_fatorConversao,  Item.indFatorConvPolegadas as it_indFatorConvPolegadas, Item.indRastreavel as it_indRastreavel  FROM Price  INNER JOIN Item ON Price.cdItem = Item.cdItem  WHERE Price.cdCustomer = ");
    _stringBuilder.append("?");
    _stringBuilder.append("    AND Price.condicaoFaturamento <> 991   AND Price.cdItem = ifnull(");
    _stringBuilder.append("?");
    _stringBuilder.append(", Price.cdItem)   AND Item.tipoItem in (");
    final int _inputSize = tipoItem.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")   AND Item.qtdCilindroCheios > 0 ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 2 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    if (cdCustomer == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cdCustomer);
    }
    _argIndex = 2;
    if (cdItem == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cdItem);
    }
    _argIndex = 3;
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
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfCdItem = _cursor.getColumnIndexOrThrow("cdItem");
      final int _cursorIndexOfFlNovoFaturamento = _cursor.getColumnIndexOrThrow("flNovoFaturamento");
      final int _cursorIndexOfPercentualIpi = _cursor.getColumnIndexOrThrow("percentualIpi");
      final int _cursorIndexOfPercentualIcms = _cursor.getColumnIndexOrThrow("percentualIcms");
      final int _cursorIndexOfPercReducaoIcms = _cursor.getColumnIndexOrThrow("percReducaoIcms");
      final int _cursorIndexOfPrecoUnitario = _cursor.getColumnIndexOrThrow("precoUnitario");
      final int _cursorIndexOfValorFrete = _cursor.getColumnIndexOrThrow("valorFrete");
      final int _cursorIndexOfValorDespesas = _cursor.getColumnIndexOrThrow("valorDespesas");
      final int _cursorIndexOfPercentualPis = _cursor.getColumnIndexOrThrow("percentualPis");
      final int _cursorIndexOfPercentualCofins = _cursor.getColumnIndexOrThrow("percentualCofins");
      final int _cursorIndexOfCstPis = _cursor.getColumnIndexOrThrow("cstPis");
      final int _cursorIndexOfCstCofins = _cursor.getColumnIndexOrThrow("cstCofins");
      final int _cursorIndexOfSituacaoTributaria = _cursor.getColumnIndexOrThrow("situacaoTributaria");
      final int _cursorIndexOfCondicaoFaturamento = _cursor.getColumnIndexOrThrow("condicaoFaturamento");
      final int _cursorIndexOfCdItem_1 = _cursor.getColumnIndexOrThrow("it_cdItem");
      final int _cursorIndexOfDescricaoProduto = _cursor.getColumnIndexOrThrow("it_descricaoProduto");
      final int _cursorIndexOfDescricaoCilindro = _cursor.getColumnIndexOrThrow("it_descricaoCilindro");
      final int _cursorIndexOfCapacidadeProduto = _cursor.getColumnIndexOrThrow("it_capacidadeProduto");
      final int _cursorIndexOfUnidadeMedida = _cursor.getColumnIndexOrThrow("it_unidadeMedida");
      final int _cursorIndexOfTax3 = _cursor.getColumnIndexOrThrow("it_tax3");
      final int _cursorIndexOfIndProducao = _cursor.getColumnIndexOrThrow("it_indProducao");
      final int _cursorIndexOfTipoPressao = _cursor.getColumnIndexOrThrow("it_tipoPressao");
      final int _cursorIndexOfIndRequerFator = _cursor.getColumnIndexOrThrow("it_indRequerFator");
      final int _cursorIndexOfFatorPcs = _cursor.getColumnIndexOrThrow("it_fatorPcs");
      final int _cursorIndexOfPesoCilindro = _cursor.getColumnIndexOrThrow("it_pesoCilindro");
      final int _cursorIndexOfPesoLiqUnitario = _cursor.getColumnIndexOrThrow("it_pesoLiqUnitario");
      final int _cursorIndexOfCapacidadeCilindro = _cursor.getColumnIndexOrThrow("it_capacidadeCilindro");
      final int _cursorIndexOfCstCilindro = _cursor.getColumnIndexOrThrow("it_cstCilindro");
      final int _cursorIndexOfCstGas = _cursor.getColumnIndexOrThrow("it_cstGas");
      final int _cursorIndexOfClasseNcmGas = _cursor.getColumnIndexOrThrow("it_classeNcmGas");
      final int _cursorIndexOfClasseNcmCilindro = _cursor.getColumnIndexOrThrow("it_classeNcmCilindro");
      final int _cursorIndexOfTipoItem = _cursor.getColumnIndexOrThrow("it_tipoItem");
      final int _cursorIndexOfTipoPropriedade = _cursor.getColumnIndexOrThrow("it_tipoPropriedade");
      final int _cursorIndexOfFatorConversao = _cursor.getColumnIndexOrThrow("it_fatorConversao");
      final int _cursorIndexOfIndFatorConvPolegadas = _cursor.getColumnIndexOrThrow("it_indFatorConvPolegadas");
      final int _cursorIndexOfIndRastreavel = _cursor.getColumnIndexOrThrow("it_indRastreavel");
      final List<ItemPrice> _result = new ArrayList<ItemPrice>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ItemPrice _item_1;
        final Price _tmpPrice;
        if (! (_cursor.isNull(_cursorIndexOfCdCustomer) && _cursor.isNull(_cursorIndexOfCdItem) && _cursor.isNull(_cursorIndexOfFlNovoFaturamento) && _cursor.isNull(_cursorIndexOfPercentualIpi) && _cursor.isNull(_cursorIndexOfPercentualIcms) && _cursor.isNull(_cursorIndexOfPercReducaoIcms) && _cursor.isNull(_cursorIndexOfPrecoUnitario) && _cursor.isNull(_cursorIndexOfValorFrete) && _cursor.isNull(_cursorIndexOfValorDespesas) && _cursor.isNull(_cursorIndexOfPercentualPis) && _cursor.isNull(_cursorIndexOfPercentualCofins) && _cursor.isNull(_cursorIndexOfCstPis) && _cursor.isNull(_cursorIndexOfCstCofins) && _cursor.isNull(_cursorIndexOfSituacaoTributaria) && _cursor.isNull(_cursorIndexOfCondicaoFaturamento))) {
          _tmpPrice = new Price();
          final Long _tmpCdCustomer;
          if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
            _tmpCdCustomer = null;
          } else {
            _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
          }
          _tmpPrice.setCdCustomer(_tmpCdCustomer);
          final Long _tmpCdItem;
          if (_cursor.isNull(_cursorIndexOfCdItem)) {
            _tmpCdItem = null;
          } else {
            _tmpCdItem = _cursor.getLong(_cursorIndexOfCdItem);
          }
          _tmpPrice.setCdItem(_tmpCdItem);
          final String _tmpFlNovoFaturamento;
          _tmpFlNovoFaturamento = _cursor.getString(_cursorIndexOfFlNovoFaturamento);
          _tmpPrice.setFlNovoFaturamento(_tmpFlNovoFaturamento);
          final Double _tmpPercentualIpi;
          if (_cursor.isNull(_cursorIndexOfPercentualIpi)) {
            _tmpPercentualIpi = null;
          } else {
            _tmpPercentualIpi = _cursor.getDouble(_cursorIndexOfPercentualIpi);
          }
          _tmpPrice.setPercentualIpi(_tmpPercentualIpi);
          final Double _tmpPercentualIcms;
          if (_cursor.isNull(_cursorIndexOfPercentualIcms)) {
            _tmpPercentualIcms = null;
          } else {
            _tmpPercentualIcms = _cursor.getDouble(_cursorIndexOfPercentualIcms);
          }
          _tmpPrice.setPercentualIcms(_tmpPercentualIcms);
          final Double _tmpPercReducaoIcms;
          if (_cursor.isNull(_cursorIndexOfPercReducaoIcms)) {
            _tmpPercReducaoIcms = null;
          } else {
            _tmpPercReducaoIcms = _cursor.getDouble(_cursorIndexOfPercReducaoIcms);
          }
          _tmpPrice.setPercReducaoIcms(_tmpPercReducaoIcms);
          final Double _tmpPrecoUnitario;
          if (_cursor.isNull(_cursorIndexOfPrecoUnitario)) {
            _tmpPrecoUnitario = null;
          } else {
            _tmpPrecoUnitario = _cursor.getDouble(_cursorIndexOfPrecoUnitario);
          }
          _tmpPrice.setPrecoUnitario(_tmpPrecoUnitario);
          final Double _tmpValorFrete;
          if (_cursor.isNull(_cursorIndexOfValorFrete)) {
            _tmpValorFrete = null;
          } else {
            _tmpValorFrete = _cursor.getDouble(_cursorIndexOfValorFrete);
          }
          _tmpPrice.setValorFrete(_tmpValorFrete);
          final Double _tmpValorDespesas;
          if (_cursor.isNull(_cursorIndexOfValorDespesas)) {
            _tmpValorDespesas = null;
          } else {
            _tmpValorDespesas = _cursor.getDouble(_cursorIndexOfValorDespesas);
          }
          _tmpPrice.setValorDespesas(_tmpValorDespesas);
          final Double _tmpPercentualPis;
          if (_cursor.isNull(_cursorIndexOfPercentualPis)) {
            _tmpPercentualPis = null;
          } else {
            _tmpPercentualPis = _cursor.getDouble(_cursorIndexOfPercentualPis);
          }
          _tmpPrice.setPercentualPis(_tmpPercentualPis);
          final Double _tmpPercentualCofins;
          if (_cursor.isNull(_cursorIndexOfPercentualCofins)) {
            _tmpPercentualCofins = null;
          } else {
            _tmpPercentualCofins = _cursor.getDouble(_cursorIndexOfPercentualCofins);
          }
          _tmpPrice.setPercentualCofins(_tmpPercentualCofins);
          final String _tmpCstPis;
          _tmpCstPis = _cursor.getString(_cursorIndexOfCstPis);
          _tmpPrice.setCstPis(_tmpCstPis);
          final String _tmpCstCofins;
          _tmpCstCofins = _cursor.getString(_cursorIndexOfCstCofins);
          _tmpPrice.setCstCofins(_tmpCstCofins);
          final String _tmpSituacaoTributaria;
          _tmpSituacaoTributaria = _cursor.getString(_cursorIndexOfSituacaoTributaria);
          _tmpPrice.setSituacaoTributaria(_tmpSituacaoTributaria);
          final String _tmpCondicaoFaturamento;
          _tmpCondicaoFaturamento = _cursor.getString(_cursorIndexOfCondicaoFaturamento);
          _tmpPrice.setCondicaoFaturamento(_tmpCondicaoFaturamento);
        }  else  {
          _tmpPrice = null;
        }
        final Item _tmpItem;
        if (! (_cursor.isNull(_cursorIndexOfCdItem_1) && _cursor.isNull(_cursorIndexOfDescricaoProduto) && _cursor.isNull(_cursorIndexOfDescricaoCilindro) && _cursor.isNull(_cursorIndexOfCapacidadeProduto) && _cursor.isNull(_cursorIndexOfUnidadeMedida) && _cursor.isNull(_cursorIndexOfTax3) && _cursor.isNull(_cursorIndexOfIndProducao) && _cursor.isNull(_cursorIndexOfTipoPressao) && _cursor.isNull(_cursorIndexOfIndRequerFator) && _cursor.isNull(_cursorIndexOfFatorPcs) && _cursor.isNull(_cursorIndexOfPesoCilindro) && _cursor.isNull(_cursorIndexOfPesoLiqUnitario) && _cursor.isNull(_cursorIndexOfCapacidadeCilindro) && _cursor.isNull(_cursorIndexOfCstCilindro) && _cursor.isNull(_cursorIndexOfCstGas) && _cursor.isNull(_cursorIndexOfClasseNcmGas) && _cursor.isNull(_cursorIndexOfClasseNcmCilindro) && _cursor.isNull(_cursorIndexOfTipoItem) && _cursor.isNull(_cursorIndexOfTipoPropriedade) && _cursor.isNull(_cursorIndexOfFatorConversao) && _cursor.isNull(_cursorIndexOfIndFatorConvPolegadas) && _cursor.isNull(_cursorIndexOfIndRastreavel))) {
          _tmpItem = new Item();
          final Long _tmpCdItem_1;
          if (_cursor.isNull(_cursorIndexOfCdItem_1)) {
            _tmpCdItem_1 = null;
          } else {
            _tmpCdItem_1 = _cursor.getLong(_cursorIndexOfCdItem_1);
          }
          _tmpItem.setCdItem(_tmpCdItem_1);
          final String _tmpDescricaoProduto;
          _tmpDescricaoProduto = _cursor.getString(_cursorIndexOfDescricaoProduto);
          _tmpItem.setDescricaoProduto(_tmpDescricaoProduto);
          final String _tmpDescricaoCilindro;
          _tmpDescricaoCilindro = _cursor.getString(_cursorIndexOfDescricaoCilindro);
          _tmpItem.setDescricaoCilindro(_tmpDescricaoCilindro);
          final Double _tmpCapacidadeProduto;
          if (_cursor.isNull(_cursorIndexOfCapacidadeProduto)) {
            _tmpCapacidadeProduto = null;
          } else {
            _tmpCapacidadeProduto = _cursor.getDouble(_cursorIndexOfCapacidadeProduto);
          }
          _tmpItem.setCapacidadeProduto(_tmpCapacidadeProduto);
          final String _tmpUnidadeMedida;
          _tmpUnidadeMedida = _cursor.getString(_cursorIndexOfUnidadeMedida);
          _tmpItem.setUnidadeMedida(_tmpUnidadeMedida);
          final String _tmpTax3;
          _tmpTax3 = _cursor.getString(_cursorIndexOfTax3);
          _tmpItem.setTax3(_tmpTax3);
          final String _tmpIndProducao;
          _tmpIndProducao = _cursor.getString(_cursorIndexOfIndProducao);
          _tmpItem.setIndProducao(_tmpIndProducao);
          final Integer _tmpTipoPressao;
          if (_cursor.isNull(_cursorIndexOfTipoPressao)) {
            _tmpTipoPressao = null;
          } else {
            _tmpTipoPressao = _cursor.getInt(_cursorIndexOfTipoPressao);
          }
          _tmpItem.setTipoPressao(_tmpTipoPressao);
          final Integer _tmpIndRequerFator;
          if (_cursor.isNull(_cursorIndexOfIndRequerFator)) {
            _tmpIndRequerFator = null;
          } else {
            _tmpIndRequerFator = _cursor.getInt(_cursorIndexOfIndRequerFator);
          }
          _tmpItem.setIndRequerFator(_tmpIndRequerFator);
          final Double _tmpFatorPcs;
          if (_cursor.isNull(_cursorIndexOfFatorPcs)) {
            _tmpFatorPcs = null;
          } else {
            _tmpFatorPcs = _cursor.getDouble(_cursorIndexOfFatorPcs);
          }
          _tmpItem.setFatorPcs(_tmpFatorPcs);
          final Double _tmpPesoCilindro;
          if (_cursor.isNull(_cursorIndexOfPesoCilindro)) {
            _tmpPesoCilindro = null;
          } else {
            _tmpPesoCilindro = _cursor.getDouble(_cursorIndexOfPesoCilindro);
          }
          _tmpItem.setPesoCilindro(_tmpPesoCilindro);
          final Double _tmpPesoLiqUnitario;
          if (_cursor.isNull(_cursorIndexOfPesoLiqUnitario)) {
            _tmpPesoLiqUnitario = null;
          } else {
            _tmpPesoLiqUnitario = _cursor.getDouble(_cursorIndexOfPesoLiqUnitario);
          }
          _tmpItem.setPesoLiqUnitario(_tmpPesoLiqUnitario);
          final Double _tmpCapacidadeCilindro;
          if (_cursor.isNull(_cursorIndexOfCapacidadeCilindro)) {
            _tmpCapacidadeCilindro = null;
          } else {
            _tmpCapacidadeCilindro = _cursor.getDouble(_cursorIndexOfCapacidadeCilindro);
          }
          _tmpItem.setCapacidadeCilindro(_tmpCapacidadeCilindro);
          final String _tmpCstCilindro;
          _tmpCstCilindro = _cursor.getString(_cursorIndexOfCstCilindro);
          _tmpItem.setCstCilindro(_tmpCstCilindro);
          final String _tmpCstGas;
          _tmpCstGas = _cursor.getString(_cursorIndexOfCstGas);
          _tmpItem.setCstGas(_tmpCstGas);
          final Long _tmpClasseNcmGas;
          if (_cursor.isNull(_cursorIndexOfClasseNcmGas)) {
            _tmpClasseNcmGas = null;
          } else {
            _tmpClasseNcmGas = _cursor.getLong(_cursorIndexOfClasseNcmGas);
          }
          _tmpItem.setClasseNcmGas(_tmpClasseNcmGas);
          final Long _tmpClasseNcmCilindro;
          if (_cursor.isNull(_cursorIndexOfClasseNcmCilindro)) {
            _tmpClasseNcmCilindro = null;
          } else {
            _tmpClasseNcmCilindro = _cursor.getLong(_cursorIndexOfClasseNcmCilindro);
          }
          _tmpItem.setClasseNcmCilindro(_tmpClasseNcmCilindro);
          final Integer _tmpTipoItem;
          if (_cursor.isNull(_cursorIndexOfTipoItem)) {
            _tmpTipoItem = null;
          } else {
            _tmpTipoItem = _cursor.getInt(_cursorIndexOfTipoItem);
          }
          _tmpItem.setTipoItem(_tmpTipoItem);
          final String _tmpTipoPropriedade;
          _tmpTipoPropriedade = _cursor.getString(_cursorIndexOfTipoPropriedade);
          _tmpItem.setTipoPropriedade(_tmpTipoPropriedade);
          final Double _tmpFatorConversao;
          if (_cursor.isNull(_cursorIndexOfFatorConversao)) {
            _tmpFatorConversao = null;
          } else {
            _tmpFatorConversao = _cursor.getDouble(_cursorIndexOfFatorConversao);
          }
          _tmpItem.setFatorConversao(_tmpFatorConversao);
          final String _tmpIndFatorConvPolegadas;
          _tmpIndFatorConvPolegadas = _cursor.getString(_cursorIndexOfIndFatorConvPolegadas);
          _tmpItem.setIndFatorConvPolegadas(_tmpIndFatorConvPolegadas);
          final String _tmpIndRastreavel;
          _tmpIndRastreavel = _cursor.getString(_cursorIndexOfIndRastreavel);
          _tmpItem.setIndRastreavel(_tmpIndRastreavel);
        }  else  {
          _tmpItem = null;
        }
        _item_1 = new ItemPrice();
        _item_1.setPrice(_tmpPrice);
        _item_1.setItem(_tmpItem);
        _result.add(_item_1);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<ItemPrice> findPricesVor(Long cdCustomer, Long cdItem, List<Integer> tipoItem) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT  Price.*, Item.cdItem as it_cdItem, Item.descricaoProduto as it_descricaoProduto, Item.capacidadeProduto as it_capacidadeProduto, Item.unidadeMedida as it_unidadeMedida, Item.descricaoCilindro as it_descricaoCilindro,  Item.tax3 as it_tax3, Item.indProducao as it_indProducao, Item.tipoPressao as it_tipoPressao, Item.indRequerFator as it_indRequerFator, Item.fatorPcs as it_fatorPcs,  Item.pesoCilindro as it_pesoCilindro, Item.pesoLiqUnitario as it_pesoLiqUnitario,  Item.capacidadeCilindro as it_capacidadeCilindro,  Item.cstCilindro as it_cstCilindro, Item.cstGas as it_cstGas,  Item.classeNcmGas as it_classeNcmGas, Item.classeNcmCilindro as it_classeNcmCilindro,  Item.tipoItem as it_tipoItem, Item.tipoPropriedade as it_tipoPropriedade,  Item.fatorConversao as it_fatorConversao,  Item.indFatorConvPolegadas as it_indFatorConvPolegadas, Item.indRastreavel as it_indRastreavel  FROM Price  INNER JOIN Item ON Price.cdItem = Item.cdItem  WHERE Price.cdCustomer = ");
    _stringBuilder.append("?");
    _stringBuilder.append("    AND Price.condicaoFaturamento <> 991   AND Price.cdItem = ifnull(");
    _stringBuilder.append("?");
    _stringBuilder.append(", Price.cdItem)   AND Item.tipoItem in (");
    final int _inputSize = tipoItem.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 2 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    if (cdCustomer == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cdCustomer);
    }
    _argIndex = 2;
    if (cdItem == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cdItem);
    }
    _argIndex = 3;
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
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfCdItem = _cursor.getColumnIndexOrThrow("cdItem");
      final int _cursorIndexOfFlNovoFaturamento = _cursor.getColumnIndexOrThrow("flNovoFaturamento");
      final int _cursorIndexOfPercentualIpi = _cursor.getColumnIndexOrThrow("percentualIpi");
      final int _cursorIndexOfPercentualIcms = _cursor.getColumnIndexOrThrow("percentualIcms");
      final int _cursorIndexOfPercReducaoIcms = _cursor.getColumnIndexOrThrow("percReducaoIcms");
      final int _cursorIndexOfPrecoUnitario = _cursor.getColumnIndexOrThrow("precoUnitario");
      final int _cursorIndexOfValorFrete = _cursor.getColumnIndexOrThrow("valorFrete");
      final int _cursorIndexOfValorDespesas = _cursor.getColumnIndexOrThrow("valorDespesas");
      final int _cursorIndexOfPercentualPis = _cursor.getColumnIndexOrThrow("percentualPis");
      final int _cursorIndexOfPercentualCofins = _cursor.getColumnIndexOrThrow("percentualCofins");
      final int _cursorIndexOfCstPis = _cursor.getColumnIndexOrThrow("cstPis");
      final int _cursorIndexOfCstCofins = _cursor.getColumnIndexOrThrow("cstCofins");
      final int _cursorIndexOfSituacaoTributaria = _cursor.getColumnIndexOrThrow("situacaoTributaria");
      final int _cursorIndexOfCondicaoFaturamento = _cursor.getColumnIndexOrThrow("condicaoFaturamento");
      final int _cursorIndexOfCdItem_1 = _cursor.getColumnIndexOrThrow("it_cdItem");
      final int _cursorIndexOfDescricaoProduto = _cursor.getColumnIndexOrThrow("it_descricaoProduto");
      final int _cursorIndexOfCapacidadeProduto = _cursor.getColumnIndexOrThrow("it_capacidadeProduto");
      final int _cursorIndexOfUnidadeMedida = _cursor.getColumnIndexOrThrow("it_unidadeMedida");
      final int _cursorIndexOfDescricaoCilindro = _cursor.getColumnIndexOrThrow("it_descricaoCilindro");
      final int _cursorIndexOfTax3 = _cursor.getColumnIndexOrThrow("it_tax3");
      final int _cursorIndexOfIndProducao = _cursor.getColumnIndexOrThrow("it_indProducao");
      final int _cursorIndexOfTipoPressao = _cursor.getColumnIndexOrThrow("it_tipoPressao");
      final int _cursorIndexOfIndRequerFator = _cursor.getColumnIndexOrThrow("it_indRequerFator");
      final int _cursorIndexOfFatorPcs = _cursor.getColumnIndexOrThrow("it_fatorPcs");
      final int _cursorIndexOfPesoCilindro = _cursor.getColumnIndexOrThrow("it_pesoCilindro");
      final int _cursorIndexOfPesoLiqUnitario = _cursor.getColumnIndexOrThrow("it_pesoLiqUnitario");
      final int _cursorIndexOfCapacidadeCilindro = _cursor.getColumnIndexOrThrow("it_capacidadeCilindro");
      final int _cursorIndexOfCstCilindro = _cursor.getColumnIndexOrThrow("it_cstCilindro");
      final int _cursorIndexOfCstGas = _cursor.getColumnIndexOrThrow("it_cstGas");
      final int _cursorIndexOfClasseNcmGas = _cursor.getColumnIndexOrThrow("it_classeNcmGas");
      final int _cursorIndexOfClasseNcmCilindro = _cursor.getColumnIndexOrThrow("it_classeNcmCilindro");
      final int _cursorIndexOfTipoItem = _cursor.getColumnIndexOrThrow("it_tipoItem");
      final int _cursorIndexOfTipoPropriedade = _cursor.getColumnIndexOrThrow("it_tipoPropriedade");
      final int _cursorIndexOfFatorConversao = _cursor.getColumnIndexOrThrow("it_fatorConversao");
      final int _cursorIndexOfIndFatorConvPolegadas = _cursor.getColumnIndexOrThrow("it_indFatorConvPolegadas");
      final int _cursorIndexOfIndRastreavel = _cursor.getColumnIndexOrThrow("it_indRastreavel");
      final List<ItemPrice> _result = new ArrayList<ItemPrice>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ItemPrice _item_1;
        final Price _tmpPrice;
        if (! (_cursor.isNull(_cursorIndexOfCdCustomer) && _cursor.isNull(_cursorIndexOfCdItem) && _cursor.isNull(_cursorIndexOfFlNovoFaturamento) && _cursor.isNull(_cursorIndexOfPercentualIpi) && _cursor.isNull(_cursorIndexOfPercentualIcms) && _cursor.isNull(_cursorIndexOfPercReducaoIcms) && _cursor.isNull(_cursorIndexOfPrecoUnitario) && _cursor.isNull(_cursorIndexOfValorFrete) && _cursor.isNull(_cursorIndexOfValorDespesas) && _cursor.isNull(_cursorIndexOfPercentualPis) && _cursor.isNull(_cursorIndexOfPercentualCofins) && _cursor.isNull(_cursorIndexOfCstPis) && _cursor.isNull(_cursorIndexOfCstCofins) && _cursor.isNull(_cursorIndexOfSituacaoTributaria) && _cursor.isNull(_cursorIndexOfCondicaoFaturamento))) {
          _tmpPrice = new Price();
          final Long _tmpCdCustomer;
          if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
            _tmpCdCustomer = null;
          } else {
            _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
          }
          _tmpPrice.setCdCustomer(_tmpCdCustomer);
          final Long _tmpCdItem;
          if (_cursor.isNull(_cursorIndexOfCdItem)) {
            _tmpCdItem = null;
          } else {
            _tmpCdItem = _cursor.getLong(_cursorIndexOfCdItem);
          }
          _tmpPrice.setCdItem(_tmpCdItem);
          final String _tmpFlNovoFaturamento;
          _tmpFlNovoFaturamento = _cursor.getString(_cursorIndexOfFlNovoFaturamento);
          _tmpPrice.setFlNovoFaturamento(_tmpFlNovoFaturamento);
          final Double _tmpPercentualIpi;
          if (_cursor.isNull(_cursorIndexOfPercentualIpi)) {
            _tmpPercentualIpi = null;
          } else {
            _tmpPercentualIpi = _cursor.getDouble(_cursorIndexOfPercentualIpi);
          }
          _tmpPrice.setPercentualIpi(_tmpPercentualIpi);
          final Double _tmpPercentualIcms;
          if (_cursor.isNull(_cursorIndexOfPercentualIcms)) {
            _tmpPercentualIcms = null;
          } else {
            _tmpPercentualIcms = _cursor.getDouble(_cursorIndexOfPercentualIcms);
          }
          _tmpPrice.setPercentualIcms(_tmpPercentualIcms);
          final Double _tmpPercReducaoIcms;
          if (_cursor.isNull(_cursorIndexOfPercReducaoIcms)) {
            _tmpPercReducaoIcms = null;
          } else {
            _tmpPercReducaoIcms = _cursor.getDouble(_cursorIndexOfPercReducaoIcms);
          }
          _tmpPrice.setPercReducaoIcms(_tmpPercReducaoIcms);
          final Double _tmpPrecoUnitario;
          if (_cursor.isNull(_cursorIndexOfPrecoUnitario)) {
            _tmpPrecoUnitario = null;
          } else {
            _tmpPrecoUnitario = _cursor.getDouble(_cursorIndexOfPrecoUnitario);
          }
          _tmpPrice.setPrecoUnitario(_tmpPrecoUnitario);
          final Double _tmpValorFrete;
          if (_cursor.isNull(_cursorIndexOfValorFrete)) {
            _tmpValorFrete = null;
          } else {
            _tmpValorFrete = _cursor.getDouble(_cursorIndexOfValorFrete);
          }
          _tmpPrice.setValorFrete(_tmpValorFrete);
          final Double _tmpValorDespesas;
          if (_cursor.isNull(_cursorIndexOfValorDespesas)) {
            _tmpValorDespesas = null;
          } else {
            _tmpValorDespesas = _cursor.getDouble(_cursorIndexOfValorDespesas);
          }
          _tmpPrice.setValorDespesas(_tmpValorDespesas);
          final Double _tmpPercentualPis;
          if (_cursor.isNull(_cursorIndexOfPercentualPis)) {
            _tmpPercentualPis = null;
          } else {
            _tmpPercentualPis = _cursor.getDouble(_cursorIndexOfPercentualPis);
          }
          _tmpPrice.setPercentualPis(_tmpPercentualPis);
          final Double _tmpPercentualCofins;
          if (_cursor.isNull(_cursorIndexOfPercentualCofins)) {
            _tmpPercentualCofins = null;
          } else {
            _tmpPercentualCofins = _cursor.getDouble(_cursorIndexOfPercentualCofins);
          }
          _tmpPrice.setPercentualCofins(_tmpPercentualCofins);
          final String _tmpCstPis;
          _tmpCstPis = _cursor.getString(_cursorIndexOfCstPis);
          _tmpPrice.setCstPis(_tmpCstPis);
          final String _tmpCstCofins;
          _tmpCstCofins = _cursor.getString(_cursorIndexOfCstCofins);
          _tmpPrice.setCstCofins(_tmpCstCofins);
          final String _tmpSituacaoTributaria;
          _tmpSituacaoTributaria = _cursor.getString(_cursorIndexOfSituacaoTributaria);
          _tmpPrice.setSituacaoTributaria(_tmpSituacaoTributaria);
          final String _tmpCondicaoFaturamento;
          _tmpCondicaoFaturamento = _cursor.getString(_cursorIndexOfCondicaoFaturamento);
          _tmpPrice.setCondicaoFaturamento(_tmpCondicaoFaturamento);
        }  else  {
          _tmpPrice = null;
        }
        final Item _tmpItem;
        if (! (_cursor.isNull(_cursorIndexOfCdItem_1) && _cursor.isNull(_cursorIndexOfDescricaoProduto) && _cursor.isNull(_cursorIndexOfCapacidadeProduto) && _cursor.isNull(_cursorIndexOfUnidadeMedida) && _cursor.isNull(_cursorIndexOfDescricaoCilindro) && _cursor.isNull(_cursorIndexOfTax3) && _cursor.isNull(_cursorIndexOfIndProducao) && _cursor.isNull(_cursorIndexOfTipoPressao) && _cursor.isNull(_cursorIndexOfIndRequerFator) && _cursor.isNull(_cursorIndexOfFatorPcs) && _cursor.isNull(_cursorIndexOfPesoCilindro) && _cursor.isNull(_cursorIndexOfPesoLiqUnitario) && _cursor.isNull(_cursorIndexOfCapacidadeCilindro) && _cursor.isNull(_cursorIndexOfCstCilindro) && _cursor.isNull(_cursorIndexOfCstGas) && _cursor.isNull(_cursorIndexOfClasseNcmGas) && _cursor.isNull(_cursorIndexOfClasseNcmCilindro) && _cursor.isNull(_cursorIndexOfTipoItem) && _cursor.isNull(_cursorIndexOfTipoPropriedade) && _cursor.isNull(_cursorIndexOfFatorConversao) && _cursor.isNull(_cursorIndexOfIndFatorConvPolegadas) && _cursor.isNull(_cursorIndexOfIndRastreavel))) {
          _tmpItem = new Item();
          final Long _tmpCdItem_1;
          if (_cursor.isNull(_cursorIndexOfCdItem_1)) {
            _tmpCdItem_1 = null;
          } else {
            _tmpCdItem_1 = _cursor.getLong(_cursorIndexOfCdItem_1);
          }
          _tmpItem.setCdItem(_tmpCdItem_1);
          final String _tmpDescricaoProduto;
          _tmpDescricaoProduto = _cursor.getString(_cursorIndexOfDescricaoProduto);
          _tmpItem.setDescricaoProduto(_tmpDescricaoProduto);
          final Double _tmpCapacidadeProduto;
          if (_cursor.isNull(_cursorIndexOfCapacidadeProduto)) {
            _tmpCapacidadeProduto = null;
          } else {
            _tmpCapacidadeProduto = _cursor.getDouble(_cursorIndexOfCapacidadeProduto);
          }
          _tmpItem.setCapacidadeProduto(_tmpCapacidadeProduto);
          final String _tmpUnidadeMedida;
          _tmpUnidadeMedida = _cursor.getString(_cursorIndexOfUnidadeMedida);
          _tmpItem.setUnidadeMedida(_tmpUnidadeMedida);
          final String _tmpDescricaoCilindro;
          _tmpDescricaoCilindro = _cursor.getString(_cursorIndexOfDescricaoCilindro);
          _tmpItem.setDescricaoCilindro(_tmpDescricaoCilindro);
          final String _tmpTax3;
          _tmpTax3 = _cursor.getString(_cursorIndexOfTax3);
          _tmpItem.setTax3(_tmpTax3);
          final String _tmpIndProducao;
          _tmpIndProducao = _cursor.getString(_cursorIndexOfIndProducao);
          _tmpItem.setIndProducao(_tmpIndProducao);
          final Integer _tmpTipoPressao;
          if (_cursor.isNull(_cursorIndexOfTipoPressao)) {
            _tmpTipoPressao = null;
          } else {
            _tmpTipoPressao = _cursor.getInt(_cursorIndexOfTipoPressao);
          }
          _tmpItem.setTipoPressao(_tmpTipoPressao);
          final Integer _tmpIndRequerFator;
          if (_cursor.isNull(_cursorIndexOfIndRequerFator)) {
            _tmpIndRequerFator = null;
          } else {
            _tmpIndRequerFator = _cursor.getInt(_cursorIndexOfIndRequerFator);
          }
          _tmpItem.setIndRequerFator(_tmpIndRequerFator);
          final Double _tmpFatorPcs;
          if (_cursor.isNull(_cursorIndexOfFatorPcs)) {
            _tmpFatorPcs = null;
          } else {
            _tmpFatorPcs = _cursor.getDouble(_cursorIndexOfFatorPcs);
          }
          _tmpItem.setFatorPcs(_tmpFatorPcs);
          final Double _tmpPesoCilindro;
          if (_cursor.isNull(_cursorIndexOfPesoCilindro)) {
            _tmpPesoCilindro = null;
          } else {
            _tmpPesoCilindro = _cursor.getDouble(_cursorIndexOfPesoCilindro);
          }
          _tmpItem.setPesoCilindro(_tmpPesoCilindro);
          final Double _tmpPesoLiqUnitario;
          if (_cursor.isNull(_cursorIndexOfPesoLiqUnitario)) {
            _tmpPesoLiqUnitario = null;
          } else {
            _tmpPesoLiqUnitario = _cursor.getDouble(_cursorIndexOfPesoLiqUnitario);
          }
          _tmpItem.setPesoLiqUnitario(_tmpPesoLiqUnitario);
          final Double _tmpCapacidadeCilindro;
          if (_cursor.isNull(_cursorIndexOfCapacidadeCilindro)) {
            _tmpCapacidadeCilindro = null;
          } else {
            _tmpCapacidadeCilindro = _cursor.getDouble(_cursorIndexOfCapacidadeCilindro);
          }
          _tmpItem.setCapacidadeCilindro(_tmpCapacidadeCilindro);
          final String _tmpCstCilindro;
          _tmpCstCilindro = _cursor.getString(_cursorIndexOfCstCilindro);
          _tmpItem.setCstCilindro(_tmpCstCilindro);
          final String _tmpCstGas;
          _tmpCstGas = _cursor.getString(_cursorIndexOfCstGas);
          _tmpItem.setCstGas(_tmpCstGas);
          final Long _tmpClasseNcmGas;
          if (_cursor.isNull(_cursorIndexOfClasseNcmGas)) {
            _tmpClasseNcmGas = null;
          } else {
            _tmpClasseNcmGas = _cursor.getLong(_cursorIndexOfClasseNcmGas);
          }
          _tmpItem.setClasseNcmGas(_tmpClasseNcmGas);
          final Long _tmpClasseNcmCilindro;
          if (_cursor.isNull(_cursorIndexOfClasseNcmCilindro)) {
            _tmpClasseNcmCilindro = null;
          } else {
            _tmpClasseNcmCilindro = _cursor.getLong(_cursorIndexOfClasseNcmCilindro);
          }
          _tmpItem.setClasseNcmCilindro(_tmpClasseNcmCilindro);
          final Integer _tmpTipoItem;
          if (_cursor.isNull(_cursorIndexOfTipoItem)) {
            _tmpTipoItem = null;
          } else {
            _tmpTipoItem = _cursor.getInt(_cursorIndexOfTipoItem);
          }
          _tmpItem.setTipoItem(_tmpTipoItem);
          final String _tmpTipoPropriedade;
          _tmpTipoPropriedade = _cursor.getString(_cursorIndexOfTipoPropriedade);
          _tmpItem.setTipoPropriedade(_tmpTipoPropriedade);
          final Double _tmpFatorConversao;
          if (_cursor.isNull(_cursorIndexOfFatorConversao)) {
            _tmpFatorConversao = null;
          } else {
            _tmpFatorConversao = _cursor.getDouble(_cursorIndexOfFatorConversao);
          }
          _tmpItem.setFatorConversao(_tmpFatorConversao);
          final String _tmpIndFatorConvPolegadas;
          _tmpIndFatorConvPolegadas = _cursor.getString(_cursorIndexOfIndFatorConvPolegadas);
          _tmpItem.setIndFatorConvPolegadas(_tmpIndFatorConvPolegadas);
          final String _tmpIndRastreavel;
          _tmpIndRastreavel = _cursor.getString(_cursorIndexOfIndRastreavel);
          _tmpItem.setIndRastreavel(_tmpIndRastreavel);
        }  else  {
          _tmpItem = null;
        }
        _item_1 = new ItemPrice();
        _item_1.setPrice(_tmpPrice);
        _item_1.setItem(_tmpItem);
        _result.add(_item_1);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<ItemPrice> findPricesRcl(Long cdItem, List<Integer> tipoItem) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT Item.cdItem as it_cdItem, Item.cdCilindro as it_cdCilindro, Item.descricaoCilindro as it_descricaoCilindro, Item.tipoPressao as it_tipoPressao, Item.descricaoProduto as it_descricaoProduto, Item.valorIndenizacao as it_valorIndenizacao, Item.capacidadeProduto as it_capacidadeProduto, Item.unidadeMedida as it_unidadeMedida,Item.tax3 as it_tax3, Item.indProducao as it_indProducao, Item.indRequerFator as it_indRequerFator, Item.pesoCilindro as it_pesoCilindro, Item.pesoLiqUnitario as it_pesoLiqUnitario, Item.capacidadeCilindro as it_capacidadeCilindro,Item.cstCilindro as it_cstCilindro, Item.cstGas as it_cstGas, Item.classeNcmGas as it_classeNcmGas, Item.classeNcmCilindro as it_classeNcmCilindro, Item.tipoItem as it_tipoItem, Item.tipoPropriedade as it_tipoPropriedade, Item.fatorConversao as it_fatorConversao, Item.indFatorConvPolegadas as it_indFatorConvPolegadas,Route.valorIndenizacaoAlta as rt_valorIndenizacaoAlta, Route.valorIndenizacaoBaixa as rt_valorIndenizacaoBaixa, Item.indRastreavel as it_indRastreavel FROM Item INNER JOIN Route WHERE cdCilindro > 0  AND Item.tipoItem in (");
    final int _inputSize = tipoItem.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")  AND Item.cdItem = ifnull(");
    _stringBuilder.append("?");
    _stringBuilder.append(", Item.cdItem)");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 1 + _inputSize;
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
    _argIndex = 1 + _inputSize;
    if (cdItem == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cdItem);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCdItem = _cursor.getColumnIndexOrThrow("it_cdItem");
      final int _cursorIndexOfCdCilindro = _cursor.getColumnIndexOrThrow("it_cdCilindro");
      final int _cursorIndexOfDescricaoCilindro = _cursor.getColumnIndexOrThrow("it_descricaoCilindro");
      final int _cursorIndexOfTipoPressao = _cursor.getColumnIndexOrThrow("it_tipoPressao");
      final int _cursorIndexOfDescricaoProduto = _cursor.getColumnIndexOrThrow("it_descricaoProduto");
      final int _cursorIndexOfValorIndenizacao = _cursor.getColumnIndexOrThrow("it_valorIndenizacao");
      final int _cursorIndexOfCapacidadeProduto = _cursor.getColumnIndexOrThrow("it_capacidadeProduto");
      final int _cursorIndexOfUnidadeMedida = _cursor.getColumnIndexOrThrow("it_unidadeMedida");
      final int _cursorIndexOfTax3 = _cursor.getColumnIndexOrThrow("it_tax3");
      final int _cursorIndexOfIndProducao = _cursor.getColumnIndexOrThrow("it_indProducao");
      final int _cursorIndexOfIndRequerFator = _cursor.getColumnIndexOrThrow("it_indRequerFator");
      final int _cursorIndexOfPesoCilindro = _cursor.getColumnIndexOrThrow("it_pesoCilindro");
      final int _cursorIndexOfPesoLiqUnitario = _cursor.getColumnIndexOrThrow("it_pesoLiqUnitario");
      final int _cursorIndexOfCapacidadeCilindro = _cursor.getColumnIndexOrThrow("it_capacidadeCilindro");
      final int _cursorIndexOfCstCilindro = _cursor.getColumnIndexOrThrow("it_cstCilindro");
      final int _cursorIndexOfCstGas = _cursor.getColumnIndexOrThrow("it_cstGas");
      final int _cursorIndexOfClasseNcmGas = _cursor.getColumnIndexOrThrow("it_classeNcmGas");
      final int _cursorIndexOfClasseNcmCilindro = _cursor.getColumnIndexOrThrow("it_classeNcmCilindro");
      final int _cursorIndexOfTipoItem = _cursor.getColumnIndexOrThrow("it_tipoItem");
      final int _cursorIndexOfTipoPropriedade = _cursor.getColumnIndexOrThrow("it_tipoPropriedade");
      final int _cursorIndexOfFatorConversao = _cursor.getColumnIndexOrThrow("it_fatorConversao");
      final int _cursorIndexOfIndFatorConvPolegadas = _cursor.getColumnIndexOrThrow("it_indFatorConvPolegadas");
      final int _cursorIndexOfValorIndenizacaoAlta = _cursor.getColumnIndexOrThrow("rt_valorIndenizacaoAlta");
      final int _cursorIndexOfValorIndenizacaoBaixa = _cursor.getColumnIndexOrThrow("rt_valorIndenizacaoBaixa");
      final int _cursorIndexOfIndRastreavel = _cursor.getColumnIndexOrThrow("it_indRastreavel");
      final List<ItemPrice> _result = new ArrayList<ItemPrice>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ItemPrice _item_1;
        final Item _tmpItem;
        if (! (_cursor.isNull(_cursorIndexOfCdItem) && _cursor.isNull(_cursorIndexOfCdCilindro) && _cursor.isNull(_cursorIndexOfDescricaoCilindro) && _cursor.isNull(_cursorIndexOfTipoPressao) && _cursor.isNull(_cursorIndexOfDescricaoProduto) && _cursor.isNull(_cursorIndexOfValorIndenizacao) && _cursor.isNull(_cursorIndexOfCapacidadeProduto) && _cursor.isNull(_cursorIndexOfUnidadeMedida) && _cursor.isNull(_cursorIndexOfTax3) && _cursor.isNull(_cursorIndexOfIndProducao) && _cursor.isNull(_cursorIndexOfIndRequerFator) && _cursor.isNull(_cursorIndexOfPesoCilindro) && _cursor.isNull(_cursorIndexOfPesoLiqUnitario) && _cursor.isNull(_cursorIndexOfCapacidadeCilindro) && _cursor.isNull(_cursorIndexOfCstCilindro) && _cursor.isNull(_cursorIndexOfCstGas) && _cursor.isNull(_cursorIndexOfClasseNcmGas) && _cursor.isNull(_cursorIndexOfClasseNcmCilindro) && _cursor.isNull(_cursorIndexOfTipoItem) && _cursor.isNull(_cursorIndexOfTipoPropriedade) && _cursor.isNull(_cursorIndexOfFatorConversao) && _cursor.isNull(_cursorIndexOfIndFatorConvPolegadas) && _cursor.isNull(_cursorIndexOfIndRastreavel))) {
          _tmpItem = new Item();
          final Long _tmpCdItem;
          if (_cursor.isNull(_cursorIndexOfCdItem)) {
            _tmpCdItem = null;
          } else {
            _tmpCdItem = _cursor.getLong(_cursorIndexOfCdItem);
          }
          _tmpItem.setCdItem(_tmpCdItem);
          final Long _tmpCdCilindro;
          if (_cursor.isNull(_cursorIndexOfCdCilindro)) {
            _tmpCdCilindro = null;
          } else {
            _tmpCdCilindro = _cursor.getLong(_cursorIndexOfCdCilindro);
          }
          _tmpItem.setCdCilindro(_tmpCdCilindro);
          final String _tmpDescricaoCilindro;
          _tmpDescricaoCilindro = _cursor.getString(_cursorIndexOfDescricaoCilindro);
          _tmpItem.setDescricaoCilindro(_tmpDescricaoCilindro);
          final Integer _tmpTipoPressao;
          if (_cursor.isNull(_cursorIndexOfTipoPressao)) {
            _tmpTipoPressao = null;
          } else {
            _tmpTipoPressao = _cursor.getInt(_cursorIndexOfTipoPressao);
          }
          _tmpItem.setTipoPressao(_tmpTipoPressao);
          final String _tmpDescricaoProduto;
          _tmpDescricaoProduto = _cursor.getString(_cursorIndexOfDescricaoProduto);
          _tmpItem.setDescricaoProduto(_tmpDescricaoProduto);
          final Double _tmpValorIndenizacao;
          if (_cursor.isNull(_cursorIndexOfValorIndenizacao)) {
            _tmpValorIndenizacao = null;
          } else {
            _tmpValorIndenizacao = _cursor.getDouble(_cursorIndexOfValorIndenizacao);
          }
          _tmpItem.setValorIndenizacao(_tmpValorIndenizacao);
          final Double _tmpCapacidadeProduto;
          if (_cursor.isNull(_cursorIndexOfCapacidadeProduto)) {
            _tmpCapacidadeProduto = null;
          } else {
            _tmpCapacidadeProduto = _cursor.getDouble(_cursorIndexOfCapacidadeProduto);
          }
          _tmpItem.setCapacidadeProduto(_tmpCapacidadeProduto);
          final String _tmpUnidadeMedida;
          _tmpUnidadeMedida = _cursor.getString(_cursorIndexOfUnidadeMedida);
          _tmpItem.setUnidadeMedida(_tmpUnidadeMedida);
          final String _tmpTax3;
          _tmpTax3 = _cursor.getString(_cursorIndexOfTax3);
          _tmpItem.setTax3(_tmpTax3);
          final String _tmpIndProducao;
          _tmpIndProducao = _cursor.getString(_cursorIndexOfIndProducao);
          _tmpItem.setIndProducao(_tmpIndProducao);
          final Integer _tmpIndRequerFator;
          if (_cursor.isNull(_cursorIndexOfIndRequerFator)) {
            _tmpIndRequerFator = null;
          } else {
            _tmpIndRequerFator = _cursor.getInt(_cursorIndexOfIndRequerFator);
          }
          _tmpItem.setIndRequerFator(_tmpIndRequerFator);
          final Double _tmpPesoCilindro;
          if (_cursor.isNull(_cursorIndexOfPesoCilindro)) {
            _tmpPesoCilindro = null;
          } else {
            _tmpPesoCilindro = _cursor.getDouble(_cursorIndexOfPesoCilindro);
          }
          _tmpItem.setPesoCilindro(_tmpPesoCilindro);
          final Double _tmpPesoLiqUnitario;
          if (_cursor.isNull(_cursorIndexOfPesoLiqUnitario)) {
            _tmpPesoLiqUnitario = null;
          } else {
            _tmpPesoLiqUnitario = _cursor.getDouble(_cursorIndexOfPesoLiqUnitario);
          }
          _tmpItem.setPesoLiqUnitario(_tmpPesoLiqUnitario);
          final Double _tmpCapacidadeCilindro;
          if (_cursor.isNull(_cursorIndexOfCapacidadeCilindro)) {
            _tmpCapacidadeCilindro = null;
          } else {
            _tmpCapacidadeCilindro = _cursor.getDouble(_cursorIndexOfCapacidadeCilindro);
          }
          _tmpItem.setCapacidadeCilindro(_tmpCapacidadeCilindro);
          final String _tmpCstCilindro;
          _tmpCstCilindro = _cursor.getString(_cursorIndexOfCstCilindro);
          _tmpItem.setCstCilindro(_tmpCstCilindro);
          final String _tmpCstGas;
          _tmpCstGas = _cursor.getString(_cursorIndexOfCstGas);
          _tmpItem.setCstGas(_tmpCstGas);
          final Long _tmpClasseNcmGas;
          if (_cursor.isNull(_cursorIndexOfClasseNcmGas)) {
            _tmpClasseNcmGas = null;
          } else {
            _tmpClasseNcmGas = _cursor.getLong(_cursorIndexOfClasseNcmGas);
          }
          _tmpItem.setClasseNcmGas(_tmpClasseNcmGas);
          final Long _tmpClasseNcmCilindro;
          if (_cursor.isNull(_cursorIndexOfClasseNcmCilindro)) {
            _tmpClasseNcmCilindro = null;
          } else {
            _tmpClasseNcmCilindro = _cursor.getLong(_cursorIndexOfClasseNcmCilindro);
          }
          _tmpItem.setClasseNcmCilindro(_tmpClasseNcmCilindro);
          final Integer _tmpTipoItem;
          if (_cursor.isNull(_cursorIndexOfTipoItem)) {
            _tmpTipoItem = null;
          } else {
            _tmpTipoItem = _cursor.getInt(_cursorIndexOfTipoItem);
          }
          _tmpItem.setTipoItem(_tmpTipoItem);
          final String _tmpTipoPropriedade;
          _tmpTipoPropriedade = _cursor.getString(_cursorIndexOfTipoPropriedade);
          _tmpItem.setTipoPropriedade(_tmpTipoPropriedade);
          final Double _tmpFatorConversao;
          if (_cursor.isNull(_cursorIndexOfFatorConversao)) {
            _tmpFatorConversao = null;
          } else {
            _tmpFatorConversao = _cursor.getDouble(_cursorIndexOfFatorConversao);
          }
          _tmpItem.setFatorConversao(_tmpFatorConversao);
          final String _tmpIndFatorConvPolegadas;
          _tmpIndFatorConvPolegadas = _cursor.getString(_cursorIndexOfIndFatorConvPolegadas);
          _tmpItem.setIndFatorConvPolegadas(_tmpIndFatorConvPolegadas);
          final String _tmpIndRastreavel;
          _tmpIndRastreavel = _cursor.getString(_cursorIndexOfIndRastreavel);
          _tmpItem.setIndRastreavel(_tmpIndRastreavel);
        }  else  {
          _tmpItem = null;
        }
        final Route _tmpRoute;
        if (! (_cursor.isNull(_cursorIndexOfValorIndenizacaoAlta) && _cursor.isNull(_cursorIndexOfValorIndenizacaoBaixa))) {
          _tmpRoute = new Route();
          final Double _tmpValorIndenizacaoAlta;
          if (_cursor.isNull(_cursorIndexOfValorIndenizacaoAlta)) {
            _tmpValorIndenizacaoAlta = null;
          } else {
            _tmpValorIndenizacaoAlta = _cursor.getDouble(_cursorIndexOfValorIndenizacaoAlta);
          }
          _tmpRoute.setValorIndenizacaoAlta(_tmpValorIndenizacaoAlta);
          final Double _tmpValorIndenizacaoBaixa;
          if (_cursor.isNull(_cursorIndexOfValorIndenizacaoBaixa)) {
            _tmpValorIndenizacaoBaixa = null;
          } else {
            _tmpValorIndenizacaoBaixa = _cursor.getDouble(_cursorIndexOfValorIndenizacaoBaixa);
          }
          _tmpRoute.setValorIndenizacaoBaixa(_tmpValorIndenizacaoBaixa);
        }  else  {
          _tmpRoute = null;
        }
        _item_1 = new ItemPrice();
        _item_1.setItem(_tmpItem);
        _item_1.setRoute(_tmpRoute);
        _result.add(_item_1);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<ItemPrice> findPricesApl(Long cdCustomer, Long cdItem, List<Integer> tipoItem) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT Item.cdItem as it_cdItem, Item.cdCilindro as it_cdCilindro, Item.tipoPressao as it_tipoPressao, Item.descricaoProduto as it_descricaoProduto, Item.valorIndenizacao as it_valorIndenizacao, Item.descricaoCilindro as it_descricaoCilindro, Item.capacidadeProduto as it_capacidadeProduto, Item.unidadeMedida as it_unidadeMedida,Item.tax3 as it_tax3, Item.indProducao as it_indProducao, Item.indRequerFator as it_indRequerFator, Item.pesoCilindro as it_pesoCilindro, Item.pesoLiqUnitario as it_pesoLiqUnitario, Item.capacidadeCilindro as it_capacidadeCilindro,Item.cstCilindro as it_cstCilindro, Item.cstGas as it_cstGas, Item.classeNcmGas as it_classeNcmGas, Item.classeNcmCilindro as it_classeNcmCilindro, Item.tipoItem as it_tipoItem, Item.tipoPropriedade as it_tipoPropriedade, Item.fatorConversao as it_fatorConversao, Item.indFatorConvPolegadas as it_indFatorConvPolegadas,Route.valorIndenizacaoAlta as rt_valorIndenizacaoAlta, Route.valorIndenizacaoBaixa as rt_valorIndenizacaoBaixa, Item.qtdCilindroCheios as it_qtdCilindroCheios, Item.indRastreavel as it_indRastreavel FROM Item INNER JOIN Route INNER JOIN Price on Price.cdItem = Item.cdItem WHERE cdCilindro > 0   AND Item.tipoItem IN (");
    final int _inputSize = tipoItem.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")   AND Price.cdCustomer = ");
    _stringBuilder.append("?");
    _stringBuilder.append("   AND Item.qtdCilindroCheios > 0   AND Item.cdItem = ifnull(");
    _stringBuilder.append("?");
    _stringBuilder.append(", Item.cdItem)");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 2 + _inputSize;
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
    _argIndex = 1 + _inputSize;
    if (cdCustomer == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cdCustomer);
    }
    _argIndex = 2 + _inputSize;
    if (cdItem == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cdItem);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCdItem = _cursor.getColumnIndexOrThrow("it_cdItem");
      final int _cursorIndexOfCdCilindro = _cursor.getColumnIndexOrThrow("it_cdCilindro");
      final int _cursorIndexOfTipoPressao = _cursor.getColumnIndexOrThrow("it_tipoPressao");
      final int _cursorIndexOfDescricaoProduto = _cursor.getColumnIndexOrThrow("it_descricaoProduto");
      final int _cursorIndexOfValorIndenizacao = _cursor.getColumnIndexOrThrow("it_valorIndenizacao");
      final int _cursorIndexOfDescricaoCilindro = _cursor.getColumnIndexOrThrow("it_descricaoCilindro");
      final int _cursorIndexOfCapacidadeProduto = _cursor.getColumnIndexOrThrow("it_capacidadeProduto");
      final int _cursorIndexOfUnidadeMedida = _cursor.getColumnIndexOrThrow("it_unidadeMedida");
      final int _cursorIndexOfTax3 = _cursor.getColumnIndexOrThrow("it_tax3");
      final int _cursorIndexOfIndProducao = _cursor.getColumnIndexOrThrow("it_indProducao");
      final int _cursorIndexOfIndRequerFator = _cursor.getColumnIndexOrThrow("it_indRequerFator");
      final int _cursorIndexOfPesoCilindro = _cursor.getColumnIndexOrThrow("it_pesoCilindro");
      final int _cursorIndexOfPesoLiqUnitario = _cursor.getColumnIndexOrThrow("it_pesoLiqUnitario");
      final int _cursorIndexOfCapacidadeCilindro = _cursor.getColumnIndexOrThrow("it_capacidadeCilindro");
      final int _cursorIndexOfCstCilindro = _cursor.getColumnIndexOrThrow("it_cstCilindro");
      final int _cursorIndexOfCstGas = _cursor.getColumnIndexOrThrow("it_cstGas");
      final int _cursorIndexOfClasseNcmGas = _cursor.getColumnIndexOrThrow("it_classeNcmGas");
      final int _cursorIndexOfClasseNcmCilindro = _cursor.getColumnIndexOrThrow("it_classeNcmCilindro");
      final int _cursorIndexOfTipoItem = _cursor.getColumnIndexOrThrow("it_tipoItem");
      final int _cursorIndexOfTipoPropriedade = _cursor.getColumnIndexOrThrow("it_tipoPropriedade");
      final int _cursorIndexOfFatorConversao = _cursor.getColumnIndexOrThrow("it_fatorConversao");
      final int _cursorIndexOfIndFatorConvPolegadas = _cursor.getColumnIndexOrThrow("it_indFatorConvPolegadas");
      final int _cursorIndexOfValorIndenizacaoAlta = _cursor.getColumnIndexOrThrow("rt_valorIndenizacaoAlta");
      final int _cursorIndexOfValorIndenizacaoBaixa = _cursor.getColumnIndexOrThrow("rt_valorIndenizacaoBaixa");
      final int _cursorIndexOfQtdCilindroCheios = _cursor.getColumnIndexOrThrow("it_qtdCilindroCheios");
      final int _cursorIndexOfIndRastreavel = _cursor.getColumnIndexOrThrow("it_indRastreavel");
      final List<ItemPrice> _result = new ArrayList<ItemPrice>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ItemPrice _item_1;
        final Item _tmpItem;
        if (! (_cursor.isNull(_cursorIndexOfCdItem) && _cursor.isNull(_cursorIndexOfCdCilindro) && _cursor.isNull(_cursorIndexOfTipoPressao) && _cursor.isNull(_cursorIndexOfDescricaoProduto) && _cursor.isNull(_cursorIndexOfValorIndenizacao) && _cursor.isNull(_cursorIndexOfDescricaoCilindro) && _cursor.isNull(_cursorIndexOfCapacidadeProduto) && _cursor.isNull(_cursorIndexOfUnidadeMedida) && _cursor.isNull(_cursorIndexOfTax3) && _cursor.isNull(_cursorIndexOfIndProducao) && _cursor.isNull(_cursorIndexOfIndRequerFator) && _cursor.isNull(_cursorIndexOfPesoCilindro) && _cursor.isNull(_cursorIndexOfPesoLiqUnitario) && _cursor.isNull(_cursorIndexOfCapacidadeCilindro) && _cursor.isNull(_cursorIndexOfCstCilindro) && _cursor.isNull(_cursorIndexOfCstGas) && _cursor.isNull(_cursorIndexOfClasseNcmGas) && _cursor.isNull(_cursorIndexOfClasseNcmCilindro) && _cursor.isNull(_cursorIndexOfTipoItem) && _cursor.isNull(_cursorIndexOfTipoPropriedade) && _cursor.isNull(_cursorIndexOfFatorConversao) && _cursor.isNull(_cursorIndexOfIndFatorConvPolegadas) && _cursor.isNull(_cursorIndexOfQtdCilindroCheios) && _cursor.isNull(_cursorIndexOfIndRastreavel))) {
          _tmpItem = new Item();
          final Long _tmpCdItem;
          if (_cursor.isNull(_cursorIndexOfCdItem)) {
            _tmpCdItem = null;
          } else {
            _tmpCdItem = _cursor.getLong(_cursorIndexOfCdItem);
          }
          _tmpItem.setCdItem(_tmpCdItem);
          final Long _tmpCdCilindro;
          if (_cursor.isNull(_cursorIndexOfCdCilindro)) {
            _tmpCdCilindro = null;
          } else {
            _tmpCdCilindro = _cursor.getLong(_cursorIndexOfCdCilindro);
          }
          _tmpItem.setCdCilindro(_tmpCdCilindro);
          final Integer _tmpTipoPressao;
          if (_cursor.isNull(_cursorIndexOfTipoPressao)) {
            _tmpTipoPressao = null;
          } else {
            _tmpTipoPressao = _cursor.getInt(_cursorIndexOfTipoPressao);
          }
          _tmpItem.setTipoPressao(_tmpTipoPressao);
          final String _tmpDescricaoProduto;
          _tmpDescricaoProduto = _cursor.getString(_cursorIndexOfDescricaoProduto);
          _tmpItem.setDescricaoProduto(_tmpDescricaoProduto);
          final Double _tmpValorIndenizacao;
          if (_cursor.isNull(_cursorIndexOfValorIndenizacao)) {
            _tmpValorIndenizacao = null;
          } else {
            _tmpValorIndenizacao = _cursor.getDouble(_cursorIndexOfValorIndenizacao);
          }
          _tmpItem.setValorIndenizacao(_tmpValorIndenizacao);
          final String _tmpDescricaoCilindro;
          _tmpDescricaoCilindro = _cursor.getString(_cursorIndexOfDescricaoCilindro);
          _tmpItem.setDescricaoCilindro(_tmpDescricaoCilindro);
          final Double _tmpCapacidadeProduto;
          if (_cursor.isNull(_cursorIndexOfCapacidadeProduto)) {
            _tmpCapacidadeProduto = null;
          } else {
            _tmpCapacidadeProduto = _cursor.getDouble(_cursorIndexOfCapacidadeProduto);
          }
          _tmpItem.setCapacidadeProduto(_tmpCapacidadeProduto);
          final String _tmpUnidadeMedida;
          _tmpUnidadeMedida = _cursor.getString(_cursorIndexOfUnidadeMedida);
          _tmpItem.setUnidadeMedida(_tmpUnidadeMedida);
          final String _tmpTax3;
          _tmpTax3 = _cursor.getString(_cursorIndexOfTax3);
          _tmpItem.setTax3(_tmpTax3);
          final String _tmpIndProducao;
          _tmpIndProducao = _cursor.getString(_cursorIndexOfIndProducao);
          _tmpItem.setIndProducao(_tmpIndProducao);
          final Integer _tmpIndRequerFator;
          if (_cursor.isNull(_cursorIndexOfIndRequerFator)) {
            _tmpIndRequerFator = null;
          } else {
            _tmpIndRequerFator = _cursor.getInt(_cursorIndexOfIndRequerFator);
          }
          _tmpItem.setIndRequerFator(_tmpIndRequerFator);
          final Double _tmpPesoCilindro;
          if (_cursor.isNull(_cursorIndexOfPesoCilindro)) {
            _tmpPesoCilindro = null;
          } else {
            _tmpPesoCilindro = _cursor.getDouble(_cursorIndexOfPesoCilindro);
          }
          _tmpItem.setPesoCilindro(_tmpPesoCilindro);
          final Double _tmpPesoLiqUnitario;
          if (_cursor.isNull(_cursorIndexOfPesoLiqUnitario)) {
            _tmpPesoLiqUnitario = null;
          } else {
            _tmpPesoLiqUnitario = _cursor.getDouble(_cursorIndexOfPesoLiqUnitario);
          }
          _tmpItem.setPesoLiqUnitario(_tmpPesoLiqUnitario);
          final Double _tmpCapacidadeCilindro;
          if (_cursor.isNull(_cursorIndexOfCapacidadeCilindro)) {
            _tmpCapacidadeCilindro = null;
          } else {
            _tmpCapacidadeCilindro = _cursor.getDouble(_cursorIndexOfCapacidadeCilindro);
          }
          _tmpItem.setCapacidadeCilindro(_tmpCapacidadeCilindro);
          final String _tmpCstCilindro;
          _tmpCstCilindro = _cursor.getString(_cursorIndexOfCstCilindro);
          _tmpItem.setCstCilindro(_tmpCstCilindro);
          final String _tmpCstGas;
          _tmpCstGas = _cursor.getString(_cursorIndexOfCstGas);
          _tmpItem.setCstGas(_tmpCstGas);
          final Long _tmpClasseNcmGas;
          if (_cursor.isNull(_cursorIndexOfClasseNcmGas)) {
            _tmpClasseNcmGas = null;
          } else {
            _tmpClasseNcmGas = _cursor.getLong(_cursorIndexOfClasseNcmGas);
          }
          _tmpItem.setClasseNcmGas(_tmpClasseNcmGas);
          final Long _tmpClasseNcmCilindro;
          if (_cursor.isNull(_cursorIndexOfClasseNcmCilindro)) {
            _tmpClasseNcmCilindro = null;
          } else {
            _tmpClasseNcmCilindro = _cursor.getLong(_cursorIndexOfClasseNcmCilindro);
          }
          _tmpItem.setClasseNcmCilindro(_tmpClasseNcmCilindro);
          final Integer _tmpTipoItem;
          if (_cursor.isNull(_cursorIndexOfTipoItem)) {
            _tmpTipoItem = null;
          } else {
            _tmpTipoItem = _cursor.getInt(_cursorIndexOfTipoItem);
          }
          _tmpItem.setTipoItem(_tmpTipoItem);
          final String _tmpTipoPropriedade;
          _tmpTipoPropriedade = _cursor.getString(_cursorIndexOfTipoPropriedade);
          _tmpItem.setTipoPropriedade(_tmpTipoPropriedade);
          final Double _tmpFatorConversao;
          if (_cursor.isNull(_cursorIndexOfFatorConversao)) {
            _tmpFatorConversao = null;
          } else {
            _tmpFatorConversao = _cursor.getDouble(_cursorIndexOfFatorConversao);
          }
          _tmpItem.setFatorConversao(_tmpFatorConversao);
          final String _tmpIndFatorConvPolegadas;
          _tmpIndFatorConvPolegadas = _cursor.getString(_cursorIndexOfIndFatorConvPolegadas);
          _tmpItem.setIndFatorConvPolegadas(_tmpIndFatorConvPolegadas);
          final Double _tmpQtdCilindroCheios;
          if (_cursor.isNull(_cursorIndexOfQtdCilindroCheios)) {
            _tmpQtdCilindroCheios = null;
          } else {
            _tmpQtdCilindroCheios = _cursor.getDouble(_cursorIndexOfQtdCilindroCheios);
          }
          _tmpItem.setQtdCilindroCheios(_tmpQtdCilindroCheios);
          final String _tmpIndRastreavel;
          _tmpIndRastreavel = _cursor.getString(_cursorIndexOfIndRastreavel);
          _tmpItem.setIndRastreavel(_tmpIndRastreavel);
        }  else  {
          _tmpItem = null;
        }
        final Route _tmpRoute;
        if (! (_cursor.isNull(_cursorIndexOfValorIndenizacaoAlta) && _cursor.isNull(_cursorIndexOfValorIndenizacaoBaixa))) {
          _tmpRoute = new Route();
          final Double _tmpValorIndenizacaoAlta;
          if (_cursor.isNull(_cursorIndexOfValorIndenizacaoAlta)) {
            _tmpValorIndenizacaoAlta = null;
          } else {
            _tmpValorIndenizacaoAlta = _cursor.getDouble(_cursorIndexOfValorIndenizacaoAlta);
          }
          _tmpRoute.setValorIndenizacaoAlta(_tmpValorIndenizacaoAlta);
          final Double _tmpValorIndenizacaoBaixa;
          if (_cursor.isNull(_cursorIndexOfValorIndenizacaoBaixa)) {
            _tmpValorIndenizacaoBaixa = null;
          } else {
            _tmpValorIndenizacaoBaixa = _cursor.getDouble(_cursorIndexOfValorIndenizacaoBaixa);
          }
          _tmpRoute.setValorIndenizacaoBaixa(_tmpValorIndenizacaoBaixa);
        }  else  {
          _tmpRoute = null;
        }
        _item_1 = new ItemPrice();
        _item_1.setItem(_tmpItem);
        _item_1.setRoute(_tmpRoute);
        _result.add(_item_1);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<ItemPrice> findPricesAplHC(Long cdItem, List<Integer> tipoItem) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT Item.cdItem as it_cdItem, Item.cdCilindro as it_cdCilindro, Item.tipoPressao as it_tipoPressao, Item.descricaoCilindro as it_descricaoCilindro, Item.descricaoProduto as it_descricaoProduto, Item.valorIndenizacao as it_valorIndenizacao, Item.capacidadeProduto as it_capacidadeProduto, Item.unidadeMedida as it_unidadeMedida,Item.tax3 as it_tax3, Item.indProducao as it_indProducao, Item.indRequerFator as it_indRequerFator, Item.pesoCilindro as it_pesoCilindro, Item.pesoLiqUnitario as it_pesoLiqUnitario, Item.capacidadeCilindro as it_capacidadeCilindro,Item.cstCilindro as it_cstCilindro, Item.cstGas as it_cstGas, Item.classeNcmGas as it_classeNcmGas, Item.classeNcmCilindro as it_classeNcmCilindro, Item.tipoItem as it_tipoItem, Item.tipoPropriedade as it_tipoPropriedade, Item.fatorConversao as it_fatorConversao, Item.indFatorConvPolegadas as it_indFatorConvPolegadas,Route.valorIndenizacaoAlta as rt_valorIndenizacaoAlta, Route.valorIndenizacaoBaixa as rt_valorIndenizacaoBaixa, Item.qtdCilindroCheios as it_qtdCilindroCheios, Item.indRastreavel as it_indRastreavel FROM Item INNER JOIN Route WHERE Item.tipoItem IN (");
    final int _inputSize = tipoItem.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")   AND Item.qtdCilindroCheios > 0   AND Item.cdItem = ifnull(");
    _stringBuilder.append("?");
    _stringBuilder.append(", Item.cdItem)");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 1 + _inputSize;
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
    _argIndex = 1 + _inputSize;
    if (cdItem == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cdItem);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCdItem = _cursor.getColumnIndexOrThrow("it_cdItem");
      final int _cursorIndexOfCdCilindro = _cursor.getColumnIndexOrThrow("it_cdCilindro");
      final int _cursorIndexOfTipoPressao = _cursor.getColumnIndexOrThrow("it_tipoPressao");
      final int _cursorIndexOfDescricaoCilindro = _cursor.getColumnIndexOrThrow("it_descricaoCilindro");
      final int _cursorIndexOfDescricaoProduto = _cursor.getColumnIndexOrThrow("it_descricaoProduto");
      final int _cursorIndexOfValorIndenizacao = _cursor.getColumnIndexOrThrow("it_valorIndenizacao");
      final int _cursorIndexOfCapacidadeProduto = _cursor.getColumnIndexOrThrow("it_capacidadeProduto");
      final int _cursorIndexOfUnidadeMedida = _cursor.getColumnIndexOrThrow("it_unidadeMedida");
      final int _cursorIndexOfTax3 = _cursor.getColumnIndexOrThrow("it_tax3");
      final int _cursorIndexOfIndProducao = _cursor.getColumnIndexOrThrow("it_indProducao");
      final int _cursorIndexOfIndRequerFator = _cursor.getColumnIndexOrThrow("it_indRequerFator");
      final int _cursorIndexOfPesoCilindro = _cursor.getColumnIndexOrThrow("it_pesoCilindro");
      final int _cursorIndexOfPesoLiqUnitario = _cursor.getColumnIndexOrThrow("it_pesoLiqUnitario");
      final int _cursorIndexOfCapacidadeCilindro = _cursor.getColumnIndexOrThrow("it_capacidadeCilindro");
      final int _cursorIndexOfCstCilindro = _cursor.getColumnIndexOrThrow("it_cstCilindro");
      final int _cursorIndexOfCstGas = _cursor.getColumnIndexOrThrow("it_cstGas");
      final int _cursorIndexOfClasseNcmGas = _cursor.getColumnIndexOrThrow("it_classeNcmGas");
      final int _cursorIndexOfClasseNcmCilindro = _cursor.getColumnIndexOrThrow("it_classeNcmCilindro");
      final int _cursorIndexOfTipoItem = _cursor.getColumnIndexOrThrow("it_tipoItem");
      final int _cursorIndexOfTipoPropriedade = _cursor.getColumnIndexOrThrow("it_tipoPropriedade");
      final int _cursorIndexOfFatorConversao = _cursor.getColumnIndexOrThrow("it_fatorConversao");
      final int _cursorIndexOfIndFatorConvPolegadas = _cursor.getColumnIndexOrThrow("it_indFatorConvPolegadas");
      final int _cursorIndexOfValorIndenizacaoAlta = _cursor.getColumnIndexOrThrow("rt_valorIndenizacaoAlta");
      final int _cursorIndexOfValorIndenizacaoBaixa = _cursor.getColumnIndexOrThrow("rt_valorIndenizacaoBaixa");
      final int _cursorIndexOfQtdCilindroCheios = _cursor.getColumnIndexOrThrow("it_qtdCilindroCheios");
      final int _cursorIndexOfIndRastreavel = _cursor.getColumnIndexOrThrow("it_indRastreavel");
      final List<ItemPrice> _result = new ArrayList<ItemPrice>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ItemPrice _item_1;
        final Item _tmpItem;
        if (! (_cursor.isNull(_cursorIndexOfCdItem) && _cursor.isNull(_cursorIndexOfCdCilindro) && _cursor.isNull(_cursorIndexOfTipoPressao) && _cursor.isNull(_cursorIndexOfDescricaoCilindro) && _cursor.isNull(_cursorIndexOfDescricaoProduto) && _cursor.isNull(_cursorIndexOfValorIndenizacao) && _cursor.isNull(_cursorIndexOfCapacidadeProduto) && _cursor.isNull(_cursorIndexOfUnidadeMedida) && _cursor.isNull(_cursorIndexOfTax3) && _cursor.isNull(_cursorIndexOfIndProducao) && _cursor.isNull(_cursorIndexOfIndRequerFator) && _cursor.isNull(_cursorIndexOfPesoCilindro) && _cursor.isNull(_cursorIndexOfPesoLiqUnitario) && _cursor.isNull(_cursorIndexOfCapacidadeCilindro) && _cursor.isNull(_cursorIndexOfCstCilindro) && _cursor.isNull(_cursorIndexOfCstGas) && _cursor.isNull(_cursorIndexOfClasseNcmGas) && _cursor.isNull(_cursorIndexOfClasseNcmCilindro) && _cursor.isNull(_cursorIndexOfTipoItem) && _cursor.isNull(_cursorIndexOfTipoPropriedade) && _cursor.isNull(_cursorIndexOfFatorConversao) && _cursor.isNull(_cursorIndexOfIndFatorConvPolegadas) && _cursor.isNull(_cursorIndexOfQtdCilindroCheios) && _cursor.isNull(_cursorIndexOfIndRastreavel))) {
          _tmpItem = new Item();
          final Long _tmpCdItem;
          if (_cursor.isNull(_cursorIndexOfCdItem)) {
            _tmpCdItem = null;
          } else {
            _tmpCdItem = _cursor.getLong(_cursorIndexOfCdItem);
          }
          _tmpItem.setCdItem(_tmpCdItem);
          final Long _tmpCdCilindro;
          if (_cursor.isNull(_cursorIndexOfCdCilindro)) {
            _tmpCdCilindro = null;
          } else {
            _tmpCdCilindro = _cursor.getLong(_cursorIndexOfCdCilindro);
          }
          _tmpItem.setCdCilindro(_tmpCdCilindro);
          final Integer _tmpTipoPressao;
          if (_cursor.isNull(_cursorIndexOfTipoPressao)) {
            _tmpTipoPressao = null;
          } else {
            _tmpTipoPressao = _cursor.getInt(_cursorIndexOfTipoPressao);
          }
          _tmpItem.setTipoPressao(_tmpTipoPressao);
          final String _tmpDescricaoCilindro;
          _tmpDescricaoCilindro = _cursor.getString(_cursorIndexOfDescricaoCilindro);
          _tmpItem.setDescricaoCilindro(_tmpDescricaoCilindro);
          final String _tmpDescricaoProduto;
          _tmpDescricaoProduto = _cursor.getString(_cursorIndexOfDescricaoProduto);
          _tmpItem.setDescricaoProduto(_tmpDescricaoProduto);
          final Double _tmpValorIndenizacao;
          if (_cursor.isNull(_cursorIndexOfValorIndenizacao)) {
            _tmpValorIndenizacao = null;
          } else {
            _tmpValorIndenizacao = _cursor.getDouble(_cursorIndexOfValorIndenizacao);
          }
          _tmpItem.setValorIndenizacao(_tmpValorIndenizacao);
          final Double _tmpCapacidadeProduto;
          if (_cursor.isNull(_cursorIndexOfCapacidadeProduto)) {
            _tmpCapacidadeProduto = null;
          } else {
            _tmpCapacidadeProduto = _cursor.getDouble(_cursorIndexOfCapacidadeProduto);
          }
          _tmpItem.setCapacidadeProduto(_tmpCapacidadeProduto);
          final String _tmpUnidadeMedida;
          _tmpUnidadeMedida = _cursor.getString(_cursorIndexOfUnidadeMedida);
          _tmpItem.setUnidadeMedida(_tmpUnidadeMedida);
          final String _tmpTax3;
          _tmpTax3 = _cursor.getString(_cursorIndexOfTax3);
          _tmpItem.setTax3(_tmpTax3);
          final String _tmpIndProducao;
          _tmpIndProducao = _cursor.getString(_cursorIndexOfIndProducao);
          _tmpItem.setIndProducao(_tmpIndProducao);
          final Integer _tmpIndRequerFator;
          if (_cursor.isNull(_cursorIndexOfIndRequerFator)) {
            _tmpIndRequerFator = null;
          } else {
            _tmpIndRequerFator = _cursor.getInt(_cursorIndexOfIndRequerFator);
          }
          _tmpItem.setIndRequerFator(_tmpIndRequerFator);
          final Double _tmpPesoCilindro;
          if (_cursor.isNull(_cursorIndexOfPesoCilindro)) {
            _tmpPesoCilindro = null;
          } else {
            _tmpPesoCilindro = _cursor.getDouble(_cursorIndexOfPesoCilindro);
          }
          _tmpItem.setPesoCilindro(_tmpPesoCilindro);
          final Double _tmpPesoLiqUnitario;
          if (_cursor.isNull(_cursorIndexOfPesoLiqUnitario)) {
            _tmpPesoLiqUnitario = null;
          } else {
            _tmpPesoLiqUnitario = _cursor.getDouble(_cursorIndexOfPesoLiqUnitario);
          }
          _tmpItem.setPesoLiqUnitario(_tmpPesoLiqUnitario);
          final Double _tmpCapacidadeCilindro;
          if (_cursor.isNull(_cursorIndexOfCapacidadeCilindro)) {
            _tmpCapacidadeCilindro = null;
          } else {
            _tmpCapacidadeCilindro = _cursor.getDouble(_cursorIndexOfCapacidadeCilindro);
          }
          _tmpItem.setCapacidadeCilindro(_tmpCapacidadeCilindro);
          final String _tmpCstCilindro;
          _tmpCstCilindro = _cursor.getString(_cursorIndexOfCstCilindro);
          _tmpItem.setCstCilindro(_tmpCstCilindro);
          final String _tmpCstGas;
          _tmpCstGas = _cursor.getString(_cursorIndexOfCstGas);
          _tmpItem.setCstGas(_tmpCstGas);
          final Long _tmpClasseNcmGas;
          if (_cursor.isNull(_cursorIndexOfClasseNcmGas)) {
            _tmpClasseNcmGas = null;
          } else {
            _tmpClasseNcmGas = _cursor.getLong(_cursorIndexOfClasseNcmGas);
          }
          _tmpItem.setClasseNcmGas(_tmpClasseNcmGas);
          final Long _tmpClasseNcmCilindro;
          if (_cursor.isNull(_cursorIndexOfClasseNcmCilindro)) {
            _tmpClasseNcmCilindro = null;
          } else {
            _tmpClasseNcmCilindro = _cursor.getLong(_cursorIndexOfClasseNcmCilindro);
          }
          _tmpItem.setClasseNcmCilindro(_tmpClasseNcmCilindro);
          final Integer _tmpTipoItem;
          if (_cursor.isNull(_cursorIndexOfTipoItem)) {
            _tmpTipoItem = null;
          } else {
            _tmpTipoItem = _cursor.getInt(_cursorIndexOfTipoItem);
          }
          _tmpItem.setTipoItem(_tmpTipoItem);
          final String _tmpTipoPropriedade;
          _tmpTipoPropriedade = _cursor.getString(_cursorIndexOfTipoPropriedade);
          _tmpItem.setTipoPropriedade(_tmpTipoPropriedade);
          final Double _tmpFatorConversao;
          if (_cursor.isNull(_cursorIndexOfFatorConversao)) {
            _tmpFatorConversao = null;
          } else {
            _tmpFatorConversao = _cursor.getDouble(_cursorIndexOfFatorConversao);
          }
          _tmpItem.setFatorConversao(_tmpFatorConversao);
          final String _tmpIndFatorConvPolegadas;
          _tmpIndFatorConvPolegadas = _cursor.getString(_cursorIndexOfIndFatorConvPolegadas);
          _tmpItem.setIndFatorConvPolegadas(_tmpIndFatorConvPolegadas);
          final Double _tmpQtdCilindroCheios;
          if (_cursor.isNull(_cursorIndexOfQtdCilindroCheios)) {
            _tmpQtdCilindroCheios = null;
          } else {
            _tmpQtdCilindroCheios = _cursor.getDouble(_cursorIndexOfQtdCilindroCheios);
          }
          _tmpItem.setQtdCilindroCheios(_tmpQtdCilindroCheios);
          final String _tmpIndRastreavel;
          _tmpIndRastreavel = _cursor.getString(_cursorIndexOfIndRastreavel);
          _tmpItem.setIndRastreavel(_tmpIndRastreavel);
        }  else  {
          _tmpItem = null;
        }
        final Route _tmpRoute;
        if (! (_cursor.isNull(_cursorIndexOfValorIndenizacaoAlta) && _cursor.isNull(_cursorIndexOfValorIndenizacaoBaixa))) {
          _tmpRoute = new Route();
          final Double _tmpValorIndenizacaoAlta;
          if (_cursor.isNull(_cursorIndexOfValorIndenizacaoAlta)) {
            _tmpValorIndenizacaoAlta = null;
          } else {
            _tmpValorIndenizacaoAlta = _cursor.getDouble(_cursorIndexOfValorIndenizacaoAlta);
          }
          _tmpRoute.setValorIndenizacaoAlta(_tmpValorIndenizacaoAlta);
          final Double _tmpValorIndenizacaoBaixa;
          if (_cursor.isNull(_cursorIndexOfValorIndenizacaoBaixa)) {
            _tmpValorIndenizacaoBaixa = null;
          } else {
            _tmpValorIndenizacaoBaixa = _cursor.getDouble(_cursorIndexOfValorIndenizacaoBaixa);
          }
          _tmpRoute.setValorIndenizacaoBaixa(_tmpValorIndenizacaoBaixa);
        }  else  {
          _tmpRoute = null;
        }
        _item_1 = new ItemPrice();
        _item_1.setItem(_tmpItem);
        _item_1.setRoute(_tmpRoute);
        _result.add(_item_1);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<ItemPrice> findPricesFut(Long cdCustomer, Long cdItem, String numeroNotaOrigem,
      List<Integer> tipoItem) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT Price.*, Item.cdItem as it_cdItem, Item.descricaoProduto as it_descricaoProduto, Item.capacidadeProduto as it_capacidadeProduto, Item.unidadeMedida as it_unidadeMedida, Item.descricaoCilindro as it_descricaoCilindro, Item.tax3 as it_tax3, Item.indProducao as it_indProducao, Item.tipoPressao as it_tipoPressao, Item.indRequerFator as it_indRequerFator, Item.fatorPcs as it_fatorPcs,  Item.pesoCilindro as it_pesoCilindro, Item.pesoLiqUnitario as it_pesoLiqUnitario,  Item.capacidadeCilindro as it_capacidadeCilindro,  Item.cstCilindro as it_cstCilindro, Item.cstGas as it_cstGas,  Item.classeNcmGas as it_classeNcmGas, Item.classeNcmCilindro as it_classeNcmCilindro,  Item.fatorConversao as it_fatorConversao, Item.indFatorConvPolegadas as it_indFatorConvPolegadas,Item.tipoItem as it_tipoItem, Item.tipoPropriedade as it_tipoPropriedade, Item.indRastreavel as it_indRastreavel   FROM PreOrder    INNER JOIN Item on Item.cdItem = PreOrder.cdItem   INNER JOIN Price on Price.cdItem = PreOrder.cdItem AND Price.cdCustomer = PreOrder.cdCustomer  INNER JOIN Saldo on Saldo.cdItem = Item.cdItem and Saldo.capacidade = Item.capacidadeProduto   WHERE Price.condicaoFaturamento <> 991     AND Price.cdCustomer = ");
    _stringBuilder.append("?");
    _stringBuilder.append("    AND PreOrder.numeroNotaOrigem = ifnull(");
    _stringBuilder.append("?");
    _stringBuilder.append(", numeroNotaOrigem)    AND PreOrder.saldo/PreOrder.capacidadeProduto >= 1     AND Item.tipoItem IN (");
    final int _inputSize = tipoItem.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")     AND Item.cdItem = ifnull(");
    _stringBuilder.append("?");
    _stringBuilder.append(", Item.cdItem)");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 3 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    if (cdCustomer == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cdCustomer);
    }
    _argIndex = 2;
    if (numeroNotaOrigem == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, numeroNotaOrigem);
    }
    _argIndex = 3;
    for (Integer _item : tipoItem) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item);
      }
      _argIndex ++;
    }
    _argIndex = 3 + _inputSize;
    if (cdItem == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cdItem);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfCdItem = _cursor.getColumnIndexOrThrow("cdItem");
      final int _cursorIndexOfFlNovoFaturamento = _cursor.getColumnIndexOrThrow("flNovoFaturamento");
      final int _cursorIndexOfPercentualIpi = _cursor.getColumnIndexOrThrow("percentualIpi");
      final int _cursorIndexOfPercentualIcms = _cursor.getColumnIndexOrThrow("percentualIcms");
      final int _cursorIndexOfPercReducaoIcms = _cursor.getColumnIndexOrThrow("percReducaoIcms");
      final int _cursorIndexOfPrecoUnitario = _cursor.getColumnIndexOrThrow("precoUnitario");
      final int _cursorIndexOfValorFrete = _cursor.getColumnIndexOrThrow("valorFrete");
      final int _cursorIndexOfValorDespesas = _cursor.getColumnIndexOrThrow("valorDespesas");
      final int _cursorIndexOfPercentualPis = _cursor.getColumnIndexOrThrow("percentualPis");
      final int _cursorIndexOfPercentualCofins = _cursor.getColumnIndexOrThrow("percentualCofins");
      final int _cursorIndexOfCstPis = _cursor.getColumnIndexOrThrow("cstPis");
      final int _cursorIndexOfCstCofins = _cursor.getColumnIndexOrThrow("cstCofins");
      final int _cursorIndexOfSituacaoTributaria = _cursor.getColumnIndexOrThrow("situacaoTributaria");
      final int _cursorIndexOfCondicaoFaturamento = _cursor.getColumnIndexOrThrow("condicaoFaturamento");
      final int _cursorIndexOfCdItem_1 = _cursor.getColumnIndexOrThrow("it_cdItem");
      final int _cursorIndexOfDescricaoProduto = _cursor.getColumnIndexOrThrow("it_descricaoProduto");
      final int _cursorIndexOfCapacidadeProduto = _cursor.getColumnIndexOrThrow("it_capacidadeProduto");
      final int _cursorIndexOfUnidadeMedida = _cursor.getColumnIndexOrThrow("it_unidadeMedida");
      final int _cursorIndexOfDescricaoCilindro = _cursor.getColumnIndexOrThrow("it_descricaoCilindro");
      final int _cursorIndexOfTax3 = _cursor.getColumnIndexOrThrow("it_tax3");
      final int _cursorIndexOfIndProducao = _cursor.getColumnIndexOrThrow("it_indProducao");
      final int _cursorIndexOfTipoPressao = _cursor.getColumnIndexOrThrow("it_tipoPressao");
      final int _cursorIndexOfIndRequerFator = _cursor.getColumnIndexOrThrow("it_indRequerFator");
      final int _cursorIndexOfFatorPcs = _cursor.getColumnIndexOrThrow("it_fatorPcs");
      final int _cursorIndexOfPesoCilindro = _cursor.getColumnIndexOrThrow("it_pesoCilindro");
      final int _cursorIndexOfPesoLiqUnitario = _cursor.getColumnIndexOrThrow("it_pesoLiqUnitario");
      final int _cursorIndexOfCapacidadeCilindro = _cursor.getColumnIndexOrThrow("it_capacidadeCilindro");
      final int _cursorIndexOfCstCilindro = _cursor.getColumnIndexOrThrow("it_cstCilindro");
      final int _cursorIndexOfCstGas = _cursor.getColumnIndexOrThrow("it_cstGas");
      final int _cursorIndexOfClasseNcmGas = _cursor.getColumnIndexOrThrow("it_classeNcmGas");
      final int _cursorIndexOfClasseNcmCilindro = _cursor.getColumnIndexOrThrow("it_classeNcmCilindro");
      final int _cursorIndexOfFatorConversao = _cursor.getColumnIndexOrThrow("it_fatorConversao");
      final int _cursorIndexOfIndFatorConvPolegadas = _cursor.getColumnIndexOrThrow("it_indFatorConvPolegadas");
      final int _cursorIndexOfTipoItem = _cursor.getColumnIndexOrThrow("it_tipoItem");
      final int _cursorIndexOfTipoPropriedade = _cursor.getColumnIndexOrThrow("it_tipoPropriedade");
      final int _cursorIndexOfIndRastreavel = _cursor.getColumnIndexOrThrow("it_indRastreavel");
      final List<ItemPrice> _result = new ArrayList<ItemPrice>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ItemPrice _item_1;
        final Price _tmpPrice;
        if (! (_cursor.isNull(_cursorIndexOfCdCustomer) && _cursor.isNull(_cursorIndexOfCdItem) && _cursor.isNull(_cursorIndexOfFlNovoFaturamento) && _cursor.isNull(_cursorIndexOfPercentualIpi) && _cursor.isNull(_cursorIndexOfPercentualIcms) && _cursor.isNull(_cursorIndexOfPercReducaoIcms) && _cursor.isNull(_cursorIndexOfPrecoUnitario) && _cursor.isNull(_cursorIndexOfValorFrete) && _cursor.isNull(_cursorIndexOfValorDespesas) && _cursor.isNull(_cursorIndexOfPercentualPis) && _cursor.isNull(_cursorIndexOfPercentualCofins) && _cursor.isNull(_cursorIndexOfCstPis) && _cursor.isNull(_cursorIndexOfCstCofins) && _cursor.isNull(_cursorIndexOfSituacaoTributaria) && _cursor.isNull(_cursorIndexOfCondicaoFaturamento))) {
          _tmpPrice = new Price();
          final Long _tmpCdCustomer;
          if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
            _tmpCdCustomer = null;
          } else {
            _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
          }
          _tmpPrice.setCdCustomer(_tmpCdCustomer);
          final Long _tmpCdItem;
          if (_cursor.isNull(_cursorIndexOfCdItem)) {
            _tmpCdItem = null;
          } else {
            _tmpCdItem = _cursor.getLong(_cursorIndexOfCdItem);
          }
          _tmpPrice.setCdItem(_tmpCdItem);
          final String _tmpFlNovoFaturamento;
          _tmpFlNovoFaturamento = _cursor.getString(_cursorIndexOfFlNovoFaturamento);
          _tmpPrice.setFlNovoFaturamento(_tmpFlNovoFaturamento);
          final Double _tmpPercentualIpi;
          if (_cursor.isNull(_cursorIndexOfPercentualIpi)) {
            _tmpPercentualIpi = null;
          } else {
            _tmpPercentualIpi = _cursor.getDouble(_cursorIndexOfPercentualIpi);
          }
          _tmpPrice.setPercentualIpi(_tmpPercentualIpi);
          final Double _tmpPercentualIcms;
          if (_cursor.isNull(_cursorIndexOfPercentualIcms)) {
            _tmpPercentualIcms = null;
          } else {
            _tmpPercentualIcms = _cursor.getDouble(_cursorIndexOfPercentualIcms);
          }
          _tmpPrice.setPercentualIcms(_tmpPercentualIcms);
          final Double _tmpPercReducaoIcms;
          if (_cursor.isNull(_cursorIndexOfPercReducaoIcms)) {
            _tmpPercReducaoIcms = null;
          } else {
            _tmpPercReducaoIcms = _cursor.getDouble(_cursorIndexOfPercReducaoIcms);
          }
          _tmpPrice.setPercReducaoIcms(_tmpPercReducaoIcms);
          final Double _tmpPrecoUnitario;
          if (_cursor.isNull(_cursorIndexOfPrecoUnitario)) {
            _tmpPrecoUnitario = null;
          } else {
            _tmpPrecoUnitario = _cursor.getDouble(_cursorIndexOfPrecoUnitario);
          }
          _tmpPrice.setPrecoUnitario(_tmpPrecoUnitario);
          final Double _tmpValorFrete;
          if (_cursor.isNull(_cursorIndexOfValorFrete)) {
            _tmpValorFrete = null;
          } else {
            _tmpValorFrete = _cursor.getDouble(_cursorIndexOfValorFrete);
          }
          _tmpPrice.setValorFrete(_tmpValorFrete);
          final Double _tmpValorDespesas;
          if (_cursor.isNull(_cursorIndexOfValorDespesas)) {
            _tmpValorDespesas = null;
          } else {
            _tmpValorDespesas = _cursor.getDouble(_cursorIndexOfValorDespesas);
          }
          _tmpPrice.setValorDespesas(_tmpValorDespesas);
          final Double _tmpPercentualPis;
          if (_cursor.isNull(_cursorIndexOfPercentualPis)) {
            _tmpPercentualPis = null;
          } else {
            _tmpPercentualPis = _cursor.getDouble(_cursorIndexOfPercentualPis);
          }
          _tmpPrice.setPercentualPis(_tmpPercentualPis);
          final Double _tmpPercentualCofins;
          if (_cursor.isNull(_cursorIndexOfPercentualCofins)) {
            _tmpPercentualCofins = null;
          } else {
            _tmpPercentualCofins = _cursor.getDouble(_cursorIndexOfPercentualCofins);
          }
          _tmpPrice.setPercentualCofins(_tmpPercentualCofins);
          final String _tmpCstPis;
          _tmpCstPis = _cursor.getString(_cursorIndexOfCstPis);
          _tmpPrice.setCstPis(_tmpCstPis);
          final String _tmpCstCofins;
          _tmpCstCofins = _cursor.getString(_cursorIndexOfCstCofins);
          _tmpPrice.setCstCofins(_tmpCstCofins);
          final String _tmpSituacaoTributaria;
          _tmpSituacaoTributaria = _cursor.getString(_cursorIndexOfSituacaoTributaria);
          _tmpPrice.setSituacaoTributaria(_tmpSituacaoTributaria);
          final String _tmpCondicaoFaturamento;
          _tmpCondicaoFaturamento = _cursor.getString(_cursorIndexOfCondicaoFaturamento);
          _tmpPrice.setCondicaoFaturamento(_tmpCondicaoFaturamento);
        }  else  {
          _tmpPrice = null;
        }
        final Item _tmpItem;
        if (! (_cursor.isNull(_cursorIndexOfCdItem_1) && _cursor.isNull(_cursorIndexOfDescricaoProduto) && _cursor.isNull(_cursorIndexOfCapacidadeProduto) && _cursor.isNull(_cursorIndexOfUnidadeMedida) && _cursor.isNull(_cursorIndexOfDescricaoCilindro) && _cursor.isNull(_cursorIndexOfTax3) && _cursor.isNull(_cursorIndexOfIndProducao) && _cursor.isNull(_cursorIndexOfTipoPressao) && _cursor.isNull(_cursorIndexOfIndRequerFator) && _cursor.isNull(_cursorIndexOfFatorPcs) && _cursor.isNull(_cursorIndexOfPesoCilindro) && _cursor.isNull(_cursorIndexOfPesoLiqUnitario) && _cursor.isNull(_cursorIndexOfCapacidadeCilindro) && _cursor.isNull(_cursorIndexOfCstCilindro) && _cursor.isNull(_cursorIndexOfCstGas) && _cursor.isNull(_cursorIndexOfClasseNcmGas) && _cursor.isNull(_cursorIndexOfClasseNcmCilindro) && _cursor.isNull(_cursorIndexOfFatorConversao) && _cursor.isNull(_cursorIndexOfIndFatorConvPolegadas) && _cursor.isNull(_cursorIndexOfTipoItem) && _cursor.isNull(_cursorIndexOfTipoPropriedade) && _cursor.isNull(_cursorIndexOfIndRastreavel))) {
          _tmpItem = new Item();
          final Long _tmpCdItem_1;
          if (_cursor.isNull(_cursorIndexOfCdItem_1)) {
            _tmpCdItem_1 = null;
          } else {
            _tmpCdItem_1 = _cursor.getLong(_cursorIndexOfCdItem_1);
          }
          _tmpItem.setCdItem(_tmpCdItem_1);
          final String _tmpDescricaoProduto;
          _tmpDescricaoProduto = _cursor.getString(_cursorIndexOfDescricaoProduto);
          _tmpItem.setDescricaoProduto(_tmpDescricaoProduto);
          final Double _tmpCapacidadeProduto;
          if (_cursor.isNull(_cursorIndexOfCapacidadeProduto)) {
            _tmpCapacidadeProduto = null;
          } else {
            _tmpCapacidadeProduto = _cursor.getDouble(_cursorIndexOfCapacidadeProduto);
          }
          _tmpItem.setCapacidadeProduto(_tmpCapacidadeProduto);
          final String _tmpUnidadeMedida;
          _tmpUnidadeMedida = _cursor.getString(_cursorIndexOfUnidadeMedida);
          _tmpItem.setUnidadeMedida(_tmpUnidadeMedida);
          final String _tmpDescricaoCilindro;
          _tmpDescricaoCilindro = _cursor.getString(_cursorIndexOfDescricaoCilindro);
          _tmpItem.setDescricaoCilindro(_tmpDescricaoCilindro);
          final String _tmpTax3;
          _tmpTax3 = _cursor.getString(_cursorIndexOfTax3);
          _tmpItem.setTax3(_tmpTax3);
          final String _tmpIndProducao;
          _tmpIndProducao = _cursor.getString(_cursorIndexOfIndProducao);
          _tmpItem.setIndProducao(_tmpIndProducao);
          final Integer _tmpTipoPressao;
          if (_cursor.isNull(_cursorIndexOfTipoPressao)) {
            _tmpTipoPressao = null;
          } else {
            _tmpTipoPressao = _cursor.getInt(_cursorIndexOfTipoPressao);
          }
          _tmpItem.setTipoPressao(_tmpTipoPressao);
          final Integer _tmpIndRequerFator;
          if (_cursor.isNull(_cursorIndexOfIndRequerFator)) {
            _tmpIndRequerFator = null;
          } else {
            _tmpIndRequerFator = _cursor.getInt(_cursorIndexOfIndRequerFator);
          }
          _tmpItem.setIndRequerFator(_tmpIndRequerFator);
          final Double _tmpFatorPcs;
          if (_cursor.isNull(_cursorIndexOfFatorPcs)) {
            _tmpFatorPcs = null;
          } else {
            _tmpFatorPcs = _cursor.getDouble(_cursorIndexOfFatorPcs);
          }
          _tmpItem.setFatorPcs(_tmpFatorPcs);
          final Double _tmpPesoCilindro;
          if (_cursor.isNull(_cursorIndexOfPesoCilindro)) {
            _tmpPesoCilindro = null;
          } else {
            _tmpPesoCilindro = _cursor.getDouble(_cursorIndexOfPesoCilindro);
          }
          _tmpItem.setPesoCilindro(_tmpPesoCilindro);
          final Double _tmpPesoLiqUnitario;
          if (_cursor.isNull(_cursorIndexOfPesoLiqUnitario)) {
            _tmpPesoLiqUnitario = null;
          } else {
            _tmpPesoLiqUnitario = _cursor.getDouble(_cursorIndexOfPesoLiqUnitario);
          }
          _tmpItem.setPesoLiqUnitario(_tmpPesoLiqUnitario);
          final Double _tmpCapacidadeCilindro;
          if (_cursor.isNull(_cursorIndexOfCapacidadeCilindro)) {
            _tmpCapacidadeCilindro = null;
          } else {
            _tmpCapacidadeCilindro = _cursor.getDouble(_cursorIndexOfCapacidadeCilindro);
          }
          _tmpItem.setCapacidadeCilindro(_tmpCapacidadeCilindro);
          final String _tmpCstCilindro;
          _tmpCstCilindro = _cursor.getString(_cursorIndexOfCstCilindro);
          _tmpItem.setCstCilindro(_tmpCstCilindro);
          final String _tmpCstGas;
          _tmpCstGas = _cursor.getString(_cursorIndexOfCstGas);
          _tmpItem.setCstGas(_tmpCstGas);
          final Long _tmpClasseNcmGas;
          if (_cursor.isNull(_cursorIndexOfClasseNcmGas)) {
            _tmpClasseNcmGas = null;
          } else {
            _tmpClasseNcmGas = _cursor.getLong(_cursorIndexOfClasseNcmGas);
          }
          _tmpItem.setClasseNcmGas(_tmpClasseNcmGas);
          final Long _tmpClasseNcmCilindro;
          if (_cursor.isNull(_cursorIndexOfClasseNcmCilindro)) {
            _tmpClasseNcmCilindro = null;
          } else {
            _tmpClasseNcmCilindro = _cursor.getLong(_cursorIndexOfClasseNcmCilindro);
          }
          _tmpItem.setClasseNcmCilindro(_tmpClasseNcmCilindro);
          final Double _tmpFatorConversao;
          if (_cursor.isNull(_cursorIndexOfFatorConversao)) {
            _tmpFatorConversao = null;
          } else {
            _tmpFatorConversao = _cursor.getDouble(_cursorIndexOfFatorConversao);
          }
          _tmpItem.setFatorConversao(_tmpFatorConversao);
          final String _tmpIndFatorConvPolegadas;
          _tmpIndFatorConvPolegadas = _cursor.getString(_cursorIndexOfIndFatorConvPolegadas);
          _tmpItem.setIndFatorConvPolegadas(_tmpIndFatorConvPolegadas);
          final Integer _tmpTipoItem;
          if (_cursor.isNull(_cursorIndexOfTipoItem)) {
            _tmpTipoItem = null;
          } else {
            _tmpTipoItem = _cursor.getInt(_cursorIndexOfTipoItem);
          }
          _tmpItem.setTipoItem(_tmpTipoItem);
          final String _tmpTipoPropriedade;
          _tmpTipoPropriedade = _cursor.getString(_cursorIndexOfTipoPropriedade);
          _tmpItem.setTipoPropriedade(_tmpTipoPropriedade);
          final String _tmpIndRastreavel;
          _tmpIndRastreavel = _cursor.getString(_cursorIndexOfIndRastreavel);
          _tmpItem.setIndRastreavel(_tmpIndRastreavel);
        }  else  {
          _tmpItem = null;
        }
        _item_1 = new ItemPrice();
        _item_1.setPrice(_tmpPrice);
        _item_1.setItem(_tmpItem);
        _result.add(_item_1);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<ItemPrice> findPricesTrc(Long cdCustomer, Long cdItem, List<Integer> tipoItem) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT  Price.*, Item.cdItem as it_cdItem, Item.descricaoProduto as it_descricaoProduto, Item.capacidadeProduto as it_capacidadeProduto, Item.unidadeMedida as it_unidadeMedida, Item.descricaoCilindro as it_descricaoCilindro,  Item.tax3 as it_tax3, Item.indProducao as it_indProducao, Item.tipoPressao as it_tipoPressao, Item.indRequerFator as it_indRequerFator, Item.fatorPcs as it_fatorPcs,  Item.pesoCilindro as it_pesoCilindro, Item.pesoLiqUnitario as it_pesoLiqUnitario,  Item.capacidadeCilindro as it_capacidadeCilindro,  Item.cstCilindro as it_cstCilindro, Item.cstGas as it_cstGas,  Item.classeNcmGas as it_classeNcmGas, Item.classeNcmCilindro as it_classeNcmCilindro,  Item.fatorConversao as it_fatorConversao,  Item.indFatorConvPolegadas as it_indFatorConvPolegadas, Item.tipoItem as it_tipoItem, Item.tipoPropriedade as it_tipoPropriedade, Item.indRastreavel as it_indRastreavel  FROM Price  INNER JOIN Item ON Price.cdItem = Item.cdItem  WHERE Price.cdCustomer = ");
    _stringBuilder.append("?");
    _stringBuilder.append("    AND Price.condicaoFaturamento <> 991   AND Price.cdItem = ifnull(");
    _stringBuilder.append("?");
    _stringBuilder.append(", Price.cdItem)   AND Item.tipoItem in (");
    final int _inputSize = tipoItem.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")   AND Item.qtdCilindroCheios > 0 ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 2 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    if (cdCustomer == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cdCustomer);
    }
    _argIndex = 2;
    if (cdItem == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cdItem);
    }
    _argIndex = 3;
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
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfCdItem = _cursor.getColumnIndexOrThrow("cdItem");
      final int _cursorIndexOfFlNovoFaturamento = _cursor.getColumnIndexOrThrow("flNovoFaturamento");
      final int _cursorIndexOfPercentualIpi = _cursor.getColumnIndexOrThrow("percentualIpi");
      final int _cursorIndexOfPercentualIcms = _cursor.getColumnIndexOrThrow("percentualIcms");
      final int _cursorIndexOfPercReducaoIcms = _cursor.getColumnIndexOrThrow("percReducaoIcms");
      final int _cursorIndexOfPrecoUnitario = _cursor.getColumnIndexOrThrow("precoUnitario");
      final int _cursorIndexOfValorFrete = _cursor.getColumnIndexOrThrow("valorFrete");
      final int _cursorIndexOfValorDespesas = _cursor.getColumnIndexOrThrow("valorDespesas");
      final int _cursorIndexOfPercentualPis = _cursor.getColumnIndexOrThrow("percentualPis");
      final int _cursorIndexOfPercentualCofins = _cursor.getColumnIndexOrThrow("percentualCofins");
      final int _cursorIndexOfCstPis = _cursor.getColumnIndexOrThrow("cstPis");
      final int _cursorIndexOfCstCofins = _cursor.getColumnIndexOrThrow("cstCofins");
      final int _cursorIndexOfSituacaoTributaria = _cursor.getColumnIndexOrThrow("situacaoTributaria");
      final int _cursorIndexOfCondicaoFaturamento = _cursor.getColumnIndexOrThrow("condicaoFaturamento");
      final int _cursorIndexOfCdItem_1 = _cursor.getColumnIndexOrThrow("it_cdItem");
      final int _cursorIndexOfDescricaoProduto = _cursor.getColumnIndexOrThrow("it_descricaoProduto");
      final int _cursorIndexOfCapacidadeProduto = _cursor.getColumnIndexOrThrow("it_capacidadeProduto");
      final int _cursorIndexOfUnidadeMedida = _cursor.getColumnIndexOrThrow("it_unidadeMedida");
      final int _cursorIndexOfDescricaoCilindro = _cursor.getColumnIndexOrThrow("it_descricaoCilindro");
      final int _cursorIndexOfTax3 = _cursor.getColumnIndexOrThrow("it_tax3");
      final int _cursorIndexOfIndProducao = _cursor.getColumnIndexOrThrow("it_indProducao");
      final int _cursorIndexOfTipoPressao = _cursor.getColumnIndexOrThrow("it_tipoPressao");
      final int _cursorIndexOfIndRequerFator = _cursor.getColumnIndexOrThrow("it_indRequerFator");
      final int _cursorIndexOfFatorPcs = _cursor.getColumnIndexOrThrow("it_fatorPcs");
      final int _cursorIndexOfPesoCilindro = _cursor.getColumnIndexOrThrow("it_pesoCilindro");
      final int _cursorIndexOfPesoLiqUnitario = _cursor.getColumnIndexOrThrow("it_pesoLiqUnitario");
      final int _cursorIndexOfCapacidadeCilindro = _cursor.getColumnIndexOrThrow("it_capacidadeCilindro");
      final int _cursorIndexOfCstCilindro = _cursor.getColumnIndexOrThrow("it_cstCilindro");
      final int _cursorIndexOfCstGas = _cursor.getColumnIndexOrThrow("it_cstGas");
      final int _cursorIndexOfClasseNcmGas = _cursor.getColumnIndexOrThrow("it_classeNcmGas");
      final int _cursorIndexOfClasseNcmCilindro = _cursor.getColumnIndexOrThrow("it_classeNcmCilindro");
      final int _cursorIndexOfFatorConversao = _cursor.getColumnIndexOrThrow("it_fatorConversao");
      final int _cursorIndexOfIndFatorConvPolegadas = _cursor.getColumnIndexOrThrow("it_indFatorConvPolegadas");
      final int _cursorIndexOfTipoItem = _cursor.getColumnIndexOrThrow("it_tipoItem");
      final int _cursorIndexOfTipoPropriedade = _cursor.getColumnIndexOrThrow("it_tipoPropriedade");
      final int _cursorIndexOfIndRastreavel = _cursor.getColumnIndexOrThrow("it_indRastreavel");
      final List<ItemPrice> _result = new ArrayList<ItemPrice>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ItemPrice _item_1;
        final Price _tmpPrice;
        if (! (_cursor.isNull(_cursorIndexOfCdCustomer) && _cursor.isNull(_cursorIndexOfCdItem) && _cursor.isNull(_cursorIndexOfFlNovoFaturamento) && _cursor.isNull(_cursorIndexOfPercentualIpi) && _cursor.isNull(_cursorIndexOfPercentualIcms) && _cursor.isNull(_cursorIndexOfPercReducaoIcms) && _cursor.isNull(_cursorIndexOfPrecoUnitario) && _cursor.isNull(_cursorIndexOfValorFrete) && _cursor.isNull(_cursorIndexOfValorDespesas) && _cursor.isNull(_cursorIndexOfPercentualPis) && _cursor.isNull(_cursorIndexOfPercentualCofins) && _cursor.isNull(_cursorIndexOfCstPis) && _cursor.isNull(_cursorIndexOfCstCofins) && _cursor.isNull(_cursorIndexOfSituacaoTributaria) && _cursor.isNull(_cursorIndexOfCondicaoFaturamento))) {
          _tmpPrice = new Price();
          final Long _tmpCdCustomer;
          if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
            _tmpCdCustomer = null;
          } else {
            _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
          }
          _tmpPrice.setCdCustomer(_tmpCdCustomer);
          final Long _tmpCdItem;
          if (_cursor.isNull(_cursorIndexOfCdItem)) {
            _tmpCdItem = null;
          } else {
            _tmpCdItem = _cursor.getLong(_cursorIndexOfCdItem);
          }
          _tmpPrice.setCdItem(_tmpCdItem);
          final String _tmpFlNovoFaturamento;
          _tmpFlNovoFaturamento = _cursor.getString(_cursorIndexOfFlNovoFaturamento);
          _tmpPrice.setFlNovoFaturamento(_tmpFlNovoFaturamento);
          final Double _tmpPercentualIpi;
          if (_cursor.isNull(_cursorIndexOfPercentualIpi)) {
            _tmpPercentualIpi = null;
          } else {
            _tmpPercentualIpi = _cursor.getDouble(_cursorIndexOfPercentualIpi);
          }
          _tmpPrice.setPercentualIpi(_tmpPercentualIpi);
          final Double _tmpPercentualIcms;
          if (_cursor.isNull(_cursorIndexOfPercentualIcms)) {
            _tmpPercentualIcms = null;
          } else {
            _tmpPercentualIcms = _cursor.getDouble(_cursorIndexOfPercentualIcms);
          }
          _tmpPrice.setPercentualIcms(_tmpPercentualIcms);
          final Double _tmpPercReducaoIcms;
          if (_cursor.isNull(_cursorIndexOfPercReducaoIcms)) {
            _tmpPercReducaoIcms = null;
          } else {
            _tmpPercReducaoIcms = _cursor.getDouble(_cursorIndexOfPercReducaoIcms);
          }
          _tmpPrice.setPercReducaoIcms(_tmpPercReducaoIcms);
          final Double _tmpPrecoUnitario;
          if (_cursor.isNull(_cursorIndexOfPrecoUnitario)) {
            _tmpPrecoUnitario = null;
          } else {
            _tmpPrecoUnitario = _cursor.getDouble(_cursorIndexOfPrecoUnitario);
          }
          _tmpPrice.setPrecoUnitario(_tmpPrecoUnitario);
          final Double _tmpValorFrete;
          if (_cursor.isNull(_cursorIndexOfValorFrete)) {
            _tmpValorFrete = null;
          } else {
            _tmpValorFrete = _cursor.getDouble(_cursorIndexOfValorFrete);
          }
          _tmpPrice.setValorFrete(_tmpValorFrete);
          final Double _tmpValorDespesas;
          if (_cursor.isNull(_cursorIndexOfValorDespesas)) {
            _tmpValorDespesas = null;
          } else {
            _tmpValorDespesas = _cursor.getDouble(_cursorIndexOfValorDespesas);
          }
          _tmpPrice.setValorDespesas(_tmpValorDespesas);
          final Double _tmpPercentualPis;
          if (_cursor.isNull(_cursorIndexOfPercentualPis)) {
            _tmpPercentualPis = null;
          } else {
            _tmpPercentualPis = _cursor.getDouble(_cursorIndexOfPercentualPis);
          }
          _tmpPrice.setPercentualPis(_tmpPercentualPis);
          final Double _tmpPercentualCofins;
          if (_cursor.isNull(_cursorIndexOfPercentualCofins)) {
            _tmpPercentualCofins = null;
          } else {
            _tmpPercentualCofins = _cursor.getDouble(_cursorIndexOfPercentualCofins);
          }
          _tmpPrice.setPercentualCofins(_tmpPercentualCofins);
          final String _tmpCstPis;
          _tmpCstPis = _cursor.getString(_cursorIndexOfCstPis);
          _tmpPrice.setCstPis(_tmpCstPis);
          final String _tmpCstCofins;
          _tmpCstCofins = _cursor.getString(_cursorIndexOfCstCofins);
          _tmpPrice.setCstCofins(_tmpCstCofins);
          final String _tmpSituacaoTributaria;
          _tmpSituacaoTributaria = _cursor.getString(_cursorIndexOfSituacaoTributaria);
          _tmpPrice.setSituacaoTributaria(_tmpSituacaoTributaria);
          final String _tmpCondicaoFaturamento;
          _tmpCondicaoFaturamento = _cursor.getString(_cursorIndexOfCondicaoFaturamento);
          _tmpPrice.setCondicaoFaturamento(_tmpCondicaoFaturamento);
        }  else  {
          _tmpPrice = null;
        }
        final Item _tmpItem;
        if (! (_cursor.isNull(_cursorIndexOfCdItem_1) && _cursor.isNull(_cursorIndexOfDescricaoProduto) && _cursor.isNull(_cursorIndexOfCapacidadeProduto) && _cursor.isNull(_cursorIndexOfUnidadeMedida) && _cursor.isNull(_cursorIndexOfDescricaoCilindro) && _cursor.isNull(_cursorIndexOfTax3) && _cursor.isNull(_cursorIndexOfIndProducao) && _cursor.isNull(_cursorIndexOfTipoPressao) && _cursor.isNull(_cursorIndexOfIndRequerFator) && _cursor.isNull(_cursorIndexOfFatorPcs) && _cursor.isNull(_cursorIndexOfPesoCilindro) && _cursor.isNull(_cursorIndexOfPesoLiqUnitario) && _cursor.isNull(_cursorIndexOfCapacidadeCilindro) && _cursor.isNull(_cursorIndexOfCstCilindro) && _cursor.isNull(_cursorIndexOfCstGas) && _cursor.isNull(_cursorIndexOfClasseNcmGas) && _cursor.isNull(_cursorIndexOfClasseNcmCilindro) && _cursor.isNull(_cursorIndexOfFatorConversao) && _cursor.isNull(_cursorIndexOfIndFatorConvPolegadas) && _cursor.isNull(_cursorIndexOfTipoItem) && _cursor.isNull(_cursorIndexOfTipoPropriedade) && _cursor.isNull(_cursorIndexOfIndRastreavel))) {
          _tmpItem = new Item();
          final Long _tmpCdItem_1;
          if (_cursor.isNull(_cursorIndexOfCdItem_1)) {
            _tmpCdItem_1 = null;
          } else {
            _tmpCdItem_1 = _cursor.getLong(_cursorIndexOfCdItem_1);
          }
          _tmpItem.setCdItem(_tmpCdItem_1);
          final String _tmpDescricaoProduto;
          _tmpDescricaoProduto = _cursor.getString(_cursorIndexOfDescricaoProduto);
          _tmpItem.setDescricaoProduto(_tmpDescricaoProduto);
          final Double _tmpCapacidadeProduto;
          if (_cursor.isNull(_cursorIndexOfCapacidadeProduto)) {
            _tmpCapacidadeProduto = null;
          } else {
            _tmpCapacidadeProduto = _cursor.getDouble(_cursorIndexOfCapacidadeProduto);
          }
          _tmpItem.setCapacidadeProduto(_tmpCapacidadeProduto);
          final String _tmpUnidadeMedida;
          _tmpUnidadeMedida = _cursor.getString(_cursorIndexOfUnidadeMedida);
          _tmpItem.setUnidadeMedida(_tmpUnidadeMedida);
          final String _tmpDescricaoCilindro;
          _tmpDescricaoCilindro = _cursor.getString(_cursorIndexOfDescricaoCilindro);
          _tmpItem.setDescricaoCilindro(_tmpDescricaoCilindro);
          final String _tmpTax3;
          _tmpTax3 = _cursor.getString(_cursorIndexOfTax3);
          _tmpItem.setTax3(_tmpTax3);
          final String _tmpIndProducao;
          _tmpIndProducao = _cursor.getString(_cursorIndexOfIndProducao);
          _tmpItem.setIndProducao(_tmpIndProducao);
          final Integer _tmpTipoPressao;
          if (_cursor.isNull(_cursorIndexOfTipoPressao)) {
            _tmpTipoPressao = null;
          } else {
            _tmpTipoPressao = _cursor.getInt(_cursorIndexOfTipoPressao);
          }
          _tmpItem.setTipoPressao(_tmpTipoPressao);
          final Integer _tmpIndRequerFator;
          if (_cursor.isNull(_cursorIndexOfIndRequerFator)) {
            _tmpIndRequerFator = null;
          } else {
            _tmpIndRequerFator = _cursor.getInt(_cursorIndexOfIndRequerFator);
          }
          _tmpItem.setIndRequerFator(_tmpIndRequerFator);
          final Double _tmpFatorPcs;
          if (_cursor.isNull(_cursorIndexOfFatorPcs)) {
            _tmpFatorPcs = null;
          } else {
            _tmpFatorPcs = _cursor.getDouble(_cursorIndexOfFatorPcs);
          }
          _tmpItem.setFatorPcs(_tmpFatorPcs);
          final Double _tmpPesoCilindro;
          if (_cursor.isNull(_cursorIndexOfPesoCilindro)) {
            _tmpPesoCilindro = null;
          } else {
            _tmpPesoCilindro = _cursor.getDouble(_cursorIndexOfPesoCilindro);
          }
          _tmpItem.setPesoCilindro(_tmpPesoCilindro);
          final Double _tmpPesoLiqUnitario;
          if (_cursor.isNull(_cursorIndexOfPesoLiqUnitario)) {
            _tmpPesoLiqUnitario = null;
          } else {
            _tmpPesoLiqUnitario = _cursor.getDouble(_cursorIndexOfPesoLiqUnitario);
          }
          _tmpItem.setPesoLiqUnitario(_tmpPesoLiqUnitario);
          final Double _tmpCapacidadeCilindro;
          if (_cursor.isNull(_cursorIndexOfCapacidadeCilindro)) {
            _tmpCapacidadeCilindro = null;
          } else {
            _tmpCapacidadeCilindro = _cursor.getDouble(_cursorIndexOfCapacidadeCilindro);
          }
          _tmpItem.setCapacidadeCilindro(_tmpCapacidadeCilindro);
          final String _tmpCstCilindro;
          _tmpCstCilindro = _cursor.getString(_cursorIndexOfCstCilindro);
          _tmpItem.setCstCilindro(_tmpCstCilindro);
          final String _tmpCstGas;
          _tmpCstGas = _cursor.getString(_cursorIndexOfCstGas);
          _tmpItem.setCstGas(_tmpCstGas);
          final Long _tmpClasseNcmGas;
          if (_cursor.isNull(_cursorIndexOfClasseNcmGas)) {
            _tmpClasseNcmGas = null;
          } else {
            _tmpClasseNcmGas = _cursor.getLong(_cursorIndexOfClasseNcmGas);
          }
          _tmpItem.setClasseNcmGas(_tmpClasseNcmGas);
          final Long _tmpClasseNcmCilindro;
          if (_cursor.isNull(_cursorIndexOfClasseNcmCilindro)) {
            _tmpClasseNcmCilindro = null;
          } else {
            _tmpClasseNcmCilindro = _cursor.getLong(_cursorIndexOfClasseNcmCilindro);
          }
          _tmpItem.setClasseNcmCilindro(_tmpClasseNcmCilindro);
          final Double _tmpFatorConversao;
          if (_cursor.isNull(_cursorIndexOfFatorConversao)) {
            _tmpFatorConversao = null;
          } else {
            _tmpFatorConversao = _cursor.getDouble(_cursorIndexOfFatorConversao);
          }
          _tmpItem.setFatorConversao(_tmpFatorConversao);
          final String _tmpIndFatorConvPolegadas;
          _tmpIndFatorConvPolegadas = _cursor.getString(_cursorIndexOfIndFatorConvPolegadas);
          _tmpItem.setIndFatorConvPolegadas(_tmpIndFatorConvPolegadas);
          final Integer _tmpTipoItem;
          if (_cursor.isNull(_cursorIndexOfTipoItem)) {
            _tmpTipoItem = null;
          } else {
            _tmpTipoItem = _cursor.getInt(_cursorIndexOfTipoItem);
          }
          _tmpItem.setTipoItem(_tmpTipoItem);
          final String _tmpTipoPropriedade;
          _tmpTipoPropriedade = _cursor.getString(_cursorIndexOfTipoPropriedade);
          _tmpItem.setTipoPropriedade(_tmpTipoPropriedade);
          final String _tmpIndRastreavel;
          _tmpIndRastreavel = _cursor.getString(_cursorIndexOfIndRastreavel);
          _tmpItem.setIndRastreavel(_tmpIndRastreavel);
        }  else  {
          _tmpItem = null;
        }
        _item_1 = new ItemPrice();
        _item_1.setPrice(_tmpPrice);
        _item_1.setItem(_tmpItem);
        _result.add(_item_1);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<ItemPrice> findPricesRps(Long cdCustomer, Long cdItem, List<Integer> tipoItem,
      String flNovoFaturamento) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT  Price.*, Item.cdItem as it_cdItem, Item.descricaoProduto as it_descricaoProduto, Item.descricaoCilindro as it_descricaoCilindro,  Item.capacidadeProduto as it_capacidadeProduto, Item.unidadeMedida as it_unidadeMedida, Item.tax3 as it_tax3, Item.indProducao as it_indProducao, Item.tipoPressao as it_tipoPressao, Item.indRequerFator as it_indRequerFator, Item.fatorPcs as it_fatorPcs,  Item.pesoCilindro as it_pesoCilindro, Item.pesoLiqUnitario as it_pesoLiqUnitario,  Item.capacidadeCilindro as it_capacidadeCilindro,  Item.cstCilindro as it_cstCilindro, Item.cstGas as it_cstGas,  Item.classeNcmGas as it_classeNcmGas, Item.classeNcmCilindro as it_classeNcmCilindro,  Item.fatorConversao as it_fatorConversao,  Item.indFatorConvPolegadas as it_indFatorConvPolegadas,  Item.tipoItem as it_tipoItem, Item.tipoPropriedade as it_tipoPropriedade, Item.indRastreavel as it_indRastreavel  FROM Price  INNER JOIN Item ON Price.cdItem = Item.cdItem  WHERE Price.cdCustomer = ");
    _stringBuilder.append("?");
    _stringBuilder.append("    AND Price.flNovoFaturamento = ");
    _stringBuilder.append("?");
    _stringBuilder.append("   AND Price.condicaoFaturamento <> 991   AND Price.cdItem = ifnull(");
    _stringBuilder.append("?");
    _stringBuilder.append(", Price.cdItem)   AND Item.tipoItem in (");
    final int _inputSize = tipoItem.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 3 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    if (cdCustomer == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cdCustomer);
    }
    _argIndex = 2;
    if (flNovoFaturamento == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, flNovoFaturamento);
    }
    _argIndex = 3;
    if (cdItem == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cdItem);
    }
    _argIndex = 4;
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
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfCdItem = _cursor.getColumnIndexOrThrow("cdItem");
      final int _cursorIndexOfFlNovoFaturamento = _cursor.getColumnIndexOrThrow("flNovoFaturamento");
      final int _cursorIndexOfPercentualIpi = _cursor.getColumnIndexOrThrow("percentualIpi");
      final int _cursorIndexOfPercentualIcms = _cursor.getColumnIndexOrThrow("percentualIcms");
      final int _cursorIndexOfPercReducaoIcms = _cursor.getColumnIndexOrThrow("percReducaoIcms");
      final int _cursorIndexOfPrecoUnitario = _cursor.getColumnIndexOrThrow("precoUnitario");
      final int _cursorIndexOfValorFrete = _cursor.getColumnIndexOrThrow("valorFrete");
      final int _cursorIndexOfValorDespesas = _cursor.getColumnIndexOrThrow("valorDespesas");
      final int _cursorIndexOfPercentualPis = _cursor.getColumnIndexOrThrow("percentualPis");
      final int _cursorIndexOfPercentualCofins = _cursor.getColumnIndexOrThrow("percentualCofins");
      final int _cursorIndexOfCstPis = _cursor.getColumnIndexOrThrow("cstPis");
      final int _cursorIndexOfCstCofins = _cursor.getColumnIndexOrThrow("cstCofins");
      final int _cursorIndexOfSituacaoTributaria = _cursor.getColumnIndexOrThrow("situacaoTributaria");
      final int _cursorIndexOfCondicaoFaturamento = _cursor.getColumnIndexOrThrow("condicaoFaturamento");
      final int _cursorIndexOfCdItem_1 = _cursor.getColumnIndexOrThrow("it_cdItem");
      final int _cursorIndexOfDescricaoProduto = _cursor.getColumnIndexOrThrow("it_descricaoProduto");
      final int _cursorIndexOfDescricaoCilindro = _cursor.getColumnIndexOrThrow("it_descricaoCilindro");
      final int _cursorIndexOfCapacidadeProduto = _cursor.getColumnIndexOrThrow("it_capacidadeProduto");
      final int _cursorIndexOfUnidadeMedida = _cursor.getColumnIndexOrThrow("it_unidadeMedida");
      final int _cursorIndexOfTax3 = _cursor.getColumnIndexOrThrow("it_tax3");
      final int _cursorIndexOfIndProducao = _cursor.getColumnIndexOrThrow("it_indProducao");
      final int _cursorIndexOfTipoPressao = _cursor.getColumnIndexOrThrow("it_tipoPressao");
      final int _cursorIndexOfIndRequerFator = _cursor.getColumnIndexOrThrow("it_indRequerFator");
      final int _cursorIndexOfFatorPcs = _cursor.getColumnIndexOrThrow("it_fatorPcs");
      final int _cursorIndexOfPesoCilindro = _cursor.getColumnIndexOrThrow("it_pesoCilindro");
      final int _cursorIndexOfPesoLiqUnitario = _cursor.getColumnIndexOrThrow("it_pesoLiqUnitario");
      final int _cursorIndexOfCapacidadeCilindro = _cursor.getColumnIndexOrThrow("it_capacidadeCilindro");
      final int _cursorIndexOfCstCilindro = _cursor.getColumnIndexOrThrow("it_cstCilindro");
      final int _cursorIndexOfCstGas = _cursor.getColumnIndexOrThrow("it_cstGas");
      final int _cursorIndexOfClasseNcmGas = _cursor.getColumnIndexOrThrow("it_classeNcmGas");
      final int _cursorIndexOfClasseNcmCilindro = _cursor.getColumnIndexOrThrow("it_classeNcmCilindro");
      final int _cursorIndexOfFatorConversao = _cursor.getColumnIndexOrThrow("it_fatorConversao");
      final int _cursorIndexOfIndFatorConvPolegadas = _cursor.getColumnIndexOrThrow("it_indFatorConvPolegadas");
      final int _cursorIndexOfTipoItem = _cursor.getColumnIndexOrThrow("it_tipoItem");
      final int _cursorIndexOfTipoPropriedade = _cursor.getColumnIndexOrThrow("it_tipoPropriedade");
      final int _cursorIndexOfIndRastreavel = _cursor.getColumnIndexOrThrow("it_indRastreavel");
      final List<ItemPrice> _result = new ArrayList<ItemPrice>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ItemPrice _item_1;
        final Price _tmpPrice;
        if (! (_cursor.isNull(_cursorIndexOfCdCustomer) && _cursor.isNull(_cursorIndexOfCdItem) && _cursor.isNull(_cursorIndexOfFlNovoFaturamento) && _cursor.isNull(_cursorIndexOfPercentualIpi) && _cursor.isNull(_cursorIndexOfPercentualIcms) && _cursor.isNull(_cursorIndexOfPercReducaoIcms) && _cursor.isNull(_cursorIndexOfPrecoUnitario) && _cursor.isNull(_cursorIndexOfValorFrete) && _cursor.isNull(_cursorIndexOfValorDespesas) && _cursor.isNull(_cursorIndexOfPercentualPis) && _cursor.isNull(_cursorIndexOfPercentualCofins) && _cursor.isNull(_cursorIndexOfCstPis) && _cursor.isNull(_cursorIndexOfCstCofins) && _cursor.isNull(_cursorIndexOfSituacaoTributaria) && _cursor.isNull(_cursorIndexOfCondicaoFaturamento))) {
          _tmpPrice = new Price();
          final Long _tmpCdCustomer;
          if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
            _tmpCdCustomer = null;
          } else {
            _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
          }
          _tmpPrice.setCdCustomer(_tmpCdCustomer);
          final Long _tmpCdItem;
          if (_cursor.isNull(_cursorIndexOfCdItem)) {
            _tmpCdItem = null;
          } else {
            _tmpCdItem = _cursor.getLong(_cursorIndexOfCdItem);
          }
          _tmpPrice.setCdItem(_tmpCdItem);
          final String _tmpFlNovoFaturamento;
          _tmpFlNovoFaturamento = _cursor.getString(_cursorIndexOfFlNovoFaturamento);
          _tmpPrice.setFlNovoFaturamento(_tmpFlNovoFaturamento);
          final Double _tmpPercentualIpi;
          if (_cursor.isNull(_cursorIndexOfPercentualIpi)) {
            _tmpPercentualIpi = null;
          } else {
            _tmpPercentualIpi = _cursor.getDouble(_cursorIndexOfPercentualIpi);
          }
          _tmpPrice.setPercentualIpi(_tmpPercentualIpi);
          final Double _tmpPercentualIcms;
          if (_cursor.isNull(_cursorIndexOfPercentualIcms)) {
            _tmpPercentualIcms = null;
          } else {
            _tmpPercentualIcms = _cursor.getDouble(_cursorIndexOfPercentualIcms);
          }
          _tmpPrice.setPercentualIcms(_tmpPercentualIcms);
          final Double _tmpPercReducaoIcms;
          if (_cursor.isNull(_cursorIndexOfPercReducaoIcms)) {
            _tmpPercReducaoIcms = null;
          } else {
            _tmpPercReducaoIcms = _cursor.getDouble(_cursorIndexOfPercReducaoIcms);
          }
          _tmpPrice.setPercReducaoIcms(_tmpPercReducaoIcms);
          final Double _tmpPrecoUnitario;
          if (_cursor.isNull(_cursorIndexOfPrecoUnitario)) {
            _tmpPrecoUnitario = null;
          } else {
            _tmpPrecoUnitario = _cursor.getDouble(_cursorIndexOfPrecoUnitario);
          }
          _tmpPrice.setPrecoUnitario(_tmpPrecoUnitario);
          final Double _tmpValorFrete;
          if (_cursor.isNull(_cursorIndexOfValorFrete)) {
            _tmpValorFrete = null;
          } else {
            _tmpValorFrete = _cursor.getDouble(_cursorIndexOfValorFrete);
          }
          _tmpPrice.setValorFrete(_tmpValorFrete);
          final Double _tmpValorDespesas;
          if (_cursor.isNull(_cursorIndexOfValorDespesas)) {
            _tmpValorDespesas = null;
          } else {
            _tmpValorDespesas = _cursor.getDouble(_cursorIndexOfValorDespesas);
          }
          _tmpPrice.setValorDespesas(_tmpValorDespesas);
          final Double _tmpPercentualPis;
          if (_cursor.isNull(_cursorIndexOfPercentualPis)) {
            _tmpPercentualPis = null;
          } else {
            _tmpPercentualPis = _cursor.getDouble(_cursorIndexOfPercentualPis);
          }
          _tmpPrice.setPercentualPis(_tmpPercentualPis);
          final Double _tmpPercentualCofins;
          if (_cursor.isNull(_cursorIndexOfPercentualCofins)) {
            _tmpPercentualCofins = null;
          } else {
            _tmpPercentualCofins = _cursor.getDouble(_cursorIndexOfPercentualCofins);
          }
          _tmpPrice.setPercentualCofins(_tmpPercentualCofins);
          final String _tmpCstPis;
          _tmpCstPis = _cursor.getString(_cursorIndexOfCstPis);
          _tmpPrice.setCstPis(_tmpCstPis);
          final String _tmpCstCofins;
          _tmpCstCofins = _cursor.getString(_cursorIndexOfCstCofins);
          _tmpPrice.setCstCofins(_tmpCstCofins);
          final String _tmpSituacaoTributaria;
          _tmpSituacaoTributaria = _cursor.getString(_cursorIndexOfSituacaoTributaria);
          _tmpPrice.setSituacaoTributaria(_tmpSituacaoTributaria);
          final String _tmpCondicaoFaturamento;
          _tmpCondicaoFaturamento = _cursor.getString(_cursorIndexOfCondicaoFaturamento);
          _tmpPrice.setCondicaoFaturamento(_tmpCondicaoFaturamento);
        }  else  {
          _tmpPrice = null;
        }
        final Item _tmpItem;
        if (! (_cursor.isNull(_cursorIndexOfCdItem_1) && _cursor.isNull(_cursorIndexOfDescricaoProduto) && _cursor.isNull(_cursorIndexOfDescricaoCilindro) && _cursor.isNull(_cursorIndexOfCapacidadeProduto) && _cursor.isNull(_cursorIndexOfUnidadeMedida) && _cursor.isNull(_cursorIndexOfTax3) && _cursor.isNull(_cursorIndexOfIndProducao) && _cursor.isNull(_cursorIndexOfTipoPressao) && _cursor.isNull(_cursorIndexOfIndRequerFator) && _cursor.isNull(_cursorIndexOfFatorPcs) && _cursor.isNull(_cursorIndexOfPesoCilindro) && _cursor.isNull(_cursorIndexOfPesoLiqUnitario) && _cursor.isNull(_cursorIndexOfCapacidadeCilindro) && _cursor.isNull(_cursorIndexOfCstCilindro) && _cursor.isNull(_cursorIndexOfCstGas) && _cursor.isNull(_cursorIndexOfClasseNcmGas) && _cursor.isNull(_cursorIndexOfClasseNcmCilindro) && _cursor.isNull(_cursorIndexOfFatorConversao) && _cursor.isNull(_cursorIndexOfIndFatorConvPolegadas) && _cursor.isNull(_cursorIndexOfTipoItem) && _cursor.isNull(_cursorIndexOfTipoPropriedade) && _cursor.isNull(_cursorIndexOfIndRastreavel))) {
          _tmpItem = new Item();
          final Long _tmpCdItem_1;
          if (_cursor.isNull(_cursorIndexOfCdItem_1)) {
            _tmpCdItem_1 = null;
          } else {
            _tmpCdItem_1 = _cursor.getLong(_cursorIndexOfCdItem_1);
          }
          _tmpItem.setCdItem(_tmpCdItem_1);
          final String _tmpDescricaoProduto;
          _tmpDescricaoProduto = _cursor.getString(_cursorIndexOfDescricaoProduto);
          _tmpItem.setDescricaoProduto(_tmpDescricaoProduto);
          final String _tmpDescricaoCilindro;
          _tmpDescricaoCilindro = _cursor.getString(_cursorIndexOfDescricaoCilindro);
          _tmpItem.setDescricaoCilindro(_tmpDescricaoCilindro);
          final Double _tmpCapacidadeProduto;
          if (_cursor.isNull(_cursorIndexOfCapacidadeProduto)) {
            _tmpCapacidadeProduto = null;
          } else {
            _tmpCapacidadeProduto = _cursor.getDouble(_cursorIndexOfCapacidadeProduto);
          }
          _tmpItem.setCapacidadeProduto(_tmpCapacidadeProduto);
          final String _tmpUnidadeMedida;
          _tmpUnidadeMedida = _cursor.getString(_cursorIndexOfUnidadeMedida);
          _tmpItem.setUnidadeMedida(_tmpUnidadeMedida);
          final String _tmpTax3;
          _tmpTax3 = _cursor.getString(_cursorIndexOfTax3);
          _tmpItem.setTax3(_tmpTax3);
          final String _tmpIndProducao;
          _tmpIndProducao = _cursor.getString(_cursorIndexOfIndProducao);
          _tmpItem.setIndProducao(_tmpIndProducao);
          final Integer _tmpTipoPressao;
          if (_cursor.isNull(_cursorIndexOfTipoPressao)) {
            _tmpTipoPressao = null;
          } else {
            _tmpTipoPressao = _cursor.getInt(_cursorIndexOfTipoPressao);
          }
          _tmpItem.setTipoPressao(_tmpTipoPressao);
          final Integer _tmpIndRequerFator;
          if (_cursor.isNull(_cursorIndexOfIndRequerFator)) {
            _tmpIndRequerFator = null;
          } else {
            _tmpIndRequerFator = _cursor.getInt(_cursorIndexOfIndRequerFator);
          }
          _tmpItem.setIndRequerFator(_tmpIndRequerFator);
          final Double _tmpFatorPcs;
          if (_cursor.isNull(_cursorIndexOfFatorPcs)) {
            _tmpFatorPcs = null;
          } else {
            _tmpFatorPcs = _cursor.getDouble(_cursorIndexOfFatorPcs);
          }
          _tmpItem.setFatorPcs(_tmpFatorPcs);
          final Double _tmpPesoCilindro;
          if (_cursor.isNull(_cursorIndexOfPesoCilindro)) {
            _tmpPesoCilindro = null;
          } else {
            _tmpPesoCilindro = _cursor.getDouble(_cursorIndexOfPesoCilindro);
          }
          _tmpItem.setPesoCilindro(_tmpPesoCilindro);
          final Double _tmpPesoLiqUnitario;
          if (_cursor.isNull(_cursorIndexOfPesoLiqUnitario)) {
            _tmpPesoLiqUnitario = null;
          } else {
            _tmpPesoLiqUnitario = _cursor.getDouble(_cursorIndexOfPesoLiqUnitario);
          }
          _tmpItem.setPesoLiqUnitario(_tmpPesoLiqUnitario);
          final Double _tmpCapacidadeCilindro;
          if (_cursor.isNull(_cursorIndexOfCapacidadeCilindro)) {
            _tmpCapacidadeCilindro = null;
          } else {
            _tmpCapacidadeCilindro = _cursor.getDouble(_cursorIndexOfCapacidadeCilindro);
          }
          _tmpItem.setCapacidadeCilindro(_tmpCapacidadeCilindro);
          final String _tmpCstCilindro;
          _tmpCstCilindro = _cursor.getString(_cursorIndexOfCstCilindro);
          _tmpItem.setCstCilindro(_tmpCstCilindro);
          final String _tmpCstGas;
          _tmpCstGas = _cursor.getString(_cursorIndexOfCstGas);
          _tmpItem.setCstGas(_tmpCstGas);
          final Long _tmpClasseNcmGas;
          if (_cursor.isNull(_cursorIndexOfClasseNcmGas)) {
            _tmpClasseNcmGas = null;
          } else {
            _tmpClasseNcmGas = _cursor.getLong(_cursorIndexOfClasseNcmGas);
          }
          _tmpItem.setClasseNcmGas(_tmpClasseNcmGas);
          final Long _tmpClasseNcmCilindro;
          if (_cursor.isNull(_cursorIndexOfClasseNcmCilindro)) {
            _tmpClasseNcmCilindro = null;
          } else {
            _tmpClasseNcmCilindro = _cursor.getLong(_cursorIndexOfClasseNcmCilindro);
          }
          _tmpItem.setClasseNcmCilindro(_tmpClasseNcmCilindro);
          final Double _tmpFatorConversao;
          if (_cursor.isNull(_cursorIndexOfFatorConversao)) {
            _tmpFatorConversao = null;
          } else {
            _tmpFatorConversao = _cursor.getDouble(_cursorIndexOfFatorConversao);
          }
          _tmpItem.setFatorConversao(_tmpFatorConversao);
          final String _tmpIndFatorConvPolegadas;
          _tmpIndFatorConvPolegadas = _cursor.getString(_cursorIndexOfIndFatorConvPolegadas);
          _tmpItem.setIndFatorConvPolegadas(_tmpIndFatorConvPolegadas);
          final Integer _tmpTipoItem;
          if (_cursor.isNull(_cursorIndexOfTipoItem)) {
            _tmpTipoItem = null;
          } else {
            _tmpTipoItem = _cursor.getInt(_cursorIndexOfTipoItem);
          }
          _tmpItem.setTipoItem(_tmpTipoItem);
          final String _tmpTipoPropriedade;
          _tmpTipoPropriedade = _cursor.getString(_cursorIndexOfTipoPropriedade);
          _tmpItem.setTipoPropriedade(_tmpTipoPropriedade);
          final String _tmpIndRastreavel;
          _tmpIndRastreavel = _cursor.getString(_cursorIndexOfIndRastreavel);
          _tmpItem.setIndRastreavel(_tmpIndRastreavel);
        }  else  {
          _tmpItem = null;
        }
        _item_1 = new ItemPrice();
        _item_1.setPrice(_tmpPrice);
        _item_1.setItem(_tmpItem);
        _result.add(_item_1);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<ItemPrice> findPricesTrb(Long cdItem) {
    final String _sql = "SELECT Item.cdItem as it_cdItem, Item.cdCilindro as it_cdCilindro, Item.tipoPressao as it_tipoPressao, Item.descricaoCilindro as it_descricaoCilindro, Item.descricaoProduto as it_descricaoProduto, Item.valorIndenizacao as it_valorIndenizacao, Item.capacidadeProduto as it_capacidadeProduto, Item.unidadeMedida as it_unidadeMedida,Item.tax3 as it_tax3, Item.indProducao as it_indProducao, Item.indRequerFator as it_indRequerFator, Item.pesoCilindro as it_pesoCilindro, Item.pesoLiqUnitario as it_pesoLiqUnitario, Item.capacidadeCilindro as it_capacidadeCilindro,Item.cstCilindro as it_cstCilindro, Item.cstGas as it_cstGas, Item.classeNcmGas as it_classeNcmGas, Item.classeNcmCilindro as it_classeNcmCilindro, Item.tipoItem as it_tipoItem, Item.tipoPropriedade as it_tipoPropriedade, Item.fatorConversao as it_fatorConversao, Item.indFatorConvPolegadas as it_indFatorConvPolegadas, Item.indRastreavel as it_indRastreavel  FROM Item WHERE Item.cdItem = ifnull(?, Item.cdItem)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (cdItem == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cdItem);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCdItem = _cursor.getColumnIndexOrThrow("it_cdItem");
      final int _cursorIndexOfCdCilindro = _cursor.getColumnIndexOrThrow("it_cdCilindro");
      final int _cursorIndexOfTipoPressao = _cursor.getColumnIndexOrThrow("it_tipoPressao");
      final int _cursorIndexOfDescricaoCilindro = _cursor.getColumnIndexOrThrow("it_descricaoCilindro");
      final int _cursorIndexOfDescricaoProduto = _cursor.getColumnIndexOrThrow("it_descricaoProduto");
      final int _cursorIndexOfValorIndenizacao = _cursor.getColumnIndexOrThrow("it_valorIndenizacao");
      final int _cursorIndexOfCapacidadeProduto = _cursor.getColumnIndexOrThrow("it_capacidadeProduto");
      final int _cursorIndexOfUnidadeMedida = _cursor.getColumnIndexOrThrow("it_unidadeMedida");
      final int _cursorIndexOfTax3 = _cursor.getColumnIndexOrThrow("it_tax3");
      final int _cursorIndexOfIndProducao = _cursor.getColumnIndexOrThrow("it_indProducao");
      final int _cursorIndexOfIndRequerFator = _cursor.getColumnIndexOrThrow("it_indRequerFator");
      final int _cursorIndexOfPesoCilindro = _cursor.getColumnIndexOrThrow("it_pesoCilindro");
      final int _cursorIndexOfPesoLiqUnitario = _cursor.getColumnIndexOrThrow("it_pesoLiqUnitario");
      final int _cursorIndexOfCapacidadeCilindro = _cursor.getColumnIndexOrThrow("it_capacidadeCilindro");
      final int _cursorIndexOfCstCilindro = _cursor.getColumnIndexOrThrow("it_cstCilindro");
      final int _cursorIndexOfCstGas = _cursor.getColumnIndexOrThrow("it_cstGas");
      final int _cursorIndexOfClasseNcmGas = _cursor.getColumnIndexOrThrow("it_classeNcmGas");
      final int _cursorIndexOfClasseNcmCilindro = _cursor.getColumnIndexOrThrow("it_classeNcmCilindro");
      final int _cursorIndexOfTipoItem = _cursor.getColumnIndexOrThrow("it_tipoItem");
      final int _cursorIndexOfTipoPropriedade = _cursor.getColumnIndexOrThrow("it_tipoPropriedade");
      final int _cursorIndexOfFatorConversao = _cursor.getColumnIndexOrThrow("it_fatorConversao");
      final int _cursorIndexOfIndFatorConvPolegadas = _cursor.getColumnIndexOrThrow("it_indFatorConvPolegadas");
      final int _cursorIndexOfIndRastreavel = _cursor.getColumnIndexOrThrow("it_indRastreavel");
      final List<ItemPrice> _result = new ArrayList<ItemPrice>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ItemPrice _item;
        final Item _tmpItem;
        if (! (_cursor.isNull(_cursorIndexOfCdItem) && _cursor.isNull(_cursorIndexOfCdCilindro) && _cursor.isNull(_cursorIndexOfTipoPressao) && _cursor.isNull(_cursorIndexOfDescricaoCilindro) && _cursor.isNull(_cursorIndexOfDescricaoProduto) && _cursor.isNull(_cursorIndexOfValorIndenizacao) && _cursor.isNull(_cursorIndexOfCapacidadeProduto) && _cursor.isNull(_cursorIndexOfUnidadeMedida) && _cursor.isNull(_cursorIndexOfTax3) && _cursor.isNull(_cursorIndexOfIndProducao) && _cursor.isNull(_cursorIndexOfIndRequerFator) && _cursor.isNull(_cursorIndexOfPesoCilindro) && _cursor.isNull(_cursorIndexOfPesoLiqUnitario) && _cursor.isNull(_cursorIndexOfCapacidadeCilindro) && _cursor.isNull(_cursorIndexOfCstCilindro) && _cursor.isNull(_cursorIndexOfCstGas) && _cursor.isNull(_cursorIndexOfClasseNcmGas) && _cursor.isNull(_cursorIndexOfClasseNcmCilindro) && _cursor.isNull(_cursorIndexOfTipoItem) && _cursor.isNull(_cursorIndexOfTipoPropriedade) && _cursor.isNull(_cursorIndexOfFatorConversao) && _cursor.isNull(_cursorIndexOfIndFatorConvPolegadas) && _cursor.isNull(_cursorIndexOfIndRastreavel))) {
          _tmpItem = new Item();
          final Long _tmpCdItem;
          if (_cursor.isNull(_cursorIndexOfCdItem)) {
            _tmpCdItem = null;
          } else {
            _tmpCdItem = _cursor.getLong(_cursorIndexOfCdItem);
          }
          _tmpItem.setCdItem(_tmpCdItem);
          final Long _tmpCdCilindro;
          if (_cursor.isNull(_cursorIndexOfCdCilindro)) {
            _tmpCdCilindro = null;
          } else {
            _tmpCdCilindro = _cursor.getLong(_cursorIndexOfCdCilindro);
          }
          _tmpItem.setCdCilindro(_tmpCdCilindro);
          final Integer _tmpTipoPressao;
          if (_cursor.isNull(_cursorIndexOfTipoPressao)) {
            _tmpTipoPressao = null;
          } else {
            _tmpTipoPressao = _cursor.getInt(_cursorIndexOfTipoPressao);
          }
          _tmpItem.setTipoPressao(_tmpTipoPressao);
          final String _tmpDescricaoCilindro;
          _tmpDescricaoCilindro = _cursor.getString(_cursorIndexOfDescricaoCilindro);
          _tmpItem.setDescricaoCilindro(_tmpDescricaoCilindro);
          final String _tmpDescricaoProduto;
          _tmpDescricaoProduto = _cursor.getString(_cursorIndexOfDescricaoProduto);
          _tmpItem.setDescricaoProduto(_tmpDescricaoProduto);
          final Double _tmpValorIndenizacao;
          if (_cursor.isNull(_cursorIndexOfValorIndenizacao)) {
            _tmpValorIndenizacao = null;
          } else {
            _tmpValorIndenizacao = _cursor.getDouble(_cursorIndexOfValorIndenizacao);
          }
          _tmpItem.setValorIndenizacao(_tmpValorIndenizacao);
          final Double _tmpCapacidadeProduto;
          if (_cursor.isNull(_cursorIndexOfCapacidadeProduto)) {
            _tmpCapacidadeProduto = null;
          } else {
            _tmpCapacidadeProduto = _cursor.getDouble(_cursorIndexOfCapacidadeProduto);
          }
          _tmpItem.setCapacidadeProduto(_tmpCapacidadeProduto);
          final String _tmpUnidadeMedida;
          _tmpUnidadeMedida = _cursor.getString(_cursorIndexOfUnidadeMedida);
          _tmpItem.setUnidadeMedida(_tmpUnidadeMedida);
          final String _tmpTax3;
          _tmpTax3 = _cursor.getString(_cursorIndexOfTax3);
          _tmpItem.setTax3(_tmpTax3);
          final String _tmpIndProducao;
          _tmpIndProducao = _cursor.getString(_cursorIndexOfIndProducao);
          _tmpItem.setIndProducao(_tmpIndProducao);
          final Integer _tmpIndRequerFator;
          if (_cursor.isNull(_cursorIndexOfIndRequerFator)) {
            _tmpIndRequerFator = null;
          } else {
            _tmpIndRequerFator = _cursor.getInt(_cursorIndexOfIndRequerFator);
          }
          _tmpItem.setIndRequerFator(_tmpIndRequerFator);
          final Double _tmpPesoCilindro;
          if (_cursor.isNull(_cursorIndexOfPesoCilindro)) {
            _tmpPesoCilindro = null;
          } else {
            _tmpPesoCilindro = _cursor.getDouble(_cursorIndexOfPesoCilindro);
          }
          _tmpItem.setPesoCilindro(_tmpPesoCilindro);
          final Double _tmpPesoLiqUnitario;
          if (_cursor.isNull(_cursorIndexOfPesoLiqUnitario)) {
            _tmpPesoLiqUnitario = null;
          } else {
            _tmpPesoLiqUnitario = _cursor.getDouble(_cursorIndexOfPesoLiqUnitario);
          }
          _tmpItem.setPesoLiqUnitario(_tmpPesoLiqUnitario);
          final Double _tmpCapacidadeCilindro;
          if (_cursor.isNull(_cursorIndexOfCapacidadeCilindro)) {
            _tmpCapacidadeCilindro = null;
          } else {
            _tmpCapacidadeCilindro = _cursor.getDouble(_cursorIndexOfCapacidadeCilindro);
          }
          _tmpItem.setCapacidadeCilindro(_tmpCapacidadeCilindro);
          final String _tmpCstCilindro;
          _tmpCstCilindro = _cursor.getString(_cursorIndexOfCstCilindro);
          _tmpItem.setCstCilindro(_tmpCstCilindro);
          final String _tmpCstGas;
          _tmpCstGas = _cursor.getString(_cursorIndexOfCstGas);
          _tmpItem.setCstGas(_tmpCstGas);
          final Long _tmpClasseNcmGas;
          if (_cursor.isNull(_cursorIndexOfClasseNcmGas)) {
            _tmpClasseNcmGas = null;
          } else {
            _tmpClasseNcmGas = _cursor.getLong(_cursorIndexOfClasseNcmGas);
          }
          _tmpItem.setClasseNcmGas(_tmpClasseNcmGas);
          final Long _tmpClasseNcmCilindro;
          if (_cursor.isNull(_cursorIndexOfClasseNcmCilindro)) {
            _tmpClasseNcmCilindro = null;
          } else {
            _tmpClasseNcmCilindro = _cursor.getLong(_cursorIndexOfClasseNcmCilindro);
          }
          _tmpItem.setClasseNcmCilindro(_tmpClasseNcmCilindro);
          final Integer _tmpTipoItem;
          if (_cursor.isNull(_cursorIndexOfTipoItem)) {
            _tmpTipoItem = null;
          } else {
            _tmpTipoItem = _cursor.getInt(_cursorIndexOfTipoItem);
          }
          _tmpItem.setTipoItem(_tmpTipoItem);
          final String _tmpTipoPropriedade;
          _tmpTipoPropriedade = _cursor.getString(_cursorIndexOfTipoPropriedade);
          _tmpItem.setTipoPropriedade(_tmpTipoPropriedade);
          final Double _tmpFatorConversao;
          if (_cursor.isNull(_cursorIndexOfFatorConversao)) {
            _tmpFatorConversao = null;
          } else {
            _tmpFatorConversao = _cursor.getDouble(_cursorIndexOfFatorConversao);
          }
          _tmpItem.setFatorConversao(_tmpFatorConversao);
          final String _tmpIndFatorConvPolegadas;
          _tmpIndFatorConvPolegadas = _cursor.getString(_cursorIndexOfIndFatorConvPolegadas);
          _tmpItem.setIndFatorConvPolegadas(_tmpIndFatorConvPolegadas);
          final String _tmpIndRastreavel;
          _tmpIndRastreavel = _cursor.getString(_cursorIndexOfIndRastreavel);
          _tmpItem.setIndRastreavel(_tmpIndRastreavel);
        }  else  {
          _tmpItem = null;
        }
        _item = new ItemPrice();
        _item.setItem(_tmpItem);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<ItemPrice> findPricesTrf(Long cdCustomer) {
    final String _sql = "SELECT  Price.*, Item.cdItem as it_cdItem, Item.descricaoProduto as it_descricaoProduto, Item.descricaoCilindro as it_descricaoCilindro,  Item.capacidadeProduto as it_capacidadeProduto, Item.unidadeMedida as it_unidadeMedida, Item.tax3 as it_tax3, Item.indProducao as it_indProducao, Item.tipoPressao as it_tipoPressao, Item.indRequerFator as it_indRequerFator, Item.fatorPcs as it_fatorPcs,  Item.pesoCilindro as it_pesoCilindro, Item.pesoLiqUnitario as it_pesoLiqUnitario,  Item.capacidadeCilindro as it_capacidadeCilindro,  Item.cstCilindro as it_cstCilindro, Item.cstGas as it_cstGas,  Item.classeNcmGas as it_classeNcmGas, Item.classeNcmCilindro as it_classeNcmCilindro,  Item.tipoItem as it_tipoItem, Item.tipoPropriedade as it_tipoPropriedade,  Item.fatorConversao as it_fatorConversao,  Item.indFatorConvPolegadas as it_indFatorConvPolegadas, Item.indRastreavel as it_indRastreavel  FROM Price  INNER JOIN Item ON Price.cdItem = Item.cdItem  WHERE Price.cdCustomer = ?    AND Price.condicaoFaturamento <> 991";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (cdCustomer == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cdCustomer);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfCdItem = _cursor.getColumnIndexOrThrow("cdItem");
      final int _cursorIndexOfFlNovoFaturamento = _cursor.getColumnIndexOrThrow("flNovoFaturamento");
      final int _cursorIndexOfPercentualIpi = _cursor.getColumnIndexOrThrow("percentualIpi");
      final int _cursorIndexOfPercentualIcms = _cursor.getColumnIndexOrThrow("percentualIcms");
      final int _cursorIndexOfPercReducaoIcms = _cursor.getColumnIndexOrThrow("percReducaoIcms");
      final int _cursorIndexOfPrecoUnitario = _cursor.getColumnIndexOrThrow("precoUnitario");
      final int _cursorIndexOfValorFrete = _cursor.getColumnIndexOrThrow("valorFrete");
      final int _cursorIndexOfValorDespesas = _cursor.getColumnIndexOrThrow("valorDespesas");
      final int _cursorIndexOfPercentualPis = _cursor.getColumnIndexOrThrow("percentualPis");
      final int _cursorIndexOfPercentualCofins = _cursor.getColumnIndexOrThrow("percentualCofins");
      final int _cursorIndexOfCstPis = _cursor.getColumnIndexOrThrow("cstPis");
      final int _cursorIndexOfCstCofins = _cursor.getColumnIndexOrThrow("cstCofins");
      final int _cursorIndexOfSituacaoTributaria = _cursor.getColumnIndexOrThrow("situacaoTributaria");
      final int _cursorIndexOfCondicaoFaturamento = _cursor.getColumnIndexOrThrow("condicaoFaturamento");
      final int _cursorIndexOfCdItem_1 = _cursor.getColumnIndexOrThrow("it_cdItem");
      final int _cursorIndexOfDescricaoProduto = _cursor.getColumnIndexOrThrow("it_descricaoProduto");
      final int _cursorIndexOfDescricaoCilindro = _cursor.getColumnIndexOrThrow("it_descricaoCilindro");
      final int _cursorIndexOfCapacidadeProduto = _cursor.getColumnIndexOrThrow("it_capacidadeProduto");
      final int _cursorIndexOfUnidadeMedida = _cursor.getColumnIndexOrThrow("it_unidadeMedida");
      final int _cursorIndexOfTax3 = _cursor.getColumnIndexOrThrow("it_tax3");
      final int _cursorIndexOfIndProducao = _cursor.getColumnIndexOrThrow("it_indProducao");
      final int _cursorIndexOfTipoPressao = _cursor.getColumnIndexOrThrow("it_tipoPressao");
      final int _cursorIndexOfIndRequerFator = _cursor.getColumnIndexOrThrow("it_indRequerFator");
      final int _cursorIndexOfFatorPcs = _cursor.getColumnIndexOrThrow("it_fatorPcs");
      final int _cursorIndexOfPesoCilindro = _cursor.getColumnIndexOrThrow("it_pesoCilindro");
      final int _cursorIndexOfPesoLiqUnitario = _cursor.getColumnIndexOrThrow("it_pesoLiqUnitario");
      final int _cursorIndexOfCapacidadeCilindro = _cursor.getColumnIndexOrThrow("it_capacidadeCilindro");
      final int _cursorIndexOfCstCilindro = _cursor.getColumnIndexOrThrow("it_cstCilindro");
      final int _cursorIndexOfCstGas = _cursor.getColumnIndexOrThrow("it_cstGas");
      final int _cursorIndexOfClasseNcmGas = _cursor.getColumnIndexOrThrow("it_classeNcmGas");
      final int _cursorIndexOfClasseNcmCilindro = _cursor.getColumnIndexOrThrow("it_classeNcmCilindro");
      final int _cursorIndexOfTipoItem = _cursor.getColumnIndexOrThrow("it_tipoItem");
      final int _cursorIndexOfTipoPropriedade = _cursor.getColumnIndexOrThrow("it_tipoPropriedade");
      final int _cursorIndexOfFatorConversao = _cursor.getColumnIndexOrThrow("it_fatorConversao");
      final int _cursorIndexOfIndFatorConvPolegadas = _cursor.getColumnIndexOrThrow("it_indFatorConvPolegadas");
      final int _cursorIndexOfIndRastreavel = _cursor.getColumnIndexOrThrow("it_indRastreavel");
      final List<ItemPrice> _result = new ArrayList<ItemPrice>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ItemPrice _item;
        final Price _tmpPrice;
        if (! (_cursor.isNull(_cursorIndexOfCdCustomer) && _cursor.isNull(_cursorIndexOfCdItem) && _cursor.isNull(_cursorIndexOfFlNovoFaturamento) && _cursor.isNull(_cursorIndexOfPercentualIpi) && _cursor.isNull(_cursorIndexOfPercentualIcms) && _cursor.isNull(_cursorIndexOfPercReducaoIcms) && _cursor.isNull(_cursorIndexOfPrecoUnitario) && _cursor.isNull(_cursorIndexOfValorFrete) && _cursor.isNull(_cursorIndexOfValorDespesas) && _cursor.isNull(_cursorIndexOfPercentualPis) && _cursor.isNull(_cursorIndexOfPercentualCofins) && _cursor.isNull(_cursorIndexOfCstPis) && _cursor.isNull(_cursorIndexOfCstCofins) && _cursor.isNull(_cursorIndexOfSituacaoTributaria) && _cursor.isNull(_cursorIndexOfCondicaoFaturamento))) {
          _tmpPrice = new Price();
          final Long _tmpCdCustomer;
          if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
            _tmpCdCustomer = null;
          } else {
            _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
          }
          _tmpPrice.setCdCustomer(_tmpCdCustomer);
          final Long _tmpCdItem;
          if (_cursor.isNull(_cursorIndexOfCdItem)) {
            _tmpCdItem = null;
          } else {
            _tmpCdItem = _cursor.getLong(_cursorIndexOfCdItem);
          }
          _tmpPrice.setCdItem(_tmpCdItem);
          final String _tmpFlNovoFaturamento;
          _tmpFlNovoFaturamento = _cursor.getString(_cursorIndexOfFlNovoFaturamento);
          _tmpPrice.setFlNovoFaturamento(_tmpFlNovoFaturamento);
          final Double _tmpPercentualIpi;
          if (_cursor.isNull(_cursorIndexOfPercentualIpi)) {
            _tmpPercentualIpi = null;
          } else {
            _tmpPercentualIpi = _cursor.getDouble(_cursorIndexOfPercentualIpi);
          }
          _tmpPrice.setPercentualIpi(_tmpPercentualIpi);
          final Double _tmpPercentualIcms;
          if (_cursor.isNull(_cursorIndexOfPercentualIcms)) {
            _tmpPercentualIcms = null;
          } else {
            _tmpPercentualIcms = _cursor.getDouble(_cursorIndexOfPercentualIcms);
          }
          _tmpPrice.setPercentualIcms(_tmpPercentualIcms);
          final Double _tmpPercReducaoIcms;
          if (_cursor.isNull(_cursorIndexOfPercReducaoIcms)) {
            _tmpPercReducaoIcms = null;
          } else {
            _tmpPercReducaoIcms = _cursor.getDouble(_cursorIndexOfPercReducaoIcms);
          }
          _tmpPrice.setPercReducaoIcms(_tmpPercReducaoIcms);
          final Double _tmpPrecoUnitario;
          if (_cursor.isNull(_cursorIndexOfPrecoUnitario)) {
            _tmpPrecoUnitario = null;
          } else {
            _tmpPrecoUnitario = _cursor.getDouble(_cursorIndexOfPrecoUnitario);
          }
          _tmpPrice.setPrecoUnitario(_tmpPrecoUnitario);
          final Double _tmpValorFrete;
          if (_cursor.isNull(_cursorIndexOfValorFrete)) {
            _tmpValorFrete = null;
          } else {
            _tmpValorFrete = _cursor.getDouble(_cursorIndexOfValorFrete);
          }
          _tmpPrice.setValorFrete(_tmpValorFrete);
          final Double _tmpValorDespesas;
          if (_cursor.isNull(_cursorIndexOfValorDespesas)) {
            _tmpValorDespesas = null;
          } else {
            _tmpValorDespesas = _cursor.getDouble(_cursorIndexOfValorDespesas);
          }
          _tmpPrice.setValorDespesas(_tmpValorDespesas);
          final Double _tmpPercentualPis;
          if (_cursor.isNull(_cursorIndexOfPercentualPis)) {
            _tmpPercentualPis = null;
          } else {
            _tmpPercentualPis = _cursor.getDouble(_cursorIndexOfPercentualPis);
          }
          _tmpPrice.setPercentualPis(_tmpPercentualPis);
          final Double _tmpPercentualCofins;
          if (_cursor.isNull(_cursorIndexOfPercentualCofins)) {
            _tmpPercentualCofins = null;
          } else {
            _tmpPercentualCofins = _cursor.getDouble(_cursorIndexOfPercentualCofins);
          }
          _tmpPrice.setPercentualCofins(_tmpPercentualCofins);
          final String _tmpCstPis;
          _tmpCstPis = _cursor.getString(_cursorIndexOfCstPis);
          _tmpPrice.setCstPis(_tmpCstPis);
          final String _tmpCstCofins;
          _tmpCstCofins = _cursor.getString(_cursorIndexOfCstCofins);
          _tmpPrice.setCstCofins(_tmpCstCofins);
          final String _tmpSituacaoTributaria;
          _tmpSituacaoTributaria = _cursor.getString(_cursorIndexOfSituacaoTributaria);
          _tmpPrice.setSituacaoTributaria(_tmpSituacaoTributaria);
          final String _tmpCondicaoFaturamento;
          _tmpCondicaoFaturamento = _cursor.getString(_cursorIndexOfCondicaoFaturamento);
          _tmpPrice.setCondicaoFaturamento(_tmpCondicaoFaturamento);
        }  else  {
          _tmpPrice = null;
        }
        final Item _tmpItem;
        if (! (_cursor.isNull(_cursorIndexOfCdItem_1) && _cursor.isNull(_cursorIndexOfDescricaoProduto) && _cursor.isNull(_cursorIndexOfDescricaoCilindro) && _cursor.isNull(_cursorIndexOfCapacidadeProduto) && _cursor.isNull(_cursorIndexOfUnidadeMedida) && _cursor.isNull(_cursorIndexOfTax3) && _cursor.isNull(_cursorIndexOfIndProducao) && _cursor.isNull(_cursorIndexOfTipoPressao) && _cursor.isNull(_cursorIndexOfIndRequerFator) && _cursor.isNull(_cursorIndexOfFatorPcs) && _cursor.isNull(_cursorIndexOfPesoCilindro) && _cursor.isNull(_cursorIndexOfPesoLiqUnitario) && _cursor.isNull(_cursorIndexOfCapacidadeCilindro) && _cursor.isNull(_cursorIndexOfCstCilindro) && _cursor.isNull(_cursorIndexOfCstGas) && _cursor.isNull(_cursorIndexOfClasseNcmGas) && _cursor.isNull(_cursorIndexOfClasseNcmCilindro) && _cursor.isNull(_cursorIndexOfTipoItem) && _cursor.isNull(_cursorIndexOfTipoPropriedade) && _cursor.isNull(_cursorIndexOfFatorConversao) && _cursor.isNull(_cursorIndexOfIndFatorConvPolegadas) && _cursor.isNull(_cursorIndexOfIndRastreavel))) {
          _tmpItem = new Item();
          final Long _tmpCdItem_1;
          if (_cursor.isNull(_cursorIndexOfCdItem_1)) {
            _tmpCdItem_1 = null;
          } else {
            _tmpCdItem_1 = _cursor.getLong(_cursorIndexOfCdItem_1);
          }
          _tmpItem.setCdItem(_tmpCdItem_1);
          final String _tmpDescricaoProduto;
          _tmpDescricaoProduto = _cursor.getString(_cursorIndexOfDescricaoProduto);
          _tmpItem.setDescricaoProduto(_tmpDescricaoProduto);
          final String _tmpDescricaoCilindro;
          _tmpDescricaoCilindro = _cursor.getString(_cursorIndexOfDescricaoCilindro);
          _tmpItem.setDescricaoCilindro(_tmpDescricaoCilindro);
          final Double _tmpCapacidadeProduto;
          if (_cursor.isNull(_cursorIndexOfCapacidadeProduto)) {
            _tmpCapacidadeProduto = null;
          } else {
            _tmpCapacidadeProduto = _cursor.getDouble(_cursorIndexOfCapacidadeProduto);
          }
          _tmpItem.setCapacidadeProduto(_tmpCapacidadeProduto);
          final String _tmpUnidadeMedida;
          _tmpUnidadeMedida = _cursor.getString(_cursorIndexOfUnidadeMedida);
          _tmpItem.setUnidadeMedida(_tmpUnidadeMedida);
          final String _tmpTax3;
          _tmpTax3 = _cursor.getString(_cursorIndexOfTax3);
          _tmpItem.setTax3(_tmpTax3);
          final String _tmpIndProducao;
          _tmpIndProducao = _cursor.getString(_cursorIndexOfIndProducao);
          _tmpItem.setIndProducao(_tmpIndProducao);
          final Integer _tmpTipoPressao;
          if (_cursor.isNull(_cursorIndexOfTipoPressao)) {
            _tmpTipoPressao = null;
          } else {
            _tmpTipoPressao = _cursor.getInt(_cursorIndexOfTipoPressao);
          }
          _tmpItem.setTipoPressao(_tmpTipoPressao);
          final Integer _tmpIndRequerFator;
          if (_cursor.isNull(_cursorIndexOfIndRequerFator)) {
            _tmpIndRequerFator = null;
          } else {
            _tmpIndRequerFator = _cursor.getInt(_cursorIndexOfIndRequerFator);
          }
          _tmpItem.setIndRequerFator(_tmpIndRequerFator);
          final Double _tmpFatorPcs;
          if (_cursor.isNull(_cursorIndexOfFatorPcs)) {
            _tmpFatorPcs = null;
          } else {
            _tmpFatorPcs = _cursor.getDouble(_cursorIndexOfFatorPcs);
          }
          _tmpItem.setFatorPcs(_tmpFatorPcs);
          final Double _tmpPesoCilindro;
          if (_cursor.isNull(_cursorIndexOfPesoCilindro)) {
            _tmpPesoCilindro = null;
          } else {
            _tmpPesoCilindro = _cursor.getDouble(_cursorIndexOfPesoCilindro);
          }
          _tmpItem.setPesoCilindro(_tmpPesoCilindro);
          final Double _tmpPesoLiqUnitario;
          if (_cursor.isNull(_cursorIndexOfPesoLiqUnitario)) {
            _tmpPesoLiqUnitario = null;
          } else {
            _tmpPesoLiqUnitario = _cursor.getDouble(_cursorIndexOfPesoLiqUnitario);
          }
          _tmpItem.setPesoLiqUnitario(_tmpPesoLiqUnitario);
          final Double _tmpCapacidadeCilindro;
          if (_cursor.isNull(_cursorIndexOfCapacidadeCilindro)) {
            _tmpCapacidadeCilindro = null;
          } else {
            _tmpCapacidadeCilindro = _cursor.getDouble(_cursorIndexOfCapacidadeCilindro);
          }
          _tmpItem.setCapacidadeCilindro(_tmpCapacidadeCilindro);
          final String _tmpCstCilindro;
          _tmpCstCilindro = _cursor.getString(_cursorIndexOfCstCilindro);
          _tmpItem.setCstCilindro(_tmpCstCilindro);
          final String _tmpCstGas;
          _tmpCstGas = _cursor.getString(_cursorIndexOfCstGas);
          _tmpItem.setCstGas(_tmpCstGas);
          final Long _tmpClasseNcmGas;
          if (_cursor.isNull(_cursorIndexOfClasseNcmGas)) {
            _tmpClasseNcmGas = null;
          } else {
            _tmpClasseNcmGas = _cursor.getLong(_cursorIndexOfClasseNcmGas);
          }
          _tmpItem.setClasseNcmGas(_tmpClasseNcmGas);
          final Long _tmpClasseNcmCilindro;
          if (_cursor.isNull(_cursorIndexOfClasseNcmCilindro)) {
            _tmpClasseNcmCilindro = null;
          } else {
            _tmpClasseNcmCilindro = _cursor.getLong(_cursorIndexOfClasseNcmCilindro);
          }
          _tmpItem.setClasseNcmCilindro(_tmpClasseNcmCilindro);
          final Integer _tmpTipoItem;
          if (_cursor.isNull(_cursorIndexOfTipoItem)) {
            _tmpTipoItem = null;
          } else {
            _tmpTipoItem = _cursor.getInt(_cursorIndexOfTipoItem);
          }
          _tmpItem.setTipoItem(_tmpTipoItem);
          final String _tmpTipoPropriedade;
          _tmpTipoPropriedade = _cursor.getString(_cursorIndexOfTipoPropriedade);
          _tmpItem.setTipoPropriedade(_tmpTipoPropriedade);
          final Double _tmpFatorConversao;
          if (_cursor.isNull(_cursorIndexOfFatorConversao)) {
            _tmpFatorConversao = null;
          } else {
            _tmpFatorConversao = _cursor.getDouble(_cursorIndexOfFatorConversao);
          }
          _tmpItem.setFatorConversao(_tmpFatorConversao);
          final String _tmpIndFatorConvPolegadas;
          _tmpIndFatorConvPolegadas = _cursor.getString(_cursorIndexOfIndFatorConvPolegadas);
          _tmpItem.setIndFatorConvPolegadas(_tmpIndFatorConvPolegadas);
          final String _tmpIndRastreavel;
          _tmpIndRastreavel = _cursor.getString(_cursorIndexOfIndRastreavel);
          _tmpItem.setIndRastreavel(_tmpIndRastreavel);
        }  else  {
          _tmpItem = null;
        }
        _item = new ItemPrice();
        _item.setPrice(_tmpPrice);
        _item.setItem(_tmpItem);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<ItemPrice> findPricesRfh(Long cdCustomer, Long cdItem, List<Integer> tipoItem,
      String flNovoFaturamento) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT  Price.*, Item.cdItem as it_cdItem, Item.descricaoProduto as it_descricaoProduto, Item.descricaoCilindro as it_descricaoCilindro,  Item.capacidadeProduto as it_capacidadeProduto, Item.unidadeMedida as it_unidadeMedida, Item.tax3 as it_tax3, Item.indProducao as it_indProducao, Item.tipoPressao as it_tipoPressao, Item.indRequerFator as it_indRequerFator, Item.fatorPcs as it_fatorPcs,  Item.pesoCilindro as it_pesoCilindro, Item.pesoLiqUnitario as it_pesoLiqUnitario,  Item.capacidadeCilindro as it_capacidadeCilindro,  Item.cstCilindro as it_cstCilindro, Item.cstGas as it_cstGas,  Item.classeNcmGas as it_classeNcmGas, Item.classeNcmCilindro as it_classeNcmCilindro,  Item.fatorConversao as it_fatorConversao,  Item.indFatorConvPolegadas as it_indFatorConvPolegadas,  Item.tipoItem as it_tipoItem, Item.tipoPropriedade as it_tipoPropriedade, Item.indRastreavel as it_indRastreavel  FROM Price  INNER JOIN Item ON Price.cdItem = Item.cdItem  WHERE Price.cdCustomer = ");
    _stringBuilder.append("?");
    _stringBuilder.append("    AND Price.flNovoFaturamento = ");
    _stringBuilder.append("?");
    _stringBuilder.append("   AND Price.condicaoFaturamento <> 991   AND Price.cdItem = ifnull(");
    _stringBuilder.append("?");
    _stringBuilder.append(", Price.cdItem)   AND Item.tipoItem in (");
    final int _inputSize = tipoItem.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")   AND Item.qtdCilindroCheios > 0 ");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 3 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    if (cdCustomer == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cdCustomer);
    }
    _argIndex = 2;
    if (flNovoFaturamento == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, flNovoFaturamento);
    }
    _argIndex = 3;
    if (cdItem == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cdItem);
    }
    _argIndex = 4;
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
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfCdItem = _cursor.getColumnIndexOrThrow("cdItem");
      final int _cursorIndexOfFlNovoFaturamento = _cursor.getColumnIndexOrThrow("flNovoFaturamento");
      final int _cursorIndexOfPercentualIpi = _cursor.getColumnIndexOrThrow("percentualIpi");
      final int _cursorIndexOfPercentualIcms = _cursor.getColumnIndexOrThrow("percentualIcms");
      final int _cursorIndexOfPercReducaoIcms = _cursor.getColumnIndexOrThrow("percReducaoIcms");
      final int _cursorIndexOfPrecoUnitario = _cursor.getColumnIndexOrThrow("precoUnitario");
      final int _cursorIndexOfValorFrete = _cursor.getColumnIndexOrThrow("valorFrete");
      final int _cursorIndexOfValorDespesas = _cursor.getColumnIndexOrThrow("valorDespesas");
      final int _cursorIndexOfPercentualPis = _cursor.getColumnIndexOrThrow("percentualPis");
      final int _cursorIndexOfPercentualCofins = _cursor.getColumnIndexOrThrow("percentualCofins");
      final int _cursorIndexOfCstPis = _cursor.getColumnIndexOrThrow("cstPis");
      final int _cursorIndexOfCstCofins = _cursor.getColumnIndexOrThrow("cstCofins");
      final int _cursorIndexOfSituacaoTributaria = _cursor.getColumnIndexOrThrow("situacaoTributaria");
      final int _cursorIndexOfCondicaoFaturamento = _cursor.getColumnIndexOrThrow("condicaoFaturamento");
      final int _cursorIndexOfCdItem_1 = _cursor.getColumnIndexOrThrow("it_cdItem");
      final int _cursorIndexOfDescricaoProduto = _cursor.getColumnIndexOrThrow("it_descricaoProduto");
      final int _cursorIndexOfDescricaoCilindro = _cursor.getColumnIndexOrThrow("it_descricaoCilindro");
      final int _cursorIndexOfCapacidadeProduto = _cursor.getColumnIndexOrThrow("it_capacidadeProduto");
      final int _cursorIndexOfUnidadeMedida = _cursor.getColumnIndexOrThrow("it_unidadeMedida");
      final int _cursorIndexOfTax3 = _cursor.getColumnIndexOrThrow("it_tax3");
      final int _cursorIndexOfIndProducao = _cursor.getColumnIndexOrThrow("it_indProducao");
      final int _cursorIndexOfTipoPressao = _cursor.getColumnIndexOrThrow("it_tipoPressao");
      final int _cursorIndexOfIndRequerFator = _cursor.getColumnIndexOrThrow("it_indRequerFator");
      final int _cursorIndexOfFatorPcs = _cursor.getColumnIndexOrThrow("it_fatorPcs");
      final int _cursorIndexOfPesoCilindro = _cursor.getColumnIndexOrThrow("it_pesoCilindro");
      final int _cursorIndexOfPesoLiqUnitario = _cursor.getColumnIndexOrThrow("it_pesoLiqUnitario");
      final int _cursorIndexOfCapacidadeCilindro = _cursor.getColumnIndexOrThrow("it_capacidadeCilindro");
      final int _cursorIndexOfCstCilindro = _cursor.getColumnIndexOrThrow("it_cstCilindro");
      final int _cursorIndexOfCstGas = _cursor.getColumnIndexOrThrow("it_cstGas");
      final int _cursorIndexOfClasseNcmGas = _cursor.getColumnIndexOrThrow("it_classeNcmGas");
      final int _cursorIndexOfClasseNcmCilindro = _cursor.getColumnIndexOrThrow("it_classeNcmCilindro");
      final int _cursorIndexOfFatorConversao = _cursor.getColumnIndexOrThrow("it_fatorConversao");
      final int _cursorIndexOfIndFatorConvPolegadas = _cursor.getColumnIndexOrThrow("it_indFatorConvPolegadas");
      final int _cursorIndexOfTipoItem = _cursor.getColumnIndexOrThrow("it_tipoItem");
      final int _cursorIndexOfTipoPropriedade = _cursor.getColumnIndexOrThrow("it_tipoPropriedade");
      final int _cursorIndexOfIndRastreavel = _cursor.getColumnIndexOrThrow("it_indRastreavel");
      final List<ItemPrice> _result = new ArrayList<ItemPrice>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ItemPrice _item_1;
        final Price _tmpPrice;
        if (! (_cursor.isNull(_cursorIndexOfCdCustomer) && _cursor.isNull(_cursorIndexOfCdItem) && _cursor.isNull(_cursorIndexOfFlNovoFaturamento) && _cursor.isNull(_cursorIndexOfPercentualIpi) && _cursor.isNull(_cursorIndexOfPercentualIcms) && _cursor.isNull(_cursorIndexOfPercReducaoIcms) && _cursor.isNull(_cursorIndexOfPrecoUnitario) && _cursor.isNull(_cursorIndexOfValorFrete) && _cursor.isNull(_cursorIndexOfValorDespesas) && _cursor.isNull(_cursorIndexOfPercentualPis) && _cursor.isNull(_cursorIndexOfPercentualCofins) && _cursor.isNull(_cursorIndexOfCstPis) && _cursor.isNull(_cursorIndexOfCstCofins) && _cursor.isNull(_cursorIndexOfSituacaoTributaria) && _cursor.isNull(_cursorIndexOfCondicaoFaturamento))) {
          _tmpPrice = new Price();
          final Long _tmpCdCustomer;
          if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
            _tmpCdCustomer = null;
          } else {
            _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
          }
          _tmpPrice.setCdCustomer(_tmpCdCustomer);
          final Long _tmpCdItem;
          if (_cursor.isNull(_cursorIndexOfCdItem)) {
            _tmpCdItem = null;
          } else {
            _tmpCdItem = _cursor.getLong(_cursorIndexOfCdItem);
          }
          _tmpPrice.setCdItem(_tmpCdItem);
          final String _tmpFlNovoFaturamento;
          _tmpFlNovoFaturamento = _cursor.getString(_cursorIndexOfFlNovoFaturamento);
          _tmpPrice.setFlNovoFaturamento(_tmpFlNovoFaturamento);
          final Double _tmpPercentualIpi;
          if (_cursor.isNull(_cursorIndexOfPercentualIpi)) {
            _tmpPercentualIpi = null;
          } else {
            _tmpPercentualIpi = _cursor.getDouble(_cursorIndexOfPercentualIpi);
          }
          _tmpPrice.setPercentualIpi(_tmpPercentualIpi);
          final Double _tmpPercentualIcms;
          if (_cursor.isNull(_cursorIndexOfPercentualIcms)) {
            _tmpPercentualIcms = null;
          } else {
            _tmpPercentualIcms = _cursor.getDouble(_cursorIndexOfPercentualIcms);
          }
          _tmpPrice.setPercentualIcms(_tmpPercentualIcms);
          final Double _tmpPercReducaoIcms;
          if (_cursor.isNull(_cursorIndexOfPercReducaoIcms)) {
            _tmpPercReducaoIcms = null;
          } else {
            _tmpPercReducaoIcms = _cursor.getDouble(_cursorIndexOfPercReducaoIcms);
          }
          _tmpPrice.setPercReducaoIcms(_tmpPercReducaoIcms);
          final Double _tmpPrecoUnitario;
          if (_cursor.isNull(_cursorIndexOfPrecoUnitario)) {
            _tmpPrecoUnitario = null;
          } else {
            _tmpPrecoUnitario = _cursor.getDouble(_cursorIndexOfPrecoUnitario);
          }
          _tmpPrice.setPrecoUnitario(_tmpPrecoUnitario);
          final Double _tmpValorFrete;
          if (_cursor.isNull(_cursorIndexOfValorFrete)) {
            _tmpValorFrete = null;
          } else {
            _tmpValorFrete = _cursor.getDouble(_cursorIndexOfValorFrete);
          }
          _tmpPrice.setValorFrete(_tmpValorFrete);
          final Double _tmpValorDespesas;
          if (_cursor.isNull(_cursorIndexOfValorDespesas)) {
            _tmpValorDespesas = null;
          } else {
            _tmpValorDespesas = _cursor.getDouble(_cursorIndexOfValorDespesas);
          }
          _tmpPrice.setValorDespesas(_tmpValorDespesas);
          final Double _tmpPercentualPis;
          if (_cursor.isNull(_cursorIndexOfPercentualPis)) {
            _tmpPercentualPis = null;
          } else {
            _tmpPercentualPis = _cursor.getDouble(_cursorIndexOfPercentualPis);
          }
          _tmpPrice.setPercentualPis(_tmpPercentualPis);
          final Double _tmpPercentualCofins;
          if (_cursor.isNull(_cursorIndexOfPercentualCofins)) {
            _tmpPercentualCofins = null;
          } else {
            _tmpPercentualCofins = _cursor.getDouble(_cursorIndexOfPercentualCofins);
          }
          _tmpPrice.setPercentualCofins(_tmpPercentualCofins);
          final String _tmpCstPis;
          _tmpCstPis = _cursor.getString(_cursorIndexOfCstPis);
          _tmpPrice.setCstPis(_tmpCstPis);
          final String _tmpCstCofins;
          _tmpCstCofins = _cursor.getString(_cursorIndexOfCstCofins);
          _tmpPrice.setCstCofins(_tmpCstCofins);
          final String _tmpSituacaoTributaria;
          _tmpSituacaoTributaria = _cursor.getString(_cursorIndexOfSituacaoTributaria);
          _tmpPrice.setSituacaoTributaria(_tmpSituacaoTributaria);
          final String _tmpCondicaoFaturamento;
          _tmpCondicaoFaturamento = _cursor.getString(_cursorIndexOfCondicaoFaturamento);
          _tmpPrice.setCondicaoFaturamento(_tmpCondicaoFaturamento);
        }  else  {
          _tmpPrice = null;
        }
        final Item _tmpItem;
        if (! (_cursor.isNull(_cursorIndexOfCdItem_1) && _cursor.isNull(_cursorIndexOfDescricaoProduto) && _cursor.isNull(_cursorIndexOfDescricaoCilindro) && _cursor.isNull(_cursorIndexOfCapacidadeProduto) && _cursor.isNull(_cursorIndexOfUnidadeMedida) && _cursor.isNull(_cursorIndexOfTax3) && _cursor.isNull(_cursorIndexOfIndProducao) && _cursor.isNull(_cursorIndexOfTipoPressao) && _cursor.isNull(_cursorIndexOfIndRequerFator) && _cursor.isNull(_cursorIndexOfFatorPcs) && _cursor.isNull(_cursorIndexOfPesoCilindro) && _cursor.isNull(_cursorIndexOfPesoLiqUnitario) && _cursor.isNull(_cursorIndexOfCapacidadeCilindro) && _cursor.isNull(_cursorIndexOfCstCilindro) && _cursor.isNull(_cursorIndexOfCstGas) && _cursor.isNull(_cursorIndexOfClasseNcmGas) && _cursor.isNull(_cursorIndexOfClasseNcmCilindro) && _cursor.isNull(_cursorIndexOfFatorConversao) && _cursor.isNull(_cursorIndexOfIndFatorConvPolegadas) && _cursor.isNull(_cursorIndexOfTipoItem) && _cursor.isNull(_cursorIndexOfTipoPropriedade) && _cursor.isNull(_cursorIndexOfIndRastreavel))) {
          _tmpItem = new Item();
          final Long _tmpCdItem_1;
          if (_cursor.isNull(_cursorIndexOfCdItem_1)) {
            _tmpCdItem_1 = null;
          } else {
            _tmpCdItem_1 = _cursor.getLong(_cursorIndexOfCdItem_1);
          }
          _tmpItem.setCdItem(_tmpCdItem_1);
          final String _tmpDescricaoProduto;
          _tmpDescricaoProduto = _cursor.getString(_cursorIndexOfDescricaoProduto);
          _tmpItem.setDescricaoProduto(_tmpDescricaoProduto);
          final String _tmpDescricaoCilindro;
          _tmpDescricaoCilindro = _cursor.getString(_cursorIndexOfDescricaoCilindro);
          _tmpItem.setDescricaoCilindro(_tmpDescricaoCilindro);
          final Double _tmpCapacidadeProduto;
          if (_cursor.isNull(_cursorIndexOfCapacidadeProduto)) {
            _tmpCapacidadeProduto = null;
          } else {
            _tmpCapacidadeProduto = _cursor.getDouble(_cursorIndexOfCapacidadeProduto);
          }
          _tmpItem.setCapacidadeProduto(_tmpCapacidadeProduto);
          final String _tmpUnidadeMedida;
          _tmpUnidadeMedida = _cursor.getString(_cursorIndexOfUnidadeMedida);
          _tmpItem.setUnidadeMedida(_tmpUnidadeMedida);
          final String _tmpTax3;
          _tmpTax3 = _cursor.getString(_cursorIndexOfTax3);
          _tmpItem.setTax3(_tmpTax3);
          final String _tmpIndProducao;
          _tmpIndProducao = _cursor.getString(_cursorIndexOfIndProducao);
          _tmpItem.setIndProducao(_tmpIndProducao);
          final Integer _tmpTipoPressao;
          if (_cursor.isNull(_cursorIndexOfTipoPressao)) {
            _tmpTipoPressao = null;
          } else {
            _tmpTipoPressao = _cursor.getInt(_cursorIndexOfTipoPressao);
          }
          _tmpItem.setTipoPressao(_tmpTipoPressao);
          final Integer _tmpIndRequerFator;
          if (_cursor.isNull(_cursorIndexOfIndRequerFator)) {
            _tmpIndRequerFator = null;
          } else {
            _tmpIndRequerFator = _cursor.getInt(_cursorIndexOfIndRequerFator);
          }
          _tmpItem.setIndRequerFator(_tmpIndRequerFator);
          final Double _tmpFatorPcs;
          if (_cursor.isNull(_cursorIndexOfFatorPcs)) {
            _tmpFatorPcs = null;
          } else {
            _tmpFatorPcs = _cursor.getDouble(_cursorIndexOfFatorPcs);
          }
          _tmpItem.setFatorPcs(_tmpFatorPcs);
          final Double _tmpPesoCilindro;
          if (_cursor.isNull(_cursorIndexOfPesoCilindro)) {
            _tmpPesoCilindro = null;
          } else {
            _tmpPesoCilindro = _cursor.getDouble(_cursorIndexOfPesoCilindro);
          }
          _tmpItem.setPesoCilindro(_tmpPesoCilindro);
          final Double _tmpPesoLiqUnitario;
          if (_cursor.isNull(_cursorIndexOfPesoLiqUnitario)) {
            _tmpPesoLiqUnitario = null;
          } else {
            _tmpPesoLiqUnitario = _cursor.getDouble(_cursorIndexOfPesoLiqUnitario);
          }
          _tmpItem.setPesoLiqUnitario(_tmpPesoLiqUnitario);
          final Double _tmpCapacidadeCilindro;
          if (_cursor.isNull(_cursorIndexOfCapacidadeCilindro)) {
            _tmpCapacidadeCilindro = null;
          } else {
            _tmpCapacidadeCilindro = _cursor.getDouble(_cursorIndexOfCapacidadeCilindro);
          }
          _tmpItem.setCapacidadeCilindro(_tmpCapacidadeCilindro);
          final String _tmpCstCilindro;
          _tmpCstCilindro = _cursor.getString(_cursorIndexOfCstCilindro);
          _tmpItem.setCstCilindro(_tmpCstCilindro);
          final String _tmpCstGas;
          _tmpCstGas = _cursor.getString(_cursorIndexOfCstGas);
          _tmpItem.setCstGas(_tmpCstGas);
          final Long _tmpClasseNcmGas;
          if (_cursor.isNull(_cursorIndexOfClasseNcmGas)) {
            _tmpClasseNcmGas = null;
          } else {
            _tmpClasseNcmGas = _cursor.getLong(_cursorIndexOfClasseNcmGas);
          }
          _tmpItem.setClasseNcmGas(_tmpClasseNcmGas);
          final Long _tmpClasseNcmCilindro;
          if (_cursor.isNull(_cursorIndexOfClasseNcmCilindro)) {
            _tmpClasseNcmCilindro = null;
          } else {
            _tmpClasseNcmCilindro = _cursor.getLong(_cursorIndexOfClasseNcmCilindro);
          }
          _tmpItem.setClasseNcmCilindro(_tmpClasseNcmCilindro);
          final Double _tmpFatorConversao;
          if (_cursor.isNull(_cursorIndexOfFatorConversao)) {
            _tmpFatorConversao = null;
          } else {
            _tmpFatorConversao = _cursor.getDouble(_cursorIndexOfFatorConversao);
          }
          _tmpItem.setFatorConversao(_tmpFatorConversao);
          final String _tmpIndFatorConvPolegadas;
          _tmpIndFatorConvPolegadas = _cursor.getString(_cursorIndexOfIndFatorConvPolegadas);
          _tmpItem.setIndFatorConvPolegadas(_tmpIndFatorConvPolegadas);
          final Integer _tmpTipoItem;
          if (_cursor.isNull(_cursorIndexOfTipoItem)) {
            _tmpTipoItem = null;
          } else {
            _tmpTipoItem = _cursor.getInt(_cursorIndexOfTipoItem);
          }
          _tmpItem.setTipoItem(_tmpTipoItem);
          final String _tmpTipoPropriedade;
          _tmpTipoPropriedade = _cursor.getString(_cursorIndexOfTipoPropriedade);
          _tmpItem.setTipoPropriedade(_tmpTipoPropriedade);
          final String _tmpIndRastreavel;
          _tmpIndRastreavel = _cursor.getString(_cursorIndexOfIndRastreavel);
          _tmpItem.setIndRastreavel(_tmpIndRastreavel);
        }  else  {
          _tmpItem = null;
        }
        _item_1 = new ItemPrice();
        _item_1.setPrice(_tmpPrice);
        _item_1.setItem(_tmpItem);
        _result.add(_item_1);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<ItemPrice> findPricesCpl(Long cdItem) {
    final String _sql = "SELECT Item.cdItem as it_cdItem, Item.cdCilindro as it_cdCilindro, Item.descricaoCilindro as it_descricaoCilindro, Item.tipoPressao as it_tipoPressao, Item.descricaoProduto as it_descricaoProduto, Item.valorIndenizacao as it_valorIndenizacao, Item.capacidadeProduto as it_capacidadeProduto, Item.unidadeMedida as it_unidadeMedida,Item.tax3 as it_tax3, Item.indProducao as it_indProducao, Item.indRequerFator as it_indRequerFator, Item.pesoCilindro as it_pesoCilindro, Item.pesoLiqUnitario as it_pesoLiqUnitario, Item.capacidadeCilindro as it_capacidadeCilindro,Item.cstCilindro as it_cstCilindro, Item.cstGas as it_cstGas, Item.classeNcmGas as it_classeNcmGas, Item.classeNcmCilindro as it_classeNcmCilindro, Item.tipoItem as it_tipoItem, Item.tipoPropriedade as it_tipoPropriedade, Item.fatorConversao as it_fatorConversao, Item.indFatorConvPolegadas as it_indFatorConvPolegadas, Item.indRastreavel as it_indRastreavel FROM Item WHERE cdCilindro > 0 AND Item.cdItem = ifnull(?, Item.cdItem)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (cdItem == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cdItem);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCdItem = _cursor.getColumnIndexOrThrow("it_cdItem");
      final int _cursorIndexOfCdCilindro = _cursor.getColumnIndexOrThrow("it_cdCilindro");
      final int _cursorIndexOfDescricaoCilindro = _cursor.getColumnIndexOrThrow("it_descricaoCilindro");
      final int _cursorIndexOfTipoPressao = _cursor.getColumnIndexOrThrow("it_tipoPressao");
      final int _cursorIndexOfDescricaoProduto = _cursor.getColumnIndexOrThrow("it_descricaoProduto");
      final int _cursorIndexOfValorIndenizacao = _cursor.getColumnIndexOrThrow("it_valorIndenizacao");
      final int _cursorIndexOfCapacidadeProduto = _cursor.getColumnIndexOrThrow("it_capacidadeProduto");
      final int _cursorIndexOfUnidadeMedida = _cursor.getColumnIndexOrThrow("it_unidadeMedida");
      final int _cursorIndexOfTax3 = _cursor.getColumnIndexOrThrow("it_tax3");
      final int _cursorIndexOfIndProducao = _cursor.getColumnIndexOrThrow("it_indProducao");
      final int _cursorIndexOfIndRequerFator = _cursor.getColumnIndexOrThrow("it_indRequerFator");
      final int _cursorIndexOfPesoCilindro = _cursor.getColumnIndexOrThrow("it_pesoCilindro");
      final int _cursorIndexOfPesoLiqUnitario = _cursor.getColumnIndexOrThrow("it_pesoLiqUnitario");
      final int _cursorIndexOfCapacidadeCilindro = _cursor.getColumnIndexOrThrow("it_capacidadeCilindro");
      final int _cursorIndexOfCstCilindro = _cursor.getColumnIndexOrThrow("it_cstCilindro");
      final int _cursorIndexOfCstGas = _cursor.getColumnIndexOrThrow("it_cstGas");
      final int _cursorIndexOfClasseNcmGas = _cursor.getColumnIndexOrThrow("it_classeNcmGas");
      final int _cursorIndexOfClasseNcmCilindro = _cursor.getColumnIndexOrThrow("it_classeNcmCilindro");
      final int _cursorIndexOfTipoItem = _cursor.getColumnIndexOrThrow("it_tipoItem");
      final int _cursorIndexOfTipoPropriedade = _cursor.getColumnIndexOrThrow("it_tipoPropriedade");
      final int _cursorIndexOfFatorConversao = _cursor.getColumnIndexOrThrow("it_fatorConversao");
      final int _cursorIndexOfIndFatorConvPolegadas = _cursor.getColumnIndexOrThrow("it_indFatorConvPolegadas");
      final int _cursorIndexOfIndRastreavel = _cursor.getColumnIndexOrThrow("it_indRastreavel");
      final List<ItemPrice> _result = new ArrayList<ItemPrice>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ItemPrice _item;
        final Item _tmpItem;
        if (! (_cursor.isNull(_cursorIndexOfCdItem) && _cursor.isNull(_cursorIndexOfCdCilindro) && _cursor.isNull(_cursorIndexOfDescricaoCilindro) && _cursor.isNull(_cursorIndexOfTipoPressao) && _cursor.isNull(_cursorIndexOfDescricaoProduto) && _cursor.isNull(_cursorIndexOfValorIndenizacao) && _cursor.isNull(_cursorIndexOfCapacidadeProduto) && _cursor.isNull(_cursorIndexOfUnidadeMedida) && _cursor.isNull(_cursorIndexOfTax3) && _cursor.isNull(_cursorIndexOfIndProducao) && _cursor.isNull(_cursorIndexOfIndRequerFator) && _cursor.isNull(_cursorIndexOfPesoCilindro) && _cursor.isNull(_cursorIndexOfPesoLiqUnitario) && _cursor.isNull(_cursorIndexOfCapacidadeCilindro) && _cursor.isNull(_cursorIndexOfCstCilindro) && _cursor.isNull(_cursorIndexOfCstGas) && _cursor.isNull(_cursorIndexOfClasseNcmGas) && _cursor.isNull(_cursorIndexOfClasseNcmCilindro) && _cursor.isNull(_cursorIndexOfTipoItem) && _cursor.isNull(_cursorIndexOfTipoPropriedade) && _cursor.isNull(_cursorIndexOfFatorConversao) && _cursor.isNull(_cursorIndexOfIndFatorConvPolegadas) && _cursor.isNull(_cursorIndexOfIndRastreavel))) {
          _tmpItem = new Item();
          final Long _tmpCdItem;
          if (_cursor.isNull(_cursorIndexOfCdItem)) {
            _tmpCdItem = null;
          } else {
            _tmpCdItem = _cursor.getLong(_cursorIndexOfCdItem);
          }
          _tmpItem.setCdItem(_tmpCdItem);
          final Long _tmpCdCilindro;
          if (_cursor.isNull(_cursorIndexOfCdCilindro)) {
            _tmpCdCilindro = null;
          } else {
            _tmpCdCilindro = _cursor.getLong(_cursorIndexOfCdCilindro);
          }
          _tmpItem.setCdCilindro(_tmpCdCilindro);
          final String _tmpDescricaoCilindro;
          _tmpDescricaoCilindro = _cursor.getString(_cursorIndexOfDescricaoCilindro);
          _tmpItem.setDescricaoCilindro(_tmpDescricaoCilindro);
          final Integer _tmpTipoPressao;
          if (_cursor.isNull(_cursorIndexOfTipoPressao)) {
            _tmpTipoPressao = null;
          } else {
            _tmpTipoPressao = _cursor.getInt(_cursorIndexOfTipoPressao);
          }
          _tmpItem.setTipoPressao(_tmpTipoPressao);
          final String _tmpDescricaoProduto;
          _tmpDescricaoProduto = _cursor.getString(_cursorIndexOfDescricaoProduto);
          _tmpItem.setDescricaoProduto(_tmpDescricaoProduto);
          final Double _tmpValorIndenizacao;
          if (_cursor.isNull(_cursorIndexOfValorIndenizacao)) {
            _tmpValorIndenizacao = null;
          } else {
            _tmpValorIndenizacao = _cursor.getDouble(_cursorIndexOfValorIndenizacao);
          }
          _tmpItem.setValorIndenizacao(_tmpValorIndenizacao);
          final Double _tmpCapacidadeProduto;
          if (_cursor.isNull(_cursorIndexOfCapacidadeProduto)) {
            _tmpCapacidadeProduto = null;
          } else {
            _tmpCapacidadeProduto = _cursor.getDouble(_cursorIndexOfCapacidadeProduto);
          }
          _tmpItem.setCapacidadeProduto(_tmpCapacidadeProduto);
          final String _tmpUnidadeMedida;
          _tmpUnidadeMedida = _cursor.getString(_cursorIndexOfUnidadeMedida);
          _tmpItem.setUnidadeMedida(_tmpUnidadeMedida);
          final String _tmpTax3;
          _tmpTax3 = _cursor.getString(_cursorIndexOfTax3);
          _tmpItem.setTax3(_tmpTax3);
          final String _tmpIndProducao;
          _tmpIndProducao = _cursor.getString(_cursorIndexOfIndProducao);
          _tmpItem.setIndProducao(_tmpIndProducao);
          final Integer _tmpIndRequerFator;
          if (_cursor.isNull(_cursorIndexOfIndRequerFator)) {
            _tmpIndRequerFator = null;
          } else {
            _tmpIndRequerFator = _cursor.getInt(_cursorIndexOfIndRequerFator);
          }
          _tmpItem.setIndRequerFator(_tmpIndRequerFator);
          final Double _tmpPesoCilindro;
          if (_cursor.isNull(_cursorIndexOfPesoCilindro)) {
            _tmpPesoCilindro = null;
          } else {
            _tmpPesoCilindro = _cursor.getDouble(_cursorIndexOfPesoCilindro);
          }
          _tmpItem.setPesoCilindro(_tmpPesoCilindro);
          final Double _tmpPesoLiqUnitario;
          if (_cursor.isNull(_cursorIndexOfPesoLiqUnitario)) {
            _tmpPesoLiqUnitario = null;
          } else {
            _tmpPesoLiqUnitario = _cursor.getDouble(_cursorIndexOfPesoLiqUnitario);
          }
          _tmpItem.setPesoLiqUnitario(_tmpPesoLiqUnitario);
          final Double _tmpCapacidadeCilindro;
          if (_cursor.isNull(_cursorIndexOfCapacidadeCilindro)) {
            _tmpCapacidadeCilindro = null;
          } else {
            _tmpCapacidadeCilindro = _cursor.getDouble(_cursorIndexOfCapacidadeCilindro);
          }
          _tmpItem.setCapacidadeCilindro(_tmpCapacidadeCilindro);
          final String _tmpCstCilindro;
          _tmpCstCilindro = _cursor.getString(_cursorIndexOfCstCilindro);
          _tmpItem.setCstCilindro(_tmpCstCilindro);
          final String _tmpCstGas;
          _tmpCstGas = _cursor.getString(_cursorIndexOfCstGas);
          _tmpItem.setCstGas(_tmpCstGas);
          final Long _tmpClasseNcmGas;
          if (_cursor.isNull(_cursorIndexOfClasseNcmGas)) {
            _tmpClasseNcmGas = null;
          } else {
            _tmpClasseNcmGas = _cursor.getLong(_cursorIndexOfClasseNcmGas);
          }
          _tmpItem.setClasseNcmGas(_tmpClasseNcmGas);
          final Long _tmpClasseNcmCilindro;
          if (_cursor.isNull(_cursorIndexOfClasseNcmCilindro)) {
            _tmpClasseNcmCilindro = null;
          } else {
            _tmpClasseNcmCilindro = _cursor.getLong(_cursorIndexOfClasseNcmCilindro);
          }
          _tmpItem.setClasseNcmCilindro(_tmpClasseNcmCilindro);
          final Integer _tmpTipoItem;
          if (_cursor.isNull(_cursorIndexOfTipoItem)) {
            _tmpTipoItem = null;
          } else {
            _tmpTipoItem = _cursor.getInt(_cursorIndexOfTipoItem);
          }
          _tmpItem.setTipoItem(_tmpTipoItem);
          final String _tmpTipoPropriedade;
          _tmpTipoPropriedade = _cursor.getString(_cursorIndexOfTipoPropriedade);
          _tmpItem.setTipoPropriedade(_tmpTipoPropriedade);
          final Double _tmpFatorConversao;
          if (_cursor.isNull(_cursorIndexOfFatorConversao)) {
            _tmpFatorConversao = null;
          } else {
            _tmpFatorConversao = _cursor.getDouble(_cursorIndexOfFatorConversao);
          }
          _tmpItem.setFatorConversao(_tmpFatorConversao);
          final String _tmpIndFatorConvPolegadas;
          _tmpIndFatorConvPolegadas = _cursor.getString(_cursorIndexOfIndFatorConvPolegadas);
          _tmpItem.setIndFatorConvPolegadas(_tmpIndFatorConvPolegadas);
          final String _tmpIndRastreavel;
          _tmpIndRastreavel = _cursor.getString(_cursorIndexOfIndRastreavel);
          _tmpItem.setIndRastreavel(_tmpIndRastreavel);
        }  else  {
          _tmpItem = null;
        }
        _item = new ItemPrice();
        _item.setItem(_tmpItem);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
