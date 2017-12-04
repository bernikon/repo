package pl.piotrkondrat.repo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.piotrkondrat.repo.models.PersonModel;
import pl.piotrkondrat.repo.models.repositories.PersonRepository;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping("/")
    @ResponseBody
    public String index() {
        List<PersonModel> personModel = personRepository.findByFirstname("Jan");
        StringBuilder stringBuilder = new StringBuilder();
        for (PersonModel model : personModel) {
            stringBuilder.append(model.toString());
        }
        return stringBuilder.toString();
    }
}
