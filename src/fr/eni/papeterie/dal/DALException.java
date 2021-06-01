package fr.eni.papeterie.dal;

/** Exception à lever en cas d'erreur dans la DAL
 *
 */
public class DALException extends Exception{
    public DALException(String message) {
        super(message);
    }
}
