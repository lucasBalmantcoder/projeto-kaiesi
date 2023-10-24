package app;
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
//import java.util.Scanner;

//import facade.Projetokaiesi;



class App {
        //chamada de Projetokaise
        
    //private static Projetokaiesi facade;
     private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        try {
            //System.out.println("Carregando o sistema...");

        //essa chamada aqui estava fazendo meu programa quebrar haha
        
        //Essa linha logo a baixo: 
        /* 
         * Atribui á uma variável, uma intância da classe 'Projetokaise' 
         * por meio do método estático 'getIntance'
         * 
         * A classe implementa o padrão de designer 'Sigleton', que garante que exista
         * apenas uma intância dessa classe em todo o programa, o método 'getInstance'
         * é responsável por retornar essa única instancia existente ou cria--lá caso
         * ainda não tenha sido criada.
         * */
        
    
            //facade = Projetokaiesi.getInstance();
           // cria_dados_testes();//o método que cria dados testes está no final.

            int opcao;
            do{
                limpaTela();
                System.out.println("    project Kaiesi");
                System.out.println("========================");
                System.out.println("<1> Data path");
                System.out.println("<2> Microprogama memory");
                System.out.println("<3> Main memory");
                System.out.println("<0> Sair");
                System.out.printf("Escolha uma opcão:");

                try {

                    opcao = Integer.valueOf(scanner.nextLine());

                } catch (Exception e) {
                    opcao = 0;
                }

                switch (opcao) {
                    case 0: limpaTela(); break;
                    case 1: data_path(); break;
                    //case 2: cadastro_de_livro(); break;
                    //case 3: cadastro_de_exemplar(); break;
                    default: break;
                }
                
            }while(opcao != 0);

           //esse chamada de saída, faz com que o programa saia e salve os dados
           //facade.exit();
            
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


    private static void data_path(){
        //Registrador registrador = facade.projetokaiesi();
        limpaTela();
        System.out.println("    Register Bank");
        System.out.println("========================");
        System.out.println("<2> Microprogama memory");
        System.out.println("<3> Main memory");
        System.out.println("<0> Sair");
        System.out.printf("Escolha uma opcão:");

    }

  

}
