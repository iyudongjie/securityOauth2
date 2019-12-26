package com.haishangxian.security.distributed.uaa.service.impl;

import com.haishangxian.security.distributed.uaa.domain.TbPermission;
import com.haishangxian.security.distributed.uaa.mapper.TbPermissionMapper;
import com.haishangxian.security.distributed.uaa.service.TbPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TbPermissionServiceImpl implements TbPermissionService {

    @Resource
    private TbPermissionMapper tbPermissionMapper;
    @Override
    public List<TbPermission> selectByUserId(Long userId) {
        return tbPermissionMapper.selectByUserId(userId);
    }

}
