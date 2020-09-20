package yo.pruebauno.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import yo.pruebauno.models.FilaVirtual;

@Repository
public interface FilaVirtualRepo extends MongoRepository<FilaVirtual, String> {
    FilaVirtual findFilaByCodigo(String codigo);
}
