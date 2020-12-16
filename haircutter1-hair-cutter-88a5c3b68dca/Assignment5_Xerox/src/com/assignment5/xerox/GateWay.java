/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment5.xerox;

import com.assignment5.analysis.AnalysisHelper;
import com.assignment5.analysis.DataStore;
import com.assignment5.entities.Customer;
import com.assignment5.entities.Item;
import com.assignment5.entities.Order;
import com.assignment5.entities.Product;
import com.assignment5.entities.SalesPerson;
import java.io.IOException;
import java.util.Map;

/**
 *
 * @author kasai
 */
public class GateWay {
    DataReader orderReader;
    DataReader productReader;
    AnalysisHelper helper;
    public GateWay() throws IOException {
        DataGenerator generator = DataGenerator.getInstance();
        orderReader = new DataReader("SalesDataNew.csv");
        productReader = new DataReader("ProductCatalogueNew.csv");
        helper = new AnalysisHelper();
    }
   
    public static void main(String args[]) throws IOException{
        GateWay  inst = new GateWay();
        inst.readData();
       
     
        
       
    }
    
    private void readData() throws IOException{
        String[] row;
        while((row = productReader.getNextRow()) != null ){
            generateProduct(row);
        }
        while((row = orderReader.getNextRow()) != null ){
            Order order = generateOrder(row);
            generateCustomer(row, order);
            generateSalesPerson(row,order);
        }
        
        runAnalysis();
    }
    
    
    
    
    
    private void generateSalesPerson(String[] row, Order order)throws IOException{
        int salesId = Integer.parseInt(row[4]);
        
        
        Map<Integer, SalesPerson> salesperson = DataStore.getInstance().getSalesPerson();
        
        if(salesperson.containsKey(salesId))
            salesperson.get(salesId).getOrders().add(order);
        else {
            SalesPerson salesPerson = new SalesPerson(salesId);
            salesPerson.getOrders().add(order);
            salesperson.put(salesId, salesPerson);
        }  
    }
    
    
    private Order generateOrder(String[] row)throws IOException{
        // 
        int orderId = Integer.parseInt(row[0]);
        int itemId = Integer.parseInt(row[1]);
        int productId = Integer.parseInt(row[2]);
        int quantity = Integer.parseInt(row[3]);
        int salesId = Integer.parseInt(row[4]);
        int customerId = Integer.parseInt(row[5]);
        int salesPrice = Integer.parseInt(row[6]);
        
        Item item = new Item(productId,salesPrice,quantity);
        
        Order o = new Order(orderId, salesId, customerId, item);
        DataStore.getInstance().getOrder().put(orderId, o);
        return o;
        
       
    }
    private void generateCustomer(String[] row, Order order){
        int customerId = Integer.parseInt(row[5]);
        
        
        
        Map<Integer, Customer> customers = DataStore.getInstance().getCustomer();
        
        if(customers.containsKey(customerId))
            customers.get(customerId).getOrders().add(order);
        else {
            Customer customer = new Customer(customerId);
            customer.getOrders().add(order);
            customers.put(customerId, customer);
        }  
        
        
        
    
    }
    private void generateProduct(String[] row) throws IOException{
        int productId = Integer.parseInt(row[0]);
        int minPrice = Integer.parseInt(row[1]);
        int maxPrice = Integer.parseInt(row[2]);
        int targetPrice = Integer.parseInt(row[3]);
        Product product = new Product(productId, minPrice, maxPrice, targetPrice);
        DataStore.getInstance().getProduct().put(productId, product);
    }
    
    public static void printRow(String[] row){
        for (String row1 : row) {
            System.out.print(row1 + ", ");
        }
        System.out.println("");
    }
    
    
    
    private void runAnalysis(){
        // TODO
        helper.getThreeBestProduct();
        helper.getThreeBestCustomer();
        helper.getThreeBestSeller();
        helper.getTotalRevenue();
        helper.originalResult();
    }
    
}
