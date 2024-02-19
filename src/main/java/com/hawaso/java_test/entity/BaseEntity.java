package com.hawaso.java_test.entity;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
// 시간 정보를 다루는 클래스!
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public class BaseEntity {
  @CreationTimestamp                    // 생성 되었을 때 시간 정보
  @Column(updatable = false)            // 수정시에 updatable 관여하지 않는다
  private LocalDateTime createdTime;

  @UpdateTimestamp                      // 업데이트 되었을 때의 시간 정보
  @Column(insertable = false)           // insertable 할때 관여하지 않는다
  private LocalDateTime updatedTime;
}

