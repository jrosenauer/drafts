/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superheromodel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author apprentice
 */
public class Location {

    public int locationID;
    public String locationName;
    public String locationDescription;
    public String locationAddress;
    public double locationLatitude;
    public double locationLongitude;
    //public List< Super> supers = new ArrayList<>();

    /**
     * @return the locationID
     */
    public int getLocationID() {
        return locationID;
    }

    /**
     * @param locationID the locationID to set
     */
    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    /**
     * @return the locationName
     */
    public String getLocationName() {
        return locationName;
    }

    /**
     * @param locationName the locationName to set
     */
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    /**
     * @return the locationDescription
     */
    public String getLocationDescription() {
        return locationDescription;
    }

    /**
     * @param locationDescription the locationDescription to set
     */
    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    /**
     * @return the locationAddress
     */
    public String getLocationAddress() {
        return locationAddress;
    }

    /**
     * @param locationAddress the locationAddress to set
     */
    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    /**
     * @return the locationLatitude
     */
    public double getLocationLatitude() {
        return locationLatitude;
    }

    /**
     * @param locationLatitude the locationLatitude to set
     */
    public void setLocationLatitude(double locationLatitude) {
        this.locationLatitude = locationLatitude;
    }

    /**
     * @return the locationLongitude
     */
    public double getLocationLongitude() {
        return locationLongitude;
    }

    /**
     * @param locationLongitude the locationLongitude to set
     */
    public void setLocationLongitude(double locationLongitude) {
        this.locationLongitude = locationLongitude;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.locationID;
        hash = 61 * hash + Objects.hashCode(this.locationName);
        hash = 61 * hash + Objects.hashCode(this.locationDescription);
        hash = 61 * hash + Objects.hashCode(this.locationAddress);
        hash = 61 * hash + (int) (Double.doubleToLongBits(this.locationLatitude) ^ (Double.doubleToLongBits(this.locationLatitude) >>> 32));
        hash = 61 * hash + (int) (Double.doubleToLongBits(this.locationLongitude) ^ (Double.doubleToLongBits(this.locationLongitude) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Location other = (Location) obj;
        if (this.locationID != other.locationID) {
            return false;
        }
        if (Double.doubleToLongBits(this.locationLatitude) != Double.doubleToLongBits(other.locationLatitude)) {
            return false;
        }
        if (Double.doubleToLongBits(this.locationLongitude) != Double.doubleToLongBits(other.locationLongitude)) {
            return false;
        }
        if (!Objects.equals(this.locationName, other.locationName)) {
            return false;
        }
        if (!Objects.equals(this.locationDescription, other.locationDescription)) {
            return false;
        }
        if (!Objects.equals(this.locationAddress, other.locationAddress)) {
            return false;
        }
        return true;
    }
    
    
}
