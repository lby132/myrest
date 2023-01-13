package com.godcoder.myrest.repository;

import com.godcoder.myrest.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
