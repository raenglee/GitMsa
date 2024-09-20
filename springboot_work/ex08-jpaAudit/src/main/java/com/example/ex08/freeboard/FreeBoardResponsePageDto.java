package com.example.ex08.freeboard;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FreeBoardResponsePageDto {

    @Schema  // swagger문서에서 안보이게 하는 것
    @JsonIgnore  // postamn에서 안보이게 하는 것 (콘텐트가 안보여짐)
    private List<FreeBoard> content;
    private List<FreeBoardResponseDto> list;
    private int totalElements;
    private int totalPages;
    private int size;
}
