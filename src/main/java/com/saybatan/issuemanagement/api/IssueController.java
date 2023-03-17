package com.saybatan.issuemanagement.api;

import com.saybatan.issuemanagement.dto.IssueDTO;
import com.saybatan.issuemanagement.dto.IssueUpdateDTO;
import com.saybatan.issuemanagement.service.impl.IssueServiceImpl;
import com.saybatan.issuemanagement.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
@Api(value = ApiPaths.ProjectCtrl.CTRL)
public class IssueController {

    private final IssueServiceImpl issueService;

    public IssueController(IssueServiceImpl issueService) {
        this.issueService = issueService;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get By ID Operation", response = IssueDTO.class)
    public ResponseEntity<IssueDTO> getById(@PathVariable("id") Long id) {
        IssueDTO issueDTO = issueService.getById(id);
        return ResponseEntity.ok(issueDTO);
    }
    @GetMapping
    public ResponseEntity<List<IssueDTO>> getAll() {
        return ResponseEntity.ok(issueService.getAll());
    }

    @PostMapping
    @ApiOperation(value = "Create Operation", response = IssueDTO.class)
    public ResponseEntity<IssueDTO> createIssue(@RequestBody IssueUpdateDTO issueUpdateDTO) {
        return ResponseEntity.ok(issueService.save(issueUpdateDTO));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Operation", response = IssueDTO.class)
    public ResponseEntity<IssueDTO> updateIssue(@PathVariable("id") Long id, @Valid @RequestBody IssueUpdateDTO issueUpdateDTO) {
        return ResponseEntity.ok(issueService.update(id, issueUpdateDTO));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Operation", response = Boolean.class)
    public ResponseEntity<Boolean> deleteIssue(@PathVariable("id") Long id) {
        return ResponseEntity.ok(issueService.deleteById(id));
    }
}
