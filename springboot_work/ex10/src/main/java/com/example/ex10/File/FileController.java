package com.example.ex10.File;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("file")  //이 주소 밑으로 들어오면~
@CrossOrigin
public class FileController {

    private final Path imagePath;
    private final FileRepository fileRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public FileController(FileRepository fileRepository, ModelMapper modelMapper) {
        this.imagePath = Paths.get("ex10/images/file/").toAbsolutePath();
        this.fileRepository = fileRepository;
        this.modelMapper = modelMapper;

        try {
            Files.createDirectories(this.imagePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("test")
    public String test() {
        return "test";
    }

    @PostMapping(value = "upload", produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String upload(@RequestPart(name = "file") MultipartFile file,
                         @RequestPart(name = "file") FileReqDto fileReqDto) {
        try{
        String myfilePath = imagePath.toAbsolutePath().toString() + File.pathSeparator + file.getOriginalFilename();

        File saveFile = new File(myfilePath);
        file.transferTo(saveFile);

        //DB 저장
        FileEntity fileEntity = modelMapper.map(fileReqDto, FileEntity.class);
        fileRepository.save(fileEntity);

    }catch (Exception e){
        e.printStackTrace();
        }

        return "upload";
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName) throws IOException {
        // 파일이 저장된 경로
        Path filePath = imagePath.resolve(fileName);
        Resource resource = new UrlResource(filePath.toUri());

        if (!resource.exists()) {
            throw new FileNotFoundException("파일을 찾을 수 없습니다: " + fileName);
        }

        // 파일을 전송
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG) // 또는 MediaType.IMAGE_PNG 등으로 변경 가능
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                .body(resource);
    }
}

