package com.joonhee.moneygate.newsfeed.domain.service;

import com.joonhee.moneygate.account.domain.repository.MentorRepository;
import com.joonhee.moneygate.newsfeed.domain.entity.NewsFeed;
import com.joonhee.moneygate.newsfeed.domain.repository.NewsFeedRepository;
import com.joonhee.moneygate.newsfeed.dto.NewsFeedDetail;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class QueryNewsFeedService {
    private final NewsFeedRepository newsFeedRepository;
    private final MentorRepository mentorRepository;

    public QueryNewsFeedService(NewsFeedRepository newsFeedRepository, MentorRepository mentorRepository) {
        this.newsFeedRepository = newsFeedRepository;
        this.mentorRepository = mentorRepository;
    }

    public List<NewsFeedDetail> findAllPublic() {
        return newsFeedRepository.findAllPublic().stream().map(newsFeed ->
                NewsFeedDetail.of(newsFeed, mentorRepository.findById(newsFeed.getMentorId()).getEmail())
            )
            .collect(Collectors.toList());
    }

    public List<NewsFeedDetail> findAll() {
        return newsFeedRepository.findAll().stream().map(newsFeed ->
                NewsFeedDetail.of(newsFeed, mentorRepository.findById(newsFeed.getMentorId()).getEmail()))
            .collect(Collectors.toList());
    }

    public NewsFeed getNewsFeed(UUID key) {
        return newsFeedRepository.findByKey(key);
    }
}
