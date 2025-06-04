package com.application.rest.repository;

import com.application.rest.entity.Noticia;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticiaRepository extends MongoRepository<Noticia, Long> {
}
