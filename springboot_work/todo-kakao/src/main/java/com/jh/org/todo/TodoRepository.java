package com.jh.org.todo;

import com.jh.org.kakao.jpa.KakaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoEntity,Long> {
    Iterable<TodoEntity> findAllByKakaoEntity(KakaoEntity kakaoEntity);
}
