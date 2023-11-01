/**
 * @author Lucas Balmant
 * @author Igo Quintino
 * 
 * Esse projeto foi baseado no projeto do professo Enoque da Universidade federal do Oeste do Para
 * 
 * Nas primeiras versoes estava com problemas nas chamadas(acesso a dados do repositorio), alguns dos erros acredito que
 * foram causados por conta de alguma incopatiblidade do java com vs code, ou  pode   ser
 * por conta de algum erro na propria linguagem que eu desconheco, fiz algumas alteracoes para
 * resolver isso, criei um novo projeto no vs code vazio e quando se faz isso, algumas   
 * algumas pastas sao criadas automaticamente elas sao:
 * .vs code
 * bin
 * lib
 * src
 * -
 * Deppois copiei, todo o projeto para dentro da pasta src, isso e claro no novo projeto
 * e ate o momento todas as minhas chamadas estao funcionando perfeitamente.
 * **/

//TODOS OS IMPORT'S DEVEM SER FEITOS AQUI.
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import exceptions.MicroprogramaJaCadastradoException;
import exceptions.MicroprogramaNaoCadastradoException;


public class App {//teste qualquer coisa da vida caralho

    // chamada de Projetokaise
    // private static Projetokaiesi facade;
    //teste

    private static Scanner scanner = new Scanner(System.in);
    private static Registrador reg = new Registrador(20, 30, 50, 1);
    private static Memory_main mm = new Memory_main(5, 4, 3, 2, 0);

    
    private static List<Microprograma>microprogramas = new ArrayList<>();
    private static idGeneratorStrategy index = new SequencialContaIdGeneratorStrategy();

    public static void main(String[] args)  {

        try {
            cria_dados_testes();
        } catch (MicroprogramaJaCadastradoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            System.out.println("Carregando o sistema...");

            int opcao;
            do {
                limpaTela();
                System.out.println("    project Kaiesi");
                System.out.println("========================");
                System.out.println("<1> Data path");
                System.out.println("<2> Microprogama memory");
                System.out.println("<3> Main memory");
                System.out.println("<4> ULA(ALU)");
                System.out.println("<0> Sair");
                System.out.printf("Escolha uma opcao:");

                try {

                    opcao = Integer.valueOf(scanner.nextLine());

                } catch (Exception e) {
                    opcao = 0;
                }

                switch (opcao) {
                    case 0: limpaTela(); break;
                    case 1: data_path(); break;
                    case 2: micro_program();; break;
                    case 3: main_memory(); break;
                    case 4: goto_ula(); break;
                    default: break;
                }

            } while (opcao != 0);

        } catch (Exception e) {
            System.err.println("Erro ao carregar dados");
            e.printStackTrace();
        }
        System.out.println("Programa terminado");
    }

    

private static void inserir_micro_p(Microprograma microprograma) throws MicroprogramaJaCadastradoException {

    if (microprogramas.size() >= 3) {
        System.out.println("Limite de 6 elementos atingido. Não é possível adicionar mais elementos.");
        return; // Saia do método, pois o limite foi atingido
    }

    if (microprograma.getId_micro() == null) {
        microprograma.setId_micro(index.nextId());
    }

    try {
        buscar_micro_programa(microprograma.getId_micro());
        throw new MicroprogramaJaCadastradoException();
    } catch (MicroprogramaNaoCadastradoException e) {
        microprogramas.add(microprograma);
    }
}
    
