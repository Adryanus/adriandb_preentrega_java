package com.inventory.model.articulo;

public class Categoria {

    // =========================
    // ATRIBUTOS
    // =========================

    private int id;

    private String codigo;

    private String nombre;

    private String descripcion;

    // =========================
    // CONSTRUCTOR
    // =========================

    public Categoria(int id,
                     String codigo,
                     String nombre,
                     String descripcion) {

        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // =========================
    // GETTERS
    // =========================

    public int getId() {

        return id;
    }

    public String getCodigo() {

        return codigo;
    }

    public String getNombre() {

        return nombre;
    }

    public String getDescripcion() {

        return descripcion;
    }

    // =========================
    // SETTERS
    // =========================

    public void setId(int id) {

        this.id = id;
    }

    public void setCodigo(String codigo) {

        this.codigo = codigo;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {

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