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

    // =========================
    // GETTERS Y SETTERS
    // =========================

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
    // MOSTRAR DETALLE
    // =========================

    @Override
    public void mostrarDetalle() {

        System.out.println(
                "🍎 Vence: " +
                vencimiento
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

        switch (vencimiento) {

            // =====================
            // 6 meses
            // =====================

            case "6M" ->

                precioFinal *= 1.00;

            // =====================
            // 1 mes
            // =====================

            case "1M" ->

                precioFinal *= 0.80;

            // =====================
            // 7 dias
            // =====================

            case "7D" ->

                precioFinal *= 0.50;
        }

        return precioFinal;
    }
}
