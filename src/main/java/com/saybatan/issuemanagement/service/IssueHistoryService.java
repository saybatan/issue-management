package com.saybatan.issuemanagement.service;

import com.saybatan.issuemanagement.dto.IssueHistoryDTO;
import com.saybatan.issuemanagement.entity.IssueHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IssueHistoryService {

    IssueHistoryDTO save(IssueHistoryDTO issueHistoryDTO);
    IssueHistoryDTO getById(Long id);
    Page<IssueHistoryDTO> getAllPageable(Pageable pageable);
    Boolean delete(IssueHistoryDTO issueHistoryDTO);

}
