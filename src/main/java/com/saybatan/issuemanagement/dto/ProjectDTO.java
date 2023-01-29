package com.saybatan.issuemanagement.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {

    private Long id;
    @NotNull
    private String projectName;
    @NotNull
    private String projectCode;
}
