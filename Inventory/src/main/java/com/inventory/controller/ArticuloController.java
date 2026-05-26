package com.inventory.controller;

import java.util.List;
import java.util.Scanner;

import com.inventory.model.articulo.Articulo;
import com.inventory.model.articulo.ArticuloComestible;
import com.inventory.model.articulo.ArticuloElectronico;
import com.inventory.model.articulo.ArticuloRopa;
import com.inventory.model.articulo.Categoria;

import com.inventory.service.ArticuloService;
import com.inventory.service.CategoriaService;

public class ArticuloController {

        private ArticuloService service;

        private CategoriaService categoriaService;

        private Scanner sc = new Scanner(System.in);

        // =========================
        // CONSTRUCTOR
        // =========================

        public ArticuloController(
                        ArticuloService service,
                        CategoriaService categoriaService) {

                this.service = service;

                this.categoriaService = categoriaService;
        }

        // =========================
        // MENU
        // =========================

        public void iniciar() {

                int opcion;

                do {

                        System.out.println(
                                        "\n📦 ARTICULOS");

                        System.out.println(
                                        "1. Agregar");

                        System.out.println(
                                        "2. Listar");

                        System.out.println(
                                        "3. Buscar");

                        System.out.println(
                                        "4. Modificar");

                        System.out.println(
                                        "5. Eliminar");

                        System.out.println(
                                        "0. Volver");

                        System.out.print(
                                        "Opcion: ");

                        opcion = leerEntero();

                        switch (opcion) {

                                case 1 -> agregar();

                                case 2 -> listar();

                                case 3 -> buscar();

                                case 4 -> modificar();

                                case 5 -> eliminar();

                                case 0 ->

                                        System.out.println(
                                                        "\n↩️ Volviendo...");

                                default -> {

                                        System.out.println(
                                                        "❌ Opcion invalida");

                                        pausa();
                                }
                        }

                } while (opcion != 0);
        }

        // =========================
        // AGREGAR
        // =========================

        private void agregar() {

                System.out.println(
                                "\nTIPO DE ARTICULO");

                System.out.println(
                                "1. Electronico");

                System.out.println(
                                "2. Ropa");

                System.out.println(
                                "3. Comestible");

                System.out.print(
                                "Opcion: ");

                int tipo = leerEntero();

                System.out.print(
                                "ID: ");

                int id = leerEntero();

                System.out.print(
                                "Codigo: ");

                String codigo = sc.nextLine();

                System.out.print(
                                "Descripcion: ");

                String descripcion = sc.nextLine();

                System.out.print(
                                "Precio: ");

                double precio = leerDouble();

                Categoria categoria = seleccionarCategoria();

                if (categoria == null) {
                        return;
                }

                Articulo articulo = null;

                switch (tipo) {

                        case 1 -> {

                                System.out.print(
                                                "Garantia en meses: ");

                                int garantia = leerEntero();

                                articulo = new ArticuloElectronico(
                                                id,
                                                codigo,
                                                descripcion,
                                                precio,
                                                categoria,
                                                garantia);
                        }

                        case 2 -> {

                                System.out.print(
                                                "Talle: ");

                                String talle = sc.nextLine();

                                System.out.print(
                                                "Color: ");

                                String color = sc.nextLine();

                                System.out.print(
                                                "Temporada (ALTA/BAJA): ");

                                String temporada = sc.nextLine();

                                articulo = new ArticuloRopa(
                                                id,
                                                codigo,
                                                descripcion,
                                                precio,
                                                categoria,
                                                talle,
                                                color,
                                                temporada);
                        }

                        case 3 -> {

                                System.out.print(
                                                "Vencimiento (6M/1M/7D): ");

                                String vencimiento = sc.nextLine();

                                articulo = new ArticuloComestible(
                                                id,
                                                codigo,
                                                descripcion,
                                                precio,
                                                categoria,
                                                vencimiento);
                        }

                        default -> {

                                System.out.println(
                                                "❌ Tipo invalido");

                                pausa();

                                return;
                        }
                }

                service.agregar(articulo);

                System.out.println("\n✅ Articulo agregado");

                pausa();

        }

        // =========================
        // LISTAR
        // =========================

        private void listar() {

                List<Articulo> articulos = service.listar();

                System.out.println(
                                "\n📋 LISTA DE ARTICULOS");

                // =====================
                // LISTA VACIA
                // =====================

                if (articulos.isEmpty()) {

                        System.out.println(
                                        "❌ No hay articulos cargados");

                        pausa();

                        return;
                }

                // =====================
                // MOSTRAR LISTA
                // =====================

                for (Articulo a : articulos) {

                        System.out.println(
                                        a.getId()
                                                        + " | "
                                                        + a.getCodigo()
                                                        + " | "
                                                        + a.getDescripcion()
                                                        + " | $"
                                                        + a.calcularPrecioFinal()
                                                        + " | "
                                                        + a.getCategoria()
                                                        + " | "
                                                        + a.obtenerDetalle());
                }

                pausa();
        }

