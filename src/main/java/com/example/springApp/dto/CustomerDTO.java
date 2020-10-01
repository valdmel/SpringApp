package com.example.springApp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    @NotBlank(message = "First name cannot be empty!")
    private String firstName;

    @NotBlank(message = "Last name cannot be empty!")
    private String lastName;
}
