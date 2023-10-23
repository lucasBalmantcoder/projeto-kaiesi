package model.aluno;

import java.io.Serializable;

public class Aluno implements Serializable {
  
  private String id_aluno;
  private String nome;
  private String cpf;
  private String endereco;
  private String contato;
  
  //private boolean bloqueado; vou fazer um método para retorna se
  // ele está ou não bloqueado


public Aluno(String nome, String cpf, String matricula, String endereco,
String contato) {

  //retirei matricula para fazer um teste de agregração, não sei se vai dar
    this.nome = nome;
    this.cpf = cpf;
    //this.matricula = matricula;
    this.endereco = endereco;
    this.contato = contato;
}

  public String getId_aluno(){
    return this.id_aluno;
  }
  public void setId_aluno( String id_numero) {
    this.id_aluno = id_numero;
  }



  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return this.cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getEndereco() {
    return this.endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public String getContato() {
    return this.contato;
  }

  public void setContato(String contato) {
    this.contato = contato;
  }

  public String toString() {//não está sendo usada
    return nome;
  }

}
