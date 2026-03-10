package foro.miaguila.api.controller;

import foro.miaguila.api.dto.TemaRequest;
import foro.miaguila.api.dto.TemaResponse;
import foro.miaguila.api.service.TemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/temas")
public class TemaController {

    @Autowired
    private TemaService temaService;

    @GetMapping
    public List<TemaResponse> listarTemas() {
        return temaService.findAll();
    }

    @GetMapping("/{id}")
    public TemaResponse obtenerTema(@PathVariable Long id) {
        return temaService.findById(id);
    }

    @PostMapping
    public TemaResponse crearTema(@RequestBody TemaRequest dto) {
        return temaService.save(dto);
    }

    @PutMapping("/{id}")
    public TemaResponse actualizarTema(@PathVariable Long id, @RequestBody TemaRequest dto) {
        return temaService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminarTema(@PathVariable Long id) {
        temaService.delete(id);
    }
}
