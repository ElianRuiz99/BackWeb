package com.application.rest.service.implement;

import com.application.rest.entity.Orden;
import com.application.rest.exception.ResourceNotFoundException;
import com.application.rest.repository.OrdenRepository;
import com.application.rest.repository.dto.OrdenDTO;
import com.application.rest.repository.mapper.OrdenMapper;
import com.application.rest.service.OrdenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrdenServiceImpl implements OrdenService {

    private OrdenRepository OrdenRepository;

    @Override
    public OrdenDTO crearOrden(OrdenDTO nuevaOrden) {
        Orden orden = OrdenMapper.mapToOrdenEntity(nuevaOrden);
        Orden ordenGuardada = OrdenRepository.save(orden);
        return OrdenMapper.mapToOrdenDTO(ordenGuardada);
    }

    @Override
    public OrdenDTO buscarOrdenPorId(Long idOrden) {
        Orden orden = OrdenRepository.findById(idOrden)
                .orElseThrow(() -> new ResourceNotFoundException("El producto NO existe con ese ID " + idOrden));
        return OrdenMapper.mapToOrdenDTO(orden);
    }

    @Override
    public List<OrdenDTO> listaOrdenes() {
        List<Orden> listaOrden = OrdenRepository.findAll();
        return listaOrden.stream().map(OrdenMapper::mapToOrdenDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OrdenDTO actualizarOrden(Long idOrden, OrdenDTO orden) {
        Orden ordenAactualizar = OrdenRepository.findById(idOrden)
                .orElseThrow(() -> new ResourceNotFoundException("El producto NO existe con ese ID " + idOrden));

        ordenAactualizar.setEstado(orden.getEstado());
        ordenAactualizar.setFecha(orden.getFecha());
        ordenAactualizar.setTotalPagar(orden.getTotalPagar());

        Orden ordenGuardada = OrdenRepository.save(ordenAactualizar);

        return OrdenMapper.mapToOrdenDTO(ordenGuardada);
    }

    @Override
    public void eliminarOrden(Long idOrden) {
        if (!OrdenRepository.existsById(idOrden)) {
            throw new ResourceNotFoundException("El producto con el ID " + idOrden + " no existe");
        }
        OrdenRepository.deleteById(idOrden);
    }
}
