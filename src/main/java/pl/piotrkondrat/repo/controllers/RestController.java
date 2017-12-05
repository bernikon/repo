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


    @RequestMapping(value = "/rest/contact", method = RequestMethod.GET,
            produces = "application/json")
    public ResponseEntity contact() {
        return new ResponseEntity(personRepository.findAll(), HttpStatus.OK);
    }

// tu wywala:
// HttpMessageNotWritableException: Could not write JSON: Infinite recursion (StackOverflowError);
// nested exception is com.fasterxml.jackson.databind.JsonMappingException...

//    @RequestMapping(value = "/rest/person/{lastname}", method = RequestMethod.GET,
//            produces = "application/json")
//    public ResponseEntity person(@PathVariable("lastname") String lastname) {
//        return new ResponseEntity(personRepository.findByLastnameIgnoreCase(lastname), HttpStatus.OK);
//    }

//    @RequestMapping(value = "/rest/person/delete/{id}", method = RequestMethod.DELETE,
//            produces = "application/json")
//    public ResponseEntity person(@PathVariable("id") int id) {
//        personRepository.delete(id);
//        return new ResponseEntity(HttpStatus.OK);
//    }


//    @RequestMapping(value = "/rest/contact", method = RequestMethod.POST,
//            produces = "application/json")
//    public ResponseEntity contact(@RequestBody PersonModel model) {
//        personRepository.save(model);
//        return new ResponseEntity(HttpStatus.OK);
//    }

}
