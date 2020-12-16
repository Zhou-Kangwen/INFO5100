/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author ZHOU
 */
public class AirlinerDirectory {
    private List<Airliner> airlinerList;
    
    public AirlinerDirectory() throws ParseException{
        airlinerList = new ArrayList<Airliner>();
        Airliner aL1 = new Airliner();
        aL1.setAirlinerName("NEU");
        
        Airliner aL2 = new Airliner();
        aL2.setAirlinerName("BU");
        
        Airliner aL3 = new Airliner();
        aL3.setAirlinerName("MIT");
        
        Airliner aL4 = new Airliner();
        aL4.setAirlinerName("Harvard");
        
        airlinerList.add(aL1);
        airlinerList.add(aL2);
        airlinerList.add(aL3);
        airlinerList.add(aL4);
        
        //Create some airplanes for each airliner.
        Airplane neuAirplane1 = new Airplane(150,"NEU755");
        Airplane neuAirplane2 = new Airplane(150,"NEU757");
        Airplane neuAirplane3 = new Airplane(150,"NEU758");
        aL1.getFleet().add(neuAirplane1);
        aL1.getFleet().add(neuAirplane2);
        aL1.getFleet().add(neuAirplane3);
        
        Airplane buAirplane1 = new Airplane(150,"BU755");
        Airplane buAirplane2 = new Airplane(150,"BU757");
        Airplane buAirplane3 = new Airplane(150,"BU758");
        aL2.getFleet().add(buAirplane1);
        aL2.getFleet().add(buAirplane2);
        aL2.getFleet().add(buAirplane3);
        
        Airplane mitAirplane1 = new Airplane(150,"MIT755");
        Airplane mitAirplane2 = new Airplane(150,"MIT757");
        Airplane mitAirplane3 = new Airplane(150,"MIT758");
        aL3.getFleet().add(mitAirplane1);
        aL3.getFleet().add(mitAirplane2);
        aL3.getFleet().add(mitAirplane3);
        
        Airplane harvardAirplane1 = new Airplane(150,"Harvard755");
        Airplane harvardAirplane2 = new Airplane(150,"Harvard757");
        Airplane harvardAirplane3 = new Airplane(150,"Harvard758");
        aL4.getFleet().add(harvardAirplane1);
        aL4.getFleet().add(harvardAirplane2);
        aL4.getFleet().add(harvardAirplane3);
        
        //Create some flights for flightschedules and airliners
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        Flight neuFlight1 = new Flight(format1.parse("2019-10-17"),format1.parse("2019-10-18"),"BOS","NYC","Morning",neuAirplane1,500.0);
        Flight neuFlight2 = new Flight(format1.parse("2019-10-20"),format1.parse("2019-10-20"),"NYC","Malden","Afternoon",neuAirplane2,1000.0);
        Flight neuFlight3 = new Flight(format1.parse("2019-10-25"),format1.parse("2019-10-26"),"BOS","LOS","Evening",neuAirplane3,1200.0);
        
        Flight buFlight1 = new Flight(format1.parse("2019-10-22"),format1.parse("2019-10-23"),"LOS","LA","Morning",buAirplane1,600.0);
        Flight buFlight2 = new Flight(format1.parse("2019-10-25"),format1.parse("2019-10-26"),"WUHAN","BOS","Afternoon",buAirplane2,1800.0);
        Flight buFlight3 = new Flight(format1.parse("2019-10-27"),format1.parse("2019-10-28"),"BOS","WUHAN","Afternoon",buAirplane3,1600.0);
        
        Flight mitFlight1 = new Flight(format1.parse("2019-10-21"),format1.parse("2019-10-21"),"Malden","LOS","Morning",mitAirplane1,1100.0);
        Flight mitFlight2 = new Flight(format1.parse("2019-10-22"),format1.parse("2019-10-24"),"NYC","Atalanta","Evening",mitAirplane2,1500.0);
        Flight mitFlight3 = new Flight(format1.parse("2019-10-23"),format1.parse("2019-10-24"),"BOS","NYC","Afternoon",mitAirplane3,598.0);
        
        Flight harvardFlight1 = new Flight(format1.parse("2019-10-21"),format1.parse("2019-10-21"),"NYC","Atalanta","Morning",harvardAirplane1,958.0);
        Flight harvardFlight2 = new Flight(format1.parse("2019-10-18"),format1.parse("2019-10-19"),"Malden","LOS","Evening",harvardAirplane2,853.0);
        Flight harvardFlight3 = new Flight(format1.parse("2019-10-19"),format1.parse("2019-10-20"),"Atalanta","WUHAN","Afternoon",harvardAirplane3,698.2);
        
        aL1.getFlightSchedule().getFlightList().add(neuFlight1);
        aL1.getFlightSchedule().getFlightList().add(neuFlight2);
        aL1.getFlightSchedule().getFlightList().add(neuFlight3);
        aL2.getFlightSchedule().getFlightList().add(buFlight1);
        aL2.getFlightSchedule().getFlightList().add(buFlight2);
        aL2.getFlightSchedule().getFlightList().add(buFlight3);
        aL3.getFlightSchedule().getFlightList().add(mitFlight1);
        aL3.getFlightSchedule().getFlightList().add(mitFlight2);
        aL3.getFlightSchedule().getFlightList().add(mitFlight3);
        aL4.getFlightSchedule().getFlightList().add(harvardFlight1);
        aL4.getFlightSchedule().getFlightList().add(harvardFlight2);
        aL4.getFlightSchedule().getFlightList().add(harvardFlight3);
    }

    public List<Airliner> getAirlinerList() {
        return airlinerList;
    }

    public void setAirlinerList(List<Airliner> airlinerList) {
        this.airlinerList = airlinerList;
    }
    public Airliner addAirliner(){
        Airliner newProduct = new Airliner();
        airlinerList.add(newProduct);
        return newProduct;
    }
    
    
}
