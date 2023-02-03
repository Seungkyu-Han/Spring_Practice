package spring_practice.spring_practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import spring_practice.spring_practice.domain.Member;
import spring_practice.spring_practice.service.MemberService;

import java.util.List;

@Controller
public class StuController {

    private final MemberService memberService;

    @Autowired
    public StuController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/student/new")
    public String createForm(){
        return "student/createStuForm";
    }

    @PostMapping("/student/new")
    public String create(StuForm form){
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("student")
    public String list(Model model){
        List<Member> students = memberService.findMembers();
        model.addAttribute("students", students);
        return "student/studentList";
    }
}
