# AE-2 Manejo de conectores de BBDD

## Requerimiento 1 📋

_Se pide hacer un CRUD completo de la entidad coche utilizando el patrón DAO._

_El usuario dispondrá de un menú como el siguiente para interaccionar con el servidor_
```
1. Añandir nuevo coche
2. Borrar coche por id
3. Consulta coche por id
4. Modificar coche por id
5. Listado de coches
6. Salir de la aplicacion
```
_Cada coche contará con un id, una matrícula, una marca, un modelo y un color, además los datos persistirán en una base de 
datos llamada "manejodeconectores"._
_En la base de datos se creará una tabla mediante Java, en la que se guardarán los datos del coche._

## Requerimiento 2 📋

_Este requerimiento consiste en añadir un submenú para la gestión de los pasajeros._

 _El menú quedaría así_
 ```
1. Añandir nuevo coche
2. Borrar coche por id
3. Consulta coche por id
4. Modificar coche por id
5. Listado de coches
6. Gestión de pasajeros
7. Salir de la aplicación
```
_Y el submenú quedaria así_
 ```
1. Añadir nuevo pasajero
2. Borrar pasajero por id
3. Consulta pasajero por id
4. Listar todos los pasajeros
5. Añadir pasajero a coche
6. Eliminar pasajero de un coche
7. Listar todos los pasajeros de un coche
8. Volver al menú principal
 ```
 
 _Cada pasajero contará con un id, un nombre, una edad y un peso._
 _En la base de datos se creará una tabla mediante Java, en la que se guardarán los datos del pasajero y además se relacionarán las tablas COCHES y PASAJEROS._
## Construido con  🛠️

* Maven herramienta de gestión y construcción de proyectos.
* XAMPP sistema de gestión de bases de datos MySQL, el servidor web Apache y los intérpretes para lenguajes de script PHP y Perl.

## Restricciones ❗
_Hay algunas validaciones en la aplicación para evitar su mal funcionamiento._

    - Nunca se podrán duplicar los Id de los coches o de los pasajeros almacenados ya que se generan automáticamente en la bbdd.
    - No se podrán introducir dos coches con la misma matrícula.
    - Solo se pueden seleccionar las opciones mostradas en el menú, en caso de introduccir un valor distinto te lo indicará.
    - El campo que requiera un número estará validado para que no se puedan introducir otro tipo de datos mediante el método isNumeric()
    - Se han creado varios métodos adicionales que realizarán validaciones secundarias, asegurando el funcionamiento de la aplicación.
    
      
## Despliegue 📦
_Para iniciar la aplicación hay que seguir unos pasos:_

1._Lo primero es asociar la libreria "mysql-connector-java-8.0.22" a la build path de nuestro proyecto (Click dcho. en la libreria > Build path > Add to build path)._

2._El siguiente paso será cambiar el "project compliance and JRE" a la version 1.7._

3._Ahora tenemos que crear una base de datos configurada en el puerto 3306 que se llame "manejodeconectores", aqui se crearán las tablas automáticamente al ejecutar el programa._

4._Por último, ya podremos ejecutar la clase "Servidor.java" de nuestro proyecto y se iniciará  la  aplicación._

## Autores ✒️
* **Javier Barón Pérez** - (https://github.com/jabaron56)
* **Ismael De Gregorio López** - (https://github.com/Lufram)
* **Alberto Lozano Gómez** - (https://github.com/Tachenko)
