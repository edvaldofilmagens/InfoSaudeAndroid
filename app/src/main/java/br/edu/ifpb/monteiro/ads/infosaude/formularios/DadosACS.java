package br.edu.ifpb.monteiro.ads.infosaude.formularios;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import infosaude.ads.monteiro.ifpb.edu.br.inicio.R;

/**
 * Created by vanderlan on 01/03/15.
 */
public class DadosACS extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.vd_dados_acs, null);

        return view;
    }

}