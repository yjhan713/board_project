package com.hawaso.java_test.repository;

import com.hawaso.java_test.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> { // JpaRepository<BoardEntity, Long> 이부분만 잘 설정하면 된다고하는데 이건 공부해봐야할듯
}
