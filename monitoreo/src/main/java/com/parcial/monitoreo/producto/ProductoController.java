package com.parcial.monitoreo.producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody Producto producto) {
        if (productoService.addProduct(producto)) {
            return ResponseEntity.ok("Producto agregado.");
        }
        return ResponseEntity.badRequest().body("El producto ya existe.");
    }

    @PatchMapping("/{nombre}/stock")
    public ResponseEntity<String> updateStock(@PathVariable String nombre, @RequestParam int nuevaCantidad) {
        try {
            productoService.updateStock(nombre, nuevaCantidad);
            return ResponseEntity.ok("Stock actualizado.");
        } catch (ProductoNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<Map<String, Producto>> getAllProducts() {
        return ResponseEntity.ok(productoService.getAllProducts());
    }
}