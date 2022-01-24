# AE-1 Manejo de ficheros

## Requerimiento 1 📋

Se pide hacer una aplicación para la gestión del almacen de coches en un concesionario.

El usuario dispondrá de un menú como el siguiente para interaccionar con el servidor
1. Añandir nuevo coche
2. Borrar coche por id
3. Consulta coche por id
4. Listado de coches
5. Salir de la aplicacion

Cada coche contará con un id, una matrícula, una marca, un modelo y un color, además cada vez que se termine la 
aplicación se persistiran los datos en un fichero llamado coches.dat.

## Requerimiento 2 📋

Este requerimiento consiste en añadir una opción más al menú, esta opción le permitirá al usuario exportar todos
 los datos de los coches a un archivo de texto.

 El menú quedaría asi
 
1. Añandir nuevo coche
2. Borrar coche por id
3. Consulta coche por id
4. Listado de coches
5. Exportar coches a archivo de texto
6. Salir de la aplicacion


## Requerimiento 3 📋

Tenemos que añadir restricciones para que no se puedan duplicar ni el id, ni la matrícula.

## Construido con  🛠️

* Maven herramienta de gestión y construcción de proyectos.

## Restricciones ❗
Hay algunas validaciones en la aplicación para evitar su mal funcionamiento.

    - Nunca se podrán duplicar los Id de los choches almacenados ya que se generan automáticamente teniendo en cuenta los existentes.
    - No se podrán introducir dos coches con la misma matrícula.
    - Solo se pueden seleccionar las opciones mostradas en el menú, en caso de introduccir un valor distinto te lo indicará.
    - El campo que requiera un número estará validado para que no se puedan introducir otro tipo de datos 

## Despliegue 📦
Lo único que hay que hacer es ejecutar la clase Server.java de nuestro proyecto.

## Autores ✒️
* Javier Barón Pérez - (https://github.com/jabaron56)
* Ismael De Gregorio López - (https://github.com/Lufram)
* Alberto Lozano Gómez - (https://github.com/Tachenko)

