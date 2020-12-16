/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Request;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HYY
 */
public class OrderDirectory {
    private List<Order> orderList;

    public OrderDirectory() {
        this.orderList = new ArrayList<>();
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
   

    public Order AddOrder() {
        Order order = new Order();
        orderList.add(order);
        return order;
    }
    
    
}
