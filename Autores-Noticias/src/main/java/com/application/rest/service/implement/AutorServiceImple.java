package com.application.rest.service.implement;

import com.application.rest.entity.Autor;
import com.application.rest.exception.ResourceNotFoundException;
import com.application.rest.repository.AutorRepository;
import com.application.rest.repository.dto.AutorDTO;
import com.application.rest.repository.mapper.AutorMapper;
import com.application.rest.service.AutorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AutorServiceImple implements AutorService {

    private AutorRepository autorRepository;

    @Override
    public AutorDTO guardarAutor(AutorDTO autorDTO) {
        Autor autor = AutorMapper.mapToAutor(autorDTO);
        Autor autorGuardado = autorRepository.save(autor);
        return AutorMapper.mapToAutorDto(autorGuardado);
    }

    @Override
    public AutorDTO buscarAutorPorId(Long idAutor) {
        Autor autor = autorRepository.findById(idAutor)
                .orElseThrow(() -> new ResourceNotFoundException("No existe Autor con el ID: " + idAutor));
        return AutorMapper.mapToAutorDto(autor);
    }

    @Override
    public List<AutorDTO> listarTodosAutores() {
        List<Autor> listaAutores = autorRepository.findAll();

        return listaAutores.stream().map(AutorMapper::mapToAutorDto)
                .collect(Collectors.toList());
    }

    @Override
    public AutorDTO actualizarAutor(Long idAutor, AutorDTO autorDTO) {
        Autor autor = autorRepository.findById(idAutor)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro Autor con ID: " + idAutor));

        autor.setNombre(autorDTO.getNombre());
        autor.setApellido(autorDTO.getApellido());
        autor.setProfesion(autorDTO.getProfesion());
        autor.setActivo(autorDTO.getActivo());

        Autor autorGuardado = autorRepository.save(autor);

        return AutorMapper.mapToAutorDto(autorGuardado);
    }

    @Override
    public void eliminarAutor(Long idAutor) {
        if(!autorRepository.existsById(idAutor)) {
            throw new ResourceNotFoundException("No se encontro Autor con el ID: " + idAutor);
        }
        autorRepository.deleteById(idAutor);
    }
}
