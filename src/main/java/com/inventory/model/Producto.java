package com.inventory.model;

public class Producto {

    public int id;
    public String codigo;
    public String descripcion;
    public double precio;
    public String categoria;

    public Producto(int id, String codigo, String descripcion, double precio, String categoria) {
        this.id = id;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
    }
}