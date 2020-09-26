package com.trade.lq.service;

import com.trade.lq.entity.Resource;
import com.trade.lq.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * describle :
 * author : huh
 * 2020/9/8 0008
 * 下午 2:18
 */
@Repository
public interface ResourceService {
    public List<Resource> getAllResource();
    List<Role> getRoleByResource(Integer resourceId);
}
