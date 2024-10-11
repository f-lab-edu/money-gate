package com.joonhee.moneygate.newsfeed.repository;

import com.joonhee.moneygate.common.SliceContent;
import com.joonhee.moneygate.newsfeed.domain.entity.ContentOpenStatus;
import com.joonhee.moneygate.newsfeed.domain.entity.NewsFeed;
import com.joonhee.moneygate.newsfeed.domain.repository.NewsFeedRepository;
import com.joonhee.moneygate.newsfeed.exception.NotFoundNewsFeedException;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class MemoryNewsFeedRepository implements NewsFeedRepository {
    private final HashMap<String, NewsFeed> newsFeeds = new HashMap<>();

    @Override
    public NewsFeed save(NewsFeed newsFeed) {
        newsFeed = setAutoIncrementId(newsFeed);
        newsFeeds.put(newsFeed.getKey(), newsFeed);
        return newsFeed;
    }

    private NewsFeed setAutoIncrementId(NewsFeed newsFeed) {
        if (newsFeed.getId() == null) {
            NewsFeed newsFeedByBuilder = NewsFeed.builder()
                .id(getMaxId() + 1)
                .body(newsFeed.getBody())
                .key(newsFeed.getKey())
                .mentorId(newsFeed.getMentorId())
                .status(newsFeed.getStatus())
                .createdAt(newsFeed.getCreatedAt())
                .updatedAt(newsFeed.getUpdatedAt())
                .deletedAt(newsFeed.getDeletedAt())
                .build();

            return newsFeedByBuilder;
        }
        return newsFeed;
    }

    private Long getMaxId() {
        return newsFeeds.values().stream()
            .mapToLong(NewsFeed::getId)
            .max()
            .orElse(0);
    }

    @Override
    public NewsFeed findByKey(String newsFeedKey) {
        NewsFeed newsFeed = newsFeeds.get(newsFeedKey);
        if (newsFeed == null) {
            throw new NotFoundNewsFeedException(newsFeedKey.toString());
        }
        return newsFeed;
    }

    @Override
    public SliceContent<NewsFeed> findAllPublicSlice(int size, String nextCursor) {
        Long cursor = nextCursor != null ? Long.parseLong(nextCursor) : Long.MAX_VALUE;

        // id 기준으로 정렬된 목록을 가져옴
        List<NewsFeed> sortedFeeds = newsFeeds.values().stream()
            .filter(newsFeed -> newsFeed.getId() < cursor)  // nextCursor보다 작은 id만 가져옴
            .sorted(Comparator.comparing(NewsFeed::getId).reversed())  // 최신 순으로 정렬
            .limit(size)  // 요청한 크기만큼 가져옴
            .collect(Collectors.toList());

        // 다음 cursor 설정 (마지막 요소의 id)
        String newNextCursor = sortedFeeds.isEmpty() ? null : String.valueOf(sortedFeeds.get(sortedFeeds.size() - 1).getId());

        return new SliceContent<>(sortedFeeds, newNextCursor);
    }

    @Override
    public List<NewsFeed> findAll() {
        return List.copyOf(newsFeeds.values());
    }
}
