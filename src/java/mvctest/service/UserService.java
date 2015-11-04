/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvctest.service;

import java.util.ArrayList;
import java.util.Collection;
import mvctest.entity.Utilisateur;
import org.springframework.stereotype.Service;

/**
 *
 * @author ETY
 */
@Service
public class UserService {

    private Collection<Utilisateur> utils = new ArrayList<Utilisateur>();

    public Iterable<Utilisateur> list() {

        return utils;

    }

    public void ajouter(Utilisateur user) {
        utils.add(user);
    }

    public Utilisateur recherche(Long id) {

        for (Utilisateur util : utils) {
            if (id.equals(util.getId())) {
                return util;
            }
        }
        return null;
    }

    public void update(Utilisateur user) {
        for (Utilisateur util : utils) {
            if (user.getId().equals(util.getId())) {
                util.setAge(user.getAge());
                util.setLogin(user.getLogin());
                util.setMdp(user.getMdp());
                if (user.getEmail() != "") {
                    util.setEmail(user.getEmail());
                }
            }
        }
    }

}
