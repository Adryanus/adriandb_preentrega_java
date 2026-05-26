package com.inventory.model;

import com.inventory.interfaces.Identificable;

public class Producto implements Identificable {

    protected int id;

    protected String codigo;

    protected String descripcion;

    protected double precio;

    public Producto(
            int id,
            String codigo,
            String descripcion,
            double precio
    ) {

        this.id = id;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    // =========================
    // ID
    // =========================

    @Override
    public int getId() {
        return id;
    }

    // =========================
    // CODIGO
    // =========================

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    // =========================
    // DESCRIPCION
    // =========================

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // =========================
    // PRECIO
    // =========================

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
