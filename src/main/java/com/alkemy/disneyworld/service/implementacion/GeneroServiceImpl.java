package com.alkemy.disneyworld.service.implementacion;

import com.alkemy.disneyworld.dto.genero.GeneroAddDto;
import com.alkemy.disneyworld.dto.genero.GeneroDTO;
import com.alkemy.disneyworld.dto.genero.GeneroUpdateDto;
import com.alkemy.disneyworld.entity.GeneroEntity;
import com.alkemy.disneyworld.entity.PeliculaEntity;
import com.alkemy.disneyworld.mapper.GeneroMapper;
import com.alkemy.disneyworld.repository.GeneroRepository;
import com.alkemy.disneyworld.repository.PeliculaRepository;
import com.alkemy.disneyworld.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GeneroServiceImpl implements GeneroService {

    @Autowired
    private GeneroMapper generoMapper;

    @Autowired
    private GeneroRepository generoRepository;

    @Autowired
    private PeliculaRepository peliculaRepository;

    public GeneroDTO save(GeneroAddDto generoDTO) {
        throwExceptionIfGeneroExist(generoDTO.getNombre());
        GeneroEntity generoEntity = generoMapper.generoAddDTO2Entity(generoDTO);
        generoEntity.setPeliculas(getPeliculas(generoDTO));
        generoRepository.save(generoEntity);
        return generoMapper.generoEntity2DTO(generoEntity);
    }

    private List<PeliculaEntity> getPeliculas(GeneroAddDto generoDTO) {
        List<PeliculaEntity> peliculaEntities = new ArrayList<>();
        if (!(generoDTO.getPeliculas().isEmpty() || generoDTO.getPeliculas() == null))
            for (Long idPelicula : generoDTO.getPeliculas()) {
                throwExceptionIfMovieNotExist(idPelicula);
                PeliculaEntity peliculaEntity = peliculaRepository.getById(idPelicula);
                peliculaEntities.add(peliculaEntity);
            }
        return peliculaEntities;
    }

    @Transactional
    public GeneroDTO update(GeneroUpdateDto generoDTO) {
        throwExceptionIfGeneroExist(generoDTO.getNewName());
        throwExceptionIfNotGeneroExist(generoDTO.getOldName());
        GeneroEntity generoEntity = actualizar(generoDTO);
        generoRepository.save(generoEntity);
        return generoMapper.generoEntity2DTO(generoEntity);
    }

    public GeneroDTO addMovie2Gender(String genero, Long idMovie) {
        throwExceptionIfMovieNotExist(idMovie);
        throwExceptionIfNotGeneroExist(genero);
        GeneroEntity generoEntity = generoRepository.getByNombre(genero);
        PeliculaEntity peliculaEntity = peliculaRepository.getById(idMovie);
        peliculaEntity.setGenero(generoEntity);
        generoEntity.getPeliculas().add(peliculaEntity);
        generoRepository.save(generoEntity);
        peliculaRepository.save(peliculaEntity);
        return generoMapper.generoEntity2DTO(generoEntity);
    }

    private GeneroEntity actualizar(GeneroUpdateDto generoDTO) {
        GeneroEntity generoEntity = generoRepository.getByNombre(generoDTO.getOldName());
        generoEntity.setNombre(generoDTO.getNewName());
        if (!(generoDTO.getImage().isEmpty() || generoDTO.getImage() == null))
            generoEntity.setImagen(generoDTO.getImage());
        return generoEntity;
    }

    public List<GeneroDTO> getAllGeneros() {
        List<GeneroEntity> generos = generoRepository.findAll();
        return generoMapper.generosEntityList2DTOList(generos);
    }

    public GeneroDTO findByNombre(String nombre) {
        throwExceptionIfNotGeneroExist(nombre);
        GeneroEntity generoEntity = generoRepository.getByNombre(nombre);
        return generoMapper.generoEntity2DTO(generoEntity);
    }

    private void throwExceptionIfGeneroExist(String nombre) {
        Optional<GeneroEntity> generoEntity = generoRepository.findOptionalByNombre(nombre);
        if (generoEntity.isPresent()) {
            throw new RuntimeException("Ya existe un genero con ese nombre");
        }
    }

    private void throwExceptionIfNotGeneroExist(String nombre) {
        Optional<GeneroEntity> generoEntity = generoRepository.findOptionalByNombre(nombre);
        if (generoEntity.isEmpty()) {
            throw new RuntimeException("No existe un genero con ese nombre");
        }
    }

    private void throwExceptionIfMovieNotExist(Long pelicula) {
        Optional<PeliculaEntity> optionalPelicula = peliculaRepository.findById(pelicula);
        if (optionalPelicula.isEmpty()) {
            throw new RuntimeException("No existe una pelicula con ese id");
        }
    }

    public void delete(String nombre) {
        throwExceptionIfNotGeneroExist(nombre);
        generoRepository.deleteById(generoRepository.getByNombre(nombre).getId());
    }
}
