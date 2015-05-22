package br.edu.ifpb.monteiro.ads.infosaude.formularios;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import br.edu.ifpb.monteiro.ads.infosaude.comportamento.NavegacaoTabs;
import infosaude.ads.monteiro.ifpb.edu.br.inicio.R;

/**
 * Created by Vanderlan Gomes on 25/02/15.
 */
public class VisitaDomiciliar extends FragmentActivity implements ActionBar.TabListener{

    private NavegacaoTabs mAppSectionsPagerAdapter;
    private ViewPager mViewPager;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visita_domiciliar);

        mAppSectionsPagerAdapter = new NavegacaoTabs(getSupportFragmentManager());

        // Set up the action bar.
        final ActionBar actionBar = getActionBar();

        actionBar.setHomeButtonEnabled(true);

        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mAppSectionsPagerAdapter);
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }
        });

        //ADICIONANDO TABS
        ActionBar.Tab tab1 = actionBar.newTab();
        tab1.setText("Dados pessoais");
        tab1.setIcon(R.drawable.dados_pessoais);
        tab1.setTabListener(this);
        actionBar.addTab(tab1);

        ActionBar.Tab tab2 = actionBar.newTab();
        tab2.setText("Acompanhamento");
        tab2.setIcon(R.drawable.aconpanhamento);
        tab2.setTabListener(this);
        actionBar.addTab(tab2);

        ActionBar.Tab tab3 = actionBar.newTab();
        tab3.setText("Finalizar Visita");
        tab3.setIcon(R.drawable.finalizar_visita);
        tab3.setTabListener(this);
        actionBar.addTab(tab3);

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

}
