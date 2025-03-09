package com.example.project_backend.configuration.exception;

import com.example.project_backend.common.code.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * 📌 CustomException: 서비스에서 발생하는 예외를 처리하는 기본 클래스
 * - ErrorCode 를 사용하여 일관된 예외 처리를 할 수 있도록 설계
 */
@Getter
public class CustomException extends RuntimeException {

    private final ErrorCode errorCode;

    public CustomException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public HttpStatus getStatus() {
        return errorCode.getStatus();
    }
}
