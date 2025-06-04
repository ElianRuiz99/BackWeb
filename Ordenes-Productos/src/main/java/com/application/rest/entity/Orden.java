package com.application.rest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ordenes")
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orden")
    private Long idOrden;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;

    @Column(name = "id_producto")
    private Long idProducto;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "total", nullable = false)
    private Double totalPagar;

    @Column(name = "estado")
    private String estado;
}
