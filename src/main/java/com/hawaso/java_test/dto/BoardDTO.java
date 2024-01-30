package com.hawaso.java_test.dto;

import java.time.LocalDateTime;
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
}
