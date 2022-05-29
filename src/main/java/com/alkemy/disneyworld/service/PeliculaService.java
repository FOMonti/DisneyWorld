package com.alkemy.disneyworld.service;

import com.alkemy.disneyworld.dto.PeliculaDTO;
import com.alkemy.disneyworld.entity.PeliculaEntity;

import java.util.List;

public interface PeliculaService {

    PeliculaDTO save(PeliculaDTO peliculaDTO);

    List<PeliculaDTO> getAllWithListId(List<Long> peliculasID);

    PeliculaDTO update(PeliculaDTO peliculaDTO);

    void delete(Long id);

    List<PeliculaDTO> getAll();
}
