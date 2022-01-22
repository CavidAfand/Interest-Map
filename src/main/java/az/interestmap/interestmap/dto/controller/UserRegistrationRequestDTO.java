package az.interestmap.interestmap.dto.controller;

import az.interestmap.interestmap.constant.UserType;
import az.interestmap.interestmap.entity.User;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UserRegistrationRequestDTO {

    @NotNull
    @NotBlank
    private String username;

    @NotNull
    @NotBlank
    private String password;

    @NotBlank
    @NotNull
    private String name;

    @NotNull
    private UserType type;

}
