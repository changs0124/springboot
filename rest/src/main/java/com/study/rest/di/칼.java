package com.study.rest.di;

import org.springframework.stereotype.Component;

@Component
public class 칼 implements 무기{
    @Override
    public void 공격() {
        System.out.printf("칼을 휘두릅니다.");
    }
}
