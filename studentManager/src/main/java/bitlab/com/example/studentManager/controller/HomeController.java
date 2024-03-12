package bitlab.com.example.studentManager.controller;

import bitlab.com.example.studentManager.DBManager.Manager;
import bitlab.com.example.studentManager.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLOutput;
import java.util.ArrayList;

@Controller
public class HomeController {

    @GetMapping(value="/home")
    public String indexPage(Model model){
        ArrayList<Student> allStudents = Manager.getAllStudents();
        model.addAttribute("allStudentsAttribute", allStudents);
        return "indexPage";
    }

    @GetMapping(value="/addStudentPage")
    public String addStudentPage(){
        return "addStudent";
    }

    @PostMapping(value="/addStudent")
    public String addStudent(@RequestParam(name = "name") String studentName,
                             @RequestParam(name = "surname") String studentSurname,
                             @RequestParam(name = "exam") int exam){
        Student student = new Student();
        student.setName(studentName);
        student.setSurname(studentSurname);
        student.setExam(exam);
        Manager.addStudent(student);
        return "redirect:/home";
    }
    @GetMapping(value="/details/{id}")
    public String details(@PathVariable(name = "id") Long id, Model model){
        Student student = Manager.getStudentById(id);
        model.addAttribute("studentAttr", student);
        return "details";
    }
}
