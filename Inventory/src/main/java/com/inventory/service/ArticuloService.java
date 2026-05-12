
package com.inventory.service;

import com.inventory.model.articulo.Articulo;
import com.inventory.model.articulo.Categoria;

import java.util.ArrayList;
import java.util.List;

public class ArticuloService {

   

    private List<Articulo> articulos =
            new ArrayList<>();

    private int nextId = 1;



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

  

    public List<Articulo> listar() {

        return articulos;
    }


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