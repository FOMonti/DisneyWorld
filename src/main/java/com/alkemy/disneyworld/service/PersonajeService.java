package com.alkemy.disneyworld.service;

import com.alkemy.disneyworld.dto.PersonajeDTO;

import java.util.List;

public interface PersonajeService {

    PersonajeDTO save(PersonajeDTO personajeDTO, List<Long> peliculas);
}
