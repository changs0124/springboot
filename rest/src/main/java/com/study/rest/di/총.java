package com.study.rest.di;

import org.springframework.stereotype.Component;

@Component
public class 총 implements 무기{
    @Override
    public void 공격() {
        System.out.printf("총을 쏩니다.");
    }
}
