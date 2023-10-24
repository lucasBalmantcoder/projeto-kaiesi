
/**
 * @author Lucas Balmant
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
/*
 *Nota de @Igoquintino: adicionando o front-end da banco de registro, ainda não completa
 *Nota de @Igoquintino: adicionando também parte não compleeta da ALU(ULA)
 *unidade lógica aritmetica no Front-end de terminal
*/

 //TODOS OS IMPORT'S DEVEM SER FEITOS AQUI.
import java.util.Scanner;

//import facade.Projetokaiesi;




class App {
        //chamada de Projetokaise
        
    //private static Projetokaiesi facade;
     private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        try {
            //System.out.println("Carregando o sistema...");

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

            /*==>Star menu<==*/
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
    /*==>End Menu<==*/

    //Esse m�todo n�o limpa a tela, ele somente  imprime v�rios espa�os na tela.
        private static void limpaTela(){ 
            for(int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
        
        
        /*==>Start Front dos registradores<==
         *incluindo a chamada especifica de cada um; 
        */
        private static void data_path(){
            int opcao;
            //Registrador registrador = facade.projetokaiesi();
            try {
                do{
                limpaTela();
                System.out.println("    Data Path");
                System.out.println("    Register Bank");
                System.out.println("========================");
                System.out.println("<1> Register '0' ");
                System.out.println("<2> Register '1' ");
                System.out.println("<3> Register '2' ");
                System.out.println("<4> Register '3' ");
                System.out.println("<0> Sair ");
                System.out.printf("Escolha uma opc�o:");

                try{
                
                    opcao = Integer.valueOf(scanner.nextLine());

                } catch(Exception e){
                    opcao = 0;
                }

                switch(opcao){ // ajustar para chamar o metodo que add no respectivo register
                    case 0: limpaTela(); break;
                    case 1: data_path(); break;
                    //case 2: cadastro_de_livro(); break;
                    //case 3: cadastro_de_exemplar(); break;
                    default: break;
                }
                }while(opcao!=0);
            } catch (Exception e) {
                    System.err.println("Erro ao carregar dados");
                    e.printStackTrace();
            }
            System.out.println("Programa terminado");
        }

        private static void register_0(){
            int opcao;
            try{
                do{
                limpaTela();
                System.out.println("    Register Bank");
                System.out.println("    Register '0' ");
                System.out.println("    =============");
                System.out.println("    <0> Voltar ");

                try{
                    
                    opcao = Integer.valueOf(scanner.nextLine());

                } catch(Exception e){
                    opcao = 0;
                }

                switch(opcao){ // chama o metódo data_path para escolher 
                    case 0: limpaTela();data_path(); break;
                    default: break;
                }
                }while(opcao!=0);
            }catch (Exception e) {
                System.err.println("Erro ao carregar dados");
                e.printStackTrace();
            }
            System.out.println("Programa terminado");
        }


        private static void register_1(){
            try{
                do{
                limpaTela();
                System.out.println("    Register Bank");
                System.out.println("    Register '1' ");
                System.out.println("    =============");
                System.out.println("    <0> Voltar ");

                try{
                    
                    opcao = Integer.valueOf(scanner.nextLine());

                } catch(Exception e){
                    opcao = 0;
                }

                switch(opcao){ //chama o metódo data_path para escolher 
                    case 0: limpaTela();data_path(); break;
                    default: break;
                }
                }while(opcao!=0);
            }catch (Exception e) {
                System.err.println("Erro ao carregar dados");
                e.printStackTrace();
            }
            System.out.println("Programa terminado");
        }


        private static void register_2(){
            try{
                do{
                limpaTela();
                System.out.println("    Register Bank");
                System.out.println("    Register '2' ");
                System.out.println("    =============");
                System.out.println("    <0> Voltar ");

                try{
                    
                    opcao = Integer.valueOf(scanner.nextLine());

                } catch(Exception e){
                    opcao = 0;
                }

                switch(opcao){ //chama o metódo data_path para escolher 
                    case 0: limpaTela();data_path(); break;
                    default: break;
                }
                
                }while (opcao!=0);
            }catch (Exception e) {
                System.err.println("Erro ao carregar dados");
                e.printStackTrace();
            }
            System.out.println("Programa terminado");
        }

        private static void register_3(){
            try{
                do{
                limpaTela();
                System.out.println("    Register Bank");
                System.out.println("    Register '3' ");
                System.out.println("    =============");
                System.out.println("    <0>  ");

                try{
                    
                    opcao = Integer.valueOf(scanner.nextLine());

                } catch(Exception e){
                    opcao = 0;
                }

                switch(opcao){ // chama o metódo data_path para escolher 
                    case 0: limpaTela();data_path(); break;
                    default: break;
                }
    
                }while(opcao!=0);

            }catch (Exception e) {
                System.err.println("Erro ao carregar dados");
                e.printStackTrace();
            }
            System.out.println("Programa terminado");
        }
        /*==>End Front registradores<== */
        
        /*==>Star Front Alu(ULA)<== */
        /*private static void ALU_ULA(){
            //Registrador registrador = facade.projetokaiesi();
            try {
                do{
                limpaTela();
                System.out.println("    ALU(ULA)");
                System.out.println("    Alu Operation");
                System.out.println("========================");
                System.out.println("<1> A + B ");
                System.out.println("<2> A - B ");
                System.out.println("<3> A || B ");
                System.out.println("<4> A & B");
                System.out.println("<0> Voltar ");
                System.out.printf("Escolha uma opc�o:");

                try{
                
                opcao = Integer.valueOf(scanner.nextLine());

                } catch(Exception e){
                    opcao = 0;
                }

                switch(opcao){ // ajustar para chamar o metodo que add no respectivo register
                    case 0: limpaTela(); break;
                    case 1: data_path(); break;
                    case 2: cadastro_de_livro(); break;
                    case 3: cadastro_de_exemplar(); break;
                    default: break;
                }
                }while(opcao!=0);
            } catch (Exception e) {
                    System.err.println("Erro ao carregar dados");
                    e.printStackTrace();
            }
            System.out.println("Programa terminado");
        }
        private static void A_mais_B(){
            try{
                do{
                limpaTela();
                System.out.println("    Register Bank");
                System.out.println("    Register '0' ");
                System.out.println("    =============");
                System.out.println("    <0> Voltar ");

                try{
                    
                    opcao = Integer.valueOf(scanner.nextLine());

                } catch(Exception e){
                    opcao = 0;
                }

                switch(opcao){ // chama o metódo data_path para escolher 
                    case 0: limpaTela();data_path(); break;
                    default: break;
                }
                }while(opcao!=0);
            }catch (Exception e) {
                System.err.println("Erro ao carregar dados");
                e.printStackTrace();
            }
            System.out.println("Programa terminado");
        }


        private static void A_menos_B(){
            try{
                do{
                limpaTela();
                System.out.println("    Register Bank");
                System.out.println("    Register '1' ");
                System.out.println("    =============");
                System.out.println("    <0> Voltar ");

                try{
                    
                    opcao = Integer.valueOf(scanner.nextLine());

                } catch(Exception e){
                    opcao = 0;
                }

                switch(opcao){ //chama o metódo data_path para escolher 
                    case 0: limpaTela();data_path(); break;
                    default: break;
                }
                }while(opcao!=0);
            }catch (Exception e) {
                System.err.println("Erro ao carregar dados");
                e.printStackTrace();
            }
            System.out.println("Programa terminado");
        }


        private static void A_and_B(){
            try{
                do{
                limpaTela();
                System.out.println("    Register Bank");
                System.out.println("    Register '2' ");
                System.out.println("    =============");
                System.out.println("    <0> Voltar ");

                try{
                    
                    opcao = Integer.valueOf(scanner.nextLine());

                } catch(Exception e){
                    opcao = 0;
                }

                switch(opcao){ //chama o metódo data_path para escolher 
                    case 0: limpaTela();data_path(); break;
                    default: break;
                }
                
                }while (opcao!=0);
            }catch (Exception e) {
                System.err.println("Erro ao carregar dados");
                e.printStackTrace();
            }
            System.out.println("Programa terminado");
        }

        private static void A_our_B(){
            try{
                do{
                limpaTela();
                System.out.println("    ALU(ULA)");
                System.out.println("    '3' ");
                System.out.println("    =============");
                System.out.println("    <0>  ");

                try{
                    
                    opcao = Integer.valueOf(scanner.nextLine());

                } catch(Exception e){
                    opcao = 0;
                }

                switch(opcao){ // chama o metódo data_path para escolher 
                    case 0: limpaTela();data_path(); break;
                    default: break;
                }
    
                }while(opcao!=0);

            }catch (Exception e) {
                System.err.println("Erro ao carregar dados");
                e.printStackTrace();
            }
            System.out.println("Programa terminado");
        }*/

}

    













    