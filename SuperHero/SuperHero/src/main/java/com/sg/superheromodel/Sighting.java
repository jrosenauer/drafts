/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superheromodel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class Sighting {

    private int sightingID;
    private LocalDate sightingDate;
    private int locationID;
    private List< Integer> superID;
    private Location location;
    private List<Super> supers = new ArrayList<>();

    /**
     * @return the sightingID
     */
    public int getSightingID() {
        return sightingID;
    }

    /**
     * @param sightingID the sightingID to set
     */
    public void setSightingID(int sightingID) {
        this.sightingID = sightingID;
    }

    /**
     * @return the sightingDate
     */
    public LocalDate getSightingDate() {
        return sightingDate;
    }

    /**
     * @param sightingDate the sightingDate to set
     */
    public void setSightingDate(LocalDate sightingDate) {
        this.sightingDate = sightingDate;
    }

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
     * @return the superID
     */
    public List< Integer> getSuperID() {
        return superID;
    }

    /**
     * @param superID the superID to set
     */
    public void setSuperID(List< Integer> superID) {
        this.superID = superID;
    }

    /**
     * @return the location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * @return the supers
     */
    public List< Super> getSupers() {
        return supers;
    }

    /**
     * @param supers the supers to set
     */
    public void setSupers(List< Super> supers) {
        this.supers = supers;
    }

}
