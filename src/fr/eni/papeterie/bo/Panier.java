package fr.eni.papeterie.bo;

import java.util.ArrayList;
import java.util.List;

/** Classe qui représente le Panier d'un client, qui contient une liste de lignes d'article.
 *
 * @author laz_R
 * @version 1.0
 */
public class Panier {

    // • Déclaration

    // Attributs d'instance
    private float montant;
    private List<Ligne> lignes_panier = new ArrayList<>();

    // • Méthodes

    // Constructeurs

    /** Constructeur sans paramètres.
     */
    public Panier() {
    }

    // Getters & Setters

    public float getMontant() {
        return montant;
    }

    /** Méthode pour GET une ligne en particulier dans la liste de lignes du Panier.
     *
     * @param index - int
     * @return - Ligne
     */
    public Ligne getLigne(int index) {
        return lignes_panier.get(index);
    }

    public List<Ligne> getLignes_panier() {
        return lignes_panier;
    }

    // toString

    @Override
    public String toString() {
        return "Panier{" +
                "montant=" + montant +
                ", lignes_panier=" + lignes_panier +
                '}';
    }

    // Mes méthodes

    /** Méthode d'ajout d'une Ligne dans la liste de lignes du Panier.
     *
     * @param article - Article
     * @param quantite - int
     */
    public void addLigne(Article article, int quantite) {
        lignes_panier.add(new Ligne(article, quantite));
    }

    /** Méthode pour modifier la quantité d'articles DÉJÀ présents dans une ligne de la liste de lignes du Panier.
     *
     * @param index - int
     * @param nouvelle_quantite - int
     */
    public void updateLigne(int index, int nouvelle_quantite) {
        lignes_panier.get(index).setQuantite(nouvelle_quantite);
    }

    /** Méthode pour supprimer une ligne de la liste de lignes du Panier.
     *
     * @param index - int
     */
    public void removeLigne(int index) {
        lignes_panier.remove(index);
    }

}
