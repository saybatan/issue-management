package com.saybatan.issuemanagement.service;

import com.saybatan.issuemanagement.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProjectService {

    Project save(Project project);
    Project getById(Long id);
    Project getByProjectCode(String projectCode);
    Page<Project> getAllPageable(Pageable pageable);
    Boolean delete(Project project);

}
