package hello.servlet.web.frontcontroller.version4;

import java.util.Map;

public interface ControllerV4 {
    String process(Map<String, String> paramMap, Map<String, Object> model);
}
