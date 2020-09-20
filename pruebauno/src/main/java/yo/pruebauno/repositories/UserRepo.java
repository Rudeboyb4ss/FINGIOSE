package yo.pruebauno.repositories;

import yo.pruebauno.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepo extends MongoRepository<User, String> {

    User findUserByRut(String rut);

}
