package com.saybatan.issuemanagement.dto;

import com.saybatan.issuemanagement.entity.IssueStatus;

import java.util.Date;

public class IssueDTO {

    private Long id;
    private String description;
    private String details;
    private Date date;
    private IssueStatus issueStatus;
    private UserDTO assignee;
    private ProjectDTO project;
}
