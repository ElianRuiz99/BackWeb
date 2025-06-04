package com.application.rest.service;

import com.application.rest.repository.dto.OrdenDTO;

import java.util.List;

public interface OrdenService {
    OrdenDTO crearOrden (OrdenDTO nuevaOrden);

    OrdenDTO buscarOrdenPorId (Long idOrden);

    List<OrdenDTO> listaOrdenes ();

    OrdenDTO actualizarOrden (Long idOrden, OrdenDTO orden);

    void eliminarOrden(Long idOrden);
}
