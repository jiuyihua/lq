package com.trade.lq.dao;

import com.trade.lq.entity.Role;
import com.trade.lq.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author:0xOO
 * @Date: 2018/9/26 0026
 * @Time: 15:20
 */
@Repository
public interface UserMapper {

    User Sel(int id);

    public User getUserByUserName(String userName);

    public List<Role> getUserRolesByUid(Integer uid);

    boolean regUser(Map map);
}
