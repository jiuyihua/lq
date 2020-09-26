package com.trade.lq.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
public class User implements UserDetails {
    private Integer id;
    private String userName;
    private String passWord;
    private String realName;
    private Boolean enable;
    private Boolean locked;
    private List<Role> roles;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", realName='" + realName + '\'' +
                '}';
    }

    //获取当前用户的角色信息
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }

    //获取当前用户的密码
    @Override
    public String getPassword() {
        return passWord;
    }

    //获取当前的用户名
    @Override
    public String getUsername() {
        return userName;
    }

    //获取当前账户是否未过期
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //获取当前账户是否未锁定
    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }
    //当前账户密码是否未过期
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //获取当前账户是否可用
    @Override
    public boolean isEnabled() {
        return true;
    }
}
