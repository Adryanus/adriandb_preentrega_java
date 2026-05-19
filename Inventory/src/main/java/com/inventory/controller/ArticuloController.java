package com.inventory.controller;

import com.inventory.model.articulo.*;

import com.inventory.service.ArticuloService;
import com.inventory.service.CategoriaService;

import java.util.Scanner;

public class ArticuloController {

    // =========================
    // SERVICES
    // =========================

    private ArticuloService service;

    private CategoriaService categoriaService;

    private CategoriaController categoriaController;

    // =========================
    // SCANNER
    // =========================

    private Scanner sc =
            new Scanner(System.in);

    // =========================
    // ID AUTOINCREMENTAL
    // =========================

    private int nextId = 1;

    // =========================
    // TABLA
    // =========================

    private static final String LINEA =
    "+----+--------+----------------------+--------------+--------------+--------------+-----------+-------------+--------+--------+------------+";

    private static final String FORMATO =
    "| %-2s | %-6s | %-20s | %-12s | %-12s | %-12s | %-9s | %-11s | %-6s | %-6s | %-10s |%n";

    private static final String FORMATO_ARTICULO =
    "| %-2d | %-6s | %-20s | %12.2f | %12.2f | %-12s | %-9s | %-11s | %-6s | %-6s | %-10s |%n";

    // =========================
    // CONSTRUCTOR
    // =========================

    public ArticuloController() {

        service =
                new ArticuloService();

        categoriaService =
                new CategoriaService();

        categoriaController =
                new CategoriaController(
                        categoriaService,
                        service
                );

        cargarCategorias();
    }

    // =========================
    // MENU
    // =========================

