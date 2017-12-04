package pl.piotrkondrat.repo.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.piotrkondrat.repo.models.PersonModel;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository <PersonModel, Integer>{
List<PersonModel> findByFirstname(String firstname);
}
