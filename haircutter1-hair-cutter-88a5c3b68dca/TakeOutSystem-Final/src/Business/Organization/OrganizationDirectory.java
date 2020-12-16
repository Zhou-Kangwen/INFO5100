/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import java.util.ArrayList;

/**
 *
 * @author HYY
 */
public class OrganizationDirectory {
 
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Organization.Type type){
        Organization organization = null;
        if (type.getValue().equals(Organization.Type.Cook.getValue())){
            organization = new CookOrganization();
            organizationList.add(organization);
        }
        
        if (type.getValue().equals(Organization.Type.DManager.getValue())){
            organization = new DManagerOrganization();
            organizationList.add(organization);
        }
        if (type.getValue().equals(Organization.Type.Delivery.getValue())){
            organization = new DeliveryOrganization();
            organizationList.add(organization);
        }
        if (type.getValue().equals(Organization.Type.PFinancial.getValue())){
            organization = new PFinancialOrganization();
            organizationList.add(organization);
        }
        if (type.getValue().equals(Organization.Type.PManager.getValue())){
            organization = new PManagerOrganization();
            organizationList.add(organization);
        }
        if (type.getValue().equals(Organization.Type.Purchase.getValue())){
            organization = new PurchaseOrganization();
            organizationList.add(organization);
        }
        if (type.getValue().equals(Organization.Type.RFinancial.getValue())){
            organization = new RFinancialOrganization();
            organizationList.add(organization);
        }
        if (type.getValue().equals(Organization.Type.RManager.getValue())){
            organization = new RManagerOrganization();
            organizationList.add(organization);
        }
        
        return organization;
    }
}
