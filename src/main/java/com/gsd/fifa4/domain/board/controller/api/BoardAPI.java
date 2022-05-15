//package com.gsd.fifa4.domain.board.controller.api;
//
//import com.gsd.fifa4.domain.board.dto.PostCondition;
//import com.gsd.fifa4.domain.board.dto.PostDTO;
//import com.gsd.fifa4.domain.board.model.Board;
//import com.gsd.fifa4.domain.board.model.Post;
//import com.gsd.fifa4.global.vo.Response;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//import org.springframework.data.domain.Pageable;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import springfox.documentation.annotations.ApiIgnore;
//
//import javax.validation.Valid;
//
///**
// * Created by Yohan lee
// * Created on 2021-03-22.
// **/
//@RequestMapping("/api/board")
//@Api(tags = {"게시판 API"})
//public interface BoardAPI {
//
//
//    @GetMapping("{board}/posts")
//    @ApiOperation(value = "게시물 리스트 API(board -> 50 : 건의게시판, 51 : 커뮤니티)", response = Response.class)
//    @ApiImplicitParam(name = "board", value = "게시판 ID",
//            dataTypeClass = Long.class, paramType = "path")
//    ResponseEntity<?> getPosts(
//            @ApiIgnore  @PathVariable("board") Board board,
//            @ApiParam(value = "검색 조건") PostCondition condition,
//            Pageable pageable
//    );
//
//    @GetMapping("/posts/{post}")
//    @ApiOperation(value = "게시물 상세보기 API", response = Response.class)
//    ResponseEntity<?> getPost(@PathVariable("post") Long postId);
//
//    @PostMapping("{board}/post")
//    @ApiOperation(value = "게시물 등록 API", response = Response.class)
//    @ApiImplicitParam(name = "board", value = "게시판 ID", dataTypeClass = Long.class, paramType = "path")
//    ResponseEntity<?> registerPost(
//            @ApiIgnore @PathVariable("board") Board board,
//            PostDTO.Request postRequest);
//
//    @PutMapping("/post/{post}")
//    @ApiOperation(value = "게시물 수정 API", response = Response.class)
//    @ApiImplicitParam(name = "post", value = "게시글 ID", dataTypeClass = Long.class, paramType = "path")
//    ResponseEntity<?> putPost(
//            @ApiIgnore @PathVariable Post post,
//            PostDTO.Request postRequest
//    );
//
//    @GetMapping("/{post}/valid-password")
//    @ApiOperation(value = "게시물 패스워드 검증", response = Response.class)
//    @ApiImplicitParam(name = "post", value = "게시글 ID", dataTypeClass = Long.class, paramType = "path")
//    ResponseEntity<?> validPassword(
//            @ApiIgnore @PathVariable("post") Long postId,
//            @ApiParam("게시물 패스워드") @RequestParam("password") String password);
//
//    @DeleteMapping("/post/{post}")
//    @ApiOperation(value = "게시물 삭제 API", response = Response.class)
//    @ApiImplicitParam(name = "post", value = "게시글 ID", dataTypeClass = Long.class, paramType = "path")
//    ResponseEntity<?> deletePost(
//            @ApiIgnore @PathVariable Post post,
//            @ApiParam("게시글 비밀번호") @RequestParam String postPassword
//    );
//}
