package fr.eni.papeterie.dal.jdbc.sqlite;

import java.util.Properties;

public class JdbcSQLiteSettings {
    private static Properties propriete;

    static {
        try {
            propriete = new Properties();
            propriete.load(JdbcSQLiteSettings.class.getResourceAsStream("settingsSQLite.properties"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String getPropriete(String cle) {
        String parametre = propriete.getProperty(cle, null);
        return parametre;
    }
}
