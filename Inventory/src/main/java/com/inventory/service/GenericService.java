package com.inventory.service;

import java.util.List;

import com.inventory.interfaces.CrudOperations;
import com.inventory.interfaces.Identificable;
import com.inventory.repository.Repository;

public class GenericService<T extends Identificable>
        implements CrudOperations<T> {

    protected Repository<T> repository;

    public GenericService() {

        repository = new Repository<>();
    }

    @Override
    public void agregar(T elemento) {

        repository.agregar(elemento);
    }

    @Override
    public List<T> listar() {

        return repository.listar();
    }

    @Override
    public T buscarPorId(int id) {

        return repository.buscarPorId(id);
    }

    @Override
    public boolean eliminar(int id) {

        return repository.eliminar(id);
    }
}
