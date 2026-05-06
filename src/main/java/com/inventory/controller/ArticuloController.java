package com.inventory.controller;

import com.inventory.service.ArticuloService;
import com.inventory.model.Articulo;
import java.util.Scanner;

public class ArticuloController {

    private ArticuloService service = new ArticuloService();
    private Scanner sc = new Scanner(System.in);

    public void iniciar() {

        int opcion;

        do {

            System.out.println("\n📦 INVENTARIO de ARTICULOS");
            System.out.println("1. Agregar");
            System.out.println("2. Listar");
            System.out.println("3. Buscar");
            System.out.println("4. Modificar");
            System.out.println("5. Eliminar");
            System.out.println("0. Salir");

            System.out.print("Opción: ");

            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {

                case 1 -> {
                    agregar();
                    
                }

                case 2 -> {
                    listar();
                    
                }

                case 3 -> {
                    buscar();
                    
                }

                case 4 -> {
                    modificar();
                    
                }

                case 5 -> {
                    eliminar();
                    
                }

                case 0 -> System.out.println("\n👋 Cerrando sistema...");

                default -> System.out.println("\n❌ Opción inválida");
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
        pausa();
    }

    private void listar() {

        String linea = "+----+----------+-------------------+--------+----------------+";

        System.out.println("\n📋 LISTA DE ARTICULOS");
        System.out.println(linea);

        System.out.printf("| %-2s | %-8s | %-17s | %-9s | %-14s |%n",
                "ID", "Código", "Descripción", "Precio", "Categoría");

        System.out.println(linea);

        for (Articulo p : service.listar()) {
            System.out.printf("| %-2d | %-8s | %-17s | %-9.2f | %-14s |%n",
                    p.id,
                    truncar(p.codigo, 10),
                    truncar(p.descripcion, 22),
                    p.precio,
                    truncar(p.categoria, 16));
        }

        System.out.println(linea);
        pausa();
    }

    private void buscar() {

        System.out.print("Ingrese código: ");
        String codigo = sc.nextLine();

        Articulo p = service.buscarPorCodigo(codigo);

        if (p != null) {

            String linea = "+----+----------+---------------------+----------------+------------------+";

            System.out.println("\n🔍 ARTÍCULO ENCONTRADO");

            imprimirCabecera();

            imprimirArticulo(p);

            System.out.println(linea);
            

        } else {
            System.out.println("❌ Artículo no encontrado");
        }

        pausa();
    }

    private void modificar() {
        String linea = "+----+----------+-------------------+--------+----------------+";
        System.out.print("Ingrese código del artículo a modificar: ");
        String codigo = sc.nextLine();

        Articulo p = service.buscarPorCodigo(codigo);

        if (p == null) {

            System.out.println("❌ Artículo no encontrado");
            return;
        }

        System.out.println("\n✏️ ARTÍCULO ACTUAL");

        imprimirCabecera();
        imprimirArticulo(p);

        System.out.println(linea);

        System.out.println("\nDeje vacío para mantener el valor actual");

        System.out.print("Nuevo código (" + p.codigo + "): ");
        String nuevoCodigo = sc.nextLine();

        if (!nuevoCodigo.isEmpty()) {
            p.codigo = nuevoCodigo;
        }

        System.out.print("Nueva descripción (" + p.descripcion + "): ");
        String nuevaDesc = sc.nextLine();

        if (!nuevaDesc.isEmpty()) {
            p.descripcion = nuevaDesc;
        }

        System.out.print("Nuevo precio (" + p.precio + "): ");
        String nuevoPrecio = sc.nextLine();

        if (!nuevoPrecio.isEmpty()) {
            p.precio = Double.parseDouble(nuevoPrecio);
        }

        System.out.print("Nueva categoría (" + p.categoria + "): ");
        String nuevaCat = sc.nextLine();

        if (!nuevaCat.isEmpty()) {
            p.categoria = nuevaCat;
        }

        System.out.println("\n✅ Artículo modificado");

        imprimirCabecera();
        imprimirArticulo(p);

        System.out.println(linea);
        pausa();
    }

    private void eliminar() {
        System.out.print("Código: ");
        String codigo = sc.nextLine();

        if (service.eliminar(codigo)) {
            System.out.println("🗑️ Eliminado");
        } else {
            System.out.println("❌ No existe");
        }
        pausa();
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

    private void imprimirCabecera() {

        String linea = "+----+----------+---------------------+----------------+------------------+";

        System.out.println(linea);

        System.out.printf("| %-2s | %-8s | %-19s | %-12s | %-16s |%n",
                "ID", "Código", "Descripción", "Precio", "Categoría");

        System.out.println(linea);
    }

    private void imprimirArticulo(Articulo p) {

        System.out.printf("| %-2d | %-8s | %-19s | %12.2f | %-16s |%n",
                p.id,
                truncar(p.codigo, 8),
                truncar(p.descripcion, 19),
                p.precio,
                truncar(p.categoria, 16));

    }
}
