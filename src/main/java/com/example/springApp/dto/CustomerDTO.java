package com.example.springApp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("first_name")
    private String firstName;

    @NotBlank(message = "Last name cannot be empty!")
    @JsonProperty("last_name")
    private String lastName;
}
