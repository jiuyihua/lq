package com.trade.lq.dao;

import com.trade.lq.entity.TtUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * describle :
 * author : huh
 * 2020/8/18 0018
 * 下午 3:57
 */
@Repository
public interface TtUserMapper {
    List<TtUser> GetTtUserList();

    boolean addTtUser(TtUser user);

    TtUser findUser(Integer id);

    boolean updateTtUser(TtUser ttUser);

    boolean delTtUser(TtUser ttUser);
}
