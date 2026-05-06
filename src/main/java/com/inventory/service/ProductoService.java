package com.inventory.service;

import com.inventory.model.Producto;
import java.util.ArrayList;
import java.util.List;

public class ProductoService {

    private List<Producto> productos = new ArrayList<>();
    private int nextId = 1;

    public void agregar(String codigo, String descripcion, double precio, String categoria) {
        productos.add(new Producto(nextId++, codigo, descripcion, precio, categoria));
    }

    public List<Producto> listar() {
        return productos;
    }

    public Producto buscarPorCodigo(String codigo) {
        for (Producto p : productos) {
            if (p.codigo.equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        return null;
    }

    public boolean eliminar(String codigo) {
        Producto p = buscarPorCodigo(codigo);
        if (p != null) {
            productos.remove(p);
            return true;
        }
        return false;
    }
}