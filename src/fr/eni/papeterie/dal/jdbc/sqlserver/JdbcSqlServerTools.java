package fr.eni.papeterie.dal.jdbc.sqlserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcSqlServerTools {
    private static final String URL = JdbcSqlServerSettings.getPropriete("url");
    private static final String LOGIN = JdbcSqlServerSettings.getPropriete("login");
    private static final String MDP = JdbcSqlServerSettings.getPropriete("mdp");

    public static Connection instanceConnectionSqlServer() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, LOGIN, MDP);
        return connection;
    }

}
