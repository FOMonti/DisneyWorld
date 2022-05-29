package com.alkemy.disneyworld.service;

import com.alkemy.disneyworld.dto.pelicula.PeliculaDTO;

import java.util.List;

public interface PeliculaService {

    PeliculaDTO save(PeliculaDTO peliculaDTO);

    List<PeliculaDTO> getAllWithListId(List<Long> peliculasID);

    PeliculaDTO update(PeliculaDTO peliculaDTO);

    void delete(Long id);

    List<PeliculaDTO> getAll();
}
