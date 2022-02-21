# AE-3 JPA

## Requerimiento 1 📋

Se pide generar un modelo de datos que gestionará una cadena de librerias.

Se ha diseñado un programa mediante JPA que tendrá las siguientes enitdades:


1. Autor, esta entidad tendrá un id, un nombre, unos apellidos y una fecha de nacimiento.
2. Editorial, esta entidad tendrá un id, un nombre y una dirección.
3. Libro, esta entidad tendrá un id,un título, un precio, una editorial y un autor.
4. Libreria, esta entidad tendra un id, un nombre del dueño, una dirección y una colección de libros.

Todas las entidades tendrán relaciones bidireccionales. además, más tarde comentaremos sus restricciones.

Este requerimiento también nos pide realizar una serie de acciones para llenar la base de datos.


1. Dar de alta 3 autores.
2. Dar de alta 2 editoriales.
3. Dar de alta 8 libros, cada libro será escrito por uno de los autores dados de alta previamente y pertenecerá a uno de los editoriales dados de alta previamente.
4. 2 librerías, cada librería tendrá 4 libros dados de alta previamente.


## Requerimiento 2 📋

Este requerimiento consiste en realizar una serie de consultas y mostrarlas por pantalla.

 Al ejecutar la aplicación se verán las consultas por consola en el siguiente orden:
 
1. Todos los libros dados de alta, con su editorial y su autor
2. Todos los autores dados de alta, con sus libros asociados
3. Todas las librerías, con solamente sus libros asociados
4. Todos los libros dados de alta, y en la librería en la que están.

## Construido con  🛠️

* Maven herramienta de gestión y construcción de proyectos.
* XAMPP sistema de gestión de bases de datos MySQL, el servidor web Apache y los intérpretes para lenguajes de script PHP y Perl.
* EclipseLink proyecto de servicios de persistencia de Eclipse de código abierto de la Fundación Eclipse.

## Restricciones ❗
Hay algunas reglas a la hora de relacionar las tablas de la base de datos de esta aplicación.

    - Un autor podrá escribir muchos libros.
    - La editorial tendrá una colección de libros publicada por la editorial
    - Un libro puede estar en diferentes librerias.
      
## Despliegue 📦

Para iniciar la aplicación hay que seguir unos pasos:

1. Lo primero es asociar la libreria "mysql-connector-java-8.0.22" a la build path de nuestro proyecto (Click dcho. en la libreria > Build path > Add to build path).

2. Ahora tenemos que crear una base de datos configurada en el puerto 3306 que se llame "jpa_relaciones", aqui se crearán las tablas automáticamente al ejecutar el programa.

3. Por último, ya podremos ejecutar la clase "app.java" de nuestro proyecto y se iniciará  la  aplicación.

Opcional: También tendremos la opción de ejecutar la clase "pruebaConexion.java", esta clase hará una prueba de conexión con la base de datos.

Hay que tener en cuenta que esta aplicación se ha construido con EclipseLink por lo que no se garantiza su compatibilidad con un IDE distinto a ECLIPSE.

## Autores ✒️
* *Javier Barón Pérez* - (https://github.com/jabaron56)
* *Ismael De Gregorio López* - (https://github.com/Lufram)
* *Alberto Lozano Gómez* - (https://github.com/Tachenko)
