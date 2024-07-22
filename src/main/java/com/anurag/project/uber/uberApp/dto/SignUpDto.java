package com.anurag.project.uber.uberApp.dto;

import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpDto {

    private  String name;
    private  String email;
    private String password;

}

