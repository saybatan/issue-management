package com.saybatan.issuemanagement.service;

import com.saybatan.issuemanagement.dto.ProjectDTO;
import com.saybatan.issuemanagement.util.TPage;
import org.springframework.data.domain.Pageable;

public interface ProjectService {

    ProjectDTO save(ProjectDTO projectDTO);

    ProjectDTO getById(Long id);

    ProjectDTO getByProjectCode(String projectCode);

    TPage<ProjectDTO> getAllPageable(Pageable pageable);

    Boolean delete(ProjectDTO projectDTO);

    ProjectDTO update(Long id, ProjectDTO projectDTO);

    void checkProjectCode(ProjectDTO projectDTO);

}
