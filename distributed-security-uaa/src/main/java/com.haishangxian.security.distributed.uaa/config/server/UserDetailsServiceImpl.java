package com.haishangxian.security.distributed.uaa.config.server;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.haishangxian.security.distributed.uaa.domain.TbPermission;
import com.haishangxian.security.distributed.uaa.domain.TbUser;
import com.haishangxian.security.distributed.uaa.service.TbPermissionService;
import com.haishangxian.security.distributed.uaa.service.TbUserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: yudongjie
 * @CreateDate: 2019-12-25 09:32
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private TbUserService userService;
    @Resource
    private TbPermissionService permissionService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       TbUser tbUser =  userService.getByUserName(username);
        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
        if (tbUser != null) {
            // 获取用户授权
            List<TbPermission> tbPermissions = permissionService.selectByUserId(tbUser.getId());
            // 声明用户授权
            for(TbPermission permission:tbPermissions){
                if (permission != null && permission.getEnname() != null) {
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getEnname());
                    grantedAuthorities.add(grantedAuthority);
                }
            }
        }

        String json = JSON.toJSONString(tbUser);
        UserDetails userDetails = User.withUsername(json).password(tbUser.getPassword()).authorities(grantedAuthorities).build();
        return userDetails;
    }
}
