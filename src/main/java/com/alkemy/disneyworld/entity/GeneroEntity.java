package com.alkemy.disneyworld.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "genero")
@Getter
@Setter

public class GeneroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nombre;

    private String imagen;

    @OneToMany(mappedBy = "generoId", cascade = CascadeType.ALL)
    private List<PeliculaEntity> peliculas;
}
