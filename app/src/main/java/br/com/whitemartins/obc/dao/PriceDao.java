package br.com.whitemartins.obc.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.RoomWarnings;

import java.util.List;

import br.com.whitemartins.obc.model.ItemPrice;
import br.com.whitemartins.obc.model.Price;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
@Dao
public interface PriceDao {

  @Query("SELECT * FROM Price")
  List<Price> getAll();

  @Insert(onConflict = REPLACE)
  void insertAll(List<Price> prices);

  @Insert(onConflict = REPLACE)
  void insert(Price price);

  @Delete
  void delete(Price price);

  @Delete
  void deleteAll(List<Price> prices);

  @Query("SELECT  Price.*, Item.cdItem as it_cdItem, Item.descricaoProduto as it_descricaoProduto, " +
      " Item.descricaoCilindro as it_descricaoCilindro, " +
      " Item.capacidadeProduto as it_capacidadeProduto, Item.unidadeMedida as it_unidadeMedida," +
      " Item.tax3 as it_tax3, Item.indProducao as it_indProducao, Item.tipoPressao as it_tipoPressao," +
      " Item.indRequerFator as it_indRequerFator, Item.fatorPcs as it_fatorPcs, " +
      " Item.pesoCilindro as it_pesoCilindro, Item.pesoLiqUnitario as it_pesoLiqUnitario, " +
      " Item.capacidadeCilindro as it_capacidadeCilindro, " +
      " Item.cstCilindro as it_cstCilindro, Item.cstGas as it_cstGas, " +
      " Item.classeNcmGas as it_classeNcmGas, Item.classeNcmCilindro as it_classeNcmCilindro, " +
      " Item.tipoItem as it_tipoItem, Item.tipoPropriedade as it_tipoPropriedade, " +
      " Item.fatorConversao as it_fatorConversao, " +
      " Item.indFatorConvPolegadas as it_indFatorConvPolegadas, Item.indRastreavel as it_indRastreavel " +
      " FROM Price " +
      " INNER JOIN Item ON Price.cdItem = Item.cdItem " +
      " WHERE Price.cdCustomer = :cdCustomer " +
      "   AND Price.condicaoFaturamento <> 991" +
      "   AND Price.cdItem = ifnull(:cdItem, Price.cdItem)" +
      "   AND Item.tipoItem in (:tipoItem)" +
      "   AND Item.qtdCilindroCheios > 0 ")
  List<ItemPrice> findPricesVnd(Long cdCustomer, Long cdItem, List<Integer> tipoItem);

  @Query("SELECT  Price.*, Item.cdItem as it_cdItem, Item.descricaoProduto as it_descricaoProduto," +
      " Item.capacidadeProduto as it_capacidadeProduto, Item.unidadeMedida as it_unidadeMedida," +
      " Item.descricaoCilindro as it_descricaoCilindro, " +
      " Item.tax3 as it_tax3, Item.indProducao as it_indProducao, Item.tipoPressao as it_tipoPressao," +
      " Item.indRequerFator as it_indRequerFator, Item.fatorPcs as it_fatorPcs, " +
      " Item.pesoCilindro as it_pesoCilindro, Item.pesoLiqUnitario as it_pesoLiqUnitario, " +
      " Item.capacidadeCilindro as it_capacidadeCilindro, " +
      " Item.cstCilindro as it_cstCilindro, Item.cstGas as it_cstGas, " +
      " Item.classeNcmGas as it_classeNcmGas, Item.classeNcmCilindro as it_classeNcmCilindro, " +
      " Item.tipoItem as it_tipoItem, Item.tipoPropriedade as it_tipoPropriedade, " +
      " Item.fatorConversao as it_fatorConversao, " +
      " Item.indFatorConvPolegadas as it_indFatorConvPolegadas, Item.indRastreavel as it_indRastreavel " +
      " FROM Price " +
      " INNER JOIN Item ON Price.cdItem = Item.cdItem " +
      " WHERE Price.cdCustomer = :cdCustomer " +
      "   AND Price.condicaoFaturamento <> 991" +
      "   AND Price.cdItem = ifnull(:cdItem, Price.cdItem)" +
      "   AND Item.tipoItem in (:tipoItem)")
  List<ItemPrice> findPricesVor(Long cdCustomer, Long cdItem, List<Integer> tipoItem);

