package com.board.domain;

import com.board.paging.Criteria;
import com.board.paging.PaginationInfo;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommonDTO extends Criteria {
    private PaginationInfo paginationInfo;
    private String deleteYn;
    private LocalDateTime insertTime;
    private LocalDateTime updateTime;
    private LocalDateTime deleteTime;
}
