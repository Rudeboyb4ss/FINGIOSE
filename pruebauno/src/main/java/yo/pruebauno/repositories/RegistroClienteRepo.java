package yo.pruebauno.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import yo.pruebauno.models.FilaVirtual;
import yo.pruebauno.models.User;

public interface RegistroClienteRepo extends MongoRepository<FilaVirtual, String> {

}
