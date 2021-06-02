package fr.eni.papeterie.ihm;

import fr.eni.papeterie.ihm.theme.Theme;

import javax.swing.*;
import java.awt.*;

public class BasicTextInputField extends JTextField {

    private final Theme THEME = Theme.getTheme();

    public BasicTextInputField(int columns) {
        super(columns);

        this.setBackground(Color.decode(THEME.input_background_color));
        this.setForeground(Color.decode(THEME.font_color));

        this.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
    }
}
