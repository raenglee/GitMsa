package com.pmh.org.freeboard;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pmh.org.file.FileEntity;
import com.pmh.org.user.User;
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

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Table(name = "freeboard")
public class FreeBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(columnDefinition = "int default 0")
    private int viewCount;

    @OneToMany(fetch = FetchType.EAGER,
            mappedBy = "freeBoard",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
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









