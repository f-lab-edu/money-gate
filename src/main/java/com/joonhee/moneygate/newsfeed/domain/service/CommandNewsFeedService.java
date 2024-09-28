package com.joonhee.moneygate.newsfeed.domain.service;

import com.joonhee.moneygate.mentor.domain.entity.Mentor;
import com.joonhee.moneygate.mentor.domain.repository.MentorRepository;
import com.joonhee.moneygate.newsfeed.domain.entity.NewsFeed;
import com.joonhee.moneygate.newsfeed.domain.repository.NewsFeedRepository;

import java.util.UUID;

public class CommandNewsFeedService {

    MentorRepository mentorRepository;
    NewsFeedRepository newsFeedRepository;

    public CommandNewsFeedService(
        MentorRepository mentorRepository,
        NewsFeedRepository newsFeedRepository
    ) {
        this.mentorRepository = mentorRepository;
        this.newsFeedRepository = newsFeedRepository;
    }

    public NewsFeed createNewsFeed(Long mentorId, String body) {
        Mentor mentor = mentorRepository.findById(mentorId);
        return newsFeedRepository.save(new NewsFeed(mentor, body));
    }

    public NewsFeed deleteNewsFeed(UUID newsFeedKey) {
        return newsFeedRepository.delete(newsFeedKey);
    }

    public NewsFeed updateNewsFeed(UUID newsFeedKey, String body) {
        return newsFeedRepository.update(newsFeedKey, body);
    }
}
