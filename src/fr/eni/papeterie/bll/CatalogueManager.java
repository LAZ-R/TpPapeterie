package fr.eni.papeterie.bll;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;
import fr.eni.papeterie.dal.ArticleDAO;
import fr.eni.papeterie.dal.DALException;
import fr.eni.papeterie.dal.DAOFactory;

import java.util.List;

public class CatalogueManager {
    private ArticleDAO daoArticle = DAOFactory.instanceArticlesDAO();
    private static CatalogueManager instance;

    private CatalogueManager(){
    }

    public static CatalogueManager getInstance(){
        if (instance == null) {
            instance = new CatalogueManager();
        }
        return instance;
    }

    public List<Article> getCatalogue() throws BLLException {
        List<Article> liste_articles = null;
        try {
            liste_articles = daoArticle.selectAll();
        } catch (DALException e) {
            throw new BLLException("Erreur dans la BLL [getCatalogue()]");
        }
        return liste_articles;
    }

    public void addArticle(Article article_a_ajouter) throws BLLException {
        try {
            daoArticle.insert(article_a_ajouter);
        } catch (DALException e) {
            throw new BLLException("Erreur dans la BLL [addArticle()]");
        }
    }

    public void updateArticle(Article article_a_modifier) throws BLLException {
        try {
            daoArticle.update(article_a_modifier);
        } catch (DALException e) {
            throw new BLLException("Erreur dans la BLL [updateArticle()]");
        }
    }

    public void removeArticle(int id_article_a_enlever) throws BLLException {
        try {
            daoArticle.delete(id_article_a_enlever);
        } catch (DALException e) {
            throw new BLLException("Erreur dans la BLL [removeArticle()]");
        }
    }

    public boolean validerArticle(Article article_a_valider) throws BLLException {
        boolean isArticleOk = true;
        if (article_a_valider.getReference() == null) {
            isArticleOk = false;
        }
        if (article_a_valider.getMarque() == null) {
            isArticleOk = false;
        }
        if (article_a_valider.getDesignation() == null) {
            isArticleOk = false;
        }
        if (article_a_valider.getPrix_unitaire() <= 0.0) {
            isArticleOk = false;
        }
        if (article_a_valider.getQuantite_stock() <= 0) {
            isArticleOk = false;
        }
        if (article_a_valider instanceof Ramette) {
            if (
                ((Ramette) article_a_valider).getGrammage() != 80
                &&
                ((Ramette) article_a_valider).getGrammage() != 100) {
                isArticleOk = false;
            }
        }
        if (article_a_valider instanceof Stylo) {
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
                isArticleOk = false;
            }
        }
        if (!isArticleOk) {
            throw new BLLException("Erreur dans la BLL [validerArticle()]");
        }

        return isArticleOk;
    }

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
