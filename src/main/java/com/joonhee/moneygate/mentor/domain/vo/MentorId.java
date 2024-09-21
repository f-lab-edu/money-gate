package com.joonhee.moneygate.mentor.domain.vo;

import java.util.UUID;

public class MentorId {
    private final UUID id;
    public MentorId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
