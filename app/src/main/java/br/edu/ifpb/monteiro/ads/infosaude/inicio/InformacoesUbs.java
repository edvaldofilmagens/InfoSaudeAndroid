package br.edu.ifpb.monteiro.ads.infosaude.inicio;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import infosaude.ads.monteiro.ifpb.edu.br.inicio.R;

/**
 * Created by Vanderlan Gomes on 17/06/15.
 */

public class InformacoesUbs extends Activity {

    private TextView nome, endereco, cnes, cidade, cep;
    private InformacoesUnidadeSaude informacoesUnidadeSaude;
    private Button bntAtualizar;
    private ProgressDialog p_dialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ubs);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        informacoesUnidadeSaude = new InformacoesUnidadeSaude();
        informacoesUnidadeSaude.buscarIformacoes();

        nome = (TextView) findViewById(R.id.txtUbsNomeUbs);
        endereco = (TextView) findViewById(R.id.txtUbsEndereco);
        cnes = (TextView) findViewById(R.id.txtUbsCnes);
        cidade = (TextView) findViewById(R.id.txtUbsCidade);
        cep = (TextView) findViewById(R.id.txtUbsCep);
        bntAtualizar = (Button) findViewById(R.id.btAtualizar);

        bntAtualizar.setOnClickListener
                (new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {

                         try {
                             atualizarInformacoes();
                             preencherInformacoes();

                         } catch (Exception e) {

                             Toast.makeText(getApplicationContext(), "Não foi possível conectar ao Servidor", Toast.LENGTH_LONG).show();
                         }

                     }
                 }

                );

    }


    public void preencherInformacoes() {

        nome.setText(informacoesUnidadeSaude.getUbs().getNome());
        endereco.setText(informacoesUnidadeSaude.getUbs().getLogradouro());
        cnes.setText(informacoesUnidadeSaude.getUbs().getCnes().toString());
        cidade.setText(informacoesUnidadeSaude.getUbs().getCidade());
        cep.setText(informacoesUnidadeSaude.getUbs().getCep());
    }

    public void atualizarInformacoes() {

        informacoesUnidadeSaude.buscarIformacoes();
    }
}
