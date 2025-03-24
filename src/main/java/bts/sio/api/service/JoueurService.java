package bts.sio.api.service;

import bts.sio.api.model.Joueur;
import bts.sio.api.repository.JoueurRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Data
@Service
public class JoueurService {
    @Autowired
    private JoueurRepository JoueurRepository;

    public Iterable<Joueur> getJoueurs() { return JoueurRepository.findAll(); }

}
