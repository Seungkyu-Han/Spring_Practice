package spring_practice.spring_practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @GetMapping("welcome")
    public String welcome(Model model){
        model.addAttribute("data", "welcome!");
        return "welcome";
    }

    @GetMapping("my-mvc")
    public String myMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "my-template";
    }

    @GetMapping("myAPI")
    @ResponseBody
    public String myApi(@RequestParam("name") String name){
        return "hello " + name;
    }

    @GetMapping("myJSON")
    @ResponseBody
    public Temp tempApi(@RequestParam("name") String name){
        Temp temp = new Temp();
        temp.setName(name);
        return temp;
    }

    static class Temp{
        private String name;

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }
    }
}
