/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherocontroller;

import com.sg.superherodao.LocationDao;
import com.sg.superheromodel.Location;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author apprentice
 */
@CrossOrigin
@Controller
public class LocationRESTController {
    
    private LocationDao dao;
    
    @Inject
    public LocationRESTController(LocationDao dao) {
        this.dao = dao;
    }
    
    @RequestMapping(value = "/location/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Location getLocation(@PathVariable("id") int id) {
        return dao.getLocationByID(id);
    }
    
    @RequestMapping(value = "/location", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Location createLocation(@Valid @RequestBody Location location) {
        return dao.addLocation(location);
    }
    
    @RequestMapping(value = "/location/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLocation(@PathVariable("id") int id) {
        dao.deleteLocation(id);
    }
    
    @RequestMapping(value = "/location/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateLocation(@PathVariable("id") int id, @Valid @RequestBody Location location) throws UpdateIntegrityException {

        if (id != location.getLocationID()) {
            throw new UpdateIntegrityException("Location Id on URL must match Location Id in submitted data.");
        }
        dao.updateLocation(location);
    }
    
    @RequestMapping(value = "/locations", method = RequestMethod.GET)
    @ResponseBody
    public List<Location> getAllLocations() {
        return dao.getAllLocations();
    }
}
