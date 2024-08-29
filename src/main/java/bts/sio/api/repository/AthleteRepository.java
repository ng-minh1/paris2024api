package bts.sio.api.repository;

import bts.sio.api.model.Athlete;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AthleteRepository extends CrudRepository<Athlete, Long> {

}