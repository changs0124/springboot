package com.study.rest.controller;

import com.study.rest.dto.ReqRegisterTodolistDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class TodolistController {

    @PostMapping("/todolist")
    public ResponseEntity<?> registerTodolist(@RequestBody ReqRegisterTodolistDto reqRegisterTodolistDto) {
        log.info("{}", reqRegisterTodolistDto);
        return ResponseEntity.ok().body(null);
    }
}
