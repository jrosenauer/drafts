/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superheromodel;

/**
 *
 * @author apprentice
 */
public class Super {

    private int superID;
    private String superName;
    private String superDescription;
   private String superPower;

   public Super() {
       
   }
   
   public Super(String superName) {
       this.superName = superName;
   }

    /**
     * @return the superID
     */
    public int getSuperID() {
        return superID;
    }

    /**
     * @param superID the superID to set
     */
    public void setSuperID(int superID) {
        this.superID = superID;
    }

    /**
     * @return the superName
     */
    public String getSuperName() {
        return superName;
    }

    /**
     * @param superName the superName to set
     */
    public void setSuperName(String superName) {
        this.superName = superName;
    }

    /**
     * @return the superDescription
     */
    public String getSuperDescription() {
        return superDescription;
    }

    /**
     * @param superDescription the superDescription to set
     */
    public void setSuperDescription(String superDescription) {
        this.superDescription = superDescription;
    }

    /**
     * @return the superPower
     */
    public String getSuperPower() {
        return superPower;
    }

    /**
     * @param superPower the superPower to set
     */
    public void setSuperPower(String superPower) {
        this.superPower = superPower;
    }

}
