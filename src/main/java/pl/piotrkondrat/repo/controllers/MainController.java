package pl.piotrkondrat.repo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.piotrkondrat.repo.models.ContactBookModel;
import pl.piotrkondrat.repo.models.repositories.ContactBookRepository;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    ContactBookRepository contactBookRepository;

    @GetMapping("/")
    @ResponseBody
    public String index() {
        List<ContactBookModel> contactBookModel = contactBookRepository.findByFirstname("Jan");
        StringBuilder stringBuilder = new StringBuilder();
        for (ContactBookModel model : contactBookModel) {
            stringBuilder.append(model.toString());
        }
        return stringBuilder.toString();
    }
}
