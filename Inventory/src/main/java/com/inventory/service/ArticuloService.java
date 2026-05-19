package com.inventory.service;

import com.inventory.model.articulo.Articulo;

import java.util.ArrayList;
import java.util.List;

public class ArticuloService {

    private List<Articulo> articulos =
            new ArrayList<>();

    // =========================
    // AGREGAR
    // =========================

    public void agregar(
            Articulo articulo
    ) {

        articulos.add(articulo);
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

            if (a.getCodigo()
                    .equalsIgnoreCase(codigo)) {

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

    // =========================
    // VALIDAR CATEGORIA EN USO
    // =========================

    public boolean existeCategoriaEnUso(
            String codigoCategoria
    ) {

        for (Articulo a : articulos) {

            if (a.getCategoria()
                    .getCodigo()
                    .equalsIgnoreCase(
                            codigoCategoria
                    )) {

                return true;
            }
        }

        return false;
    }
}