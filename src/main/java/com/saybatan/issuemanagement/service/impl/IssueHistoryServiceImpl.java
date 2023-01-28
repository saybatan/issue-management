package com.saybatan.issuemanagement.service.impl;

import com.saybatan.issuemanagement.entity.Issue;
import com.saybatan.issuemanagement.entity.IssueHistory;
import com.saybatan.issuemanagement.repository.IssueHistoryRepository;
import com.saybatan.issuemanagement.repository.IssueRepository;
import com.saybatan.issuemanagement.service.IssueHistoryService;
import com.saybatan.issuemanagement.service.IssueService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class IssueHistoryServiceImpl implements IssueHistoryService {

    private final IssueHistoryRepository issueHistoryRepository;

    public IssueHistoryServiceImpl(IssueHistoryRepository issueHistoryRepository) {
        this.issueHistoryRepository = issueHistoryRepository;
    }

    @Override
    public IssueHistory save(IssueHistory issueHistory) {
        return issueHistoryRepository.save(issueHistory);
    }

    @Override
    public IssueHistory getById(Long id) {
        return issueHistoryRepository.getOne(id);
    }

    @Override
    public Page<IssueHistory> getAllPageable(Pageable pageable) {
        return issueHistoryRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(IssueHistory issueHistory) {
        issueHistoryRepository.delete(issueHistory);
        return true;
    }
}
