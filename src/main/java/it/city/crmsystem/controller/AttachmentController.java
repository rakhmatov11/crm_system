package it.city.crmsystem.controller;

import it.city.crmsystem.payload.ApiResponse;
import it.city.crmsystem.payload.AttachmentDto;
import it.city.crmsystem.service.AttachmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;

@RestController
@RequestMapping("/attachment")
@RequiredArgsConstructor
public class AttachmentController {
    final AttachmentService attachmentService;


    @PostMapping(value = "/upload",consumes = {"multipart/form-data"})
    public HttpEntity<?> upload(@RequestParam(value = "file")
                                    MultipartFile file) throws IOException {
        ApiResponse<?> upload = attachmentService.upload(file);
        return ResponseEntity.status(upload.isSuccess() ? 200 : 409)
                 .body(upload);
    }

    @GetMapping("/getFile/{id}")
    public HttpEntity<?> getFile(@PathVariable Long id) throws MalformedURLException {
        AttachmentDto file = attachmentService.getFile(id);
        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(file.getAttachment().getContentType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\"" + file.getAttachment().getName())
                .body(file.getResource());
    }

    @PutMapping(value = "/{id}",consumes =  {"multipart/form-data"})
    public Long editFile(@PathVariable Long id, @RequestParam(value = "file") MultipartFile file) throws IOException {
        return attachmentService.editAttachment(id, file);
    }


    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteAttachment(@PathVariable Long id ){
        ApiResponse<?> apiResponse = attachmentService.deleteAttachment(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }
}