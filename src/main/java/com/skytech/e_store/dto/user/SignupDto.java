package com.skytech.e_store.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupDto {
        private String firstName;
        private String lastName;
        private String email;
        private String password;
}
