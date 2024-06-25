package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicAuthController {
    private final BasicAuthFeignClient basicAuthFeignClient;

    @Autowired
    public BasicAuthController(BasicAuthFeignClient basicAuthFeignClient) {
        this.basicAuthFeignClient = basicAuthFeignClient;
    }
    @GetMapping("/basicAuth")
    public String basicAuth(@RequestParam("email") String email, @RequestParam("password") String password){
        String basicAuth = basicAuthFeignClient.basicAuth(email, password);
        return basicAuth;
    }
}
