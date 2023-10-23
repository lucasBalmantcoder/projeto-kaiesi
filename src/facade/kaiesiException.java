package facade;


//todas as classe com exeções devem extender a 'exception'
public class kaiesiException extends Exception {
    public kaiesiException(String message) {
        super(message);
    }

    public kaiesiException(String message, Throwable e) {
        super(message, e);
    }

    
}
