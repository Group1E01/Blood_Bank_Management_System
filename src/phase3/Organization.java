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
public class Organization {

    private String orgnizationName, orgnizationAddress, orgnizationPhoneNo, orgnizationEmail;
    private Campaign campaign;

    public Organization(String orgnizationName, String orgnizationAddress, String orgnizationPhoneNo, String orgnizationEmail) {
        this.orgnizationName = orgnizationName;
        this.orgnizationAddress = orgnizationAddress;
        this.orgnizationPhoneNo = orgnizationPhoneNo;
        this.orgnizationEmail = orgnizationEmail;
        campaign = new Campaign();
    }

    public void setOrgnizationName(String orgnizationName) {
        this.orgnizationName = orgnizationName;
    }

    public void setOrgnizationAddress(String orgnizationAddress) {
        this.orgnizationAddress = orgnizationAddress;
    }

    public void setOrgnizationPhoneNo(String orgnizationPhoneNo) {
        this.orgnizationPhoneNo = orgnizationPhoneNo;
    }

    public void setOrgnizationEmail(String orgnizationEmail) {
        this.orgnizationEmail = orgnizationEmail;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public String getOrgnizationName() {
        return orgnizationName;
    }

    public String getOrgnizationAddress() {
        return orgnizationAddress;
    }

    public String getOrgnizationPhoneNo() {
        return orgnizationPhoneNo;
    }

    public String getOrgnizationEmail() {
        return orgnizationEmail;
    }

    public void updateDetails(String orgnizationName, String orgnizationAddress, String orgnizationPhoneNo, String orgnizationEmail) {
        this.orgnizationName = orgnizationName;
        this.orgnizationAddress = orgnizationAddress;
        this.orgnizationPhoneNo = orgnizationPhoneNo;
        this.orgnizationEmail = orgnizationEmail;
    }
}

