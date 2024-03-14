package com.example.webflux.repositories;

import com.example.webflux.models.Company;
import com.example.webflux.models.Linea;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineRepository extends R2dbcRepository<Linea, Integer>{

}