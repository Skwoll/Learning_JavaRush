package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class University {
    private String name;

    private List<Student> students;

    private int age;

    public University(String name, int age) {
        this.name = name;
        this.age = age;
        students = new ArrayList<>();
    }

    public Student getStudentWithAverageGrade(double avg) {
        //TODO:
        return students.stream().filter(student -> student.getAverageGrade() == avg).findFirst().get();
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        return students.stream().sorted(Comparator.comparingDouble(value -> -value.getAverageGrade())).findFirst().get();
    }

    public Student getStudentWithMinAverageGrade() {
        //TODO:
        return students.stream().sorted(Comparator.comparingDouble(value -> value.getAverageGrade())).findFirst().get();
    }

    public void expel(Student student) {
        students.remove(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}