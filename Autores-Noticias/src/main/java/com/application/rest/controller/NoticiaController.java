package com.application.rest.controller;

import com.application.rest.repository.dto.NoticiaDTO;
import com.application.rest.service.NoticiaService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/noticias")
public class NoticiaController {

    private static final Logger logger = LoggerFactory.getLogger(NoticiaController.class);
    private NoticiaService noticiaService;

    @PostMapping("/crearNoticia")
    public ResponseEntity<NoticiaDTO> crearNoticia(@RequestBody NoticiaDTO noticiaDTO) {
        logger.info("Inicia ejcucion del servicio /crearNoticia - POST");
        NoticiaDTO noticia = noticiaService.guardarNoticia(noticiaDTO);
        return new ResponseEntity<>(noticia, HttpStatus.CREATED);
    }

    @GetMapping("/buscarNoticiaPorId/{id}")
    public ResponseEntity<NoticiaDTO> buscarNoticiaPorId(@PathVariable("id") Long idNoticia) {
        logger.info("Inicia ejcucion del servicio /buscarNoticiaPorId/{id} - GET");
        NoticiaDTO noticia = noticiaService.buscarNoticiaPorId(idNoticia);
        return ResponseEntity.ok(noticia);
    }

    @GetMapping("/listarTodasNoticia")
    public ResponseEntity<List<NoticiaDTO>> listarTodasNoticias() {
        logger.info("Inicia ejcucion del servicio /listarTodasNoticia - GET");
        List<NoticiaDTO> listaAutores = noticiaService.listarTodasNoticias();
        return ResponseEntity.ok(listaAutores);
    }

    @PutMapping("/actualizarNoticia/{id}")
    public ResponseEntity<NoticiaDTO> actualizarNoticia(@PathVariable("id") Long idNoticia, @RequestBody NoticiaDTO noticiaDTO){
        logger.info("Inicia ejcucion del servicio /actualizarNoticia/{id} - PUT");
        NoticiaDTO autor = noticiaService.actualizarNoticia(idNoticia, noticiaDTO);
        return ResponseEntity.ok(autor);
    }

    @DeleteMapping("/eliminarNoticia/{id}")
    public ResponseEntity<String> eliminarNoticia(@PathVariable("id") Long idNoticia) {
        logger.info("Inicia ejcucion del servicio /eliminarNoticia/{id} - DELETE");
        noticiaService.eliminarNoticia(idNoticia);
        return ResponseEntity.ok("Se elimino la Noticia con ID " + idNoticia + " Exitosamente");
    }
}
