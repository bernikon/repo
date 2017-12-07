package pl.piotrkondrat.repo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.piotrkondrat.repo.models.PersonModel;
import pl.piotrkondrat.repo.models.repositories.PersonRepository;

@Controller
public class RestController {

    @Autowired
    PersonRepository personRepository;


// źle mapuje

    @RequestMapping(value = "/rest/people", method = RequestMethod.GET,
            produces = "application/json")
    public ResponseEntity people() {
        return new ResponseEntity(personRepository.findAll(), HttpStatus.OK);
    }

// do persona o id 1 przypisuje kontakty z 1 i 2 ???

    @RequestMapping(value = "/rest/people/{lastname}", method = RequestMethod.GET,
            produces = "application/json")
    public ResponseEntity people(@PathVariable("lastname") String lastname) {
        return new ResponseEntity(personRepository.findByLastnameIgnoreCase(lastname), HttpStatus.OK);
    }

    @RequestMapping(value = "/rest/people/delete/{id}", method = RequestMethod.DELETE,
            produces = "application/json")
    public ResponseEntity people(@PathVariable("id") int id) {
        personRepository.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

//    @RequestMapping(method = RequestMethod.POST)
//    public ResponseEntity<?> addPerson(@RequestBody PersonModel personModel) {
//        return new ResponseEntity<>(personRepository.save(personModel), HttpStatus.CREATED);
//    }


//    @RequestMapping(value = "/rest/contact", method = RequestMethod.POST,
//            produces = "application/json")
//    public ResponseEntity contact(@RequestBody PersonModel model) {
//        personRepository.save(model);
//        return new ResponseEntity(HttpStatus.OK);
//    }

}
