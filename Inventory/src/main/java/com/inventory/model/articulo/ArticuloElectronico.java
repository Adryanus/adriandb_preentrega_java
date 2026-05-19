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

    // =========================
    // GETTERS Y SETTERS
    // =========================

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
    // MOSTRAR DETALLE
    // =========================

    @Override
    public void mostrarDetalle() {

        System.out.println(
                "🔌 Garantia: " +
                garantiaMeses +
                " meses"
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

        switch (garantiaMeses) {

            case 6 ->

                precioFinal *= 1.05;

            case 12 ->

                precioFinal *= 1.10;

            case 36 ->

                precioFinal *= 1.25;
        }

        return precioFinal;
    }
}
