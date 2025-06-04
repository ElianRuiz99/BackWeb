package com.application.rest.service;

import com.application.rest.repository.dto.ProductoDTO;

import java.util.List;

public interface ProductoService {
    ProductoDTO crearProducto(ProductoDTO productoDTO);

    ProductoDTO obtenerProductoPorId(Long productoDTO);

    List<ProductoDTO> obtenerTodosProductos();

    ProductoDTO actualizarTodoProducto(Long idProducto, ProductoDTO producto);

    void eliminarProducto(Long idProducto);
}
