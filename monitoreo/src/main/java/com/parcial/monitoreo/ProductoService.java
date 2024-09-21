package com.parcial.monitoreo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import com.parcial.monitoreo.producto.*;
import com.parcial.monitoreo.log.Log;
import com.parcial.monitoreo.advertencia.Advertencia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@Service
public class ProductoService {

	private final Map<String, Producto> productos = new HashMap<>();
    private final Log logAgent;
    private final Advertencia advertenciaAgent;

	public ProductoService(Log logAgent, Advertencia advertenciaAgent) {
        this.logAgent = logAgent;
        this.advertenciaAgent = advertenciaAgent;
    }

	public boolean addProduct(Producto newProduct) {
		if (!productos.containsKey(newProduct.getNombre())) {
            productos.put(newProduct.getNombre(), newProduct);
            return true;
        }
        return false;
	}

	public void updateStock(String nombre, int nuevaCantidad) {
		Producto producto = productos.get(nombre);
        if (producto == null) {
            throw new ProductoNotFoundException("Producto no encontrado.");
        }
        producto.setCantidad(nuevaCantidad);
        logAgent.notifyStockChange(producto);
        if (nuevaCantidad < 5) {
            advertenciaAgent.notifyLowStock(producto);
        }
	}

	public Producto getProduct(String nombre) {
        return productos.get(nombre);
    }

    public Map<String, Producto> getAllProducts() {
        return productos;
    }
	
	public static void main(String[] args) {
		SpringApplication.run(ProductoService.class, args);
	}
	
}
