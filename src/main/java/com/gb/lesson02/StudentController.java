package com.gb.lesson02;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    private StudentRepository repository;

    @Autowired
    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }


    @GetMapping()
    public List<Student> getAll() {
        return repository.getAllStudent();
    }

    @GetMapping("{id}")
    public Student getById(@PathVariable long id) {
        return repository.getStudentId(id);
    }

    @GetMapping("search")
    public Student getByName(@RequestParam String name) {
        return repository.getStudentName(name);
    }

    @GetMapping("group/{groupName}")
    public List<Student> getByGroup(@PathVariable("groupName") String nameGroup) {
        return repository.getStudentGroup(nameGroup);
    }
}
