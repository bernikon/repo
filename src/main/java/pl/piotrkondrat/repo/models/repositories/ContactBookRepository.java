package pl.piotrkondrat.repo.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.piotrkondrat.repo.models.ContactBookModel;

@Repository
public interface ContactBookRepository extends CrudRepository <ContactBookModel, Integer>{

}
