package com.alkemy.disneyworld.controller;

import com.alkemy.disneyworld.dto.genero.GeneroAddDto;
import com.alkemy.disneyworld.dto.genero.GeneroDTO;
import com.alkemy.disneyworld.dto.genero.GeneroUpdateDto;
import com.alkemy.disneyworld.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/generos")
public class GeneroController {

    @Autowired
    private GeneroService generoService;

    @PostMapping("/save")
    public ResponseEntity<GeneroDTO> save(@RequestBody GeneroAddDto genero) {
        GeneroDTO generoGuardado = generoService.save(genero);
        return ResponseEntity.status(HttpStatus.CREATED).body(generoGuardado);
    }

    //TODO : Testear(testear con peliculas, no debe borrar las relaciones)
    @PostMapping("/update")
    public ResponseEntity<GeneroDTO> update(@RequestBody GeneroUpdateDto genero) {
        GeneroDTO generoGuardado = generoService.update(genero);
        return ResponseEntity.status(HttpStatus.CREATED).body(generoGuardado);
    }

    //TODO : Testear luego de crud Movie
    @PostMapping("/{nombreGenero}/movies/{idMovie}")
    public ResponseEntity<GeneroDTO> addPeliculas(@RequestParam String nombreGenero, @RequestParam Long idMovie) {
        GeneroDTO generoGuardado = generoService.addMovie2Gender(nombreGenero, idMovie);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<GeneroDTO>> getAll() {
        List<GeneroDTO> generos = generoService.getAllGeneros();
        return ResponseEntity.ok(generos);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> remove(@PathVariable String id) {
        generoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