        private static Microprograma buscar_micro_programa(String id_microprograma) throws MicroprogramaNaoCadastradoException {
            for (Microprograma microprograma : microprogramas) {
                if (microprograma.getId_micro().equals(id_microprograma)) {
                    return microprograma;
                }
            }
        
            
            throw new MicroprogramaNaoCadastradoException();
        }

        
        private static void removerMaiorIndice() {
            int maiorIndice = -1; // Inicializa com um valor impossível de ser um índice válido
            Microprograma microprogramaComMaiorIndice = null;
        
            for (Microprograma microprograma : microprogramas) {
                String idMicro = microprograma.getId_micro();
                if (idMicro != null) {
                    int indice = Integer.parseInt(idMicro); // Converte o ID para um número
                    if (indice > maiorIndice) {
                        maiorIndice = indice; // Atualiza o maior índice encontrado
                        microprogramaComMaiorIndice = microprograma; // Atualiza o Microprograma correspondente
                    }
                }
            }
        
            if (microprogramaComMaiorIndice != null) {
                microprogramaComMaiorIndice.setId_micro(index.antId());
                microprogramas.remove(microprogramaComMaiorIndice); // Remove o Microprograma com o maior índice
                
            }
        }

        private static void remove_all() {
            for (Microprograma microprograma : microprogramas) {
                String idMicro = microprograma.getId_micro();
                if (idMicro != null) {
                    int indice = Integer.parseInt(idMicro);
                    if (indice >= 0) {
                        microprograma.setId_micro(index.antId()); // Define o índice como zero
                    }
                }
            }
            
            microprogramas.clear(); // Remove todos os elementos da lista
        }
        

        private static List<Microprograma> getallMicroprogramas() {
            return new ArrayList<>(microprogramas);
        }

        

    // Esse metodo nao limpa a tela, ele so imprime varios espacos na tela.
    private static void limpaTela() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    private static void data_path() {

        // Registrador registrador = facade.projetokaiesi();
        limpaTela();
        int opcao;
        do {
            menu_ini();
            confis_01();

            try {
                opcao = Integer.valueOf(scanner.nextLine());
            } catch (Exception e) {
                opcao = 0;
            }

            switch (opcao) {
                case 1:
                    limpaTela();// vai limpar a tela
                    menu_ini();// vai fazer atializar o menu de acordo com as confis do swc
                    // Adicionar valor - faz chamada de metodo la em registrador
                    System.out.print("Digite o valor a ser adicionado: ");
                    int valorAdicionado = Integer.valueOf(scanner.nextLine());
                    System.out.print("Digite o registrador de destino (0-3): ");
                    int regDestino = Integer.valueOf(scanner.nextLine());
                    reg.select_reg(regDestino, valorAdicionado);
                    limpaTela();
                    break;

                case 2:
                    limpaTela();// vai limpar a tela
                    menu_ini();// vai fazer atializar o menu de acordo com as confis do swc

                    // Remover valor usando removeValue() - faz chamada de metodo la em registrador
                    System.out.print("Digite o id do registrador (0-3) para remover o valor: ");
                    int regDestinoRemocao = Integer.valueOf(scanner.nextLine());
                    reg.removeValue(regDestinoRemocao);
                    limpaTela();
                    break;
                case 3:

                    goto_ula();// ir para ula

                    break;
                case 4:
                    limpaTela();// vai limpar a tela
                    menu_ini();// vai fazer atializar o menu de acordo com as confis do swc

                    select_a_b();

                    limpaTela();// vai limpar a tela
                    break;

                case 0:
                    limpaTela();
                    // Remover todos os valores - vai zerar todos os regis
                    reg.remove_all();

                    break;
                default:
                    break;
            }
        } while (opcao != 5);
    }

    /*
     * Metodo para manipulacao de valores, ou seja, que vai ser setado em 'A' ou em
     * 'B'
     */
    private static void select_a_b() {
        System.out.println("Digite A(0) ou B(1): ");
        int var;
        do {
            var = Integer.valueOf(scanner.nextLine());
            if (var == 0) {
                int var0;
                do {
                    System.out.print("Digite o registrador de destino (0-3) para setar o valor em 'A': ");
                    var0 = Integer.valueOf(scanner.nextLine());
                    reg.setA(var0);
                } while (var0 < 0 || var0 > 3);
                break;
            } else if (var == 1) {
                int var1;
                do {
                    System.out.print("Digite o registrador de destino (0-3) para setar o valor em 'B': ");
                    var1 = Integer.valueOf(scanner.nextLine());
                    reg.setB(var1);
                } while (var1 < 0 || var1 > 3);
                break;
            }
        } while (var < 0 || var > 1);
    }

