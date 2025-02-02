package com.service.userservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.*;

@Entity
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "users")
public class UserInfo {




        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        Long id;


        @JsonProperty("user_id")
        @NonNull
        private String userId;
        @JsonProperty("first_name")
        @NonNull
        private String firstName;

        @JsonProperty("last_name")
        @NonNull
        private String lastName;

        @JsonProperty("phone_number")
        @NonNull
        private Long phoneNumber;

        @JsonProperty("email")
        @NonNull
        private String  email;

        @JsonProperty("profile_pic")

        private String profilePic;
    }


