package br.edu.ifpb.monteiro.ads.infosaude.comportamento;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import br.edu.ifpb.monteiro.ads.infosaude.formularios.Acompanhamento;
import br.edu.ifpb.monteiro.ads.infosaude.formularios.DadosPessoais;
import br.edu.ifpb.monteiro.ads.infosaude.formularios.Desfecho;

/**
 * Created by vanderlan on 21/03/15.
 * Classe responsável pela transição de TABS
 */
//CLASSE QUE TRATA DA TRANSIÇÃO DAS TABS
public class NavegacaoTabs extends FragmentPagerAdapter {

    public NavegacaoTabs(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

        switch (i) {

            case 0:
                DadosPessoais dadosPessoais = new DadosPessoais();
                return dadosPessoais;

            case 1:
                Acompanhamento acompanhamento = new Acompanhamento();
                return acompanhamento;

            default:
                Desfecho desfecho = new Desfecho();
                return desfecho;
        }
    }

    @Override
    public int getCount() {

        return 3;
    }

}