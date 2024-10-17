package com.joonhee.moneygate.newsfeed.domain.entity;

import com.joonhee.moneygate.newsfeed.domain.dto.LikesDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class Likes {
    private List<Long> userIds = new ArrayList<>();

    public Likes(List<Long> userIds) {
        this.userIds = userIds;
    }

    public List<Long> addOrSubtract(Like like) {
        Long userId = like.getUserId();
        if (this.userIds.contains(userId) && like.getStatus() == LikeStatus.DELETED) {
            this.userIds.remove(userId);
            return List.copyOf(this.userIds);
        }

        this.userIds.add(userId);
        return List.copyOf(this.userIds);
    }

    public LikesDto toDto() {
        return new LikesDto(List.copyOf(this.userIds));
    }
}
