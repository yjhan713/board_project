package com.hawaso.java_test.entity;

import com.hawaso.java_test.dto.BoardDTO;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

//DB 테이블 역할을 하는 클래스 Entity 클래의 정보를 View 단으로 가지안고 service 까지가 최대
@Entity
@Getter   // 클래스의 특정 멤버 변수의 값을 가져옴
@Setter   // 클래스의 특정 멤버 변수에 값을 설정
@Table(name = "board_table")  // 내가 생성한 테이블 이름
public class BoardEntity extends BaseEntity {
  @Id // pk 컬럼 지정. 1개는 필수
  @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
  private Long id;

  @Column(length = 20, nullable = false )  //length : 컬럼의 크기, nullable : not null 를 지정하는 옵션
  private String boardWriter;

  @Column // 크기 255. null 가능 - 디폴트
  private String boardPass;

  @Column
  private String boardTitle;

  @Column(length = 500)
  private String boardContents;

  @Column
  private int boardHits;

  public static BoardEntity toSaveEntity(BoardDTO boardDTO) {   // DTO에 담긴 값을 Entity 객체로 옮겨 담는 작업
    BoardEntity boardEntity = new BoardEntity();
    boardEntity.setBoardWriter(boardDTO.getBoardWriter());
    boardEntity.setBoardPass(boardDTO.getBoardPass());
    boardEntity.setBoardTitle(boardDTO.getBoardTitle());
    boardEntity.setBoardContents(boardDTO.getBoardContents());
    boardEntity.setBoardHits(0);
    return boardEntity;
  }

  public static BoardEntity toUpdateEntity(BoardDTO boardDTO) {
    BoardEntity boardEntity = new BoardEntity();
    boardEntity.setId(boardDTO.getId());
    boardEntity.setBoardWriter(boardDTO.getBoardWriter());
    boardEntity.setBoardPass(boardDTO.getBoardPass());
    boardEntity.setBoardTitle(boardDTO.getBoardTitle());
    boardEntity.setBoardContents(boardDTO.getBoardContents());
    boardEntity.setBoardHits(boardDTO.getBoardHits());
    return boardEntity;
  }
}

