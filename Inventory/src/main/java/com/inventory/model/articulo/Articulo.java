package com.inventory.model.articulo;

import com.inventory.model.Producto;

public abstract class Articulo extends Producto {

    protected Categoria categoria;

    public Articulo(
            int id,
            String codigo,
            String descripcion,
            double precio,
            Categoria categoria
    ) {

        super(
                id,
                codigo,
                descripcion,
                precio
        );

        this.categoria = categoria;
    }

    // =========================
    // CATEGORIA
    // =========================

    public Categoria getCategoria() {

        return categoria;
    }

    public void setCategoria(
            Categoria categoria
    ) {

        this.categoria = categoria;
    }

    // =========================
    // METODOS ABSTRACTOS
    // =========================

    public abstract String obtenerDetalle();

    public abstract double calcularPrecioFinal();
}