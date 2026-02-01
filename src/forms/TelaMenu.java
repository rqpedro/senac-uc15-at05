package forms;

import beans.Usuario;
import dao.VisitaDAO;
import beans.Visita;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaMenu extends javax.swing.JFrame {

    public TelaMenu() {
        initComponents();
        carregarTabelaVisitas();
    }

    public TelaMenu(Usuario usuarioLogado) {
        initComponents();

        // Verifica o perfil do usuário
        if (usuarioLogado.getPerfil().getPerfil().equals("AVALIADOR")) {
            btnCadastrarArea.setVisible(false);
            btnCadastrarProcesso.setVisible(false);
            btnCadastrarVisita.setVisible(false);
            btnExcluirVisita.setVisible(false);
        } else {
            btnCadastrarArea.setVisible(true);
            btnCadastrarProcesso.setVisible(true);
            btnCadastrarVisita.setVisible(true);
            btnExcluirVisita.setVisible(true);
        }

        carregarTabelaVisitas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMenuGeral = new javax.swing.JPanel();
        menu = new javax.swing.JLabel();
        panelTabelaMenu = new javax.swing.JPanel();
        scrollTabela = new javax.swing.JScrollPane();
        tblVisitas = new javax.swing.JTable();
        tabelaMenu = new javax.swing.JLabel();
        btnExcluirVisita = new javax.swing.JButton();
        panelAtividadesMenu = new javax.swing.JPanel();
        btnCadastrarArea = new javax.swing.JButton();
        btnCadastrarProcesso = new javax.swing.JButton();
        btnCadastrarVisita = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");

        panelMenuGeral.setToolTipText("Painel Menu");

        menu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        menu.setText("Menu");

        javax.swing.GroupLayout panelMenuGeralLayout = new javax.swing.GroupLayout(panelMenuGeral);
        panelMenuGeral.setLayout(panelMenuGeralLayout);
        panelMenuGeralLayout.setHorizontalGroup(
            panelMenuGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuGeralLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(273, 273, 273))
        );
        panelMenuGeralLayout.setVerticalGroup(
            panelMenuGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuGeralLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(menu)
                .addContainerGap())
        );

        panelTabelaMenu.setBackground(new java.awt.Color(204, 204, 204));
        panelTabelaMenu.setBorder(javax.swing.BorderFactory.createTitledBorder("Painel Tabela"));
        panelTabelaMenu.setToolTipText("Painel Atividades");

        tblVisitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id Visita", "Área", "Processo", "Usuário", "Data"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        scrollTabela.setViewportView(tblVisitas);

        tabelaMenu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tabelaMenu.setText("Tabela de visitas");

        btnExcluirVisita.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExcluirVisita.setText("Excluir");
        btnExcluirVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirVisitaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTabelaMenuLayout = new javax.swing.GroupLayout(panelTabelaMenu);
        panelTabelaMenu.setLayout(panelTabelaMenuLayout);
        panelTabelaMenuLayout.setHorizontalGroup(
            panelTabelaMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTabelaMenuLayout.createSequentialGroup()
                .addContainerGap(151, Short.MAX_VALUE)
                .addComponent(tabelaMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTabelaMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelTabelaMenuLayout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(btnExcluirVisita)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTabelaMenuLayout.setVerticalGroup(
            panelTabelaMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTabelaMenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tabelaMenu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExcluirVisita)
                .addContainerGap())
        );

        panelAtividadesMenu.setBackground(new java.awt.Color(204, 204, 204));
        panelAtividadesMenu.setBorder(javax.swing.BorderFactory.createTitledBorder("Painel de Atividades"));
        panelAtividadesMenu.setToolTipText("Panel Atividades");

        btnCadastrarArea.setBackground(new java.awt.Color(0, 153, 153));
        btnCadastrarArea.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCadastrarArea.setText("Cadastrar Área");
        btnCadastrarArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarAreaActionPerformed(evt);
            }
        });

        btnCadastrarProcesso.setBackground(new java.awt.Color(255, 51, 51));
        btnCadastrarProcesso.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCadastrarProcesso.setText("Cadastrar Processo");
        btnCadastrarProcesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarProcessoActionPerformed(evt);
            }
        });

        btnCadastrarVisita.setBackground(new java.awt.Color(255, 255, 153));
        btnCadastrarVisita.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCadastrarVisita.setText("Cadastrar Visita");
        btnCadastrarVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarVisitaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAtividadesMenuLayout = new javax.swing.GroupLayout(panelAtividadesMenu);
        panelAtividadesMenu.setLayout(panelAtividadesMenuLayout);
        panelAtividadesMenuLayout.setHorizontalGroup(
            panelAtividadesMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAtividadesMenuLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(panelAtividadesMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnCadastrarVisita)
                    .addComponent(btnCadastrarProcesso)
                    .addComponent(btnCadastrarArea))
                .addGap(11, 11, 11))
        );
        panelAtividadesMenuLayout.setVerticalGroup(
            panelAtividadesMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAtividadesMenuLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(btnCadastrarArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(55, 55, 55)
                .addComponent(btnCadastrarProcesso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(67, 67, 67)
                .addComponent(btnCadastrarVisita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenuGeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelAtividadesMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTabelaMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMenuGeral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTabelaMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelAtividadesMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarAreaActionPerformed
        TelaArea telaArea = new TelaArea();
        telaArea.setVisible(true);

    }//GEN-LAST:event_btnCadastrarAreaActionPerformed

    private void btnCadastrarProcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarProcessoActionPerformed
        TelaProcesso telaProcesso = new TelaProcesso();
        telaProcesso.setVisible(true);
    }//GEN-LAST:event_btnCadastrarProcessoActionPerformed

    private void btnCadastrarVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarVisitaActionPerformed
        TelaVisita telaVisita = new TelaVisita(this);
        telaVisita.setVisible(true);

    }//GEN-LAST:event_btnCadastrarVisitaActionPerformed

    private void btnExcluirVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirVisitaActionPerformed
        int linhaSelecionada = tblVisitas.getSelectedRow();

        // 1. Verifica se selecionou alguma linha
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma visita para excluir.");
            return;
        }

        // 2. Pega o ID da visita (coluna 0)
        int idVisita = (int) tblVisitas.getValueAt(linhaSelecionada, 0);

        // 3. Confirma exclusão
        int opcao = JOptionPane.showConfirmDialog(
                this,
                "Deseja realmente excluir esta visita?",
                "Confirmação",
                JOptionPane.YES_NO_OPTION
        );

        if (opcao != JOptionPane.YES_OPTION) {
            return;
        }

        // 4. Exclui no banco
        VisitaDAO dao = new VisitaDAO();
        dao.excluir(idVisita);

        // 5. Atualiza a tabela
        atualizarTabela();

        JOptionPane.showMessageDialog(this, "Visita excluída com sucesso!");
    }//GEN-LAST:event_btnExcluirVisitaActionPerformed

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
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrarArea;
    private javax.swing.JButton btnCadastrarProcesso;
    private javax.swing.JButton btnCadastrarVisita;
    private javax.swing.JButton btnExcluirVisita;
    private javax.swing.JLabel menu;
    private javax.swing.JPanel panelAtividadesMenu;
    private javax.swing.JPanel panelMenuGeral;
    private javax.swing.JPanel panelTabelaMenu;
    private javax.swing.JScrollPane scrollTabela;
    private javax.swing.JLabel tabelaMenu;
    private javax.swing.JTable tblVisitas;
    // End of variables declaration//GEN-END:variables

    private void carregarTabelaVisitas() {
        DefaultTableModel model = (DefaultTableModel) tblVisitas.getModel();
        model.setRowCount(0); // limpa a tabela

        VisitaDAO visitaDAO = new VisitaDAO();
        List<Visita> visitas = visitaDAO.listar();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (Visita v : visitas) {
            model.addRow(new Object[]{
                v.getId(),
                v.getArea().getNomeArea(),
                v.getProcesso().getNomeProcesso(),
                v.getUsuario().getNomeUsuario(),
                v.getDataVisita().format(formatter)
            });
        }
    }

    public void atualizarTabela() {
        carregarTabelaVisitas();
    }

}
