package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "requestHeader", urlPatterns = "/requestHeader")
public class RequestHeader extends HttpServlet {

    private void printStart(HttpServletResponse httpServletResponse, String string) throws IOException {
        httpServletResponse.getWriter().printf("--- %s-Line start ---\n", string);
    }

    private void printEnd(HttpServletResponse httpServletResponse, String string) throws IOException {
        httpServletResponse.getWriter().printf("--- %s-Line end ---\n", string);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StartLine(req, resp);
        Headers(req, resp);
    }

    private void StartLine(HttpServletRequest request,HttpServletResponse response)throws IOException{

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");

        PrintWriter writer = response.getWriter();

        printStart(response, "Request");

        writer.println("Method = " + request.getMethod());
        writer.println("Protocol = " + request.getProtocol());
        writer.println("Scheme = " + request.getScheme());
        writer.println("RequestURL = " + request.getRequestURL());
        writer.println("RequestURI = " + request.getRequestURI());
        writer.println("QueryString = " + request.getQueryString());
        writer.println("isSecure = " + request.isSecure());
        printEnd(response, "Request");

        writer.println();
    }

    private void Headers(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");

        PrintWriter writer = response.getWriter();

        printStart(response, "Headers");

        request.getHeaderNames().asIterator()
                .forEachRemaining(headerName -> writer.println(headerName + " = " + request.getHeader(headerName)));

        printEnd(response, "Headers");
        writer.println();
    }
}
