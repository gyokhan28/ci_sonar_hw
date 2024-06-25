package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="basicClient", url = "https://authenticationtest.com", configuration = BasicAuthFeignConfig.class)
public interface BasicAuthFeignClient {

    @GetMapping("/login/?mode=simpleFormAuth")
    String basicAuth(@RequestParam("email") String email, @RequestParam("password") String password);
}
