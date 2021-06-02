package fr.eni.papeterie.ihm;

import fr.eni.papeterie.ihm.theme.Theme;

import javax.swing.*;
import java.awt.*;

public class BasicLabel extends JLabel {

    private final Theme THEME = Theme.getTheme();

    public BasicLabel(String text) {

        super(text);

        this.setOpaque(true);

        this.setBackground(Color.decode(THEME.background_color));
        this.setForeground(Color.decode(THEME.font_color));

        this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

    }

}
