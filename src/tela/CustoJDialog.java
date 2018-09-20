/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import provanorton.DAO.CustoDAO;
import provanorton.DAO.CustoDAO;
import provanorton.DAO.DestinoDAO;
import provanorton.model.Custo;
import provanorton.model.Destino;
import static provanorton.util.DateUtil.dateToString;
import static provanorton.util.DateUtil.stringToDate;

/**
 *
 * @author Norton Wagner Martins
 */
public class CustoJDialog extends javax.swing.JDialog {

    private CustoDAO custoDAO;

    /**
     * Creates new form CombustivelJDialog
     */
    public CustoJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        custoDAO = new CustoDAO();

        try {
            carregaTable(custoDAO.getAll());
        } catch (SQLException ex) {
            Logger.getLogger(CustoJDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        btSalvar.setEnabled(false);
        tfCodigo.setEnabled(false);
        desabilitaCampos(false);
        habilitaFiltroCodigo();
        
        /*try {
            DefaultComboBoxModel modeloDestino = new DefaultComboBoxModel (DestinoDAO.getAll());
        cbClientes_OS.setModel(modeloComboClientes);
        } catch (Exception e) {
            e.printStackTrace();
        } */


    }

    private void desabilitaCampos(boolean ativo) {
        tfDescricao.setEnabled(ativo);
        //tfDtFim.setEnabled(ativo);
        //tfDtInicio.setEnabled(ativo);
        tfVlTot.setEnabled(ativo);
    }

    private void limparCampos() {
        tfCodigo.setText("");
        tfDescricao.setText("");
        //tfDtInicio.setText("");
        //tfDtFim.setText("");
        tfVlTot.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btGroupFiltros = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        tfCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfDescricao = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCustos = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btSair = new javax.swing.JButton();
        pnFiltros = new javax.swing.JPanel();
        btNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btRemover = new javax.swing.JButton();
        rbCodigo = new javax.swing.JRadioButton();
        rbDescricao = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        tfCodigoFiltro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfDescicaoFiltro = new javax.swing.JTextField();
        btFiltrar = new javax.swing.JButton();
        btFiltroAll = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        tfVlTot = new javax.swing.JTextField();
        cbTpCusto = new javax.swing.JComboBox<>();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Código:");

        tfCodigo.setEnabled(false);

        jLabel2.setText("Descrição:");

        tbCustos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Tipo Custo", "Valor Custo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbCustos);

        jLabel6.setText("Codigo Destino:");

        jLabel3.setText("Tipo Custo:");

        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        pnFiltros.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btRemover.setText("Remover");
        btRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverActionPerformed(evt);
            }
        });

        btGroupFiltros.add(rbCodigo);
        rbCodigo.setSelected(true);
        rbCodigo.setText("Codigo");
        rbCodigo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbCodigoItemStateChanged(evt);
            }
        });

        btGroupFiltros.add(rbDescricao);
        rbDescricao.setText("Descrição");
        rbDescricao.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbDescricaoItemStateChanged(evt);
            }
        });

        jLabel4.setText("Codigo:");

        jLabel5.setText("Descrição:");

        btFiltrar.setText("Filtrar");
        btFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFiltrarActionPerformed(evt);
            }
        });

        btFiltroAll.setText("Filtrar Todos");
        btFiltroAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFiltroAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnFiltrosLayout = new javax.swing.GroupLayout(pnFiltros);
        pnFiltros.setLayout(pnFiltrosLayout);
        pnFiltrosLayout.setHorizontalGroup(
            pnFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFiltrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbCodigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbDescricao)
                .addGap(43, 43, 43)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(pnFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnFiltrosLayout.createSequentialGroup()
                        .addComponent(tfCodigoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(tfDescicaoFiltro)
                        .addGap(18, 18, 18)
                        .addComponent(btFiltrar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnFiltrosLayout.createSequentialGroup()
                        .addGap(0, 27, Short.MAX_VALUE)
                        .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btRemover)
                        .addGap(164, 164, 164)
                        .addComponent(btFiltroAll)))
                .addContainerGap())
        );
        pnFiltrosLayout.setVerticalGroup(
            pnFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnFiltrosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalvar)
                    .addComponent(btNovo)
                    .addComponent(btRemover)
                    .addComponent(btFiltroAll))
                .addGap(18, 18, 18)
                .addGroup(pnFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCodigoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(tfDescicaoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(rbCodigo)
                    .addComponent(rbDescricao)
                    .addComponent(btFiltrar))
                .addGap(26, 26, 26))
        );

        jLabel7.setText("Valor Custo:");

        tfVlTot.setToolTipText("");

        cbTpCusto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 - Hotel", "2 - Comida", "3 - Aluguel" }));
        cbTpCusto.setToolTipText("");

        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(341, 341, 341))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnFiltros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbTpCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfVlTot, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(79, 79, 79))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cbTpCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfVlTot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(pnFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btSair)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        Custo custo = new Custo();
        custo.setCodigo(Integer.parseInt(tfCodigo.getText().trim()));
        custo.setDsCusto(tfDescricao.getText().trim());
        //custo.setDestino(destino);
        //destino.setDtTermino(Date.valueOf(tfDtFim.getText().trim()));
        custo.setTpCusto(cbTpCusto.getSelectedIndex());
        try {
            custoDAO.save(custo);
            JOptionPane.showMessageDialog(null, "Custo Salvo Com Sucesso!!!");
            limparCampos();
            desabilitaCampos(false);
            carregaTable(custoDAO.getAll());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        try {
            tfCodigo.setText(String.valueOf(custoDAO.getLastId()));
            tfDescricao.setText("Teste");
            tfVlTot.setText("1500");
 
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        desabilitaCampos(true);
        btSalvar.setEnabled(true);
    }//GEN-LAST:event_btNovoActionPerformed

    private void btFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFiltrarActionPerformed
        try {
            if (rbCodigo.isSelected() && tfCodigoFiltro.getText().trim().length() > 0) {//Codigo está selecionado
                Custo custo = custoDAO.getById(Integer.parseInt(tfCodigoFiltro.getText()));
                List<Custo> custoList = new ArrayList<>();
                custoList.add(custo);
                carregaTable(custoList);
            } else if (rbDescricao.isSelected() && tfDescicaoFiltro.getText().trim().length() > 0) {
                carregaTable(custoDAO.getByName(tfDescicaoFiltro.getText()));
            }else {
                JOptionPane.showMessageDialog(null, "Favor Informe um filtro para Pesquisa...");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btFiltrarActionPerformed

    private void rbDescricaoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbDescricaoItemStateChanged
        tfCodigoFiltro.setText("");
        tfCodigoFiltro.setEnabled(false);
        tfDescicaoFiltro.setEnabled(true);
    }//GEN-LAST:event_rbDescricaoItemStateChanged

    private void rbCodigoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbCodigoItemStateChanged
        habilitaFiltroCodigo();
    }//GEN-LAST:event_rbCodigoItemStateChanged

    private void btRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverActionPerformed
        remover();
    }//GEN-LAST:event_btRemoverActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btSairActionPerformed

    private void btFiltroAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFiltroAllActionPerformed
        try {
            carregaTable(custoDAO.getAll());
            tfCodigoFiltro.setText("");
            tfDescicaoFiltro.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(CustoJDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btFiltroAllActionPerformed

    private void habilitaFiltroCodigo(){
        tfDescicaoFiltro.setText("");
        tfDescicaoFiltro.setEnabled(false);
        tfCodigoFiltro.setEnabled(true);
    }
    
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(CustoJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustoJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustoJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustoJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CustoJDialog dialog = new CustoJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btFiltrar;
    private javax.swing.JButton btFiltroAll;
    private javax.swing.ButtonGroup btGroupFiltros;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btRemover;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox<String> cbTpCusto;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnFiltros;
    private javax.swing.JRadioButton rbCodigo;
    private javax.swing.JRadioButton rbDescricao;
    private javax.swing.JTable tbCustos;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfCodigoFiltro;
    private javax.swing.JTextField tfDescicaoFiltro;
    private javax.swing.JTextField tfDescricao;
    private javax.swing.JTextField tfVlTot;
    // End of variables declaration//GEN-END:variables

    private void carregaTable(List<Custo> custoList) {
        if (custoList == null)
            return;
        DefaultTableModel model = (DefaultTableModel) tbCustos.getModel();
        model.setRowCount(0);
        for (Custo c : custoList) {
            model.addRow(new Object[]{c.getCodigo(), c.getDsCusto(), c.getTpCusto(), c.getVlCusto()});
        }
    }

    private void remover() {
        //Recupera a Linha selecionada na Tabela
        int linhaSeleciona = tbCustos.getSelectedRow();
        if (linhaSeleciona == -1) {//Nenhuma Linha foi Selecionada
            JOptionPane.showMessageDialog(null, "Selecione uma linha para Remover");
            return;
        }
        int codigoRemover = (int) tbCustos.getValueAt(linhaSeleciona, 0);
        try {
            custoDAO.delete(codigoRemover);
            carregaTable(custoDAO.getAll());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }       
    }
}