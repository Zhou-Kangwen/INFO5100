/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Request.Menu;
import Business.Request.ModifyDishesRequestDirectory;
import Business.Request.PurchaseRequestDirectory;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author HYY
 */
public class RestaurantEnterprise extends Enterprise{
    private Menu menu;
    ModifyDishesRequestDirectory modifyDishesRequestDirectory;
    PurchaseRequestDirectory purchaseRequestDirectory;
    public RestaurantEnterprise(String name){
        super(name,Enterprise.EnterpriseType.Restaurant);
        menu = new Menu();
        modifyDishesRequestDirectory = new ModifyDishesRequestDirectory();
        purchaseRequestDirectory = new PurchaseRequestDirectory();
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public ModifyDishesRequestDirectory getModifyDishesRequestDirectory() {
        return modifyDishesRequestDirectory;
    }

    public void setModifyDishesRequestDirectory(ModifyDishesRequestDirectory modifyDishesRequestDirectory) {
        this.modifyDishesRequestDirectory = modifyDishesRequestDirectory;
    }

    public PurchaseRequestDirectory getPurchaseRequestDirectory() {
        return purchaseRequestDirectory;
    }

    public void setPurchaseRequestDirectory(PurchaseRequestDirectory purchaseRequestDirectory) {
        this.purchaseRequestDirectory = purchaseRequestDirectory;
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
}
