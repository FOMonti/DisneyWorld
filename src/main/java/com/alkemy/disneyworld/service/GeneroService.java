package com.alkemy.disneyworld.service;

import com.alkemy.disneyworld.dto.GeneroDTO;
import com.alkemy.disneyworld.entity.GeneroEntity;

import java.util.List;

public interface GeneroService {

    GeneroDTO findById(Long id);

    GeneroDTO save(GeneroDTO generoDTO);

    List<GeneroDTO> getAllGeneros();

    void delete(Long id);
}
