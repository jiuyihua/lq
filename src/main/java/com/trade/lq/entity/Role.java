package com.trade.lq.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

/**
 * describle :
 * author : huh
 * 2020/8/30 0030
 * 下午 2:53
 */
@Data
public class Role implements Serializable {
    private Integer id;
    private String name;
    private String nameZh;
    /**
     * 角色对应权限集合
     */
    private Set<Permissions> permissions;
}
