package com.alkemy.disneyworld.controller;

import com.alkemy.disneyworld.dto.GeneroDTO;
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

    //TODO : Modificar Service (Agregar Exception) || List<Peliculas>
    @PostMapping("/save")
    public ResponseEntity<GeneroDTO> save(@RequestBody GeneroDTO genero) {
        GeneroDTO generoGuardado = generoService.save(genero);
        return ResponseEntity.status(HttpStatus.CREATED).body(generoGuardado);
    }

    //TODO : IMPLEMENTAR
    @PostMapping("/update")
    public ResponseEntity<GeneroDTO> update(@RequestBody GeneroDTO genero) {
        GeneroDTO generoGuardado = generoService.update(genero);
        return ResponseEntity.status(HttpStatus.CREATED).body(generoGuardado);
    }

    //TODO : IMPLEMENTAR
    @PostMapping("/add_peliculas")
    public ResponseEntity<GeneroDTO> addPeliculas(@RequestBody GeneroDTO genero) {
        GeneroDTO generoGuardado = generoService.update(genero);
        return ResponseEntity.status(HttpStatus.CREATED).body(generoGuardado);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<GeneroDTO>> getAll() {
        List<GeneroDTO> generos = generoService.getAllGeneros();
        return ResponseEntity.ok(generos);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> remove(@PathVariable Long id) {
        generoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
