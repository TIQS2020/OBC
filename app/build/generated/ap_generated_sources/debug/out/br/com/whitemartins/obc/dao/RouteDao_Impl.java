package br.com.whitemartins.obc.dao;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import br.com.whitemartins.obc.database.DateTypeConverter;
import br.com.whitemartins.obc.model.Route;
import java.lang.Double;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("unchecked")
public class RouteDao_Impl implements RouteDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfRoute;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfRoute;

  public RouteDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfRoute = new EntityInsertionAdapter<Route>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Route`(`cdFilial`,`numAlmoxarifado`,`cdRota`,`numVeiculo`,`numeroMotorista`,`numeroViagem`,`cdFilialJde`,`cdCompanhia`,`pesquisaHabilitada`,`modeloDoc`,`modeloCec`,`nomeFilial`,`endereco`,`bairro`,`cidade`,`uf`,`cep`,`tipoCnpj`,`cnpj`,`inscEstadual`,`telefone`,`numeroModem`,`intervalo`,`intervaloTempo`,`razaoSocial`,`valorIndenizacaoAlta`,`valorIndenizacaoBaixa`,`valorIndenizacaoLS`,`integDI`,`descDesp1`,`descDesp2`,`descDesp3`,`descDesp4`,`adicionarCliente`,`alterarPrecoObc`,`solicitarOdometroParada`,`permitirTroca`,`tipoFilial`,`forcarContagemFisica`,`ultimaContagemSenha`,`imprimirVariacaoPreco`,`senhaComunicacao`,`habilitarImpressora`,`fatiaAutomaticaPreco`,`imprimirPreorderDepois`,`flPrecoPreorder`,`statusRastrebilidade`,`tipoImpressao`,`tipoImpressora`,`mostrarDescontoMotorista`,`imprimirQtdNota`,`imprimirContagem`,`tipoCargaVeiculo`,`checkDiscoVazio`,`relatorioAuditoria`,`clienteSemServico`,`abatimento`,`registroNota`,`relatorioDespesas`,`avaliacaoInventario`,`resumoViriacao`,`relatorioData`,`contaPagamento`,`transferencia`,`deposito`,`viagemMultipla`,`medidorVazao`,`obc6110`,`ativarRastreabilidade`,`razaoSocialTransp`,`enderecoTrasnp`,`cidadeTransp`,`estadoTransp`,`placaVeiculo`,`UfVeiculo`,`tipoCnpjTransp`,`cnpjTransp`,`tipoPagamento`,`reimprimirNota`,`remeterPara`,`setupModem`,`tipoDiscagem`,`tipoConexao`,`dataViagem`,`imei`,`bloqViagem`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Route value) {
        if (value.getCdFilial() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getCdFilial());
        }
        if (value.getNumAlmoxarifado() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNumAlmoxarifado());
        }
        if (value.getCdRota() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getCdRota());
        }
        if (value.getNumVeiculo() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getNumVeiculo());
        }
        if (value.getNumeroMotorista() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getNumeroMotorista());
        }
        if (value.getNumeroViagem() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getNumeroViagem());
        }
        if (value.getCdFilialJde() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getCdFilialJde());
        }
        if (value.getCdCompanhia() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getCdCompanhia());
        }
        if (value.getPesquisaHabilitada() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getPesquisaHabilitada());
        }
        if (value.getModeloDoc() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getModeloDoc());
        }
        if (value.getModeloCec() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getModeloCec());
        }
        if (value.getNomeFilial() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getNomeFilial());
        }
        if (value.getEndereco() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getEndereco());
        }
        if (value.getBairro() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getBairro());
        }
        if (value.getCidade() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getCidade());
        }
        if (value.getUf() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getUf());
        }
        if (value.getCep() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getCep());
        }
        if (value.getTipoCnpj() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getTipoCnpj());
        }
        if (value.getCnpj() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getCnpj());
        }
        if (value.getInscEstadual() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getInscEstadual());
        }
        if (value.getTelefone() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getTelefone());
        }
        if (value.getNumeroModem() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.getNumeroModem());
        }
        if (value.getIntervalo() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindLong(23, value.getIntervalo());
        }
        if (value.getIntervaloTempo() == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindLong(24, value.getIntervaloTempo());
        }
        if (value.getRazaoSocial() == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindString(25, value.getRazaoSocial());
        }
        if (value.getValorIndenizacaoAlta() == null) {
          stmt.bindNull(26);
        } else {
          stmt.bindDouble(26, value.getValorIndenizacaoAlta());
        }
        if (value.getValorIndenizacaoBaixa() == null) {
          stmt.bindNull(27);
        } else {
          stmt.bindDouble(27, value.getValorIndenizacaoBaixa());
        }
        if (value.getValorIndenizacaoLS() == null) {
          stmt.bindNull(28);
        } else {
          stmt.bindDouble(28, value.getValorIndenizacaoLS());
        }
        if (value.getIntegDI() == null) {
          stmt.bindNull(29);
        } else {
          stmt.bindString(29, value.getIntegDI());
        }
        if (value.getDescDesp1() == null) {
          stmt.bindNull(30);
        } else {
          stmt.bindString(30, value.getDescDesp1());
        }
        if (value.getDescDesp2() == null) {
          stmt.bindNull(31);
        } else {
          stmt.bindString(31, value.getDescDesp2());
        }
        if (value.getDescDesp3() == null) {
          stmt.bindNull(32);
        } else {
          stmt.bindString(32, value.getDescDesp3());
        }
        if (value.getDescDesp4() == null) {
          stmt.bindNull(33);
        } else {
          stmt.bindString(33, value.getDescDesp4());
        }
        if (value.getAdicionarCliente() == null) {
          stmt.bindNull(34);
        } else {
          stmt.bindString(34, value.getAdicionarCliente());
        }
        if (value.getAlterarPrecoObc() == null) {
          stmt.bindNull(35);
        } else {
          stmt.bindString(35, value.getAlterarPrecoObc());
        }
        if (value.getSolicitarOdometroParada() == null) {
          stmt.bindNull(36);
        } else {
          stmt.bindString(36, value.getSolicitarOdometroParada());
        }
        if (value.getPermitirTroca() == null) {
          stmt.bindNull(37);
        } else {
          stmt.bindString(37, value.getPermitirTroca());
        }
        if (value.getTipoFilial() == null) {
          stmt.bindNull(38);
        } else {
          stmt.bindString(38, value.getTipoFilial());
        }
        if (value.getForcarContagemFisica() == null) {
          stmt.bindNull(39);
        } else {
          stmt.bindString(39, value.getForcarContagemFisica());
        }
        if (value.getUltimaContagemSenha() == null) {
          stmt.bindNull(40);
        } else {
          stmt.bindString(40, value.getUltimaContagemSenha());
        }
        if (value.getImprimirVariacaoPreco() == null) {
          stmt.bindNull(41);
        } else {
          stmt.bindString(41, value.getImprimirVariacaoPreco());
        }
        if (value.getSenhaComunicacao() == null) {
          stmt.bindNull(42);
        } else {
          stmt.bindString(42, value.getSenhaComunicacao());
        }
        if (value.getHabilitarImpressora() == null) {
          stmt.bindNull(43);
        } else {
          stmt.bindString(43, value.getHabilitarImpressora());
        }
        if (value.getFatiaAutomaticaPreco() == null) {
          stmt.bindNull(44);
        } else {
          stmt.bindString(44, value.getFatiaAutomaticaPreco());
        }
        if (value.getImprimirPreorderDepois() == null) {
          stmt.bindNull(45);
        } else {
          stmt.bindString(45, value.getImprimirPreorderDepois());
        }
        if (value.getFlPrecoPreorder() == null) {
          stmt.bindNull(46);
        } else {
          stmt.bindString(46, value.getFlPrecoPreorder());
        }
        if (value.getStatusRastrebilidade() == null) {
          stmt.bindNull(47);
        } else {
          stmt.bindLong(47, value.getStatusRastrebilidade());
        }
        if (value.getTipoImpressao() == null) {
          stmt.bindNull(48);
        } else {
          stmt.bindString(48, value.getTipoImpressao());
        }
        if (value.getTipoImpressora() == null) {
          stmt.bindNull(49);
        } else {
          stmt.bindString(49, value.getTipoImpressora());
        }
        if (value.getMostrarDescontoMotorista() == null) {
          stmt.bindNull(50);
        } else {
          stmt.bindString(50, value.getMostrarDescontoMotorista());
        }
        if (value.getImprimirQtdNota() == null) {
          stmt.bindNull(51);
        } else {
          stmt.bindString(51, value.getImprimirQtdNota());
        }
        if (value.getImprimirContagem() == null) {
          stmt.bindNull(52);
        } else {
          stmt.bindString(52, value.getImprimirContagem());
        }
        if (value.getTipoCargaVeiculo() == null) {
          stmt.bindNull(53);
        } else {
          stmt.bindLong(53, value.getTipoCargaVeiculo());
        }
        if (value.getCheckDiscoVazio() == null) {
          stmt.bindNull(54);
        } else {
          stmt.bindString(54, value.getCheckDiscoVazio());
        }
        if (value.getRelatorioAuditoria() == null) {
          stmt.bindNull(55);
        } else {
          stmt.bindString(55, value.getRelatorioAuditoria());
        }
        if (value.getClienteSemServico() == null) {
          stmt.bindNull(56);
        } else {
          stmt.bindString(56, value.getClienteSemServico());
        }
        if (value.getAbatimento() == null) {
          stmt.bindNull(57);
        } else {
          stmt.bindString(57, value.getAbatimento());
        }
        if (value.getRegistroNota() == null) {
          stmt.bindNull(58);
        } else {
          stmt.bindString(58, value.getRegistroNota());
        }
        if (value.getRelatorioDespesas() == null) {
          stmt.bindNull(59);
        } else {
          stmt.bindString(59, value.getRelatorioDespesas());
        }
        if (value.getAvaliacaoInventario() == null) {
          stmt.bindNull(60);
        } else {
          stmt.bindString(60, value.getAvaliacaoInventario());
        }
        if (value.getResumoViriacao() == null) {
          stmt.bindNull(61);
        } else {
          stmt.bindString(61, value.getResumoViriacao());
        }
        if (value.getRelatorioData() == null) {
          stmt.bindNull(62);
        } else {
          stmt.bindString(62, value.getRelatorioData());
        }
        if (value.getContaPagamento() == null) {
          stmt.bindNull(63);
        } else {
          stmt.bindString(63, value.getContaPagamento());
        }
        if (value.getTransferencia() == null) {
          stmt.bindNull(64);
        } else {
          stmt.bindString(64, value.getTransferencia());
        }
        if (value.getDeposito() == null) {
          stmt.bindNull(65);
        } else {
          stmt.bindString(65, value.getDeposito());
        }
        if (value.getViagemMultipla() == null) {
          stmt.bindNull(66);
        } else {
          stmt.bindString(66, value.getViagemMultipla());
        }
        if (value.getMedidorVazao() == null) {
          stmt.bindNull(67);
        } else {
          stmt.bindString(67, value.getMedidorVazao());
        }
        if (value.getObc6110() == null) {
          stmt.bindNull(68);
        } else {
          stmt.bindString(68, value.getObc6110());
        }
        if (value.getAtivarRastreabilidade() == null) {
          stmt.bindNull(69);
        } else {
          stmt.bindString(69, value.getAtivarRastreabilidade());
        }
        if (value.getRazaoSocialTransp() == null) {
          stmt.bindNull(70);
        } else {
          stmt.bindString(70, value.getRazaoSocialTransp());
        }
        if (value.getEnderecoTrasnp() == null) {
          stmt.bindNull(71);
        } else {
          stmt.bindString(71, value.getEnderecoTrasnp());
        }
        if (value.getCidadeTransp() == null) {
          stmt.bindNull(72);
        } else {
          stmt.bindString(72, value.getCidadeTransp());
        }
        if (value.getEstadoTransp() == null) {
          stmt.bindNull(73);
        } else {
          stmt.bindString(73, value.getEstadoTransp());
        }
        if (value.getPlacaVeiculo() == null) {
          stmt.bindNull(74);
        } else {
          stmt.bindString(74, value.getPlacaVeiculo());
        }
        if (value.getUfVeiculo() == null) {
          stmt.bindNull(75);
        } else {
          stmt.bindString(75, value.getUfVeiculo());
        }
        if (value.getTipoCnpjTransp() == null) {
          stmt.bindNull(76);
        } else {
          stmt.bindString(76, value.getTipoCnpjTransp());
        }
        if (value.getCnpjTransp() == null) {
          stmt.bindNull(77);
        } else {
          stmt.bindString(77, value.getCnpjTransp());
        }
        if (value.getTipoPagamento() == null) {
          stmt.bindNull(78);
        } else {
          stmt.bindString(78, value.getTipoPagamento());
        }
        if (value.getReimprimirNota() == null) {
          stmt.bindNull(79);
        } else {
          stmt.bindString(79, value.getReimprimirNota());
        }
        if (value.getRemeterPara() == null) {
          stmt.bindNull(80);
        } else {
          stmt.bindString(80, value.getRemeterPara());
        }
        if (value.getSetupModem() == null) {
          stmt.bindNull(81);
        } else {
          stmt.bindString(81, value.getSetupModem());
        }
        if (value.getTipoDiscagem() == null) {
          stmt.bindNull(82);
        } else {
          stmt.bindString(82, value.getTipoDiscagem());
        }
        if (value.getTipoConexao() == null) {
          stmt.bindNull(83);
        } else {
          stmt.bindString(83, value.getTipoConexao());
        }
        final Long _tmp;
        _tmp = DateTypeConverter.dateToTimestamp(value.getDataViagem());
        if (_tmp == null) {
          stmt.bindNull(84);
        } else {
          stmt.bindLong(84, _tmp);
        }
        if (value.getImei() == null) {
          stmt.bindNull(85);
        } else {
          stmt.bindString(85, value.getImei());
        }
        if (value.getBloqViagem() == null) {
          stmt.bindNull(86);
        } else {
          stmt.bindString(86, value.getBloqViagem());
        }
      }
    };
    this.__deletionAdapterOfRoute = new EntityDeletionOrUpdateAdapter<Route>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Route` WHERE `cdRota` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Route value) {
        if (value.getCdRota() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getCdRota());
        }
      }
    };
  }

  @Override
  public void insert(Route route) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfRoute.insert(route);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(Route route) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfRoute.handle(route);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll(List<Route> routes) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfRoute.handleMultiple(routes);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Route> getAll() {
    final String _sql = "SELECT * FROM Route";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCdFilial = _cursor.getColumnIndexOrThrow("cdFilial");
      final int _cursorIndexOfNumAlmoxarifado = _cursor.getColumnIndexOrThrow("numAlmoxarifado");
      final int _cursorIndexOfCdRota = _cursor.getColumnIndexOrThrow("cdRota");
      final int _cursorIndexOfNumVeiculo = _cursor.getColumnIndexOrThrow("numVeiculo");
      final int _cursorIndexOfNumeroMotorista = _cursor.getColumnIndexOrThrow("numeroMotorista");
      final int _cursorIndexOfNumeroViagem = _cursor.getColumnIndexOrThrow("numeroViagem");
      final int _cursorIndexOfCdFilialJde = _cursor.getColumnIndexOrThrow("cdFilialJde");
      final int _cursorIndexOfCdCompanhia = _cursor.getColumnIndexOrThrow("cdCompanhia");
      final int _cursorIndexOfPesquisaHabilitada = _cursor.getColumnIndexOrThrow("pesquisaHabilitada");
      final int _cursorIndexOfModeloDoc = _cursor.getColumnIndexOrThrow("modeloDoc");
      final int _cursorIndexOfModeloCec = _cursor.getColumnIndexOrThrow("modeloCec");
      final int _cursorIndexOfNomeFilial = _cursor.getColumnIndexOrThrow("nomeFilial");
      final int _cursorIndexOfEndereco = _cursor.getColumnIndexOrThrow("endereco");
      final int _cursorIndexOfBairro = _cursor.getColumnIndexOrThrow("bairro");
      final int _cursorIndexOfCidade = _cursor.getColumnIndexOrThrow("cidade");
      final int _cursorIndexOfUf = _cursor.getColumnIndexOrThrow("uf");
      final int _cursorIndexOfCep = _cursor.getColumnIndexOrThrow("cep");
      final int _cursorIndexOfTipoCnpj = _cursor.getColumnIndexOrThrow("tipoCnpj");
      final int _cursorIndexOfCnpj = _cursor.getColumnIndexOrThrow("cnpj");
      final int _cursorIndexOfInscEstadual = _cursor.getColumnIndexOrThrow("inscEstadual");
      final int _cursorIndexOfTelefone = _cursor.getColumnIndexOrThrow("telefone");
      final int _cursorIndexOfNumeroModem = _cursor.getColumnIndexOrThrow("numeroModem");
      final int _cursorIndexOfIntervalo = _cursor.getColumnIndexOrThrow("intervalo");
      final int _cursorIndexOfIntervaloTempo = _cursor.getColumnIndexOrThrow("intervaloTempo");
      final int _cursorIndexOfRazaoSocial = _cursor.getColumnIndexOrThrow("razaoSocial");
      final int _cursorIndexOfValorIndenizacaoAlta = _cursor.getColumnIndexOrThrow("valorIndenizacaoAlta");
      final int _cursorIndexOfValorIndenizacaoBaixa = _cursor.getColumnIndexOrThrow("valorIndenizacaoBaixa");
      final int _cursorIndexOfValorIndenizacaoLS = _cursor.getColumnIndexOrThrow("valorIndenizacaoLS");
      final int _cursorIndexOfIntegDI = _cursor.getColumnIndexOrThrow("integDI");
      final int _cursorIndexOfDescDesp1 = _cursor.getColumnIndexOrThrow("descDesp1");
      final int _cursorIndexOfDescDesp2 = _cursor.getColumnIndexOrThrow("descDesp2");
      final int _cursorIndexOfDescDesp3 = _cursor.getColumnIndexOrThrow("descDesp3");
      final int _cursorIndexOfDescDesp4 = _cursor.getColumnIndexOrThrow("descDesp4");
      final int _cursorIndexOfAdicionarCliente = _cursor.getColumnIndexOrThrow("adicionarCliente");
      final int _cursorIndexOfAlterarPrecoObc = _cursor.getColumnIndexOrThrow("alterarPrecoObc");
      final int _cursorIndexOfSolicitarOdometroParada = _cursor.getColumnIndexOrThrow("solicitarOdometroParada");
      final int _cursorIndexOfPermitirTroca = _cursor.getColumnIndexOrThrow("permitirTroca");
      final int _cursorIndexOfTipoFilial = _cursor.getColumnIndexOrThrow("tipoFilial");
      final int _cursorIndexOfForcarContagemFisica = _cursor.getColumnIndexOrThrow("forcarContagemFisica");
      final int _cursorIndexOfUltimaContagemSenha = _cursor.getColumnIndexOrThrow("ultimaContagemSenha");
      final int _cursorIndexOfImprimirVariacaoPreco = _cursor.getColumnIndexOrThrow("imprimirVariacaoPreco");
      final int _cursorIndexOfSenhaComunicacao = _cursor.getColumnIndexOrThrow("senhaComunicacao");
      final int _cursorIndexOfHabilitarImpressora = _cursor.getColumnIndexOrThrow("habilitarImpressora");
      final int _cursorIndexOfFatiaAutomaticaPreco = _cursor.getColumnIndexOrThrow("fatiaAutomaticaPreco");
      final int _cursorIndexOfImprimirPreorderDepois = _cursor.getColumnIndexOrThrow("imprimirPreorderDepois");
      final int _cursorIndexOfFlPrecoPreorder = _cursor.getColumnIndexOrThrow("flPrecoPreorder");
      final int _cursorIndexOfStatusRastrebilidade = _cursor.getColumnIndexOrThrow("statusRastrebilidade");
      final int _cursorIndexOfTipoImpressao = _cursor.getColumnIndexOrThrow("tipoImpressao");
      final int _cursorIndexOfTipoImpressora = _cursor.getColumnIndexOrThrow("tipoImpressora");
      final int _cursorIndexOfMostrarDescontoMotorista = _cursor.getColumnIndexOrThrow("mostrarDescontoMotorista");
      final int _cursorIndexOfImprimirQtdNota = _cursor.getColumnIndexOrThrow("imprimirQtdNota");
      final int _cursorIndexOfImprimirContagem = _cursor.getColumnIndexOrThrow("imprimirContagem");
      final int _cursorIndexOfTipoCargaVeiculo = _cursor.getColumnIndexOrThrow("tipoCargaVeiculo");
      final int _cursorIndexOfCheckDiscoVazio = _cursor.getColumnIndexOrThrow("checkDiscoVazio");
      final int _cursorIndexOfRelatorioAuditoria = _cursor.getColumnIndexOrThrow("relatorioAuditoria");
      final int _cursorIndexOfClienteSemServico = _cursor.getColumnIndexOrThrow("clienteSemServico");
      final int _cursorIndexOfAbatimento = _cursor.getColumnIndexOrThrow("abatimento");
      final int _cursorIndexOfRegistroNota = _cursor.getColumnIndexOrThrow("registroNota");
      final int _cursorIndexOfRelatorioDespesas = _cursor.getColumnIndexOrThrow("relatorioDespesas");
      final int _cursorIndexOfAvaliacaoInventario = _cursor.getColumnIndexOrThrow("avaliacaoInventario");
      final int _cursorIndexOfResumoViriacao = _cursor.getColumnIndexOrThrow("resumoViriacao");
      final int _cursorIndexOfRelatorioData = _cursor.getColumnIndexOrThrow("relatorioData");
      final int _cursorIndexOfContaPagamento = _cursor.getColumnIndexOrThrow("contaPagamento");
      final int _cursorIndexOfTransferencia = _cursor.getColumnIndexOrThrow("transferencia");
      final int _cursorIndexOfDeposito = _cursor.getColumnIndexOrThrow("deposito");
      final int _cursorIndexOfViagemMultipla = _cursor.getColumnIndexOrThrow("viagemMultipla");
      final int _cursorIndexOfMedidorVazao = _cursor.getColumnIndexOrThrow("medidorVazao");
      final int _cursorIndexOfObc6110 = _cursor.getColumnIndexOrThrow("obc6110");
      final int _cursorIndexOfAtivarRastreabilidade = _cursor.getColumnIndexOrThrow("ativarRastreabilidade");
      final int _cursorIndexOfRazaoSocialTransp = _cursor.getColumnIndexOrThrow("razaoSocialTransp");
      final int _cursorIndexOfEnderecoTrasnp = _cursor.getColumnIndexOrThrow("enderecoTrasnp");
      final int _cursorIndexOfCidadeTransp = _cursor.getColumnIndexOrThrow("cidadeTransp");
      final int _cursorIndexOfEstadoTransp = _cursor.getColumnIndexOrThrow("estadoTransp");
      final int _cursorIndexOfPlacaVeiculo = _cursor.getColumnIndexOrThrow("placaVeiculo");
      final int _cursorIndexOfUfVeiculo = _cursor.getColumnIndexOrThrow("UfVeiculo");
      final int _cursorIndexOfTipoCnpjTransp = _cursor.getColumnIndexOrThrow("tipoCnpjTransp");
      final int _cursorIndexOfCnpjTransp = _cursor.getColumnIndexOrThrow("cnpjTransp");
      final int _cursorIndexOfTipoPagamento = _cursor.getColumnIndexOrThrow("tipoPagamento");
      final int _cursorIndexOfReimprimirNota = _cursor.getColumnIndexOrThrow("reimprimirNota");
      final int _cursorIndexOfRemeterPara = _cursor.getColumnIndexOrThrow("remeterPara");
      final int _cursorIndexOfSetupModem = _cursor.getColumnIndexOrThrow("setupModem");
      final int _cursorIndexOfTipoDiscagem = _cursor.getColumnIndexOrThrow("tipoDiscagem");
      final int _cursorIndexOfTipoConexao = _cursor.getColumnIndexOrThrow("tipoConexao");
      final int _cursorIndexOfDataViagem = _cursor.getColumnIndexOrThrow("dataViagem");
      final int _cursorIndexOfImei = _cursor.getColumnIndexOrThrow("imei");
      final int _cursorIndexOfBloqViagem = _cursor.getColumnIndexOrThrow("bloqViagem");
      final List<Route> _result = new ArrayList<Route>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Route _item;
        _item = new Route();
        final String _tmpCdFilial;
        _tmpCdFilial = _cursor.getString(_cursorIndexOfCdFilial);
        _item.setCdFilial(_tmpCdFilial);
        final String _tmpNumAlmoxarifado;
        _tmpNumAlmoxarifado = _cursor.getString(_cursorIndexOfNumAlmoxarifado);
        _item.setNumAlmoxarifado(_tmpNumAlmoxarifado);
        final Integer _tmpCdRota;
        if (_cursor.isNull(_cursorIndexOfCdRota)) {
          _tmpCdRota = null;
        } else {
          _tmpCdRota = _cursor.getInt(_cursorIndexOfCdRota);
        }
        _item.setCdRota(_tmpCdRota);
        final String _tmpNumVeiculo;
        _tmpNumVeiculo = _cursor.getString(_cursorIndexOfNumVeiculo);
        _item.setNumVeiculo(_tmpNumVeiculo);
        final String _tmpNumeroMotorista;
        _tmpNumeroMotorista = _cursor.getString(_cursorIndexOfNumeroMotorista);
        _item.setNumeroMotorista(_tmpNumeroMotorista);
        final Long _tmpNumeroViagem;
        if (_cursor.isNull(_cursorIndexOfNumeroViagem)) {
          _tmpNumeroViagem = null;
        } else {
          _tmpNumeroViagem = _cursor.getLong(_cursorIndexOfNumeroViagem);
        }
        _item.setNumeroViagem(_tmpNumeroViagem);
        final String _tmpCdFilialJde;
        _tmpCdFilialJde = _cursor.getString(_cursorIndexOfCdFilialJde);
        _item.setCdFilialJde(_tmpCdFilialJde);
        final String _tmpCdCompanhia;
        _tmpCdCompanhia = _cursor.getString(_cursorIndexOfCdCompanhia);
        _item.setCdCompanhia(_tmpCdCompanhia);
        final String _tmpPesquisaHabilitada;
        _tmpPesquisaHabilitada = _cursor.getString(_cursorIndexOfPesquisaHabilitada);
        _item.setPesquisaHabilitada(_tmpPesquisaHabilitada);
        final String _tmpModeloDoc;
        _tmpModeloDoc = _cursor.getString(_cursorIndexOfModeloDoc);
        _item.setModeloDoc(_tmpModeloDoc);
        final String _tmpModeloCec;
        _tmpModeloCec = _cursor.getString(_cursorIndexOfModeloCec);
        _item.setModeloCec(_tmpModeloCec);
        final String _tmpNomeFilial;
        _tmpNomeFilial = _cursor.getString(_cursorIndexOfNomeFilial);
        _item.setNomeFilial(_tmpNomeFilial);
        final String _tmpEndereco;
        _tmpEndereco = _cursor.getString(_cursorIndexOfEndereco);
        _item.setEndereco(_tmpEndereco);
        final String _tmpBairro;
        _tmpBairro = _cursor.getString(_cursorIndexOfBairro);
        _item.setBairro(_tmpBairro);
        final String _tmpCidade;
        _tmpCidade = _cursor.getString(_cursorIndexOfCidade);
        _item.setCidade(_tmpCidade);
        final String _tmpUf;
        _tmpUf = _cursor.getString(_cursorIndexOfUf);
        _item.setUf(_tmpUf);
        final String _tmpCep;
        _tmpCep = _cursor.getString(_cursorIndexOfCep);
        _item.setCep(_tmpCep);
        final String _tmpTipoCnpj;
        _tmpTipoCnpj = _cursor.getString(_cursorIndexOfTipoCnpj);
        _item.setTipoCnpj(_tmpTipoCnpj);
        final String _tmpCnpj;
        _tmpCnpj = _cursor.getString(_cursorIndexOfCnpj);
        _item.setCnpj(_tmpCnpj);
        final String _tmpInscEstadual;
        _tmpInscEstadual = _cursor.getString(_cursorIndexOfInscEstadual);
        _item.setInscEstadual(_tmpInscEstadual);
        final String _tmpTelefone;
        _tmpTelefone = _cursor.getString(_cursorIndexOfTelefone);
        _item.setTelefone(_tmpTelefone);
        final String _tmpNumeroModem;
        _tmpNumeroModem = _cursor.getString(_cursorIndexOfNumeroModem);
        _item.setNumeroModem(_tmpNumeroModem);
        final Integer _tmpIntervalo;
        if (_cursor.isNull(_cursorIndexOfIntervalo)) {
          _tmpIntervalo = null;
        } else {
          _tmpIntervalo = _cursor.getInt(_cursorIndexOfIntervalo);
        }
        _item.setIntervalo(_tmpIntervalo);
        final Integer _tmpIntervaloTempo;
        if (_cursor.isNull(_cursorIndexOfIntervaloTempo)) {
          _tmpIntervaloTempo = null;
        } else {
          _tmpIntervaloTempo = _cursor.getInt(_cursorIndexOfIntervaloTempo);
        }
        _item.setIntervaloTempo(_tmpIntervaloTempo);
        final String _tmpRazaoSocial;
        _tmpRazaoSocial = _cursor.getString(_cursorIndexOfRazaoSocial);
        _item.setRazaoSocial(_tmpRazaoSocial);
        final Double _tmpValorIndenizacaoAlta;
        if (_cursor.isNull(_cursorIndexOfValorIndenizacaoAlta)) {
          _tmpValorIndenizacaoAlta = null;
        } else {
          _tmpValorIndenizacaoAlta = _cursor.getDouble(_cursorIndexOfValorIndenizacaoAlta);
        }
        _item.setValorIndenizacaoAlta(_tmpValorIndenizacaoAlta);
        final Double _tmpValorIndenizacaoBaixa;
        if (_cursor.isNull(_cursorIndexOfValorIndenizacaoBaixa)) {
          _tmpValorIndenizacaoBaixa = null;
        } else {
          _tmpValorIndenizacaoBaixa = _cursor.getDouble(_cursorIndexOfValorIndenizacaoBaixa);
        }
        _item.setValorIndenizacaoBaixa(_tmpValorIndenizacaoBaixa);
        final Double _tmpValorIndenizacaoLS;
        if (_cursor.isNull(_cursorIndexOfValorIndenizacaoLS)) {
          _tmpValorIndenizacaoLS = null;
        } else {
          _tmpValorIndenizacaoLS = _cursor.getDouble(_cursorIndexOfValorIndenizacaoLS);
        }
        _item.setValorIndenizacaoLS(_tmpValorIndenizacaoLS);
        final String _tmpIntegDI;
        _tmpIntegDI = _cursor.getString(_cursorIndexOfIntegDI);
        _item.setIntegDI(_tmpIntegDI);
        final String _tmpDescDesp1;
        _tmpDescDesp1 = _cursor.getString(_cursorIndexOfDescDesp1);
        _item.setDescDesp1(_tmpDescDesp1);
        final String _tmpDescDesp2;
        _tmpDescDesp2 = _cursor.getString(_cursorIndexOfDescDesp2);
        _item.setDescDesp2(_tmpDescDesp2);
        final String _tmpDescDesp3;
        _tmpDescDesp3 = _cursor.getString(_cursorIndexOfDescDesp3);
        _item.setDescDesp3(_tmpDescDesp3);
        final String _tmpDescDesp4;
        _tmpDescDesp4 = _cursor.getString(_cursorIndexOfDescDesp4);
        _item.setDescDesp4(_tmpDescDesp4);
        final String _tmpAdicionarCliente;
        _tmpAdicionarCliente = _cursor.getString(_cursorIndexOfAdicionarCliente);
        _item.setAdicionarCliente(_tmpAdicionarCliente);
        final String _tmpAlterarPrecoObc;
        _tmpAlterarPrecoObc = _cursor.getString(_cursorIndexOfAlterarPrecoObc);
        _item.setAlterarPrecoObc(_tmpAlterarPrecoObc);
        final String _tmpSolicitarOdometroParada;
        _tmpSolicitarOdometroParada = _cursor.getString(_cursorIndexOfSolicitarOdometroParada);
        _item.setSolicitarOdometroParada(_tmpSolicitarOdometroParada);
        final String _tmpPermitirTroca;
        _tmpPermitirTroca = _cursor.getString(_cursorIndexOfPermitirTroca);
        _item.setPermitirTroca(_tmpPermitirTroca);
        final String _tmpTipoFilial;
        _tmpTipoFilial = _cursor.getString(_cursorIndexOfTipoFilial);
        _item.setTipoFilial(_tmpTipoFilial);
        final String _tmpForcarContagemFisica;
        _tmpForcarContagemFisica = _cursor.getString(_cursorIndexOfForcarContagemFisica);
        _item.setForcarContagemFisica(_tmpForcarContagemFisica);
        final String _tmpUltimaContagemSenha;
        _tmpUltimaContagemSenha = _cursor.getString(_cursorIndexOfUltimaContagemSenha);
        _item.setUltimaContagemSenha(_tmpUltimaContagemSenha);
        final String _tmpImprimirVariacaoPreco;
        _tmpImprimirVariacaoPreco = _cursor.getString(_cursorIndexOfImprimirVariacaoPreco);
        _item.setImprimirVariacaoPreco(_tmpImprimirVariacaoPreco);
        final String _tmpSenhaComunicacao;
        _tmpSenhaComunicacao = _cursor.getString(_cursorIndexOfSenhaComunicacao);
        _item.setSenhaComunicacao(_tmpSenhaComunicacao);
        final String _tmpHabilitarImpressora;
        _tmpHabilitarImpressora = _cursor.getString(_cursorIndexOfHabilitarImpressora);
        _item.setHabilitarImpressora(_tmpHabilitarImpressora);
        final String _tmpFatiaAutomaticaPreco;
        _tmpFatiaAutomaticaPreco = _cursor.getString(_cursorIndexOfFatiaAutomaticaPreco);
        _item.setFatiaAutomaticaPreco(_tmpFatiaAutomaticaPreco);
        final String _tmpImprimirPreorderDepois;
        _tmpImprimirPreorderDepois = _cursor.getString(_cursorIndexOfImprimirPreorderDepois);
        _item.setImprimirPreorderDepois(_tmpImprimirPreorderDepois);
        final String _tmpFlPrecoPreorder;
        _tmpFlPrecoPreorder = _cursor.getString(_cursorIndexOfFlPrecoPreorder);
        _item.setFlPrecoPreorder(_tmpFlPrecoPreorder);
        final Integer _tmpStatusRastrebilidade;
        if (_cursor.isNull(_cursorIndexOfStatusRastrebilidade)) {
          _tmpStatusRastrebilidade = null;
        } else {
          _tmpStatusRastrebilidade = _cursor.getInt(_cursorIndexOfStatusRastrebilidade);
        }
        _item.setStatusRastrebilidade(_tmpStatusRastrebilidade);
        final String _tmpTipoImpressao;
        _tmpTipoImpressao = _cursor.getString(_cursorIndexOfTipoImpressao);
        _item.setTipoImpressao(_tmpTipoImpressao);
        final String _tmpTipoImpressora;
        _tmpTipoImpressora = _cursor.getString(_cursorIndexOfTipoImpressora);
        _item.setTipoImpressora(_tmpTipoImpressora);
        final String _tmpMostrarDescontoMotorista;
        _tmpMostrarDescontoMotorista = _cursor.getString(_cursorIndexOfMostrarDescontoMotorista);
        _item.setMostrarDescontoMotorista(_tmpMostrarDescontoMotorista);
        final String _tmpImprimirQtdNota;
        _tmpImprimirQtdNota = _cursor.getString(_cursorIndexOfImprimirQtdNota);
        _item.setImprimirQtdNota(_tmpImprimirQtdNota);
        final String _tmpImprimirContagem;
        _tmpImprimirContagem = _cursor.getString(_cursorIndexOfImprimirContagem);
        _item.setImprimirContagem(_tmpImprimirContagem);
        final Integer _tmpTipoCargaVeiculo;
        if (_cursor.isNull(_cursorIndexOfTipoCargaVeiculo)) {
          _tmpTipoCargaVeiculo = null;
        } else {
          _tmpTipoCargaVeiculo = _cursor.getInt(_cursorIndexOfTipoCargaVeiculo);
        }
        _item.setTipoCargaVeiculo(_tmpTipoCargaVeiculo);
        final String _tmpCheckDiscoVazio;
        _tmpCheckDiscoVazio = _cursor.getString(_cursorIndexOfCheckDiscoVazio);
        _item.setCheckDiscoVazio(_tmpCheckDiscoVazio);
        final String _tmpRelatorioAuditoria;
        _tmpRelatorioAuditoria = _cursor.getString(_cursorIndexOfRelatorioAuditoria);
        _item.setRelatorioAuditoria(_tmpRelatorioAuditoria);
        final String _tmpClienteSemServico;
        _tmpClienteSemServico = _cursor.getString(_cursorIndexOfClienteSemServico);
        _item.setClienteSemServico(_tmpClienteSemServico);
        final String _tmpAbatimento;
        _tmpAbatimento = _cursor.getString(_cursorIndexOfAbatimento);
        _item.setAbatimento(_tmpAbatimento);
        final String _tmpRegistroNota;
        _tmpRegistroNota = _cursor.getString(_cursorIndexOfRegistroNota);
        _item.setRegistroNota(_tmpRegistroNota);
        final String _tmpRelatorioDespesas;
        _tmpRelatorioDespesas = _cursor.getString(_cursorIndexOfRelatorioDespesas);
        _item.setRelatorioDespesas(_tmpRelatorioDespesas);
        final String _tmpAvaliacaoInventario;
        _tmpAvaliacaoInventario = _cursor.getString(_cursorIndexOfAvaliacaoInventario);
        _item.setAvaliacaoInventario(_tmpAvaliacaoInventario);
        final String _tmpResumoViriacao;
        _tmpResumoViriacao = _cursor.getString(_cursorIndexOfResumoViriacao);
        _item.setResumoViriacao(_tmpResumoViriacao);
        final String _tmpRelatorioData;
        _tmpRelatorioData = _cursor.getString(_cursorIndexOfRelatorioData);
        _item.setRelatorioData(_tmpRelatorioData);
        final String _tmpContaPagamento;
        _tmpContaPagamento = _cursor.getString(_cursorIndexOfContaPagamento);
        _item.setContaPagamento(_tmpContaPagamento);
        final String _tmpTransferencia;
        _tmpTransferencia = _cursor.getString(_cursorIndexOfTransferencia);
        _item.setTransferencia(_tmpTransferencia);
        final String _tmpDeposito;
        _tmpDeposito = _cursor.getString(_cursorIndexOfDeposito);
        _item.setDeposito(_tmpDeposito);
        final String _tmpViagemMultipla;
        _tmpViagemMultipla = _cursor.getString(_cursorIndexOfViagemMultipla);
        _item.setViagemMultipla(_tmpViagemMultipla);
        final String _tmpMedidorVazao;
        _tmpMedidorVazao = _cursor.getString(_cursorIndexOfMedidorVazao);
        _item.setMedidorVazao(_tmpMedidorVazao);
        final String _tmpObc6110;
        _tmpObc6110 = _cursor.getString(_cursorIndexOfObc6110);
        _item.setObc6110(_tmpObc6110);
        final String _tmpAtivarRastreabilidade;
        _tmpAtivarRastreabilidade = _cursor.getString(_cursorIndexOfAtivarRastreabilidade);
        _item.setAtivarRastreabilidade(_tmpAtivarRastreabilidade);
        final String _tmpRazaoSocialTransp;
        _tmpRazaoSocialTransp = _cursor.getString(_cursorIndexOfRazaoSocialTransp);
        _item.setRazaoSocialTransp(_tmpRazaoSocialTransp);
        final String _tmpEnderecoTrasnp;
        _tmpEnderecoTrasnp = _cursor.getString(_cursorIndexOfEnderecoTrasnp);
        _item.setEnderecoTrasnp(_tmpEnderecoTrasnp);
        final String _tmpCidadeTransp;
        _tmpCidadeTransp = _cursor.getString(_cursorIndexOfCidadeTransp);
        _item.setCidadeTransp(_tmpCidadeTransp);
        final String _tmpEstadoTransp;
        _tmpEstadoTransp = _cursor.getString(_cursorIndexOfEstadoTransp);
        _item.setEstadoTransp(_tmpEstadoTransp);
        final String _tmpPlacaVeiculo;
        _tmpPlacaVeiculo = _cursor.getString(_cursorIndexOfPlacaVeiculo);
        _item.setPlacaVeiculo(_tmpPlacaVeiculo);
        final String _tmpUfVeiculo;
        _tmpUfVeiculo = _cursor.getString(_cursorIndexOfUfVeiculo);
        _item.setUfVeiculo(_tmpUfVeiculo);
        final String _tmpTipoCnpjTransp;
        _tmpTipoCnpjTransp = _cursor.getString(_cursorIndexOfTipoCnpjTransp);
        _item.setTipoCnpjTransp(_tmpTipoCnpjTransp);
        final String _tmpCnpjTransp;
        _tmpCnpjTransp = _cursor.getString(_cursorIndexOfCnpjTransp);
        _item.setCnpjTransp(_tmpCnpjTransp);
        final String _tmpTipoPagamento;
        _tmpTipoPagamento = _cursor.getString(_cursorIndexOfTipoPagamento);
        _item.setTipoPagamento(_tmpTipoPagamento);
        final String _tmpReimprimirNota;
        _tmpReimprimirNota = _cursor.getString(_cursorIndexOfReimprimirNota);
        _item.setReimprimirNota(_tmpReimprimirNota);
        final String _tmpRemeterPara;
        _tmpRemeterPara = _cursor.getString(_cursorIndexOfRemeterPara);
        _item.setRemeterPara(_tmpRemeterPara);
        final String _tmpSetupModem;
        _tmpSetupModem = _cursor.getString(_cursorIndexOfSetupModem);
        _item.setSetupModem(_tmpSetupModem);
        final String _tmpTipoDiscagem;
        _tmpTipoDiscagem = _cursor.getString(_cursorIndexOfTipoDiscagem);
        _item.setTipoDiscagem(_tmpTipoDiscagem);
        final String _tmpTipoConexao;
        _tmpTipoConexao = _cursor.getString(_cursorIndexOfTipoConexao);
        _item.setTipoConexao(_tmpTipoConexao);
        final Date _tmpDataViagem;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfDataViagem)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfDataViagem);
        }
        _tmpDataViagem = DateTypeConverter.fromTimestamp(_tmp);
        _item.setDataViagem(_tmpDataViagem);
        final String _tmpImei;
        _tmpImei = _cursor.getString(_cursorIndexOfImei);
        _item.setImei(_tmpImei);
        final String _tmpBloqViagem;
        _tmpBloqViagem = _cursor.getString(_cursorIndexOfBloqViagem);
        _item.setBloqViagem(_tmpBloqViagem);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Route getRoute() {
    final String _sql = "SELECT * FROM Route LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCdFilial = _cursor.getColumnIndexOrThrow("cdFilial");
      final int _cursorIndexOfNumAlmoxarifado = _cursor.getColumnIndexOrThrow("numAlmoxarifado");
      final int _cursorIndexOfCdRota = _cursor.getColumnIndexOrThrow("cdRota");
      final int _cursorIndexOfNumVeiculo = _cursor.getColumnIndexOrThrow("numVeiculo");
      final int _cursorIndexOfNumeroMotorista = _cursor.getColumnIndexOrThrow("numeroMotorista");
      final int _cursorIndexOfNumeroViagem = _cursor.getColumnIndexOrThrow("numeroViagem");
      final int _cursorIndexOfCdFilialJde = _cursor.getColumnIndexOrThrow("cdFilialJde");
      final int _cursorIndexOfCdCompanhia = _cursor.getColumnIndexOrThrow("cdCompanhia");
      final int _cursorIndexOfPesquisaHabilitada = _cursor.getColumnIndexOrThrow("pesquisaHabilitada");
      final int _cursorIndexOfModeloDoc = _cursor.getColumnIndexOrThrow("modeloDoc");
      final int _cursorIndexOfModeloCec = _cursor.getColumnIndexOrThrow("modeloCec");
      final int _cursorIndexOfNomeFilial = _cursor.getColumnIndexOrThrow("nomeFilial");
      final int _cursorIndexOfEndereco = _cursor.getColumnIndexOrThrow("endereco");
      final int _cursorIndexOfBairro = _cursor.getColumnIndexOrThrow("bairro");
      final int _cursorIndexOfCidade = _cursor.getColumnIndexOrThrow("cidade");
      final int _cursorIndexOfUf = _cursor.getColumnIndexOrThrow("uf");
      final int _cursorIndexOfCep = _cursor.getColumnIndexOrThrow("cep");
      final int _cursorIndexOfTipoCnpj = _cursor.getColumnIndexOrThrow("tipoCnpj");
      final int _cursorIndexOfCnpj = _cursor.getColumnIndexOrThrow("cnpj");
      final int _cursorIndexOfInscEstadual = _cursor.getColumnIndexOrThrow("inscEstadual");
      final int _cursorIndexOfTelefone = _cursor.getColumnIndexOrThrow("telefone");
      final int _cursorIndexOfNumeroModem = _cursor.getColumnIndexOrThrow("numeroModem");
      final int _cursorIndexOfIntervalo = _cursor.getColumnIndexOrThrow("intervalo");
      final int _cursorIndexOfIntervaloTempo = _cursor.getColumnIndexOrThrow("intervaloTempo");
      final int _cursorIndexOfRazaoSocial = _cursor.getColumnIndexOrThrow("razaoSocial");
      final int _cursorIndexOfValorIndenizacaoAlta = _cursor.getColumnIndexOrThrow("valorIndenizacaoAlta");
      final int _cursorIndexOfValorIndenizacaoBaixa = _cursor.getColumnIndexOrThrow("valorIndenizacaoBaixa");
      final int _cursorIndexOfValorIndenizacaoLS = _cursor.getColumnIndexOrThrow("valorIndenizacaoLS");
      final int _cursorIndexOfIntegDI = _cursor.getColumnIndexOrThrow("integDI");
      final int _cursorIndexOfDescDesp1 = _cursor.getColumnIndexOrThrow("descDesp1");
      final int _cursorIndexOfDescDesp2 = _cursor.getColumnIndexOrThrow("descDesp2");
      final int _cursorIndexOfDescDesp3 = _cursor.getColumnIndexOrThrow("descDesp3");
      final int _cursorIndexOfDescDesp4 = _cursor.getColumnIndexOrThrow("descDesp4");
      final int _cursorIndexOfAdicionarCliente = _cursor.getColumnIndexOrThrow("adicionarCliente");
      final int _cursorIndexOfAlterarPrecoObc = _cursor.getColumnIndexOrThrow("alterarPrecoObc");
      final int _cursorIndexOfSolicitarOdometroParada = _cursor.getColumnIndexOrThrow("solicitarOdometroParada");
      final int _cursorIndexOfPermitirTroca = _cursor.getColumnIndexOrThrow("permitirTroca");
      final int _cursorIndexOfTipoFilial = _cursor.getColumnIndexOrThrow("tipoFilial");
      final int _cursorIndexOfForcarContagemFisica = _cursor.getColumnIndexOrThrow("forcarContagemFisica");
      final int _cursorIndexOfUltimaContagemSenha = _cursor.getColumnIndexOrThrow("ultimaContagemSenha");
      final int _cursorIndexOfImprimirVariacaoPreco = _cursor.getColumnIndexOrThrow("imprimirVariacaoPreco");
      final int _cursorIndexOfSenhaComunicacao = _cursor.getColumnIndexOrThrow("senhaComunicacao");
      final int _cursorIndexOfHabilitarImpressora = _cursor.getColumnIndexOrThrow("habilitarImpressora");
      final int _cursorIndexOfFatiaAutomaticaPreco = _cursor.getColumnIndexOrThrow("fatiaAutomaticaPreco");
      final int _cursorIndexOfImprimirPreorderDepois = _cursor.getColumnIndexOrThrow("imprimirPreorderDepois");
      final int _cursorIndexOfFlPrecoPreorder = _cursor.getColumnIndexOrThrow("flPrecoPreorder");
      final int _cursorIndexOfStatusRastrebilidade = _cursor.getColumnIndexOrThrow("statusRastrebilidade");
      final int _cursorIndexOfTipoImpressao = _cursor.getColumnIndexOrThrow("tipoImpressao");
      final int _cursorIndexOfTipoImpressora = _cursor.getColumnIndexOrThrow("tipoImpressora");
      final int _cursorIndexOfMostrarDescontoMotorista = _cursor.getColumnIndexOrThrow("mostrarDescontoMotorista");
      final int _cursorIndexOfImprimirQtdNota = _cursor.getColumnIndexOrThrow("imprimirQtdNota");
      final int _cursorIndexOfImprimirContagem = _cursor.getColumnIndexOrThrow("imprimirContagem");
      final int _cursorIndexOfTipoCargaVeiculo = _cursor.getColumnIndexOrThrow("tipoCargaVeiculo");
      final int _cursorIndexOfCheckDiscoVazio = _cursor.getColumnIndexOrThrow("checkDiscoVazio");
      final int _cursorIndexOfRelatorioAuditoria = _cursor.getColumnIndexOrThrow("relatorioAuditoria");
      final int _cursorIndexOfClienteSemServico = _cursor.getColumnIndexOrThrow("clienteSemServico");
      final int _cursorIndexOfAbatimento = _cursor.getColumnIndexOrThrow("abatimento");
      final int _cursorIndexOfRegistroNota = _cursor.getColumnIndexOrThrow("registroNota");
      final int _cursorIndexOfRelatorioDespesas = _cursor.getColumnIndexOrThrow("relatorioDespesas");
      final int _cursorIndexOfAvaliacaoInventario = _cursor.getColumnIndexOrThrow("avaliacaoInventario");
      final int _cursorIndexOfResumoViriacao = _cursor.getColumnIndexOrThrow("resumoViriacao");
      final int _cursorIndexOfRelatorioData = _cursor.getColumnIndexOrThrow("relatorioData");
      final int _cursorIndexOfContaPagamento = _cursor.getColumnIndexOrThrow("contaPagamento");
      final int _cursorIndexOfTransferencia = _cursor.getColumnIndexOrThrow("transferencia");
      final int _cursorIndexOfDeposito = _cursor.getColumnIndexOrThrow("deposito");
      final int _cursorIndexOfViagemMultipla = _cursor.getColumnIndexOrThrow("viagemMultipla");
      final int _cursorIndexOfMedidorVazao = _cursor.getColumnIndexOrThrow("medidorVazao");
      final int _cursorIndexOfObc6110 = _cursor.getColumnIndexOrThrow("obc6110");
      final int _cursorIndexOfAtivarRastreabilidade = _cursor.getColumnIndexOrThrow("ativarRastreabilidade");
      final int _cursorIndexOfRazaoSocialTransp = _cursor.getColumnIndexOrThrow("razaoSocialTransp");
      final int _cursorIndexOfEnderecoTrasnp = _cursor.getColumnIndexOrThrow("enderecoTrasnp");
      final int _cursorIndexOfCidadeTransp = _cursor.getColumnIndexOrThrow("cidadeTransp");
      final int _cursorIndexOfEstadoTransp = _cursor.getColumnIndexOrThrow("estadoTransp");
      final int _cursorIndexOfPlacaVeiculo = _cursor.getColumnIndexOrThrow("placaVeiculo");
      final int _cursorIndexOfUfVeiculo = _cursor.getColumnIndexOrThrow("UfVeiculo");
      final int _cursorIndexOfTipoCnpjTransp = _cursor.getColumnIndexOrThrow("tipoCnpjTransp");
      final int _cursorIndexOfCnpjTransp = _cursor.getColumnIndexOrThrow("cnpjTransp");
      final int _cursorIndexOfTipoPagamento = _cursor.getColumnIndexOrThrow("tipoPagamento");
      final int _cursorIndexOfReimprimirNota = _cursor.getColumnIndexOrThrow("reimprimirNota");
      final int _cursorIndexOfRemeterPara = _cursor.getColumnIndexOrThrow("remeterPara");
      final int _cursorIndexOfSetupModem = _cursor.getColumnIndexOrThrow("setupModem");
      final int _cursorIndexOfTipoDiscagem = _cursor.getColumnIndexOrThrow("tipoDiscagem");
      final int _cursorIndexOfTipoConexao = _cursor.getColumnIndexOrThrow("tipoConexao");
      final int _cursorIndexOfDataViagem = _cursor.getColumnIndexOrThrow("dataViagem");
      final int _cursorIndexOfImei = _cursor.getColumnIndexOrThrow("imei");
      final int _cursorIndexOfBloqViagem = _cursor.getColumnIndexOrThrow("bloqViagem");
      final Route _result;
      if(_cursor.moveToFirst()) {
        _result = new Route();
        final String _tmpCdFilial;
        _tmpCdFilial = _cursor.getString(_cursorIndexOfCdFilial);
        _result.setCdFilial(_tmpCdFilial);
        final String _tmpNumAlmoxarifado;
        _tmpNumAlmoxarifado = _cursor.getString(_cursorIndexOfNumAlmoxarifado);
        _result.setNumAlmoxarifado(_tmpNumAlmoxarifado);
        final Integer _tmpCdRota;
        if (_cursor.isNull(_cursorIndexOfCdRota)) {
          _tmpCdRota = null;
        } else {
          _tmpCdRota = _cursor.getInt(_cursorIndexOfCdRota);
        }
        _result.setCdRota(_tmpCdRota);
        final String _tmpNumVeiculo;
        _tmpNumVeiculo = _cursor.getString(_cursorIndexOfNumVeiculo);
        _result.setNumVeiculo(_tmpNumVeiculo);
        final String _tmpNumeroMotorista;
        _tmpNumeroMotorista = _cursor.getString(_cursorIndexOfNumeroMotorista);
        _result.setNumeroMotorista(_tmpNumeroMotorista);
        final Long _tmpNumeroViagem;
        if (_cursor.isNull(_cursorIndexOfNumeroViagem)) {
          _tmpNumeroViagem = null;
        } else {
          _tmpNumeroViagem = _cursor.getLong(_cursorIndexOfNumeroViagem);
        }
        _result.setNumeroViagem(_tmpNumeroViagem);
        final String _tmpCdFilialJde;
        _tmpCdFilialJde = _cursor.getString(_cursorIndexOfCdFilialJde);
        _result.setCdFilialJde(_tmpCdFilialJde);
        final String _tmpCdCompanhia;
        _tmpCdCompanhia = _cursor.getString(_cursorIndexOfCdCompanhia);
        _result.setCdCompanhia(_tmpCdCompanhia);
        final String _tmpPesquisaHabilitada;
        _tmpPesquisaHabilitada = _cursor.getString(_cursorIndexOfPesquisaHabilitada);
        _result.setPesquisaHabilitada(_tmpPesquisaHabilitada);
        final String _tmpModeloDoc;
        _tmpModeloDoc = _cursor.getString(_cursorIndexOfModeloDoc);
        _result.setModeloDoc(_tmpModeloDoc);
        final String _tmpModeloCec;
        _tmpModeloCec = _cursor.getString(_cursorIndexOfModeloCec);
        _result.setModeloCec(_tmpModeloCec);
        final String _tmpNomeFilial;
        _tmpNomeFilial = _cursor.getString(_cursorIndexOfNomeFilial);
        _result.setNomeFilial(_tmpNomeFilial);
        final String _tmpEndereco;
        _tmpEndereco = _cursor.getString(_cursorIndexOfEndereco);
        _result.setEndereco(_tmpEndereco);
        final String _tmpBairro;
        _tmpBairro = _cursor.getString(_cursorIndexOfBairro);
        _result.setBairro(_tmpBairro);
        final String _tmpCidade;
        _tmpCidade = _cursor.getString(_cursorIndexOfCidade);
        _result.setCidade(_tmpCidade);
        final String _tmpUf;
        _tmpUf = _cursor.getString(_cursorIndexOfUf);
        _result.setUf(_tmpUf);
        final String _tmpCep;
        _tmpCep = _cursor.getString(_cursorIndexOfCep);
        _result.setCep(_tmpCep);
        final String _tmpTipoCnpj;
        _tmpTipoCnpj = _cursor.getString(_cursorIndexOfTipoCnpj);
        _result.setTipoCnpj(_tmpTipoCnpj);
        final String _tmpCnpj;
        _tmpCnpj = _cursor.getString(_cursorIndexOfCnpj);
        _result.setCnpj(_tmpCnpj);
        final String _tmpInscEstadual;
        _tmpInscEstadual = _cursor.getString(_cursorIndexOfInscEstadual);
        _result.setInscEstadual(_tmpInscEstadual);
        final String _tmpTelefone;
        _tmpTelefone = _cursor.getString(_cursorIndexOfTelefone);
        _result.setTelefone(_tmpTelefone);
        final String _tmpNumeroModem;
        _tmpNumeroModem = _cursor.getString(_cursorIndexOfNumeroModem);
        _result.setNumeroModem(_tmpNumeroModem);
        final Integer _tmpIntervalo;
        if (_cursor.isNull(_cursorIndexOfIntervalo)) {
          _tmpIntervalo = null;
        } else {
          _tmpIntervalo = _cursor.getInt(_cursorIndexOfIntervalo);
        }
        _result.setIntervalo(_tmpIntervalo);
        final Integer _tmpIntervaloTempo;
        if (_cursor.isNull(_cursorIndexOfIntervaloTempo)) {
          _tmpIntervaloTempo = null;
        } else {
          _tmpIntervaloTempo = _cursor.getInt(_cursorIndexOfIntervaloTempo);
        }
        _result.setIntervaloTempo(_tmpIntervaloTempo);
        final String _tmpRazaoSocial;
        _tmpRazaoSocial = _cursor.getString(_cursorIndexOfRazaoSocial);
        _result.setRazaoSocial(_tmpRazaoSocial);
        final Double _tmpValorIndenizacaoAlta;
        if (_cursor.isNull(_cursorIndexOfValorIndenizacaoAlta)) {
          _tmpValorIndenizacaoAlta = null;
        } else {
          _tmpValorIndenizacaoAlta = _cursor.getDouble(_cursorIndexOfValorIndenizacaoAlta);
        }
        _result.setValorIndenizacaoAlta(_tmpValorIndenizacaoAlta);
        final Double _tmpValorIndenizacaoBaixa;
        if (_cursor.isNull(_cursorIndexOfValorIndenizacaoBaixa)) {
          _tmpValorIndenizacaoBaixa = null;
        } else {
          _tmpValorIndenizacaoBaixa = _cursor.getDouble(_cursorIndexOfValorIndenizacaoBaixa);
        }
        _result.setValorIndenizacaoBaixa(_tmpValorIndenizacaoBaixa);
        final Double _tmpValorIndenizacaoLS;
        if (_cursor.isNull(_cursorIndexOfValorIndenizacaoLS)) {
          _tmpValorIndenizacaoLS = null;
        } else {
          _tmpValorIndenizacaoLS = _cursor.getDouble(_cursorIndexOfValorIndenizacaoLS);
        }
        _result.setValorIndenizacaoLS(_tmpValorIndenizacaoLS);
        final String _tmpIntegDI;
        _tmpIntegDI = _cursor.getString(_cursorIndexOfIntegDI);
        _result.setIntegDI(_tmpIntegDI);
        final String _tmpDescDesp1;
        _tmpDescDesp1 = _cursor.getString(_cursorIndexOfDescDesp1);
        _result.setDescDesp1(_tmpDescDesp1);
        final String _tmpDescDesp2;
        _tmpDescDesp2 = _cursor.getString(_cursorIndexOfDescDesp2);
        _result.setDescDesp2(_tmpDescDesp2);
        final String _tmpDescDesp3;
        _tmpDescDesp3 = _cursor.getString(_cursorIndexOfDescDesp3);
        _result.setDescDesp3(_tmpDescDesp3);
        final String _tmpDescDesp4;
        _tmpDescDesp4 = _cursor.getString(_cursorIndexOfDescDesp4);
        _result.setDescDesp4(_tmpDescDesp4);
        final String _tmpAdicionarCliente;
        _tmpAdicionarCliente = _cursor.getString(_cursorIndexOfAdicionarCliente);
        _result.setAdicionarCliente(_tmpAdicionarCliente);
        final String _tmpAlterarPrecoObc;
        _tmpAlterarPrecoObc = _cursor.getString(_cursorIndexOfAlterarPrecoObc);
        _result.setAlterarPrecoObc(_tmpAlterarPrecoObc);
        final String _tmpSolicitarOdometroParada;
        _tmpSolicitarOdometroParada = _cursor.getString(_cursorIndexOfSolicitarOdometroParada);
        _result.setSolicitarOdometroParada(_tmpSolicitarOdometroParada);
        final String _tmpPermitirTroca;
        _tmpPermitirTroca = _cursor.getString(_cursorIndexOfPermitirTroca);
        _result.setPermitirTroca(_tmpPermitirTroca);
        final String _tmpTipoFilial;
        _tmpTipoFilial = _cursor.getString(_cursorIndexOfTipoFilial);
        _result.setTipoFilial(_tmpTipoFilial);
        final String _tmpForcarContagemFisica;
        _tmpForcarContagemFisica = _cursor.getString(_cursorIndexOfForcarContagemFisica);
        _result.setForcarContagemFisica(_tmpForcarContagemFisica);
        final String _tmpUltimaContagemSenha;
        _tmpUltimaContagemSenha = _cursor.getString(_cursorIndexOfUltimaContagemSenha);
        _result.setUltimaContagemSenha(_tmpUltimaContagemSenha);
        final String _tmpImprimirVariacaoPreco;
        _tmpImprimirVariacaoPreco = _cursor.getString(_cursorIndexOfImprimirVariacaoPreco);
        _result.setImprimirVariacaoPreco(_tmpImprimirVariacaoPreco);
        final String _tmpSenhaComunicacao;
        _tmpSenhaComunicacao = _cursor.getString(_cursorIndexOfSenhaComunicacao);
        _result.setSenhaComunicacao(_tmpSenhaComunicacao);
        final String _tmpHabilitarImpressora;
        _tmpHabilitarImpressora = _cursor.getString(_cursorIndexOfHabilitarImpressora);
        _result.setHabilitarImpressora(_tmpHabilitarImpressora);
        final String _tmpFatiaAutomaticaPreco;
        _tmpFatiaAutomaticaPreco = _cursor.getString(_cursorIndexOfFatiaAutomaticaPreco);
        _result.setFatiaAutomaticaPreco(_tmpFatiaAutomaticaPreco);
        final String _tmpImprimirPreorderDepois;
        _tmpImprimirPreorderDepois = _cursor.getString(_cursorIndexOfImprimirPreorderDepois);
        _result.setImprimirPreorderDepois(_tmpImprimirPreorderDepois);
        final String _tmpFlPrecoPreorder;
        _tmpFlPrecoPreorder = _cursor.getString(_cursorIndexOfFlPrecoPreorder);
        _result.setFlPrecoPreorder(_tmpFlPrecoPreorder);
        final Integer _tmpStatusRastrebilidade;
        if (_cursor.isNull(_cursorIndexOfStatusRastrebilidade)) {
          _tmpStatusRastrebilidade = null;
        } else {
          _tmpStatusRastrebilidade = _cursor.getInt(_cursorIndexOfStatusRastrebilidade);
        }
        _result.setStatusRastrebilidade(_tmpStatusRastrebilidade);
        final String _tmpTipoImpressao;
        _tmpTipoImpressao = _cursor.getString(_cursorIndexOfTipoImpressao);
        _result.setTipoImpressao(_tmpTipoImpressao);
        final String _tmpTipoImpressora;
        _tmpTipoImpressora = _cursor.getString(_cursorIndexOfTipoImpressora);
        _result.setTipoImpressora(_tmpTipoImpressora);
        final String _tmpMostrarDescontoMotorista;
        _tmpMostrarDescontoMotorista = _cursor.getString(_cursorIndexOfMostrarDescontoMotorista);
        _result.setMostrarDescontoMotorista(_tmpMostrarDescontoMotorista);
        final String _tmpImprimirQtdNota;
        _tmpImprimirQtdNota = _cursor.getString(_cursorIndexOfImprimirQtdNota);
        _result.setImprimirQtdNota(_tmpImprimirQtdNota);
        final String _tmpImprimirContagem;
        _tmpImprimirContagem = _cursor.getString(_cursorIndexOfImprimirContagem);
        _result.setImprimirContagem(_tmpImprimirContagem);
        final Integer _tmpTipoCargaVeiculo;
        if (_cursor.isNull(_cursorIndexOfTipoCargaVeiculo)) {
          _tmpTipoCargaVeiculo = null;
        } else {
          _tmpTipoCargaVeiculo = _cursor.getInt(_cursorIndexOfTipoCargaVeiculo);
        }
        _result.setTipoCargaVeiculo(_tmpTipoCargaVeiculo);
        final String _tmpCheckDiscoVazio;
        _tmpCheckDiscoVazio = _cursor.getString(_cursorIndexOfCheckDiscoVazio);
        _result.setCheckDiscoVazio(_tmpCheckDiscoVazio);
        final String _tmpRelatorioAuditoria;
        _tmpRelatorioAuditoria = _cursor.getString(_cursorIndexOfRelatorioAuditoria);
        _result.setRelatorioAuditoria(_tmpRelatorioAuditoria);
        final String _tmpClienteSemServico;
        _tmpClienteSemServico = _cursor.getString(_cursorIndexOfClienteSemServico);
        _result.setClienteSemServico(_tmpClienteSemServico);
        final String _tmpAbatimento;
        _tmpAbatimento = _cursor.getString(_cursorIndexOfAbatimento);
        _result.setAbatimento(_tmpAbatimento);
        final String _tmpRegistroNota;
        _tmpRegistroNota = _cursor.getString(_cursorIndexOfRegistroNota);
        _result.setRegistroNota(_tmpRegistroNota);
        final String _tmpRelatorioDespesas;
        _tmpRelatorioDespesas = _cursor.getString(_cursorIndexOfRelatorioDespesas);
        _result.setRelatorioDespesas(_tmpRelatorioDespesas);
        final String _tmpAvaliacaoInventario;
        _tmpAvaliacaoInventario = _cursor.getString(_cursorIndexOfAvaliacaoInventario);
        _result.setAvaliacaoInventario(_tmpAvaliacaoInventario);
        final String _tmpResumoViriacao;
        _tmpResumoViriacao = _cursor.getString(_cursorIndexOfResumoViriacao);
        _result.setResumoViriacao(_tmpResumoViriacao);
        final String _tmpRelatorioData;
        _tmpRelatorioData = _cursor.getString(_cursorIndexOfRelatorioData);
        _result.setRelatorioData(_tmpRelatorioData);
        final String _tmpContaPagamento;
        _tmpContaPagamento = _cursor.getString(_cursorIndexOfContaPagamento);
        _result.setContaPagamento(_tmpContaPagamento);
        final String _tmpTransferencia;
        _tmpTransferencia = _cursor.getString(_cursorIndexOfTransferencia);
        _result.setTransferencia(_tmpTransferencia);
        final String _tmpDeposito;
        _tmpDeposito = _cursor.getString(_cursorIndexOfDeposito);
        _result.setDeposito(_tmpDeposito);
        final String _tmpViagemMultipla;
        _tmpViagemMultipla = _cursor.getString(_cursorIndexOfViagemMultipla);
        _result.setViagemMultipla(_tmpViagemMultipla);
        final String _tmpMedidorVazao;
        _tmpMedidorVazao = _cursor.getString(_cursorIndexOfMedidorVazao);
        _result.setMedidorVazao(_tmpMedidorVazao);
        final String _tmpObc6110;
        _tmpObc6110 = _cursor.getString(_cursorIndexOfObc6110);
        _result.setObc6110(_tmpObc6110);
        final String _tmpAtivarRastreabilidade;
        _tmpAtivarRastreabilidade = _cursor.getString(_cursorIndexOfAtivarRastreabilidade);
        _result.setAtivarRastreabilidade(_tmpAtivarRastreabilidade);
        final String _tmpRazaoSocialTransp;
        _tmpRazaoSocialTransp = _cursor.getString(_cursorIndexOfRazaoSocialTransp);
        _result.setRazaoSocialTransp(_tmpRazaoSocialTransp);
        final String _tmpEnderecoTrasnp;
        _tmpEnderecoTrasnp = _cursor.getString(_cursorIndexOfEnderecoTrasnp);
        _result.setEnderecoTrasnp(_tmpEnderecoTrasnp);
        final String _tmpCidadeTransp;
        _tmpCidadeTransp = _cursor.getString(_cursorIndexOfCidadeTransp);
        _result.setCidadeTransp(_tmpCidadeTransp);
        final String _tmpEstadoTransp;
        _tmpEstadoTransp = _cursor.getString(_cursorIndexOfEstadoTransp);
        _result.setEstadoTransp(_tmpEstadoTransp);
        final String _tmpPlacaVeiculo;
        _tmpPlacaVeiculo = _cursor.getString(_cursorIndexOfPlacaVeiculo);
        _result.setPlacaVeiculo(_tmpPlacaVeiculo);
        final String _tmpUfVeiculo;
        _tmpUfVeiculo = _cursor.getString(_cursorIndexOfUfVeiculo);
        _result.setUfVeiculo(_tmpUfVeiculo);
        final String _tmpTipoCnpjTransp;
        _tmpTipoCnpjTransp = _cursor.getString(_cursorIndexOfTipoCnpjTransp);
        _result.setTipoCnpjTransp(_tmpTipoCnpjTransp);
        final String _tmpCnpjTransp;
        _tmpCnpjTransp = _cursor.getString(_cursorIndexOfCnpjTransp);
        _result.setCnpjTransp(_tmpCnpjTransp);
        final String _tmpTipoPagamento;
        _tmpTipoPagamento = _cursor.getString(_cursorIndexOfTipoPagamento);
        _result.setTipoPagamento(_tmpTipoPagamento);
        final String _tmpReimprimirNota;
        _tmpReimprimirNota = _cursor.getString(_cursorIndexOfReimprimirNota);
        _result.setReimprimirNota(_tmpReimprimirNota);
        final String _tmpRemeterPara;
        _tmpRemeterPara = _cursor.getString(_cursorIndexOfRemeterPara);
        _result.setRemeterPara(_tmpRemeterPara);
        final String _tmpSetupModem;
        _tmpSetupModem = _cursor.getString(_cursorIndexOfSetupModem);
        _result.setSetupModem(_tmpSetupModem);
        final String _tmpTipoDiscagem;
        _tmpTipoDiscagem = _cursor.getString(_cursorIndexOfTipoDiscagem);
        _result.setTipoDiscagem(_tmpTipoDiscagem);
        final String _tmpTipoConexao;
        _tmpTipoConexao = _cursor.getString(_cursorIndexOfTipoConexao);
        _result.setTipoConexao(_tmpTipoConexao);
        final Date _tmpDataViagem;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfDataViagem)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfDataViagem);
        }
        _tmpDataViagem = DateTypeConverter.fromTimestamp(_tmp);
        _result.setDataViagem(_tmpDataViagem);
        final String _tmpImei;
        _tmpImei = _cursor.getString(_cursorIndexOfImei);
        _result.setImei(_tmpImei);
        final String _tmpBloqViagem;
        _tmpBloqViagem = _cursor.getString(_cursorIndexOfBloqViagem);
        _result.setBloqViagem(_tmpBloqViagem);
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
