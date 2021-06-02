package fr.eni.papeterie.ihm;

import fr.eni.papeterie.bo.CouleursStylo;
import fr.eni.papeterie.ihm.theme.Theme;

import javax.swing.*;
import java.awt.*;

/** Classe d'interface graphique utilisateur
 *
 * @author laz_R
 * @version 1.0
 */
public class GUI extends JFrame {

    // • Déclaration

    // Constantes
    private final Theme THEME = Theme.getTheme();

    private final int LARGEUR_FENETRE = 350;
    private final int HAUTEUR_FENETRE = 400;

    private final int LARGEUR_INPUT_EN_COLONNES = 16;

    // Panneau principal
    private JPanel panneau_principal;

    // Sous-panneau 1
    private JPanel panneau_haut;
        // ligne 0
        private JLabel label_reference;
        private JTextField input_reference;
        // ligne 1
        private JLabel label_designation;
        private JTextField input_designation;
        // ligne 2
        private JLabel label_marque;
        private JTextField input_marque;
        // ligne 3
        private JLabel label_stock;
        private JTextField input_stock;
        // ligne 4
        private JLabel label_prix;
        private JTextField input_prix;
        // ligne 5
        private JLabel label_type;
        private JPanel input_type;
        private JRadioButton radio_button_ramette;
        private JRadioButton radio_button_stylo;

        // ligne 6
        private JLabel label_grammage;
        private JPanel input_grammage;
        private JCheckBox check_box_80_grammes;
        private JCheckBox check_box_100_grammes;

        // ligne 7
        private JLabel label_couleur;
        private JComboBox<CouleursStylo> input_couleur;

    // Sous-panneau 2
    private JPanel panneau_bas;
        // ligne 0
        private JButton bouton_precedent;
        private JButton bouton_nouveau;
        private JButton bouton_enregistrer;
        private JButton bouton_supprimer;
        private JButton bouton_suivant;

    /** Constructeur de l'interface utilisateur
     */
    public GUI() {

        // • INITIALISATION DE LA FENÊTRE
        // Nom de la fenêtre
        this.setTitle("Tp Papeterie");
        // Taille de la fenêtre
        this.setSize(LARGEUR_FENETRE,HAUTEUR_FENETRE);
        // pour ne prendre que la taille du contenu
        //this.pack();
        // On ne veut pas que la fenêtre puisse être redimensionnée
        this.setResizable(false);
        // Apparaît centrée sur l'écran principal
        this.setLocationRelativeTo(null);
        // Action quand on ferme la fenêtre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // • ATTRIBUTION DU PANNEAU PRINCIPAL
        this.setContentPane(getPanneau_principal());

        // • RENTRE LA FENÊTRE VISIBLE (a mettre en dernier)
        this.setVisible(true);
    }

    /** Gettostructeur du singleton panneau_principal
     * @return JPanel
     */
    public JPanel getPanneau_principal() {

        // Si pas d'instance déjà existante
        if (panneau_principal == null) {

            // • INITIALISATION DU PANNEAU PRINCIPAL
            panneau_principal = new JPanel();

            panneau_principal.setBackground(Color.decode(THEME.background_color));
            panneau_principal.setForeground(Color.decode(THEME.font_color));

            // • MISE EN PLACE DU LAYOUT DU PANNEAU PRINCIPAL
            panneau_principal.setLayout(new GridBagLayout());
            // contraintes relatives au layout GridBag
            GridBagConstraints gbc = new GridBagConstraints();

            // • PLACEMENT DES ELEMENTS

            gbc.gridx = 0; gbc.gridy = 0;
            panneau_principal.add(getPanneau_haut(), gbc);

            gbc.gridx = 0; gbc.gridy = 1;
            panneau_principal.add(getPanneau_bas(), gbc);
        }
        return panneau_principal;
    }

