package fr.eni.papeterie.ihm;

import fr.eni.papeterie.bo.CouleursStylo;
import fr.eni.papeterie.ihm.theme.Theme;

import javax.swing.*;
import java.awt.*;

/** Classe d'interface graphique pour l'utilisateur
 *
 */
public class GUI extends JFrame {

    // Constantes

    private final Theme THEME = Theme.getTheme();

    private final int COLONNES_INPUT = 16;
    private final int LARGEUR_FENETRE = 350;
    private final int HAUTEUR_FENETRE = 400;

    private final String COULEUR_FOND = THEME.background_color;
    private final String COULEUR_FOND_INPUT = THEME.input_background_color;
    private final String COULEUR_TEXTE = THEME.font_color;

    // • Déclaration
    private JPanel panneau_principal;

    // sous panneau 1
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
    private ButtonGroup button_group_type;
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
    private JComboBox input_couleur;

    // sous panneau 2
    private JPanel panneau_bas;

    // boutons
    private JButton bouton_precedent;
    private JButton bouton_nouveau;
    private JButton bouton_enregistrer;
    private JButton bouton_supprimer;
    private JButton bouton_suivant;

    /** Constructeur de l'interface utilisateur
     *
     */
    public GUI() {

        // • INITIALISATION DU PANNEAU EN BOIS
        this.setTitle("Tp Papeterie");
        this.setSize(LARGEUR_FENETRE,HAUTEUR_FENETRE);
        // action quand fermé
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // centrer sur l'écran principal
        this.setLocationRelativeTo(null);

        // • INITIALISATION DU PANNEAU PRINCIPAL
        this.setContentPane(getPanneau_principal());

        // pour ne prendre que la taille du contenu
        //this.pack();

        // • RENTRE LE PANNEAU EN BOIS VISIBLE (a mettre en dernier)
        this.setVisible(true);
    }

    /** Gettostructeur du singleton panneau_principal
     *
     * @return JPanel
     */
    public JPanel getPanneau_principal() {

        // Si pas d'instance déjà existante
        if (panneau_principal == null) {

            // • INITIALISATION DU PANNEAU PRINCIPAL
            panneau_principal = new JPanel();
            panneau_principal.setBackground(Color.decode(COULEUR_FOND));
            panneau_principal.setForeground(Color.decode(COULEUR_TEXTE));

            // • MISE EN PLACE DU LAYOUT DU PANNEAU PRINCIPAL
            panneau_principal.setLayout(new GridBagLayout());
            // contraintes relatives au layout GridBag
            GridBagConstraints gbc = new GridBagConstraints();

            // • PLACEMENT DES ELEMENTS

            // position de l'element avec GridBag
            gbc.gridx = 0;
            gbc.gridy = 0;
            // ajout au panneau
            panneau_principal.add(getPanneau_haut(), gbc);

            // position de l'element avec GridBag
            gbc.gridx = 0;
            gbc.gridy = 1;
            // ajout au panneau
            panneau_principal.add(getPanneau_bas(), gbc);
        }
        return panneau_principal;
    }