    /*--> START UlA(ALU) FUNCTION <--*/
    private static void goto_ula() {// unidade logica e aritmatica
        limpaTela();
        int opcao;
        String[] s = { "(+)", "(-)", "(and)", "(or)" };

        do {
            System.out.println("             Unit of Logic and Arithmetic");
            System.out.println("C bus andress       A bus andress       B bus andress");
            System.out.println("=====================================================");
            System.out.printf("R%d = %d\t\t   R%d = %d   %s   R%d = %d\n", reg.getC(), reg.retonar_reg(reg.getC()),
                    reg.getA(), reg.retonar_reg(reg.getA()), s[reg.getSel()], reg.getB(),
                    reg.retonar_reg(reg.getB()));/* funcionando o setamento de valores em 'A' e 'B' */
            System.out.println("=====================================================");
            info_regis();
            confis_02();

            try {
                opcao = Integer.valueOf(scanner.nextLine());

            } catch (Exception e) {
                opcao = 0;
            }

            switch (opcao) {
                /*--> start operation <--*/
                case 1: somar_regis(); limpaTela(); break;
                case 2: sub_regis(); limpaTela(); break;
                case 3: and_regis(); limpaTela(); break;
                case 4: or_regis(); limpaTela(); break;
                /*--> end operation <--*/
                case 5: data_path(); break;/*atalho direto para Register Bank*/
                case 6: select_c(); limpaTela(); break;/*Selecionar registrador para a saida do 'C bus'*/
                case 0: menu_ini(); break;/*Saida para o menu inicial*/
                default: break;
            }
        } while (opcao != 0);
    }
    /*Start funcoes das operacoes da ULA(ALU)*/
    private static void somar_regis() {
        int i = 0;
        reg.setSel(i);
        int a = reg.retonar_reg(reg.getA());
        int b = reg.retonar_reg(reg.getB());

        reg.somar_registros(reg.getC(), a, b);

    }

    private static void sub_regis() {
        int i = 1;
        reg.setSel(i);
        int a = reg.retonar_reg(reg.getA());
        int b = reg.retonar_reg(reg.getB());

        reg.sub_registros(reg.getC(), a, b);

    }

    private static void and_regis() {
        int i = 2;
        reg.setSel(i);
        int a = reg.retonar_reg(reg.getA());
        int b = reg.retonar_reg(reg.getB());

        reg.and_registros(reg.getC(), a, b);

    }

    private static void or_regis() {
        int i = 3;
        reg.setSel(i);
        int a = reg.retonar_reg(reg.getA());
        int b = reg.retonar_reg(reg.getB());

        reg.or_registros(reg.getC(), a, b);

    }

    private static void select_c() {
        int var_c;
        do {
            System.out.print("Digite o registrador de destino (0-3) para setar o valor em 'C': ");
            var_c = Integer.valueOf(scanner.nextLine());
            reg.setC(var_c);
        } while (var_c < 0 || var_c > 3);
    }
    /*End funcao das operacoes da ULA(ALU)*/
    /*--> END ULA(ALU) FUNCTION <--*/

