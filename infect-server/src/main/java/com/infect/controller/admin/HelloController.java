package com.infect.controller.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Hello world")
@RestController
@RequestMapping("/admin/helloWorld")
public class HelloController {

    @GetMapping()
    @ApiOperation("hello world")
    public String helloQWorld(){
        return "Hello world";
    }

}
