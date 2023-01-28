package com.saybatan.issuemanagement.dto;

import com.saybatan.issuemanagement.entity.IssueStatus;
import lombok.Data;

import java.util.Date;

@Data
public class IssueDTO {

    private Long id;
    private String description;
    private String details;
    private Date date;
    private IssueStatus issueStatus;
    private UserDTO assignee;
    private ProjectDTO project;
}
