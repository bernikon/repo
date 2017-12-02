package pl.piotrkondrat.repo.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactBookRepository extends CrudRepository <ContactBookRepository, Integer>{

}
