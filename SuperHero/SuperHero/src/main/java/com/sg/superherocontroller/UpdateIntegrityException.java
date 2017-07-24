/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherocontroller;

/**
 *
 * @author apprentice
 */
public class UpdateIntegrityException extends Exception {
    
    private String message;
    
    public UpdateIntegrityException (String message) {
        this.message = message;
    }
}