    /** Gettostructeur du Singleton panneau_haut
     * @return JPanel
     */
    public JPanel getPanneau_haut() {

        if (panneau_haut == null) {

            // • INITIALISATION DU PANNEAU
            panneau_haut = new JPanel();

            panneau_haut.setBackground(Color.decode(THEME.background_color));
            panneau_haut.setForeground(Color.decode(THEME.font_color));

            // • MISE EN PLACE DU LAYOUT DU PANNEAU
            panneau_haut.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();

            // • PLACEMENT DES ELEMENTS

            // ligne 0
            gbc.gridx = 0; gbc.gridy = 0;
            panneau_haut.add(getLabel_reference(),gbc);

            gbc.gridx = 1; gbc.gridy = 0;
            panneau_haut.add(getInput_reference(), gbc);

            // ligne 1
            gbc.gridx = 0; gbc.gridy = 1;
            panneau_haut.add(getLabel_designation(), gbc);

            gbc.gridx = 1; gbc.gridy = 1;
            panneau_haut.add(getInput_designation(), gbc);

            // ligne 2
            gbc.gridx = 0; gbc.gridy = 2;
            panneau_haut.add(getLabel_marque(), gbc);

            gbc.gridx = 1; gbc.gridy = 2;
            panneau_haut.add(getInput_marque(), gbc);

            // ligne 3
            gbc.gridx = 0; gbc.gridy = 3;
            panneau_haut.add(getLabel_stock(), gbc);

            gbc.gridx = 1; gbc.gridy = 3;
            panneau_haut.add(getInput_stock(), gbc);

            // ligne 4
            gbc.gridx = 0; gbc.gridy = 4;
            panneau_haut.add(getLabel_prix(), gbc);

            gbc.gridx = 1; gbc.gridy = 4;
            panneau_haut.add(getInput_prix(), gbc);

            // ligne 5
            gbc.gridx = 0; gbc.gridy = 5;
            panneau_haut.add(getLabel_type(), gbc);

            gbc.gridx = 1; gbc.gridy = 5;
            panneau_haut.add(getInput_type(), gbc);

            // ligne 6
            gbc.gridx = 0; gbc.gridy = 6;
            panneau_haut.add(getLabel_grammage(), gbc);

            gbc.gridx = 1; gbc.gridy = 6;
            panneau_haut.add(getInput_grammage(), gbc);

            // ligne 7
            gbc.gridx = 0; gbc.gridy = 7;
            panneau_haut.add(getLabel_couleur(), gbc);

            gbc.gridx = 1; gbc.gridy = 7;
            panneau_haut.add(getInput_couleur(), gbc);
        }
        return panneau_haut;
    }

    // Ligne 0

    /** Gettostructeur du Singleton label_reference
     * @return JLabel
     */
    public JLabel getLabel_reference() {
        if (label_reference == null) {
            label_reference = new BasicLabelJustifRight("Référence");
        }
        return label_reference;
    }

    /** Gettostructeur du Singleton input_reference
     * @return JTextField
     */
    public JTextField getInput_reference() {
        if (input_reference == null) {
            input_reference = new BasicTextInputField(LARGEUR_INPUT_EN_COLONNES);
        }
        return input_reference;
    }

    // Ligne 1

    /** Gettostructeur du Singleton label_designation
     * @return JLabel
     */
    public JLabel getLabel_designation() {
        if (label_designation == null) {
            label_designation = new BasicLabelJustifRight("Désignation");
        }
        return label_designation;
    }

    /** Gettostructeur du Singleton input_designation
     * @return JTextField
     */
    public JTextField getInput_designation() {
        if (input_designation == null) {
            input_designation = new BasicTextInputField(LARGEUR_INPUT_EN_COLONNES);
        }
        return input_designation;
    }

    // Ligne 2

    /** Gettostructeur du Singleton label_marque
     * @return JLabel
     */
    public JLabel getLabel_marque() {
        if (label_marque == null) {
            label_marque = new BasicLabelJustifRight("Marque");
        }
        return label_marque;
    }

    /** Gettostructeur du Singleton input_marque
     * @return JTextField
     */
    public JTextField getInput_marque() {
        if (input_marque == null) {
            input_marque = new BasicTextInputField(LARGEUR_INPUT_EN_COLONNES);
        }
        return input_marque;
    }

    // Ligne 3

    /** Gettostructeur du Singleton label_stock
     * @return JLabel
     */
    public JLabel getLabel_stock() {
        if (label_stock == null) {
            label_stock = new BasicLabelJustifRight("Stock");
        }
        return label_stock;
    }

