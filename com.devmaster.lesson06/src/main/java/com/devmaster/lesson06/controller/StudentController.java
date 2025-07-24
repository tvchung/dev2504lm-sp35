package com.devmaster.lesson06.controller;

import com.devmaster.lesson06.dto.StudentDTO;
import com.devmaster.lesson06.entity.Student;
import com.devmaster.lesson06.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping
    public  String getStudents(Model model){
        List<Student> students = studentService.fillAll();
        model.addAttribute("students",students);
        return "students/student-list";
    }
    @GetMapping("/add-new")
    public String addNewStudent(Model model) {
        model.addAttribute("student", new StudentDTO());
        return "students/student-add";
    }
    // Post khi thêm mới
    @PostMapping
    public String saveStudent(@ModelAttribute("student") StudentDTO student) {
        studentService.save(student);
        return "redirect:/students";
    }

    // Form sưar
    @GetMapping("/edit/{id}")
    public String showFormEditStudent(@PathVariable(value = "id") long id, Model model) {
        StudentDTO student =
                studentService.findById(id).orElseThrow(()
                        -> new  IllegalArgumentException("Invalid student Id:" + id));
        model.addAttribute("student", student);
        return "students/student-edit";
    }
    // Submit form edit
    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable(value = "id") Long id ,@ModelAttribute("student") StudentDTO student) {
        studentService.updateStudentById(id,student);
        return "redirect:/students";
    }

    // xóa
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable(value = "id") Long id)
    {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
}
