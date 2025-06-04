package com.application.rest.service;

import com.application.rest.entity.Noticia;
import com.application.rest.repository.dto.NoticiaDTO;

import java.util.List;

public interface NoticiaService {
    NoticiaDTO guardarNoticia(NoticiaDTO noticiaDto);

    NoticiaDTO buscarNoticiaPorId(Long idNoticia);

    List<NoticiaDTO> listarTodasNoticias();

    NoticiaDTO actualizarNoticia(Long idNoticia, NoticiaDTO noticiaDto);

    void eliminarNoticia(Long idNoticia);
}
