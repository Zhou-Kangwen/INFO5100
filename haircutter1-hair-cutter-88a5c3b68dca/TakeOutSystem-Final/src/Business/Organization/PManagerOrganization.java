/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.PManagerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author HYY
 */
public class PManagerOrganization extends Organization{
  public PManagerOrganization() {
        super(Organization.Type.PManager.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new PManagerRole());
        return roles;
    }
}
