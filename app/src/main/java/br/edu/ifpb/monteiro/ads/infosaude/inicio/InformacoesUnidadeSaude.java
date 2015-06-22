package br.edu.ifpb.monteiro.ads.infosaude.inicio;

import android.content.Context;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumEstados;
import br.edu.ifpb.monteiro.ads.infosaude.modelos.UnidadeSaude;
import br.edu.ifpb.monteiro.ads.infosaude.ws.Conexao;

/**
 * Created by Vanderlan Gomes on 17/06/15.
 */
public class InformacoesUnidadeSaude {

    private static final String METHOD_NAME = "dadosUBS";
    private static final String SOAP_ACTION = "dadosUBSResponse";
    private Conexao conexao;
    private String URL;

    private UnidadeSaude ubs;


    public InformacoesUnidadeSaude(Context context) {

        conexao = new Conexao(context);
        URL = "http://"+conexao.getIp()+":"+conexao.getPortaHtttp()+"/InfoSaude/InfomacoesUbsWS?wsdl";

    }

    public UnidadeSaude getUbs() {
        return ubs;
    }

    public void setUbs(UnidadeSaude ubs) {
        this.ubs = ubs;
    }

    public void buscarIformacoes () {
        SoapObject soapClient = new SoapObject(conexao.getNAMESPACE(), METHOD_NAME);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(soapClient);
        envelope.implicitTypes = true;

        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

        try {
            androidHttpTransport.call("urn:" + SOAP_ACTION, envelope);
            SoapObject resultsRequestSOAP = (SoapObject) envelope.getResponse();

            UnidadeSaude ubs2 = new UnidadeSaude();

            ubs2.setBairro(resultsRequestSOAP.getProperty("bairro").toString());
            ubs2.setCep(resultsRequestSOAP.getProperty("cep").toString());
            ubs2.setCidade(resultsRequestSOAP.getProperty("cidade").toString());
            ubs2.setBairro(resultsRequestSOAP.getProperty("bairro").toString());
            ubs2.setCnes(Integer.parseInt(resultsRequestSOAP.getProperty("cnes").toString()));
            ubs2.setEnderecoNumero(Integer.parseInt(
                    resultsRequestSOAP.getProperty("enderecoNumero").toString()));
            ubs2.setEstado(EnumEstados.PB);
            ubs2.setId(Long.parseLong(resultsRequestSOAP.getProperty("id").toString()));
            ubs2.setLogradouro(resultsRequestSOAP.getProperty("logradouro").toString());
            ubs2.setNome(resultsRequestSOAP.getProperty("nome").toString());
            ubs2.setNumero(Integer.parseInt(resultsRequestSOAP.getProperty("numero").toString()));

            setUbs(ubs2);

        } catch (IOException | XmlPullParserException e) {
            e.printStackTrace();
        }
    }

}