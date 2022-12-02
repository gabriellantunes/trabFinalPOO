package br.univille.poo.app.controle;

import br.univille.poo.app.entidade.Tarefa;
import br.univille.poo.app.persistencia.TarefaDAO;
import java.util.List;

public class TarefaController {

    private TarefaDAO tarefaDAO;
    private Tarefa tarefa;

    // construtor do controller, aqui é instanciado um objeto de tarefaDAO
    public TarefaController() {
        tarefaDAO = new TarefaDAO();
    }

    // método para inserir uma tarefa no banco
    public boolean inserirTarefa(String titulo, String descricao, boolean concluido) {
        // é instanciado o objeto tarefa com os valores a ser inseridos no BD
        tarefa = new Tarefa(titulo, descricao, concluido);
        // é feito a chamada do metodo que insere no bando dentro do DAO
        boolean resultado = tarefaDAO.inserir(tarefa);
        // caso o metodo retorne verdadeiro retorna verdadeiro, caso contrario retorna falso
        if (resultado) {
            return true;
        }
        return false;
    }

    // método para listar todas as tarefas no banco
    public List<Tarefa> listarTarefas() {
        // retorna uma lista com todos os elementos
        return tarefaDAO.obterTodos();
    }

    // método para listar a tarefa apartir de um id
    public Tarefa listarTarefaId(int id) {
        // retorna uma tarefa que foi buscada pelo id no bando de dados
        return tarefaDAO.listarId(id);
    }

    // método para concluir a tarefa
    public boolean concluirTarefa(Tarefa tarefa) {
        // retorna verdadeiro ou falso
        return tarefaDAO.atualizar(tarefa);
    }

    // método para excluir uma tafera do banco apartir do id
    public boolean excluirTarefa(int id) {
        // retorna verdadeiro ou falso
        return tarefaDAO.excluir(id);
    }

    // método para alterar uma tarefa no banco
    public boolean alterarTarefa(Tarefa tarefa) {
        // retorna verdadeiro ou falso
        return tarefaDAO.atualizar(tarefa);
    }
}
