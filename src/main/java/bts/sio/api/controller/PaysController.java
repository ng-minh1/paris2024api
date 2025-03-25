package bts.sio.api.controller;

import bts.sio.api.model.Pays;
import bts.sio.api.model.Sport;
import bts.sio.api.service.PaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

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

    @GetMapping("/pays/{id}")
    public Pays getPays(@PathVariable("id") final Long id) {
        Optional<Pays> pays = paysService.getPays(id);
        if(pays.isPresent()) {
            return pays.get();
        } else {
            return null;
        }
    }
}
