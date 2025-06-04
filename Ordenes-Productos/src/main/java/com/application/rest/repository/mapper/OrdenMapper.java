package com.application.rest.repository.mapper;

import com.application.rest.entity.Orden;
import com.application.rest.repository.dto.OrdenDTO;

public class OrdenMapper {
    public static OrdenDTO mapToOrdenDTO (Orden orden){
        return new OrdenDTO(
                orden.getIdOrden(),
                orden.getFecha(),
                orden.getIdProducto(),
                orden.getCantidad(),
                orden.getTotalPagar(),
                orden.getEstado()
        );
    }

    public static Orden mapToOrdenEntity (OrdenDTO orden){
        return new Orden(
                orden.getIdOrden(),
                orden.getFecha(),
                orden.getIdProducto(),
                orden.getCantidad(),
                orden.getTotalPagar(),
                orden.getEstado()
        );
    }
}
