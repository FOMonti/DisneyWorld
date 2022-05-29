package com.alkemy.disneyworld.mapper;

import com.alkemy.disneyworld.dto.pelicula.PeliculaDTO;
import com.alkemy.disneyworld.entity.PeliculaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PeliculaMapper {

    @Autowired
    private static PersonajeMapper personajeMapper;

    public PeliculaDTO peliculaEntity2DTO(PeliculaEntity peliculaEntity, boolean cargarPersonajes) {
        PeliculaDTO peliculaDTO = new PeliculaDTO();
        peliculaDTO.setTitulo(peliculaEntity.getTitulo());
        peliculaDTO.setImagen(peliculaEntity.getImagen());
        peliculaDTO.setCalificacion(peliculaEntity.getCalificacion());
        peliculaDTO.setFechaDeCreacion(peliculaEntity.getFechaDeCreacion());
        if (cargarPersonajes)
            peliculaDTO.setPersonajesDTO(personajeMapper.personajeEntityList2DTOList(peliculaEntity.getPersonajes()));
        return peliculaDTO;
    }

    public PeliculaEntity peliculaDTO2Entity(PeliculaDTO peliculaDTO) {
        PeliculaEntity peliculaEntity = new PeliculaEntity();
        peliculaEntity.setTitulo(peliculaDTO.getTitulo());
        peliculaEntity.setCalificacion(peliculaDTO.getCalificacion());
        peliculaEntity.setImagen(peliculaDTO.getImagen());
        return peliculaEntity;
    }

    public List<PeliculaDTO> peliculaEntityList2DTOList(List<PeliculaEntity> personajeEntities,
                                                        boolean loadCharacters) {
        List<PeliculaDTO> peliculaDTOS = new ArrayList<>();
        for (PeliculaEntity peliculaEntity : personajeEntities) {
            peliculaDTOS.add(peliculaEntity2DTO(peliculaEntity, loadCharacters));
        }
        return peliculaDTOS;
    }


}
