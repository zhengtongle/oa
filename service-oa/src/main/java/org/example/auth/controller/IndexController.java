package org.example.auth.controller;

import com.baomidou.mybatisplus.extension.api.R;
import io.swagger.annotations.Api;
import org.example.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Api("后台登录管理")
@RestController
@RequestMapping("/admin/system/index")
public class IndexController {

    // login
    @PostMapping("/login")
    public Result<Map<String,Object>> login() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("token", "Admin-Token");
        return Result.ok(map);
    }

    // info
    @GetMapping("/info")
    public Result<Map<String,Object>> info(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("roles","[admin]");
        map.put("name","admin");
//        map.put("avater","");
        return Result.ok(map);
    }
    // logout
    @PostMapping("/logout")
    public Result<Object> logout(){
        return Result.ok();
    }
}
