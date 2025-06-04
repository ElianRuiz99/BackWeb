package com.application.rest.controller;

import com.application.rest.repository.dto.ProductoDTO;
import com.application.rest.service.ProductoService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/producto")
public class ProductoController {
    private static final Logger logger = LoggerFactory.getLogger(ProductoController.class);
    private ProductoService productoService;

    @PostMapping("/crear")
    public ResponseEntity<ProductoDTO> crearProducto(@RequestBody ProductoDTO productoDTO) {
        logger.info("Inicia ejecucion del servicio /crear - POST");
        ProductoDTO producto = productoService.crearProducto(productoDTO);
        return new ResponseEntity<>(producto, HttpStatus.CREATED);
    }

    @GetMapping("/obtenerPorId/{id}")
    public ResponseEntity<ProductoDTO> obtenerProductoPorId(@PathVariable("id") Long idProducto) {
        logger.info("Inicia ejecucion del servicio /obtenerPorId/{id} - GET");
        ProductoDTO producto = productoService.obtenerProductoPorId(idProducto);
        return ResponseEntity.ok(producto);
    }

    @GetMapping("/obtenerTodosProductos")
    public ResponseEntity<List<ProductoDTO>> obtenerTodosProducto() {
        logger.info("Inicia ejecucion del servicio /obtenerTodosProductos - GET");
        List<ProductoDTO> listaProductos = productoService.obtenerTodosProductos();
        return ResponseEntity.ok(listaProductos);
    }

    @PutMapping("/actualizaProductoCompleto/{id}")
    public ResponseEntity<ProductoDTO> actualizarTodoProducto(@PathVariable("id") Long id, @RequestBody ProductoDTO producto) {
        logger.info("Inicia ejecucion del servicio /actualizaProductoCompleto/{id} - PUT");
        ProductoDTO actualzarProducto = productoService.actualizarTodoProducto(id, producto);
        return ResponseEntity.ok(actualzarProducto);
    }

    @DeleteMapping("/eliminarProducto/{id}")
    public ResponseEntity<String> eliminarProducto(@PathVariable("id") Long idProducto) {
        logger.info("Inicia ejecucion del servicio /eliminarProducto/{id} - DELETE");
        productoService.eliminarProducto(idProducto);
        return ResponseEntity.ok("Producto con el ID " + idProducto + " fue ELIMINADO exitosamente!");
    }


}
