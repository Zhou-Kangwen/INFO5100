/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.Date;

/**
 *
 * @author ZHOU
 */
public class Flight {
    private Date departureTime;
    private Date arrivingTime;
    private String departureCity;
    private String arrivingCity;
    private String timeOfDay;
    private Airplane airPlane;
    private int [][] seats;
    private double price;
    
    
    public Flight(Date departureTime,Date arrivingTime,String departureCity,String arrivingCity, String timeOfDay,Airplane airPlane, Double price){
        this.departureTime = departureTime;
        this.arrivingTime = arrivingTime;
        this.departureCity = departureCity;
        this.arrivingCity = arrivingCity;
        this.airPlane = airPlane;
        this.timeOfDay = timeOfDay;
        seats= new int[25][6];
        for(int i =0;i<seats.length;i++){
            for(int j =0;j<seats[0].length;j++){
                seats[i][j]=0;
            }  
        }
        this.price = price;
    }

    public String getTimeOfDay() {
        return timeOfDay;
    }

    public void setTimeOfDay(String timeOfDay) {
        this.timeOfDay = timeOfDay;
    }
    

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivingTime() {
        return arrivingTime;
    }

    public void setArrivingTime(Date arrivingTime) {
        this.arrivingTime = arrivingTime;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivingCity() {
        return arrivingCity;
    }

    public void setArrivingCity(String arrivingCity) {
        this.arrivingCity = arrivingCity;
    }

    public Airplane getAirPlane() {
        return airPlane;
    }

    public void setAirPlane(Airplane airPlane) {
        this.airPlane = airPlane;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    

    public int[][] getSeats() {
        return seats;
    }

    public void setSeats(int[][] seats) {
        this.seats = seats;
    }
@Override
    public String toString() {
        return this.getAirPlane().getPlaneName(); //To change body of generated methods, choose Tools | Templates.
    }
}
