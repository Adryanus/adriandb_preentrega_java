package com.inventory.model.articulo;

public class ArticuloRopa extends Articulo {

    private String talle;
    private String color;
    private String temporada;

    public ArticuloRopa(
            int id,
            String codigo,
            String descripcion,
            double precio,
            Categoria categoria,
            String talle,
            String color,
            String temporada
    ) {

        super(
                id,
                codigo,
                descripcion,
                precio,
                categoria
        );

        this.talle = talle;
        this.color = color;
        this.temporada = temporada;
    }

    public String getTalle() {
        return talle;
    }

    public void setTalle(String talle) {
        this.talle = talle;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    // =========================
    // DETALLE
    // =========================

    @Override
    public String obtenerDetalle() {

        return "👕 Talle: "
                + talle
                + " | Color: "
                + color
                + " | Temporada: "
                + temporada;
    }

    // =========================
    // PRECIO FINAL
    // =========================

    @Override
    public double calcularPrecioFinal() {

        switch (temporada.toUpperCase()) {

            case "ALTA":
                return getPrecio() * 1.30;

            case "BAJA":
                return getPrecio() * 0.80;

            default:
                return getPrecio();
        }
    }
}