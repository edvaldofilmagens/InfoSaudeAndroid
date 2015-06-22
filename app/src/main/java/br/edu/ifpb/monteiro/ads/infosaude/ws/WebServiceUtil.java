package br.edu.ifpb.monteiro.ads.infosaude.ws;

/**
 * Created by Vanderlan Gomes on 19/06/15.
 */
public class WebServiceUtil {

    private static final String NAMESPACE = "http://webservices.infosaude.ads.monteiro.ifpb.edu.br/";
    private String url = "http://192.168.0.103:8080/InfoSaude/InfomacoesUbsWS?wsdl";

    private WebServiceUtil(){

    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
