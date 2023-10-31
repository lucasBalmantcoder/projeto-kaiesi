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
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
//import facade.Projetokaiesi;

public class App {

    // chamada de Projetokaise
    // private static Projetokaiesi facade;
    private static Scanner scanner = new Scanner(System.in);
    private static Registrador reg = new Registrador(20, 30, 50, 1);
    private static Memory_main mm = new Memory_main(5, 4, 3, 2, 0);
    
    private List<Microprograma>lista_micro = new ArrayList<>();//lista de objetos


    public static void main(String[] args) {
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
                    case 2: microprograma_memory(); break;
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
                case 4: select_reg0_re1_reg2_reg3(); limpaTela(); break;/* Selecionar para onde vai o valor contido na id de memoria */
                case 5: menu_ini(); break;/*Saida para o menu inicial*/
                case 6: select_c(); limpaTela(); break;
                case 0: mm.remove_all(); limpaTela(); break;
                default: break;
            }
        } while (opcao != 5);
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

    private static void menu_ini() { /*banco de registro, ele atualiza de acordo com que tem*/
        System.out.println("                   Register Bank");
        System.out.println("C bus andress       A bus andress       B bus andress");
        System.out.println("=====================================================");
        System.out.printf(
                "R%d = %d\t\t    R%d = %d\t\tR%d = %d\n", reg.getC(), reg
                        .retonar_reg(reg.getC()),
                reg.getA(), reg.retonar_reg(reg.getA()), reg.getB(), reg.retonar_reg(reg.getB()));/*
                                                                                                   * funcionando o
                                                                                                   * setamento de
                                                                                                   * valores em 'A' e
                                                                                                   * 'B'
                                                                                                   */
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
    
    private static void microprograma_memory(){ /*menu microprograma*/
        limpaTela();
        String[] s = { "(+)", "(-)", "(and)", "(or)" };
        System.out.println("========================================================================");
        System.out.println("A Addr:     B Addr:     ALU Op:     Switch Pos:     C Addr:     RW Addr: ");
        System.out.printf("  R%d\t      R%d\t  %s\t\t\t\tR%d\tRW%d\n", reg.getA(), reg.getB(), s[reg.getSel()], reg.getC(),mm.getVar());
        System.out.println("========================================================================");
        int i = scanner.nextInt();
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

    private static void select_reg0_re1_reg2_reg3() {/*Selecionar o registrador para setar o valor de (id) memoria*/
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
}
