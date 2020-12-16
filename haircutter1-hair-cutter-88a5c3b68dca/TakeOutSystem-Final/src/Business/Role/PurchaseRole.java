/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.PurchaseOrganization;
import Business.TakeOutSystem;
import Business.UserAccount.UserAccount;

import UserInterface.RPurchaseRole.RPurchaseWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author HYY
 */
public class PurchaseRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, TakeOutSystem business) {
        return new RPurchaseWorkAreaJPanel(userProcessContainer,account, (PurchaseOrganization)organization, enterprise,business);
    }
    
}
