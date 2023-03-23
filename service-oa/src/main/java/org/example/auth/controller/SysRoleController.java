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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "角色管理接口")
@RestController
@RequestMapping("/admin/system/role")
public class SysRoleController {

    private final SysRoleService sysRoleService;

    public SysRoleController(SysRoleService sysRoleService) {
        this.sysRoleService = sysRoleService;
    }

    @ApiOperation("查询所有角色")
    @GetMapping("/findAll")
    public Result<List<SysRole>> findAll() {
        return Result.ok(sysRoleService.list());
    }

    @ApiOperation("条件分页查询")
    @GetMapping("/{page}/{limit}")
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

    // 添加角色
    @ApiOperation("添加角色")
    @PostMapping()
    public Result<Object> save(@RequestBody SysRole sysRole) {
        boolean is_success = sysRoleService.save(sysRole);
        if (is_success) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    // 根据Id查询角色
    @ApiOperation("根据Id查询角色")
    @GetMapping("/{id}")
    public Result<SysRole> get(@PathVariable Long id) {
        SysRole sysRole = sysRoleService.getById(id);
        return Result.ok(sysRole);
    }

    @ApiOperation("根据Id更新角色")
    @PutMapping()
    public Result<Object> update(@RequestBody SysRole sysRole) {
        boolean is_success = sysRoleService.updateById(sysRole);
        if (is_success) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    @ApiOperation("根据Id删除")
    @DeleteMapping("/{id}")
    public Result<Object> delete(@PathVariable Long id) {
        boolean is_success = sysRoleService.removeById(id);
        if (is_success) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    @ApiOperation("批量删除")
    @DeleteMapping()
    public Result<Object> delete(@RequestBody List<Long> ids) {
        boolean is_success = sysRoleService.removeByIds(ids);
        if (is_success) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }



}
