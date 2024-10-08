package com.pmh.org.freeboard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface FreeBoardRepository extends JpaRepository<FreeBoard,Long> {


//    @Query(value = "delete fb from FreeBoard fb idx = ?idx")
//    public void customDeleteByIdx(Long idx);

    // JPQL 문법
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM FreeBoard fb WHERE fb.idx = :idx")
    void cusDeleteByIdx(@Param("idx") Long idx);

}
