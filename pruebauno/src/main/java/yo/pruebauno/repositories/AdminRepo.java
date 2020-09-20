package yo.pruebauno.repositories;

import yo.pruebauno.models.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AdminRepo extends MongoRepository<Admin, String>{
    @Override
    List<Admin> findAll();
    Admin findAdminByRut(String rut);
}
