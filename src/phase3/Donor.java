/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phase3;

/**
 * @author daus
 */
public abstract class Donor implements Donate {
    private String donorName, donorGender;
    
    private int donorAge;
    private double donorTotalBlood, donorDonatedAmount;
  

    public Donor(String donorName, String donorGender, int donorAge, double donorTotalBlood) {
        this.donorName = donorName;
        this.donorGender = donorGender;
        this.donorAge = donorAge;
        this.donorTotalBlood = donorTotalBlood;
    }

    public int getDonorAge() {
        return donorAge;
    }

    public String getDonorName() {
        return donorName;
    }

    public String getDonorGender() {
        return donorGender;
    }

    public double getDonorTotalBlood() {
        return donorTotalBlood;
    }

    public double getDonorDonatedAmount() {
        return donorDonatedAmount;
    }

    public abstract String printMessage();

    @Override
    public void donateBlood(double donateAmount, Campaign campaign) {
        if (donorTotalBlood - donateAmount <= 0) {
            System.out.println("Sorry you are not eligible to donate that much blood");
        } else {
            donorTotalBlood -= donateAmount;
            this.donorDonatedAmount += donateAmount;
            campaign.addTotalDonatedBlood(donateAmount);
        }

    }


}

