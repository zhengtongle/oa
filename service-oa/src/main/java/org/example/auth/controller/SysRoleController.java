package org.example.auth.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.auth.service.SysRoleService;
import org.example.model.system.SysRole;
import org.example.result.Result;
import org.example.vo.system.SysRoleQueryVo;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@Api(tags = "角色管理接口")
@RestController
@RequestMapping("/admin/system/role")
public class SysRoleController {

    private SysRoleService sysRoleService;

    public SysRoleController(SysRoleService sysRoleService) {
        this.sysRoleService = sysRoleService;
    }

    @ApiOperation("查询所有用户")
    @GetMapping("/findAll")
    public Result<List<SysRole>> findAll() {
        return Result.ok(sysRoleService.list());
    }

    @ApiOperation("条件分页查询")
    @GetMapping("{page}/{limit}")
    public Result<Page<SysRole>> page(@PathVariable("page") Long page, @PathVariable("limit") Long limit, SysRoleQueryVo sysRoleQueryVo) {
        // 创建Page对象 传递分页参数
        Page<SysRole> pageParam = new Page<>(page, limit);
        // 创建查询条件
        LambdaQueryWrapper<SysRole> queryWrapper = new LambdaQueryWrapper<>();
        String roleName = sysRoleQueryVo.getRoleName();
        if (!StringUtils.isEmpty(roleName)) {
            queryWrapper.like(SysRole::getRoleName, roleName);
        }
        // 调用实现
        return Result.ok(sysRoleService.page(pageParam, queryWrapper));
    }
}
