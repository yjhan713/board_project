package com.hawaso.java_test.controller;

import com.hawaso.java_test.dto.BoardDTO;
import com.hawaso.java_test.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    return "index";
  }

  @GetMapping("/")
  public String findAll(Model model) {   // 데이터를 가져온다라고 하면 Model 객체를 사용
    // DB에서 전체 게시글 뎅터를 가져와 list.html 보여준다.
    List<BoardDTO> boardDTOList = boardService.findAll();
    model.addAttribute("boardList", boardDTOList);
    return "list";
  }

  @GetMapping("/{id}")
  public String findById(@PathVariable Long id, Model model) {   // PathVariable경로 상에 값을 가져올때
    /*  2가지 고민점
       해당 게시글의 조회수를 하나 올리고
       게시글 데이터를 가져와서 detail.html에 출력
    */
    boardService.updateHits(id);
    BoardDTO boardDTO = boardService.findById(id);
    model.addAttribute("board", boardDTO);
    return "detail";
  }

  @GetMapping("/update/{id}")
  public String updateForm(@PathVariable Long id, Model model) {
    BoardDTO boardDTO = boardService.findById(id);
    model.addAttribute("boardUpdate", boardDTO);
    return "update";
  }

  @PostMapping("/update")
  public String update(@ModelAttribute BoardDTO boardDTO, Model model) {
    BoardDTO board = boardService.update(boardDTO);
    model.addAttribute("board", board);
    return "detail";
//    return "redirect:/board/" + boardDTO.getId();
  }

  @GetMapping("/delete/{id}")
  public String delete(@PathVariable Long id) {
    boardService.delete(id);
    return "redirect:/board/";
  }

  // /board/paging?page=1   default로 1페이지를 디폴르로 넣는 이유는 페이지값이 없어서 에러가 날 수 있어서
  @GetMapping("/paging")
  public String paging(@PageableDefault(page = 1)Pageable pageable, Model model) {
  // pageable.getPageNumber();
    Page<BoardDTO> boardList = boardService.paging(pageable);
    int blockLimit = 3;
    int startPage = (((int)(Math.ceil((double)pageable.getPageNumber() / blockLimit))) - 1) * blockLimit + 1; // 1 4 7 10 ~~
    int endPage = ((startPage + blockLimit - 1) < boardList.getTotalPages()) ? startPage + blockLimit - 1 : boardList.getTotalPages();

    // page 갯수 20개
    // 현재 사용자가 3페이지
    // 1 2 3
    // 현재 사용자가 7페이지
    // 7 8 9
    // 보여지는 페이지 갯수 3개

    model.addAttribute("boardList", boardList);
    model.addAttribute("startPage", startPage);
    model.addAttribute("endPage", endPage);
    return "paging";

  }
}
