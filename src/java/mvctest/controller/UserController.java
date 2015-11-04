/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvctest.controller;

import mvctest.entity.Utilisateur;
import mvctest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ETY
 */

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping(value = "/lister", method = RequestMethod.GET) //La route
    public String lister(Model model) {
        model.addAttribute("users", service.list());
        return "user/user_list"; //La vue à afficher
    }
    
        @RequestMapping(value = "/ajouter", method = RequestMethod.GET) //La route
    public String ajouterGet(Model model,Utilisateur user) {
        Utilisateur u=new Utilisateur();
        u.setLogin("Ecrire le login");
        u.setMdp("Ecrire le mdp");
        model.addAttribute("util", u);
        return "user/user_ajouter"; //La vue à afficher
    }
    
    @RequestMapping(value = "/ajouter", method = RequestMethod.POST) //La route
    public String ajouterPost(@ModelAttribute("util") Utilisateur user) {
        service.ajouter(user);
        return "redirect:/lister"; //La vue à afficher
    }
    
    @RequestMapping(value = "/modifier/{monId}", method = RequestMethod.GET) //La route
    public String modifierGet(@PathVariable("monId") long monId, Model model) {
        Utilisateur u =service.recherche(monId);
        model.addAttribute("util", u);
        return "user/user_update"; //La vue à afficher
    }

    @RequestMapping(value = "/modifier/{monId}", method = RequestMethod.POST) //La route
    public String modifierPost(@ModelAttribute("util") Utilisateur user) {
        service.update(user);
        return "redirect:/lister"; //La vue à afficher
    }
}
