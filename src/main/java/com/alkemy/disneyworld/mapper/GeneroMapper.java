package com.alkemy.disneyworld.mapper;

import com.alkemy.disneyworld.dto.GeneroDTO;
import com.alkemy.disneyworld.entity.GeneroEntity;
import org.springframework.stereotype.Component;

@Component
public class GeneroMapper {

    public GeneroEntity generoDTO2Entity(GeneroDTO generoDTO) {
        GeneroEntity generoEntity = new GeneroEntity();
        generoEntity.setImagen(generoDTO.getImagen());
        generoEntity.setNombre(generoDTO.getNombre());
        return generoEntity;
    }

    public GeneroDTO generoEntity2DTO(GeneroEntity generoEntity) {
        GeneroDTO generoDTO = new GeneroDTO();
        generoDTO.setId(generoEntity.getId());
        generoDTO.setImagen(generoEntity.getImagen());
        generoDTO.setNombre(generoEntity.getNombre());
        return generoDTO;
    }
}
