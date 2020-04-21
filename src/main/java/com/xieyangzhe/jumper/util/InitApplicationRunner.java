package com.xieyangzhe.jumper.util;

import com.xieyangzhe.jumper.service.UrlService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Yangzhe Xie
 * @date 21/4/20
 */
@Component
@Order(value = 1)
public class InitApplicationRunner implements ApplicationRunner {

    @Resource
    private UrlService urlService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        urlService.loadId();
    }
}
