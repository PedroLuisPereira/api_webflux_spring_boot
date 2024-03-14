package com.example.webflux.models;

import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.annotation.Id;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "lineas")
public class Linea implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    private String nombre;
    private String codigo;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Long company;
}
