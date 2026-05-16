package com.inventory.model.articulo;

import com.inventory.model.Producto;

import com.inventory.interfaces.Mostrable;

public abstract class Articulo
        extends Producto
        implements Mostrable {

    private Categoria categoria;

    public Articulo(int id,
            String codigo,
            String descripcion,
            double precio,
            Categoria categoria) {

        super(id,
                codigo,
                descripcion,
                precio);

        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}