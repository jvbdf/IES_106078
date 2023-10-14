package ies.jakartawebstarter;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello User!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userMessage;

        response.setContentType("text/html");
        userMessage = request.getParameter("msg");
        System.out.println(userMessage       );
        PrintWriter out = response.getWriter();
        if (userMessage == null) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Hello User</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + message + "</h1>");
            out.println("<p>" + "If you want to see a message just type it as a parameter folloowing the example above:" + "</h1>");
            out.println("<p>" + "http://127.0.0.1:8888/JakartaWebStarter-1.0-SNAPSHOT/hello-servlet?msg=ola%20novo%20usuario" + "</h1>");
            out.println("</body></html>");
        }
        else{
            out.println("<html>");
            out.println("<head>");
            out.println("<title>User Message</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + userMessage + "</h1>");
            out.println("</body></html>");
        }
       
    }

    public void destroy() {
    }

}