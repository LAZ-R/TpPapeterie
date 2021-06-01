package fr.eni.papeterie.bll;

/** Exception à lever en cas d'erreur dans la BLL
 *
 */
public class BLLException extends Exception{
    public BLLException(String message) {
        super(message);
    }
}
