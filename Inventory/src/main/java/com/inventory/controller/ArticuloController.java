package com.inventory.controller;

import com.inventory.model.articulo.Articulo;
import com.inventory.model.articulo.Categoria;

import com.inventory.service.ArticuloService;
import com.inventory.service.CategoriaService;

import java.util.Scanner;

public class ArticuloController {

        private ArticuloService service = new ArticuloService();

        private CategoriaService categoriaService = new CategoriaService();

        private Scanner sc = new Scanner(System.in);

        private static final String LINEA = "+----+--------+-----------------------+----------------+------------------+";

        private static final String FORMATO = "| %-2s | %-6s | %-21s | %-14s | %-16s |%n";

        private static final String FORMATO_ARTICULO = "| %-2d | %-6s | %-21s | %14.2f | %-16s |%n";

        public void iniciar() {

                if (categoriaService.listar().isEmpty()) {

                        precargarCategorias();
                }

                int opcion;

                do {

                        System.out.println("\n📦 INVENTARIO");
                        System.out.println("1. Agregar");
                        System.out.println("2. Listar");
                        System.out.println("3. Buscar");
                        System.out.println("4. Modificar");
                        System.out.println("5. Eliminar");
                        System.out.println("6. Listar categorias");
                        System.out.println("0. Salir");

                        System.out.print("Opcion: ");

                        opcion = leerEntero();

                        switch (opcion) {

                                case 1 -> agregar();

                                case 2 -> listar();

                                case 3 -> buscar();

                                case 4 -> modificar();

                                case 5 -> eliminar();

                                case 6 -> listarCategorias();

                                case 0 ->
                                        System.out.println(
                                                        "\n👋 Cerrando sistema...");

                                default -> {

                                        System.out.println(
                                                        "\n❌ Opcion invalida");

                                        pausa();
                                }
                        }

                } while (opcion != 0);
        }

        private void precargarCategorias() {

                categoriaService.agregar(
                                "ELEC",
                                "Electronica",
                                "Dispositivos electronicos");

                categoriaService.agregar(
                                "ROPA",
                                "Ropa",
                                "Prendas de vestir");

                categoriaService.agregar(
                                "ALIM",
                                "Alimentos",
                                "Productos alimenticios");

                categoriaService.agregar(
                                "HOGAR",
                                "Hogar",
                                "Articulos para el hogar");

                categoriaService.agregar(
                                "DEP",
                                "Deportes",
                                "Articulos deportivos");
        }

        private void agregar() {

                System.out.println(
                                "\n➕ AGREGAR ARTICULO");

                System.out.print("Codigo: ");

                String codigo = sc.nextLine();

                System.out.print("Descripcion: ");

                String descripcion = sc.nextLine();

                System.out.print("Precio: ");

                double precio = leerDouble();

                listarCategorias();

                System.out.print(
                                "Codigo categoria: ");

                String codigoCategoria = sc.nextLine();

                Categoria categoria = categoriaService
                                .buscarPorCodigo(
                                                codigoCategoria);

                if (categoria == null) {

                        System.out.println(
                                        "❌ Categoria inexistente");

                        pausa();

                        return;
                }

                service.agregar(
                                codigo,
                                descripcion,
                                precio,
                                categoria);

                System.out.println(
                                "\n✅ Articulo agregado");

                pausa();
        }

        private void listar() {

                System.out.println(
                                "\n📋 LISTA DE ARTICULOS");

                imprimirCabecera();

                for (Articulo p : service.listar()) {

                        imprimirArticulo(p);
                }

                System.out.println(LINEA);

                pausa();
        }

        private void buscar() {

                System.out.print(
                                "Ingrese codigo: ");

                String codigo = sc.nextLine();

                Articulo p = service.buscarPorCodigo(
                                codigo);

                if (p != null) {

                        System.out.println(
                                        "\n🔍 ARTICULO ENCONTRADO");

                        imprimirCabecera();

                        imprimirArticulo(p);

                        System.out.println(LINEA);

                } else {

                        System.out.println(
                                        "❌ Articulo no encontrado");
                }

                pausa();
        }

