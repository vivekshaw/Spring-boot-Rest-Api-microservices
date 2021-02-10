package com.example.demo.controler;

import com.example.demo.entity.Course;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseControler {

    @Autowired
    private CourseService courseService;

    @GetMapping("/home")
    public String home(){
       return "First Api";
    }

    @GetMapping("/courses")
    public List<Course> getCourses(){
       // List<Course> courseList=new ArrayList<>();
        return this.courseService.getCourses();
    }


    @GetMapping("/course/{courseId}")
    public Course getCourse(@PathVariable String courseId){
        return this.courseService.getCourse(Long.parseLong(courseId));
    }

    @PostMapping("/courses")
    public Course  addCourse(@RequestBody Course course){
        return this.courseService.addCourse(course);
    }

    @PutMapping("/courses")
    public Course  updateCourse(@RequestBody Course course){
        return this.courseService.updateCourse(course);
    }


    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> updateCourse(@PathVariable String courseId){
        try{
             this.courseService.deleteCourse(Long.parseLong(courseId));
             return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
