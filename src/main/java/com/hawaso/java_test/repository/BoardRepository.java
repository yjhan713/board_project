package com.hawaso.java_test.repository;

import com.hawaso.java_test.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> { // JpaRepository<BoardEntity, Long> 이부분만 잘 설정하면 된다고하는데 이건 공부해봐야할듯
  // update board_table set board_hits=board_hits+1 where id =? 기존 조회수에서 하나의 값을 올리는 쿼리
  @Modifying
  @Query(value = "update BoardEntity b set b.boardHits=b.boardHits+1 where b.id=:id")
  void updateHits(@Param("id")Long id);
}
