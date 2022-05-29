package com.alkemy.disneyworld.controller;

import com.alkemy.disneyworld.dto.PersonajeDTO;
import com.alkemy.disneyworld.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/characters")
public class PersonajeController {

    @Autowired
    public PersonajeService personajeService;

    //TODO : Modificar Service (Agregar Exception) || List<Long> peliculas
    @PostMapping("/save")
    public ResponseEntity<PersonajeDTO> save(@RequestBody PersonajeDTO personaje) {
        PersonajeDTO personajeGuardado = personajeService.save(personaje);
        return ResponseEntity.status(HttpStatus.CREATED).body(personajeGuardado);
    }


    //TODO : IMPLEMENTAR
    @PostMapping("/update")
    public ResponseEntity<PersonajeDTO> update(@RequestBody PersonajeDTO pelicula) {
        PersonajeDTO generoGuardado = personajeService.update(pelicula);
        return ResponseEntity.status(HttpStatus.CREATED).body(generoGuardado);
    }

    //TODO : IMPLEMENTAR
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> remove(@PathVariable Long id) {
        personajeService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
