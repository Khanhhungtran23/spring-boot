package scse.wab.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scse.wab.jpa.entity.Course;
import scse.wab.jpa.repository.CourseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses(String name, String sort) {
        if (sort != null && sort.equals("asc")) {
            return courseRepository.findByNameContainingOrderByNameAsc(name);
        }
        else if (name != null) {
        return courseRepository.findByNameContaining(name); }
        else return courseRepository.findAll();
    }

    public List<Course> getCourseByName(String name) {
        return courseRepository.findByNameContaining(name);
    }

    public Course updateCourse(Integer courseId, Course courseDetails) {
        Optional<Course> course = courseRepository.findById(courseId);

        if (course.isPresent()) {
            Course existingCourse = course.get();

            existingCourse.setCourseLevelId(courseDetails.getCourseLevelId());
            existingCourse.setName(courseDetails.getName());
            existingCourse.setNameVn(courseDetails.getNameVn());
            existingCourse.setCreditTheory(courseDetails.getCreditTheory());
            existingCourse.setCreditLab(courseDetails.getCreditLab());
            existingCourse.setDescription(courseDetails.getDescription());

            return courseRepository.save(existingCourse);
        }
        return null;
    }

    public boolean deleteCourse(Integer courseId) {
        if (courseRepository.existsById(courseId)) {
            courseRepository.deleteById(courseId);
            return true;
        }
        return false;
    }
}