    /** Gettostructeur du Singleton input_stock
     * @return JTextField
     */
    public JTextField getInput_stock() {
        if (input_stock == null) {
            input_stock = new BasicTextInputField(LARGEUR_INPUT_EN_COLONNES);
        }
        return input_stock;
    }

    // Ligne 4

    /** Gettostructeur du Singleton label_prix
     * @return JLabel
     */
    public JLabel getLabel_prix() {
        if (label_prix == null) {
            label_prix = new BasicLabelJustifRight("Prix");
        }
        return label_prix;
    }

    /** Gettostructeur du Singleton input_prix
     * @return JTextField
     */
    public JTextField getInput_prix() {
        if (input_prix == null) {
            input_prix = new BasicTextInputField(LARGEUR_INPUT_EN_COLONNES);
        }
        return input_prix;
    }

    // Ligne 5

    /** Gettostructeur du Singleton label_type
     * @return JLabel
     */
    public JLabel getLabel_type() {
        if (label_type == null) {
            label_type = new BasicLabelJustifRight("Type");
        }
        return label_type;
    }

    /** Gettostructeur du Singleton radio_button_ramette
     * @return JRadioButton
     */
    public JRadioButton getRadio_button_ramette() {
        if (radio_button_ramette == null) {
            radio_button_ramette = new JRadioButton("Ramette");
            radio_button_ramette.setBackground(Color.decode(THEME.background_color));
            radio_button_ramette.setForeground(Color.decode(THEME.font_color));
        }
        return radio_button_ramette;
    }

    /** Gettostructeur du Singleton radio_button_stylo
     * @return JRadioButton
     */
    public JRadioButton getRadio_button_stylo() {
        if (radio_button_stylo == null) {
            radio_button_stylo = new JRadioButton("Stylo");
            radio_button_stylo.setBackground(Color.decode(THEME.background_color));
            radio_button_stylo.setForeground(Color.decode(THEME.font_color));
        }
        return radio_button_stylo;
    }

    /** Gettostructeur du Singleton input_type
     * @return JPanel
     */
    public JPanel getInput_type() {
        if (input_type == null) {

            input_type = new JPanel();
            input_type.setBackground(Color.decode(THEME.background_color));
            input_type.setForeground(Color.decode(THEME.font_color));


            // • MISE EN PLACE DU LAYOUT DU PANNEAUL
            input_type.setLayout(new BorderLayout());

            ButtonGroup button_group_type = new ButtonGroup();
            button_group_type.add(getRadio_button_ramette());
            button_group_type.add(getRadio_button_stylo());

            // ajout au panneau
            input_type.add(getRadio_button_ramette(), BorderLayout.NORTH);
            input_type.add(getRadio_button_stylo(), BorderLayout.SOUTH);
        }
        return input_type;
    }

    // Ligne 6

    /** Gettostructeur du Singleton label_grammage
     * @return JLabel
     */
    public JLabel getLabel_grammage() {
        if (label_grammage == null) {
            label_grammage = new BasicLabelJustifRight("Grammage");
        }
        return label_grammage;
    }


    /** Gettostructeur du Singleton check_box_80_grammes
     * @return JCheckBox
     */
    public JCheckBox getCheck_box_80_grammes() {
        if (check_box_80_grammes == null) {
            check_box_80_grammes = new JCheckBox("80 grammes");
            check_box_80_grammes.setBackground(Color.decode(THEME.background_color));
            check_box_80_grammes.setForeground(Color.decode(THEME.font_color));
        }
        return check_box_80_grammes;
    }

    /** Gettostructeur du Singleton check_box_100_grammes
     * @return JCheckBox
     */
    public JCheckBox getCheck_box_100_grammes() {
        if (check_box_100_grammes == null) {
            check_box_100_grammes = new JCheckBox("100 grammes");
            check_box_100_grammes.setBackground(Color.decode(THEME.background_color));
            check_box_100_grammes.setForeground(Color.decode(THEME.font_color));
        }
        return check_box_100_grammes;
    }

