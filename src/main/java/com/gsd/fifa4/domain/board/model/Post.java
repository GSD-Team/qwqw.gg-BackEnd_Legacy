//package com.gsd.fifa4.domain.board.model;
//
//import com.gsd.fifa4.domain.board.dto.PostDTO;
//import com.gsd.fifa4.global.vo.BaseEntity;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import org.hibernate.annotations.DynamicUpdate;
//import org.hibernate.annotations.GenericGenerator;
//import org.hibernate.annotations.Parameter;
//
//import javax.persistence.*;
//
///**
// * Created by Yohan lee
// * Created on 2021-03-22.
// **/
//
//@GenericGenerator(name = "post_seq_generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
//        parameters = {
//                @Parameter(name = "sequence_name", value = "seq_post"),
//                @Parameter(name = "initial_value", value = "50"),
//                @Parameter(name = "increment_size", value = "1")
//        }
//)
//
//@Getter
//@Entity
//@Table(name = "post")
//@NoArgsConstructor
//@DynamicUpdate
//public class Post extends BaseEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_seq_generator")
//    @Column(name = "post_id")
//    private Long id;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "board_id", nullable = false)
//    private Board board;
//
//    @Column(name = "title", nullable = false)
//    private String title;
//
//    @Lob
//    @Column(name = "text")
//    private String text;
//
//    @Column(name = "notice")
//    private boolean notice;
//
//    @Column(name = "del")
//    private boolean del;
//
//    @Column(name = "creator", nullable = false)
//    private String creator;
//
//    @Column(name = "post_password", nullable = false)
//    private String postPassword;
//
//    public void delete() {
//        this.del = true;
//    }
//
//    public void setBoard(Board board) {
//        this.board = board;
//        board.getPosts().add(this);
//    }
//
//    public boolean isValidPassword(String postPassword) {
//        return this.postPassword.equals(postPassword);
//    }
//
//    public void toUpdate(PostDTO.Request requestDTO) {
//        this.title = requestDTO.getTitle();
//        this.text = requestDTO.getText();
//    }
//}
