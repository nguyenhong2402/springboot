package vn.techmaster.jobhunt.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import vn.techmaster.jobhunt.error.StorageException;

@Service
public class StorageService {
    @Value("${upload.path}")
    private String path;

    public String saveFile(MultipartFile file, String employerId) {
        if (file.isEmpty()) {
            throw new StorageException("employer.save.logo.emptyFile");
        }
        String logoFileName = employerId + "." + getFileExtension(file.getOriginalFilename());
        String logoPath = path + logoFileName;
        try (var is = file.getInputStream()) {
            Files.copy(is, Paths.get(logoPath), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            //var msg = String.format("Failed to store file %s", logoPath);
            throw new StorageException("employer.save.logo.failed", new String[] {logoPath});
        }
        return logoFileName;
    }

    private String getFileExtension(String fileName) {
        int postOfDot = fileName.lastIndexOf(".");
        if (postOfDot < 0) {
          return null;
        }
        return fileName.substring(postOfDot + 1);
      }
}
