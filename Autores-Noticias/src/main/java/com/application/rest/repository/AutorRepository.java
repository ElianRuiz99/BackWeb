package com.application.rest.repository;

import com.application.rest.entity.Autor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends MongoRepository<Autor, Long> {

}
