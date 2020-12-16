/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ZHOU
 */
public class FlightSchedule {
    private List<Flight> flightList;
    
    public FlightSchedule(){
        flightList = new ArrayList<Flight>();
    }

    public List<Flight> getFlightList() {
        
        return flightList;
    }

    public void setFlightList(List<Flight> flightList) {
        this.flightList = flightList;
    }
    
    public FlightSchedule searchbyDC(String DepartureCity){
        FlightSchedule result = new FlightSchedule();
        for(Flight prod : this.flightList){
            if(prod.getDepartureCity().equals(DepartureCity)){
                result.getFlightList().add(prod);
            }
        }
            return result;
    }
        
        
    public FlightSchedule searchbyAC(String ArrivingCity){
        FlightSchedule result = new FlightSchedule();
        for(Flight prod : this.flightList){
            if(prod.getArrivingCity().equals(ArrivingCity)){
                result.getFlightList().add(prod);
            }
        }
            return result;
    }
    
    public FlightSchedule searchbyDT(String DepartureTime){
        FlightSchedule result = new FlightSchedule();
        for(Flight prod : this.flightList){
            if(prod.getDepartureTime().equals(DepartureTime)){
                result.getFlightList().add(prod);
            }
        }
            return result;
    }
    
    public FlightSchedule searchAT(String ArrivingTime){
        FlightSchedule result = new FlightSchedule();
        for(Flight prod : this.flightList){
            if(prod.getArrivingTime().equals(ArrivingTime)){
                result.getFlightList().add(prod);
            }
        }
            return result;
    }
    
    public FlightSchedule searchbyTime(String time){
        FlightSchedule result = new FlightSchedule();
        for(Flight prod : this.flightList){
            if(prod.getTimeOfDay().equals(time)){
                result.getFlightList().add(prod);
            }
        }
            return result;
    }
  
    
}
