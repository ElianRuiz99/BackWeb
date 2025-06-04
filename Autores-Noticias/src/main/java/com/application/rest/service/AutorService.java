package com.application.rest.service;

import com.application.rest.repository.dto.AutorDTO;

import java.util.List;

public interface AutorService {

    AutorDTO guardarAutor(AutorDTO autorDTO);

    AutorDTO buscarAutorPorId(Long idAutor);

    List<AutorDTO> listarTodosAutores();

    AutorDTO actualizarAutor(Long idAutor, AutorDTO autorDTo);

    void eliminarAutor(Long idAutor);

}
