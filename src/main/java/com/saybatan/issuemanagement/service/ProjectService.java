package com.saybatan.issuemanagement.service;

import com.saybatan.issuemanagement.dto.ProjectDTO;
import com.saybatan.issuemanagement.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProjectService {

    ProjectDTO save(ProjectDTO projectDTO);
    ProjectDTO getById(Long id);
    ProjectDTO getByProjectCode(String projectCode);
    Page<ProjectDTO> getAllPageable(Pageable pageable);
    Boolean delete(ProjectDTO projectDTO);

}
