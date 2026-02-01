package forms;

import dao.ProcessoDAO;
import javax.swing.JOptionPane;

public class TelaProcesso extends javax.swing.JFrame {

    public TelaProcesso() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelProcesso = new javax.swing.JPanel();
        lblDigitarProcesso = new javax.swing.JLabel();
        txtProcesso = new javax.swing.JTextField();
        btnCadastrarProcesso = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela Processo");

        lblDigitarProcesso.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDigitarProcesso.setText("Digite o processo que quer cadastrar:");

        btnCadastrarProcesso.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCadastrarProcesso.setText("Cadastrar");
        btnCadastrarProcesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarProcessoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelProcessoLayout = new javax.swing.GroupLayout(panelProcesso);
        panelProcesso.setLayout(panelProcessoLayout);
        panelProcessoLayout.setHorizontalGroup(
            panelProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelProcessoLayout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(panelProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDigitarProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
            .addGroup(panelProcessoLayout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(btnCadastrarProcesso)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelProcessoLayout.setVerticalGroup(
            panelProcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProcessoLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(lblDigitarProcesso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtProcesso)
                .addGap(58, 58, 58)
                .addComponent(btnCadastrarProcesso)
                .addGap(93, 93, 93))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelProcesso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarProcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarProcessoActionPerformed
        String nomeProcesso = txtProcesso.getText().trim();

        // Validação: campo não pode estar vazio
        if (nomeProcesso.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite o nome do processo!");
            txtProcesso.requestFocus();
            return;
        }

        // Cria o objeto Processo
        beans.Processo processo = new beans.Processo();
        processo.setNomeProcesso(nomeProcesso);

        // Chama o DAO para cadastrar
        ProcessoDAO pDao = new dao.ProcessoDAO();
        try {
            pDao.cadastrar(processo);
            JOptionPane.showMessageDialog(this, "Processo cadastrado com sucesso!");
            txtProcesso.setText("");
            txtProcesso.requestFocus();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar processo: " + e.getMessage());
        }
    }//GEN-LAST:event_btnCadastrarProcessoActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaProcesso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaProcesso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaProcesso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaProcesso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaProcesso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrarProcesso;
    private javax.swing.JLabel lblDigitarProcesso;
    private javax.swing.JPanel panelProcesso;
    private javax.swing.JTextField txtProcesso;
    // End of variables declaration//GEN-END:variables

}
