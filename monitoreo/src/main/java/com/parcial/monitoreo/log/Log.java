package com.parcial.monitoreo.log;

public class Log {
    public void executeAgent(Producto producto) {
        system.out.println("Producto:"+producto.getName()+" -> "+producto.getStock()+" unidades disponibles.");
    }
}