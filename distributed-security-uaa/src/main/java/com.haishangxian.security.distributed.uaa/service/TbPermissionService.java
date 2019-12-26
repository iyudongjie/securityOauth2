package com.haishangxian.security.distributed.uaa.service;

import com.haishangxian.security.distributed.uaa.domain.TbPermission;

import java.util.List;

public interface TbPermissionService{

    default List<TbPermission> selectByUserId(Long userId) {
        return null;
    }



}
