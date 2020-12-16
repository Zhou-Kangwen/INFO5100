/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Request;

import java.util.ArrayList;

/**
 *
 * @author ZHOU
 */
public class PurchaseRequestDirectory {
    private ArrayList<PurchaseRequest> purchaseRequestList;
    
    public PurchaseRequestDirectory(){
        purchaseRequestList = new ArrayList<PurchaseRequest> ();
    }

    public ArrayList<PurchaseRequest> getPurchaseRequestList() {
        return purchaseRequestList;
    }

    public void setPurchaseRequestList(ArrayList<PurchaseRequest> purchaseRequestList) {
        this.purchaseRequestList = purchaseRequestList;
    }
    
    
    public PurchaseRequest createPurchaseRequest(){
        PurchaseRequest purchaseRequest = new PurchaseRequest();
        purchaseRequestList.add(purchaseRequest);
        return purchaseRequest;
    }
    
}
