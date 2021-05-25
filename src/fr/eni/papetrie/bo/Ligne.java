package fr.eni.papetrie.bo;

/** Classe qui représente une Ligne d'article.
 *
 * @author laz_R
 * @version 1.0
 */
public class Ligne {

    // • Déclaration

    // Attributs d'instance

    private Article article;
    protected int quantite;
    protected float prix;

    // • Méthodes

    // Constructeurs

    /** Constructeur avec tous les paramètres.
     *  Le prix de la ligne se calcule automatiquement en fonction du prix unitaire et de la quantité.
     *
     * @param article - Article
     * @param quantite - int
     */
    public Ligne(Article article, int quantite) {
        this.article = article;
        this.quantite = quantite;
        this.prix = this.article.getPrix_unitaire() * this.quantite;
    }

    // Getters & Setters

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public float getPrix() {
        return prix;
    }

    // toString

    @Override
    public String toString() {
        return "Ligne{" +
                "article=" + article +
                ", quantite=" + quantite +
                '}';
    }

    // Mes méthodes
}
