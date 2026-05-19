package com.inventory.model.articulo;

public class ArticuloComestible
        extends Articulo {

    private String vencimiento;

    public ArticuloComestible(
            int id,
            String codigo,
            String descripcion,
            double precio,
            Categoria categoria,
            String vencimiento
    ) {

        super(
                id,
                codigo,
                descripcion,
                precio,
                categoria
        );

        this.vencimiento =
                vencimiento;
    }

    public String getVencimiento() {

        return vencimiento;
    }

    public void setVencimiento(
            String vencimiento
    ) {

        this.vencimiento =
                vencimiento;
    }

    // =========================
    // DETALLE
    // =========================

    @Override
    public String obtenerDetalle() {

        return
                "🍎 Vence: "
                + vencimiento;
    }

    // =========================
    // PRECIO FINAL
    // =========================

    @Override
    public double calcularPrecioFinal() {

        if (vencimiento.equalsIgnoreCase("6M")) {

            return getPrecio();
        }

        if (vencimiento.equalsIgnoreCase("1M")) {

            return getPrecio() * 0.85;
        }

        if (vencimiento.equalsIgnoreCase("7D")) {

            return getPrecio() * 0.60;
        }

        return getPrecio();
    }
}
