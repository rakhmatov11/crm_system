package it.city.crmsystem.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private T body;
    private Object object;
    private String message;
    private boolean success;


    public ApiResponse(String message, boolean success){
        this.message = message;
        this.success = success;
    }
    public ApiResponse(T body, String message, boolean success){
        this.message = message;
        this.success = success;
        this.body = body;
    }

}
