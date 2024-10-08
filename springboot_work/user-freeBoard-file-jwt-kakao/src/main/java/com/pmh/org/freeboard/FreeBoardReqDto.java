package com.pmh.org.freeboard;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Data
public class FreeBoardReqDto {

    private Long idx;

    @Schema(example = "제목을 넣어주세요")
    @Length(min = 2, max = 255)
    private String title;

    @Schema(example = "내용을 넣어주세요")
    @NotEmpty
    private String content;
//    private User user;

    @Schema(hidden = true)
    private LocalDateTime regDate;

    @Schema(hidden = true)
    private LocalDateTime modDate;

    @Schema(hidden = true)
    private int viewCount;
}
