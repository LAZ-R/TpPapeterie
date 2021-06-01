package fr.eni.papeterie.ihm.theme;

import fr.eni.papeterie.ihm.ThemeManager;

import java.util.Properties;

public class ThemeSettings {

    private static ThemeManager TM = new ThemeManager();
    private static Properties propriete;


    static {
        try {
            propriete = new Properties();
            propriete.load(ThemeSettings.class.getResourceAsStream(TM.actualTheme));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String getPropriete(String cle) {
        String parametre = propriete.getProperty(cle, null);
        return parametre;
    }
}
