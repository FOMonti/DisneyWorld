package com.alkemy.disneyworld.dto.genero;

import com.alkemy.disneyworld.dto.pelicula.PeliculaDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GeneroDTO {

    private String nombre;
    private String imagen;
    private List<PeliculaDTO> peliculas;

}
