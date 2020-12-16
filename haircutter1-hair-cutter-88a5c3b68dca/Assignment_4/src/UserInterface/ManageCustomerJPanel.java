/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Business.Airliner;
import Business.AirlinerDirectory;
import Business.Customer;
import Business.Flight;
import Business.FlightSchedule;
import Business.TravelAgency;
import java.awt.CardLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ZHOU
 */
public class ManageCustomerJPanel extends javax.swing.JPanel {

    private TravelAgency travelAgency;
    private JPanel rightJPanel;
    private AirlinerDirectory airlinerDirectory;
    /**
     * Creates new form ManageCustomers
     */

    public ManageCustomerJPanel(JPanel rightJPanel, TravelAgency travelAgency, AirlinerDirectory airlinerDirectory) {
        initComponents();
        this.travelAgency = travelAgency;
        this.rightJPanel = rightJPanel;
        this.airlinerDirectory = airlinerDirectory;
        populate();
        initialize();
    }
    
    private void initialize(){
        //text should either be "Supplier Login Screen" OR "Customer Login Screen"
        //Based on the selection
        SimpleDateFormat sdf =  new SimpleDateFormat( " yyyy-MM-dd " );
       
        cboDCity.removeAllItems();
        cboACity.removeAllItems();
        cboTime.removeAllItems();
        cboDDate.removeAllItems();
        cboADate.removeAllItems();
        cboCus.removeAllItems();
        cboDCity.addItem("");
        cboACity.addItem("");
        cboTime.addItem("");
        cboDDate.addItem("");
        cboADate.addItem("");
        for(Customer cus:travelAgency.getTravelOffice().getCustomerDirectory().getCustomerList()){
          cboCus.addItem(cus);
        }
        ArrayList<String> listdc = new ArrayList<>();
        for(Airliner a : airlinerDirectory.getAirlinerList()){
            for(Flight f : a.getFlightSchedule().getFlightList()){
                listdc.add(f.getDepartureCity());
            }
        }
        for (int i=0;i<listdc.size()-1;i++){
            for(int j=listdc.size()-1;j>i;j--){
                if(listdc.get(j).equals(listdc.get(i))){
                    listdc.remove(j);
                }
            }
        }
        for(String s:listdc){
            cboDCity.addItem(s);
        }
        
        ArrayList<String> listac = new ArrayList<>();
        for(Airliner a : airlinerDirectory.getAirlinerList()){
            for(Flight f : a.getFlightSchedule().getFlightList()){
                listac.add(f.getArrivingCity());
            }
        }
        for (int i=0;i<listac.size()-1;i++){
            for(int j=listac.size()-1;j>i;j--){
                if(listac.get(j).equals(listac.get(i))){
                    listac.remove(j);
                }
            }
        }
        for(String s:listac){
            cboACity.addItem(s);
        }
        
        cboTime.addItem("Morning");
        cboTime.addItem("Afternoon");
        cboTime.addItem("Evening");
        
        ArrayList<String> listDDate = new ArrayList<>();
        for(Airliner a : airlinerDirectory.getAirlinerList()){
            for(Flight f : a.getFlightSchedule().getFlightList()){
                listDDate.add(sdf.format(f.getDepartureTime()));
            }
        }
        for (int i=0;i<listDDate.size()-1;i++){
            for(int j=listDDate.size()-1;j>i;j--){
                if(listDDate.get(j).equals(listDDate.get(i))){
                    listDDate.remove(j);
                }
            }
        }
        for(String s:listDDate){
            cboDDate.addItem(s);
        } 
        
        ArrayList<String> listADate = new ArrayList<>();
        for(Airliner a : airlinerDirectory.getAirlinerList()){
            for(Flight f : a.getFlightSchedule().getFlightList()){
                listADate.add(sdf.format(f.getArrivingTime()));
            }
        }
        for (int i=0;i<listADate.size()-1;i++){
            for(int j=listADate.size()-1;j>i;j--){
                if(listADate.get(j).equals(listADate.get(i))){
                    listADate.remove(j);
                }
            }
        }
        for(String s:listADate){
            cboADate.addItem(s);
        }
    }
    
