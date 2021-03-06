package fr.eni.papeterie.dal.jdbc.sqlserver;

import java.util.Properties;

public class JdbcSqlServerSettings {
    private static Properties propriete;

    static {
        try {
            propriete = new Properties();
            propriete.load(JdbcSqlServerSettings.class.getResourceAsStream("settingsSqlServer.properties"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String getPropriete(String cle) {
        String parametre = propriete.getProperty(cle, null);
        return parametre;
    }
}
