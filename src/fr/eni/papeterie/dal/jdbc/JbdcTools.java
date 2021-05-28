package fr.eni.papeterie.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JbdcTools {
    private static final String URL = Settings.getPropriete("url");
    private static final String LOGIN = Settings.getPropriete("login");
    private static final String MDP = Settings.getPropriete("mdp");

    public static Connection instanceConnectionSqlServer() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, LOGIN, MDP);
        return connection;
    }

}
