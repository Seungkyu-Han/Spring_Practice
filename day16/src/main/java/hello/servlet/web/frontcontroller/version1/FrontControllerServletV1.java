package hello.servlet.web.frontcontroller.version1;

import hello.servlet.web.frontcontroller.version1.controller.StudentFormControllerV1;
import hello.servlet.web.frontcontroller.version1.controller.StudentListControllerV1;
import hello.servlet.web.frontcontroller.version1.controller.StudentSaveControllerV1;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV1", urlPatterns = "/front-controller/v1/*")
public class FrontControllerServletV1 extends HttpServlet {
    private Map<String, ControllerV1> controllerMap = new HashMap<>();

    public FrontControllerServletV1(){
        controllerMap.put("/front-controller/v1/students/new-form", new StudentFormControllerV1());
        controllerMap.put("/front-controller/v1/students/save", new StudentSaveControllerV1());
        controllerMap.put("/front-controller/v1/students", new StudentListControllerV1());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ControllerV1 controller = controllerMap.get(req.getRequestURI());
        if(controller == null){
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        controller.process(req, resp);
    }
}
