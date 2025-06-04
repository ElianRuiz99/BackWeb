package com.application.rest.repository.mapper;

import com.application.rest.entity.Producto;
import com.application.rest.repository.dto.ProductoDTO;

public class ProductoMapper {
    public static ProductoDTO mapToProductoDto (Producto producto) {
        return new ProductoDTO(
                producto.getIdProducto(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getPrecioUnitario(),
                producto.getStock(),
                producto.getCategoria()
        );
    }

    public static Producto mapToProductoEntity (ProductoDTO productoDto) {
        return new Producto(
                productoDto.getIdProducto(),
                productoDto.getNombre(),
                productoDto.getDescripcion(),
                productoDto.getPrecioUnitario(),
                productoDto.getStock(),
                productoDto.getCategoria()
        );
    }
}