  @Query("SELECT Item.cdItem as it_cdItem, Item.cdCilindro as it_cdCilindro, " +
      "Item.descricaoCilindro as it_descricaoCilindro, " +
      "Item.tipoPressao as it_tipoPressao, " +
      "Item.descricaoProduto as it_descricaoProduto, Item.valorIndenizacao as it_valorIndenizacao, " +
      "Item.capacidadeProduto as it_capacidadeProduto, Item.unidadeMedida as it_unidadeMedida," +
      "Item.tax3 as it_tax3, Item.indProducao as it_indProducao, " +
      "Item.indRequerFator as it_indRequerFator, Item.pesoCilindro as it_pesoCilindro, " +
      "Item.pesoLiqUnitario as it_pesoLiqUnitario, Item.capacidadeCilindro as it_capacidadeCilindro," +
      "Item.cstCilindro as it_cstCilindro, Item.cstGas as it_cstGas, " +
      "Item.classeNcmGas as it_classeNcmGas, Item.classeNcmCilindro as it_classeNcmCilindro, " +
      "Item.tipoItem as it_tipoItem, Item.tipoPropriedade as it_tipoPropriedade, " +
      "Item.fatorConversao as it_fatorConversao, " +
      "Item.indFatorConvPolegadas as it_indFatorConvPolegadas," +
      "Route.valorIndenizacaoAlta as rt_valorIndenizacaoAlta, " +
      "Route.valorIndenizacaoBaixa as rt_valorIndenizacaoBaixa, Item.indRastreavel as it_indRastreavel " +
      "FROM Item " +
      "INNER JOIN Route " +
      "WHERE cdCilindro > 0 " +
      " AND Item.tipoItem in (:tipoItem) " +
      " AND Item.cdItem = ifnull(:cdItem, Item.cdItem)")
  List<ItemPrice> findPricesRcl(Long cdItem, List<Integer> tipoItem);

  @Query("SELECT Item.cdItem as it_cdItem, Item.cdCilindro as it_cdCilindro, " +
      "Item.tipoPressao as it_tipoPressao, " +
      "Item.descricaoProduto as it_descricaoProduto, Item.valorIndenizacao as it_valorIndenizacao, " +
      "Item.descricaoCilindro as it_descricaoCilindro, " +
      "Item.capacidadeProduto as it_capacidadeProduto, Item.unidadeMedida as it_unidadeMedida," +
      "Item.tax3 as it_tax3, Item.indProducao as it_indProducao, " +
      "Item.indRequerFator as it_indRequerFator, Item.pesoCilindro as it_pesoCilindro, " +
      "Item.pesoLiqUnitario as it_pesoLiqUnitario, Item.capacidadeCilindro as it_capacidadeCilindro," +
      "Item.cstCilindro as it_cstCilindro, Item.cstGas as it_cstGas, " +
      "Item.classeNcmGas as it_classeNcmGas, Item.classeNcmCilindro as it_classeNcmCilindro, " +
      "Item.tipoItem as it_tipoItem, Item.tipoPropriedade as it_tipoPropriedade, " +
      "Item.fatorConversao as it_fatorConversao, " +
      "Item.indFatorConvPolegadas as it_indFatorConvPolegadas," +
      "Route.valorIndenizacaoAlta as rt_valorIndenizacaoAlta, " +
      "Route.valorIndenizacaoBaixa as rt_valorIndenizacaoBaixa, " +
      "Item.qtdCilindroCheios as it_qtdCilindroCheios, Item.indRastreavel as it_indRastreavel " +
      "FROM Item " +
      "INNER JOIN Route " +
      "INNER JOIN Price on Price.cdItem = Item.cdItem " +
      "WHERE cdCilindro > 0 " +
      "  AND Item.tipoItem IN (:tipoItem) " +
      "  AND Price.cdCustomer = :cdCustomer " +
      "  AND Item.qtdCilindroCheios > 0 " +
      "  AND Item.cdItem = ifnull(:cdItem, Item.cdItem)")
  List<ItemPrice> findPricesApl(Long cdCustomer, Long cdItem, List<Integer> tipoItem);

