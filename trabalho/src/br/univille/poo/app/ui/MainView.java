package br.univille.poo.app.ui;

import br.univille.poo.app.servico.GerenteJanela;

public class MainView extends javax.swing.JFrame {

    GerenteJanela gerenteJanela;

    // aqui temos um menu simples para abrir as três funcionalidades do sistema
    public MainView() {
        setTitle("Tarefas");
        initComponents();
        this.gerenteJanela = new GerenteJanela(jDesktopPane);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuTarefa = new javax.swing.JMenu();
        jMenuItemInserir = new javax.swing.JMenuItem();
        jMenuItemListar = new javax.swing.JMenuItem();
        jMenuItemListarConcluidas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPaneLayout = new javax.swing.GroupLayout(jDesktopPane);
        jDesktopPane.setLayout(jDesktopPaneLayout);
        jDesktopPaneLayout.setHorizontalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 626, Short.MAX_VALUE)
        );
        jDesktopPaneLayout.setVerticalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 429, Short.MAX_VALUE)
        );

        jMenuTarefa.setText("Tarefas");

        jMenuItemInserir.setText("Inserir tarefa");
        jMenuItemInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemInserirActionPerformed(evt);
            }
        });
        jMenuTarefa.add(jMenuItemInserir);

        jMenuItemListar.setText("Listar tarefas");
        jMenuItemListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListarActionPerformed(evt);
            }
        });
        jMenuTarefa.add(jMenuItemListar);

        jMenuItemListarConcluidas.setText("Listar concluidas");
        jMenuItemListarConcluidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListarConcluidasActionPerformed(evt);
            }
        });
        jMenuTarefa.add(jMenuItemListarConcluidas);

        jMenuBar1.add(jMenuTarefa);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemInserirActionPerformed
        gerenteJanela.abrirJanela(InserirTarefaView.getInstancia());
        InserirTarefaView.getInstancia().setPosicao();
    }//GEN-LAST:event_jMenuItemInserirActionPerformed

    private void jMenuItemListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListarActionPerformed
        gerenteJanela.abrirJanela(ListagemTarefasView.getInstancia());
        ListagemTarefasView.getInstancia().setPosicao();
    }//GEN-LAST:event_jMenuItemListarActionPerformed

    private void jMenuItemListarConcluidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListarConcluidasActionPerformed
        gerenteJanela.abrirJanela(ListarConcluidasView.getInstancia());
        ListarConcluidasView.getInstancia().setPosicao();
    }//GEN-LAST:event_jMenuItemListarConcluidasActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemInserir;
    private javax.swing.JMenuItem jMenuItemListar;
    private javax.swing.JMenuItem jMenuItemListarConcluidas;
    private javax.swing.JMenu jMenuTarefa;
    // End of variables declaration//GEN-END:variables
}
