package com.skytech.estore.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ApiResponse {
    private  boolean success;
    private String message;
}

//public String getTimeStamp() {
//    return LocalDateTime.now().toString();
//}
//}