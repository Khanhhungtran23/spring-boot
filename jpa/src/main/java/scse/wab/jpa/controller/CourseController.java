package scse.wab.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import scse.wab.jpa.entity.Course;
import scse.wab.jpa.service.CourseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/c")
public class CourseController {


    @Autowired
    private CourseService courseService;

    @PostMapping("/new")
    public Course createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    @GetMapping("/all")
    public List<Course> getCourses(@RequestParam(required = false) String name, @RequestParam(required = false) String sort) {
        return courseService.getAllCourses(name, sort);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Course> getCourse(@PathVariable String name) {
        Optional<Course> course = courseService.getCourseByName(name);
        return course.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Integer id, @RequestBody Course courseDetails) {
        Course updatedCourse = courseService.updateCourse(id, courseDetails);
        return updatedCourse != null ? ResponseEntity.ok(updatedCourse) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Integer id) {
        boolean isDeleted = courseService.deleteCourse(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
