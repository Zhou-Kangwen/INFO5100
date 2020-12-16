/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author ZHOU
 */
public class Customer {
    private String name;
    private Ticket ticket;
    
    public Customer(String name,Ticket ticket){
        this.name = name;                                                                                                                                                                                                          
        this.ticket = ticket;
    }

    public Customer() {
        this.ticket = new Ticket();
        
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
    @Override
    public String toString(){
        return name;
    }
}
