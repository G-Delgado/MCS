# Tarea Integradora #2. Music, Collect & Share
Para aplicar los conceptos de herencia, etc :3

## Enunciadooo 🚀

En la unidad 3 de nuestro curso hemos trabajado en el análisis de un problema construyendo un modelo con los elementos que intervienen en el problema y especificando los servicios que el programa debe ofrecer, bajo el paradigma de programación orientado a objetos.
Aprendimos a construir las clases que implementan el modelo de la solución del problema, identificando de manera informal los métodos de  una clase y clasificarlos en métodos constructores, de consulta y de modificación. Utilizamos una arquitectura para un programa que permita repartir de manera adecuada las responsabilidades entre la interfaz de usuario y el modelo de la solución, y cómo relacionar dichos componentes. Finalmente, hemos aprendido a relacionar todos los conceptos vistos en las tres primeras unidades del curso.

En la unidad 4 de nuestro curso hemos trabajado sobre la aplicación de mecanismos de reutilización como son la herencia y el polimorfismo. Estas técnicas enriquecen el comportamiento de las clases modeladas como parte de una  solución en el diagrama de clases.

Esta tarea integradora presenta una actividad en la cual se requiere aplicar todos los conocimientos adquiridos en la unidad 3 y en la unidad 4 hasta la herencia.  Por tanto, esta tarea es un instrumento para verificar el cumplimiento de los objetivos que han sido planteados para las unidades 3 y 4 descritas en el programa del curso.  

Para llevar a cabo este ejercicio es necesario realizar las actividades listadas a continuación:
Actividades
Lleve a cabo las siguientes actividades de cada una de las etapas de desarrollo de software:

Análisis del problema (Lista de requerimientos funcionales en el formato visto en clase).
Diseño de la solución. Elabore un diagrama de clases que modele la solución del problema de acuerdo con las buenas prácticas y los patrones de diseño revisados hasta el momento en el curso. Su diagrama debe incluir el paquete modelo y el de interfaz de usuario. 
Realice un diagrama de objetos que satisfaga su diagrama de clases. 
Implementación en Java. Incluya en la implementación, los comentarios descriptivos sobre los atributos y métodos de cada clase. Recuerde que todos los artefactos generados de fase de diseño e implementación deben ser en inglés. 
Documentación en JavaDoc (Debe entregarse el JavaDoc generado y ubicarlo en la carpeta docs). 
Usar GitHub como repositorio de código fuente y documentación utilizando la estructura de carpetas aprendida en clase. Recuerde que se debe evidenciar su avance a través de los días en el desarrollo de su tarea.
Subir a moodle los puntos anteriores el plazo máximo es 31 de Octubre de 2020

Recuerde que puede encontrar la Rúbrica laboratorio en el siguiente enlace.

Nota:
 Usted debe entregar un archivo en formato pdf con toda la documentación (análisis) y la URL de su repositorio GitHub donde se deben encontrar los archivos de codificación en sus respectivos paquetes.
Tenga en cuenta que su repositorio GitHub debe presentar una estructura base como por ejemplo: 
       MCS/
      src/           
      bin/          
      docs/    
Dentro de los directorios src/ y bin/ estarán presentes estos directorios(representando cada uno de sus paquetes):
      	ui/
	    model/
El directorio src (source code) contiene sus clases .java dentro del directorio ui/ y model/. Por otro lado el directorio bin (binary files) contiene los archivos .class en el directorio ui/ y model/.
Su código debería compilar de acuerdo con lo explicado en la diapositiva 15 de esta presentación: http://tinyurl.com/y3bd9bg2



A continuación, encontrará un enunciado que narra de forma detallada la situación problemática que se espera usted solucione.
Enunciado
Cansados de las continuas interrupciones de la publicidad y comerciales mientras escuchan música usando las plataformas de streaming, usted y unos compañeros de la universidad decidieron aplicar sus conocimientos en programación para diseñar e implementar el prototipo de una aplicación que permita organizar y compartir música entre sus usuarios.

Inicialmente, el equipo de desarrollo decidió bautizar la aplicación: el Music Collect & Share o MCS para referirse al prototipo de la app de forma corta. En un momento de creatividad crearon un logo y lo convirtieron en ascii para el prototipo (mientras aprenden interfaz gráfica de usuario)
 MCS


