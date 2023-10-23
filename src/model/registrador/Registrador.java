package model.registrador;

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
