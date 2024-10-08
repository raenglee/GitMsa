package com.pmh.org.freeboard;

import com.pmh.org.file.FileEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FreeBoardResponseDto {

    private Long idx;
    private String title;
    private String content;

//    private User user;

    private Long userIdx;

    private String creAuthor;
    private String modAuthor;
    private String regDate;
    private String modDate;

    private int viewCount;
    private List<FileEntity> list = new ArrayList<>();

}
