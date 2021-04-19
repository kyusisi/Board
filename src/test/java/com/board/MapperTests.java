package com.board;

import com.board.domain.BoardDTO;
import com.board.mapper.BoardMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MapperTests {
    @Autowired
    private BoardMapper mapper;

    @Test
    public void testOfInsert() {
        BoardDTO params = new BoardDTO();
        params.setTitle("1번 게시글 제목");
        params.setContent("1번 게시글 내용");
        params.setWriter("테스터");

        int result = mapper.insertBoard(params);
        System.out.println("result = " + result);
    }

    @Test
    public void testOfSelectDetail() {
        BoardDTO board = mapper.selectBoardDetail((long) 1);
        try {
            String boardJson = new ObjectMapper().writeValueAsString(board);
            System.out.println("boardJson = " + boardJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testOfUpdate() {
        BoardDTO params = new BoardDTO();
        params.setTitle("1번 게시글 제목 수정");
        params.setContent("1번 게시글 내용 수정");
        params.setWriter("홍길동");
        params.setIdx((long) 1);

        int result = mapper.updateBoard(params);
        if (result == 1) {
            BoardDTO boardDTO = mapper.selectBoardDetail((long) 1);
            try {
                String boardJson = new ObjectMapper().writeValueAsString(boardDTO);

                System.out.println("====================================");
                System.out.println("boardJson = " + boardJson);
                System.out.println("====================================");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testOfDelete() {
        int result = mapper.deleteBoard((long) 1);
        if (result == 1) {
            BoardDTO board = mapper.selectBoardDetail((long) 1);
            try {
                String boardJson = new ObjectMapper().writeValueAsString(board);
                System.out.println("======================================");
                System.out.println("boardJson = " + boardJson);
                System.out.println("======================================");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testMultipleInsert() {
        for (int i = 2; i <= 50; i++) {
            BoardDTO params = new BoardDTO();
            params.setTitle(i + " 번째 게시글 제목");
            params.setContent(i + " 번째 게시글 내용");
            params.setWriter(i + " 번 게시글 작성자");
            mapper.insertBoard(params);
        }
    }

/*    @Test
    public void testSelectList() {
        int boardTotalCount = mapper.selectBoardTotalCount(1);

        if (boardTotalCount > 0) {
            List<BoardDTO> boardList = mapper.selectBoardList(1);
            if(CollectionUtils.isEmpty(boardList) == false) {
                for (BoardDTO board : boardList) {
                    System.out.println("=========================================");
                    System.out.println(board.getTitle());
                    System.out.println(board.getContent());
                    System.out.println(board.getWriter());
                    System.out.println("=========================================");

                }
            }
        }
    }*/
}