    /*--> START MAIN MEMORY COMPLETO, PRFV, VERIFIQUE OS COMENTARIOS DA FUNCOES <--*/
    private static void main_memory() {
        limpaTela();
        int opcao;
        do {
            System.out.println("                   Memory Main");
            System.out.println("Value");
            System.out.println("=====================================================");
            System.out.printf("0 : %d \n", mm.getM_0());
            System.out.printf("1 : %d \n", mm.getM_1());
            System.out.printf("2 : %d \n", mm.getM_2());
            System.out.printf("3 : %d \n", mm.getM_3());
            System.out.printf("4 : %d \n", mm.getM_4());
            System.out.println("=====================================================");
            mm_confis_01();

            try {
                opcao = Integer.valueOf(scanner.nextLine());

            } catch (Exception e) {
                opcao = 0;
            }

            switch (opcao) {
                case 1: add_mm(); break; /* add valor especifico no mm */
                case 2: remove_mm(); break; /* remover valor especifico no mm */
                case 3: goto_ula(); limpaTela(); break;/* direto para ULA */
                case 4: select_regis(); limpaTela(); break;/* Selecionar para onde vai o valor contido na id de memoria */
                case 5: menu_ini(); break;/*Saida para o menu inicial*/
                case 6: select_c(); limpaTela(); break;
                case 0: mm.remove_all(); limpaTela(); break;
                default: break;
            }
        } while (opcao != 5);
    }

    private static void micro_program() {
        limpaTela();
        int opcao;
        do {
            limpaTela();
            info_mc();
            List<Microprograma> microprogramas = getallMicroprogramas();
            for (Microprograma microprograma : microprogramas) {
                System.out.printf("%s  R%d\tR%d\t%d \t%d\t\tR%d\t%d\n", microprograma.getId_micro(),microprograma.getA_addr(), microprograma.getB_addr(), microprograma.getAlu_op(), 0,microprograma.getC_addr(),microprograma.getRw());
            }
       
            mc_confis_01();

            try {
                opcao = Integer.valueOf(scanner.nextLine());

            } catch (Exception e) {
                opcao = 0;
            }

            switch (opcao) {
                case 1: 
                     Microprograma microprograma = new Microprograma(reg.getA(), reg.getB(), reg.getC(), reg.getAlu_op(), 0, mm.getVar());
                     try {
                        inserir_micro_p(microprograma);
                    } catch (MicroprogramaJaCadastradoException e) {
                      
                        e.printStackTrace();
                    }
                    break; 
                case 2:
                    removerMaiorIndice();
                break; 
                case 3: goto_ula(); limpaTela(); break;

                case 4: main_memory(); limpaTela(); break;/* Selecionar para onde vai o valor contido na id de memoria */
                case 5:  break;/*Saida para o menu inicial*/
                
                case 6: execute();break;
                case 0: remove_all(); break;
                default: break;
            }
        } while (opcao != 5 );
    }

    private static void execute(){
        List<Microprograma> microprogramas = getallMicroprogramas();
            for (Microprograma microprograma : microprogramas) {
                reg.setA(microprograma.getA_addr());
                reg.setB(microprograma.getB_addr());
                reg.setC(microprograma.getC_addr());
                reg.setAlu_op(microprograma.getAlu_op());
                mm.setVar(microprograma.getRw());
                reg.setId_registrador(microprograma.getId_micro());
            }
        
    }


    /*--> END MEMORY MAIN FUNCTION <--*/

    /*--> START MENUS DO DAS FUNCOES PRINCIPAIS <--*/

    private static void confis_01() { /*Banco de Registro, opcoes de escolhas, apenas print*/
        System.out.println("Press <1> to add values  Press <2> to remove values");
        System.out.println("Press <3> go to ULA      Press <0> to remove all");
        System.out.println("Press <4> select A e B   Press <5> to exit");
        System.out.printf("Escolha uma opcao:");
    }

    private static void confis_02() {/*ULA(ALU), opcoes de escolhas, apenas print*/
        System.out.println("Press <1> A + B            Press <2> A - B");
        System.out.println("Press <3> A & B            Press <4> A or B");
        System.out.println("Press <5> go to RB         Press <0> to exit");
        System.out.println("Press <6> select c regis");
        System.out.printf("Escolha uma opcao:");
    }

    private static void mm_confis_01() { /*memoria main, as opcoes de escolha, apenas print*/
        System.out.println("Press <1> to add values      Press <2> to remove values");
        System.out.println("Press <3> go to ULA          Press <0> to remove all");
        System.out.println("Press <4> select registers   Press <5> to exit");
        System.out.printf("Escolha uma opcao:");
    }

