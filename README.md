# Actividad-3-Sesiones-y-Cookies

# README - Actividad Triángulo con Sesión y Cookies

## Descripción

Esta aplicación web en Java permite calcular el área y perímetro de un triángulo equilátero. Utiliza **JSP, Servlet, sesión y cookies** para mantener información del usuario y del último cálculo realizado.

## Estructura del Proyecto

```
HolaMundoWeb/
│
├─ src/main/java/modelo/Triangulo.java        # Clase modelo del triángulo
├─ src/main/java/controlador/TrianguloServlet.java  # Servlet que procesa el formulario
├─ src/main/webapp/index.jsp                  # Página principal con formulario y manejo de sesión/cookies
├─ src/main/webapp/resultado.jsp             # Página que muestra los resultados enviados desde el servlet
├─ src/main/webapp/WEB-INF/web.xml           # Configuración del servlet
└─ pom.xml                                   # Configuración del proyecto Maven
```

## Requisitos

* JDK 17 o superior
* Apache NetBeans 17 (u otra versión compatible con Maven)
* Apache Tomcat 10+ (compatible con Jakarta EE)

## Instalación y Ejecución

1. Clonar o descargar el proyecto en tu máquina.
2. Abrir NetBeans y seleccionar **File > Open Project**.
3. Navegar a la carpeta del proyecto y abrirlo.
4. Configurar Tomcat 10 en NetBeans si no está configurado.
5. Limpiar y construir el proyecto (**Clean and Build**).
6. Ejecutar el proyecto en Tomcat (**Run**).
7. Abrir el navegador y acceder a: `http://localhost:8080/HolaMundoWeb/index.jsp`

## Uso

1. Al abrir la página, se pedirá el nombre del usuario si no existe en sesión.
2. Se puede ingresar la base y altura de un triángulo equilátero.
3. Al enviar el formulario, el servlet calculará el área y perímetro y los guardará en cookies.
4. La página `index.jsp` mostrará los datos del último triángulo calculado gracias a las cookies.
5. `resultado.jsp` mostrará el resultado del cálculo del triángulo.

## Funcionalidades

* Manejo de **sesión** para guardar el nombre del usuario.
* Uso de **cookies** para recordar los datos del último triángulo calculado.
* Separación entre lógica de negocio (`Triangulo.java`), controlador (`TrianguloServlet.java`) y vista (`index.jsp`, `resultado.jsp`).
* Compatible con Tomcat 10+ y Jakarta EE.

## Autor

* Gerardo Sánchez Muñoz

## Notas

* Para cambiar el contexto de la aplicación, modificar la propiedad `Context Path` en NetBeans.
* Para cambiar el puerto de Tomcat, editar `server.xml` en la carpeta `conf` de Tomcat.
* Asegurarse de usar importaciones `jakarta.servlet.*` para compatibilidad con Tomcat 10+.
