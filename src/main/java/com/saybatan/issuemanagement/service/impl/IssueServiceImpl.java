package com.saybatan.issuemanagement.service.impl;

import com.saybatan.issuemanagement.dto.IssueDTO;
import com.saybatan.issuemanagement.entity.Issue;
import com.saybatan.issuemanagement.repository.IssueRepository;
import com.saybatan.issuemanagement.service.IssueService;
import com.saybatan.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class IssueServiceImpl implements IssueService {

//    This is not best practice
//    @Autowired
//    private IssueRepository issueRepository;

    private final IssueRepository issueRepository;
    private final ModelMapper modelMapper;

    public IssueServiceImpl(IssueRepository issueRepository, ModelMapper modelMapper) {
        this.issueRepository = issueRepository;
        this.modelMapper = modelMapper;
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
        return null;
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
    public Boolean delete(IssueDTO IssueDTO) {
        return null;
    }

    @Override
    public IssueDTO update(Long id, IssueDTO issueDTO) {
        return null;
    }

    public Boolean deleteById(Long id){
        issueRepository.deleteById(id);
        return true;
    }
}
