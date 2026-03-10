# 🎭 Foro Cultural Comunitario

Proyecto desarrollado en **Spring Boot** para dinamizar la cultura local mediante un foro seguro y organizado.  
Incluye autenticación **JWT**, endpoints REST documentados y ejemplos reproducibles para la comunidad.

---

## 🚀 Características principales
- Registro y login de usuarios con contraseñas encriptadas.
- Autenticación y autorización mediante **JWT**.
- Gestión de **Categorias**, **Temas** y **Publicaciones** con relaciones consistentes.
- Endpoints REST organizados y documentados.
- Scripts SQL para poblar la base con datos iniciales.
- Se realiza pruebas en **Insomnia** para reproducibilidad, tambien lo puedes realizar con postman.

---

## 📋 Requerimientos del sistema
Para ejecutar este proyecto necesitas:

- **Java 17** o superior  
- **Maven 3.8+**  
- **Spring Boot 3.x**  
- **MySQL 8.x** (o PostgreSQL, ajustando configuración)  
- **Insomnia/Postman** para pruebas de API  
- **Git** para clonar el repositorio  

---

## 📂 Estructura del proyecto
src/main/java/com/foro 
├── controller 
├── service4
├── dto
│    ├── request
│    └── response
├── entity 
└── security


---

## 🔑 Endpoints principales
### Autenticación
- `POST /auth/register` → Registro de usuario  
- `POST /auth/login` → Login y generación de token JWT

### Categorias
- `GET /Categoria`  → Listar todos las categorias  
- `POST /Categoria` → Crear una nueva categoria
- `PUT /Categoria`  → Actualizar categoria
- `DELETE /Categoria`  → Borrar categoria

### Temas
- `GET /Temas` → Listar todos los temas  
- `POST /Temas` → Crear un nuevo tema
- `PUT /Temas`  → Actualizar tema
- `DELETE /Temas`  → Borrar tema 

### Publicaciones
- `GET /publicaciones` → Listar publicaciones  
- `POST /publicaciones` → Crear publicación asociada a un tema
- `PUT /publicaciones`  → Actualizar publicacion
- `DELETE /publicaciones`  → Borrar publicacion

---

## 🛠️ Instalación y ejecución
1. Clonar el repositorio:
   ```bash
   git clone https://github.com/tuusuario/foro-cultural.git


## Ejemplo de respuesta JSON

   {
  "id": 1,
  "titulo": "Festival Gastronómico",
  "contenido": "Evento de comida típica en la plaza central",
  "autor": "usuario_demo",
  "fecha": "2026-03-10",
  "tema": "Gastronomía"
}

   
