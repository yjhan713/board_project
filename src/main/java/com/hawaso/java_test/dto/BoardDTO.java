package com.hawaso.java_test.dto;

import java.time.LocalDateTime;

import com.hawaso.java_test.entity.BaseEntity;
import com.hawaso.java_test.entity.BoardEntity;
import lombok.*;
// DTO(Data Transfer Object), VO, Bean - 데이터를 전송하는 객체
@Getter
@Setter
@ToString
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 모든 필드를 매개변수로 하는 생성자
public class BoardDTO {     // 이곳이 필드
  private Long id;
  private String boardWriter;
  private String boardPass;
  private String boardTitle;
  private String boardContents;
  private int boardHits;
  private LocalDateTime boardCreatedTime;
  private LocalDateTime boardUpdatedTime;

  // Ait + Insert = Generate(자동완성 기능)
  public BoardDTO(Long id, String boardWriter, String boardTitle, int boardHits, LocalDateTime boardCreatedTime) {
    this.id = id;
    this.boardWriter = boardWriter;
    this.boardTitle = boardTitle;
    this.boardHits = boardHits;
    this.boardCreatedTime = boardCreatedTime;
  }

  public static BoardDTO toBoardDTO(BoardEntity boardEntity) {
    BoardDTO boardDTO = new BoardDTO();
    boardDTO.setId(boardEntity.getId());
    boardDTO.setBoardWriter(boardEntity.getBoardWriter());
    boardDTO.setBoardPass(boardEntity.getBoardPass());
    boardDTO.setBoardTitle(boardEntity.getBoardTitle());
    boardDTO.setBoardContents(boardEntity.getBoardContents());
    boardDTO.setBoardHits(boardEntity.getBoardHits());
    boardDTO.setBoardCreatedTime(boardEntity.getCreatedTime());
    boardDTO.setBoardUpdatedTime(boardEntity.getUpdatedTime());
    return boardDTO;
  }
}
