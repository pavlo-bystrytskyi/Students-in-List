package org.example;

import java.util.ArrayList;
import java.util.List;

public class School {
    List<Student> students;

    public School() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public Student findStudentById(int id) {
        Student result = null;
        for (Student student : students) {
            if (student.getStudentId() == id) {
                result = student;
                break;
            }
        }

        return result;
    }

    public List<Course> getCoursesByStudentId(int id) {
        Student student = findStudentById(id);

        if (student == null) {
            return new ArrayList<>();
        } else {
            return student.getCourses();
        }
    }

    public void printAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