    /** Gettostructeur du Singleton input_grammage
     * @return JPanel
     */
    public JPanel getInput_grammage() {
        if (input_grammage == null) {

            input_grammage = new JPanel();

            input_grammage.setBackground(Color.decode(THEME.background_color));
            input_grammage.setForeground(Color.decode(THEME.font_color));

            // • MISE EN PLACE DU LAYOUT DU PANNEAUL
            input_grammage.setLayout(new BorderLayout());

            ButtonGroup button_group_grammage = new ButtonGroup();
            button_group_grammage.add(getRadio_button_ramette());
            button_group_grammage.add(getRadio_button_stylo());

            input_grammage.add(getCheck_box_80_grammes(), BorderLayout.NORTH);
            input_grammage.add(getCheck_box_100_grammes(), BorderLayout.SOUTH);
        }
        return input_grammage;
    }

    // Ligne 7

    /** Gettostructeur du Singleton label_couleur
     * @return JLabel
     */
    public JLabel getLabel_couleur() {
        if (label_couleur == null) {
            label_couleur = new BasicLabelJustifRight("Couleur");
        }
        return label_couleur;
    }

    /** Gettostructeur du Singleton input_couleur
     * @return JComboBox
     */
    public JComboBox<CouleursStylo> getInput_couleur() {
        if (input_couleur == null) {
            input_couleur = new JComboBox<>(CouleursStylo.values());
            input_couleur.setBackground(Color.decode(THEME.input_background_color));
            input_couleur.setForeground(Color.decode(THEME.font_color));
        }
        return input_couleur;
    }

    /** Gettostructeur du Singleton panneau_bas
     * @return JPanel
     */
    public JPanel getPanneau_bas() {
        if (panneau_bas == null) {
            // • INITIALISATION DU PANNEAU
            panneau_bas = new JPanel();

            // • MISE EN PLACE DU LAYOUT DU PANNEAU
            panneau_bas.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();

            // • PLACEMENT DES ELEMENTS

            // ligne 0
            gbc.gridx = 0; gbc.gridy = 0;
            panneau_bas.add(getBouton_precedent(), gbc);

            gbc.gridx = 1; gbc.gridy = 0;
            panneau_bas.add(getBouton_nouveau(), gbc);

            gbc.gridx = 2; gbc.gridy = 0;
            panneau_bas.add(getBouton_enregistrer(), gbc);

            gbc.gridx = 3; gbc.gridy = 0;
            panneau_bas.add(getBouton_supprimer(), gbc);

            gbc.gridx = 4; gbc.gridy = 0;
            panneau_bas.add(getBouton_suivant(), gbc);
        }
        return panneau_bas;
    }

    /** Gettostructeur du Singleton bouton_precedent
     * @return JButton
     */
    public JButton getBouton_precedent() {
        if (bouton_precedent == null) {
            bouton_precedent = new BasicButtonWithIcon("resources/precedent.png");
        }
        return bouton_precedent;
    }

    /** Gettostructeur du Singleton bouton_nouveau
     * @return JButton
     */
    public JButton getBouton_nouveau() {
        if (bouton_nouveau == null) {
            bouton_nouveau = new BasicButtonWithIcon("resources/nouveau.png");
        }
        return bouton_nouveau;
    }

    /** Gettostructeur du Singleton bouton_enregistrer
     * @return JButton
     */
    public JButton getBouton_enregistrer() {
        if (bouton_enregistrer == null) {
            bouton_enregistrer = new BasicButtonWithIcon("resources/enregistrer.png");
        }
        return bouton_enregistrer;
    }

    /** Gettostructeur du Singleton bouton_supprimer
     * @return JButton
     */
    public JButton getBouton_supprimer() {
        if (bouton_supprimer == null) {
            bouton_supprimer = new BasicButtonWithIcon("resources/supprimer.png");
        }
        return bouton_supprimer;
    }

    /** Gettostructeur du Singleton bouton_suivant
     * @return JButton
     */
    public JButton getBouton_suivant() {
        if (bouton_suivant == null) {
            bouton_suivant = new BasicButtonWithIcon("resources/suivant.png");
        }
        return bouton_suivant;
    }

}