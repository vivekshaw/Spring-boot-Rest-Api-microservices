package com.example.demo.service;

import com.example.demo.entity.Course;
import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CourseService {

    public List<Course> getCourses();
    public Course getCourse(long courseId);
    public Course addCourse(Course course);
    public Course updateCourse(Course course);
    public void  deleteCourse(long courseId);


}
