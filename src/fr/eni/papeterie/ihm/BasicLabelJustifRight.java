package fr.eni.papeterie.ihm;

import fr.eni.papeterie.ihm.theme.Theme;

import javax.swing.*;
import java.awt.*;

public class BasicLabelJustifRight extends JLabel {

    private final Theme THEME = Theme.getTheme();

    public BasicLabelJustifRight(String text) {

        super(text,SwingConstants.RIGHT);

        this.setOpaque(true);

        this.setBackground(Color.decode(THEME.background_color));
        this.setForeground(Color.decode(THEME.font_color));

        this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

    }

}