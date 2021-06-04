package fr.eni.papeterie.dal;

import fr.eni.papeterie.dal.jdbc.sqlite.ArticleDAOJdbcSQLiteImpl;
import fr.eni.papeterie.dal.jdbc.sqlserver.ArticleDAOJdbcSqlServerImpl;

public class DAOFactory {

    public static ArticleDAO instanceArticlesDAO(){
        ArticleDAO instance_a_renvoyer = new ArticleDAOJdbcSQLiteImpl();
        return instance_a_renvoyer;
    }

}
