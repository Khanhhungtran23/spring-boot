package scse.wab.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import scse.wab.jpa.entity.Program;

import java.util.List;

public interface ProgramRepository extends JpaRepository<Program, Integer> {
    List<Program> findByNameContaining(String name);
    List<Program> findByNameContainingOrderByNameAsc(String name);
}
