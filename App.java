/**
 * @author Lucas Balmant
 * 
 * Esse projeto foi baseado no projeto do professo Enoque da Universidade federal do Oeste do Pará
 * 
 * Nas primeiras versões estava com problemas nas chamadas(acesso a dados do repositório), alguns dos erros acredito que
 * foram causados por conta de alguma incopatiblidade do java com vs code, ou  pode   ser
 * por conta de algum erro na própria linguagem que eu desconheço, fiz algumas alterações para
 * resolver isso, criei um novo projeto no vs code vazio e quando se faz isso, algumas   
 * algumas pastas são criadas automáticamente elas são:
 * .vs code
 * bin
 * lib
 * src
 * -
 * Deppois copiei, todo o projeto para dentro da pasta src, isso é claro no novo projeto
 * e até o momento todas as minhas chamadas estão funcionando perfeitamente.
 * **/

//TODOS OS IMPORT'S DEVEM SER FEITOS AQUI.
import java.util.List;
import java.util.Scanner;
//import java.io.FileInputStream;

import model.aluno.*;
import model.emprestimo.Emprestimo;

import repository.RepositoryException;
import repository.exemplar.ExemplarNaoCadastradoException;
import repository.livro.LivroNaoCadastradoException;
//import do exemplar
import model.exemplar.*;
import model.livro.*;
//import repository.exemplar.*;

//"fachada"
import facade.BibliotecaUniversidade;
import facade.BibliotecaException;


class App {
        //chamada de biblioteca
    private static BibliotecaUniversidade facade;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        try {
            System.out.println("Carregando o sistema...");

        //essa chamada aqui estava fazendo meu programa quebrar haha
        
        //Essa linha logo a baixo: 
        /* 
         * Atribui á uma variável, uma intância da classe 'Biblioteca universidade' 
         * por meio do método estático 'getIntance'
         * 
         * A classe implementa o padrão de designer 'Sigleton', que garante que exista
         * apenas uma intância dessa classe em todo o programa, o método 'getInstance'
         * é responsável por retornar essa única instancia existente ou cria--lá caso
         * ainda não tenha sido criada.
         * */
        
            facade = BibliotecaUniversidade.getInstance();

            cria_dados_testes();//o método que cria dados testes está no final.

            int opcao;
            do{
                limpaTela();
                System.out.println("    MENU PRINCIPAL");
                System.out.println("========================");
                System.out.println("<1> Cadastrar Aluno");
                System.out.println("<2> Cadastrar Livros");
                System.out.println("<3> Cadastrar Exemplar");
                System.out.println("<4> Emprestimos");
                System.out.println("<0> Sair");
                System.out.printf("Escolha uma opcão:");

                try {

                    opcao = Integer.valueOf(scanner.nextLine());

                } catch (Exception e) {
                    opcao = 0;
                }

                switch (opcao) {
                    case 0: 
                        limpaTela();
                        break;
                    case 1:
                        cadastro_de_alunos();
                        break;
                    case 2:
                        cadastro_de_livro();
                        break;
                    case 3: 
                        cadastro_de_exemplar();
                        break;
                    case 4: 
                        cadastrar_emprestimos(); 
                        break;
                
                    default:
                        break;
                }
                
            }while(opcao != 0);

           //esse chamada de saída, faz com que o programa saia e salve os dados
           facade.exit();
            
        } catch (Exception e) {
            System.err.println("Erro ao carregar dados");
            e.printStackTrace();
        }
        System.out.println("Programa terminado");
    }

    //Esse método não limpa a tela, ele somente  imprime vários espaços na tela.
    private static void limpaTela(){ 
        for(int i = 0; i < 50; i++) {
            System.out.println();
        }
    }


  

    //fim das linhas

     

    //parte destinada para dados de teste
    //Está adicionando apenas Usuário
    

    private static void cria_dados_testes(){

        try {
            facade.inserir_aluno(new Aluno("Lucas Balmant", "111.111.111-11", "20230708", "Rua Bom Jardim", "99999999999"));
            facade.inserir_aluno(new Aluno("Peter Parker", "2", "20230709", "Nova York", "22222222222"));

            //dados de acesso rápido
            facade.inserir_aluno(new Aluno("Minato ", "1", "2","mundo", "4"));

            facade.inserir_livro(new Livro("Berserk", "Kentaro","fantasy"));
            facade.inserir_livro(new Livro("A arte", "Minato","aventura"));
            facade.inserir_livro(new Livro("Olho de Vidro", "Tales", "Horror"));
            facade.inserir_livro(new Livro("Vingadores","Marvel","comedia"));


            //inserir as informações de livro
            Livro livro = facade.buscar_Livro("1");
            Livro livro2 = facade.buscar_Livro("2");
            Livro livro3 = facade.buscar_Livro("3");
            Livro livro4 = facade.buscar_Livro("4");

            
            facade.inserir_exemplar(new Exemplar(livro, true, true));

            facade.inserir_exemplar(new Exemplar(livro2, true, false));

            facade.inserir_exemplar(new Exemplar(livro3, true,false));

            facade.inserir_exemplar(new Exemplar(livro4, true, false));

            Aluno aluno = facade.buscar_Aluno("111.111.111-11");

            Aluno aluno2 = facade.buscar_Aluno("2");

            Exemplar exemplar1 = facade.buscar_Exemplar("1");

            Exemplar exemplar2 = facade.buscar_Exemplar("2");


            facade.inserir_novo_emprestimo(new Emprestimo(aluno, exemplar1 ));

            facade.inserir_novo_emprestimo(new Emprestimo(aluno2, exemplar2));

            //dados de teste  de exemplar2
            
            // biblioteca.inserir_exemplar(new Exemplar("macacos voadores", "Jhony bravo", "Fantasia", 02, true, null));
            //biblioteca.inserir_exemplar(new Exemplar("Pantera ", "Michael Rusber", "Terror", 03, true, null));
        } catch (RepositoryException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
    }
}
