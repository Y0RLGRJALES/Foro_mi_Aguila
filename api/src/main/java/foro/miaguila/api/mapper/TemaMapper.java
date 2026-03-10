package foro.miaguila.api.mapper;

import foro.miaguila.api.dto.TemaRequest;
import foro.miaguila.api.dto.TemaResponse;
import foro.miaguila.api.entity.Tema;
import foro.miaguila.api.entity.Categoria;
import org.springframework.stereotype.Component;

@Component
public class TemaMapper {

    public Tema toEntity(TemaRequest request, Categoria categoria) {
        Tema tema = new Tema();
        tema.setTitulo(request.getTitulo());
        tema.setCategoria(categoria);
        return tema;
    }

    public TemaResponse toResponse(Tema tema) {
        TemaResponse response = new TemaResponse();
        response.setId(tema.getId());
        response.setTitulo(tema.getTitulo());
        response.setCategoriaId(tema.getCategoria().getId());
        return response;
    }
}
