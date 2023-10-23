package model.emprestimo;

import java.io.Serializable;
import java.time.LocalDateTime;

import model.aluno.Aluno;
import model.exemplar.Exemplar;
import model.historico.Historico;
import model.historico.ItemHistorico;
import repository.exemplar.ExemplarIndisponivelExeption;


public class Emprestimo  implements Serializable  {
    private String id_emprestimo; //idenx auto de emprestimo 
    private Aluno aluno;
    private Exemplar exemplar;
    private boolean devolvido; //só pode ser emprestado se já tive sido devolvido.
    private Historico historico;

    public Emprestimo(Aluno aluno, Exemplar exemplar, boolean devolvido) {
        //this.id_emprestimo = id_emprestimo;
        this.aluno = aluno;
        this.exemplar = exemplar;
        this.devolvido = devolvido;
    }

    public Emprestimo(Aluno aluno, Exemplar exemplar) {
        //this.id_emprestimo = id_emprestimo;
        this.aluno = aluno;
        this.exemplar = exemplar;
        //this.devolvido = devolvido;
    }


    public void emprestar_exemplar(Exemplar exemplar, Historico historico) throws 
    ExemplarIndisponivelExeption  {
        if(exemplar.getDisponivel() == true) {
            exemplar.setDisponivel(false);
            this.historico.addItem(new ItemHistorico(LocalDateTime.now(), "Emprestimo", getNomeExemplar() ));
        }else{ 
            throw new ExemplarIndisponivelExeption();
       }
        
    }

    public void devolver(Exemplar exemplar, Historico historico) throws 
    ExemplarIndisponivelExeption  {
        if(exemplar.getDisponivel() == false) {
            exemplar.setDisponivel(false);
        }else{ 
            throw new ExemplarIndisponivelExeption();
       }
        
    }


    

    public String getId_emprestimo() {
        return this.id_emprestimo;
    }

    public void setId_emprestimo(String id_emprestimo) {
        this.id_emprestimo = id_emprestimo;
    }

    public Aluno getAluno() {
        return this.aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Exemplar getExemplar() {
        return this.exemplar;
    }

    //Método responsvel por retornar o nome do exemplar
    public String getNomeExemplar() {
        return this.getExemplar().getLivro().getTitulo();
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public String isDevolvido() {
        if(getDevolvido() == true){
            return "Sim";
        }else {
            return "Não";
        }
    }

    public boolean getDevolvido() {
        return this.devolvido;
    }

    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }




}
