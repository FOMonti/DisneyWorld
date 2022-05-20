package com.alkemy.disneyworld.service.implementacion;

import com.alkemy.disneyworld.dto.GeneroDTO;
import com.alkemy.disneyworld.entity.GeneroEntity;
import com.alkemy.disneyworld.mapper.GeneroMapper;
import com.alkemy.disneyworld.repository.GeneroRepository;
import com.alkemy.disneyworld.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeneroServiceImpl implements GeneroService {

    @Autowired
    private GeneroMapper generoMapper;

    @Autowired
    private GeneroRepository generoRepository;

    public GeneroDTO save(GeneroDTO generoDTO) {
        GeneroEntity generoEntity = generoMapper.generoDTO2Entity(generoDTO);
        GeneroEntity generoEntitySaved = generoRepository.save(generoEntity);
        return generoMapper.generoEntity2DTO(generoEntity);
    }

    public List<GeneroDTO> getAllGeneros() {
        List<GeneroEntity> generos = generoRepository.findAll();
        return generoMapper.generosEntityList2DTOList(generos);
    }

    public GeneroDTO findById(Long id) {
        GeneroDTO generoDTO = new GeneroDTO();
        Optional<GeneroEntity> generoEntity = generoRepository.findById(id);
        if (generoEntity.isPresent()) {
            generoDTO = generoMapper.generoEntity2DTO(generoEntity.get());
        }
        return generoDTO;
    }

    public void delete(Long id) {
        generoRepository.deleteById(id);
    }
}
