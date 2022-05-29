package com.alkemy.disneyworld.service;

import com.alkemy.disneyworld.dto.personaje.PersonajeDTO;

public interface PersonajeService {

    PersonajeDTO save(PersonajeDTO personajeDTO);

    void delete(Long id);

    PersonajeDTO update(PersonajeDTO pelicula);
}
