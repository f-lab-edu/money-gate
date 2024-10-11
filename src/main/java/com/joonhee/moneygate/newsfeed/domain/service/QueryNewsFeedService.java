package com.joonhee.moneygate.newsfeed.domain.service;

import com.joonhee.moneygate.account.domain.repository.UserRepository;
import com.joonhee.moneygate.common.SliceContent;
import com.joonhee.moneygate.newsfeed.domain.entity.NewsFeed;
import com.joonhee.moneygate.newsfeed.domain.repository.NewsFeedRepository;
import com.joonhee.moneygate.newsfeed.dto.NewsFeedDetail;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class QueryNewsFeedService {
    private final NewsFeedRepository newsFeedRepository;
    private final UserRepository mentorRepository;

    public QueryNewsFeedService(NewsFeedRepository newsFeedRepository, UserRepository mentorRepository) {
        this.newsFeedRepository = newsFeedRepository;
        this.mentorRepository = mentorRepository;
    }

    public SliceContent<NewsFeedDetail> findAllPublicSlice(int size, String nextCursor) {
        SliceContent<NewsFeed> newsFeedContent = newsFeedRepository.findAllPublicSlice(size, nextCursor);
        List<NewsFeedDetail> newsFeedDetails = getNewsFeedDetails(newsFeedContent.content());
        return new SliceContent<>(
            newsFeedDetails,
            newsFeedContent.nextCursor()
        );
    }

    private List<NewsFeedDetail> getNewsFeedDetails(List<NewsFeed> newsFeeds) {
        List<Long> mentorIds = getMentorIds(newsFeeds);
        Map<Long, String> mentorIdToEmail = getMentorEmails(mentorIds);
        return newsFeeds.stream().map(newsFeed -> NewsFeedDetail.of(newsFeed, mentorIdToEmail.get(newsFeed.getMentorId()))).collect(Collectors.toList());
    }

    private List<Long> getMentorIds(List<NewsFeed> newsFeeds) {
        return newsFeeds.stream().map(newsFeed -> newsFeed.getMentorId()).collect(Collectors.toList());
    }

    private Map<Long, String> getMentorEmails(List<Long> mentorIds) {
        return mentorRepository.findByIds(mentorIds).stream().collect(Collectors.toMap(mentor -> mentor.getId(), mentor -> mentor.getEmail()));
    }

    public NewsFeed getNewsFeed(String key) {
        return newsFeedRepository.findByKey(key);
    }
}
