package com.haishangxian.security.distributed.uaa.mapper;

import com.haishangxian.security.distributed.uaa.domain.TbPermission;
import com.haishangxian.security.distributed.uaa.tk.mybatis.mapper.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbPermissionMapper extends MyMapper<TbPermission> {
    List<TbPermission> selectByUserId(@Param("userId") Long userId);

}