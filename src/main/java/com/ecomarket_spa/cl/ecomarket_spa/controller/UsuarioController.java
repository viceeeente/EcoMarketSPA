package com.ecomarket_spa.cl.ecomarket_spa.controller;

import com.ecomarket_spa.cl.ecomarket_spa.model.Usuario;
import com.ecomarket_spa.cl.ecomarket_spa.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> obtenerTodos() {
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @GetMapping("/{run}")
    public ResponseEntity<Usuario> obtenerPorRun(@PathVariable String run) {
        return ResponseEntity.ok(usuarioService.findByRun(run));
    }

    @PostMapping
    public ResponseEntity<Usuario> crear(@RequestBody Usuario usuario) {
        return new ResponseEntity<>(usuarioService.save(usuario), HttpStatus.CREATED);
    }

    @PutMapping("/{run}")
    public ResponseEntity<Usuario> actualizar(@PathVariable String run, @RequestBody Usuario usuario) {
        usuarioService.findByRun(run); // Verifica que exista
        usuario.setRun(run);
        return ResponseEntity.ok(usuarioService.save(usuario));
    }

    @DeleteMapping("/{run}")
    public ResponseEntity<Void> eliminar(@PathVariable String run) {
        usuarioService.deleteByRun(run);
        return ResponseEntity.noContent().build();
    }
}