package com.inventory.repository;

import java.util.ArrayList;
import java.util.List;

import com.inventory.interfaces.Identificable;

public class Repository<T extends Identificable> {

    private List<T> elementos;

    public Repository() {

        elementos = new ArrayList<>();
    }

    public void agregar(T elemento) {

        elementos.add(elemento);
    }

    public List<T> listar() {

        return elementos;
    }

    public T buscarPorId(int id) {

        for (T elemento : elementos) {

            if (elemento.getId() == id) {

                return elemento;
            }
        }

        return null;
    }

    public boolean eliminar(int id) {

        T elemento = buscarPorId(id);

        if (elemento != null) {

            elementos.remove(elemento);

            return true;
        }

        return false;
    }
}