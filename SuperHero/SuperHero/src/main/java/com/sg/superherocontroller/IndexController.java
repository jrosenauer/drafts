/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherocontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author apprentice
 */
@Controller
public class IndexController {

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String displayIndex() {
//        return "index";
//    }

    @RequestMapping(value = "/location", method = RequestMethod.GET)
    public String displayLocation() {
        return "Location";
    }

    @RequestMapping(value = "/super", method = RequestMethod.GET)
    public String displaySuper() {
        return "Super";
    }

    @RequestMapping(value = "/organization", method = RequestMethod.GET)
    public String displayOrganization() {
        return "Organization";
    }

    @RequestMapping(value = "/sighting", method = RequestMethod.GET)
    public String displaySighting() {
        return "Sighting";
    }
}
