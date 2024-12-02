package scse.wab.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import scse.wab.jpa.entity.Program;
import scse.wab.jpa.service.ProgramService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/p")
public class ProgramController {

    @Autowired
    private ProgramService programService;

    @PostMapping
    public Program createProgram(@RequestBody Program program) {
        return programService.createProgram(program);
    }

    @GetMapping
    public List<Program> getPrograms(@RequestParam(required = false) String name, @RequestParam(required = false) String sort) {
        return programService.getAllPrograms(name, sort);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Program> getProgram(@PathVariable String name) {
        Optional<Program> program = programService.getProgramByName(name);
        return program.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Program> updateProgram(@PathVariable Integer id, @RequestBody Program programDetails) {
        Program updatedProgram = programService.updateProgram(id, programDetails);
        return updatedProgram != null ? ResponseEntity.ok(updatedProgram) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProgram(@PathVariable Integer id) {
        boolean isDeleted = programService.deleteProgram(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
