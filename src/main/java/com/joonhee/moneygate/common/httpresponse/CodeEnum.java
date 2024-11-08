package com.joonhee.moneygate.common.httpresponse;

public enum CodeEnum {
    SUCCESS("실행 성공"),
    FAIL("실행 실패"),
    UNAUTHORIZED_USER("권한 없음"),
    ;

    private final String description;

    CodeEnum(String description) {
        this.description = description;
    }
}
