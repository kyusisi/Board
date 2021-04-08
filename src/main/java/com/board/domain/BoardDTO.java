package com.board.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BoardDTO {
    private Long idx;
    private String title;
    private String content;
    private String writer;
    private int viewCnt;
    private String noticeYn;
    private String secretYn;
    private String deleteYn;
    private LocalDateTime insertTime;
    private LocalDateTime updateTime;
    private LocalDateTime deleteTime;

}
