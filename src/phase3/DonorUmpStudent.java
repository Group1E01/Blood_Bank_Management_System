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
public class DonorUmpStudent extends Donor {

    private String studentID;

    public DonorUmpStudent(String studentID, String donorName, String donorGender, int donorAge, double donorTotalBlood) {
        super(donorName, donorGender, donorAge, donorTotalBlood);
        this.studentID = studentID;
    }

    public String getStudentID() {
        return studentID;
    }

    @Override
    public String printMessage() {
        double totalDonatedAmount = getDonorDonatedAmount();
        String message;
        if (totalDonatedAmount >= 200) {
            message = "You have been given 200 Merit";
        } else {
            message = "Thanks for donating blood, you need to donate at least 200 blood to get merit.";
        }
        return message;
    }
}
