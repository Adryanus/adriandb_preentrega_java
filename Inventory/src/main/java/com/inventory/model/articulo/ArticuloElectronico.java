package com.inventory.model.articulo;

public class ArticuloElectronico
        extends Articulo {

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

        this.garantiaMeses =
                garantiaMeses;
    }

    public int getGarantiaMeses() {

        return garantiaMeses;
    }

    public void setGarantiaMeses(
            int garantiaMeses
    ) {

        this.garantiaMeses =
                garantiaMeses;
    }

    // =========================
    // DETALLE
    // =========================

    @Override
    public String obtenerDetalle() {

        return
                "🔌 Garantia: "
                + garantiaMeses
                + " meses";
    }

    // =========================
    // PRECIO FINAL
    // =========================

    @Override
    public double calcularPrecioFinal() {

        if (garantiaMeses == 6) {

            return getPrecio() * 1.05;
        }

        if (garantiaMeses == 12) {

            return getPrecio() * 1.10;
        }

        if (garantiaMeses == 36) {

            return getPrecio() * 1.25;
        }

        return getPrecio();
    }
}
