package br.dev.vktgabriel.rotaliteria.upx6.dependencies.implementation;

import br.dev.vktgabriel.rotaliteria.upx6.config.S3ClienteConfig;
import br.dev.vktgabriel.rotaliteria.upx6.dependencies.ImageBucket;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class S3Service implements ImageBucket {

    @Value("${aws.s3.bucket-name}")
    private String bucket;

    private final S3Client s3Client;
    private final S3ClienteConfig s3ClienteConfig;

    public String upload(String usuario, MultipartFile file) throws IOException {
        String fileName = String.format("%s_%s", usuario, file.getOriginalFilename());
        s3Client.putObject(PutObjectRequest.builder()
                        .bucket(bucket)
                        .key(fileName)
                        .build(),
                RequestBody.fromBytes(file.getBytes()));

        return String.format("https://%s.s3.%s.amazonaws.com/%s", bucket, s3ClienteConfig.getRegion(), fileName);
    }
}
