

import java.io.Serializable;

public class Registrador implements Serializable {
  
  private String id_registrador;
  private int regis_0 = 0;
  private int regis_1 = 0;
  private int regis_2 = 0;
  private int regis_3 = 0;
  
  //private boolean bloqueado; vou fazer um m?todo para retorna se
  // ele est? ou n?o bloqueado


  public Registrador(int regis_0, int regis_1, int regis_2, int regis_3) {
    //this.id_aluno = id_aluno;
    this.regis_0 = regis_0;
    this.regis_1 = regis_1;
    this.regis_2 = regis_2;
    this.regis_3 = regis_3;
  }


  public String getId_registrador() {
    return this.id_registrador;
  }
  
  public void setId_registrador(String id_registrador) {
    this.id_registrador = id_registrador;
  }

  public int getRegis_0() {
    return this.regis_0;
  }

  public void setRegis_0(int regis_0) {
    this.regis_0 = regis_0;
  }

  public int getRegis_1() {
    return this.regis_1;
  }

  public void setRegis_1(int regis_1) {
    this.regis_1 = regis_1;
  }

  public int getRegis_2() {
    return this.regis_2;
  }

  public void setRegis_2(int regis_2) {
    this.regis_2 = regis_2;
  }

  public int getRegis_3() {
    return this.regis_3;
  }

  public void setRegis_3(int regis_3) {
    this.regis_3 = regis_3;
  }

  public void somar_registros(int regDestino, int regis1, int regis2) {
    int valor = regis1 + regis2;
    select_reg(regDestino, valor);
}


  public void sub_registros(int regDestino, int regis1, int regis2){
    int valor = regis1 - regis2;
    select_reg(regis2, valor);
  }

  public void and_registros(int regDestino,int regis1, int regis2){
    int valor = regis1 & regis2;
    select_reg(regis2, valor);
  }
  public void or_registros(int regDestino,int regis1, int regis2){
    int valor = regis1 | regis2;
    select_reg(regis2, valor);
  }

  public void removeValue(int regDestino) {
    select_reg(regDestino, 0);
}

public void select_reg(int regis_x, int valor) {
    if (regis_x == 0) {
        setRegis_0(valor);
    } else if (regis_x == 1) {
        setRegis_1(valor);
    } else if (regis_x == 2) {
        setRegis_2(valor);
    } else if (regis_x == 3) {
        setRegis_3(valor);
    }
}

public int select_reg(int regis) {
    int a = 0;
    if (regis == 0) {
       a = getRegis_0();
    } else if (regis == 1) {
        a = getRegis_1();
    } else if (regis == 2) {
        a = getRegis_2();
    } else if (regis == 3) {
        a =getRegis_3();
    }
    return a;
}

//talvez use para alguma peripecia aí
/* 
  public String getId_aluno(){
    return this.id_aluno;
  }
  public void setId_aluno( String id_numero) {
    this.id_aluno = id_numero;
  }


  public String toString() {//não está sendo usada
    return nome;
  }
*/


}
