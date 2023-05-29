package com.skytech.e_store.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;


@AllArgsConstructor
@Data
public class ApiResponse {
    private final boolean success;
    private final String message;

    public String getTimestamp() {
        return LocalDateTime.now().toString();
    }
}