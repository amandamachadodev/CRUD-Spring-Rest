package springrest.springrest.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springrest.springrest.models.PersonModel;

public interface PersonRepository extends JpaRepository<PersonModel, Long> {
}
