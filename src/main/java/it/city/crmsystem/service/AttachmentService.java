package it.city.crmsystem.service;

import it.city.crmsystem.entity.Attachment;
import it.city.crmsystem.exception.GenericNotFoundException;
import it.city.crmsystem.payload.ApiResponse;
import it.city.crmsystem.payload.AttachmentDto;
import it.city.crmsystem.repository.AttachmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AttachmentService {

    final AttachmentRepository attachmentRepository;

    private static Integer count=0;
    public static final Path root = Paths.get("app-crm-server/src/main/resources/image");



     // 2 ta bir xil rasm saqlasa ham bo'ladi

    public ApiResponse<?> upload(MultipartFile file) throws IOException {
        count++;
        String fileName = count + file.getOriginalFilename();
        Files.copy(file.getInputStream(), root.resolve(fileName));
        Attachment attachment = new Attachment();
        attachment.setName(1+" "+count+file.getOriginalFilename());
        attachment.setSize(file.getSize());
        attachment.setContentType(file.getContentType());
        return new ApiResponse<>(attachmentRepository.
                save(attachment).getId(),"Successfully",true);
    }

    public AttachmentDto getFile(Long id) throws MalformedURLException {
        Attachment attachment = attachmentRepository.findById(id).orElseThrow(() ->
                GenericNotFoundException.builder().message
                        ("Attachment id not found").statusCode(404).build());
        Path file = root.resolve(attachment.getName());
        Resource resource = new UrlResource(file.toUri());
        return new AttachmentDto(
                attachment.getId(),
                resource,
                attachment
        );
    }


    public Long editAttachment(Long id, MultipartFile file) throws IOException {
        Attachment attachment = attachmentRepository.findById(id).orElseThrow(() ->
                GenericNotFoundException.builder().message("Attachment id not found").
                        statusCode(404).build());
//        Files.delete(root.resolve(attachment.getName()));
        Files.copy(file.getInputStream(), root.resolve
                (Objects.requireNonNull(file.getOriginalFilename())));
        attachment.setName(file.getOriginalFilename());
        attachment.setSize(file.getSize());
        attachment.setContentType(file.getContentType());
        return attachmentRepository.save(attachment).getId();
    }


    public ApiResponse<?> deleteAttachment(Long id){
        Attachment attachment = attachmentRepository.findById(id).orElseThrow(() ->
                GenericNotFoundException.builder().message("Attachment not found")
                        .statusCode(404).build());
        attachmentRepository.delete(attachment);
        return new ApiResponse<>("Successfully deleted attachment", true);
    }


    public Attachment getOneAttachment(Long id) {
        return attachmentRepository.findById(id).orElseThrow(() ->
                GenericNotFoundException.builder().
                        message("Attachment id not found").
                        statusCode(404).build());
    }

}


