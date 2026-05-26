package com.inventory.model.articulo;

public class ArticuloElectronico extends Articulo {

    private int garantiaMeses;

    public ArticuloElectronico(
            int id,
            String codigo,
            String descripcion,
            double precio,
            Categoria categoria,
            int garantiaMeses
    ) {

        super(
                id,
                codigo,
                descripcion,
                precio,
                categoria
        );

        this.garantiaMeses = garantiaMeses;
    }

    public int getGarantiaMeses() {
        return garantiaMeses;
    }

    public void setGarantiaMeses(int garantiaMeses) {
        this.garantiaMeses = garantiaMeses;
    }

    // =========================
    // DETALLE
    // =========================

    @Override
    public String obtenerDetalle() {

        return "🔌 Garantía: "
                + garantiaMeses
                + " meses";
    }

    // =========================
    // PRECIO FINAL
    // =========================

    @Override
    public double calcularPrecioFinal() {

        switch (garantiaMeses) {

            case 6:
                return getPrecio() * 1.05;

            case 12:
                return getPrecio() * 1.10;

            case 36:
                return getPrecio() * 1.25;

            default:
                return getPrecio();
        }
    }
}
