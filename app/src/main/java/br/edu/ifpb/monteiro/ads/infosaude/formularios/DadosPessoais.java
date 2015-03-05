package br.edu.ifpb.monteiro.ads.infosaude.formularios;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import infosaude.ads.monteiro.ifpb.edu.br.inicio.R;

/**
 * Created by vanderlan on 25/02/15.
 */
public class DadosPessoais extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.vd_dados_pessoais, null);

        return view;
    }

}
