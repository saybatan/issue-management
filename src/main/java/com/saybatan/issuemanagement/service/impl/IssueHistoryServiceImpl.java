package com.saybatan.issuemanagement.service.impl;

import com.saybatan.issuemanagement.dto.IssueHistoryDTO;
import com.saybatan.issuemanagement.repository.IssueHistoryRepository;
import com.saybatan.issuemanagement.service.IssueHistoryService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class IssueHistoryServiceImpl implements IssueHistoryService {

    private final IssueHistoryRepository issueHistoryRepository;
    private final ModelMapper modelMapper;

    public IssueHistoryServiceImpl(IssueHistoryRepository issueHistoryRepository, ModelMapper modelMapper) {
        this.issueHistoryRepository = issueHistoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public IssueHistoryDTO save(IssueHistoryDTO issueHistoryDTO) {
        return null;
    }

    @Override
    public IssueHistoryDTO getById(Long id) {
        return null;
    }

    @Override
    public Page<IssueHistoryDTO> getAllPageable(Pageable pageable) {
        return null;
    }

    @Override
    public Boolean delete(IssueHistoryDTO issueHistoryDTO) {
        return null;
    }
}
