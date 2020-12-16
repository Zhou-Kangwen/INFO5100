/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.CookRole;

import Business.DB4OUtil.DB4OUtil;
import Business.Enterprise.Enterprise;
import Business.Organization.CookOrganization;
import Business.Request.Dish;
import Business.Request.ModifyDishesRequest;
import Business.TakeOutSystem;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ZHOU
 */
public class CookWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CookWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private CookOrganization cookOrganization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private TakeOutSystem business;

  
    public CookWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, CookOrganization cookOrganization, Enterprise enterprise, TakeOutSystem business) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.cookOrganization = cookOrganization;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.business = business;
        valueLabel.setText(enterprise.getName());
        
        populateMenuTable();
        populatemodifyMenuJTable();
    }
    
    void populateMenuTable(){
        DefaultTableModel model = (DefaultTableModel) menuJTable.getModel();
        model.setRowCount(0);
        for (Dish d : enterprise.getMenu().getMenuList()){
            Object[] row = new Object[2];
            row[0] = d;
            row[1] = d.getPrice();
            model.addRow(row);
        }
    }
    
    void populatemodifyMenuJTable(){
        DefaultTableModel model = (DefaultTableModel) modifyMenuJTable.getModel();
        model.setRowCount(0);
        for (ModifyDishesRequest m : enterprise.getModifyDishesRequestDirectory().getModifyMenuRequestList()){
            Object[] row = new Object[5];
            row[0] = m.getDish().getDishName();
            row[1] = m.getOriginalPrice();
            row[2] = m.getFinalPrice();
            row[3] = m;
            row[4] = m.getModifyStatus();
            model.addRow(row);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        modifyMenuJTable = new javax.swing.JTable();
        btnModifyMenu = new javax.swing.JButton();
        valueLabel = new javax.swing.JLabel();
        enterpriseLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        menuJTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 204, 255));

        modifyMenuJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name of Dishes", "Original Price", "Modified Price", "Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(modifyMenuJTable);
        if (modifyMenuJTable.getColumnModel().getColumnCount() > 0) {
            modifyMenuJTable.getColumnModel().getColumn(0).setResizable(false);
            modifyMenuJTable.getColumnModel().getColumn(1).setResizable(false);
            modifyMenuJTable.getColumnModel().getColumn(2).setResizable(false);
            modifyMenuJTable.getColumnModel().getColumn(3).setResizable(false);
            modifyMenuJTable.getColumnModel().getColumn(4).setResizable(false);
        }

        btnModifyMenu.setText("Modify Menu Request");
        btnModifyMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyMenuActionPerformed(evt);
            }
        });

        valueLabel.setText("<value>");

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel.setText("EnterPrise :");

        menuJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name of Dishes", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(menuJTable);
        if (menuJTable.getColumnModel().getColumnCount() > 0) {
            menuJTable.getColumnModel().getColumn(0).setResizable(false);
            menuJTable.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel1.setText("Menu:");

        jLabel2.setText("Modify Menu Request:");

        btnAdd.setText("Add Dish");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete Dish");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(367, 367, 367))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnModifyMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnModifyMenu)))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnModifyMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyMenuActionPerformed
        // TODO add your handling code here:
        int selectedrow = menuJTable.getSelectedRow();

        if (selectedrow >= 0) {
            Dish d = (Dish) menuJTable.getValueAt(selectedrow, 0);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            userProcessContainer.add("RequestModifyMenuJPanel", new RequestModifyMenuJPanel(userProcessContainer, userAccount, enterprise, d, business));
            layout.next(userProcessContainer);
        } else
        JOptionPane.showMessageDialog(null, "Please select any row");
        
    }//GEN-LAST:event_btnModifyMenuActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        AddDishJPanel ad = new AddDishJPanel(userProcessContainer,enterprise.getMenu(),business,enterprise);
        userProcessContainer.add("AddDishJPanel", ad);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        //populateTable1();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int selectedrow = menuJTable.getSelectedRow();

        if (selectedrow >= 0) {
            Dish d = (Dish) menuJTable.getValueAt(selectedrow, 0);
            enterprise.getMenu().deleteDish(d);
            DB4OUtil.getInstance().storeSystem(business);
            JOptionPane.showMessageDialog(null, "Organization has been deleted");
            populateMenuTable();
        } else
        JOptionPane.showMessageDialog(null, "Please select any row");
    
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnModifyMenu;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable menuJTable;
    private javax.swing.JTable modifyMenuJTable;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
}
