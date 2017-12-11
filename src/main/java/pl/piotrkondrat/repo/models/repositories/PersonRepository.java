package pl.piotrkondrat.repo.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import pl.piotrkondrat.repo.models.ContactModel;
import pl.piotrkondrat.repo.models.PersonModel;


import java.util.List;

public interface PersonRepository extends CrudRepository<PersonModel, Long> {
    List<PersonModel> findByLastnameIgnoreCase(String text);

    boolean existsByLastnameEquals(String lastname);
}

