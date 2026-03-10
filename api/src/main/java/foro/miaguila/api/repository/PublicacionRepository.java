package foro.miaguila.api.repository;

import foro.miaguila.api.entity.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface PublicacionRepository extends JpaRepository<Publicacion, Long> {

    Optional<Publicacion> findByTituloAndMensaje(String titulo, String mensaje);

    // Primeros 10 más antiguos
    List<Publicacion> findTop10ByOrderByFechaCreacionAsc();

    // Últimos 10 más recientes
    List<Publicacion> findTop10ByOrderByFechaCreacionDesc();
}
