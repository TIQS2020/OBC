package br.com.whitemartins.obc.print;

import android.app.Activity;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;

import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.graphics.internal.ZebraImageAndroid;
import com.zebra.sdk.printer.ZebraPrinter;
import com.zebra.sdk.printer.ZebraPrinterLanguageUnknownException;

import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.dao.InvoiceMessageDao;
import br.com.whitemartins.obc.dao.LotePatrimonioDao;
import br.com.whitemartins.obc.dao.MessageDao;
import br.com.whitemartins.obc.dao.RastreabilidadeDao;
import br.com.whitemartins.obc.enumeration.CecType;
import br.com.whitemartins.obc.enumeration.CnpjCpfTypeEnum;
import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.enumeration.InvoiceType;
import br.com.whitemartins.obc.enumeration.LotePatrimonioType;
import br.com.whitemartins.obc.enumeration.OperationType;
import br.com.whitemartins.obc.enumeration.StatusCecType;
import br.com.whitemartins.obc.enumeration.StatusNFeType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.model.Customer;
import br.com.whitemartins.obc.model.Invoice;
import br.com.whitemartins.obc.model.InvoiceItem;
import br.com.whitemartins.obc.model.InvoiceMessage;
import br.com.whitemartins.obc.model.LotePatrimonio;
import br.com.whitemartins.obc.model.Message;
import br.com.whitemartins.obc.model.Patient;
import br.com.whitemartins.obc.model.Rastreabilidade;
import br.com.whitemartins.obc.operations.SuperOperation;
import br.com.whitemartins.obc.util.ImageHelper;
import br.com.whitemartins.obc.util.InvoiceHelper;
import br.com.whitemartins.obc.util.UtilHelper;
import br.com.whitemartins.obc.views.DatabaseApp;

public class Cec {

  protected Invoice invoice;
  protected WeakReference<Activity> context;
  protected ZebraImageAndroid image = null;
  protected Boolean reprint = false;
  protected Boolean automatic = false;
  protected Bitmap bitmap;

  public Cec setActivity(Activity activity) {
    this.context = new WeakReference<>(activity);
    return this;
  }

  public Cec setSignature(Bitmap _bitmap) {
    this.bitmap = _bitmap;
    if (bitmap != null)
      image = new ZebraImageAndroid(bitmap);
    return this;
  }

  public Cec setInvoice(@NonNull Invoice invoice) {
    this.invoice = invoice;
    return this;
  }

  public Cec setReprint(Boolean reprint) {
    this.reprint = reprint;
    return this;
  }

  public Cec setAutomatic(Boolean automatic) {
    this.automatic = automatic;
    return this;
  }

