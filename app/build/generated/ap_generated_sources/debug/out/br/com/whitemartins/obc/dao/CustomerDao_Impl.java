package br.com.whitemartins.obc.dao;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import br.com.whitemartins.obc.database.DateTypeConverter;
import br.com.whitemartins.obc.model.Customer;
import br.com.whitemartins.obc.model.Patient;
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
public class CustomerDao_Impl implements CustomerDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfCustomer;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfCustomer;

  public CustomerDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCustomer = new EntityInsertionAdapter<Customer>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Customer`(`cdCustomer`,`nome`,`endereco`,`bairro`,`cidade`,`uf`,`cep`,`telefone`,`dtPesquisa`,`situacaoTributariaPis`,`situacaoTributariaCofins`,`cstPisE`,`cstPisS`,`cstCofinsE`,`cstCofinsS`,`flDistribGas`,`flPaciente`,`inscEstadual`,`tipoCnpjCpf`,`cnpj`,`flPesquisa`,`limiteCredito`,`dtVigencia`,`cdCiaFiscal`,`flReducaoIcms`,`flCredito`,`flSimplesFaturamento`,`permitirCheque`,`permitirFatura`,`permitirDinheiro`,`situacaoTributariaIpi`,`unidResponsaval`,`consumidorFinal`,`classeContrib`,`descontoIcmsOrgaoPublico`,`situacaoTributariaIcms`,`flFilialWm`,`nomeMotorista`,`nomeContato`,`cargoContato`,`telefoneContato`,`flNovoFaturamento`,`cdJdeOperadora`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Customer value) {
        if (value.getCdCustomer() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getCdCustomer());
        }
        if (value.getNome() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNome());
        }
        if (value.getEndereco() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getEndereco());
        }
        if (value.getBairro() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getBairro());
        }
        if (value.getCidade() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCidade());
        }
        if (value.getUf() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getUf());
        }
        if (value.getCep() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getCep());
        }
        if (value.getTelefone() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getTelefone());
        }
        final Long _tmp;
        _tmp = DateTypeConverter.dateToTimestamp(value.getDtPesquisa());
        if (_tmp == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, _tmp);
        }
        if (value.getSituacaoTributariaPis() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.getSituacaoTributariaPis());
        }
        if (value.getSituacaoTributariaCofins() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindLong(11, value.getSituacaoTributariaCofins());
        }
        if (value.getCstPisE() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getCstPisE());
        }
        if (value.getCstPisS() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getCstPisS());
        }
        if (value.getCstCofinsE() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getCstCofinsE());
        }
        if (value.getCstCofinsS() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getCstCofinsS());
        }
        if (value.getFlDistribGas() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getFlDistribGas());
        }
        if (value.getFlPaciente() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getFlPaciente());
        }
        if (value.getInscEstadual() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getInscEstadual());
        }
        if (value.getTipoCnpjCpf() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getTipoCnpjCpf());
        }
        if (value.getCnpj() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getCnpj());
        }
        if (value.getFlPesquisa() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getFlPesquisa());
        }
        if (value.getLimiteCredito() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindDouble(22, value.getLimiteCredito());
        }
        final Long _tmp_1;
        _tmp_1 = DateTypeConverter.dateToTimestamp(value.getDtVigencia());
        if (_tmp_1 == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindLong(23, _tmp_1);
        }
        if (value.getCdCiaFiscal() == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindLong(24, value.getCdCiaFiscal());
        }
        if (value.getFlReducaoIcms() == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindString(25, value.getFlReducaoIcms());
        }
        if (value.getFlCredito() == null) {
          stmt.bindNull(26);
        } else {
          stmt.bindString(26, value.getFlCredito());
        }
        if (value.getFlSimplesFaturamento() == null) {
          stmt.bindNull(27);
        } else {
          stmt.bindString(27, value.getFlSimplesFaturamento());
        }
        if (value.getPermitirCheque() == null) {
          stmt.bindNull(28);
        } else {
          stmt.bindString(28, value.getPermitirCheque());
        }
        if (value.getPermitirFatura() == null) {
          stmt.bindNull(29);
        } else {
          stmt.bindString(29, value.getPermitirFatura());
        }
        if (value.getPermitirDinheiro() == null) {
          stmt.bindNull(30);
        } else {
          stmt.bindString(30, value.getPermitirDinheiro());
        }
        if (value.getSituacaoTributariaIpi() == null) {
          stmt.bindNull(31);
        } else {
          stmt.bindLong(31, value.getSituacaoTributariaIpi());
        }
        if (value.getUnidResponsaval() == null) {
          stmt.bindNull(32);
        } else {
          stmt.bindString(32, value.getUnidResponsaval());
        }
        if (value.getConsumidorFinal() == null) {
          stmt.bindNull(33);
        } else {
          stmt.bindString(33, value.getConsumidorFinal());
        }
        if (value.getClasseContrib() == null) {
          stmt.bindNull(34);
        } else {
          stmt.bindLong(34, value.getClasseContrib());
        }
        if (value.getDescontoIcmsOrgaoPublico() == null) {
          stmt.bindNull(35);
        } else {
          stmt.bindLong(35, value.getDescontoIcmsOrgaoPublico());
        }
        if (value.getSituacaoTributariaIcms() == null) {
          stmt.bindNull(36);
        } else {
          stmt.bindLong(36, value.getSituacaoTributariaIcms());
        }
        if (value.getFlFilialWm() == null) {
          stmt.bindNull(37);
        } else {
          stmt.bindString(37, value.getFlFilialWm());
        }
        if (value.getNomeMotorista() == null) {
          stmt.bindNull(38);
        } else {
          stmt.bindString(38, value.getNomeMotorista());
        }
        if (value.getNomeContato() == null) {
          stmt.bindNull(39);
        } else {
          stmt.bindString(39, value.getNomeContato());
        }
        if (value.getCargoContato() == null) {
          stmt.bindNull(40);
        } else {
          stmt.bindString(40, value.getCargoContato());
        }
        if (value.getTelefoneContato() == null) {
          stmt.bindNull(41);
        } else {
          stmt.bindString(41, value.getTelefoneContato());
        }
        if (value.getFlNovoFaturamento() == null) {
          stmt.bindNull(42);
        } else {
          stmt.bindString(42, value.getFlNovoFaturamento());
        }
        if (value.getCdJdeOperadora() == null) {
          stmt.bindNull(43);
        } else {
          stmt.bindLong(43, value.getCdJdeOperadora());
        }
      }
    };
    this.__deletionAdapterOfCustomer = new EntityDeletionOrUpdateAdapter<Customer>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Customer` WHERE `cdCustomer` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Customer value) {
        if (value.getCdCustomer() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getCdCustomer());
        }
      }
    };
  }

  @Override
  public void insert(Customer customer) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfCustomer.insert(customer);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(Customer customer) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfCustomer.handle(customer);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll(List<Customer> customers) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfCustomer.handleMultiple(customers);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Customer> getAll() {
    final String _sql = "SELECT * FROM Customer";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfNome = _cursor.getColumnIndexOrThrow("nome");
      final int _cursorIndexOfEndereco = _cursor.getColumnIndexOrThrow("endereco");
      final int _cursorIndexOfBairro = _cursor.getColumnIndexOrThrow("bairro");
      final int _cursorIndexOfCidade = _cursor.getColumnIndexOrThrow("cidade");
      final int _cursorIndexOfUf = _cursor.getColumnIndexOrThrow("uf");
      final int _cursorIndexOfCep = _cursor.getColumnIndexOrThrow("cep");
      final int _cursorIndexOfTelefone = _cursor.getColumnIndexOrThrow("telefone");
      final int _cursorIndexOfDtPesquisa = _cursor.getColumnIndexOrThrow("dtPesquisa");
      final int _cursorIndexOfSituacaoTributariaPis = _cursor.getColumnIndexOrThrow("situacaoTributariaPis");
      final int _cursorIndexOfSituacaoTributariaCofins = _cursor.getColumnIndexOrThrow("situacaoTributariaCofins");
      final int _cursorIndexOfCstPisE = _cursor.getColumnIndexOrThrow("cstPisE");
      final int _cursorIndexOfCstPisS = _cursor.getColumnIndexOrThrow("cstPisS");
      final int _cursorIndexOfCstCofinsE = _cursor.getColumnIndexOrThrow("cstCofinsE");
      final int _cursorIndexOfCstCofinsS = _cursor.getColumnIndexOrThrow("cstCofinsS");
      final int _cursorIndexOfFlDistribGas = _cursor.getColumnIndexOrThrow("flDistribGas");
      final int _cursorIndexOfFlPaciente = _cursor.getColumnIndexOrThrow("flPaciente");
      final int _cursorIndexOfInscEstadual = _cursor.getColumnIndexOrThrow("inscEstadual");
      final int _cursorIndexOfTipoCnpjCpf = _cursor.getColumnIndexOrThrow("tipoCnpjCpf");
      final int _cursorIndexOfCnpj = _cursor.getColumnIndexOrThrow("cnpj");
      final int _cursorIndexOfFlPesquisa = _cursor.getColumnIndexOrThrow("flPesquisa");
      final int _cursorIndexOfLimiteCredito = _cursor.getColumnIndexOrThrow("limiteCredito");
      final int _cursorIndexOfDtVigencia = _cursor.getColumnIndexOrThrow("dtVigencia");
      final int _cursorIndexOfCdCiaFiscal = _cursor.getColumnIndexOrThrow("cdCiaFiscal");
      final int _cursorIndexOfFlReducaoIcms = _cursor.getColumnIndexOrThrow("flReducaoIcms");
      final int _cursorIndexOfFlCredito = _cursor.getColumnIndexOrThrow("flCredito");
      final int _cursorIndexOfFlSimplesFaturamento = _cursor.getColumnIndexOrThrow("flSimplesFaturamento");
      final int _cursorIndexOfPermitirCheque = _cursor.getColumnIndexOrThrow("permitirCheque");
      final int _cursorIndexOfPermitirFatura = _cursor.getColumnIndexOrThrow("permitirFatura");
      final int _cursorIndexOfPermitirDinheiro = _cursor.getColumnIndexOrThrow("permitirDinheiro");
      final int _cursorIndexOfSituacaoTributariaIpi = _cursor.getColumnIndexOrThrow("situacaoTributariaIpi");
      final int _cursorIndexOfUnidResponsaval = _cursor.getColumnIndexOrThrow("unidResponsaval");
      final int _cursorIndexOfConsumidorFinal = _cursor.getColumnIndexOrThrow("consumidorFinal");
      final int _cursorIndexOfClasseContrib = _cursor.getColumnIndexOrThrow("classeContrib");
      final int _cursorIndexOfDescontoIcmsOrgaoPublico = _cursor.getColumnIndexOrThrow("descontoIcmsOrgaoPublico");
      final int _cursorIndexOfSituacaoTributariaIcms = _cursor.getColumnIndexOrThrow("situacaoTributariaIcms");
      final int _cursorIndexOfFlFilialWm = _cursor.getColumnIndexOrThrow("flFilialWm");
      final int _cursorIndexOfNomeMotorista = _cursor.getColumnIndexOrThrow("nomeMotorista");
      final int _cursorIndexOfNomeContato = _cursor.getColumnIndexOrThrow("nomeContato");
      final int _cursorIndexOfCargoContato = _cursor.getColumnIndexOrThrow("cargoContato");
      final int _cursorIndexOfTelefoneContato = _cursor.getColumnIndexOrThrow("telefoneContato");
      final int _cursorIndexOfFlNovoFaturamento = _cursor.getColumnIndexOrThrow("flNovoFaturamento");
      final int _cursorIndexOfCdJdeOperadora = _cursor.getColumnIndexOrThrow("cdJdeOperadora");
      final List<Customer> _result = new ArrayList<Customer>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Customer _item;
        _item = new Customer();
        final Long _tmpCdCustomer;
        if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
          _tmpCdCustomer = null;
        } else {
          _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
        }
        _item.setCdCustomer(_tmpCdCustomer);
        final String _tmpNome;
        _tmpNome = _cursor.getString(_cursorIndexOfNome);
        _item.setNome(_tmpNome);
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
        final String _tmpTelefone;
        _tmpTelefone = _cursor.getString(_cursorIndexOfTelefone);
        _item.setTelefone(_tmpTelefone);
        final Date _tmpDtPesquisa;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfDtPesquisa)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfDtPesquisa);
        }
        _tmpDtPesquisa = DateTypeConverter.fromTimestamp(_tmp);
        _item.setDtPesquisa(_tmpDtPesquisa);
        final Integer _tmpSituacaoTributariaPis;
        if (_cursor.isNull(_cursorIndexOfSituacaoTributariaPis)) {
          _tmpSituacaoTributariaPis = null;
        } else {
          _tmpSituacaoTributariaPis = _cursor.getInt(_cursorIndexOfSituacaoTributariaPis);
        }
        _item.setSituacaoTributariaPis(_tmpSituacaoTributariaPis);
        final Integer _tmpSituacaoTributariaCofins;
        if (_cursor.isNull(_cursorIndexOfSituacaoTributariaCofins)) {
          _tmpSituacaoTributariaCofins = null;
        } else {
          _tmpSituacaoTributariaCofins = _cursor.getInt(_cursorIndexOfSituacaoTributariaCofins);
        }
        _item.setSituacaoTributariaCofins(_tmpSituacaoTributariaCofins);
        final String _tmpCstPisE;
        _tmpCstPisE = _cursor.getString(_cursorIndexOfCstPisE);
        _item.setCstPisE(_tmpCstPisE);
        final String _tmpCstPisS;
        _tmpCstPisS = _cursor.getString(_cursorIndexOfCstPisS);
        _item.setCstPisS(_tmpCstPisS);
        final String _tmpCstCofinsE;
        _tmpCstCofinsE = _cursor.getString(_cursorIndexOfCstCofinsE);
        _item.setCstCofinsE(_tmpCstCofinsE);
        final String _tmpCstCofinsS;
        _tmpCstCofinsS = _cursor.getString(_cursorIndexOfCstCofinsS);
        _item.setCstCofinsS(_tmpCstCofinsS);
        final String _tmpFlDistribGas;
        _tmpFlDistribGas = _cursor.getString(_cursorIndexOfFlDistribGas);
        _item.setFlDistribGas(_tmpFlDistribGas);
        final String _tmpFlPaciente;
        _tmpFlPaciente = _cursor.getString(_cursorIndexOfFlPaciente);
        _item.setFlPaciente(_tmpFlPaciente);
        final String _tmpInscEstadual;
        _tmpInscEstadual = _cursor.getString(_cursorIndexOfInscEstadual);
        _item.setInscEstadual(_tmpInscEstadual);
        final String _tmpTipoCnpjCpf;
        _tmpTipoCnpjCpf = _cursor.getString(_cursorIndexOfTipoCnpjCpf);
        _item.setTipoCnpjCpf(_tmpTipoCnpjCpf);
        final String _tmpCnpj;
        _tmpCnpj = _cursor.getString(_cursorIndexOfCnpj);
        _item.setCnpj(_tmpCnpj);
        final String _tmpFlPesquisa;
        _tmpFlPesquisa = _cursor.getString(_cursorIndexOfFlPesquisa);
        _item.setFlPesquisa(_tmpFlPesquisa);
        final Double _tmpLimiteCredito;
        if (_cursor.isNull(_cursorIndexOfLimiteCredito)) {
          _tmpLimiteCredito = null;
        } else {
          _tmpLimiteCredito = _cursor.getDouble(_cursorIndexOfLimiteCredito);
        }
        _item.setLimiteCredito(_tmpLimiteCredito);
        final Date _tmpDtVigencia;
        final Long _tmp_1;
        if (_cursor.isNull(_cursorIndexOfDtVigencia)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getLong(_cursorIndexOfDtVigencia);
        }
        _tmpDtVigencia = DateTypeConverter.fromTimestamp(_tmp_1);
        _item.setDtVigencia(_tmpDtVigencia);
        final Long _tmpCdCiaFiscal;
        if (_cursor.isNull(_cursorIndexOfCdCiaFiscal)) {
          _tmpCdCiaFiscal = null;
        } else {
          _tmpCdCiaFiscal = _cursor.getLong(_cursorIndexOfCdCiaFiscal);
        }
        _item.setCdCiaFiscal(_tmpCdCiaFiscal);
        final String _tmpFlReducaoIcms;
        _tmpFlReducaoIcms = _cursor.getString(_cursorIndexOfFlReducaoIcms);
        _item.setFlReducaoIcms(_tmpFlReducaoIcms);
        final String _tmpFlCredito;
        _tmpFlCredito = _cursor.getString(_cursorIndexOfFlCredito);
        _item.setFlCredito(_tmpFlCredito);
        final String _tmpFlSimplesFaturamento;
        _tmpFlSimplesFaturamento = _cursor.getString(_cursorIndexOfFlSimplesFaturamento);
        _item.setFlSimplesFaturamento(_tmpFlSimplesFaturamento);
        final String _tmpPermitirCheque;
        _tmpPermitirCheque = _cursor.getString(_cursorIndexOfPermitirCheque);
        _item.setPermitirCheque(_tmpPermitirCheque);
        final String _tmpPermitirFatura;
        _tmpPermitirFatura = _cursor.getString(_cursorIndexOfPermitirFatura);
        _item.setPermitirFatura(_tmpPermitirFatura);
        final String _tmpPermitirDinheiro;
        _tmpPermitirDinheiro = _cursor.getString(_cursorIndexOfPermitirDinheiro);
        _item.setPermitirDinheiro(_tmpPermitirDinheiro);
        final Integer _tmpSituacaoTributariaIpi;
        if (_cursor.isNull(_cursorIndexOfSituacaoTributariaIpi)) {
          _tmpSituacaoTributariaIpi = null;
        } else {
          _tmpSituacaoTributariaIpi = _cursor.getInt(_cursorIndexOfSituacaoTributariaIpi);
        }
        _item.setSituacaoTributariaIpi(_tmpSituacaoTributariaIpi);
        final String _tmpUnidResponsaval;
        _tmpUnidResponsaval = _cursor.getString(_cursorIndexOfUnidResponsaval);
        _item.setUnidResponsaval(_tmpUnidResponsaval);
        final String _tmpConsumidorFinal;
        _tmpConsumidorFinal = _cursor.getString(_cursorIndexOfConsumidorFinal);
        _item.setConsumidorFinal(_tmpConsumidorFinal);
        final Integer _tmpClasseContrib;
        if (_cursor.isNull(_cursorIndexOfClasseContrib)) {
          _tmpClasseContrib = null;
        } else {
          _tmpClasseContrib = _cursor.getInt(_cursorIndexOfClasseContrib);
        }
        _item.setClasseContrib(_tmpClasseContrib);
        final Integer _tmpDescontoIcmsOrgaoPublico;
        if (_cursor.isNull(_cursorIndexOfDescontoIcmsOrgaoPublico)) {
          _tmpDescontoIcmsOrgaoPublico = null;
        } else {
          _tmpDescontoIcmsOrgaoPublico = _cursor.getInt(_cursorIndexOfDescontoIcmsOrgaoPublico);
        }
        _item.setDescontoIcmsOrgaoPublico(_tmpDescontoIcmsOrgaoPublico);
        final Integer _tmpSituacaoTributariaIcms;
        if (_cursor.isNull(_cursorIndexOfSituacaoTributariaIcms)) {
          _tmpSituacaoTributariaIcms = null;
        } else {
          _tmpSituacaoTributariaIcms = _cursor.getInt(_cursorIndexOfSituacaoTributariaIcms);
        }
        _item.setSituacaoTributariaIcms(_tmpSituacaoTributariaIcms);
        final String _tmpFlFilialWm;
        _tmpFlFilialWm = _cursor.getString(_cursorIndexOfFlFilialWm);
        _item.setFlFilialWm(_tmpFlFilialWm);
        final String _tmpNomeMotorista;
        _tmpNomeMotorista = _cursor.getString(_cursorIndexOfNomeMotorista);
        _item.setNomeMotorista(_tmpNomeMotorista);
        final String _tmpNomeContato;
        _tmpNomeContato = _cursor.getString(_cursorIndexOfNomeContato);
        _item.setNomeContato(_tmpNomeContato);
        final String _tmpCargoContato;
        _tmpCargoContato = _cursor.getString(_cursorIndexOfCargoContato);
        _item.setCargoContato(_tmpCargoContato);
        final String _tmpTelefoneContato;
        _tmpTelefoneContato = _cursor.getString(_cursorIndexOfTelefoneContato);
        _item.setTelefoneContato(_tmpTelefoneContato);
        final String _tmpFlNovoFaturamento;
        _tmpFlNovoFaturamento = _cursor.getString(_cursorIndexOfFlNovoFaturamento);
        _item.setFlNovoFaturamento(_tmpFlNovoFaturamento);
        final Long _tmpCdJdeOperadora;
        if (_cursor.isNull(_cursorIndexOfCdJdeOperadora)) {
          _tmpCdJdeOperadora = null;
        } else {
          _tmpCdJdeOperadora = _cursor.getLong(_cursorIndexOfCdJdeOperadora);
        }
        _item.setCdJdeOperadora(_tmpCdJdeOperadora);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Customer findById(Long cdCustomer) {
    final String _sql = "SELECT * FROM Customer WHERE cdCustomer = ? LIMIT 1";
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
      final int _cursorIndexOfNome = _cursor.getColumnIndexOrThrow("nome");
      final int _cursorIndexOfEndereco = _cursor.getColumnIndexOrThrow("endereco");
      final int _cursorIndexOfBairro = _cursor.getColumnIndexOrThrow("bairro");
      final int _cursorIndexOfCidade = _cursor.getColumnIndexOrThrow("cidade");
      final int _cursorIndexOfUf = _cursor.getColumnIndexOrThrow("uf");
      final int _cursorIndexOfCep = _cursor.getColumnIndexOrThrow("cep");
      final int _cursorIndexOfTelefone = _cursor.getColumnIndexOrThrow("telefone");
      final int _cursorIndexOfDtPesquisa = _cursor.getColumnIndexOrThrow("dtPesquisa");
      final int _cursorIndexOfSituacaoTributariaPis = _cursor.getColumnIndexOrThrow("situacaoTributariaPis");
      final int _cursorIndexOfSituacaoTributariaCofins = _cursor.getColumnIndexOrThrow("situacaoTributariaCofins");
      final int _cursorIndexOfCstPisE = _cursor.getColumnIndexOrThrow("cstPisE");
      final int _cursorIndexOfCstPisS = _cursor.getColumnIndexOrThrow("cstPisS");
      final int _cursorIndexOfCstCofinsE = _cursor.getColumnIndexOrThrow("cstCofinsE");
      final int _cursorIndexOfCstCofinsS = _cursor.getColumnIndexOrThrow("cstCofinsS");
      final int _cursorIndexOfFlDistribGas = _cursor.getColumnIndexOrThrow("flDistribGas");
      final int _cursorIndexOfFlPaciente = _cursor.getColumnIndexOrThrow("flPaciente");
      final int _cursorIndexOfInscEstadual = _cursor.getColumnIndexOrThrow("inscEstadual");
      final int _cursorIndexOfTipoCnpjCpf = _cursor.getColumnIndexOrThrow("tipoCnpjCpf");
      final int _cursorIndexOfCnpj = _cursor.getColumnIndexOrThrow("cnpj");
      final int _cursorIndexOfFlPesquisa = _cursor.getColumnIndexOrThrow("flPesquisa");
      final int _cursorIndexOfLimiteCredito = _cursor.getColumnIndexOrThrow("limiteCredito");
      final int _cursorIndexOfDtVigencia = _cursor.getColumnIndexOrThrow("dtVigencia");
      final int _cursorIndexOfCdCiaFiscal = _cursor.getColumnIndexOrThrow("cdCiaFiscal");
      final int _cursorIndexOfFlReducaoIcms = _cursor.getColumnIndexOrThrow("flReducaoIcms");
      final int _cursorIndexOfFlCredito = _cursor.getColumnIndexOrThrow("flCredito");
      final int _cursorIndexOfFlSimplesFaturamento = _cursor.getColumnIndexOrThrow("flSimplesFaturamento");
      final int _cursorIndexOfPermitirCheque = _cursor.getColumnIndexOrThrow("permitirCheque");
      final int _cursorIndexOfPermitirFatura = _cursor.getColumnIndexOrThrow("permitirFatura");
      final int _cursorIndexOfPermitirDinheiro = _cursor.getColumnIndexOrThrow("permitirDinheiro");
      final int _cursorIndexOfSituacaoTributariaIpi = _cursor.getColumnIndexOrThrow("situacaoTributariaIpi");
      final int _cursorIndexOfUnidResponsaval = _cursor.getColumnIndexOrThrow("unidResponsaval");
      final int _cursorIndexOfConsumidorFinal = _cursor.getColumnIndexOrThrow("consumidorFinal");
      final int _cursorIndexOfClasseContrib = _cursor.getColumnIndexOrThrow("classeContrib");
      final int _cursorIndexOfDescontoIcmsOrgaoPublico = _cursor.getColumnIndexOrThrow("descontoIcmsOrgaoPublico");
      final int _cursorIndexOfSituacaoTributariaIcms = _cursor.getColumnIndexOrThrow("situacaoTributariaIcms");
      final int _cursorIndexOfFlFilialWm = _cursor.getColumnIndexOrThrow("flFilialWm");
      final int _cursorIndexOfNomeMotorista = _cursor.getColumnIndexOrThrow("nomeMotorista");
      final int _cursorIndexOfNomeContato = _cursor.getColumnIndexOrThrow("nomeContato");
      final int _cursorIndexOfCargoContato = _cursor.getColumnIndexOrThrow("cargoContato");
      final int _cursorIndexOfTelefoneContato = _cursor.getColumnIndexOrThrow("telefoneContato");
      final int _cursorIndexOfFlNovoFaturamento = _cursor.getColumnIndexOrThrow("flNovoFaturamento");
      final int _cursorIndexOfCdJdeOperadora = _cursor.getColumnIndexOrThrow("cdJdeOperadora");
      final Customer _result;
      if(_cursor.moveToFirst()) {
        _result = new Customer();
        final Long _tmpCdCustomer;
        if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
          _tmpCdCustomer = null;
        } else {
          _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
        }
        _result.setCdCustomer(_tmpCdCustomer);
        final String _tmpNome;
        _tmpNome = _cursor.getString(_cursorIndexOfNome);
        _result.setNome(_tmpNome);
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
        final String _tmpTelefone;
        _tmpTelefone = _cursor.getString(_cursorIndexOfTelefone);
        _result.setTelefone(_tmpTelefone);
        final Date _tmpDtPesquisa;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfDtPesquisa)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfDtPesquisa);
        }
        _tmpDtPesquisa = DateTypeConverter.fromTimestamp(_tmp);
        _result.setDtPesquisa(_tmpDtPesquisa);
        final Integer _tmpSituacaoTributariaPis;
        if (_cursor.isNull(_cursorIndexOfSituacaoTributariaPis)) {
          _tmpSituacaoTributariaPis = null;
        } else {
          _tmpSituacaoTributariaPis = _cursor.getInt(_cursorIndexOfSituacaoTributariaPis);
        }
        _result.setSituacaoTributariaPis(_tmpSituacaoTributariaPis);
        final Integer _tmpSituacaoTributariaCofins;
        if (_cursor.isNull(_cursorIndexOfSituacaoTributariaCofins)) {
          _tmpSituacaoTributariaCofins = null;
        } else {
          _tmpSituacaoTributariaCofins = _cursor.getInt(_cursorIndexOfSituacaoTributariaCofins);
        }
        _result.setSituacaoTributariaCofins(_tmpSituacaoTributariaCofins);
        final String _tmpCstPisE;
        _tmpCstPisE = _cursor.getString(_cursorIndexOfCstPisE);
        _result.setCstPisE(_tmpCstPisE);
        final String _tmpCstPisS;
        _tmpCstPisS = _cursor.getString(_cursorIndexOfCstPisS);
        _result.setCstPisS(_tmpCstPisS);
        final String _tmpCstCofinsE;
        _tmpCstCofinsE = _cursor.getString(_cursorIndexOfCstCofinsE);
        _result.setCstCofinsE(_tmpCstCofinsE);
        final String _tmpCstCofinsS;
        _tmpCstCofinsS = _cursor.getString(_cursorIndexOfCstCofinsS);
        _result.setCstCofinsS(_tmpCstCofinsS);
        final String _tmpFlDistribGas;
        _tmpFlDistribGas = _cursor.getString(_cursorIndexOfFlDistribGas);
        _result.setFlDistribGas(_tmpFlDistribGas);
        final String _tmpFlPaciente;
        _tmpFlPaciente = _cursor.getString(_cursorIndexOfFlPaciente);
        _result.setFlPaciente(_tmpFlPaciente);
        final String _tmpInscEstadual;
        _tmpInscEstadual = _cursor.getString(_cursorIndexOfInscEstadual);
        _result.setInscEstadual(_tmpInscEstadual);
        final String _tmpTipoCnpjCpf;
        _tmpTipoCnpjCpf = _cursor.getString(_cursorIndexOfTipoCnpjCpf);
        _result.setTipoCnpjCpf(_tmpTipoCnpjCpf);
        final String _tmpCnpj;
        _tmpCnpj = _cursor.getString(_cursorIndexOfCnpj);
        _result.setCnpj(_tmpCnpj);
        final String _tmpFlPesquisa;
        _tmpFlPesquisa = _cursor.getString(_cursorIndexOfFlPesquisa);
        _result.setFlPesquisa(_tmpFlPesquisa);
        final Double _tmpLimiteCredito;
        if (_cursor.isNull(_cursorIndexOfLimiteCredito)) {
          _tmpLimiteCredito = null;
        } else {
          _tmpLimiteCredito = _cursor.getDouble(_cursorIndexOfLimiteCredito);
        }
        _result.setLimiteCredito(_tmpLimiteCredito);
        final Date _tmpDtVigencia;
        final Long _tmp_1;
        if (_cursor.isNull(_cursorIndexOfDtVigencia)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getLong(_cursorIndexOfDtVigencia);
        }
        _tmpDtVigencia = DateTypeConverter.fromTimestamp(_tmp_1);
        _result.setDtVigencia(_tmpDtVigencia);
        final Long _tmpCdCiaFiscal;
        if (_cursor.isNull(_cursorIndexOfCdCiaFiscal)) {
          _tmpCdCiaFiscal = null;
        } else {
          _tmpCdCiaFiscal = _cursor.getLong(_cursorIndexOfCdCiaFiscal);
        }
        _result.setCdCiaFiscal(_tmpCdCiaFiscal);
        final String _tmpFlReducaoIcms;
        _tmpFlReducaoIcms = _cursor.getString(_cursorIndexOfFlReducaoIcms);
        _result.setFlReducaoIcms(_tmpFlReducaoIcms);
        final String _tmpFlCredito;
        _tmpFlCredito = _cursor.getString(_cursorIndexOfFlCredito);
        _result.setFlCredito(_tmpFlCredito);
        final String _tmpFlSimplesFaturamento;
        _tmpFlSimplesFaturamento = _cursor.getString(_cursorIndexOfFlSimplesFaturamento);
        _result.setFlSimplesFaturamento(_tmpFlSimplesFaturamento);
        final String _tmpPermitirCheque;
        _tmpPermitirCheque = _cursor.getString(_cursorIndexOfPermitirCheque);
        _result.setPermitirCheque(_tmpPermitirCheque);
        final String _tmpPermitirFatura;
        _tmpPermitirFatura = _cursor.getString(_cursorIndexOfPermitirFatura);
        _result.setPermitirFatura(_tmpPermitirFatura);
        final String _tmpPermitirDinheiro;
        _tmpPermitirDinheiro = _cursor.getString(_cursorIndexOfPermitirDinheiro);
        _result.setPermitirDinheiro(_tmpPermitirDinheiro);
        final Integer _tmpSituacaoTributariaIpi;
        if (_cursor.isNull(_cursorIndexOfSituacaoTributariaIpi)) {
          _tmpSituacaoTributariaIpi = null;
        } else {
          _tmpSituacaoTributariaIpi = _cursor.getInt(_cursorIndexOfSituacaoTributariaIpi);
        }
        _result.setSituacaoTributariaIpi(_tmpSituacaoTributariaIpi);
        final String _tmpUnidResponsaval;
        _tmpUnidResponsaval = _cursor.getString(_cursorIndexOfUnidResponsaval);
        _result.setUnidResponsaval(_tmpUnidResponsaval);
        final String _tmpConsumidorFinal;
        _tmpConsumidorFinal = _cursor.getString(_cursorIndexOfConsumidorFinal);
        _result.setConsumidorFinal(_tmpConsumidorFinal);
        final Integer _tmpClasseContrib;
        if (_cursor.isNull(_cursorIndexOfClasseContrib)) {
          _tmpClasseContrib = null;
        } else {
          _tmpClasseContrib = _cursor.getInt(_cursorIndexOfClasseContrib);
        }
        _result.setClasseContrib(_tmpClasseContrib);
        final Integer _tmpDescontoIcmsOrgaoPublico;
        if (_cursor.isNull(_cursorIndexOfDescontoIcmsOrgaoPublico)) {
          _tmpDescontoIcmsOrgaoPublico = null;
        } else {
          _tmpDescontoIcmsOrgaoPublico = _cursor.getInt(_cursorIndexOfDescontoIcmsOrgaoPublico);
        }
        _result.setDescontoIcmsOrgaoPublico(_tmpDescontoIcmsOrgaoPublico);
        final Integer _tmpSituacaoTributariaIcms;
        if (_cursor.isNull(_cursorIndexOfSituacaoTributariaIcms)) {
          _tmpSituacaoTributariaIcms = null;
        } else {
          _tmpSituacaoTributariaIcms = _cursor.getInt(_cursorIndexOfSituacaoTributariaIcms);
        }
        _result.setSituacaoTributariaIcms(_tmpSituacaoTributariaIcms);
        final String _tmpFlFilialWm;
        _tmpFlFilialWm = _cursor.getString(_cursorIndexOfFlFilialWm);
        _result.setFlFilialWm(_tmpFlFilialWm);
        final String _tmpNomeMotorista;
        _tmpNomeMotorista = _cursor.getString(_cursorIndexOfNomeMotorista);
        _result.setNomeMotorista(_tmpNomeMotorista);
        final String _tmpNomeContato;
        _tmpNomeContato = _cursor.getString(_cursorIndexOfNomeContato);
        _result.setNomeContato(_tmpNomeContato);
        final String _tmpCargoContato;
        _tmpCargoContato = _cursor.getString(_cursorIndexOfCargoContato);
        _result.setCargoContato(_tmpCargoContato);
        final String _tmpTelefoneContato;
        _tmpTelefoneContato = _cursor.getString(_cursorIndexOfTelefoneContato);
        _result.setTelefoneContato(_tmpTelefoneContato);
        final String _tmpFlNovoFaturamento;
        _tmpFlNovoFaturamento = _cursor.getString(_cursorIndexOfFlNovoFaturamento);
        _result.setFlNovoFaturamento(_tmpFlNovoFaturamento);
        final Long _tmpCdJdeOperadora;
        if (_cursor.isNull(_cursorIndexOfCdJdeOperadora)) {
          _tmpCdJdeOperadora = null;
        } else {
          _tmpCdJdeOperadora = _cursor.getLong(_cursorIndexOfCdJdeOperadora);
        }
        _result.setCdJdeOperadora(_tmpCdJdeOperadora);
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
  public List<Customer> getCustomersAndPatients(Integer type, Long cdCia, Long cdCustomer) {
    final String _sql = "SELECT cdCustomer, nome, Customer.cnpj as cnpj FROM Customer  JOIN Route WHERE cdcustomer <> (?)    AND cdcustomer = ifnull(?, cdcustomer)   AND (   (?=1 AND substr(Route.cnpj, 0, 9) = substr(Customer.cnpj, 0, 9))         OR (?=2 AND substr(Route.cnpj, 0, 9) <> substr(Customer.cnpj, 0, 9))       )UNION SELECT cdPaciente as cdCustomer, nome, cnpj FROM Patient  WHERE cdPaciente = ifnull(?, cdPaciente)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 5);
    int _argIndex = 1;
    if (cdCia == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cdCia);
    }
    _argIndex = 2;
    if (cdCustomer == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cdCustomer);
    }
    _argIndex = 3;
    if (type == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, type);
    }
    _argIndex = 4;
    if (type == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, type);
    }
    _argIndex = 5;
    if (cdCustomer == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cdCustomer);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfCdCustomer = _cursor.getColumnIndexOrThrow("cdCustomer");
      final int _cursorIndexOfNome = _cursor.getColumnIndexOrThrow("nome");
      final int _cursorIndexOfCnpj = _cursor.getColumnIndexOrThrow("cnpj");
      final List<Customer> _result = new ArrayList<Customer>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Customer _item;
        _item = new Customer();
        final Long _tmpCdCustomer;
        if (_cursor.isNull(_cursorIndexOfCdCustomer)) {
          _tmpCdCustomer = null;
        } else {
          _tmpCdCustomer = _cursor.getLong(_cursorIndexOfCdCustomer);
        }
        _item.setCdCustomer(_tmpCdCustomer);
        final String _tmpNome;
        _tmpNome = _cursor.getString(_cursorIndexOfNome);
        _item.setNome(_tmpNome);
        final String _tmpCnpj;
        _tmpCnpj = _cursor.getString(_cursorIndexOfCnpj);
        _item.setCnpj(_tmpCnpj);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Patient> getCustomersPatients(Integer type, Long cdCia, Long cdCustomer) {
    final String _sql = "SELECT cdCustomer, nome, Customer.cnpj as cnpj FROM Customer  JOIN Route WHERE cdcustomer <> (?)    AND cdcustomer = ifnull(?, cdcustomer)   AND (   (?=1 AND substr(Route.cnpj, 0, 9) = substr(Customer.cnpj, 0, 9))         OR (?=2 AND substr(Route.cnpj, 0, 9) <> substr(Customer.cnpj, 0, 9))       )UNION SELECT cdPaciente as cdCustomer, nome, cnpj FROM Patient  WHERE cdPaciente = ifnull(?, cdPaciente)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 5);
    int _argIndex = 1;
    if (cdCia == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cdCia);
    }
    _argIndex = 2;
    if (cdCustomer == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cdCustomer);
    }
    _argIndex = 3;
    if (type == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, type);
    }
    _argIndex = 4;
    if (type == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, type);
    }
    _argIndex = 5;
    if (cdCustomer == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, cdCustomer);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfNome = _cursor.getColumnIndexOrThrow("nome");
      final int _cursorIndexOfCnpj = _cursor.getColumnIndexOrThrow("cnpj");
      final List<Patient> _result = new ArrayList<Patient>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Patient _item;
        _item = new Patient();
        final String _tmpNome;
        _tmpNome = _cursor.getString(_cursorIndexOfNome);
        _item.setNome(_tmpNome);
        final String _tmpCnpj;
        _tmpCnpj = _cursor.getString(_cursorIndexOfCnpj);
        _item.setCnpj(_tmpCnpj);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
