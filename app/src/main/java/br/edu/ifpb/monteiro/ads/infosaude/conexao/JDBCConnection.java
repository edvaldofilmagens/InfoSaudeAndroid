package br.edu.ifpb.monteiro.ads.infosaude.conexao;

import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Vanderlan
 */
public class JDBCConnection {

    public Connection mySQLConnectionJDBC() {

        Connection conn = null;
        try {

            Class.forName("org.postgresql.Driver");

            conn = DriverManager.getConnection("jdbc:postgresql://192.168.0.107:5432/photogeo", "postgres", "123");

            return conn;

        } catch (Exception e) {

            e.printStackTrace();

        }

        return conn;
    }
}

