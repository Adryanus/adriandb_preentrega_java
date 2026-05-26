package com.inventory.model.articulo;

public class ArticuloComestible extends Articulo {

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

        this.vencimiento = vencimiento;
    }

    public String getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(String vencimiento) {
        this.vencimiento = vencimiento;
    }

    // =========================
    // DETALLE
    // =========================

    @Override
    public String obtenerDetalle() {

        return "🍎 Vence: " + vencimiento;
    }

    // =========================
    // PRECIO FINAL
    // =========================

    @Override
    public double calcularPrecioFinal() {

        switch (vencimiento.toUpperCase()) {

            case "1M":
                return getPrecio() * 0.85;

            case "7D":
                return getPrecio() * 0.60;

            case "6M":
            default:
                return getPrecio();
        }
    }
}

