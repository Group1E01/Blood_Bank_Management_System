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
public class DonorFactory {
    
    public Donor createDonor(String type, String studentID, String donorName, String donorGender, int donorAge, double donorTotalBlood){
        Donor obj = null;
        if(type.toLowerCase().equals("umpstudent")) {
            obj = new DonorUmpStudent(studentID, donorName, donorGender, donorAge, donorTotalBlood);
        }
        else if(type.toLowerCase().equals("guest")){
            obj = new DonorGuest(donorName, donorGender, donorAge, donorTotalBlood);
        }
        return obj;
    }
}
