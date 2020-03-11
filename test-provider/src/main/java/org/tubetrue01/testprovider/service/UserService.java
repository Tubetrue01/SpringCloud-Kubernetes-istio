package org.tubetrue01.testprovider.service;

import org.tubetrue01.pojo.User;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User : Pengfei Zhang
 * Mail : Tubetrue01@gmail.com
 * Date : 2020/2/10
 * Time : 6:51 下午
 * Description :
 */
public interface UserService {
    List<User> findAll();

    int save(User user);
}
