package com.example.ex10.freeboard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

//select, inset, update.. 다 된것
public interface FreeBoardRepository extends JpaRepository<FreeBoard, Long> {

    @Modifying
    @Transactional
    @Query("delete from FreeBoard fb WHERE fb.idx = :idx")
    void cusDeleteByIdx(@Param("idx") Long idx);
}
