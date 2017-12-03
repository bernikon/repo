package pl.piotrkondrat.repo.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.piotrkondrat.repo.models.ContactBookModel;

import java.util.List;

@Repository
public interface ContactBookRepository extends CrudRepository <ContactBookModel, Integer>{
List<ContactBookModel> findByFirstname(String firstname);
}
