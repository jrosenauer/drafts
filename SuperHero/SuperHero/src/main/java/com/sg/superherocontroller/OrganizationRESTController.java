/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherocontroller;

import com.sg.superherodao.OrganizationDao;
import com.sg.superheromodel.Organization;
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
public class OrganizationRESTController {
    
    private OrganizationDao dao;
    
    @Inject
    public OrganizationRESTController(OrganizationDao dao) {
        this.dao = dao;
    }
    
    @RequestMapping(value = "/organization/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Organization getOrganization(@PathVariable("id") int id) {
        return dao.getOrganizationByID(id);
    }
    
    @RequestMapping(value = "/organization", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Organization createOrganization(@Valid @RequestBody Organization organization) {
        return dao.addOrganization(organization);
    }
    
    @RequestMapping(value = "/organization/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrganization(@PathVariable("id") int id) {
        dao.deleteOrganization(id);
    }
    
    @RequestMapping(value = "/organization/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateOrganization(@PathVariable("id") int id, @Valid @RequestBody Organization organization) throws UpdateIntegrityException {

        if (id != organization.getOrganizationID()) {
            throw new UpdateIntegrityException("Organization Id on URL must match Organization Id in submitted data.");
        }
        dao.updateOrganization(organization);
    }
    
    @RequestMapping(value = "/organizations", method = RequestMethod.GET)
    @ResponseBody
    public List<Organization> getAllOrganization() {
        return dao.getAllOrganizations();
    }
}
