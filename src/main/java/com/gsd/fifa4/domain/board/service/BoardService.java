//package com.gsd.fifa4.domain.board.service;
//
//import com.gsd.fifa4.domain.board.dto.PostCondition;
//import com.gsd.fifa4.domain.board.dto.PostDTO;
//import com.gsd.fifa4.domain.board.model.Board;
//import com.gsd.fifa4.domain.board.model.Post;
//import com.gsd.fifa4.domain.board.repository.PostQueryRepository;
//import com.gsd.fifa4.domain.board.repository.PostRepository;
//import com.gsd.fifa4.global.util.ModelMapperUtil;
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
///**
// * Created by Yohan lee
// * Created on 2021-03-22.
// **/
//
//@Service
//@RequiredArgsConstructor
//public class BoardService {
//
//    private final PostRepository postRepository;
//    private final PostQueryRepository postQueryRepository;
//
//
//
//    @Transactional(readOnly = true)
//    public Page<PostDTO> getPosts(Board board, PostCondition condition, Pageable pageable) {
//        return postQueryRepository.findPosts(board, condition, pageable);
//    }
//
//    @Transactional(readOnly = true)
//    public PostDTO getPost(Long id) {
//        Post post = postRepository.findByIdAndDel(id, false)
//                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시물입니다."));
//
//        return ModelMapperUtil.toDTO(post, PostDTO.class);
//    }
//
//    @Transactional
//    public void register(Board board, PostDTO.Request dto) {
//        Post post = ModelMapperUtil.toEntity(dto, Post.class);
//        post.setBoard(board);
//        postRepository.save(post);
//    }
//
//    @Transactional
//    public void update(Post post, PostDTO.Request dto) {
//        if(!post.isValidPassword(dto.getPostPassword())) {
//            throw new IllegalArgumentException("권한이 없습니다.");
//        }
//
//        post.toUpdate(dto);
//    }
//
//    @Transactional
//    public void delete(Post post, String postPassword) {
//        if(!post.isValidPassword(postPassword)) {
//            throw new IllegalArgumentException("권한이 없습니다.");
//        }
//
//        post.delete();
//    }
//
//    @Transactional(readOnly = true)
//    public boolean validPassword(Long postId, String password) {
//        Post post = postRepository.findById(postId)
//                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시물입니다."));
//        return post.isValidPassword(password);
//    }
//
//}
