package repository.emprestimo;

//import java
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import model.emprestimo.Emprestimo;
import pattern.idGeneratorStrategy;
import repository.SequencialContaIdGeneratorStrategy;


public class RepositorioEmprestimoLista implements RepositorioEmprestimo, 
Serializable{

    List<microprograma> emprestimos;
    idGeneratorStrategy index;

    public RepositorioEmprestimoLista() {
        emprestimos = new ArrayList<>();
        index = new SequencialContaIdGeneratorStrategy();
    }

    @Override
    public void inserir_emprestimo(microprograma emprestimo) throws 
     EmprestimoJaCadastradoException {
        if(emprestimo.getId_emprestimo() == null) {
            emprestimo.setId_emprestimo(index.nextId());
        }
        if(emprestimo.getExemplar().getDisponivel() == true) {
            emprestimo.getExemplar().setDisponivel(false);
        }
        try {
            buscar_emprestimo(emprestimo.getId_emprestimo());
            throw new EmprestimoJaCadastradoException();

        }catch (EmprestimoNaoCadastradoException e) {
            emprestimos.add(emprestimo);
        }

    }

     @Override 
    public void alterar_emprestimo(microprograma emprestimo) throws
     EmprestimoNaoCadastradoException {
        //n?o h? necessidade de atualizar o objeto
        buscar_emprestimo(emprestimo.getId_emprestimo());
    }

    @Override
    public void deletar_emprestimo(microprograma emprestimo)throws 
        EmprestimoNaoCadastradoException {
        if(emprestimo.getExemplar().getDisponivel() == false){
            emprestimo.getExemplar().setDisponivel(true);
        }
        if(!emprestimos.remove(emprestimo)) { 
        //se for direrente de "alunos" remova aluno
            throw new EmprestimoNaoCadastradoException();
        }
    }

    @Override
    public microprograma  buscar_emprestimo(String id_emprestimo) throws 
    EmprestimoNaoCadastradoException {
        
        for(microprograma emprestimo : emprestimos) { 
            if (emprestimo.getId_emprestimo().equals(id_emprestimo)) {
                return emprestimo;
            }
        }
        throw new EmprestimoNaoCadastradoException();

    }

    @Override
    public List<microprograma> getAll() { 
        return new ArrayList<>(emprestimos);
    }




    
}
