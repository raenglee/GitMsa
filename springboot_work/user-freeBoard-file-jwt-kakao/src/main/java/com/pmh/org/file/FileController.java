package com.pmh.org.file;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
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
import java.util.HashMap;

@RestController
@RequestMapping("file")
@CrossOrigin
@Slf4j
public class FileController {

    private final Path imagePath;
    private final ModelMapper modelMapper;
    private final FileRepository fileRepository;

    public FileController(ModelMapper modelMapper, FileRepository fileRepository) {
        this.modelMapper = modelMapper;
        this.fileRepository = fileRepository;
        this.imagePath = Paths.get("images/file").toAbsolutePath();

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

    @PostMapping(value = "upload",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String upload(
            @RequestPart(name = "file") MultipartFile file,
            @RequestPart(name = "fileDto") FileReqDto fileReqDto) {
        try {
            String fileName = file.getOriginalFilename();
            String filePath = imagePath.toString()+File.separator+fileName;

            File dest = new File(filePath);
            file.transferTo(dest);

            FileEntity fileEntity = modelMapper.map(fileReqDto, FileEntity.class);
            fileRepository.save(fileEntity);

        }catch (Exception e){
            e.printStackTrace();
        }
        return "upload";
    }

    @PostMapping(value = "uploads", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploads(@RequestPart(name = "files") MultipartFile[] files,
                          @RequestPart(name = "fileDto") HashMap<String, String> map) {
        try{
            for (MultipartFile file : files) {
                String fileName = file.getOriginalFilename();
                String filePath = imagePath.toString()+File.separator+fileName;
                File dest = new File(filePath);
                file.transferTo(dest);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return "upload";

    }
    @GetMapping("/download/{fileName}")
    public ResponseEntity<Resource> downloadFile(@PathVariable(name = "fileName") String fileName) throws IOException {
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

