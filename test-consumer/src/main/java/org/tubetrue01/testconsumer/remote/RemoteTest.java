package org.tubetrue01.testconsumer.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.tubetrue01.pojo.User;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User : Pengfei Zhang
 * Mail : Tubetrue01@gmail.com
 * Date : 2020/3/13
 * Time : 1:06 下午
 * Description :
 */
@Primary
@FeignClient(name = "test-provider", url = "http://test-provider.zpf.svc.cluster.local:8080", path = "/provider/user")
public interface RemoteTest {

    @GetMapping("/info")
    List<User> findAll();

    @PostMapping("/save")
    void save(@RequestBody User user);
}
