package com.inventory.controller;

import com.inventory.model.articulo.Categoria;

import com.inventory.service.CategoriaService;
import com.inventory.service.ArticuloService;

import java.util.List;
import java.util.Scanner;

public class CategoriaController {

    private CategoriaService service;

    private ArticuloService articuloService;

    private Scanner sc =
            new Scanner(System.in);

    // =========================
    // CONSTRUCTOR
    // =========================

    public CategoriaController(
            CategoriaService service,
            ArticuloService articuloService
    ) {

        this.service = service;

        this.articuloService =
                articuloService;
    }

    // =========================
    // MENU
    // =========================

    public void iniciar() {

        int opcion;

        do {

            System.out.println(
                    "\n📂 CATEGORIAS"
            );

            System.out.println(
                    "1. Agregar"
            );

            System.out.println(
                    "2. Listar"
            );

            System.out.println(
                    "3. Buscar"
            );

            System.out.println(
                    "4. Modificar"
            );

            System.out.println(
                    "5. Eliminar"
            );

            System.out.println(
                    "0. Volver"
            );

            System.out.print(
                    "Opcion: "
            );

            opcion =
                    leerEntero();

            switch (opcion) {

                case 1 -> agregar();

                case 2 -> listar();

                case 3 -> buscar();

                case 4 -> modificar();

                case 5 -> eliminar();

                case 0 ->

                    System.out.println(
                            "\n↩️ Volviendo..."
                    );

                default -> {

                    System.out.println(
                            "❌ Opcion invalida"
                    );

                    pausa();
                }
            }

        } while (opcion != 0);
    }

    // =========================
    // AGREGAR
    // =========================

    private void agregar() {

        System.out.print(
                "ID: "
        );

        int id =
                leerEntero();

        System.out.print(
                "Nombre: "
        );

        String nombre =
                sc.nextLine();

        System.out.print(
                "Descripcion: "
        );

        String descripcion =
                sc.nextLine();

        Categoria categoria =
                new Categoria(
                        id,
                        nombre,
                        descripcion
                );

        service.agregar(
                categoria
        );

        System.out.println(
                "\n✅ Categoria agregada"
        );

        pausa();
    }

    // =========================
    // LISTAR
    // =========================

    private void listar() {

    System.out.println(
            "\n📋 LISTA DE CATEGORIAS"
    );

    List<Categoria> categorias =
            service.listar();

    // =====================
    // LISTA VACIA
    // =====================

    if (categorias.isEmpty()) {

        System.out.println(
                "❌ No hay categorias cargadas"
        );

        pausa();

        return;
    }

    // =====================
    // MOSTRAR LISTA
    // =====================

    for (Categoria c : categorias) {

        System.out.println(
                c.getId()
                + " | "
                + c.getNombre()
                + " | "
                + c.getDescripcion()
        );
    }

    pausa();
}

    // =========================
    // BUSCAR
    // =========================

    private void buscar() {

        System.out.print(
                "ID: "
        );

        int id =
                leerEntero();

        Categoria c =
                service.buscarPorId(
                        id
                );

        if (c != null) {

            System.out.println(
                    "\n✅ Categoria encontrada"
            );

            System.out.println(
                    c.getId()
                    + " | "
                    + c.getNombre()
                    + " | "
                    + c.getDescripcion()
            );

        } else {

            System.out.println(
                    "❌ Categoria inexistente"
            );
        }

        pausa();
    }

    // =========================
    // MODIFICAR
    // =========================

    private void modificar() {

        System.out.print(
                "ID: "
        );

        int id =
                leerEntero();

        Categoria c =
                service.buscarPorId(
                        id
                );

        if (c == null) {

            System.out.println(
                    "❌ Categoria inexistente"
            );

            pausa();

            return;
        }

        System.out.print(
                "Nuevo nombre: "
        );

        String nombre =
                sc.nextLine();

        System.out.print(
                "Nueva descripcion: "
        );

        String descripcion =
                sc.nextLine();

        // =====================
        // MODIFICACION DIRECTA
        // =====================

        c.setNombre(nombre);

        c.setDescripcion(
                descripcion
        );

        System.out.println(
                "\n✅ Categoria modificada"
        );

        pausa();
    }

    // =========================
    // ELIMINAR
    // =========================

    private void eliminar() {

        System.out.print(
                "ID: "
        );

        int id =
                leerEntero();

        // =====================
        // VALIDAR USO
        // =====================

        if (articuloService
                .existeCategoriaEnUso(
                        id
                )) {

            System.out.println(
                    "❌ No se puede eliminar."
            );

            System.out.println(
                    "La categoria tiene articulos asociados."
            );

            pausa();

            return;
        }

        if (service.eliminar(id)) {

            System.out.println(
                    "\n🗑️ Categoria eliminada"
            );

        } else {

            System.out.println(
                    "❌ Categoria inexistente"
            );
        }

        pausa();
    }

    // =========================
    // UTILS
    // =========================

    private void pausa() {

        System.out.println(
                "\nPresione ENTER..."
        );

        sc.nextLine();
    }

    private int leerEntero() {

        while (true) {

            try {

                return Integer.parseInt(
                        sc.nextLine()
                );

            } catch (Exception e) {

                System.out.print(
                        "❌ Numero invalido: "
                );
            }
        }
    }
}
