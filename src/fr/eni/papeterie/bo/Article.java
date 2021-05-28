package fr.eni.papeterie.bo;

/** Classe qui représente un Article.
 *
 * @author laz_R
 * @version 1.0
 */
public abstract class Article {

    // • Déclaration

    // Attributs d'instance

    private Integer idArticle;
    private String reference;
    private String marque;
    private String designation;
    private float prix_unitaire;
    private int quantite_stock;

    // • Méthodes

    // Constructeur(s)

    /** Constructeur sans paramètres.
     */
    public Article() {
    }

    /** Constructeur avec tous les paramètres, sauf l'id de l'article.
     *
     * @param reference - String
     * @param marque - String
     * @param designation - String
     * @param prix_unitaire - float
     * @param quantite_stock - int
     */
    public Article(String reference, String marque, String designation, float prix_unitaire, int quantite_stock) {
        this.reference = reference;
        this.marque = marque;
        this.designation = designation;
        this.prix_unitaire = prix_unitaire;
        this.quantite_stock = quantite_stock;
    }

    /** Constructeur avec tous les paramètres.
     *
     * @param idArticle - Integer
     * @param reference - String
     * @param marque - String
     * @param designation - String
     * @param prix_unitaire - float
     * @param quantite_stock - int
     */
    public Article(Integer idArticle, String reference, String marque, String designation, float prix_unitaire, int quantite_stock) {
        this.idArticle = idArticle;
        this.reference = reference;
        this.marque = marque;
        this.designation = designation;
        this.prix_unitaire = prix_unitaire;
        this.quantite_stock = quantite_stock;
    }

    // Getters & Setters

    public Integer getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Integer idArticle) {
        this.idArticle = idArticle;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public float getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(float prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    public int getQuantite_stock() {
        return quantite_stock;
    }

    public void setQuantite_stock(int quantite_stock) {
        this.quantite_stock = quantite_stock;
    }

    // toString

    @Override
    public String toString() {
        return "Article{" +
                "id_article=" + idArticle +
                ", reference='" + reference + '\'' +
                ", marque='" + marque + '\'' +
                ", designation='" + designation + '\'' +
                ", prix_unitaire=" + prix_unitaire +
                ", quantite_stock=" + quantite_stock +
                '}';
    }

    // Mes méthodes


}
