/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherocontroller;

import com.sg.superherodao.SightingDao;
import com.sg.superheromodel.Sighting;
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
public class SightingRESTController {
    
    private SightingDao dao;
    
    @Inject
    public SightingRESTController(SightingDao dao) {
        this.dao = dao;
    }
    
    @RequestMapping(value = "/sighting/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Sighting getSighting(@PathVariable("id") int id) {
        return dao.getSightingByID(id);
    }
    
    @RequestMapping(value = "/sighting", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Sighting createSighting(@Valid @RequestBody Sighting sighting) {
        return dao.addSighting(sighting);
    }
    
    @RequestMapping(value = "/sighting/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSighting(@PathVariable("id") int id) {
        dao.deleteSighting(id);
    }
    
    @RequestMapping(value = "/sighting/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateSighting(@PathVariable("id") int id, @Valid @RequestBody Sighting sighting) throws UpdateIntegrityException {

        if (id != sighting.getSightingID()) {
            throw new UpdateIntegrityException("Sighting Id on URL must match Sighting Id in submitted data.");
        }
        dao.updateSighting(sighting);
    }
    
    @RequestMapping(value = "/sightings", method = RequestMethod.GET)
    @ResponseBody
    public List<Sighting> getAllSightings() {
        return dao.getAllSightings();
    }
    
    @RequestMapping(value = "/tenSightings", method = RequestMethod.GET)
        @ResponseBody
    public List<Sighting> getTopTenSightings() {
        return dao.getTopTenSightings();
    }

}
