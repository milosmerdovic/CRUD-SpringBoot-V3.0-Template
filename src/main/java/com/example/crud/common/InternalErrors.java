package com.example.crud.common;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum InternalErrors {

    PAYLOAD_VALIDATION_ERROR(9000),
    GENERIC_INTERNAL_ERROR(9001),
    RESOURCE_NOT_FOUND(9002),
    VALIDATION_ERROR(9003),
    UNPROCESSABLE_ENTITY(9004),
    INVALID_STATE(9005),
    CREDENTIALS_NOT_RECOGNIZED(9006),
    NOT_SUFFICIENT_PERMISSIONS(9007),
    DUPLICATE_KEY(9008);

    private int code;

    public int code() {
        return this.code;
    }
}
