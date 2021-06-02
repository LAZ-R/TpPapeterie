package fr.eni.papeterie.ihm;

import fr.eni.papeterie.ihm.theme.Theme;

import javax.swing.*;
import java.awt.*;

public class BasicButtonWithIcon extends JButton {

    private final Theme THEME = Theme.getTheme();

    public BasicButtonWithIcon(String cheminVersIcone) {

        super();

        Icon icone = new ImageIcon(this.getClass().getResource(cheminVersIcone));
        this.setIcon(icone);

        this.setBackground(Color.decode(THEME.background_color));

        this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        this.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                changeBackground(THEME.input_background_color);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                changeBackground(THEME.background_color);
            }
        });
    }

    public void changeBackground(String couleur) {
        this.setBackground(Color.decode(couleur));
    }
}
