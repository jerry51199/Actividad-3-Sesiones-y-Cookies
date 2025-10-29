package controlador;

import modelo.Triangulo;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class TrianguloServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Obtener datos del formulario
        double base = Double.parseDouble(request.getParameter("base"));
        double altura = Double.parseDouble(request.getParameter("altura"));

        // Crear objeto Triangulo y calcular
        Triangulo t = new Triangulo(base, altura);
        double area = t.getArea();
        double perimetro = t.getPerimetro();

        // Guardar resultados en cookies
        Cookie cookieBase = new Cookie("base", String.valueOf(base));
        Cookie cookieAltura = new Cookie("altura", String.valueOf(altura));
        Cookie cookieArea = new Cookie("area", String.valueOf(area));
        Cookie cookiePerimetro = new Cookie("perimetro", String.valueOf(perimetro));

        // Tiempo de vida de cookies: 1 día
        cookieBase.setMaxAge(24*60*60);
        cookieAltura.setMaxAge(24*60*60);
        cookieArea.setMaxAge(24*60*60);
        cookiePerimetro.setMaxAge(24*60*60);

        response.addCookie(cookieBase);
        response.addCookie(cookieAltura);
        response.addCookie(cookieArea);
        response.addCookie(cookiePerimetro);

        // Guardar nombre del usuario en sesión
        HttpSession session = request.getSession();
        String nombre = (String) session.getAttribute("nombre");
        session.setAttribute("nombre", nombre);

        // Enviar datos a JSP de resultados
        request.setAttribute("base", base);
        request.setAttribute("altura", altura);
        request.setAttribute("area", area);
        request.setAttribute("perimetro", perimetro);
        RequestDispatcher rd = request.getRequestDispatcher("resultado.jsp");
        rd.forward(request, response);
    }
}
