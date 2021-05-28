package fr.eni.papeterie.dal.jdbc;

import fr.eni.papeterie.bo.Article;

import java.util.List;

public interface ArticleDAO {

    public Article selectById(Integer id_article);
    public List<Article> selectAll();
    public void insert(Article article_a_insert);
    public void update(Article article_a_update);
    public void delete(Integer id_article_a_delete);
}
