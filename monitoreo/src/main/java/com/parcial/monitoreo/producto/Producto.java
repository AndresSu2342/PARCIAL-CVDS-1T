package com.parcial.monitoreo.producto;

public class Producto {
    private String nombre;
    private double precio;
    private int cantidad;
    private String categoria;

    public Producto(String nombre, double precio, int cantidad, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }

    public String getNombre(){
        return nombre;
    }
    public double getPrecio(){
        return precio;
    }
    public int getCantidad(){
        return cantidad;
    }
    public String getCategoria(){
        return categoria;
    }
    
    public void setNombre(String newNombre){
        nombre = newNombre;
    }
    public void setPrecio(double newPrecio){
        precio = newPrecio;
    }
    public void setCantidad(int newCantidad){
        cantidad = newCantidad;
    }
    public void setCategoria(String newCategoria){
        categoria = newCategoria;
    }

}
