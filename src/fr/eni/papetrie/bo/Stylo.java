package fr.eni.papetrie.bo;

/** Classe qui représente un Stylo (qui est un Article).
 *
 * @author laz_R
 * @version 1.0
 */
public class Stylo extends Article{

    // • Déclaration

    // Attributs d'instance

    private String couleur;



    // • Méthodes

    // Constructeur(s)

    /** Constructeur sans paramètres.
     */
    public Stylo() {
    }

    /** Constructeur avec tous les paramètres, sauf l'id de l'article.
     *
     * @param reference - String
     * @param marque - String
     * @param designation - String
     * @param prix_unitaire - float
     * @param quantite_stock - int
     * @param couleur - String
     */
    public Stylo(String reference, String marque, String designation, float prix_unitaire, int quantite_stock, String couleur) {
        super(reference, marque, designation, prix_unitaire, quantite_stock);
        this.couleur = couleur;
    }

    /** Constructeur avec tous les paramètres.
     *
     * @param id_article - Integer
     * @param reference - String
     * @param marque - String
     * @param designation - String
     * @param prix_unitaire - float
     * @param quantite_stock - int
     * @param couleur - String
     */
    public Stylo(Integer id_article, String reference, String marque, String designation, float prix_unitaire, int quantite_stock, String couleur) {
        super(id_article, reference, marque, designation, prix_unitaire, quantite_stock);
        this.couleur = couleur;
    }

    // Getters & Setters

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    // toString

    @Override
    public String toString() {
        return "Stylo{" +
                "couleur='" + couleur + '\'' +
                '}';
    }

    // Mes méthodes
}
