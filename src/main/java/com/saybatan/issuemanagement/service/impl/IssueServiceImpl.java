package com.saybatan.issuemanagement.service.impl;

import com.saybatan.issuemanagement.entity.Issue;
import com.saybatan.issuemanagement.repository.IssueRepository;
import com.saybatan.issuemanagement.service.IssueService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class IssueServiceImpl implements IssueService {

//    This is not best practice
//    @Autowired
//    private IssueRepository issueRepository;

    private final IssueRepository issueRepository;

    public IssueServiceImpl(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    @Override
    public Issue save(Issue issue) {
        return issueRepository.save(issue);
    }

    @Override
    public Issue getById(Long id) {
        return issueRepository.getOne(id);
    }

    @Override
    public Page<Issue> getAllPageable(Pageable pageable) {
        return issueRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(Issue issue) {
        issueRepository.delete(issue);
        return true;
    }
}