  @Query("SELECT Item.cdItem as it_cdItem, Item.cdCilindro as it_cdCilindro, " +
      "Item.tipoPressao as it_tipoPressao, " +
      "Item.descricaoCilindro as it_descricaoCilindro, " +
      "Item.descricaoProduto as it_descricaoProduto, Item.valorIndenizacao as it_valorIndenizacao, " +
      "Item.capacidadeProduto as it_capacidadeProduto, Item.unidadeMedida as it_unidadeMedida," +
      "Item.tax3 as it_tax3, Item.indProducao as it_indProducao, " +
      "Item.indRequerFator as it_indRequerFator, Item.pesoCilindro as it_pesoCilindro, " +
      "Item.pesoLiqUnitario as it_pesoLiqUnitario, Item.capacidadeCilindro as it_capacidadeCilindro," +
      "Item.cstCilindro as it_cstCilindro, Item.cstGas as it_cstGas, " +
      "Item.classeNcmGas as it_classeNcmGas, Item.classeNcmCilindro as it_classeNcmCilindro, " +
      "Item.tipoItem as it_tipoItem, Item.tipoPropriedade as it_tipoPropriedade, " +
      "Item.fatorConversao as it_fatorConversao, " +
      "Item.indFatorConvPolegadas as it_indFatorConvPolegadas," +
      "Route.valorIndenizacaoAlta as rt_valorIndenizacaoAlta, " +
      "Route.valorIndenizacaoBaixa as rt_valorIndenizacaoBaixa, " +
      "Item.qtdCilindroCheios as it_qtdCilindroCheios, Item.indRastreavel as it_indRastreavel " +
      "FROM Item " +
      "INNER JOIN Route " +
      "WHERE Item.tipoItem IN (:tipoItem) " +
      "  AND Item.qtdCilindroCheios > 0 " +
      "  AND Item.cdItem = ifnull(:cdItem, Item.cdItem)")
  List<ItemPrice> findPricesAplHC(Long cdItem, List<Integer> tipoItem);

  @Query("SELECT Price.*, Item.cdItem as it_cdItem, Item.descricaoProduto as it_descricaoProduto, " +
      "Item.capacidadeProduto as it_capacidadeProduto, Item.unidadeMedida as it_unidadeMedida, " +
      "Item.descricaoCilindro as it_descricaoCilindro, " +
      "Item.tax3 as it_tax3, Item.indProducao as it_indProducao, Item.tipoPressao as it_tipoPressao, " +
      "Item.indRequerFator as it_indRequerFator, Item.fatorPcs as it_fatorPcs,  " +
      "Item.pesoCilindro as it_pesoCilindro, Item.pesoLiqUnitario as it_pesoLiqUnitario,  " +
      "Item.capacidadeCilindro as it_capacidadeCilindro,  " +
      "Item.cstCilindro as it_cstCilindro, Item.cstGas as it_cstGas,  " +
      "Item.classeNcmGas as it_classeNcmGas, Item.classeNcmCilindro as it_classeNcmCilindro,  " +
      "Item.fatorConversao as it_fatorConversao, " +
      "Item.indFatorConvPolegadas as it_indFatorConvPolegadas," +
      "Item.tipoItem as it_tipoItem, Item.tipoPropriedade as it_tipoPropriedade, Item.indRastreavel as it_indRastreavel " +
      "  FROM PreOrder  " +
      "  INNER JOIN Item on Item.cdItem = PreOrder.cdItem " +
      "  INNER JOIN Price on Price.cdItem = PreOrder.cdItem AND Price.cdCustomer = PreOrder.cdCustomer" +
      "  INNER JOIN Saldo on Saldo.cdItem = Item.cdItem and Saldo.capacidade = Item.capacidadeProduto " +
      "  WHERE Price.condicaoFaturamento <> 991 " +
      "    AND Price.cdCustomer = :cdCustomer" +
      "    AND PreOrder.numeroNotaOrigem = ifnull(:numeroNotaOrigem, numeroNotaOrigem)" +
      "    AND PreOrder.saldo/PreOrder.capacidadeProduto >= 1 " +
      "    AND Item.tipoItem IN (:tipoItem) " +
      "    AND Item.cdItem = ifnull(:cdItem, Item.cdItem)")
  List<ItemPrice> findPricesFut(Long cdCustomer, Long cdItem, String numeroNotaOrigem,
                                List<Integer> tipoItem);

