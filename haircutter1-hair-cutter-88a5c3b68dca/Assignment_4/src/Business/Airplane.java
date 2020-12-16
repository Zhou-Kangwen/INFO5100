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
public class Airplane {
    private int seatsNumber;
    private String planeName;
    
    public Airplane(int seatsNumber,String planeNum){
        this.seatsNumber=seatsNumber;
        this.planeName = planeNum;
    }
    
    public int getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(int seatsNumber) {
        this.seatsNumber = seatsNumber;
    }
    
    public String getPlaneName() {
        return planeName;
    }

    public void setPlaneName(String planeName) {
        this.planeName = planeName;
    }

    
    
    
}
