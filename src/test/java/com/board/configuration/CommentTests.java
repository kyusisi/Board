package com.board.configuration;

import com.board.domain.CommentDTO;
import com.board.service.CommentService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CommentTests {

    @Autowired
    private CommentService commentService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void registerComments() {
        int number = 20;

        for(int i = 0; i <= 20; i++) {
            CommentDTO params = new CommentDTO();
            params.setBoardIdx((long) 934);
            params.setContent(i + " 번 댓글을 추가합니다.");
            params.setWriter(i + " 번 회원");
            commentService.registerComment(params);
        }
        logger.debug("댓글 " + number + " 개 추가되었습니다.");
    }

    @Test
    public void deleteComment() {
        commentService.deleteComment((long) 568);

        getCommentList();
    }

    @Test
    public void getCommentList() {
        CommentDTO params = new CommentDTO();
        params.setBoardIdx((long) 538);

        commentService.getCommentList(params);
    }


}
