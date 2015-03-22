package br.edu.ifpb.monteiro.ads.infosaude.comportamento;

import android.app.ActionBar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.util.Log;

import infosaude.ads.monteiro.ifpb.edu.br.inicio.R;

/**
 * Created by vanderlan on 21/03/15.
 */
//CLASSE QUE TRATA DA TRANSIÇÃO DAS TABS
public class NavegacaoTabs implements ActionBar.TabListener{

    private Fragment frag;

    public NavegacaoTabs(Fragment frag) {

        this.frag = frag;
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {

        FragmentTransaction fts  =  frag.getActivity().getSupportFragmentManager().beginTransaction();
        fts.replace(R.id.layout_direito, frag);
        fts.commit();

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {
        FragmentTransaction fts  =  frag.getActivity().getSupportFragmentManager().beginTransaction();
        fts.remove(frag);
        fts.commit();
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {
        Log.i("TAB", "TAB RESELECT");
    }
}

