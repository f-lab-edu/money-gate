package com.joonhee.moneygate.newsfeed.domain.service;

import com.joonhee.moneygate.account.domain.entity.Mentor;
import com.joonhee.moneygate.account.domain.repository.MentorRepository;
import com.joonhee.moneygate.newsfeed.domain.entity.ContentStatus;
import com.joonhee.moneygate.newsfeed.domain.entity.NewsFeed;
import com.joonhee.moneygate.newsfeed.domain.repository.NewsFeedRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

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
        Mentor mentor = mentorRepository.findById(mentorId);
        return newsFeedRepository.save(new NewsFeed(mentor.getId(), body, ContentStatus.PUBLIC));
    }

    public NewsFeed createNewsFeedByDraft(Long mentorId, String body) {
        Mentor mentor = mentorRepository.findById(mentorId);
        return newsFeedRepository.save(new NewsFeed(mentor.getId(), body, ContentStatus.DRAFT));
    }

    public NewsFeed deleteNewsFeed(UUID newsFeedKey) {
        NewsFeed newsFeed = newsFeedRepository.findByKey(newsFeedKey);
        if (newsFeed == null) {
            throw new IllegalArgumentException("NewsFeed not found");
        }
        newsFeed.delete();
        return newsFeedRepository.save(newsFeed);
    }

    public NewsFeed updateNewsFeed(UUID newsFeedKey, String body) {
        NewsFeed newsFeed = newsFeedRepository.findByKey(newsFeedKey);
        if (newsFeed == null) {
            throw new IllegalArgumentException("NewsFeed not found");
        }
        newsFeed.updateBody(body);
        return newsFeedRepository.save(newsFeed);
    }
}
