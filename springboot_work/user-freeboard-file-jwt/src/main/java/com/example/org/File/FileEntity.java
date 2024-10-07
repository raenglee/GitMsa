package com.example.org.File;

import com.example.org.freeboard.FreeBoard;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table (name = "freeboardFiles")
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String name;
    private String path;
    private String fileDesc;

    @ManyToOne
//    private FreeBoard freeBoard;
    @JsonIgnore  // 이게 없으면 n+1 무한반복 오류 발생 (글안에서 글을 계속 보여줌)
    private FreeBoard freeBoard;


    //toString 할때 프리보드 안보이도록 지워줘야함
    @Override
    public String toString() {
        return "FileEntity{" +
                "idx=" + idx +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", fileDesc='" + fileDesc +
                '}';
    }
}
