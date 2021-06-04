package fr.eni.papeterie.dal.jdbc.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcSQLiteTools {
    private static final String URL = JdbcSQLiteSettings.getPropriete("url");

    public static Connection instanceConnectionSQLite() throws SQLException {
        Connection connection = DriverManager.getConnection(URL);
        return connection;
    }

}
