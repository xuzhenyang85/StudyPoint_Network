package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "HTTP", urlPatterns = {"/HTTP"})
public class HTTP extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HTTP</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Servlet HTTP at " + request.getContextPath() + "</h2>");
            
            out.println("<p>host: " + request.getHeader("host") + "</p>");
            
            out.println("<p>connection: " + request.getHeader("connection") + "</p>");
            
            out.println("<p>cache-control: " + request.getHeader("cache-control") + "</p>");
            
            out.println("<p>accept: " + request.getHeader("accept") + "</p>");
            
            out.println("<p>user-Agent: " + request.getHeader("User-Agent") + "</p>");
            
            out.println("<p>accept-encoding: " + request.getHeader("accept-encoding") + "</p>");
            
            out.println("<p>accept-language: " + request.getHeader("accept-language") + "</p>");
            
            response.setHeader("Cache-Control", "max-age=300");
            
            out.println("<p> Parameters: " + request.getParameter("name")+"</p>");
            
            //request.getSession().setAttribute("name", "nonameSessionCookie"); // reference og værdi læggende
            out.println("<p> CookieSession: " + request.getSession().getAttribute("name") +"</p>");
            
            response.addCookie(new Cookie("name","nonamePersistentCookie"));
            out.println("<p>CookiePersistent: "+ request.getCookies()[1].getValue() + "</p>");
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
