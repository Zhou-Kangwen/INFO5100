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
 * @author ZHOU
 */
public class PurchaseRequest {
    private String materialName;
    private float moneyOrdered;
    private String purchaseRequestStatus;
    private String timeStamp;
    
    public PurchaseRequest(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        timeStamp =  df.format(new Date());
    }
    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public float getMoneyOrdered() {
        return moneyOrdered;
    }

    public void setMoneyOrdered(float moneyOrdered) {
        this.moneyOrdered = moneyOrdered;
    }


    public String getPurchaseRequestStatus() {
        return purchaseRequestStatus;
    }

    public void setPurchaseRequestStatus(String purchaseRequestStatus) {
        this.purchaseRequestStatus = purchaseRequestStatus;
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
