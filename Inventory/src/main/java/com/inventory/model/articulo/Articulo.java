package com.inventory.model.articulo;

public class Articulo {

    // =========================
    // ATRIBUTOS
    // =========================

    private int id;

    private String codigo;

    private String descripcion;

    private double precio;

    private Categoria categoria;

    // =========================
    // CONSTRUCTOR
    // =========================

    public Articulo(int id,
                     String codigo,
                     String descripcion,
                     double precio,
                     Categoria categoria) {

        this.id = id;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
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

    public String getDescripcion() {

        return descripcion;
    }

    public double getPrecio() {

        return precio;
    }

    public Categoria getCategoria() {

        return categoria;
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

    public void setDescripcion(String descripcion) {

        this.descripcion = descripcion;
    }

    public void setPrecio(double precio) {

        this.precio = precio;
    }

    public void setCategoria(Categoria categoria) {

        this.categoria = categoria;
    }

    // =========================
    // TOSTRING
    // =========================

    @Override
    public String toString() {

        return "Articulo{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", categoria=" + categoria.getNombre() +
                '}';
    }
}