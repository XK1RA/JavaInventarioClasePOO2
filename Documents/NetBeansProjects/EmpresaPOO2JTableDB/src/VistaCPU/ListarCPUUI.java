/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VistaCPU;

import DAO.CPUDAO;
import DAO.MarcaDAO;

/**
 *
 * @author Paula
 */
public class ListarCPUUI extends javax.swing.JPanel {
    private CPUDAO LosCPU;
    private MarcaDAO LasMarcas;
    /**
     * Creates new form ListarCPUUI
     */
    public ListarCPUUI(CPUDAO local, MarcaDAO lasmarcas) {
        this.LosCPU = local;
        this.LasMarcas= lasmarcas;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JL_ListMoni = new javax.swing.JLabel();
        JB_Listar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTA_ListaMoni = new javax.swing.JTextArea();

        JL_ListMoni.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        JL_ListMoni.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JL_ListMoni.setText("CPU'S ALMACENADOS");

        JB_Listar.setText("LISTAR");
        JB_Listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_ListarActionPerformed(evt);
            }
        });

        JTA_ListaMoni.setColumns(20);
        JTA_ListaMoni.setRows(5);
        jScrollPane1.setViewportView(JTA_ListaMoni);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JL_ListMoni, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(JB_Listar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(JL_ListMoni, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JB_Listar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JB_ListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_ListarActionPerformed
        // TODO add your handling code here:
        this.JTA_ListaMoni.setText(this.LosCPU.ListaCPU(LasMarcas));
    }//GEN-LAST:event_JB_ListarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JB_Listar;
    private javax.swing.JLabel JL_ListMoni;
    private javax.swing.JTextArea JTA_ListaMoni;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
