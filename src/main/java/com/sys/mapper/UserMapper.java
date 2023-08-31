package com.sys.mapper;
import com.sys.model.User;
import com.sys.vo.UserVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    //新增用户
    int add(UserVO userVO);
    //删除用户
    void delete(int userId);
    //修改
    void modify(UserVO userVO);
    //查询
    List<User> query(UserVO userVO);
}
