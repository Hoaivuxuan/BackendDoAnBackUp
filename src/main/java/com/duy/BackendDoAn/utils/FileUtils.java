package com.duy.BackendDoAn.utils;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.firebase.cloud.StorageClient;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FilenameUtils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;
import java.util.UUID;

public class FileUtils {
    private static String UPLOADS_FOLDER = "uploads";
    public static void deleteFile(String filename) throws Exception{

    }

    public static boolean isImageFile(MultipartFile file){
        String contentType = file.getContentType();
        if(contentType == null || !contentType.startsWith("image/")){
            return false;
        }
        return true;
    }

    public static String storeFile(MultipartFile file) throws Exception{
        if (!isImageFile(file) || file.getOriginalFilename() == null) {
            throw new Exception("Invalid image format");
        }
        String filename = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        String extension = FilenameUtils.getExtension(filename);  // Lấy extension của file gốc
        // Thêm UUID và extension vào tên file để đảm bảo tên file là duy nhất và giữ nguyên extension
        String uniqueFilename = UUID.randomUUID().toString() + "_" + System.nanoTime() + "." + extension;

        // Đường dẫn đến thư mục mà bạn muốn lưu file
        java.nio.file.Path uploadDir = Paths.get(UPLOADS_FOLDER);
        // Kiểm tra và tạo thư mục nếu nó không tồn tại
        if (!Files.exists(uploadDir)) {
            Files.createDirectories(uploadDir);
        }
        // Đường dẫn đầy đủ đến file
        java.nio.file.Path destination = Paths.get(uploadDir.toString(), uniqueFilename);
        // Sao chép file vào thư mục đích
        Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);
        return uniqueFilename;
    }

    public static String uploadToFirebase(MultipartFile file) throws Exception {
        try {
            // Tạo tên file unique
            String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
            Bucket bucket = StorageClient.getInstance().bucket();
            Blob blob = bucket.create(fileName, file.getBytes(), file.getContentType());

            // Trả về URL công khai của file
            return String.format("https://firebasestorage.googleapis.com/v0/b/%s/o/%s?alt=media",
                    bucket.getName(), fileName);
        } catch (Exception e) {
            throw new Exception("Failed to upload file to Firebase", e);
        }
    }

}
