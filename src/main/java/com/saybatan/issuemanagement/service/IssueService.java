package com.saybatan.issuemanagement.service;

import com.saybatan.issuemanagement.dto.IssueDTO;
import com.saybatan.issuemanagement.entity.Issue;
import com.saybatan.issuemanagement.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IssueService {

    IssueDTO save(IssueDTO issueDTO);

    IssueDTO getById(Long id);

    TPage<IssueDTO> getAllPageable(Pageable pageable);

    Boolean delete(IssueDTO IssueDTO);

    IssueDTO update(Long id, IssueDTO issueDTO);

}
