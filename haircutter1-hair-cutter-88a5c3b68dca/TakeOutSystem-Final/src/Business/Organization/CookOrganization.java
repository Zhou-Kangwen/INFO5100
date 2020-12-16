/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.CookRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author HYY
 */
public class CookOrganization extends Organization {
    public CookOrganization() {
        super(Type.Cook.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new CookRole());
        return roles;
    }
    
}
