package br.univille.poo.app.persistencia;

import br.univille.poo.app.entidade.Tarefa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TarefaDAO extends BaseDAO {

    // método para inserir uma tarefa no banco
    public boolean inserir(Tarefa tarefa) {
        // string com a query
        String sql = "insert into tarefa(titulo, descricao, concluido) values(?, ? ,?)";
        try ( Connection c = obterConexao();  PreparedStatement p = c.prepareStatement(sql)) {
            // insere os valores nescessarios na query
            p.setString(1, tarefa.getTitulo());
            p.setString(2, tarefa.getDescricao());
            p.setBoolean(3, tarefa.isConcluido());
            p.execute();
            // caso funcione retorna true
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir tarefa");
            e.printStackTrace();
            // caso de algum erro retorna false
            return false;
        }
    }

    // método para atualizar algum valor já cadastrado no banco
    public boolean atualizar(Tarefa tarefa) {
        // string com a query
        String sql = "update  tarefa set titulo=?, concluido=?, descricao=? where id=?";
        try ( Connection c = obterConexao();  PreparedStatement p = c.prepareStatement(sql)) {
            // insere os valore nescessarios na query
            p.setString(1, tarefa.getTitulo());
            p.setBoolean(2, tarefa.isConcluido());
            p.setString(3, tarefa.getDescricao());
            p.setInt(4, tarefa.getId());
            p.execute();
            // caso funcione retorna true
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar tarefa");
            e.printStackTrace();
            // caso de algum erro retorna false
            return false;
        }
    }

    // método para excluir uma tarefa apartir do id
    public boolean excluir(int id) {
        // string com a query
        String sql = "delete from tarefa where id=?";
        try ( Connection c = obterConexao();  PreparedStatement p = c.prepareStatement(sql)) {
            // insere o valor nescesario na query
            p.setInt(1, id);
            p.execute();
            // caso funcione retorna true
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir a tarefa");
            e.printStackTrace();
            // caso de algum erro retorna false
            return false;
        }
    }

    // método para listar uma tarefa apartir do id
    public Tarefa listarId(int id) {
        // string com a query
        String sql = "select * from tarefa where id=?";
        try ( Connection c = obterConexao();  PreparedStatement p = c.prepareStatement(sql)) {
            // insere o valor nescessario na query
            p.setInt(1, id);
            ResultSet resultSet = p.executeQuery();
            while (resultSet.next()) {
                // adiciona o resultaldo em um objeto de Tarefa
                Tarefa tarefa = new Tarefa();
                tarefa.setId(resultSet.getInt("id"));
                tarefa.setTitulo(resultSet.getString("titulo"));
                tarefa.setConcluido(resultSet.getBoolean("concluido"));
                tarefa.setDescricao(resultSet.getString("descricao"));
                // retorna esse objeto
                return tarefa;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao obter todas as tarefas");
            e.printStackTrace();
            // caso de algum erro retorna null
        }
        return null;
    }

    // método para retornar todas as tarefas
    public List<Tarefa> obterTodos() {
        // List para receber as tarefas
        List<Tarefa> lista = new ArrayList<>();
        // string com a query
        String sql = "select * from tarefa";
        try ( Connection c = obterConexao();  PreparedStatement p = c.prepareStatement(sql)) {
            // aramazen os resultados
            ResultSet resultSet = p.executeQuery();
            while (resultSet.next()) {
                // interação para adicionar os resultados em uma instancia de Tarefa e depois na List
                Tarefa tarefa = new Tarefa();
                tarefa.setId(resultSet.getInt("id"));
                tarefa.setTitulo(resultSet.getString("titulo"));
                tarefa.setConcluido(resultSet.getBoolean("concluido"));
                tarefa.setDescricao(resultSet.getString("descricao"));

                lista.add(tarefa);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao obter todas as tarefas");
            e.printStackTrace();
        }
        // retorna a lista
        return lista;
    }

}