  @Query("SELECT  Price.*, Item.cdItem as it_cdItem, Item.descricaoProduto as it_descricaoProduto," +
      " Item.capacidadeProduto as it_capacidadeProduto, Item.unidadeMedida as it_unidadeMedida," +
      " Item.descricaoCilindro as it_descricaoCilindro, " +
      " Item.tax3 as it_tax3, Item.indProducao as it_indProducao, Item.tipoPressao as it_tipoPressao," +
      " Item.indRequerFator as it_indRequerFator, Item.fatorPcs as it_fatorPcs, " +
      " Item.pesoCilindro as it_pesoCilindro, Item.pesoLiqUnitario as it_pesoLiqUnitario, " +
      " Item.capacidadeCilindro as it_capacidadeCilindro, " +
      " Item.cstCilindro as it_cstCilindro, Item.cstGas as it_cstGas, " +
      " Item.classeNcmGas as it_classeNcmGas, Item.classeNcmCilindro as it_classeNcmCilindro, " +
      " Item.fatorConversao as it_fatorConversao, " +
      " Item.indFatorConvPolegadas as it_indFatorConvPolegadas," +
      " Item.tipoItem as it_tipoItem, Item.tipoPropriedade as it_tipoPropriedade, Item.indRastreavel as it_indRastreavel " +
      " FROM Price " +
      " INNER JOIN Item ON Price.cdItem = Item.cdItem " +
      " WHERE Price.cdCustomer = :cdCustomer " +
      "   AND Price.condicaoFaturamento <> 991" +
      "   AND Price.cdItem = ifnull(:cdItem, Price.cdItem)" +
      "   AND Item.tipoItem in (:tipoItem)" +
      "   AND Item.qtdCilindroCheios > 0 ")
  List<ItemPrice> findPricesTrc(Long cdCustomer, Long cdItem, List<Integer> tipoItem);

