package com.hawaso.java_test.controller;

import com.hawaso.java_test.dto.BoardDTO;
import com.hawaso.java_test.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
  private final BoardService boardService;  // 생성자 주입 방식으로 의존성을 주입한다

  @GetMapping("/save")
  public String saveForm() {
    return "save";
  }
// (@RequestParam("boardWriter") String boardWriter) - Post 데이터를 받는 기본 방법

  @PostMapping("/save")
  public String save(@ModelAttribute BoardDTO boardDTO) {     // RequestParam으로 하나하나 할 필요없이 DTO 클래스를 전부 import
    System.out.println("boardDTO = " + boardDTO);
    boardService.save(boardDTO);
    return null;

  }
}
