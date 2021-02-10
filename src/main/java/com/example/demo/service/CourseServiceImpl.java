package com.example.demo.service;

import com.example.demo.dao.CourseRepository;
import com.example.demo.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl  implements CourseService{

    private List<Course> list;
    @Autowired
    private CourseRepository courseDao;

    public CourseServiceImpl(){
       /* list= new ArrayList<>();
        list.add(new Course(1,"Java","Spring Boot"));
        list.add(new Course(2,"Android","Android  Test"));*/
    }
    @Override
    public List<Course> getCourses() {
        return courseDao.findAll();
    }

    @Override
    public Course getCourse(long courseId) {
        Course  course =courseDao.findById(courseId).get();
        return course;
       // return list.stream().filter(c -> c.getId()==courseId).collect(Collectors.toList());
    }

    @Override
    public Course addCourse(Course course) {
       // list.add(course);
        courseDao.save(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
       // list.add(course);
        courseDao.save(course);
        return course;
    }

    @Override
    public  void  deleteCourse(long courseId) {
       // list.clear();
        courseDao.deleteById(courseId);
    }
}
