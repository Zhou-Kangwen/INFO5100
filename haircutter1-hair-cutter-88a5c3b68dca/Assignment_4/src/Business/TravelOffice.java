/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Susan Sun
 */
public class TravelOffice {
    private CustomerDirectory customerDirectory;
    private MasterTravelSchedule masterTravelSchedule;
    
    public TravelOffice(){
        customerDirectory = new CustomerDirectory();
        masterTravelSchedule = new MasterTravelSchedule();
    }

    public MasterTravelSchedule getMasterTravelSchedule() {
        return masterTravelSchedule;
    }

    public void setMasterTravelSchedule(MasterTravelSchedule masterTravelSchedule) {
        this.masterTravelSchedule = masterTravelSchedule;
    }

    public CustomerDirectory getCustomerDirectory() {
        return customerDirectory;
    }

    public void setCustomerDirectory(CustomerDirectory customerDirectory) {
        this.customerDirectory = customerDirectory;
    }
    
    
}
