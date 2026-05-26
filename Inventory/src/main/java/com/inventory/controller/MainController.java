package com.inventory.controller;

import java.util.Scanner;

import com.inventory.service.ArticuloService;
import com.inventory.service.CategoriaService;

public class MainController {

    private Scanner sc =
            new Scanner(System.in);

    private ArticuloController articuloController;

    private CategoriaController categoriaController;

    // =========================
    // CONSTRUCTOR
    // =========================

    public MainController() {

        // =====================
        // SERVICES
        // =====================

        ArticuloService articuloService =
                new ArticuloService();

        CategoriaService categoriaService =
                new CategoriaService();

        // =====================
        // CONTROLLERS
        // =====================

        articuloController =
                new ArticuloController(
                        articuloService,
                        categoriaService
                );

        categoriaController =
                new CategoriaController(
                        categoriaService,
                        articuloService
                );
    }

    // =========================
    // MENU PRINCIPAL
    // =========================

    public void iniciar() {

        int opcion;

        do {

            System.out.println(
                    "\n📦 INVENTARIO"
            );

            System.out.println(
                    "1. Articulos"
            );

            System.out.println(
                    "2. Categorias"
            );

            System.out.println(
                    "0. Salir"
            );

            System.out.print(
                    "Opcion: "
            );

            opcion =
                    leerEntero();

            switch (opcion) {

                case 1 ->

                    articuloController
                            .iniciar();

                case 2 ->

                    categoriaController
                            .iniciar();

                case 0 ->

                    System.out.println(
                            "\n👋 Saliendo..."
                    );

                default ->

                    System.out.println(
                            "❌ Opcion invalida"
                    );
            }

        } while (opcion != 0);
    }

    // =========================
    // UTILS
    // =========================

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
