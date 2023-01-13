package com.godcoder.myrest.controller;

import com.godcoder.myrest.model.Board;
import com.godcoder.myrest.repository.BoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;

    @GetMapping("/list")
    public String list(Model model) {
        final List<Board> boards = boardRepository.findAll();
        log.info("board = {}", boards);
        model.addAttribute("boards", boards);
        return "board/list";
    }
}
