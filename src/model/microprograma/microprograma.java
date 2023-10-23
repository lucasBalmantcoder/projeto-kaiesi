package model.microprograma;

import java.io.Serializable;
import java.time.LocalDateTime;

import model.exemplar.Exemplar;
import model.historico.Historico;
import model.historico.ItemHistorico;
import model.registrador.Aluno;
import repository.exemplar.ExemplarIndisponivelExeption;


public class microprograma  implements Serializable  {
    private String id_microprograma; //idenx auto de emprestimo 
    
    //private Exemplar exemplar;
    //private boolean devolvido; //s? pode ser emprestado se j? tive sido devolvido.
    //private Historico historico;

    public microprograma(String id_microprograma) {
        this.id_microprograma = id_microprograma;
        //this.devolvido = devolvido;
    }





    

    public String getId_microprograma() {
        return this.id_microprograma;
    }

    public void setId_emprestimo(String id_microprograma) {
        this.id_microprograma = id_microprograma;
    }





}
