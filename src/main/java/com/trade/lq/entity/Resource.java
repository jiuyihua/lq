package com.trade.lq.entity;

import lombok.Data;

import java.util.List;

/**
 * describle :
 * author : huh
 * 2020/8/30 0030
 * 下午 5:03
 */
@Data
public class Resource {
    private Integer id;
    private String pattern;
    private List<Role> roles;
}
