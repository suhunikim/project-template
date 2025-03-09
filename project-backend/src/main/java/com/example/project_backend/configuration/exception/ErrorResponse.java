package com.example.project_backend.configuration.exception;

import com.example.project_backend.common.code.ErrorCode;
import lombok.*;

import java.time.LocalDateTime;

/**
 * 📌 ErrorResponse: 예외 발생 시 클라이언트에게 응답할 데이터 형식 정의
 * - status: HTTP 상태 코드
 * - message: 예외 메시지
 * - timestamp: 에러 발생 시간
 * - @Builder 사용 가능하도록 기본 생성자(@NoArgsConstructor) 추가
 * - 모든 필드를 포함하는 생성자(@AllArgsConstructor) 추가
 */

@Getter
@Builder
@AllArgsConstructor
public class ErrorResponse {
    private final int status;
    private final String message;
    private final LocalDateTime timestamp;

    /**
     * ✅ ErrorCode 기반으로 ErrorResponse 객체 생성
     */
    public static ErrorResponse of(ErrorCode errorCode) {
        return ErrorResponse.builder()
                .status(errorCode.getStatus().value())
                .message(errorCode.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }
}