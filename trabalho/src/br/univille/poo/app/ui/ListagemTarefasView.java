package br.univille.poo.app.ui;

import br.univille.poo.app.controle.TarefaController;
import br.univille.poo.app.entidade.Tarefa;
import java.awt.Dimension;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class ListagemTarefasView extends javax.swing.JInternalFrame {

    private List<Tarefa> tarefas;
    private static ListagemTarefasView listarView;
    private Tarefa tarefa;
    private TarefaController controle;
    private DefaultListModel model;

    public ListagemTarefasView() {
        initComponents();
        controle = new TarefaController();
        this.popularLista();
    }

    // método para instanciar a tela
    public static ListagemTarefasView getInstancia() {
        if (listarView == null) {
            listarView = new ListagemTarefasView();
        }
        return listarView;
    }

    // metodo para poupular a lista com os dados do banco
    private void popularLista() {
        tarefas = controle.listarTarefas();
        model = new DefaultListModel();
        // adiciona os dados do banco na lista
        for (Tarefa i : tarefas) {
            if (!i.isConcluido()) {
                String item = i.getId() + ": " + i.getTitulo();
                model.addElement(item);
            }
        }
        // seta o modelo
        jListTarefas.setModel(model);
    }

    // metodo para abrir a janela no meio, presente em todas as views internas
    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jListTarefas = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldTitulo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldDescricao = new javax.swing.JTextField();
        jToggleButtonSelecionar = new javax.swing.JToggleButton();
        jToggleButtonAlterar = new javax.swing.JToggleButton();
        jToggleButtonConcluir = new javax.swing.JToggleButton();

        setClosable(true);

        jListTarefas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jListTarefas);

        jLabel3.setText("TÍTULO:");

        jLabel2.setText("DESCRIÇÃO:");

        jToggleButtonSelecionar.setText("SELECIONAR");
        jToggleButtonSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonSelecionarActionPerformed(evt);
            }
        });

        jToggleButtonAlterar.setText("ALTERAR DADOS");
        jToggleButtonAlterar.setActionCommand("ALTERAR DADOS");
        jToggleButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonAlterarActionPerformed(evt);
            }
        });

        jToggleButtonConcluir.setText("CONCLUIR");
        jToggleButtonConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonConcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jToggleButtonSelecionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jToggleButtonAlterar)
                        .addGap(18, 18, 18)
                        .addComponent(jToggleButtonConcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButtonAlterar)
                    .addComponent(jToggleButtonConcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToggleButtonSelecionar)
                .addGap(0, 16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButtonSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonSelecionarActionPerformed
        // seleciona a tarefa
        String a = jListTarefas.getSelectedValue().toString();
        String[] arr = a.split(":", 2);
        int id = Integer.parseInt(arr[0]);
        
        // busca no bando a tarefa correspondete ao id
        tarefa = controle.listarTarefaId(id);
        
        // coloca o texto do banco nos campos
        jTextFieldDescricao.setText(this.tarefa.getDescricao());
        jTextFieldTitulo.setText(this.tarefa.getTitulo());
    }//GEN-LAST:event_jToggleButtonSelecionarActionPerformed

    private void jToggleButtonConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonConcluirActionPerformed
        // marca concluido a tarefa
        tarefa.setConcluido(true);
        
        // atualiza no banco
        boolean result = controle.concluirTarefa(tarefa);
        if (result) {
            JOptionPane.showMessageDialog(null, "Tarefa concluida com sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao concluir a tarefa");
        }

        // atualiza a lista de tarefas
        model.clear();
        this.popularLista();
        jTextFieldDescricao.setText("");
        jTextFieldTitulo.setText("");
    }//GEN-LAST:event_jToggleButtonConcluirActionPerformed

    private void jToggleButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonAlterarActionPerformed
        // alterar a tarefa do banco
        tarefa.setTitulo(jTextFieldTitulo.getText());
        tarefa.setDescricao(jTextFieldDescricao.getText());
        
        // altera a tarefa no bando e informa se foi sucedido ou não
        boolean result = controle.alterarTarefa(tarefa);
        if (result) {
            JOptionPane.showMessageDialog(null, "Tarefa alterada com sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao alterar a tarefa");
        }
        
        // atualiza a lista
        model.clear();
        this.popularLista();
        jTextFieldDescricao.setText("");
        jTextFieldTitulo.setText("");
    }//GEN-LAST:event_jToggleButtonAlterarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jListTarefas;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFieldDescricao;
    private javax.swing.JTextField jTextFieldTitulo;
    private javax.swing.JToggleButton jToggleButtonAlterar;
    private javax.swing.JToggleButton jToggleButtonConcluir;
    private javax.swing.JToggleButton jToggleButtonSelecionar;
    // End of variables declaration//GEN-END:variables
}
