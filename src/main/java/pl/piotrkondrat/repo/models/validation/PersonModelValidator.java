package pl.piotrkondrat.repo.models.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.piotrkondrat.repo.models.PersonModel;
import pl.piotrkondrat.repo.models.repositories.PersonRepository;


@Component
public class PersonModelValidator {

    @Autowired
    PersonRepository personRepository;

    public String validateData(PersonModel person) {
        if (person.getLastname() == null || person.getLastname().isEmpty()) {
            return "Lastname cannot be empty";
        }

        if (personRepository.existsByLastnameEquals(person.getLastname())) {
            return "This lastname is already exist";
        }

        return null;
    }
}
