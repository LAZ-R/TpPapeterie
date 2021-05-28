package fr.eni.papeterie.dal;

import fr.eni.papeterie.dal.jdbc.ArticleDAOJdbcImpl;
import fr.eni.papeterie.dal.jdbc.ArticleDAO;

public class DAOFactory {

    public static ArticleDAO instanceArticlesDAO(){
        ArticleDAO instance_a_renvoyer = new ArticleDAOJdbcImpl();
        return instance_a_renvoyer;
    }

}
