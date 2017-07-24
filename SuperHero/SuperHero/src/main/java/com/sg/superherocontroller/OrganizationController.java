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
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author apprentice
 */
@Controller
public class OrganizationController {

    OrganizationDao dao;

    @Inject
    public OrganizationController(OrganizationDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/displayOrganizationPage", method = RequestMethod.GET)
    public String displayOrganizationPage(Model model) {
        List<Organization> organizationList = dao.getAllOrganizations();
        model.addAttribute("organizationList", organizationList);
        return "Organization";
    }

    @RequestMapping(value = "/createOrganization", method = RequestMethod.POST)
    public String createOrganization(HttpServletRequest request) {
        Organization organization = new Organization();
        organization.setOrganizationName(request.getParameter("organizationName"));
        organization.setOrganizationAddress(request.getParameter("organizationAddress"));
        organization.setOrganizationDescription(request.getParameter("organizationDescription"));
        organization.setOrganizationPhone(request.getParameter("organizationPhone"));
        organization.setOrganizationEmail(request.getParameter("organizationEmail"));
        dao.addOrganization(organization);
        return "redirect:displayOrganizationPage";
    }

    @RequestMapping(value = "/displayOrganizationDetails", method = RequestMethod.GET)
    public String displayOrganizationDetails(HttpServletRequest request, Model model) {
        String organizationIDParameter = request.getParameter("organizationID");
        int organizationID = Integer.parseInt(organizationIDParameter);
        Organization organization = dao.getOrganizationByID(organizationID);
        model.addAttribute("organization", organization);
        return "organizationDetails";
    }
    
    @RequestMapping(value = "/deleteOrganization", method = RequestMethod.GET)
    public String deleteOrganization(HttpServletRequest request) {
        String organizationIDParameter = request.getParameter("organizationID");
        int organizationID = Integer.parseInt(organizationIDParameter);
        dao.deleteOrganization(organizationID);
        return "redirect:displayOrganizationPage";
    }
    
    @RequestMapping(value = "/displayEditOrganizationForm", method = RequestMethod.GET)
    public String displayEditOrganizationForm(HttpServletRequest request, Model model) {
        String organizationIDParameter = request.getParameter("organizationID");
        int organizationID = Integer.parseInt(organizationIDParameter);
        Organization organization = dao.getOrganizationByID(organizationID);
        model.addAttribute(organization);
        return "OrganizationEdit";
    }
    
    @RequestMapping(value = "/editOrganization", method = RequestMethod.POST)
    public String editOrganization(@Valid @ModelAttribute("organization") Organization organization) {
        dao.updateOrganization(organization);
        return "redirect:displayOrganizationPage";
    }
}
