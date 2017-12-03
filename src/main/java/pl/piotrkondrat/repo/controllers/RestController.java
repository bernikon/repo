package pl.piotrkondrat.repo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.piotrkondrat.repo.models.repositories.ContactBookRepository;

@Controller
public class RestController {

    @Autowired
    ContactBookRepository contactBookRepository;

    @RequestMapping(value = "/rest/contact", method = RequestMethod.GET,
    produces = "application/json")
    public ResponseEntity contact(){
        return new ResponseEntity(contactBookRepository.findAll(), HttpStatus.OK);
    }

}
