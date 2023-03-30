package hello.servlet.web.frontcontroller.version5;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.version3.StudentFormControllerV3;
import hello.servlet.web.frontcontroller.version3.StudentListControllerV3;
import hello.servlet.web.frontcontroller.version3.StudentSaveControllerV3;
import hello.servlet.web.frontcontroller.version4.StudentFormControllerV4;
import hello.servlet.web.frontcontroller.version4.StudentListControllerV4;
import hello.servlet.web.frontcontroller.version4.StudentSaveControllerV4;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "frontControllerServletV5", urlPatterns = "/front-controller/V5/*")
public class FrontControllerServletV5 extends HttpServlet {

    private final Map<String, Object> handlerMappingMap = new HashMap<>();
    private final List<MyHandleAdapter> handleAdapters = new ArrayList<>();

    public FrontControllerServletV5(){
        initHandlerAdapters();
        initHandlerMappingMap();
    }

    private void initHandlerMappingMap(){
        handlerMappingMap.put("/front-controller/v5/v3/students/new-form", new StudentFormControllerV3());
        handlerMappingMap.put("/front-controller/v5/v3/students/save", new StudentSaveControllerV3());
        handlerMappingMap.put("/front-controller/v5/v3/students", new StudentListControllerV3());

        handlerMappingMap.put("/front-controller/v5/v4/students/new-form", new StudentFormControllerV4());
        handlerMappingMap.put("/front-controller/v5/v4/students/save", new StudentSaveControllerV4());
        handlerMappingMap.put("/front-controller/v5/v4/students", new StudentListControllerV4());
    }

    private void initHandlerAdapters(){
        handleAdapters.add(new ControllerV3HandlerAdapter());
        handleAdapters.add(new ControllerV4HandlerAdapter());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object handler = getHandler(req);

        if(handler == null){
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        MyHandleAdapter adapter = getHandlerAdapter(handler);
        ModelView modelView = adapter.handle(req, resp, handler);

         MyView view = viewer(modelView.getViewName());
         view.render(modelView.getModel(), req, resp);
    }

    private MyView viewer(String viewName) {
        return new MyView("/WEB-INF/view/" + viewName + ".jsp");
    }

    private MyHandleAdapter getHandlerAdapter(Object handler) {
        for(MyHandleAdapter adapter : handleAdapters){
            if(adapter.supports(handler)){
                return adapter;
            }
        }
        throw new IllegalStateException("no handler adapter");
    }

    private Object getHandler(HttpServletRequest req) {
        String requestURI = req.getRequestURI();
        return handlerMappingMap.get(requestURI);
    }
}
