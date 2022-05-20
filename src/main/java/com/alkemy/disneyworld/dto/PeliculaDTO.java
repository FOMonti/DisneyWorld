package com.alkemy.disneyworld.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class PeliculaDTO {

    private String imagen;

    private String titulo;

    private Integer calificacion;

    private LocalDate fechaDeCreacion;

    private Set<PersonajeDTO> personajesDTO;
}
