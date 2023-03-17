package com.saybatan.issuemanagement.service.impl;

import com.saybatan.issuemanagement.dto.IssueDTO;
import com.saybatan.issuemanagement.entity.Issue;
import com.saybatan.issuemanagement.entity.IssueStatus;
import com.saybatan.issuemanagement.entity.Project;
import com.saybatan.issuemanagement.entity.User;
import com.saybatan.issuemanagement.repository.IssueRepository;
import com.saybatan.issuemanagement.repository.ProjectRepository;
import com.saybatan.issuemanagement.repository.UserRepository;
import com.saybatan.issuemanagement.service.IssueService;
import com.saybatan.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class IssueServiceImpl implements IssueService {

//    This is not best practice
//    @Autowired
//    private IssueRepository issueRepository;

    private final IssueRepository issueRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;

    public IssueServiceImpl(IssueRepository issueRepository, ModelMapper modelMapper, UserRepository userRepository, ProjectRepository projectRepository) {
        this.issueRepository = issueRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public IssueDTO save(IssueDTO issueDTO) {

        if (issueDTO.getDate() == null) {
            throw new IllegalArgumentException("Issue date can not be null");
        }

        Issue issue = modelMapper.map(issueDTO, Issue.class);
        issueRepository.save(issue);
        return modelMapper.map(issue, IssueDTO.class);
    }

    @Override
    public IssueDTO getById(Long id) {
        Issue issue = issueRepository.getOne(id);
        return modelMapper.map(issue, IssueDTO.class);
    }

    public List<IssueDTO> getAll() {
        List<Issue> issueList = issueRepository.findAll();
        return Arrays.asList(modelMapper.map(issueList,IssueDTO[].class));
    }

    @Override
    public TPage<IssueDTO> getAllPageable(Pageable pageable) {

        Page<Issue> issues = issueRepository.findAll(pageable);
        TPage tPage = new TPage<IssueDTO>();
        IssueDTO[] dtos = modelMapper.map(issues.getContent(), IssueDTO[].class);
        tPage.setStat(issues, Arrays.asList(dtos));

        return tPage;
    }

    @Override
    public Boolean delete(IssueDTO issueDTO) {
        Issue issue = modelMapper.map(issueDTO, Issue.class);
        issueRepository.delete(issue);
        return true;
    }

    @Override
    public IssueDTO update(Long id, IssueDTO issueDTO) {
        Issue issue = issueRepository.getOne(id);
        User user = userRepository.getOne(issueDTO.getAssignee().getId());
        issue.setAssignee(user);
        issue.setDate(issueDTO.getDate());
        issue.setDescription(issueDTO.getDescription());
        issue.setIssueStatus(issueDTO.getIssueStatus());
        issue.setDetails(issueDTO.getDetails());
        Project project = projectRepository.getOne(issueDTO.getProject().getId());
        issue.setProject(project);
        issueRepository.save(issue);
        return modelMapper.map(issue,IssueDTO.class);
    }

    public Boolean deleteById(Long id) {
        issueRepository.deleteById(id);
        return true;
    }
}
