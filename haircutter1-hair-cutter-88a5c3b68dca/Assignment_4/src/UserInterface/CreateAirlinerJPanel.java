/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Business.Airliner;
import Business.AirlinerDirectory;
import Business.TravelAgency;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ZHOU
 */
public class CreateAirlinerJPanel extends javax.swing.JPanel {

    private TravelAgency travelAgency;
    private JPanel rightJPanel;
    private AirlinerDirectory airlinerDirectory;
    /**
     * Creates new form CreateAirlinerJPanel
     */
    
    public CreateAirlinerJPanel(JPanel rightJPanel, TravelAgency travelAgency, AirlinerDirectory airlinerDirectory) {
        initComponents();
        this.travelAgency = travelAgency;
        this.rightJPanel = rightJPanel;
        this.airlinerDirectory = airlinerDirectory;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtAirlinerName = new javax.swing.JTextField();
        btnCreateAirliner = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("宋体", 1, 12)); // NOI18N
        jLabel1.setText("Airliner:");

        jLabel2.setFont(new java.awt.Font("宋体", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Create A New Airliner");

        jLabel5.setText("Airliner Name:");

        txtAirlinerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAirlinerNameActionPerformed(evt);
            }
        });

        btnCreateAirliner.setFont(new java.awt.Font("宋体", 1, 12)); // NOI18N
        btnCreateAirliner.setText("Create Airliner");
        btnCreateAirliner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateAirlinerActionPerformed(evt);
            }
        });

        btnBack.setText("<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack)
                .addGap(365, 365, 365)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtAirlinerName, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnCreateAirliner)))
                .addGap(0, 522, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btnBack)))
                .addGap(86, 86, 86)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAirlinerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addComponent(btnCreateAirliner, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(262, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtAirlinerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAirlinerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAirlinerNameActionPerformed

    private void btnCreateAirlinerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateAirlinerActionPerformed
        // TODO add your handling code here:
        String name =  txtAirlinerName.getText();
        if(name == null || name.equals("")){
            JOptionPane.showMessageDialog(null, "AirLiner Name can't be enmpty");
            return;
              
        }
        Airliner airliner = this.airlinerDirectory.addAirliner();
        airliner.setAirlinerName(name);
        JOptionPane.showMessageDialog(null, "Airliner Created Successfully");
        txtAirlinerName.setText("");
    }//GEN-LAST:event_btnCreateAirlinerActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
         // TODO add your handling code here:
        rightJPanel.remove(this);
        CardLayout layout = (CardLayout) rightJPanel.getLayout();
        Component[] comps = rightJPanel.getComponents();
        for(Component comp : comps){
            if(comp instanceof RegisterAirlinerJPanel){
                RegisterAirlinerJPanel manageP = (RegisterAirlinerJPanel) comp;
                manageP.initialize();
            }
        }
        
        
        layout.previous(rightJPanel);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreateAirliner;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtAirlinerName;
    // End of variables declaration//GEN-END:variables
}
