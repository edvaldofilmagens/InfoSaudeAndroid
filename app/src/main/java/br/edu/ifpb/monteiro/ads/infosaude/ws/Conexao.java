package br.edu.ifpb.monteiro.ads.infosaude.ws;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Vanderlan Gomes on 19/06/15.
 */
public class Conexao {

    private String host;
    private String ip;
    private int portaHtttp;
    private SharedPreferences prefs;
    private static final String NAMESPACE = "http://webservices.infosaude.ads.monteiro.ifpb.edu.br/";


    public Conexao(Context t){
        prefs = PreferenceManager.getDefaultSharedPreferences(t);
        bucarInformacoes();
    }
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
    private void bucarInformacoes(){

        setIp(prefs.getString("ip", "192.168.0.99"));
        setHost(prefs.getString("host","servidor-pc"));
        setPortaHtttp(prefs.getInt("porta",8080));

    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPortaHtttp() {
        return portaHtttp;
    }

    public void setPortaHtttp(int portaHtttp) {
        this.portaHtttp = portaHtttp;
    }

    public static String getNAMESPACE() {
        return NAMESPACE;
    }
}
