package com.example.ex10.freeboard;

import com.example.ex10.File.FileEntity;
import com.example.ex10.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity // 테이블임을 알려주는 것
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Table(name = "freeboard") // 테이블 이름 설정
public class FreeBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTOINCREMENT(자동증가)시켜달라는 의미
    private Long idx;

    private String title;
    private String content;

    @CreatedBy
    @Column(updatable = false)
    private String creAuthor;

    @LastModifiedBy
    private String modAuthor;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime regDate;

    @LastModifiedDate
    private LocalDateTime modDate;

    @Column(columnDefinition = "int default 0")  // 칼럼 정의, 조회수이므로 무조건 처음엔 0이어야함
    private int viewCount;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "freeBoard", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FileEntity> list = new ArrayList<>();

    @ManyToOne
    @JsonIgnore
    private User user;

    @Override
    public String toString() {
        return "FreeBoard{" +
                "idx=" + idx +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", creAuthor='" + creAuthor + '\'' +
                ", modAuthor='" + modAuthor + '\'' +
                ", regDate=" + regDate +
                ", modDate=" + modDate +
                ", viewCount=" + viewCount +
                ", list=" + list +
                '}';
    }
}