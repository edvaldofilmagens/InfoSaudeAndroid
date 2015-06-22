package br.edu.ifpb.monteiro.ads.infosaude.autenticacao;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import br.edu.ifpb.monteiro.ads.infosaude.formularios.VisitaDomiciliar;
import br.edu.ifpb.monteiro.ads.infosaude.inicio.InformacoesUbs;
import br.edu.ifpb.monteiro.ads.infosaude.ws.ConexaoInfoSaudeWeb;
import infosaude.ads.monteiro.ifpb.edu.br.inicio.R;

/**
 * Created by Vanderlan Gomes on 11/03/15.
 */
public class Login extends Activity{


    private Button bntLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_saude_login);

        bntLogin = (Button)  findViewById(R.id.bntLogin);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_info_saude_inicio, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent i = null;

        switch (id){

            case R.id.confConexao:
                i = new Intent(this, ConexaoInfoSaudeWeb.class);
                break;
            case R.id.infoUbs:
                i = new Intent(this, InformacoesUbs.class);
                break;

        }

        startActivity(i);

        return super.onOptionsItemSelected(item);
    }

    public void efetuarLogin(View view) {

        Intent i = new Intent(this, VisitaDomiciliar.class);
        startActivity(i);

    }
}
