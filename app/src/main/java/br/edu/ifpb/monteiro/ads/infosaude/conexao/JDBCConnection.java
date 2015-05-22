package br.edu.ifpb.monteiro.ads.infosaude.conexao;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Vanderlan
 */
public class JDBCConnection {

    public static Connection postgreSQLConnectionJDBC() {

        Connection conn = null;
        try {

            Class.forName("org.postgresql.Driver");

            String url = "jdbc:postgresql://192.168.0.107:5432/photogeo" +
                    "?sslfactory=org.postgresql.ssl.NonValidatingFactory&ssl=true";

            conn = DriverManager.getConnection(url,"postgres", "123");

            return conn;

        } catch (Exception e) {

            e.printStackTrace();

        }

        return conn;
    }

    public void efetuarLogin() {

        Statement stPostgres;
        ResultSet result = null;

        try {

            stPostgres = postgreSQLConnectionJDBC().createStatement();

            String sql = "select * from photo where eventid = 2234;";

            result = stPostgres.executeQuery(sql);


        } catch (SQLException e) {
            e.printStackTrace();
        }



        double probabilidade = 0;

        try {
            if (result.next()) {

                probabilidade =   result.getFloat(1);
                Log.d("SQL NO POSTGRES", "OK - CONEXÃO ESTABELECIDA "+probabilidade);

            }
        } catch (SQLException e) {

            Log.d("SQL NO POSTGRES", "OPAA - DEU MERDA");

        }



    }
}

