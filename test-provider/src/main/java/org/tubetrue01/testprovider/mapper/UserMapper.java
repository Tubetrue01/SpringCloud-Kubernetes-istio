package org.tubetrue01.testprovider.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.tubetrue01.pojo.User;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User : Pengfei Zhang
 * Mail : Tubetrue01@gmail.com
 * Date : 2020/2/10
 * Time : 6:52 下午
 * Description :
 */
@Mapper
public interface UserMapper {
    List<User> selectAll();

    int insert(User user);
}
