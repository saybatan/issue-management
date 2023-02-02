package com.saybatan.issuemanagement.api;


import com.saybatan.issuemanagement.dto.ProjectDTO;
import com.saybatan.issuemanagement.service.impl.ProjectServiceImpl;
import com.saybatan.issuemanagement.util.ApiPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiPaths.ProjectCtrl.CTRL)
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

    @PutMapping("/{id}")
    public ResponseEntity<ProjectDTO> updateProject(@PathVariable("id") Long id, @Validated @RequestBody ProjectDTO projectDTO) {
        return ResponseEntity.ok(projectServiceImpl.update(id, projectDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProject(@PathVariable("id") Long id){
        return ResponseEntity.ok(projectServiceImpl.deleteById(id));
    }


}
