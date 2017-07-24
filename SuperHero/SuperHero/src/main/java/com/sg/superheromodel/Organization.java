/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superheromodel;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class Organization {

    private int organizationID;
    private String organizationName;
    private String organizationDescription;
    private String organizationAddress;
    private String organizationPhone;
    private String organizationEmail;
    private List < Super > members = new ArrayList<>();

    //arraylist?

    /**
     * @return the organizationID
     */
    public int getOrganizationID() {
        return organizationID;
    }

    /**
     * @param organizationID the organizationID to set
     */
    public void setOrganizationID(int organizationID) {
        this.organizationID = organizationID;
    }

    /**
     * @return the organizationName
     */
    public String getOrganizationName() {
        return organizationName;
    }

    /**
     * @param organizationName the organizationName to set
     */
    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    /**
     * @return the organizationDescription
     */
    public String getOrganizationDescription() {
        return organizationDescription;
    }

    /**
     * @param organizationDescription the organizationDescription to set
     */
    public void setOrganizationDescription(String organizationDescription) {
        this.organizationDescription = organizationDescription;
    }

    /**
     * @return the organizationAddress
     */
    public String getOrganizationAddress() {
        return organizationAddress;
    }

    /**
     * @param organizationAddress the organizationAddress to set
     */
    public void setOrganizationAddress(String organizationAddress) {
        this.organizationAddress = organizationAddress;
    }

    /**
     * @return the organizationPhone
     */
    public String getOrganizationPhone() {
        return organizationPhone;
    }

    /**
     * @param organizationPhone the organizationPhone to set
     */
    public void setOrganizationPhone(String organizationPhone) {
        this.organizationPhone = organizationPhone;
    }

    /**
     * @return the organizationEmail
     */
    public String getOrganizationEmail() {
        return organizationEmail;
    }

    /**
     * @param organizationEmail the organizationEmail to set
     */
    public void setOrganizationEmail(String organizationEmail) {
        this.organizationEmail = organizationEmail;
    }

    /**
     * @return the members
     */
    public List < Super > getMembers() {
        return members;
    }

    /**
     * @param members the members to set
     */
    public void setMembers(List < Super > members) {
        this.members = members;
    }
}
