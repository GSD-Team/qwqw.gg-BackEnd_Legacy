package com.gsd.fifa4.domain.board.controller;

import com.gsd.fifa4.domain.board.controller.api.BoardAPI;
import com.gsd.fifa4.domain.board.dto.PostCondition;
import com.gsd.fifa4.domain.board.dto.PostDTO;
import com.gsd.fifa4.domain.board.model.Board;
import com.gsd.fifa4.domain.board.model.Post;
import com.gsd.fifa4.domain.board.service.BoardService;
import com.gsd.fifa4.global.vo.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Yohan lee
 * Created on 2021-03-22.
 **/
@RestController
@RequiredArgsConstructor
public class BoardController implements BoardAPI {

    private final BoardService boardService;

    @Override
    public ResponseEntity<?> getPosts(Board board, PostCondition condition, @PageableDefault  Pageable pageable) {
        return ResponseEntity.ok(new Response(boardService.getPosts(board, condition, pageable)));
    }

    @Override
    public ResponseEntity<?> getPost(Long postId) {
        return ResponseEntity.ok(new Response(boardService.getPost(postId)));
    }


    @Override
    public ResponseEntity<?> registerPost(Board board, @RequestBody @Valid PostDTO.Request postRequest) {
        boardService.register(board, postRequest);
        return ResponseEntity.ok(new Response());
    }

    @Override
    public ResponseEntity<?> putPost(Post post, @RequestBody @Valid PostDTO.Request postRequest) {
        boardService.update(post, postRequest);
        return ResponseEntity.ok(new Response());
    }

    @Override
    public ResponseEntity<?> validPassword(Long postId, String password) {
        if(!boardService.validPassword(postId, password)) {
            throw new IllegalArgumentException("잘못된 패스워드 입니다.");
        }
        return ResponseEntity.ok(new Response());
    }

    @Override
    public ResponseEntity<?> deletePost(Post post, String postPassword) {
        boardService.delete(post, postPassword);
        return ResponseEntity.ok(new Response());
    }
}
