package org.tubetrue01.testprovider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tubetrue01.pojo.User;
import org.tubetrue01.testprovider.mapper.UserMapper;
import org.tubetrue01.testprovider.service.UserService;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User : Pengfei Zhang
 * Mail : Tubetrue01@gmail.com
 * Date : 2020/2/10
 * Time : 6:52 下午
 * Description :
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return this.userMapper.selectAll();
    }

    @Override
    public int save(User user) {
       return  this.userMapper.insert(user);
    }
}
