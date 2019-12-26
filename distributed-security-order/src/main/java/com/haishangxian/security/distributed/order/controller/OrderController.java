package com.haishangxian.security.distributed.order.controller;

import com.haishangxian.security.distributed.order.model.TbUser;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @GetMapping("/r1")
//    @PreAuthorize("hasAnyAuthority('aa')")
    public String r1(){

        TbUser priciple = (TbUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "访问资源r1";
    }
}
