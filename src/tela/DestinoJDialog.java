/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import provanorton.DAO.DestinoDAO;
import provanorton.model.Destino;
import provanorton.util.DateUtil;
import static provanorton.util.DateUtil.dateToString;
import static provanorton.util.DateUtil.stringToDate;

/**
 *
 * @author Norton Wagner Martins
 */
public class DestinoJDialog extends javax.swing.JDialog {

    private DestinoDAO destinoDAO;

    /**
     * Creates new form CombustivelJDialog
     */
    public DestinoJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        destinoDAO = new DestinoDAO();

        try {
            carregaTable(destinoDAO.getAll());
        } catch (SQLException ex) {
            Logger.getLogger(DestinoJDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        btSalvar.setEnabled(false);
        tfCodigo.setEnabled(false);
        desabilitaCampos(false);
        habilitaFiltroCodigo();

    }

    private void desabilitaCampos(boolean ativo) {
        tfDestino.setEnabled(ativo);
        tfDtFim.setEnabled(ativo);
        tfDtInicio.setEnabled(ativo);
        tfVlTot.setEnabled(ativo);
    }

    private void limparCampos() {
        tfCodigo.setText("");
        tfDestino.setText("");
        tfDtInicio.setText("");
        tfDtFim.setText("");
        //tfVlTot.setText("");
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
        tfDestino = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDestinos = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        tfDtInicio = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        tfDtFim = new javax.swing.JFormattedTextField();
        btSair = new javax.swing.JButton();
        pnFiltros = new javax.swing.JPanel();
        btNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btRemover = new javax.swing.JButton();
        rbCodigo = new javax.swing.JRadioButton();
        rbDescricao = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfDescicaoFiltro = new javax.swing.JTextField();
        btFiltrar = new javax.swing.JButton();
        btFiltroAll = new javax.swing.JButton();
        tfCodigoFiltro = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        tfVlTot = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Destino");

        jLabel1.setText("Código:");

        tfCodigo.setEnabled(false);

        jLabel2.setText("Destino:");

        tbDestinos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Destino", "Data De Inicio", "Data De Termino", "Valor Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbDestinos);

        jLabel6.setText("Data De Inicio:");

        try {
            tfDtInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel3.setText("Data De Termino:");

        try {
            tfDtFim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

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

        tfCodigoFiltro.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfCodigoFiltro)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnFiltrosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(pnFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnFiltrosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(btRemover)
                        .addGap(164, 164, 164)
                        .addComponent(btFiltroAll))
                    .addGroup(pnFiltrosLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(tfDescicaoFiltro)
                        .addGap(18, 18, 18)
                        .addComponent(btFiltrar)))
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
                    .addComponent(jLabel4)
                    .addComponent(tfDescicaoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(rbCodigo)
                    .addComponent(rbDescricao)
                    .addComponent(btFiltrar)
                    .addComponent(tfCodigoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        jLabel7.setText("Valor Total:");

        tfVlTot.setText("CALCULADO A PARTIR DOS CUSTOS");
        tfVlTot.setToolTipText("");
        tfVlTot.setEnabled(false);

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
                            .addComponent(tfDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfDtInicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfDtFim, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(174, 174, 174))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfVlTot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(tfDtInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(tfDtFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfVlTot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btSair)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if (validaCampos()) {
            java.sql.Date dataSqlInicio = new java.sql.Date((DateUtil.stringToDate(tfDtInicio.getText().trim())).getTime());
            java.sql.Date dataSqlTermino = new java.sql.Date((DateUtil.stringToDate(tfDtFim.getText().trim())).getTime());
            Destino destino = new Destino();
            destino.setCodigo(Integer.parseInt(tfCodigo.getText().trim()));
            destino.setDestino(tfDestino.getText().trim());
            destino.setDtInicio(dataSqlInicio);
            destino.setDtTermino(dataSqlTermino);
            destino.setVlTotal(0.00);
            try {
                destinoDAO.save(destino);
                JOptionPane.showMessageDialog(null, "Destino Salvo Com Sucesso!!!");
                limparCampos();
                desabilitaCampos(false);
                carregaTable(destinoDAO.getAll());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }//GEN-LAST:event_btSalvarActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        try {
            tfCodigo.setText(String.valueOf(destinoDAO.getLastId()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        desabilitaCampos(true);
        btSalvar.setEnabled(true);
    }//GEN-LAST:event_btNovoActionPerformed

    private void btFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFiltrarActionPerformed
        try {
            if (rbCodigo.isSelected() && tfCodigoFiltro.getText().trim().length() > 0) {//Codigo está selecionado
                Destino destino = destinoDAO.getById(Integer.parseInt(tfCodigoFiltro.getText().trim()));
                List<Destino> destList = new ArrayList<>();
                destList.add(destino);
                carregaTable(destList);
            } else if (rbDescricao.isSelected() && tfDescicaoFiltro.getText().trim().length() > 0) {
                carregaTable(destinoDAO.getByName(tfDescicaoFiltro.getText()));
            } else {
                JOptionPane.showMessageDialog(null, "Favor Informe um filtro para Pesquisa...");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btFiltrarActionPerformed

    private Boolean validaCampos() {
        Boolean valido = true;
        if (tfDestino.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null, "Campo Destino não pode ficar vazio");
            tfDestino.setFocusable(true);
            valido = false;
        } else if (tfDtInicio.getText().replace("/", " ").trim().length() <= 0) {
            JOptionPane.showMessageDialog(null, "Campo DATA INICIAL não pode ficar vazio");
            tfDtInicio.setFocusable(true);
            valido = false;
        } else if (tfDtFim.getText().replace("/", "").trim().length() <= 0) {
            JOptionPane.showMessageDialog(null, "Campo DATA FINAL não pode ficar vazio");
            tfDtFim.setFocusable(true);
            valido = false;
        }

        return valido;
    }
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
        MenuJDialog dialog = new MenuJDialog(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_btSairActionPerformed

    private void btFiltroAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFiltroAllActionPerformed
        try {

            carregaTable(destinoDAO.getAll());
            tfCodigoFiltro.setText("");
            tfDescicaoFiltro.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(DestinoJDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btFiltroAllActionPerformed

    private void habilitaFiltroCodigo() {
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
            java.util.logging.Logger.getLogger(DestinoJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DestinoJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DestinoJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DestinoJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DestinoJDialog dialog = new DestinoJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable tbDestinos;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JFormattedTextField tfCodigoFiltro;
    private javax.swing.JTextField tfDescicaoFiltro;
    private javax.swing.JTextField tfDestino;
    private javax.swing.JFormattedTextField tfDtFim;
    private javax.swing.JFormattedTextField tfDtInicio;
    private javax.swing.JTextField tfVlTot;
    // End of variables declaration//GEN-END:variables

    private void carregaTable(List<Destino> destinoList) {
        if (destinoList == null) {
            return;
        }
        DefaultTableModel model = (DefaultTableModel) tbDestinos.getModel();
        model.setRowCount(0);
        for (Destino d : destinoList) {
            model.addRow(new Object[]{d.getCodigo(), d.getDestino(), dateToString(d.getDtInicio()), dateToString(d.getDtTermino()), d.getVlTotal()});
        }
    }

    private void remover() {
        //Recupera a Linha selecionada na Tabela
        int linhaSeleciona = tbDestinos.getSelectedRow();
        if (linhaSeleciona == -1) {//Nenhuma Linha foi Selecionada
            JOptionPane.showMessageDialog(null, "Selecione uma linha para Remover");
            return;
        }
        int codigoRemover = (int) tbDestinos.getValueAt(linhaSeleciona, 0);
        try {
            if (destinoDAO.getById(codigoRemover).getVlTotal() > 0) {
                JOptionPane.showMessageDialog(null, "Não é possivel Remover, pois possui um CUSTO vinculado");
                return;
            }
            destinoDAO.delete(codigoRemover);
            carregaTable(destinoDAO.getAll());
        } catch (SQLException ex) {
            ex.getErrorCode();
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
