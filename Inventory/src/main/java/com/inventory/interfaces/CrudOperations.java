package com.inventory.interfaces;

import java.util.List;

public interface CrudOperations<T> {

    // =========================
    // CREATE
    // =========================

    void agregar(T elemento);

    // =========================
    // READ
    // =========================

    List<T> listar();

    T buscarPorId(int id);

    // =========================
    // DELETE
    // =========================

    boolean eliminar(int id);
}