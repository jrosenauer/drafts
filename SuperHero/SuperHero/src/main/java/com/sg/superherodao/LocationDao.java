/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherodao;

import com.sg.superheromodel.Location;
import com.sg.superheromodel.Super;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface LocationDao {
    
    public Location addLocation (Location location);
    
    public void deleteLocation (int locationID);
    
    public void updateLocation (Location location);
    
    public Location getLocationByID (int locationID);
    
    public List < Location > getAllLocations();
    
    public List < Location > getAllLocationsBySuper(int superID);
    

}
