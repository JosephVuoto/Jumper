package com.xieyangzhe.jumper.controller;

import com.xieyangzhe.jumper.model.UrlModel;
import com.xieyangzhe.jumper.service.UrlService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author Yangzhe Xie
 * @date 20/4/20
 */
@Controller
public class UrlController {
    @Resource
    private UrlService urlService;
    @Value("${server.host}")
    private String host;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/{encoded}")
    public String jump(Model model, @PathVariable String encoded) {
        UrlModel urlModel = urlService.getUrlModel(encoded);
        if (urlModel == null) {
            return "redirect:" + host;
        }
        if (urlModel.getHasPassword()) {
            model.addAttribute("encoded", encoded);
            return "pwd";
        } else {
            return "redirect:" + urlModel.getUrl();
        }
    }

    @PostMapping("/validate")
    public String validate(String encoded, String password) {
        UrlModel urlModel = urlService.getUrlModel(encoded);
        try {
            if (urlModel.getPassword().equals(password)) {
                return "redirect:" + urlModel.getUrl();
            } else {
                return "redirect:" + host + "/" + encoded + "?message=%e5%af%86%e7%a0%81%e9%94%99%e8%af%af";
            }
        } catch (Exception e) {
            return "redirect:" + host + "/" + encoded + "?message=%e6%9c%aa%e7%9f%a5%e9%94%99%e8%af%af";
        }
    }
}
