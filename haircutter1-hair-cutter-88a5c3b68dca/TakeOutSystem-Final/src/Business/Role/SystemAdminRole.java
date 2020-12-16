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
import UserInterface.SystemAdminWorkArea.SystemAdminWorkAreaJPanel;
import javax.swing.JPanel;


/**
 *
 * @author HYY
 */
public class SystemAdminRole extends Role{

    

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, TakeOutSystem system) {
        return new SystemAdminWorkAreaJPanel(userProcessContainer, system); //To change body of generated methods, choose Tools | Templates.
    }
    
}
