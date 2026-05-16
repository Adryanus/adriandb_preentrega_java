package com.inventory.model.articulo;

public class ArticuloComestible
        extends Articulo {

    private String vencimiento;

    public ArticuloComestible(int id,
            String codigo,
            String descripcion,
            double precio,
            Categoria categoria,
            String vencimiento) {

        super(id,
                codigo,
                descripcion,
                precio,
                categoria);

        this.vencimiento = vencimiento;
    }

    public String getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(String vencimiento) {
        this.vencimiento = vencimiento;
    }

    @Override
    public void mostrarDetalle() {

        System.out.println(
                "🍎 Vence: " +
                        vencimiento);
    }
}
