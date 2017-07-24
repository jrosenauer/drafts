/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherocontroller;

import com.sg.superherodao.LocationDao;
import com.sg.superherodao.SightingDao;
import com.sg.superherodao.SuperDao;
import com.sg.superheromodel.Location;
import com.sg.superheromodel.Sighting;
import com.sg.superheromodel.Super;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
public class SightingController {

    SightingDao dao;
    LocationDao Ldao;
    SuperDao Sdao;

    @Inject
    public SightingController(SightingDao dao, LocationDao Ldao, SuperDao Sdao) {
        this.dao = dao;
        this.Ldao = Ldao;
        this.Sdao = Sdao;
    }

    @RequestMapping(value = "/displaySightingPage", method = RequestMethod.GET)
    public String displaySightingPage(Model model) {
        List<Sighting> sightingList = dao.getAllSightings();
        model.addAttribute("sightingList", sightingList);
        model.addAttribute("locationList", Ldao.getAllLocations());
        model.addAttribute("superList", Sdao.getAllSupers());
        return "Sighting";
    }

    @RequestMapping(value = "/createSighting", method = RequestMethod.POST)
    public String createSighting(HttpServletRequest request) {
        Sighting sighting = new Sighting();

        String locationIDParameter = request.getParameter("locationID");
        int locationID = Integer.parseInt(locationIDParameter);
        Location location = new Location();
        location = Ldao.getLocationByID(locationID);

        String superIDParameter = request.getParameter("superID");
        int superID = Integer.parseInt(superIDParameter);
        Super super2 = new Super();
        super2 = Sdao.getSuperByID(superID);

        String sightingDateParameter = (request.getParameter("sightingDate"));
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyy-MM-dd");
        LocalDate sightingDate = LocalDate.parse(sightingDateParameter, dateFormat);

        sighting.setLocation(location);
        sighting.setSightingDate(sightingDate);
        sighting.setLocationID(locationID);

        List<Super> supers3 = new ArrayList<>();
        supers3.add(super2);

        sighting.setSupers(supers3);

        dao.addSighting(sighting);
        return "redirect:displaySightingPage";

    }

    @RequestMapping(value = "/displaySightingDetails", method = RequestMethod.GET)
    public String displaySightingDetails(HttpServletRequest request, Model model) {
        String sightingIDParameter = request.getParameter("sightingID");
        int sightingID = Integer.parseInt(sightingIDParameter);
        Sighting sighting = dao.getSightingByID(sightingID);
        model.addAttribute("sighting", sighting);
        return "sighting";
    }

    @RequestMapping(value = "/deleteSighting", method = RequestMethod.GET)
    public String deleteSighting(HttpServletRequest request) {
        String sightingIDParameter = request.getParameter("sightingID");
        int sightingID = Integer.parseInt(sightingIDParameter);
        Sighting sighting = dao.getSightingByID(sightingID);
        dao.deleteSighting(sightingID);
        return "redirect:displaySightingPage";
    }

    @RequestMapping(value = "/displayEditSightingForm", method = RequestMethod.GET)
    public String displayEditSightingForm(HttpServletRequest request, Model model) {
        String sightingIDParameter = request.getParameter("sightingID");
        int sightingID = Integer.parseInt(sightingIDParameter);
        Sighting sighting = dao.getSightingByID(sightingID);
//        sighting.setLocation(Ldao.getLocationByID(sighting.getLocationID()));
        //sighting.setSuperID(Sdao.getSuperByID(sighting.getSuperID()));
        model.addAttribute(sighting);
        return "SightingEdit";
    }

    @RequestMapping(value = "/editSighting", method = RequestMethod.POST)
    public String editSighting(@Valid @ModelAttribute("sighting") Sighting sighting, BindingResult result) {
        if (result.hasErrors()) {
            return "SightingEdit";
        }
        dao.updateSighting(sighting);
        return "redirect:displaySightingPage";
    }
}
