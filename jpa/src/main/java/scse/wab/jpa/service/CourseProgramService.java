package scse.wab.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scse.wab.jpa.entity.CourseProgram;
import scse.wab.jpa.repository.CourseProgramRepository;

import java.util.List;
// import java.util.Optional;

@Service
public class CourseProgramService {

    @Autowired
    private CourseProgramRepository courseProgramRepository;

    public CourseProgram createCourseProgram(CourseProgram courseProgram) {
        return courseProgramRepository.save(courseProgram);
    }

    public List<CourseProgram> getCourseProgramsByProgramName(String programName) {
        return courseProgramRepository.findByProgramNameContaining(programName);
    }

    public void deleteCourseProgram(String courseName, String programName) {
        courseProgramRepository.deleteByCourseNameAndProgramName(courseName, programName);
    }
}
