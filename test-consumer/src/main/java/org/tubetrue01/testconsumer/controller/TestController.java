package org.tubetrue01.testconsumer.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.tubetrue01.pojo.User;
import org.tubetrue01.testconsumer.remote.RemoteTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User : Pengfei Zhang
 * Mail : Tubetrue01@gmail.com
 * Date : 2020/3/13
 * Time : 10:45 上午
 * Description :
 */
@Log4j2
@RestController
@RequestMapping("/user")
public class TestController {

    @Autowired
    private RemoteTest remoteTest;
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/clients")
    public List<String> clients() {
        return this.discoveryClient.getServices();
    }

    @GetMapping("/info")
    public List<User> findAll() {

        List<User> result = new ArrayList<>();
        try {

            log.info("-==调用远程服务！🎣==-");
            result = this.remoteTest.findAll();
        } catch (Exception e) {
            log.error("-==调用远程服务出现错误！==-", e);
        }

        return result;
    }

    @PostMapping("/save")
    public void save(@RequestBody User user) {
        log.info("-==调用远程服务保存用户信息![{}]==-", user.getUsername());
        this.remoteTest.save(user);
    }

}
