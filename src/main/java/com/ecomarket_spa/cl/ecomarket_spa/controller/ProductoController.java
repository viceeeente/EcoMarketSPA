package com.ecomarket_spa.cl.ecomarket_spa.controller;

import com.ecomarket_spa.cl.ecomarket_spa.model.Producto;
import com.ecomarket_spa.cl.ecomarket_spa.service.ProductoService;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/prueba/v1/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> listar(){
        List<Producto> productos = productoService.findAll();
        if(productos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(productos);
    }
}
