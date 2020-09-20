package yo.pruebauno.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import yo.pruebauno.models.Turno;

@Repository
public interface TurnoRepo extends MongoRepository<Turno, String> {
    Turno findTurnoById(int id);
}
