package scse.wab.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import scse.wab.jpa.entity.CourseProgram;
import scse.wab.jpa.service.CourseProgramService;

import java.util.List;

@RestController
@RequestMapping("/api/cp")
public class CourseProgramController {

    @Autowired
    private CourseProgramService courseProgramService;

    @PostMapping("/new")
    public CourseProgram createCourseProgram(@RequestBody CourseProgram courseProgram) {
        return courseProgramService.createCourseProgram(courseProgram);
    }

    @GetMapping("/{programName}")
    public List<CourseProgram> getCourseProgramsByProgramName(@PathVariable String programName) {
        return courseProgramService.getCourseProgramsByProgramName(programName);
    }

    @DeleteMapping("/{courseName}/{programName}")
    public ResponseEntity<Void> deleteCourseProgram(@PathVariable String courseName, @PathVariable String programName) {
        courseProgramService.deleteCourseProgram(courseName, programName);
        return ResponseEntity.noContent().build();
    }
}
