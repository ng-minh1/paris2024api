package bts.sio.api.repository;

import bts.sio.api.model.Pays;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaysRepository extends CrudRepository<Pays, Long> {

}