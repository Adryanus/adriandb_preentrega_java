// ========================================
// ArticuloService.java
// ========================================

package com.inventory.service;

import com.inventory.model.articulo.Articulo;
import com.inventory.model.articulo.Categoria;

import java.util.ArrayList;
import java.util.List;

public class ArticuloService {

    // =========================
    // ATRIBUTOS
    // =========================

    private List<Articulo> articulos =
            new ArrayList<>();

    private int nextId = 1;

    // =========================
    // AGREGAR
    // =========================

    public void agregar(String codigo,
                        String descripcion,
                        double precio,
                        Categoria categoria) {

        articulos.add(

                new Articulo(
                        nextId++,
                        codigo,
                        descripcion,
                        precio,
                        categoria
                )
        );
    }

    // =========================
    // LISTAR
    // =========================

    public List<Articulo> listar() {

        return articulos;
    }

    // =========================
    // BUSCAR
    // =========================

    public Articulo buscarPorCodigo(
            String codigo
    ) {

        for (Articulo a : articulos) {

            if (
                a.getCodigo()
                 .equalsIgnoreCase(codigo)
            ) {

                return a;
            }
        }

        return null;
    }

    // =========================
    // ELIMINAR
    // =========================

    public boolean eliminar(
            String codigo
    ) {

        Articulo a =
                buscarPorCodigo(codigo);

        if (a != null) {

            articulos.remove(a);

            return true;
        }

        return false;
    }
}