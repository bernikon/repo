package pl.piotrkondrat.repo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.piotrkondrat.repo.models.ContactModel;
import pl.piotrkondrat.repo.models.PersonModel;
import pl.piotrkondrat.repo.models.repositories.PersonRepository;
import pl.piotrkondrat.repo.models.validation.PersonModelValidator;

@Controller
public class RestController {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonModelValidator personModelValidator;


    @RequestMapping(value = "/rest/people-search", method = RequestMethod.GET,
            produces = "application/json")
    public ResponseEntity peopleIndex() {
        return new ResponseEntity(personRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/rest/people-search/{lastname}", method = RequestMethod.GET,
            produces = "application/json")
    public ResponseEntity people(@PathVariable("lastname") String lastname) {
        return new ResponseEntity(personRepository.findByLastnameIgnoreCase(lastname), HttpStatus.OK);
    }

    @RequestMapping(value = "/rest/people/{id}", method = RequestMethod.DELETE,
            produces = "application/json")
    public ResponseEntity people(@PathVariable("id") Long id) {
        personRepository.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/rest/people", method = RequestMethod.POST,
            produces = "application/json")
    public ResponseEntity addPerson(@RequestBody PersonModel model) {
        String error = personModelValidator.validateData(model);
        if (error != null) {
            return new ResponseEntity(error, HttpStatus.CONFLICT);
        }

        for (ContactModel contact : model.getContacts()) {
            contact.setPerson(model);
        }

        personRepository.save(model);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/rest/people/{id}/{firstname}/{lastname}/{gender}", method = RequestMethod.PUT,
            produces = "application/json")
    public ResponseEntity peopleChange(@PathVariable("id") Long id,
                                       @PathVariable("firstname") String firstname,
                                       @PathVariable("lastname") String lastname,
                                       @PathVariable("gender") String gender) {
        PersonModel model = personRepository.findOne(id);

        if (personRepository.existsByLastnameEquals(lastname)) {
            return new ResponseEntity("This lastname is already exist", HttpStatus.CONFLICT);
        }
        model.setFirstname(firstname);
        model.setLastname(lastname);
        model.setGender(gender);
        personRepository.save(model);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/rest/people", method = RequestMethod.PUT,
            produces = "application/json")
    public ResponseEntity responseAct(@RequestBody PersonModel personModel) {
        String error = personModelValidator.validateData(personModel);
        if (error != null) {
            return new ResponseEntity(error, HttpStatus.CONFLICT);
        }

        for (ContactModel contact : personModel.getContacts()) {
            contact.setPerson(personModel);
        }

        personRepository.save(personModel);
        return new ResponseEntity((HttpStatus.OK));
    }

}
