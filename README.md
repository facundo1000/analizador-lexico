# Analizador Lexico 

## Utilización

1. Descomprimir el archivo `analizador-lexico.zip`.
2. Ingresar al directorio `analizador-lexico`.
3. Ejecutar el comando `mvn clean package` o `mvn clean install` para compilar el proyecto (se debe tener maven instalado).
4. Luego de compilar el proyecto ejecutar el comando `java -jar ./target/analizador-lexico.jar test.txt`, desde el directorio raiz.

**El programa finaliza cuando el programa lee exactamente la palabra `fin`.**