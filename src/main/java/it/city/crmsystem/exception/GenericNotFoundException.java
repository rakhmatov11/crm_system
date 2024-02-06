package it.city.crmsystem.exception;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GenericNotFoundException extends RuntimeException {
    private String message;
    private Integer statusCode;
}
