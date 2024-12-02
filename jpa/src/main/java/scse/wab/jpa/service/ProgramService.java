package scse.wab.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scse.wab.jpa.entity.Program;
import scse.wab.jpa.repository.ProgramRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProgramService {

    @Autowired
    private ProgramRepository programRepository;

    public Program createProgram(Program program) {
        return programRepository.save(program);
    }

    public List<Program> getAllPrograms(String name, String sort) {
        if (sort != null && sort.equals("asc")) {
            return programRepository.findByNameContainingOrderByNameAsc(name);
        }
        return programRepository.findByNameContaining(name);
    }

    public Optional<Program> getProgramByName(String name) {
        return programRepository.findById(Integer.valueOf(name));
    }

    public Program updateProgram(Integer programId, Program programDetails) {
        Optional<Program> existingProgram = programRepository.findById(programId);

        if (existingProgram.isPresent()) {
            Program program = existingProgram.get();

            program.setName(programDetails.getName());
            program.setDuration(programDetails.getDuration());
            program.setVersion(programDetails.getVersion());
            program.setMajorId(programDetails.getMajorId());
            program.setProgramTypeId(programDetails.getProgramTypeId());
            program.setValidFrom(programDetails.getValidFrom());

            return programRepository.save(program);
        }
        return null;
    }


    public boolean deleteProgram(Integer programId) {
        if (programRepository.existsById(programId)) {
            programRepository.deleteById(programId);
            return true;
        }
        return false;
    }
}
