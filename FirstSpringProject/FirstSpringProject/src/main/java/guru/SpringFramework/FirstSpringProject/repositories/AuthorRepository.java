package guru.SpringFramework.FirstSpringProject.repositories;

import guru.SpringFramework.FirstSpringProject.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
