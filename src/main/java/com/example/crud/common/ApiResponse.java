package com.example.crud.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> implements Serializable {

    private static final long serialVersionUID = 186504082724804396L;

    private int operationResultCode;
    private String operationResultDescription;
    private int returnedObjectsNumber;
    private long totalObjectsNumber;
    private T payload;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ApiError error;

}
