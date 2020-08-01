/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phase3;

/**
 * @author daus
 */
public class Donor{
    private String donorIC, donorName, donorGender, donorBloodType;
    private int donorAge, donorDonatedAmount;
  

    public Donor(String donorIC, String donorName, String donorGender, String donorBloodType, int donorAge, int donorDonatedAmount) {
        this.donorIC = donorIC;
        this.donorName = donorName;
        this.donorGender = donorGender;
        this.donorAge = donorAge;
        this.donorBloodType = donorBloodType;
        this.donorDonatedAmount = donorDonatedAmount;
    }

    public String getDonorIC() {
        return donorIC;
    }
    
    public String getDonorName() {
        return donorName;
    }

    public String getDonorGender() {
        return donorGender;
    }

    public String getDonorBloodType() {
        return donorBloodType;
    }
    
    public int getDonorAge() {
        return donorAge;
    }
    
    public int getDonorDonatedAmount() {
        return donorDonatedAmount;
    }

    /*@Override
    public void donateBlood(double donateAmount, Campaign campaign) {
        if (donorTotalBlood - donateAmount <= 0) {
            System.out.println("Sorry you are not eligible to donate that much blood");
        } else {
            donorTotalBlood -= donateAmount;
            this.donorDonatedAmount += donateAmount;
            campaign.addTotalDonatedBlood(donateAmount);
        }

    }*/


}

