

import java.io.Serializable;

public class Registrador implements Serializable {
  
  private String id_registrador;
  private int regis_0 = 0;
  private int regis_1 = 0;
  private int regis_2 = 0;
  private int regis_3 = 0;
  private int a = 0;
  private int b = 0;
  private int c = 0;
  private int sel = 0;
  private int alu_op;
  
  
  //private boolean bloqueado; vou fazer um m?todo para retorna se
  // ele est? ou n?o bloqueado


  public Registrador(int regis_0, int regis_1, int regis_2, int regis_3) {
    //this.id_aluno = id_aluno;
    this.regis_0 = regis_0;
    this.regis_1 = regis_1;
    this.regis_2 = regis_2;
    this.regis_3 = regis_3;
    this.alu_op = 0;
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

  public void setRegis_0(int value) {
    this.regis_0 = value;
  }

  public int getRegis_1() {
    return this.regis_1;
  }

  public void setRegis_1(int value) {
    this.regis_1 = value;
  }

  public int getRegis_2() {
    return this.regis_2;
  }

  public void setRegis_2(int value) {
    this.regis_2 = value;
  }

  public int getRegis_3() {
    return this.regis_3;
  }

  public void setRegis_3(int value) {
    this.regis_3 = value;
  }

  public int getA() {
    return a;
  }

  public void setA(int a) {
        this.a = a;
    }

  public int getB() {
        return b;
    }

  public void setB(int b) {
        this.b = b;
    }

    
  public int getC() {//get de 
    return this.c;
  }

  public void setC(int c) {
    this.c = c;
  }
  public int getSel() {
    return this.sel;
  }

  public void setSel(int sel) {
    this.sel = sel;
  }

  public void remove_all(){
    setRegis_0(0);
    setRegis_1(0);
    setRegis_2(0);
    setRegis_3(0);
  }
 

  public void somar_registros(int regDestino, int regis1, int regis2) {
    int valor = regis1 + regis2;
    select_reg(regDestino, valor);
    setAlu_op(0);
}


  public void sub_registros(int regDestino, int regis1, int regis2){
    int valor = regis1 - regis2;
    select_reg(regDestino, valor);
    setAlu_op(4);
    
  }

  public void and_registros(int regDestino,int regis1, int regis2){
    int valor = regis1 & regis2;
    select_reg(regDestino, valor);
    setAlu_op(3);
  }
  public void or_registros(int regDestino,int regis1, int regis2){
    int valor = regis1 | regis2;
    select_reg(regDestino, valor);
    setAlu_op(1);
  }

  public void removeValue(int regDestino) {
    select_reg(regDestino, 0);
    
}

//setar valores e add em algum registrador
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

//z = mm.select_regis_mm(b);
//reg.select_reg(y,z);


//retornar um resgitrador que um usuario escolher
public int retonar_reg(int regis) {
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

//implementação do caos
  public int getAlu_op() {
    return this.alu_op;
  }

  public void setAlu_op(int alu_op) {
    this.alu_op = alu_op;
  }


 

}

