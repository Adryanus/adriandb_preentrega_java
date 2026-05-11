@echo off

cd /d "%~dp0"

cd src\main\java

echo ============================
echo COMPILANDO...
echo ============================

javac ^
com\inventory\model\articulo\Categoria.java ^
com\inventory\model\articulo\Articulo.java ^
com\inventory\service\CategoriaService.java ^
com\inventory\service\ArticuloService.java ^
com\inventory\controller\ArticuloController.java ^
com\inventory\InventoryApp.java

if %errorlevel% neq 0 (
    echo.
    echo Error de compilacion
    pause
    exit /b
)

echo.
echo Compilacion exitosa
echo.

echo ============================
echo EJECUTANDO...
echo ============================

java com.inventory.InventoryApp

pause