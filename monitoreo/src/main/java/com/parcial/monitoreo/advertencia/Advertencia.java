package com.parcial.monitoreo.advertencia;

import com.parcial.monitoreo.producto.Producto;
import org.springframework.stereotype.Component;

@Component
public class AdvertenciaAgent {
    public void notifyLowStock(Producto producto) {
        System.out.println("ALERTA!!! El stock del Producto: " + producto.getNombre() + " es muy bajo, solo quedan " + producto.getCantidad() + " unidades disponibles.");
    }
}
