/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.TakeOutSystem;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author HYY
 */
public abstract class Role {
    public enum RoleType{
        
        Cook("Cook"), DManager("DeliveryManager"),Delivery("Delivery"),PManager("PlatformManager"),PFinancial("PlatformFinancial"),Purchase("Purchase"),RFinancial("Restaurant"),RManager("RestaurantManager");
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, 
            UserAccount account, 
            Organization organization, 
            Enterprise enterprise, 
            TakeOutSystem business);

    @Override
    public String toString() {
        return this.getClass().getName();
    }
    
    
}
