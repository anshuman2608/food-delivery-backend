package com.example.eatWell.dto.request;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressCreateRequest {

    @NotNull(message = "phone number cannot be null")
    @NotEmpty(message = "phone number cannot be empty")
    private String phoneNumber;

    @NotNull(message = "address line1 cannot be null")
    @NotEmpty(message = "address line1 cannot be empty")
    private String addressLine1;

    private String addressLine2;

    @NotNull(message = "city cannot be null")
    @NotEmpty(message = "city number cannot be empty")
    private String city;

    @NotNull(message = "state cannot be null")
    @NotEmpty(message = "state number cannot be empty")
    private String state;

    @NotNull(message = "country cannot be null")
    @NotEmpty(message = "country cannot be empty")
    private String country;


    @Size(max=6, min=6, message = "pincode must be of 6 digit")
    private String pincode;
}
