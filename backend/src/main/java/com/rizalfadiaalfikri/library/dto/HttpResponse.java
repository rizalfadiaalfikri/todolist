package com.rizalfadiaalfikri.library.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HttpResponse {

    private String status;
    private String message;
    private List data;

}
