package br.univille.poo.app.entidade;

public class Tarefa {

    private int id;
    private String titulo;
    private String descricao;
    private boolean concluido;

    public Tarefa() {

    }

    public Tarefa(String titulo, String descricao, boolean concluido) {
        this.setTitulo(titulo);
        this.setDescricao(descricao);
        this.setConcluido(concluido);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }

    @Override
    public String toString() {
        return "Tarefa{"
                + "id = " + id
                + " titulo = '" + titulo + '\''
                + ", descricao = '" + descricao + '\''
                + ", concluido = " + concluido
                + '}';
    }

}
