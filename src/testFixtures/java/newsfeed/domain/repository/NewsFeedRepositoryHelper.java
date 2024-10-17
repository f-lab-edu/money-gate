package newsfeed.domain.repository;

import account.domain.entity.UserStub;
import com.joonhee.moneygate.account.domain.entity.User;
import com.joonhee.moneygate.account.domain.repository.UserRepository;
import com.joonhee.moneygate.newsfeed.domain.entity.NewsFeed;
import com.joonhee.moneygate.newsfeed.domain.repository.NewsFeedRepository;
import newsfeed.domain.entity.NewsFeedStub;

import java.util.List;

public class NewsFeedRepositoryHelper {
    private final NewsFeedRepository newsFeedRepository;
    private final UserRepository mentorRepository;

    public NewsFeedRepositoryHelper(
        NewsFeedRepository newsFeedRepository,
        UserRepository mentorRepository
    ) {
        this.newsFeedRepository = newsFeedRepository;
        this.mentorRepository = mentorRepository;
    }

    public List<NewsFeed> createDummyPublicNewsFeeds() {
        User mentor = mentorRepository.save(UserStub.createDummyMentor());
        NewsFeed newsFeed = NewsFeedStub.createDummyPublicNewsFeed(mentor.getId());
        NewsFeed newsFeed1 = newsFeedRepository.save(newsFeed);
        NewsFeed newsFeed2 = newsFeedRepository.save(newsFeed);
        return List.of(newsFeed1, newsFeed2);
    }

    public NewsFeed createDummyPublicNewsFeed() {
        User mentor = mentorRepository.save(UserStub.createDummyMentor());
        NewsFeed newsFeed = NewsFeedStub.createDummyPublicNewsFeed(mentor.getId());
        return newsFeedRepository.save(newsFeed);
    }

    public NewsFeed createDummyDraftNewsFeed() {
        User mentor = mentorRepository.save(UserStub.createDummyMentor());
        NewsFeed newsFeed = NewsFeedStub.createDummyDraftNewsFeed(mentor.getId());
        return newsFeedRepository.save(newsFeed);
    }
}
