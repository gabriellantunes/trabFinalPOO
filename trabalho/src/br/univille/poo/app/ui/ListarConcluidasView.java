package br.univille.poo.app.ui;

import br.univille.poo.app.controle.TarefaController;
import br.univille.poo.app.entidade.Tarefa;
import java.awt.Dimension;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class ListarConcluidasView extends javax.swing.JInternalFrame {

    private static ListarConcluidasView listarView;
    private List<Tarefa> tarefas;
    private Tarefa tarefa;
    private TarefaController controle;
    private DefaultListModel model;

    public ListarConcluidasView() {
        initComponents();
        controle = new TarefaController();
        this.popularLista();
    }

    public static ListarConcluidasView getInstancia() {
        if (listarView == null) {
            listarView = new ListarConcluidasView();
        }
        return listarView;
    }

    private void popularLista() {
        tarefas = controle.listarTarefas();
        model = new DefaultListModel();
        for (Tarefa i : tarefas) {
            if (i.isConcluido()) {
                String item = i.getId() + ": " + i.getTitulo();
                model.addElement(item);
            }
        }
        jListTarefas.setModel(model);
    }
    
    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jListTarefas = new javax.swing.JList<>();
        jToggleButtonSelecionar = new javax.swing.JToggleButton();
        jTextFieldTitulo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldDescricao = new javax.swing.JTextField();
        jToggleButtonExcluir = new javax.swing.JToggleButton();

        setClosable(true);

        jListTarefas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jListTarefas);

        jToggleButtonSelecionar.setText("SELECIONAR");
        jToggleButtonSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonSelecionarActionPerformed(evt);
            }
        });

        jTextFieldTitulo.setEditable(false);

        jLabel3.setText("TÍTULO:");

        jLabel2.setText("DESCRIÇÃO:");

        jTextFieldDescricao.setEditable(false);

        jToggleButtonExcluir.setText("EXCLUIR");
        jToggleButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jToggleButtonSelecionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jTextFieldTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel2))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jToggleButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jToggleButtonExcluir)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToggleButtonSelecionar)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButtonSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonSelecionarActionPerformed
        // mesma coisa do outro método na ListagemTarefasView
        String a = jListTarefas.getSelectedValue().toString();
        String[] arr = a.split(":", 2);
        int id = Integer.parseInt(arr[0]);

        tarefa = controle.listarTarefaId(id);

        jTextFieldDescricao.setText(this.tarefa.getDescricao());
        jTextFieldTitulo.setText(this.tarefa.getTitulo());
    }//GEN-LAST:event_jToggleButtonSelecionarActionPerformed

    private void jToggleButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonExcluirActionPerformed
        // exclui uma tarefa do bando
        boolean result = controle.excluirTarefa(tarefa.getId());
        
        // imprime o resultado da exclusão
        if(result) {
            JOptionPane.showMessageDialog(null, "Tarefa excluida com sucesso");
        }else {
            JOptionPane.showMessageDialog(null, "Erro ao excluir a tarefa");
        }
        
        // atualiza a lista
        model.clear();
        this.popularLista();
        jTextFieldDescricao.setText("");
        jTextFieldTitulo.setText("");
    }//GEN-LAST:event_jToggleButtonExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jListTarefas;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFieldDescricao;
    private javax.swing.JTextField jTextFieldTitulo;
    private javax.swing.JToggleButton jToggleButtonExcluir;
    private javax.swing.JToggleButton jToggleButtonSelecionar;
    // End of variables declaration//GEN-END:variables
}
