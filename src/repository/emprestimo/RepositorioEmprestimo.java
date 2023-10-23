package repository.emprestimo;

import java.util.List;

import model.emprestimo.Emprestimo;

public interface RepositorioEmprestimo {

    void inserir_emprestimo(microprograma emprestimo) throws EmprestimoJaCadastradoException;

    void deletar_emprestimo(microprograma emprestimo) throws EmprestimoNaoCadastradoException;

    void alterar_emprestimo(microprograma emprestimo) throws EmprestimoNaoCadastradoException;

    microprograma buscar_emprestimo(String id_emprestimo) throws EmprestimoNaoCadastradoException;





    List<microprograma> getAll();
}
