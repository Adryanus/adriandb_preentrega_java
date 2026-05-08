package com.inventory.controller;

import com.inventory.service.ArticuloService;
import com.inventory.model.Articulo;
import java.util.Scanner;

public class ArticuloController {

    private ArticuloService service = new ArticuloService();
    private Scanner sc = new Scanner(System.in);

    // =========================
    // CONSTANTES DE TABLA
    // =========================

    private static final String linea = "+----+--------+---------------------+----------------+-----------------+";

    private static final String formato = "| %-2s | %-6s | %-19s | %-14s | %-16s |%n";

    private static final String formato_articulo = "| %-2d | %-6s | %-19s | %14.2f | %-16s |%n";

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

            opcion = leerEntero();

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
        double precio = leerDouble();

        System.out.print("Categoría: ");
        String cat = sc.nextLine();

        service.agregar(codigo, desc, precio, cat);
        pausa();
    }

    private void listar() {

        System.out.println("\n📋 LISTA DE ARTICULOS");

        imprimirCabecera();

        for (Articulo p : service.listar()) {
            imprimirArticulo(p);
        }

        System.out.println(linea);

        pausa();
    }

    private void buscar() {

        System.out.print("Ingrese código: ");
        String codigo = sc.nextLine();

        Articulo p = service.buscarPorCodigo(codigo);

        if (p != null) {

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

            while (true) {

                try {

                    p.precio = Double.parseDouble(nuevoPrecio);
                    break;

                } catch (NumberFormatException e) {

                    System.out.print("❌ Precio inválido. Reingrese: ");
                    nuevoPrecio = sc.nextLine();
                }
            }
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

    private int leerEntero() {

        while (true) {

            try {

                return Integer.parseInt(sc.nextLine());

            } catch (NumberFormatException e) {

                System.out.print("❌ Ingrese un número válido: ");
            }
        }
    }

    private double leerDouble() {

        while (true) {

            try {

                double valor = Double.parseDouble(sc.nextLine());

                if (valor < 0) {

                    System.out.print("❌ El precio no puede ser negativo: ");
                    continue;
                }

                return valor;

            } catch (NumberFormatException e) {

                System.out.print("❌ Ingrese un precio válido: ");
            }
        }
    }

    private void imprimirCabecera() {

        System.out.println(linea);

        System.out.printf(formato,
                "ID",
                "Código",
                "Descripción",
                "Precio",
                "Categoría");

        System.out.println(linea);
    }

    private void imprimirArticulo(Articulo p) {

        System.out.printf(formato_articulo,
                p.id,
                truncar(p.codigo, 6),
                truncar(p.descripcion, 19),
                p.precio,
                truncar(p.categoria, 16));
    }
}
