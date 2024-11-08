package br.com.teste.desafio.web.model;

import lombok.*;

@Getter
@Builder
@ToString
public class Post{

    private int userId;
    private int id;
    private String title;
    private String body;

}
