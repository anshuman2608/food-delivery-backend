package com.example.eatWell.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DriverCreateRequest {

    @NotNull(message = "name cannot be null")
    @NotEmpty(message = "name number cannot be empty")
    private String name;

    @NotNull(message = "phone cannot be null")
    @NotEmpty(message = "phone number cannot be empty")
    private String phoneNumber;

    @NotNull(message = "location cannot be null")
    @NotEmpty(message = "location cannot be empty")
    private String location;
}
