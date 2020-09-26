package com.trade.lq.entity;

import lombok.Data;

/**
 * describle :
 * author : huh
 * 2020/9/13 0013
 * 下午 6:34
 */

@Data
public class Permissions {
    private String id;
    private String permissionsName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermissionsName() {
        return permissionsName;
    }

    public void setPermissionsName(String permissionsName) {
        this.permissionsName = permissionsName;
    }

    public Permissions(String id, String permissionsName) {
        this.id = id;
        this.permissionsName = permissionsName;
    }
}