    /** Gettostructeur du Singleton panneau_haut
     *
     * @return JPanel
     */
    public JPanel getPanneau_haut() {
        if (panneau_haut == null) {
            // • INITIALISATION DU PANNEAU
            panneau_haut = new JPanel();
            panneau_haut.setBackground(Color.decode(COULEUR_FOND));
            panneau_haut.setForeground(Color.decode(COULEUR_TEXTE));

            // • MISE EN PLACE DU LAYOUT DU PANNEAUL
            panneau_haut.setLayout(new GridBagLayout());
            // contraintes relatives au layout GridBag
            GridBagConstraints gbc = new GridBagConstraints();

            // • PLACEMENT DES ELEMENTS

            // ligne 0

            // position de l'element avec GridBag
            gbc.gridx = 0;
            gbc.gridy = 0;
            // ajout au panneau
            panneau_haut.add(getLabel_reference(),gbc);

            // position de l'element avec GridBag
            gbc.gridx = 1;
            gbc.gridy = 0;
            // ajout au panneau
            panneau_haut.add(getInput_reference(), gbc);

            // ligne 1

            // position de l'element avec GridBag
            gbc.gridx = 0;
            gbc.gridy = 1;
            // ajout au panneau
            panneau_haut.add(getLabel_designation(), gbc);

            // position de l'element avec GridBag
            gbc.gridx = 1;
            gbc.gridy = 1;
            // ajout au panneau
            panneau_haut.add(getInput_designation(), gbc);

            // ligne 2

            // position de l'element avec GridBag
            gbc.gridx = 0;
            gbc.gridy = 2;
            // ajout au panneau
            panneau_haut.add(getLabel_marque(), gbc);

            // position de l'element avec GridBag
            gbc.gridx = 1;
            gbc.gridy = 2;
            // ajout au panneau
            panneau_haut.add(getInput_marque(), gbc);

            // ligne 3

            // position de l'element avec GridBag
            gbc.gridx = 0;
            gbc.gridy = 3;
            // ajout au panneau
            panneau_haut.add(getLabel_stock(), gbc);

            // position de l'element avec GridBag
            gbc.gridx = 1;
            gbc.gridy = 3;
            // ajout au panneau
            panneau_haut.add(getInput_stock(), gbc);

            // ligne 4

            // position de l'element avec GridBag
            gbc.gridx = 0;
            gbc.gridy = 4;
            // ajout au panneau
            panneau_haut.add(getLabel_prix(), gbc);

            // position de l'element avec GridBag
            gbc.gridx = 1;
            gbc.gridy = 4;
            // ajout au panneau
            panneau_haut.add(getInput_prix(), gbc);

            // ligne 5

            // position de l'element avec GridBag
            gbc.gridx = 0;
            gbc.gridy = 5;
            // ajout au panneau
            panneau_haut.add(getLabel_type(), gbc);

            // position de l'element avec GridBag
            gbc.gridx = 1;
            gbc.gridy = 5;
            // ajout au panneau
            panneau_haut.add(getInput_type(), gbc);

            // ligne 6

            // position de l'element avec GridBag
            gbc.gridx = 0;
            gbc.gridy = 6;
            // ajout au panneau
            panneau_haut.add(getLabel_grammage(), gbc);

            // position de l'element avec GridBag
            gbc.gridx = 1;
            gbc.gridy = 6;
            // ajout au panneau
            panneau_haut.add(getInput_grammage(), gbc);

            // ligne 7

            // position de l'element avec GridBag
            gbc.gridx = 0;
            gbc.gridy = 7;
            // ajout au panneau
            panneau_haut.add(getLabel_couleur(), gbc);

            // position de l'element avec GridBag
            gbc.gridx = 1;
            gbc.gridy = 7;
            // ajout au panneau
            panneau_haut.add(getInput_couleur(), gbc);

        }
        return panneau_haut;
    }

    // Ligne 0

    /** Gettostructeur du Singleton label_reference
     *
     * @return JLabel
     */
    public JLabel getLabel_reference() {
        if (label_reference == null) {
            label_reference = new JLabel("Référence",SwingConstants.RIGHT);
            label_reference.setOpaque(true);
            label_reference.setBackground(Color.decode(COULEUR_FOND));
            label_reference.setForeground(Color.decode(COULEUR_TEXTE));
            label_reference.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        }
        return label_reference;
    }

    /** Gettostructeur du Singleton input_reference
     *
     * @return JTextField
     */
    public JTextField getInput_reference() {
        if (input_reference == null) {
            input_reference = new JTextField(COLONNES_INPUT);
            input_reference.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
            input_reference.setBackground(Color.decode(COULEUR_FOND_INPUT));
            input_reference.setForeground(Color.decode(COULEUR_TEXTE));

        }
        return input_reference;
    }

    // Ligne 1

    /** Gettostructeur du Singleton label_designation
     *
     * @return JLabel
     */
    public JLabel getLabel_designation() {
        if (label_designation == null) {
            label_designation = new JLabel("Désignation",SwingConstants.RIGHT);
            label_designation.setOpaque(true);
            label_designation.setBackground(Color.decode(COULEUR_FOND));
            label_designation.setForeground(Color.decode(COULEUR_TEXTE));
            label_designation.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        }
        return label_designation;
    }

    /** Gettostructeur du Singleton input_designation
     *
     * @return JTextField
     */
    public JTextField getInput_designation() {
        if (input_designation == null) {
            input_designation = new JTextField(COLONNES_INPUT);
            input_designation.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
            input_designation.setBackground(Color.decode(COULEUR_FOND_INPUT));
            input_designation.setForeground(Color.decode(COULEUR_TEXTE));
        }
        return input_designation;
    }

    // Ligne 2

    /** Gettostructeur du Singleton label_marque
     *
     * @return JLabel
     */
    public JLabel getLabel_marque() {
        if (label_marque == null) {
            label_marque = new JLabel("Marque",SwingConstants.RIGHT);
            label_marque.setOpaque(true);
            label_marque.setBackground(Color.decode(COULEUR_FOND));
            label_marque.setForeground(Color.decode(COULEUR_TEXTE));
            label_marque.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        }
        return label_marque;
    }

