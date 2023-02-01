package com.saybatan.issuemanagement.api;

import com.saybatan.issuemanagement.dto.IssueDTO;
import com.saybatan.issuemanagement.service.impl.IssueServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/issue")
public class IssueController {

    private final IssueServiceImpl issueService;

    public IssueController(IssueServiceImpl issueService) {
        this.issueService = issueService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<IssueDTO> getById(@PathVariable("id") Long id) {
        IssueDTO issueDTO = issueService.getById(id);
        return ResponseEntity.ok(issueDTO);
    }

    @PostMapping
    public ResponseEntity<IssueDTO> createIssue(@RequestBody IssueDTO issueDTO) {
        return ResponseEntity.ok(issueService.save(issueDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<IssueDTO> updateIssue(@PathVariable("id") Long id, @RequestBody IssueDTO issueDTO) {
        return ResponseEntity.ok(issueService.update(id, issueDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteIssue(@PathVariable("id") Long id) {
        return ResponseEntity.ok(issueService.deleteById(id));
    }
}
