package com.canteen.admin.controller.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
public class AdminUserParam {

    @NotEmpty(message = "Username is empty!")
    @Size(min = 6, message = "Username's size should be bigger than 6")
    private String username;

    @NotEmpty(message = "Password is empty!")
    @Size(min = 6, message = "Password's size should be bigger than 6")
    private String password;
}