    public void populate(){
        DefaultTableModel dtm = (DefaultTableModel)tblFlightInfo.getModel();
        dtm.setRowCount(0);
        SimpleDateFormat sdf =  new SimpleDateFormat( " yyyy-MM-dd " );
        for(Airliner a : airlinerDirectory.getAirlinerList()){
            for(Flight f : a.getFlightSchedule().getFlightList()){
                Object[] row = new Object[dtm.getColumnCount()];
                row[0] = f;
                row[1] = f.getDepartureCity();
                row[2] = f.getArrivingCity();
                row[3] = sdf.format(f.getDepartureTime());
                row[4] = sdf.format(f.getArrivingTime());
                row[5] = f.getTimeOfDay();
                row[6] = f.getPrice();
                dtm.addRow(row);
            }
        }
        cboCus.removeAllItems();
         for(Customer cus:travelAgency.getTravelOffice().getCustomerDirectory().getCustomerList()){
          cboCus.addItem(cus);
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFlightInfo = new javax.swing.JTable();
        btnSearch = new javax.swing.JButton();
        btnBookReservation = new javax.swing.JButton();
        cboCus = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cboDCity = new javax.swing.JComboBox<>();
        cboTime = new javax.swing.JComboBox<>();
        cboDDate = new javax.swing.JComboBox<>();
        cboACity = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cboADate = new javax.swing.JComboBox<>();
        btnRefresh = new javax.swing.JButton();
        btnCreateCustomer = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("宋体", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manage Customer");

        tblFlightInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Airplane", "Departure City", "Arriving City", "Departure time", "Arriving Time", "Time Of Day", "Price($)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblFlightInfo);
        if (tblFlightInfo.getColumnModel().getColumnCount() > 0) {
            tblFlightInfo.getColumnModel().getColumn(0).setResizable(false);
            tblFlightInfo.getColumnModel().getColumn(1).setResizable(false);
            tblFlightInfo.getColumnModel().getColumn(2).setResizable(false);
            tblFlightInfo.getColumnModel().getColumn(3).setResizable(false);
            tblFlightInfo.getColumnModel().getColumn(4).setResizable(false);
            tblFlightInfo.getColumnModel().getColumn(5).setResizable(false);
            tblFlightInfo.getColumnModel().getColumn(6).setResizable(false);
        }

        btnSearch.setText("Search for Best Fight");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnBookReservation.setText("Book A Reservation");
        btnBookReservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookReservationActionPerformed(evt);
            }
        });

        cboCus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Arriving Date:");

        cboDCity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboDCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDCityActionPerformed(evt);
            }
        });

        cboTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboDDate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboACity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Departure City:");

        jLabel3.setText("Arriving City:");

        jLabel4.setText("Time Of Day:");

        jLabel5.setText("Departure Date:");

        cboADate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnCreateCustomer.setText("Create Your Account");
        btnCreateCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateCustomerActionPerformed(evt);
            }
        });

        jLabel7.setText("Select your Name:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(33, 33, 33)
                        .addComponent(cboCus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel5))))
                                .addGap(120, 120, 120)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cboTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboACity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboDDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboADate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cboDCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(187, 187, 187)
                        .addComponent(btnRefresh)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBookReservation, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCreateCustomer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)))
                        .addContainerGap(330, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(cboDCity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(btnCreateCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(120, 120, 120)
                                        .addComponent(jLabel6))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(btnBookReservation, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnRefresh))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(cboCus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7))
                                        .addGap(8, 8, 8))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(cboACity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(cboTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(cboDDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(cboADate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBookReservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookReservationActionPerformed
        // TODO add your handling code here:
       int selectedRow = tblFlightInfo.getSelectedRow();
       Customer cus = (Customer)cboCus.getSelectedItem();
        if (selectedRow >= 0) {
            //int selectionButton = JOptionPane.YES_NO_OPTION;
            //int selectionResult = JOptionPane.showConfirmDialog(null, "Are you sure to update??", "Warning", selectionButton);
            //if (selectionResult == JOptionPane.YES_OPTION) {
            if(cus == null){
                JOptionPane.showMessageDialog(null, "Please create a customer account first!!");
                return;
            }
                Flight flight = (Flight) tblFlightInfo.getValueAt(selectedRow, 0);
                if(cus.getTicket().getFlight()==null){
                    CustomerBookSeatJPanel customerBookSeatJPanel =new CustomerBookSeatJPanel(rightJPanel,flight,cus);
                    rightJPanel.add("customerBookSeatJpanel", customerBookSeatJPanel);
                    CardLayout layout=(CardLayout)rightJPanel.getLayout();
                    layout.next(rightJPanel);}
                else{
                    JOptionPane.showMessageDialog(null, "A customer can't book second ticket!!");
                    return;
                }
            }
         else {
            JOptionPane.showMessageDialog(null, "Please select a Row!!");
            return;
        }
        
    }//GEN-LAST:event_btnBookReservationActionPerformed

    private void cboDCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDCityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboDCityActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        String DepartureCity =cboDCity.getSelectedItem().toString();
        String ArrivingCity = cboACity.getSelectedItem().toString();
        String Time = cboTime.getSelectedItem().toString();
        String DepartureTime = cboDDate.getSelectedItem().toString();
        String ArrivinigTime = cboADate.getSelectedItem().toString();
        
        //Match each selected item in comboBox and give them into the result1.
        FlightSchedule result1 = new FlightSchedule();
        FlightSchedule result = new FlightSchedule();
        for(Airliner a : airlinerDirectory.getAirlinerList()){
            for(Flight f : a.getFlightSchedule().getFlightList()){
                result.getFlightList().add(f);
            }
           
        }
        if(DepartureCity==""){
          result1=result;
        }
        else{
            result1 = result.searchbyDC(DepartureCity);
        }
        
        FlightSchedule result2 = new FlightSchedule();
        if(ArrivingCity==""){
           result2 = result1;
        }
        else{
            result2 = result1.searchbyAC(ArrivingCity);
        }
        
        
        FlightSchedule result3 = new FlightSchedule();
        if(Time==""){
           result3 = result2;
        }
        else{
            result3 = result2.searchbyTime(Time);
        }
        
        
        FlightSchedule result4 = new FlightSchedule();
        if(DepartureTime==""){
           result4 =result3;
        }
        else{
            result4 =result3.searchbyDT(DepartureTime);
        }
        
        FlightSchedule result5 = new FlightSchedule();
        if(DepartureTime==""){
           result5 = result4;
        }
        else{
            result5 = result4.searchAT(ArrivinigTime);
        }
        
        if(result5.getFlightList().size() == 0){
            JOptionPane.showMessageDialog(null,"There is no matched flight" );
            
        }else{
            //Search best flight for customer.
            DefaultTableModel dtm = (DefaultTableModel)tblFlightInfo.getModel();
            dtm.setRowCount(0);
            SimpleDateFormat sdf =  new SimpleDateFormat( " yyyy-MM-dd " );
        
            double p = result5.getFlightList().get(0).getPrice();
            for(Flight f : result5.getFlightList()){
                if(f.getPrice() < p){
                    p = f.getPrice();
                }
            }

            for(Flight f : result5.getFlightList()){
                if(f.getPrice() == p){
                    Object[] row = new Object[dtm.getColumnCount()];
                    row[0] = f;
                    row[1] = f.getDepartureCity();
                    row[2] = f.getArrivingCity();
                    row[3] = sdf.format(f.getDepartureTime());
                    row[4] = sdf.format(f.getArrivingTime());
                    row[5] = f.getTimeOfDay();
                    row[6] = f.getPrice();
                    dtm.addRow(row);
                }
            }
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        populate();
        initialize();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnCreateCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateCustomerActionPerformed
        // TODO add your handling code here:
        CreateCustomerJPanel jpanel = new CreateCustomerJPanel(this.travelAgency.getTravelOffice(),this.travelAgency.getTravelOffice().getCustomerDirectory(),this.rightJPanel);
        this.rightJPanel.add("CreateCustomerJPanel",jpanel);
        CardLayout layout = (CardLayout) this.rightJPanel.getLayout();
        layout.next(rightJPanel);
    }//GEN-LAST:event_btnCreateCustomerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBookReservation;
    private javax.swing.JButton btnCreateCustomer;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cboACity;
    private javax.swing.JComboBox<String> cboADate;
    private javax.swing.JComboBox<Object> cboCus;
    private javax.swing.JComboBox<String> cboDCity;
    private javax.swing.JComboBox<String> cboDDate;
    private javax.swing.JComboBox<String> cboTime;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblFlightInfo;
    // End of variables declaration//GEN-END:variables
}
