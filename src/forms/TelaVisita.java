package forms;

import beans.Area;
import beans.Processo;
import beans.Usuario;
import beans.Visita;
import dao.AreaDAO;
import dao.ProcessoDAO;
import dao.UsuarioDAO;
import dao.VisitaDAO;
import java.util.List;
import javax.swing.JOptionPane;

public class TelaVisita extends javax.swing.JFrame {

    private TelaMenu telaMenu;

    public TelaVisita() {
        initComponents();
        carregarCombos();
    }

    public TelaVisita(TelaMenu telaMenu) {
        initComponents();
        this.telaMenu = telaMenu;
        carregarCombos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelVisita = new javax.swing.JPanel();
        lblArea = new javax.swing.JLabel();
        lblCadastroVisita = new javax.swing.JLabel();
        txtData = new javax.swing.JFormattedTextField();
        lblData = new javax.swing.JLabel();
        btnCadastrarVisita = new javax.swing.JButton();
        lblArea1 = new javax.swing.JLabel();
        lblArea2 = new javax.swing.JLabel();
        cbxArea = new javax.swing.JComboBox();
        cbxProcesso = new javax.swing.JComboBox();
        cbxUsuario = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela Visita");

        lblArea.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblArea.setText("Área:");

        lblCadastroVisita.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCadastroVisita.setText("Cadastro de Visitas");

        try {
            txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtData.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblData.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblData.setText("Data:");

        btnCadastrarVisita.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCadastrarVisita.setText("Cadastrar");
        btnCadastrarVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarVisitaActionPerformed(evt);
            }
        });

        lblArea1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblArea1.setText("Processo:");

        lblArea2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblArea2.setText("Usuário:");

        javax.swing.GroupLayout panelVisitaLayout = new javax.swing.GroupLayout(panelVisita);
        panelVisita.setLayout(panelVisitaLayout);
        panelVisitaLayout.setHorizontalGroup(
            panelVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVisitaLayout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(btnCadastrarVisita)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelVisitaLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(panelVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelVisitaLayout.createSequentialGroup()
                        .addGroup(panelVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblArea, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblArea2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(panelVisitaLayout.createSequentialGroup()
                        .addComponent(lblData, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)))
                .addGroup(panelVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtData)
                    .addGroup(panelVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cbxArea, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelVisitaLayout.createSequentialGroup()
                            .addComponent(lblCadastroVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(78, 78, 78))
                        .addComponent(cbxProcesso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbxUsuario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18))
        );
        panelVisitaLayout.setVerticalGroup(
            panelVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVisitaLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblCadastroVisita)
                .addGap(40, 40, 40)
                .addGroup(panelVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblArea)
                    .addComponent(cbxArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(panelVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblArea1))
                .addGap(40, 40, 40)
                .addGroup(panelVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblArea2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(panelVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblData))
                .addGap(40, 40, 40)
                .addComponent(btnCadastrarVisita)
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelVisita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelVisita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarVisitaActionPerformed
        try {
            // Pega os objetos selecionados diretamente do combo
            Area areaSelecionada = (Area) cbxArea.getSelectedItem();
            Processo processoSelecionado = (Processo) cbxProcesso.getSelectedItem();
            Usuario usuarioSelecionado = (Usuario) cbxUsuario.getSelectedItem();

            // Verifica se algum combo não foi selecionado
            if (areaSelecionada == null || processoSelecionado == null || usuarioSelecionado == null) {
                JOptionPane.showMessageDialog(this, "Selecione todos os campos!");
                return;
            }

            String dataStr = txtData.getText();

            if (!utils.Validador.validarVazios(dataStr, "Data")) {
                return;
            }

            if (!utils.Validador.validarData(dataStr, "Data")) {
                return;
            }

            dataStr = utils.Validador.retirarEspacos(dataStr);

            java.time.format.DateTimeFormatter formatter
                    = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");

            java.time.LocalDate data = java.time.LocalDate.parse(dataStr, formatter);

            // Cria objeto Visita
            Visita v = new Visita();
            v.setArea(areaSelecionada);
            v.setProcesso(processoSelecionado);
            v.setUsuario(usuarioSelecionado);
            v.setDataVisita(data);

            VisitaDAO vDao = new dao.VisitaDAO();
            vDao.cadastrar(v);

            JOptionPane.showMessageDialog(this, "Visita cadastrada com sucesso!");
            
            if (telaMenu != null) {
                telaMenu.atualizarTabela();
            }

            dispose();
            
            
            txtData.setText("");
            cbxArea.setSelectedIndex(0);
            cbxProcesso.setSelectedIndex(0);
            cbxUsuario.setSelectedIndex(0);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar visita: " + e.getMessage());
        }
    }//GEN-LAST:event_btnCadastrarVisitaActionPerformed

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
            java.util.logging.Logger.getLogger(TelaVisita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaVisita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaVisita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaVisita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaVisita().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrarVisita;
    private javax.swing.JComboBox cbxArea;
    private javax.swing.JComboBox cbxProcesso;
    private javax.swing.JComboBox cbxUsuario;
    private javax.swing.JLabel lblArea;
    private javax.swing.JLabel lblArea1;
    private javax.swing.JLabel lblArea2;
    private javax.swing.JLabel lblCadastroVisita;
    private javax.swing.JLabel lblData;
    private javax.swing.JPanel panelVisita;
    private javax.swing.JFormattedTextField txtData;
    // End of variables declaration//GEN-END:variables

    private void carregarCombos() {
        AreaDAO aDao = new AreaDAO();
        List<Area> listaArea = aDao.getArea("");

        for (Area a : listaArea) {
            cbxArea.addItem(a);
        }

        ProcessoDAO pDao = new ProcessoDAO();
        List<Processo> listaProcesso = pDao.getProcesso("");

        for (Processo p : listaProcesso) {
            cbxProcesso.addItem(p);
        }

        UsuarioDAO uDao = new UsuarioDAO();
        List<Usuario> listaUsuario = uDao.getUsuario("");

        for (Usuario u : listaUsuario) {
            cbxUsuario.addItem(u);
        }
    }

}
