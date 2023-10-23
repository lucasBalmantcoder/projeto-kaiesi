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

//import local
import model.aluno.Aluno;
//import model.conta.Conta;
//import repository.aluno.*;
//import repository.emprestimo.EmprestimoJaCadastradoException;
//import repository.emprestimo.EmprestimoNaoCadastradoException;
//import repository.emprestimo.RepositorioEmprestimo;
//import repository.conta.*;

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



public class BibliotecaUniversidade {
    
    //arquivovo para salvar os dados
    private final File arquivo = new File("biblioteca.liv");
    
    //chmada de arquivo dos repositórios aluno
    //private RepositorioAluno repositorioAluno;
    //private RepositorioLivro repositorioLivro;
    //private RepositorioExemplar repositorioExemplar;
    //private RepositorioEmprestimo repositorioEmprestimo;
   
    //private RepositorioConta repositorioConta;

    /* Padrão do projeto Sigleton*/

    //Atributo est?tico que vai manter a ?nica 
    //instância da classe 

    private static BibliotecaUniversidade instance = null;

    //Construtor deve ser privada garantindo que não seja chamado de
    //fora da classe

    private BibliotecaUniversidade() throws BibliotecaException {
        if(arquivo.exists()) {
               loadData();//implementado
        } else {
            //repositorioAluno = new RepositorioAlunoLista();
            //repositorioLivro = new RepositorioLivroLista();
            //repositorioExemplar = new RepositorioExemplarLista();
            //repositorioEmprestimo = new RepositorioEmprestimoLista();
          
         

            //repositorioConta = new RepositorioContaLista();
           //tenta fazer altera??es para fazer as chamadas da conta
        }
    }


    //Método getInstance, responsavel por fornecer a única instância
    //da classe

    public static BibliotecaUniversidade getInstance() throws BibliotecaException {
        if(instance == null)  {
            instance = new BibliotecaUniversidade();
        }
        return instance;
    }


    //Inicialização de chamada do Aluno


    public void inserir_aluno(Aluno aluno) throws CPFJaCadastradoException {
        repositorioAluno.inserir_aluno(aluno);
    }


    public void alterar_aluno(Aluno aluno) throws AlunoNaoCadastradoException {
        repositorioAluno.alterar_aluno(aluno);
        
    }

    public Aluno buscar_Aluno(String cpf) throws AlunoNaoCadastradoException {
        return repositorioAluno.buscar_aluno(cpf);

    }

    public void deletar_aluno(Aluno aluno) throws BibliotecaException,
    AlunoNaoCadastradoException  {
        repositorioAluno.deletar_aluno(aluno);

    }

    public List<Aluno>getAllAlunos() {
        return repositorioAluno.getAll();
    }


    //inicialização de chamadas do Livro

 
    
    
    //talvez seja necessario fazer alterações no repositório aluno
    //falta implementar os método da conta

    //Impplementação da parte de inixialização de Exemplar
 

    ///emprestimo

    public void inserir_novo_emprestimo(Emprestimo emprestimo) throws EmprestimoJaCadastradoException {
        repositorioEmprestimo.inserir_emprestimo(emprestimo);
    }

    public void devolver_livro_emprestado(Emprestimo emprestimo) throws EmprestimoNaoCadastradoException {
       

    } 


     public void alterar_emprestimo(Emprestimo emprestimo) throws EmprestimoNaoCadastradoException {
        repositorioEmprestimo.alterar_emprestimo(emprestimo);
    } 

    public Emprestimo buscar_emprestimo(String id_emprestimo) throws EmprestimoNaoCadastradoException {
        return repositorioEmprestimo.buscar_emprestimo(id_emprestimo);
    }
    
    public void deletar_emprestimo(Emprestimo emprestimo) throws BibliotecaException, EmprestimoNaoCadastradoException {
        repositorioEmprestimo.deletar_emprestimo(emprestimo);
    } 

    

      public List<Emprestimo>getAllEmprestimos() {
        return repositorioEmprestimo.getAll();
    }


    // a partir desse ponto são os métodos de armazenamento de dados
    private void loadData() throws BibliotecaException {
        try { 
            FileInputStream f = new FileInputStream(arquivo);
            ObjectInputStream o = new ObjectInputStream(f);

            //repositorioAluno = (RepositorioAluno) o.readObject();
           
            //repositorioEmprestimo = (RepositorioEmprestimo) o.readObject();
            

            o.close();
            f.close();
        }catch (Exception e) {
            throw new BibliotecaException("Erro ao carregar dados do arquivo", e);


        }
    }

    public void exit() throws BibliotecaException { 
        try { 
            FileOutputStream f = new FileOutputStream(arquivo);
            ObjectOutputStream o = new ObjectOutputStream(f);

            //salvar dados 
            //o.writeObject(repositorioAluno);
            
           // o.writeObject(repositorioEmprestimo);
            

            o.close();
            f.close();

        }catch (IOException e) {
            throw new BibliotecaException("Erro ao gravar dados no arquivo", e);
        }
    }

}

