package br.com.whitemartins.obc.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Callback;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Configuration;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomOpenHelper;
import android.arch.persistence.room.RoomOpenHelper.Delegate;
import android.arch.persistence.room.util.TableInfo;
import android.arch.persistence.room.util.TableInfo.Column;
import android.arch.persistence.room.util.TableInfo.ForeignKey;
import android.arch.persistence.room.util.TableInfo.Index;
import br.com.whitemartins.obc.dao.AbastecimentoDao;
import br.com.whitemartins.obc.dao.AbastecimentoDao_Impl;
import br.com.whitemartins.obc.dao.AnswerDao;
import br.com.whitemartins.obc.dao.AnswerDao_Impl;
import br.com.whitemartins.obc.dao.AssetDao;
import br.com.whitemartins.obc.dao.AssetDao_Impl;
import br.com.whitemartins.obc.dao.CodeDao;
import br.com.whitemartins.obc.dao.CodeDao_Impl;
import br.com.whitemartins.obc.dao.ConversionLQDao;
import br.com.whitemartins.obc.dao.ConversionLQDao_Impl;
import br.com.whitemartins.obc.dao.CustomerDao;
import br.com.whitemartins.obc.dao.CustomerDao_Impl;
import br.com.whitemartins.obc.dao.DailyDao;
import br.com.whitemartins.obc.dao.DailyDao_Impl;
import br.com.whitemartins.obc.dao.ExceptyDao;
import br.com.whitemartins.obc.dao.ExceptyDao_Impl;
import br.com.whitemartins.obc.dao.GeneralDao;
import br.com.whitemartins.obc.dao.GeneralDao_Impl;
import br.com.whitemartins.obc.dao.InvoiceDao;
import br.com.whitemartins.obc.dao.InvoiceDao_Impl;
import br.com.whitemartins.obc.dao.InvoiceImageDao;
import br.com.whitemartins.obc.dao.InvoiceImageDao_Impl;
import br.com.whitemartins.obc.dao.InvoiceItemDao;
import br.com.whitemartins.obc.dao.InvoiceItemDao_Impl;
import br.com.whitemartins.obc.dao.InvoiceMessageDao;
import br.com.whitemartins.obc.dao.InvoiceMessageDao_Impl;
import br.com.whitemartins.obc.dao.InvoiceNumberDao;
import br.com.whitemartins.obc.dao.InvoiceNumberDao_Impl;
import br.com.whitemartins.obc.dao.ItemDao;
import br.com.whitemartins.obc.dao.ItemDao_Impl;
import br.com.whitemartins.obc.dao.LotePatrimonioDao;
import br.com.whitemartins.obc.dao.LotePatrimonioDao_Impl;
import br.com.whitemartins.obc.dao.MessageDao;
import br.com.whitemartins.obc.dao.MessageDao_Impl;
import br.com.whitemartins.obc.dao.PatientDao;
import br.com.whitemartins.obc.dao.PatientDao_Impl;
import br.com.whitemartins.obc.dao.PaymentCardDao;
import br.com.whitemartins.obc.dao.PaymentCardDao_Impl;
import br.com.whitemartins.obc.dao.PaymentDao;
import br.com.whitemartins.obc.dao.PaymentDao_Impl;
import br.com.whitemartins.obc.dao.PreOrderDao;
import br.com.whitemartins.obc.dao.PreOrderDao_Impl;
import br.com.whitemartins.obc.dao.PriceDao;
import br.com.whitemartins.obc.dao.PriceDao_Impl;
import br.com.whitemartins.obc.dao.QuestionsDao;
import br.com.whitemartins.obc.dao.QuestionsDao_Impl;
import br.com.whitemartins.obc.dao.RastreabilidadeDao;
import br.com.whitemartins.obc.dao.RastreabilidadeDao_Impl;
import br.com.whitemartins.obc.dao.RouteDao;
import br.com.whitemartins.obc.dao.RouteDao_Impl;
import br.com.whitemartins.obc.dao.SaldoDao;
import br.com.whitemartins.obc.dao.SaldoDao_Impl;
import br.com.whitemartins.obc.dao.SearchDao;
import br.com.whitemartins.obc.dao.SearchDao_Impl;
import br.com.whitemartins.obc.dao.TaxDao;
import br.com.whitemartins.obc.dao.TaxDao_Impl;
import br.com.whitemartins.obc.dao.TravelDao;
import br.com.whitemartins.obc.dao.TravelDao_Impl;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public class AppDatabase_Impl extends AppDatabase {
  private volatile DailyDao _dailyDao;

  private volatile CustomerDao _customerDao;

  private volatile RouteDao _routeDao;

  private volatile PriceDao _priceDao;

  private volatile ItemDao _itemDao;

  private volatile AssetDao _assetDao;

  private volatile InvoiceNumberDao _invoiceNumberDao;

  private volatile PaymentCardDao _paymentCardDao;

  private volatile TaxDao _taxDao;

  private volatile CodeDao _codeDao;

  private volatile QuestionsDao _questionsDao;

  private volatile ConversionLQDao _conversionLQDao;

  private volatile MessageDao _messageDao;

  private volatile TravelDao _travelDao;

  private volatile PreOrderDao _preOrderDao;

  private volatile GeneralDao _generalDao;

  private volatile PatientDao _patientDao;

  private volatile RastreabilidadeDao _rastreabilidadeDao;

  private volatile InvoiceDao _invoiceDao;

  private volatile InvoiceItemDao _invoiceItemDao;

  private volatile InvoiceMessageDao _invoiceMessageDao;

  private volatile SearchDao _searchDao;

  private volatile AnswerDao _answerDao;

  private volatile PaymentDao _paymentDao;

  private volatile SaldoDao _saldoDao;

  private volatile LotePatrimonioDao _lotePatrimonioDao;

  private volatile AbastecimentoDao _abastecimentoDao;

  private volatile ExceptyDao _exceptyDao;

  private volatile InvoiceImageDao _invoiceImageDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(6) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Daily` (`numeroViagem` INTEGER, `dataHoraInicio` INTEGER, `odometroInicial` INTEGER, `dataHoraFim` INTEGER, `odometroFinal` INTEGER, `rota` INTEGER, `veiculo` TEXT, `filial` TEXT, `versao` TEXT, `modeloDocViagem` INTEGER, `dataViagem` TEXT, PRIMARY KEY(`numeroViagem`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Customer` (`cdCustomer` INTEGER, `nome` TEXT, `endereco` TEXT, `bairro` TEXT, `cidade` TEXT, `uf` TEXT, `cep` TEXT, `telefone` TEXT, `dtPesquisa` INTEGER, `situacaoTributariaPis` INTEGER, `situacaoTributariaCofins` INTEGER, `cstPisE` TEXT, `cstPisS` TEXT, `cstCofinsE` TEXT, `cstCofinsS` TEXT, `flDistribGas` TEXT, `flPaciente` TEXT, `inscEstadual` TEXT, `tipoCnpjCpf` TEXT, `cnpj` TEXT, `flPesquisa` TEXT, `limiteCredito` REAL, `dtVigencia` INTEGER, `cdCiaFiscal` INTEGER, `flReducaoIcms` TEXT, `flCredito` TEXT, `flSimplesFaturamento` TEXT, `permitirCheque` TEXT, `permitirFatura` TEXT, `permitirDinheiro` TEXT, `situacaoTributariaIpi` INTEGER, `unidResponsaval` TEXT, `consumidorFinal` TEXT, `classeContrib` INTEGER, `descontoIcmsOrgaoPublico` INTEGER, `situacaoTributariaIcms` INTEGER, `flFilialWm` TEXT, `nomeMotorista` TEXT, `nomeContato` TEXT, `cargoContato` TEXT, `telefoneContato` TEXT, `flNovoFaturamento` TEXT, `cdJdeOperadora` INTEGER, PRIMARY KEY(`cdCustomer`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Item` (`cdItem` INTEGER NOT NULL, `capacidadeProduto` REAL NOT NULL, `cdCilindro` INTEGER NOT NULL, `capacidadeCilindro` REAL, `indCapacVariavel` TEXT, `indRecursivoLastro` TEXT, `descricaoCilindro` TEXT, `descricaoProduto` TEXT, `qtdCilindroCheios` REAL, `qtdCilindroVazios` REAL, `fatorConversao` REAL, `estruturaProducao` TEXT, `percode` INTEGER, `custoTransferencia` REAL, `tax1` TEXT, `tax2` TEXT, `tax3` TEXT, `indRastreavel` TEXT, `indLiquido` TEXT, `valorIndenizacao` REAL, `cstGas` TEXT, `cstCilindro` TEXT, `unidadeMedida` TEXT, `indLiqGas` TEXT, `indRequerFator` INTEGER, `fatorPcs` REAL, `pcsRegistrado` TEXT, `classeNcmCilindro` INTEGER, `pesoCilindro` REAL, `pesoLiqUnitario` REAL, `classeNcmGas` INTEGER, `tipoPropriedade` TEXT, `recursivFrete` TEXT, `tipoPressao` INTEGER, `indRastreabilidade` TEXT, `tipoItem` INTEGER, `indFatorConvPolegadas` TEXT, `indProducao` TEXT, PRIMARY KEY(`cdItem`, `capacidadeProduto`, `cdCilindro`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Price` (`cdCustomer` INTEGER NOT NULL, `cdItem` INTEGER NOT NULL, `flNovoFaturamento` TEXT, `percentualIpi` REAL, `percentualIcms` REAL, `percReducaoIcms` REAL, `precoUnitario` REAL, `valorFrete` REAL, `valorDespesas` REAL, `percentualPis` REAL, `percentualCofins` REAL, `cstPis` TEXT, `cstCofins` TEXT, `situacaoTributaria` TEXT, `condicaoFaturamento` TEXT, PRIMARY KEY(`cdCustomer`, `cdItem`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Route` (`cdFilial` TEXT, `numAlmoxarifado` TEXT, `cdRota` INTEGER, `numVeiculo` TEXT, `numeroMotorista` TEXT, `numeroViagem` INTEGER, `cdFilialJde` TEXT, `cdCompanhia` TEXT, `pesquisaHabilitada` TEXT, `modeloDoc` TEXT, `modeloCec` TEXT, `nomeFilial` TEXT, `endereco` TEXT, `bairro` TEXT, `cidade` TEXT, `uf` TEXT, `cep` TEXT, `tipoCnpj` TEXT, `cnpj` TEXT, `inscEstadual` TEXT, `telefone` TEXT, `numeroModem` TEXT, `intervalo` INTEGER, `intervaloTempo` INTEGER, `razaoSocial` TEXT, `valorIndenizacaoAlta` REAL, `valorIndenizacaoBaixa` REAL, `valorIndenizacaoLS` REAL, `integDI` TEXT, `descDesp1` TEXT, `descDesp2` TEXT, `descDesp3` TEXT, `descDesp4` TEXT, `adicionarCliente` TEXT, `alterarPrecoObc` TEXT, `solicitarOdometroParada` TEXT, `permitirTroca` TEXT, `tipoFilial` TEXT, `forcarContagemFisica` TEXT, `ultimaContagemSenha` TEXT, `imprimirVariacaoPreco` TEXT, `senhaComunicacao` TEXT, `habilitarImpressora` TEXT, `fatiaAutomaticaPreco` TEXT, `imprimirPreorderDepois` TEXT, `flPrecoPreorder` TEXT, `statusRastrebilidade` INTEGER, `tipoImpressao` TEXT, `tipoImpressora` TEXT, `mostrarDescontoMotorista` TEXT, `imprimirQtdNota` TEXT, `imprimirContagem` TEXT, `tipoCargaVeiculo` INTEGER, `checkDiscoVazio` TEXT, `relatorioAuditoria` TEXT, `clienteSemServico` TEXT, `abatimento` TEXT, `registroNota` TEXT, `relatorioDespesas` TEXT, `avaliacaoInventario` TEXT, `resumoViriacao` TEXT, `relatorioData` TEXT, `contaPagamento` TEXT, `transferencia` TEXT, `deposito` TEXT, `viagemMultipla` TEXT, `medidorVazao` TEXT, `obc6110` TEXT, `ativarRastreabilidade` TEXT, `razaoSocialTransp` TEXT, `enderecoTrasnp` TEXT, `cidadeTransp` TEXT, `estadoTransp` TEXT, `placaVeiculo` TEXT, `UfVeiculo` TEXT, `tipoCnpjTransp` TEXT, `cnpjTransp` TEXT, `tipoPagamento` TEXT, `reimprimirNota` TEXT, `remeterPara` TEXT, `setupModem` TEXT, `tipoDiscagem` TEXT, `tipoConexao` TEXT, `dataViagem` INTEGER, `imei` TEXT, `bloqViagem` TEXT, PRIMARY KEY(`cdRota`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Asset` (`cdItem` INTEGER NOT NULL, `descricao` TEXT, `numeroPatrimonio` TEXT NOT NULL, `numeroSerie` TEXT, `cdAtivo` TEXT, `descricaoAtivo` TEXT, `checado` TEXT, PRIMARY KEY(`cdItem`, `numeroPatrimonio`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Patient` (`cdPaciente` INTEGER, `nome` TEXT, `endereco` TEXT, `bairro` TEXT, `cidade` TEXT, `UF` TEXT, `CEP` TEXT, `telefone` TEXT, `cdJDEOperadora` INTEGER, `cnpj` TEXT, `flDistribGas` TEXT, `precoDiferente` TEXT, PRIMARY KEY(`cdPaciente`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `InvoiceNumber` (`numeroSerieEntrada` INTEGER, `tipoNotaEntrada` TEXT, `numeroNotaFiscalEntrada` INTEGER, `numeroMaximoNFEntrada` INTEGER, `numeroSerieSaida` INTEGER, `tipoNotaSaida` TEXT, `nuemroNotaFiscalSaida` INTEGER, `numeroMaximoNFSaida` INTEGER, `numeroLinhasEntrada` INTEGER, `numeroLinhasSaida` INTEGER, PRIMARY KEY(`numeroNotaFiscalEntrada`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `PaymentCard` (`cnpj` TEXT NOT NULL, `nomeEmpresa` TEXT, `tipoIntegracao` INTEGER, PRIMARY KEY(`cnpj`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Tax` (`condPagto` INTEGER NOT NULL, `descPagto` TEXT, `seqParcela` INTEGER, `dtEmissao` INTEGER NOT NULL, `dtParcela` INTEGER NOT NULL, `percentual` REAL, `indCondPagto` TEXT, PRIMARY KEY(`condPagto`, `dtEmissao`, `dtParcela`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Code` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `tipoCodigo` TEXT, `codigo` INTEGER, `descricao` TEXT, `indRastreabilidade` TEXT, `cfop3` INTEGER, `sufixo` TEXT, `cfop4` INTEGER, `situacaoTributariaPis` INTEGER, `cstPis` TEXT, `situacaoTributariaCofins` INTEGER, `cstCofins` TEXT, `cstIpiZero` TEXT, `cstIpiTributado` TEXT, `cstIpiIsento` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Questions` (`numeroPergunta` INTEGER, `pergunta` TEXT, `numeroResposta1` INTEGER, `resposta1` TEXT, `numeroResposta2` INTEGER, `resposta2` TEXT, `numeroResposta3` INTEGER, `resposta3` TEXT, `numeroResposta4` INTEGER, `resposta4` TEXT, `numeroResposta5` INTEGER, `resposta5` TEXT, `categorizar` TEXT, PRIMARY KEY(`numeroPergunta`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `ConversaoLQ` (`numeroWM` INTEGER, `cdJDECliente` INTEGER NOT NULL, `numeroSerieTanque` TEXT NOT NULL, `capacidadeKG` REAL, `capacidadePol` REAL, `fatorConversao` REAL, PRIMARY KEY(`cdJDECliente`, `numeroSerieTanque`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Message` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `tipoMensagem` TEXT NOT NULL, `cdCustomer` INTEGER NOT NULL, `mensagem` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Travel` (`numeroViagem` INTEGER, `dataViagem` INTEGER, `sequencia` INTEGER, `indViagemUsada` TEXT, PRIMARY KEY(`numeroViagem`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `PreOrder` (`cdPreOrder` INTEGER NOT NULL, `dataEmissaoNota` INTEGER, `cdCustomer` INTEGER NOT NULL, `numeroNotaOrigem` TEXT, `cdItem` INTEGER NOT NULL, `capacidadeProduto` REAL, `saldo` REAL, `preco` REAL, `ajusteICMS` REAL, PRIMARY KEY(`cdPreOrder`, `cdCustomer`, `cdItem`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `General` (`id` INTEGER, `numeroViagem` INTEGER, `numeroNotaEntrada` INTEGER, `serieNotaEntrada` INTEGER, `numeroNotaSaida` INTEGER, `serieNotaSaida` INTEGER, `contadorSenha` INTEGER, `flIndOriginalRefeita` TEXT, `beginTravelType` TEXT, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Rastreabilidade` (`id` INTEGER, `cdFilial` TEXT, `cdCilindro` TEXT, `numeroLote` TEXT, `idNota` INTEGER, `numeroNota` INTEGER, `cdItem` INTEGER, `numeroVeiculo` TEXT, `numeroViagem` INTEGER, `dataViagem` INTEGER, `capacidadeItem` REAL, `cdCustomer` INTEGER, `liberado` TEXT, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE UNIQUE INDEX `uk_cilindro` ON `Rastreabilidade` (`idNota`, `cdCilindro`, `cdItem`, `capacidadeItem`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Invoice` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `numero` INTEGER, `serie` INTEGER, `numeroNotaVOR` INTEGER, `serieNotaVOR` INTEGER, `cdPreOrdem` TEXT, `numeroFutEntrega` TEXT, `cdFiscal` INTEGER, `cnpjCpfDestino` TEXT, `cnpjCpfTransp` TEXT, `tipoNota` TEXT, `classeContribuinte` INTEGER, `dataViagemPrincial` TEXT, `numeroViagem` TEXT, `dataViagem` TEXT, `nomeOperacao` TEXT, `dataEmissao` INTEGER, `dataMovimento` INTEGER, `dataVencimento` INTEGER, `valorTotal` REAL, `valorLiquido` REAL, `valorTotalProduto` REAL, `valorFrete` REAL, `valorDespAcessorias` REAL, `valorDinheiro` REAL, `valorTroco` REAL, `valorFatura` REAL, `valorDebito` REAL, `valorCredito` REAL, `valorCheque` REAL, `numeroCheque` TEXT, `ufVeiculo` TEXT, `placaVeiculo` TEXT, `numeroVeiculo` TEXT, `modalidadeFrete` INTEGER, `nomeEspecVolume` TEXT, `nomeMarca` TEXT, `qtdVolumes` INTEGER, `volumeCapacidade` REAL, `volumeCapacidadeReport` REAL, `pesoBruto` REAL, `pesoLiquido` REAL, `tipoPedido` TEXT, `cdCustomer` INTEGER, `ativaTipoPagto` TEXT, `stepEmissao` INTEGER, `chave` TEXT, `protocolo` TEXT, `cdMovimento` TEXT, `condicaoPagamento` TEXT, `aliquotaIcms` REAL, `valorDescontoIcms` REAL, `valorIcms` REAL, `baseCalculoIcms` REAL, `situacaoTributariaIcms` INTEGER, `valorIpi` REAL, `baseCalculoIpi` REAL, `situacaoTributariaIpi` INTEGER, `flNovoFaturamento` TEXT, `cdOperadora` INTEGER, `flPaciente` TEXT, `cdCustomerService` INTEGER, `nomeAssinadorCec` TEXT, `rgAssinadorCec` TEXT, `tipoMovimentoIntegracao` INTEGER, `semPagto` TEXT, `statusGravacaoJde` INTEGER, `mensagemGravacaoJde` TEXT, `tipoTransacao` INTEGER, `status` INTEGER, `statusContingencia` TEXT, `mensagemContingencia` TEXT, `statusCec` INTEGER, `nomeTransacao` TEXT, `statusImpressaoCec` INTEGER, `nomeFormaImpressaoCec` TEXT, `nomeStatus` TEXT, `nomeStatusImpressaoCec` TEXT, `flPrecoAlterado` TEXT, `nomeTipoPagamento` TEXT, `cdMotivo` TEXT, `dsMotivo` TEXT, `statusNfeImp` TEXT, `statusReportFile` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `InvoiceItem` (`idNota` INTEGER NOT NULL, `numeroNota` INTEGER, `serieNota` INTEGER, `cfop` INTEGER, `seqItem` INTEGER, `cdItem` INTEGER NOT NULL, `capacidade` REAL NOT NULL, `nomeItem` TEXT, `qtdItem` REAL, `volume` REAL, `unidadeMedida` TEXT, `naturezaOperacao` TEXT, `nomeNaturezaOperacao` TEXT, `classifFiscal` INTEGER, `cstAIcms` TEXT, `cstBIcms` TEXT, `cstIpi` TEXT, `cstPis` TEXT, `cstCofins` TEXT, `valorTotal` REAL, `valorBaseIcms` REAL, `valorBaseReduzidaIcms` REAL, `valorIcms` REAL, `valorDebitoIcms` REAL, `valorCreditoIcms` REAL, `valorBaseIcmsSt` REAL, `valorIcmsSt` REAL, `valorBaseIpi` REAL, `valorIpi` REAL, `valorDebitoIpi` REAL, `valorCreditoIpi` REAL, `valorBasePis` REAL, `valorDebitoPis` REAL, `valorBaseCreditoPis` REAL, `valorCreditoPis` REAL, `valorBaseCofins` REAL, `valorDebitoCofins` REAL, `valorBaseCreditoCofins` REAL, `valorCreditoCofins` REAL, `aliquotaIcms` REAL, `aliquotaIpi` REAL, `aliquotaPis` REAL, `aliquotaCofins` REAL, `tipoIcms` INTEGER, `tipoIpi` INTEGER, `tipoPis` INTEGER, `tipoCofins` INTEGER, `valorTotalFrete` REAL, `valorTotalSeguro` REAL, `valorDescontoIcms` REAL, `valorUnitario` REAL, `valorDespesasAcessorias` REAL, `flPrecoAlterado` TEXT, `valorPrecoUnitarioOriginal` REAL, `infCilPP` TEXT, `condicaoPagamento` TEXT, `cdMovimento` TEXT, `returnType` INTEGER, `returnCode` TEXT, `quantidadeCilindroVendida` REAL, `quantidadeCilindroPedida` REAL, `pedidoCustomer` TEXT, `itemPedidoCustomer` TEXT, `tipoFaturamento` TEXT, `flAssistenciaTecnica` TEXT, `tipoItem` INTEGER, PRIMARY KEY(`idNota`, `cdItem`, `capacidade`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `InvoiceMessage` (`idNota` INTEGER NOT NULL, `tipoTransacao` INTEGER, `numeroNota` INTEGER, `serieNota` INTEGER, `cdCustomer` INTEGER NOT NULL, `cdRota` INTEGER, `numeroFutEntrega` TEXT, `dataEmissao` INTEGER, `sequencia` INTEGER NOT NULL, `linha` INTEGER NOT NULL, `mensagem` TEXT, `mostrarMsg` TEXT, PRIMARY KEY(`idNota`, `cdCustomer`, `sequencia`, `linha`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Search` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `cdCustomer` INTEGER, `dtPesquisa` INTEGER, `motorista` TEXT, `contato` TEXT, `cargo` TEXT, `telefone` TEXT, `rejeitada` TEXT, `idNota` INTEGER)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Answer` (`id` INTEGER NOT NULL, `idPesquisa` INTEGER NOT NULL, `pergunrta` TEXT, `resposta` TEXT, `categorizada` TEXT, PRIMARY KEY(`id`, `idPesquisa`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Payment` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `idNota` INTEGER, `tipoIntegracao` INTEGER, `cnpj` TEXT, `numeroAutorizacao` TEXT, `valor` REAL, `credenciadora` TEXT, `bandeira` TEXT, `nomeBandeira` TEXT, `modalidade` INTEGER)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Saldo` (`numeroViagem` INTEGER NOT NULL, `cdItem` INTEGER NOT NULL, `capacidade` REAL NOT NULL, `nomeItem` TEXT, `tipoItem` INTEGER, `tipoPropriedade` TEXT, `qtdCarregadaCheios` REAL, `qtdCarregadaVazios` REAL, `qtdAtualCheios` REAL, `qtdAtualVazios` REAL, `qtdCheiosCont` REAL, `qtdVaziosCont` REAL, `qtdVendidos` REAL, `qtdAplicados` REAL, `qtdRecolhidos` REAL, `qtdAplicadosHC` REAL, `qtdRecolhidosHC` REAL, `qtdAplicadosHCCont` REAL, `qtdRecolhidosHCCont` REAL, `qtdTrocados` REAL, `qtdTransferidos` REAL, `qtdComplementados` REAL, `qtdDescarregados` REAL, PRIMARY KEY(`numeroViagem`, `cdItem`, `capacidade`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `LotePatrimonio` (`codigo` INTEGER PRIMARY KEY AUTOINCREMENT, `idNota` INTEGER, `cdFilial` TEXT, `cdItem` INTEGER, `capacidade` REAL, `numeroLote` TEXT, `numeroVeiuclo` TEXT, `numeroViagem` INTEGER, `dataViagem` INTEGER, `cdCustomer` INTEGER, `tipo` INTEGER, `liberado` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Abastecimento` (`codigo` INTEGER, `numWM` INTEGER, `cdCustomer` INTEGER, `numeroSerieTanque` TEXT, `capacidadeKG` REAL, `capacidadePol` REAL, `fatorConversao` REAL, `pesoAntes` REAL, `pesoDepois` REAL, `nivelAntes` REAL, `nivelDepois` REAL, `totalDescarga` REAL, `totalCalulado` REAL, `totalNfe` REAL, `divergente` TEXT, `tipoCalculo` INTEGER, `idNota` INTEGER, PRIMARY KEY(`codigo`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Excepty` (`cdCustomer` INTEGER NOT NULL, `cdExcept` INTEGER NOT NULL, `dataHoraEntrada` INTEGER NOT NULL, `tipo` TEXT, `odometro` INTEGER, `dataHoraSaida` INTEGER, `numeroViagem` INTEGER, `dataViagem` INTEGER, PRIMARY KEY(`cdCustomer`, `cdExcept`, `dataHoraEntrada`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `InvoiceImage` (`idNota` INTEGER, `status` INTEGER, `cec` TEXT, `assinatura` TEXT, PRIMARY KEY(`idNota`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"a1d991c54c4a69696672956c476e7b22\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Daily`");
        _db.execSQL("DROP TABLE IF EXISTS `Customer`");
        _db.execSQL("DROP TABLE IF EXISTS `Item`");
        _db.execSQL("DROP TABLE IF EXISTS `Price`");
        _db.execSQL("DROP TABLE IF EXISTS `Route`");
        _db.execSQL("DROP TABLE IF EXISTS `Asset`");
        _db.execSQL("DROP TABLE IF EXISTS `Patient`");
        _db.execSQL("DROP TABLE IF EXISTS `InvoiceNumber`");
        _db.execSQL("DROP TABLE IF EXISTS `PaymentCard`");
        _db.execSQL("DROP TABLE IF EXISTS `Tax`");
        _db.execSQL("DROP TABLE IF EXISTS `Code`");
        _db.execSQL("DROP TABLE IF EXISTS `Questions`");
        _db.execSQL("DROP TABLE IF EXISTS `ConversaoLQ`");
        _db.execSQL("DROP TABLE IF EXISTS `Message`");
        _db.execSQL("DROP TABLE IF EXISTS `Travel`");
        _db.execSQL("DROP TABLE IF EXISTS `PreOrder`");
        _db.execSQL("DROP TABLE IF EXISTS `General`");
        _db.execSQL("DROP TABLE IF EXISTS `Rastreabilidade`");
        _db.execSQL("DROP TABLE IF EXISTS `Invoice`");
        _db.execSQL("DROP TABLE IF EXISTS `InvoiceItem`");
        _db.execSQL("DROP TABLE IF EXISTS `InvoiceMessage`");
        _db.execSQL("DROP TABLE IF EXISTS `Search`");
        _db.execSQL("DROP TABLE IF EXISTS `Answer`");
        _db.execSQL("DROP TABLE IF EXISTS `Payment`");
        _db.execSQL("DROP TABLE IF EXISTS `Saldo`");
        _db.execSQL("DROP TABLE IF EXISTS `LotePatrimonio`");
        _db.execSQL("DROP TABLE IF EXISTS `Abastecimento`");
        _db.execSQL("DROP TABLE IF EXISTS `Excepty`");
        _db.execSQL("DROP TABLE IF EXISTS `InvoiceImage`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsDaily = new HashMap<String, TableInfo.Column>(11);
        _columnsDaily.put("numeroViagem", new TableInfo.Column("numeroViagem", "INTEGER", false, 1));
        _columnsDaily.put("dataHoraInicio", new TableInfo.Column("dataHoraInicio", "INTEGER", false, 0));
        _columnsDaily.put("odometroInicial", new TableInfo.Column("odometroInicial", "INTEGER", false, 0));
        _columnsDaily.put("dataHoraFim", new TableInfo.Column("dataHoraFim", "INTEGER", false, 0));
        _columnsDaily.put("odometroFinal", new TableInfo.Column("odometroFinal", "INTEGER", false, 0));
        _columnsDaily.put("rota", new TableInfo.Column("rota", "INTEGER", false, 0));
        _columnsDaily.put("veiculo", new TableInfo.Column("veiculo", "TEXT", false, 0));
        _columnsDaily.put("filial", new TableInfo.Column("filial", "TEXT", false, 0));
        _columnsDaily.put("versao", new TableInfo.Column("versao", "TEXT", false, 0));
        _columnsDaily.put("modeloDocViagem", new TableInfo.Column("modeloDocViagem", "INTEGER", false, 0));
        _columnsDaily.put("dataViagem", new TableInfo.Column("dataViagem", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysDaily = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesDaily = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoDaily = new TableInfo("Daily", _columnsDaily, _foreignKeysDaily, _indicesDaily);
        final TableInfo _existingDaily = TableInfo.read(_db, "Daily");
        if (! _infoDaily.equals(_existingDaily)) {
          throw new IllegalStateException("Migration didn't properly handle Daily(br.com.whitemartins.obc.model.Daily).\n"
                  + " Expected:\n" + _infoDaily + "\n"
                  + " Found:\n" + _existingDaily);
        }
        final HashMap<String, TableInfo.Column> _columnsCustomer = new HashMap<String, TableInfo.Column>(43);
        _columnsCustomer.put("cdCustomer", new TableInfo.Column("cdCustomer", "INTEGER", false, 1));
        _columnsCustomer.put("nome", new TableInfo.Column("nome", "TEXT", false, 0));
        _columnsCustomer.put("endereco", new TableInfo.Column("endereco", "TEXT", false, 0));
        _columnsCustomer.put("bairro", new TableInfo.Column("bairro", "TEXT", false, 0));
        _columnsCustomer.put("cidade", new TableInfo.Column("cidade", "TEXT", false, 0));
        _columnsCustomer.put("uf", new TableInfo.Column("uf", "TEXT", false, 0));
        _columnsCustomer.put("cep", new TableInfo.Column("cep", "TEXT", false, 0));
        _columnsCustomer.put("telefone", new TableInfo.Column("telefone", "TEXT", false, 0));
        _columnsCustomer.put("dtPesquisa", new TableInfo.Column("dtPesquisa", "INTEGER", false, 0));
        _columnsCustomer.put("situacaoTributariaPis", new TableInfo.Column("situacaoTributariaPis", "INTEGER", false, 0));
        _columnsCustomer.put("situacaoTributariaCofins", new TableInfo.Column("situacaoTributariaCofins", "INTEGER", false, 0));
        _columnsCustomer.put("cstPisE", new TableInfo.Column("cstPisE", "TEXT", false, 0));
        _columnsCustomer.put("cstPisS", new TableInfo.Column("cstPisS", "TEXT", false, 0));
        _columnsCustomer.put("cstCofinsE", new TableInfo.Column("cstCofinsE", "TEXT", false, 0));
        _columnsCustomer.put("cstCofinsS", new TableInfo.Column("cstCofinsS", "TEXT", false, 0));
        _columnsCustomer.put("flDistribGas", new TableInfo.Column("flDistribGas", "TEXT", false, 0));
        _columnsCustomer.put("flPaciente", new TableInfo.Column("flPaciente", "TEXT", false, 0));
        _columnsCustomer.put("inscEstadual", new TableInfo.Column("inscEstadual", "TEXT", false, 0));
        _columnsCustomer.put("tipoCnpjCpf", new TableInfo.Column("tipoCnpjCpf", "TEXT", false, 0));
        _columnsCustomer.put("cnpj", new TableInfo.Column("cnpj", "TEXT", false, 0));
        _columnsCustomer.put("flPesquisa", new TableInfo.Column("flPesquisa", "TEXT", false, 0));
        _columnsCustomer.put("limiteCredito", new TableInfo.Column("limiteCredito", "REAL", false, 0));
        _columnsCustomer.put("dtVigencia", new TableInfo.Column("dtVigencia", "INTEGER", false, 0));
        _columnsCustomer.put("cdCiaFiscal", new TableInfo.Column("cdCiaFiscal", "INTEGER", false, 0));
        _columnsCustomer.put("flReducaoIcms", new TableInfo.Column("flReducaoIcms", "TEXT", false, 0));
        _columnsCustomer.put("flCredito", new TableInfo.Column("flCredito", "TEXT", false, 0));
        _columnsCustomer.put("flSimplesFaturamento", new TableInfo.Column("flSimplesFaturamento", "TEXT", false, 0));
        _columnsCustomer.put("permitirCheque", new TableInfo.Column("permitirCheque", "TEXT", false, 0));
        _columnsCustomer.put("permitirFatura", new TableInfo.Column("permitirFatura", "TEXT", false, 0));
        _columnsCustomer.put("permitirDinheiro", new TableInfo.Column("permitirDinheiro", "TEXT", false, 0));
        _columnsCustomer.put("situacaoTributariaIpi", new TableInfo.Column("situacaoTributariaIpi", "INTEGER", false, 0));
        _columnsCustomer.put("unidResponsaval", new TableInfo.Column("unidResponsaval", "TEXT", false, 0));
        _columnsCustomer.put("consumidorFinal", new TableInfo.Column("consumidorFinal", "TEXT", false, 0));
        _columnsCustomer.put("classeContrib", new TableInfo.Column("classeContrib", "INTEGER", false, 0));
        _columnsCustomer.put("descontoIcmsOrgaoPublico", new TableInfo.Column("descontoIcmsOrgaoPublico", "INTEGER", false, 0));
        _columnsCustomer.put("situacaoTributariaIcms", new TableInfo.Column("situacaoTributariaIcms", "INTEGER", false, 0));
        _columnsCustomer.put("flFilialWm", new TableInfo.Column("flFilialWm", "TEXT", false, 0));
        _columnsCustomer.put("nomeMotorista", new TableInfo.Column("nomeMotorista", "TEXT", false, 0));
        _columnsCustomer.put("nomeContato", new TableInfo.Column("nomeContato", "TEXT", false, 0));
        _columnsCustomer.put("cargoContato", new TableInfo.Column("cargoContato", "TEXT", false, 0));
        _columnsCustomer.put("telefoneContato", new TableInfo.Column("telefoneContato", "TEXT", false, 0));
        _columnsCustomer.put("flNovoFaturamento", new TableInfo.Column("flNovoFaturamento", "TEXT", false, 0));
        _columnsCustomer.put("cdJdeOperadora", new TableInfo.Column("cdJdeOperadora", "INTEGER", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCustomer = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCustomer = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCustomer = new TableInfo("Customer", _columnsCustomer, _foreignKeysCustomer, _indicesCustomer);
        final TableInfo _existingCustomer = TableInfo.read(_db, "Customer");
        if (! _infoCustomer.equals(_existingCustomer)) {
          throw new IllegalStateException("Migration didn't properly handle Customer(br.com.whitemartins.obc.model.Customer).\n"
                  + " Expected:\n" + _infoCustomer + "\n"
                  + " Found:\n" + _existingCustomer);
        }
        final HashMap<String, TableInfo.Column> _columnsItem = new HashMap<String, TableInfo.Column>(38);
        _columnsItem.put("cdItem", new TableInfo.Column("cdItem", "INTEGER", true, 1));
        _columnsItem.put("capacidadeProduto", new TableInfo.Column("capacidadeProduto", "REAL", true, 2));
        _columnsItem.put("cdCilindro", new TableInfo.Column("cdCilindro", "INTEGER", true, 3));
        _columnsItem.put("capacidadeCilindro", new TableInfo.Column("capacidadeCilindro", "REAL", false, 0));
        _columnsItem.put("indCapacVariavel", new TableInfo.Column("indCapacVariavel", "TEXT", false, 0));
        _columnsItem.put("indRecursivoLastro", new TableInfo.Column("indRecursivoLastro", "TEXT", false, 0));
        _columnsItem.put("descricaoCilindro", new TableInfo.Column("descricaoCilindro", "TEXT", false, 0));
        _columnsItem.put("descricaoProduto", new TableInfo.Column("descricaoProduto", "TEXT", false, 0));
        _columnsItem.put("qtdCilindroCheios", new TableInfo.Column("qtdCilindroCheios", "REAL", false, 0));
        _columnsItem.put("qtdCilindroVazios", new TableInfo.Column("qtdCilindroVazios", "REAL", false, 0));
        _columnsItem.put("fatorConversao", new TableInfo.Column("fatorConversao", "REAL", false, 0));
        _columnsItem.put("estruturaProducao", new TableInfo.Column("estruturaProducao", "TEXT", false, 0));
        _columnsItem.put("percode", new TableInfo.Column("percode", "INTEGER", false, 0));
        _columnsItem.put("custoTransferencia", new TableInfo.Column("custoTransferencia", "REAL", false, 0));
        _columnsItem.put("tax1", new TableInfo.Column("tax1", "TEXT", false, 0));
        _columnsItem.put("tax2", new TableInfo.Column("tax2", "TEXT", false, 0));
        _columnsItem.put("tax3", new TableInfo.Column("tax3", "TEXT", false, 0));
        _columnsItem.put("indRastreavel", new TableInfo.Column("indRastreavel", "TEXT", false, 0));
        _columnsItem.put("indLiquido", new TableInfo.Column("indLiquido", "TEXT", false, 0));
        _columnsItem.put("valorIndenizacao", new TableInfo.Column("valorIndenizacao", "REAL", false, 0));
        _columnsItem.put("cstGas", new TableInfo.Column("cstGas", "TEXT", false, 0));
        _columnsItem.put("cstCilindro", new TableInfo.Column("cstCilindro", "TEXT", false, 0));
        _columnsItem.put("unidadeMedida", new TableInfo.Column("unidadeMedida", "TEXT", false, 0));
        _columnsItem.put("indLiqGas", new TableInfo.Column("indLiqGas", "TEXT", false, 0));
        _columnsItem.put("indRequerFator", new TableInfo.Column("indRequerFator", "INTEGER", false, 0));
        _columnsItem.put("fatorPcs", new TableInfo.Column("fatorPcs", "REAL", false, 0));
        _columnsItem.put("pcsRegistrado", new TableInfo.Column("pcsRegistrado", "TEXT", false, 0));
        _columnsItem.put("classeNcmCilindro", new TableInfo.Column("classeNcmCilindro", "INTEGER", false, 0));
        _columnsItem.put("pesoCilindro", new TableInfo.Column("pesoCilindro", "REAL", false, 0));
        _columnsItem.put("pesoLiqUnitario", new TableInfo.Column("pesoLiqUnitario", "REAL", false, 0));
        _columnsItem.put("classeNcmGas", new TableInfo.Column("classeNcmGas", "INTEGER", false, 0));
        _columnsItem.put("tipoPropriedade", new TableInfo.Column("tipoPropriedade", "TEXT", false, 0));
        _columnsItem.put("recursivFrete", new TableInfo.Column("recursivFrete", "TEXT", false, 0));
        _columnsItem.put("tipoPressao", new TableInfo.Column("tipoPressao", "INTEGER", false, 0));
        _columnsItem.put("indRastreabilidade", new TableInfo.Column("indRastreabilidade", "TEXT", false, 0));
        _columnsItem.put("tipoItem", new TableInfo.Column("tipoItem", "INTEGER", false, 0));
        _columnsItem.put("indFatorConvPolegadas", new TableInfo.Column("indFatorConvPolegadas", "TEXT", false, 0));
        _columnsItem.put("indProducao", new TableInfo.Column("indProducao", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysItem = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesItem = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoItem = new TableInfo("Item", _columnsItem, _foreignKeysItem, _indicesItem);
        final TableInfo _existingItem = TableInfo.read(_db, "Item");
        if (! _infoItem.equals(_existingItem)) {
          throw new IllegalStateException("Migration didn't properly handle Item(br.com.whitemartins.obc.model.Item).\n"
                  + " Expected:\n" + _infoItem + "\n"
                  + " Found:\n" + _existingItem);
        }
        final HashMap<String, TableInfo.Column> _columnsPrice = new HashMap<String, TableInfo.Column>(15);
        _columnsPrice.put("cdCustomer", new TableInfo.Column("cdCustomer", "INTEGER", true, 1));
        _columnsPrice.put("cdItem", new TableInfo.Column("cdItem", "INTEGER", true, 2));
        _columnsPrice.put("flNovoFaturamento", new TableInfo.Column("flNovoFaturamento", "TEXT", false, 0));
        _columnsPrice.put("percentualIpi", new TableInfo.Column("percentualIpi", "REAL", false, 0));
        _columnsPrice.put("percentualIcms", new TableInfo.Column("percentualIcms", "REAL", false, 0));
        _columnsPrice.put("percReducaoIcms", new TableInfo.Column("percReducaoIcms", "REAL", false, 0));
        _columnsPrice.put("precoUnitario", new TableInfo.Column("precoUnitario", "REAL", false, 0));
        _columnsPrice.put("valorFrete", new TableInfo.Column("valorFrete", "REAL", false, 0));
        _columnsPrice.put("valorDespesas", new TableInfo.Column("valorDespesas", "REAL", false, 0));
        _columnsPrice.put("percentualPis", new TableInfo.Column("percentualPis", "REAL", false, 0));
        _columnsPrice.put("percentualCofins", new TableInfo.Column("percentualCofins", "REAL", false, 0));
        _columnsPrice.put("cstPis", new TableInfo.Column("cstPis", "TEXT", false, 0));
        _columnsPrice.put("cstCofins", new TableInfo.Column("cstCofins", "TEXT", false, 0));
        _columnsPrice.put("situacaoTributaria", new TableInfo.Column("situacaoTributaria", "TEXT", false, 0));
        _columnsPrice.put("condicaoFaturamento", new TableInfo.Column("condicaoFaturamento", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPrice = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPrice = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPrice = new TableInfo("Price", _columnsPrice, _foreignKeysPrice, _indicesPrice);
        final TableInfo _existingPrice = TableInfo.read(_db, "Price");
        if (! _infoPrice.equals(_existingPrice)) {
          throw new IllegalStateException("Migration didn't properly handle Price(br.com.whitemartins.obc.model.Price).\n"
                  + " Expected:\n" + _infoPrice + "\n"
                  + " Found:\n" + _existingPrice);
        }
        final HashMap<String, TableInfo.Column> _columnsRoute = new HashMap<String, TableInfo.Column>(86);
        _columnsRoute.put("cdFilial", new TableInfo.Column("cdFilial", "TEXT", false, 0));
        _columnsRoute.put("numAlmoxarifado", new TableInfo.Column("numAlmoxarifado", "TEXT", false, 0));
        _columnsRoute.put("cdRota", new TableInfo.Column("cdRota", "INTEGER", false, 1));
        _columnsRoute.put("numVeiculo", new TableInfo.Column("numVeiculo", "TEXT", false, 0));
        _columnsRoute.put("numeroMotorista", new TableInfo.Column("numeroMotorista", "TEXT", false, 0));
        _columnsRoute.put("numeroViagem", new TableInfo.Column("numeroViagem", "INTEGER", false, 0));
        _columnsRoute.put("cdFilialJde", new TableInfo.Column("cdFilialJde", "TEXT", false, 0));
        _columnsRoute.put("cdCompanhia", new TableInfo.Column("cdCompanhia", "TEXT", false, 0));
        _columnsRoute.put("pesquisaHabilitada", new TableInfo.Column("pesquisaHabilitada", "TEXT", false, 0));
        _columnsRoute.put("modeloDoc", new TableInfo.Column("modeloDoc", "TEXT", false, 0));
        _columnsRoute.put("modeloCec", new TableInfo.Column("modeloCec", "TEXT", false, 0));
        _columnsRoute.put("nomeFilial", new TableInfo.Column("nomeFilial", "TEXT", false, 0));
        _columnsRoute.put("endereco", new TableInfo.Column("endereco", "TEXT", false, 0));
        _columnsRoute.put("bairro", new TableInfo.Column("bairro", "TEXT", false, 0));
        _columnsRoute.put("cidade", new TableInfo.Column("cidade", "TEXT", false, 0));
        _columnsRoute.put("uf", new TableInfo.Column("uf", "TEXT", false, 0));
        _columnsRoute.put("cep", new TableInfo.Column("cep", "TEXT", false, 0));
        _columnsRoute.put("tipoCnpj", new TableInfo.Column("tipoCnpj", "TEXT", false, 0));
        _columnsRoute.put("cnpj", new TableInfo.Column("cnpj", "TEXT", false, 0));
        _columnsRoute.put("inscEstadual", new TableInfo.Column("inscEstadual", "TEXT", false, 0));
        _columnsRoute.put("telefone", new TableInfo.Column("telefone", "TEXT", false, 0));
        _columnsRoute.put("numeroModem", new TableInfo.Column("numeroModem", "TEXT", false, 0));
        _columnsRoute.put("intervalo", new TableInfo.Column("intervalo", "INTEGER", false, 0));
        _columnsRoute.put("intervaloTempo", new TableInfo.Column("intervaloTempo", "INTEGER", false, 0));
        _columnsRoute.put("razaoSocial", new TableInfo.Column("razaoSocial", "TEXT", false, 0));
        _columnsRoute.put("valorIndenizacaoAlta", new TableInfo.Column("valorIndenizacaoAlta", "REAL", false, 0));
        _columnsRoute.put("valorIndenizacaoBaixa", new TableInfo.Column("valorIndenizacaoBaixa", "REAL", false, 0));
        _columnsRoute.put("valorIndenizacaoLS", new TableInfo.Column("valorIndenizacaoLS", "REAL", false, 0));
        _columnsRoute.put("integDI", new TableInfo.Column("integDI", "TEXT", false, 0));
        _columnsRoute.put("descDesp1", new TableInfo.Column("descDesp1", "TEXT", false, 0));
        _columnsRoute.put("descDesp2", new TableInfo.Column("descDesp2", "TEXT", false, 0));
        _columnsRoute.put("descDesp3", new TableInfo.Column("descDesp3", "TEXT", false, 0));
        _columnsRoute.put("descDesp4", new TableInfo.Column("descDesp4", "TEXT", false, 0));
        _columnsRoute.put("adicionarCliente", new TableInfo.Column("adicionarCliente", "TEXT", false, 0));
        _columnsRoute.put("alterarPrecoObc", new TableInfo.Column("alterarPrecoObc", "TEXT", false, 0));
        _columnsRoute.put("solicitarOdometroParada", new TableInfo.Column("solicitarOdometroParada", "TEXT", false, 0));
        _columnsRoute.put("permitirTroca", new TableInfo.Column("permitirTroca", "TEXT", false, 0));
        _columnsRoute.put("tipoFilial", new TableInfo.Column("tipoFilial", "TEXT", false, 0));
        _columnsRoute.put("forcarContagemFisica", new TableInfo.Column("forcarContagemFisica", "TEXT", false, 0));
        _columnsRoute.put("ultimaContagemSenha", new TableInfo.Column("ultimaContagemSenha", "TEXT", false, 0));
        _columnsRoute.put("imprimirVariacaoPreco", new TableInfo.Column("imprimirVariacaoPreco", "TEXT", false, 0));
        _columnsRoute.put("senhaComunicacao", new TableInfo.Column("senhaComunicacao", "TEXT", false, 0));
        _columnsRoute.put("habilitarImpressora", new TableInfo.Column("habilitarImpressora", "TEXT", false, 0));
        _columnsRoute.put("fatiaAutomaticaPreco", new TableInfo.Column("fatiaAutomaticaPreco", "TEXT", false, 0));
        _columnsRoute.put("imprimirPreorderDepois", new TableInfo.Column("imprimirPreorderDepois", "TEXT", false, 0));
        _columnsRoute.put("flPrecoPreorder", new TableInfo.Column("flPrecoPreorder", "TEXT", false, 0));
        _columnsRoute.put("statusRastrebilidade", new TableInfo.Column("statusRastrebilidade", "INTEGER", false, 0));
        _columnsRoute.put("tipoImpressao", new TableInfo.Column("tipoImpressao", "TEXT", false, 0));
        _columnsRoute.put("tipoImpressora", new TableInfo.Column("tipoImpressora", "TEXT", false, 0));
        _columnsRoute.put("mostrarDescontoMotorista", new TableInfo.Column("mostrarDescontoMotorista", "TEXT", false, 0));
        _columnsRoute.put("imprimirQtdNota", new TableInfo.Column("imprimirQtdNota", "TEXT", false, 0));
        _columnsRoute.put("imprimirContagem", new TableInfo.Column("imprimirContagem", "TEXT", false, 0));
        _columnsRoute.put("tipoCargaVeiculo", new TableInfo.Column("tipoCargaVeiculo", "INTEGER", false, 0));
        _columnsRoute.put("checkDiscoVazio", new TableInfo.Column("checkDiscoVazio", "TEXT", false, 0));
        _columnsRoute.put("relatorioAuditoria", new TableInfo.Column("relatorioAuditoria", "TEXT", false, 0));
        _columnsRoute.put("clienteSemServico", new TableInfo.Column("clienteSemServico", "TEXT", false, 0));
        _columnsRoute.put("abatimento", new TableInfo.Column("abatimento", "TEXT", false, 0));
        _columnsRoute.put("registroNota", new TableInfo.Column("registroNota", "TEXT", false, 0));
        _columnsRoute.put("relatorioDespesas", new TableInfo.Column("relatorioDespesas", "TEXT", false, 0));
        _columnsRoute.put("avaliacaoInventario", new TableInfo.Column("avaliacaoInventario", "TEXT", false, 0));
        _columnsRoute.put("resumoViriacao", new TableInfo.Column("resumoViriacao", "TEXT", false, 0));
        _columnsRoute.put("relatorioData", new TableInfo.Column("relatorioData", "TEXT", false, 0));
        _columnsRoute.put("contaPagamento", new TableInfo.Column("contaPagamento", "TEXT", false, 0));
        _columnsRoute.put("transferencia", new TableInfo.Column("transferencia", "TEXT", false, 0));
        _columnsRoute.put("deposito", new TableInfo.Column("deposito", "TEXT", false, 0));
        _columnsRoute.put("viagemMultipla", new TableInfo.Column("viagemMultipla", "TEXT", false, 0));
        _columnsRoute.put("medidorVazao", new TableInfo.Column("medidorVazao", "TEXT", false, 0));
        _columnsRoute.put("obc6110", new TableInfo.Column("obc6110", "TEXT", false, 0));
        _columnsRoute.put("ativarRastreabilidade", new TableInfo.Column("ativarRastreabilidade", "TEXT", false, 0));
        _columnsRoute.put("razaoSocialTransp", new TableInfo.Column("razaoSocialTransp", "TEXT", false, 0));
        _columnsRoute.put("enderecoTrasnp", new TableInfo.Column("enderecoTrasnp", "TEXT", false, 0));
        _columnsRoute.put("cidadeTransp", new TableInfo.Column("cidadeTransp", "TEXT", false, 0));
        _columnsRoute.put("estadoTransp", new TableInfo.Column("estadoTransp", "TEXT", false, 0));
        _columnsRoute.put("placaVeiculo", new TableInfo.Column("placaVeiculo", "TEXT", false, 0));
        _columnsRoute.put("UfVeiculo", new TableInfo.Column("UfVeiculo", "TEXT", false, 0));
        _columnsRoute.put("tipoCnpjTransp", new TableInfo.Column("tipoCnpjTransp", "TEXT", false, 0));
        _columnsRoute.put("cnpjTransp", new TableInfo.Column("cnpjTransp", "TEXT", false, 0));
        _columnsRoute.put("tipoPagamento", new TableInfo.Column("tipoPagamento", "TEXT", false, 0));
        _columnsRoute.put("reimprimirNota", new TableInfo.Column("reimprimirNota", "TEXT", false, 0));
        _columnsRoute.put("remeterPara", new TableInfo.Column("remeterPara", "TEXT", false, 0));
        _columnsRoute.put("setupModem", new TableInfo.Column("setupModem", "TEXT", false, 0));
        _columnsRoute.put("tipoDiscagem", new TableInfo.Column("tipoDiscagem", "TEXT", false, 0));
        _columnsRoute.put("tipoConexao", new TableInfo.Column("tipoConexao", "TEXT", false, 0));
        _columnsRoute.put("dataViagem", new TableInfo.Column("dataViagem", "INTEGER", false, 0));
        _columnsRoute.put("imei", new TableInfo.Column("imei", "TEXT", false, 0));
        _columnsRoute.put("bloqViagem", new TableInfo.Column("bloqViagem", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysRoute = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesRoute = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoRoute = new TableInfo("Route", _columnsRoute, _foreignKeysRoute, _indicesRoute);
        final TableInfo _existingRoute = TableInfo.read(_db, "Route");
        if (! _infoRoute.equals(_existingRoute)) {
          throw new IllegalStateException("Migration didn't properly handle Route(br.com.whitemartins.obc.model.Route).\n"
                  + " Expected:\n" + _infoRoute + "\n"
                  + " Found:\n" + _existingRoute);
        }
        final HashMap<String, TableInfo.Column> _columnsAsset = new HashMap<String, TableInfo.Column>(7);
        _columnsAsset.put("cdItem", new TableInfo.Column("cdItem", "INTEGER", true, 1));
        _columnsAsset.put("descricao", new TableInfo.Column("descricao", "TEXT", false, 0));
        _columnsAsset.put("numeroPatrimonio", new TableInfo.Column("numeroPatrimonio", "TEXT", true, 2));
        _columnsAsset.put("numeroSerie", new TableInfo.Column("numeroSerie", "TEXT", false, 0));
        _columnsAsset.put("cdAtivo", new TableInfo.Column("cdAtivo", "TEXT", false, 0));
        _columnsAsset.put("descricaoAtivo", new TableInfo.Column("descricaoAtivo", "TEXT", false, 0));
        _columnsAsset.put("checado", new TableInfo.Column("checado", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAsset = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAsset = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAsset = new TableInfo("Asset", _columnsAsset, _foreignKeysAsset, _indicesAsset);
        final TableInfo _existingAsset = TableInfo.read(_db, "Asset");
        if (! _infoAsset.equals(_existingAsset)) {
          throw new IllegalStateException("Migration didn't properly handle Asset(br.com.whitemartins.obc.model.Asset).\n"
                  + " Expected:\n" + _infoAsset + "\n"
                  + " Found:\n" + _existingAsset);
        }
        final HashMap<String, TableInfo.Column> _columnsPatient = new HashMap<String, TableInfo.Column>(12);
        _columnsPatient.put("cdPaciente", new TableInfo.Column("cdPaciente", "INTEGER", false, 1));
        _columnsPatient.put("nome", new TableInfo.Column("nome", "TEXT", false, 0));
        _columnsPatient.put("endereco", new TableInfo.Column("endereco", "TEXT", false, 0));
        _columnsPatient.put("bairro", new TableInfo.Column("bairro", "TEXT", false, 0));
        _columnsPatient.put("cidade", new TableInfo.Column("cidade", "TEXT", false, 0));
        _columnsPatient.put("UF", new TableInfo.Column("UF", "TEXT", false, 0));
        _columnsPatient.put("CEP", new TableInfo.Column("CEP", "TEXT", false, 0));
        _columnsPatient.put("telefone", new TableInfo.Column("telefone", "TEXT", false, 0));
        _columnsPatient.put("cdJDEOperadora", new TableInfo.Column("cdJDEOperadora", "INTEGER", false, 0));
        _columnsPatient.put("cnpj", new TableInfo.Column("cnpj", "TEXT", false, 0));
        _columnsPatient.put("flDistribGas", new TableInfo.Column("flDistribGas", "TEXT", false, 0));
        _columnsPatient.put("precoDiferente", new TableInfo.Column("precoDiferente", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPatient = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPatient = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPatient = new TableInfo("Patient", _columnsPatient, _foreignKeysPatient, _indicesPatient);
        final TableInfo _existingPatient = TableInfo.read(_db, "Patient");
        if (! _infoPatient.equals(_existingPatient)) {
          throw new IllegalStateException("Migration didn't properly handle Patient(br.com.whitemartins.obc.model.Patient).\n"
                  + " Expected:\n" + _infoPatient + "\n"
                  + " Found:\n" + _existingPatient);
        }
        final HashMap<String, TableInfo.Column> _columnsInvoiceNumber = new HashMap<String, TableInfo.Column>(10);
        _columnsInvoiceNumber.put("numeroSerieEntrada", new TableInfo.Column("numeroSerieEntrada", "INTEGER", false, 0));
        _columnsInvoiceNumber.put("tipoNotaEntrada", new TableInfo.Column("tipoNotaEntrada", "TEXT", false, 0));
        _columnsInvoiceNumber.put("numeroNotaFiscalEntrada", new TableInfo.Column("numeroNotaFiscalEntrada", "INTEGER", false, 1));
        _columnsInvoiceNumber.put("numeroMaximoNFEntrada", new TableInfo.Column("numeroMaximoNFEntrada", "INTEGER", false, 0));
        _columnsInvoiceNumber.put("numeroSerieSaida", new TableInfo.Column("numeroSerieSaida", "INTEGER", false, 0));
        _columnsInvoiceNumber.put("tipoNotaSaida", new TableInfo.Column("tipoNotaSaida", "TEXT", false, 0));
        _columnsInvoiceNumber.put("nuemroNotaFiscalSaida", new TableInfo.Column("nuemroNotaFiscalSaida", "INTEGER", false, 0));
        _columnsInvoiceNumber.put("numeroMaximoNFSaida", new TableInfo.Column("numeroMaximoNFSaida", "INTEGER", false, 0));
        _columnsInvoiceNumber.put("numeroLinhasEntrada", new TableInfo.Column("numeroLinhasEntrada", "INTEGER", false, 0));
        _columnsInvoiceNumber.put("numeroLinhasSaida", new TableInfo.Column("numeroLinhasSaida", "INTEGER", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysInvoiceNumber = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesInvoiceNumber = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoInvoiceNumber = new TableInfo("InvoiceNumber", _columnsInvoiceNumber, _foreignKeysInvoiceNumber, _indicesInvoiceNumber);
        final TableInfo _existingInvoiceNumber = TableInfo.read(_db, "InvoiceNumber");
        if (! _infoInvoiceNumber.equals(_existingInvoiceNumber)) {
          throw new IllegalStateException("Migration didn't properly handle InvoiceNumber(br.com.whitemartins.obc.model.InvoiceNumber).\n"
                  + " Expected:\n" + _infoInvoiceNumber + "\n"
                  + " Found:\n" + _existingInvoiceNumber);
        }
        final HashMap<String, TableInfo.Column> _columnsPaymentCard = new HashMap<String, TableInfo.Column>(3);
        _columnsPaymentCard.put("cnpj", new TableInfo.Column("cnpj", "TEXT", true, 1));
        _columnsPaymentCard.put("nomeEmpresa", new TableInfo.Column("nomeEmpresa", "TEXT", false, 0));
        _columnsPaymentCard.put("tipoIntegracao", new TableInfo.Column("tipoIntegracao", "INTEGER", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPaymentCard = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPaymentCard = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPaymentCard = new TableInfo("PaymentCard", _columnsPaymentCard, _foreignKeysPaymentCard, _indicesPaymentCard);
        final TableInfo _existingPaymentCard = TableInfo.read(_db, "PaymentCard");
        if (! _infoPaymentCard.equals(_existingPaymentCard)) {
          throw new IllegalStateException("Migration didn't properly handle PaymentCard(br.com.whitemartins.obc.model.PaymentCard).\n"
                  + " Expected:\n" + _infoPaymentCard + "\n"
                  + " Found:\n" + _existingPaymentCard);
        }
        final HashMap<String, TableInfo.Column> _columnsTax = new HashMap<String, TableInfo.Column>(7);
        _columnsTax.put("condPagto", new TableInfo.Column("condPagto", "INTEGER", true, 1));
        _columnsTax.put("descPagto", new TableInfo.Column("descPagto", "TEXT", false, 0));
        _columnsTax.put("seqParcela", new TableInfo.Column("seqParcela", "INTEGER", false, 0));
        _columnsTax.put("dtEmissao", new TableInfo.Column("dtEmissao", "INTEGER", true, 2));
        _columnsTax.put("dtParcela", new TableInfo.Column("dtParcela", "INTEGER", true, 3));
        _columnsTax.put("percentual", new TableInfo.Column("percentual", "REAL", false, 0));
        _columnsTax.put("indCondPagto", new TableInfo.Column("indCondPagto", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTax = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTax = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTax = new TableInfo("Tax", _columnsTax, _foreignKeysTax, _indicesTax);
        final TableInfo _existingTax = TableInfo.read(_db, "Tax");
        if (! _infoTax.equals(_existingTax)) {
          throw new IllegalStateException("Migration didn't properly handle Tax(br.com.whitemartins.obc.model.Tax).\n"
                  + " Expected:\n" + _infoTax + "\n"
                  + " Found:\n" + _existingTax);
        }
        final HashMap<String, TableInfo.Column> _columnsCode = new HashMap<String, TableInfo.Column>(15);
        _columnsCode.put("id", new TableInfo.Column("id", "INTEGER", false, 1));
        _columnsCode.put("tipoCodigo", new TableInfo.Column("tipoCodigo", "TEXT", false, 0));
        _columnsCode.put("codigo", new TableInfo.Column("codigo", "INTEGER", false, 0));
        _columnsCode.put("descricao", new TableInfo.Column("descricao", "TEXT", false, 0));
        _columnsCode.put("indRastreabilidade", new TableInfo.Column("indRastreabilidade", "TEXT", false, 0));
        _columnsCode.put("cfop3", new TableInfo.Column("cfop3", "INTEGER", false, 0));
        _columnsCode.put("sufixo", new TableInfo.Column("sufixo", "TEXT", false, 0));
        _columnsCode.put("cfop4", new TableInfo.Column("cfop4", "INTEGER", false, 0));
        _columnsCode.put("situacaoTributariaPis", new TableInfo.Column("situacaoTributariaPis", "INTEGER", false, 0));
        _columnsCode.put("cstPis", new TableInfo.Column("cstPis", "TEXT", false, 0));
        _columnsCode.put("situacaoTributariaCofins", new TableInfo.Column("situacaoTributariaCofins", "INTEGER", false, 0));
        _columnsCode.put("cstCofins", new TableInfo.Column("cstCofins", "TEXT", false, 0));
        _columnsCode.put("cstIpiZero", new TableInfo.Column("cstIpiZero", "TEXT", false, 0));
        _columnsCode.put("cstIpiTributado", new TableInfo.Column("cstIpiTributado", "TEXT", false, 0));
        _columnsCode.put("cstIpiIsento", new TableInfo.Column("cstIpiIsento", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCode = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCode = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCode = new TableInfo("Code", _columnsCode, _foreignKeysCode, _indicesCode);
        final TableInfo _existingCode = TableInfo.read(_db, "Code");
        if (! _infoCode.equals(_existingCode)) {
          throw new IllegalStateException("Migration didn't properly handle Code(br.com.whitemartins.obc.model.Code).\n"
                  + " Expected:\n" + _infoCode + "\n"
                  + " Found:\n" + _existingCode);
        }
        final HashMap<String, TableInfo.Column> _columnsQuestions = new HashMap<String, TableInfo.Column>(13);
        _columnsQuestions.put("numeroPergunta", new TableInfo.Column("numeroPergunta", "INTEGER", false, 1));
        _columnsQuestions.put("pergunta", new TableInfo.Column("pergunta", "TEXT", false, 0));
        _columnsQuestions.put("numeroResposta1", new TableInfo.Column("numeroResposta1", "INTEGER", false, 0));
        _columnsQuestions.put("resposta1", new TableInfo.Column("resposta1", "TEXT", false, 0));
        _columnsQuestions.put("numeroResposta2", new TableInfo.Column("numeroResposta2", "INTEGER", false, 0));
        _columnsQuestions.put("resposta2", new TableInfo.Column("resposta2", "TEXT", false, 0));
        _columnsQuestions.put("numeroResposta3", new TableInfo.Column("numeroResposta3", "INTEGER", false, 0));
        _columnsQuestions.put("resposta3", new TableInfo.Column("resposta3", "TEXT", false, 0));
        _columnsQuestions.put("numeroResposta4", new TableInfo.Column("numeroResposta4", "INTEGER", false, 0));
        _columnsQuestions.put("resposta4", new TableInfo.Column("resposta4", "TEXT", false, 0));
        _columnsQuestions.put("numeroResposta5", new TableInfo.Column("numeroResposta5", "INTEGER", false, 0));
        _columnsQuestions.put("resposta5", new TableInfo.Column("resposta5", "TEXT", false, 0));
        _columnsQuestions.put("categorizar", new TableInfo.Column("categorizar", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysQuestions = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesQuestions = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoQuestions = new TableInfo("Questions", _columnsQuestions, _foreignKeysQuestions, _indicesQuestions);
        final TableInfo _existingQuestions = TableInfo.read(_db, "Questions");
        if (! _infoQuestions.equals(_existingQuestions)) {
          throw new IllegalStateException("Migration didn't properly handle Questions(br.com.whitemartins.obc.model.Questions).\n"
                  + " Expected:\n" + _infoQuestions + "\n"
                  + " Found:\n" + _existingQuestions);
        }
        final HashMap<String, TableInfo.Column> _columnsConversaoLQ = new HashMap<String, TableInfo.Column>(6);
        _columnsConversaoLQ.put("numeroWM", new TableInfo.Column("numeroWM", "INTEGER", false, 0));
        _columnsConversaoLQ.put("cdJDECliente", new TableInfo.Column("cdJDECliente", "INTEGER", true, 1));
        _columnsConversaoLQ.put("numeroSerieTanque", new TableInfo.Column("numeroSerieTanque", "TEXT", true, 2));
        _columnsConversaoLQ.put("capacidadeKG", new TableInfo.Column("capacidadeKG", "REAL", false, 0));
        _columnsConversaoLQ.put("capacidadePol", new TableInfo.Column("capacidadePol", "REAL", false, 0));
        _columnsConversaoLQ.put("fatorConversao", new TableInfo.Column("fatorConversao", "REAL", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysConversaoLQ = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesConversaoLQ = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoConversaoLQ = new TableInfo("ConversaoLQ", _columnsConversaoLQ, _foreignKeysConversaoLQ, _indicesConversaoLQ);
        final TableInfo _existingConversaoLQ = TableInfo.read(_db, "ConversaoLQ");
        if (! _infoConversaoLQ.equals(_existingConversaoLQ)) {
          throw new IllegalStateException("Migration didn't properly handle ConversaoLQ(br.com.whitemartins.obc.model.ConversaoLQ).\n"
                  + " Expected:\n" + _infoConversaoLQ + "\n"
                  + " Found:\n" + _existingConversaoLQ);
        }
        final HashMap<String, TableInfo.Column> _columnsMessage = new HashMap<String, TableInfo.Column>(4);
        _columnsMessage.put("id", new TableInfo.Column("id", "INTEGER", false, 1));
        _columnsMessage.put("tipoMensagem", new TableInfo.Column("tipoMensagem", "TEXT", true, 0));
        _columnsMessage.put("cdCustomer", new TableInfo.Column("cdCustomer", "INTEGER", true, 0));
        _columnsMessage.put("mensagem", new TableInfo.Column("mensagem", "TEXT", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMessage = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMessage = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMessage = new TableInfo("Message", _columnsMessage, _foreignKeysMessage, _indicesMessage);
        final TableInfo _existingMessage = TableInfo.read(_db, "Message");
        if (! _infoMessage.equals(_existingMessage)) {
          throw new IllegalStateException("Migration didn't properly handle Message(br.com.whitemartins.obc.model.Message).\n"
                  + " Expected:\n" + _infoMessage + "\n"
                  + " Found:\n" + _existingMessage);
        }
        final HashMap<String, TableInfo.Column> _columnsTravel = new HashMap<String, TableInfo.Column>(4);
        _columnsTravel.put("numeroViagem", new TableInfo.Column("numeroViagem", "INTEGER", false, 1));
        _columnsTravel.put("dataViagem", new TableInfo.Column("dataViagem", "INTEGER", false, 0));
        _columnsTravel.put("sequencia", new TableInfo.Column("sequencia", "INTEGER", false, 0));
        _columnsTravel.put("indViagemUsada", new TableInfo.Column("indViagemUsada", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTravel = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTravel = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTravel = new TableInfo("Travel", _columnsTravel, _foreignKeysTravel, _indicesTravel);
        final TableInfo _existingTravel = TableInfo.read(_db, "Travel");
        if (! _infoTravel.equals(_existingTravel)) {
          throw new IllegalStateException("Migration didn't properly handle Travel(br.com.whitemartins.obc.model.Travel).\n"
                  + " Expected:\n" + _infoTravel + "\n"
                  + " Found:\n" + _existingTravel);
        }
        final HashMap<String, TableInfo.Column> _columnsPreOrder = new HashMap<String, TableInfo.Column>(9);
        _columnsPreOrder.put("cdPreOrder", new TableInfo.Column("cdPreOrder", "INTEGER", true, 1));
        _columnsPreOrder.put("dataEmissaoNota", new TableInfo.Column("dataEmissaoNota", "INTEGER", false, 0));
        _columnsPreOrder.put("cdCustomer", new TableInfo.Column("cdCustomer", "INTEGER", true, 2));
        _columnsPreOrder.put("numeroNotaOrigem", new TableInfo.Column("numeroNotaOrigem", "TEXT", false, 0));
        _columnsPreOrder.put("cdItem", new TableInfo.Column("cdItem", "INTEGER", true, 3));
        _columnsPreOrder.put("capacidadeProduto", new TableInfo.Column("capacidadeProduto", "REAL", false, 0));
        _columnsPreOrder.put("saldo", new TableInfo.Column("saldo", "REAL", false, 0));
        _columnsPreOrder.put("preco", new TableInfo.Column("preco", "REAL", false, 0));
        _columnsPreOrder.put("ajusteICMS", new TableInfo.Column("ajusteICMS", "REAL", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPreOrder = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPreOrder = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPreOrder = new TableInfo("PreOrder", _columnsPreOrder, _foreignKeysPreOrder, _indicesPreOrder);
        final TableInfo _existingPreOrder = TableInfo.read(_db, "PreOrder");
        if (! _infoPreOrder.equals(_existingPreOrder)) {
          throw new IllegalStateException("Migration didn't properly handle PreOrder(br.com.whitemartins.obc.model.PreOrder).\n"
                  + " Expected:\n" + _infoPreOrder + "\n"
                  + " Found:\n" + _existingPreOrder);
        }
        final HashMap<String, TableInfo.Column> _columnsGeneral = new HashMap<String, TableInfo.Column>(9);
        _columnsGeneral.put("id", new TableInfo.Column("id", "INTEGER", false, 1));
        _columnsGeneral.put("numeroViagem", new TableInfo.Column("numeroViagem", "INTEGER", false, 0));
        _columnsGeneral.put("numeroNotaEntrada", new TableInfo.Column("numeroNotaEntrada", "INTEGER", false, 0));
        _columnsGeneral.put("serieNotaEntrada", new TableInfo.Column("serieNotaEntrada", "INTEGER", false, 0));
        _columnsGeneral.put("numeroNotaSaida", new TableInfo.Column("numeroNotaSaida", "INTEGER", false, 0));
        _columnsGeneral.put("serieNotaSaida", new TableInfo.Column("serieNotaSaida", "INTEGER", false, 0));
        _columnsGeneral.put("contadorSenha", new TableInfo.Column("contadorSenha", "INTEGER", false, 0));
        _columnsGeneral.put("flIndOriginalRefeita", new TableInfo.Column("flIndOriginalRefeita", "TEXT", false, 0));
        _columnsGeneral.put("beginTravelType", new TableInfo.Column("beginTravelType", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysGeneral = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesGeneral = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoGeneral = new TableInfo("General", _columnsGeneral, _foreignKeysGeneral, _indicesGeneral);
        final TableInfo _existingGeneral = TableInfo.read(_db, "General");
        if (! _infoGeneral.equals(_existingGeneral)) {
          throw new IllegalStateException("Migration didn't properly handle General(br.com.whitemartins.obc.model.General).\n"
                  + " Expected:\n" + _infoGeneral + "\n"
                  + " Found:\n" + _existingGeneral);
        }
        final HashMap<String, TableInfo.Column> _columnsRastreabilidade = new HashMap<String, TableInfo.Column>(13);
        _columnsRastreabilidade.put("id", new TableInfo.Column("id", "INTEGER", false, 1));
        _columnsRastreabilidade.put("cdFilial", new TableInfo.Column("cdFilial", "TEXT", false, 0));
        _columnsRastreabilidade.put("cdCilindro", new TableInfo.Column("cdCilindro", "TEXT", false, 0));
        _columnsRastreabilidade.put("numeroLote", new TableInfo.Column("numeroLote", "TEXT", false, 0));
        _columnsRastreabilidade.put("idNota", new TableInfo.Column("idNota", "INTEGER", false, 0));
        _columnsRastreabilidade.put("numeroNota", new TableInfo.Column("numeroNota", "INTEGER", false, 0));
        _columnsRastreabilidade.put("cdItem", new TableInfo.Column("cdItem", "INTEGER", false, 0));
        _columnsRastreabilidade.put("numeroVeiculo", new TableInfo.Column("numeroVeiculo", "TEXT", false, 0));
        _columnsRastreabilidade.put("numeroViagem", new TableInfo.Column("numeroViagem", "INTEGER", false, 0));
        _columnsRastreabilidade.put("dataViagem", new TableInfo.Column("dataViagem", "INTEGER", false, 0));
        _columnsRastreabilidade.put("capacidadeItem", new TableInfo.Column("capacidadeItem", "REAL", false, 0));
        _columnsRastreabilidade.put("cdCustomer", new TableInfo.Column("cdCustomer", "INTEGER", false, 0));
        _columnsRastreabilidade.put("liberado", new TableInfo.Column("liberado", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysRastreabilidade = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesRastreabilidade = new HashSet<TableInfo.Index>(1);
        _indicesRastreabilidade.add(new TableInfo.Index("uk_cilindro", true, Arrays.asList("idNota","cdCilindro","cdItem","capacidadeItem")));
        final TableInfo _infoRastreabilidade = new TableInfo("Rastreabilidade", _columnsRastreabilidade, _foreignKeysRastreabilidade, _indicesRastreabilidade);
        final TableInfo _existingRastreabilidade = TableInfo.read(_db, "Rastreabilidade");
        if (! _infoRastreabilidade.equals(_existingRastreabilidade)) {
          throw new IllegalStateException("Migration didn't properly handle Rastreabilidade(br.com.whitemartins.obc.model.Rastreabilidade).\n"
                  + " Expected:\n" + _infoRastreabilidade + "\n"
                  + " Found:\n" + _existingRastreabilidade);
        }
        final HashMap<String, TableInfo.Column> _columnsInvoice = new HashMap<String, TableInfo.Column>(84);
        _columnsInvoice.put("id", new TableInfo.Column("id", "INTEGER", false, 1));
        _columnsInvoice.put("numero", new TableInfo.Column("numero", "INTEGER", false, 0));
        _columnsInvoice.put("serie", new TableInfo.Column("serie", "INTEGER", false, 0));
        _columnsInvoice.put("numeroNotaVOR", new TableInfo.Column("numeroNotaVOR", "INTEGER", false, 0));
        _columnsInvoice.put("serieNotaVOR", new TableInfo.Column("serieNotaVOR", "INTEGER", false, 0));
        _columnsInvoice.put("cdPreOrdem", new TableInfo.Column("cdPreOrdem", "TEXT", false, 0));
        _columnsInvoice.put("numeroFutEntrega", new TableInfo.Column("numeroFutEntrega", "TEXT", false, 0));
        _columnsInvoice.put("cdFiscal", new TableInfo.Column("cdFiscal", "INTEGER", false, 0));
        _columnsInvoice.put("cnpjCpfDestino", new TableInfo.Column("cnpjCpfDestino", "TEXT", false, 0));
        _columnsInvoice.put("cnpjCpfTransp", new TableInfo.Column("cnpjCpfTransp", "TEXT", false, 0));
        _columnsInvoice.put("tipoNota", new TableInfo.Column("tipoNota", "TEXT", false, 0));
        _columnsInvoice.put("classeContribuinte", new TableInfo.Column("classeContribuinte", "INTEGER", false, 0));
        _columnsInvoice.put("dataViagemPrincial", new TableInfo.Column("dataViagemPrincial", "TEXT", false, 0));
        _columnsInvoice.put("numeroViagem", new TableInfo.Column("numeroViagem", "TEXT", false, 0));
        _columnsInvoice.put("dataViagem", new TableInfo.Column("dataViagem", "TEXT", false, 0));
        _columnsInvoice.put("nomeOperacao", new TableInfo.Column("nomeOperacao", "TEXT", false, 0));
        _columnsInvoice.put("dataEmissao", new TableInfo.Column("dataEmissao", "INTEGER", false, 0));
        _columnsInvoice.put("dataMovimento", new TableInfo.Column("dataMovimento", "INTEGER", false, 0));
        _columnsInvoice.put("dataVencimento", new TableInfo.Column("dataVencimento", "INTEGER", false, 0));
        _columnsInvoice.put("valorTotal", new TableInfo.Column("valorTotal", "REAL", false, 0));
        _columnsInvoice.put("valorLiquido", new TableInfo.Column("valorLiquido", "REAL", false, 0));
        _columnsInvoice.put("valorTotalProduto", new TableInfo.Column("valorTotalProduto", "REAL", false, 0));
        _columnsInvoice.put("valorFrete", new TableInfo.Column("valorFrete", "REAL", false, 0));
        _columnsInvoice.put("valorDespAcessorias", new TableInfo.Column("valorDespAcessorias", "REAL", false, 0));
        _columnsInvoice.put("valorDinheiro", new TableInfo.Column("valorDinheiro", "REAL", false, 0));
        _columnsInvoice.put("valorTroco", new TableInfo.Column("valorTroco", "REAL", false, 0));
        _columnsInvoice.put("valorFatura", new TableInfo.Column("valorFatura", "REAL", false, 0));
        _columnsInvoice.put("valorDebito", new TableInfo.Column("valorDebito", "REAL", false, 0));
        _columnsInvoice.put("valorCredito", new TableInfo.Column("valorCredito", "REAL", false, 0));
        _columnsInvoice.put("valorCheque", new TableInfo.Column("valorCheque", "REAL", false, 0));
        _columnsInvoice.put("numeroCheque", new TableInfo.Column("numeroCheque", "TEXT", false, 0));
        _columnsInvoice.put("ufVeiculo", new TableInfo.Column("ufVeiculo", "TEXT", false, 0));
        _columnsInvoice.put("placaVeiculo", new TableInfo.Column("placaVeiculo", "TEXT", false, 0));
        _columnsInvoice.put("numeroVeiculo", new TableInfo.Column("numeroVeiculo", "TEXT", false, 0));
        _columnsInvoice.put("modalidadeFrete", new TableInfo.Column("modalidadeFrete", "INTEGER", false, 0));
        _columnsInvoice.put("nomeEspecVolume", new TableInfo.Column("nomeEspecVolume", "TEXT", false, 0));
        _columnsInvoice.put("nomeMarca", new TableInfo.Column("nomeMarca", "TEXT", false, 0));
        _columnsInvoice.put("qtdVolumes", new TableInfo.Column("qtdVolumes", "INTEGER", false, 0));
        _columnsInvoice.put("volumeCapacidade", new TableInfo.Column("volumeCapacidade", "REAL", false, 0));
        _columnsInvoice.put("volumeCapacidadeReport", new TableInfo.Column("volumeCapacidadeReport", "REAL", false, 0));
        _columnsInvoice.put("pesoBruto", new TableInfo.Column("pesoBruto", "REAL", false, 0));
        _columnsInvoice.put("pesoLiquido", new TableInfo.Column("pesoLiquido", "REAL", false, 0));
        _columnsInvoice.put("tipoPedido", new TableInfo.Column("tipoPedido", "TEXT", false, 0));
        _columnsInvoice.put("cdCustomer", new TableInfo.Column("cdCustomer", "INTEGER", false, 0));
        _columnsInvoice.put("ativaTipoPagto", new TableInfo.Column("ativaTipoPagto", "TEXT", false, 0));
        _columnsInvoice.put("stepEmissao", new TableInfo.Column("stepEmissao", "INTEGER", false, 0));
        _columnsInvoice.put("chave", new TableInfo.Column("chave", "TEXT", false, 0));
        _columnsInvoice.put("protocolo", new TableInfo.Column("protocolo", "TEXT", false, 0));
        _columnsInvoice.put("cdMovimento", new TableInfo.Column("cdMovimento", "TEXT", false, 0));
        _columnsInvoice.put("condicaoPagamento", new TableInfo.Column("condicaoPagamento", "TEXT", false, 0));
        _columnsInvoice.put("aliquotaIcms", new TableInfo.Column("aliquotaIcms", "REAL", false, 0));
        _columnsInvoice.put("valorDescontoIcms", new TableInfo.Column("valorDescontoIcms", "REAL", false, 0));
        _columnsInvoice.put("valorIcms", new TableInfo.Column("valorIcms", "REAL", false, 0));
        _columnsInvoice.put("baseCalculoIcms", new TableInfo.Column("baseCalculoIcms", "REAL", false, 0));
        _columnsInvoice.put("situacaoTributariaIcms", new TableInfo.Column("situacaoTributariaIcms", "INTEGER", false, 0));
        _columnsInvoice.put("valorIpi", new TableInfo.Column("valorIpi", "REAL", false, 0));
        _columnsInvoice.put("baseCalculoIpi", new TableInfo.Column("baseCalculoIpi", "REAL", false, 0));
        _columnsInvoice.put("situacaoTributariaIpi", new TableInfo.Column("situacaoTributariaIpi", "INTEGER", false, 0));
        _columnsInvoice.put("flNovoFaturamento", new TableInfo.Column("flNovoFaturamento", "TEXT", false, 0));
        _columnsInvoice.put("cdOperadora", new TableInfo.Column("cdOperadora", "INTEGER", false, 0));
        _columnsInvoice.put("flPaciente", new TableInfo.Column("flPaciente", "TEXT", false, 0));
        _columnsInvoice.put("cdCustomerService", new TableInfo.Column("cdCustomerService", "INTEGER", false, 0));
        _columnsInvoice.put("nomeAssinadorCec", new TableInfo.Column("nomeAssinadorCec", "TEXT", false, 0));
        _columnsInvoice.put("rgAssinadorCec", new TableInfo.Column("rgAssinadorCec", "TEXT", false, 0));
        _columnsInvoice.put("tipoMovimentoIntegracao", new TableInfo.Column("tipoMovimentoIntegracao", "INTEGER", false, 0));
        _columnsInvoice.put("semPagto", new TableInfo.Column("semPagto", "TEXT", false, 0));
        _columnsInvoice.put("statusGravacaoJde", new TableInfo.Column("statusGravacaoJde", "INTEGER", false, 0));
        _columnsInvoice.put("mensagemGravacaoJde", new TableInfo.Column("mensagemGravacaoJde", "TEXT", false, 0));
        _columnsInvoice.put("tipoTransacao", new TableInfo.Column("tipoTransacao", "INTEGER", false, 0));
        _columnsInvoice.put("status", new TableInfo.Column("status", "INTEGER", false, 0));
        _columnsInvoice.put("statusContingencia", new TableInfo.Column("statusContingencia", "TEXT", false, 0));
        _columnsInvoice.put("mensagemContingencia", new TableInfo.Column("mensagemContingencia", "TEXT", false, 0));
        _columnsInvoice.put("statusCec", new TableInfo.Column("statusCec", "INTEGER", false, 0));
        _columnsInvoice.put("nomeTransacao", new TableInfo.Column("nomeTransacao", "TEXT", false, 0));
        _columnsInvoice.put("statusImpressaoCec", new TableInfo.Column("statusImpressaoCec", "INTEGER", false, 0));
        _columnsInvoice.put("nomeFormaImpressaoCec", new TableInfo.Column("nomeFormaImpressaoCec", "TEXT", false, 0));
        _columnsInvoice.put("nomeStatus", new TableInfo.Column("nomeStatus", "TEXT", false, 0));
        _columnsInvoice.put("nomeStatusImpressaoCec", new TableInfo.Column("nomeStatusImpressaoCec", "TEXT", false, 0));
        _columnsInvoice.put("flPrecoAlterado", new TableInfo.Column("flPrecoAlterado", "TEXT", false, 0));
        _columnsInvoice.put("nomeTipoPagamento", new TableInfo.Column("nomeTipoPagamento", "TEXT", false, 0));
        _columnsInvoice.put("cdMotivo", new TableInfo.Column("cdMotivo", "TEXT", false, 0));
        _columnsInvoice.put("dsMotivo", new TableInfo.Column("dsMotivo", "TEXT", false, 0));
        _columnsInvoice.put("statusNfeImp", new TableInfo.Column("statusNfeImp", "TEXT", false, 0));
        _columnsInvoice.put("statusReportFile", new TableInfo.Column("statusReportFile", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysInvoice = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesInvoice = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoInvoice = new TableInfo("Invoice", _columnsInvoice, _foreignKeysInvoice, _indicesInvoice);
        final TableInfo _existingInvoice = TableInfo.read(_db, "Invoice");
        if (! _infoInvoice.equals(_existingInvoice)) {
          throw new IllegalStateException("Migration didn't properly handle Invoice(br.com.whitemartins.obc.model.Invoice).\n"
                  + " Expected:\n" + _infoInvoice + "\n"
                  + " Found:\n" + _existingInvoice);
        }
        final HashMap<String, TableInfo.Column> _columnsInvoiceItem = new HashMap<String, TableInfo.Column>(66);
        _columnsInvoiceItem.put("idNota", new TableInfo.Column("idNota", "INTEGER", true, 1));
        _columnsInvoiceItem.put("numeroNota", new TableInfo.Column("numeroNota", "INTEGER", false, 0));
        _columnsInvoiceItem.put("serieNota", new TableInfo.Column("serieNota", "INTEGER", false, 0));
        _columnsInvoiceItem.put("cfop", new TableInfo.Column("cfop", "INTEGER", false, 0));
        _columnsInvoiceItem.put("seqItem", new TableInfo.Column("seqItem", "INTEGER", false, 0));
        _columnsInvoiceItem.put("cdItem", new TableInfo.Column("cdItem", "INTEGER", true, 2));
        _columnsInvoiceItem.put("capacidade", new TableInfo.Column("capacidade", "REAL", true, 3));
        _columnsInvoiceItem.put("nomeItem", new TableInfo.Column("nomeItem", "TEXT", false, 0));
        _columnsInvoiceItem.put("qtdItem", new TableInfo.Column("qtdItem", "REAL", false, 0));
        _columnsInvoiceItem.put("volume", new TableInfo.Column("volume", "REAL", false, 0));
        _columnsInvoiceItem.put("unidadeMedida", new TableInfo.Column("unidadeMedida", "TEXT", false, 0));
        _columnsInvoiceItem.put("naturezaOperacao", new TableInfo.Column("naturezaOperacao", "TEXT", false, 0));
        _columnsInvoiceItem.put("nomeNaturezaOperacao", new TableInfo.Column("nomeNaturezaOperacao", "TEXT", false, 0));
        _columnsInvoiceItem.put("classifFiscal", new TableInfo.Column("classifFiscal", "INTEGER", false, 0));
        _columnsInvoiceItem.put("cstAIcms", new TableInfo.Column("cstAIcms", "TEXT", false, 0));
        _columnsInvoiceItem.put("cstBIcms", new TableInfo.Column("cstBIcms", "TEXT", false, 0));
        _columnsInvoiceItem.put("cstIpi", new TableInfo.Column("cstIpi", "TEXT", false, 0));
        _columnsInvoiceItem.put("cstPis", new TableInfo.Column("cstPis", "TEXT", false, 0));
        _columnsInvoiceItem.put("cstCofins", new TableInfo.Column("cstCofins", "TEXT", false, 0));
        _columnsInvoiceItem.put("valorTotal", new TableInfo.Column("valorTotal", "REAL", false, 0));
        _columnsInvoiceItem.put("valorBaseIcms", new TableInfo.Column("valorBaseIcms", "REAL", false, 0));
        _columnsInvoiceItem.put("valorBaseReduzidaIcms", new TableInfo.Column("valorBaseReduzidaIcms", "REAL", false, 0));
        _columnsInvoiceItem.put("valorIcms", new TableInfo.Column("valorIcms", "REAL", false, 0));
        _columnsInvoiceItem.put("valorDebitoIcms", new TableInfo.Column("valorDebitoIcms", "REAL", false, 0));
        _columnsInvoiceItem.put("valorCreditoIcms", new TableInfo.Column("valorCreditoIcms", "REAL", false, 0));
        _columnsInvoiceItem.put("valorBaseIcmsSt", new TableInfo.Column("valorBaseIcmsSt", "REAL", false, 0));
        _columnsInvoiceItem.put("valorIcmsSt", new TableInfo.Column("valorIcmsSt", "REAL", false, 0));
        _columnsInvoiceItem.put("valorBaseIpi", new TableInfo.Column("valorBaseIpi", "REAL", false, 0));
        _columnsInvoiceItem.put("valorIpi", new TableInfo.Column("valorIpi", "REAL", false, 0));
        _columnsInvoiceItem.put("valorDebitoIpi", new TableInfo.Column("valorDebitoIpi", "REAL", false, 0));
        _columnsInvoiceItem.put("valorCreditoIpi", new TableInfo.Column("valorCreditoIpi", "REAL", false, 0));
        _columnsInvoiceItem.put("valorBasePis", new TableInfo.Column("valorBasePis", "REAL", false, 0));
        _columnsInvoiceItem.put("valorDebitoPis", new TableInfo.Column("valorDebitoPis", "REAL", false, 0));
        _columnsInvoiceItem.put("valorBaseCreditoPis", new TableInfo.Column("valorBaseCreditoPis", "REAL", false, 0));
        _columnsInvoiceItem.put("valorCreditoPis", new TableInfo.Column("valorCreditoPis", "REAL", false, 0));
        _columnsInvoiceItem.put("valorBaseCofins", new TableInfo.Column("valorBaseCofins", "REAL", false, 0));
        _columnsInvoiceItem.put("valorDebitoCofins", new TableInfo.Column("valorDebitoCofins", "REAL", false, 0));
        _columnsInvoiceItem.put("valorBaseCreditoCofins", new TableInfo.Column("valorBaseCreditoCofins", "REAL", false, 0));
        _columnsInvoiceItem.put("valorCreditoCofins", new TableInfo.Column("valorCreditoCofins", "REAL", false, 0));
        _columnsInvoiceItem.put("aliquotaIcms", new TableInfo.Column("aliquotaIcms", "REAL", false, 0));
        _columnsInvoiceItem.put("aliquotaIpi", new TableInfo.Column("aliquotaIpi", "REAL", false, 0));
        _columnsInvoiceItem.put("aliquotaPis", new TableInfo.Column("aliquotaPis", "REAL", false, 0));
        _columnsInvoiceItem.put("aliquotaCofins", new TableInfo.Column("aliquotaCofins", "REAL", false, 0));
        _columnsInvoiceItem.put("tipoIcms", new TableInfo.Column("tipoIcms", "INTEGER", false, 0));
        _columnsInvoiceItem.put("tipoIpi", new TableInfo.Column("tipoIpi", "INTEGER", false, 0));
        _columnsInvoiceItem.put("tipoPis", new TableInfo.Column("tipoPis", "INTEGER", false, 0));
        _columnsInvoiceItem.put("tipoCofins", new TableInfo.Column("tipoCofins", "INTEGER", false, 0));
        _columnsInvoiceItem.put("valorTotalFrete", new TableInfo.Column("valorTotalFrete", "REAL", false, 0));
        _columnsInvoiceItem.put("valorTotalSeguro", new TableInfo.Column("valorTotalSeguro", "REAL", false, 0));
        _columnsInvoiceItem.put("valorDescontoIcms", new TableInfo.Column("valorDescontoIcms", "REAL", false, 0));
        _columnsInvoiceItem.put("valorUnitario", new TableInfo.Column("valorUnitario", "REAL", false, 0));
        _columnsInvoiceItem.put("valorDespesasAcessorias", new TableInfo.Column("valorDespesasAcessorias", "REAL", false, 0));
        _columnsInvoiceItem.put("flPrecoAlterado", new TableInfo.Column("flPrecoAlterado", "TEXT", false, 0));
        _columnsInvoiceItem.put("valorPrecoUnitarioOriginal", new TableInfo.Column("valorPrecoUnitarioOriginal", "REAL", false, 0));
        _columnsInvoiceItem.put("infCilPP", new TableInfo.Column("infCilPP", "TEXT", false, 0));
        _columnsInvoiceItem.put("condicaoPagamento", new TableInfo.Column("condicaoPagamento", "TEXT", false, 0));
        _columnsInvoiceItem.put("cdMovimento", new TableInfo.Column("cdMovimento", "TEXT", false, 0));
        _columnsInvoiceItem.put("returnType", new TableInfo.Column("returnType", "INTEGER", false, 0));
        _columnsInvoiceItem.put("returnCode", new TableInfo.Column("returnCode", "TEXT", false, 0));
        _columnsInvoiceItem.put("quantidadeCilindroVendida", new TableInfo.Column("quantidadeCilindroVendida", "REAL", false, 0));
        _columnsInvoiceItem.put("quantidadeCilindroPedida", new TableInfo.Column("quantidadeCilindroPedida", "REAL", false, 0));
        _columnsInvoiceItem.put("pedidoCustomer", new TableInfo.Column("pedidoCustomer", "TEXT", false, 0));
        _columnsInvoiceItem.put("itemPedidoCustomer", new TableInfo.Column("itemPedidoCustomer", "TEXT", false, 0));
        _columnsInvoiceItem.put("tipoFaturamento", new TableInfo.Column("tipoFaturamento", "TEXT", false, 0));
        _columnsInvoiceItem.put("flAssistenciaTecnica", new TableInfo.Column("flAssistenciaTecnica", "TEXT", false, 0));
        _columnsInvoiceItem.put("tipoItem", new TableInfo.Column("tipoItem", "INTEGER", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysInvoiceItem = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesInvoiceItem = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoInvoiceItem = new TableInfo("InvoiceItem", _columnsInvoiceItem, _foreignKeysInvoiceItem, _indicesInvoiceItem);
        final TableInfo _existingInvoiceItem = TableInfo.read(_db, "InvoiceItem");
        if (! _infoInvoiceItem.equals(_existingInvoiceItem)) {
          throw new IllegalStateException("Migration didn't properly handle InvoiceItem(br.com.whitemartins.obc.model.InvoiceItem).\n"
                  + " Expected:\n" + _infoInvoiceItem + "\n"
                  + " Found:\n" + _existingInvoiceItem);
        }
        final HashMap<String, TableInfo.Column> _columnsInvoiceMessage = new HashMap<String, TableInfo.Column>(12);
        _columnsInvoiceMessage.put("idNota", new TableInfo.Column("idNota", "INTEGER", true, 1));
        _columnsInvoiceMessage.put("tipoTransacao", new TableInfo.Column("tipoTransacao", "INTEGER", false, 0));
        _columnsInvoiceMessage.put("numeroNota", new TableInfo.Column("numeroNota", "INTEGER", false, 0));
        _columnsInvoiceMessage.put("serieNota", new TableInfo.Column("serieNota", "INTEGER", false, 0));
        _columnsInvoiceMessage.put("cdCustomer", new TableInfo.Column("cdCustomer", "INTEGER", true, 2));
        _columnsInvoiceMessage.put("cdRota", new TableInfo.Column("cdRota", "INTEGER", false, 0));
        _columnsInvoiceMessage.put("numeroFutEntrega", new TableInfo.Column("numeroFutEntrega", "TEXT", false, 0));
        _columnsInvoiceMessage.put("dataEmissao", new TableInfo.Column("dataEmissao", "INTEGER", false, 0));
        _columnsInvoiceMessage.put("sequencia", new TableInfo.Column("sequencia", "INTEGER", true, 3));
        _columnsInvoiceMessage.put("linha", new TableInfo.Column("linha", "INTEGER", true, 4));
        _columnsInvoiceMessage.put("mensagem", new TableInfo.Column("mensagem", "TEXT", false, 0));
        _columnsInvoiceMessage.put("mostrarMsg", new TableInfo.Column("mostrarMsg", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysInvoiceMessage = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesInvoiceMessage = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoInvoiceMessage = new TableInfo("InvoiceMessage", _columnsInvoiceMessage, _foreignKeysInvoiceMessage, _indicesInvoiceMessage);
        final TableInfo _existingInvoiceMessage = TableInfo.read(_db, "InvoiceMessage");
        if (! _infoInvoiceMessage.equals(_existingInvoiceMessage)) {
          throw new IllegalStateException("Migration didn't properly handle InvoiceMessage(br.com.whitemartins.obc.model.InvoiceMessage).\n"
                  + " Expected:\n" + _infoInvoiceMessage + "\n"
                  + " Found:\n" + _existingInvoiceMessage);
        }
        final HashMap<String, TableInfo.Column> _columnsSearch = new HashMap<String, TableInfo.Column>(9);
        _columnsSearch.put("id", new TableInfo.Column("id", "INTEGER", false, 1));
        _columnsSearch.put("cdCustomer", new TableInfo.Column("cdCustomer", "INTEGER", false, 0));
        _columnsSearch.put("dtPesquisa", new TableInfo.Column("dtPesquisa", "INTEGER", false, 0));
        _columnsSearch.put("motorista", new TableInfo.Column("motorista", "TEXT", false, 0));
        _columnsSearch.put("contato", new TableInfo.Column("contato", "TEXT", false, 0));
        _columnsSearch.put("cargo", new TableInfo.Column("cargo", "TEXT", false, 0));
        _columnsSearch.put("telefone", new TableInfo.Column("telefone", "TEXT", false, 0));
        _columnsSearch.put("rejeitada", new TableInfo.Column("rejeitada", "TEXT", false, 0));
        _columnsSearch.put("idNota", new TableInfo.Column("idNota", "INTEGER", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSearch = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSearch = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSearch = new TableInfo("Search", _columnsSearch, _foreignKeysSearch, _indicesSearch);
        final TableInfo _existingSearch = TableInfo.read(_db, "Search");
        if (! _infoSearch.equals(_existingSearch)) {
          throw new IllegalStateException("Migration didn't properly handle Search(br.com.whitemartins.obc.model.Search).\n"
                  + " Expected:\n" + _infoSearch + "\n"
                  + " Found:\n" + _existingSearch);
        }
        final HashMap<String, TableInfo.Column> _columnsAnswer = new HashMap<String, TableInfo.Column>(5);
        _columnsAnswer.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        _columnsAnswer.put("idPesquisa", new TableInfo.Column("idPesquisa", "INTEGER", true, 2));
        _columnsAnswer.put("pergunrta", new TableInfo.Column("pergunrta", "TEXT", false, 0));
        _columnsAnswer.put("resposta", new TableInfo.Column("resposta", "TEXT", false, 0));
        _columnsAnswer.put("categorizada", new TableInfo.Column("categorizada", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAnswer = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAnswer = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAnswer = new TableInfo("Answer", _columnsAnswer, _foreignKeysAnswer, _indicesAnswer);
        final TableInfo _existingAnswer = TableInfo.read(_db, "Answer");
        if (! _infoAnswer.equals(_existingAnswer)) {
          throw new IllegalStateException("Migration didn't properly handle Answer(br.com.whitemartins.obc.model.Answer).\n"
                  + " Expected:\n" + _infoAnswer + "\n"
                  + " Found:\n" + _existingAnswer);
        }
        final HashMap<String, TableInfo.Column> _columnsPayment = new HashMap<String, TableInfo.Column>(10);
        _columnsPayment.put("id", new TableInfo.Column("id", "INTEGER", false, 1));
        _columnsPayment.put("idNota", new TableInfo.Column("idNota", "INTEGER", false, 0));
        _columnsPayment.put("tipoIntegracao", new TableInfo.Column("tipoIntegracao", "INTEGER", false, 0));
        _columnsPayment.put("cnpj", new TableInfo.Column("cnpj", "TEXT", false, 0));
        _columnsPayment.put("numeroAutorizacao", new TableInfo.Column("numeroAutorizacao", "TEXT", false, 0));
        _columnsPayment.put("valor", new TableInfo.Column("valor", "REAL", false, 0));
        _columnsPayment.put("credenciadora", new TableInfo.Column("credenciadora", "TEXT", false, 0));
        _columnsPayment.put("bandeira", new TableInfo.Column("bandeira", "TEXT", false, 0));
        _columnsPayment.put("nomeBandeira", new TableInfo.Column("nomeBandeira", "TEXT", false, 0));
        _columnsPayment.put("modalidade", new TableInfo.Column("modalidade", "INTEGER", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPayment = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPayment = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPayment = new TableInfo("Payment", _columnsPayment, _foreignKeysPayment, _indicesPayment);
        final TableInfo _existingPayment = TableInfo.read(_db, "Payment");
        if (! _infoPayment.equals(_existingPayment)) {
          throw new IllegalStateException("Migration didn't properly handle Payment(br.com.whitemartins.obc.model.Payment).\n"
                  + " Expected:\n" + _infoPayment + "\n"
                  + " Found:\n" + _existingPayment);
        }
        final HashMap<String, TableInfo.Column> _columnsSaldo = new HashMap<String, TableInfo.Column>(23);
        _columnsSaldo.put("numeroViagem", new TableInfo.Column("numeroViagem", "INTEGER", true, 1));
        _columnsSaldo.put("cdItem", new TableInfo.Column("cdItem", "INTEGER", true, 2));
        _columnsSaldo.put("capacidade", new TableInfo.Column("capacidade", "REAL", true, 3));
        _columnsSaldo.put("nomeItem", new TableInfo.Column("nomeItem", "TEXT", false, 0));
        _columnsSaldo.put("tipoItem", new TableInfo.Column("tipoItem", "INTEGER", false, 0));
        _columnsSaldo.put("tipoPropriedade", new TableInfo.Column("tipoPropriedade", "TEXT", false, 0));
        _columnsSaldo.put("qtdCarregadaCheios", new TableInfo.Column("qtdCarregadaCheios", "REAL", false, 0));
        _columnsSaldo.put("qtdCarregadaVazios", new TableInfo.Column("qtdCarregadaVazios", "REAL", false, 0));
        _columnsSaldo.put("qtdAtualCheios", new TableInfo.Column("qtdAtualCheios", "REAL", false, 0));
        _columnsSaldo.put("qtdAtualVazios", new TableInfo.Column("qtdAtualVazios", "REAL", false, 0));
        _columnsSaldo.put("qtdCheiosCont", new TableInfo.Column("qtdCheiosCont", "REAL", false, 0));
        _columnsSaldo.put("qtdVaziosCont", new TableInfo.Column("qtdVaziosCont", "REAL", false, 0));
        _columnsSaldo.put("qtdVendidos", new TableInfo.Column("qtdVendidos", "REAL", false, 0));
        _columnsSaldo.put("qtdAplicados", new TableInfo.Column("qtdAplicados", "REAL", false, 0));
        _columnsSaldo.put("qtdRecolhidos", new TableInfo.Column("qtdRecolhidos", "REAL", false, 0));
        _columnsSaldo.put("qtdAplicadosHC", new TableInfo.Column("qtdAplicadosHC", "REAL", false, 0));
        _columnsSaldo.put("qtdRecolhidosHC", new TableInfo.Column("qtdRecolhidosHC", "REAL", false, 0));
        _columnsSaldo.put("qtdAplicadosHCCont", new TableInfo.Column("qtdAplicadosHCCont", "REAL", false, 0));
        _columnsSaldo.put("qtdRecolhidosHCCont", new TableInfo.Column("qtdRecolhidosHCCont", "REAL", false, 0));
        _columnsSaldo.put("qtdTrocados", new TableInfo.Column("qtdTrocados", "REAL", false, 0));
        _columnsSaldo.put("qtdTransferidos", new TableInfo.Column("qtdTransferidos", "REAL", false, 0));
        _columnsSaldo.put("qtdComplementados", new TableInfo.Column("qtdComplementados", "REAL", false, 0));
        _columnsSaldo.put("qtdDescarregados", new TableInfo.Column("qtdDescarregados", "REAL", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSaldo = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSaldo = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSaldo = new TableInfo("Saldo", _columnsSaldo, _foreignKeysSaldo, _indicesSaldo);
        final TableInfo _existingSaldo = TableInfo.read(_db, "Saldo");
        if (! _infoSaldo.equals(_existingSaldo)) {
          throw new IllegalStateException("Migration didn't properly handle Saldo(br.com.whitemartins.obc.model.Saldo).\n"
                  + " Expected:\n" + _infoSaldo + "\n"
                  + " Found:\n" + _existingSaldo);
        }
        final HashMap<String, TableInfo.Column> _columnsLotePatrimonio = new HashMap<String, TableInfo.Column>(12);
        _columnsLotePatrimonio.put("codigo", new TableInfo.Column("codigo", "INTEGER", false, 1));
        _columnsLotePatrimonio.put("idNota", new TableInfo.Column("idNota", "INTEGER", false, 0));
        _columnsLotePatrimonio.put("cdFilial", new TableInfo.Column("cdFilial", "TEXT", false, 0));
        _columnsLotePatrimonio.put("cdItem", new TableInfo.Column("cdItem", "INTEGER", false, 0));
        _columnsLotePatrimonio.put("capacidade", new TableInfo.Column("capacidade", "REAL", false, 0));
        _columnsLotePatrimonio.put("numeroLote", new TableInfo.Column("numeroLote", "TEXT", false, 0));
        _columnsLotePatrimonio.put("numeroVeiuclo", new TableInfo.Column("numeroVeiuclo", "TEXT", false, 0));
        _columnsLotePatrimonio.put("numeroViagem", new TableInfo.Column("numeroViagem", "INTEGER", false, 0));
        _columnsLotePatrimonio.put("dataViagem", new TableInfo.Column("dataViagem", "INTEGER", false, 0));
        _columnsLotePatrimonio.put("cdCustomer", new TableInfo.Column("cdCustomer", "INTEGER", false, 0));
        _columnsLotePatrimonio.put("tipo", new TableInfo.Column("tipo", "INTEGER", false, 0));
        _columnsLotePatrimonio.put("liberado", new TableInfo.Column("liberado", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysLotePatrimonio = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesLotePatrimonio = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoLotePatrimonio = new TableInfo("LotePatrimonio", _columnsLotePatrimonio, _foreignKeysLotePatrimonio, _indicesLotePatrimonio);
        final TableInfo _existingLotePatrimonio = TableInfo.read(_db, "LotePatrimonio");
        if (! _infoLotePatrimonio.equals(_existingLotePatrimonio)) {
          throw new IllegalStateException("Migration didn't properly handle LotePatrimonio(br.com.whitemartins.obc.model.LotePatrimonio).\n"
                  + " Expected:\n" + _infoLotePatrimonio + "\n"
                  + " Found:\n" + _existingLotePatrimonio);
        }
        final HashMap<String, TableInfo.Column> _columnsAbastecimento = new HashMap<String, TableInfo.Column>(17);
        _columnsAbastecimento.put("codigo", new TableInfo.Column("codigo", "INTEGER", false, 1));
        _columnsAbastecimento.put("numWM", new TableInfo.Column("numWM", "INTEGER", false, 0));
        _columnsAbastecimento.put("cdCustomer", new TableInfo.Column("cdCustomer", "INTEGER", false, 0));
        _columnsAbastecimento.put("numeroSerieTanque", new TableInfo.Column("numeroSerieTanque", "TEXT", false, 0));
        _columnsAbastecimento.put("capacidadeKG", new TableInfo.Column("capacidadeKG", "REAL", false, 0));
        _columnsAbastecimento.put("capacidadePol", new TableInfo.Column("capacidadePol", "REAL", false, 0));
        _columnsAbastecimento.put("fatorConversao", new TableInfo.Column("fatorConversao", "REAL", false, 0));
        _columnsAbastecimento.put("pesoAntes", new TableInfo.Column("pesoAntes", "REAL", false, 0));
        _columnsAbastecimento.put("pesoDepois", new TableInfo.Column("pesoDepois", "REAL", false, 0));
        _columnsAbastecimento.put("nivelAntes", new TableInfo.Column("nivelAntes", "REAL", false, 0));
        _columnsAbastecimento.put("nivelDepois", new TableInfo.Column("nivelDepois", "REAL", false, 0));
        _columnsAbastecimento.put("totalDescarga", new TableInfo.Column("totalDescarga", "REAL", false, 0));
        _columnsAbastecimento.put("totalCalulado", new TableInfo.Column("totalCalulado", "REAL", false, 0));
        _columnsAbastecimento.put("totalNfe", new TableInfo.Column("totalNfe", "REAL", false, 0));
        _columnsAbastecimento.put("divergente", new TableInfo.Column("divergente", "TEXT", false, 0));
        _columnsAbastecimento.put("tipoCalculo", new TableInfo.Column("tipoCalculo", "INTEGER", false, 0));
        _columnsAbastecimento.put("idNota", new TableInfo.Column("idNota", "INTEGER", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAbastecimento = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAbastecimento = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAbastecimento = new TableInfo("Abastecimento", _columnsAbastecimento, _foreignKeysAbastecimento, _indicesAbastecimento);
        final TableInfo _existingAbastecimento = TableInfo.read(_db, "Abastecimento");
        if (! _infoAbastecimento.equals(_existingAbastecimento)) {
          throw new IllegalStateException("Migration didn't properly handle Abastecimento(br.com.whitemartins.obc.model.Abastecimento).\n"
                  + " Expected:\n" + _infoAbastecimento + "\n"
                  + " Found:\n" + _existingAbastecimento);
        }
        final HashMap<String, TableInfo.Column> _columnsExcepty = new HashMap<String, TableInfo.Column>(8);
        _columnsExcepty.put("cdCustomer", new TableInfo.Column("cdCustomer", "INTEGER", true, 1));
        _columnsExcepty.put("cdExcept", new TableInfo.Column("cdExcept", "INTEGER", true, 2));
        _columnsExcepty.put("dataHoraEntrada", new TableInfo.Column("dataHoraEntrada", "INTEGER", true, 3));
        _columnsExcepty.put("tipo", new TableInfo.Column("tipo", "TEXT", false, 0));
        _columnsExcepty.put("odometro", new TableInfo.Column("odometro", "INTEGER", false, 0));
        _columnsExcepty.put("dataHoraSaida", new TableInfo.Column("dataHoraSaida", "INTEGER", false, 0));
        _columnsExcepty.put("numeroViagem", new TableInfo.Column("numeroViagem", "INTEGER", false, 0));
        _columnsExcepty.put("dataViagem", new TableInfo.Column("dataViagem", "INTEGER", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysExcepty = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesExcepty = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoExcepty = new TableInfo("Excepty", _columnsExcepty, _foreignKeysExcepty, _indicesExcepty);
        final TableInfo _existingExcepty = TableInfo.read(_db, "Excepty");
        if (! _infoExcepty.equals(_existingExcepty)) {
          throw new IllegalStateException("Migration didn't properly handle Excepty(br.com.whitemartins.obc.model.Excepty).\n"
                  + " Expected:\n" + _infoExcepty + "\n"
                  + " Found:\n" + _existingExcepty);
        }
        final HashMap<String, TableInfo.Column> _columnsInvoiceImage = new HashMap<String, TableInfo.Column>(4);
        _columnsInvoiceImage.put("idNota", new TableInfo.Column("idNota", "INTEGER", false, 1));
        _columnsInvoiceImage.put("status", new TableInfo.Column("status", "INTEGER", false, 0));
        _columnsInvoiceImage.put("cec", new TableInfo.Column("cec", "TEXT", false, 0));
        _columnsInvoiceImage.put("assinatura", new TableInfo.Column("assinatura", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysInvoiceImage = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesInvoiceImage = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoInvoiceImage = new TableInfo("InvoiceImage", _columnsInvoiceImage, _foreignKeysInvoiceImage, _indicesInvoiceImage);
        final TableInfo _existingInvoiceImage = TableInfo.read(_db, "InvoiceImage");
        if (! _infoInvoiceImage.equals(_existingInvoiceImage)) {
          throw new IllegalStateException("Migration didn't properly handle InvoiceImage(br.com.whitemartins.obc.model.InvoiceImage).\n"
                  + " Expected:\n" + _infoInvoiceImage + "\n"
                  + " Found:\n" + _existingInvoiceImage);
        }
      }
    }, "a1d991c54c4a69696672956c476e7b22", "39473db0edfa2d1f32dfe1ce5595c2fe");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "Daily","Customer","Item","Price","Route","Asset","Patient","InvoiceNumber","PaymentCard","Tax","Code","Questions","ConversaoLQ","Message","Travel","PreOrder","General","Rastreabilidade","Invoice","InvoiceItem","InvoiceMessage","Search","Answer","Payment","Saldo","LotePatrimonio","Abastecimento","Excepty","InvoiceImage");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `Daily`");
      _db.execSQL("DELETE FROM `Customer`");
      _db.execSQL("DELETE FROM `Item`");
      _db.execSQL("DELETE FROM `Price`");
      _db.execSQL("DELETE FROM `Route`");
      _db.execSQL("DELETE FROM `Asset`");
      _db.execSQL("DELETE FROM `Patient`");
      _db.execSQL("DELETE FROM `InvoiceNumber`");
      _db.execSQL("DELETE FROM `PaymentCard`");
      _db.execSQL("DELETE FROM `Tax`");
      _db.execSQL("DELETE FROM `Code`");
      _db.execSQL("DELETE FROM `Questions`");
      _db.execSQL("DELETE FROM `ConversaoLQ`");
      _db.execSQL("DELETE FROM `Message`");
      _db.execSQL("DELETE FROM `Travel`");
      _db.execSQL("DELETE FROM `PreOrder`");
      _db.execSQL("DELETE FROM `General`");
      _db.execSQL("DELETE FROM `Rastreabilidade`");
      _db.execSQL("DELETE FROM `Invoice`");
      _db.execSQL("DELETE FROM `InvoiceItem`");
      _db.execSQL("DELETE FROM `InvoiceMessage`");
      _db.execSQL("DELETE FROM `Search`");
      _db.execSQL("DELETE FROM `Answer`");
      _db.execSQL("DELETE FROM `Payment`");
      _db.execSQL("DELETE FROM `Saldo`");
      _db.execSQL("DELETE FROM `LotePatrimonio`");
      _db.execSQL("DELETE FROM `Abastecimento`");
      _db.execSQL("DELETE FROM `Excepty`");
      _db.execSQL("DELETE FROM `InvoiceImage`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public DailyDao dailyDao() {
    if (_dailyDao != null) {
      return _dailyDao;
    } else {
      synchronized(this) {
        if(_dailyDao == null) {
          _dailyDao = new DailyDao_Impl(this);
        }
        return _dailyDao;
      }
    }
  }

  @Override
  public CustomerDao customerDao() {
    if (_customerDao != null) {
      return _customerDao;
    } else {
      synchronized(this) {
        if(_customerDao == null) {
          _customerDao = new CustomerDao_Impl(this);
        }
        return _customerDao;
      }
    }
  }

  @Override
  public RouteDao routeDao() {
    if (_routeDao != null) {
      return _routeDao;
    } else {
      synchronized(this) {
        if(_routeDao == null) {
          _routeDao = new RouteDao_Impl(this);
        }
        return _routeDao;
      }
    }
  }

  @Override
  public PriceDao priceDao() {
    if (_priceDao != null) {
      return _priceDao;
    } else {
      synchronized(this) {
        if(_priceDao == null) {
          _priceDao = new PriceDao_Impl(this);
        }
        return _priceDao;
      }
    }
  }

  @Override
  public ItemDao itemDao() {
    if (_itemDao != null) {
      return _itemDao;
    } else {
      synchronized(this) {
        if(_itemDao == null) {
          _itemDao = new ItemDao_Impl(this);
        }
        return _itemDao;
      }
    }
  }

  @Override
  public AssetDao assetDao() {
    if (_assetDao != null) {
      return _assetDao;
    } else {
      synchronized(this) {
        if(_assetDao == null) {
          _assetDao = new AssetDao_Impl(this);
        }
        return _assetDao;
      }
    }
  }

  @Override
  public InvoiceNumberDao invoiceNumberDao() {
    if (_invoiceNumberDao != null) {
      return _invoiceNumberDao;
    } else {
      synchronized(this) {
        if(_invoiceNumberDao == null) {
          _invoiceNumberDao = new InvoiceNumberDao_Impl(this);
        }
        return _invoiceNumberDao;
      }
    }
  }

  @Override
  public PaymentCardDao payCardDao() {
    if (_paymentCardDao != null) {
      return _paymentCardDao;
    } else {
      synchronized(this) {
        if(_paymentCardDao == null) {
          _paymentCardDao = new PaymentCardDao_Impl(this);
        }
        return _paymentCardDao;
      }
    }
  }

  @Override
  public TaxDao taxDao() {
    if (_taxDao != null) {
      return _taxDao;
    } else {
      synchronized(this) {
        if(_taxDao == null) {
          _taxDao = new TaxDao_Impl(this);
        }
        return _taxDao;
      }
    }
  }

  @Override
  public CodeDao codeDao() {
    if (_codeDao != null) {
      return _codeDao;
    } else {
      synchronized(this) {
        if(_codeDao == null) {
          _codeDao = new CodeDao_Impl(this);
        }
        return _codeDao;
      }
    }
  }

  @Override
  public QuestionsDao questionsDao() {
    if (_questionsDao != null) {
      return _questionsDao;
    } else {
      synchronized(this) {
        if(_questionsDao == null) {
          _questionsDao = new QuestionsDao_Impl(this);
        }
        return _questionsDao;
      }
    }
  }

  @Override
  public ConversionLQDao conversionLQDao() {
    if (_conversionLQDao != null) {
      return _conversionLQDao;
    } else {
      synchronized(this) {
        if(_conversionLQDao == null) {
          _conversionLQDao = new ConversionLQDao_Impl(this);
        }
        return _conversionLQDao;
      }
    }
  }

  @Override
  public MessageDao messageDao() {
    if (_messageDao != null) {
      return _messageDao;
    } else {
      synchronized(this) {
        if(_messageDao == null) {
          _messageDao = new MessageDao_Impl(this);
        }
        return _messageDao;
      }
    }
  }

  @Override
  public TravelDao travelDao() {
    if (_travelDao != null) {
      return _travelDao;
    } else {
      synchronized(this) {
        if(_travelDao == null) {
          _travelDao = new TravelDao_Impl(this);
        }
        return _travelDao;
      }
    }
  }

  @Override
  public PreOrderDao preOrderDao() {
    if (_preOrderDao != null) {
      return _preOrderDao;
    } else {
      synchronized(this) {
        if(_preOrderDao == null) {
          _preOrderDao = new PreOrderDao_Impl(this);
        }
        return _preOrderDao;
      }
    }
  }

  @Override
  public GeneralDao generalDao() {
    if (_generalDao != null) {
      return _generalDao;
    } else {
      synchronized(this) {
        if(_generalDao == null) {
          _generalDao = new GeneralDao_Impl(this);
        }
        return _generalDao;
      }
    }
  }

  @Override
  public PatientDao patientDao() {
    if (_patientDao != null) {
      return _patientDao;
    } else {
      synchronized(this) {
        if(_patientDao == null) {
          _patientDao = new PatientDao_Impl(this);
        }
        return _patientDao;
      }
    }
  }

  @Override
  public RastreabilidadeDao rastreabilidadeDao() {
    if (_rastreabilidadeDao != null) {
      return _rastreabilidadeDao;
    } else {
      synchronized(this) {
        if(_rastreabilidadeDao == null) {
          _rastreabilidadeDao = new RastreabilidadeDao_Impl(this);
        }
        return _rastreabilidadeDao;
      }
    }
  }

  @Override
  public InvoiceDao invoiceDao() {
    if (_invoiceDao != null) {
      return _invoiceDao;
    } else {
      synchronized(this) {
        if(_invoiceDao == null) {
          _invoiceDao = new InvoiceDao_Impl(this);
        }
        return _invoiceDao;
      }
    }
  }

  @Override
  public InvoiceItemDao invoiceItemDao() {
    if (_invoiceItemDao != null) {
      return _invoiceItemDao;
    } else {
      synchronized(this) {
        if(_invoiceItemDao == null) {
          _invoiceItemDao = new InvoiceItemDao_Impl(this);
        }
        return _invoiceItemDao;
      }
    }
  }

  @Override
  public InvoiceMessageDao invoiceMessageDao() {
    if (_invoiceMessageDao != null) {
      return _invoiceMessageDao;
    } else {
      synchronized(this) {
        if(_invoiceMessageDao == null) {
          _invoiceMessageDao = new InvoiceMessageDao_Impl(this);
        }
        return _invoiceMessageDao;
      }
    }
  }

  @Override
  public SearchDao searchDao() {
    if (_searchDao != null) {
      return _searchDao;
    } else {
      synchronized(this) {
        if(_searchDao == null) {
          _searchDao = new SearchDao_Impl(this);
        }
        return _searchDao;
      }
    }
  }

  @Override
  public AnswerDao answerDao() {
    if (_answerDao != null) {
      return _answerDao;
    } else {
      synchronized(this) {
        if(_answerDao == null) {
          _answerDao = new AnswerDao_Impl(this);
        }
        return _answerDao;
      }
    }
  }

  @Override
  public PaymentDao paymentDao() {
    if (_paymentDao != null) {
      return _paymentDao;
    } else {
      synchronized(this) {
        if(_paymentDao == null) {
          _paymentDao = new PaymentDao_Impl(this);
        }
        return _paymentDao;
      }
    }
  }

  @Override
  public SaldoDao saldoDao() {
    if (_saldoDao != null) {
      return _saldoDao;
    } else {
      synchronized(this) {
        if(_saldoDao == null) {
          _saldoDao = new SaldoDao_Impl(this);
        }
        return _saldoDao;
      }
    }
  }

  @Override
  public LotePatrimonioDao lotePatrimonioDao() {
    if (_lotePatrimonioDao != null) {
      return _lotePatrimonioDao;
    } else {
      synchronized(this) {
        if(_lotePatrimonioDao == null) {
          _lotePatrimonioDao = new LotePatrimonioDao_Impl(this);
        }
        return _lotePatrimonioDao;
      }
    }
  }

  @Override
  public AbastecimentoDao abastecimentoDao() {
    if (_abastecimentoDao != null) {
      return _abastecimentoDao;
    } else {
      synchronized(this) {
        if(_abastecimentoDao == null) {
          _abastecimentoDao = new AbastecimentoDao_Impl(this);
        }
        return _abastecimentoDao;
      }
    }
  }

  @Override
  public ExceptyDao exceptDao() {
    if (_exceptyDao != null) {
      return _exceptyDao;
    } else {
      synchronized(this) {
        if(_exceptyDao == null) {
          _exceptyDao = new ExceptyDao_Impl(this);
        }
        return _exceptyDao;
      }
    }
  }

  @Override
  public InvoiceImageDao invoiceImageDao() {
    if (_invoiceImageDao != null) {
      return _invoiceImageDao;
    } else {
      synchronized(this) {
        if(_invoiceImageDao == null) {
          _invoiceImageDao = new InvoiceImageDao_Impl(this);
        }
        return _invoiceImageDao;
      }
    }
  }
}
