package repository.registrador;

//import java
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import model.registrador.*;
import pattern.idGeneratorStrategy;
import repository.SequencialContaIdGeneratorStrategy;




public class RepositorioRegistradorLista{ //implements RepositorioRegistrador,
//Serializable{

    int somar_registros(int regis1, int regis2){
        return (regis1 + regis2);
    }

    int sub_registros(int regis1, int regis2){
        return regis1 - regis1;
    }
    int and_registros(int regis1, int regis2){
        return regis1 & regis2;
    }
    int or_registros(int regis1, int regis2){
        return regis1 | regis2;
    }
    
    //List<Registrador> registradores;
    //idGeneratorStrategy index;
 /*
    public RepositorioRegistradorLista() {
        registradores = new ArrayList<>();
        index = new SequencialContaIdGeneratorStrategy();
    }

    @Override
    public void inserir_registrador(Registrador registrador) throws 
    RegistroJaSalvoException {
        if(registrador.getId_registrador() == null) {
            registrador.setId_registrador(index.nextId());
         }
        try {
            //buscar_registrador(registrador);
            throw new RegistroJaSalvoException();

        }catch (RegistradorNoSaveException ex) {
            registradores.add(registrador);
        }


    }

    /*
     @Override
    public Aluno buscar_registrador(String registrador) throws 
    RegistradorNoSaveException {
        for(Registrador registro : registradores) { 
            if (registro.getCpf().equals(cpf_id_aluno) || aluno.getId_aluno().equals(cpf_id_aluno)) {
                //se meu raciocinio estiver certo ent?o a condi??o ? que 
                //se o cpf ou o id_aluno for igual ele vai retornar o aluno
                
                return aluno;
            }
        }
        throw new RegistradorNoSaveException();

    }

    /*
    @Override 
    public void alterar_aluno(Aluno aluno) throws RegistradorNoSaveException {
        //n?o h? necessidade de atualizar o objeto
        buscar_aluno(aluno.getCpf() );
    }

    @Override
    public void deletar_aluno(Aluno aluno) throws RegistradorNoSaveException {
        if(!alunos.remove(aluno)) { 
        //se for direrente de "alunos" remova aluno
            throw new RegistradorNoSaveException();
        }
    }

   
   

    @Override
    public List<Registrador> getAll() { 
        return new ArrayList<>(registradores);
    }

  */
    
}
