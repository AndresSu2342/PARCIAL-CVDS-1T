package com.parcial.monitoreo.producto;

public class Producto {
    private String name;
    private double price;
    private int stock;
    private String category;

    public Producto(String nombre, double precio, int cantidad, String categoria) {
        this.name = nombre;
        this.price = precio;
        this.stock = cantidad;
        this.category = categoria;
    }

    public String getName(){
        return name;
    }
    public String getPrice(){
        return price;
    }
    public String getStock(){
        return stock;
    }
    public String getCategory(){
        return category;
    }
    
    public void setName(String newName){
        name = newName;
    }
    public void setPrice(String newPrice){
        price = newPrice;
    }
    public void setStock(String newStock){
        stock = newStock;
    }
    public void setCategory(String newCategory){
        category = newCategory;
    }

}