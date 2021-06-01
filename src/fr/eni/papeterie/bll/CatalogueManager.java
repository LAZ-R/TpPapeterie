package fr.eni.papeterie.bll;

import fr.eni.papeterie.bo.Article;
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

    /*private void validerArticle(Article article_a_valider) throws BLLException {
        try {
            daoArticle.delete(id_article_a_enlever);
        } catch (DALException e) {
            throw new BLLException("Erreur dans la BLL [validerArticle()]");
        }
    }*/

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
