package fr.eni.papeterie.dal.jdbc;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;
import fr.eni.papeterie.dal.ArticleDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleDAOJdbcImpl implements ArticleDAO {

    // • Déclaration

    // Attributs d'instance


    // Requetes SQL
    private final String SQL_DELETE = "DELETE FROM Articles WHERE idArticle=?;";
    private final String SQL_UPDATE = "UPDATE Articles SET reference=?, marque=?, designation=?, prixUnitaire=?, qteStock=?, grammage=?, couleur=?, type=? WHERE idArticle=?;";
    private final String SQL_INSERT = "INSERT INTO Articles (reference, marque, designation, prixUnitaire, qteStock, grammage, couleur, type) VALUES (?,?,?,?,?,?,?,?);";
    private final String SQL_SELECT_BY_ID = "SELECT * FROM Articles WHERE idArticle=?";
    private final String SQL_SELECT_ALL = "SELECT * FROM Articles";

    // • Méthodes

    // Constructeurs

    // Getters & Setters

    // Mes méthodes

    @Override
    /** Méthode qui renvoie l'article dont l'id a été renseigné en paramètre.
     *
     * @param id_article - Integer
     */
    public Article selectById(Integer id_article){

        Article article_a_return = null;

        try {

            PreparedStatement etat_select = JbdcTools.instanceConnectionSqlServer().prepareStatement(this.SQL_SELECT_BY_ID);

            etat_select.setInt(1, (int)id_article);
            ResultSet result_set = etat_select.executeQuery();

            while (result_set.next()) {
                // Si la colonne "type" est égale à "stylo" :
                if (result_set.getString("type").equalsIgnoreCase("stylo")) {

                    article_a_return = new Stylo(
                            result_set.getInt("idArticle"),
                            result_set.getString("reference"),
                            result_set.getString("marque"),
                            result_set.getString("designation"),
                            result_set.getFloat("prixUnitaire"),
                            result_set.getInt("qteStock"),
                            result_set.getString("couleur"));
                }
                // Si la colonne "type" est égale à "stylo" :
                else if (result_set.getString("type").equalsIgnoreCase("ramette")) {

                    article_a_return = new Ramette(
                            result_set.getInt("idArticle"),
                            result_set.getString("reference"),
                            result_set.getString("marque"),
                            result_set.getString("designation"),
                            result_set.getFloat("prixUnitaire"),
                            result_set.getInt("qteStock"),
                            result_set.getInt("grammage"));
                }
            }

            etat_select.executeQuery();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return article_a_return;
    }

    @Override
    /** Méthode qui renvoie la liste de tous les articles.
     *
     */
    public List<Article> selectAll(){

        List<Article> liste_article_a_return = new ArrayList<>();

        try {
            Statement etat_select = JbdcTools.instanceConnectionSqlServer().createStatement();
            ResultSet result_set = etat_select.executeQuery(SQL_SELECT_ALL);

            while(result_set.next()) {
                // Si la colonne "type" est égale à "stylo" :
                if (result_set.getString("type").equalsIgnoreCase("stylo")) {

                    Article article_a_push = new Stylo(
                            result_set.getInt("idArticle"),
                            result_set.getString("reference"),
                            result_set.getString("marque"),
                            result_set.getString("designation"),
                            result_set.getFloat("prixUnitaire"),
                            result_set.getInt("qteStock"),
                            result_set.getString("couleur"));

                    liste_article_a_return.add(article_a_push);
                }
                // Si la colonne "type" est égale à "stylo" :
                else if (result_set.getString("type").equalsIgnoreCase("ramette")){

                    Article article_a_push = new Ramette(
                            result_set.getInt("idArticle"),
                            result_set.getString("reference"),
                            result_set.getString("marque"),
                            result_set.getString("designation"),
                            result_set.getFloat("prixUnitaire"),
                            result_set.getInt("qteStock"),
                            result_set.getInt("grammage"));

                    liste_article_a_return.add(article_a_push);
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return liste_article_a_return;
    }

    @Override
    /** Méthode a appeler pour ajouter un article dans la table Articles.
     *
     * @param article_a_insert - Article
     */
    public void insert(Article article_a_insert) {
        try  {

            PreparedStatement etat_insert = JbdcTools.instanceConnectionSqlServer().prepareStatement(this.SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

            etat_insert.setString(1, article_a_insert.getReference());
            etat_insert.setString(2, article_a_insert.getMarque());
            etat_insert.setString(3, article_a_insert.getDesignation());
            etat_insert.setFloat(4, article_a_insert.getPrix_unitaire());
            etat_insert.setInt(5, article_a_insert.getQuantite_stock());
            if (article_a_insert instanceof Ramette){
                etat_insert.setInt(6, ((Ramette)article_a_insert).getGrammage());
                etat_insert.setNull(7, Types.NULL);
                etat_insert.setString(8, "ramette");
            }
            if (article_a_insert instanceof Stylo) {
                etat_insert.setNull(6, Types.NULL);
                etat_insert.setString(7, ((Stylo)article_a_insert).getCouleur());
                etat_insert.setString(8, "stylo");
            }

            etat_insert.executeUpdate();

            ResultSet rs = etat_insert.getGeneratedKeys();
            while (rs.next()) {
                article_a_insert.setIdArticle(rs.getInt(1));
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    /** Méthode qui update l'article en paramètre.
     *
     * @param article_a_update - Article
     */
    public void update(Article article_a_update) {
        try {
            PreparedStatement etat_update = JbdcTools.instanceConnectionSqlServer().prepareStatement(this.SQL_UPDATE);
            String type_article = null;

            etat_update.setString(1, article_a_update.getReference());
            etat_update.setString(2, article_a_update.getMarque());
            etat_update.setString(3, article_a_update.getDesignation());
            etat_update.setFloat(4, article_a_update.getPrix_unitaire());
            etat_update.setInt(5, article_a_update.getQuantite_stock());
            if (article_a_update instanceof Ramette) {
                type_article = "ramette";
                etat_update.setInt(6, ((Ramette) article_a_update).getGrammage());
                etat_update.setNull(7, Types.NULL);
            }
            if (article_a_update instanceof Stylo) {
                type_article = "stylo";
                etat_update.setNull(6, Types.NULL);
                etat_update.setString(7, ((Stylo)article_a_update).getCouleur());
            }
            etat_update.setString(8, type_article);
            etat_update.setInt(9, article_a_update.getIdArticle());

            etat_update.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    /** Méthode qui supprime l'article en paramètre de la BDD.
     *
     * @param id_article_a_delete - Article
     */
    public void delete(Integer id_article_a_delete) {
        try {
            PreparedStatement etat_delete = JbdcTools.instanceConnectionSqlServer().prepareStatement(this.SQL_DELETE);
            etat_delete.setInt(1, id_article_a_delete);
            etat_delete.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
