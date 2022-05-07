package com.gsd.fifa4.domain.board.repository;

import com.gsd.fifa4.domain.board.dto.PostCondition;
import com.gsd.fifa4.domain.board.dto.PostDTO;
import com.gsd.fifa4.domain.board.dto.QPostDTO;
import com.gsd.fifa4.domain.board.model.Board;
import com.gsd.fifa4.domain.board.model.QPost;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

/**
 * Created by Yohan lee
 * Created on 2021-03-22.
 **/

@Repository
@RequiredArgsConstructor
public class PostQueryRepository {

    private final JPAQueryFactory queryFactory;


    public Page<PostDTO> findPosts(Board board, PostCondition condition, Pageable pageable) {

        QPost post = QPost.post;
        QueryResults<PostDTO> queryResults = queryFactory
                .select(
                        new QPostDTO(
                                post.id,
                                post.title,
                                post.creator,
                                post.notice,
                                post.createdDate,
                                post.updatedDate
                        )
                )
                .from(post)
                .where(
                        post.del.isFalse(),
                        post.board.eq(board),
                        likeCreator(post, condition),
                        likeTitle(post, condition),
                        likeAll(post, condition)
                )
                .orderBy(post.createdDate.desc())
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .fetchResults();

        return new PageImpl<>(queryResults.getResults(), pageable, queryResults.getTotal());

    }

    private BooleanExpression likeCreator(QPost post, PostCondition condition) {
        if(condition == null || condition.isAll()) { return null; }
        if (condition.isCreator() && !StringUtils.hasText(condition.getKeyword())) {
            return null;
        }

        return post.creator.contains(condition.getKeyword());
    }

    private BooleanExpression likeTitle(QPost post, PostCondition condition) {
        if(condition == null || condition.isAll()) { return null; }
        if (condition.isTitle() && !StringUtils.hasText(condition.getKeyword())) {
            return null;
        }

        return post.title.contains(condition.getKeyword());
    }

    private BooleanExpression likeAll(QPost post, PostCondition condition) {
        if(condition == null) { return null; }
        if(condition.isAll() && !StringUtils.hasText(condition.getKeyword())) {
            return null;
        }

        return post.title.contains(condition.getKeyword())
                .or(post.creator.contains(condition.getKeyword()));
    }
}
