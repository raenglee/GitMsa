package com.example.ex10.freeboard;

import org.springframework.data.jpa.repository.JpaRepository;

//select, inset, update.. 다 된것
public interface FreeBoardRepository extends JpaRepository<FreeBoard, Long> {
}
