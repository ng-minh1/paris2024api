package bts.sio.api.controller;

import bts.sio.api.model.Joueur;
import bts.sio.api.service.JoueurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class JoueurController {

    @Autowired
    private JoueurService joueurService;


    @GetMapping("/joueurs")
    public Iterable<Joueur> getJoueurs() {
        return joueurService.getJoueurs();
    }

}
