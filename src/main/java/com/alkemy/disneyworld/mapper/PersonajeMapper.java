package com.alkemy.disneyworld.mapper;

import com.alkemy.disneyworld.dto.personaje.PersonajeDTO;
import com.alkemy.disneyworld.entity.PersonajeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class PersonajeMapper {

    @Autowired
    private static PeliculaMapper peliculaMapper;

    public PersonajeEntity personajeDTO2PersonajeEntity(PersonajeDTO personajeDTO) {
        PersonajeEntity personajeEntity = new PersonajeEntity();
        personajeEntity.setNombre(personajeDTO.getNombre());
        personajeEntity.setEdad(personajeDTO.getEdad());
        personajeEntity.setHistoria(personajeDTO.getHistoria());
        personajeEntity.setPeso(personajeDTO.getPeso());
        personajeEntity.setImagen(personajeDTO.getImagen());
        return personajeEntity;
    }

    public PersonajeDTO personajeEntity2PersonajeDTO(PersonajeEntity personajeEntity, boolean loadPeliculas) {
        PersonajeDTO personajeDTO = new PersonajeDTO();
        personajeDTO.setNombre(personajeEntity.getNombre());
        personajeDTO.setEdad(personajeEntity.getEdad());
        personajeDTO.setHistoria(personajeEntity.getHistoria());
        personajeDTO.setPeso(personajeEntity.getPeso());
        personajeDTO.setImagen(personajeEntity.getImagen());
        if (loadPeliculas)
            personajeDTO.setPeliculaDTO(peliculaMapper.peliculaEntityList2DTOList(personajeEntity.getPeliculas(), false));
        return personajeDTO;
    }

    public Set<PersonajeDTO> personajeEntityList2DTOList(Collection<PersonajeEntity> personajeEntities) {
        Set<PersonajeDTO> personajeDTOS = new HashSet<>();
        for (PersonajeEntity personajeEntity : personajeEntities) {
            personajeDTOS.add(personajeEntity2PersonajeDTO(personajeEntity, false));
        }
        return personajeDTOS;
    }

}
