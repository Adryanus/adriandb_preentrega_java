package com.inventory.model.articulo;

import com.inventory.interfaces.Identificable;

public class Categoria implements Identificable {

    private int id;

    private String nombre;

    private String descripcion;

    public Categoria(
            int id,
            String nombre,
            String descripcion
    ) {

        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // =========================
    // ID
    // =========================

    @Override
    public int getId() {

        return id;
    }

    // =========================
    // NOMBRE
    // =========================

    public String getNombre() {

        return nombre;
    }

    public void setNombre(
            String nombre
    ) {

        this.nombre = nombre;
    }

    // =========================
    // DESCRIPCION
    // =========================

    public String getDescripcion() {

        return descripcion;
    }

    public void setDescripcion(
            String descripcion
    ) {

        this.descripcion = descripcion;
    }

    // =========================
    // TOSTRING
    // =========================

    @Override
    public String toString() {

        return nombre;
    }
}
