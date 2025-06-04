package com.application.rest.controller;

import com.application.rest.repository.dto.OrdenDTO;
import com.application.rest.service.OrdenService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/orden")
public class OrdenController {
    private static final Logger logger = LoggerFactory.getLogger(OrdenController.class);
    private OrdenService ordenService;

    @PostMapping("/crearOrden")
    public ResponseEntity<OrdenDTO> crearOrden(@RequestBody OrdenDTO orden) {
        logger.info("Iniacia ejecucion del servicio /crearOrden - POST ");
        OrdenDTO ordenCrada = ordenService.crearOrden(orden);
        return new ResponseEntity<>(ordenCrada, HttpStatus.CREATED);
    }

    @GetMapping("/buscarOrden/{id}")
    public ResponseEntity<OrdenDTO> buscarOrdenPorId(@PathVariable("id") Long idOrden) {
        logger.info("Inicia ejecucion del servicio /buscarOrden/{id} - GET");
        OrdenDTO ordenEncontrada = ordenService.buscarOrdenPorId(idOrden);
        return ResponseEntity.ok(ordenEncontrada);
    }

    @GetMapping("/listarOrdenes")
    public ResponseEntity<List<OrdenDTO>> listarOrdenes() {
        logger.info("Inicia ejecucion del servicio /listarOrdenes - GET");
        List<OrdenDTO> listaOrdenes = ordenService.listaOrdenes();
        return ResponseEntity.ok(listaOrdenes);
    }

    @PutMapping("/actualizarOrden/{id}")
    public ResponseEntity<OrdenDTO> actualizarOrden (@PathVariable("id") Long idOrden, @RequestBody OrdenDTO orden) {
        logger.info("Inicia ejecucuion del servicio /actualizarOrden/{id} - PUT");
        OrdenDTO ordenActualizada = ordenService.actualizarOrden(idOrden, orden);
        return ResponseEntity.ok(ordenActualizada);
    }

    @DeleteMapping("/eliminarOrden/{id}")
    public ResponseEntity<String> eliminarOrden(@PathVariable("id") Long idOrden) {
        logger.info("Inicia ejecucion del servicio /eliminarOrden - DELETE");
        ordenService.eliminarOrden(idOrden);
        return ResponseEntity.ok("Se elimino la Orden con ID " + idOrden + " Exitosamente");
    }
}