package com.duy.BackendDoAn.responses;

import com.duy.BackendDoAn.models.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("email")
    private String email;

    @JsonProperty("avatar")
    private String avatar;

    @JsonProperty("address")
    private String address;

    @JsonProperty("country")
    private String country;

    @JsonProperty("date_of_birth")
    private String dateOfBirth;

    @JsonProperty("active")
    private boolean active;

    @JsonProperty("role")
    private String role;

    public static UserResponse fromUser(User user){
        return UserResponse.builder().id(user.getId())
                .name(user.getName())
                .firstName(user.getFirst_name())
                .lastName(user.getLast_name())
                .phoneNumber(user.getPhone_number())
                .email(user.getEmail())
                .avatar(user.getAvatar())
                .address(user.getAddress())
                .country(user.getCountry())
                .dateOfBirth(formatDateOfBirth(user.getDate_of_birth()))
                .active(user.isActive())
                .role(user.getRole())
                .build();
    }

    private static String formatDateOfBirth(LocalDate dateOfBirth) {
        return (dateOfBirth != null) ? dateOfBirth.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) : null;
    }
}
