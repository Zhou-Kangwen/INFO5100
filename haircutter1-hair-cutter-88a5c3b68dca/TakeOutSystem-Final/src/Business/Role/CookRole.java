/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Enterprise.Enterprise;
import Business.Organization.CookOrganization;
import Business.Organization.Organization;
import Business.TakeOutSystem;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import UserInterface.CookRole.CookWorkAreaJPanel;

/**
 *
 * @author HYY
 */
public class CookRole extends Role {
    
   

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, TakeOutSystem business) {
        return new CookWorkAreaJPanel(userProcessContainer,account, (CookOrganization)organization, enterprise,business); //To change body of generated methods, choose Tools | Templates.
    }
}
