/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherocontroller;

import com.sg.superherodao.SuperDao;
import com.sg.superheromodel.Super;
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
public class SuperRESTController {
    
    private SuperDao dao;
    
    @Inject
    public SuperRESTController(SuperDao dao) {
        this.dao = dao;
    }
    
    
    @RequestMapping(value = "/super/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Super getSuper(@PathVariable("id") int id) {
        return dao.getSuperByID(id);
    }
    
    @RequestMapping(value = "/super", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Super createSuper(@Valid @RequestBody Super superPerson) {
        return dao.addSuper(superPerson);
    }
    
    @RequestMapping(value = "/super/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSuper(@PathVariable("id") int id) {
        dao.deleteSuper(id);
    }
    
    @RequestMapping(value = "/super/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateSuper(@PathVariable("id") int id, @Valid @RequestBody Super superPerson) throws UpdateIntegrityException {

        if (id != superPerson.getSuperID()) {
            throw new UpdateIntegrityException("Super Id on URL must match Super Id in submitted data.");
        }
        dao.updateSuper(superPerson);
    }
    
    @RequestMapping(value = "/supers", method = RequestMethod.GET)
    @ResponseBody
    public List<Super> getAllSupers() {
        return dao.getAllSupers();
    }
}