    /** Gettostructeur du Singleton input_marque
     *
     * @return JTextField
     */
    public JTextField getInput_marque() {
        if (input_marque == null) {
            input_marque = new JTextField(COLONNES_INPUT);
            input_marque.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
            input_marque.setBackground(Color.decode(COULEUR_FOND_INPUT));
            input_marque.setForeground(Color.decode(COULEUR_TEXTE));
        }
        return input_marque;
    }

    // Ligne 3

    /** Gettostructeur du Singleton label_stock
     *
     * @return JLabel
     */
    public JLabel getLabel_stock() {
        if (label_stock == null) {
            label_stock = new JLabel("Stock",SwingConstants.RIGHT);
            label_stock.setOpaque(true);
            label_stock.setBackground(Color.decode(COULEUR_FOND));
            label_stock.setForeground(Color.decode(COULEUR_TEXTE));
            label_stock.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        }
        return label_stock;
    }

    /** Gettostructeur du Singleton input_stock
     *
     * @return JTextField
     */
    public JTextField getInput_stock() {
        if (input_stock == null) {
            input_stock = new JTextField(COLONNES_INPUT);
            input_stock.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
            input_stock.setBackground(Color.decode(COULEUR_FOND_INPUT));
            input_stock.setForeground(Color.decode(COULEUR_TEXTE));
        }
        return input_stock;
    }

    // Ligne 4

    /** Gettostructeur du Singleton label_prix
     *
     * @return JLabel
     */
    public JLabel getLabel_prix() {
        if (label_prix == null) {
            label_prix = new JLabel("Prix",SwingConstants.RIGHT);
            label_prix.setOpaque(true);
            label_prix.setBackground(Color.decode(COULEUR_FOND));
            label_prix.setForeground(Color.decode(COULEUR_TEXTE));
            label_prix.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        }
        return label_prix;
    }

    /** Gettostructeur du Singleton input_prix
     *
     * @return JTextField
     */
    public JTextField getInput_prix() {
        if (input_prix == null) {
            input_prix = new JTextField(COLONNES_INPUT);
            input_prix.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
            input_prix.setBackground(Color.decode(COULEUR_FOND_INPUT));
            input_prix.setForeground(Color.decode(COULEUR_TEXTE));
        }
        return input_prix;
    }

    // Ligne 5

    /** Gettostructeur du Singleton label_type
     *
     * @return JLabel
     */
    public JLabel getLabel_type() {
        if (label_type == null) {
            label_type = new JLabel("Type",SwingConstants.RIGHT);
            label_type.setOpaque(true);
            label_type.setBackground(Color.decode(COULEUR_FOND));
            label_type.setForeground(Color.decode(COULEUR_TEXTE));
            label_type.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        }
        return label_type;
    }

    /** Gettostructeur du Singleton button_group_type
     *
     * @return ButtonGroup
     */
    public ButtonGroup getButton_group_type() {
        if (button_group_type == null) {
            button_group_type = new ButtonGroup();
            button_group_type.add(getRadio_button_ramette());
            button_group_type.add(getRadio_button_stylo());
        }
        return button_group_type;
    }

    /** Gettostructeur du Singleton radio_button_ramette
     *
     * @return JRadioButton
     */
    public JRadioButton getRadio_button_ramette() {
        if (radio_button_ramette == null) {
            radio_button_ramette = new JRadioButton("Ramette");
            radio_button_ramette.setBackground(Color.decode(COULEUR_FOND));
            radio_button_ramette.setForeground(Color.decode(COULEUR_TEXTE));
        }
        return radio_button_ramette;
    }

    /** Gettostructeur du Singleton radio_button_stylo
     *
     * @return JRadioButton
     */
    public JRadioButton getRadio_button_stylo() {
        if (radio_button_stylo == null) {
            radio_button_stylo = new JRadioButton("Stylo");
            radio_button_stylo.setBackground(Color.decode(COULEUR_FOND));
            radio_button_stylo.setForeground(Color.decode(COULEUR_TEXTE));
        }
        return radio_button_stylo;
    }

    /** Gettostructeur du Singleton input_type
     *
     * @return JPanel
     */
    public JPanel getInput_type() {
        if (input_type == null) {

            input_type = new JPanel();
            input_type.setBackground(Color.decode(COULEUR_FOND));
            input_type.setForeground(Color.decode(COULEUR_TEXTE));


            // • MISE EN PLACE DU LAYOUT DU PANNEAUL
            input_type.setLayout(new BorderLayout());

            // ajout au panneau
            input_type.add(getRadio_button_ramette(), BorderLayout.NORTH);

            // ajout au panneau
            input_type.add(getRadio_button_stylo(), BorderLayout.SOUTH);
        }
        return input_type;
    }

