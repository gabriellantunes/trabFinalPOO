package br.univille.poo.app;

import br.univille.poo.app.persistencia.CriarTabelas;
import br.univille.poo.app.ui.MainView;

public class Main {

    public static void main(String[] args) {
        // instanciação da classe que cria a(s) tabela(s) no banco
        CriarTabelas criarTabela = new CriarTabelas();

        // primeiro a criação da tabela no banco
        criarTabela.criarTabelas();

        // instancia a tela principal
        MainView telaPrincipal = new MainView();
        // torna visivel essa tela
        telaPrincipal.setVisible(true);
    }

}
