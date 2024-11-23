package com.duy.BackendDoAn.configurations;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.InputStream;

@Configuration
public class FirebaseConfig {

    public FirebaseConfig() {
        try {
            InputStream serviceAccount = getClass().getClassLoader().getResourceAsStream("serviceAccountKey.json");
            if (serviceAccount == null) {
                throw new IllegalStateException("Không tìm thấy serviceAccountKey.json trong classpath");
            }
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setStorageBucket("backenddoan-4e905.firebasestorage.app")
                    .build();
            if (FirebaseApp.getApps().isEmpty()) { // Kiểm tra tránh khởi tạo nhiều lần
                FirebaseApp.initializeApp(options);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Lỗi khi khởi tạo Firebase: " + e.getMessage());
        }
    }
}
