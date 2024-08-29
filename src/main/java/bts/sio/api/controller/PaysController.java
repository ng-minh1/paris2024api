package bts.sio.api.controller;

import bts.sio.api.model.Pays;
import bts.sio.api.service.PaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaysController {

    @Autowired
    private PaysService paysService;

    /**
     * Read - Get all apys
     * @return - An Iterable object of Pays full filled
     */
    @GetMapping("/pays")
    public Iterable<Pays> getAthletes() {
        return paysService.getLesPays();
    }
}
