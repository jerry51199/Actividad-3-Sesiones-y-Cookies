<%@ page import="jakarta.servlet.http.Cookie" %>
<%@ page session="true" %>
<%
    // Usamos la variable session que ya existe automáticamente
    String nombre = (String) session.getAttribute("nombre");

    if (nombre == null) {
        if (request.getMethod().equalsIgnoreCase("POST") && request.getParameter("nombre") != null) {
            nombre = request.getParameter("nombre");
            session.setAttribute("nombre", nombre);
            out.println("<p>Hola, " + nombre + "!</p>");
        } else {
            out.println("<form method='post'>");
            out.println("Ingrese su nombre: <input type='text' name='nombre' required>");
            out.println("<input type='submit' value='Guardar'>");
            out.println("</form>");
            return;
        }
    } else {
        out.println("<p>Hola, " + nombre + "!</p>");
    }

    // Mostrar cookies del último triángulo calculado
    Cookie[] cookies = request.getCookies();
    String base = "", altura = "", area = "", perimetro = "";
    if (cookies != null) {
        for (Cookie c : cookies) {
            switch(c.getName()) {
                case "base": base = c.getValue(); break;
                case "altura": altura = c.getValue(); break;
                case "area": area = c.getValue(); break;
                case "perimetro": perimetro = c.getValue(); break;
            }
        }
    }

    if (!base.isEmpty()) {
        out.println("<h3>Último triángulo calculado:</h3>");
        out.println("<p>Base: " + base + "</p>");
        out.println("<p>Altura: " + altura + "</p>");
        out.println("<p>Área: " + area + "</p>");
        out.println("<p>Perímetro: " + perimetro + "</p>");
    }
%>

<h3>Ingrese los datos del triángulo equilátero</h3>
<form action="TrianguloServlet" method="post">
    Base: <input type="number" name="base" step="0.01" required><br>
    Altura: <input type="number" name="altura" step="0.01" required><br>
    <input type="submit" value="Calcular">
</form>
