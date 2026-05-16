package com.inventory.model.articulo;

public class ArticuloElectronico
        extends Articulo {

    private int garantiaMeses;

    public ArticuloElectronico(int id,
            String codigo,
            String descripcion,
            double precio,
            Categoria categoria,
            int garantiaMeses) {

        super(id,
                codigo,
                descripcion,
                precio,
                categoria);

        this.garantiaMeses = garantiaMeses;
    }

    public int getGarantiaMeses() {
        return garantiaMeses;
    }

    public void setGarantiaMeses(int garantiaMeses) {
        this.garantiaMeses = garantiaMeses;
    }

    @Override
    public void mostrarDetalle() {

        System.out.println(
                "🔌 Garantia: " +
                        garantiaMeses +
                        " meses");
    }
}
