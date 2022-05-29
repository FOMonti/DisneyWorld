package com.alkemy.disneyworld.service.implementacion;

import com.alkemy.disneyworld.dto.GeneroDTO;
import com.alkemy.disneyworld.dto.PeliculaDTO;
import com.alkemy.disneyworld.entity.GeneroEntity;
import com.alkemy.disneyworld.entity.PeliculaEntity;
import com.alkemy.disneyworld.mapper.GeneroMapper;
import com.alkemy.disneyworld.mapper.PeliculaMapper;
import com.alkemy.disneyworld.repository.PeliculaRepository;
import com.alkemy.disneyworld.service.GeneroService;
import com.alkemy.disneyworld.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PeliculaServiceImpl implements PeliculaService {

    @Autowired
    private PeliculaMapper peliculaMapper;

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Autowired
    private GeneroService generoService;

    @Autowired
    private GeneroMapper generoMapper;

    public PeliculaDTO save(PeliculaDTO peliculaDTO) {
        PeliculaEntity peliculaEntity = peliculaMapper.peliculaDTO2Entity(peliculaDTO);
        peliculaEntity.setFechaDeCreacion(LocalDate.now());
        GeneroDTO generoDTO = generoService.findById(peliculaDTO.getIdGenero());
        GeneroEntity generoEntity = generoMapper.generoDTO2Entity(generoDTO);
        peliculaEntity.setGenero(generoEntity);
        return peliculaMapper.peliculaEntity2DTO(peliculaEntity, true);
    }

    public List<PeliculaDTO> getAllWithListId(List<Long> peliculasID) {
        return peliculaMapper.peliculaEntityList2DTOList(peliculaEntities(peliculasID), false);
    }

    public PeliculaDTO update(PeliculaDTO peliculaDTO) {
        return null;
    }

    public void delete(Long id) {

    }

    public List<PeliculaDTO> getAll() {
        return null;
    }

    private List<PeliculaEntity> peliculaEntities(List<Long> peliculasID) {
        List<PeliculaEntity> peliculaEntities = new ArrayList<>();
        for (Long id : peliculasID) {
            Optional<PeliculaEntity> peliculaEntity = peliculaRepository.findById(id);
            peliculaEntity.ifPresent(peliculaEntities::add);
        }
        return peliculaEntities;
    }


}
