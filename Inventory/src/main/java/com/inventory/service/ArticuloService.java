package com.inventory.service;

import java.util.ArrayList;
import java.util.List;

import com.inventory.model.articulo.Articulo;
import com.inventory.model.articulo.Categoria;

public class ArticuloService
        extends GenericService<Articulo> {

    // =========================
    // BUSCAR POR CATEGORIA
    // =========================

    public List<Articulo> buscarPorCategoria(
            Categoria categoria
    ) {

        List<Articulo> resultado =
                new ArrayList<>();

        for (Articulo articulo : listar()) {

            if (articulo.getCategoria()
                    .equals(categoria)) {

                resultado.add(articulo);
            }
        }

        return resultado;
    }

    // =========================
    // VALIDAR CATEGORIA EN USO
    // =========================

    public boolean existeCategoriaEnUso(
            int idCategoria
    ) {

        for (Articulo articulo : listar()) {

            if (articulo
                    .getCategoria()
                    .getId() == idCategoria) {

                return true;
            }
        }

        return false;
    }
}