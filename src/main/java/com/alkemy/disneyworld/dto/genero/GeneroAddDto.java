package com.alkemy.disneyworld.dto.genero;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GeneroAddDto {

    private String nombre;

    private String imagen;

    private List<Long> peliculas;
}
