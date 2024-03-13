package com.gb.lesson02;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentRepository {
    private final List<Student> list;

    public StudentRepository() {
        list = new ArrayList<>();
        list.add(new Student("Костя1", "group1"));
        list.add(new Student("Костя2", "group 01"));
        list.add(new Student("Костя3", "group1"));
        list.add(new Student("Костя4", "group 01"));
        list.add(new Student("Костя5", "group 01"));
        list.add(new Student("Костя6", "group02"));
        list.add(new Student("Костя7", "group 02"));
        list.add(new Student("Костя8", "group 02"));
        list.add(new Student("Костя9", "group 02"));
        list.add(new Student("Костя10", "group 02"));
    }

    public Student getStudentId(long id) {
        return list.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Student> getAllStudent() {
        return List.copyOf(list);
    }

    public Student getStudentName(String name) {
        return list.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public List<Student> getStudentGroup(String nameGroup) {
        return list.stream()
                .filter(e -> e.getNameGroup().equals(nameGroup))
                .map(p -> new Student(p.getId(), p.getName(), p.getNameGroup()))
                .collect(Collectors.toList());
    }
}
