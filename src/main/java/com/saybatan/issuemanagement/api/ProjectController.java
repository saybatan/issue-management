package com.saybatan.issuemanagement.api;


import com.saybatan.issuemanagement.dto.ProjectDTO;
import com.saybatan.issuemanagement.service.impl.ProjectServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
public class ProjectController {
    private final ProjectServiceImpl projectServiceImpl;
    public ProjectController(ProjectServiceImpl projectServiceImpl) {
        this.projectServiceImpl = projectServiceImpl;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDTO> getById(@PathVariable("id") Long id){
        ProjectDTO projectDTO = projectServiceImpl.getById(id);
        return ResponseEntity.ok(projectDTO);
    }




}
