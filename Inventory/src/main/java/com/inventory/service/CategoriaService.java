package com.inventory.service;

import com.inventory.model.articulo.Categoria;

import java.util.ArrayList;
import java.util.List;

public class CategoriaService {

    private List<Categoria> categorias =
            new ArrayList<>();

    private int nextId = 1;

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

    public List<Categoria> listar() {

        return categorias;
    }

    public Categoria buscarPorCodigo(String codigo) {

        for (Categoria c : categorias) {

            if (c.getCodigo()
                 .equalsIgnoreCase(codigo)) {

                return c;
            }
        }

        return null;
    }
}
