package org.example;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private int studentId;
    private String firstName;
    private String lastName;
    private final List<Course> courses = new ArrayList<>();

    public Student(int studentId, String firstName, String lastName) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public List<Course> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    public int getStudentId() {
        return studentId;
    }
}
