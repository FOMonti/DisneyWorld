package com.alkemy.disneyworld.controller;

import com.alkemy.disneyworld.dto.PeliculaDTO;
import com.alkemy.disneyworld.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    //TODO : Modificar Service (Agregar Exception) || List<Long> personajes
    @PostMapping("/save")
    public ResponseEntity<PeliculaDTO> save(@RequestBody PeliculaDTO pelicula) {
        PeliculaDTO peliculaSaved = peliculaService.save(pelicula);
        return ResponseEntity.status(HttpStatus.CREATED).body(peliculaSaved);
    }

    //TODO : IMPLEMENTAR
    @PostMapping("/update")
    public ResponseEntity<PeliculaDTO> update(@RequestBody PeliculaDTO peliculaDTO) {
        PeliculaDTO peliculaSaved = peliculaService.update(peliculaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(peliculaSaved);
    }

    //TODO : IMPLEMENTAR
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> remove(@PathVariable Long id) {
        peliculaService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    //TODO : IMPLEMENTAR
    @GetMapping("/getAll")
    public ResponseEntity<List<PeliculaDTO>> getAll() {
        return ResponseEntity.status(HttpStatus.FOUND).body(peliculaService.getAll());
    }

    //TODO : Modificar Service (Agregar Exception)
    @PostMapping("/{idMovie}/characters/{idCharacter}")
    public ResponseEntity<Void> addPelicula(@PathVariable Long id, @PathVariable Long idPelicula) {
//        personajeService.addPelicula(id, idPelicula);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    //TODO : IMPLEMENTAR
    @DeleteMapping("/{idMovie}/characters/{idCharacter}")
    public ResponseEntity<Void> remove(@PathVariable String idMovie, @PathVariable String idCharacter) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
