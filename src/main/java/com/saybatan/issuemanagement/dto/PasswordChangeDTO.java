package com.saybatan.issuemanagement.dto;

import lombok.Data;

@Data
public class PasswordChangeDTO {
    private String oldPassword;
    private String newPassword;
    private String newPasswordAgain;

}
