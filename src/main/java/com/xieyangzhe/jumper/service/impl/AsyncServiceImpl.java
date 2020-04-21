package com.xieyangzhe.jumper.service.impl;

import com.xieyangzhe.jumper.dao.UrlDao;
import com.xieyangzhe.jumper.model.UrlModel;
import com.xieyangzhe.jumper.service.AsyncService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Yangzhe Xie
 * @date 21/4/20
 */
@Service
public class AsyncServiceImpl implements AsyncService {
    @Resource
    private UrlDao urlDao;

    @Async("asyncExecutor")
    @Override
    public void update(UrlModel urlModel) {
        System.out.println(Thread.currentThread().getName());
        urlDao.updateWhenClick(urlModel);
        System.out.println("task finished");
    }
}
