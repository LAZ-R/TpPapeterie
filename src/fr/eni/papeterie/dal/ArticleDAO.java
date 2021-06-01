package fr.eni.papeterie.dal;

import fr.eni.papeterie.bo.Article;

import java.util.List;

public interface ArticleDAO {

    public Article selectById(Integer id_article) throws DALException;
    public List<Article> selectAll() throws DALException;
    public void insert(Article article_a_insert) throws DALException;
    public void update(Article article_a_update) throws DALException;
    public void delete(Integer id_article_a_delete) throws DALException;
}
