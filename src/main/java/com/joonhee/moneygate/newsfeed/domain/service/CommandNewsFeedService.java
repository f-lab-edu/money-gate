package com.joonhee.moneygate.newsfeed.domain.service;

import com.joonhee.moneygate.account.domain.entity.User;
import com.joonhee.moneygate.account.domain.repository.MentorRepository;
import com.joonhee.moneygate.newsfeed.domain.entity.ContentOpenStatus;
import com.joonhee.moneygate.newsfeed.domain.entity.NewsFeed;
import com.joonhee.moneygate.newsfeed.domain.repository.NewsFeedRepository;
import com.joonhee.moneygate.validator.MentorValidator;
import org.springframework.stereotype.Service;

@Service
public class CommandNewsFeedService {

    private final MentorRepository mentorRepository;
    private final NewsFeedRepository newsFeedRepository;
    private final MentorValidator mentorValidator;

    public CommandNewsFeedService(
        MentorRepository mentorRepository,
        NewsFeedRepository newsFeedRepository,
        MentorValidator mentorValidator
    ) {
        this.mentorRepository = mentorRepository;
        this.newsFeedRepository = newsFeedRepository;
        this.mentorValidator = mentorValidator;
    }

    public NewsFeed createNewsFeedByPublic(Long mentorId, String body) {
        mentorValidator.validateMentor(mentorId);
        return newsFeedRepository.save(NewsFeed.createNewsFeedByPublic(mentorId, body));
    }

    public NewsFeed createNewsFeedByDraft(Long mentorId, String body) {
        mentorValidator.validateMentor(mentorId);
        return newsFeedRepository.save(NewsFeed.createNewsFeedByDraft(mentorId, body));
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
