package excepciones;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

public class NegocioException extends Exception {
    /**
     * constructor por ausencia de negocio exception
     */
    public NegocioException() {
    }
    /**
     * contructor que devuelve el mensaje de error
     * @param message  mensaje del error
     */
    public NegocioException(String message) {
        super(message);
    }
    /**
     * contructor que devuelve el mensaje de error y la causa
     * @param message mensaje del error
     * @param cause causa de lerror
     */
    public NegocioException(String message, Throwable cause) {
        super(message, cause);
    }
    
    /**
     * Constructor que devuelve la causa del error
     * @param cause causa de lerror
     */
    public NegocioException(Throwable cause) {
        super(cause);
    }


    public NegocioException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
