package com.saybatan.issuemanagement.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
@Getter
@Setter
@Data
public class UserSaveDTO {
    @Email
    private String email;
    private String nameSurname;
    private String password;
}
