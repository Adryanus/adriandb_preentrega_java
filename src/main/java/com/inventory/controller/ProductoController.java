package com.inventory.controller;

import com.inventory.service.ProductoService;
import com.inventory.model.Producto;
import java.util.Scanner;

public class ProductoController {

    private ProductoService service = new ProductoService();
    private Scanner sc = new Scanner(System.in);

    public void iniciar() {
        int opcion;

        do {
            System.out.println("\n📦 INVENTARIO");
            System.out.println("1. Agregar");
            System.out.println("2. Listar");
            System.out.println("3. Buscar");
            System.out.println("4. Eliminar");
            System.out.println("0. Salir");

            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> {
                    agregar();
                    pausa();
                }
                case 2 -> {
                    listar();
                    pausa();
                }
                case 3 -> {
                    buscar();
                    pausa();
                }
                case 4 -> {
                    eliminar();
                    pausa();
                }
            }

        } while (opcion != 0);
    }

    private void agregar() {
        System.out.print("Código: ");
        String codigo = sc.nextLine();

        System.out.print("Descripción: ");
        String desc = sc.nextLine();

        System.out.print("Precio: ");
        double precio = Double.parseDouble(sc.nextLine());

        System.out.print("Categoría: ");
        String cat = sc.nextLine();

        service.agregar(codigo, desc, precio, cat);
    }

   private void listar() {

    String linea = "+----+----------+-------------------+-----------+----------------+";

    System.out.println("\n📋 LISTA DE PRODUCTOS");
    System.out.println(linea);

    System.out.printf("| %-2s | %-8s | %-17s | %-9s | %-14s |%n",
            "ID", "Código", "Descripción", "Precio", "Categoría");

    System.out.println(linea);

    for (Producto p : service.listar()) {
        System.out.printf("| %-2d | %-8s | %-17s | %-9.2f | %-14s |%n",
                p.id,
                truncar(p.codigo, 10),
                truncar(p.descripcion, 22),
                p.precio,
                truncar(p.categoria, 16));
    }

    System.out.println(linea);
}

    private void buscar() {
        System.out.print("Código: ");
        String codigo = sc.nextLine();

        Producto p = service.buscarPorCodigo(codigo);

        if (p != null) {
            System.out.println(p.descripcion);
        } else {
            System.out.println("❌ No encontrado");
        }
    }

    private void eliminar() {
        System.out.print("Código: ");
        String codigo = sc.nextLine();

        if (service.eliminar(codigo)) {
            System.out.println("🗑️ Eliminado");
        } else {
            System.out.println("❌ No existe");
        }
    }

    private void pausa() {
        System.out.println("\nPresione ENTER para continuar...");
        sc.nextLine();
    }

    private String truncar(String texto, int max) {
    if (texto.length() > max) {        
        return texto.substring(0, max - 3) + "...";
    }
    return texto;
}
}
