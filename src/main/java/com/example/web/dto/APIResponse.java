package com.example.web.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIResponse<T> {
    int recordCount;
    T response;
}
