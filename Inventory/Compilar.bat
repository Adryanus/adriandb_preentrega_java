@echo off

cd /d "%~dp0"

echo ============================
echo LIMPIANDO...
echo ============================

rmdir /s /q out 2>nul

mkdir out

echo.
echo ============================
echo COMPILANDO...
echo ============================

pushd src\main\java

javac -d ..\..\..\out ^
com\inventory\interfaces\*.java ^
com\inventory\repository\*.java ^
com\inventory\service\*.java ^
com\inventory\model\*.java ^
com\inventory\model\articulo\*.java ^
com\inventory\controller\*.java ^
com\inventory\InventoryApp.java

IF ERRORLEVEL 1 (

    echo.
    echo ❌ ERROR DE COMPILACION

    popd

    pause

    exit /b
)

popd

echo.
echo ============================
echo ✅ COMPILACION EXITOSA
echo ============================




