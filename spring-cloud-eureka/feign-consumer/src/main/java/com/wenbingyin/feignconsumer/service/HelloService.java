package com.wenbingyin.feignconsumer.service;

import com.wenbingyin.feignconsumer.dto.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("EUREKA-CLIENT")
public interface HelloService {

    @RequestMapping("/hello")
    String hello();

    @RequestMapping(value = "hello1", method = RequestMethod.GET)
    String hello(@RequestParam(value = "name") String name);

    @RequestMapping(value = "hello2", method = RequestMethod.GET)
    User hello(@RequestHeader(value = "name") String name, @RequestHeader(value = "age") Integer age);

    @RequestMapping(value = "hello3", method = RequestMethod.POST)
    String hello(@RequestBody User user);
}
