package com.trade.lq.service;

import com.jayway.jsonpath.internal.Utils;
import com.trade.lq.dao.TtUserMapper;
import com.trade.lq.entity.TtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * describle :
 * author : huh
 * 2020/8/18 0018
 * 下午 3:57
 */
@Service
public class TtUserService {

    @Autowired
    TtUserMapper ttUserMapper;

    public List<TtUser> getTtUserList(){
        return ttUserMapper.GetTtUserList();
    }

    public TtUser findUser(Integer id){
        TtUser ttUser = ttUserMapper.findUser(id);
        if (ttUser==null || Utils.isEmpty(ttUser.getName())){
            return ttUser;
        }
        return ttUser;
    }

    @Transactional
    public boolean addTtUser(TtUser user){
        TtUser queryUser = ttUserMapper.findUser(user.getId());
        if (queryUser==null||queryUser.equals("")){
             ttUserMapper.addTtUser(user);
            return true;
        } else {
            return false;
        }
    };

    public boolean updateTtUser(TtUser user) {
        if (ttUserMapper.updateTtUser(user)){
            return true;
        }
        return false;
    }

    public boolean delTtUser(TtUser ttUser){
        if (ttUserMapper.delTtUser(ttUser))
            return true;
        else return false;
    }
}
