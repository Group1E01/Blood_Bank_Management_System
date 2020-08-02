/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phase3;

/**
 *
 * @author Group 1E
 */
public class DonorGuest extends Donor {

    public DonorGuest(String donorName, String donorGender, int donorAge, double donorTotalBlood) {
        super(donorName, donorGender, donorAge, donorTotalBlood);
    }

    @Override
    public String printMessage() {
        return "Thanks for donating " + getDonorDonatedAmount() + " blood!! See you next time!";
    }

}

