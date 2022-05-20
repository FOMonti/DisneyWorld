package com.alkemy.disneyworld.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PersonajeDTO {

    private String imagen;

    private String nombre;

    private Integer edad;

    private Double peso;

    private String historia;

    private List<PeliculaDTO> peliculaDTO;
}
