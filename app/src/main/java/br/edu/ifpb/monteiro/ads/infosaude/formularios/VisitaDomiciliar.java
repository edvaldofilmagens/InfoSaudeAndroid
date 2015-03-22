package br.edu.ifpb.monteiro.ads.infosaude.formularios;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;

import br.edu.ifpb.monteiro.ads.infosaude.comportamento.NavegacaoTabs;
import br.edu.ifpb.monteiro.ads.infosaude.inicio.InfoSaudeInicio;
import infosaude.ads.monteiro.ifpb.edu.br.inicio.R;

/**
 * Created by Vanderlan Gomes on 25/02/15.
 */
public class VisitaDomiciliar extends FragmentActivity {

    FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visita_domiciliar);

        ActionBar actionBar = getActionBar();
        actionBar = getActionBar();

        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        //Adicionando as Tabs


        ActionBar.Tab tab1 = actionBar.newTab();
        tab1.setText("Acompanhamento");
        tab1.setIcon(R.drawable.ic_launcher);
        tab1.setTabListener(new NavegacaoTabs(new Acompanhamento()));
        actionBar.addTab(tab1);

        ActionBar.Tab tab2 = actionBar.newTab();
        tab2.setText("Dados da Visita");
        tab2.setTabListener(new NavegacaoTabs(new Desfecho()));
        actionBar.addTab(tab2);


        //ACIONANDO A FUNCIONALIDADE DO ÍCONE DA ACTIONBAR
        // ... PARA SER CLICÁVEL
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradient));

        if(savedInstanceState == null){

            DadosPessoais dadosPessoais = new DadosPessoais();

            //É UTILIZADO PARA FAZER OERAÇÕES COM FRAGMENTS, COMO MUDANÇA DE FRAGMENTS EM TEMPO DE EXECUÇÃO
            FragmentTransaction ft = fm.beginTransaction();

            //ADICIONA O FRAGMENT A ACTIVITY
            ft.add(R.id.layout_direito, dadosPessoais);

            //ACIONA A PILHA DE EXECUÇÃO PARA QUANDO  USUÁRIO CLICAR EM VOLTAR NÃO SAIR DA
            //APLICAÇÃO, MAS SOMENTE VOLTAR AO FRAMENT ANTERIOR
            ft.addToBackStack("pilha");

            //APLICA AS ATERAÇÕES REALIZADAS, É OBRIGATÓRIO
            ft.commit();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.menu_visita_domiciliar, menu);
        return true;
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {

        FragmentTransaction ft = fm.beginTransaction();

        switch (item.getItemId()){

            case android.R.id.home:
                InfoSaudeInicio infoSaudeInicio = new InfoSaudeInicio();

                Intent i = new Intent(this, InfoSaudeInicio.class);

                startActivity(i);
                break;

            case R.id.item1:
                DadosPessoais dadosPessoais = new DadosPessoais();
                ft.replace(R.id.layout_direito, dadosPessoais, "dados pessoais");

                break;
            case R.id.item2:

                BuscaAtiva buscaAtiva = new BuscaAtiva();
                ft.replace(R.id.layout_direito, buscaAtiva, "busca ativa");

                break;
            case R.id.item3:
                Acompanhamento acompanhamento = new Acompanhamento();

                ft.replace(R.id.layout_direito, acompanhamento, "busca ativa");

                break;
            case R.id.item4:
                Desfecho desfecho = new Desfecho();

                ft.replace(R.id.layout_direito, desfecho, "desfecho");

                break;
            case R.id.item6:
                DadosACS dadosACS = new DadosACS();

                ft.replace(R.id.layout_direito, dadosACS, "dados ACS");

                break;

        }
        ft.addToBackStack("pilha");
        ft.commit();

        return super.onMenuItemSelected(featureId, item);
    }
}
