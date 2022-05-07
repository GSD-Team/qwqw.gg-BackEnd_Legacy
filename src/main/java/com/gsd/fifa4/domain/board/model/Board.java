package com.gsd.fifa4.domain.board.model;

import com.gsd.fifa4.domain.board.constant.BoardType;
import com.gsd.fifa4.global.vo.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yohan lee
 * Created on 2021-03-22.
 **/

@GenericGenerator(name = "board_seq_generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
                @Parameter(name = "sequence_name", value = "seq_board"),
                @Parameter(name = "initial_value", value = "50"),
                @Parameter(name = "increment_size", value = "1")
        }
)
@Getter
@Entity
@Table(name = "board")
@NoArgsConstructor
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "board_seq_generator")
    @Column(name = "board_id")
    private Long id;

    @Column(name = "board_name", unique = true)
    private String boardName;

    @Column(name = "board_type")
    @Enumerated(EnumType.STRING)
    private BoardType type;

    @Column(name = "board_use")
    private boolean use;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "board")
    private List<Post> posts = new ArrayList<>();


    public Board(String boardName, BoardType type, boolean use) {
        this.boardName = boardName;
        this.type = type;
        this.use = use;
    }
}
