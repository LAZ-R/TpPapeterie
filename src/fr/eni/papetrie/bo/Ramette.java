package fr.eni.papetrie.bo;

/** Classe qui représente une Ramette de papier (qui est un Article).
 *
 * @author laz_R
 * @version 1.0
 */
public class Ramette extends Article{

    // • Déclaration

    // Attributs d'instance

    private int grammage;



    // • Méthodes

    // Constructeur(s)

    /** Constructeur sans paramètres.
     */
    public Ramette() {
    }

    /** Constructeur avec tous les paramètres, sauf l'id de l'article.
     *
     * @param reference - String
     * @param marque - String
     * @param designation - String
     * @param prix_unitaire - float
     * @param quantite_stock - int
     * @param grammage - int
     */
    public Ramette(String reference, String marque, String designation, float prix_unitaire, int quantite_stock, int grammage) {
        super(reference, marque, designation, prix_unitaire, quantite_stock);
        this.grammage = grammage;
    }

    /** Constructeur avec tous les paramètres.
     *
     * @param id_article - Integer
     * @param reference - String
     * @param marque - String
     * @param designation - String
     * @param prix_unitaire - float
     * @param quantite_stock - int
     * @param grammage - int
     */
    public Ramette(Integer id_article, String reference, String marque, String designation, float prix_unitaire, int quantite_stock, int grammage) {
        super(id_article, reference, marque, designation, prix_unitaire, quantite_stock);
        this.grammage = grammage;
    }

    // Getters & Setters

    public int getGrammage() {
        return grammage;
    }

    public void setGrammage(int grammage) {
        this.grammage = grammage;
    }

    // toString

    @Override
    public String toString() {
        return "Ramette{" +
                "grammage=" + grammage +
                '}';
    }

    // Mes méthodes
}
