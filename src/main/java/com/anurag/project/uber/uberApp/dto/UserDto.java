package com.anurag.project.uber.uberApp.dto;

import com.anurag.project.uber.uberApp.entities.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private  String name;
    private Set<Role> roles;
}
