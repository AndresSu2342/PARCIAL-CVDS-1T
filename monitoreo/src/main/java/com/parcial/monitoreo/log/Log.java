package com.parcial.monitoreo.log;

import com.parcial.monitoreo.producto.Producto;
import org.springframework.stereotype.Component;

@Component
public class Log {
    public void notifyStockChange(Producto producto) {
        System.out.println("Producto: " + producto.getNombre() + " -> " + producto.getCantidad() + " unidades disponibles");
    }
}
