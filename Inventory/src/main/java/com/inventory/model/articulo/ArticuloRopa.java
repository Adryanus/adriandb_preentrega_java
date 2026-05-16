package com.inventory.model.articulo;

public class ArticuloRopa
        extends Articulo {

    private String talle;

    private String color;

    public ArticuloRopa(int id,
            String codigo,
            String descripcion,
            double precio,
            Categoria categoria,
            String talle,
            String color) {

        super(id,
                codigo,
                descripcion,
                precio,
                categoria);

        this.talle = talle;
        this.color = color;
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

    @Override
    public void mostrarDetalle() {

        System.out.println(
                "👕 Talle: " + talle +
                        " | Color: " + color);
    }
}