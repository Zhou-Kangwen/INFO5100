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
 * @author Susan Sun
 */
public class MoneyOrderDirectory {
    private List<MoneyOrder> moneyOrderList;
    
    public MoneyOrderDirectory(){
        moneyOrderList = new ArrayList<>();
    }

    public List<MoneyOrder> getMoneyOrderList() {
        return moneyOrderList;
    }

    public void setMoneyOrderList(List<MoneyOrder> moneyOrderList) {
        this.moneyOrderList = moneyOrderList;
    }
    
    public MoneyOrder createMoneyOrder(){
        MoneyOrder moneyOrder = new MoneyOrder();
        moneyOrderList.add(moneyOrder);
        return moneyOrder;
    }
}
