package co.com.sofka.biblioteca.Repositories;

import co.com.sofka.biblioteca.Models.Recurso;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioRecurso extends MongoRepository<Recurso, String> {
}
