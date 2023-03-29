package hello.servlet.web.frontcontroller.version3;

import hello.servlet.web.frontcontroller.ModelView;

import java.util.Map;

public class StudentFormControllerV3 implements ControllerV3{

    @Override
    public ModelView process(Map<String, String> paramMap) {
        return new ModelView("new-form");
    }
}