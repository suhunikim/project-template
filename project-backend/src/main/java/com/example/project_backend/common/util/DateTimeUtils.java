package com.example.project_backend.common.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 날짜/시간 관련 유틸리티 클래스입니다.
 */
public class DateTimeUtils {

    /**
     * 기본 날짜/시간 포맷터 (yyyy-MM-dd HH:mm:ss)
     */
    public static final DateTimeFormatter DEFAULT_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * LocalDateTime 객체를 기본 포맷(yyyy-MM-dd HH:mm:ss)으로 포맷팅합니다.
     *
     * @param dateTime 포맷팅할 LocalDateTime 객체
     * @return 포맷팅된 문자열
     */
    public static String format(LocalDateTime dateTime) {
        return dateTime.format(DEFAULT_FORMATTER);
    }
}
