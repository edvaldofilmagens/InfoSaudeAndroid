package br.edu.ifpb.monteiro.ads.infosaude.autenticacao;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.edu.ifpb.monteiro.ads.infosaude.inicio.InfoSaudeInicio;
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

    public void efetuarLogin(View view) {

        InfoSaudeInicio ifsi = new InfoSaudeInicio();

        Intent i = new Intent(this, InfoSaudeInicio.class);

        startActivity(i);

    }

}
