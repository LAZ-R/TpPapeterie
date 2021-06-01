package fr.eni.papeterie.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTools {
    private static final String URL = JdbcSettings.getPropriete("url");
    private static final String LOGIN = JdbcSettings.getPropriete("login");
    private static final String MDP = JdbcSettings.getPropriete("mdp");

    public static Connection instanceConnectionSqlServer() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, LOGIN, MDP);
        return connection;
    }

}
