@echo off

cd src\main\java

javac ^
com\inventory\model\Articulo.java ^
com\inventory\service\ArticuloService.java ^
com\inventory\controller\ArticuloController.java ^
com\inventory\InventoryApp.java

if %errorlevel% neq 0 (
    echo.
    echo ❌ Error de compilacion
    pause
    exit /b
)

echo.
echo ✅ Compilacion exitosa
echo.

java com.inventory.InventoryApp

pause