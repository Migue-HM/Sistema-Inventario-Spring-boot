Sistema Inventario 

Tecnologías y herramientas utilizadas

IDE: IntelliJ IDEA
Lenguaje: Java 21
Framework: Spring Boot - version 4.1.0
Gestor de dependencias: Maven
DBMS: MySQL 


Requisitos previos

Java JDK 21
Maven 3.9+ 
MySQL 10.4.32

IDE utilizado - IntelliJ IDE


Pasos para correr la aplicación
Clonar el repositorio

bash   git clone https://github.com/usuario/nombre-repositorio.git
   cd nombre-repositorio

Crear la base de datos en MySQL

sql   CREATE DATABASE inventario_db;


Configurar la conexión a la base de datos
Edita el archivo src/main/resources/application.properties (o application.yml) con tus credenciales:


properties   spring.datasource.url=jdbc:mysql://localhost:3306/nombre_basedatos
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   spring.jpa.hibernate.ddl-auto=update


Abrir el proyecto en IntelliJ IDEA
Espera a que IntelliJ descargue las dependencias de Maven automáticamente.


Ejecutar la aplicación

Localiza la clase principal que contiene @SpringBootApplication, generalmente Application.java o MainApplication.java
Haz clic derecho sobre ella y selecciona Run.
También puedes usar el botón  ubicado junto al método main.

Por defecto la aplicación estará disponible en:

   http://localhost:8080




   
