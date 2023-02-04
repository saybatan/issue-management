package com.saybatan.issuemanagement.dto;

import com.saybatan.issuemanagement.entity.IssueStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "Issue Data Transfer Object")
public class IssueDTO {

    @ApiModelProperty(value = "Issue ID")
    private Long id;
    @ApiModelProperty(value = "Description of Issue")
    private String description;
    @ApiModelProperty(value = "Details of Issue")
    private String details;
    @ApiModelProperty(value = "Date of Issue")
    private Date date;
    @ApiModelProperty(value = "Status of Issue")
    private IssueStatus issueStatus;
    @ApiModelProperty(value = "Assignee of Issue")
    private UserDTO assignee;
    @ApiModelProperty(value = "Project of Issue")
    private ProjectDTO project;
}
