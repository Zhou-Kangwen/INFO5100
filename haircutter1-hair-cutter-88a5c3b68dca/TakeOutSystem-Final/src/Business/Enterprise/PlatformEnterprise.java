/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author HYY
 */
public class PlatformEnterprise extends Enterprise{
    public PlatformEnterprise(String name){
        super(name,Enterprise.EnterpriseType.Platform);
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
}
