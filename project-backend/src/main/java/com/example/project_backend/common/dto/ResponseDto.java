package com.example.project_backend.common.dto;

import com.example.project_backend.common.code.ErrorCode;
import com.example.project_backend.configuration.exception.ErrorResponse;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseDto<T> {
    private boolean success; // 성공 여부
    private String message;  // 응답 메시지
    private T data;          // 응답 데이터 (제네릭 타입)
    private ErrorResponse error; // 실패 시 에러 정보 (선택적)

    /**
     * 성공 응답을 생성하는 팩토리 메서드입니다.
     *
     * @param message 응답 메시지
     * @param data    응답 데이터
     * @param <T>     응답 데이터의 타입
     * @return 성공 응답 객체
     */
    public static <T> ResponseDto<T> success(String message, T data) {
        return new ResponseDto<>(true, message, data, null);
    }

    /**
     * 실패 응답을 생성하는 팩토리 메서드입니다. (ErrorResponse 객체 사용)
     *
     * @param error ErrorResponse 객체
     * @param <T>   응답 데이터의 타입 (실패 시에는 null)
     * @return 실패 응답 객체
     */
    public static <T> ResponseDto<T> fail(ErrorResponse error) {
        return new ResponseDto<>(false, null, null, error);
    }

    /**
     * 실패 응답을 생성하는 팩토리 메서드입니다. (ErrorCode 사용)
     *
     * @param errorCode ErrorCode enum 값
     * @param <T>       응답 데이터의 타입 (실패 시에는 null)
     * @return 실패 응답 객체
     */
    public static <T> ResponseDto<T> fail(ErrorCode errorCode) {
        return new ResponseDto<>(false, errorCode.getMessage(), null, ErrorResponse.of(errorCode));
    }
}
