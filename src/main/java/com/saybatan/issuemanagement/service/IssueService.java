package com.saybatan.issuemanagement.service;

import com.saybatan.issuemanagement.entity.Issue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IssueService {

    Issue save(Issue issue);
    Issue getById(Long id);
    Page<Issue> getAllPageable(Pageable pageable);
    Boolean delete(Issue issue);

}
