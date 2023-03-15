package org.example.auth.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.example.auth.mapper.SysRoleMapper;
import org.example.model.system.SysRole;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/role")
public class RoleController {
    private SysRoleMapper mapper;

    public RoleController(SysRoleMapper mapper) {
        this.mapper = mapper;
    }

    @GetMapping("/{id}")
    public SysRole findAll(@PathVariable Integer id){
        LambdaQueryWrapper<SysRole> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysRole::getId,id);
        return  mapper.selectOne(lambdaQueryWrapper);
    }


}
