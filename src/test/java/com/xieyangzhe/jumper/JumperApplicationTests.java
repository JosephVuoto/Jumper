package com.xieyangzhe.jumper;

import com.xieyangzhe.jumper.dao.UrlDao;
import com.xieyangzhe.jumper.model.UrlModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class JumperApplicationTests {

    @Resource
    private UrlDao urlDao;

}
