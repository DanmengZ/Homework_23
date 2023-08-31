package com.sys.service;

import com.sys.mapper.UserMapper;
import com.sys.model.User;
import com.sys.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service
 */
@Service
public class UserService {
    private UserMapper userMapper;//userMapper
    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    public UserService() {
    }

    /**
     * 新增用户
     * @param userVO
     */
    public int add(UserVO userVO){
        return userMapper.add(userVO);
    }

    /**
     * 删除用户
     * @param userId
     */
    public void delete(int userId){
        userMapper.delete(userId);
    }

    /**
     * 修改用户
     * @param userVO
     */
    public void modify(UserVO userVO){
        userMapper.modify(userVO);
    }

    /**
     * 查询用户
     * @param userVO
     * @return
     */
    public List<User> query(UserVO userVO){
        return userMapper.query(userVO);
    }
}
