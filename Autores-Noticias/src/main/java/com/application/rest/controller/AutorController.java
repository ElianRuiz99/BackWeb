package com.application.rest.controller;

import com.application.rest.repository.dto.AutorDTO;
import com.application.rest.service.AutorService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/autor")
public class AutorController {

    private static final Logger logger = LoggerFactory.getLogger(AutorController.class);
    private AutorService autorService;

    @PostMapping("/crearAutor")
    public ResponseEntity<AutorDTO> crearAutor(@RequestBody AutorDTO autor) {
        logger.info("Inicia ejcucion del servicio /crearAutor - POST");
        AutorDTO autorCreado = autorService.guardarAutor(autor);
        return new ResponseEntity<>(autorCreado, HttpStatus.CREATED);
    }

    @GetMapping("/buscarAutorPorId/{id}")
    public ResponseEntity<AutorDTO> buscarAutorPorId(@PathVariable("id") Long idAutor) {
        logger.info("Inicia ejcucion del servicio /buscarAutorPorId/{id} - GET");
        AutorDTO autor = autorService.buscarAutorPorId(idAutor);
        return ResponseEntity.ok(autor);
    }

    @GetMapping("/listarTodosAutores")
    public ResponseEntity<List<AutorDTO>> listarTodosAutores() {
        logger.info("Inicia ejcucion del servicio /listarTodosAutores - GET");
        List<AutorDTO> listaAutores = autorService.listarTodosAutores();
        return ResponseEntity.ok(listaAutores);
    }

    @PutMapping("/actualizarAutor/{id}")
    public ResponseEntity<AutorDTO> actualizarAutor(@PathVariable("id") Long idAutor, @RequestBody AutorDTO autorDTO){
        logger.info("Inicia ejcucion del servicio /actualizarAutor/{id} - PUT");
        AutorDTO autor = autorService.actualizarAutor(idAutor, autorDTO);
        return ResponseEntity.ok(autor);
    }

    @DeleteMapping("/eliminarAutor/{id}")
    public ResponseEntity<String> eliminarAutor(@PathVariable("id") Long idAutor) {
        logger.info("Inicia ejcucion del servicio /eliminarAutor/{id} - DELETE");
        autorService.eliminarAutor(idAutor);
        return ResponseEntity.ok("Se elimino la Orden con ID " + idAutor + " Exitosamente");
    }
}
