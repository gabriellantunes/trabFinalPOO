package br.univille.poo.app.ui;

import br.univille.poo.app.controle.TarefaController;
import br.univille.poo.app.entidade.Tarefa;
import java.awt.Dimension;
import javax.swing.JOptionPane;

public class InserirTarefaView extends javax.swing.JInternalFrame {

    private static InserirTarefaView inserirView;

    public InserirTarefaView() {
        initComponents();
    }

    public static InserirTarefaView getInstancia() {
        if (inserirView == null) {
            inserirView = new InserirTarefaView();
        }
        return inserirView;
    }

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jToggleButtonCadastrar = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldTitulo = new javax.swing.JTextField();
        jTextFieldDescricao = new javax.swing.JTextField();

        setClosable(true);

        jLabel2.setText("DESCRIÇÃO:");

        jToggleButtonCadastrar.setLabel("CADASTRAR");
        jToggleButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonCadastrarActionPerformed(evt);
            }
        });

        jLabel3.setText("TÍTULO:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(31, 31, 31)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jTextFieldTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jToggleButtonCadastrar)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(174, 174, 174))))))
                .addContainerGap(18, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToggleButtonCadastrar)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonCadastrarActionPerformed
        // salva oque o usuario digitou em duas strings
        String titulo = jTextFieldTitulo.getText();
        String descricao = jTextFieldDescricao.getText();

        // caso alguma delas esteja vazia informe o usuario
        if (titulo.equals("") || descricao.equals("")) {
            JOptionPane.showMessageDialog(null, "Algum dos valores está em branco");
        } else {
            // caso contrario instancia a camada de controle
            TarefaController controleTarefa = new TarefaController();
            
            // insere no bando e armazena o resultado
            boolean resultado = controleTarefa.inserirTarefa(titulo, descricao, false);
            // imprime se a inserção foi bem sucedida ou não
            if (resultado) {
                JOptionPane.showMessageDialog(null, "Tarefa inserida com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao inserir a tarefa");
            }
            jTextFieldTitulo.setText("");
            jTextFieldDescricao.setText("");
        }
    }//GEN-LAST:event_jToggleButtonCadastrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextFieldDescricao;
    private javax.swing.JTextField jTextFieldTitulo;
    private javax.swing.JToggleButton jToggleButtonCadastrar;
    // End of variables declaration//GEN-END:variables

}
