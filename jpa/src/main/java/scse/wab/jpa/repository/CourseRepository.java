package scse.wab.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import scse.wab.jpa.entity.Course;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    List<Course> findByNameContaining(String name);
    List<Course> findByNameContainingOrderByNameAsc(String name);
}
