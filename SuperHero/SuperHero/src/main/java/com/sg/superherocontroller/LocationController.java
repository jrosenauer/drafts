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
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author apprentice
 */
@Controller
public class LocationController {

    LocationDao dao;

    @Inject
    public LocationController(LocationDao dao) {
        this.dao = dao;
    }
    
    @RequestMapping(value = "/displayLocationPage", method = RequestMethod.GET)
    public String displayLocationPage(Model model) {
        List<Location> locationList = dao.getAllLocations();
        model.addAttribute("locationList", locationList);
        return "Location";
    }

    @RequestMapping(value = "/createLocation", method = RequestMethod.POST)
    public String createLocation(HttpServletRequest request) {
        Location location = new Location();
        location.setLocationName(request.getParameter("locationName"));
        location.setLocationDescription(request.getParameter("locationDescription"));
        location.setLocationAddress(request.getParameter("locationAddress"));
        location.setLocationLongitude(Double.parseDouble(request.getParameter("locationLongitude")));
        location.setLocationLatitude(Double.parseDouble(request.getParameter("locationLatitude")));
        dao.addLocation(location);
        
        return "redirect:/displayLocationPage";
    }

    @RequestMapping(value = "/displayLocationDetails", method = RequestMethod.GET)
    public String displayLocationDetails(HttpServletRequest request, Model model) {
        String locationIDParameter = request.getParameter("locationID");
        int locationID = Integer.parseInt(locationIDParameter);
        Location location = dao.getLocationByID(locationID);
        model.addAttribute("location", location);
        return "LocationDetails";
    }

    @RequestMapping(value = "/deleteLocation", method = RequestMethod.GET)
    public String deleteLocation(HttpServletRequest request) {
        String locationIDParameter = request.getParameter("locationID");
        int locationID = Integer.parseInt(locationIDParameter);
        dao.deleteLocation(locationID);
        return "redirect:displayLocationPage";
    }

    @RequestMapping(value = "/displayEditLocationForm", method = RequestMethod.GET)
    public String displayEditLocationForm(HttpServletRequest request, Model model) {
        String locationIDParameter = request.getParameter("locationID");
        int locationID = Integer.parseInt(locationIDParameter);
        Location location = dao.getLocationByID(locationID);
        model.addAttribute(location);
        return "LocationEdit";
    }

    @RequestMapping(value = "/editLocation", method = RequestMethod.POST)
    public String editLocation(@Valid @ModelAttribute("location") Location location) {
        dao.updateLocation(location);
        return "redirect:displayLocationPage";
    }
}
