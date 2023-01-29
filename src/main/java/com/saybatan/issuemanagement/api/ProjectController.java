package com.saybatan.issuemanagement.api;


import com.saybatan.issuemanagement.dto.ProjectDTO;
import com.saybatan.issuemanagement.service.impl.ProjectServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project")
public class ProjectController {
    private final ProjectServiceImpl projectServiceImpl;

    public ProjectController(ProjectServiceImpl projectServiceImpl) {
        this.projectServiceImpl = projectServiceImpl;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDTO> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(projectServiceImpl.getById(id));
    }

    @PostMapping
    public ResponseEntity<ProjectDTO> createProject(@RequestBody ProjectDTO projectDTO) {
        return ResponseEntity.ok(projectServiceImpl.save(projectDTO));
    }


}
