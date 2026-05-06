package com.inventory.service;

import com.inventory.model.Articulo;
import java.util.ArrayList;
import java.util.List;

public class ArticuloService {

    private List<Articulo> productos = new ArrayList<>();
    private int nextId = 1;

    public void agregar(String codigo, String descripcion, double precio, String categoria) {
        productos.add(new Articulo(nextId++, codigo, descripcion, precio, categoria));
    }

    public List<Articulo> listar() {
        return productos;
    }

    public Articulo buscarPorCodigo(String codigo) {
        for (Articulo p : productos) {
            if (p.codigo.equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        return null;
    }

    public boolean eliminar(String codigo) {
        Articulo p = buscarPorCodigo(codigo);
        if (p != null) {
            productos.remove(p);
            return true;
        }
        return false;
    }
}