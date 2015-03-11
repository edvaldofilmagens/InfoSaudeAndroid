package br.edu.ifpb.monteiro.ads.infosaude.inicio;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.sql.ResultSet;
import java.sql.Statement;

import br.edu.ifpb.monteiro.ads.infosaude.conexao.JDBCConnection;
import infosaude.ads.monteiro.ifpb.edu.br.inicio.R;


public class InfoSaudeInicio extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_saude_inicio);

        try {
            testarJDBC();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_info_saude_inicio, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void fichaVisitaDomiciliar(View view) {

        VisitaDomiciliar visitaDomiciliar = new VisitaDomiciliar();

        Intent i = new Intent(this, VisitaDomiciliar.class);

        startActivity(i);

    }


    public void testarJDBC() throws Exception{

        JDBCConnection con = new JDBCConnection();

        Statement stPostgres = con.mySQLConnectionJDBC().createStatement();

        String sql = "select * from photo where eventid = 2234;";

        ResultSet result = stPostgres.executeQuery(sql);

        double probabilidade = 0;

        if (result.next()) {

            probabilidade =   result.getFloat(1);

        }

        Toast.makeText(this, probabilidade +"", Toast.LENGTH_SHORT);

    }
}
