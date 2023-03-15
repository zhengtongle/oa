package org.example.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.model.system.SysRole;
import org.springframework.stereotype.Repository;

@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {
}
