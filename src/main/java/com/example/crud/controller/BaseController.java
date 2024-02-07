package com.example.crud.controller;

import com.example.crud.common.ApiError;
import com.example.crud.common.ApiResponse;
import com.example.crud.dto.PageDto;
import com.example.crud.logging.BaseStopWatch;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;

import java.util.List;

public abstract class BaseController {
    protected StopWatch startWatch(final String id) {
        return new BaseStopWatch(id);
    }
    protected StopWatch startWatch(final Object... id) {
        return new BaseStopWatch(id);
    }
    protected String stopWatch(final StopWatch sw) {
        return sw.shortSummary();
    }
    protected <T> ResponseEntity<ApiResponse<T>> okResponse(final T payload, final String description){
        final ApiResponse<T> body = new ApiResponse<>();
        body.setOperationResultCode(HttpStatus.OK.value());
        body.setOperationResultDescription(description);
        body.setReturnedObjectsNumber(1);
        body.setTotalObjectsNumber(1);
        body.setPayload(payload);
        return new ResponseEntity<ApiResponse<T>>(body, HttpStatus.OK);
    }
    protected <T> ResponseEntity<ApiResponse<List<T>>> okResponse(final List<T> payload, final String description){
        final int size = payload != null ? payload.size() : 0;
        final ApiResponse<List<T>> body = new ApiResponse<>();
        body.setOperationResultCode(HttpStatus.OK.value());
        body.setOperationResultDescription(description);
        body.setReturnedObjectsNumber(size);
        body.setTotalObjectsNumber(size);
        body.setPayload(payload);
        return new ResponseEntity<ApiResponse<List<T>>>(body, HttpStatus.OK);
    }
    protected <T> ResponseEntity<ApiResponse<T[]>> okResponse(final T[] payload, final String description){
        final int size = payload != null ? payload.length : 0;
        final ApiResponse<T[]> body = new ApiResponse<>();
        body.setOperationResultCode(HttpStatus.OK.value());
        body.setOperationResultDescription(description);
        body.setReturnedObjectsNumber(size);
        body.setTotalObjectsNumber(size);
        body.setPayload(payload);
        return new ResponseEntity<ApiResponse<T[]>>(body, HttpStatus.OK);
    }
    protected <T> ResponseEntity<ApiResponse<List<T>>> okResponse(final Page<T> payload, final String description){
        final int size = payload.getContent() != null ? payload.getContent().size() : 0;
        final ApiResponse<List<T>> body = new ApiResponse<>();
        body.setOperationResultCode(HttpStatus.OK.value());
        body.setOperationResultDescription(description);
        body.setReturnedObjectsNumber(size);
        body.setTotalObjectsNumber(payload.getTotalElements());
        body.setPayload(payload.getContent());
        return new ResponseEntity<ApiResponse<List<T>>>(body, HttpStatus.OK);
    }
    protected <T> ResponseEntity<ApiResponse<List<T>>> okResponse(final PageDto<T> payload, final String description){
        final int size = payload.getContent() != null ? payload.getContent().size() : 0;
        final long totalSize = payload != null ? payload.getTotalElements() : 0;
        final ApiResponse<List<T>> body = new ApiResponse<>();
        body.setOperationResultCode(HttpStatus.OK.value());
        body.setOperationResultDescription(description);
        body.setReturnedObjectsNumber(size);
        body.setTotalObjectsNumber(totalSize);
        body.setPayload(payload != null ? payload.getContent() : null);
        return new ResponseEntity<ApiResponse<List<T>>>(body, HttpStatus.OK);
    }
    protected <T> ResponseEntity<ApiResponse<T>> koResponse(final ApiResponse<T> body, final HttpStatus status, final String description, final ApiError error){
        body.setOperationResultCode(status.value());
        body.setOperationResultDescription(description);
        body.setReturnedObjectsNumber(0);
        body.setTotalObjectsNumber(0);
        body.setPayload(null);
        body.setError(error);
        return new ResponseEntity<ApiResponse<T>>(body, status);
    }

    protected <T> ResponseEntity<ApiResponse<T>> koResponse(final ApiResponse<T> body, final HttpStatus status, final String description){
        return this.koResponse(body, status, description, null);
    }

    protected <T> ResponseEntity<ApiResponse<T>> koResponse(final ApiResponse<T> body, final Exception e){
            //TODO switch error and give description by exception
        return this.koResponse(body, HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred", null);
    }
}
