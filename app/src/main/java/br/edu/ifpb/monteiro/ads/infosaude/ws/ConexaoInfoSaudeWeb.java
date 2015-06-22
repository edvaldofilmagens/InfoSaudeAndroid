package br.edu.ifpb.monteiro.ads.infosaude.ws;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import infosaude.ads.monteiro.ifpb.edu.br.inicio.R;

public class ConexaoInfoSaudeWeb extends Activity {

    private SharedPreferences prefs;
    private EditText txtIp;
    private EditText txtHost;
    private EditText txtPorta;
    private Button btSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conexao_info_saude_web);

        txtIp = (EditText) findViewById(R.id.txtConfIp);
        txtHost = (EditText) findViewById(R.id.txtConfHost);
        txtPorta = (EditText) findViewById(R.id.txtConfHttpPort);

        //SALVAR PREFERENCIAS NO CACHE DO APLICATIVO
        prefs = PreferenceManager.getDefaultSharedPreferences(this);

        //BUSCA AS INFORMAÇOES JA SALVAS
        lerConfiguracoes();

        btSalvar = (Button) findViewById(R.id.btConfSalvar);
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                salvarConfiguracoes();
            }
        });
    }

    private void lerConfiguracoes() {

        txtIp.setText(prefs.getString("ip", "192.168.0.99"));
        txtHost.setText(prefs.getString("host","servidor-pc"));
        txtPorta.setText( ""+prefs.getInt("porta",8080)  );


    }

    public void salvarConfiguracoes() {

        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("ip", txtIp.getText().toString());
        editor.putString("host", txtHost.getText().toString());
        editor.putInt("porta", Integer.parseInt(txtPorta.getText().toString()));

        editor.commit();

        Toast.makeText(getApplicationContext(),"Configurações Salvas com Sucesso", Toast.LENGTH_LONG).show();

    }
}
