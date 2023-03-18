package com.saybatan.issuemanagement.api;


import com.saybatan.issuemanagement.dto.ProjectDTO;
import com.saybatan.issuemanagement.dto.ProjectSaveDTO;
import com.saybatan.issuemanagement.service.impl.ProjectServiceImpl;
import com.saybatan.issuemanagement.util.ApiPaths;
import com.saybatan.issuemanagement.util.TPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiPaths.ProjectCtrl.CTRL)
@Api(value = ApiPaths.ProjectCtrl.CTRL)
@Slf4j
public class ProjectController {
    private final ProjectServiceImpl projectServiceImpl;

    public ProjectController(ProjectServiceImpl projectServiceImpl) {
        this.projectServiceImpl = projectServiceImpl;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get By ID Operation", response = ProjectDTO.class)
    public ResponseEntity<ProjectDTO> getById(@PathVariable("id") Long id) {
        log.info("ProjectController -> GetByID");
        log.debug("ProjectController -> GetByID -> PARAM: ", id);
        return ResponseEntity.ok(projectServiceImpl.getById(id));
    }

    @GetMapping
    @ApiOperation(value = "Get All Operation", response = ProjectDTO.class)
    public ResponseEntity<List<ProjectDTO>> getAll() {
        return ResponseEntity.ok(projectServiceImpl.getAll());
    }

    @GetMapping("/pagination")
    @ApiOperation(value = "Get By Pagination Operation", response = ProjectDTO.class)
    public ResponseEntity<TPage<ProjectDTO>> getAllPageable(Pageable pageable) {
        return ResponseEntity.ok(projectServiceImpl.getAllPageable(pageable));
    }

    @PostMapping
    @ApiOperation(value = "Create Operation", response = ProjectDTO.class)
    public ResponseEntity<ProjectDTO> createProject(@RequestBody ProjectSaveDTO projectSaveDTO) {
        return ResponseEntity.ok(projectServiceImpl.save(projectSaveDTO));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Operation", response = ProjectDTO.class)
    public ResponseEntity<ProjectDTO> updateProject(@PathVariable("id") Long id, @Validated @RequestBody ProjectSaveDTO projectSaveDTO) {
        return ResponseEntity.ok(projectServiceImpl.update(id, projectSaveDTO));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Operation", response = Boolean.class)
    public ResponseEntity<Boolean> deleteProject(@PathVariable("id") Long id) {
        return ResponseEntity.ok(projectServiceImpl.deleteById(id));
    }


}
