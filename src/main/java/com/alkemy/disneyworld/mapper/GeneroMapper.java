package com.alkemy.disneyworld.mapper;

import com.alkemy.disneyworld.dto.genero.GeneroAddDto;
import com.alkemy.disneyworld.dto.genero.GeneroDTO;
import com.alkemy.disneyworld.dto.genero.GeneroUpdateDto;
import com.alkemy.disneyworld.entity.GeneroEntity;
import com.alkemy.disneyworld.entity.PeliculaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GeneroMapper {

    @Autowired
    private PeliculaMapper peliculaMapper;

    public GeneroEntity generoDTO2Entity(GeneroDTO generoDTO) {
        GeneroEntity generoEntity = new GeneroEntity();
        generoEntity.setImagen(generoDTO.getImagen());
        generoEntity.setNombre(generoDTO.getNombre());
        return generoEntity;
    }

    public GeneroDTO generoEntity2DTO(GeneroEntity generoEntity) {
        GeneroDTO generoDTO = new GeneroDTO();
        generoDTO.setImagen(generoEntity.getImagen());
        generoDTO.setNombre(generoEntity.getNombre());
        generoDTO.setPeliculas(peliculaMapper.peliculaEntityList2DTOList(generoEntity.getPeliculas(), false));
        return generoDTO;
    }

    public List<GeneroDTO> generosEntityList2DTOList(List<GeneroEntity> generosEntitys) {
        List<GeneroDTO> generosDTOS = new ArrayList<>();
        for (GeneroEntity generoEntity : generosEntitys)
            generosDTOS.add(generoEntity2DTO(generoEntity));
        return generosDTOS;
    }

    public GeneroEntity generoAddDTO2Entity(GeneroAddDto generoDTO) {
        GeneroEntity generoEntity = new GeneroEntity();
        generoEntity.setNombre(generoDTO.getNombre());
        generoEntity.setImagen(generoDTO.getImagen());
        return generoEntity;
    }
}
