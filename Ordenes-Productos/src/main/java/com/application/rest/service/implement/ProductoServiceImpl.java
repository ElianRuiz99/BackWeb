package com.application.rest.service.implement;

import com.application.rest.entity.Producto;
import com.application.rest.exception.ResourceNotFoundException;
import com.application.rest.repository.ProductoRepository;
import com.application.rest.repository.dto.ProductoDTO;
import com.application.rest.repository.mapper.ProductoMapper;
import com.application.rest.service.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private ProductoRepository productoRepository;

    @Override
    public ProductoDTO crearProducto(ProductoDTO productoDTO) {
        Producto producto = ProductoMapper.mapToProductoEntity(productoDTO);
        Producto productoGuardado = productoRepository.save(producto);
        return ProductoMapper.mapToProductoDto(productoGuardado);
    }

    @Override
    public ProductoDTO obtenerProductoPorId(Long idProducto) {
        Producto producto = productoRepository.findById(idProducto)
                .orElseThrow(() -> new ResourceNotFoundException("El producto NO existe con ese ID " + idProducto));
        return ProductoMapper.mapToProductoDto(producto);
    }

    @Override
    public List<ProductoDTO> obtenerTodosProductos() {
        List<Producto> listaProductos = productoRepository.findAll();
        return listaProductos.stream().map(ProductoMapper::mapToProductoDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductoDTO actualizarTodoProducto(Long idProducto, ProductoDTO producto) {
        Producto productoAactualizar = productoRepository.findById(idProducto).orElseThrow(
                () -> new ResourceNotFoundException("El producto con el ID " + idProducto + " No existe")
        );

        productoAactualizar.setNombre(producto.getNombre());
        productoAactualizar.setDescripcion(producto.getDescripcion());
        productoAactualizar.setStock(producto.getStock());
        productoAactualizar.setPrecioUnitario(producto.getPrecioUnitario());
        productoAactualizar.setCategoria(producto.getCategoria());

        Producto productoGuardado = productoRepository.save(productoAactualizar);

        return ProductoMapper.mapToProductoDto(productoGuardado);
    }

    @Override
    public void eliminarProducto(Long idProducto) {
        if (!productoRepository.existsById(idProducto)) {
            throw new ResourceNotFoundException("El producto con el ID " + idProducto + " no existe");
        }
        productoRepository.deleteById(idProducto);
    }
}
