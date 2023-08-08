package hd.backend.service;

import hd.backend.domain.FileUp;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileService {
    //(1) 파일 업로드
    long saveFile(MultipartFile mf) throws IOException;

    //(2) 파일 다운로드
    List<FileUp> getFileUpAll();
    FileUp getFileUp(long file_id);
}
