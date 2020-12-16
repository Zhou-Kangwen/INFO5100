/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ZHOU
 */
public class CustomerDirectory {
    private List<Customer> customerList;
    
    public CustomerDirectory(){
        customerList = new ArrayList<Customer>();
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
   

    public Customer addCustomer() {
        Customer customer = new Customer();
        customerList.add(customer);
        return customer;
    }
    
}
