package org.tubetrue01.testconsumer.remote.fallback;

import org.springframework.stereotype.Component;
import org.tubetrue01.pojo.User;
import org.tubetrue01.testconsumer.remote.RemoteTest;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User : Pengfei Zhang
 * Mail : Tubetrue01@gmail.com
 * Date : 2020/3/13
 * Time : 1:11 下午
 * Description :
 */
@Component
public class RemoteTestFallback implements RemoteTest {
    @Override
    public List<User> findAll() {
        return List.of(new User(404, "fallback", "error"));
    }

    @Override
    public void save(User user) {

    }
}
