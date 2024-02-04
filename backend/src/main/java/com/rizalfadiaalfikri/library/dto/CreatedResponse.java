package com.rizalfadiaalfikri.library.dto;

import com.rizalfadiaalfikri.library.entity.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreatedResponse {
    private String status;
    private String message;
    private List data;
}
