package com.haishangxian.security.distributed.uaa.service;

import com.haishangxian.security.distributed.uaa.domain.TbUser;

public interface TbUserService{

    TbUser getByUserName(String username);


}
