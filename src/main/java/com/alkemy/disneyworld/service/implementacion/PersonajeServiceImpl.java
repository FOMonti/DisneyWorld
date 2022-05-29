package com.alkemy.disneyworld.service.implementacion;

import com.alkemy.disneyworld.dto.PeliculaDTO;
import com.alkemy.disneyworld.dto.PersonajeDTO;
import com.alkemy.disneyworld.entity.PeliculaEntity;
import com.alkemy.disneyworld.entity.PersonajeEntity;
import com.alkemy.disneyworld.mapper.PersonajeMapper;
import com.alkemy.disneyworld.repository.PersonajeRepository;
import com.alkemy.disneyworld.service.PeliculaService;
import com.alkemy.disneyworld.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeServiceImpl implements PersonajeService {

    @Autowired
    private PersonajeMapper personajeMapper;

    @Autowired
    private PersonajeRepository personajeRepository;

    @Autowired
    private PeliculaService peliculasService;

    public PersonajeDTO save(PersonajeDTO personajeDTO) {
        PersonajeEntity personajeEntity = personajeMapper.personajeDTO2PersonajeEntity(personajeDTO);
        personajeRepository.save(personajeEntity);
        return personajeMapper.personajeEntity2PersonajeDTO(personajeEntity, false);
    }

    public void delete(Long id) {

    }

    public PersonajeDTO update(PersonajeDTO pelicula) {
        return null;
    }


}
