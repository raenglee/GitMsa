package com.jh.org.todo;

import com.jh.org.kakao.jpa.KakaoEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name="todos")
public class TodoEntity {
    @Id
    @Schema(hidden = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(example = "할일제목")
    @Size(min = 2,max = 255)
    private String title;
    @Schema(example = "할일 적으세요")
    private String content;
    @Schema(example = "false")
    private boolean completed;
    private LocalDate selectDate;

    @Schema(hidden = true)
    @ManyToOne
    @JoinColumn(name = "kakao_id")
    private KakaoEntity kakaoEntity;

}
