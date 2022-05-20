package com.alkemy.disneyworld.service.implementacion;

import com.alkemy.disneyworld.dto.PersonajeDTO;
import com.alkemy.disneyworld.entity.PersonajeEntity;
import com.alkemy.disneyworld.mapper.PersonajeMapper;
import com.alkemy.disneyworld.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeServiceImpl implements PersonajeService {

    @Autowired
    public PersonajeMapper personajeMapper;

    //    @Autowired
//    public PeliculasService peliculasService;
    public PersonajeDTO save(PersonajeDTO personajeDTO, List<Long> peliculas) {
        PersonajeEntity personajeEntity = personajeMapper.personajeDTO2PersonajeEntity(personajeDTO);
//    List<PeliculasEntity> peliculasEntity = peliculasService.getAllWithListID(peliculas);
        return null;
    }
}
