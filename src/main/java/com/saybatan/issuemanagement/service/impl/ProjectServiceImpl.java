package com.saybatan.issuemanagement.service.impl;

import com.saybatan.issuemanagement.dto.ProjectDTO;
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
        return null;
    }

    @Override
    public ProjectDTO getById(Long id) {
        return null;
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

//    @Override
//    public Project save(Project project) {
//
//        if(project.getProjectCode() == null){
//            throw new IllegalArgumentException("Project code can not be null");
//        }
//
//        return projectRepository.save(project);
//    }
//
//    @Override
//    public Project getById(Long id) {
//        return projectRepository.getById(id);
//    }
//
//    @Override
//    public Project getByProjectCode(String projectCode) {
//        return projectRepository.getByProjectCode(projectCode);
//    }
//
//    @Override
//    public Page<Project> getAllPageable(Pageable pageable) {
//        return projectRepository.findAll(pageable);
//    }
//
//    @Override
//    public Boolean delete(Project project) {
//        projectRepository.delete(project);
//        return true;
//    }
}