    // Ligne 6

    /** Gettostructeur du Singleton label_grammage
     *
     * @return JLabel
     */
    public JLabel getLabel_grammage() {
        if (label_grammage == null) {
            label_grammage = new JLabel("Grammage",SwingConstants.RIGHT);
            label_grammage.setOpaque(true);
            label_grammage.setBackground(Color.decode(COULEUR_FOND));
            label_grammage.setForeground(Color.decode(COULEUR_TEXTE));
            label_grammage.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        }
        return label_grammage;
    }

    /** Gettostructeur du Singleton button_group_grammage
     *
     * @return ButtonGroup
     */
    public ButtonGroup getButton_group_grammage() {
        if (button_group_grammage == null) {
            button_group_grammage = new ButtonGroup();
            button_group_grammage.add(getRadio_button_ramette());
            button_group_grammage.add(getRadio_button_stylo());
        }
        return button_group_grammage;
    }

    /** Gettostructeur du Singleton check_box_80_grammes
     *
     * @return JCheckBox
     */
    public JCheckBox getCheck_box_80_grammes() {
        if (check_box_80_grammes == null) {
            check_box_80_grammes = new JCheckBox("80 grammes");
            check_box_80_grammes.setBackground(Color.decode(COULEUR_FOND));
            check_box_80_grammes.setForeground(Color.decode(COULEUR_TEXTE));
        }
        return check_box_80_grammes;
    }

    /** Gettostructeur du Singleton check_box_100_grammes
     *
     * @return JCheckBox
     */
    public JCheckBox getCheck_box_100_grammes() {
        if (check_box_100_grammes == null) {
            check_box_100_grammes = new JCheckBox("100 grammes");
            check_box_100_grammes.setBackground(Color.decode(COULEUR_FOND));
            check_box_100_grammes.setForeground(Color.decode(COULEUR_TEXTE));
        }
        return check_box_100_grammes;
    }

    /** Gettostructeur du Singleton input_grammage
     *
     * @return JPanel
     */
    public JPanel getInput_grammage() {
        if (input_grammage == null) {

            input_grammage = new JPanel();
            input_grammage.setBackground(Color.decode(COULEUR_FOND));
            input_grammage.setForeground(Color.decode(COULEUR_TEXTE));

            // • MISE EN PLACE DU LAYOUT DU PANNEAUL
            input_grammage.setLayout(new BorderLayout());

            input_grammage.add(getCheck_box_80_grammes(), BorderLayout.NORTH);

            input_grammage.add(getCheck_box_100_grammes(), BorderLayout.SOUTH);
        }
        return input_grammage;
    }

    // Ligne 7

    /** Gettostructeur du Singleton label_couleur
     *
     * @return JLabel
     */
    public JLabel getLabel_couleur() {
        if (label_couleur == null) {
            label_couleur = new JLabel("Couleur",SwingConstants.RIGHT);
            label_couleur.setOpaque(true);
            label_couleur.setBackground(Color.decode(COULEUR_FOND));
            label_couleur.setForeground(Color.decode(COULEUR_TEXTE));
            label_couleur.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        }
        return label_couleur;
    }

    /** Gettostructeur du Singleton input_couleur
     *
     * @return JComboBox
     */
    public JComboBox getInput_couleur() {
        if (input_couleur == null) {
            input_couleur = new JComboBox();
            input_couleur.addItem(CouleursStylo.NOIR);
            input_couleur.addItem(CouleursStylo.BLEU);
            input_couleur.addItem(CouleursStylo.ROUGE);
            input_couleur.addItem(CouleursStylo.VERT);
            input_couleur.setBackground(Color.decode(COULEUR_FOND_INPUT));
            input_couleur.setForeground(Color.decode(COULEUR_TEXTE));
        }
        return input_couleur;
    }








