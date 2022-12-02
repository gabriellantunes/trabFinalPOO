package br.univille.poo.app.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class CriarTabelas {

    // string com o script de criação da tabela
    private final static String CRIAR_TABELA_TAREFA = """
            create table if not exists tarefa(
            	id integer primary key auto_increment,
                titulo varchar(80),
                descricao  varchar(500),
                concluido  boolean
            )
            """;

    // método para criação da tabela
    public static void criarTabelas() {
        List<String> lista = new ArrayList<>();
        lista.add(CRIAR_TABELA_TAREFA);
        // executa o comando de criação das tabelas
        for (String comando : lista) {
            try ( Connection c = FabricaConexao.getConnection();  PreparedStatement p = c.prepareStatement(comando)) {
                p.execute();
            } catch (Exception e) {
                System.out.println("Erro ao criar a tabela");
                e.printStackTrace();
            }
        }

    }

}