        // =========================
        // BUSCAR
        // =========================

        private void buscar() {

                System.out.print(
                                "ID: ");

                int id = leerEntero();

                Articulo a = service.buscarPorId(id);

                if (a != null) {

                        System.out.println(
                                        "\n✅ Articulo encontrado");

                        System.out.println(
                                        a.getId()
                                                        + " | "
                                                        + a.getCodigo()
                                                        + " | "
                                                        + a.getDescripcion()
                                                        + " | $"
                                                        + a.calcularPrecioFinal()
                                                        + " | "
                                                        + a.getCategoria()
                                                        + " | "
                                                        + a.obtenerDetalle());

                } else {

                        System.out.println(
                                        "❌ Articulo inexistente");
                }

                pausa();
        }

        // =========================
        // MODIFICAR
        // =========================

        private void modificar() {

                System.out.print(
                                "ID: ");

                int id = leerEntero();

                Articulo a = service.buscarPorId(id);

                if (a == null) {

                        System.out.println(
                                        "❌ Articulo inexistente");

                        pausa();

                        return;
                }

                // =====================
                // CODIGO
                // =====================

                System.out.print(
                                "Nuevo codigo ("
                                                + a.getCodigo()
                                                + "): ");

                String codigo = sc.nextLine();

                if (!codigo.isBlank()) {

                        a.setCodigo(codigo);
                }

                // =====================
                // DESCRIPCION
                // =====================

                System.out.print(
                                "Nueva descripcion ("
                                                + a.getDescripcion()
                                                + "): ");

                String descripcion = sc.nextLine();

                if (!descripcion.isBlank()) {

                        a.setDescripcion(
                                        descripcion);
                }

                // =====================
                // PRECIO
                // =====================

                System.out.print(
                                "Nuevo precio ("
                                                + a.getPrecio()
                                                + "): ");

                String precioTexto = sc.nextLine();

                if (!precioTexto.isBlank()) {

                        try {

                                double precio = Double.parseDouble(
                                                precioTexto);

                                a.setPrecio(precio);

                        } catch (Exception e) {

                                System.out.println(
                                                "❌ Precio invalido");
                        }
                }

                System.out.println(
                                "\n✅ Articulo modificado");

                pausa();
        }

        // =========================
        // ELIMINAR
        // =========================

        private void eliminar() {

                System.out.print(
                                "ID: ");

                int id = leerEntero();

                if (service.eliminar(id)) {

                        System.out.println(
                                        "\n🗑️ Articulo eliminado");

                } else {

                        System.out.println(
                                        "❌ Articulo inexistente");
                }

                pausa();
        }

        // =========================
        // CATEGORIA
        // =========================

        private Categoria seleccionarCategoria() {

                List<Categoria> categorias = categoriaService.listar();

                System.out.println(
                                "\n📂 CATEGORIAS");

                // NO HAY CATEGORIAS

                if (categorias.isEmpty()) {

                        System.out.println(
                                        "❌ No hay categorias registradas. Debe Crear categorias antes de cargar articulos");

                        pausa();

                        return null;
                }

                // MOSTRAR CATEGORIAS

                for (Categoria c : categorias) {

                        System.out.println(
                                        c.getId()
                                                        + " | "
                                                        + c.getNombre());
                }

                System.out.print(
                                "ID categoria: ");

                int id = leerEntero();

                Categoria categoria = categoriaService.buscarPorId(id);

                // ID INVALIDO

                if (categoria == null) {

                        System.out.println(
                                        "❌ Categoria inexistente");

                        pausa();
                }

                return categoria;
        }

        // =========================
        // UTILS
        // =========================

        private void pausa() {

                System.out.println(
                                "\nPresione ENTER...");

                sc.nextLine();
        }

        private int leerEntero() {

                while (true) {

                        try {

                                return Integer.parseInt(
                                                sc.nextLine());

                        } catch (Exception e) {

                                System.out.print(
                                                "❌ Numero invalido: ");
                        }
                }
        }

        private double leerDouble() {

                while (true) {

                        try {

                                return Double.parseDouble(
                                                sc.nextLine());

                        } catch (Exception e) {

                                System.out.print(
                                                "❌ Numero invalido: ");
                        }
                }
        }
}