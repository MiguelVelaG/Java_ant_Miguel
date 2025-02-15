# 🌟 **LoginApp** 🌟

Bienvenido a **LoginApp**, una aplicación de escritorio desarrollada en **Java** para gestionar el inicio de sesión y registro de usuarios. La app tiene un diseño moderno con un fondo gradual y efectos interactivos, haciendo que la experiencia del usuario sea atractiva y funcional.

---

## ✨ **Características** ✨

- **Interfaz atractiva** con un fondo de gradiente de color.
- **Formulario de inicio de sesión** para que los usuarios ingresen su nombre de usuario y contraseña.
- **Formulario de registro** para nuevos usuarios con validación.
- **Efectos de hover** en los botones para una experiencia interactiva.
- **Conexión con MySQL** para verificar las credenciales de los usuarios.
  
---

## ⚡ **Requisitos** ⚡

Para ejecutar la aplicación en tu máquina local, necesitarás:

- **JDK 8 o superior**: Necesario para ejecutar la aplicación en Java.
- **IDE**: Recomendamos **IntelliJ IDEA**, **Eclipse** o cualquier otro IDE Java de tu preferencia.
- **Base de datos MySQL**: La aplicación utiliza MySQL para gestionar las credenciales de usuario.

---

## 🚀 **Instalación** 🚀

1. **Clona este repositorio** en tu máquina local:

   ```bash
   git clone https://github.com/MiguelVelaG/Java_ant_Miguel.git
Navega al directorio del proyecto:
cd LoginApp
Verifica que tienes Java instalado (JDK 8 o superior):
java -version
Abre el proyecto en tu IDE favorito.
Configura la base de datos:
Si aún no tienes configurada la base de datos, crea una base de datos llamada loginapp y la tabla usuarios con los siguientes campos:

CREATE DATABASE loginapp;

USE loginapp;

CREATE TABLE usuarios (
    usuarioid INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(200),
    correo VARCHAR(200),
    contrasena VARCHAR(50)
);
Configura la conexión a la base de datos en el código, asegurándote de que coincida con tus credenciales de MySQL.
Ejecuta el proyecto:
Desde tu IDE o terminal, puedes compilar y ejecutar el proyecto con los siguientes comandos:

javac LoginApp.java
java LoginApp
🎮 Uso 🎮

Inicio de sesión: Ingresa tu nombre de usuario y contraseña en la pantalla principal y haz clic en Entrar.
Registro de nuevo usuario: Si no tienes cuenta, haz clic en Registrarse y completa el formulario.
La aplicación verificará tus credenciales con la base de datos y te mostrará un mensaje de éxito o error.

👨‍💻 Desarrollado por 👨‍💻

Miguel Velasco.
