package com.rizalfadiaalfikri.library.dto;

import org.hibernate.mapping.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HttpResponse {

    private String status;
    private String message;

}
