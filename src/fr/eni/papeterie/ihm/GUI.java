package fr.eni.papeterie.ihm;

import fr.eni.papeterie.bll.BLLException;
import fr.eni.papeterie.bll.CatalogueManager;
import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.CouleursStylo;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;
import fr.eni.papeterie.ihm.components.BasicButtonWithIcon;
import fr.eni.papeterie.ihm.components.BasicLabel;
import fr.eni.papeterie.ihm.components.BasicTextInputField;
import fr.eni.papeterie.ihm.theme.Theme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/** Classe d'interface graphique utilisateur
 *
 * @author laz_R
 * @version 1.0
 */
public class GUI extends JFrame {

    // • Déclaration

    // Constantes
    private final Theme THEME = Theme.getTheme();

    private final int LARGEUR_FENETRE = 360;
    private final int HAUTEUR_FENETRE = 492;

    private final int LARGEUR_INPUT_EN_COLONNES = 17;

    // Variables
    private List<Article> liste;
    private Article article_actuellement_consulte = null;
    private int index_article_actuellement_consulte = 0;

    // Components

    // Panneau principal
    private JPanel panneau_principal;

    // Affichage de l'article en cours et du total d'articles
    private JLabel titre_header;

    // Affichage de l'article en cours et du total d'articles
    private JLabel affichage_article_actuel;

    // Panneau Haut
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
        private ButtonGroup button_group_grammage;
        private JCheckBox check_box_80_grammes;
        private JCheckBox check_box_100_grammes;

        // ligne 7
        private JLabel label_couleur;
        private JComboBox<CouleursStylo> input_couleur;

    // Panneau Boutons
    private JPanel panneau_boutons;
        // ligne 0
        private JButton bouton_precedent;
        private JButton bouton_nouveau;
        private JButton bouton_modifier;
        private JButton bouton_annuler;
        private JButton bouton_enregistrer;
        private JButton bouton_supprimer;
        private JButton bouton_suivant;

    // Zone Warning
        private JLabel info_text;