     private static void mc_confis_01() { /*microprograma, as opcoes de escolha, apenas print*/
        System.out.println("===================================================");
        System.out.println("Press <1> save mc           Press <2> to remove mc");
        System.out.println("Press <3> go to ULA         Press <0> to remove all");
        System.out.println("Press <4> go to mm          Press <6> Execute");
        System.out.println("Press <5> to exit           ");
        System.out.printf("Escolha uma opcao:");
    }

    private static void menu_ini() { /*banco de registro, ele atualiza de acordo com que tem*/
        System.out.println("                   Register Bank");
        System.out.println("C bus andress       A bus andress       B bus andress");
        System.out.println("=====================================================");
        System.out.printf(
                "R%d = %d\t\t    R%d = %d\t\tR%d = %d\n", reg.getC(), reg
                .retonar_reg(reg.getC()),reg.getA(), reg.retonar_reg(reg.getA()),
                 reg.getB(), reg.retonar_reg(reg.getB()));//funcionando o setamento de A e B
        System.out.println("=====================================================");
        info_regis();

    }
    
    private static void info_regis() { /*banco de registro, info de registradores, ele atualiza de acordo com que tem*/
        System.out.printf("R0: %d \n", reg.getRegis_0());
        System.out.printf("R1: %d \n", reg.getRegis_1());
        System.out.printf("R2: %d \n", reg.getRegis_2());
        System.out.printf("R3: %d \n", reg.getRegis_3());
        System.out.println("=====================================================");
    }
    
    
    private static void info_mc(){ /*menu microprograma*/
        limpaTela();
        System.out.println("=====================================================");
        System.out.println("id A Addr  B Addr  ALU Op  Switch Pos  C Addr   RWAddr");
        System.out.printf("%s R%-2d\tR%d\t%d \t%d\t\tR%d\t%d\n", reg.getId_registrador(),reg.getA(), reg.getB(), reg.getAlu_op(), 0,reg.getC(),mm.getVar());
        System.out.println("=====================================================");
       
    } 
    /*--> END MENUS DO DAS FUNCOES PRINCIPAIS <--*/

    /*--> START FUNCOES DO MEMORY MAIN <--*/

    private static void add_mm() { /* Add valor em um edereco de memoria */
        System.out.print("Digite o valor a ser adicionado: ");
        int valorAdicionado = Integer.valueOf(scanner.nextLine());
        System.out.print("Enter the memory address (0-4): ");
        int mmDestino = Integer.valueOf(scanner.nextLine());
        mm.select_mm(mmDestino, valorAdicionado);
        limpaTela();
    }

    private static void remove_mm() {/* Remover valor de algum edereco de memoria */

        System.out.print("Enter the memory address id (0-4) to remove the value: ");
        int mmDestinoRemocao = Integer.valueOf(scanner.nextLine());
        mm.removeValue(mmDestinoRemocao);
        limpaTela();
    }

    private static void select_regis() {/*Selecionar o registrador para setar o valor de (id) memoria*/
        int var;
        do{
            System.out.println("Digite M0(0), M1(1), M2(2) ou M3(3), M4(4): ");
            var = Integer.valueOf(scanner.nextLine());
        }while(var < 0 || var > 4);
        mm.setVar(var);
            int r = mm.retornar_mm(var);
            System.out.print("Enter which registrar (0-3): ");
            int mm_to_reg = Integer.valueOf(scanner.nextLine());
            reg.select_reg(mm_to_reg, r);
    }
    /*--> END FUNCOES MEMORY MAIN <--*/

    private static void cria_dados_testes() throws MicroprogramaJaCadastradoException{
        inserir_micro_p(new Microprograma(3, 2, 1, 2, 0, 2));
        inserir_micro_p(new Microprograma(2, 1, 1, 2, 0, 2));
        inserir_micro_p(new Microprograma(1, 2, 1, 2, 0, 2));

    }
}
