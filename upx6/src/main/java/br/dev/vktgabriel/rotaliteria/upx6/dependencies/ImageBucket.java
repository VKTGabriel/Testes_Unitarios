package br.dev.vktgabriel.rotaliteria.upx6.dependencies;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageBucket {
    public String upload(String usuario, MultipartFile file) throws IOException;
}