    /** Constructeur de l'interface utilisateur
     */
    public GUI() {

        // • INITIALISATION DE LA FENÊTRE

        // Nom de la fenêtre
        this.setTitle("Tp Papeterie");
        //this.setUndecorated(true);

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

        // • RENDRE LA FENÊTRE VISIBLE (a mettre en dernier)
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
            panneau_principal.add(getTitre_header(), gbc);

            gbc.gridx = 0; gbc.gridy = 1;
            panneau_principal.add(getAffichage_article_actuel(), gbc);

            gbc.gridx = 0; gbc.gridy = 2;
            panneau_principal.add(getPanneau_haut(), gbc);

            gbc.gridx = 0; gbc.gridy = 3;
            panneau_principal.add(getInfo_text(), gbc);

            gbc.gridx = 0; gbc.gridy = 4;
            panneau_principal.add(getPanneau_boutons(), gbc);

            afficherArticleBaseDeDonnee(index_article_actuellement_consulte);
        }
        return panneau_principal;
    }

    /** Gettostructeur du Singleton titre_header
     * @return JLabel
     */
    public JLabel getTitre_header() {

        if (titre_header == null) {
            titre_header = new JLabel();
            titre_header.setBackground(Color.decode(THEME.background_color));
            titre_header.setForeground(Color.decode(THEME.font_color));
            titre_header.setText("• PAPETERIE •");
            titre_header.setBorder(BorderFactory.createEmptyBorder(4,5,2,5));
            titre_header.setFont(new Font("Arial",Font.BOLD, 22));
        }
        return titre_header;
    }

    /** Gettostructeur du Singleton affichage_article_actuel
     * @return JLabel
     */
    public JLabel getAffichage_article_actuel() {

        if (affichage_article_actuel == null) {
            affichage_article_actuel = new JLabel();
            affichage_article_actuel.setBackground(Color.decode(THEME.background_color));
            affichage_article_actuel.setForeground(Color.decode(THEME.font_color));
            affichage_article_actuel.setBorder(BorderFactory.createEmptyBorder(2,10,4,10));
        }
        return affichage_article_actuel;
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

            // ligne 0 - Référence
            gbc.gridx = 0; gbc.gridy = 0;
            panneau_haut.add(getLabel_reference(),gbc);

            gbc.gridx = 1; gbc.gridy = 0;
            panneau_haut.add(getInput_reference(), gbc);

            // ligne 1 - Désignation
            gbc.gridx = 0; gbc.gridy = 1;
            panneau_haut.add(getLabel_designation(), gbc);

            gbc.gridx = 1; gbc.gridy = 1;
            panneau_haut.add(getInput_designation(), gbc);

            // ligne 2 - Marque
            gbc.gridx = 0; gbc.gridy = 2;
            panneau_haut.add(getLabel_marque(), gbc);

            gbc.gridx = 1; gbc.gridy = 2;
            panneau_haut.add(getInput_marque(), gbc);

            // ligne 3 - Stock
            gbc.gridx = 0; gbc.gridy = 3;
            panneau_haut.add(getLabel_stock(), gbc);

            gbc.gridx = 1; gbc.gridy = 3;
            panneau_haut.add(getInput_stock(), gbc);

            // ligne 4 - Prix
            gbc.gridx = 0; gbc.gridy = 4;
            panneau_haut.add(getLabel_prix(), gbc);

            gbc.gridx = 1; gbc.gridy = 4;
            panneau_haut.add(getInput_prix(), gbc);

            // ligne 5 - Type
            gbc.gridx = 0; gbc.gridy = 5;
            panneau_haut.add(getLabel_type(), gbc);

            gbc.gridx = 1; gbc.gridy = 5;
            panneau_haut.add(getInput_type(), gbc);

            // ligne 6 - Grammage
            gbc.gridx = 0; gbc.gridy = 6;
            panneau_haut.add(getLabel_grammage(), gbc);
            //label_grammage.setVisible(false);

            gbc.gridx = 1; gbc.gridy = 6;
            panneau_haut.add(getInput_grammage(), gbc);


            // ligne 7 - Couleur
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
            label_reference = new BasicLabel("Référence");
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
            label_designation = new BasicLabel("Désignation");
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
            label_marque = new BasicLabel("Marque");
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
            label_stock = new BasicLabel("Stock");
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
            label_prix = new BasicLabel("Prix");
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
            label_type = new BasicLabel("Type");
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
            radio_button_ramette.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    label_grammage.setEnabled(true);
                    check_box_80_grammes.setEnabled(true);
                    check_box_100_grammes.setEnabled(true);

                    label_couleur.setEnabled(false);
                    input_couleur.setEnabled(false);
                }
            });
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
            radio_button_stylo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    label_grammage.setEnabled(false);
                    check_box_80_grammes.setEnabled(false);
                    check_box_100_grammes.setEnabled(false);

                    label_couleur.setEnabled(true);
                    input_couleur.setEnabled(true);
                }
            });
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


            // • MISE EN PLACE DU LAYOUT DU PANNEAU
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
            label_grammage = new BasicLabel("Grammage");
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
            check_box_80_grammes.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    check_box_100_grammes.setSelected(false);
                }
            });
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
            check_box_100_grammes.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    check_box_80_grammes.setSelected(false);
                }
            });
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

            button_group_grammage = new ButtonGroup();
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
            label_couleur = new BasicLabel("Couleur");
        }
        return label_couleur;
    }

    /** Gettostructeur du Singleton input_couleur
     * @return JComboBox
     */
    public JComboBox<CouleursStylo> getInput_couleur() {
        if (input_couleur == null) {
            input_couleur = new JComboBox<>(CouleursStylo.values());
            input_couleur.setSelectedItem(CouleursStylo.NOIR);
            input_couleur.setBackground(Color.decode(THEME.input_background_color));
            input_couleur.setForeground(Color.decode(THEME.input_font_color));
        }
        return input_couleur;
    }

    /** Gettostructeur du Singleton info_text
     * @return JLabel
     */
    public JLabel getInfo_text() {
        if (info_text == null) {
            info_text = new JLabel();
            info_text.setBackground(Color.decode(THEME.background_color));
            info_text.setBorder(BorderFactory.createEmptyBorder(2,2,5,2));

            info_text.setText(" "); // Vide de base (mais avec un espace, pour prendre sa "place physique")
        }
        return info_text;
    }

    /** Gettostructeur du Singleton panneau_boutons
     * @return JPanel
     */
    public JPanel getPanneau_boutons() {
        if (panneau_boutons == null) {
            // • INITIALISATION DU PANNEAU
            panneau_boutons = new JPanel();

            // • MISE EN PLACE DU LAYOUT DU PANNEAU
            panneau_boutons.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();

            // • PLACEMENT DES ELEMENTS

            // ligne 0
            gbc.gridx = 0; gbc.gridy = 0;
            panneau_boutons.add(getBouton_precedent(), gbc);

            gbc.gridx = 1; gbc.gridy = 0;
            panneau_boutons.add(getBouton_nouveau(), gbc);

            gbc.gridx = 2; gbc.gridy = 0;
            panneau_boutons.add(getBouton_modifier(), gbc);

            gbc.gridx = 3; gbc.gridy = 0;
            panneau_boutons.add(getBouton_enregistrer(), gbc);

            gbc.gridx = 4; gbc.gridy = 0;
            panneau_boutons.add(getBouton_supprimer(), gbc);

            gbc.gridx = 5; gbc.gridy = 0;
            panneau_boutons.add(getBouton_suivant(), gbc);

            gbc.gridx = 6; gbc.gridy = 0;
            panneau_boutons.add(getBouton_annuler(), gbc);
        }
        return panneau_boutons;
    }

    /** Gettostructeur du Singleton bouton_precedent
     * @return JButton
     */
    public JButton getBouton_precedent() {
        if (bouton_precedent == null) {
            bouton_precedent = new BasicButtonWithIcon("../resources/precedent.png");
            bouton_precedent.setToolTipText("Article Précedent");
            bouton_precedent.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    info_text.setText(" ");

                    // Mise à jour de l'index de l'article actuellement consulté
                    index_article_actuellement_consulte -= 1;
                    // Affichage de l'article actuellement consulté
                    afficherArticleBaseDeDonnee(index_article_actuellement_consulte);
                }
            });
        }
        return bouton_precedent;
    }

    /** Gettostructeur du Singleton bouton_nouveau
     * @return JButton
     */
    public JButton getBouton_nouveau() {
        if (bouton_nouveau == null) {
            bouton_nouveau = new BasicButtonWithIcon("../resources/nouveau.png");
            bouton_nouveau.setToolTipText("Créer un nouvel article");
            bouton_nouveau.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    info_text.setText(" ");
                    affichage_article_actuel.setText(" ");
                    // Mise à 0 de l'ID de l'article consulté, pour que le programme sache que c'est un INSERT et pas un DELETE
                    article_actuellement_consulte.setIdArticle(0);

                    // Remise à 0 des champs de texte
                    input_reference.setText("");
                    input_designation.setText("");
                    input_marque.setText("");
                    input_stock.setText("");
                    input_prix.setText("");

                    //rends les champs éditables
                    input_reference.setEditable(true);
                    input_designation.setEditable(true);
                    input_marque.setEditable(true);
                    input_stock.setEditable(true);
                    input_prix.setEditable(true);

                    // Sélection ramette par défaut
                    radio_button_ramette.setSelected(true);
                    radio_button_stylo.setSelected(false);

                    label_grammage.setEnabled(true);
                    check_box_80_grammes.setEnabled(true);
                    check_box_100_grammes.setEnabled(true);

                    label_couleur.setEnabled(false);
                    input_couleur.setEnabled(false);

                    // Changement du set de boutons disponible
                    bouton_precedent.setVisible(false);
                    bouton_nouveau.setVisible(false);
                    bouton_modifier.setVisible(false);
                    bouton_enregistrer.setVisible(true);
                    bouton_annuler.setVisible(true);
                    bouton_supprimer.setVisible(false);
                    bouton_suivant.setVisible(false);
                }
            });
        }
        return bouton_nouveau;
    }

    /** Gettostructeur du Singleton bouton_modifier
     * @return JButton
     */
    public JButton getBouton_modifier() {
        if (bouton_modifier == null) {
            bouton_modifier = new BasicButtonWithIcon("../resources/modifier.png");
            bouton_modifier.setToolTipText("Modifier l'article");
            bouton_modifier.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    info_text.setText(" ");

                    // Rends les champs éditables
                    input_reference.setEditable(true);
                    input_designation.setEditable(true);
                    input_marque.setEditable(true);
                    input_stock.setEditable(true);
                    input_prix.setEditable(true);

                    // Changement du set de boutons disponible
                    bouton_precedent.setVisible(false);
                    bouton_nouveau.setVisible(false);
                    bouton_modifier.setVisible(false);
                    bouton_enregistrer.setVisible(true);
                    bouton_annuler.setVisible(true);
                    bouton_supprimer.setVisible(true);
                    bouton_suivant.setVisible(false);
                }
            });
        }
        return bouton_modifier;
    }

    /** Gettostructeur du Singleton bouton_annuler
     * @return JButton
     */
    public JButton getBouton_annuler() {
        if (bouton_annuler == null) {
            bouton_annuler = new BasicButtonWithIcon("../resources/annuler.png");
            bouton_annuler.setToolTipText("Annuler");

            bouton_annuler.setVisible(false); //invisible par défaut

            bouton_annuler.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    info_text.setText(" ");

                    // On recharge et affiche le dernier article consulté
                    afficherArticleBaseDeDonnee(index_article_actuellement_consulte);

                    // Changement du set de boutons disponible
                    bouton_precedent.setVisible(true);
                    bouton_nouveau.setVisible(true);
                    bouton_modifier.setVisible(true);
                    bouton_enregistrer.setVisible(false);
                    bouton_annuler.setVisible(false);
                    bouton_supprimer.setVisible(false);
                    bouton_suivant.setVisible(true);
                }
            });
        }
        return bouton_annuler;
    }

    /** Gettostructeur du Singleton bouton_enregistrer
     * @return JButton
     */
    public JButton getBouton_enregistrer() {
        if (bouton_enregistrer == null) {
            bouton_enregistrer = new BasicButtonWithIcon("../resources/enregistrer.png");
            bouton_enregistrer.setToolTipText("Enregistrer l'Article");

            bouton_enregistrer.setVisible(false); //invisible par défaut

            bouton_enregistrer.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    info_text.setText(" ");

                    CatalogueManager cm = CatalogueManager.getInstance();

                    Article article_a_ajouter = null;

                    if (radio_button_ramette.isSelected()) {
                        article_a_ajouter = new Ramette();
                        if (check_box_80_grammes.isSelected()) {
                            ((Ramette)article_a_ajouter).setGrammage(80);
                        }
                        else if (check_box_100_grammes.isSelected()) {
                            ((Ramette)article_a_ajouter).setGrammage(100);
                        }
                    }
                    else if (radio_button_stylo.isSelected()){
                        article_a_ajouter = new Stylo();
                        switch (input_couleur.getItemAt(input_couleur.getSelectedIndex())) {
                            case NOIR :
                                ((Stylo)article_a_ajouter).setCouleur("noir");
                                break;
                            case BLEU :
                                ((Stylo)article_a_ajouter).setCouleur("bleu");
                                break;
                            case ROUGE :
                                ((Stylo)article_a_ajouter).setCouleur("rouge");
                                break;
                            case VERT :
                                ((Stylo)article_a_ajouter).setCouleur("vert");
                                break;
                            case JAUNE :
                                ((Stylo)article_a_ajouter).setCouleur("jaune");
                                break;
                        }
                    }
                    article_a_ajouter.setReference(input_reference.getText());
                    article_a_ajouter.setDesignation(input_designation.getText());
                    article_a_ajouter.setMarque(input_marque.getText());
                    try {
                        article_a_ajouter.setQuantite_stock(Integer.parseInt(input_stock.getText()));
                    }
                    catch (NumberFormatException nbe) {
                        // On ne mets rien ici car cette exception va se transformer en exception BLL traitée juste après
                    }
                    try {
                        article_a_ajouter.setPrix_unitaire(Float.parseFloat(input_prix.getText()));
                    }
                    catch (NumberFormatException nbe) {
                        // On ne mets rien ici car cette exception va se transformer en exception BLL traitée juste après
                    }
                    article_a_ajouter.setIdArticle(article_actuellement_consulte.getIdArticle());

                    try {
                        // Vérification de la validité de l'article à intéragir avec la BDD
                        if (cm.validerArticle(article_a_ajouter)) {

                            // Si l'ID de l'article est égal à 0 alors c'est que c'est un Nouvel article et qu'il faut faire un INSERT
                            if (article_a_ajouter.getIdArticle() == 0) {
                                cm.addArticle(article_a_ajouter);

                                // Affichage à l'utilisateur que tout s'est bien passé
                                info_text.setForeground(Color.decode(THEME.font_color));
                                info_text.setText("L' article a bien été ajouté au catalogue");

                                // Mise à jour de la longueur de la liste d'article
                                afficherArticleBaseDeDonnee(index_article_actuellement_consulte);

                                // Le nouvel article est forcément à la fin de la liste, donc on défini l'index de l'article actuel à la longueur de la liste -1
                                index_article_actuellement_consulte = liste.size()-1;

                                // Affichage de l'article nouvellement crée
                                afficherArticleBaseDeDonnee(index_article_actuellement_consulte);
                            }

                            // Si l'ID de l'article est différent de 0, alors c'est que c'est un article existant et qu'il faut faire un UPDATE
                            else {
                                cm.updateArticle(article_a_ajouter);

                                // Affichage à l'utilisateur que tout s'est bien passé
                                info_text.setForeground(Color.decode(THEME.font_color));
                                info_text.setText("L' article a bien été modifié");

                                // Affichage de l'article nouvellement modifié
                                afficherArticleBaseDeDonnee(index_article_actuellement_consulte);
                            }
                        }

                        // Changement du set de boutons disponible
                        bouton_precedent.setVisible(true);
                        bouton_nouveau.setVisible(true);
                        bouton_modifier.setVisible(true);
                        bouton_enregistrer.setVisible(false);
                        bouton_annuler.setVisible(false);
                        bouton_supprimer.setVisible(false);
                        bouton_suivant.setVisible(true);
                    } catch (BLLException f) {

                        // Affichage à l'utilisateur qu'un problème est survenu (et sur quel champ)
                        info_text.setForeground(Color.decode(THEME.warning_font_color));
                        info_text.setText("ERREUR DE SAISIE. " + f.getMessage());
                    }
                }
            });
        }
        return bouton_enregistrer;
    }

    /** Gettostructeur du Singleton bouton_supprimer
     * @return JButton
     */
    public JButton getBouton_supprimer() {
        if (bouton_supprimer == null) {
            bouton_supprimer = new BasicButtonWithIcon("../resources/supprimer.png");
            bouton_supprimer.setToolTipText("Supprimer l'Article");

            bouton_supprimer.setVisible(false); //invisible par défaut

            bouton_supprimer.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CatalogueManager cm = CatalogueManager.getInstance();
                    try {
                        cm.removeArticle(article_actuellement_consulte.getIdArticle());

                        // Affichage à l'utilisateur que tout s'est bien passé
                        info_text.setForeground(Color.decode(THEME.font_color));
                        info_text.setText("L' article a bien été supprimé du catalogue");

                        // Affichage de l'article précédent celui nouvellement supprimé (ou du 1er si c'était le 1er)
                        index_article_actuellement_consulte -= 1;
                        afficherArticleBaseDeDonnee(index_article_actuellement_consulte);

                        // Changement du set de boutons disponible
                        bouton_precedent.setVisible(true);
                        bouton_nouveau.setVisible(true);
                        bouton_modifier.setVisible(true);
                        bouton_enregistrer.setVisible(false);
                        bouton_annuler.setVisible(false);
                        bouton_supprimer.setVisible(false);
                        bouton_suivant.setVisible(true);

                    } catch (BLLException bllException) {
                        info_text.setForeground(Color.decode(THEME.warning_font_color));
                        info_text.setText("ERREUR LORS DE LA SUPPRESSION");
                    }
                }
            });
        }
        return bouton_supprimer;
    }

    /** Gettostructeur du Singleton bouton_suivant
     * @return JButton
     */
    public JButton getBouton_suivant() {
        if (bouton_suivant == null) {
            bouton_suivant = new BasicButtonWithIcon("../resources/suivant.png");
            bouton_suivant.setToolTipText("Article Suivant");
            bouton_suivant.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    info_text.setText(" ");

                    // Mise à jour de l'index de l'article actuellement consulté
                    index_article_actuellement_consulte += 1;
                    // Affichage de l'article actuellement consulté
                    afficherArticleBaseDeDonnee(index_article_actuellement_consulte);
                }
            });
        }
        return bouton_suivant;
    }



    /** Méthode d'affichage graphique d'un article déjà en base de donnée,
     *  dont l'index dans la liste d'articles est renseigné en paramètre
     * @param index - int
     */
    public void afficherArticleBaseDeDonnee(int index) {

        CatalogueManager cm = CatalogueManager.getInstance();
        Article article_actuel = null;
        try {
            // Rafraichissement de la liste d'articles
            liste = cm.getCatalogue();

            // Vérification de la validité de l'index en paramètre
            if (index > liste.size()-1) {
                index_article_actuellement_consulte = 0;
                index = index_article_actuellement_consulte;
            }
            if (index < 0) {
                index_article_actuellement_consulte = liste.size()-1;
                index = index_article_actuellement_consulte;
            }

            // Mise à jour de l'affichage de la place de l'article sur le total d'articles en fonction de l'index renseigné
            int place_article = index + 1;
            int total_articles = liste.size();
            affichage_article_actuel.setText(String.valueOf(place_article)+"/"+String.valueOf(total_articles));

            // Aspiration de l'article recherché grâce à son index dans la liste
            article_actuel = liste.get(index);

            // • Remplissage (et désactivation de l'édition) des champs en fonction du contenu de l'article précedement récupéré

            input_reference.setText(article_actuel.getReference().trim());
            input_reference.setEditable(false);

            input_designation.setText(article_actuel.getDesignation().trim());
            input_designation.setEditable(false);

            input_marque.setText(article_actuel.getMarque().trim());
            input_marque.setEditable(false);

            input_stock.setText(String.valueOf(article_actuel.getQuantite_stock()));
            input_stock.setEditable(false);

            input_prix.setText(String.valueOf(article_actuel.getPrix_unitaire()));
            input_prix.setEditable(false);

            // Si l'article est une Ramette
            if (article_actuel instanceof Ramette) {

                radio_button_ramette.setSelected(true);
                radio_button_stylo.setSelected(false);

                if (((Ramette) article_actuel).getGrammage() == 80) {
                    check_box_80_grammes.setSelected(true);
                    check_box_100_grammes.setSelected(false);
                }
                else if (((Ramette) article_actuel).getGrammage() == 100) {
                    check_box_80_grammes.setSelected(false);
                    check_box_100_grammes.setSelected(true);
                }

                // Mise à jour de l'affichage en fonction du type d'article
                label_grammage.setEnabled(true);
                check_box_80_grammes.setEnabled(true);
                check_box_100_grammes.setEnabled(true);

                label_couleur.setEnabled(false);
                input_couleur.setEnabled(false);
            }

            // Sinon, si l'article est un Stylo
            else if (article_actuel instanceof Stylo) {

                radio_button_ramette.setSelected(false);
                radio_button_stylo.setSelected(true);

                switch (((Stylo) article_actuel).getCouleur()) {
                    case "noir":
                        input_couleur.setSelectedItem(CouleursStylo.NOIR);
                        break;
                    case "bleu":
                        input_couleur.setSelectedItem(CouleursStylo.BLEU);
                        break;
                    case "rouge":
                        input_couleur.setSelectedItem(CouleursStylo.ROUGE);
                        break;
                    case "vert":
                        input_couleur.setSelectedItem(CouleursStylo.VERT);
                        break;
                    case "jaune":
                        input_couleur.setSelectedItem(CouleursStylo.JAUNE);
                        break;
                }

                // Mise à jour de l'affichage en fonction du type d'article
                label_grammage.setEnabled(false);
                check_box_80_grammes.setEnabled(false);
                check_box_100_grammes.setEnabled(false);

                label_couleur.setEnabled(true);
                input_couleur.setEnabled(true);
            }

        } catch (BLLException e) {
            e.printStackTrace();
        }

        // Mise à jour de l'article actuellement consulté
        article_actuellement_consulte = article_actuel;
    }

}