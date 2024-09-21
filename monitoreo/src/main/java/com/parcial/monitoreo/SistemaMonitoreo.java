package com.parcial.monitoreo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.parcial.monitoreo.producto.Producto;
import com.parcial.monitoreo.log.Log;
import com.parcial.monitoreo.advertencia.Advertencia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class SistemaMonitoreo {

	private final Map<String, Producto> productos = new HashMap<>();
    private final Log logAgent;
    private final Advertencia advertenciaAgent;

	public SistemaMonitoreo(Log logAgent, Advertencia advertenciaAgent) {
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

	public boolean updateStock(Producto product, String newStock) {
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

    public Map<String, Producto> getAllProducts() {
        return productos;
    }
	
	public static void main(String[] args) {
		SpringApplication.run(SistemaMonitoreo.class, args);
	}
	
}
