package it.city.crmsystem.payload;

import it.city.crmsystem.entity.Attachment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.core.io.Resource;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AttachmentDto {
    private Long id;
    private Resource resource;
    private Attachment attachment;

}