  @Query("SELECT  Price.*, Item.cdItem as it_cdItem, Item.descricaoProduto as it_descricaoProduto," +
      " Item.descricaoCilindro as it_descricaoCilindro, " +
      " Item.capacidadeProduto as it_capacidadeProduto, Item.unidadeMedida as it_unidadeMedida," +
      " Item.tax3 as it_tax3, Item.indProducao as it_indProducao, Item.tipoPressao as it_tipoPressao," +
      " Item.indRequerFator as it_indRequerFator, Item.fatorPcs as it_fatorPcs, " +
      " Item.pesoCilindro as it_pesoCilindro, Item.pesoLiqUnitario as it_pesoLiqUnitario, " +
      " Item.capacidadeCilindro as it_capacidadeCilindro, " +
      " Item.cstCilindro as it_cstCilindro, Item.cstGas as it_cstGas, " +
      " Item.classeNcmGas as it_classeNcmGas, Item.classeNcmCilindro as it_classeNcmCilindro, " +
      " Item.fatorConversao as it_fatorConversao, " +
      " Item.indFatorConvPolegadas as it_indFatorConvPolegadas, " +
      " Item.tipoItem as it_tipoItem, Item.tipoPropriedade as it_tipoPropriedade, Item.indRastreavel as it_indRastreavel " +
      " FROM Price " +
      " INNER JOIN Item ON Price.cdItem = Item.cdItem " +
      " WHERE Price.cdCustomer = :cdCustomer " +
      "   AND Price.flNovoFaturamento = :flNovoFaturamento" +
      "   AND Price.condicaoFaturamento <> 991" +
      "   AND Price.cdItem = ifnull(:cdItem, Price.cdItem)" +
      "   AND Item.tipoItem in (:tipoItem)")
  List<ItemPrice> findPricesRps(Long cdCustomer, Long cdItem, List<Integer> tipoItem,
                                String flNovoFaturamento);

  @Query("SELECT Item.cdItem as it_cdItem, Item.cdCilindro as it_cdCilindro, " +
      "Item.tipoPressao as it_tipoPressao, " +
      "Item.descricaoCilindro as it_descricaoCilindro, " +
      "Item.descricaoProduto as it_descricaoProduto, Item.valorIndenizacao as it_valorIndenizacao, " +
      "Item.capacidadeProduto as it_capacidadeProduto, Item.unidadeMedida as it_unidadeMedida," +
      "Item.tax3 as it_tax3, Item.indProducao as it_indProducao, " +
      "Item.indRequerFator as it_indRequerFator, Item.pesoCilindro as it_pesoCilindro, " +
      "Item.pesoLiqUnitario as it_pesoLiqUnitario, Item.capacidadeCilindro as it_capacidadeCilindro," +
      "Item.cstCilindro as it_cstCilindro, Item.cstGas as it_cstGas, " +
      "Item.classeNcmGas as it_classeNcmGas, Item.classeNcmCilindro as it_classeNcmCilindro, " +
      "Item.tipoItem as it_tipoItem, Item.tipoPropriedade as it_tipoPropriedade, " +
      "Item.fatorConversao as it_fatorConversao, " +
      "Item.indFatorConvPolegadas as it_indFatorConvPolegadas, Item.indRastreavel as it_indRastreavel  " +
      "FROM Item " +
      "WHERE Item.cdItem = ifnull(:cdItem, Item.cdItem)")
  List<ItemPrice> findPricesTrb(Long cdItem);

  @Query("SELECT  Price.*, Item.cdItem as it_cdItem, Item.descricaoProduto as it_descricaoProduto," +
      " Item.descricaoCilindro as it_descricaoCilindro, " +
      " Item.capacidadeProduto as it_capacidadeProduto, Item.unidadeMedida as it_unidadeMedida," +
      " Item.tax3 as it_tax3, Item.indProducao as it_indProducao, Item.tipoPressao as it_tipoPressao," +
      " Item.indRequerFator as it_indRequerFator, Item.fatorPcs as it_fatorPcs, " +
      " Item.pesoCilindro as it_pesoCilindro, Item.pesoLiqUnitario as it_pesoLiqUnitario, " +
      " Item.capacidadeCilindro as it_capacidadeCilindro, " +
      " Item.cstCilindro as it_cstCilindro, Item.cstGas as it_cstGas, " +
      " Item.classeNcmGas as it_classeNcmGas, Item.classeNcmCilindro as it_classeNcmCilindro, " +
      " Item.tipoItem as it_tipoItem, Item.tipoPropriedade as it_tipoPropriedade, " +
      " Item.fatorConversao as it_fatorConversao, " +
      " Item.indFatorConvPolegadas as it_indFatorConvPolegadas, Item.indRastreavel as it_indRastreavel " +
      " FROM Price " +
      " INNER JOIN Item ON Price.cdItem = Item.cdItem " +
      " WHERE Price.cdCustomer = :cdCustomer " +
      "   AND Price.condicaoFaturamento <> 991")
    //"   AND Price.cdItem = ifnull(:cdItem, Price.cdItem)" +
    //"   AND Item.tipoItem in (:tipoItem)")
  List<ItemPrice> findPricesTrf(Long cdCustomer);

