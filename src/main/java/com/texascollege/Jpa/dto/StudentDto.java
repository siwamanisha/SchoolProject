package com.texascollege.Jpa.dto;

import jakarta.validation.constraints.NotEmpty;

public record StudentDto (
        @NotEmpty
        String firstame,
        @NotEmpty
        String lastname,
        String email,
       Integer SchoolId
){

}
