package com.hawaso.java_test.service;

import com.hawaso.java_test.dto.BoardDTO;
import com.hawaso.java_test.entity.BoardEntity;
import com.hawaso.java_test.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

// DTO -> Entity (Entity Class)
// Entity -> DTO (DTO Class) service 클래스에서 변환하는 과정이 발생

@Service
@RequiredArgsConstructor
public class BoardService {
  private final BoardRepository boardRepository;

  public void save (BoardDTO boardDTO) {
    BoardEntity boardEntity = BoardEntity.toSaveEntity(boardDTO);
    boardRepository.save(boardEntity);
  }
}