  @Query("SELECT  Price.*, Item.cdItem as it_cdItem, Item.descricaoProduto as it_descricaoProduto," +
      " Item.descricaoCilindro as it_descricaoCilindro, " +
      " Item.capacidadeProduto as it_capacidadeProduto, Item.unidadeMedida as it_unidadeMedida," +
      " Item.tax3 as it_tax3, Item.indProducao as it_indProducao, Item.tipoPressao as it_tipoPressao," +
      " Item.indRequerFator as it_indRequerFator, Item.fatorPcs as it_fatorPcs, " +
      " Item.pesoCilindro as it_pesoCilindro, Item.pesoLiqUnitario as it_pesoLiqUnitario, " +
      " Item.capacidadeCilindro as it_capacidadeCilindro, " +
      " Item.cstCilindro as it_cstCilindro, Item.cstGas as it_cstGas, " +
      " Item.classeNcmGas as it_classeNcmGas, Item.classeNcmCilindro as it_classeNcmCilindro, " +
      " Item.fatorConversao as it_fatorConversao, " +
      " Item.indFatorConvPolegadas as it_indFatorConvPolegadas, " +
      " Item.tipoItem as it_tipoItem, Item.tipoPropriedade as it_tipoPropriedade, Item.indRastreavel as it_indRastreavel " +
      " FROM Price " +
      " INNER JOIN Item ON Price.cdItem = Item.cdItem " +
      " WHERE Price.cdCustomer = :cdCustomer " +
      "   AND Price.flNovoFaturamento = :flNovoFaturamento" +
      "   AND Price.condicaoFaturamento <> 991" +
      "   AND Price.cdItem = ifnull(:cdItem, Price.cdItem)" +
      "   AND Item.tipoItem in (:tipoItem)" +
      "   AND Item.qtdCilindroCheios > 0 ")
  List<ItemPrice> findPricesRfh(Long cdCustomer, Long cdItem, List<Integer> tipoItem,
                                String flNovoFaturamento);

  @Query("SELECT Item.cdItem as it_cdItem, Item.cdCilindro as it_cdCilindro, " +
      "Item.descricaoCilindro as it_descricaoCilindro, " +
      "Item.tipoPressao as it_tipoPressao, " +
      "Item.descricaoProduto as it_descricaoProduto, Item.valorIndenizacao as it_valorIndenizacao, " +
      "Item.capacidadeProduto as it_capacidadeProduto, Item.unidadeMedida as it_unidadeMedida," +
      "Item.tax3 as it_tax3, Item.indProducao as it_indProducao, " +
      "Item.indRequerFator as it_indRequerFator, Item.pesoCilindro as it_pesoCilindro, " +
      "Item.pesoLiqUnitario as it_pesoLiqUnitario, Item.capacidadeCilindro as it_capacidadeCilindro," +
      "Item.cstCilindro as it_cstCilindro, Item.cstGas as it_cstGas, " +
      "Item.classeNcmGas as it_classeNcmGas, Item.classeNcmCilindro as it_classeNcmCilindro, " +
      "Item.tipoItem as it_tipoItem, Item.tipoPropriedade as it_tipoPropriedade, " +
      "Item.fatorConversao as it_fatorConversao, " +
      "Item.indFatorConvPolegadas as it_indFatorConvPolegadas, Item.indRastreavel as it_indRastreavel " +
      "FROM Item " +
      "WHERE cdCilindro > 0 AND Item.cdItem = ifnull(:cdItem, Item.cdItem)")
  List<ItemPrice> findPricesCpl(Long cdItem);
}


