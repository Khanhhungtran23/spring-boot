package scse.wab.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import scse.wab.jpa.entity.CourseProgram;

import java.util.List;

public interface CourseProgramRepository extends JpaRepository<CourseProgram, Integer> {
    List<CourseProgram> findByProgramNameContaining(String programName);
    void deleteByCourseNameAndProgramName(String courseName, String programName);
}
