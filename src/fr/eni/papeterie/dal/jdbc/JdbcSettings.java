package fr.eni.papeterie.dal.jdbc;

import java.util.Properties;

public class JdbcSettings {
    private static Properties propriete;

    static {
        try {
            propriete = new Properties();
            propriete.load(JdbcSettings.class.getResourceAsStream("settings.properties"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String getPropriete(String cle) {
        String parametre = propriete.getProperty(cle, null);
        return parametre;
    }
}
