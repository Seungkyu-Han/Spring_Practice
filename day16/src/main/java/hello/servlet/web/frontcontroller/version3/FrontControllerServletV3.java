package hello.servlet.web.frontcontroller.version2;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.version2.controller.StudentFormControllerV2;
import hello.servlet.web.frontcontroller.version2.controller.StudentListControllerV2;
import hello.servlet.web.frontcontroller.version2.controller.StudentSaveControllerV2;
import hello.servlet.web.frontcontroller.version3.ControllerV3;
import hello.servlet.web.frontcontroller.version3.StudentFormControllerV3;
import hello.servlet.web.frontcontroller.version3.StudentListControllerV3;
import hello.servlet.web.frontcontroller.version3.StudentSaveControllerV3;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {

    private Map<String, ControllerV3> controllerMap = new HashMap<>();

    public FrontControllerServletV3(){
        controllerMap.put("/front-controller/v3/students/new-form", new StudentFormControllerV3());
        controllerMap.put("/front-controller/v3/students/save", new StudentSaveControllerV3());
        controllerMap.put("/front-controller/v3/students", new StudentListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ControllerV3 controller = controllerMap.get(req.getRequestURI());
        if(controller == null){
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Map<String, String> paramMap = createParamMap(req);
        ModelView modelView = controller.process(paramMap);

        String viewName = modelView.getViewName();
        MyView view = viewer(viewName);
        view.render(modelView.getModel(), req, resp);
    }

    private MyView viewer(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    private Map<String, String> createParamMap(HttpServletRequest req) {
        Map<String, String> paramMap = new HashMap<>();
        req.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, req.getParameter(paramName)));

        return paramMap;
    }
}
