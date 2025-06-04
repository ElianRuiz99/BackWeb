package com.application.rest.repository.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrdenDTO {
    private Long idOrden;
    private LocalDateTime fecha;
    private Long idProducto;
    private Integer cantidad;
    private Double totalPagar;
    private String estado;
}
