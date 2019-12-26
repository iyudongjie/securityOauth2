package com.haishangxian.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @GetMapping("/r3")
//    @PreAuthorize("hasAnyAuthority('SystemContent')")
    public String r1(){

//        String priciple = (String)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "访问资源r1";
    }
}
