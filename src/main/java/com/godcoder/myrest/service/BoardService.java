package com.godcoder.myrest.service;

import com.godcoder.myrest.model.Board;
import com.godcoder.myrest.model.User;
import com.godcoder.myrest.repository.BoardRepository;
import com.godcoder.myrest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserRepository userRepository;

    public Board save(String username, Board board) {
        final User user = userRepository.findByUsername(username);
        board.setUser(user);
        return board;
    }



}
