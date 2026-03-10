package foro.miaguila.api.controller;

import foro.miaguila.api.entity.Categoria;
import foro.miaguila.api.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/categorias")

public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    // GET: listar todas las categorías
    @GetMapping
    public List<Categoria> listarCategorias() {
        return categoriaService.findAll();
    }

    // GET: obtener categoría por ID
    @GetMapping("/{id}")
    public Categoria obtenerCategoria(@PathVariable Long id) {
        return categoriaService.findById(id);
    }

    // POST: crear nueva categoría
    @PostMapping
    public Categoria crearCategoria(@RequestBody Categoria categoria) {
        return categoriaService.save(categoria);
    }

    // PUT: actualizar categoría existente
    @PutMapping("/{id}")
    public Categoria actualizarCategoria(@PathVariable Long id, @RequestBody Categoria categoria) {
        Categoria existente = categoriaService.findById(id);
        existente.setNombre(categoria.getNombre());
        existente.setDescripcion(categoria.getDescripcion());
        return categoriaService.save(existente);
    }

    // DELETE: eliminar categoría
    @DeleteMapping("/{id}")
    public void eliminarCategoria(@PathVariable Long id) {
        categoriaService.delete(id);
    }
}