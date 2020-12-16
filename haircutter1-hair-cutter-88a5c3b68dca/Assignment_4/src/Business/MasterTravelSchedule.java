/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Susan Sun
 */
public class MasterTravelSchedule {
    private FlightSchedule flightSchedule;
    private TravelOffice travelOffice;
    
    public MasterTravelSchedule(){
        flightSchedule = new FlightSchedule();
        
    }

    public FlightSchedule getFlightSchedule() {
        return flightSchedule;
    }

    public void setFlightSchedule(FlightSchedule flightSchedule) {
        this.flightSchedule = flightSchedule;
    }
    
    public TravelOffice getTravelOffice() {
        return travelOffice;
    }

    public void setTravelOffice(TravelOffice travelOffice) {
        this.travelOffice = travelOffice;
    }
    
    
}
