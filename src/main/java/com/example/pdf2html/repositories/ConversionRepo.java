package com.example.pdf2html.repositories;

import com.example.pdf2html.entities.Conversion;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversionRepo extends ReactiveMongoRepository<Conversion,String> {
}
