/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Quentin Fankrache
 */
public final class SqlConnection {

    private static final String host = "localhost";
    private static final String port = "3306";
    private static final String base = "nouvellesdereves";
    private static final String login = "root";
    private static final String password = "";
    private static final String url = "jdbc:mysql://" + host + ":" + port + "/" + base;
    private static final String url1 = url + "?user=" + login + "&password=" + password;
    static Connection connection = null;

    private SqlConnection() {
    }

    public static Connection getInstance() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(url, login, password);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
            return connection;
        } else {
            return connection;
        }
    }

}
