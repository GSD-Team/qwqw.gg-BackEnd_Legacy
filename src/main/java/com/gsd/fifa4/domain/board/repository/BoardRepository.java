package com.gsd.fifa4.domain.board.repository;

import com.gsd.fifa4.domain.board.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Yohan lee
 * Created on 2021-03-22.
 **/
public interface BoardRepository extends JpaRepository<Board, Long> {
}
