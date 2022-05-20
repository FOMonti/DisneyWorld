package com.alkemy.disneyworld.controller;

import com.alkemy.disneyworld.dto.PersonajeDTO;
import com.alkemy.disneyworld.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("characters")
public class PersonajeController {

    @Autowired
    public PersonajeService personajeService;

    @PostMapping
    public ResponseEntity<PersonajeDTO> save(@RequestBody PersonajeDTO personaje,
                                             @RequestBody List<Long> peliculas) {
        PersonajeDTO personajeGuardado = personajeService.save(personaje, peliculas);
        return ResponseEntity.status(HttpStatus.CREATED).body(personajeGuardado);
    }

    @PostMapping("/{id}/pelicula/{idPelicula}")
    public ResponseEntity<Void> addPelicula(@PathVariable Long id, @PathVariable Long idPelicula){
//        personajeService.addPelicula(id,idPelicula);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
