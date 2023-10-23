package repository.registrador;

import repository.RepositoryException;

public class RegistradorNoSaveException extends RepositoryException{
    public RegistradorNoSaveException() {
        super("Registrador não salvo");
    } 
    
}
