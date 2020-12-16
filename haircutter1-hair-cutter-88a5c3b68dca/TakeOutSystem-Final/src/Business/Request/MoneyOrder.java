/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Request;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author HYY
 */
public class MoneyOrder {
    //private OrderDirectory orderDirectory;
    //private Order order;
    private String moneyOrderStatus;
    private String timeStamp;
    //private OrderDirectory orderDirectory;
    private String Name;
    private float money;
    
    private float totalProfit;

    public float getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(float totalProfit) {
        this.totalProfit = totalProfit;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    
  
    

    public MoneyOrder() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        timeStamp =  df.format(new Date());
        this.Name=null;
        
    }

    

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }
    
    public String getMoneyOrderStatus() {
        return moneyOrderStatus;
    }

    public void setMoneyOrderStatus(String moneyOrderStatus) {
        this.moneyOrderStatus = moneyOrderStatus;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
    
    @Override 
    public String toString(){
        return timeStamp;
    }
    
}
