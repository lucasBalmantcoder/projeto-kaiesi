package facade;


//todas as classe com exeções devem extender a 'exception'
public class KaiesiException extends Exception {
    public KaiesiException(String message) {
        super(message);
    }

    public KaiesiException(String message, Throwable e) {
        super(message, e);
    }

    
}
