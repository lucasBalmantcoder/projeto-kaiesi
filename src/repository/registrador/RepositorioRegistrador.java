package repository.registrador;

//import locais
import model.registrador.Registrador;

//import da linguagem java
//import java.util.List;

public interface RepositorioRegistrador {

    
    void inserir_registrador(Registrador registrador) throws RegistroJaSalvoException;

    //Registrador buscar_registrador(Registrador registrador) throws RegistradorNoSaveException;

    //void alterar_registrador(Registrador registrador) throws RegistradorNoSaveException;

    void deletar_registrador(Registrador registrador) throws RegistradorNoSaveException;

    
   
     //   List<Registrador> getAll();
 

    
}
