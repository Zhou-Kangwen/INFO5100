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
 * @author ZHOU
 */
public class Airliner {
    private String airlinerName;
    private List<Airplane> fleet;
    private FlightSchedule flightSchedule;
    
    public Airliner(){
        fleet = new ArrayList<Airplane>();
        flightSchedule = new FlightSchedule();
    }

    public List<Airplane> getFleet() {
        return fleet;
    }

    public void setFleet(List<Airplane> fleet) {
        this.fleet = fleet;
    }

    public FlightSchedule getFlightSchedule() {
        return flightSchedule;
    }

    public void setFlightSchedule(FlightSchedule flightSchedule) {
        this.flightSchedule = flightSchedule;
    }

    

    public String getAirlinerName() {
        return airlinerName;
    }

    public void setAirlinerName(String airlinerName) {
        this.airlinerName = airlinerName;
    }
    
    @Override
    public String toString() {
        return getAirlinerName(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
