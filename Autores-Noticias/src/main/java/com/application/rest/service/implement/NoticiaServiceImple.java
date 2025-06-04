package com.application.rest.service.implement;

import com.application.rest.entity.Noticia;
import com.application.rest.exception.ResourceNotFoundException;
import com.application.rest.repository.NoticiaRepository;
import com.application.rest.repository.dto.NoticiaDTO;
import com.application.rest.repository.mapper.NoticiaMapper;
import com.application.rest.service.NoticiaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NoticiaServiceImple implements NoticiaService {

    private NoticiaRepository noticiaRepository;

    @Override
    public NoticiaDTO guardarNoticia(NoticiaDTO noticia) {
        Noticia noticiaAGuardar = NoticiaMapper.mapToNoticia(noticia);
        Noticia noticiaGuardada = noticiaRepository.save(noticiaAGuardar);
        return NoticiaMapper.mapToNoticiaDto(noticiaGuardada);
    }

    @Override
    public NoticiaDTO buscarNoticiaPorId(Long idNoticia) {
        Noticia noticia = noticiaRepository.findById(idNoticia)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro ninguna Noticia con el ID: " + idNoticia));

        return NoticiaMapper.mapToNoticiaDto(noticia);
    }

    @Override
    public List<NoticiaDTO> listarTodasNoticias() {
        List<Noticia> noticias = noticiaRepository.findAll();

        return noticias.stream().map(NoticiaMapper::mapToNoticiaDto)
                .collect(Collectors.toList());
    }


    @Override
    public NoticiaDTO actualizarNoticia(Long idNoticia, NoticiaDTO noticiaDTO) {
        Noticia noticia = noticiaRepository.findById(idNoticia)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro Noticia con ID: " + idNoticia));

        noticia.setTitulo(noticiaDTO.getTitulo());
        noticia.setContenido(noticiaDTO.getContenido());
        noticia.setIdAutor(noticiaDTO.getIdAutor());

        Noticia noticiaGuardada = noticiaRepository.save(noticia);
        return NoticiaMapper.mapToNoticiaDto(noticiaGuardada);
    }

    @Override
    public void eliminarNoticia(Long idNoticia) {
        if (!noticiaRepository.existsById(idNoticia)) {
            throw new ResourceNotFoundException("El producto con el ID " + idNoticia + " no existe");
        }
        noticiaRepository.deleteById(idNoticia);
    }
}
