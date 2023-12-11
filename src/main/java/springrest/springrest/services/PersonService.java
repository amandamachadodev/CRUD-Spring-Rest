package springrest.springrest.services;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.ListQuerydslPredicateExecutor;
import org.springframework.stereotype.Service;
import springrest.springrest.models.PersonModel;
import springrest.springrest.respositories.PersonRepository;

@Service
public class PersonService {
    @Autowired
    PersonRepository repository;
    private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<PersonModel> findAll() {
        logger.info("Finding all people!");
        return repository.findAll();
    }

    public PersonModel findById(Long id) {
        logger.info("Finding one person!");
        return repository.findById(id).orElseThrow(() -> new RuntimeException("No records found for this ID!"));
    }

    public PersonModel create(PersonModel person) {
        logger.info("Creating one person!");
        repository.save(person);
        return person;
    }

    public PersonModel update(PersonModel person) {
        logger.info("Updating one person!");
        var entity = repository.findById(person.getId())
                .orElseThrow(() -> new RuntimeException("No records found for this ID!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(person);
    }

    public void delete(Long id) {
        logger.info("Deleting one person!");
        var entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No records found for this ID!"));
        repository.delete(entity);
    }

}
