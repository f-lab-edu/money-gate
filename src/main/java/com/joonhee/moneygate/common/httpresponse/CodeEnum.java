package com.joonhee.moneygate.common.httpresponse;

public enum CodeEnum {
    SUCCESS("실행 성공"),
    FAIL("실행 실패");

    private final String code;

    CodeEnum(String code) {
        this.code = code;
    }
}