    public void iniciar() {

        int opcion;

        do {

            System.out.println(
                    "\n📦 INVENTARIO"
            );

            System.out.println(
                    "1. Agregar Articulo"
            );

            System.out.println(
                    "2. Listar Articulos"
            );

            System.out.println(
                    "3. Buscar Articulo"
            );

            System.out.println(
                    "4. Eliminar Articulo"
            );

            System.out.println(
                    "5. Listar Categorias"
            );

            System.out.println(
                    "6. Gestionar Categorias"
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

                case 1 -> agregar();

                case 2 -> listar();

                case 3 -> buscar();

                case 4 -> eliminar();

                case 5 -> {

                    listarCategorias();

                    pausa();
                }

                case 6 ->

                    categoriaController.iniciar();

                case 0 ->

                    System.out.println(
                            "\n👋 Saliendo..."
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

        System.out.println(
                "\nTIPO DE ARTICULO"
        );

        System.out.println(
                "1. Electronico"
        );

        System.out.println(
                "2. Comestible"
        );

        System.out.println(
                "3. Ropa"
        );

        System.out.print(
                "Opcion: "
        );

        int tipo =
                leerEntero();

        System.out.print(
                "Codigo: "
        );

        String codigo =
                sc.nextLine();

        System.out.print(
                "Descripcion: "
        );

        String descripcion =
                sc.nextLine();

        System.out.print(
                "Precio base: "
        );

        double precio =
                leerDouble();

        listarCategorias();

        System.out.print(
                "Codigo categoria: "
        );

        String codCat =
                sc.nextLine();

        Categoria categoria =
                categoriaService
                        .buscarPorCodigo(codCat);

        if (categoria == null) {

            System.out.println(
                    "❌ Categoria inexistente"
            );

            pausa();

            return;
        }

        Articulo articulo = null;

        switch (tipo) {

            // =====================
            // ELECTRONICO
            // =====================

            case 1 -> {

                System.out.println(
                        "\nGARANTIA"
                );

                System.out.println(
                        "6  = 6 meses"
                );

                System.out.println(
                        "12 = 1 año"
                );

                System.out.println(
                        "36 = 3 años"
                );

                System.out.print(
                        "Garantia: "
                );

                int garantia =
                        leerEntero();

                articulo =
                        new ArticuloElectronico(
                                generarId(),
                                codigo,
                                descripcion,
                                precio,
                                categoria,
                                garantia
                        );
            }

            // =====================
            // COMESTIBLE
            // =====================

            case 2 -> {

                System.out.println(
                        "\nVENCIMIENTO"
                );

                System.out.println(
                        "6M = 6 meses"
                );

                System.out.println(
                        "1M = 1 mes"
                );

                System.out.println(
                        "7D = 7 dias"
                );

                System.out.print(
                        "Opcion: "
                );

                String vencimiento =
                        sc.nextLine()
                                .toUpperCase();

                articulo =
                        new ArticuloComestible(
                                generarId(),
                                codigo,
                                descripcion,
                                precio,
                                categoria,
                                vencimiento
                        );
            }

            // =====================
            // ROPA
            // =====================

            case 3 -> {

                System.out.print(
                        "Talle: "
                );

                String talle =
                        sc.nextLine();

                System.out.print(
                        "Color: "
                );

                String color =
                        sc.nextLine();

                System.out.println(
                        "\nTEMPORADA"
                );

                System.out.println(
                        "ALTA"
                );

                System.out.println(
                        "BAJA"
                );

                System.out.print(
                        "Opcion: "
                );

                String temporada =
                        sc.nextLine()
                                .toUpperCase();

                articulo =
                        new ArticuloRopa(
                                generarId(),
                                codigo,
                                descripcion,
                                precio,
                                categoria,
                                talle,
                                color,
                                temporada
                        );
            }

            default -> {

                System.out.println(
                        "❌ Tipo invalido"
                );

                pausa();

                return;
            }
        }

        service.agregar(articulo);

        System.out.println(
                "\n✅ Articulo agregado"
        );

        pausa();
    }

    // =========================
    // LISTAR
    // =========================

    private void listar() {

        System.out.println(
                "\n📋 LISTA DE ARTICULOS"
        );

        imprimirCabecera();

        for (Articulo a : service.listar()) {

            imprimirArticulo(a);
        }

        System.out.println(LINEA);

        pausa();
    }

    // =========================
    // BUSCAR
    // =========================

    private void buscar() {

        System.out.print(
                "Codigo: "
        );

        String codigo =
                sc.nextLine();

        Articulo a =
                service.buscarPorCodigo(codigo);

        if (a != null) {

            imprimirCabecera();

            imprimirArticulo(a);

            System.out.println(
                    LINEA
            );

        } else {

            System.out.println(
                    "❌ No encontrado"
            );
        }

        pausa();
    }

    // =========================
    // ELIMINAR
    // =========================

    private void eliminar() {

        System.out.print(
                "Codigo: "
        );

        String codigo =
                sc.nextLine();

        if (service.eliminar(codigo)) {

            System.out.println(
                    "🗑️ Eliminado"
            );

        } else {

            System.out.println(
                    "❌ No existe"
            );
        }

        pausa();
    }

    // =========================
    // LISTAR CATEGORIAS
    // =========================

    private void listarCategorias() {

        System.out.println(
                "\n📂 CATEGORIAS"
        );

        for (Categoria c :
                categoriaService.listar()) {

            System.out.println(
                    c.getCodigo()
                    + " - "
                    + c.getNombre()
            );
        }
    }

    // =========================
    // CARGAR CATEGORIAS
    // =========================

    private void cargarCategorias() {

        categoriaService.agregar(
                "ELEC",
                "Electronica",
                "Productos electronicos"
        );

        categoriaService.agregar(
                "ALIM",
                "Alimentos",
                "Productos alimenticios"
        );

        categoriaService.agregar(
                "ROPA",
                "Ropa",
                "Indumentaria"
        );
    }

    // =========================
    // TABLA
    // =========================

    private void imprimirCabecera() {

        System.out.println(LINEA);

        System.out.printf(
                FORMATO,

                "ID",
                "Codigo",
                "Descripcion",
                "Precio",
                "PrecioFinal",
                "Categoria",
                "Garantia",
                "Vencimiento",
                "Talle",
                "Color",
                "Temporada"
        );

        System.out.println(LINEA);
    }

    private void imprimirArticulo(
            Articulo a
    ) {

        String garantia = "";

        String vencimiento = "";

        String talle = "";

        String color = "";

        String temporada = "";

        // =====================
        // ELECTRONICO
        // =====================

        if (a instanceof ArticuloElectronico e) {

            garantia =
                    e.getGarantiaMeses()
                    + " meses";
        }

        // =====================
        // COMESTIBLE
        // =====================

        if (a instanceof ArticuloComestible c) {

            vencimiento =
                    c.getVencimiento();
        }

        // =====================
        // ROPA
        // =====================

        if (a instanceof ArticuloRopa r) {

            talle =
                    r.getTalle();

            color =
                    r.getColor();

            temporada =
                    r.getTemporada();
        }

        System.out.printf(
                FORMATO_ARTICULO,

                a.getId(),

                truncar(
                        a.getCodigo(),
                        6
                ),

                truncar(
                        a.getDescripcion(),
                        20
                ),

                a.getPrecio(),

                a.calcularPrecioFinal(),

                truncar(
                        a.getCategoria()
                                .getNombre(),
                        12
                ),

                truncar(
                        garantia,
                        9
                ),

                truncar(
                        vencimiento,
                        11
                ),

                truncar(
                        talle,
                        6
                ),

                truncar(
                        color,
                        6
                ),

                truncar(
                        temporada,
                        10
                )
        );
    }

    // =========================
    // UTILS
    // =========================

    private int generarId() {

        return nextId++;
    }

    private String truncar(
            String texto,
            int max
    ) {

        if (texto.length() > max) {

            return texto.substring(
                    0,
                    max - 3
            ) + "...";
        }

        return texto;
    }

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

    private double leerDouble() {

        while (true) {

            try {

                return Double.parseDouble(
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