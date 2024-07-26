package com.study.rest.dto;


import lombok.Data;

@Data
public class ReqRegisterTodolistDto {
    private String content;
    private String registerDate;
    private int checkedState;
}
