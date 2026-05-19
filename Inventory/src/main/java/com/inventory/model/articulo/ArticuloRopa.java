package com.inventory.model.articulo;

public class ArticuloRopa
        extends Articulo {

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

    // =========================
    // GETTERS Y SETTERS
    // =========================

    public String getTalle() {

        return talle;
    }

    public void setTalle(
            String talle
    ) {

        this.talle = talle;
    }

    public String getColor() {

        return color;
    }

    public void setColor(
            String color
    ) {

        this.color = color;
    }

    public String getTemporada() {

        return temporada;
    }

    public void setTemporada(
            String temporada
    ) {

        this.temporada = temporada;
    }

    // =========================
    // MOSTRAR DETALLE
    // =========================

    @Override
    public void mostrarDetalle() {

        System.out.println(
                "👕 Talle: " +
                talle +
                " | Color: " +
                color
        );

        System.out.println(
                "☀️ Temporada: " +
                temporada
        );

        System.out.println(
                "💲 Precio final: $" +
                calcularPrecioFinal()
        );
    }

    // =========================
    // CALCULAR PRECIO
    // =========================

    @Override
    public double calcularPrecioFinal() {

        double precioFinal =
                getPrecio();

        switch (temporada) {

            // =====================
            // TEMPORADA ALTA
            // =====================

            case "ALTA" ->

                precioFinal *= 1.20;

            // =====================
            // TEMPORADA BAJA
            // =====================

            case "BAJA" ->

                precioFinal *= 0.70;
        }

        return precioFinal;
    }
}