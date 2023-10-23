package facade;

//import java
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
//import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import model.registrador.Registrador;
import repository.registrador.RepositorioRegistrador;
import repository.registrador.RepositorioRegistradorLista;

//repositório de emprestimo
//import model.emprestimo.*;
//import repository.emprestimo.RepositorioEmprestimoLista;
//import livro
//import repository.livro.*;
//import model.livro.*;

//import de exemplar
//import repository.exemplar.*;
//import model.exemplar.*;

//import exceções
//import repository.aluno.AlunoNaoCadastradoException;
//import repository.aluno.CPFJaCadastradoException;
//import local.*; com asteriscos serve para fazer chamada



public class projetokaiesi {
    
    //arquivovo para salvar os dados
    private final File arquivo = new File("kaiesi.dmp");
    
    private RepositorioRegistrador repositorioRegistrador;
    //chmada de arquivo dos repositórios aluno
    //private RepositorioAluno repositorioAluno;
    //private RepositorioLivro repositorioLivro;
    //private RepositorioExemplar repositorioExemplar;
    //private RepositorioEmprestimo repositorioEmprestimo;
   
    //private RepositorioConta repositorioConta;

    /* Padrão do projeto Sigleton*/

    //Atributo est?tico que vai manter a ?nica 
    //instância da classe 

    private static projetokaiesi instance = null;

    //Construtor deve ser privada garantindo que não seja chamado de
    //fora da classe

    private projetokaiesi() throws kaiesiException {
        if(arquivo.exists()) {
               loadData();//implementado
        } else {
            repositorioRegistrador = new RepositorioRegistradorLista();
            //repositorioAluno = new RepositorioAlunoLista();
            //repositorioLivro = new RepositorioLivroLista();
            //repositorioExemplar = new RepositorioExemplarLista();
            //repositorioEmprestimo = new RepositorioEmprestimoLista();
          
         

            //repositorioConta = new RepositorioContaLista();
           //tenta fazer altera??es para fazer as chamadas da conta
        }
    }


    //M?todo getInstance, responsavel por fornecer a ?nica inst?ncia
    //da classe

    public static projetokaiesi getInstance() throws kaiesiException {
        if(instance == null)  {
            instance = new projetokaiesi();
        }
        return instance;
    }


    //Inicializa??o de chamada do Aluno

/*     public void inserir_aluno(Aluno aluno) throws RegistroJaSalvoException {
        repositorioAluno.inserir_aluno(aluno);
    }


    public void alterar_aluno(Aluno aluno) throws RegistradorNoSaveException {
        repositorioAluno.alterar_aluno(aluno);
        
    }

    public Aluno buscar_Aluno(String cpf) throws RegistradorNoSaveException {
        return repositorioAluno.buscar_aluno(cpf);

    }

    public void deletar_aluno(Aluno aluno) throws kaiesiException,
    RegistradorNoSaveException  {
        repositorioAluno.deletar_aluno(aluno);

    }

    public List<Aluno>getAllAlunos() {
        return repositorioAluno.getAll();
    }



    //inicializa??o de chamadas do Livro

 
    
    
    //talvez seja necessario fazer altera??es no reposit?rio aluno
    //falta implementar os m?todo da conta

    //Impplementa??o da parte de inixializa??o de Exemplar
 

    ///emprestimo

    public void inserir_novo_emprestimo(microprograma emprestimo) throws EmprestimoJaCadastradoException {
        repositorioEmprestimo.inserir_emprestimo(emprestimo);
    }

    public void devolver_livro_emprestado(microprograma emprestimo) throws EmprestimoNaoCadastradoException {
       

    } 


     public void alterar_emprestimo(microprograma emprestimo) throws EmprestimoNaoCadastradoException {
        repositorioEmprestimo.alterar_emprestimo(emprestimo);
    } 

    public microprograma buscar_emprestimo(String id_emprestimo) throws EmprestimoNaoCadastradoException {
        return repositorioEmprestimo.buscar_emprestimo(id_emprestimo);
    }
    
    public void deletar_emprestimo(microprograma emprestimo) throws kaiesiException, EmprestimoNaoCadastradoException {
        repositorioEmprestimo.deletar_emprestimo(emprestimo);
    } 

    

      public List<microprograma>getAllEmprestimos() {
        return repositorioEmprestimo.getAll();
    }

*/

    // a partir desse ponto s?o os m?todos de armazenamento de dados
    private void loadData() throws kaiesiException {
        try { 
            FileInputStream f = new FileInputStream(arquivo);
            ObjectInputStream o = new ObjectInputStream(f);

            repositorioRegistrador = (repositorioRegistrador) o.readObject();
            //repositorioAluno = (RepositorioAluno) o.readObject();
           
            //repositorioEmprestimo = (RepositorioEmprestimo) o.readObject();
            

            o.close();
            f.close();
        }catch (Exception e) {
            throw new kaiesiException("Erro ao carregar dados do arquivo", e);


        }
    }

    public void exit() throws kaiesiException { 
        try { 
            FileOutputStream f = new FileOutputStream(arquivo);
            ObjectOutputStream o = new ObjectOutputStream(f);

            //salvar dados 
            //o.writeObject(repositorioAluno);
            
           // o.writeObject(repositorioEmprestimo);
            

            o.close();
            f.close();

        }catch (IOException e) {
            throw new kaiesiException("Erro ao gravar dados no arquivo", e);
        }
    }

}

