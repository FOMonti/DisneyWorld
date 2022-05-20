package com.alkemy.disneyworld.service;

import com.alkemy.disneyworld.dto.PeliculaDTO;

import java.util.List;

public interface PeliculaService {

    PeliculaDTO save(PeliculaDTO peliculaDTO, Long generoId);

    List<PeliculaDTO> getAllWithListId(List<Long> peliculasID);
}
