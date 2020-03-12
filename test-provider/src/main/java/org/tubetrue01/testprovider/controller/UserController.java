package org.tubetrue01.testprovider.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tubetrue01.pojo.User;
import org.tubetrue01.testprovider.configuration.ConfigConfiguration;
import org.tubetrue01.testprovider.configuration.SecretConfiguration;
import org.tubetrue01.testprovider.service.UserService;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User : Pengfei Zhang
 * Mail : Tubetrue01@gmail.com
 * Date : 2020/2/10
 * Time : 6:47 下午
 * Description :
 */
@Log4j2
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecretConfiguration configuration;

    @Autowired
    private ConfigConfiguration configConfiguration;

    @GetMapping("/secret")
    public String secret() {
        log.info("-==访问Secret信息==-");
        return configuration.getUsername() + " : " + configuration.getPassword();
    }

    @GetMapping("/config")
    public String config() {
        log.info("-==访问config信息==-");
        return configConfiguration.getUsername() + " : " + configConfiguration.getPassword();
    }

    @GetMapping("/info")
    public List<User> findAll() {

        log.info("-==获取用户信息成功！==-");
        return this.userService.findAll();
    }

    @PostMapping("/save")
    public void save(@RequestBody User user) {
        var username = user.getUsername();
        var isSuccess = this.userService.save(user);
        if (isSuccess > 0) {
            log.info("-==保存用户信息[{}]成功!==-", username);
        } else {
            log.warn("-==保存用户信息[{}]失败！==-", username);
        }

    }
}
