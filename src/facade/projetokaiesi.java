package facade;

//import java
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
//import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//import java.util.List;

//import model.registrador.Registrador;
import repository.registrador.RegistroJaSalvoException;
import repository.registrador.RepositorioRegistrador;
import repository.registrador.RepositorioRegistradorLista;


public class Projetokaiesi {
    
    //arquivo para salvar os dados
    private final File arquivo = new File("projetokaiesi.dmp");
    
    //chamada do arquirvo do repositório
    private RepositorioRegistrador repositorioRegistrador;


    /* Padrão do projeto Sigleton*/

    //Atributo estético que vai manter a única 
    //instância da classe 

    private static Projetokaiesi instance = null;

    //Construtor deve ser privada garantindo que não seja chamado de
    //fora da classe

    private Projetokaiesi() throws KaiesiException {
        if(arquivo.exists()) {
               loadData();//implementado
        } else {
            repositorioRegistrador = new RepositorioRegistradorLista();
        
           //tenta fazer altera??es para fazer as chamadas da conta
        }
    }


    //M?todo getInstance, responsavel por fornecer a ?nica inst?ncia
    //da classe

    public static Projetokaiesi getInstance() throws KaiesiException {
        if(instance == null)  {
            instance = new Projetokaiesi();
        }
        return instance;
    }


    public void somar_registros(int regis1, int regis2) throws RegistroJaSalvoException{
         repositorioRegistrador.somar_registros(regis1,regis2);
    }

    // a partir desse ponto s?o os m?todos de armazenamento de dados
    private void loadData() throws KaiesiException {
        try { 
            FileInputStream f = new FileInputStream(arquivo);
            ObjectInputStream o = new ObjectInputStream(f);

            repositorioRegistrador = (RepositorioRegistrador) o.readObject();

            

            o.close();
            f.close();
        }catch (Exception e) {
            throw new KaiesiException("Erro ao carregar dados do arquivo", e);


        }
    }

    public void exit() throws KaiesiException { 
        try { 
            FileOutputStream f = new FileOutputStream(arquivo);
            ObjectOutputStream o = new ObjectOutputStream(f);

            //salvar dados 
            o.writeObject(repositorioRegistrador);
            
           // o.writeObject(repositorioEmprestimo);
            

            o.close();
            f.close();

        }catch (IOException e) {
            throw new KaiesiException("Erro ao gravar dados no arquivo", e);
        }
    }

}

