package com.wenbingyin.eurekaclient.controller;

import com.wenbingyin.eurekaclient.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index() {
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/hello，host：" + instance.getHost() + "，server id：" + instance.getServiceId());
        return "Hello World";
    }

    @RequestMapping(value = "hello1", method = RequestMethod.GET)
    public String hello(@RequestParam String name) {
        return "Hello" + name;
    }

    @RequestMapping(value = "hello2", method = RequestMethod.GET)
    public User hello(@RequestHeader String name, @RequestHeader Integer age) {
        return new User(name, age);
    }

    @RequestMapping(value = "hello3", method = RequestMethod.POST)
    public String hello(@RequestBody User user) {
        return "Hello" + user.getName() + "，" + user.getAge();
    }

}
