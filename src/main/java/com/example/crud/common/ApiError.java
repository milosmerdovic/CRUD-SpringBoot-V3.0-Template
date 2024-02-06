package com.example.crud.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ApiError {

    private InternalErrors error;
    @Builder.Default
    private Date timestamp = new Date();
    private String path;
    private List<ErrorDetail> details;

}
