package com.haishangxian.security.distributed.uaa.service.impl;

import com.haishangxian.security.distributed.uaa.domain.TbUser;
import com.haishangxian.security.distributed.uaa.mapper.TbUserMapper;
import com.haishangxian.security.distributed.uaa.service.TbUserService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

@Service
public class TbUserServiceImpl implements TbUserService {

    @Resource
    private TbUserMapper tbUserMapper;

    @Override
    public TbUser getByUserName(String username) {
        Example example = new Example(TbUser.class);
        example.createCriteria().andEqualTo("username",username);
        return tbUserMapper.selectOneByExample(example);
    }
}
