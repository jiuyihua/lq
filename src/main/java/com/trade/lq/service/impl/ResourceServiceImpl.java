package com.trade.lq.service.impl;

import com.trade.lq.dao.ResourceMapper;
import com.trade.lq.entity.Resource;
import com.trade.lq.entity.Role;
import com.trade.lq.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * describle :
 * author : huh
 * 2020/9/8 0008
 * 下午 2:20
 */
@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    ResourceMapper resourceMapper;

    @Override
    public List<Resource> getAllResource() {
        return resourceMapper.getAllResource();
    }

    @Secured("ROLE_ADMIN")//此处为方法权限安全保护
    @Override
    public List<Role> getRoleByResource(Integer resourceId){
        return resourceMapper.getRoleByResource(resourceId);
    };
}
