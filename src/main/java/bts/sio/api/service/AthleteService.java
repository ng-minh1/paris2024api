package bts.sio.api.service;

import bts.sio.api.model.Athlete;
import bts.sio.api.model.Sport;
import bts.sio.api.repository.AthleteRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Data
@Service
public class AthleteService {
    @Autowired
    private AthleteRepository athleteRepository;

    public Optional<Athlete> getAthlete(final Long id) {
        return athleteRepository.findById(id);
    }

    public Iterable<Athlete> getAthletes() {
        return athleteRepository.findAll();
    }

    public void deleteAthlete(final Long id) {
        athleteRepository.deleteById(id);
    }

    public Athlete saveAthlete(Athlete athlete) {
        if (athlete.getId() == 0) {
            athlete.setId(null);
        }
        return athleteRepository.save(athlete);
    }

    public List<Athlete> getAthletesBySport(Long sportId) {
        return athleteRepository.findBySportId(sportId); // Appel de la méthode repository
    }

    public List<Athlete> getAthletesByPays(Long paysId) {
        return athleteRepository.findByPaysId(paysId); // Appel de la méthode repository
    }
}