    /** Gettostructeur du Singleton panneau_bas
     *
     * @return JPanel
     */
    public JPanel getPanneau_bas() {
        if (panneau_bas == null) {
            // • INITIALISATION DU PANNEAU
            panneau_bas = new JPanel();

            // • MISE EN PLACE DU LAYOUT DU PANNEAUL
            panneau_bas.setLayout(new GridBagLayout());
            // contraintes relatives au layout GridBag
            GridBagConstraints gbc = new GridBagConstraints();

            // • PLACEMENT DES ELEMENTS

            // ligne 0

            // position de l'element avec GridBag
            gbc.gridx = 0;
            gbc.gridy = 0;
            // ajout au panneau
            panneau_bas.add(getBouton_precedent(), gbc);

            // position de l'element avec GridBag
            gbc.gridx = 1;
            gbc.gridy = 0;
            // ajout au panneau
            panneau_bas.add(getBouton_nouveau(), gbc);

            // position de l'element avec GridBag
            gbc.gridx = 2;
            gbc.gridy = 0;
            // ajout au panneau
            panneau_bas.add(getBouton_enregistrer(), gbc);

            // position de l'element avec GridBag
            gbc.gridx = 3;
            gbc.gridy = 0;
            // ajout au panneau
            panneau_bas.add(getBouton_supprimer(), gbc);

            // position de l'element avec GridBag
            gbc.gridx = 4;
            gbc.gridy = 0;
            // ajout au panneau
            panneau_bas.add(getBouton_suivant(), gbc);
        }
        return panneau_bas;
    }

    /** Gettostructeur du Singleton bouton_precedent
     *
     * @return JButton
     */
    public JButton getBouton_precedent() {
        if (bouton_precedent == null) {
            Icon precedent = new ImageIcon(this.getClass().getResource("resources/precedent.png"));
            bouton_precedent = new JButton(precedent);
            bouton_precedent.setBackground(Color.decode(COULEUR_FOND));
            bouton_precedent.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

            bouton_precedent.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    bouton_precedent.setBackground(Color.decode(COULEUR_FOND_INPUT));
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    bouton_precedent.setBackground(Color.decode(COULEUR_FOND));
                }
            });
        }
        return bouton_precedent;
    }

    /** Gettostructeur du Singleton bouton_nouveau
     *
     * @return JButton
     */
    public JButton getBouton_nouveau() {
        if (bouton_nouveau == null) {
            Icon nouveau = new ImageIcon(this.getClass().getResource("resources/nouveau.png"));
            bouton_nouveau = new JButton(nouveau);
            bouton_nouveau.setBackground(Color.decode(COULEUR_FOND));
            bouton_nouveau.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

            bouton_nouveau.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    bouton_nouveau.setBackground(Color.decode(COULEUR_FOND_INPUT));
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    bouton_nouveau.setBackground(Color.decode(COULEUR_FOND));
                }
            });
        }
        return bouton_nouveau;
    }

    /** Gettostructeur du Singleton bouton_enregistrer
     *
     * @return JButton
     */
    public JButton getBouton_enregistrer() {
        if (bouton_enregistrer == null) {
            Icon enregistrer = new ImageIcon(this.getClass().getResource("resources/enregistrer.png"));
            bouton_enregistrer = new JButton(enregistrer);
            bouton_enregistrer.setBackground(Color.decode(COULEUR_FOND));
            bouton_enregistrer.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

            bouton_enregistrer.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    bouton_enregistrer.setBackground(Color.decode(COULEUR_FOND_INPUT));
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    bouton_enregistrer.setBackground(Color.decode(COULEUR_FOND));
                }
            });
        }
        return bouton_enregistrer;
    }

    /** Gettostructeur du Singleton bouton_supprimer
     *
     * @return JButton
     */
    public JButton getBouton_supprimer() {
        if (bouton_supprimer == null) {
            Icon supprimer = new ImageIcon(this.getClass().getResource("resources/supprimer.png"));
            bouton_supprimer = new JButton(supprimer);
            bouton_supprimer.setBackground(Color.decode(COULEUR_FOND));
            bouton_supprimer.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

            bouton_supprimer.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    bouton_supprimer.setBackground(Color.decode(COULEUR_FOND_INPUT));
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    bouton_supprimer.setBackground(Color.decode(COULEUR_FOND));
                }
            });
        }
        return bouton_supprimer;
    }

    /** Gettostructeur du Singleton bouton_suivant
     *
     * @return JButton
     */
    public JButton getBouton_suivant() {
        if (bouton_suivant == null) {
            Icon suivant = new ImageIcon(this.getClass().getResource("resources/suivant.png"));
            bouton_suivant = new JButton(suivant);
            bouton_suivant.setBackground(Color.decode(COULEUR_FOND));
            bouton_suivant.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

            bouton_suivant.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    bouton_suivant.setBackground(Color.decode(COULEUR_FOND_INPUT));
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    bouton_suivant.setBackground(Color.decode(COULEUR_FOND));
                }
            });

        }
        return bouton_suivant;
    }


}
