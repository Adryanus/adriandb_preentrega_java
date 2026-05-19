@echo off

cd /d "%~dp0"

cd src\main\java

echo ============================
echo LIMPIANDO .CLASS...
echo ============================

del /s *.class > nul 2>&1

echo.
echo ============================
echo COMPILANDO...
echo ============================

javac ^
com\inventory\interfaces\Mostrable.java ^
com\inventory\interfaces\Calculable.java ^
com\inventory\model\Producto.java ^
com\inventory\model\articulo\Categoria.java ^
com\inventory\model\articulo\Articulo.java ^
com\inventory\model\articulo\ArticuloElectronico.java ^
com\inventory\model\articulo\ArticuloComestible.java ^
com\inventory\model\articulo\ArticuloRopa.java ^
com\inventory\service\CategoriaService.java ^
com\inventory\service\ArticuloService.java ^
com\inventory\controller\CategoriaController.java ^
com\inventory\controller\ArticuloController.java ^
com\inventory\InventoryApp.java

IF ERRORLEVEL 1 (

    echo.
    echo ❌ ERROR DE COMPILACION

    pause

    exit /b
)

echo.
echo ✅ COMPILACION EXITOSA


