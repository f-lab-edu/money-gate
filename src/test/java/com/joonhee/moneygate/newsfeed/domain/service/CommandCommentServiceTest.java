package com.joonhee.moneygate.newsfeed.domain.service;

import account.domain.entity.UserBuilder;
import com.joonhee.moneygate.account.domain.entity.User;
import com.joonhee.moneygate.account.domain.repository.UserRepository;
import com.joonhee.moneygate.account.repository.MemoryUserRepository;
import com.joonhee.moneygate.newsfeed.domain.entity.Comment;
import com.joonhee.moneygate.newsfeed.domain.entity.CommentStatus;
import com.joonhee.moneygate.newsfeed.domain.entity.NewsFeed;
import com.joonhee.moneygate.newsfeed.domain.repository.CommentRepository;
import com.joonhee.moneygate.newsfeed.domain.repository.NewsFeedRepository;
import com.joonhee.moneygate.newsfeed.exception.NotFoundNewsFeedException;
import com.joonhee.moneygate.newsfeed.repository.MemoryCommentRepository;
import com.joonhee.moneygate.newsfeed.repository.MemoryNewsFeedRepository;
import com.joonhee.moneygate.validator.NewsFeedValidator;
import newsfeed.domain.entity.NewsFeedBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CommandCommentServiceTest {
    private UserRepository userRepository;
    private CommentRepository commentRepository;
    private NewsFeedRepository newsFeedRepository;
    private NewsFeedValidator newsFeedValidator;
    private CommandCommentService commandCommentService;

    @BeforeEach
    void setUp() {
        userRepository = new MemoryUserRepository();
        commentRepository = new MemoryCommentRepository();
        newsFeedRepository = new MemoryNewsFeedRepository();
        newsFeedValidator = new NewsFeedValidator(newsFeedRepository);
        commandCommentService = new CommandCommentService(commentRepository, newsFeedValidator);
    }


    @Test
    @DisplayName("유저가 게시된 뉴스피드에 공개 댓글을 생성")
    void createPublicCommentOnPublicNewsFeed() {
        // Arrange
        User mentor = UserBuilder.createDummyMentor();
        mentor = userRepository.save(mentor);
        User user = UserBuilder.createDummyUser();
        user = userRepository.save(user);
        NewsFeed newsFeed = NewsFeedBuilder.createDummyPublicNewsFeed(mentor.getId());
        newsFeed = newsFeedRepository.save(newsFeed);

        // Action
        Comment comment = commandCommentService.createCommentByPublic(user.getId(), newsFeed.getKey(), "댓글 내용");

        // Assert
        Comment savedComment = commentRepository.findById(comment.getId());
        assertThat(savedComment.getStatus()).isEqualTo(CommentStatus.PUBLIC);
    }

    @Test
    @DisplayName("유저가 게시된 뉴스피드에 작성중 댓글 생성")
    void createDraftCommentOnPublicNewsFeed() {
        // Arrange
        User mentor = UserBuilder.createDummyMentor();
        mentor = userRepository.save(mentor);
        User user = UserBuilder.createDummyUser();
        user = userRepository.save(user);
        NewsFeed newsFeed = NewsFeedBuilder.createDummyPublicNewsFeed(mentor.getId());
        newsFeed = newsFeedRepository.save(newsFeed);

        // Action
        Comment comment = commandCommentService.createCommentByDraft(user.getId(), newsFeed.getKey(), "댓글 내용");

        // Assert
        Comment savedComment = commentRepository.findById(comment.getId());
        assertThat(savedComment.getStatus()).isEqualTo(CommentStatus.DRAFT);
    }

    @Test
    @DisplayName("유저가 게시된 뉴스피드에 생성한 댓글 수정")
    void updatePublicCommentOnPublicNewsFeed() {
        // Arrange
        User mentor = UserBuilder.createDummyMentor();
        mentor = userRepository.save(mentor);
        User user = UserBuilder.createDummyUser();
        user = userRepository.save(user);
        NewsFeed newsFeed = NewsFeedBuilder.createDummyPublicNewsFeed(mentor.getId());
        newsFeed = newsFeedRepository.save(newsFeed);
        String CREATED_BODY = "생성된 댓글 내용";
        String UPDATED_BODY = "수정된 댓글 내용";
        Comment comment = Comment.createCommentByPublic(user.getId(), newsFeed.getId(), CREATED_BODY);
        comment = commentRepository.save(comment);

        // Action
        Comment updatedComment = commandCommentService.update(comment.getId(), UPDATED_BODY);

        // Assert
        Comment savedComment = commentRepository.findById(updatedComment.getId());
        assertThat(savedComment.getStatus()).isEqualTo(CommentStatus.PUBLIC);
        assertThat(savedComment.getBody()).isEqualTo(UPDATED_BODY);
    }

    @Test
    @DisplayName("유저가 게시된 뉴스피드에 생성한 댓글 삭제")
    void deletePublicCommentOnPublicNewsFeed() {
        // Arrange
        User mentor = UserBuilder.createDummyMentor();
        mentor = userRepository.save(mentor);
        User user = UserBuilder.createDummyUser();
        user = userRepository.save(user);
        NewsFeed newsFeed = NewsFeedBuilder.createDummyPublicNewsFeed(mentor.getId());
        newsFeed = newsFeedRepository.save(newsFeed);
        String CREATED_BODY = "생성된 댓글 내용";
        Comment comment = Comment.createCommentByPublic(user.getId(), newsFeed.getId(), CREATED_BODY);
        comment = commentRepository.save(comment);

        // Action
        Comment deleteComment = commandCommentService.delete(comment.getId());

        // Assert
        Comment deletedComment = commentRepository.findById(deleteComment.getId());
        assertThat(deletedComment.getStatus()).isEqualTo(CommentStatus.DELETED);
    }

    @Test
    @DisplayName("존재하지 않는 게시글에 댓글 생성 시 예외 발생")
    void createCommentOnNonExistNewsFeed() {
        // Arrange
        User user = UserBuilder.createDummyUser();
        user = userRepository.save(user);
        String NON_EXIST_KEY = UUID.randomUUID().toString();

        // Action & Assert
        User finalUser = user;
        assertThatThrownBy(() -> commandCommentService.createCommentByPublic(finalUser.getId(), NON_EXIST_KEY, "댓글 내용"))
            .isInstanceOf(NotFoundNewsFeedException.class);
    }
}