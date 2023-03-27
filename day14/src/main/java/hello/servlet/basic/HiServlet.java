package hello.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "hiServlet", urlPatterns = "/hi")
public class HiServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8");


        PrintWriter writer = resp.getWriter();
        writer.println("HiServlet");
        writer.println("request = " + req);
        writer.println("response = " + resp);

        writer.println("name = " + req.getParameter("name"));

    }
}
