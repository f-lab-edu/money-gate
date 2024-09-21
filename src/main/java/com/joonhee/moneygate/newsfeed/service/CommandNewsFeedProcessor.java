package com.joonhee.moneygate.newsfeed.service;

import com.joonhee.moneygate.mentor.domain.entity.Mentor;
import com.joonhee.moneygate.mentor.domain.repository.MentorRepository;
import com.joonhee.moneygate.mentor.domain.vo.MentorId;
import com.joonhee.moneygate.newsfeed.domain.entity.NewsFeed;
import com.joonhee.moneygate.newsfeed.domain.repository.NewsFeedRepository;
import com.joonhee.moneygate.newsfeed.domain.vo.NewsFeedId;
import com.joonhee.moneygate.newsfeed.usecase.CommandNewsFeedUseCase;

public class CommandNewsFeedProcessor implements CommandNewsFeedUseCase {

    MentorRepository mentorRepository;
    NewsFeedRepository newsFeedRepository;

    public CommandNewsFeedProcessor(
        MentorRepository mentorRepository,
        NewsFeedRepository newsFeedRepository
    ) {
        this.mentorRepository = mentorRepository;
        this.newsFeedRepository = newsFeedRepository;
    }

    @Override
    public NewsFeed createNewsFeed(MentorId id, String body) {
        Mentor mentor = mentorRepository.findById(id);
        return newsFeedRepository.save(new NewsFeed(mentor, body));
    }

    @Override
    public NewsFeed deleteNewsFeed(NewsFeedId id) {
        return newsFeedRepository.delete(id);
    }

    @Override
    public NewsFeed updateNewsFeed(NewsFeedId id, String body) {
        return newsFeedRepository.update(id, body);
    }
}