  protected BasePrinter getPrint() {

    final BasePrinter printer = new BasePrinter() {
      private Integer posY = 20;
      private Integer posYPrinter = 0;

      @Override
      protected void doHeader() {
        this._printDefs._height = 1200;
        this._printDefs._width = 831;

        boolean aVista = invoice.getValorFatura() == 0;

        SuperOperation operation = SuperOperation.getOperation(invoice.getTipoTransacao());
        CecType cecType = GLOBAL.self().getCecDanfe(operation, aVista);
        this.titulo = cecType.getFullname().toUpperCase();
        this.filial = GLOBAL.self().getStaticTable().getCdFilial();
        this.numViagem = invoice.getNumeroViagem();
        this.numVeiculo = GLOBAL.self().getStaticTable().getCdVeiculo();
        this.dtViagem =
          UtilHelper.formatDateStr(GLOBAL.self().getRoute().getDataViagem(),
            ConstantsEnum.ddMMyyyy_barra.getValue());
      }

      @Override
      protected void doBody() {
        LotePatrimonioDao lotePatrimonioDao = DatabaseApp.self().getDatabase().lotePatrimonioDao();
        InvoiceMessageDao invoiceMessageDao = DatabaseApp.self().getDatabase().invoiceMessageDao();

        SuperOperation operation = SuperOperation.getOperation(invoice.getTipoTransacao());

        Customer customer = InvoiceHelper.self().getInvoiceCustomer(invoice);

        List<InvoiceItem> items = invoice.getItens();

        String dateStr = new SimpleDateFormat(ConstantsEnum.ddMMyyyy_HHmmss_barra.getValue(),
          Locale.getDefault()).format(invoice.getDataMovimento());

        String chave = invoice.getChave();

        doText(this.titulo, 1, posYPrinter += 30, posY, true, true);
        doText(GLOBAL.self().getRoute().getRazaoSocial(), 1, posYPrinter += 40, posY += 20,
          true, true);

        doText("DADOS DA NOTA FISCAL", 0, posYPrinter += 80, posY += 40, true,
          false);
        doLine(posY += 5, posYPrinter += 20, 823, 1);

        doText(String.format(Locale.getDefault(), "Nota Fiscal de %s: %d Serie: %d",
          invoice.getNomeOperacao(), invoice.getNumero(), invoice.getSerie()), 0,
          posYPrinter += 5, posY += 10, false, false);

        doText(String.format("Data de Emissao: %s Tipo Operacao: %s",
          dateStr, InvoiceType.getName(invoice.getTipoNota())), 0, posYPrinter += 20,
          posY += 10, false, false);

        if (!invoice.getStatus().equals(StatusNFeType.AUTORIZADA.getValue())
          || invoice.getStatusNfeImp().substring(0, 1).equalsIgnoreCase(StatusCecType.DANFE_OFF.getValue().toString())
          || invoice.getStatusNfeImp().substring(0, 1).equalsIgnoreCase(StatusCecType.CEC_OFF.getValue().toString())) {
          dateStr = "";
          chave = "";
        }

        doText("CHAVE DE ACESSO", 0, posYPrinter += 40, posY += 30, false,
          true);

        if (chave != null && !chave.isEmpty()) {
          doBarcode(chave, posY + 5, posYPrinter += 30);
          //doText(invoice.getChave(), 0, 320, posY += 80, false, true);
        }

//        posY += 80;
        doText("PROTOCOLO DE AUTORIZACAO DE USO", 0, posYPrinter += 140, posY += 100,
          true, false);

        doLine(posY += 5, posYPrinter += 20, 823, 1);

        if (invoice.getStatusNfeImp().substring(0, 1).equalsIgnoreCase(StatusCecType.DANFE_ON.getValue().toString())
          || invoice.getStatusNfeImp().substring(0, 1).equalsIgnoreCase(StatusCecType.CEC_ON.getValue().toString()))
          doText(invoice.getProtocolo() + " " + dateStr, 0, posYPrinter += 5, posY += 10,
            false, false);
        else if (invoice.getStatusNfeImp().substring(0, 1).equalsIgnoreCase(StatusCecType.DANFE_OFF.getValue().toString())) {
          doText(StatusCecType.DANFE_OFF.getTypeName(), 0, posYPrinter += 5, posY += 10,
            false, false);
        } else if (invoice.getStatusNfeImp().substring(0, 1).equalsIgnoreCase(StatusCecType.CEC_OFF.getValue().toString())) {
          doText(StatusCecType.CEC_OFF.getTypeName(), 0, posYPrinter += 5, posY += 10,
            false, false);
        } else
          doText(invoice.getStatusNfeImp().substring(1) + " " + dateStr, 0, posYPrinter += 5, posY += 10,
            false, false);

        doText("DADOS DO EMITENTE", 0, posYPrinter += 50, posY += 20, true,
          false);
        doLine(posY += 5, posYPrinter += 20, 823, 1);

        doText(GLOBAL.self().getRoute().getNomeFilial(), 0, posYPrinter += 5,
          posY += 10, false, false);

        if (customer.getTipoCnpjCpf().equalsIgnoreCase(CnpjCpfTypeEnum.CNPJ.getValue()))
          doText(String.format("CNPJ: %s   I.E.: %s   UF: %s",
            UtilHelper.formataCNPJ(GLOBAL.self().getRoute().getCnpj()),
            GLOBAL.self().getRoute().getInscEstadual(), GLOBAL.self().getRoute().getUf()), 0,
            posYPrinter += 20, posY += 10, false, false);
        else
          doText(String.format("CPF: %s   I.E.: %s   UF: %s",
            UtilHelper.formataCPF(GLOBAL.self().getRoute().getCnpj()),
            GLOBAL.self().getRoute().getInscEstadual(), GLOBAL.self().getRoute().getUf()), 0,
            posYPrinter += 20, posY += 10, false, false);

        doText("DADOS DO DESTINATARIO", 0, posYPrinter += 50, posY += 30, true,
          false);
        doLine(posY += 5, posYPrinter += 20, 823, 1);

        doText("Nome: " + customer.getNome(), 0, posYPrinter += 5, posY += 10, false,
          false);

        doText(String.format("CNPJ: %s   I.E.: %s   UF: %s",
          UtilHelper.formataCNPJ(customer.getCnpj()), customer.getInscEstadual(),
          customer.getUf()), 0, posYPrinter += 20, posY += 10, false,
          false);

        String flag = customer.getCnpj().substring(0, 1);
        doText("DADOS DOS PRODUTOS", 0, posYPrinter += 50, posY += 30, true,
          false);
        doLine(posY += 5, posYPrinter += 20, 823, 1);

        //Caso valor de fatura seja 0, nota considerada a Vista
        boolean aVista = invoice.getValorFatura() == 0;

        boolean showValue = GLOBAL.self().getCecDanfe(operation, aVista).showValue();

        String format = "%s%s%s%s%s";

        String header = String.format(Locale.getDefault(), format,
          UtilHelper.padRight(context.get().getString(R.string.descricao), ' ', 28),
          UtilHelper.padRight(context.get().getString(R.string.un_medida), ' ', 3),
          UtilHelper.padLeft(context.get().getString(R.string.qtd), ' ', 11),
          showValue ? UtilHelper.padLeft(context.get().getString(R.string.vl_unitario), ' ', 12) : "",
          showValue ? UtilHelper.padLeft(context.get().getString(R.string.vl_total), ' ', 14) : "");

        doText(header, 0, posYPrinter += 5, posY += 10, false, false);
        doLine(posY += 5, posYPrinter += 20, 823, 1);

        String cilPP = "";
        String textoAt = "";
        int qtdPP = 0;
        posYPrinter += 5;

        for (InvoiceItem item : items) {

          if (ConstantsEnum.YES.getValue().equalsIgnoreCase(item.getFlAssistenciaTecnica()))
            textoAt += String.format(Locale.getDefault(), "%d %s;", item.getCdItem(),
              item.getNomeItem());

          int len = item.getNomeItem().length();

          if (len > 26)
            len = 26;

          String quantStr = UtilHelper.padLeft(String.format("%s%s",
            GLOBAL.self().isLiquido() ? "" :
              UtilHelper.formatDoubleString(item.getQuantidadeCilindroVendida(), 0) + "/",
            UtilHelper.formatDoubleString(item.getQtdItem(), 2)), ' ', 11);

          String linhaItem = String.format(Locale.getDefault(), format,
            UtilHelper.padRight(item.getNomeItem().substring(0, len), ' ', 28),
            UtilHelper.padRight(item.getUnidadeMedida().trim(), ' ', 3),
            quantStr,
            showValue ? UtilHelper.padLeft(UtilHelper.formatDoubleString(item.getValorUnitario(),
              4), ' ', 12) : "",
            showValue ? UtilHelper.padLeft(UtilHelper.formatDoubleString(item.getValorTotal(),
              2), ' ', 14) : "");

          doText(linhaItem, 0, posYPrinter, posY += 15, false, false);

          List<LotePatrimonio> pats = lotePatrimonioDao.find(invoice.getId(), item.getCdItem(),
            item.getCapacidade());

          int contador = 0;

          if (!pats.isEmpty())
            posYPrinter += 20;

          for (LotePatrimonio lotePatrimonio : pats) {
            contador++;
            String lote_pat_label = "- Lote Fab.:";

            int spaces = 31;
            if (lotePatrimonio.getTipo().equals(LotePatrimonioType.PATRIMONIO.getValue())) {
              lote_pat_label = "- Patrimônio:";
              spaces = 32;
            }

            if (Integer.valueOf(1).equals(contador))
              doText(String.format(Locale.getDefault(), "   Item: %s %s %s",
                item.getCdItem(), lote_pat_label, lotePatrimonio.getNumeroLote()), 0,
                posYPrinter += 10, posY += 10, false, false);
            else
              doText(String.format(Locale.getDefault(), "%s%s",
                UtilHelper.padLeft("", ' ', spaces), lotePatrimonio.getNumeroLote()),
                0, posYPrinter += 20, posY += 10, false, false);

            //posY += 30;
//            qtdPP += item.getInfCilPP().length() / 15;
//
//            if (item.getInfCilPP().trim().length() > 0)
//              cilPP += item.getInfCilPP().trim();
          }
          posYPrinter += 30;

          qtdPP += item.getInfCilPP().length() / 15;

          if (item.getInfCilPP().trim().length() > 0)
            cilPP += item.getInfCilPP().trim();
        }

        doLine(posY += 10, posYPrinter += 30, 823, 1);

        if (showValue)

          doText(context.get().getString(R.string.total_value_order) + " " +
              UtilHelper.formatDoubleString(invoice.getValorTotal(), 2), 0,
            posYPrinter += 30, posY += 20, false, false);

        if (!textoAt.isEmpty()) {
          doText("ITENS RECOLHIDOS PARA ASSISTÊNCIA TÉCNICA", 0, posYPrinter += 30,
            posY += 20, true, false);

          doLine(posY += 5, posYPrinter += 20, 823, 1);

          posY -= 10;

          String[] ats = textoAt.split(";");

          for (String s : ats)
            if (!s.isEmpty())
              doText(s, 0, posYPrinter += 20, posY += 20, false, false);
        }

        doText("DADOS ADICIONAIS", 0, posYPrinter += 50, posY += 30, true,
          false);
        doLine(posY += 5, posYPrinter += 20, 823, 1);

        String texto = String.format(Locale.getDefault(),
          "  Filial: %s Viagem: %s Veículo: %s",
          GLOBAL.self().getRoute().getCdFilialJde(),
          invoice.getNumeroViagem(),
          UtilHelper.convertToIntegerDef(GLOBAL.self().getRoute().getNumVeiculo(), 0));

        doText(texto, 0, posYPrinter += 20, posY += 20, false, false);

        Patient patient = Patient.newInstance();
        patient.setCdPaciente(invoice.getCdCustomer());
        patient = patient.isPaciente();

        if (patient != null) {
          doText("  Cod. Jde do Paciente: " +
              patient.getCdPaciente().toString(), 0, posYPrinter += 30, posY += 25,
            false, false);

          doText("  " + patient.getNome(), 0, posYPrinter += 30, posY += 10,
            false, false);

          doText(String.format("  %s %s", patient.getEndereco(), patient.getBairro()), 0,
            posYPrinter += 30, posY += 10, false, false);

          doText(String.format("  %s %s-%s", patient.getCidade(), patient.getUF(),
            patient.getCEP()), 0, posYPrinter += 30, posY += 10, false, false);
        }

        List<Rastreabilidade> rastreabs = new ArrayList<>();

        if (operation.isRastreavel()) {
          RastreabilidadeDao rastDao = DatabaseApp.self().getDatabase().rastreabilidadeDao();

          rastreabs = rastDao.find(invoice.getId(), UtilHelper.convertToLongDef(
            invoice.getNumeroViagem(), 0), invoice.getCdCustomer());

          if (rastreabs.size() == 0)
            rastreabs = rastDao.find(invoice.getId(), UtilHelper.convertToLongDef(
              invoice.getNumeroViagem(), 0), invoice.getCdOperadora());

          int _crln = 30;
          int tam = _crln + (_crln * rastreabs.size() / 2);

          if (invoice.getNumeroFutEntrega() != null && invoice.getNumeroFutEntrega().trim().length() > 0)
            tam += _crln;

          if (cilPP.trim().length() > 0)
            tam += _crln * (qtdPP / 2) + 1;

          if (rastreabs.size() > 0)
            doText("  DADOS DE RASTREABILIDADE", 0, posYPrinter += 30, posY += 25,
              false, false);
        }

        String currentHeader = "";
        StringBuilder cilindros = new StringBuilder();
        Integer cil_idx = 0;

        for (int idx = 1; idx <= rastreabs.size(); idx++) {
          Rastreabilidade rast = rastreabs.get(idx - 1);

          if (!currentHeader.equalsIgnoreCase(rast.getCdItem().toString() +
            rast.getNumeroLote())) {

            if (cilindros.length() > 0) {

              doText("        " + cilindros.toString().trim().substring(0, cilindros.length() - 2), 0,
                posYPrinter += 30, posY += 20, false, false);

              cilindros = new StringBuilder();
              cil_idx = 0;
            }

            doText(String.format(Locale.getDefault(), "   Item: %d Lote: %s %s",
              rast.getCdItem(), rast.getNumeroLote(),
              (GLOBAL.self().isLiquido() ? "" : "Cilindro: " + rast.getCdCilindro())), 0,
              posYPrinter += 30, posY += 20, false, false);

          } else {
            cilindros.append(rast.getCdCilindro()).append(", ");
            cil_idx++;

            if (cil_idx.equals(5) || rastreabs.size() == idx) {
              doText("         " +
                  cilindros.toString().trim().substring(0, cilindros.toString().trim().length() - 1),
                0, posYPrinter += 30, posY += 20, false, false);

              cilindros = new StringBuilder();

              cil_idx = 0;
            }
          }

          currentHeader = rast.getCdItem().toString() + rast.getNumeroLote();
        }

        if (invoice.getNumeroFutEntrega() != null && invoice.getNumeroFutEntrega().trim().length() > 0)
          doText("  " + invoice.getNumeroFutEntrega().trim(), 0, posYPrinter += 30,
            posY += 30, false, false);

        doLine(posY += 20, posYPrinter += 30, 823, 1);

        String currPed = "";

        for (InvoiceItem item : items) {
          if (item.getPedidoCustomer().isEmpty())
            continue;

          if (!currPed.equalsIgnoreCase(item.getPedidoCustomer())) {
            doText("  Número do Pedido do Cliente: " + item.getPedidoCustomer(), 0,
              posYPrinter += 30, posY += 15, false, false);

            currPed = item.getPedidoCustomer();
          }

          String t = String.format("   Item: %s - Sequencial: %s", item.getCdItem(),
            item.getItemPedidoCustomer());

          doText(t, 0, posYPrinter += 20, posY += 10, false, false);
        }

        List<InvoiceMessage> invoiceMessages = invoiceMessageDao.find(invoice.getId(),
          ConstantsEnum.YES.getValue());

        if (invoiceMessages.size() > 0)
          doLine(posY += 10, posYPrinter += 25, 823, 1);

        for (InvoiceMessage invoiceMessage : invoiceMessages)
          doText(invoiceMessage.getMensagem().replace("|", "   "), 0,
            posYPrinter += 20, posY += 20, false, false);

        doText(String.format("  (Documento sem valor fiscal%s)", reprint ? " - Reimpressão" : ""),
          0, posYPrinter += 50, posY += 20, false, false);

//        doLine(posY += 10, posYPrinter += 30, 823, 1);

        List<Message> mensagens = new ArrayList<>();
        MessageDao messageDao = DatabaseApp.self().getDatabase().messageDao();

        if (operation.getOperationType().equals(OperationType.APL)
          || operation.getOperationType().equals(OperationType.APLHC)) {
          //Colocando as mensagens K na aplicação
          mensagens = messageDao.find(ConstantsEnum.K.getValue(), invoice.getCdCustomer());

          if (!mensagens.isEmpty())
            posYPrinter += 20;

          for (Message mensagem : mensagens) {
            int len = mensagem.getMensagem().replace("|", "   ").length();

            if (len > 65)
              len = 65;

            doText("  " + mensagem.getMensagem().replace("|", "   ")
                .substring(0, len), 0, posYPrinter += 25, posY += 20, false,
              false);
          }

          mensagens.clear();
          mensagens = messageDao.find(ConstantsEnum.W.getValue());

          doText("TERMO DE RESPONSABILIDADE", 0, posYPrinter += 50, posY += 20,
            false, false);

          doLine(posY += 5, posYPrinter += 25, 823, 1);

        } else if (!GLOBAL.self().isHomecare()) //Rodolfo Pontar HC Fase 1
          mensagens = messageDao.find(ConstantsEnum.K.getValue(), invoice.getCdCustomer());
        else if (ConstantsEnum.YES.getValue().equalsIgnoreCase(customer.getFlPaciente())) //Travel de Packeged para mostrar o endereço do patient
          mensagens = messageDao.find(ConstantsEnum.K.getValue(), invoice.getCdCustomer());

        for (Message mensagem : mensagens) {
          int len = mensagem.getMensagem().replace("|", "   ").length();

          if (len > 65)
            len = 65;

          doText("  " + mensagem.getMensagem().substring(0, len), 0, posYPrinter += 30,
            posY += 15, false, false);
        }

        doLine(posY += 5, posYPrinter += 25, 823, 1);

        if (!operation.getOperationType().equals(OperationType.RPS)) {
          doText(String.format("  Recebemos de %s unidade",
            GLOBAL.self().getRoute().getRazaoSocial()), 0, posYPrinter += 20, posY += 20,
            false, false);
          doText(String.format("  %s os produtos constantes na",
            GLOBAL.self().getRoute().getNomeFilial()), 0, posYPrinter += 30, posY += 10,
            false, false);
          doText("  Nota Fiscal indicada acima.", 0, posYPrinter += 30, posY += 10,
            false, false);

          if (GLOBAL.self().isFamex()) {
            doText("  Para receber a NF Eletrônica, mantenha o e-mail atualizado", 0,
              posYPrinter += 30, posY += 20, false, false);
            doText("  ligando para (11) 3705-8391.", 0, posYPrinter += 30, posY += 10,
              false, false);
          } else if (GLOBAL.self().isGama()) {
            doText("  Para receber a NF Eletrônica, mantenha o e-mail atualizado", 0,
              posYPrinter += 30, posY += 20, false, false);
            doText("  ligando para (11) 4343-4000 ou (11) 96926-8813.", 0,
              posYPrinter += 30, posY += 10, false, false);
          } else if (GLOBAL.self().isCiaLegal()) {
            doText("  Para receber a NF Eletrônica, mantenha o e-mail atualizado", 0,
              posYPrinter += 30, posY += 20, false, false);
            doText("  pelo 0800 709 9000 (de tel fixo), (21) 3548-3500 (de celular).", 0,
              posYPrinter += 30, posY += 10, false, false);
          }
        } else {
//          doLine(posY += 10, posYPrinter += 20, 823, 1);

          doText(String.format("  Recebemos de %s, unidade",
            GLOBAL.self().getRoute().getRazaoSocial()), 0, posYPrinter += 30, posY += 20,
            false, false);
          doText(String.format("  %s, os produtos constantes no",
            GLOBAL.self().getRoute().getNomeFilial()), 0, posYPrinter += 30, posY += 10,
            false, false);
          doText("  Recibo indicado acima para prestação de serviço.", 0,
            posYPrinter += 30, posY += 10, false, false);
        }

        doBox(posY += 15, 829, posYPrinter += 30);
        doText("  NOME/RG: " + String.format("%s/%s", invoice.getNomeAssinadorCec(),
          invoice.getRgAssinadorCec()), 0, posYPrinter += 6, posY += 15, false,
          false);

        doSignature(UtilHelper.getSignFileName(invoice), posY += 10);

        this._printDefs._height = posYPrinter + 25;
      }

      @Override
      protected void doFooter(PrinterConnection printerConnection) throws ConnectionException,
        ZebraPrinterLanguageUnknownException {
        try {
          if (!automatic) {
            if (bitmap != null) {
              ZebraPrinter zebraPrinter = printerConnection.getPrinter();
              if (zebraPrinter != null)
                zebraPrinter.printImage(image, 180, 0, 500, 300, false);

              printerConnection.disconnect();
            }
          }
        } catch (ConnectionException | ZebraPrinterLanguageUnknownException e) {
          printerConnection.disconnect();
          throw e;
        }
      }
    };

    return printer;
  }


  public void print() throws ConnectionException, ZebraPrinterLanguageUnknownException {

    try {
      ImageHelper.self().createCecImage(8000);

      BasePrinter printer = getPrint();

      printer.setPrintImage(true);
      printer.setAutomatic(automatic);
      printer.setReprint(reprint);
      printer.print(invoice);

    } catch (Exception ex) {
      ex.printStackTrace();
      throw ex;
    }

  }
}
