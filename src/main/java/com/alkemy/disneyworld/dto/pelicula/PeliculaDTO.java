package com.alkemy.disneyworld.dto.pelicula;

import com.alkemy.disneyworld.dto.personaje.PersonajeDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class PeliculaDTO {

    private Long id;

    private String imagen;

    private String titulo;

    private Integer calificacion;

    private String idGenero;

    private LocalDate fechaDeCreacion;

    private Set<PersonajeDTO> personajesDTO;
}
