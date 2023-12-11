package springrest.springrest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import springrest.springrest.models.PersonModel;
import springrest.springrest.services.PersonService;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonModel> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonModel findById(@PathVariable(value = "id") Long id) {
        return service.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonModel create(@RequestBody PersonModel person) {
        return service.create(person);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonModel update(@RequestBody PersonModel person) {
        return service.update(person);
    }


    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
    }
}
