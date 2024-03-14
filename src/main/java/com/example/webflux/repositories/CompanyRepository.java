package com.example.webflux.repositories;

import com.example.webflux.models.Company;
import com.example.webflux.models.Tutorial;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CompanyRepository extends R2dbcRepository<Company, Integer>{

}