package com.alkemy.disneyworld.service;

import com.alkemy.disneyworld.dto.genero.GeneroAddDto;
import com.alkemy.disneyworld.dto.genero.GeneroDTO;
import com.alkemy.disneyworld.dto.genero.GeneroUpdateDto;

import java.util.List;

public interface GeneroService {

    GeneroDTO findByNombre(String nombre);

    GeneroDTO save(GeneroAddDto generoDTO);

    List<GeneroDTO> getAllGeneros();

    void delete(String id);

    GeneroDTO update(GeneroUpdateDto genero);

    GeneroDTO addMovie2Gender(String genero, Long idMovie);
}
