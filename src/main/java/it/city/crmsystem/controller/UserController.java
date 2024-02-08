package it.city.crmsystem.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/info")
    public HttpEntity<String> getInfo() {
        String message = "User information endpoint";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
