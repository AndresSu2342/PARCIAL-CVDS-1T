package com.parcial.monitoreo.advertencia;

public class Advertencia {
    public void executeAgent(Producto producto) {
        system.out.println("ALERTA!!! El stock del Producto: "+producto.getName()+ " es muy bajo, solo quedan "+producto.getStock()+" unidades disponibles.");
    }
}