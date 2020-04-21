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
    
    @Test
    void contextLoads() {
        UrlModel model = new UrlModel();
        model.setUrl("123123123123");
        model.setEncoded("sadas");
        model.setHasPassword(true);
        model.setPassword("asdad");

        urlDao.insertUrl(model);
    }

}
