package com.saybatan.issuemanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDTO {

    @NotNull
    private String username;
    private String nameSurname;
    @Email
    private String email;
    @Size(message = "test", min = 4)
    private String password;
}
