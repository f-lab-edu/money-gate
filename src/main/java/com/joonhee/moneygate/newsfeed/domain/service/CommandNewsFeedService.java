package com.joonhee.moneygate.newsfeed.domain.service;

import com.joonhee.moneygate.account.domain.entity.User;
import com.joonhee.moneygate.account.domain.repository.MentorRepository;
import com.joonhee.moneygate.newsfeed.domain.entity.ContentOpenStatus;
import com.joonhee.moneygate.newsfeed.domain.entity.NewsFeed;
import com.joonhee.moneygate.newsfeed.domain.repository.NewsFeedRepository;
import org.springframework.stereotype.Service;

@Service
public class CommandNewsFeedService {

    private final MentorRepository mentorRepository;
    private final NewsFeedRepository newsFeedRepository;

    public CommandNewsFeedService(
        MentorRepository mentorRepository,
        NewsFeedRepository newsFeedRepository
    ) {
        this.mentorRepository = mentorRepository;
        this.newsFeedRepository = newsFeedRepository;
    }

    public NewsFeed createNewsFeedByPublic(Long mentorId, String body) {
        User mentor = mentorRepository.findById(mentorId);
        return newsFeedRepository.save(new NewsFeed(mentor.getId(), body, ContentOpenStatus.PUBLIC));
    }

    public NewsFeed createNewsFeedByDraft(Long mentorId, String body) {
        User mentor = mentorRepository.findById(mentorId);
        return newsFeedRepository.save(new NewsFeed(mentor.getId(), body, ContentOpenStatus.DRAFT));
    }

    public NewsFeed deleteNewsFeed(String newsFeedKey) {
        NewsFeed newsFeed = newsFeedRepository.findByKey(newsFeedKey);
        newsFeed.delete();
        return newsFeedRepository.save(newsFeed);
    }

    public NewsFeed updateNewsFeed(String newsFeedKey, String body) {
        NewsFeed newsFeed = newsFeedRepository.findByKey(newsFeedKey);
        newsFeed.updateBody(body);
        return newsFeedRepository.save(newsFeed);
    }
}
