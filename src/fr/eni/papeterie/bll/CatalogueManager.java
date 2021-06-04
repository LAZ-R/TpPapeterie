package fr.eni.papeterie.bll;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;
import fr.eni.papeterie.dal.ArticleDAO;
import fr.eni.papeterie.dal.DALException;
import fr.eni.papeterie.dal.DAOFactory;

import java.util.List;

/** Classe qui représente l'entitée avec laquelle doit
 *  interagir l'IHM quand elle veut effectuer une action sur la DAL
 *
 * @author laz_R
 * @version 1.0
 */

public class CatalogueManager {

    // • Déclaration

    // Instances
    private ArticleDAO daoArticle = DAOFactory.instanceArticlesDAO();
    // Variables
    private static CatalogueManager instance;

    // • Méthodes

    // Constructeur(s)

    /** Constructeur privé, sans paramètres
     */
    private CatalogueManager(){
    }

    /** Gettostructeur pour singleton
     * @return CatalogueManager
     */
    public static CatalogueManager getInstance(){
        if (instance == null) {
            instance = new CatalogueManager();
        }
        return instance;
    }

    // Mes Méthodes

    /** Méthode qui retourne la totalité des articles présents en BDD sous forme de liste d'Articles
     *
     * @return - List<Article>
     * @throws BLLException
     */
    public List<Article> getCatalogue() throws BLLException {
        List<Article> liste_articles = null;
        try {
            liste_articles = daoArticle.selectAll();
        } catch (DALException e) {
            throw new BLLException("Erreur dans la BLL [getCatalogue()]");
        }
        return liste_articles;
    }

    /** Méthode qui ajoute l'article en paramètre à la BDD
     *
     * @param article_a_ajouter - Article
     * @throws BLLException
     */
    public void addArticle(Article article_a_ajouter) throws BLLException {
        try {
            daoArticle.insert(article_a_ajouter);
        } catch (DALException e) {
            throw new BLLException("Erreur dans la BLL [addArticle()]");
        }
    }

    /** Méthode qui met à jour l'article en paramètre dans la BDD
     *
     * @param article_a_modifier - Article
     * @throws BLLException
     */
    public void updateArticle(Article article_a_modifier) throws BLLException {
        try {
            daoArticle.update(article_a_modifier);
        } catch (DALException e) {
            throw new BLLException("Erreur dans la BLL [updateArticle()]");
        }
    }

    /** Méthode qui supprime l'article dont l'ID est en paramètre de la BDD
     *
     * @param id_article_a_enlever - int
     * @throws BLLException
     */
    public void removeArticle(int id_article_a_enlever) throws BLLException {
        try {
            daoArticle.delete(id_article_a_enlever);
        } catch (DALException e) {
            throw new BLLException("Erreur dans la BLL [removeArticle()]");
        }
    }

    /** Méthode à appeler pour vérifier que l'article en paramètre peut effectivement interagir avec la BDD
     *
     * @param article_a_valider - Article
     * @return - boolean
     * @throws BLLException
     */
    public boolean validerArticle(Article article_a_valider) throws BLLException {

        // Vérification de la présence d'une Référence pour l'Article
        if (article_a_valider.getReference() == null || article_a_valider.getReference().trim().equalsIgnoreCase("")) {
            throw new BLLException("Référence invalide");
        }
        // Vérification de la présence d'une Désignation pour l'Article
        if (article_a_valider.getDesignation() == null || article_a_valider.getDesignation().trim().equalsIgnoreCase("")) {
            throw new BLLException("Désignation invalide");
        }
        // Vérification de la présence d'une Marque pour l'Article
        if (article_a_valider.getMarque() == null || article_a_valider.getMarque().trim().equalsIgnoreCase("")) {
            throw new BLLException("Marque invalide");
        }
        // Vérification de la présence d'une Quantité présente en Stock pour l'Article
        if (article_a_valider.getQuantite_stock() <= 0) {
            throw new BLLException("Stock invalide");
        }
        // Vérification de la présence d'un Prix Unitaire pour l'Article
        if (article_a_valider.getPrix_unitaire() <= 0.0) {
            throw new BLLException("Prix Unitaire invalide");
        }

        // Si l'Article en paramètre est une Ramette
        if (article_a_valider instanceof Ramette) {
            // Vérification de la validité du grammage renseigné
            if (
                ((Ramette) article_a_valider).getGrammage() != 80
                &&
                ((Ramette) article_a_valider).getGrammage() != 100) {
                throw new BLLException("Grammage invalide");
            }
        }
        // Si l'Article en paramètre est un Stylo
        if (article_a_valider instanceof Stylo) {
            // Vérification de la validité de la couleur renseignée
            String couleur = ((Stylo) article_a_valider).getCouleur().trim();

            if (
                !(couleur.equalsIgnoreCase("noir"))
                &&
                !(couleur.equalsIgnoreCase("bleu"))
                &&
                !(couleur.equalsIgnoreCase("rouge"))
                &&
                !(couleur.equalsIgnoreCase("vert"))
                &&
                !(couleur.equalsIgnoreCase("jaune"))
            ) {
                throw new BLLException("Couleur invalide");
            }
        }

        return true;
    }

    /** Méthode qui retourne l'Article présent dans la BDD dont l'index est renseigné en paramètre
     *
     * @param id_article_a_recuperer - int
     * @return - Article
     * @throws BLLException
     */
    public Article getArticle(int id_article_a_recuperer) throws BLLException {
        Article article_a_recuperer = null;
        try {
            article_a_recuperer = daoArticle.selectById(id_article_a_recuperer);
        } catch (DALException e) {
            throw new BLLException("Erreur dans la BLL [getArticle()]");
        }
        return article_a_recuperer;
    }

}
