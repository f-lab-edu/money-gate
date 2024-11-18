package com.joonhee.moneygate.common.httpresponse;

public enum CodeEnum {
    RS_001("실행 성공"),
    FRS_001("실행 실패"),
    FRS_002("권한 없음"),
    FRS_003("데이터 없음"),
    ;

    private final String description;

    CodeEnum(String description) {
        this.description = description;
    }
}
