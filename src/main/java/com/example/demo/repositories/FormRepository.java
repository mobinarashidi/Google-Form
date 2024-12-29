package com.example.demo.repositories;

import com.example.demo.models.Form;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FormRepository extends MongoRepository<Form, String> {
}
