package com.xieyangzhe.jumper.controller;

import com.google.gson.Gson;
import com.xieyangzhe.jumper.service.UrlService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Yangzhe Xie
 * @date 21/4/20
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @Resource
    private UrlService urlService;

    @PostMapping("/create")
    public String createUrl(String url, Boolean hasPassword, String password) {
        if (!url.startsWith("http")) {
            url = "http://" + url;
        }
        Map<String, String> result = new HashMap<>();
        String encoded = "";
        try {
            if (hasPassword != null && hasPassword && password != null && !password.isEmpty()) {
                if (password.length() > 16) {
                    result.put("code", "-1");
                    result.put("message", "密码长度需要小于16位");
                    return new Gson().toJson(result);
                }
                encoded = urlService.createUrl(url, hasPassword, password);
            } else {
                encoded = urlService.createUrl(url);
            }
        } catch (Exception e) {
            result.put("code", "-1");
            result.put("message", "未知错误");
            return new Gson().toJson(result);
        }
        result.put("code", "1");
        result.put("message", "生成的URL：" + encoded);
        return new Gson().toJson(result);
    }
}
