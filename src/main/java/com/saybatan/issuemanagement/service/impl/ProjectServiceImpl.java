package com.saybatan.issuemanagement.service.impl;

import com.saybatan.issuemanagement.dto.ProjectDTO;
import com.saybatan.issuemanagement.entity.Project;
import com.saybatan.issuemanagement.repository.ProjectRepository;
import com.saybatan.issuemanagement.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProjectDTO save(ProjectDTO projectDTO) {
        Project projectCode = projectRepository.getByProjectCode(projectDTO.getProjectCode());
        if (projectCode != null) {
            throw new IllegalArgumentException("Project Code Already Exist");
        }
        Project project = modelMapper.map(projectDTO, Project.class);
        project = projectRepository.save(project);
        projectDTO.setId(project.getId());
        return projectDTO;
    }

    @Override
    public ProjectDTO getById(Long id) {
        Project project = projectRepository.getOne(id);
        return modelMapper.map(project, ProjectDTO.class);
    }

    @Override
    public ProjectDTO getByProjectCode(String projectCode) {
        return null;
    }

    @Override
    public Page<ProjectDTO> getAllPageable(Pageable pageable) {
        return null;
    }

    @Override
    public Boolean delete(ProjectDTO projectDTO) {
        return null;
    }

}
