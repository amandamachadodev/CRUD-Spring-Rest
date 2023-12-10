package springrest.springrest.services;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springrest.springrest.models.PersonModel;
import springrest.springrest.respositories.PersonRepository;

@Service
public class PersonService {
    @Autowired
    PersonRepository respository;
    private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<PersonModel> findAll() {

        logger.info("Finding all people!");

        List<PersonModel> persons = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            PersonModel person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    public PersonModel findById(String id) {

        logger.info("Finding one person!");

        PersonModel person = new PersonModel();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Leandro");
        person.setLastName("Costa");
        person.setAddress("Uberlândia - Minas Gerais - Brasil");
        person.setGender("Male");
        return person;
    }

    public PersonModel create(PersonModel person) {
        logger.info("Creating one person!");

        PersonModel newPerson = new PersonModel(person.getFirstName(), person.getLastName(),
                person.getAddress(), person.getGender());
        respository.save(newPerson);


        return person;
    }

    public PersonModel update(PersonModel person) {

        logger.info("Updating one person!");

        return person;
    }

    public void delete(String id) {

        logger.info("Deleting one person!");
    }

    private PersonModel mockPerson(int i) {

        PersonModel person = new PersonModel();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name " + i);
        person.setLastName("Last name " + i);
        person.setAddress("Some address in Brasil " + i);
        person.setGender("Male");
        return person;
    }
}
