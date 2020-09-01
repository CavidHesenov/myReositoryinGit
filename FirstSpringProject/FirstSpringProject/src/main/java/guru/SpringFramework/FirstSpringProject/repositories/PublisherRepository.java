package guru.SpringFramework.FirstSpringProject.repositories;

import guru.SpringFramework.FirstSpringProject.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