El Music Collect & Share tiene varios usuarios registrados, un pool de canciones compartidas y una colección de playlists.  Cada usuario tiene un apodo o nombre de usuario que es una sola palabra, sin espacios.  Por ejemplo, lunalunera, djchristian y seyerman son nombres de usuarios de la aplicación. Todos los usuarios tienen además una contraseña, una edad y una categoría.  La categoría de un usuario  puede ser, newbie, little contributor, mild contributor y star contributor, la categoría de un usuario  se asigna dependiendo de la cantidad de canciones que han compartido en el pool de canciones así:
Un usuario está en la categoría newbie cuando está recién creado y hasta que comparte tres canciones. 
A partir de tres canciones compartidas, un usuario se convierte en  little contributor hasta que comparta diez canciones.
Cuando un usuario comparte diez canciones se convierte en usuario mild contributor  y conserva esta categoría hasta que comparte 30 canciones.
A partir de las 30 canciones compartidas, el usuario está en la categoría star contributor
Cada canción en el pool de canciones del MCS tiene un título, un nombre de artista o banda, una fecha de lanzamiento, una duración y un género. El género se refiere al género musical, aunque existen diversos  géneros musicales, usted y sus compañeros decidieron limitar los géneros de las canciones del MCS a rock, hip hop, música clásica, reggae, salsa y metal.  
De forma general,  cada playlist en el MCS tiene un nombre, una duración y los géneros de las canciones que hacen parte del playlist. La duración de una playlist se obtiene sumando la duración de cada una de las canciones en el play list, y los géneros es el conjunto de géneros de las canciones del playlist.  Por tanto, cuando se crea un playlist en el MCS este playlist tiene un nombre pero está vacío por tanto su duración es cero y su conjunto de géneros está vacío.  La duración y el conjunto de géneros cambia a medida que se vayan agregando canciones.  A continuación se explica con un ejemplo:

Se crea un playlist llamado “Música para programar”, con  duración igual a cero y género vacío.
Se incluye en la playlist la canción “November rain” de Guns N’ Roses con duración 4:43 y género Hard Rock.
Por tanto, se actualiza la duración de la playlist a 4:43 y el género a ROCK
Se incluye la canción “Nothing else matters” de Metallica con duración 6:28 y género Hard Rock. Entonces se actualiza la duración de la playlist a 11:11 y género sigue siendo ROCK
Se incluye la canción “Jump around” de House of Pain con duración 3:37 y género hip hop.  Entonces la duración de la playlist se actualiza a  14:48 y su género se actualiza a ROCK, HIP HOP

Los playlist tienen tres variantes: playlists privados, restringidos y públicos. A continuación se explican las particularidades de los playlists:
Un playlist privado tiene un único usuario que puede añadir y listar las canciones que contiene.
Un playlist restringido tiene un máximo de cinco usuarios que pueden añadir y listar canciones.
Un playlist público no tiene restricciones de usuarios, es abierto para todos, pero tiene una calificación promedio, porque cualquier usuario puede ingresar una calificación entre 1  y 5 indicando qué tanto le gustó el playlist (1 la nota más baja, 5 la nota más alta)
Funcionalidades de la aplicación
La aplicación que usted  implementará es todavía un prototipo, por tanto hay un máximo número de usuarios (10), un máximo número de playlists (20) y un máximo de canciones en el pool de canciones compartidas (30).  Además, algunas funcionalidades como reproducir canciones, y la autenticación de usuarios están fuera del alcance de esta tarea. 
La aplicación debe permitir al usuario hacer lo siguiente:
Crear un usuario con sus datos: nombre de usuario, contraseña, edad y categoría.
Listar los usuarios de la aplicación mostrando solo su nombre de usuario, edad y categoría de acuerdo al siguiente formato:
                        *************  User **************
                        **  UserName: lunalunera
                        **  Age: 15
                        **  Category: NEWBIE
                        ***********************************
Permitirle a un usuario crear una canción con todos sus datos e incluirla en el pool de canciones compartidas.
Actualizar la categoría de un usuario a medida que este incluya canciones en el pool de canciones.
Listar las canciones del pool de canciones compartidas en el siguiente formato
                        **************  Song **************
                        **  Title: Como te hago entender
                        **  Artist: Roberto Roena 
                        **  Duration: 5:45
                        **  Genre: SALSA 
                        ***********************************

Crear playlist de los tres variantes (público, restringido y privado)
De forma general, es decir con cada playlist sin importar su tipo, la aplicación permite crear un playlist con un nombre, con una duración en cero y un género desconocido. 
De forma general, es decir con cada playlist sin importar su tipo, la aplicación permite añadir canciones del pool de canciones compartidas.  Nota: La verificación de los usuarios se hará en una segunda versión del prototipo. 
La duración y el género de un playlist, sin importar su tipo,  se actualizan cada que se añade una canción de acuerdo al ejemplo explicado en la sección anterior.
De forma particular, con un playlist privado, la aplicación permite agregar el único usuario que tiene acceso a las canciones del playlist.
De forma particular, con un playlist restringido, la aplicación permite agregar máximo cinco usuarios que tienen acceso a las canciones del playlist.
De forma particular, con un playlist público, la aplicación permite a un usuario asignar una calificación y mostrar la calificación promedio.
Listar los playlists creados en el MCS así:
De forma general, es decir con cada playlist sin importar su tipo, la aplicación debe mostrar la información así:
            **************  Playlist **************
            **  Title: Musica para programar
            **  Duration: 11:48
            **  Genre: ROCK, HIPHOP
De forma particular, para un playlist privado, la aplicación además muestra el nombre del único usuario que puede manipular la playlist
De forma particular, con un playlist restringido, la aplicación además muestra los nombres de los usuarios que pueden manipular la lista
De forma particular, con un playlist público, la aplicación muestra la nota promedio de la playlist.




## Construido con 🛠️

* Java (vanilla)?
* Notepad++ (:C)
* Mis manos B)

## Autores ✒️

* **Gabriel Delgado**
