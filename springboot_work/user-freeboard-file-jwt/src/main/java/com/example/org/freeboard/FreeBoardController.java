package com.example.org.freeboard;

import com.example.org.File.FileEntity;
import com.example.org.File.FileRepository;
import com.example.org.error.BizException;
import com.example.org.error.ErrorCode;
import com.example.org.user.User;
import com.example.org.user.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("freeboard")
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class FreeBoardController {

    private final FreeBoardRepository freeBoardRepository;
    private final FileRepository fileRepository;
    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    @Value("${my.value}")
    private String welcome;

    @GetMapping("com/example/org/test")
    public String test() {
        return welcome;
    }

    @GetMapping
    public ResponseEntity<FreeBoardResponsePageDto> findALl(
            @RequestParam(name = "pageNum", defaultValue = "0") int pageNum
            , @RequestParam(name = "size", defaultValue = "5") int size) {

//        System.out.println(SecurityContextHolder.getContext().getAuthentication());
        // aaa@naver.com
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        //ADMIN
        String role = SecurityContextHolder.getContext().getAuthentication().getAuthorities()
                .stream().map(grantedAuthority -> grantedAuthority.toString()).toString();
        //email이 null이 아니고 빈 공백이 아니면 로그인
        System.out.println("eamil = "+email);
        if((email == null && email.equals("")) || email.equals("anonymousUser")){
            System.out.println("로그인 하십시오");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } else {
            System.out.println("이미 로그인 되어있습니다.");
        }
        // ADMIN이 아니면 바로 리턴 (등급별로 페이지를 보여주고 안보여주고)
//        if(!role.equals("ROLE_ADMIN"))
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        Sort sort = Sort.by(Sort.Direction.DESC, "idx");
        Pageable pageable = PageRequest.of(pageNum, size, sort);

        //Page=>getTotalElements, getTotalPages등이 존재 List=>그런거 없음
        Page<FreeBoard> page = freeBoardRepository.findAll(pageable);
        FreeBoardResponsePageDto freeBoardResponsePageDto = modelMapper.map(page, FreeBoardResponsePageDto.class);

        List<FreeBoardResponseDto> list = freeBoardResponsePageDto
                .getContent()
                .stream()
                .map(freeBoard -> {
                    FreeBoardResponseDto freeBoardResponseDto = modelMapper.map(freeBoard, FreeBoardResponseDto.class);

                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yy/MM/dd hh:mm");
                    freeBoardResponseDto.setRegDate(dateTimeFormatter.format(freeBoard.getRegDate()));
                    freeBoardResponseDto.setModDate(dateTimeFormatter.format(freeBoard.getModDate()));

                    if(freeBoard.getUser()!=null) {
                        freeBoardResponseDto.setCreAuthor(freeBoard.getUser().getName());
                        freeBoardResponseDto.setModAuthor(freeBoard.getUser().getName());
                        freeBoardResponseDto.setUserIdx(freeBoard.getUser().getIdx());
                    }else{
                        freeBoardResponseDto.setCreAuthor("탈퇴한 회원");
                        freeBoardResponseDto.setModAuthor("탈퇴한 회원");
                    }

                    return freeBoardResponseDto;
                }).toList();

        freeBoardResponsePageDto.setList(list);
        return ResponseEntity.ok(freeBoardResponsePageDto);
    }

    @GetMapping("view/{idx}")
    public ResponseEntity<FreeBoardResponseDto> findOne(@PathVariable(name = "idx") long idx) {
        // 해당되는 행을 찾고
        FreeBoard freeBoard = freeBoardRepository.findById(idx).orElseThrow(() -> new BizException(ErrorCode.NOT_FOUND));
        // 조회수 수정
        freeBoard.setViewCount(freeBoard.getViewCount()+1);
        freeBoardRepository.save(freeBoard);

        FreeBoardResponseDto freeBoardResponseDto = modelMapper.map(freeBoard, FreeBoardResponseDto.class);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yy/MM/dd hh:mm");
        freeBoardResponseDto.setRegDate(dateTimeFormatter.format(freeBoard.getRegDate()));
        freeBoardResponseDto.setModDate(dateTimeFormatter.format(freeBoard.getModDate()));

        if(freeBoard.getUser()!=null) {
            freeBoardResponseDto.setCreAuthor(freeBoard.getUser().getName());
            freeBoardResponseDto.setModAuthor(freeBoard.getUser().getName());
            freeBoardResponseDto.setUserIdx(freeBoard.getUser().getIdx());
        }else{
            freeBoardResponseDto.setCreAuthor("탈퇴한 회원");
            freeBoardResponseDto.setModAuthor("탈퇴한 회원");
        }
        return ResponseEntity.ok(freeBoardResponseDto);
    }

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )

    public ResponseEntity<FreeBoard> save(
            @Valid @RequestPart(name = "data") FreeBoardReqDto freeBoardReqDto,
            @RequestPart(name = "file", required = false) MultipartFile file) {

        FreeBoard freeBoard = new ModelMapper().map(freeBoardReqDto, FreeBoard.class);

        if(freeBoardReqDto.getIdx()==null) {
            freeBoardRepository.save(freeBoard);
        }
        else{
            FreeBoard dbFreeBoard = freeBoardRepository.findById(freeBoard.getIdx()).orElseThrow();
            dbFreeBoard = new ModelMapper().map(freeBoardReqDto, FreeBoard.class);
            freeBoardRepository.save(dbFreeBoard);
        }

        User user = userRepository.findById(1L).orElse(null);
        freeBoard.setUser(user);

        if (file != null) {
            String myFilePath = Paths.get("images/file/").toAbsolutePath() + File.separator + file.getOriginalFilename();
            try {
                File destFile = new File(myFilePath);
                file.transferTo(destFile);
            } catch (Exception e) {
                e.printStackTrace();
            }

            FileEntity fileEntity = new FileEntity();
            //파일 이름 DB name 칼럼에 저장
            fileEntity.setName(file.getOriginalFilename());
            //파일 경로 DB path 칼럼에 저장
            fileEntity.setPath(Paths.get("images/file/").toAbsolutePath().toString());
            //파일엔티티와 프리보드 연계
            fileEntity.setFreeBoard(freeBoard);
            fileRepository.save(fileEntity);
            freeBoard.setList(Arrays.asList(fileEntity));
            freeBoardRepository.save(freeBoard);
        }else{
            List<FileEntity> list = fileRepository.findByFreeBoardIdx(freeBoard.getIdx());
            list.forEach(fileEntity -> {
                fileRepository.deleteById(fileEntity.getIdx());
            });
            freeBoardRepository.save(freeBoard);
        }

        return ResponseEntity.status(200).body(freeBoard);
    }

    @DeleteMapping("delete/{idx}")
    public ResponseEntity<String> deleteById(@PathVariable(name = "idx") long idx) {

        FreeBoard freeBoard = freeBoardRepository.findById(idx)
                .orElseThrow(() -> new BizException(ErrorCode.NOT_FOUND));

//        freeBoard.setList(new ArrayList<>());
        freeBoard.setUser(null);
        freeBoardRepository.save(freeBoard);
        freeBoardRepository.delete(freeBoard);

//        fileRepository.findByFreeBoardIdx(
//                freeBoard.getIdx()).forEach(fileEntity -> {
//            fileRepository.deleteById(fileEntity.getIdx());
//        });
//        freeBoardRepository.cusDeleteByIdx(idx);
        return ResponseEntity.ok("삭제되었습니다.");
    }
}