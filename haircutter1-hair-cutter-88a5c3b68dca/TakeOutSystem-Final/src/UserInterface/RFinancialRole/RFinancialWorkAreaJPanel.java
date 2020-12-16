/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.RFinancialRole;

import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Request.Dish;
import Business.Request.MoneyOrder;
import Business.Request.MoneyOrderDirectory;
import Business.Request.Order;
import Business.Request.PurchaseRequest;
import Business.TakeOutSystem;
import Business.UserAccount.UserAccount;
import UserInterface.CookRole.AddDishJPanel;
import UserInterface.CookRole.RequestModifyMenuJPanel;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ZHOU
 */
public class RFinancialWorkAreaJPanel extends javax.swing.JPanel {
 private JPanel userProcessContainer;
    private UserAccount account;
    private Organization organization;
    private Enterprise enterprise;
    private TakeOutSystem system;
    private MoneyOrderDirectory moneyOrderDirectory;
    private List<Order> temp;
            
    public RFinancialWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, TakeOutSystem business) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.organization = organization;
        this.enterprise = enterprise;
        this.system = business;
        this.moneyOrderDirectory = enterprise.getMoneyOrderDirectory();
        this.temp = new ArrayList<Order>();
        valueLabel.setText(enterprise.getName());
        float sum=0;
        for(MoneyOrder m:moneyOrderDirectory.getMoneyOrderList()){
            if(m.getMoneyOrderStatus().equals("Approved")){
                sum+=m.getMoney();
            }
        }
        txtBalance.setText(String.valueOf(enterprise.getBalance()+sum));
        System.out.println(enterprise.getMoneyOrderDirectory());
        System.out.println(enterprise.getMoneyOrderDirectory().getMoneyOrderList());
        populatePurchaseTable();
        populateMoneyOrderJTable();
    }
    

    void populateMoneyOrderJTable(){
        DefaultTableModel model = (DefaultTableModel) moneyOrderJTable.getModel();
        model.setRowCount(0);
        for (MoneyOrder m : enterprise.getMoneyOrderDirectory().getMoneyOrderList()){
            
                Object[] row = new Object[4];
                row[0] = m;
                row[1] = m.getMoney();
                row[2] = m.getName();
                row[3] = m.getMoneyOrderStatus();
                model.addRow(row);
            
            
        }
    }

    void populatePurchaseTable(){
        DefaultTableModel model = (DefaultTableModel) purchaseJTable.getModel();
        model.setRowCount(0);
        for (PurchaseRequest p : enterprise.getPurchaseRequestDirectory().getPurchaseRequestList()){
            if(p.getPurchaseRequestStatus().equals("Approved By Manager")){
                Object[] row = new Object[4];
                row[0] = p.getMaterialName();
                row[1] = p.getMoneyOrdered();
                row[2] = p;
                row[3] = p.getPurchaseRequestStatus();
                model.addRow(row);
            }
            
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnApprove = new javax.swing.JButton();
        btnDecline = new javax.swing.JButton();
        valueLabel = new javax.swing.JLabel();
        enterpriseLabel = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        moneyOrderJTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtBalance = new javax.swing.JTextField();
        btnRequestMoney = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        purchaseJTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 204, 255));

        btnApprove.setText("Approve");
        btnApprove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApproveActionPerformed(evt);
            }
        });

        btnDecline.setText("Decline");

        valueLabel.setText("<value>");

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel.setText("EnterPrise :");

        moneyOrderJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Money Request", "Restaurant", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(moneyOrderJTable);

        jLabel1.setText("Account Balance:");

        txtBalance.setEnabled(false);
        txtBalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBalanceActionPerformed(evt);
            }
        });

        btnRequestMoney.setText("Request Money");
        btnRequestMoney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestMoneyActionPerformed(evt);
            }
        });

        jLabel2.setText("Purchase Requst:");

        jButton4.setText("Delete Request");

        purchaseJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Material Name", "Money Ordered", "Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(purchaseJTable);

        jLabel3.setText("Money Request:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(192, 192, 192))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(enterpriseLabel)
                        .addGap(30, 30, 30)
                        .addComponent(valueLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRequestMoney)
                            .addComponent(jButton4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnDecline, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnApprove, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enterpriseLabel)
                    .addComponent(valueLabel)
                    .addComponent(jLabel1)
                    .addComponent(txtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnApprove)
                                .addGap(18, 18, 18)
                                .addComponent(btnDecline))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jLabel2)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRequestMoney)
                                .addGap(33, 33, 33)
                                .addComponent(jButton4))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(35, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(78, 78, 78))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnApproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApproveActionPerformed
        // TODO add your handling code here:
        int selectedrow = purchaseJTable.getSelectedRow();

        if(selectedrow >=0)
        {
            PurchaseRequest  vs = (PurchaseRequest)purchaseJTable.getValueAt(selectedrow,2);
            vs.setPurchaseRequestStatus("Approved By Financial");

            enterprise.setBalance(enterprise.getBalance()- vs.getMoneyOrdered());
            txtBalance.setText(String.valueOf(enterprise.getBalance()));

            JOptionPane.showMessageDialog(null, "This request has been approved!!");
            populatePurchaseTable();
        }
        else
        JOptionPane.showMessageDialog(null,"Please select an request!! ");

    }//GEN-LAST:event_btnApproveActionPerformed

    private void txtBalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBalanceActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtBalanceActionPerformed

    private void btnRequestMoneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestMoneyActionPerformed
        // TODO add your handling code here:
        RequestRMoneyJPanel rp = new RequestRMoneyJPanel(userProcessContainer,enterprise,system);
        userProcessContainer.add("RequestRMoneyJPanel", rp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnRequestMoneyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApprove;
    private javax.swing.JButton btnDecline;
    private javax.swing.JButton btnRequestMoney;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable moneyOrderJTable;
    private javax.swing.JTable purchaseJTable;
    private javax.swing.JTextField txtBalance;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
}
