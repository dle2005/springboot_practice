package com.example.study.controller;

import com.example.study.model.SearchParam;
import com.example.study.model.network.Header;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class GetController {

    @RequestMapping(method = RequestMethod.GET, path = "/getMethod")
    public String getRequest() {
        return "Hi getMethod";
    }

    @GetMapping("/getParameter")
    public String getParameter(@RequestParam String id, @RequestParam String password) {
        System.out.println("id: " + id);
        System.out.println("password: " + password);
        return id+password;
    }

    @GetMapping("/getMultiParameter")
    public SearchParam getParameter(SearchParam searchParam) {
        return searchParam;
    }

    @GetMapping("/header")
    public Header getHeader() {
//        return Header.builder().resultCode("OK").description("OK").build();
        return Header.OK();
    }
}
