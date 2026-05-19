package com.inventory.service;

import com.inventory.model.articulo.Categoria;

import java.util.ArrayList;
import java.util.List;

public class CategoriaService {

    // =========================
    // LISTA
    // =========================

    private List<Categoria> categorias =
            new ArrayList<>();

    // =========================
    // ID AUTOINCREMENTAL
    // =========================

    private int nextId = 1;

    // =========================
    // AGREGAR
    // =========================

    public void agregar(
            String codigo,
            String nombre,
            String descripcion
    ) {

        Categoria categoria =
                new Categoria(
                        nextId++,
                        codigo,
                        nombre,
                        descripcion
                );

        categorias.add(categoria);
    }

    // =========================
    // LISTAR
    // =========================

    public List<Categoria> listar() {

        return categorias;
    }

    // =========================
    // BUSCAR
    // =========================

    public Categoria buscarPorCodigo(
            String codigo
    ) {

        for (Categoria c : categorias) {

            if (c.getCodigo()
                    .equalsIgnoreCase(codigo)) {

                return c;
            }
        }

        return null;
    }

    // =========================
    // MODIFICAR
    // =========================

    public boolean modificar(
            String codigo,
            String nuevoNombre,
            String nuevaDescripcion
    ) {

        Categoria categoria =
                buscarPorCodigo(codigo);

        if (categoria != null) {

            categoria.setNombre(
                    nuevoNombre
            );

            categoria.setDescripcion(
                    nuevaDescripcion
            );

            return true;
        }

        return false;
    }

    // =========================
    // ELIMINAR
    // =========================

    public boolean eliminar(
            String codigo
    ) {

        Categoria categoria =
                buscarPorCodigo(codigo);

        if (categoria != null) {

            categorias.remove(categoria);

            return true;
        }

        return false;
    }
}