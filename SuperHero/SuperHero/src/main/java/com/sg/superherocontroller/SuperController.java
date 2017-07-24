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
public class SuperController {

    SuperDao dao;

    @Inject
    public SuperController(SuperDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/displaySuperPage", method = RequestMethod.GET)
    public String displaySuperPage(Model model) {
        List<Super> superList = dao.getAllSupers();
        model.addAttribute("superList", superList);
        return "Super";
    }

    @RequestMapping(value = "/createSuper", method = RequestMethod.POST)
    public String createSuper(HttpServletRequest request) {
        Super superPerson = new Super();
        superPerson.setSuperName(request.getParameter("superName"));
        superPerson.setSuperDescription(request.getParameter("superDescription"));
        superPerson.setSuperPower(request.getParameter("superPower"));
        dao.addSuper(superPerson);
        return "redirect:displaySuperPage";
    }

    @RequestMapping(value = "/displaySuperDetails", method = RequestMethod.GET)
    public String displaySuperDetails(HttpServletRequest request, Model model) {
        String superIDParameter = request.getParameter("superID");
        int superID = Integer.parseInt(superIDParameter);
        Super superPerson = dao.getSuperByID(superID);
        model.addAttribute("superPerson", superPerson);
        return "SuperDetails";
    }

    @RequestMapping(value = "/deleteSuper", method = RequestMethod.GET)
    public String deleteSuper(HttpServletRequest request) {
        String superIDParameter = request.getParameter("superID");
        int superID = Integer.parseInt(superIDParameter);
        dao.deleteSuper(superID);
        return "redirect:displaySuperPage";
    }

    @RequestMapping(value = "/displayEditSuperForm", method = RequestMethod.GET)
    public String displayEditSuperForm(HttpServletRequest request, Model model) {
        String superIDParameter = request.getParameter("superID");
        int superID = Integer.parseInt(superIDParameter);
        Super superPerson = dao.getSuperByID(superID);
        model.addAttribute("superPerson", superPerson);
        return "SuperEdit";
    }

    @RequestMapping(value = "/editSuper", method = RequestMethod.POST)
    public String editSuper(@Valid @ModelAttribute("superPerson") Super superPerson) {
        dao.updateSuper(superPerson);
        return "redirect:displaySuperPage";
    }
}
