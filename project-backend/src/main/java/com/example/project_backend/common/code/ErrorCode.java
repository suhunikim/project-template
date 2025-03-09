package com.example.project_backend.common.code;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * 📌 ErrorCode: 애플리케이션에서 사용될 에러 코드 정의
 * - 각 에러 코드에 대해 HTTP 상태 코드와 메시지를 함께 관리
 */
@Getter
public enum ErrorCode {
    INVALID_INPUT(HttpStatus.BAD_REQUEST, "잘못된 입력값 입니다."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 사용자를 찾을 수 없습니다."),
    DUPLICATE_EMAIL(HttpStatus.CONFLICT, "이미 사용 중인 이메일 입니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부 오류가 발생했습니다.");

    private final HttpStatus status; // HTTP 상태 코드
    private final String message;    // 에러 메시지

    ErrorCode(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
