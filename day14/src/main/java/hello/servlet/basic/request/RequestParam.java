package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "requestParam", urlPatterns = "/requestParam")
public class RequestParam extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("[파리미터 조회] - start");
        req.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName + " = " + req.getParameter(paramName)));

        System.out.println("[파리미터 조회] - end");
        System.out.println();

        System.out.println("[개별 파라미터 조회]");
        System.out.println("name : " + req.getParameter("name"));
        System.out.println("age: " + req.getParameter("age"));

        System.out.println();
    }
}
