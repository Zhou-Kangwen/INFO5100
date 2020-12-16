/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment5.analysis;

import com.assignment5.entities.Customer;
import com.assignment5.entities.Order;
import com.assignment5.entities.Product;
import com.assignment5.entities.SalesPerson;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author HYY
 */
public class AnalysisHelper {
    public void getThreeBestProduct(){
        Map<Integer, Integer> pro= new HashMap<>();
        Map<Integer, Product> products = DataStore.getInstance().getProduct();
        Map<Integer, Order> orders = DataStore.getInstance().getOrder();
        for(Product p :products.values()){
            int num = 0;
            for(Order o :orders.values()){
                if(p.getProductId()==o.getItem().getProductId() && o.getItem().getSalesPrice()>p.getTargetPrice()){
                    num += o.getItem().getQuantity();
                }
            }
            pro.put(p.getProductId(), num);
        }
        
        List<Map.Entry<Integer,Integer>>list = new ArrayList<>(pro.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>()
        {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2)
            {
                return o2.getValue()-(o1.getValue());
            }           
        }); 
        System.out.println("The Top 3 best negotiated products :");
        int count=1;
        for(int i = 0; i< list.size(); ){
            System.out.println("Top "+count+" : ");
            System.out.println("Product" + list.get(i).getKey() + " was sold " + list.get(i).getValue()+" above the target price");
            for(int j=i+1;j<list.size();j++){
                if(list.get(i).getValue().equals(list.get(j).getValue())){
                     System.out.println("Product" + list.get(j).getKey() + " was sold " + list.get(j).getValue()+" above the target price");
                }
                else{
                    count++;
                    i=j;
                    break;
                }
            }
            if(count>3){
                break;
            }
        }  
        System.out.println();
    }
    
    public void getThreeBestCustomer(){
        Map<Integer, Customer> customers = DataStore.getInstance().getCustomer();
        
        Map<Integer, Product> products = DataStore.getInstance().getProduct();
        Map<Integer,Integer> cus = new HashMap<>();
        for(Customer c: customers.values()){
            int total = 0;
            for(Order o :c.getOrders()){
                
                int quantity = o.getItem().getQuantity();
                int salesprice = o.getItem().getSalesPrice();
                int targetprice = products.get(o.getItem().getProductId()).getTargetPrice();
                total += quantity*Math.abs(salesprice-targetprice);
                
                   
            }
            
            cus.put(c.getCustomerId(), total);
            
        }
        
        List<Map.Entry<Integer,Integer>>list = new ArrayList<>(cus.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>()
        {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2)
            {
                return o1.getValue() - o2.getValue();
            }           
        }); 
        System.out.println("The Top 3 best customers  :");

        int count=1;
        for(int i = 0; i< list.size(); ){
            System.out.println("Top "+count+" : ");
            System.out.println("Customer" + list.get(i).getKey() + " bought " + list.get(i).getValue());
            for(int j=i+1;j<list.size();j++){
                if(list.get(i).getValue().equals(list.get(j).getValue())){
                     System.out.println("Customer" + list.get(j).getKey() + " bought " + list.get(j).getValue());
                }
                else{
                    count++;
                    i=j;
                    break;
                }
            }
            if(count>3){
                break;
            }
        }  
        System.out.println();
    }
    
    
    public void getThreeBestSeller(){
        Map<Integer, SalesPerson> salesPersons = DataStore.getInstance().getSalesPerson();
        
        Map<Integer, Product> products = DataStore.getInstance().getProduct();
        Map<Integer,Integer> sales = new HashMap<>();
        for(SalesPerson s :salesPersons.values()){
            int profit = 0;
            for(Order o: s.getOrders()){
                
                int quantity = o.getItem().getQuantity();
                int salesprice = o.getItem().getSalesPrice();
                int targetprice = products.get(o.getItem().getProductId()).getTargetPrice();
                profit += quantity*(salesprice-targetprice);
                
            }
            sales.put(s.getSalerId(), profit);
        }
        
        List<Map.Entry<Integer,Integer>>list = new ArrayList<>(sales.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>()
        {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2)
            {
                return o2.getValue() - o1.getValue();
            }           
        }); 
        System.out.println("The Top 3 best sales person  :");

        int count=1;
        for(int i = 0; i< list.size(); ){
            System.out.println("Top "+count+" : ");
            System.out.println("SalesPerson" + list.get(i).getKey() + " 's profit is  " + list.get(i).getValue());
            for(int j=i+1;j<list.size();j++){
                if(list.get(i).getValue().equals(list.get(j).getValue())){
                     System.out.println("SalesPerson" + list.get(j).getKey() + " 's profit is  " + list.get(j).getValue());
                }
                else{
                    count++;
                    i=j;
                    break;
                }
            }
            if(count>3){
                break;
            }
        }  
        System.out.println();
    }
    
    public void getTotalRevenue(){
        Map<Integer,Product> products = DataStore.getInstance().getProduct();
        Map<Integer,Order> orders = DataStore.getInstance().getOrder();
        int total = 0;
        for(Order o :orders.values()){
            
               
            int quantity = o.getItem().getQuantity();
            int salesprice = o.getItem().getSalesPrice();
            int targetprice = products.get(o.getItem().getProductId()).getTargetPrice();
            total+= quantity*(salesprice-targetprice);
                
            
        }
        System.out.println("The total revenue is "+ total);
        System.out.println();
    }   
        
    public void originalResult(){
        Map<Integer,Product> products = DataStore.getInstance().getProduct();
        Map<Integer,Order> orders = DataStore.getInstance().getOrder();
        Map<Product,Float> Dif = new HashMap<>();
        Map<Product,Float> Ave= new HashMap<>();
        
        for(Product p: products.values()){
            float averagesaleprice=0;
            float totalprice = 0;
            float num = 0;
            for(Order o : orders.values()){
                if(p.getProductId()==o.getItem().getProductId()){
                    num += o.getItem().getQuantity();
                    totalprice +=o.getItem().getSalesPrice()*o.getItem().getQuantity();
                    
                }
            }
            averagesaleprice =Float.valueOf(totalprice/num);
            float difference = averagesaleprice - p.getTargetPrice();
            float error = difference/averagesaleprice;
            Ave.put(p, averagesaleprice);
            Dif.put(p, difference);
            
            
            
            //System.out.printf("%9d  %9f    %9d       %9f  %9f \n",p.getProductId(),averagesaleprice,p.getTargetPrice(),difference,error*100);
        }
        
        List<Map.Entry<Product,Float>>list = new ArrayList<>(Dif.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<Product,Float>>()
        {
            @Override
            public int compare(Map.Entry<Product, Float> o1, Map.Entry<Product, Float> o2)
            {
                return o2.getValue().compareTo(o1.getValue());
            }           
        }); 
        System.out.println("The product that averagesalesprice is higer than or equals to targetprice :");
        
        System.out.println();
        System.out.println("ProductId "+"AverageSalePrice "+"TargetPrice "+ "Difference"+" Error");
        for(int i = 0; i< list.size(); i++){
            float difference = list.get(i).getValue();
            float target = list.get(i).getKey().getTargetPrice();
            float ave = target+difference;
            float error = difference/ave;
            if(difference>=0){
                System.out.println(list.get(i).getKey().getProductId()+"  "+ ave+" "+ target+" "+difference+" "+error*100+"%");
            }
            
        }
        
        System.out.println();
        System.out.println("The product that averagesalesprice is lower than targetprice :");
        System.out.println();
        System.out.println("ProductId "+"AverageSalePrice "+"TargetPrice "+ "Difference"+" Error");
        for(int i = 0; i< list.size(); i++){
            float difference = list.get(i).getValue();
            float target = list.get(i).getKey().getTargetPrice();
            float ave = target+difference;
            float error = difference/ave;
            if(difference<0){
                System.out.println(list.get(i).getKey().getProductId()+"  "+ ave+" "+ target+" "+difference+" "+error*100+"%");
            }
    } 
    }
    
    
    
        
}
