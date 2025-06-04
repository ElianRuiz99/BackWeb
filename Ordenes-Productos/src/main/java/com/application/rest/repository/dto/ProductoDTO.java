package com.application.rest.repository.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {
    private Long idProducto;
    private String nombre;
    private String descripcion;
    private Double precioUnitario;
    private Integer stock;
    private String categoria;
}
