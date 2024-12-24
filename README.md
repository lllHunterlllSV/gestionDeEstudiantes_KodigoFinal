# Documentación de la API RESTful - Proyecto Spring Boot

## Introducción

Esta API RESTful fue desarrollada utilizando Java y el framework Spring Boot. El objetivo es proporcionar un sistema de gestión para estudiantes, profesores, materias y calificaciones. La API permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre las entidades involucradas.

La API está diseñada para facilitar la interacción con la base de datos de forma eficiente y sencilla, garantizando que las operaciones básicas puedan realizarse de manera rápida.

## Descripción del Diseño

### Diagrama de Arquitectura

El diseño sigue el patrón Modelo-Vista-Controlador (MVC), donde:

- **Modelo (M)**: Representa las entidades de la base de datos, como Estudiante, Profesor, Materia, y Calificación.
- **Vista (V)**: En una API RESTful, la vista es representada por las respuestas JSON.
- **Controlador (C)**: Se encargan de manejar las solicitudes HTTP y llamar a los servicios correspondientes.

El diagrama de arquitectura muestra las interacciones entre los controladores, servicios y repositorios.

![Diagrama de Arquitectura](diagram.png)

### Modelo de Datos

Las entidades principales en el modelo de datos son:

- **Estudiante**: `{id_estudiante, nombre, apellido, correo, fecha_nacimiento}`
- **Profesor**: `{id_profesor, nombre, apellido, correo}`
- **Materia**: `{id_materia, nombre, id_profesor (FK)}`
- **Calificación**: `{id_calificacion, id_estudiante (FK), id_materia (FK), nota, fecha}`

A continuación, se muestra un diagrama entidad-relación (ER) básico:

![Diagrama ER](ER.png)

## Documentación de Endpoints

A continuación se detallan los endpoints disponibles para interactuar con la API:

### Estudiantes

- **GET /api/estudiantes**: Obtiene la lista de todos los estudiantes.
- **GET /api/estudiantes/{id}**: Obtiene un estudiante por su ID.
- **POST /api/estudiantes**: Crea un nuevo estudiante.
- **PUT /api/estudiantes/{id}**: Actualiza los datos de un estudiante.
- **DELETE /api/estudiantes/{id}**: Elimina un estudiante por su ID.

### Profesores

- **GET /api/profesores**: Obtiene la lista de todos los profesores.
- **GET /api/profesores/{id}**: Obtiene un profesor por su ID.
- **POST /api/profesores**: Crea un nuevo profesor.
- **PUT /api/profesores/{id}**: Actualiza los datos de un profesor.
- **DELETE /api/profesores/{id}**: Elimina un profesor por su ID.

### Materias

- **GET /api/materias**: Obtiene la lista de todas las materias.
- **GET /api/materias/{id}**: Obtiene una materia por su ID.
- **POST /api/materias**: Crea una nueva materia.
- **PUT /api/materias/{id}**: Actualiza los datos de una materia.
- **DELETE /api/materias/{id}**: Elimina una materia por su ID.

### Calificaciones

- **GET /api/calificaciones**: Obtiene la lista de todas las calificaciones.
- **GET /api/calificaciones/{id}**: Obtiene una calificación por su ID.
- **POST /api/calificaciones**: Crea una nueva calificación.
- **PUT /api/calificaciones/{id}**: Actualiza los datos de una calificación.
- **DELETE /api/calificaciones/{id}**: Elimina una calificación por su ID.

## Instrucciones de Configuración y Ejecución

### Requisitos Previos

Para ejecutar la API en un entorno de desarrollo, es necesario tener instalado lo siguiente:

- JDK 11 o superior.
- Maven.
- Base de datos (MySQL, PostgreSQL o H2).

### Pasos para compilar y ejecutar el proyecto

1. Clonar el repositorio en tu máquina local.
2. Ejecutar el siguiente comando para compilar el proyecto:

    ```bash
    mvn clean install
    ```

3. Para ejecutar la aplicación, usa el siguiente comando:

    ```bash
    mvn spring-boot:run
    ```

## Configuración de la Base de Datos

En el archivo `application.properties`, se debe configurar la base de datos. Si deseas usar otro nombre de base de datos, solo cambia la URL de la conexión. Por ejemplo, para cambiar el nombre de la base de datos a `nuevobd`, debes modificar la siguiente línea:

```properties
# DATASOURCE (MYSQL 8.0)
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/tuDB?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
spring.datasource.username=root
spring.datasource.password=

# JPA
spring.jpa.generate-ddl=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.show-sql=true

# Table names physically
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
spring.datasource.url: Cambia "tuDB" al nombre de tu base de datos. Asegúrate de que el servidor MySQL esté en funcionamiento.
spring.datasource.username: Define el nombre de usuario para la conexión a la base de datos.
spring.datasource.password: Define la contraseña para la conexión a la base de datos.
Acceso a la Documentación Swagger
Una vez que la aplicación esté ejecutándose, puedes acceder a la documentación de Swagger a través de la siguiente URL en tu navegador:

http://localhost:8080/doc/swagger-ui/index.html

Esto te permitirá explorar la API y probar los endpoints directamente desde la interfaz de usuario de Swagger.

Configuración del archivo application.properties
En el archivo application.properties, se debe incluir la siguiente configuración para habilitar Swagger y configurar las rutas de la API:

properties
Copiar código
springdoc.api-docs.enabled=true
springdoc.swagger-ui.enabled=true

springdoc.swagger-ui.path=/doc/swagger-ui/index.html

springdoc.paths-to-match=/api/estudiantes/**, /api/materias/**, /api/profesores/**, /api/calificaciones/**
springdoc.api-docs.enabled=true: Habilita la generación de la documentación de la API.
springdoc.swagger-ui.enabled=true: Habilita la interfaz de usuario de Swagger para explorar la API.
springdoc.swagger-ui.path=/doc/swagger-ui/index.html: Establece la ruta donde se puede acceder a la interfaz de Swagger.
springdoc.paths-to-match: Define las rutas de la API que serán documentadas por Swagger. En este caso, se incluyen los endpoints para estudiantes, materias, profesores y calificaciones.
Usuarios por Defecto
En el sistema se incluyen los siguientes usuarios por defecto:

Administrador:

Usuario: admin
Contraseña: admin123
Profesor:

Usuario: profesor
Contraseña: profesor123
Estudiante:

Usuario: estudiante
Contraseña: estudiante123
r
Copiar código

Este archivo README está diseñado para proporcionar a los usuarios toda la información esencial pa
