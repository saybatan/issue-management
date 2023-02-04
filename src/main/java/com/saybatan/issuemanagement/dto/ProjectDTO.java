package com.saybatan.issuemanagement.dto;

import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Project Data Transfer Object")
public class ProjectDTO {

    @ApiModelProperty(value = "Project ID")
    private Long id;
    @NotNull
    @ApiModelProperty(required = true, value = "Name of Project")
    private String projectName;
    @NotNull
    @ApiModelProperty(required = true, value = "Code of Project")
    private String projectCode;
}
