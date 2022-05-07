package com.gsd.fifa4.domain.board.repository;

import com.gsd.fifa4.domain.board.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by Yohan lee
 * Created on 2021-03-22.
 **/
public interface PostRepository extends JpaRepository<Post, Long> {

    Optional<Post> findByIdAndDel(Long id, boolean del);
}
