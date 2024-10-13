package com.joonhee.moneygate.newsfeed.application;

import com.joonhee.moneygate.common.SliceContent;
import com.joonhee.moneygate.newsfeed.domain.entity.ContentOpenStatus;
import com.joonhee.moneygate.newsfeed.domain.entity.NewsFeed;
import com.joonhee.moneygate.newsfeed.domain.repository.NewsFeedRepository;
import com.joonhee.moneygate.newsfeed.exception.NotFoundNewsFeedException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NewsFeedRepositoryImpl implements NewsFeedRepository {
    private final CrudNewsFeedRepository crudNewsFeedRepository;

    public NewsFeedRepositoryImpl(CrudNewsFeedRepository crudNewsFeedRepository) {
        this.crudNewsFeedRepository = crudNewsFeedRepository;
    }

    @Override
    public NewsFeed save(NewsFeed newsFeed) {
        return crudNewsFeedRepository.save(newsFeed);
    }

    @Override
    public NewsFeed findByKey(String newsFeedKey) {
        return crudNewsFeedRepository.findByKey(newsFeedKey).orElseThrow(() -> new NotFoundNewsFeedException(newsFeedKey.toString()));
    }

    @Override
    public SliceContent<NewsFeed> findAllPublicSlice(int size, String nextCursor) {
        List<NewsFeed> content;
        if (nextCursor == null) {
            content = crudNewsFeedRepository.findAllByStatusOrderIdDesc(ContentOpenStatus.PUBLIC.name(), size);
        } else {
            content = crudNewsFeedRepository.findAllByStatusOrderIdDesc(ContentOpenStatus.PUBLIC.name(), Long.parseLong(nextCursor), size);
        }

        String id = content.isEmpty() ? null : content.get(content.size() - 1).getId().toString();


        return new SliceContent<>(content, id);
    }

    @Override
    public List<NewsFeed> findAll() {
        Sort sort = Sort.by(Sort.Order.desc("createdAt"));
        return crudNewsFeedRepository.findAll(sort);
    }
}