        private void modificar() {

                System.out.print(
                                "Ingrese codigo del articulo: ");

                String codigo = sc.nextLine();

                Articulo p = service.buscarPorCodigo(
                                codigo);

                if (p == null) {

                        System.out.println(
                                        "❌ Articulo no encontrado");

                        pausa();

                        return;
                }

                imprimirCabecera();

                imprimirArticulo(p);

                System.out.println(LINEA);

                System.out.print(
                                "Nuevo codigo (" +
                                                p.getCodigo() +
                                                "): ");

                String nuevoCodigo = sc.nextLine();

                if (!nuevoCodigo.isEmpty()) {

                        p.setCodigo(nuevoCodigo);
                }

                System.out.print(
                                "Nueva descripcion (" +
                                                p.getDescripcion() +
                                                "): ");

                String nuevaDescripcion = sc.nextLine();

                if (!nuevaDescripcion.isEmpty()) {

                        p.setDescripcion(
                                        nuevaDescripcion);
                }

                System.out.print(
                                "Nuevo precio (" +
                                                p.getPrecio() +
                                                "): ");

                String nuevoPrecio = sc.nextLine();

                if (!nuevoPrecio.isEmpty()) {

                        try {

                                p.setPrecio(

                                                Double.parseDouble(
                                                                nuevoPrecio));

                        } catch (NumberFormatException e) {

                                System.out.println(
                                                "❌ Precio invalido");
                        }
                }

                listarCategorias();

                System.out.print(
                                "Nueva categoria (" +
                                                p.getCategoria()
                                                                .getCodigo()
                                                +
                                                "): ");

                String nuevaCategoria = sc.nextLine();

                if (!nuevaCategoria.isEmpty()) {

                        Categoria categoria = categoriaService
                                        .buscarPorCodigo(
                                                        nuevaCategoria);

                        if (categoria != null) {

                                p.setCategoria(
                                                categoria);

                        } else {

                                System.out.println(
                                                "❌ Categoria inexistente");
                        }
                }

                System.out.println(
                                "\n✅ Articulo modificado");

                imprimirCabecera();

                imprimirArticulo(p);

                System.out.println(LINEA);

                pausa();
        }

        private void eliminar() {

                System.out.print("Codigo: ");

                String codigo = sc.nextLine();

                if (service.eliminar(codigo)) {

                        System.out.println(
                                        "🗑️ Eliminado");

                } else {

                        System.out.println(
                                        "❌ No existe");
                }

                pausa();
        }

        private void listarCategorias() {

                String lineaCategoria = "+----+--------+----------------------+--------------------------+";

                System.out.println(
                                "\n📚 LISTA DE CATEGORIAS");

                System.out.println(
                                lineaCategoria);

                System.out.printf(
                                "| %-2s | %-6s | %-20s | %-24s |%n",
                                "ID",
                                "Codigo",
                                "Nombre",
                                "Descripcion");

                System.out.println(
                                lineaCategoria);

                for (Categoria c : categoriaService.listar()) {

                        System.out.printf(
                                        "| %-2d | %-6s | %-20s | %-24s |%n",

                                        c.getId(),

                                        truncar(
                                                        c.getCodigo(),
                                                        6),

                                        truncar(
                                                        c.getNombre(),
                                                        20),

                                        truncar(
                                                        c.getDescripcion(),
                                                        24));
                }

                System.out.println(
                                lineaCategoria);

                pausa();
        }

        private void imprimirCabecera() {

                System.out.println(LINEA);

                System.out.printf(
                                FORMATO,
                                "ID",
                                "Codigo",
                                "Descripcion",
                                "Precio",
                                "Categoria");

                System.out.println(LINEA);
        }

        private void imprimirArticulo(
                        Articulo p) {

                System.out.printf(
                                FORMATO_ARTICULO,

                                p.getId(),

                                truncar(
                                                p.getCodigo(),
                                                6),

                                truncar(
                                                p.getDescripcion(),
                                                19),

                                p.getPrecio(),

                                truncar(
                                                p.getCategoria()
                                                                .getNombre(),
                                                16));
        }

        private int leerEntero() {

                while (true) {

                        try {

                                return Integer.parseInt(
                                                sc.nextLine());

                        } catch (NumberFormatException e) {

                                System.out.print(
                                                "❌ Ingrese un numero valido: ");
                        }
                }
        }

        private double leerDouble() {

                while (true) {

                        try {

                                double valor = Double.parseDouble(
                                                sc.nextLine());

                                if (valor < 0) {

                                        System.out.print(
                                                        "❌ El precio no puede ser negativo: ");

                                        continue;
                                }

                                return valor;

                        } catch (NumberFormatException e) {

                                System.out.print(
                                                "❌ Ingrese un precio valido: ");
                        }
                }
        }

        private String truncar(
                        String texto,
                        int max) {

                if (texto.length() > max) {

                        return texto.substring(
                                        0,
                                        max - 3) + "...";
                }

                return texto;
        }

        private void pausa() {

                System.out.println(
                                "\nPresione ENTER para continuar...");

                sc.nextLine();
        }
}