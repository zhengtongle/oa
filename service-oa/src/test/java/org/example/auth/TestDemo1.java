package org.example.auth;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.example.auth.mapper.SysRoleMapper;
import org.example.model.system.SysRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestDemo1 {

    private SysRoleMapper mapper;

    private RoleController controller;


    @Autowired
    public TestDemo1(SysRoleMapper mapper, RoleController controller) {
        this.mapper = mapper;
        this.controller = controller;
    }

    @Test
    public void getAll(){
        LambdaQueryWrapper<SysRole> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapper.eq(SysRole::getRoleCode,1);
//        List<SysRole> sysRole = mapper.selectList(queryWrapper);
        SysRole sysRole = mapper.selectOne(queryWrapper);
        System.out.println(sysRole);
    }
    @Test
    public void testController(){
        System.out.println(controller);
    }

    @Test
    public void testInsert(){
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("角色管理员");
        sysRole.setRoleCode("role");
        sysRole.setDescription("角色管理员");

        int result = mapper.insert(sysRole);
        System.out.println(result); //影响的行数
        System.out.println(sysRole); //id自动回填
    }

    @Test
    public void testUpdateById(){
        SysRole sysRole = new SysRole();
        sysRole.setId(1L);
        sysRole.setRoleName("角色管理员1");

        int result = mapper.updateById(sysRole);
        System.out.println(result);

    }

    /**
     * application-dev.yml 加入配置
     * 此为默认值，如果你的默认值和mp默认的一样，则不需要该配置
     * mybatis-plus:
     *   global-config:
     *     db-config:
     *       logic-delete-value: 1
     *       logic-not-delete-value: 0
     */
    @Test
    public void testDeleteById(){
        int result = mapper.deleteById(2L);
        System.out.println(result);
    }

}
