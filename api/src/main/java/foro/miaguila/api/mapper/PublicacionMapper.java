package foro.miaguila.api.mapper;

import foro.miaguila.api.dto.request.PublicacionRequest;
import foro.miaguila.api.dto.response.PublicacionResponse;
import foro.miaguila.api.entity.Publicacion;
import foro.miaguila.api.entity.Tema;
import org.springframework.stereotype.Component;

@Component
public class PublicacionMapper {

    public Publicacion toEntity(PublicacionRequest request, Tema tema) {
        Publicacion publicacion = new Publicacion();
        publicacion.setTitulo(request.getTitulo());
        publicacion.setMensaje(request.getMensaje());
        publicacion.setAutor(request.getAutor());
        publicacion.setEstado(request.getEstado() != null ? request.getEstado() : "ACTIVO");
        publicacion.setTema(tema);
        return publicacion;
    }

    public PublicacionResponse toResponse(Publicacion publicacion) {
        return new PublicacionResponse(
                publicacion.getId(),
                publicacion.getTitulo(),
                publicacion.getMensaje(),
                publicacion.getAutor(),
                publicacion.getEstado(),
                publicacion.getFechaCreacion(),
                publicacion.getTema() != null ? publicacion.getTema().getTitulo() : null,
                (publicacion.getTema() != null && publicacion.getTema().getCategoria() != null)
                        ? publicacion.getTema().getCategoria().getNombre()
                        : null
        );
    }
}
