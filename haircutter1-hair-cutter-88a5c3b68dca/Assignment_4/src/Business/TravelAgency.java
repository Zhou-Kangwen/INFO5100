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
public class TravelAgency {
    private Airliner airliner;
    private MasterTravelSchedule masterTravelSchedule;
    private TravelOffice travelOffice;
    private Ticket ticket;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
    public TravelAgency(){
        airliner = new Airliner();
        masterTravelSchedule = new MasterTravelSchedule();
        travelOffice = new TravelOffice();
    }

    public Airliner getAirliner() {
        return airliner;
    }

    public void setAirliner(Airliner airliner) {
        this.airliner = airliner;
    }

    
    public MasterTravelSchedule getMasterTravelSchedule() {
        return masterTravelSchedule;
    }

    public void setMasterTravelSchedule(MasterTravelSchedule masterTravelSchedule) {
        this.masterTravelSchedule = masterTravelSchedule;
    }

    public TravelOffice getTravelOffice() {
        return travelOffice;
    }

    public void setTravelOffice(TravelOffice travelOffice) {
        this.travelOffice = travelOffice;
    }
    
    
}
