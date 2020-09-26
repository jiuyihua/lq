package com.trade.lq.dao;

import com.trade.lq.entity.Resource;
import com.trade.lq.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * describle :
 * author : huh
 * 2020/8/30 0030
 * 下午 5:39
 */
@Repository
public interface ResourceMapper {

    List<Resource> getAllResource();

    List<Role> getRoleByResource(Integer resourceId);
}
