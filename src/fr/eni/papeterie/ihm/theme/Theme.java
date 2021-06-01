package fr.eni.papeterie.ihm.theme;

public class Theme {
    public String background_color="";
    public String input_background_color="";
    public String font_color="";
    public static Theme instance;

    private Theme() {
        this.background_color = ThemeSettings.getPropriete("background_color");
        this.input_background_color =  ThemeSettings.getPropriete("input_background_color");
        this.font_color = ThemeSettings.getPropriete("font_color");
    }

    public static Theme getTheme() {
        if (instance == null) {
            instance = new Theme();
        }
        return instance;
    }
}
