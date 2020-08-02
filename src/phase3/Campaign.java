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
public class Campaign {

    private String campaignName, campaignStartDate, campaignVenue;
    private double campaignTotalDonatedBlood;
    private Donor donor;
    
    
    public Campaign(String campaignName, String campaignStartDate, String campaignVenue) {
        this.campaignName = campaignName;
        this.campaignStartDate = campaignStartDate;
        this.campaignVenue = campaignVenue;
        this.donor = donor;
       
    }
    public Campaign(){
        this.campaignName = null;
        this.campaignStartDate = null;
        this.campaignVenue = null;
        this.donor = null;
    }

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }
    
    
    public String getCampaignName() {
        return campaignName;
    }

    public String getCampaignStartDate() {
        return campaignStartDate;
    }

    public String getCampaignVenue() {
        return campaignVenue;
    }

    public double getCampaignTotalDonatedBlood() {
        return campaignTotalDonatedBlood;
    }
    
    public void addTotalDonatedBlood(double donorBlood) {
        campaignTotalDonatedBlood += donorBlood;
    }

}

