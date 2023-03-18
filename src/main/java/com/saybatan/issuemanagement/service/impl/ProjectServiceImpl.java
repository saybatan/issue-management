package com.saybatan.issuemanagement.service.impl;

import com.saybatan.issuemanagement.dto.ProjectDTO;
import com.saybatan.issuemanagement.entity.Project;
import com.saybatan.issuemanagement.repository.ProjectRepository;
import com.saybatan.issuemanagement.service.ProjectService;
import com.saybatan.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

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
        checkProjectCode(projectDTO);
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
    public TPage<ProjectDTO> getAllPageable(Pageable pageable) {
        Page<Project> projects = projectRepository.findAll(pageable);
        TPage<ProjectDTO> tPage = new TPage<>();
        tPage.setStat(projects, Arrays.asList(modelMapper.map(projects.getContent(),ProjectDTO[].class)));
        return tPage;
    }

    @Override
    public Boolean delete(ProjectDTO projectDTO) {
        return null;
    }

    public Boolean deleteById(Long id){
        projectRepository.deleteById(id);
        return true;
    }

    @Override
    public ProjectDTO update(Long id, ProjectDTO projectDTO) {

        Project project = projectRepository.getOne(id);
        if (project == null) {
            throw new IllegalArgumentException("Project Does Not Exist. ID: " + id);
        }
//        checkProjectCode(projectDTO);
        Project projectCheck = projectRepository.getByProjectCodeAndIdNot(projectDTO.getProjectCode(),id);
        if (projectCheck != null){
            throw new IllegalArgumentException("Project Code Already Exist");
        }
        project.setProjectCode(projectDTO.getProjectCode());
        project.setProjectName(projectDTO.getProjectName());
        projectRepository.save(project);
        return modelMapper.map(project, ProjectDTO.class);
    }

//    public Boolean deleteProject

    @Override
    public void checkProjectCode(ProjectDTO projectDTO) {
        Project projectCode = projectRepository.getByProjectCode(projectDTO.getProjectCode());
        if (projectCode != null) {
            throw new IllegalArgumentException("Project Code Already Exist");
        }
    }

    public List<ProjectDTO> getAll() {
        List<Project> projectList = projectRepository.findAll();
        return Arrays.asList(modelMapper.map(projectList,ProjectDTO[].class));
    }
}
