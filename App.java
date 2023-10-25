
/**
 * @author Lucas Balmant
 * @
 * 
 * Esse projeto foi baseado no projeto do professo Enoque da Universidade federal do Oeste do Par�
 * 
 * Nas primeiras vers�es estava com problemas nas chamadas(acesso a dados do reposit�rio), alguns dos erros acredito que
 * foram causados por conta de alguma incopatiblidade do java com vs code, ou  pode   ser
 * por conta de algum erro na pr�pria linguagem que eu desconhe�o, fiz algumas altera��es para
 * resolver isso, criei um novo projeto no vs code vazio e quando se faz isso, algumas   
 * algumas pastas s�o criadas autom�ticamente elas s�o:
 * .vs code
 * bin
 * lib
 * src
 * -
 * Deppois copiei, todo o projeto para dentro da pasta src, isso � claro no novo projeto
 * e at� o momento todas as minhas chamadas est�o funcionando perfeitamente.
 * **/

//TODOS OS IMPORT'S DEVEM SER FEITOS AQUI.
import java.util.Scanner;



//import facade.Projetokaiesi;



public class App {

    
        //chamada de Projetokaise
        
    //private static Projetokaiesi facade;
     private static Scanner scanner = new Scanner(System.in);
     private static Registrador reg = new Registrador(0, 0, 0, 0);

     



    public static void main(String[] args) {
        

    
      
        try {
            System.out.println("Carregando o sistema...");

        //essa chamada aqui estava fazendo meu programa quebrar haha
        
        //Essa linha logo a baixo: 
        /* 
         * Atribui � uma vari�vel, uma int�ncia da classe 'Projetokaise' 
         * por meio do m�todo est�tico 'getIntance'
         * 
         * A classe implementa o padr�o de designer 'Sigleton', que garante que exista
         * apenas uma int�ncia dessa classe em todo o programa, o m�todo 'getInstance'
         * � respons�vel por retornar essa �nica instancia existente ou cria--l� caso
         * ainda n�o tenha sido criada.
         * */
        
    
            //facade = Projetokaiesi.getInstance();
           // cria_dados_testes();//o m�todo que cria dados testes est� no final.

            int opcao;
            do{
                limpaTela();
                System.out.println("    project Kaiesi");
                System.out.println("========================");
                System.out.println("<1> Data path");
                System.out.println("<2> Microprogama memory");
                System.out.println("<3> Main memory");
                System.out.println("<0> Sair");
                System.out.printf("Escolha uma opc�o:");

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

           //esse chamada de sa�da, faz com que o programa saia e salve os dados
           //facade.exit();
            
        } catch (Exception e) {
            System.err.println("Erro ao carregar dados");
            e.printStackTrace();
        }
        System.out.println("Programa terminado");
    }

    //Esse m�todo n�o limpa a tela, ele somente  imprime v�rios espa�os na tela.
    private static void limpaTela(){ 
        for(int i = 0; i < 50; i++) {
            System.out.println();
        }
    }


    private static void data_path(){
        //Registrador registrador = facade.projetokaiesi();
        limpaTela();
        int regis_a = 0;
        int regis_b = 0;
        int opcao;
    
        System.out.println("    Register Bank");
        System.out.println("C bus andress       A bus andress       C bus andress");
        System.out.println("=====================================================");
        System.out.printf("R0: %d \t\t\t", reg.getRegis_0());
        System.out.printf("R%d = %d          R%d = %d\n", regis_a, reg.select_reg(0), regis_b, reg.select_reg(0));
        System.out.printf("R1: %d \n", reg.getRegis_1());
        System.out.printf("R2: %d \n", reg.getRegis_2());
        System.out.printf("R3: %d \n", reg.getRegis_3());
        System.out.println("=====================================================");
        System.out.println("Press <1> to add values  Press <2> to remove values");
        System.out.println("Press <3> go to ULA      Press <0> to remove all");
        System.out.println("Press <4> select A e B");
        System.out.printf("Escolha uma opc�o:");
       
        
    try {
        opcao = Integer.valueOf(scanner.nextLine());
    } catch (Exception e) {
        opcao = 0;
    }

    switch (opcao) {
        case 1:
            // Adicionar valor - faz chamada de m�todo l� em registrador
            System.out.print("Digite o valor a ser adicionado: ");
            int valorAdicionado = Integer.valueOf(scanner.nextLine());
            System.out.print("Digite o registrador de destino (0-3): ");
            int regDestino = Integer.valueOf(scanner.nextLine());
            reg.select_reg(regDestino, valorAdicionado);
            break;
        case 2:
            // Remover valor usando removeValue() - faz chamada de m�todo l� em registrador
            System.out.print("Digite o registrador de destino (0-3) para remover o valor: ");
            int regDestinoRemocao = Integer.valueOf(scanner.nextLine());
            reg.removeValue(regDestinoRemocao);
            break;
        case 3:
            // Ir para ULA
            // Implemente a l�gica para ir para a ULA aqui
            break;
            case 4:
            System.out.print("Digite a or b");
            int indice = Integer.valueOf(scanner.nextLine());
            System.out.print("Digite o registrador de destino (0-3): ");
            int regDestine = Integer.valueOf(scanner.nextLine());
            
            break;
        case 0:
            // Remover todos os valores - vai zerar todos os regis
            reg.setRegis_0(0);
            reg.setRegis_1(0);
            reg.setRegis_2(0);
            reg.setRegis_3(0);
            break;
        default:
            break;
    }

    }

  

}
