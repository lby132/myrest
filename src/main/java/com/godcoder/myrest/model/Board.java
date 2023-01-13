package com.godcoder.myrest.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "t_board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
}
