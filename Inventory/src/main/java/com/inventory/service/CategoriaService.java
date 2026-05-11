// ========================================
// CategoriaService.java
// ========================================

package com.inventory.service;

import com.inventory.model.articulo.Categoria;

import java.util.ArrayList;
import java.util.List;

public class CategoriaService {

    // =========================
    // ATRIBUTOS
    // =========================

    private List<Categoria> categorias =
            new ArrayList<>();

    private int nextId = 1;

    // =========================
    // AGREGAR
    // =========================

    public void agregar(String codigo,
                        String nombre,
                        String descripcion) {

        categorias.add(

                new Categoria(
                        nextId++,
                        codigo,
                        nombre,
                        descripcion
                )
        );
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

            if (
                c.getCodigo()
                 .equalsIgnoreCase(codigo)
            ) {

                return c;
            }
        }

        return null;
    }
}