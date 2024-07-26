package com.study.ssr.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter @ToString
public class Dvd {
    private String title;
    private String producer;
    private String publisher;
}
